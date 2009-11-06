package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.diagram.dialogs.OrganizeParticipantsDialog;

@Deprecated
public class OrganizeParticipantsAction extends AbstractGmfAction {
	
	@Override
	protected AbstractTransactionalCommand getCommand() {
		return new OrganizeParticipantsCommand(eObject);
	}

	@Deprecated
	public class OrganizeParticipantsCommand extends AbstractDialogWrapperCommand {
		
		public OrganizeParticipantsCommand(EObject modelElement) {
		    super(modelElement, "Organize Participants");
		}

		@Override
		protected Dialog getDialog(Shell shell) {
			return new OrganizeParticipantsDialog(shell, modelElement);
		}

	}
}
