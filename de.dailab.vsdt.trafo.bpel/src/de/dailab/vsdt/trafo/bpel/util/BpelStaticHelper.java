package de.dailab.vsdt.trafo.bpel.util;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPick;
import org.xmlsoap.schemas.ws._2003._03.business.process.TProcess;
import org.xmlsoap.schemas.ws._2003._03.business.process.TReceive;
import org.xmlsoap.schemas.ws._2003._03.business.process.TScope;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSequence;
import org.xmlsoap.schemas.wsdl.TDefinitions;
import org.xmlsoap.schemas.wsdl.TPortType;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BpmnProcess;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;


/**
 * this class is intended to hold all the methods that can be accessed statically,
 * i.e. without any side effects.
 * 
 * The methods in this class are:
 * - getters for wrapper objects; if the wrapper object does not exist yet, it is created
 * - getters for BPMN-to-BPEL naming conversions
 * - various helper methods
 * 
 * @author kuester
 */
public class BpelStaticHelper implements BpelVisitorConstants {
	
	public static boolean useSuffixes= true;
	
	/**
	 * can not be instantiated
	 */
	private BpelStaticHelper() {}
	
	/**
	 * returns the processes scope if it has one or creates a new scope for the process
	 * 
	 * @param process	the BPEL process
	 * @return			the processes scope
	 */
	public static TScope getScope(TProcess process) {
		if (process.getScope() == null) {
			TScope scope= bpelFac.createTScope();
			process.setScope(scope);
		}
		return process.getScope();
	}
	
	
	/**
	 * returns the scope's event handlers if it has any or creates a new one
	 * 
	 * @param scope	the scope
	 * @return		the eventHandlers
	 */
	public static TEventHandlers getEventHandlers(TScope scope) {
		if (scope.getEventHandlers() == null) {
			TEventHandlers eventHandlers= bpelFac.createTEventHandlers();
			scope.setEventHandlers(eventHandlers);
		}
		return scope.getEventHandlers();
	}
	
	
	/**
	 * returns the scope's fault handlers if it has any or creates a new one
	 * 
	 * @param scope	the scope
	 * @return		the faultHandlers
	 */
	public static TFaultHandlers getFaultHandlers(TScope scope) {
		if (scope.getFaultHandlers() == null) {
			TFaultHandlers faultHandlers= bpelFac.createTFaultHandlers();
			scope.setFaultHandlers(faultHandlers);
		}
		return scope.getFaultHandlers();
	}
	

	/**
	 * This method returns the first receive or pick in a (possibly nested) sequence.
	 * Note: As a side-effect the activity found, if any, is removed from it's containing
	 * sequence. The method will only check whether the first element is a receive or pick
	 * or if the first element is a sequence (otherwise it wouldn't be the first receive
	 * or pick anyway. Useful for inserting process start assignments.
	 * 
	 * @param sequence		a (nested) BPMN sequence thought to be started with a receive or pick
	 * @return				the first receive or pick (being removed from its containing sequence) or null
	 */
	public static TActivity extractFirstReceiveOrPick(TSequence sequence) {
		TActivity firstElement= (TActivity) sequence.getActivity().getValue(0);
		if (firstElement instanceof TReceive || 
				firstElement instanceof TPick) {
			sequence.getActivity().remove(0);
			return firstElement;
		} else {
			if (firstElement instanceof TSequence) {
				return extractFirstReceiveOrPick((TSequence)firstElement);
			} else {
				return null;
			}
		}
	}
	

	/**
	 * returns a bpws:getVariableData-String for the given variable and part
	 * 
	 * @param var	some variable
	 * @param part	some part of that variable, or null
	 * @param query	some optional query, or null (will be ignored, if part is null)
	 * @return		"bpws:getVariableData('" + var + "','" + part + "')"
	 */
	public static String getVarData(String var, String part, String query) {
		StringBuffer buff= new StringBuffer();
		buff.append("bpws:getVariableData('");
		buff.append(var);
		if (part != null) {
			buff.append("','");
			buff.append(part);
			if (query != null) {
				buff.append("','");
				buff.append(query);
			}
		}
		buff.append("')");
		return buff.toString();
	}
	
