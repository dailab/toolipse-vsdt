package de.dailab.vsdt.trafo.jiacv.export;

import de.dailab.jiactng.jadl.Agent;
import de.dailab.jiactng.jadl.Service;

/**
 * Utilities-class for the BPMN to JIAC V /JADL transformation.
 * 
 * @author kuester
 */
public class Util {

	/**
	 * @param model		some JADL file model
	 * @return			first service in the file, if any, or null
	 */
	public static Service getFirstService(Agent model) {
		for (Service service : model.getServices()) {
			return service;
		}
		return null;
	}
	
}
