package de.dailab.vsdt.trafo.jiacv.util;

import de.dailab.jiactng.jadl.Agent;
import de.dailab.jiactng.jadl.Service;

/**
 * Utilities-class for the BPMN to JIAC V /JADL transformation.
 * 
 * @author kuester
 */
public class Util {

	public static final String EXT_JADL=		".jadl";
	public static final String EXT_DROOLS=		".drl";
//	public static final String EXT_XML=			".xml";
	public static final String EXT_AWE_MODEL=	".agentworld";
	public static final String EXT_AWE_DIAGRAM=	".awe";
	public static final String FILE_SEP= System.getProperty("file.separator");
	
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
