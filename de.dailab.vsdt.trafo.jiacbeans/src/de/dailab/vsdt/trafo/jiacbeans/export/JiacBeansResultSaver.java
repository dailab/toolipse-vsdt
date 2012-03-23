package de.dailab.vsdt.trafo.jiacbeans.export;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import jiacbeans.AgentBean;

import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;

import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.jiacbeans.export.generated.AgentBeanGenerator;

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
			String packageName = bean.getPackageName();
			packageName.replaceAll(".", "/");
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
					e.printStackTrace();
//					return false;
				}
			}
			// overwrite the target with the merged contents
			FileWriter writer = new FileWriter(f);
			writer.write(content);
			writer.close();
		}
		return true;
	}

	
}
