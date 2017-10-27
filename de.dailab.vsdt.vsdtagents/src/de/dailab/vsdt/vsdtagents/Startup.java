package de.dailab.vsdt.vsdtagents;

import org.eclipse.ui.IStartup;

/**
 * Early startup so that the VSDT integration agents are available when
 * SSM tries to push services into VSDT, preventing a lot of nasty
 * exception that typically occurr right in the middle of a demonstration.
 *
 * @author kuester
 */
public class Startup implements IStartup {

	@Override
	public void earlyStartup() {
		System.out.println("Auto-starting VSDT agents for SSM integration. "
				+ "If you do not want this to happen at start up, go to "
				+ "Preferences -> General -> Startup and deactivate it.");
	}
	
}
