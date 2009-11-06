package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.diagram.edit.policies.DoubleClickOrgAssignEditPolicy;
import de.dailab.vsdt.diagram.figures.DataObjectFigure;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractDataObjectEditPart extends AbstractVsdtBorderedShapeEditPart implements IVsdtEditPart {
	
	/**
	 * the standard constructor
	 */
	public AbstractDataObjectEditPart(View view) {
		super(view);
	}

	/**
	 * @return the model, casted to its actual Type
	 */
	public DataObject getCastedModel() {
		return (DataObject) ((View) getModel()).getElement();
	}

	public abstract DataObjectFigure getPrimaryShape();
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		DataObjectFigure figure= new DataObjectFigure();
		return figure;
	}


	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,new DoubleClickOrgAssignEditPolicy());
	}
}
