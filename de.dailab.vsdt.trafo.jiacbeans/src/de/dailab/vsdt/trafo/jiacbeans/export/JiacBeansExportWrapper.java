package de.dailab.vsdt.trafo.jiacbeans.export;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	
	private final Map<JavaCode, Pool> modelPoolMap;
	
	private final List<JavaCode> javaFiles;
	
	private File baseDirectory;
	
	public JiacBeansExportWrapper(BusinessProcessSystem bps) {
		super(bps);
		javaFiles = new ArrayList<JavaCode>();
		modelPoolMap = new TreeMap<JavaCode, Pool>();
	}
	
	public void setBaseDirectory(File base){
		baseDirectory = base;
	}
	
	public void map(Object key, Object value) {
		super.map(key, value);
		if (key instanceof Pool && value instanceof JavaCode) {
			modelPoolMap.put((JavaCode) value, (Pool) key);
		}
	}
	
	public Pool getPool(JavaCode model) {
		return model != null ? modelPoolMap.get(model) : null;
	}
	
	public List<JavaCode> getJavaFiles() {
		return javaFiles;
	}
	
}	
