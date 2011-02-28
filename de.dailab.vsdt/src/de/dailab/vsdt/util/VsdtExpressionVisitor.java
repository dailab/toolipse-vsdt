package de.dailab.vsdt.util;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.vxl.util.Util;
import de.dailab.vsdt.vxl.util.VxlParseException;
import de.dailab.vsdt.vxl.util.VxlParser;
import de.dailab.vsdt.vxl.vxl.VxlAccessor;
import de.dailab.vsdt.vxl.vxl.VxlArrayAccessor;
import de.dailab.vsdt.vxl.vxl.VxlAtom;
import de.dailab.vsdt.vxl.vxl.VxlBooleanConst;
import de.dailab.vsdt.vxl.vxl.VxlBracketTerm;
import de.dailab.vsdt.vxl.vxl.VxlFieldAccessor;
import de.dailab.vsdt.vxl.vxl.VxlHead;
import de.dailab.vsdt.vxl.vxl.VxlList;
import de.dailab.vsdt.vxl.vxl.VxlListElement;
import de.dailab.vsdt.vxl.vxl.VxlMinus;
import de.dailab.vsdt.vxl.vxl.VxlNegation;
import de.dailab.vsdt.vxl.vxl.VxlNullConst;
import de.dailab.vsdt.vxl.vxl.VxlNumericConst;
import de.dailab.vsdt.vxl.vxl.VxlOperator;
import de.dailab.vsdt.vxl.vxl.VxlStringConst;
import de.dailab.vsdt.vxl.vxl.VxlTail;
import de.dailab.vsdt.vxl.vxl.VxlTerm;
import de.dailab.vsdt.vxl.vxl.VxlValue;
import de.dailab.vsdt.vxl.vxl.VxlVariable;

/**
 * This class is used for printing out Terms in the "VSDT Expression Language".
 * Further, when extended it can be used for translating these Terms to another
 * language, e.g. BPEL's XPath, so they can be used in the target language of
 * virtually any transformation. For that purpose the respective visit methods
 * have to be overwritten, appending different code to the string buffer.  
 * 
 * However, only Expressions with (inherited) language being 'VSDT Expression 
 * Language' or 'VXL' will be translated, so the user still has the possibility 
 * to use another language in case the generic syntax does not have the expressive 
 * power that's needed.
 * 
 * Alternatively, expressions can also be scanned for variables, which will then 
 * be renamed according to the target language's conventions. For that purpose 
 * the method getFullVarName has to be implemented, which can use the getProperty 
 * method for obtaining the property matching the variable (which can then provide 
 * additional information about its context).
 * 
 * This visitor can not be replaced by the generic version {@link XMIVisitor}.
 * 
 * @author kuester
 */
public class VsdtExpressionVisitor {
	
	/** translate expression (if expression language == VXL) */
	protected boolean translateExpressions;
	
	/** replace variable names for other languages */
	protected boolean replaceVariableNames;
	
	/** This buffer is used for building the serialized form of the Term */
	protected StringBuffer buffer;
	
	/** The Expression to be serialized / translated */
	protected Expression expression;
	
	/** List of Properties being visible in the scope of the Expression's owner */
	private List<Property> visibleProperties;
	
	/** Error message denoting the last Error (e.g. Parse Error, Unsupported Language Feature, etc.) */
	protected String errorMessage;

	/**
	 * Create new Expression Visitor
	 * 
	 * @param translateExpression	Translate Expressions with language == VXL?
	 * @param replaceVariableNames	Otherwise replace Variables?
	 */
	public VsdtExpressionVisitor(boolean translateExpression, boolean replaceVariableNames) {
		this.translateExpressions= translateExpression;
		this.replaceVariableNames= replaceVariableNames;
	}
	
	/**
	 * @return		the last Error message during parsing / translation
	 */
	public String getLastErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * @return		Properties visible in the scope of the current Expression's owner
	 */
	protected List<Property> getVisibleProperties() {
		if (visibleProperties == null) {
			visibleProperties= VsdtHelper.getVisibleProperties(expression);
		}
		return visibleProperties;
	}
	
	/**
	 * Iterate over visible Properties and return the first Property which's name
	 * matches the given variable name
	 * 
	 * @param varName	Name of some variable
	 * @return			Property with equal name in the scope, or null 
	 */
	protected Property getProperty(String varName) {
		if (varName != null) { 
			for (Property property : getVisibleProperties()) {
				if (varName.equals(property.getName())) {
					return property;
				}
			}
		}
		return null;
	}
	
