/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The VSDT Structure View PlugIn Activator class, providing access to icons.
 */
public final class VsdtStructureViewPlugin extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID= "de.dailab.vsdt.trafo.strucbpmn.view";

	public static final String IMAGE_STRUCTURIZE= "Structurize.gif";
	public static final String IMAGE_EXPANDALL= "ExpandAll.gif";
	public static final String IMAGE_COLLAPSEALL= "CollapseAll.gif";
	
	public static final String IMAGE_ACTIVITY= "Activity.gif";
	public static final String IMAGE_EMBEDDED= "EmbeddedSubprocessAttSet.gif";
	public static final String IMAGE_START= "Start.gif";
	public static final String IMAGE_INTERMEDIATE= "Intermediate.gif";
	public static final String IMAGE_END= "End.gif";
	public static final String IMAGE_GATEWAY= "Gateway.gif";
	public static final String IMAGE_POOL= "Pool.gif";
	
	public static final String IMAGE_SEQUENCE= "Sequence.gif";
	public static final String IMAGE_BLOCK= "Block.gif";
	public static final String IMAGE_BRANCH= "Branch.gif";
	public static final String IMAGE_LOOP= "Loop.gif";
	public static final String IMAGE_EHBLOCK= "EHBlock.gif";
	public static final String IMAGE_EHCASE= "EHCase.gif";
	public static final String IMAGE_SKIP= "Skip.gif";
	public static final String IMAGE_DERIVED= "Derived.gif";
	
	/**
	 * get an image from the icons/ directory. The directory name must not be
	 * passed as a parameter but only the image name. It is recommended to use 
	 * one of the existing static IMAGE_* fields to access the images.
	 * 
	 * @param fileName	name of some image file
	 * @return			image descriptor for the given image
	 */
	public static ImageDescriptor getImageDescriptor(String fileName) {
		return imageDescriptorFromPlugin(PLUGIN_ID, "icons/" + fileName);
	}
	
}
