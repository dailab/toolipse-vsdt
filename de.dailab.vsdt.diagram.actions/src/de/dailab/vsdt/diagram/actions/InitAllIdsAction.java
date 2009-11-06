package de.dailab.vsdt.diagram.actions;

import java.util.LinkedList;
import java.util.Queue;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.util.VsdtHelper;

public class InitAllIdsAction extends AbstractGmfAction {
	
	@Override
	protected AbstractTransactionalCommand getCommand() {
		if (eObject instanceof BusinessProcessDiagram) {
			return new InitAllIdsCommand((BusinessProcessDiagram) eObject);
		}
		return null;
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		String title= "Initialize all IDs?";
		String message= "The IDs of all objects in this diagram will be generated anew. Continue?";
		if (openQuestion(title, message)) {
			super.doRun(progressMonitor);
		}
	}

	public class InitAllIdsCommand extends AbstractGmfCommand {
		
		public InitAllIdsCommand(BusinessProcessDiagram bpd) {
		    super(bpd, "Initialize all IDs");
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			
			Queue<IdObject> queue= new LinkedList<IdObject>();
			queue.add((IdObject) modelElement);
			while (! queue.isEmpty()) {
				IdObject idObject= queue.remove();
				VsdtHelper.generateNewID(idObject);
				for (EObject child : idObject.eContents()) {
					if (child instanceof IdObject) {
						queue.add((IdObject) child);
					}
				}
			}
			return CommandResult.newOKCommandResult(modelElement);
		}

	}
}
