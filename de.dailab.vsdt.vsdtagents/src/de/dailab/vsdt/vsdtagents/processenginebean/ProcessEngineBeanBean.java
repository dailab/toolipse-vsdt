package de.dailab.vsdt.vsdtagents.processenginebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.gmf.Util;
import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.ActionResult;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.jiactng.agentcore.ontology.IAgentDescription;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.edit.parts.IVsdtEditPart;
import de.dailab.vsdt.diagram.figures.IDecoratableFigure;
import de.dailab.vsdt.diagram.interpreter.view.EclipseInterpreterObserver;
import de.dailab.vsdt.diagram.interpreter.view.EclipseInterpreterObserver.FlowObjectMarkerDecorator;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.interpreter.State;

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
		
		for (VsdtDiagramEditor editor : editors) {
			BusinessProcessDiagramEditPart editPart = (BusinessProcessDiagramEditPart) ((VsdtDiagramEditor) editor).getDiagramEditPart();
			BusinessProcessDiagram bpd = editPart.getCastedModel();
			
			// XXX this is somewhat wasteful; better iterate the edit parts directly?
			for (TreeIterator<EObject> iter = bpd.eAllContents(); iter.hasNext(); ) {
				EObject next = iter.next();
				
				if (next instanceof IdObject) {
					String id = ((IdObject) next).getId();

					if (allStates.containsKey(id)) {
						IFigure figure = getFigure(editPart, next);
						// MarkerDecorator
						if (figure instanceof IDecoratableFigure) {
							IDecoratableFigure decoratableFigure= (IDecoratableFigure) figure;
							if (! (decoratableFigure.getDecorator() instanceof FlowObjectMarkerDecorator)) {
								decoratableFigure.setDecorator(new FlowObjectMarkerDecorator());
							}
							FlowObjectMarkerDecorator decorator = (FlowObjectMarkerDecorator) decoratableFigure.getDecorator();
							decorator.state = State.valueOf(allStates.get(id));
							figure.repaint();
						}
					}
				}
			}
			// XXX for this to work properly we first have to group all the idobjects per pool
//			for (Entry<EObject, Integer> entry : stepMap.entrySet()) {
//				IFigure figure= getFigure(entry.getKey());
//				if (figure instanceof PolylineConnectionEx) {
//					PolylineConnectionEx connectionFigure = (PolylineConnectionEx) figure;
//					int lastVisited= entry.getValue();
//					if (lastVisited > 0) {
//						connectionFigure.setLineWidth(3);
//						Color color= figure.getForegroundColor();
//						int red= color.getRed();
//						int green= color.getGreen();
//						int blue= (int) (255 * ((float) lastVisited / (float) step));
//						connectionFigure.setForegroundColor(new Color(color.getDevice(), red, green, blue));
//					}
//				}
//			}
		}
		
	}

	/** Map holding the association of EObjects to EditParts */
	protected final Map<EObject, IFigure> figureMap= new HashMap<>();

	/*
	 * copied from {@link EclipseInterpreterObserver}
	 */
	protected final IFigure getFigure(BusinessProcessDiagramEditPart diagramEditPart, EObject eObject) {
		IFigure figure = figureMap.get(eObject);
		if (figure == null) {
			IVsdtEditPart editPart= (IVsdtEditPart) Util.findFirstEditPart(eObject, diagramEditPart, IVsdtEditPart.class);
			if (editPart != null) {
				figure= editPart.getPrimaryShape();
				figureMap.put(eObject, figure);
			}
		}
		return figure;
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
