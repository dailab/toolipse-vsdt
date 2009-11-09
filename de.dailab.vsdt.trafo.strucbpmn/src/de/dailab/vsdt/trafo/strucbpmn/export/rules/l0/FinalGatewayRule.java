package de.dailab.vsdt.trafo.strucbpmn.export.rules.l0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.base.AbstractRule;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Final Gateway Rule
 * 
 * This rule is intended to add a final gateway merging all concurrent/alternative flows
 * in the case of business process diagrams with multiple end events. The Gateway will be connected
 * with sequence flows to the end events. This will not alter the semantics of the diagram, although
 * the resulting diagram used for the transformation will be illegal according to the BPMN specification.
 * 
 * The benefit of this rule is that there will be no need anymore for a dedicated OpenEndBlockRule and
 * BoundaryEventOpenRule.
 * 
 * NOTE: actually, not only end events are taken into account, but also other FlowObjects with no outgoing
 * Sequence Flows
 * 
 * PATTERN: multiple ending flow objects in the same container
 * 
 * EFFECT: a gateway is created and inserted after the flow objects, merging all flows
 */
public class FinalGatewayRule extends AbstractRule {
	
	protected FlowObjectContainer _container= null;
	protected FlowObject _end1= null;
	protected FlowObject _end2= null;
	
	private final int CONTAINER= 0,
					  END1= 1,
					  END2= 2;
	
	/**
	 * Default constructor.
	 */
	public FinalGatewayRule(EObject root) {
		super(root,"Final Gateway Rule");
	}
	
	@Override
	protected void resetVars() {
		_container= null;
		_end1= null;
		_end2= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	
	@Override
	protected void apply() {
		
		//this rule only said that there are at least two ending FlowObjects.
		//find ALL ending FlowObjects in the process
		List<FlowObject> endingFlowObjects= new ArrayList<FlowObject>();
		for (Iterator<FlowObject> iter = _container.getContainedFlowObjects().iterator(); iter
				.hasNext();) {
			FlowObject flowObject = (FlowObject) iter.next();
			if (flowObject.isEndingNode()) {
				endingFlowObjects.add(flowObject);
			}
		}
		
		//create gateway
		Gateway gateway= VsdtFactory.eINSTANCE.createGateway();
		gateway.setName("Gateway_MERGEALL");
		_container.getContainedFlowObjects().add(gateway);
		
		//create sequence flows
		BusinessProcessDiagram bpd= gateway.getPool().getParentDiagram();
		for(FlowObject flowObject : endingFlowObjects) {
			SequenceFlow sequenceFlow= VsdtFactory.eINSTANCE.createSequenceFlow();
			sequenceFlow.setSource(flowObject);
			sequenceFlow.setTarget(gateway);
			bpd.getConnections().add(sequenceFlow);
		}
	}
	
	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_container=	(FlowObjectContainer)	matches.get(CONTAINER);
		_end1= 		(FlowObject) 			matches.get(END1);
		_end2= 		(FlowObject) 			matches.get(END2);
	}
	
	/**
	 * wrapper for the rule
	 */
	class RuleWrapper extends AbstractVsdtWrapper {

		/**
		 * flow object container with at least two end events inside of it
		 */
		@Override
		public void initLHSVariables() {
			addVariableType(bpmn.getFlowObjectContainer(), lhsVariables); // CONTAINER
			addVariableType(bpmn.getFlowObject(), lhsVariables); // END 1
			addVariableType(bpmn.getFlowObject(), lhsVariables); // END 2
			
			addInjectivityQuery(lhsVariables, END1, END2);
			addTargetQuery(lhsVariables, CONTAINER, END1, bpmn.getFlowObjectContainer_ContainedFlowObjects());
			addTargetQuery(lhsVariables, CONTAINER, END2, bpmn.getFlowObjectContainer_ContainedFlowObjects());
			
			//reduce domains
			for (Iterator<EObject> iter = lhsVariables.get(END1).getDomain().iterator(); iter.hasNext();) {
				FlowObject flowObject= (FlowObject) iter.next();
				if (! flowObject.isEndingNode() ||
						flowObject.getAbstractProcess().isAdHoc()) {
					iter.remove();
				}
			}
			for (Iterator<EObject> iter = lhsVariables.get(END2).getDomain().iterator(); iter.hasNext();) {
				FlowObject flowObject= (FlowObject) iter.next();
				if (! flowObject.isEndingNode()) {
					iter.remove();
				}
			}
		}

		@Override
		protected void initNACVariables() {
		}

	}
	
}