package de.dailab.vsdt.diagram.navigator;

import org.eclipse.jface.viewers.ViewerSorter;

import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;

/**
 * @generated
 */
public class VsdtNavigatorSorter extends ViewerSorter {

	/**
	 * @generated
	 */
	private static final int GROUP_CATEGORY = 5005;

	/**
	 * @generated
	 */
	public int category(Object element) {
		if (element instanceof VsdtNavigatorItem) {
			VsdtNavigatorItem item = (VsdtNavigatorItem) element;
			return VsdtVisualIDRegistry.getVisualID(item.getView());
		}
		return GROUP_CATEGORY;
	}

}
