package de.dailab.vsdt.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.dailab.vsdt.diagram.edit.commands.AssociationCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.AssociationReorientCommand;
import de.dailab.vsdt.diagram.edit.parts.AssociationEditPart;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class MessageFlowItemSemanticEditPolicy extends
		VsdtBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (VsdtElementTypes.Association_3003 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (VsdtElementTypes.Association_3003 == req.getElementType()) {
			return getGEFWrapper(new AssociationCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EClass based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientRelationshipCommand(
			ReorientRelationshipRequest req) {
		switch (getVisualID(req)) {
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new AssociationReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
