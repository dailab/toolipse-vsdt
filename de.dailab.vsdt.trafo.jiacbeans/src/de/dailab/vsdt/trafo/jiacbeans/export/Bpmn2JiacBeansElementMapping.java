package de.dailab.vsdt.trafo.jiacbeans.export;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.impl.BpmnElementMapping;
import de.dailab.vsdt.trafo.jiacbeans.export.generated.ElementMappingTemplate;
import de.dailab.vsdt.trafo.jiacbeans.util.JavaCode;

/**
 * BPMN to JIAC TNG JADL visitor. This visitor is performing a top-down pass of 
 * the BPMN model. This way it creates the element mapping for all the elements 
 * passed on the way.
 * 
 * @author tkuester
 */
public class Bpmn2JiacBeansElementMapping extends BpmnElementMapping {
	
	String _currentService; 
	
	public JiacBeansExportWrapper getWrapper(){
		return (JiacBeansExportWrapper)super.wrapper;
	}
	@Override
	protected void visitBusinessProcessSystem(BusinessProcessSystem bps) {
		TrafoLog.trace("Visiting Business Process System '" + bps.getName() + "'");
		
		// visit Business Processes, create JADL scripts
		for (BusinessProcessDiagram bpd : bps.getBusinessProcesses()) {
			visitBusinessProcessDiagram(bpd);
		}
	}
	
	/**
	 * Start the visitor's pass at the top-level business process diagram
	 * 
	 * @param bpd	the business process diagram to be mapped
	 */
	private void visitBusinessProcessDiagram(BusinessProcessDiagram bpd) {
		TrafoLog.trace("Visiting Business Process Diagram '" + bpd.getName() + "'");
		_currentService = bpd.getName();
		// visit Pools and add resulting services to model
		for (Pool pool : bpd.getPools()) {
			JavaCode jc = visitPool(pool);
//			wrapper.map(pool, jc);
			getWrapper().getJavaFiles().add(jc);
		}
	}
	
	public JavaCode visitPool(Pool pool) {
		TrafoLog.trace("Visiting Pool '" + pool.getName() + "'"); 
		JavaCode agentBean = new JavaCode(_currentService+"_"+pool.getName());
		agentBean.setSuperClass("de.dailab.jiactng.agentcore.AbstractAgentBean");
		return agentBean;
	}
	@Override
	public void initialize() {
	}

}
