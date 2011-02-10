package de.dailab.vsdt.diagram.views.webservices;

import java.util.ArrayList;
import java.util.Collection;

import javax.wsdl.Definition;
import javax.wsdl.Message;
import javax.wsdl.Operation;
import javax.wsdl.PortType;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Simple content provider class to be used with this view. This class is taken from
 * the Eclipse View Plugin Example.
 * 
 * @author kuester
 */
public class WebServiceViewContentProvider implements ITreeContentProvider {

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}
	
	public void dispose() {
	}
	
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}
	
	@SuppressWarnings("unchecked")
	public Object[] getChildren(Object parentElement) {
		Collection children= new ArrayList();
		if (parentElement instanceof WebSeviceAccessor) {
			WebSeviceAccessor accessor = (WebSeviceAccessor) parentElement;
			children.addAll(accessor.getDefinition());
		}
		if (parentElement instanceof Definition) {
			Definition definition = (Definition) parentElement;
			if (! definition.getMessages().isEmpty()) {
				children.add(definition.getMessages().values());
			}
			children.addAll(definition.getPortTypes().values());
		}
		if (parentElement instanceof Message) {
			Message message= (Message) parentElement;
			children.addAll(message.getParts().values());
		}
		if (parentElement instanceof PortType) {
			PortType portType = (PortType) parentElement;
			children.addAll(portType.getOperations());
		}
		if (parentElement instanceof Operation) {
			Operation operation = (Operation) parentElement;
			children.add(operation.getInput());
			children.add(operation.getOutput());
			children.addAll(operation.getFaults().values());
		}
		// Collections
		if (parentElement instanceof Collection) {
			children.addAll((Collection) parentElement);
		}
		return children.toArray();
	}
	
	public Object getParent(Object element) {
		return null;
	}
	
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
	
}