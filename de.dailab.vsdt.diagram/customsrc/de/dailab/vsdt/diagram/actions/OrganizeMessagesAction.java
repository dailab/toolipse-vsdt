package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.diagram.dialogs.OrganizeMessageChannelsDialog;

public class OrganizeMessagesAction extends AbstractGmfAction {
	
	@Override
	protected AbstractTransactionalCommand getCommand() {
		return new OrganizeMessagesCommand(eObject);
	}

	public class OrganizeMessagesCommand extends AbstractDialogWrapperCommand {
		
		public OrganizeMessagesCommand(EObject modelElement) {
		    super(modelElement, "Organize Messages");
		}
		
		@Override
		protected Dialog getDialog(Shell shell) {
			return new OrganizeMessageChannelsDialog(shell, modelElement);
		}
		
	}
}
