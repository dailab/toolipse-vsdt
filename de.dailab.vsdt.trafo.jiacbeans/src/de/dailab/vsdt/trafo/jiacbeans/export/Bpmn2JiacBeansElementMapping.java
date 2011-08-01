package de.dailab.vsdt.trafo.jiacbeans.export;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import jiacbeans.ActivityMethod;
import jiacbeans.AgentBean;
import jiacbeans.JiacbeansFactory;
import jiacbeans.Method;
import jiacbeans.Script;
import jiacbeans.Sequence;
import jiacbeans.While;
import jiacbeans.WorkflowMethod;
import jiacbeans.impl.JiacbeansFactoryImpl;
import jiacbeans.impl.MethodImpl;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.impl.BpmnElementMapping;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;

/**
 * BPMN to JIAC TNG JADL visitor. This visitor is performing a top-down pass of 
 * the BPMN model. This way it creates the element mapping for all the elements 
 * passed on the way.
 * 
 * @author tkuester
 */
public class Bpmn2JiacBeansElementMapping extends BpmnElementMapping {
	
	final JiacbeansFactory beansFac = JiacbeansFactory.eINSTANCE;
	
	String _currentService;
	AgentBean _currentBean;
	
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
			AgentBean bean = visitPool(pool);
//			wrapper.map(pool, jc);
			getWrapper().getBeans().add(bean);
		}
	}
	
	private AgentBean visitPool(Pool pool) {
		TrafoLog.trace("Visiting Pool '" + pool.getName() + "'"); 
//		_currentBean = new JavaCode(pool.getName()+"."+_currentService+"_"+pool.getName());
//		_currentBean.setSuperClass("de.dailab.jiactng.agentcore.AbstractAgentBean");
		_currentBean = beansFac.createAgentBean();
		_currentBean.setPackageName(pool.getName());
		_currentBean.setName(_currentService+"_"+pool.getName());
		
		WorkflowMethod workflow = beansFac.createWorkflowMethod();
		workflow.setName(pool.getParent().getName());
		_currentBean.addMethod(workflow);
		writeWorkflowSequence(workflow, pool.getGraphicalElements());
		return _currentBean;
	}
	
	private void writeWorkflowSequence(WorkflowMethod workflow, List<FlowObject> flowObjects){
		Sequence seq = beansFac.createSequence();
		workflow.setContent(seq);
		for(FlowObject obj : flowObjects){
			seq.getScripts().add(visitFlowObject(obj));
		}
	}
	
	private Script visitFlowObject(FlowObject flowObject){
		Script script = beansFac.createScript();
		script.setCode("");
		//delegate to specialized methods
		System.out.println(flowObject.getClass());
		if (flowObject instanceof Event) {
			Event event= (Event) flowObject;
			return visitEvent(event);
		}
		if (flowObject instanceof Activity) {
			Activity activity=(Activity) flowObject;
			return visitActivity(activity);
		}
		if (flowObject instanceof Gateway) {
			Gateway gateway= (Gateway) flowObject;
			return visitGateway(gateway);
		}
		//special structured BPMN elements
		if (flowObject instanceof BpmnSequence) {
			BpmnSequence bpmnSequence = (BpmnSequence) flowObject;
			return visitBpmnSequence(bpmnSequence);
		}
		if (flowObject instanceof BpmnBlock) {
			BpmnBlock bpmnBlock = (BpmnBlock) flowObject;
			return visitBpmnBlock(bpmnBlock);
		}
		if (flowObject instanceof BpmnLoopBlock) {
			BpmnLoopBlock bpmnLoopBlock = (BpmnLoopBlock) flowObject;
			return visitBpmnLoopBlock(bpmnLoopBlock);
		}
		return script;
	}
	
	private Script visitBpmnBlock(BpmnBlock block){
		TrafoLog.trace("Visiting BpmnBlock");
		Gateway fork = block.getFirstGateway();
		Sequence seq = beansFac.createSequence();
//		
//		switch (fork.getGatewayType()) {
//			case AND:
//				break;
//			case OR:
//				break;
//			case XOR_DATA:
//				break;
//			case XOR_EVENT:
//				break;
//			case COMPLEX:
//				break;
//		}
		for(BpmnBranch branch : block.getElements()){
			seq.getScripts().add(visitFlowObject((FlowObject)branch.getElement()));
		}
		return seq;
	}
	
	private Script visitBpmnLoopBlock(BpmnLoopBlock block){
		TrafoLog.trace("Visiting BpmnLoopBlock");
		Script untilPart= visitFlowObject(block.getFirstBranch().getElement());
		Script whilePart= visitFlowObject(block.getSecondBranch().getElement());
		
		String condition = "";
		// compose and parse loop condition expression
		if (block.getSecondBranch().getCondition() != null) {
			condition = block.getSecondBranch().getCondition().getExpression();
		} else {
			//use negated exit condition
			condition = "! (" + block.getExitBranch().getCondition().getExpression() + ")";
		}
		
		condition.replaceAll("and", "&&");
		condition.replaceAll("or", "||");
		
		// assemble loop body
		Sequence loopBody= beansFac.createSequence();
		if (whilePart != null) {
			loopBody.getScripts().add(whilePart);
		}
		if (untilPart != null) {
			loopBody.getScripts().add(untilPart);
		}
		
		While loop = beansFac.createWhile();
		loop.setCondition(condition);
		loop.setContent(loopBody);
		
		// IV. ASSEMBLE SEQUENCE HOLDING THE LOOP (and return it)
		if (untilPart == null) {
			// only the loop
			return loop;
		} else {
			// a sequence holding a copy of activity 1 and the loop
			Sequence sequence = beansFac.createSequence();
			sequence.getScripts().add((Script) EcoreUtil.copy(untilPart));
			sequence.getScripts().add(loop);
			return sequence;
		}
	}
	
	private Script visitBpmnSequence(BpmnSequence bpmnSequence) {
		TrafoLog.trace("Visiting BpmnSequence");
		Sequence seq = beansFac.createSequence();
		for (FlowObject flowObject :  bpmnSequence.getElements()) {
			seq.getScripts().add(visitFlowObject(flowObject));
		}
		return seq;
	}
	
	private Script visitEvent(Event e){
		TrafoLog.trace("Visiting Event '" + e.getName() + "'");
		//TODO implement this
		Script script = beansFac.createScript();
		script.setCode("");//empty
		return script;
	}
	
	private Script visitActivity(Activity a){
		TrafoLog.trace("Visiting Activity '" + a.getName() + "'");
		ActivityMethod method = beansFac.createActivityMethod();
		method.setName(a.getName());
		method.setIsStatic(false);
		method.setVisibility(MethodImpl.PRIVATE);
		_currentBean.addMethod(method);
		Script script = beansFac.createScript();
		script.setCode(a.getName()+"();");
		return script;
	}
	
	private Script visitGateway(Gateway g){
		//TODO implement this
		Script script = beansFac.createScript();
		script.setCode("");//empty
		return script;
	}
	@Override
	public void initialize() {
	}

}
