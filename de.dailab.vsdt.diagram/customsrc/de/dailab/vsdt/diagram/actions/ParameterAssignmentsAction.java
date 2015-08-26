package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.dialogs.ParameterAssignmentsDialog;

public class ParameterAssignmentsAction extends AbstractGmfAction {

	@Override
	protected AbstractTransactionalCommand getCommand() {
		if (eObject instanceof FlowObject) {
			return new ParameterAssignmentsCommand((FlowObject) eObject);
		}
		return null;
	}

	public static class ParameterAssignmentsCommand extends AbstractDialogWrapperCommand {
		
		public ParameterAssignmentsCommand(EObject modelElement) {
		    super(modelElement, "Create Parameter Assignments");
		}

		@Override
		protected Dialog getDialog(Shell shell) {
			return new ParameterAssignmentsDialog(shell, modelElement);
		}
		
	}
}
