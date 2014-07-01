package de.dailab.vsdt.vsdtagents.deployment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import de.dailab.jiactng.agentcore.AbstractAgentBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.ActionResult;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;

/**
 * A Agent Bean for the JIAC-Node-running-inside-Eclipse-Node that's actually
 * useful.  This bean provides methods for searching for actions and services.
 * 
 * @see JadlInterpreterAgentBean
 * 
 * @author burkhardt, kuester
 */
public class DeploymentBean extends AbstractAgentBean {

	/** name of IInterpreterAgentBean's Deploy-Action */
	static String ACTION_DEPLOY = "IInterpreterAgentBean#DeployJADLCode";
	
	/** name of IInterpreterAgentBean's Undeploy-Action */
	static String ACTION_UNDEPLOY = "IInterpreterAgentBean#UndeployJADLService";
	
	/** name of Service Starter Bean's Deploy-Action */
	static String ACTION_DEPLOY_WITH_RULES = "ServiceStarterBean.deployWithStarters";
	

	/**
	 * Returns a Map holding all the Actions found, categorized by Agents.
	 * 
	 * @return	Map of Agents and Actions
	 */
	public List<IActionDescription> getServices() {
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
	 * Deploy the given Code as a JADL Service using the respective method of 
	 * the Interpreter Agent Bean. 
	 * 
	 * @param agent			JADL Interpreter Agent where to deploy the service
	 * @param serviceSrc	full JADL source code, including headers etc.
	 * @return				List of names of newly added Actions 
	 * @throws Exception	forward any Exception thrown by the Interpreter
	 */
//	@SuppressWarnings("unchecked")
//	public Collection<String> deploy(IAgentDescription agent, String serviceSrc) throws Exception {
//		// find the given agent's deploy action
//		IActionDescription deployAction = findAction(ACTION_DEPLOY, agent);
//		
//		// deploy given service, if deploy action was found
//		if (deployAction != null) {
//			ActionResult result = invokeAndWaitForResult(deployAction, new Serializable[] { serviceSrc});
//			if (result.getFailure() != null) {
//				throw new Exception(result.getFailure().toString());
//			}
//			List<String> serviceNames= (List<String>) result.getResults()[0];
//			return serviceNames;
//		} else {
//			throw new Exception("Can only deploy JADL service on Agent with JADL Deploy Action");
//		}
//	}
//	
	
	/**
	 * Deploy the given Code as a JADL Service using the respective method of 
	 * the Service Starter Agent Bean. This will deploy the services, and install
	 * a number of rules for starting the services based on some events.
	 * 
	 * @param agent			JADL Interpreter Agent where to deploy the service
	 * @param serviceSrc	full JADL source code, including headers etc.
	 * @param rules			service starter rules, or null
	 * @return				List of names of newly added Actions 
	 * @throws Exception	forward any Exception thrown by the Interpreter
	 */
	@SuppressWarnings("unchecked")
	public Collection<String> deployWithRules(IAgentDescription agent, String serviceSrc, HashMap<String, Serializable[]> rules) throws Exception {
		// find the given agent's deploy action
		
		IActionDescription deployAction = rules == null ? 
				findAction(ACTION_DEPLOY, agent) : findAction(ACTION_DEPLOY_WITH_RULES, agent);
		Serializable[] parameters = rules == null ?
				new Serializable[] {serviceSrc} : new Serializable[] {serviceSrc, rules};
		
		// deploy given service, if deploy action was found
		if (deployAction != null) {
			ActionResult result = invokeAndWaitForResult(deployAction, parameters);
			if (result.getFailure() != null) {
				throw new Exception(result.getFailure().toString());
			}
			List<String> serviceNames= (List<String>) result.getResults()[0];
			return serviceNames;
		} else {
			throw new Exception("Can only deploy JADL service with starter rules on Agent with Service Starter Bean");
		}
	}
	
	
	/**
	 * Undeploy the JADL service corresponding to the given Action Description.
	 * 
	 * @param service		some Action Description for a JADL Service
	 * @return				undeployment successful?
	 */
	public boolean undeploy(IActionDescription service) {
		if (service != null) {
			// search for service provider's undeploy action, if any
			IActionDescription undeployAction = findAction(ACTION_UNDEPLOY, service.getProviderDescription());
			
			// undeploy service, if action was found
			if (undeployAction != null) {
				String serviceName = service.getName();
				ActionResult result = invokeAndWaitForResult(undeployAction, new Serializable[] {serviceName});
				return result.getFailure() == null;
			}
		}
		return false;
	}
	
	
	/**
	 * Search for an Action provided by a specific agent.
	 * 
	 * @param actionName	name of the action to find
	 * @param provider		the agent to provide the action
	 * @return				the desired action, or null
	 */
	private IActionDescription findAction(String actionName, IAgentDescription provider) {
		IActionDescription template = new Action(actionName);
		template.setProviderDescription(provider);
		return thisAgent.searchAction(template);
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
	public Serializable[] invokeService(IActionDescription service, Serializable... parameters) throws Exception {
		ActionResult result = invokeAndWaitForResult(service, parameters);
		if (result.getFailure() != null) {
			if (result.getFailure() instanceof Exception) {
				Exception exception = (Exception) result.getFailure();
				exception.printStackTrace();
				throw exception;
			} else {
				throw new Exception(result.getFailure().toString());
			}
		}
		return result.getResults();
	}

}
