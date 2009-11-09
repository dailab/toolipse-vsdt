package de.dailab.vsdt.trafo.strucbpmn.export;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.strucbpmn.util.StrucBpmnResourceFactoryImpl;

public class StrucBpmnResultSaver extends MappingResultSaver {

	//file extensions
	public static final String EXT_XML= ".strucbpmn";

	/**
	 * Save the result to a StrucBPMN file.
	 * Additionally the content of the log list can be saved to a text file.
	 * 
	 * @param path		path where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		BusinessProcessDiagram bpd= (BusinessProcessDiagram) wrapper.getSourceModel();
		String baseFileName= new File(baseDirectory, bpd.getName()).getAbsolutePath();
		
		//save Model file to resource
		StrucBpmnResourceFactoryImpl resFac= new StrucBpmnResourceFactoryImpl();
		Resource procRes= resFac.createResource(URI.createFileURI(baseFileName + EXT_XML));
		procRes.getContents().add(bpd);
		procRes.save(null);

		return true;
	}

}
