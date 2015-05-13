package de.dailab.vsdt.interpreter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.interpreter.ISimulationObserver.LogLevel;
import de.dailab.vsdt.util.VsdtHelper;
import de.dailab.vsdt.vxl.util.Util;
import de.dailab.vsdt.vxl.util.VxlInterpreter;
import de.dailab.vsdt.vxl.util.VxlParseException;
import de.dailab.vsdt.vxl.util.VxlParser;
import de.dailab.vsdt.vxl.vxl.VxlTerm;

/**
 * This Simulation requires fewer interaction with the user than the Manual
 * Simulation, as it keeps track of the Property value, evaluating the several
 * expression in Assignments, Loops and branching conditions.
 * 
 * Note: This works only for expressions using the VSDT Expression Language (VXL)
 * 
 * @author kuester
 */
public abstract class AbstractInterpretingSimulation extends BasicSimulation {

	@Override
	public String getName() {
		return "Interpreting Simulation";
	}
	
	@Override
	public boolean isApplicable(EObject object) throws Exception {
		if (object instanceof BusinessProcessSystem) {
			BusinessProcessSystem bps = (BusinessProcessSystem) object;
			if (! bps.isExecutable()) {
				String message = "The current Process Diagram is not executable. " +
						"If you want to interpret this Process, please set the " +
						"Business Process System's executable flag to True.";
				throw new Exception(message);
			}
		}
		return true;
	}
	
	/*
	 * TODO 
	 * - support for complex types and arrays
	 * - standard loop: test before
	 * - multiInstance loop
	 * - forget local property values when exiting activity (message's, too)
	 * - do not always show MessageParameterDialogs
	 */
	
	/** This Map holds the association of Properties to values */
	protected Map<Property, Serializable> propertyValueMap= new HashMap<>();
	
	/** This Map holds the current loop counter for the several activities  currently looping*/
	protected Map<Activity, Integer> loopCounterMap= new HashMap<>();
	
	/**
	 * - Before starting the Interpreting Simulation, assert that all expressions
	 *   can be parsed. Nothing more annoying than running the interpreter and 
	 *   then finding an error in the next to last assignment. 
	 */
	@Override
	protected boolean checkDiagram(EObject object) {
		return true; // TODO 
//		boolean isOk = true;
//		for (TreeIterator<EObject> iter= diagram.eAllContents(); iter.hasNext(); ) {
//			EObject next= iter.next();
//			if (next instanceof Expression) {
//				// test-parse the expression, exit if result is null
//				VxlTerm result = parseExpression(getExpression((Expression) next));
//				isOk &= result != null;
//			}
//		}
//		return isOk;
	}

	/**
	 * reset property maps
	 */
	@Override
	protected void initialize(EObject object) {
		propertyValueMap.clear();
		loopCounterMap.clear();
	}
	
	/**
	 * Returns the currently stored Value for the given Property
	 * 
	 * @param property		Some Property
	 * @return				Current Value in this Simulation instance
	 */
	public Serializable getPropertyValue(Property property) {
		if (property != null) {
			return propertyValueMap.get(property);
		}
		return null;
	}
	
	/**
	 * Set the given value for the property in the properties values map.
	 * 
	 * @param property		Some Property
	 * @param value			New value to be assigned to this property
	 */
	public void setPropertyValue(Property property, Serializable value) {
		if (property != null) {
			propertyValueMap.put(property, value);
		}
	}

