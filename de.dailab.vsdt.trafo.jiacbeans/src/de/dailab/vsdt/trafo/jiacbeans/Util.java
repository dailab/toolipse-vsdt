package de.dailab.vsdt.trafo.jiacbeans;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;

import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;

/**
 * Utilities-class for the BPMN to JiacBeans/JAVA transformation.
 * 
 * @author kuester
 *
 */
public class Util {
	
	public static final String NL = System.getProperty("line.separator");
	
	/**
	 * Takes an expression (null, Expression, or DisjunctiveExpression) and returns
	 * the wrapped expressions. In case of a disjunctiveCondition the several
	 * conditions are concatenated with 'or'.
	 * 
	 * @param		expression some (Struc)BPMN Expression
	 * @return		expression(s) wrapped in the Expression
	 */
	public static String getCondition(de.dailab.vsdt.Expression expression) {
		if (expression == null) {
			return null;
		}
		if (expression instanceof DisjunctiveExpression) {
			DisjunctiveExpression disjunctive = (DisjunctiveExpression) expression;
			StringBuffer buff= new StringBuffer();
			for (int i = 0; i < disjunctive.getExpressions().size(); i++) {
				if (i > 0) {
					buff.append(" || ");
				}
				buff.append("( ");
				buff.append(disjunctive.getExpressions().get(i));
				buff.append(" )");
			}
			return buff.toString();
		} else {
			return expression.getExpression();
		}
	}
	
	public static String toJavaName(String s, boolean upperInital) {
		// replace whitespaces and special characters
		s = s.replaceAll("\\s+", "_");	// whitespace(s) -> underscore
		s = s.replaceAll("\\W", "");	// special -> nothing
			
		// make title case
		StringBuilder sb = new StringBuilder();
		boolean toUpper = upperInital;
		for (char c : s.toCharArray()) {
			if (c == '_') {
				toUpper = true;
			} else {
				sb.append(toUpper ? Character.toUpperCase(c) : c);
				toUpper = false;
			}
		}
		return sb.toString();
	}
	
	/**
	 * Increase indentation of given string by one tab
	 * 
	 * @param string	some string
	 * @return			same string with one tab more per line
	 */
	public static String indent(String string) {
		BufferedReader br = new BufferedReader(new StringReader(string));
		try {
			StringBuffer buffer = new StringBuffer();
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				if (! line.isEmpty()) {
					buffer.append("\t").append(line).append(NL);
				}
			}
			return buffer.toString();
		} catch (IOException e) {
			return null;
		}
	}
	
	/**
	 * Join a number of objects to a string using a given delimiter string and 
	 * the objects' toString method.
	 * 
	 * @param objects		objects to join
	 * @param delimiter		delimiter to be inserted between two objects
	 * @return
	 */
	public static <T> String join(Collection<T> objects, String delimiter, ObjToStrFunction<T> f) {
		StringBuffer buffer = new StringBuffer();
		if (objects != null) {
			for (T object: objects) {
				if (buffer.length() > 0) {
					buffer.append(delimiter);
				}
				if (f == null) {
					buffer.append(String.valueOf(object));
				} else {
					buffer.append(f.toString(object));
				}
			}
		}
		return buffer.toString();
	}
	
	/**
	 * I want functional programming...
	 */
	public static abstract class ObjToStrFunction<T> {
		
		public abstract String toString(T o);
		
	}
	
}
