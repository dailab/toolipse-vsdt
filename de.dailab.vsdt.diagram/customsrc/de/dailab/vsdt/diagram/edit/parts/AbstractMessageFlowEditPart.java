package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.AbstractGmfConnectionEditPart;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.policies.DoubleClickOrgPropEditPolicy;
import de.dailab.vsdt.diagram.figures.MessageFlowFigure;


/**
 * this abstract edit part shall be subclassed by the actual edit part usedby GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractMessageFlowEditPart extends AbstractGmfConnectionEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractMessageFlowEditPart(View view) {
		super(view);
	}

	/**
	 * notify the edit part when there are changes to the model
	 * (just a stub, no notifications yet)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		
		}
	}
	
	/**
	 * @return the model, casted to its actual Type
	 */
	public MessageFlow getCastedModel() {
		return (MessageFlow) ((View)getModel()).getElement();
	}
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected Connection createConnectionFigure() {
		MessageFlowFigure figure= new MessageFlowFigure();
		return figure;
	}
	
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,new DoubleClickOrgPropEditPolicy());
	}

}

