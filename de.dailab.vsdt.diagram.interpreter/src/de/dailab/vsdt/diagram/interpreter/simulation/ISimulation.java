package de.dailab.vsdt.diagram.interpreter.simulation;

import java.util.List;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;

/**
 * This interface describes a Simulation, i.e. the stepwise "execution" of a
 * Business Process Diagram.  A Simulation can be controlled manually, asking
 * the user which way to go when there the paths are branching, or it can rely
 * on the internal data, using Properties and Conditions, or it can use real
 * services when executing the several Activities.
 * 
 * @author kuester
 */
public interface ISimulation {

	/**
	 * Start a new simulation for the given BusinessProcessDiagram. Use this
	 * constructor, if you want to simulate a Business Process Diagram without
	 * using the Interpreter View.
	 * 
	 * @param diagram			BusinessProcessDiagram to simulate
	 * @return List of newly readied FlowObjects
	 */
	List<FlowObject> start(BusinessProcessDiagram diagram);

	/**
	 * Start a new simulation for the given BusinessProcessDiagramEditPart. Use
	 * this constructor if you are using the Interpreter View.
	 * 
	 * @param diagramEditPart	Edit Part of the BusinessProcessDiagram to simulate
	 * @return List of newly readied FlowObjects
	 */
	List<FlowObject> start(BusinessProcessDiagramEditPart diagramEditPart);
	
	/**
	 * Stop the currently running simulation.
	 */
	void stop();
	
	/**
	 * Step over the given FlowObject.  Typically, this equals stepping
	 * into and right afterwards stepping out of the selected element.
	 * 
	 * @param flowObject	Some FlowObject being in State READY
	 * @return List of newly readied FlowObjects
	 */
	List<FlowObject> stepOver(FlowObject flowObject);
	
	/**
	 * Step into the given FlowObject.  Tokens have to be consumed from incoming
	 * flows and nested FlowObjects have can be put in the State READY.  The 
	 * Flow Object itself is put into State ACTIVE.
	 * 
	 * @param flowObject	Some FlowObject being in State READY
	 * @return List of newly readied FlowObjects
	 */
	List<FlowObject> stepInto(FlowObject flowObject);

	/**
	 * Step out of the given FlowObject.  Tokens have to be placed on the 
	 * outgoing flows and nested FlowObjects are terminated (put in state IDLE, 
	 * DONE, or FAILED). The Flow Object itself is put into state DONE.
	 * 
	 * @param flowObject	Some FlowObject currently being in State ACTIVE
	 * @return List of newly readied FlowObjects
	 */
	List<FlowObject> stepOut(FlowObject flowObject);
	
	/**
	 * @return		Whether a Simulation is running, or not 
	 */
	boolean isRunning();
	
	/**
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @return				The State the FlowObject currently is in
	 */
	State getState(FlowObject flowObject);

}
