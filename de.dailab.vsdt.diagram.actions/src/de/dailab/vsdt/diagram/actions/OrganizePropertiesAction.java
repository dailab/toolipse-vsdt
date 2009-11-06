package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.diagram.dialogs.OrganizePropertiesDialog;

public class OrganizePropertiesAction extends AbstractGmfAction {

	@Override
	protected AbstractTransactionalCommand getCommand() {
		return new OrganizePropertiesCommand(eObject);
	}

	public class OrganizePropertiesCommand extends AbstractDialogWrapperCommand {
		
		public OrganizePropertiesCommand(EObject modelElement) {
		    super(modelElement, "Organize Properties");
		}
		
		@Override
		protected Dialog getDialog(Shell shell) {
			return new OrganizePropertiesDialog(shell, modelElement);
		}
		
	}
}
