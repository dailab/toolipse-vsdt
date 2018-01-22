package de.dailab.vsdt.vsdtagents.processenginebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.dailab.jiactng.agentcore.AbstractAgentBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.ActionResult;
import de.dailab.jiactng.agentcore.action.IMethodExposingBean.Expose;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import de.dailab.vsdt.interpreter.State;

/**
 * Proxy-Bean for invoking actions on ProcessEngineBean, providing a bridge 
 * between the Eclipse View and the actual JIAC VSDT Interpreter Agents.
 * 
 * @author kuester
 */
public class ProcessEngineBeanBean extends AbstractAgentBean {

	// The actions from ProcessEngineBean
	static final String PROVIDER = "de.dailab.jiactng.vsdt.interpreter.ProcessEngineBean#";
	static final String ACTION_REGISTER_RUNTIME = PROVIDER + "registerInterpreterRuntime";
	static final String ACTION_REMOVE_RUNTIME   = PROVIDER + "removeInterpreterRuntime";
	static final String ACTION_GET_RUNTIMES     = PROVIDER + "getAllInterpreters";
	
	// own actions
	public static final String ACTION_SHOW_STATE = "de.dailab.vsdt.vsdtagents.processenginebean.ProcessEngineBeanBean#showState";

	/*
	 * OWN ACTIONS TO BE INVOKED BY PROCESS ENGINE BEAN
	 */

	/**
	 * Receive interpreter state from process engine bean and set tokens in
	 * currently opened VSDT editor accordingly.
	 *
	 * @param allStates		Mapping FlowObject IDs to interpreter State
	 * @param allSteps		mapping Connection IDs to last visited step
	 */
	@Expose(name=ACTION_SHOW_STATE, scope=ActionScope.GLOBAL)
	public void showState(Map<String, State> allStates, Map<String, Integer> allSteps) {
		// TODO implement this method
		System.out.println("ACTION INVOKED");
		System.out.println(allStates);
		System.out.println(allSteps);
	}

	/*
	 * METHODS TO INVOKE ACTIONS AT PROCESS ENGINE BEAN
	 */

	/**
	 * Get a list of all the interpreter agents, by searching for all running 
	 * interpreter actions and returning their respective providers.
	 * 
	 * @return		list of agents with VSDT interpreter agent bean
	 */
	protected List<IAgentDescription> getInterpreterAgents() {
		Action template = new Action(ACTION_GET_RUNTIMES);
		List<IAgentDescription> agents = new ArrayList<>();
		for (IActionDescription action : thisAgent.searchAllActions(template)) {
			agents.add(action.getProviderDescription());
		}
		return agents;
	}

	/**
	 * Get all the interpreter runtimes running on some interpreter agent.
	 * 
	 * @param agent				the interpreter agent
	 * @return					list of running interpreter runtimes (maps id -> toString)
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, String> getRunningInterpreters(IAgentDescription agent) throws Exception {
		Serializable[] result = invokeAction(agent, ACTION_GET_RUNTIMES, 5000);
		return (Map<String, String>) result[0]; 
	}

	/**
	 * Deploy new Interpreter Runtime to selected interpreter agent
	 * 
	 * @param agent				the interpreter agent
	 * @param vsdtSource		the source code of the VSDT process file
	 * @param participantName	the name of the participant/role to play
	 * @return					the ID of the newly created interpreter runtime
	 * @throws Exception
	 */
	protected String deployProcessToInterpreter(IAgentDescription agent, String vsdtSource, String participantName) throws Exception {
		Serializable[] result = invokeAction(agent, ACTION_REGISTER_RUNTIME, 5000, vsdtSource, participantName);
		return (String) result[0];
	}
	
	/**
	 * Remove interpreter runtime with given ID from given interpreter agent.
	 * 
	 * @param agent				the interpreter agent
	 * @param id				ID of the runtime to remove
	 * @throws Exception		whether removal was successful
	 */
	protected void undeployInterpreterRuntime(IAgentDescription agent, String id) throws Exception {
		invokeAction(agent, ACTION_REMOVE_RUNTIME, 5000, id);
	}

	/**
	 * Invoke action, log errors and throw exception in case there are failures
	 * (better than to continue with invalid result and causing more exceptions
	 * up the line), return result.
	 * 
	 * @param agent			the agent where to invoke the action, or null for any
	 * @param actionName	the name of the action to invoke
	 * @param parameters	parameters of the action, if any
	 * @return 				the action result values (the complete array, not just the first one)
	 * @throws Exception	in case something went wrong...
	 */
	private Serializable[] invokeAction(IAgentDescription agent, String actionName, long timeout, Serializable... parameters) throws Exception {
	    IActionDescription template = new Action(actionName);
	    template.setProviderDescription(agent);
		
		IActionDescription action = thisAgent.searchAction(template);
	    if (action == null) {
	        throw new Exception("Could not find Action with name " + actionName);
	    }

	    ActionResult result = invokeAndWaitForResult(action, parameters, timeout);
	    if (result.getFailure() != null) {
	    	if (result.getFailure() instanceof Exception) {
	    		throw (Exception) result.getFailure();
	    	} else {
	    		throw new Exception("Action returned with Failure" + result.getFailure().toString());
	    	}
	    }
	    return result.getResults();
	}
	
}
