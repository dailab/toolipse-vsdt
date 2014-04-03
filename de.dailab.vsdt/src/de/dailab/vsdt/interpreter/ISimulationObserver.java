package de.dailab.vsdt.interpreter;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.FlowObject;

/**
 * Interface for observing the current state of the VSDT diagram interpreter.
 * This can be an Eclipse view, highlighting the current state of the interpreter
 * in the Eclipse VSDT editor, or a simple logging appender.
 * 
 * @author kuester
 */
public interface ISimulationObserver {

	enum LogLevel {INFO, WARN, ERROR};

	void logMessage(LogLevel level, String title, String message);
	
	void refresh(int step, Map<EObject, Integer> stepMap, Map<FlowObject, State> stateMap);
	
	void clear();
	
}
