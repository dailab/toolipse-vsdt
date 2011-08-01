package de.dailab.vsdt.trafo.jiacbeans.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import jiacbeans.AgentBean;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.impl.BpmnExportWrapper;
import de.dailab.vsdt.trafo.jiacbeans.util.JavaCode;

/**
 * Maintains a mapping from resulting models back to the original pools.
 * 
 * @author kuester
 */
public class JiacBeansExportWrapper extends BpmnExportWrapper {
	
	private final Map<AgentBean, Pool> modelPoolMap;
	
	private final List<AgentBean> beans;
	
	private File baseDirectory;
	
	public JiacBeansExportWrapper(BusinessProcessSystem bps) {
		super(bps);
		beans = new ArrayList<AgentBean>();
		modelPoolMap = new TreeMap<AgentBean, Pool>();
	}
	
	public void setBaseDirectory(File base){
		baseDirectory = base;
	}
	
	public void map(Object key, Object value) {
		super.map(key, value);
		if (key instanceof Pool && value instanceof AgentBean) {
			modelPoolMap.put((AgentBean) value, (Pool) key);
		}
	}
	
	public Pool getPool(JavaCode model) {
		return model != null ? modelPoolMap.get(model) : null;
	}
	
	public List<AgentBean> getBeans() {
		return beans;
	}
	
}	
