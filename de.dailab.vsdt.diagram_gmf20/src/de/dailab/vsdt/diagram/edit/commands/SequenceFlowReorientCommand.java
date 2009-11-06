package de.dailab.vsdt.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.diagram.edit.policies.VsdtBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class SequenceFlowReorientCommand extends EditElementCommand {

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
	public SequenceFlowReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (!(getElementToEdit() instanceof SequenceFlow)) {
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
		if (!(oldEnd instanceof FlowObject && newEnd instanceof FlowObject)) {
			return false;
		}
		FlowObject target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof BusinessProcessDiagram)) {
			return false;
		}
		BusinessProcessDiagram container = (BusinessProcessDiagram) getLink()
				.eContainer();
		return VsdtBaseItemSemanticEditPolicy.LinkConstraints
				.canExistSequenceFlow_3001(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof FlowObject && newEnd instanceof FlowObject)) {
			return false;
		}
		FlowObject source = getLink().getSource();
		if (!(getLink().eContainer() instanceof BusinessProcessDiagram)) {
			return false;
		}
		BusinessProcessDiagram container = (BusinessProcessDiagram) getLink()
				.eContainer();
		return VsdtBaseItemSemanticEditPolicy.LinkConstraints
				.canExistSequenceFlow_3001(container, source, getNewTarget());
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
	protected SequenceFlow getLink() {
		return (SequenceFlow) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected FlowObject getOldSource() {
		return (FlowObject) oldEnd;
	}

	/**
	 * @generated
	 */
	protected FlowObject getNewSource() {
		return (FlowObject) newEnd;
	}

	/**
	 * @generated
	 */
	protected FlowObject getOldTarget() {
		return (FlowObject) oldEnd;
	}

	/**
	 * @generated
	 */
	protected FlowObject getNewTarget() {
		return (FlowObject) newEnd;
	}
}
