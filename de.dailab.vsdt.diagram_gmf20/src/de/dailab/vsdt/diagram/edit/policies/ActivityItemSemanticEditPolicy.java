package de.dailab.vsdt.diagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.commands.AssociationCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.AssociationReorientCommand;
import de.dailab.vsdt.diagram.edit.commands.Intermediate2CreateCommand;
import de.dailab.vsdt.diagram.edit.commands.MessageFlowCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.MessageFlowReorientCommand;
import de.dailab.vsdt.diagram.edit.commands.SequenceFlowCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.SequenceFlowReorientCommand;
import de.dailab.vsdt.diagram.edit.parts.ActivityEditPart;
import de.dailab.vsdt.diagram.edit.parts.ActivitySubprocessCompartmentEditPart;
import de.dailab.vsdt.diagram.edit.parts.AssociationEditPart;
import de.dailab.vsdt.diagram.edit.parts.EndEditPart;
import de.dailab.vsdt.diagram.edit.parts.GatewayEditPart;
import de.dailab.vsdt.diagram.edit.parts.Intermediate2EditPart;
import de.dailab.vsdt.diagram.edit.parts.IntermediateEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.SequenceFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.StartEditPart;
import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class ActivityItemSemanticEditPolicy extends
		VsdtBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (VsdtElementTypes.Intermediate_2007 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getActivity_BoundaryEvents());
			}
			return getGEFWrapper(new Intermediate2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		CompoundCommand cc = getDestroyEdgesCommand();
		addDestroyChildNodesCommand(cc);
		addDestroyShortcutsCommand(cc);
		cc.add(getGEFWrapper(new DestroyElementCommand(req)));
		return cc.unwrap();
	}

	/**
	 * @generated
	 */
	protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
		View view = (View) getHost().getModel();
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation != null) {
			return;
		}
		for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
			Node node = (Node) it.next();
			switch (VsdtVisualIDRegistry.getVisualID(node)) {
			case Intermediate2EditPart.VISUAL_ID:
				cmd.add(getDestroyElementCommand(node));
				break;
			case ActivitySubprocessCompartmentEditPart.VISUAL_ID:
				for (Iterator cit = node.getChildren().iterator(); cit
						.hasNext();) {
					Node cnode = (Node) cit.next();
					switch (VsdtVisualIDRegistry.getVisualID(cnode)) {
					case ActivityEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case EndEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case GatewayEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case IntermediateEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					case StartEditPart.VISUAL_ID:
						cmd.add(getDestroyElementCommand(cnode));
						break;
					}
				}
				break;
			}
		}
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
