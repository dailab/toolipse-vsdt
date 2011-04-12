package de.dailab.vsdt.trafo.jiacv.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.dailab.jiactng.jadl.Agent;
import de.dailab.jiactng.jadl.Assign;
import de.dailab.jiactng.jadl.BoolConst;
import de.dailab.jiactng.jadl.ComplexType;
import de.dailab.jiactng.jadl.Expression;
import de.dailab.jiactng.jadl.FloatConst;
import de.dailab.jiactng.jadl.HeaderDeclaration;
import de.dailab.jiactng.jadl.IntegerConst;
import de.dailab.jiactng.jadl.PrimitveType;
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
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
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
	 * /////////////////////////////////////
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
	 * @param varName		the name of the variable to be created
	 * @param typeString	the type of the variable to be created
	 * @return				new variable declaration object
	 */
	public VariableDeclaration createVariableDeclaration(String varName, String typeString) {
		VariableDeclaration declaration= jadlFac.createVariableDeclaration();
		declaration.setDeclaration(createHeaderVariableDeclaration(varName, typeString));
		return declaration;
	}
	
	/**
	 * Create a List of Header Variable Declarations from a List of Properties
	 * 
	 * @param properties	List of Properties, e.g. from a Message
	 * @return				List of HeaderVariableDeclarations 
	 */
	public List<HeaderDeclaration> createHeaderDeclarations(List<Property> properties) {
		List<HeaderDeclaration> declarations= new ArrayList<HeaderDeclaration>();
		if (properties != null) {
			for (Property property : properties) {
				HeaderDeclaration declaration= createHeaderVariableDeclaration(property.getName(), Util.getType(property));
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
	public HeaderDeclaration createHeaderVariableDeclaration(String varName, String typeString) {
		HeaderDeclaration declaration= jadlFac.createHeaderDeclaration();
		declaration.setName(createVariableName(varName));
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
		declaration.setType(createType(actualType));
		return declaration;
	}
	
	/**
	 * Create a type object according to the given type string
	 * @param typeString	some string, e.g. "string" or "MyClass"
	 * @return				Type object according to the string
	 */
	public Type createType(String typeString) {
		Type type= jadlFac.createType();
		// test for simple types
		PrimitveType primitive= PrimitveType.get(typeString);
		if (primitive != null) {
			type.setPrimitive(primitive);
		} else {
//			OntologyName ontoName= jadlFac.createOntologyName();
//			ontoName.setName(typeString);
			ComplexType complexType= jadlFac.createComplexType();
			complexType.setClazz(typeString);
			type.setComplex(complexType);
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
	public Send createSend(Expression address, Property message) {
		Send send= jadlFac.createSend();
		send.setAddress(address);
		send.setMessage(createVariableName(message.getName()));
		return send;
	}
	
	/**
	 * Create Address Expression
	 * 
	 * @param message		some Message
	 * @return
	 */
	public Expression createAddress(MessageChannel channel) {
		return createExpression(Util.createAddressString(channel));
	}
	
	/**
	 * Create Receive element
	 * 
	 * @param address	address where to listen for new message
	 * @param property	the property
	 * @param timeout	timeout in milli seconds
	 * @return			newly created Receive element
	 */
	public Receive createReceive(Expression address, Property property, int timeout) {
		Receive receive= jadlFac.createReceive();
		receive.setTimeout(createExpression(timeout));
		receive.setAddress(address);
		receive.setVariable(createVariableName(property.getName()));
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
		Script script= parseScript(prefix + string + suffix, string);
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
	 * @param string			some string holding a script
	 * @param originalString	Original String, in case the string to be parsed is a wrapper for something else
	 * @return					the script object
	 */
	public Script parseScript(String string, String originalString) {
		String prefix= "service s (in ) (out ) { ";
		String suffix= " }";
		Agent model= parseModel(prefix + string + suffix, originalString);
		if (model != null) {
			Service service= getFirstService(model);
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
	 * @param model		some JADL file model
	 * @return			first service in the file, if any, or null
	 */
	private Service getFirstService(Agent model) {
		for (Service service : model.getServices()) {
			return service;
		}
		return null;
	}
	
	/**
	 * Parse Model from given string
	 * @param string			some string holding a complete model
	 * @param originalString	Original String, in case the string to be parsed is a wrapper for something else
	 * @return					the model object
	 */
	public Agent parseModel(String string, String originalString) {
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
				TrafoLog.warn("Parsing error '" + parser.getErrors().get(0).getMessage()
						+ "' when parsing String '" + (originalString == null ? string : originalString) + "'");
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
