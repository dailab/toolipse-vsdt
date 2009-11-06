package de.dailab.vsdt.diagram.rsd.client;

import java.io.StringReader;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Part;
import javax.wsdl.Port;
import javax.wsdl.PortType;
import javax.wsdl.Service;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.soap.SOAPAddress;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.xml.sax.InputSource;

import de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter;
import de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.diagram.rsd.IRsdParam;
import de.dailab.vsdt.diagram.rsd.IRsdWS;

/**
 * web service description wrapper for the axis 2 RSD client to be used
 * with the VSDT RSD View
 * 
 * @author kuester
 */
public class Axis2RsdWS implements IRsdWS {
	
	private Axis2ServiceDescription service= null;
	private Definition definition= null;
	
	private Implementation webService= null;
	private Message inMessage= null;
	private Message outMessage= null;
	
	private boolean elementsCreated= false;
	
	public Axis2RsdWS(Axis2ServiceDescription service) {
		this.service= service;
	}

	public Calendar getExpireDate() {
		return service.getExpireDate();
	}

	public String getId() {
		return service.getId();
	}

	public String[] getKeywords() {
		return service.getKeywords();
	}

	public String getName() {
		return service.getName();
	}

	public String getPostcondition() {
		return service.getPostCondition();
	}

	public String getPrecondition() {
		return service.getPreCondition();
	}

	public String getProviderAdress() {
		return service.getProviderAddress();
	}

	public String getQoSRating() {
		return service.getQoSRating();
	}

	public String getWsdl() {
		return service.getWsdl();
	}

	public String getWsdlUrl() {
		if (service.getWsdlUrl() == null) {
			//For some reason the URL is not stored in the Service object... Extract URL from definition
			if (getDefinition() != null) {
				service.setWsdlUrl(definition.getDocumentBaseURI());
				if (service.getWsdlUrl() == null) {
					Object o= getFirstElement(definition.getServices());
					if (o instanceof Service) {
						Service serv = (Service) o;
						o= getFirstElement(serv.getPorts());
						if (o instanceof Port) {
							Port port = (Port) o;
							List elements= port.getExtensibilityElements();
							for (Object element : elements) {
								if (element instanceof SOAPAddress) {
									SOAPAddress address = (SOAPAddress) element;
									service.setWsdlUrl(address.getLocationURI());
								}
							}
						}
					}
				}
			}
		}
		return service.getWsdlUrl();
	}
	
	private Object getFirstElement(Map map) {
		for (Iterator i= map.values().iterator(); i.hasNext(); ) {
			return i.next();
		}
		return null;
	}
	
	public IRsdParam[] getInputParams() {
		return toIRsdParam(service.getInputParams());
	}

	public IRsdParam[] getOutputParams() {
		return toIRsdParam(service.getOutputParams());
	}
	
	private IRsdParam[] toIRsdParam(ServiceParameter[] params) {
		if (params != null) {
			IRsdParam[] params2= new Axis2RsdParam[params.length];
			for (int i = 0; i < params.length; i++) {
				params2[i]= new Axis2RsdParam(params[i]);
			}
			return params2;
		}
		return null;
	}

	public Object getDefinition() {
		if (definition == null) {
			try {
				if (service.getWsdl() != null) {
					definition= WSDLFactory.newInstance().newWSDLReader().readWSDL(null, new InputSource(new StringReader(service.getWsdl())));
				} else if (service.getWsdlUrl() != null) {
					definition= WSDLFactory.newInstance().newWSDLReader().readWSDL(service.getWsdlUrl());
				}
			} catch (WSDLException e) {
				e.printStackTrace();
			}
		}
		return definition;
	}
	
	/*
	 * the elements are created only once, since this is somewhat complex. however, to prevent that one and
	 * the same object is shared among different BPMN diagrams in a longer VSDT session, the element is
	 * copied each time and a copy is returned
	 */
	
	public Implementation getWebService() {
		doElementCreationOnce();
		return (Implementation) EcoreUtil.copy(webService);
	}
	
	public Message getInputMessage() {
		doElementCreationOnce();
		return (Message) EcoreUtil.copy(inMessage);
	}
	
	public Message getOutputMessage() {
		doElementCreationOnce();
		return (Message) EcoreUtil.copy(outMessage);
	}
	
	// the methods below are used to create a web service and up to two message objects from the WSDL file
	
	private void doElementCreationOnce() {
		if (! elementsCreated) {
			initializeBpmnElements();
			elementsCreated= true;
		}
	}

	private void initializeBpmnElements() {
		String operationName= service.getName().substring(0, service.getName().indexOf('.'));
		webService= VsdtFactory.eINSTANCE.createImplementation();

		Definition definition= (Definition) getDefinition();
		Map<?, PortType> porttypes= definition.getPortTypes();
		for (PortType pt : porttypes.values()) {
			List<Operation> operations= pt.getOperations();
			for (Operation op : operations) {
				if (op.getName().equals(operationName)) {
					//create web service and message objects for this operation
					webService= VsdtFactory.eINSTANCE.createImplementation();
					webService.setLocation(getWsdlUrl());
					webService.setInterface(pt.getQName().getLocalPart());
					webService.setOperation(op.getName());
					if (op.getInput() != null) {
						inMessage= createMessage(op.getInput().getMessage());
					}
					if (op.getOutput() != null) {
						outMessage= createMessage(op.getOutput().getMessage());
					}
					
					// TODO somehow add the binding and service block to the web service object
					// no, storing the entire WSDL in the description attribute is not an option...
//					webService.setDescription(service.getWsdl());
					
					break;
				}
			}
		}
	}
	
	private Message createMessage(javax.wsdl.Message wsdlMessage) {
		if (wsdlMessage != null) {
			Message message= VsdtFactory.eINSTANCE.createMessage();
			message.setName(wsdlMessage.getQName().getLocalPart());
			Collection<Part> parts= wsdlMessage.getParts().values();
			for (Part part : parts) {
				Property property= VsdtFactory.eINSTANCE.createProperty();
				property.setName(part.getName());
				if (part.getTypeName() != null) {
					property.setType(getPrefixedName(part.getTypeName()));
				} else {
					property.setType(getPrefixedName(part.getElementName()));
				}
				message.getProperties().add(property);
			}
			return message;
		}
		return null;
	}
	
	private String getPrefixedName(QName qName) {
		if (qName != null) {
			String prefix= qName.getPrefix();
			if (prefix == null || "http://www.w3.org/2001/XMLSchema".equals(qName.getNamespaceURI())) {
				prefix= "xsd";
			}
			return prefix + ":" + qName.getLocalPart();
		}
		return null;
	}
		
	@Override
	public String toString() {
		return new StringBuffer().append(getProviderAdress()).append(".").append(getName()).toString();
	}
}
