package de.dailab.vsdt.trafo.text.export.stages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import de.dailab.vsdt.trafo.MappingResultSaver;

/**
 * ResultSaver for the BPMN-to-Text-Transformation.
 * 
 * @author kuester
 */
public class TextResultSaver extends MappingResultSaver {

	@Override
	protected String getDirectorySuffix() {
		return "text";
	}
	
	/**
	 * @param folder	folder where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		// Saving of the actual file is delegates to the respective text builder,
		// so it can e.g. create additional layout files, or start a build procss,
		// or whatever.
		for (Object target : wrapper.getTargetModels()) {
			if (target instanceof TextBuilder) {
				TextBuilder textBuilder = (TextBuilder) target;
				String fileName= textBuilder.getName();
				textBuilder.saveAs(baseDirectory.getAbsolutePath(), fileName);
			}
		}
		// Iterate over generated images, if any, create the file and write
		// the byte array with the image data.
		Map<String, byte[]> imageMap= ((TextExportWrapper) wrapper).getImageMap();
		for (Entry<String, byte[]> entry : imageMap.entrySet()) {
			File file= new File(baseDirectory, entry.getKey());
			if (! file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fos= new FileOutputStream(file);
			fos.write(entry.getValue());
			fos.close();
		}
		return true;
	}
	
}
