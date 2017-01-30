package de.dailab.vsdt.diagram.clipboard;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.gmf.runtime.common.ui.services.action.global.IGlobalActionContext;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @see https://esalagea.wordpress.com/2011/04/13/lets-solve-once-for-all-the-gmf-copy-paste-problem-and-then-forget-about-it/
 *
 * @author kuester
 */
public class VsdtEditorClipboardSupportGlobalActionHandler extends DiagramGlobalActionHandler {

	public ICommand getCommand(IGlobalActionContext cntxt) {
		IWorkbenchPart part = cntxt.getActivePart();
		if (!(part instanceof IDiagramWorkbenchPart)) {
			return null;
		}
		IDiagramWorkbenchPart diagramPart = (IDiagramWorkbenchPart) part;
		String actionId = cntxt.getActionId();
		System.out.println("CALLING GET COMMAND for " + actionId);
		if (actionId.equals(GlobalActionId.COPY)) {
			return getCopyCommand(cntxt, diagramPart, false);
		} else if (actionId.equals(GlobalActionId.PASTE)) {
			return getPasteCommand(cntxt, diagramPart);
		} else {
			return super.getCommand(cntxt);
		}
	}
	
	@Override
	protected boolean canPaste(IGlobalActionContext cntxt) {
		return VsdtEditorCopyCommand.objectsToCopy != null;
	}
	
	protected ICommand getCopyCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart, final boolean isUndoable) {
		System.out.println("GET COPY COMMAND");
		List<EObject> toCopyElements = this.getSelectedElements(cntxt.getSelection());
		List<EditPart> toCopyEditParts = this.getSelectedEditParts(cntxt.getSelection());
		return new VsdtEditorCopyCommand(toCopyElements, toCopyEditParts);
	}

	protected ICommand getPasteCommand(IGlobalActionContext cntxt, IDiagramWorkbenchPart diagramPart) {
		System.out.println("GET PASTE COMMAND");
		return new VsdtEditorPasteCommand((IGraphicalEditPart) ((StructuredSelection) cntxt.getSelection()).getFirstElement());
	}

	/*
	 * utility methods
	 */

	@SuppressWarnings("unchecked")
	protected List<EObject> getSelectedElements(ISelection selection) {
		List<EObject> results = new LinkedList<>();
		if (selection == null || selection.isEmpty())
			return results;
		Iterator<EObject> iterator = ((IStructuredSelection) selection).iterator();
		while (iterator.hasNext()) {
			Object selectedElement = iterator.next();
			EObject element = (EObject) ((EditPart) selectedElement).getAdapter(EObject.class);
			results.add(element);
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	private List<EditPart> getSelectedEditParts(ISelection selection) {
		List<EditPart> results = new LinkedList<>();
		Iterator<EditPart> iterator = ((IStructuredSelection) selection).iterator();
		while (iterator.hasNext()) {
			Object selectedElement = iterator.next();
			results.add((EditPart) selectedElement);
		}
		return results;
	}

}
