package de.dailab.vsdt.trafo.jiacbeans.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import jiacbeans.AgentBean;

import org.eclipse.emf.codegen.merge.java.JControlModel;
import org.eclipse.emf.codegen.merge.java.JMerger;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;

import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.jiacbeans.export.generated.JavaCodeGenerator;

public class JiacBeansResultSaver extends MappingResultSaver {

	@Override
	protected String getDirectorySuffix() {
		return "jiacbeans";
	}

	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		JControlModel model = new JControlModel(); 
		ASTFacadeHelper astFacadeHelper = new ASTFacadeHelper();
		model.initialize(astFacadeHelper, "mergerules.xml"); 
		JMerger jMerger = new JMerger(model); 
		JiacBeansExportWrapper wrapper = (JiacBeansExportWrapper) this.wrapper;
		wrapper.setBaseDirectory(baseDirectory);
		JavaCodeGenerator generator = new JavaCodeGenerator();
		for(AgentBean bean : wrapper.getBeans()){
			String packageName = bean.getPackageName();
			System.out.println(packageName);
//			String[] paths = packageName.split(".");
//			String path = "";
//			for(String s : paths){
//				path+= s +FILE_SEP ;
//			}
//			if(paths.length==-1)path = packageName;
//			System.out.println(path);
			packageName.replaceAll(".", "/");
			File folder = new File(baseDirectory,packageName);
			if(!folder.exists())folder.mkdirs();
			String fileName = bean.getName();
			File f = new File(folder,fileName+".java");
			String content = generator.generate(bean);
//			if(!f.exists()){
				FileWriter writer = new FileWriter(f);
				writer.write(content);
				writer.flush();
//			}else{
//				//source=new generated code 
//				try { //try to merge
//					jMerger.setSourceCompilationUnit(jMerger.createCompilationUnitForContents(content));
//					jMerger.setTargetCompilationUnit(jMerger.createCompilationUnitForInputStream(new FileInputStream(f))); //target=last generated code
//					jMerger.merge(); 
//					String result = jMerger.getTargetCompilationUnit().getContents(); 
//					System.out.println(result);
//				}catch (Exception e) {
//					//if something goes wrong overwrite the file
//					FileWriter writer = new FileWriter(f);
//					writer.write(content);
//					writer.flush();
//				} 
//			}
		}
		return true;
	}

	
}
