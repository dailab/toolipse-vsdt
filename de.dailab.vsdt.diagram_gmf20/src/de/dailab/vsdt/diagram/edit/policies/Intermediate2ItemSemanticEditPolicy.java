package de.dailab.vsdt.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.dailab.vsdt.diagram.edit.commands.AssociationCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.AssociationReorientCommand;
import de.dailab.vsdt.diagram.edit.commands.MessageFlowCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.MessageFlowReorientCommand;
import de.dailab.vsdt.diagram.edit.commands.SequenceFlowCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.SequenceFlowReorientCommand;
import de.dailab.vsdt.diagram.edit.parts.AssociationEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.SequenceFlowEditPart;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class Intermediate2ItemSemanticEditPolicy extends
		VsdtBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyShortcutsCommand(cc);
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
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
		if (VsdtElementTypes.SequenceFlow_3001 == req.getElementType()) {
			return getGEFWrapper(new SequenceFlowCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (VsdtElementTypes.MessageFlow_3002 == req.getElementType()) {
			return getGEFWrapper(new MessageFlowCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
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
		if (VsdtElementTypes.SequenceFlow_3001 == req.getElementType()) {
			return getGEFWrapper(new SequenceFlowCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
		if (VsdtElementTypes.MessageFlow_3002 == req.getElementType()) {
			return getGEFWrapper(new MessageFlowCreateCommand(req, req
					.getSource(), req.getTarget()));
		}
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
		case SequenceFlowEditPart.VISUAL_ID:
			return getGEFWrapper(new SequenceFlowReorientCommand(req));
		case MessageFlowEditPart.VISUAL_ID:
			return getGEFWrapper(new MessageFlowReorientCommand(req));
		case AssociationEditPart.VISUAL_ID:
			return getGEFWrapper(new AssociationReorientCommand(req));
		}
		return super.getReorientRelationshipCommand(req);
	}

}
