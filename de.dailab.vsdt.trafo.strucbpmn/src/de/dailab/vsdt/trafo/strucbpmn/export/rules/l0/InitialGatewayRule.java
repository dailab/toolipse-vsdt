package de.dailab.vsdt.trafo.strucbpmn.export.rules.l0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Initial Gateway Rule
 * 
 * This rule is intended to add an initial gateway splitting all concurrent/alternative flows
 * in the case of business process diagrams with multiple start events. The Gateway will be connected
 * with sequence flows to the start events. This will not alter the semantics of the diagram, although
 * the resulting diagram used for the transformation will be illegal according to the BPMN specification.
 * 
 * The benefit of this rule is that there will be no need anymore for a dedicated OpenStartBlockRule.
 * 
 * NOTE: actually, not only start events are taken into account, but also other FlowObjects with no outgoing
 * Sequence Flows
 * 
 * PATTERN: multiple ending flow objects in the same container
 * 
 * EFFECT: a gateway is created and inserted before the flow objects, forking all flows
 */
public class InitialGatewayRule extends AbstractVsdtRule {
	
	protected FlowObjectContainer _container= null;
	protected FlowObject _start1= null;
	protected FlowObject _start2= null;

	public static final String INITIAL_GATEWAY= "__INITIAL_GATEWAY__";
	
	private final int CONTAINER= 0,
					  START1= 1,
					  START2= 2;
	
	@Override
	protected void resetVars() {
		_container= null;
		_start1= null;
		_start2= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	
	@Override
	protected void apply() {
		// the pattern of this rule requires two starting FlowObjects.
		// now find ALL starting FlowObjects in the process
		List<FlowObject> startingFlowObjects= new ArrayList<FlowObject>();
		for (FlowObject flowObject : _container.getContainedFlowObjects()) {
			if (flowObject.isStartingNode()) {
				startingFlowObjects.add(flowObject);
			}
		}
		
		//create gateway
		Gateway gateway= VsdtFactory.eINSTANCE.createGateway();
		gateway.setName(INITIAL_GATEWAY);
		gateway.setGatewayType(GatewayType.COMPLEX);
		_container.getContainedFlowObjects().add(gateway);
		
		//create sequence flows
		BusinessProcessDiagram bpd= gateway.getPool().getParent();
		for(FlowObject flowObject : startingFlowObjects) {
			SequenceFlow sequenceFlow= VsdtFactory.eINSTANCE.createSequenceFlow();
			sequenceFlow.setSource(gateway);
			sequenceFlow.setTarget(flowObject);
			bpd.getConnections().add(sequenceFlow);
		}
	}
	
	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_container=	(FlowObjectContainer)	matches.get(CONTAINER);
		_start1= 	(FlowObject) 			matches.get(START1);
		_start2= 	(FlowObject) 			matches.get(START2);
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
			addVariableType(bpmn.getFlowObject(), lhsVariables); // START 1
			addVariableType(bpmn.getFlowObject(), lhsVariables); // START 2
			
			addInjectivityQuery(lhsVariables, START1, START2);
			addTargetQuery(lhsVariables, CONTAINER, START1, bpmn.getFlowObjectContainer_ContainedFlowObjects());
			addTargetQuery(lhsVariables, CONTAINER, START2, bpmn.getFlowObjectContainer_ContainedFlowObjects());
			
			//reduce domains
			for (Iterator<EObject> iter = lhsVariables.get(CONTAINER).getDomain().iterator(); iter.hasNext();) {
				FlowObjectContainer foc= (FlowObjectContainer) iter.next();
				if ((foc instanceof AbstractProcess) && ((AbstractProcess) foc).isAdHoc()) {
					iter.remove();
				}
			}
			for (Iterator<EObject> iter = lhsVariables.get(START1).getDomain().iterator(); iter.hasNext();) {
				FlowObject flowObject= (FlowObject) iter.next();
				if (! flowObject.isStartingNode()) {
					iter.remove();
				}
			}
			for (Iterator<EObject> iter = lhsVariables.get(START2).getDomain().iterator(); iter.hasNext();) {
				FlowObject flowObject= (FlowObject) iter.next();
				if (! flowObject.isStartingNode()) {
					iter.remove();
				}
			}
		}

		@Override
		protected void initNACVariables() {
		}

	}
	
}