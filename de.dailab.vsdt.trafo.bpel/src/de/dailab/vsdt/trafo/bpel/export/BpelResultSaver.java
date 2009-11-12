package de.dailab.vsdt.trafo.bpel.export;

import java.io.File;
import java.io.IOException;

import org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot;
import org.xmlsoap.schemas.ws._2003._03.business.process.TProcess;
import org.xmlsoap.schemas.ws._2003._03.business.process.util.ProcessResourceFactoryImpl;
import org.xmlsoap.schemas.wsdl.TDefinitions;
import org.xmlsoap.schemas.wsdl.util.WsdlResourceFactoryImpl;

import de.dailab.vsdt.trafo.MappingResultSaver;
import de.dailab.vsdt.trafo.bpel.util.BpelProcessSet;
import de.dailab.vsdt.trafo.bpel.util.BpelStaticHelper;

public class BpelResultSaver extends MappingResultSaver {

	//file extensions
	public static final String EXT_BPEL= ".bpel";
	public static final String EXT_WSDL= ".wsdl";

	/**
	 * Save the result to a couple of BPEL and WSDL files for each pool/process in the diagram.
	 * Additionally the content of the log list can be saved to a text file.
	 * 
	 * @param path		path where to save the stuff
	 * @return			successfully saved?
	 */
	@Override
	protected boolean internalSave(File baseDirectory) throws IOException {
		//iterate over all processes in the list
		for (Object object : wrapper.getTargetModels()) {
			if (object instanceof BpelProcessSet) {
				BpelProcessSet processSet = (BpelProcessSet) object;
				
				TProcess tProc= processSet.process;
				TDefinitions tDef= processSet.definitions;
				File fileBpel= new File(baseDirectory, tProc.getName() + EXT_BPEL);
				File fileWsdl= new File(baseDirectory, tProc.getName() + EXT_WSDL);
				
				//save BPEL file to resource
				DocumentRoot bpelRoot= (DocumentRoot) tProc.eContainer();
				saveAsXmlResource(fileBpel, bpelRoot, null, new ProcessResourceFactoryImpl());
				
				//clean up Definition
				BpelStaticHelper.cleanUpWSDL(tDef);
				
				//save WSDL file to resource
				org.xmlsoap.schemas.wsdl.DocumentRoot wsdlRoot= (org.xmlsoap.schemas.wsdl.DocumentRoot) tDef.eContainer();
				saveAsXmlResource(fileWsdl, wsdlRoot, null, new WsdlResourceFactoryImpl());
			}
		}
		return true;
	}

}
