package de.dailab.vsdt.diagram.edit.policies;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.diagram.part.Messages;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorUtil;

/**
 * Derived from OpenDiagramCommand of VSDT Meta Diagram Editor, this command is
 * used to open a given Business Process Diagram (e.g. the one referenced by an
 * Independent Subprocess) in a new Diagram Editor.
 * 
 * @author kuester
 * @generated NOT
 */
public class OpenBusinessProcessDiagramCommand  extends AbstractTransactionalCommand {

	/** the Business Process Diagram to be opened */
	private final BusinessProcessDiagram bpd;

	public OpenBusinessProcessDiagramCommand(BusinessProcessDiagram bpd) {
		super(TransactionUtil.getEditingDomain(bpd), Messages.CommandName_OpenDiagram, null);
		this.bpd = bpd;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			Diagram diagram = getDiagramToOpen();
			if (diagram == null) {
				diagram = intializeNewDiagram();
			}
			URI uri = EcoreUtil.getURI(diagram);
			String editorName = uri.lastSegment() + "#" + diagram.eResource().getContents().indexOf(diagram); //$NON-NLS-1$
			IEditorInput editorInput = new URIEditorInput(uri, editorName);
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			page.openEditor(editorInput, getEditorID());
			return CommandResult.newOKCommandResult();
		} catch (Exception ex) {
			throw new ExecutionException("Can't open diagram", ex);
		}
	}

	/**
	 * Get the diagram to open by looking in the model element's resource and
	 * finding the diagram, if any, which has the model element as its element.
	 * 
	 * Obviously, this will work only if model and diagram are in the same file.
	 * 
	 * @return		model element's diagram
	 */
	protected Diagram getDiagramToOpen() {
		for (EObject object : bpd.eResource().getContents()) {
			if (object instanceof Diagram) {
				Diagram diagram = (Diagram) object;
				if (diagram.getElement() == bpd) {
					return diagram;
				}
			}
		}
		return null;
	}

	/**
	 * If the diagram does not exist yet, create it in the resource of the model
	 * element.
	 * 
	 * @return		newly created Diagram object
	 * @throws ExecutionException
	 */
	protected Diagram intializeNewDiagram() throws ExecutionException {
		Diagram d = ViewService.createDiagram(bpd, getDiagramKind(), getPreferencesHint());
		if (d == null) {
			throw new ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind");
		}
		bpd.eResource().getContents().add(d);
		EObject container = bpd.eContainer();
		while (container instanceof View) {
			((View) container).persist();
			container = container.eContainer();
		}
		try {
			new WorkspaceModifyOperation() {
				protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
					try {
						for (Iterator<Resource> it = bpd.eResource().getResourceSet().getResources().iterator(); it.hasNext();) {
							Resource nextResource = it.next();
							if (nextResource.isLoaded() && !getEditingDomain().isReadOnly(nextResource)) {
								nextResource.save(VsdtDiagramEditorUtil.getSaveOptions());
							}
						}
					} catch (IOException ex) {
						throw new InvocationTargetException(ex, "Save operation failed");
					}
				}
			}.run(null);
		} catch (InvocationTargetException e) {
			throw new ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind", e);
		} catch (InterruptedException e) {
			throw new ExecutionException("Can't create diagram of '" + getDiagramKind() + "' kind", e);
		}
		return d;
	}

	protected PreferencesHint getPreferencesHint() {
		return VsdtDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT;
	}

	protected String getDiagramKind() {
		return "Vsdt";
	}

	protected String getEditorID() {
		return "de.dailab.vsdt.diagram.part.VsdtDiagramEditorID";
	}
}

