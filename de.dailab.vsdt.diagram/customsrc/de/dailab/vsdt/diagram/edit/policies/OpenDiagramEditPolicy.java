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
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.diagram.part.Messages;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorUtil;

/**
 * Derived from VSDT Meta Diagram Editor's Open Diagram Edit Policy
 * 
 * Shall be used for opening Independent Subprocesses in a new Editor, but not
 * finished yet.
 * 
 * @generated NOT
 */
public class OpenDiagramEditPolicy extends OpenEditPolicy {

	protected Command getOpenCommand(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);
		if (false == targetEditPart.getModel() instanceof View) {
			return null;
		}
		View view = (View) targetEditPart.getModel();
		EObject element= view.getElement();
		if (element instanceof Activity) {
			Activity activity= (Activity) element;
			if (activity.getActivityType() == ActivityType.INDEPENDENT
					&& activity.getDiagramRef() != null) {
				Style link = view.getDiagram().getStyle(NotationPackage.eINSTANCE
						.getHintedDiagramLinkStyle());
				if (false == link instanceof HintedDiagramLinkStyle) {
					return null;
				}
				return new ICommandProxy(new OpenDiagramCommand(
						(HintedDiagramLinkStyle) link));
			}
		}
		return new ICommandProxy(UnexecutableCommand.INSTANCE);
	}

	private static class OpenDiagramCommand extends
			AbstractTransactionalCommand {

		private final HintedDiagramLinkStyle diagramFacet;

		OpenDiagramCommand(HintedDiagramLinkStyle linkStyle) {
			// editing domain is taken for original diagram, 
			// if we open diagram from another file, we should use another editing domain
			super(TransactionUtil.getEditingDomain(linkStyle),
					Messages.CommandName_OpenDiagram, null);
			diagramFacet = linkStyle;
		}

		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			try {
				Diagram diagram = getDiagramToOpen();
				if (diagram == null) {
					diagram = intializeNewDiagram();
				}
				URI uri = EcoreUtil.getURI(diagram);
				String editorName = uri.lastSegment()
						+ "#" + diagram.eResource().getContents().indexOf(diagram); //$NON-NLS-1$
				IEditorInput editorInput = new URIEditorInput(uri, editorName);
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				page.openEditor(editorInput, getEditorID());
				return CommandResult.newOKCommandResult();
			} catch (Exception ex) {
				throw new ExecutionException("Can't open diagram", ex);
			}
		}

		protected Diagram getDiagramToOpen() {
			return diagramFacet.getDiagramLink();
		}

		protected Diagram intializeNewDiagram() throws ExecutionException {
			Diagram d = ViewService.createDiagram(getDiagramDomainElement(),
					getDiagramKind(), getPreferencesHint());
			if (d == null) {
				throw new ExecutionException("Can't create diagram of '"
						+ getDiagramKind() + "' kind");
			}
			diagramFacet.setDiagramLink(d);
			assert diagramFacet.eResource() != null;
			diagramFacet.eResource().getContents().add(d);
			EObject container = diagramFacet.eContainer();
			while (container instanceof View) {
				((View) container).persist();
				container = container.eContainer();
			}
			try {
				new WorkspaceModifyOperation() {
					protected void execute(IProgressMonitor monitor)
							throws CoreException, InvocationTargetException,
							InterruptedException {
						try {
							for (Iterator it = diagramFacet.eResource()
									.getResourceSet().getResources().iterator(); it
									.hasNext();) {
								Resource nextResource = (Resource) it.next();
								if (nextResource.isLoaded()
										&& !getEditingDomain().isReadOnly(
												nextResource)) {
									nextResource.save(VsdtDiagramEditorUtil
											.getSaveOptions());
								}
							}
						} catch (IOException ex) {
							throw new InvocationTargetException(ex,
									"Save operation failed");
						}
					}
				}.run(null);
			} catch (InvocationTargetException e) {
				throw new ExecutionException("Can't create diagram of '"
						+ getDiagramKind() + "' kind", e);
			} catch (InterruptedException e) {
				throw new ExecutionException("Can't create diagram of '"
						+ getDiagramKind() + "' kind", e);
			}
			return d;
		}

		protected EObject getDiagramDomainElement() {
			// use same element as associated with EP
			EObject element= ((View) diagramFacet.eContainer()).getElement();
			System.out.println(element);
			// TODO get diagram element
			return null;
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

}
