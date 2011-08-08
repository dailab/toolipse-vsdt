package de.dailab.vsdt.trafo.jiacbeans.util;

import de.dailab.vsdt.Property;

/**
 * Utilities-class for the BPMN to JiacBeans/JAVA transformation.
 * 
 * @author Petrus Setiawan Tan
 *
 */
public class Util {
	
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
}
