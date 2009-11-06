package de.dailab.vsdt.trafo.jiacv.export;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.dailab.jiactng.jadl.Agent;
import de.dailab.jiactng.jadl.Assign;
import de.dailab.jiactng.jadl.BoolConst;
import de.dailab.jiactng.jadl.ComplexType;
import de.dailab.jiactng.jadl.DataType;
import de.dailab.jiactng.jadl.Expression;
import de.dailab.jiactng.jadl.FloatConst;
import de.dailab.jiactng.jadl.HeaderVariableDeclaration;
import de.dailab.jiactng.jadl.IntegerConst;
import de.dailab.jiactng.jadl.OntologyName;
import de.dailab.jiactng.jadl.Print;
import de.dailab.jiactng.jadl.Receive;
import de.dailab.jiactng.jadl.Script;
import de.dailab.jiactng.jadl.Send;
import de.dailab.jiactng.jadl.Seq;
import de.dailab.jiactng.jadl.Service;
import de.dailab.jiactng.jadl.StringConst;
import de.dailab.jiactng.jadl.Type;
import de.dailab.jiactng.jadl.Value;
import de.dailab.jiactng.jadl.Variable;
import de.dailab.jiactng.jadl.VariableDeclaration;
import de.dailab.jiactng.jadl.While;
import de.dailab.jiactng.jadl.ontology.JadlParseException;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;

/**
 * This class is holding all kinds of simple creation and parsing methods
 * 
 * @author kuester
 */
public class JadlElementFactory implements Bpmn2JiacConstants {
	
	public static final JadlElementFactory INSTANCE= new JadlElementFactory();
	
	private JadlElementFactory() {
	}
	
	/*
	 * /////////////////////////////////////
	 * //// CREATION METHODS
	 * /////////////////////////////////////7
	 */

	/**
	 * Create new Print object
	 * 
	 * @param message	the message to print
	 * @return			new Print element, printing the given message
	 */
	public Print createPrint(String message) {
		Print print= jadlFac.createPrint();
		print.setExpression(createExpression(message));
		return print;
	}

	/**
	 * Create new Variable Declaration object.
	 * 
	 * XXX keep this up to date with the language syntax
	 * 
	 * @param varName		the name of the variable to be created
	 * @param typeString	the type of the variable to be created
	 * @return				new variable declaration object
	 */
	public VariableDeclaration createVariableDeclaration(String varName, String typeString) {
		VariableDeclaration declaration= jadlFac.createVariableDeclaration();
		declaration.setVariable(createVariableName(varName));
		String actualType= typeString;

		// test whether this is an array declaration
		final String regex= "\\w+\\[\\d*\\]";
		Matcher matcher= Pattern.compile(regex).matcher(typeString);
		if (matcher.matches()) {
			// array declaration
			declaration.setArray(true);
			int i= typeString.indexOf("[");
			int j= typeString.indexOf("]");
			String num= typeString.substring(i+1,j);
			if (! num.isEmpty()) {
				declaration.setArraySize(createExpression(num));
			}
			actualType= typeString.substring(0,i);
		}
		declaration.setVariableType(createType(actualType));
		return declaration;
	}
	
	/**
	 * Create a List of Header Variable Declarations from a List of Properties
	 * 
	 * @param properties	List of Properties, e.g. from a Message
	 * @return				List of HeaderVariableDeclarations 
	 */
	public List<HeaderVariableDeclaration> createHeaderVariableDeclarations(List<Property> properties) {
		List<HeaderVariableDeclaration> declarations= new ArrayList<HeaderVariableDeclaration>();
		if (properties != null) {
			for (Property property : properties) {
				HeaderVariableDeclaration declaration= createHeaderVariableDeclaration(property.getName(), property.getType());
				if (declaration != null) {
					declarations.add(declaration);
				}
			}
		}
		return declarations;
	}
	
	/**
	 * Create new Header Variable Declaration object.
	 * 
	 * @param varName		the name of the variable to be created
	 * @param typeString	the type of the variable to be created
	 * @return				new header variable declaration object
	 */
	public HeaderVariableDeclaration createHeaderVariableDeclaration(String varName, String typeString) {
		HeaderVariableDeclaration declaration= jadlFac.createHeaderVariableDeclaration();
		declaration.setVariableName(createVariable(varName).getName());
		String actualType= typeString;

		// test whether this is an array declaration
		final String regex= "\\w+\\[\\d*\\]";
		Matcher matcher= Pattern.compile(regex).matcher(typeString);
		if (matcher.matches()) {
			// array declaration
			declaration.setArray(true);
			int i= typeString.indexOf("[");
			actualType= typeString.substring(0,i);
		}
		declaration.setVariableType(createType(actualType));
		return declaration;
	}
	
