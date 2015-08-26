package de.dailab.vsdt.diagram.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.Activity;

public class InitOutputSetAction extends AbstractGmfAction {

	@Override
	protected AbstractTransactionalCommand getCommand() {
		if (eObject instanceof Activity) {
			Activity activity = (Activity) eObject;
			return new InitOutputSetCommand(activity);
		}
		return null;
	}

	public static class InitOutputSetCommand extends AbstractGmfCommand {
		
		public InitOutputSetCommand(Activity activity) {
		    super(activity, "Initialize Output Set");
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			
			((Activity) modelElement).initializeOutputSet();
			
			return CommandResult.newOKCommandResult(modelElement);
		}
	}
}
