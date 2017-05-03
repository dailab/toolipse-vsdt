package de.dailab.vsdt.util;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;

/**
 * This class provides a number of advanced element creation methods.
 * These methods make the creation of new elements not only more line-efficient, 
 * but also less error-prone, as they dictate which attribute need to be set. 
 * 
 * @author kuester
 */
public class VsdtElementFactory {

	public static final VsdtFactory fac= VsdtFactory.eINSTANCE;
	
	public static Intermediate createIntermediate(String name, TriggerType trigger) {
		Intermediate intermediate= fac.createIntermediate();
		intermediate.setName(name);
		intermediate.setTrigger(trigger);
		return intermediate;
	}
	
	public static Activity createActivity(String name, ActivityType type) {
		Activity activity= fac.createActivity();
		activity.setName(name);
		activity.setActivityType(type);
		return activity;
	}
	
	public static Gateway createGateway(String name, GatewayType type) {
		Gateway gateway= fac.createGateway();
		gateway.setName(name);
		gateway.setGatewayType(type);
		return gateway;
	}
	
	/**
	 * create an expression wrapper object for a given expression
	 * 
	 * @param expression	the expression string
	 * @return				expression wrapper holding the actual expression
	 */
	public static Expression createExpression(String expression) {
		return createExpression(expression, null);
	}
	
	/**
	 * create an expression wrapper object for a given expression and language
	 * 
	 * @param expression	the expression string
	 * @param language		the expression language, or null (using the diagram default)
	 * @return				expression wrapper holding the actual expression
	 */
	public static Expression createExpression(String expression, String language) {
		if (expression != null && ! expression.trim().isEmpty()) {
			Expression exp= fac.createExpression();
			exp.setExpression(expression);
			exp.setLanguage(language);
			return exp;
		} else {
			return null;
		}
	}

	public static Service createService(String type, String interfce, String operation, Participant participant) {
		Service service = fac.createService();
		service.setInterface(interfce);
		service.setOperation(operation);
		service.setParticipant(participant);
		service.setType(type);
		return service;
	}
	
	public static MessageChannel createMessageChannel(String channel, Property payload) {
		MessageChannel messageChannel= fac.createMessageChannel();
		messageChannel.setChannel(createExpression(channel));
		messageChannel.setPayload(payload);
		return messageChannel;
	}
	
	public static Property createProperty(String name, String type) {
		Property property= fac.createProperty();
		property.setName(name);
		property.setType(type);
		return property;
	}

	public static Assignment createAssignmen(Property to, Expression from, AssignTimeType time) {
		Assignment assign = VsdtFactory.eINSTANCE.createAssignment();
		assign.setTo(to);
		assign.setFrom(from);
		assign.setAssignTime(time);
		return assign;
	}
}
