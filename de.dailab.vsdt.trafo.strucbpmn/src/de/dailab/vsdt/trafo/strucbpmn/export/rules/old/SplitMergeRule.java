package de.dailab.vsdt.trafo.strucbpmn.export.rules.old;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Split Merge Rule
 * 
 * PATTERN: ...
 * 
 * EFFECT: ... 
 */
@Deprecated
public class SplitMergeRule extends AbstractVsdtRule {
	
	protected SequenceFlow	_seqFlow11= null;
	protected SequenceFlow	_seqFlow12= null;
	protected SequenceFlow	_seqFlow21= null;
	protected SequenceFlow	_seqFlow22= null;
	protected FlowObject	_flowobject1= null;
	protected FlowObject	_flowobject2= null;
	protected BpmnBlock		_block= null;
	protected Gateway		_fork= null;
	protected Gateway		_merge= null;
	
	@Override
	protected void resetVars() {
		_seqFlow11= null;
		_seqFlow12= null;
		_seqFlow21= null;
		_seqFlow22= null;
		_flowobject1= null;
		_flowobject2= null;
		_block= null;
		_fork= null;
		_merge= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}
	
	/**
	 * - create new merging gateway
	 * - reconnect sequence flows
	 * - connect gateways with sequence flow
	 */
	@Override
	protected void apply() {

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
	protected void setWeightedLHS(List<EObject> matches){
		_seqFlow11=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW11);
		_seqFlow12=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW12);
		_seqFlow21=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW21);
		_seqFlow22=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW22);
		_flowobject1=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECT1);
		_flowobject2=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECT2);
		_block=			(BpmnBlock)		matches.get(RuleWrapper.BLOCK);
		_fork=			(Gateway)		matches.get(RuleWrapper.FORK);
		_merge=			(Gateway)		matches.get(RuleWrapper.MERGE);
	}
	
	
	/**
	 * wrapper class for this rule
	 * 
	 * @author tkuester
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
			
		public static final int SEQFLOW11= 0,
								SEQFLOW12= 1,
								SEQFLOW21= 2,
								SEQFLOW22= 3,
								FLOWOBJECT1= 4,
								FLOWOBJECT2= 5,
								BLOCK= 6,
								FORK= 7,
								MERGE= 8;
		
		@Override
		public void initLHSVariables() {
			
			addVariableType(bpmn.getSequenceFlow(), lhsVariables, 4);	// SEQFLOW11
			addVariableType(bpmn.getFlowObject(), lhsVariables, 2);		// FLOWOBJECT1
			addVariableType(struc.getBpmnBlock(), lhsVariables);		// BLOCK
			addVariableType(bpmn.getGateway(), lhsVariables, 2);		// FORK
			
			//queries
			addInjectivityQuery(lhsVariables,FORK,MERGE);
			addInjectivityQuery(lhsVariables, FLOWOBJECT1, FLOWOBJECT2);

			addBranchTargetQueries(lhsVariables, FORK, SEQFLOW11, FLOWOBJECT1, SEQFLOW12, MERGE);
			addBranchTargetQueries(lhsVariables, FORK, SEQFLOW21, FLOWOBJECT2, SEQFLOW22, BLOCK);
			
			addTargetQuery(lhsVariables, BLOCK, MERGE, struc.getBpmnBlock_SecondGateway());
		}
		
		@Override
		protected void initNACVariables() {
		}
	}
}