package de.dailab.vsdt.vxl.util;

/**
 * Utility class for VSDT Expression Language related stuff.
 * 
 * @author kuester
 */
public class Util {

	public static final String LANG_NAME= "VSDT Expression Language";
	public static final String LANG_NAME_SHORT= "VXL";
	
	public static final String TYPE_INTEGER= "integer";
	public static final String TYPE_LONG= "long";
	public static final String TYPE_BOOLEAN= "boolean";
	public static final String TYPE_FLOAT= "float";
	public static final String TYPE_DOUBLE= "double";
	public static final String TYPE_STRING= "string";
	
	public static final String[] datatypes= { 
		TYPE_STRING, TYPE_INTEGER, TYPE_LONG, TYPE_FLOAT, TYPE_DOUBLE, TYPE_BOOLEAN
	};

	/**
	 * Check whether the given expression language matches VXL
	 * 
	 * @param expLang	some language name
	 * @return			name matches VXL name(s)?
	 */
	public static boolean languageIsVxl(String expLang) {
		return LANG_NAME.equalsIgnoreCase(expLang) || LANG_NAME_SHORT.equalsIgnoreCase(expLang);
	}
	
	
}
