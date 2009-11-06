package de.dailab.vsdt.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.dailab.vsdt.Association;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.GraphicalObject;
import de.dailab.vsdt.diagram.edit.policies.VsdtBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class AssociationReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public AssociationReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (!(getElementToEdit() instanceof Association)) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof GraphicalObject && newEnd instanceof GraphicalObject)) {
			return false;
		}
		GraphicalObject target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof BusinessProcessDiagram)) {
			return false;
		}
		BusinessProcessDiagram container = (BusinessProcessDiagram) getLink()
				.eContainer();
		return VsdtBaseItemSemanticEditPolicy.LinkConstraints
				.canExistAssociation_3003(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof GraphicalObject && newEnd instanceof GraphicalObject)) {
			return false;
		}
		GraphicalObject source = getLink().getSource();
		if (!(getLink().eContainer() instanceof BusinessProcessDiagram)) {
			return false;
		}
		BusinessProcessDiagram container = (BusinessProcessDiagram) getLink()
				.eContainer();
		return VsdtBaseItemSemanticEditPolicy.LinkConstraints
				.canExistAssociation_3003(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Association getLink() {
		return (Association) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected GraphicalObject getOldSource() {
		return (GraphicalObject) oldEnd;
	}

	/**
	 * @generated
	 */
	protected GraphicalObject getNewSource() {
		return (GraphicalObject) newEnd;
	}

	/**
	 * @generated
	 */
	protected GraphicalObject getOldTarget() {
		return (GraphicalObject) oldEnd;
	}

	/**
	 * @generated
	 */
	protected GraphicalObject getNewTarget() {
		return (GraphicalObject) newEnd;
	}
}
