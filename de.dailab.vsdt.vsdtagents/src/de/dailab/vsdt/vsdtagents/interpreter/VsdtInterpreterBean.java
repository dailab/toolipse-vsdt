package de.dailab.vsdt.vsdtagents.interpreter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.dailab.jiactng.agentcore.AbstractAgentBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.ActionResult;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.vsdt.diagram.interpreter.view.InterpreterView;

/**
 * Special Version of the Deployment Bean, additionally registering a special
 * simulation type with the VSDT's interpreter view.
 * 
 * @author kuester
 */
public class VsdtInterpreterBean extends AbstractAgentBean {

	@Override
	public void doStart() throws Exception {
		super.doStart();
		InterpreterView.simulations.add(new JiacEnabledVsdtInterpreter(this));
	}

	/**
	 * Returns a Map holding all the Actions found, categorized by Agents.
	 * 
	 * @return	Map of Agents and Actions
	 */
	public List<IActionDescription> getActions() {
		List<IActionDescription> allActions = thisAgent.searchAllActions(new Action());
		List<IActionDescription> publicActions = new ArrayList<IActionDescription>();
		// publicActions = filter(lambda a: a.scope != AGENT, allActions)
		for (IActionDescription action : allActions) {
			if (action.getScope() != ActionScope.AGENT) {
				publicActions.add(action);
			}
		}
		return publicActions;
	}
	
	/**
	 * Invoke the JADL service corresponding to the given Action Description
	 * with the given input parameters. The Service is invoked synchronously and
	 * the result is returned.
	 * 
	 * @param service		some Action Description for a JADL Service
	 * @param parameters	input parameters for the service invocation
	 * @return				result of the service invocation
	 * @throws Exception	any Exception that occurred during the invocation
	 */
	public Serializable[] invokeAction(IActionDescription service, Serializable... parameters) throws Exception {
		ActionResult result = invokeAndWaitForResult(service, parameters);
		if (result.getFailure() != null) {
			throw new Exception(result.getFailure().toString());
		}
		return result.getResults();
	}
	
}
