package de.dailab.es;

/**
 * This class extends the ESEngine so it is {@link Runnable} and can be started
 * and stopped, until an adequate result has been achieved. Further, it can be
 * linked to an {@link AbstractESFrame}, so the currently best individual and 
 * its quality can be visualized in the Frame. 
 * 
 * @see ESEngine
 * @see ESModel
 * @see AbstractESFrame
 * 
 * @author kuester
 *
 * @param <T>	Class describing the individuals
 */
public class ESRunner<T> extends ESEngine<T> implements Runnable {

	/** thread to run the optimization */
	private Thread thread = null;
	
	/** where to visualize the currently best individual (optional) */
	private final ESObserver<T> observer;
	
	/** maximum number of generations, or null */
	private int max_generations= -1;
	
	/**
	 * Create new ESRunner
	 * 
	 * @param model			domain model to optimize
	 * @param observer		observer for visualization (optional)
	 */
	public ESRunner(ESModel<T> model, ESObserver<T> observer, Integer generations) {
		super(model);
		this.observer= observer;
	}
	
	/**
	 * Start ESRunner in a new Thread. Note that you should call the setup
	 * method before!
	 * 
	 * @param generations	maximum number of generations, or null
	 */
	public void start(int generations) {
		this.max_generations = generations > 0 ? generations : -1;
		thread= new Thread(this);
		thread.start();
	}
	
	/**
	 * Stop ESRunner
	 */
	public void stop() {
		if (thread != null) {
			thread.interrupt();
		}
	}
	
	/**
	 * Wait for the ESRunner to complete. Can only be called if a maximum number
	 * of generations has been set!
	 */
	public void join() {
		if (max_generations > 0 && isRunning()) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.err.println("Thread Interrupted.");
			}
		}
	}

	/**
	 * @return	whether the ESRunner is currently running
	 */
	public boolean isRunning() {
		return thread != null && thread.isAlive();
	}

	/**
	 * Create one generation after another until the runner is stopped,
	 * optionally display the currently best individual on the GUI.
	 */
	@Override
	public void run() {
		int generation= 0;
		do {
			// generate new generation
			boolean didImprove = generateNext();

			// update GUI?
			if (observer != null) {
				observer.setBest(getBest(), generation, didImprove);
			}
			// repeat
			generation++;
			
		} while (! thread.isInterrupted() && (max_generations <= 0 || generation <= max_generations));
	}

}
