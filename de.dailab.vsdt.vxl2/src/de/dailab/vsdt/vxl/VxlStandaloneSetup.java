
package de.dailab.vsdt.vxl;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class VxlStandaloneSetup extends VxlStandaloneSetupGenerated{

	public static void doSetup() {
		new VxlStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

