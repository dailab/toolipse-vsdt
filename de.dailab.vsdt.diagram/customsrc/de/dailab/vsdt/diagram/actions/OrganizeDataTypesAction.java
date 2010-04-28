package de.dailab.vsdt.diagram.actions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.diagram.dialogs.OrganizeDataTypesDialog;

public class OrganizeDataTypesAction extends AbstractGmfAction {
	
	@Override
	protected AbstractTransactionalCommand getCommand() {
		return new OrganizeDataTypesCommand(eObject);
	}

	public class OrganizeDataTypesCommand extends AbstractDialogWrapperCommand {
		
		public OrganizeDataTypesCommand(EObject modelElement) {
		    super(modelElement, "Organize Data Types");
		}
		
		@Override
		protected Dialog getDialog(Shell shell) {
			return new OrganizeDataTypesDialog(shell, modelElement);
		}
		
	}
}
