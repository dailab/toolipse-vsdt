package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.diagram.dialogs.OrganizeAssignmentsDialog;

public class OrganizeAssignmentsAction extends AbstractGmfAction {

	@Override
	protected AbstractTransactionalCommand getCommand() {
		return new OrganizeAssignmentsCommand(eObject);
	}

	public class OrganizeAssignmentsCommand extends AbstractDialogWrapperCommand {
		
		public OrganizeAssignmentsCommand(EObject modelElement) {
		    super(modelElement, "Organize Assignments");
		}

		@Override
		protected Dialog getDialog(Shell shell) {
			return new OrganizeAssignmentsDialog(shell, modelElement);
		}
		
	}
}
