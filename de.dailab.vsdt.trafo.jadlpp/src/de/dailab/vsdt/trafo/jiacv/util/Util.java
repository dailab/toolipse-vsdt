package de.dailab.vsdt.trafo.jiacv.util;

import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;

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
	 * If the type is a fully qualified complex type, trim the package part.
	 * Import statements are created in the visitPool method.
	 * 
	 * @param property	some Property
	 * @return			simple name of the Property's type
	 */
	public static String getType(Property property) {
		String type = property.getType();
		if (type != null && type.contains(".")) {
			type = type.substring(type.lastIndexOf(".") + 1);
		}
		return type;
	}

	/**
	 * Create an Address String based on the given Message and Participant.
	 * 
	 * @param message		some Message
	 * @return				communication address channel.channel"
	 */
	public static String createAddressString(MessageChannel channel) {
		String address= channel.getChannel() != null ? channel.getChannel().getExpression() : "unknown";
		return address.toLowerCase();
	}
}
