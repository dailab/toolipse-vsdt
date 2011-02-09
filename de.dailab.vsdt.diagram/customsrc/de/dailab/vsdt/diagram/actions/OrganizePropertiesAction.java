package de.dailab.vsdt.diagram.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.diagram.dialogs.OrganizePropertiesDialog;

public class OrganizePropertiesAction extends AbstractGmfAction {

	private int hint = -1;
	
	public void run(EObject modelElement, int hint) {
		this.eObject = modelElement;
		this.hint = hint;
		AbstractTransactionalCommand command= getCommand();
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}	
	}
	
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
			return new OrganizePropertiesDialog(shell, modelElement, hint);
		}
		
	}
}
