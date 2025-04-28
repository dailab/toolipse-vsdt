package de.dailab.common.gmf.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;

/**
 * Command for executing any runnable (should in some way be connected to
 * parent class' modelElement).
 *
 * @author kuester
 */
public class GenericRunnableCommand extends AbstractGmfCommand {

	final Runnable runnable;
	
	public GenericRunnableCommand(EObject modelElement, String name, Runnable runnable) {
		super(modelElement, name);
		this.runnable = runnable;
	}
	
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			runnable.run();
			return CommandResult.newOKCommandResult();
		} catch (Exception e) {
			return CommandResult.newErrorCommandResult(e);
		}
	}
	
}
