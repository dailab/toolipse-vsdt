package de.dailab.vsdt.interpreter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.interpreter.ISimulationObserver.LogLevel;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * Abstract implementation of ISimulation.  This class handles large parts of
 * determining which FlowObjects are ready to be executed and for moving Tokens
 * from and to Sequence Flows.  Further, this class hooks into the editor to 
 * highlight the currently active elements and synchronizing with the InterpreterView.
 * 
 * This class implements all the methods of the ISimulator interface, including
 * the various step methods, and provides a number of abstract methods to be
 * implemented by subclasses for handling the "details".
 * 
 * Internally, the simulation works similarly to a PetriNet, regarding the
 * flow objects as transitions and connections as states, which can hold a number
 * of tokens. 
 * 
 * @author kuester
 */
public abstract class AbstractSimulation implements ISimulation {
	
	/** This Map holds the association of States to FlowObjects */
	protected final Map<FlowObject, State> stateMap;
	
	/** This Map holds the association of Tokens to Connections */
	protected final Map<ConnectingObject, Integer> tokenMap;
	
	/** Another Map, holding information in which step each element has been visited (last) */
	protected final Map<EObject, Integer> stepMap;

	/** observers, e.g. for adding tokens to diagram editor, or for updating interpreter UI */
	protected Set<ISimulationObserver> observers;
	
	/** The number of (full) steps the simulation has already taken. */
	protected int step;
	
	/** perform assignments inside or outside of activity looping */
	protected boolean ASSIGNMENTS_INSIDE_LOOP = false;
	
	/**
	 * Initialize fields
	 */
	public AbstractSimulation() {
		stateMap = new HashMap<>();
		tokenMap = new HashMap<>();
		stepMap = new HashMap<>();
		observers = new HashSet<>();
		step = -1;
	}

	////////////////////////////////////////////////////////////////////////////
	// Interface methods (all final)
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * - initialize step counter
	 * - initialize token and state maps
	 */
	public final List<FlowObject> start(EObject object) {
		System.out.println("Starting Simulation");

		// initialize stuff
		step = 0;
		tokenMap.clear();
		stateMap.clear();
		initialize(object);

		// check diagram
		if (checkDiagram(object)) {
			List<FlowObject> readyFlowObjects = new ArrayList<>();

			// initialize some tables holding the currently activated elements
			// check flow object states, put connections into tokens map
			for (TreeIterator<EObject> contents = object.eAllContents(); contents.hasNext(); ) {
				EObject next = contents.next();
				if (next instanceof FlowObject) {
					FlowObject flowObject = (FlowObject) next;
					
					List<ConnectingObject> connections = new ArrayList<>();
					connections.addAll(flowObject.getIncomingMsg());
					connections.addAll(flowObject.getIncomingSeq());
					connections.addAll(flowObject.getOutgoingMsg());
					connections.addAll(flowObject.getOutgoingSeq());
					for (ConnectingObject connection : connections) {
						tokenMap.put(connection, 0);
					}
					
					stateMap.put(flowObject, State.IDLE);
					if (updateState(flowObject)) {
						readyFlowObjects.add(flowObject);
					}
				}
			}
			notifyObservers();
			return readyFlowObjects;
		} else {
			return null;
		}
	}

	@Override
	public void addObserver(ISimulationObserver observer) {
		if (observer != null) {
			this.observers.add(observer);
		}
	}

	/**
	 * - reset step counter
	 * - reset states of flow objects (being reflected in the diagram)
	 * - clear token and state maps
	 */
	public final void stop() {
		System.out.println("Stopping Simulation");
		step = -1;
		// clear activation tables
		stateMap.clear();
		tokenMap.clear();
		stepMap.clear();
		// remove markers
		clearObservers();
		// do implementation-specific finalization stuff
		cleanup();
	}
	
	public final boolean isRunning() {
		return step != -1;
	}
	
	public final List<FlowObject> stepOver(FlowObject flowObject) {
		stepInto(flowObject);
		return stepOut(flowObject);
	}

