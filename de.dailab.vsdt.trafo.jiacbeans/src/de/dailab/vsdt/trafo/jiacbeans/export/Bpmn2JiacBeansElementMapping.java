package de.dailab.vsdt.trafo.jiacbeans.export;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.impl.BpmnElementMapping;
import de.dailab.vsdt.trafo.jiacbeans.export.generated.ElementMappingTemplate;
import de.dailab.vsdt.trafo.jiacbeans.util.JavaCode;
import de.dailab.vsdt.trafo.jiacbeans.util.Method;

/**
 * BPMN to JIAC TNG JADL visitor. This visitor is performing a top-down pass of 
 * the BPMN model. This way it creates the element mapping for all the elements 
 * passed on the way.
 * 
 * @author tkuester
 */
public class Bpmn2JiacBeansElementMapping extends BpmnElementMapping {
	
	String _currentService;
	JavaCode _currentBean;
	
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
	
	private JavaCode visitPool(Pool pool) {
		TrafoLog.trace("Visiting Pool '" + pool.getName() + "'"); 
		_currentBean = new JavaCode(pool.getName()+"."+_currentService+"_"+pool.getName());
		_currentBean.setSuperClass("de.dailab.jiactng.agentcore.AbstractAgentBean");
		//now visiting flow Objects of the pool
		for(FlowObject obj : pool.getGraphicalElements()){
			visitFlowObject(obj);
		}
		return _currentBean;
	}
	
	private void visitFlowObject(FlowObject flowObject){
		//delegate to specialized methods
		if (flowObject instanceof Event) {
			Event event= (Event) flowObject;
			visitEvent(event);
		}
		if (flowObject instanceof Activity) {
			Activity activity=(Activity) flowObject;
			visitActivity(activity);
		}
		if (flowObject instanceof Gateway) {
			Gateway gateway= (Gateway) flowObject;
			visitGateway(gateway);
		}
	}
	
	private void visitEvent(Event e){
	}
	
	private void visitActivity(Activity a){
		TrafoLog.trace("Visiting Activity '" + a.getName() + "'");
		Method method = new Method(Method.PUBLIC, false, false, a.getName());
		_currentBean.addMethod(method);
	}
	
	private void visitGateway(Gateway g){
		
	}
	@Override
	public void initialize() {
	}

}
