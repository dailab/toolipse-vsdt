package de.dailab.vsdt.diagram.actions;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest.ViewAndElementDescriptor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * This action is used to initialize the pools of a given Business Process Diagram.
 * For each Participant participating in the business process, one pool is created
 * and associated to that Participant.
 * 
 * @author kuester
 */
public class InitializePoolsAction implements IObjectActionDelegate {

	/** Business Process Diagram holding the Pools to be created*/
	protected BusinessProcessDiagramEditPart bpdEditPart;
	
	public void selectionChanged(IAction action, ISelection selection) {
		bpdEditPart= null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof BusinessProcessDiagramEditPart) {
				bpdEditPart = (BusinessProcessDiagramEditPart) structuredSelection.getFirstElement();
			}
		}
	}
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
	
	public void run(IAction action) {
		
		// open dialog
		Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		String title= "Initialize Pools?";
		String message= "A new Pool will be created for each Participant " +
				"of this Business Process Diagram. Continue?";
		if (! MessageDialog.openQuestion(shell, title, message)) {
			return;
		}
		
		//this compound command will hold the various partial commands
		CompoundCommand cc= new CompoundCommand("Initialize Pools");

		BusinessProcessDiagram bpd= bpdEditPart.getCastedModel();
		int n= bpd.getPools().size();
		for (Participant participant : bpd.getParticipants()) {
			boolean createPool= true;
			for (Pool pool : bpd.getPools()) {
				// do not create pools for participants already represented by a pool
				createPool&= pool.getParticipant() != participant; 
			}
			if (createPool) {
				// Create Pool Command
				CreateViewRequest nodeRequest = CreateViewRequestFactory.getCreateShapeRequest(
						VsdtElementTypes.Pool_1004, bpdEditPart.getDiagramPreferencesHint());
				nodeRequest.setLocation(new Point(30, 30 + n*300));
				nodeRequest.setSize(new Dimension(1000, 200));
				cc.add(bpdEditPart.getCommand(nodeRequest)); // FIXME sometimes NPE
				
				// Set Pool attributes according to Participant
				IAdaptable poolAdapter= (IAdaptable) ((List) nodeRequest.getNewObject()).get(0);
				SetPoolAttributesCommand setCommand= new SetPoolAttributesCommand(poolAdapter, participant);
				cc.add(new ICommandProxy(setCommand));
				
				n++;
			}
		}
		
		// execute commands
		bpdEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(cc);
	}
	
	/**
	 * This command is used to set the Pool's participant and name attribute
	 * according to the Participant it has been created for.
	 * 
	 * @author kuester
	 */
	protected class SetPoolAttributesCommand extends AbstractGmfCommand {
		final IAdaptable poolAdapter;
		final Participant participant;

		public SetPoolAttributesCommand(IAdaptable poolAdapter, Participant participant) {
			super(participant, "Set Pool Attributes Command");
			this.poolAdapter= poolAdapter;
			this.participant= participant;
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			EObject element= null;
			if (poolAdapter instanceof ViewAndElementDescriptor) {
				ViewAndElementDescriptor descriptor = (ViewAndElementDescriptor) poolAdapter;
				element= descriptor.getCreateElementRequestAdapter().resolve();
			}
			
			if (element instanceof Pool) {
				Pool pool= (Pool) element;
				pool.setParticipant(participant);
				pool.setName(participant.getName());
				
				return CommandResult.newOKCommandResult();
			} else {
				return CommandResult.newErrorCommandResult("No Pool Element found");
			}
		}
	}
	
}
