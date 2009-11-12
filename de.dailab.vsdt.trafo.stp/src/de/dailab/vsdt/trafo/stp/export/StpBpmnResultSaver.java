package de.dailab.vsdt.trafo.stp.export;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.stp.bpmn.BpmnDiagram;

import de.dailab.vsdt.trafo.MappingResultSaver;

public class StpBpmnResultSaver extends MappingResultSaver {

	//file extensions
	public static final String EXT_BPMN= ".bpmn";

	/**
	 * Save the result to a STP BPMN file.
	 * Additionally the content of the log list can be saved to a text file.
	 * 
	 * @param path		path where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		//iterate over all processes in the list
		for (Object object : wrapper.getTargetModels()) {
			if (object instanceof BpmnDiagram) {
				BpmnDiagram diagram = (BpmnDiagram) object;
				File file= new File(baseDirectory, diagram.getName() + EXT_BPMN);
				
				// from XYZ-editor-creation-wizard
				Map<Object, Object> options = new HashMap<Object, Object>();
				options.put(XMLResource.OPTION_ENCODING, "UTF-8");
//				saveAsXmlResource(file, diagram, options, null); // doesn't work here
				URI uri= URI.createFileURI(file.getAbsolutePath());
				Resource res= new ResourceSetImpl().createResource(uri);
				res.getContents().add(diagram);
				res.save(options);
			}
		}
		return true;
	}

}
