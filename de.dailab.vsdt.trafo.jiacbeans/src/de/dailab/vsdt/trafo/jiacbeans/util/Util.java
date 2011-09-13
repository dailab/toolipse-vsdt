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
		return toJavaType(type);
	}
	
	/**
	 * convert the given type to be java conform 
	 * @param type
	 * @return
	 */
	public static String toJavaType(String type){
		//TODO complete this
		//check the primitives first
		if(type.equals("integer"))return "int";
		if(type.equals("bool"))return "boolean";
		if(type.equals("double"))return "double";
		//nicht primitiv -> first character to UpperCase
		return type.substring(0, 1).toUpperCase()+type.substring(1);
	}
	
	/**
	 * convert the given name to be java conform 
	 * @param name
	 * @return
	 */
	public static String toJavaName(String name){
		//complete this if needed
		name = name.replaceAll("-", "");
		name = name.replaceAll(":", "");
		return name.substring(0,1).toLowerCase()+name.substring(1);
		
	}
}
