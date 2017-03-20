package de.dailab.vsdt.diagram.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.dailab.common.gmf.Util;
import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractDialogWrapperCommand;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.dialogs.SetTypeDialog;

public class SetTypeAction extends AbstractGmfAction {

	@Override
	protected AbstractTransactionalCommand getCommand() {
		if (eObject instanceof FlowObject) {
			return new SetTypeCommand((FlowObject) eObject);
		}
		return null;
	}

	public static class SetTypeCommand extends AbstractDialogWrapperCommand {

		public SetTypeCommand(FlowObject flowObject) {
		    super(flowObject, "Set Type");
		}
		
		@Override
		protected Dialog getDialog(Shell shell) {
			return new SetTypeDialog(shell, (FlowObject) modelElement);
		}
	}
	
	public static class Handler extends AbstractHandler {
	
		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			try {
				FlowObject modelElement = Util.getModelElement(selection);
				if (modelElement != null && modelElement instanceof FlowObject) {
					new SetTypeAction().run(modelElement);
				}
			} catch (ClassCastException e) {
				System.out.println("Could not execute handler " + getClass().getSimpleName() + ": got unexpected model element.");
			}
			return null;
		}
	}

}
