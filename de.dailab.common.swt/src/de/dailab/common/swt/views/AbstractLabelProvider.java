package de.dailab.common.swt.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.swt.ImageLoader;

/**
 * This class can be used to provide the labels and images used in the various
 * views.  It provides some convenience methods, especially for efficient
 * management of images.
 * 
 * @author kuester
 */
public abstract class AbstractLabelProvider extends LabelProvider {
	
	@Override
	public Image getImage(Object element) {
		// get image descriptor
		ImageDescriptor descriptor= getImageDescriptor(element);
		if (descriptor == null) {
			descriptor= PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT);
		}
	   //obtain the cached image corresponding to the descriptor
	   return ImageLoader.getInstance().getImage(descriptor);
	}
	
	protected abstract ImageDescriptor getImageDescriptor(Object element);
	
//	protected EObject getSemanticElement(Object element) {
//		if (element instanceof EObject) {
//			return (EObject) element;
//		} else { 
//			System.err.println(element.getClass().getName());
//			return null;
//		}
//	}

}