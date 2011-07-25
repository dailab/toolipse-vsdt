package de.dailab.vsdt.trafo.jiacbeans.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
		for(JavaCode jc : wrapper.getJavaFiles()){
			String[] paths = jc.getPackageName().split(".");
			String path = "";
			for(String s : paths){
				path+= s +"/" ;
			}
			File folder = new File(baseDirectory+"/"+path);
			if(!folder.exists())folder.mkdirs();
			String fileName = path+jc.getClassName();
			File f = new File(folder+"/"+fileName+".java");
			FileWriter writer = new FileWriter(f);
			writer.write(generator.generate(jc));
			writer.flush();
		}
		return true;
	}

	
}
