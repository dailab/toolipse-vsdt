package de.dailab.vsdt.trafo.strucbpmn.export.rules.l0;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.strucbpmn.export.AbstractVsdtRule;

/**
 * Insert Gateway Rule
 * 
 * With this rule a flow object with multiple incoming and/or outgoing sequence
 * flows is split up in the flow object alongside with one or two gateways. 
 * This rule is necessary to facilitate the Sequence Rule and the Block Rule. 
 * After the application of this rule each activity will have at most one 
 * incoming and outgoing sequence flow.
 * 
 * PATTERN: a flow object with multiple incoming and/or outgoing sequence flows
 * 
 * EFFECT: a gateway is inserted before and/or after the flow object and
 * connected with the flow object via a sequence flow. the incoming and/or 
 * outgoing sequence flows are redirected to the gateways.
 */
public class InsertGatewayRule extends AbstractVsdtRule {
	
	public static final int FLOWOBJECT= 0;
	
	@Override
	protected void excecute(List<EObject> matches){
		FlowObject _flowObject=	(FlowObject)	matches.get(FLOWOBJECT);
		
		//get container
		FlowObjectContainer container= _flowObject.getParent();
		BusinessProcessDiagram bpd= _flowObject.getPool().getParent();
		String name= _flowObject.getName();
		
		// case1: multiple incoming sequences flows
		if (_flowObject.getIncomingSeq().size() > 1) {
			
			//create gateway
			Gateway gateway= VsdtFactory.eINSTANCE.createGateway();
			gateway.setParent(container);
			gateway.setName(name + SUFFIX_MERGE);
			
			//redirect incoming sequence flows
			gateway.getIncomingSeq().addAll(_flowObject.getIncomingSeq());

			//create sequence flow
			SequenceFlow seqFlow= VsdtFactory.eINSTANCE.createSequenceFlow();
			bpd.getConnections().add(seqFlow);
			
			//connect gateway and activity
			seqFlow.setName(gateway.getName() + "_to_" + name);
			seqFlow.setSource(gateway);
			seqFlow.setTarget(_flowObject);
		}
		
		// case 2: multiple outgoing sequence flows
		if (_flowObject.getOutgoingSeq().size() > 1) {
			
			//create gateway
			Gateway gateway= VsdtFactory.eINSTANCE.createGateway();
			gateway.setParent(container);
			gateway.setName(name + SUFFIX_FORK);
			
			//redirect outgoing sequence flows
			gateway.getOutgoingSeq().addAll(_flowObject.getOutgoingSeq());
			
			//determine gateway type (AND, XOR, and OR allowed here)
			int numberOfConditions= 0;
			for (SequenceFlow seqFlow : gateway.getOutgoingSeq()) {
				if (seqFlow.getConditionType() == ConditionType.EXPRESSION) {
					numberOfConditions++;
				}
			}
			if (numberOfConditions == 0) {
				gateway.setGatewayType(GatewayType.AND);
			} else {
				if (numberOfConditions == 1) {
					gateway.setGatewayType(GatewayType.XOR_DATA);
				} else {
					gateway.setGatewayType(GatewayType.OR);
				}
			}
			
			//create sequence flow
			SequenceFlow seqFlow= VsdtFactory.eINSTANCE.createSequenceFlow();
			bpd.getConnections().add(seqFlow);
			
			//connect gateway and activity
			seqFlow.setName(name + "_to_" + gateway.getName());
			seqFlow.setSource(_flowObject);
			seqFlow.setTarget(gateway);
		}
		
	}
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpmn.getFlowObject()); // FLOWOBJECT
		
		//reduce domains
		for (Iterator<EObject> iter = lhsVariables.get(FLOWOBJECT).getDomain().iterator(); iter.hasNext();) {
			boolean ok= true;
			FlowObject flowObject= (FlowObject) iter.next();
			
			// not a gateway (important to prevent infinite loop!
			ok &= ! (flowObject instanceof Gateway);
			
			//  >1 incoming or outgoing sequences
			ok &= flowObject.getIncomingSeq().size() > 1 || 
					flowObject.getOutgoingSeq().size() > 1;
								
			if (! ok) {
				iter.remove();
			}
		}
	}

	@Override
	protected void initNACVariables() {
	}

}