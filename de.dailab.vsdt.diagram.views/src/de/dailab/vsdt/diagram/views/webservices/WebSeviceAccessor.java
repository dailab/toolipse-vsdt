package de.dailab.vsdt.diagram.views.webservices;

import java.util.ArrayList;
import java.util.List;

import javax.wsdl.Definition;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.Part;
import javax.wsdl.PortType;
import javax.wsdl.WSDLException;
import javax.wsdl.factory.WSDLFactory;

import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtFactory;

/**
 * This class is the Root Object of the WebService View.  It contains all accessed
 * Web services and provides ways to convert these Web service elements to BPMN
 * elements.  Since the elements do not have inverse references it is necessary
 * to look up the elements in the definitions to identify their parent elements.
 * 
 * @author kuester
 */
public class WebSeviceAccessor {

	public static final String IMPLEMENTATION_TYPE= "WebService";
	public static final String SIMPLE_TYPE_PREFIX= "xsd:";
	public static final String UNKNOWN_TYPE= "<unknown type>";
	
	private List<Definition> definitions= new ArrayList<Definition>();
	
	/**
	 * Load WSDL file and add the resulting Definition to the list.
	 * 
	 * @param url		URL containing a WSDL definition (usually ending with "?wsdl")
	 * @return			newly created Definition object
	 * @throws WSDLException
	 */
	public Definition loadWSDL(String url) throws WSDLException {
		Definition definition= WSDLFactory.newInstance().newWSDLReader().readWSDL(url);
		definitions.add(definition);
		return definition;
	}
	
	public List<Definition> getDefinition() {
		return definitions;
	}

	/**
	 * Creating the BPMN Implementation of an operation requires to look up the
	 * operation in the collected Definitions and PortTypes.
	 *  
	 * @param operation		Some WSDL Operation
	 * @return				Respective BPMN Implementation
	 */
	public Implementation createBpmnElement(Operation operation) {
		Implementation implementation= VsdtFactory.eINSTANCE.createImplementation();
		implementation.setOperation(operation.getName());
		implementation.setType(IMPLEMENTATION_TYPE);
		for (Definition definition : definitions) {
			for (Object object : definition.getPortTypes().values()) {
				PortType portType= (PortType) object;
				if (portType.getOperations().contains(operation)) {
					implementation.setInterface(portType.getQName().getLocalPart());
					implementation.setLocation(definition.getDocumentBaseURI());
					break;
				}
			}
		}
		return implementation;
	}
	
	/**
	 * Create a BPMN Message from a WSDL Message. The originating Message's Parts
	 * are translated to the resulting Message's Properties.
	 * 
	 * @param message		Some WSDL Message
	 * @return				Respective BPMN Message
	 * @see createBpmnElement(Part part)
	 */
	public de.dailab.vsdt.Message createBpmnElement(Message message) {
		de.dailab.vsdt.Message bpmnMessage= VsdtFactory.eINSTANCE.createMessage();
		bpmnMessage.setName(message.getQName().getLocalPart());
		for (Object part : message.getOrderedParts(null)) {
			bpmnMessage.getProperties().add(createBpmnElement((Part) part));
		}
		return bpmnMessage;
	}
	
	/**
	 * Create a BPMN Property from a WSDL Message Part (to be integrated in a
	 * BPMN Message mapped from a WSDL Message).
	 * 
	 * @param part			Some WSDL Message Part
	 * @return				Respective BPMN Property
	 */
	public Property createBpmnElement(Part part) {
		Property property= VsdtFactory.eINSTANCE.createProperty();
		property.setName(part.getName());
		String typePrefix= null;
		String typeName= "<unknown type>";
		if (part.getTypeName() != null) {
			typePrefix= part.getTypeName().getPrefix();
			typeName= part.getTypeName().getLocalPart();
		} else if (part.getElementName() != null) {
			typePrefix= part.getElementName().getPrefix();
			typeName= part.getElementName().getLocalPart();
		}
		property.setType((typePrefix != null && ! typePrefix.isEmpty() ? typePrefix + ":" : "" ) + typeName); 
		return property;
	}

}
