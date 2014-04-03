package de.dailab.vsdt.interpreter;


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
