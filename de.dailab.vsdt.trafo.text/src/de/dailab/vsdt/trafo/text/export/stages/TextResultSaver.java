package de.dailab.vsdt.trafo.text.export.stages;

import java.io.File;
import java.io.IOException;

import de.dailab.vsdt.trafo.MappingResultSaver;

public class TextResultSaver extends MappingResultSaver {

	/**
	 * @param folder	folder where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		for (Object target : wrapper.getTargetModels()) {
			if (target instanceof TextBuilder) {
				TextBuilder textBuilder = (TextBuilder) target;
				String fileName= textBuilder.getName();
				textBuilder.saveAs(baseDirectory.getAbsolutePath(), fileName);
			}
		}
		return true;
	}
	
}