	/**
	 * Collect properties of incoming or outgoing messages and services, so they
	 * can be handles appropriately, e.g. by simply displaying them (or asking for
	 * them) in a dialogue, or by issuing respective service calls.
	 * 
	 * Note: Here, "Incoming" means the Message incoming to the Flow Object, 
	 * not the Input Message of the Service.
	 * 
	 * @param flowObject	Some FlowObject in this Simulation with Messages
	 * @param incoming		Select Incoming or Outgoing message?
	 * @return				List of properties
	 */
	public List<Property> collectMessageProperties(FlowObject flowObject, boolean incoming) {
		List<Property> properties = null;
		if (flowObject instanceof Activity) {
			Activity activity= (Activity) flowObject;
			if (activity.getImplementation() instanceof Service) {
				Service service = (Service) activity.getImplementation();
				properties = getParameters(service, activity.getPool().getParticipant(), incoming);
			}
			if (activity.getImplementation() instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) activity.getImplementation();
				if ((activity.getActivityType() == ActivityType.SEND && ! incoming) || 
						activity.getActivityType() == ActivityType.RECEIVE && incoming) {
					if (channel.getPayload() != null) {
						properties = Arrays.asList(channel.getPayload());
					}
				}
			}
		}
		if (flowObject instanceof Event) {
			Event event = (Event) flowObject;
			if (event.isThrowing() != incoming) {
				if (event.getImplementation() instanceof Service) {
					Service service = (Service) event.getImplementation();
					properties = getParameters(service, event.getPool().getParticipant(), incoming);
				}
				if (event.getImplementation() instanceof MessageChannel) {
					MessageChannel channel = (MessageChannel) event.getImplementation();
					if (channel.getPayload() != null) {
						properties = Arrays.asList(channel.getPayload());
					}
				}
			}
		}
		return properties;
	}

	/**
	 * Handle properties of incoming or outgoing messages and services, e.g. by 
	 * simply displaying them (or asking for them) in a dialogue, or by issuing 
	 * respective service calls.
	 * 
	 * This method is only called when there's actually a message being sent,
	 * but the list of properties could be empty!
	 * 
	 * Note: Here, "Incoming" means the Message incoming to the Flow Object, 
	 * not the Input Message of the Service.
	 * 
	 * @param properties	The properties (not null, but could be empty list)
	 * @param incoming		Select Incoming or Outgoing message?
	 */
	protected abstract void handleMessageProperties(List<Property> properties, boolean incoming);
	
	/**
	 * Return the right set of parameters (input or output).
	 * 
	 * @param service			some Service
	 * @param myParticipant		participant for whom to retrieve the parameters
	 * @param incoming			incoming or outgoing message?
	 * @return					right set of parameters, i.e. input or output
	 */
	protected List<Property> getParameters(Service service, Participant myParticipant, boolean incoming) {
		// WARNING: This works only if the service provider is
		// not the same participant as the service requester!
		//   inc,   same -> input
		//   inc, ! same -> output
		// ! inc,   same -> output
		// ! inc, ! same -> input
		boolean isSameParticipant = myParticipant == service.getParticipant();
		return incoming == isSameParticipant ? service.getInput() : service.getOutput();
	}
	
	/**
	 * - If there is an outgoing message, open {@link MessageParameterDialog} 
	 *   showing the message parameters.
	 */
	@Override
	protected void executeBegin(FlowObject flowObject) {
		super.executeBegin(flowObject);
		// open dialog telling the user which service has been called with which parameters
		List<Property> properties = collectMessageProperties(flowObject, false);
		if (properties != null) {
			handleMessageProperties(properties, false);
		}
	}

	/**
	 * - If there is an incoming message, open {@link MessageParameterDialog} 
	 *   showing the message parameters.
	 */
	@Override
	protected void executeEnd(FlowObject flowObject) {
		// open a dialog asking the user with which results the service shall return 
		List<Property> properties = collectMessageProperties(flowObject, true);
		if (properties != null) {
			handleMessageProperties(properties, true);
		}
		super.executeEnd(flowObject);
	}
	
	/**
	 * - evaluate assignment expressions
	 * - store value in {@link #propertyValueMap}
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void handleAssignments(EObject eObject, AssignTimeType assignTime) {
		List<Assignment> assignments= null;
		if (eObject instanceof FlowObject) {
			assignments= ((FlowObject) eObject).getAssignments();
		}
		// evaluate assignment expression
		if (assignments != null) {
			for (Assignment assignment : assignments) {
				if (assignment.getAssignTime() == assignTime && assignment.getFrom() != null) {
					Serializable value= parseAndEvaluate(assignment.getFrom(), createContext(eObject));
					if (assignment.getToQuery() != null) {
						// try to assign to array index
						VxlTerm term = parseExpression(assignment.getToQuery());
						Serializable query = evaluateTerm(term, createContext(eObject));
						if (query instanceof Number) {
							Number number = (Number) query;
							Serializable propVal = getPropertyValue(assignment.getTo());
							if (propVal instanceof List) {
								List<Serializable> list = (List) propVal;
								list.set(Util.asInteger(number), value); 
							}
						}
					} else {
						setPropertyValue(assignment.getTo(), value);
						System.out.println(assignment.getTo().getName() + " <- " + value);
					}
				}
			}
		}
	}
	
	/**
	 * - determine whether SequenceFlows need to be selected at all
	 * - evaluate ConditionExpressions and add flows to list accordingly
	 * - if not inclusive OR, at max one flow can be selected
	 * - if no flow has been selected, and there is a default flow, select it
	 */
	@Override
	protected List<SequenceFlow> selectOutgoingSequenceFlows(FlowObject flowObject) {
		boolean inclusiveOr= flowObject instanceof Gateway && ! (
				((Gateway)flowObject).getGatewayType()==GatewayType.XOR_DATA ||
				((Gateway)flowObject).getGatewayType()==GatewayType.XOR_EVENT);
		if ((flowObject instanceof Gateway) && 
				((Gateway)flowObject).getGatewayType()==GatewayType.COMPLEX) {
			// not supported yet
			logMessage(LogLevel.ERROR, "Not Supported", "Complex Gateways are not yet supported");
			return new ArrayList<>();
		}
		List<SequenceFlow> selectedFlows= new ArrayList<>();
		SequenceFlow defaultflow= null;
		for (SequenceFlow sequenceFlow : flowObject.getOutgoingSeq()) {
			if (sequenceFlow.getConditionType() == ConditionType.DEFAULT) {
				defaultflow= sequenceFlow;
			} else  if (evaluateCondition(sequenceFlow.getConditionExpression(), createContext(flowObject))) {
				selectedFlows.add(sequenceFlow);
				if (! inclusiveOr) {
					break;
				}
			}
		}
		if (selectedFlows.isEmpty() && defaultflow != null) {
			selectedFlows.add(defaultflow);
		}
		return selectedFlows;
	}
	
	/**
	 * - Standard Loop:
	 *   - test loop counter and loop condition
	 *   - if both are OK, the Activity is repeated
	 *   - the current loop counter is stored in the {@link #loopCounterMap}
	 * - MultiInstance Loop: Not yet implemented
	 */
	@Override
	protected boolean isLooping(Activity activity) {
		if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
			StandardLoopAttSet loopAttributes = (StandardLoopAttSet) activity.getLoopAttributes();
			// test both loop condition and loop maximum
			boolean counterOk= true;
			if (loopAttributes.getLoopMaximum() > 0) {
				if (! loopCounterMap.containsKey(activity)) {
					loopCounterMap.put(activity, 1);
				}
				int max= loopAttributes.getLoopMaximum();
				counterOk= loopCounterMap.get(activity) < max;
				if (counterOk) {
					// increase counter
					loopCounterMap.put(activity, loopCounterMap.get(activity)+1);
				} else {
					// reset counter
					loopCounterMap.remove(activity);
				}
			}
			boolean conditionOk= true;
			if (loopAttributes.getLoopCondition() != null) {
				conditionOk= evaluateCondition(loopAttributes.getLoopCondition(), createContext(activity));
			}
			return counterOk && conditionOk;
		}
		if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
			// not supported yet
			logMessage(LogLevel.WARN, "Not Supported", "MI Loops are not yet supported");
		}
		return false;
	}

	/**
	 * Create the "Context" for the given FlowObject. The Context is a Map 
	 * holding the association of names of properties in the scope of the given
	 * FlowObject to property values taken from the {@link #propertyValueMap}.
	 * 
	 * @see FlowObject#getVisibleProperties()
	 * @param eObject	Some (Flow) Object
	 * @return				Map of names of Properties in the scope to their values
	 */
	public Map<String, Serializable> createContext(EObject eObject) {
		// get local properties
		Map<String, Serializable> context= new HashMap<>();
		for (Property property : VsdtHelper.getVisibleProperties(eObject)) {
			context.put(property.getName(), propertyValueMap.get(property));
		}
		return context;
	}
	
	public final String getPropertiesString() {
		final String NL = System.getProperty("line.separator");
		StringBuilder builder = new StringBuilder();
		builder.append("--- Properties Table ---" + NL);
		for (Property property : propertyValueMap.keySet()) {
			builder.append((property != null ? property.getName() : "null") + "\t" + propertyValueMap.get(property) + NL);
		}
		builder.append("--- Loop Counter Table ---" + NL);
		for (Activity activity : loopCounterMap.keySet()) {
			builder.append(activity.getName() + "\t" + loopCounterMap.get(activity) + NL);
		}
		return builder.toString();
	}
	
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
	public boolean evaluateCondition(Expression expression, Map<String, Serializable> context) {
		if (expression != null) {
			Serializable value= parseAndEvaluate(expression, context);
			if (value instanceof Boolean) {
				return (Boolean) value;
			} else {
				String title= "Evaluation failed";
				StringBuffer message= new StringBuffer();
				message.append("The condition ").append(expression.getExpression()).append(" does not evaluate to a Boolean value.");
				logMessage(LogLevel.ERROR, title, message.toString());
			}
		} else {
			String title= "Evaluation failed";
			StringBuffer message= new StringBuffer();
			message.append("The condition must not be null.");
			logMessage(LogLevel.ERROR, title, message.toString());
		}
		return false;
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
	public Serializable parseAndEvaluate(Expression expression, Map<String, Serializable> context) {
		return evaluateTerm(parseExpression(getExpression(expression)), context);
	}
	
	/**
	 * If the Expression is a non-null VSDT Expression with Expression Language
	 * set to VXL, return the Expression string, otherwise return null.
	 * 
	 * @param expression	Some VXL Expression (as VSDT Expression object)
	 * @return				Expression string if non-null VXL Expression, or null
	 */
	public String getExpression(Expression expression) {
		if (expression == null) return null;
		// check expression language
		String lang= expression.getExpressionLanguageToBeUsed();
		if (Util.languageIsVxl(lang)) {
//			return expression.getExpression();
			return VsdtHelper.getExpressionWithParameters(expression);
		} else {
			String message= "Expressions must be given using the VSDT Expression Language (VXL).";
			logMessage(LogLevel.WARN, "Unsupported Expression Language", message.toString());
			return null;
		}
	}
	
	/**
	 * Parse the Expression using the VXL parser and return the resulting Term. 
	 * If there are any errors, this is shown in some dialogs, and null is returned.
	 * 
	 * @param expression	Some VXL Expression (as string)
	 * @return				Result of the parsing, or null in case of error
	 */
	public VxlTerm parseExpression(String expression) {
		if (expression == null) return null;

		VxlParser parser= VxlParser.getInstance();	//TODO errror here
		
		try {
			VxlTerm term= parser.parse(expression);
			return term;
		} catch (VxlParseException e) {
			String title= "Parsing failed";
			StringBuffer message= new StringBuffer();
			message.append("The expression ").append(expression).append(" could not be parsed.");
			if (! parser.getErrors().isEmpty()) {
				message.append("\r\nErrors:");
				for (Diagnostic d : parser.getErrors()) {
					message.append("\r\n- ").append(d.getMessage());
				}
			}
			logMessage(LogLevel.ERROR, title, message.toString());
			return null;
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
	public Serializable evaluateTerm(VxlTerm term, Map<String, Serializable> context) {
		if (term == null) return null;
		VxlInterpreter interpreter= new VxlInterpreter();
		Serializable result= interpreter.evaluateTerm(term, context);
		Map<Object, String> errors= interpreter.getErrors();
		if (! errors.isEmpty()) {
			String title= "Evaluation failed";
			StringBuffer message= new StringBuffer();
			message.append("Expression could not be evaluated.");
			message.append("\r\nErrors:");
			for (String error : errors.values()) {
				message.append("\r\n- ").append(error);
			}
			logMessage(LogLevel.ERROR, title, message.toString());
		}
		return result;
	}
	
}
