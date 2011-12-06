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
	 * no suffix is needed.
	 * Normally we would like the result to be saved directly 
	 * in a jiac project - source folder
	 */
	@Override
	protected String getDirectorySuffix() {
		return "";
	}

	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		
		JiacBeansExportWrapper wrapper = (JiacBeansExportWrapper) this.wrapper;
//		wrapper.setBaseDirectory(baseDirectory);
		AgentBeanGenerator generator = new AgentBeanGenerator();
		for (AgentBean bean : wrapper.getBeans()) {
			String packageName = bean.getPackageName();
			packageName.replaceAll(".", "/");
			File folder = new File(baseDirectory, packageName);
			if (! folder.exists()) {
				folder.mkdirs();
			}
			String fileName = bean.getName();
			File f = new File(folder,fileName+".java");
			String content = generator.generate(bean);
			if (! f.exists()) {
				FileWriter writer = new FileWriter(f);
				writer.write(content);
				writer.flush();
			} else {
				//code exists, initialize JMerger
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
					String mergedContents = jMerger.getTargetCompilationUnit().getContents();
					// overwrite the target with the merged contents
					FileWriter writer = new FileWriter(f);
					writer.write(mergedContents);
					writer.flush();
				} catch (Exception e) {
					//if something goes wrong overwrite the file
					FileWriter writer = new FileWriter(f);
					writer.write(content);
					writer.flush();
				}
			}
		}
		return true;
	}

	
}