	/**
	 * The expression is parsed and translated, or only the variable names are substituted (if they
	 * can be found). However, the translation is not altered, but the result is only returned.
	 * 
	 * @param expression
	 * @return
	 */
	public final String getTranslation(Expression expression) {
		if (expression == null || expression.getExpression() == null) return null;
		
		this.buffer= new StringBuffer();
		this.expression= expression;
		this.errorMessage= null;
		this.visibleProperties= null;
		
		// translate expression?
		String originalExpression= expression.getExpression();
		String lang= expression.getExpressionLanguageToBeUsed();
		if (translateExpressions && 
				Util.languageIsVxl(lang) &&
				! excludeFromTranslation(expression)) {
			// parse expression
			VxlParser parser= VxlParser.getInstance();
			try {
				// parse the term
				VxlTerm term= parser.parse(originalExpression);
				// serialize the term to the target language
				visit(term);
				return buffer.toString();
			} catch (VxlParseException e) {
				// store error message and return the original expression
//				errorMessage= "Errors occurred when parsing Expression " + originalExpression;
				errorMessage= e.getLocalizedMessage();
			}
		} else if (replaceVariableNames) {
			// substitute variable names?
			return replaceVarNames(originalExpression);
		}
		return originalExpression;
	}
	
	/**
	 * Overwrite this method if you want to exclude some expressions from being
	 * translated.
	 * 
	 * @param expression	some expression
	 * @return				exclude this expression from being translated?
	 */
	protected boolean excludeFromTranslation(Expression expression) {
		return false;
	}
	
	// TERM SERIALIZATION
	
	/**
	 * Term:			head = Head (tail = Tail)?;
	 */
	protected void visit(VxlTerm term) {
		visit(term.getHead());
		if (term.getTail() != null) {
			buffer.append(" ");
			visit(term.getTail());
		}
	}

	/**
	 * Head:			BracketTerm | Negation | Atom;
	 */
	protected void visit(VxlHead head) {
		if (head instanceof VxlBracketTerm) {
			visit((VxlBracketTerm) head);
		}
		if (head instanceof VxlNegation) {
			visit((VxlNegation) head);
		}
		if (head instanceof VxlAtom) {
			visit((VxlAtom) head);
		}
	}

	/**
	 * Tail:			operator = Operator term = Term;
	 */
	protected void visit(VxlTail tail) {
		visit(tail.getOperator());
		buffer.append(" ");
		visit(tail.getTerm());
	}

	/**
	 * BracketTerm:		"(" term = Term ")";
	 */
	protected void visit(VxlBracketTerm bracketTerm) {
		buffer.append(" (");
		visit(bracketTerm.getTerm());
		buffer.append(") ");
	}
	
	/**
	 * Negation:		"!" head = Head;
	 */
	protected void visit(VxlNegation negation) {
		buffer.append("not ");
		visit(negation.getHead());
	}

	/**
	 * Minus:		"-" head= Head;
	 */
	protected void visit(VxlMinus minus) {
		buffer.append("- ");
		visit(minus.getHead());
	}

	
	/**
	 * Atom:			Variable | Value;
	 */
	protected void visit(VxlAtom atom) {
		if (atom instanceof VxlVariable) {
			visit((VxlVariable) atom);
		}
		if (atom instanceof VxlValue) {
			visit((VxlValue) atom);
		}
		if (atom instanceof VxlList) {
			visit((VxlList) atom);
			
		}
	}

	/**
	 * List:			"[" (body = VxlListElement)? "]"; 
	 */
	protected void visit(VxlList list) {
		buffer.append("[");
		if (list.getBody() != null) {
			visit(list.getBody());
		}
		buffer.append("]");
	}
	
	/**
	 * ListElement:		first = VxlTerm ("," rest = VxlListElement)?;
	 */
	protected void visit(VxlListElement listElement) {
		visit(listElement.getFirst());
		if (listElement.getRest() != null) {
			buffer.append(", ");
			visit(listElement.getRest());
		}
	}
	
	/**
	 * Variable:		"$" name = ID (accessor = Accessor)?;
	 */
	protected void visit(VxlVariable variable) {
//		buffer.append("$");
		buffer.append(variable.getName());
		if (variable.getAccessor() != null) {
			visit(variable.getAccessor());
		}
	}
	
	/**
	 * Accessor:		ArrayAccessor | FieldAccessor;
	 */
	protected void visit(VxlAccessor accessor) {
		if (accessor instanceof VxlArrayAccessor) {
			visit((VxlArrayAccessor) accessor);
		}
		if (accessor instanceof VxlFieldAccessor) {
			visit((VxlFieldAccessor) accessor);
		}
	}

