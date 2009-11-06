package de.dailab.vsdt.trafo;

import de.dailab.vsdt.trafo.base.logger.TrafoLog;

/**
 * Each instance of this class represents one stage in a mapping to an executable language,
 * e.g. the Element Mapping to BPEL.  A List of this stages are passed to an Export Wizard
 * and applied sequentially.
 * 
 * @author kuester
 */
public abstract class MappingStage {

	/**
	 * This field is holding the wrapper for the source model and the target models
	 * as well as a map holding the mapping for each individual element. Of course
	 * the fields of this object can be used differently, too, this is up to the 
	 * responsible developer of the mapping.
	 */
	protected MappingWrapper wrapper;

	/**
	 * @return	The wrapper for the source and target models
	 */
	public MappingWrapper getWrapper() {
		return wrapper;
	}
	
	/**
	 * @param wrapper	New Wrapper object. The wrapper should be the same for each stage of the mapping.
	 */
	public void setWrapper(MappingWrapper wrapper) {
		this.wrapper = wrapper;
	}
	
	/**
	 * Do initialization work, if any. Prevents from confusing elements from one transformation
	 * with those from another one when invoking multiple transformations in a row.
	 */
	public abstract void initialize();
	
	/**
	 * Apply the mapping stage on the wrapper, reading (and possibly altering) the source model
	 * and writing one or more target models to one of the lists in the wrapper. Additionally,
	 * this public apply method will do some checks and logging stuff. To implement the apply method,
	 * override the internalApply method instead.
	 * 
	 * @return	Transformation stage successful executed?
	 */
	public final boolean apply() {
		if (wrapper == null || wrapper.getSourceModel() == null) {
			TrafoLog.error("No Source Model specified, aborting");
			return false;
		}
		String name= this.getClass().getName();
		long starttime= System.currentTimeMillis();
		boolean ok= false;
		TrafoLog.debug("<<< Starting " + name);
		//start rule based post transformation
		ok= internalApply();
		TrafoLog.debug(">>> Finished " + name);
		TrafoLog.trace("Duration: " + (System.currentTimeMillis()-starttime) + " ms");
		
		return ok;
	}
	
	/**
	 * @see apply()
	 */
	protected abstract boolean internalApply();


//	/**
//	 * put key-value pair into the mapping table
//	 */
//	public void map(Object key, Object value) {
//		wrapper.map(key, value);
//	}
//	
//	/**
//	 * @param key	some eObject that has been mapped prior
//	 * @return		result of the key's mapping
//	 */
//	public Object getMapping(Object key) {
//		return wrapper.getMapping(key);
//	}
	
}
