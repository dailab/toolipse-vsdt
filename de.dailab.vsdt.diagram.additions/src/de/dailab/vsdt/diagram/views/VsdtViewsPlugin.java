/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.diagram.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The VSDT Views PlugIn, providing access to icons.
 */
public final class VsdtViewsPlugin extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID= "de.dailab.vsdt.diagram.views";
	
	public static final String IMAGE_OPEN= "Open.gif";
	public static final String IMAGE_IMPORT= "Import.gif";
	
	public static final String IMAGE_POOL= "Pool.gif";
	
	public static final String IMAGE_PROPERTY= "Property.gif";
	public static final String IMAGE_WSDL= "WebService.gif";
	public static final String IMAGE_MESSAGE= "Message.gif";
	public static final String IMAGE_PART= "Property.gif";
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
