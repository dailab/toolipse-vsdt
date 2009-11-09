package de.dailab.vsdt.trafo.bpel.util;

import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessFactory;
import org.xmlsoap.schemas.wsdl.WsdlFactory;

/**
 * This interface is holding various constants / singleton instances to be used by the visitor and its helper classes.
 * 
 * @author kuester
 */
public interface BpelVisitorConstants {
	
	//name-space prefixes
	public static final String NS_BPEL= "bpws";
	public static final String NS_THIS= "ns1";
	public static final String NS_TNS=  "tns";
	public static final String NS_XSD=  "xsd";
	public static final String NS_PLNK= "plnk";
	public static final String NS_WSDL= "wsdl";
	public static final String NS_SOAP= "soap";	

	//name-space URIs
	public static final String NS_BPEL_URI=  "http://schemas.xmlsoap.org/ws/2003/03/business-process/";
	public static final String NS_PLNK_URI=  "http://docs.oasis-open.org/wsbpel/2.0/plnktype";
	public static final String NS_XPATH_URI= "http://www.w3.org/TR/1999/REC-xpath-19991116";
	public static final String NS_XSD_URI=   "http://www.w3.org/2001/XMLSchema";
	public static final String NS_WSDL_URI=  "http://schemas.xmlsoap.org/wsdl/";
	public static final String NS_SOAP_URI=  "http://schemas.xmlsoap.org/wsdl/soap/";
		
	//factories
	public static ProcessFactory bpelFac= ProcessFactory.eINSTANCE;
	public static WsdlFactory wsdlFac=    WsdlFactory.eINSTANCE;
	public static XMLTypeFactory xmlFac=  XMLTypeFactory.eINSTANCE;
	public static ExtendedMetaData emd=   ExtendedMetaData.INSTANCE;
	
	//XSD data types
	public static final String TYPE_BOOLEAN= NS_XSD+":boolean";
	public static final String TYPE_INTEGER= NS_XSD+":integer";
	public static final String TYPE_DEFAULT= TYPE_INTEGER;

	//other stuff
//	public static final String XPATH= "XPath";
	
}
