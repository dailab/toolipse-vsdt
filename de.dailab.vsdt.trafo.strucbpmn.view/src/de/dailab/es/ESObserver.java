package de.dailab.es;

/**
 * Observer to be notifies by ESRunner while running the simulation.
 * 
 * @author kuester
 *
 * @param <T>	Class describing the individuals
 */
public interface ESObserver<T> {

	/**
	 * Be notified of the (new) best individual of the current generation
	 * 
	 * @param best			currently best individual
	 * @param generation	current generation
	 * @param didImprove	whether the best did improve in this generation
	 */
	public void setBest(T best, int generation, boolean didImprove);
	
}
