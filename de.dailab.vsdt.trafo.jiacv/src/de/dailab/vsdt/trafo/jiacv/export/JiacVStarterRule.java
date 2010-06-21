package de.dailab.vsdt.trafo.jiacv.export;

import de.dailab.jiactng.jadl.Service;
import de.dailab.vsdt.Event;


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
	protected Service serviceToStart;
	
	/**
	 * Create new Starter Rule
	 * 
	 * @param startEvent		the start event for which to create the rule
	 * @param serviceToStart	the service to start with this rule
	 */
	public JiacVStarterRule(Event startEvent, Service serviceToStart) {
		this.startEvent= startEvent;
		this.serviceToStart= serviceToStart;
	}

	/**
	 * Create a Drools Rule corresponding to this Starter Rule
	 * 
	 * @return		string representation of the rule
	 */
	public String toDroolsRule() {
		StringBuffer buffer= new StringBuffer();
		// TODO
		
		buffer.append("when");
		buffer.append("\t" + startEvent.toString());
		buffer.append("then");
		buffer.append("\t" + serviceToStart.toString());
		
		return buffer.toString();
	}
	
}
