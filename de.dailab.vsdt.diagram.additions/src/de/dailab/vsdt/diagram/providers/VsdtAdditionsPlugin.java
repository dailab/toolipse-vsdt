/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.diagram.providers;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The VSDT Additions PlugIn, providing access to icons.
 */
public final class VsdtAdditionsPlugin extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID= "de.dailab.vsdt.diagram.additions";
	
	// action icons
	public static final String IMAGE_OPEN= "Open.gif";
	public static final String IMAGE_IMPORT= "Import.gif";
	public static final String IMAGE_STRUCTURIZE= "Structurize.gif";
	public static final String IMAGE_EXPANDALL= "ExpandAll.gif";
	public static final String IMAGE_COLLAPSEALL= "CollapseAll.gif";
	
	// data icons
	public static final String IMAGE_PROPERTY= "Property.gif";
	public static final String IMAGE_WSDL= "WebService.gif";
	public static final String IMAGE_MESSAGE= "Message.gif";
	public static final String IMAGE_PART= "Property.gif";
	public static final String IMAGE_PORTTYPE= "PortType.gif";
	public static final String IMAGE_OPERATION= "Operation.gif";
	public static final String IMAGE_INPUT= "Input.gif";
	public static final String IMAGE_OUTPUT= "Output.gif";
	public static final String IMAGE_FAULT= "Fault.gif";
	
	// node icons
	public static final String IMAGE_ACTIVITY= "Activity.gif";
	public static final String IMAGE_EMBEDDED= "EmbeddedSubprocessAttSet.gif";
	public static final String IMAGE_START= "Start.gif";
	public static final String IMAGE_INTERMEDIATE= "Intermediate.gif";
	public static final String IMAGE_END= "End.gif";
	public static final String IMAGE_GATEWAY= "Gateway.gif";
	public static final String IMAGE_POOL= "Pool.gif";
	
	// structure icons
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
	 * passed as a parameter but only the image name. It is recommended to use one
	 * of the existing static IMAGE_* fields to access the images.
	 * 
	 * @param fileName	name of some image file
	 * @return			image descriptor for the given image
	 */
	public static ImageDescriptor getImageDescriptor(String fileName) {
		return imageDescriptorFromPlugin(PLUGIN_ID, "icons/" + fileName);
	}
	
}
