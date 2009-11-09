package de.dailab.vsdt.trafo.bpel.util;

import org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot;
import org.xmlsoap.schemas.ws._2003._03.business.process.TProcess;
import org.xmlsoap.schemas.wsdl.TDefinitions;

/**
 * a container encapsulating the various parts of a BPEL process
 */
public class BpelProcessSet implements BpelVisitorConstants {

	/** the BPEL Process */
	public final TProcess process;
	
	/** the WSDL Definitions */
	public final TDefinitions definitions;
	
	/**
	 * Create ProcessSet for given Process and optionally given Definitions. If no Definitions
	 * are given, new Definitions are created. Further, the required name spaces are added.
	 * @param process
	 * @param definitionToUse
	 */
	public BpelProcessSet(TProcess process, TDefinitions definitionToUse) {
		this.process= process;
		if (definitionToUse == null) {
			this.definitions= wsdlFac.createTDefinitions();
			this.definitions.setTargetNamespace(BpelStaticHelper.getWsdlTNS(process.getName()));
			org.xmlsoap.schemas.wsdl.DocumentRoot wsdlRoot= wsdlFac.createDocumentRoot();
			wsdlRoot.setDefinitions(this.definitions);	
			wsdlRoot.getXMLNSPrefixMap().put(NS_TNS, this.definitions.getTargetNamespace());
			wsdlRoot.getXMLNSPrefixMap().put(NS_WSDL,NS_WSDL_URI);
			wsdlRoot.getXMLNSPrefixMap().put(NS_SOAP,NS_SOAP_URI);
			wsdlRoot.getXMLNSPrefixMap().put(NS_PLNK,NS_PLNK_URI);
			wsdlRoot.getXMLNSPrefixMap().put(NS_XSD,NS_XSD_URI);
		} else {
			this.definitions= definitionToUse;
		}
		this.process.setTargetNamespace(BpelStaticHelper.getBpelTNS(process.getName()));
		DocumentRoot bpelRoot= bpelFac.createDocumentRoot();
		bpelRoot.setProcess(this.process);
		bpelRoot.getXMLNSPrefixMap().put(NS_THIS, this.definitions.getTargetNamespace());
		bpelRoot.getXMLNSPrefixMap().put(NS_BPEL,NS_BPEL_URI);
		bpelRoot.getXMLNSPrefixMap().put(NS_XSD,NS_XSD_URI);
	}
	
}
