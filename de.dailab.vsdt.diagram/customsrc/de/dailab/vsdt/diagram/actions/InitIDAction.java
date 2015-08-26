package de.dailab.vsdt.diagram.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.util.VsdtHelper;

public class InitIDAction extends AbstractGmfAction {

	@Override
	protected AbstractTransactionalCommand getCommand() {
		if (eObject instanceof IdObject) {
			IdObject idObject= (IdObject) eObject;
			return new InitIdCommand(idObject);
		}
		return null;
	}

	public static class InitIdCommand extends AbstractGmfCommand {
		
		public InitIdCommand(IdObject idObject) {
		    super(idObject, "Initialize ID");
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			
			VsdtHelper.generateNewID((IdObject) modelElement);
			
			return CommandResult.newOKCommandResult(modelElement);
		}

	}

}
