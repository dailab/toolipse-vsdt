package de.dailab.common.swt.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;


/**
 * Abstract superclass to be used as a ContentProvider in various view. This 
 * class provides some means of input and selection management.
 * 
 * @author kuester
 */
public abstract class AbstractContentProvider implements IStructuredContentProvider, ISelectionListener {

	protected Viewer viewer= null;
	
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (viewer != null) {
			viewer.refresh();
		}
	}

	/**
	 * This method is called once after the input of the viewer is set via 
	 * setInput, and once after the view is closed
	 */
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		this.viewer= v;
		if (newInput instanceof ISelectionService) {
			ISelectionService selectionService = (ISelectionService) newInput;
			selectionService.addSelectionListener(this);
		}
		if (oldInput instanceof ISelectionService) {
			ISelectionService selectionService= (ISelectionService) oldInput;
			selectionService.removeSelectionListener(this);
		}
	}
	
	public void dispose() {
		if (viewer != null) {
			if (viewer.getInput() instanceof ISelectionService) {
				((ISelectionService) viewer.getInput()).removeSelectionListener(this);
			}
		}
	}
	
}