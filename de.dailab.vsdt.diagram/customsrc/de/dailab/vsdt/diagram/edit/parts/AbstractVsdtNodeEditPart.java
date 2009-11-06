package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.AbstractGmfNodeEditPart;
import de.dailab.vsdt.diagram.edit.policies.VsdtConnectionHandleEditPolicyEx;

public abstract class AbstractVsdtNodeEditPart extends AbstractGmfNodeEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractVsdtNodeEditPart(View view) {
		super(view);
	}
	
	/**
	 * replace ConnectionHandleEditPolicy
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
        removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
        installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
        		new VsdtConnectionHandleEditPolicyEx());
	}

}
