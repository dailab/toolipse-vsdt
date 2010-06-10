package de.dailab.vsdt.diagram.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.diagram.dialogs.SetTypeDialog;

public class SetTypeAction extends AbstractGmfAction {

	@Override
	protected AbstractTransactionalCommand getCommand() {
		if (eObject instanceof FlowObject) {
			FlowObject flowObject= (FlowObject) eObject;
			return new SetTypeCommand(flowObject);
		}
		return null;
	}

	public class SetTypeCommand extends AbstractGmfCommand {

		private FlowObject flowObject;
		
		public SetTypeCommand(FlowObject flowObject) {
		    super(flowObject, "Set Type");
		    this.flowObject= flowObject;
		}
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {

			//display simple dialog, ask for new type, set new type
			Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			SetTypeDialog dialog= new SetTypeDialog( shell, flowObject);
			if (dialog.open() == SetTypeDialog.OK) {
				if (dialog.getSelected() != null) {
					if (flowObject instanceof Event) {
						((Event)flowObject).setTrigger(TriggerType.get(dialog.getSelected()));
					}
					if (flowObject instanceof Gateway) {
						((Gateway)flowObject).setGatewayType(GatewayType.get(dialog.getSelected()));
					}
					if (flowObject instanceof Activity) {
						((Activity)flowObject).setActivityType(ActivityType.get(dialog.getSelected()));
					}
					return CommandResult.newOKCommandResult(modelElement);	
				} else {
					return CommandResult.newCancelledCommandResult();
				}
			} else {
				return CommandResult.newErrorCommandResult("No Type Selected");
			}
		}
	}

}
