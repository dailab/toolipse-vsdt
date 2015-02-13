package de.dailab.vsdt.vsdtagents.processenginebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.dailab.jiactng.agentcore.AbstractAgentBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.ActionResult;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;

/**
 * TODO javadocs
 * 
 * @author kuester
 */
public class ProcessEngineBeanBean extends AbstractAgentBean {

	static final String PROVIDER = "de.dailab.jiactng.vsdt.interpreter.ProcessEngineBean#";
	static final String ACTION_REGISTER_RUNTIME = PROVIDER + "registerInterpreterRuntime";
	static final String ACTION_REMOVE_RUNTIME   = PROVIDER + "removeInterpreterRuntime";
	static final String ACTION_GET_RUNTIMES     = PROVIDER + "getAllInterpreters";
	
	/*
	 * TODO methods for invoking the process engine bean actions for 
	 * deploying processes, removing processes, listing processes, etc.
	 */

	protected List<IAgentDescription> getInterpreterAgents() {
		Action template = new Action(ACTION_GET_RUNTIMES);
		List<IAgentDescription> agents = new ArrayList<>();
		for (IActionDescription action : thisAgent.searchAllActions(template)) {
			agents.add(action.getProviderDescription());
		}
		return agents;
	}

	@SuppressWarnings("unchecked")
	protected Map<String, String> getRunningInterpreters(IAgentDescription agent) {
		Action template = new Action(ACTION_GET_RUNTIMES);
		template.setProviderDescription(agent);
		
		IActionDescription action = thisAgent.searchAction(template);
		try {
			ActionResult result = invokeAndWaitForResult(action, new Serializable[] {});
			Map<String, String> idToStringMap = (Map<String, String>) result.getResults()[0];
			return idToStringMap;
			
		} catch (Exception e) {
			System.err.println("ERROR: Failed to invoke action. " + e.getMessage());
		}
		return null;
	}

	protected String deployProcessToInterpreter(IAgentDescription agent, String vsdtSource, String participantName) throws Exception {
		Action template = new Action(ACTION_REGISTER_RUNTIME);
		template.setProviderDescription(agent);
		
		IActionDescription action = thisAgent.searchAction(template);
		ActionResult result = invokeAndWaitForResult(action, new Serializable[] {vsdtSource, participantName});
		
		if (result.getFailure() != null) {
			if (result.getFailure() instanceof Exception) {
				throw (Exception) result.getFailure();
			} else {
				throw new Exception(result.getFailure().toString());
			}
		} else {
			return (String) result.getResults()[0];
		}
	}
	
}
