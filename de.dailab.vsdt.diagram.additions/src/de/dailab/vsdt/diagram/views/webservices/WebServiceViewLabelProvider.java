package de.dailab.vsdt.diagram.views.webservices;

import java.util.Collection;

import javax.wsdl.Definition;
import javax.wsdl.Fault;
import javax.wsdl.Input;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.Output;
import javax.wsdl.Part;
import javax.wsdl.PortType;

import org.eclipse.jface.resource.ImageDescriptor;

import de.dailab.common.swt.views.AbstractLabelProvider;
import de.dailab.vsdt.diagram.providers.VsdtAdditionsPlugin;

/**
 * This class is used to provide the Labels used in the BPMN WebServices View
 * 
 * @author kuester
 */
public class WebServiceViewLabelProvider extends AbstractLabelProvider {

	public static final String UNKNOWN_NAME= "<unknown>";
	
	@Override
	public ImageDescriptor getImageDescriptor(Object element) {
		ImageDescriptor descriptor= null;
		// handle Collections
		Object actualElement= element;
		if (element instanceof Collection) {
			Collection collection = (Collection) element;
			if (! collection.isEmpty()) {
				actualElement= collection.iterator().next();
			}
		}
		if (actualElement instanceof Definition) {
		   descriptor= VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_WSDL);
		}
		if (actualElement instanceof Message) {
		   descriptor= VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_MESSAGE);
		}
		if (actualElement instanceof Part) {
		   descriptor= VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_PART);
		}
		if (actualElement instanceof PortType) {
			descriptor= VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_PORTTYPE);			
		}
		if (actualElement instanceof Operation) {
			descriptor= VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_OPERATION);
		}
		if (actualElement instanceof Input) {
			descriptor= VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_INPUT);			
		}
		if (actualElement instanceof Output) {
			descriptor= VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_OUTPUT);
		}
		if (actualElement instanceof Fault) {
			descriptor= VsdtAdditionsPlugin.getImageDescriptor(VsdtAdditionsPlugin.IMAGE_FAULT);
		}
		return descriptor;
	}
	
	@Override
	public String getText(Object element) {
		StringBuffer buffer= new StringBuffer();
		if (element instanceof Definition) {
			Definition definition= (Definition) element;
			if (definition.getQName() != null) {
				buffer.append(definition.getQName().getLocalPart());
				buffer.append(" @ ");
			}
			buffer.append(definition.getDocumentBaseURI());
		}
		if (element instanceof Message) {
			Message message= (Message) element;
			buffer.append(message.getQName().getLocalPart());
		}
		if (element instanceof Part) {
			Part part= (Part) element;
			buffer.append(part.getName());
			buffer.append(" : ");
			buffer.append(part.getTypeName() != null ? part.getTypeName().getLocalPart() : "");
			buffer.append(part.getElementName() != null ? part.getElementName().getLocalPart() : "");
		}
		if (element instanceof PortType) {
			PortType portType = (PortType) element;
			buffer.append(portType.getQName().getLocalPart());
		}
		if (element instanceof Operation) {
			Operation operation = (Operation) element;
			buffer.append(operation.getName());
		}
		if (element instanceof Input) {
			Input input = (Input) element;
			if (input.getName() != null) {
				buffer.append(input.getName());
			}
			buffer.append(" : ");
			buffer.append(input.getMessage().getQName().getLocalPart());
		}
		if (element instanceof Output) {
			Output output = (Output) element;
			if (output.getName() != null) {
				buffer.append(output.getName());
			}
			buffer.append(" : ");
			buffer.append(output.getMessage().getQName().getLocalPart());
		}
		if (element instanceof Fault) {
			Fault fault = (Fault) element;
			buffer.append(fault.getName());
			buffer.append(" : ");
			buffer.append(fault.getMessage().getQName().getLocalPart());
		}
		// Collections
		if (element instanceof Collection) {
			Collection collection = (Collection) element;
			if (! collection.isEmpty()) {
				Object actualElement= collection.iterator().next();
				String name= actualElement.getClass().getSimpleName();
				buffer.append(name.endsWith("Impl") ? name.substring(0, name.length()-4) : name);
				buffer.append("s");
			}
		}
		if (buffer.toString().isEmpty()) {
			buffer.append(UNKNOWN_NAME);
		}
		return buffer.toString();
	}
	
}