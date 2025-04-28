package de.dailab.common.swt.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.ui.ISelectionListener;

/**
 * Extending the AbstractContentProvides with some convenience methods for
 * displaying hierarchies of EObject in a tree structured view.
 * 
 * @author kuester
 */
public abstract class AbstractTreeContentProvider extends AbstractContentProvider implements ITreeContentProvider, ISelectionListener {

	public Object getParent(Object element) {
		if (element instanceof EObject) {
			return ((EObject)element).eContainer();
		}
		return null;
	}
	
	public boolean hasChildren(Object element) {
		return getChildren(element).length > 0;
	}
	
}