package de.dailab.vsdt.trafo.jiacv.export.stages;

import java.util.HashMap;
import java.util.Map;

import de.dailab.jiactng.jadl.Agent;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.impl.BpmnExportWrapper;

/**
 * Maintains a mapping from resulting models back to the original pools.
 * 
 * @author kuester
 */
public class JiacVExportWrapper extends BpmnExportWrapper {

	private final Map<Agent, Pool> modelPoolMap;
	
	public JiacVExportWrapper(BusinessProcessSystem bps) {
		super(bps);
		modelPoolMap= new HashMap<Agent, Pool>();
	}

	@Override
	public void map(Object key, Object value) {
		super.map(key, value);
		if (key instanceof Pool && value instanceof Agent) {
			modelPoolMap.put((Agent) value, (Pool) key);
		}
	}
	
	public Pool getPool(Agent model) {
		return model != null ? modelPoolMap.get(model) : null;
	}
	
}