	/**
	 * - increase step counter
	 * - remove tokens from incoming flows
	 * - set state to ACTIVE
	 * - handle start assignments
	 */
	public final List<FlowObject> stepInto(FlowObject flowObject) {
		System.out.println("Stepping Into " + getReadable(flowObject));
		List<FlowObject> result= new ArrayList<>();
		if (isInState(flowObject, State.READY, State.LOOPING_READY)) {
			step++;
			
			// remove tokens from incoming flows
			for (SequenceFlow seqFlow : flowObject.getIncomingSeq()) {
				changeToken(seqFlow, -1);
			}

			// skip assignments when looping
			if (! isInState(flowObject, State.LOOPING_READY) || ASSIGNMENTS_INSIDE_LOOP) {
				// handle start Assignments
				if (! handleAssignments(flowObject, AssignTimeType.START)) {
					return stepFailed(flowObject);
				}
			}

			// set state to ACTIVE_WAITING
			setState(flowObject, State.ACTIVE_WAITING);

			// execute, part I
			try {
				executeBegin(flowObject);
			} catch (Exception e) {
				logMessage(LogLevel.ERROR, "Error stepping into " + flowObject.getNameOrId(), e.getMessage());
				// check whether there is an error boundary event
//				Intermediate error = getEventHandler(flowObject, TriggerType.ERROR);
//				if (error != null) {
//					return stepOver(error);
//				}
				return stepFailed(flowObject);
			}
			
			// possibly set state to ACTIVE_READY
			if (updateState(flowObject)) {
				result.add(flowObject);
			}
		}
		notifyObservers();
		return result;
	}
	
	/**
	 * - handle activity looping
	 * - select outgoing path to take
	 * - handle end assignments
	 * - set state to DONE
	 * - place tokens on outgoing flows
	 * - update states of succeeding flow objects
	 */
	public final List<FlowObject> stepOut(FlowObject flowObject) {
		System.out.println("Stepping out of " + getReadable(flowObject));
		List<FlowObject> result= new ArrayList<>();
		if (isInState(flowObject, State.ACTIVE_READY)) {
			
			// execute, part II
			try {
				executeEnd(flowObject);
			} catch (Exception e) {
				logMessage(LogLevel.ERROR, "Error stepping out of " + flowObject.getNameOrId(), e.getMessage());
				// check if there is error event attached
//				Intermediate error = getEventHandler(flowObject, TriggerType.ERROR);
//				if (error != null) {
//					return stepOver(error);
//				}
				return stepFailed(flowObject);
			}
			
			// handle activity looping
			if (flowObject instanceof Activity && isLooping((Activity) flowObject)) {
				// set state to DONE, and then right back to LOOPING_READY
				setState(flowObject, State.LOOPING_READY);
				if (ASSIGNMENTS_INSIDE_LOOP) {
					// handle end Assignments
					if (! handleAssignments(flowObject, AssignTimeType.END)) {
						return stepFailed(flowObject);
					}
				}
				// XXX invert if / else, remove duplicate assignments handling
				
			} else {
				// handle end Assignments
				if (! handleAssignments(flowObject, AssignTimeType.END)) {
					return stepFailed(flowObject);
				}
				
				// OR-, XOR-Gateway: select outgoing sequence flow(s)
				List<SequenceFlow> seqFlows= needsToSelectPath(flowObject) 
						? selectOutgoingSequenceFlows(flowObject)
						: flowObject.getOutgoingSeq();
				if (seqFlows == null) {
					return result; // no selection; cancel
				}
				
				// set state to DONE
				setState(flowObject, State.DONE);
				
				// place tokens on outgoing sequence flows
				for (SequenceFlow seqFlow : seqFlows) {
					changeToken(seqFlow, +1);
					if (updateState(seqFlow.getTarget())) {
						result.add(seqFlow.getTarget());
					}
					stepMap.put(seqFlow, step);
				}
			}
			// set containing subprocess to ACTIVE_READY
			if (flowObject.getParent() instanceof Activity) {
				if (updateState((Activity) flowObject.getParent())) {
					result.add((Activity) flowObject.getParent());
				}
			}
			// cancel other events after event-based XOR gateway
			// this was previously done in stepInto, but this breaks the automatic interpreter
			// XXX rewrite using streams?
			for (SequenceFlow seqFlow : flowObject.getIncomingSeq()) {
				FlowObject source = seqFlow.getSource();
				if (source instanceof Gateway && 
						((Gateway) source).getGatewayType() == GatewayType.XOR_EVENT) {
					// event-based XOR: remove other tokens, too
					for (SequenceFlow seqFlow2 : source.getOutgoingSeq()) {
						if (seqFlow2.getTarget() != flowObject) {
							setState(seqFlow2.getTarget(), State.IDLE);
						}
					}
				}
			}
		}
		notifyObservers();
		return result;
	}
	
