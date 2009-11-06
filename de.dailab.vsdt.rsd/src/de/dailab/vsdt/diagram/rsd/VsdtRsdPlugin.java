/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.diagram.rsd;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The Vsdt Rsd View Plugin, providing access to icons.
 */
public final class VsdtRsdPlugin extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID= "de.dailab.vsdt.rsd";
	
	public static final String IMAGE_IMPORT= "import.gif";
	public static final String IMAGE_REFRESH= "refresh.gif";
	public static final String IMAGE_CONNECT= "connect.gif";
	public static final String IMAGE_PROPERTIES= "properties.gif";
	public static final String IMAGE_PERSPECTIVE= "perspective.gif";

	public static final String IMAGE_MESSAGE= "Message.gif";
	public static final String IMAGE_PART= "Part.gif";
	public static final String IMAGE_PORTTYPE= "PortType.gif";
	public static final String IMAGE_OPERATION= "Operation.gif";
	public static final String IMAGE_INPUT= "Input.gif";
	public static final String IMAGE_OUTPUT= "Output.gif";
	public static final String IMAGE_FAULT= "Fault.gif";
	
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
