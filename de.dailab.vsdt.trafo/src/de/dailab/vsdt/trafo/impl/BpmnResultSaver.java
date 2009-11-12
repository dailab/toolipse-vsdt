package de.dailab.vsdt.trafo.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMLResource;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.trafo.MappingResultSaver;

/**
 * Default implementation of MappingResultSaver to be used for BPMN files.
 * This class can be used for importing BPMN diagrams from other sources, e.g. BPEL.
 * 
 * @author kuester
 */
public class BpmnResultSaver extends MappingResultSaver {

	/** file extensions */
	public static final String EXT= ".vsdt";
	
	/** 
	 * this suffix is inserted between the filename and the extension, 
	 * e.g. to distinguish from existing files with same extension
	 * when importing from other BPMN editors
	 */
	private String suffix= "";

	/**
	 * Save the result to a couple of BPEL and WSDL files for each pool/process in the diagram.
	 * Additionally the content of the log list can be saved to a text file.
	 * 
	 * @param path		path where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		//iterate over all BPDs in the list
		for (Object object : wrapper.getTargetModels()) {
			if (object instanceof BusinessProcessSystem) {
				BusinessProcessSystem bps= (BusinessProcessSystem) object;
				File file= new File(baseDirectory, bps.getNameOrId() + suffix + EXT);
				
				// from XYZ-editor-creation-wizard
				Map<Object, Object> options = new HashMap<Object, Object>();
				options.put(XMLResource.OPTION_ENCODING, "UTF-8");
				saveAsXmlResource(file, bps, options, null); // Problem with IDs when using VSDT resource factory
			}
		}
		return true;
	}
	
	public void setSuffix(String suffix) {
		this.suffix= suffix;
	}

}