	/**
	 * - shorthand for when stepping into or out of a flow object fails
	 */
	protected List<FlowObject> stepFailed(FlowObject flowObject) {
		setState(flowObject, State.FAILED);
		notifyObservers();
		return Collections.emptyList();
	}

	////////////////////////////////////////////////////////////////////////////
	// Life Cycle methods
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Perform some pre-simulation checks when the simulation is to be started.
	 * CheckDiagram can be thought of as a more rigorous version of isApplicable,
	 * checking not only whether the type of simulation is in principle applicable
	 * to that diagram, but e.g. also whether there are errors in the diagram.
	 * 
	 * @param diagram		The Business Process Diagram to be simulated
	 * @return				Whether there are any Problems with the diagrams
	 */
	protected abstract boolean checkDiagram(EObject object);
	
	/**
	 * Do initialization stuff, reset cached property values, etc.
	 * 
	 * @param bpd			The Business Process Diagram to be simulated
	 */
	protected abstract void initialize(EObject rootObject);
	
	/**
	 * Do implementation-specific clean-up stuff.
	 */
	protected void cleanup() {};
	
	/**
	 * This method is executed at the end of the {@link #stepInto(FlowObject)}
	 * method and after the Start Assignments. Typically, Message handling should
	 * go here, depending on the type of the simulation e.g. placing tokens on 
	 * outgoing Message Flows or Messages, passing values to message parameters, 
	 * etc. Other stuff that has to be done when "executing" an activity may also
	 * go here, for example searching and invoking an actual service.
	 * 
	 * @param flowObject	Some FlowObject being "executed"
	 */
	protected abstract void executeBegin(FlowObject flowObject);
	
	/**
	 * Analogous to {@link #executeBegin(FlowObject)}, this method is executed 
	 * at the beginning of the {@link #stepOut(FlowObject)} method and before the End
	 * Assignments. Typically, Message handling should go here, depending on the 
	 * type of the simulation e.g. removing tokens from incoming Message Flows 
	 * or Messages, reading values from message parameters, etc.. Other stuff 
	 * that has to be done when "executing" an activity may also go here,
	 * for example getting the result from an invoked service.
	 * 
	 * @param flowObject	Some FlowObject being "executed"
	 */
	protected abstract void executeEnd(FlowObject flowObject);
	
	/**
	 * Handle the Objects assignments, if any. The second parameter determines
	 * whether to handle the Start or End assignments..
	 * 
	 * @param eObject	Some FlowObject or the Process
	 * @param assignTime	AssignTime (START or STOP)
	 */
	protected abstract boolean handleAssignments(EObject eObject, AssignTimeType assignTime);
	
	/**
	 * Determine whether the activity shall be looping, e.g. by prompting the
	 * user or by evaluating the loop condition, if any.
	 * 
	 * @param flowObject	Some Activity with Looping != NONE 
	 * @return				Whether this activity shall be repeated
	 */
	protected abstract boolean isLooping(Activity activity);
	
	/**
	 * Set the state of the given FlowObject. This method is intended to not 
	 * only set the state, but also to (recursively) alter the States of related
	 * Flow Objects, e.g. when setting an Embedded Subprocess to ACTIVE, the 
	 * contained Flow Objects and Boundary Events should be set to ready, and
	 * when executing a Boundary Event, the according activity should be set to
	 * failed, etc.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @param state			New State for that FlowObject
	 */
	protected abstract void setState(FlowObject flowObject, State state);
	