	/**
	 * Create a type object according to the given type string
	 * @param typeString	some string, e.g. "string" or "MyClass"
	 * @return				Type object according to the string
	 */
	public Type createType(String typeString) {
		Type type= jadlFac.createType();
		DataType simpleType= null;
		// test for simple types
		if (TYPE_BOOL.equals(typeString)) {
			simpleType= DataType.BOOL_TYPE;
		}
		if (TYPE_BYTE.equals(typeString)) {
			simpleType= DataType.BYTE_TYPE;
		}
		if (TYPE_DOUBLE.equals(typeString)) {
			simpleType= DataType.DOUBLE_TYPE;
		}
		if (TYPE_FLOAT.equals(typeString)) {
			simpleType= DataType.FLOAT_TYPE;
		}
		if (TYPE_INT.equals(typeString)) {
			simpleType= DataType.INT_TYPE;
		}
		if (TYPE_LONG.equals(typeString)) {
			simpleType= DataType.LONG_TYPE;
		}
		if (TYPE_SHORT.equals(typeString)) {
			simpleType= DataType.SHORT_TYPE;
		}
		if (TYPE_STRING.equals(typeString)) {
			simpleType= DataType.STRING_TYPE;
		}
		if (TYPE_URL.equals(typeString)) {
			simpleType= DataType.URL_TYPE;
		}
		if (simpleType != null) {
			type.setSimpleType(simpleType);
		} else {
			OntologyName ontoName= jadlFac.createOntologyName();
			ontoName.setName(typeString);
			ComplexType complexType= jadlFac.createComplexType();
			complexType.setOntology(ontoName);
			type.setComplexType(complexType);
		}
		return type;
	}

	/**
	 * Create a new assign element.
	 * 
	 * @param from			the from-expression to be parsed
	 * @param toVarName		the name of the variable name to bind the expression to
	 * @param toQuery		an optional query (i.e. property or array index) or null
	 * @return
	 */
	public Assign createAssign(String from, String toVarName, String toQuery) {
		Assign assign= jadlFac.createAssign();
		Expression value= parseExpression(from);
		assign.setValue(value);
		Variable var= createVariable(toVarName);
		assign.setVariable(var);
		if (toQuery != null) {
			// try to parse as array index, if this fails interpret as complex property
			try {
				int index= Integer.parseInt(toQuery);
				var.setArray(true);
				var.setIndex(createExpression(index));
			} catch (NumberFormatException e) {
				de.dailab.jiactng.jadl.Property property= jadlFac.createProperty();
				property.setName(toQuery);
				var.setComplex(true);
				var.setProperty(property);	
			}
		}
		return assign;
	}
	
	/**
	 * Create Send element
	 * 
	 * @param address	where to send the message
	 * @param message	payload of the message
	 * @return			newly created Send element
	 */
	public Send createSend(String address, Property message) {
		Send send= jadlFac.createSend();
		send.setAddress(createExpression(address));
		send.setMessage(createVariable(message.getName()));
		return send;
	}
	
	/**
	 * Create Receive element
	 * 
	 * @param timeout	timeout in milli seconds
	 * @param address	address where to listen for new message
	 * @param type		expected type of message payload
	 * @param variable	variable to bind the received value to
	 * @return			newly created Receive element
	 */
	public Receive createReceive(int timeout, String address, String type, String variable) {
		Receive receive= jadlFac.createReceive();
		receive.setTimeout(createExpression(timeout));
		receive.setAddress(createExpression(address));
//		receive.setType(createType(type));
		receive.setVariable(createVariableName(variable));
		return receive;
	}
	
	/**
	 * Create a simple constant expression wrapping a number, boolean or string.
	 * 
	 * @param object	some number, boolean or string
	 * @return			expression wrapping the given object, or null
	 */
	public Expression createExpression(Object object) {
		Value v= null;
		if (object instanceof Integer) {
			v= jadlFac.createIntegerConst();
			((IntegerConst) v).setConst(String.valueOf(object));
		}
		if (object instanceof Double) {
			v= jadlFac.createFloatConst();
			((FloatConst) v).setConst(String.valueOf(object));
		}
		if (object instanceof String) {
			v= jadlFac.createStringConst();
			((StringConst) v).setConst(String.valueOf(object));
		}
		if (object instanceof Boolean) {
			v= jadlFac.createBoolConst();
			((BoolConst) v).setConst(String.valueOf(object));
		}
		if (v != null) {
			Expression expression= jadlFac.createExpression();
			expression.setHeadTerm(v);
			return expression;
		}
		return null;
	}
	
	/**
	 * just creates and returns a new variable object with the given name
	 * 
	 * @param name	name of the variable
	 * @return		the variable
	 */
	public Variable createVariable(String name) {
		Variable variable= jadlFac.createVariable();
		variable.setName(createVariableName(name));
		variable.setArray(false);
		variable.setComplex(false);
		variable.setProperty(null);
		variable.setIndex(null);
		return variable;
	}
	
	/**
	 * Create and return variable name wrapping the given name string.
	 * 
	 * @param name	name of the variable
	 * @return		the VariableName
	 */
	public String createVariableName(String name) {
//		VariableName varName= jadlFac.createVariableName();
//		varName.setName("$" + name);
//		return varName;
		return "$" + name;
	}
	
	/*
	 * /////////////////////////////
	 * //// OTHER HELPER METHODS
	 * /////////////////////////////
	 */
	
