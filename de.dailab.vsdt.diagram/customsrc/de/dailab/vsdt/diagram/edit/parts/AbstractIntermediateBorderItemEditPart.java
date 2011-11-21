package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.policies.DoubleClickOrgAssignEditPolicy;
import de.dailab.vsdt.diagram.edit.policies.VsdtConnectionHandleEditPolicyEx;
import de.dailab.vsdt.diagram.figures.EventFigure;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractIntermediateBorderItemEditPart extends AbstractBorderItemEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractIntermediateBorderItemEditPart(View view) {
		super(view);
	}
	
	/**
	 * notify the edit part when there are changes to the model
	 * - when the trigger has changed, set the figures trigger accordingly
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.INTERMEDIATE__TRIGGER:
			getPrimaryShape().setTriggerType(getCastedModel().getTrigger());
			refreshVisuals();
			break;
		case VsdtPackage.FLOW_OBJECT__INCOMING_SEQ:
		case VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ:
		case VsdtPackage.EVENT__IMPLEMENTATION:
			getPrimaryShape().setThrowing(getCastedModel().isThrowing());
			refreshVisuals();
			break;
		case VsdtPackage.EVENT__NON_INTERRUPTING:
			getPrimaryShape().setNonInterrupting(getCastedModel().isNonInterrupting());
			refreshVisuals();
			break;
		}
	}

	/**
	 * @return the model, casted to its actual Type
	 */
	public Intermediate getCastedModel() {
		return (Intermediate) ((View) getModel()).getElement();
	}

	public abstract EventFigure getPrimaryShape();
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		EventFigure figure= new EventFigure(EventFigure.INTERMEDIATE, getCastedModel()
				.getTrigger(), false, getCastedModel().isNonInterrupting(), getCastedModel());
		return figure;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,new DoubleClickOrgAssignEditPolicy());
		
        removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
        installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
        		new VsdtConnectionHandleEditPolicyEx());
	}
}
