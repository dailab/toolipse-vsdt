package de.dailab.vsdt.diagram.views.rsd;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IWorkbenchPartSite;

import sun.misc.Compare;
import sun.misc.Sort;
import de.dailab.vsdt.diagram.rsd.IRsdWS;

/**
 * Simple content provider class to be used with the RSD view. This class is taken from
 * the Eclipse View Plugin Example.
 * 
 * @author kuester
 */
public class RsdViewContentProvider implements IStructuredContentProvider {

	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}
	
	/**
	 * this method is called on RsdView.viewer.refresh() and takes the (cached) services
	 * from the client and puts it on the view.
	 */
	public Object[] getElements(Object parent) {
		if (parent instanceof IWorkbenchPartSite) {
			IWorkbenchPartSite site = (IWorkbenchPartSite) parent;
			if (site.getPart() instanceof RsdView) {
				RsdView view = (RsdView) site.getPart();
				List<IRsdWS> services= view.getClient().getCachedServices();
				return sortServices(services);
			}
		}
		return new Object[] { };
	}
	
	private Object[] sortServices(List<IRsdWS> list) {
		Object[] array= list.toArray();
		Sort.quicksort(array, new Compare(){
			public int doCompare(Object o1, Object o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
		return array;
	}
	
}