	/**
	 * Takes an expression (null, Expression, or DisjunctiveExpression) and returns
	 * the wrapped expressions. In case of a disjunctiveCondition the several
	 * conditions are concatenated with 'or'.
	 * 
	 * @param		expression some (Struc)BPMN Expression
	 * @return		expression(s) wrapped in the Expression
	 */
	public String getCondition(de.dailab.vsdt.Expression expression) {
		if (expression == null) {
			return null;
		}
		if (expression instanceof DisjunctiveExpression) {
			DisjunctiveExpression disjunctive = (DisjunctiveExpression) expression;
			StringBuffer buff= new StringBuffer();
			for (int i=0; i<disjunctive.getExpressions().size(); i++) {
				if (i>0) {
					buff.append(" || ");
				}
				buff.append("( ");
				buff.append(disjunctive.getExpressions().get(i));
				buff.append(" )");
			}
			return  buff.toString();
		} else {
			return expression.getExpression();
		}
	}
	
	/**
	 * Takes a number of Scripts and puts them into a Sequence
	 * 
	 * @param scripts	scripts to put into the sequence		
	 * @return			JADL sequence element
	 */
	public Seq createSequence(Script... scripts) {
		Seq sequence= jadlFac.createSeq();
		for (Script script : scripts) {
			sequence.getScripts().add(script);
		}
		return sequence;
	}
	
	/*
	 * /////////////////////////////////////
	 * //// PARSING METHODS
	 * /////////////////////////////////////
	 */

	/**
	 * Parse Expression from given string
	 * @param string	some string holding an expression
	 * @return			expression object
	 */
	public Expression parseExpression(String string) {
		String prefix= "while ( ";
		String suffix= " ) { }";
		Script script= parseScript(prefix + string + suffix);
		if (script instanceof While) {
			return ((While) script).getExpression();
		}
		return null;
	}

	public Expression parseExpression(de.dailab.vsdt.Expression expression) {
		if (expression != null) {
			return parseExpression(expression.getExpression());
		}
		return null;
	}
	
//	/**
//	 * Parse Expression from given string
//	 * @param string	some string holding an expression
//	 * @return			expression object
//	 */
//	public AssignValue parseAssignValue(String string) {
//		String prefix= "$foo = ";
//		String suffix= ";";
//		Script script= parseScript(prefix + string + suffix);
//		if (script instanceof Assign) {
//			return ((Assign) script).getValue();
//		}
//		return null;
//	}
//	
//	public Value parseValue(String string) {
//		AssignValue value= parseAssignValue(string);
//		if (value instanceof Value) {
//			return (Value) value;
//		}
//		return null;
//	}
	
	/**
	 * Parse script from given string
	 * @param string	some string holding a script
	 * @return			the script object
	 */
	public Script parseScript(String string) {
		String prefix= "service s (in ) (out ) { ";
		String suffix= " }";
		Agent model= parseModel(prefix + string + suffix);
		if (model != null) {
			Service service= Util.getFirstService(model);
			Seq seq= service.getBody();
			if (seq.getScripts().size() == 1) {
				return (Script) seq.getScripts().get(0);
			} else {
				return seq;
			}
		}
		return null;
	}

	/**
	 * Parse Model from given string
	 * @param string	some string holding a complete model
	 * @return			the model object
	 */
	public Agent parseModel(String string) {
//		Agent model= null;
//		// create parser based on JADL metamodel (XText-/Ecore file)
//		TrafoLog.debug("Parsing \"" + string + "\"");
//		ByteArrayInputStream bais= new ByteArrayInputStream(string.getBytes());
//		XtextParser xtextParser = new XtextParser(bais);
////		new EmfMetaModel(JadlPackage.eINSTANCE);
//		jadlResourceFactory.register();
//		jadlParser jadlParser = xtextParser.getParser();
//		try {
//			Node node = jadlParser.parse();
//			if (node != null) {
//				for(Object o : node.getErrors()) {
//					TrafoLog.warn("parser error: " + o);
//				}
//				model = (Model) node.getModelElement();
//			} else {
//				throw new Exception();
//			}
//		} catch (RecognitionException re) {			
//			TrafoLog.warn("syntax error at line " + re.line + ", token " + re.token + ": " + re.getMessage());
//		} catch (Exception e) {
//			TrafoLog.warn("could not parse code to a JADL model; ");
//		}
//		return model;
		Agent result= null;
		JadlParser parser= JadlParser.getInstance();
		try {
			result= parser.parse(string);
		} catch (JadlParseException e) {
			if (! parser.getErrors().isEmpty()) {
				TrafoLog.warn("Parsing error: " + parser.getErrors().get(0).getMessage());
			}
		}
		return result;
	}
	
	/**
	 * MAMS-specific version of createVariable
	 * 
	 * @param parName	name of the input parameter
	 * @param varName	name of the variable
	 * @return			the variable
	 */
	public Variable createInputForMAMS(String parName, String varName) {
		Variable variable= jadlFac.createVariable();
		variable.setName(createVariableName("\"" + parName + "\" $" + varName));
		return variable;
	}
}
