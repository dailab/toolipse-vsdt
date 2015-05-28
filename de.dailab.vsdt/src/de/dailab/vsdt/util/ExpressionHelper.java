package de.dailab.vsdt.util;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.vxl.util.Util;
import de.dailab.vsdt.vxl.util.VxlInterpreter;
import de.dailab.vsdt.vxl.util.VxlParseException;
import de.dailab.vsdt.vxl.util.VxlParser;
import de.dailab.vsdt.vxl.vxl.VxlTerm;

/**
 * Helper class for evaluating all sorts of expressions.
 *
 * @author kuester
 */
public class ExpressionHelper {


	/*
	 * VXL CONDITION/EXPRESSION EVALUATION HELPER METHODS
	 */
	
	/**
	 * Parse and evaluate a condition.  If the result is a Boolean, return it;
	 * otherwise an error dialog is shown and false is returned.
	 * 
	 * @see #parseAndEvaluate(Expression, Map)
	 * @see #createContext(FlowObject)
	 * @param expression	Some VXL Condition (Expression evaluating to Boolean)
	 * @param context		Map of Property names and values
	 * @return				Result of the evaluation, or false in case of error
	 */
	public static boolean evaluateCondition(Expression expression, Map<String, Serializable> context) {
		if (expression != null) {
			Serializable value= parseAndEvaluate(expression, context);
			if (value instanceof Boolean) {
				return (Boolean) value;
			} else {
				StringBuffer message= new StringBuffer();
				message.append("The condition ").append(expression.getExpression()).append(" does not evaluate to a Boolean value.");
				throw new IllegalArgumentException(message.toString());
			}
		} else {
			throw new IllegalArgumentException("The condition must not be null.");
		}
	}
	
	/**
	 * Parse and Evaluate the Expression using the VXL parser and interpreter.
	 * If there are any errors, they are shown in some dialogs, and the result 
	 * is returned; otherwise return null.
	 * 
	 * @see #createContext(FlowObject)
	 * @param expression	Some VXL Expression (as VSDT Expression object)
	 * @param context		Map of Property names and values
	 * @return				Result of the evaluation, or null in case of error
	 */
	public static Serializable parseAndEvaluate(Expression expression, Map<String, Serializable> context) {
		return parseAndEvaluate(getExpression(expression), context);
	}

	public static Serializable parseAndEvaluate(String expression, Map<String, Serializable> context) {
		return evaluateTerm(parseExpression(expression), context);
	}

	/**
	 * If the Expression is a non-null VSDT Expression with Expression Language
	 * set to VXL, return the Expression string, otherwise return null.
	 * 
	 * @param expression	Some VXL Expression (as VSDT Expression object)
	 * @return				Expression string if non-null VXL Expression, or null
	 */
	public static String getExpression(Expression expression) {
		if (expression == null) return null;
		// check expression language
		String lang= expression.getExpressionLanguageToBeUsed();
		if (Util.languageIsVxl(lang)) {
//			return expression.getExpression();
			return VsdtHelper.getExpressionWithParameters(expression);
		} else {
			throw new IllegalArgumentException("Unsupported Expression Language");
		}
	}
	
	/**
	 * Parse the Expression using the VXL parser and return the resulting Term. 
	 * If there are any errors, this is shown in some dialogs, and null is returned.
	 * 
	 * @param expression	Some VXL Expression (as string)
	 * @return				Result of the parsing, or null in case of error
	 */
	public static VxlTerm parseExpression(String expression) {
		if (expression == null) return null;

		VxlParser parser= VxlParser.getInstance();
		
		try {
			VxlTerm term= parser.parse(expression);
			return term;
		} catch (VxlParseException e) {
			StringBuffer message= new StringBuffer();
			message.append("The expression ").append(expression).append(" could not be parsed.");
			if (! parser.getErrors().isEmpty()) {
				message.append("\r\nErrors:");
				for (Diagnostic d : parser.getErrors()) {
					message.append("\r\n- ").append(d.getMessage());
				}
			}
			throw new IllegalArgumentException(message.toString());
		}
	}
	
	/**
	 * Parse and Evaluate the Expression using the VXL parser and interpreter.
	 * If there are any errors, they are shown in some dialogs, and the result 
	 * is returned; otherwise return null.
	 * 
	 * @see #createContext(FlowObject)
	 * @param expression	Some VXL Term
	 * @param context		Map of Property names and values
	 * @return				Result of the evaluation, or null in case of error
	 */
	public static Serializable evaluateTerm(VxlTerm term, Map<String, Serializable> context) {
		if (term == null) return null;
		VxlInterpreter interpreter= new VxlInterpreter();
		Serializable result= interpreter.evaluateTerm(term, context);
		Map<Object, String> errors= interpreter.getErrors();
		if (! errors.isEmpty()) {
			StringBuffer message= new StringBuffer();
			message.append("Expression could not be evaluated.");
			message.append("\r\nErrors:");
			for (String error : errors.values()) {
				message.append("\r\n- ").append(error);
			}
			throw new IllegalArgumentException(message.toString());
		}
		return result;
	}
	
}
