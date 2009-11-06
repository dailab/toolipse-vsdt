package de.dailab.vsdt.diagram.actions;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * This Action can be used to insert a pair of Link Events, replacing the selected
 * Sequence Flow.
 * 
 * @author kuester
 */
public class InsertLinkEventsAction extends InsertPatternAction {

	public String getCommandName() {
		return "Insert Link Events";
	}
	
	@Override
	public boolean addCreationCommands(CompoundCommand cc) {

		Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		InputDialog dialog= new InputDialog(shell, "Enter Link Name", 
				"Please enter a name for the Link to be used as Labels for the Link Events", null, null);
		if (! (dialog.open() == Dialog.OK)) {
			return false;
		}
		String linkName= dialog.getValue();

		Rectangle b= seqFlowEditPart.getFigure().getBounds();
		Point p= b.getCenter().translate(-30,-40);
		compEditPart.getFigure().translateToAbsolute(p);
		
		// Create First Event Command
		CreateViewRequest event1Request = CreateViewRequestFactory.getCreateShapeRequest(
				VsdtElementTypes.Intermediate_2003,
				compEditPart.getDiagramPreferencesHint());
		event1Request.setLocation(p.getCopy().translate(- b.width/4, 0));
		cc.add(compEditPart.getCommand(event1Request));
		adapterForFirstNode = (IAdaptable) ((List) event1Request.getNewObject()).get(0);
		
		// Create Second Event Command
		CreateViewRequest event2Request = CreateViewRequestFactory.getCreateShapeRequest(
				VsdtElementTypes.Intermediate_2003,
				compEditPart.getDiagramPreferencesHint());
		event2Request.setLocation(p.getCopy().translate(b.width/4, 0));
		cc.add(compEditPart.getCommand(event2Request));
		adapterForLastNode = (IAdaptable) ((List) event2Request.getNewObject()).get(0);
		
		cc.add(new ICommandProxy(new SetLinkTargetsCommand(linkName)));
		
		return true;
	}
	
	protected class SetLinkTargetsCommand extends AbstractGmfCommand {
		
		private final String linkName;
		
		public SetLinkTargetsCommand(String linkName) {
			super(seqFlowEditPart.getCastedModel(), "Set Link Targets Command");
			this.linkName= linkName;
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			
			Object node1= adapterForFirstNode.getAdapter(Node.class);
			Object node2= adapterForLastNode.getAdapter(Node.class);
			if (node1 instanceof Node && node2 instanceof Node) {
				Intermediate linkSource= (Intermediate) ((Node) node1).getElement();
				Intermediate linkTarget= (Intermediate) ((Node) node2).getElement();
				linkSource.setTrigger(TriggerType.LINK);
				linkTarget.setTrigger(TriggerType.LINK);
				linkSource.setLinkedTo(linkTarget);
				linkTarget.setLinkedTo(linkSource);
				if (linkName != null && ! linkName.isEmpty()) {
					linkSource.setName(linkName);
					linkTarget.setName(linkName);
				}
				return CommandResult.newOKCommandResult();
			}
			return CommandResult.newErrorCommandResult("Adapters not of Type Node");
		}
	}
	
}
