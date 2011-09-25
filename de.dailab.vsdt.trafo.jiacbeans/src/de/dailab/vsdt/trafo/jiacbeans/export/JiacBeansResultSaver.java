package de.dailab.vsdt.trafo.jiacbeans.export;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;


import jiacbeans.AgentBean;

import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTJCompilationUnit;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;

import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.jiacbeans.export.generated.JavaCodeGenerator;

public class JiacBeansResultSaver extends MappingResultSaver {

	@Override
	protected String getDirectorySuffix() {
		return "";
	}

	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		JControlModel model = new JControlModel(); 
		ASTFacadeHelper astFacadeHelper = new ASTFacadeHelper();
		model.initialize(astFacadeHelper, getClass().getResource("mergerules.xml").toString()); 
		JMerger jMerger = new JMerger(model); 
		JiacBeansExportWrapper wrapper = (JiacBeansExportWrapper) this.wrapper;
		wrapper.setBaseDirectory(baseDirectory);
		JavaCodeGenerator generator = new JavaCodeGenerator();
		for(AgentBean bean : wrapper.getBeans()){
			String packageName = bean.getPackageName();
			packageName.replaceAll(".", "/");
			File folder = new File(baseDirectory,packageName);
			if(!folder.exists())folder.mkdirs();
			String fileName = bean.getName();
			File f = new File(folder,fileName+".java");
			String content = generator.generate(bean);
			if(!f.exists()){
				FileWriter writer = new FileWriter(f);
				writer.write(content);
				writer.flush();
			}else{
				//source=new generated code 
				// set source
				try{
					jMerger.setSourceCompilationUnit(jMerger.createCompilationUnitForContents(content));
					jMerger.setTargetCompilationUnit(jMerger.createCompilationUnitForInputStream(new FileInputStream(f))); //target=last generated code
					jMerger.merge(); 
					// extract merged contents
					String mergedContents = jMerger.getTargetCompilationUnit().getContents();
					// overwrite the target with the merged contents
					FileWriter writer = new FileWriter(f);
					writer.write(mergedContents);
					writer.flush();
				}catch(WrappedException e){
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
