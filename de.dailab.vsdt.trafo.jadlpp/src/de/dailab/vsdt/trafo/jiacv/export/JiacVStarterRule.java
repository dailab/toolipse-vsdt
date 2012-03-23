package de.dailab.vsdt.trafo.jiacv.export;

import de.dailab.jiactng.jadl.Service;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.trafo.jiacv.util.Util;


/**
 * This class is used to encapsulate the information for a JIAC V Starter Rule.
 * Rules can be created for each Start Event. The Rule's Body depends on the 
 * kind of Start Event (e.g. Timer, Message, Rule).
 * 
 * @author kuester
 */
public class JiacVStarterRule {

	/** the start event for which to create the rule */
	protected Event startEvent;
	
	/** the service to start with this rule */
	protected Service service;
	
	/**
	 * Create new Starter Rule
	 * 
	 * @param startEvent		the start event for which to create the rule
	 * @param serviceToStart	the service to start with this rule
	 */
	public JiacVStarterRule(Event startEvent, Service service) {
		this.startEvent= startEvent;
		this.service= service;
	}
	
	public Service getServiceToStart() {
		return service;
	}
	
	public Event getStartEvent() {
		return startEvent;
	}

	/**
	 * Create a Drools Rule corresponding to this Starter Rule.
	 * 
	 * @return		string representation of the rule
	 */
	public String toDroolsRule() {
		final String NL = System.getProperty("line.separator");
		final String TAB = "\t";
		final String serviceName = service.getName();
		String parameter = "";
		StringBuffer buffer= new StringBuffer();

		// write head and condition: service is known
		buffer.append("rule \"" + serviceName + "\"" + NL);
		buffer.append("when" + NL);
		buffer.append(TAB + "action : Action( name == \"" + serviceName + "\")" + NL);

		// type specific conditions
		switch (startEvent.getTrigger()) {
		case MESSAGE:
			if (startEvent.getImplementation() instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) startEvent.getImplementation();
				String address = Util.createAddressString(channel);
				buffer.append(TAB + "jiacMessage : IJiacMessage()" + NL);
				buffer.append(TAB + "eval(\"" + address + "\".equals(jiacMessage.getHeader(IJiacMessage.Header.SEND_TO)))" + NL);
				if (channel.getPayload() != null) {
					Property payload = channel.getPayload();
					parameter = payload.getName();
					buffer.append(TAB + parameter + " : "  + Util.getType(payload) + "() from jiacMessage.payload" + NL);
				}
				break;
			}
		case RULE:
			// condition for RULE event
			// copy rule expression to WHEN part
			String rule = startEvent.getRuleExpression().getExpression();
			buffer.append(TAB + rule + NL);
			// scan the rule expression for names of process properties
			for (Property property : startEvent.getPool().getProperties()) {
				if (rule.contains(property.getName())) {
					// make these properties the service parameters
					if (! parameter.isEmpty()) {
						parameter += ", ";
					}
					parameter += property.getName();
				}
			}
			
			break;
		case TIMER:
			// TODO condition for TIMER event
			// check time fact
			// start process with no parameters
			// mark the process as being started (how?)
		default:
			buffer.append(TAB + " # " + startEvent.toString() + NL);
			break;
		}

		// write consequence: start the service
		buffer.append("then" + NL);
		buffer.append(TAB + "System.out.println(\"RULE " + serviceName + "\" fired);" + NL);
		buffer.append(TAB + "insert( new DoAction(action, null, new Serializable[] { " + parameter + " }) );" + NL);
		
		// type specific consequences
		switch (startEvent.getTrigger()) {
		case MESSAGE:
			buffer.append(TAB + "retract( jiacMessage);" + NL);
			break;
		}
		buffer.append("end" + NL + NL);
		
		return buffer.toString();
	}

}
