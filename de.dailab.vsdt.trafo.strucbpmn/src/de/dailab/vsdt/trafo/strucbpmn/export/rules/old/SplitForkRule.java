package de.dailab.vsdt.trafo.strucbpmn.export.rules.old;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Split Merge Rule
 * 
 * PATTERN: ...
 * 
 * EFFECT: ... 
 */
@Deprecated
public class SplitForkRule extends AbstractVsdtRule {
		
	public static final int SEQFLOW11= 0,
							SEQFLOW12= 1,
							SEQFLOW21= 2,
							SEQFLOW22= 3,
							FLOWOBJECT1= 4,
							FLOWOBJECT2= 5,
							BLOCK= 6,
							FORK= 7,
							MERGE= 8;
	
	/**
	 * - create new merging gateway
	 * - reconnect sequence flows
	 * - connect gateways with sequence flow
	 * - create new condition for that seqFlow
	 */
	@Override
	protected void apply(List<EObject> matches){
//		SequenceFlow _seqFlow11=	(SequenceFlow)	matches.get(SEQFLOW11);
//		SequenceFlow _seqFlow12=	(SequenceFlow)	matches.get(SEQFLOW12);
//		SequenceFlow _seqFlow21=	(SequenceFlow)	matches.get(SEQFLOW21);
//		SequenceFlow _seqFlow22=	(SequenceFlow)	matches.get(SEQFLOW22);
//		FlowObject _flowobject1=	(FlowObject)	matches.get(FLOWOBJECT1);
//		FlowObject _flowobject2=	(FlowObject)	matches.get(FLOWOBJECT2);
		BpmnBlock _block=			(BpmnBlock)		matches.get(BLOCK);
		Gateway _fork=				(Gateway)		matches.get(FORK);
//		Gateway _merge=				(Gateway)		matches.get(MERGE);

		//create new gateway
		Gateway fork2= VsdtFactory.eINSTANCE.createGateway();
		fork2.setName(_fork.getName() + SUFFIX_SPLIT);
		_block.getParent().getContainedFlowObjects().add(fork2);
		
		fork2.setGatewayType(_fork.getGatewayType());
		
		//redirect SeqFlows
		fork2.getIncomingSeq().addAll(_block.getIncomingSeq());
		fork2.getOutgoingSeq().addAll(_fork.getOutgoingSeq());
		
		//connect gateways with new SeqFlow
		SequenceFlow seqFlow2= VsdtFactory.eINSTANCE.createSequenceFlow();
		seqFlow2.setSource(fork2);
		seqFlow2.setTarget(_block);
		_fork.getPool().getParent().getConnections().add(seqFlow2);
		
		DisjunctiveExpression disjunctive= StrucBpmnFactory.eINSTANCE.createDisjunctiveExpression();
		for (SequenceFlow sf : _fork.getOutgoingSeq()) {
			if (sf.getConditionExpression() != null && sf.getConditionExpression().getExpression() != null) {
				disjunctive.getExpressions().add(sf.getConditionExpression().getExpression());
			}
			if (sf.getConditionExpression() instanceof DisjunctiveExpression) {
				DisjunctiveExpression disj2 = (DisjunctiveExpression) sf.getConditionExpression();
				disjunctive.getExpressions().addAll(disj2.getExpressions());
			}
			if (sf.getConditionType() == ConditionType.DEFAULT) {
				seqFlow2.setConditionType(ConditionType.DEFAULT);
			}
		}
		seqFlow2.setConditionExpression(disjunctive);
	}
	
	@Override
	public void initLHSVariables() {
		
		addVariable(lhsVariables, bpmn.getSequenceFlow(), 4);	// SEQFLOW1s
		addVariable(lhsVariables, bpmn.getFlowObject(), 2);		// FLOWOBJECTs
		addVariable(lhsVariables, struc.getBpmnBlock());		// BLOCK
		addVariable(lhsVariables, bpmn.getGateway(), 2);		// GATEWAYS
		
		//queries
		addInjectivityQuery(lhsVariables,FORK,MERGE);
		addInjectivityQuery(lhsVariables, FLOWOBJECT1, FLOWOBJECT2);

		addBranchTargetQueries(lhsVariables, FORK, SEQFLOW11, FLOWOBJECT1, SEQFLOW12, MERGE);
		addBranchTargetQueries(lhsVariables, BLOCK, SEQFLOW21, FLOWOBJECT2, SEQFLOW22, MERGE);
		
		addTargetQuery(lhsVariables, BLOCK, FORK, struc.getBpmnBlock_FirstGateway());
	}
	
	@Override
	protected void initNACVariables() {
	}
}