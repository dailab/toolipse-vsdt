package de.dailab.vsdt.trafo.strucbpmn.export;

import java.io.File;
import java.io.IOException;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.strucbpmn.util.StrucBpmnResourceFactoryImpl;

public class StrucBpmnResultSaver extends MappingResultSaver {

	//file extensions
	public static final String EXT_XML= ".strucbpmn";

	@Override
	protected String getDirectorySuffix() {
		return "strucbpmn";
	}
	
	/**
	 * Save the result to a StrucBPMN file.
	 * Additionally the content of the log list can be saved to a text file.
	 * 
	 * @param path		path where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		BusinessProcessSystem bpd= (BusinessProcessSystem) wrapper.getSourceModel();
		File file= new File(baseDirectory, bpd.getName());
		
		//save Model file to resource
		saveAsXmlResource(file, bpd, null, new StrucBpmnResourceFactoryImpl());

		return true;
	}

}
