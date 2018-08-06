package de.dailab.vsdt.vsdtagents.processenginebean;

import static de.dailab.vsdt.diagram.interpreter.view.DecorationHelper.decorateEdge;
import static de.dailab.vsdt.diagram.interpreter.view.DecorationHelper.decorateNode;
import static de.dailab.vsdt.diagram.interpreter.view.DecorationHelper.getFigure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.ui.PlatformUI;

import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.ActionResult;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.interpreter.view.EclipseInterpreterObserver;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.interpreter.State;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * Proxy-Bean for invoking actions on ProcessEngineBean, providing a bridge 
 * between the Eclipse View and the actual JIAC VSDT Interpreter Agents.
 * 
 * @author kuester
 */
public class ProcessEngineBeanBean extends AbstractMethodExposingBean {

	// The actions from ProcessEngineBean
	static final String PROVIDER = "de.dailab.jiactng.vsdt.interpreter.ProcessEngineBean#";
	static final String ACTION_REGISTER_RUNTIME = PROVIDER + "registerInterpreterRuntime";
	static final String ACTION_REMOVE_RUNTIME   = PROVIDER + "removeInterpreterRuntime";
	static final String ACTION_GET_RUNTIMES     = PROVIDER + "getAllInterpreters";
	static final String ACTION_GET_ACTIONS      = PROVIDER + "getAllInterpreterActions";
	
	// own actions
	public static final String ACTION_SHOW_STATE = "de.dailab.vsdt.vsdtagents.processenginebean.ProcessEngineBeanBean#showState";

	/*
	 * OWN ACTIONS TO BE INVOKED BY PROCESS ENGINE BEAN
	 */

	/**
	 * Receive interpreter state from process engine bean and set tokens in
	 * currently opened VSDT editor accordingly.
	 * 
	 * Parts of this are more or less copied/adapted from {@link EclipseInterpreterObserver}
	 *
	 * @param allStates		Mapping FlowObject IDs to interpreter State
	 * @param allSteps		mapping Connection IDs to last visited step
	 */
	@Expose(name=ACTION_SHOW_STATE, scope=ActionScope.GLOBAL)
	public void showState(Map<String, String> allStates, Map<String, Integer> allSteps) {
		// get all opened VSDT editors
		List<VsdtDiagramEditor> editors = Stream.of(PlatformUI.getWorkbench().getWorkbenchWindows())
				.flatMap(wbw -> Stream.of(wbw.getPages()))
				.flatMap(wbp -> Stream.of(wbp.getEditorReferences()))
				.map(ref -> ref.getEditor(false))
				.filter(VsdtDiagramEditor.class::isInstance)
				.map(VsdtDiagramEditor.class::cast)
				.collect(Collectors.toList());

		// this can show the state in multiple VSDT editors opened side-by-side at once
		for (VsdtDiagramEditor editor : editors) {
			BusinessProcessDiagramEditPart editPart = (BusinessProcessDiagramEditPart) ((VsdtDiagramEditor) editor).getDiagramEditPart();
			BusinessProcessDiagram bpd = editPart.getCastedModel();
			
			// filter objects by states, get state, and decorate accordingly
			bpd.getPools().stream()
					.flatMap(p -> VsdtHelper.getAllGraphicalElements(p).stream())
					.filter(x -> allStates.containsKey(x.getId()))
					.forEach(x -> decorateNode(getFigure(editPart, x), State.valueOf(allStates.get(x.getId()))));

			// get max step, filter connections by step set, and decorate accordingly
			int maxStep = bpd.getConnections().stream().mapToInt(x -> allSteps.getOrDefault(x.getId(), 0)).max().orElseGet(() -> 1);
			bpd.getConnections().stream()
					.forEach(x -> decorateEdge(getFigure(editPart, x), allSteps.getOrDefault(x.getId(), 0), maxStep));
		}
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
	 * @return					map of running interpreter runtimes (maps id -> toString)
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, String> getRunningInterpreters(IAgentDescription agent) throws Exception {
		Serializable[] result = invokeAction(agent, ACTION_GET_RUNTIMES, 5000);
		return (Map<String, String>) result[0]; 
	}
	
	/**
	 * Get all processes exposed as actions
	 * 
	 * @param agent				the interpreter agent
	 * @return					map of available processes (maps id -> [actions])
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected Map<String, List<Action>> getExposedProcesses(IAgentDescription agent) throws Exception {
		Serializable[] result = invokeAction(agent, ACTION_GET_ACTIONS, 5000);
		return (Map<String, List<Action>>) result[0];
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
	 * Invoke the VSDT Process corresponding to the given Action Description
	 * with the given input parameters. The Service is invoked synchronously and
	 * the result is returned.
	 * 
	 * @param service		some Action Description for an interpreter process
	 * @param parameters	input parameters for the service invocation
	 * @return				result of the service invocation
	 * @throws Exception	any Exception that occurred during the invocation
	 */
	protected Serializable[] invokeProcess(IActionDescription service, Serializable... parameters) throws Exception {
		ActionResult result = invokeAndWaitForResult(service, parameters);
		if (result.getFailure() != null) {
			if (result.getFailure() instanceof Exception) {
				throw (Exception) result.getFailure();
			} else {
				throw new Exception(result.getFailure().toString());
			}
		}
		return result.getResults();
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
