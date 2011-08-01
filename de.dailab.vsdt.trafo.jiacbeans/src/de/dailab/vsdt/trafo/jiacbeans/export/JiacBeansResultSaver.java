package de.dailab.vsdt.trafo.jiacbeans.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import jiacbeans.AgentBean;

import org.eclipse.emf.codegen.jet.JETEmitter;

import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.jiacbeans.export.generated.JavaCodeGenerator;
import de.dailab.vsdt.trafo.jiacbeans.util.JavaCode;

public class JiacBeansResultSaver extends MappingResultSaver {

	@Override
	protected String getDirectorySuffix() {
		return "jiacbeans";
	}

	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
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
			FileWriter writer = new FileWriter(f);
			writer.write(generator.generate(bean));
			writer.flush();
		}
		return true;
	}

	
}
