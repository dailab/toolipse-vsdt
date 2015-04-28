package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.policies.DoubleClickOrgAssignEditPolicy;
import de.dailab.vsdt.diagram.figures.GatewayFigure;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractGatewayEditPart extends AbstractVsdtBorderedShapeEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractGatewayEditPart(View view) {
		super(view);
	}

	/**
	 * notify the edit part when there are changes to the model
	 * - when the GatewayType or marker visible feature has changes, set it in the figure
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.GATEWAY__GATEWAY_TYPE:
			getPrimaryShape().setGatewayType(getCastedModel().getGatewayType());
			refreshVisuals();
			break;
//		case VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ:
//			// this can not be moved to impl classes, as this would (un)set 
//			// the gates each time the model file is loaded
//			getCastedModel().refreshGates();
//			break;
		}
	}

	/**
	 * @return the model, casted to its actual Type
	 */
	public Gateway getCastedModel() {
		return (Gateway) ((View) getModel()).getElement();
	}

	public abstract GatewayFigure getPrimaryShape();
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		GatewayFigure figure= new GatewayFigure(getCastedModel().getGatewayType(), getCastedModel());
		return figure;
	}


	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,new DoubleClickOrgAssignEditPolicy());
	}
}
