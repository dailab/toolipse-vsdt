package de.dailab.vsdt.util;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.vxl.Accessor;
import de.dailab.vsdt.vxl.ArrayAccessor;
import de.dailab.vsdt.vxl.Atom;
import de.dailab.vsdt.vxl.BooleanConst;
import de.dailab.vsdt.vxl.BracketTerm;
import de.dailab.vsdt.vxl.FieldAccessor;
import de.dailab.vsdt.vxl.Head;
import de.dailab.vsdt.vxl.Negation;
import de.dailab.vsdt.vxl.NullConst;
import de.dailab.vsdt.vxl.NumericConst;
import de.dailab.vsdt.vxl.Operator;
import de.dailab.vsdt.vxl.StringConst;
import de.dailab.vsdt.vxl.Tail;
import de.dailab.vsdt.vxl.Term;
import de.dailab.vsdt.vxl.Value;
import de.dailab.vsdt.vxl.Variable;
import de.dailab.vsdt.vxl.util.Util;
import de.dailab.vsdt.vxl.util.VxlParseException;
import de.dailab.vsdt.vxl.util.VxlParser;

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
		if (expression == null) return null;
		
		this.buffer= new StringBuffer();
		this.expression= expression;
		this.errorMessage= null;
		this.visibleProperties= null;
		
		// translate expression?
		String originalExpression= expression.getExpression();
		String lang= expression.getExpressionLanguageToBeUsed();
		if (translateExpressions && Util.languageIsVxl(lang)) {
			// parse expression
			VxlParser parser= VxlParser.getInstance();
			try {
				// parse the term
				Term term= parser.parse(originalExpression);
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
	
	// TERM SERIALIZATION
	
	/**
	 * Term:			head = Head (tail = Tail)?;
	 */
	protected void visit(Term term) {
		visit(term.getHead());
		if (term.getTail() != null) {
			buffer.append(" ");
			visit(term.getTail());
		}
	}

	/**
	 * Head:			BracketTerm | Negation | Atom;
	 */
	protected void visit(Head head) {
		if (head instanceof BracketTerm) {
			visit((BracketTerm) head);
		}
		if (head instanceof Negation) {
			visit((Negation) head);
		}
		if (head instanceof Atom) {
			visit((Atom) head);
		}
	}

	/**
	 * Tail:			operator = Operator term = Term;
	 */
	protected void visit(Tail tail) {
		visit(tail.getOperator());
		buffer.append(" ");
		visit(tail.getTerm());
	}

	/**
	 * BracketTerm:		"(" term = Term ")";
	 */
	protected void visit(BracketTerm bracketTerm) {
		buffer.append(" (");
		visit(bracketTerm.getTerm());
		buffer.append(") ");
	}
	
	/**
	 * Negation:		"!" term = Term;
	 */
	protected void visit(Negation negation) {
		buffer.append("! ");
		visit(negation.getTerm());
	}

	/**
	 * Atom:			Variable | Value;
	 */
	protected void visit(Atom atom) {
		if (atom instanceof Variable) {
			visit((Variable) atom);
		}
		if (atom instanceof Value) {
			visit((Value) atom);
		}
	}

	/**
	 * Variable:		"$" name = ID (accessor = Accessor)?;
	 */
	protected void visit(Variable variable) {
		buffer.append("$");
		buffer.append(variable.getName());
		if (variable.getAccessor() != null) {
			visit(variable.getAccessor());
		}
	}
	
	/**
	 * Accessor:		ArrayAccessor | FieldAccessor;
	 */
	protected void visit(Accessor accessor) {
		if (accessor instanceof ArrayAccessor) {
			visit((ArrayAccessor) accessor);
		}
		if (accessor instanceof FieldAccessor) {
			visit((FieldAccessor) accessor);
		}
	}

	/**
	 * ArrayAccessor:	"[" index = Term "]" (accessor = Accessor)?;
	 */
	protected void visit(ArrayAccessor accessor) {
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
	protected void visit(FieldAccessor accessor) {
		buffer.append(".");
		buffer.append(accessor.getName());
		if (accessor.getAccessor() != null) {
			visit(accessor.getAccessor());
		}
	}

	/**
	 * Value:			StringConst | BooleanConst | NumericConst | Null;
	 */
	protected void visit(Value value) {
		if (value instanceof StringConst) {
			visit((StringConst) value);
		}
		if (value instanceof BooleanConst) {
			visit((BooleanConst) value);
		}
		if (value instanceof NumericConst) {
			visit((NumericConst) value);
		}
		if (value instanceof NullConst) {
			visit((NullConst) value);
		}
	}
	
	/**
	 * StringConst:		const = STRING;
	 */
	protected void visit(StringConst stringConst) {
		buffer.append("\"");
		buffer.append(stringConst.getConst());
		buffer.append("\"");
	}

	/**
	 * BooleanConst:	isTrue ?= "true" | "false";
	 */
	protected void visit(BooleanConst booleanConst) {
		buffer.append(booleanConst.isIsTrue() ? "true" : "false");
	}
	
	/**
	 * Null:			"null";
	 */
	protected void visit(NullConst nll) {
		buffer.append("null");
	}

	/**
	 * NumericConst:	const = Numeric;
	 */
	protected void visit(NumericConst numericConst) {
		buffer.append(numericConst.getConst());
	}

	/**
	 * Enum Operator : 
	 * 	LT = "<" | LE = "<=" | EQ = "=" | NEQ = "!=" | GT = ">" | GE = ">=" |
	 * 	ADD = "+" | SUB = "-" | MULT = "*" | DIV = "/" | MOD = "%" |
	 * 	AND = "and" | OR = "or" |
	 * 	CONCAT = "++"; 	
	 */
	protected void visit(Operator operator) {
		switch (operator) {
		case LT:
			buffer.append("<");
			break;
		case LE:
			buffer.append("<=");
			break;
		case EQ:
			buffer.append("==");
			break;
		case NEQ:
			buffer.append("!=");
			break;
		case GT:
			buffer.append(">");
			break;
		case GE:
			buffer.append(">=");
			break;
		case ADD:
			buffer.append("+");
			break;
		case SUB:
			buffer.append("-");
			break;
		case MULT:
			buffer.append("*");
			break;
		case DIV:
			buffer.append("/");
			break;
		case MOD:
			buffer.append("%");
			break;
		case AND:
			buffer.append("&&");
			break;
		case OR:
			buffer.append("||");
			break;
		case CONCAT:
			buffer.append("++");
			break;
		}
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
