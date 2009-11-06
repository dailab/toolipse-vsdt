package de.dailab.vsdt.diagram.views.rsd;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.diagram.rsd.IRsdWS;

/**
 * Simple label provider class to be used with the RSD view. This class is taken from
 * the Eclipse View Plugin Example.
 *  
 * @author kuester
 */
public class RsdViewLabelProvider extends LabelProvider implements ITableLabelProvider {
	
	/**
	 * @return	the label which represents the given item in the view
	 */
	public String getColumnText(Object obj, int index) {
		if (obj instanceof IRsdWS) {
			IRsdWS ws = (IRsdWS) obj;
			return new StringBuffer().append(ws.getProviderAdress()).append(":").append(ws.getName()).toString();
		}
		return null;
	}
	
	/**
	 * @return	the icon for the given item to be used in the column
	 */
	public Image getColumnImage(Object obj, int index) {
		return getImage(obj);
	}
	
	/**
	 * @return	the icon for the given item
	 */
	public Image getImage(Object obj) {
		return PlatformUI.getWorkbench().
				getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}
	
}