	/**
	 * Calculate whether the given FlowObject is ready for execution, i.e. whether
	 * its state can be changed from {@value State#IDLE} to {@value State#READY},
	 * basically checking the tokens on the incoming Sequence Flows, but also 
	 * the activation of the parent element, if any.  Some special cases have to 
	 * be considered, too, such as Service Tasks or Link and Signal Events.
	 * Note: This method should not /change/ the state of that FlowObject or any 
	 * other element.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @return				whether the FlowObject can be set to {@value State#READY}
	 */
	protected abstract boolean calculateIsReady(FlowObject flowObject);
	
	/**
	 * Analogous to {@link #calculateIsReady(FlowObject)}, this method checks
	 * whether the given FlowObject can finish (i.e. change it's state from 
	 * {@value State#ACTIVE_WAITING} to {@value State#ACTIVE_READY}.  Depending
	 * on the type of simulation, this check may involve checking for tokens on
	 * Messages or Message Flows, and for the state of children, if any.
	 * Note: This method should not /change/ the state of that FlowObject or any 
	 * other element.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @return				whether the FlowObject can be set to {@value State#ACTIVE_READY}
	 */
	protected abstract boolean calculateCanFinish(FlowObject flowObject);
	
	/**
	 * Select the outgoing paths to take for the given FlowObject, e.g. an XOR
	 * Gateway, for instance by prompting the user to select some or by 
	 * evaluating the Properties and Conditions.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @return				List of SequenceFlows starting the paths to take after this FlowObject
	 */
	protected abstract List<SequenceFlow> selectOutgoingSequenceFlows(FlowObject flowObject);

	////////////////////////////////////////////////////////////////////////////
	// Helper Methods
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Find and return first boundary event of given type, if any, otherwise null.
	 * Parameter is FlowObject so that no instanceof check is needed in the interpreter
	 * methods.
	 *
	 * @param flowObject	the flow object, should be an activity
	 * @param type			the type of event, e.g. Error, Message, etc.
	 * @return				first boundary event with given type, or null
	 */
	protected Intermediate getEventHandler(FlowObject flowObject, TriggerType type) {
		if (flowObject instanceof Activity) {
			Activity activity = (Activity) flowObject;
			for (Intermediate event : activity.getBoundaryEvents()) {
				if (event.getTrigger() == type) {
					return event;
				}
			}
		}
		return null;
	}
	
	/**
	 * Depending on whether the FlowObject is IDLE or ACTIVE_WAITING, check 
	 * whether it can be set to READY or ACTIVE_READY respectively and do so.
	 * 
	 *  @param flowObject	Some FlowObject being part of the Simulation
	 */
	protected final boolean updateState(FlowObject flowObject) {
		if (isInState(flowObject, State.ACTIVE_WAITING, State.ACTIVE_READY)) {
			if (calculateCanFinish(flowObject)) {
				setState(flowObject, State.ACTIVE_READY);
				return true;
			}
		} else {
			if (calculateIsReady(flowObject)) {
				setState(flowObject, State.READY);
				return true;
			} else {
				setState(flowObject, State.IDLE);
			}
		}
		return false;
	}
	
	/**
	 * This method determines whether a path needs to be selected or not.  For
	 * example, a path needs to be selected for an XOR-Data Gateway, while no
	 * path needs to be selected for an AND Gateway.  Somewhat problematic are
	 * the cases of Complex and XOR-Event Gateways.  In the first case, a path
	 * needs to be selected, but this can not be done automatically, so the user
	 * needs to be asked.  In the latter case, the current solution is to select
	 * both path (i.e. to return false in this method) and then to deactivate 
	 * the other paths after one path has been selected.
	 * 
	 * In practice, this could probably be changed to just return whether any of the
	 * outgoing flows has a condition, but it should also work in "manual" simulation.
	 * 
	 * @param flowObject	Some FlowObject, possibly with more than one outgoing SequenceFlow
	 * @return				Whether a path needs to be selected.
	 */
	protected final boolean needsToSelectPath(FlowObject flowObject) {
		if (flowObject instanceof Gateway) {
			GatewayType type = ((Gateway) flowObject).getGatewayType();
			return flowObject.getOutgoingSeq().size() > 1
					&& type != GatewayType.AND
					&& type != GatewayType.XOR_EVENT;
		} else {
			return flowObject.getOutgoingSeq().stream()
					.anyMatch(sf -> sf.getConditionType() != ConditionType.NONE);
		}
	}
	