	/**
	 * ArrayAccessor:	"[" index = Term "]" (accessor = Accessor)?;
	 */
	protected void visit(VxlArrayAccessor accessor) {
		buffer.append("[");
		visit(accessor.getIndex());
		buffer.append("]");
		if (accessor.getAccessor() != null) {
			visit(accessor.getAccessor());
		}
	}
	
	/**
	 * FieldAccessor:	"." name = ID (accessor = Accessor)?;
	 */
	protected void visit(VxlFieldAccessor accessor) {
		buffer.append(".");
		buffer.append(accessor.getName());
		if (accessor.getAccessor() != null) {
			visit(accessor.getAccessor());
		}
	}

	/**
	 * Value:			StringConst | BooleanConst | NumericConst | Null;
	 */
	protected void visit(VxlValue value) {
		if (value instanceof VxlStringConst) {
			visit((VxlStringConst) value);
		}
		if (value instanceof VxlBooleanConst) {
			visit((VxlBooleanConst) value);
		}
		if (value instanceof VxlNumericConst) {
			visit((VxlNumericConst) value);
		}
		if (value instanceof VxlNullConst) {
			visit((VxlNullConst) value);
		}
	}
	
	/**
	 * StringConst:		const = STRING;
	 */
	protected void visit(VxlStringConst stringConst) {
		buffer.append("\"");
		buffer.append(stringConst.getConst());
		buffer.append("\"");
	}

	/**
	 * BooleanConst:	isTrue ?= "true" | "false";
	 */
	protected void visit(VxlBooleanConst booleanConst) {
		buffer.append(booleanConst.getConst());
	}
	
	/**
	 * Null:			"null";
	 */
	protected void visit(VxlNullConst nll) {
		buffer.append("null");
	}

	/**
	 * NumericConst:	const = Numeric;
	 */
	protected void visit(VxlNumericConst numericConst) {
		buffer.append(numericConst.getConst());
	}

	/**
	 * Enum Operator : 
	 * 	LT = "<" | LE = "<=" | EQ = "=" | NEQ = "!=" | GT = ">" | GE = ">=" |
	 * 	ADD = "+" | SUB = "-" | MULT = "*" | DIV = "/" | MOD = "%" |
	 * 	AND = "and" | OR = "or" |
	 * 	CONCAT = "++"; 	
	 */
	protected void visit(VxlOperator operator) {
		buffer.append(operator.getLiteral());
	}

	// VARIABLE NAME SUBSTITUTION

	/**
	 * Replace all occurrences of variable names in the given expression by a getter
	 * according to the specific mapping.  For being replaced, variables have to be escaped
	 * with a '$'. A query may be included after a '.'. Some samples: $propName , 
	 * $propName.query, ...
	 * This method only finds the property names in expressions and then delegates to
	 * getFullVarName(String,String), so it can be overwritten more easily.
	 * 
	 * @param expression	some expression, e.g. from an assign's "from"
	 * @return				same expression with escaped variable names
	 */
	private final String replaceVarNames(String expression) {
		// Allowed values: $propName , $propName.query
		// Without additional escape-characters and some spaces:
		// \$ \w+ ( . \w+ )? 
		final String regex= "\\$\\w+(\\.\\w+)?";
		if (expression == null) {
			return null;
		}
		Matcher matcher= Pattern.compile(regex).matcher(expression);
		StringBuffer buff= new StringBuffer(expression); // this buffer will hold the new expression
		int startPosition= 0;  // the position from where to look for the next match
		int offset= 0;         // the offset, which is needed to keep the altered expression in synch with with matcher
		
		// Find potential property names based on RegEx
		while (matcher.find(startPosition)) {
			MatchResult result= matcher.toMatchResult();
			String res= result.group();
			res= res.replaceFirst("\\$", "");					// trim leading ${

			String resName= res.replaceFirst("\\.\\w+", "");	// trim query
			String query= (res.indexOf(".") != -1) ? res.substring(res.indexOf(".")+1) : null;
			
			// replace property name with variable part getter
			String varName= getFullVarName(resName, query);
			buff.replace(result.start()+offset, result.end()+offset, varName);
			offset+= varName.length() - result.group().length();
	
			startPosition= result.end();
		}
		return buff.toString();
	}
	
	/**
	 * This method substitutes a property name with a language-specific getter for that property.
	 * 
	 * @param varName	the name of the variable
	 * @param query		a query, of null
	 * @return			language-specific getter for that property
	 */
	protected String getFullVarName(String varName, String query) {
		StringBuffer buffer= new StringBuffer();
		buffer.append("$");
		buffer.append(varName);
		if (query != null) {
			buffer.append(".");
			buffer.append(query);
		}
		return buffer.toString();
	}
	
}