	/**
	 * Takes an expression (null, Expression, or DisjunctiveExpression) and returns
	 * the wrapped expressions. In case of a disjunctiveCondition the several
	 * conditions are concatenated with 'or'.
	 * 
	 * @param		expression some (Struc)BPMN Expression
	 * @return		expression(s) wrapped in the Expression
	 */
	public static String getCondition(Expression expression) {
		if (expression == null) {
			return null;
		}
		if (expression instanceof DisjunctiveExpression) {
			DisjunctiveExpression disjunctive = (DisjunctiveExpression) expression;
			StringBuffer buff= new StringBuffer();
			for (int i=0; i<disjunctive.getExpressions().size(); i++) {
				if (i>0) {
					buff.append(" or ");
				}
				buff.append("( ");
				buff.append(disjunctive.getExpressions().get(i));
				buff.append(" )");
			}
			return  buff.toString();
		} else {
			if (expression.getExpression() == null || expression.getExpression().trim().isEmpty()) {
				// empty expression changed to true()
				expression.setExpression("true()");
			}
			return expression.getExpression();
		}
	}
	
	/**
	 * returns a uniformly formatted name for a variable for a given element. The element should be
	 * of type Activity, Process, or Message
	 * 
	 * @param object	some Activity, Process, or Message
	 * @return			[object.name]_[object.class]Data
	 */
	public static String getVarNameFor(Object object) {
		if (object instanceof Message) {
			Message message = (Message) object;
			return message.getName() + ( useSuffixes ? "_MessageData" : "" );
		}
		if (object instanceof Activity) {
			Activity activity = (Activity) object;
			return activity.getName() + ( useSuffixes ? "_ActivityData" : "" );
		}
		if (object instanceof BpmnProcess) {
			BpmnProcess process = (BpmnProcess) object;
			return process.getName() + ( useSuffixes ? "_ProcessData" : "" );
		}
		return null;
	}
	
	
	/**
	 * returns a uniformly formatted name for a WSDL message for a given variable name (for those
	 * variables that each have their own message, i.e. NO counters)
	 * 
	 * @param object	some variable name
	 * @return			variableName + "Message"
	 */
	public static String getMessageName(String variableName) {
		return variableName + "Message";
	}
	
	
	/**
	 * returns a uniformly formatted name for a partner link for a given participant
	 * 
	 * @param participant	some participant
	 * @return				participant.name
	 */
	public static String getPartnerLinkName(Participant participant) {
		return participant.getName();
	}

	
	/**
	 * create a new QName from the given name. If the give name is null, null is returned.
	 * This method is quite convenient, since QNames can not be constructed from null values
	 * 
	 * @param name	some 'normal' name
	 * @return		new QName or null
	 */
	public static QName makeQName(String name) {
		if (name != null) {
			return new QName(name);
		} else {
			return null;
		}
	}
	

	/**
	 * returns a uniformly formatted target name-space for a given process and WSDL name for being used
	 * for the declaration and reference of the WSDL's target name-space
	 * 
	 * @param name	some name
	 * @return		"http://" + name + "/WSDL/"
	 */
	public static String getWsdlTNS(String name) {
		return "http://" + name + "/WSDL/";
	}
	
	
	/**
	 * returns a uniformly formatted target name-space for a given process and WSDL name for being used
	 * for the declaration and reference of the Process's target name-space
	 * 
	 * @param name	some name
	 * @return		"http://" + name
	 */
	public static String getBpelTNS(String name) {
		return "http://" + name;
	}
	
	
	/**
	 * abbreviation for getVarData(getVarNameFor(property.eContainer()), property.getName())
	 * 
	 * @param property	some property
	 * @return			the variable getter
	 */
	public static String getFullVarName(Property property, String query) {
		return getVarData(getVarNameFor(property.eContainer()), property.getName(), query);
	}
	
	
	/**
	 * do some clean up on the generated WSDL file, e.g. sorting message types and port types etc. 
	 * @param definitions	the WSDL definitions
	 */
	public static void cleanUpWSDL(TDefinitions definitions) {
		//remove port types and re-insert them at the end of the file 
		List<TPortType> porttypes= new ArrayList<TPortType>();
		porttypes.addAll(definitions.getPortType());
		
		definitions.getPortType().clear();
		definitions.getPortType().addAll(porttypes);
	}
}
