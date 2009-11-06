package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.diagram.dialogs.OrganizeImplementationsDialog;

public class OrganizeImplementationsAction extends AbstractGmfAction {
	
	@Override
	protected AbstractTransactionalCommand getCommand() {
		return new OrganizeImplementationsCommand(eObject);
	}

	public class OrganizeImplementationsCommand extends AbstractDialogWrapperCommand {
		
		public OrganizeImplementationsCommand(EObject modelElement) {
		    super(modelElement, "Organize Web Services");
		}
		
		@Override
		protected Dialog getDialog(Shell shell) {
			return new OrganizeImplementationsDialog(shell, modelElement);
		}
		
	}
}
