package de.dailab.vsdt.vsdtagents;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.dailab.jiactng.nodeplugin.JiacNodePlugin;
import de.dailab.vsdt.vsdtagents.deployment.DeploymentBean;
import de.dailab.vsdt.vsdtagents.interpreter.VsdtInterpreterBean;
import de.dailab.vsdt.vsdtagents.processenginebean.ProcessEngineBeanBean;
import de.dailab.vsdt.vsdtagents.sema.SemaIntegrationAgentBean;

/**
 * The activator class controls the plug-in life cycle. When the plug-in is
 * started, VSDT-specific agents are put on the JIAC Node.
 */
public class VsdtAgents extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "de.dailab.vsdt.vsdtagents";

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		
		new Thread(new Runnable() {
			public void run() {
				JiacNodePlugin nodePlugin = JiacNodePlugin.getDefault();
				nodePlugin.addAgent("DeploymentAgent", 0, new DeploymentBean());
				nodePlugin.addAgent("InterpreterAgent", 0, new VsdtInterpreterBean());
				nodePlugin.addAgent("SemaVSDTIntegrationAgent", 0, new SemaIntegrationAgentBean());
				nodePlugin.addAgent("ProcessEngineBeanAgent", 0, new ProcessEngineBeanBean());
			}
		}).start();
	}

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
