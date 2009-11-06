package de.dailab.vsdt.diagram.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.MessageFlow;

public class InitMessageAction extends AbstractGmfAction {
	
	@Override
	protected AbstractTransactionalCommand getCommand() {
		if (eObject instanceof MessageFlow) {
			MessageFlow messageFlow= (MessageFlow) eObject;
			return new InitMessageCommand(messageFlow);
		}
		return null;
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		String title= "Create new Message?";
		String message= "A new Message Object will be created and associated to the Message Flow and, if possible, to its source and target. Continue?";
		if (openQuestion(title, message)) {
			super.doRun(progressMonitor);
		}
	}

	public class InitMessageCommand extends AbstractGmfCommand {
		
		public InitMessageCommand(MessageFlow messageFlow) {
		    super(messageFlow, "Initialize Message");
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			
			((MessageFlow) modelElement).initializeMessage();
			
			return CommandResult.newOKCommandResult(modelElement);
		}
	}

}
