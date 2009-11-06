package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.IModelCastingEditPart;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.diagram.edit.policies.BusinessProcessDiagramCanonicalEditPolicy;
import de.dailab.vsdt.diagram.edit.policies.BusinessProcessDiagramItemSemanticEditPolicy;

/**
 * + implements IVsdtEditPart, IModelCastingEditPart
 * @generated NOT
 */
public class BusinessProcessDiagramEditPart extends DiagramEditPart implements
		IModelCastingEditPart, IVsdtEditPart {

	/**
	 * @generated NOT
	 */
	public BusinessProcessDiagram getCastedModel() {
		return (BusinessProcessDiagram) ((View) getModel()).getElement();
	}

	/**
	 * @generated
	 */
	public final static String MODEL_ID = "Vsdt"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 79;

	/**
	 * @generated
	 */
	public BusinessProcessDiagramEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new BusinessProcessDiagramItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new BusinessProcessDiagramCanonicalEditPolicy());
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}

	/**
	 * @generated NOT
	 */
	public IFigure getPrimaryShape() {
		return null;
	}

}
