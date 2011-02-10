package de.dailab.vsdt.diagram.views.pools;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

import de.dailab.common.swt.views.AbstractTreeContentProvider;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolEditPart;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;

/**
 * This Class provides the content for the Pool Visibility View.  The input is the active
 * workbench page.  Top level elements are the BPMN diagram's Pools, child element's are 
 * the (transitive) child edit parts, excluding LabelEditParts and CompartmentEditParts
 * (but including the CompartmentEditParts' children, of course).  If the selection in the 
 * active editor changes, the view is refreshed, and the state of the checkBoxes and the 
 * selection is set accordingly.
 * 
 * @author kuester
 */
public class PoolVisibilityViewContentProvider extends AbstractTreeContentProvider implements ITreeContentProvider, ISelectionListener {

	/**
	 * This method is called every time the selection in the workbench changes
	 * - sets the selection in the view according to the main editor
	 * - sets the checked states of the entries in the view according to the edit parts' activation
	 */
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		super.selectionChanged(part, selection);
//		System.out.println("selection in content provider changed");
		if (viewer != null) {
//			viewer.setSelection(selection);
			if (viewer instanceof CheckboxTreeViewer && selection instanceof StructuredSelection) {
				CheckboxTreeViewer cv = (CheckboxTreeViewer) viewer;
				Object firstElement= ((StructuredSelection) selection).getFirstElement();
				if (firstElement instanceof BusinessProcessDiagramEditPart) {
					BusinessProcessDiagramEditPart diagramEditPart= (BusinessProcessDiagramEditPart) firstElement;
					for (Object o : diagramEditPart.getChildren()) {
						if (o instanceof PoolEditPart) {
							PoolEditPart pep= (PoolEditPart) o;
							cv.setChecked(o, pep.isActive());
						}
					}
				}
			}
		}
	}

	public Object[] getElements(Object parent) {
		List<Object> elements= new ArrayList<Object>();

		if (parent instanceof IWorkbenchPage) {
			IEditorPart editor= ((IWorkbenchPage) parent).getActiveEditor();
			if (editor instanceof VsdtDiagramEditor) {
				DiagramEditPart dep = ((VsdtDiagramEditor)editor).getDiagramEditPart();
				for (Object o : dep.getChildren()) {
					if (o instanceof PoolEditPart) {
						PoolEditPart pep = (PoolEditPart) o;
						elements.add(pep);
					}
				}
			}
		}
		return elements.toArray();
	}

	public Object[] getChildren(Object parentElement) {
//		Collection children= new ArrayList();
//		if (parentElement instanceof GraphicalEditPart) {
//			for (Object o : ((GraphicalEditPart) parentElement).getChildren()) {
//				if (o instanceof LabelEditPart) {
//					continue;
//				}
//				if (o instanceof CompartmentEditPart) {
//					children.addAll(((CompartmentEditPart) o).getChildren());
//					continue;
//				}
//				children.add(o);
//			}
//		}
//		return children.toArray();
		return new Object[] {};
	}
	
}