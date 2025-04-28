package de.dailab.common.gmf.action;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.ui.action.AbstractActionDelegate;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.PlatformUI;

public abstract class AbstractGmfAction extends AbstractActionDelegate implements IObjectActionDelegate {

	/**the selected edit part*/
	protected IGraphicalEditPart editPart;
	
	/**the eObject behind the edit part*/
	protected EObject eObject;
	
	/**
	 * execute the command
	 */
	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		AbstractTransactionalCommand command= getCommand();
		try {
			OperationHistoryFactory.getOperationHistory().execute(command,progressMonitor, null);
		} catch (ExecutionException e) {
		}		
	}
	
	/**
	 * just execute the command (e.g. starting from a property sheet)
	 * @param modelElement		the model element
	 */
	public void run(EObject modelElement) {
		this.eObject= modelElement;
		AbstractTransactionalCommand command= getCommand();
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
		}	
	}

	/**
	 * get the graphical edit part from the selection
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
		editPart = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof IGraphicalEditPart) {
				editPart = (IGraphicalEditPart) structuredSelection.getFirstElement();
				eObject= ((View)editPart.getModel()).getElement();
			}
		}
	}

	/**
	 * implement this method to return the command to execute
	 * 
	 * @return			the command
	 */
	protected abstract AbstractTransactionalCommand getCommand();
	
	/**
	 * Opens a question dialog with the given title and message to be displayed before
	 * the execution of the action. To use this method, overwrite doRun.
	 *  
	 * @param title		the title of the dialog to be displayed
	 * @param message	the message of the dialog
	 * @return			ok button clicked?
	 */
	protected boolean openQuestion(String title, String message) {
		Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		return MessageDialog.openConfirm(shell, title, message);
	}

}
