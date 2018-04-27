package de.dailab.vsdt.diagram.actions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;

import de.dailab.common.gmf.action.AbstractGmfAction;
import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.util.VsdtHelper;

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

	/**
	 * Command opening a list selection dialogue and performing the cleanup
	 *
	 * @author kuester
	 */
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

			if (dialog.open() == Window.OK) {
				removeElements(Stream.of(dialog.getResult())
						.map(EObject.class::cast)
						.collect(Collectors.toList()));
				return CommandResult.newOKCommandResult();
			} else {
				return CommandResult.newCancelledCommandResult();
			}
		}
	}

	/**
	 * Perform the actual cleanup
	 *
	 * @param objects	elements selected in the dialogue
	 */
	protected void removeElements(List<EObject> objects) {
		// TODO
	}

	/**
	 * Responsible for determining unused elements than can be cleaned up
	 *
	 * @author kuester
	 */
	public class CleanupContentProvider implements IStructuredContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {
			BusinessProcessSystem bps = (BusinessProcessSystem) inputElement;

			Map<String, DataType> typesMap = new HashMap<>();
			for (DataType datatype: bps.getDataTypes()) {
				typesMap.put(VsdtHelper.getTypeName(datatype), datatype);
			}

			Set<EObject> candidateElements = new HashSet<>();
			candidateElements.addAll(bps.getDataTypes());
			candidateElements.addAll(bps.getServices());
			candidateElements.addAll(bps.getMessageChannels());

			Set<EObject> usedElements = new HashSet<>();
			for (TreeIterator<EObject> iter = bps.eAllContents(); iter.hasNext(); ) {
				EObject element = iter.next();
				if (element instanceof AbstractProcess) {
					candidateElements.addAll(((AbstractProcess) element).getProperties());
				}
				if (element instanceof Assignment) {
					usedElements.add(((Assignment) element).getTo());
					// also check from expression? if property is never target of an assignment,
					// it can never occur in an expression either (for process properties at least)
				}
				if (element instanceof Event) {
					usedElements.add(((Event) element).getImplementation());
				}
				if (element instanceof Activity) {
					usedElements.add(((Activity) element).getImplementation());
				}
				if (element instanceof Property) {
					usedElements.add(typesMap.getOrDefault(((Property) element).getType(), null));
				}
			}
			return candidateElements.stream()
					.filter(x -> ! usedElements.contains(x))
					.toArray();
		}
	}

	/**
	 * Just the label provider for the elements in the dialogue
	 *
	 * @author kuester
	 */
	public class CleanupLabelProvider extends LabelProvider {

		@Override
		public String getText(Object element) {
			// TODO Auto-generated method stub
			return super.getText(element);
		}
	}
}
