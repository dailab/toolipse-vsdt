package de.dailab.vsdt.meta.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.meta.diagram.edit.policies.VsdtBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ParticipantAssociatedProcessesCreateCommand extends
		EditElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	public ParticipantAssociatedProcessesCreateCommand(
			CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof Participant) {
			return false;
		}
		if (target != null && false == target instanceof BusinessProcessDiagram) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		return VsdtBaseItemSemanticEditPolicy.LinkConstraints
				.canCreateParticipantAssociatedProcesses_3001(getSource(),
						getTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in create link command"); //$NON-NLS-1$
		}
		if (getSource() != null && getTarget() != null) {
			getSource().getAssociatedProcesses().add(getTarget());
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * @generated
	 */
	protected Participant getSource() {
		return (Participant) source;
	}

	/**
	 * @generated
	 */
	protected BusinessProcessDiagram getTarget() {
		return (BusinessProcessDiagram) target;
	}
}
