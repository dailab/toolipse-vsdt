package de.dailab.es;

import java.io.IOException;
import java.util.List;

/**
 * Evolution Strategy Model. This interface describes the domain where the
 * evolution strategy based optimization shall take place. It can be seen as
 * the world, or environment to which the individuals have to adapt.
 * 
 * Classes implementing this interface MUST provide methods for creating an
 * initial population, for mutating an individual, and for determining the
 * quality (fitness) of an individual. Further, it SHOULD implement a way to
 * recombine two or more individuals to a new one, but this is not equally well
 * applicable to each domain. Further, it can provide some helper methods to
 * reset, load, or save the current state of the environment.   
 * 
 * @see ESEngine
 * 
 * @author kuester
 *
 * @param <T>	Class describing the individuals
 */
public interface ESModel<T> {

	
	/**
	 * Create a first (random) generation of parents.
	 * 
	 * @param my	number of parents per generation
	 * @return		MY random individuals constituting the first generation
	 */
	public List<T> initialize(int my);
	
	
	/**
	 * Create a mutation of the parent. The mutation should not be a random new
	 * individual but should be more or less 'close' to the parent. For advanced
	 * evolution strategies, the {@link #delta} field can be taken into account,
	 * too, with a high delta leading to more extreme mutations.
	 * 
	 * The parent itself may _not_ be altered in any way, so it can be reused
	 * for creating further offspring or the next generation!
	 * 
	 * @param parent	the parent to mutate
	 * @param delta		how much the offspring may differ from the parent
	 * @return			mutated offspring
	 */
	public T mutate(T parent, double delta);
	
	
	/**
	 * Recombine RHO instances of the given parents to a new individual and
	 * return it. This is a more advanced pattern of evolution. If you do not
	 * know how this can be applied in the given area of application, just
	 * return a copy of one of the parents. The parents should not be altered
	 * in the process of this method!
	 * 
	 * @param parents	list of RHO available parents to recombine
	 * @return			individual recombined from RHO parents
	 */
	public T recombine(List<T> parents);

	
	/**
	 * Get the quality of an object as a _positive_, _non-zero_ double number.
	 * (The number being positive and non-zero is required for calculating the
	 * improvement from one generation to the next). The higher the quality,
	 * the better, or 'fitter', is the individual.
	 * 
	 * Note: In Fact, quality functions often yield a value which is the lower
	 * the better the individual is, and this would also be simpler for the
	 * implementation, as one would not have to revert the list of individuals
	 * after sorting them by their quality. However, for the sake of intuition
	 * we will stick with this notion of quality.
	 * 
	 * @param individual	some individual
	 * @return				quality of the individual (the higher the better)
	 */
	public double getQuality(T individual);
	
	
	/**
	 * Reset the model.
	 */
	public void clear();
	
	
	/**
	 * Load model from file. Does not have to be implemented
	 * 
	 * @param pathToFile	path to the file to load
	 * @throws IOException
	 */
	public void load(String pathToFile) throws IOException;

	
	/**
	 * Save model to file. This method is useful, but does not have to be 
	 * implemented.
	 * 
	 * @param pathToFile	path to the file to load
	 * @throws IOException
	 */
	public void save(String pathToFile) throws IOException;
	
}
