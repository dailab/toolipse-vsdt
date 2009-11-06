package de.dailab.vsdt.diagram.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.Pool;

@Deprecated
public class InitParticipantAction extends AbstractGmfAction {

	@Override
	protected AbstractTransactionalCommand getCommand() {
		if (eObject instanceof Pool) {
			Pool pool = (Pool) eObject;
			return new InitParticipantCommand(pool);
		}
		return null;
	}
	
	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		String title= "Create new Participant?";
		String message= "A new Participant Object will be created and associated to the Pool. Continue?";
		if (openQuestion(title, message)) {
			super.doRun(progressMonitor);
		}
	}

	@Deprecated
	public class InitParticipantCommand extends AbstractGmfCommand {
		
		private Pool pool;
		
		public InitParticipantCommand(Pool pool) {
		    super(pool, "Initialize Participant");
		    this.pool= pool;
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			
			pool.initializeParticipant();
			
			return CommandResult.newOKCommandResult(pool);
		}
	}	
}
