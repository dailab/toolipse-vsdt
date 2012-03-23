package de.dailab.vsdt.trafo.jiacbeans.export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiacbeans.AgentBean;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.impl.BpmnExportWrapper;

/**
 * Maintains a mapping from resulting models back to the original pools.
 * 
 * @author kuester
 */
public class JiacBeansExportWrapper extends BpmnExportWrapper {
	
	private final Map<AgentBean, Pool> modelPoolMap;
	
	private final List<AgentBean> beans;
	
	public JiacBeansExportWrapper(BusinessProcessSystem bps) {
		super(bps);
		beans = new ArrayList<AgentBean>();
		modelPoolMap = new HashMap<AgentBean, Pool>();
	}
	
	public void map(Object key, Object value) {
		super.map(key, value);
		if (key instanceof Pool && value instanceof AgentBean) {
			//map the bean back to the pool
			modelPoolMap.put((AgentBean) value, (Pool) key);
		}
	}
	
	public Pool getPool(AgentBean model) {
		return model != null ? modelPoolMap.get(model) : null;
	}
	
	public List<AgentBean> getBeans() {
		return beans;
	}
	
	public void addAgentBean(AgentBean bean, Pool pool) {
		map(pool,bean);
		getTargetModels().add(bean);
		beans.add(bean);
	}
	
}	
