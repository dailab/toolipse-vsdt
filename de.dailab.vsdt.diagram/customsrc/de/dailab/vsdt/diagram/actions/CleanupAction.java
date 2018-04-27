package de.dailab.vsdt.diagram.actions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.BusinessProcessSystem;

/**
 * Action used for cleaning up the diagram, removing unused Services,
 * Data Types, or (Process-) Properties, removing Assignments that use
 * unused properties, etc.
 *
 * @author kuester
 */
public class CleanupAction extends AbstractGmfAction {

	@Override
	public CleanupCommand getCommand() {
		return new CleanupCommand();
	}

	public class CleanupCommand extends AbstractGmfCommand {

		public CleanupCommand() {
			super(eObject, "Cleanup Diagram");
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ListSelectionDialog dialog = new ListSelectionDialog(shell, eObject,
					new CleanupContentProvider(), new CleanupLabelProvider(),
					"Select unused elements to be removed");

			Object[] result = dialog.getResult();
			System.out.println(result);

			if (result != null) {
				removeElements(Stream.of(result)
						.map(EObject.class::cast)
						.collect(Collectors.toList()));
				return CommandResult.newOKCommandResult();
			} else {
				return CommandResult.newCancelledCommandResult();
			}
		}
	}

	protected void removeElements(List<EObject> objects) {
		// TODO
	}

	public class CleanupContentProvider implements IStructuredContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			BusinessProcessSystem bps = (BusinessProcessSystem) inputElement;

			// TODO Auto-generated method stub
			return null;
		}
	}

	public class CleanupLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			// TODO Auto-generated method stub
			return super.getText(element);
		}
	}
}
