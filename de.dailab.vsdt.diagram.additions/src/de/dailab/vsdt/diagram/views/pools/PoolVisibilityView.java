package de.dailab.vsdt.diagram.views.pools;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.views.AbstractStructuredViewerView;
import de.dailab.vsdt.diagram.actions.SetPoolVisibilityAction;
import de.dailab.vsdt.diagram.edit.parts.PoolEditPart;

/**
 * The main intent of this view is to provide a means to toggle the visibility of a given
 * BPMN Pool on and off. This can be very helpful in cases where three or more Pools are
 * communicating with each others, so the Message Flows need to cross the central Pool(s).
 * In this case, Pools that are currently not of interest can be hidden.
 * 
 * Further, this view might be extended to a full-featured outline view, giving a better
 * view on the diagram structure than the EMF outline view, but there are still some issues
 * with this.
 * 
 * Currently, this view provides no other actions than toggling the visibility of a pool,
 * which is done when (un)checking an entry in the tree representing a pool.
 * 
 * @author kuester
 */
public class PoolVisibilityView extends AbstractStructuredViewerView {
	
	private CheckboxTreeViewer viewer;
	
	public void setFocus() {
		viewer.getControl().setFocus();
	};
	
	@Override
	public void createPartControl(Composite composite) {
		
		viewer= new CheckboxTreeViewer(composite);
		viewer.setContentProvider(new PoolVisibilityViewContentProvider());
		viewer.setLabelProvider(new PoolVisibilityViewLabelProvider());
		viewer.setInput(getViewSite().getWorkbenchWindow().getActivePage());

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO synch selection with editor
//				System.out.println("selection in pool view changed");
//				if (event.getSelection() instanceof TreeSelection) {
//					TreeSelection selection = (TreeSelection) event.getSelection();
//					Object o= selection.getFirstElement();
//					if (o instanceof GraphicalEditPart) {
//						GraphicalEditPart editPart = (GraphicalEditPart) o;
//						editPart.getViewer().setSelection(new StructuredSelection(editPart));
//					}
//				}
			}
		});
		viewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				if (event.getElement() instanceof PoolEditPart) {
					int state= event.getChecked() ? SetPoolVisibilityAction.MODE_SHOW : SetPoolVisibilityAction.MODE_HIDE;
					new SetPoolVisibilityAction((PoolEditPart) event.getElement(), state).run();
				}
			}
		});
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				// center on and highlight clicked Pool
				Object selected= getSelectedElement(viewer);
				IEditorPart editor= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if (selected instanceof AbstractGraphicalEditPart && editor instanceof DiagramEditor) {
					Util.highlight((AbstractGraphicalEditPart) selected, (DiagramEditor) editor);
				}
			}
		});
	}
	
}