	/**
	 * Change the tokens for the given Connection. The given delta will be added
	 * to the connections tokens in the token map. A connection can have arbitrarily
	 * many tokens, but not less than zero.
	 * 
	 * @param connection	Some Connection being part of the Simulation
	 * @param delta			Delta to add on the tokens for this connection
	 */
	protected final void changeToken(ConnectingObject connection, int delta) {
		Integer token = tokenMap.get(connection);
		if (token != null) {
			token= token + delta;
		} else {
			token= delta;
		}
		tokenMap.put(connection, token < 0 ? 0 : token);
	}

	public final State getState(FlowObject flowObject) {
		return stateMap.get(flowObject);
	}
	
	public final Collection<FlowObject> getFlowObjects() {
		return new HashSet<>(stateMap.keySet());
	}
	
	public final int getToken(ConnectingObject connection) {
		return tokenMap.get(connection);
	}
	
	public final int getStep(EObject object) {
		return stepMap.get(object);
	}
	
	/*
	 * protected getters for internal state
	 */

	public Map<FlowObject, State> getStateMap() {
		return Collections.unmodifiableMap(stateMap);
	}

	public Map<EObject, Integer> getStepMap() {
		return Collections.unmodifiableMap(stepMap);
	}

	public Map<ConnectingObject, Integer> getTokenMap() {
		return Collections.unmodifiableMap(tokenMap);
	}

	/**
	 * Check whether the given FlowObject is in one of the given states.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @param states		One or more states
	 * @return				Whether the FlowObject is in one of these States
	 */
	protected final boolean isInState(FlowObject flowObject, State... states) {
		for (State state : states) {
			if (stateMap.get(flowObject) == state) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get tabular string with information on current states
	 */
	public final String getStatesString() {
		StringBuilder builder = new StringBuilder();
		builder.append("--- State Table ---" + NL);
		for (FlowObject flowObject : stateMap.keySet()) {
			builder.append(tabulate(15, stateMap.get(flowObject), VsdtHelper.getDescriptiveName(flowObject)));
		}
		return builder.toString();
	}
	
	/**
	 * Get tabular string with information on current tokens
	 */
	public final String getTokensString() {
		StringBuilder builder = new StringBuilder();
		builder.append("--- Token Table ---" + NL);
		for (ConnectingObject connection : tokenMap.keySet()) {
			builder.append(tabulate(10, tokenMap.get(connection), connection.getName()));
		}
		return builder.toString();
	}

	protected void logMessage(ISimulationObserver.LogLevel level, String title, String message) {
		if (level == LogLevel.INFO) {
			System.out.println(title + ": " + message);
		} else {
			System.err.println(title + ": " + message);
		}
		for (ISimulationObserver observer : observers) {
			observer.logMessage(level, title, message);
		}
	}
	
	protected void notifyObservers() {
		for (ISimulationObserver observer : observers) {
			observer.refresh(step, stepMap, stateMap);
		}
	}
	
	protected void clearObservers() {
		for (ISimulationObserver observer : observers) {
			observer.clear();
		}
	}
	
	protected static final String NL = System.getProperty("line.separator");
	
	protected final String tabulate(int width, Object first, Object second) {
		return String.format(String.format("%%-%ds%%s%s", width, NL), first, second);
	}
	
	protected final String getReadable(FlowObject fo) {
		return fo != null ? String.format("%s '%s'", fo.eClass().getName(), fo.getNameOrId()) : "null";
	}

}
