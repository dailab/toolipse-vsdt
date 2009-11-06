package de.dailab.vsdt.diagram.views.pools;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;

import de.dailab.common.gmf.ui.views.AbstractLabelProvider;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.diagram.views.VsdtViewsPlugin;

/**
 * This class is used to provide the Labels used in the Pool Visibility View
 * 
 * @author kuester
 */
public class PoolVisibilityViewLabelProvider extends AbstractLabelProvider {

	protected ImageDescriptor getImageDescriptor(Object element) {
		ImageDescriptor descriptor= null;
		EObject actualElement= getActualElement(element);
		if (actualElement instanceof Pool) {
		   descriptor= VsdtViewsPlugin.getImageDescriptor(VsdtViewsPlugin.IMAGE_POOL);
		}
		return descriptor;
	}
	
	public String getText(Object element) {
		StringBuffer buffer= new StringBuffer();
		EObject actualElement= getActualElement(element);
		if (actualElement instanceof Pool) {
			Pool pool= (Pool) actualElement;
			buffer.append(pool.getName());
		}
		if (buffer.toString().isEmpty()) {
			if (actualElement instanceof EObject) {
				String name= EMFCoreUtil.getName((EObject) actualElement);
				if (name != null) {
					buffer.append(name);
				}
			}
		}
		return buffer.toString();
	}
	
}