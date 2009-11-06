package de.dailab.vsdt.diagram.interpreter.simulation;

import org.eclipse.jface.resource.ImageDescriptor;

import de.dailab.vsdt.diagram.interpreter.VsdtInterpreterPlugin;

/**
 * The several States FlowObjects can be in during the simulation.
 * 
 * @author kuester
 */
public enum State {
	
	/** The Flow Object can not be executed and has not been executed yet */
	IDLE,
	
	/** The Flow Object can be executed in the next step */
	READY,
	
	/** This State is used for Activities that are again ready when looping*/
	LOOPING_READY,
	
	/** The Flow Object is waiting for being able to finish */
	ACTIVE_WAITING,
	
	/** The Flow Object is currently being executed and can finish any time */
	ACTIVE_READY,
	
	/** The Flow Object has successfully been executed */
	DONE,
	
	/** Execution of the Flow Object has failed or has been interrupted */
	FAILED;
	
	
	/**
	 * Get an Icon representing this state. This icon can be used both as an
	 * icon for a menu item, e.g. in the InterpreterView, or for the figure in
	 * the diagram itself (although here scalable graphics would be better). 
	 * 
	 * @return		Small Icon according to this State
	 */
	public ImageDescriptor getImageDescriptor() {
		switch (this) {
		case READY:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_READY);
		case ACTIVE_WAITING:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_ACTIVE_WAITING);
		case ACTIVE_READY:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_ACTIVE_READY);
		case DONE: 
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_DONE);
		case FAILED:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_FAILED);
		case LOOPING_READY:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_READY);
		default:
			return VsdtInterpreterPlugin.getImageDescriptor(VsdtInterpreterPlugin.IMAGE_SIM_IDLE);
		}
	}
	
	/**
	 * @return		Whether this is a Ready state
	 */
	public boolean isReadyState() {
		return this == READY || this == LOOPING_READY || this == ACTIVE_READY;
	}
	
	/**
	 * @return		Whether this a an Active state
	 */
	public boolean isActiveState() {
		return this == ACTIVE_READY || this == ACTIVE_WAITING;
	}
}
