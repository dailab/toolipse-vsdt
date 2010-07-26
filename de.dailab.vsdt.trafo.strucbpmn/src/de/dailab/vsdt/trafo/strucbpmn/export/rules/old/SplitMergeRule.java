package de.dailab.vsdt.trafo.strucbpmn.export.rules.old;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Split Merge Rule
 * 
 * PATTERN: ...
 * 
 * EFFECT: ... 
 */
@Deprecated
public class SplitMergeRule extends AbstractVsdtRule {
		
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
//		Gateway _fork=				(Gateway)		matches.get(FORK);
		Gateway _merge=				(Gateway)		matches.get(MERGE);

		//create new gateway
		Gateway merge2= VsdtFactory.eINSTANCE.createGateway();
		merge2.setName(_merge.getName() + SUFFIX_SPLIT);
		merge2.setGatewayType(_merge.getGatewayType());
		_block.getParent().getContainedFlowObjects().add(merge2);
		
		//redirect SeqFlows
		merge2.getOutgoingSeq().addAll(_block.getOutgoingSeq());
		merge2.getIncomingSeq().addAll(_merge.getIncomingSeq());
		
		//connect gateways with new SeqFlow
		SequenceFlow seqFlow2= VsdtFactory.eINSTANCE.createSequenceFlow();
		seqFlow2.setSource(_block);
		seqFlow2.setTarget(merge2);
		_merge.getPool().getParent().getConnections().add(seqFlow2);
	}
	
	
	@Override
	public void initLHSVariables() {
		
		addVariable(lhsVariables, bpmn.getSequenceFlow(), 4);	// SEQFLOW11
		addVariable(lhsVariables, bpmn.getFlowObject(), 2);		// FLOWOBJECT1
		addVariable(lhsVariables, struc.getBpmnBlock());		// BLOCK
		addVariable(lhsVariables, bpmn.getGateway(), 2);		// FORK
		
		//queries
		addInjectivityConstraint(lhsVariables,FORK,MERGE);
		addInjectivityConstraint(lhsVariables, FLOWOBJECT1, FLOWOBJECT2);

		addBranchTargetQueries(lhsVariables, FORK, SEQFLOW11, FLOWOBJECT1, SEQFLOW12, MERGE);
		addBranchTargetQueries(lhsVariables, FORK, SEQFLOW21, FLOWOBJECT2, SEQFLOW22, BLOCK);
		
		addReferenceConstraint(lhsVariables, BLOCK, MERGE, struc.getBpmnBlock_SecondGateway());
	}
	
	@Override
	protected void initNACVariables() {
	}
}