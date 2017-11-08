package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;

import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.VsdtPackage;


public class MessageFlowSection extends AbstractVsdtPropertySection {

    protected MessageFlow messageFlow;
    
    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getMessageFlow();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof MessageFlow) {
        	this.messageFlow= (MessageFlow) eObject;
        }
    }

}