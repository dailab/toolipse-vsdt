package de.dailab.vsdt.vxl.util;

import java.util.HashMap;
import java.util.Map;



/**
 * Utility class for VSDT Expression Language related stuff.
 * 
 * @author kuester
 */
public class Util {

	public static final String LANG_NAME= "VSDT Expression Language";
	public static final String LANG_NAME_SHORT= "VXL";
	
	public static final String LANG_NAME_MVEL= "MVEL";

	public static final String TYPE_INTEGER= "integer";
	public static final String TYPE_LONG= "long";
	public static final String TYPE_BOOLEAN= "boolean";
	public static final String TYPE_FLOAT= "float";
	public static final String TYPE_DOUBLE= "double";
	public static final String TYPE_STRING= "string";
	public static final String TYPE_ANY = "anyType";

	public static final String[] datatypes= { 
		TYPE_STRING, TYPE_INTEGER, TYPE_LONG, TYPE_FLOAT, TYPE_DOUBLE, TYPE_BOOLEAN, TYPE_ANY
	};

	@SuppressWarnings("serial")
	private static Map<String, String> basicDataTypeMap = new HashMap<String, String>() {{
		put(Util.TYPE_INTEGER, Integer.class.getCanonicalName());
		put(Util.TYPE_BOOLEAN, Boolean.class.getCanonicalName());
		put(Util.TYPE_STRING,  String.class.getCanonicalName());
		put(Util.TYPE_FLOAT,   Float.class.getCanonicalName());
		put(Util.TYPE_DOUBLE,  Double.class.getCanonicalName());
		put(Util.TYPE_LONG,    Long.class.getCanonicalName());
		put(Util.TYPE_ANY,     Object.class.getCanonicalName());
	}};
	
	/**
	 * Find substitute for basic 'VXL' data types, like integer, boolean, etc.
	 * 
	 * @param property	some property's type
	 * @return			substitute data type, if primitive, or actual data type
	 */
	public static String getProperType(String basicType) {
		return basicDataTypeMap.containsKey(basicType) ? 
				basicDataTypeMap.get(basicType) : basicType;
	}
	
	/**
	 * Check whether the given expression language matches VXL
	 * 
	 * @param expLang	some language name
	 * @return			name matches VXL name(s)?
	 */
	public static boolean languageIsVxl(String expLang) {
		return LANG_NAME.equalsIgnoreCase(expLang) || LANG_NAME_SHORT.equalsIgnoreCase(expLang);
	}
	
	/**
	 * Check whether the given expression language matches MVEL
	 */
	public static boolean languageIsMvel(String expLang) {
		return LANG_NAME_MVEL.equalsIgnoreCase(expLang);
	}

	public static int asInteger(Number number) {
		if (number instanceof Double) {
			double d= (Double) number;
			return (int) d;
		}
		if (number instanceof Integer) {
			return (Integer) number;
		}
		return 0;
	}
	
}
