package de.dailab.vsdt.trafo.jiacbeans.export;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiacbeans.AgentBean;

import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;

import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.jiacbeans.export.generated.AgentBeanGenerator;

/**
 * Result saver class for the VSDT BPMN --> JIAC Agent Beans transformation.
 * This will create and merge the agent beans files and create a Spring 
 * configuration file.
 * 
 * @author kuester
 */
public class JiacBeansResultSaver extends MappingResultSaver {
	
	/**
	 * Normally we would like the result to be saved directly 
	 * in a jiac project - source folder
	 */
	@Override
	protected String getDirectorySuffix() {
		return "agentbeans";
	}

	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		
		JiacBeansExportWrapper wrapper = (JiacBeansExportWrapper) this.wrapper;
		AgentBeanGenerator generator = new AgentBeanGenerator();

		for (AgentBean bean : wrapper.getBeans()) {
			String packageName = bean.getPackageName().replace(".", "/");
			File folder = new File(baseDirectory, packageName);
			if (! folder.exists()) {
				folder.mkdirs();
			}
			
			// generate code
			String content = generator.generate(bean);
			
			File f = new File(folder, bean.getName() + ".java");
			if (f.exists()) {
				//code exists -> initialize JMerger
				ASTFacadeHelper astFacadeHelper = new ASTFacadeHelper();
				JControlModel model = new JControlModel(); 
				model.setConvertToStandardBraceStyle(true);
				model.setLeadingTabReplacement("\t");
				model.initialize(astFacadeHelper, getClass().getResource("mergerules.xml").toString());
				JMerger jMerger = new JMerger(model); 
				try {
					//source = new generated code from JET
					//target = existing code
					jMerger.setSourceCompilationUnit(jMerger.createCompilationUnitForContents(content));
					jMerger.setTargetCompilationUnit(jMerger.createCompilationUnitForInputStream(new FileInputStream(f))); //target=last generated code
					jMerger.merge(); 
					// extract merged contents
					content = jMerger.getTargetCompilationUnit().getContents();
				} catch (Exception e) {
					TrafoLog.warn("Could not merge with existing file: " + e.getMessage());
					e.printStackTrace();
				}
			}
			// overwrite the target with the merged contents
			try (FileWriter writer = new FileWriter(f)) {
				writer.write(content);
			}
		}
		
		createConfigFile(baseDirectory, wrapper);
		
		return true;
	}
	
	/**
	 * Create Spring configuration file for the generated agent roles and beans.
	 * For now, just assemble the string manually; might change this to using
	 * either an XML library or another JET template.
	 * 
	 * @param baseDir	base directory where to save the configuration file
	 * @param wrapper	the export wrapper holding the result
	 */
	private void createConfigFile(File baseDir, JiacBeansExportWrapper wrapper) {

		// create mapping of roles to beans
		Map<String, List<AgentBean>> rolesMap = new HashMap<>();
		for (AgentBean bean : wrapper.getBeans()) {
			String role = wrapper.getPool(bean).getParticipant().getName();
			if (! rolesMap.containsKey(role)) {
				rolesMap.put(role, new ArrayList<AgentBean>());
			}
			rolesMap.get(role).add(bean);
		}
		
		// create header configuration string
		final String NL = System.getProperty("line.separator");
		StringBuffer buffer = new StringBuffer();
		buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(NL);
		buffer.append("<!DOCTYPE beans PUBLIC \"-//SPRING//DTD BEAN//EN\" \"http://www.springframework.org/dtd/spring-beans.dtd\">").append(NL);
		buffer.append("<beans>").append(NL);
		buffer.append("\t<import resource=\"classpath:de/dailab/jiactng/agentcore/conf/AgentNode.xml\" />").append(NL);
		buffer.append("\t<import resource=\"classpath:de/dailab/jiactng/agentcore/conf/Agent.xml\" />").append(NL);
		buffer.append(NL);
		
		// create node configuration string
		String nodeName = wrapper.getSourceModel().getName();
		buffer.append("\t<bean name=\"" + nodeName + "\" parent=\"NodeWithJMX\">").append(NL);
		buffer.append("\t\t<property name=\"agents\">").append(NL);
		buffer.append("\t\t\t<list>").append(NL);
		for (String role : rolesMap.keySet()) {
			buffer.append("\t\t\t\t<ref bean=\"" + role + "Agent\" />").append(NL);
		}
		buffer.append("\t\t\t</list>").append(NL);
		buffer.append("\t\t</property>").append(NL);
		buffer.append("\t</bean>").append(NL);
		buffer.append(NL);
		
		// create agent configuration strings
		for (String role : rolesMap.keySet()) {
			buffer.append("\t<bean name=\"" + role + "Agent\" singleton=\"false\" parent=\"NonBlockingAgent\">").append(NL);
			buffer.append("\t\t<property name=\"agentBeans\">").append(NL);
			buffer.append("\t\t\t<list>").append(NL);
			for (AgentBean bean : rolesMap.get(role)) {
				buffer.append("\t\t\t\t<ref bean=\"" + bean.getName() + "Bean\" />").append(NL);
			}
			buffer.append("\t\t\t</list>").append(NL);
			buffer.append("\t\t</property>").append(NL);
			buffer.append("\t</bean>").append(NL);
			buffer.append(NL);
			
			// create bean configuration strings
			for (AgentBean bean : rolesMap.get(role)) {
				String clazz = bean.getPackageName() + "." + bean.getName();
				buffer.append("\t<bean name=\"" + bean.getName() + "Bean\" singleton=\"false\" "
						+ "class=\"" + clazz + "\">").append(NL); 
				buffer.append("\t\t<property name=\"executionInterval\" value=\"1000\" />").append(NL);
				buffer.append("\t</bean>").append(NL);
				buffer.append(NL);
			}
		}

		// write footer
		buffer.append("</beans>").append(NL);

		// create and write file
		File f = new File(baseDir, "nodeconfig.xml");
		try (FileWriter writer = new FileWriter(f)) {
			writer.write(buffer.toString());
		} catch (IOException e) {
			// if this fails, it is not an error --> do not re-throw
			TrafoLog.warn("Could not create configuration file: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
