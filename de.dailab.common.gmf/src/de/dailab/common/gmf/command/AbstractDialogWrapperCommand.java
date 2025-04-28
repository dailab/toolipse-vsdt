package de.dailab.common.gmf.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * This command wraps another command which displays a dialog. Inside the dialog arbitrary
 * operations can be done on the given modelElement. If the dialog is canceled, the inner
 * command will be undone by the outer command, effectively undoing the changes made in the
 * dialog.  Surely there's a better way for doing this, but for now it works.
 * 
 * @author kuester
 */
public abstract class AbstractDialogWrapperCommand extends AbstractGmfCommand {
	
	public AbstractDialogWrapperCommand(EObject modelElement, String commandName) {
	    super(modelElement, commandName);
	}
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		InnerCommand cmd= new InnerCommand(modelElement);
		cmd.execute(monitor, info);
		if (cmd.getCommandResult().getReturnValue() == null) {
			//command has been canceled
			cmd.undo(monitor, info);
		}
		return cmd.getCommandResult();
	}
	
	protected abstract Dialog getDialog(Shell shell);

	/**
	 * this command is executed inside of the other command and can be undone
	 * in case the dialog has been canceled.
	 * Surely there is a better way for this, but for now it works...
	 */
	private class InnerCommand extends AbstractGmfCommand {
		
		public InnerCommand(EObject modelelement) {
			super(modelelement, null);
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			//display dialog
			Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			Dialog dialog= getDialog( shell );
			if (dialog.open() == Dialog.OK){
				return CommandResult.newOKCommandResult(modelElement);
			} else {
				return CommandResult.newCancelledCommandResult();
			}
		}
	}
}