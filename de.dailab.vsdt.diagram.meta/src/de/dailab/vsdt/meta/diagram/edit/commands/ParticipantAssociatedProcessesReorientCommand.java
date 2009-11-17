package de.dailab.vsdt.meta.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.meta.diagram.edit.policies.VsdtBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ParticipantAssociatedProcessesReorientCommand extends
		EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject referenceOwner;

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
	public ParticipantAssociatedProcessesReorientCommand(
			ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == referenceOwner instanceof Participant) {
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
		if (!(oldEnd instanceof BusinessProcessDiagram && newEnd instanceof Participant)) {
			return false;
		}
		return VsdtBaseItemSemanticEditPolicy.LinkConstraints
				.canExistParticipantAssociatedProcesses_3001(getNewSource(),
						getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof BusinessProcessDiagram && newEnd instanceof BusinessProcessDiagram)) {
			return false;
		}
		return VsdtBaseItemSemanticEditPolicy.LinkConstraints
				.canExistParticipantAssociatedProcesses_3001(getOldSource(),
						getNewTarget());
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
		getOldSource().getAssociatedProcesses().remove(getOldTarget());
		getNewSource().getAssociatedProcesses().add(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getAssociatedProcesses().remove(getOldTarget());
		getOldSource().getAssociatedProcesses().add(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected Participant getOldSource() {
		return (Participant) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected Participant getNewSource() {
		return (Participant) newEnd;
	}

	/**
	 * @generated
	 */
	protected BusinessProcessDiagram getOldTarget() {
		return (BusinessProcessDiagram) oldEnd;
	}

	/**
	 * @generated
	 */
	protected BusinessProcessDiagram getNewTarget() {
		return (BusinessProcessDiagram) newEnd;
	}
}
