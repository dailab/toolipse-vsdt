/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.diagram.interpreter;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The VSDT Interpreter PlugIn Activator class, providing access to icons.
 */
public final class VsdtInterpreterPlugin extends AbstractUIPlugin {
	
	public static final String PLUGIN_ID= "de.dailab.vsdt.diagram.interpreter";

	public static final String IMAGE_POOL= "Pool.gif";
	public static final String IMAGE_PROPERTY= "Property.gif";
	public static final String IMAGE_SIM_START= "SimStart.gif";
	public static final String IMAGE_SIM_STOP= "SimStop.gif";
	public static final String IMAGE_SIM_STEP_OVER= "SimStepOver.gif";
	public static final String IMAGE_SIM_STEP_INTO= "SimStepInto.gif";
	public static final String IMAGE_SIM_STEP_OUT= "SimStepOut.gif";
	public static final String IMAGE_SIM_READY= "SimReady.gif";
	public static final String IMAGE_SIM_ACTIVE_WAITING= "SimActiveWaiting.gif";
	public static final String IMAGE_SIM_ACTIVE_READY= "SimActiveReady.gif";
	public static final String IMAGE_SIM_INTER= "SimInter.gif";
	public static final String IMAGE_SIM_IDLE= "SimIdle.gif";
	public static final String IMAGE_SIM_DONE= "SimDone.gif";
	public static final String IMAGE_SIM_FAILED= "SimFailed.gif";
	public static final String IMAGE_SIM_TOKEN= "SimToken.gif";
	
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
