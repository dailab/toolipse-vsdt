package de.dailab.vsdt.trafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is holding both the source and target models of the transformation.
 * Instances of this class are used to carry the models from one stage of the trans-
 * formation to the next. 
 * 
 * @author kuester
 */
public class MappingWrapper {
	
	private final Object sourceModel;
	
	private final List<Object> targetModels= new ArrayList<Object>();
	
	private final Map<Object, Object> mappedElements= new HashMap<Object, Object>();
	
	public MappingWrapper(Object object) {
		this.sourceModel= object;
	}

	/**
	 * put key-value pair into the mapping table
	 */
	public void map(Object key, Object value) {
		if (key != null && value != null) {
			if (! mappedElements.containsKey(key)) {
				mappedElements.put(key,value);
			}	
		}
	}
	
	/**
	 * @param key	some eObject that has been mapped prior
	 * @return		result of the key's mapping
	 */
	public Object getMapping(Object key) {
		if (key != null && mappedElements.containsKey(key)) {
			return mappedElements.get(key);
		}
		return null;
	}
	
	public Object getSourceModel() {
		return sourceModel;
	}
	
	public List<Object> getTargetModels() {
		return targetModels;
	}
	
	public Map<Object, Object> getMappedElements() {
		return mappedElements;
	}

}
