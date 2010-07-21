package de.dailab.vsdt.trafo.strucbpmn.export.rules.old;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Split Merge Rule
 * 
 * PATTERN: ...
 * 
 * EFFECT: ... 
 */
public class SplitForkRule extends AbstractVsdtRule {
	
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
	 * - create new condition for that seqFlow
	 */
	@Override
	protected void apply() {

		//create new gateway
		Gateway fork2= VsdtFactory.eINSTANCE.createGateway();
		fork2.setName(_fork.getName() + "_2");
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
			
			addVariableType(bpmn.getSequenceFlow(), lhsVariables, 4);	// SEQFLOW1s
			addVariableType(bpmn.getFlowObject(), lhsVariables, 2);		// FLOWOBJECTs
			addVariableType(struc.getBpmnBlock(), lhsVariables);		// BLOCK
			addVariableType(bpmn.getGateway(), lhsVariables, 2);		// GATEWAYS
			
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
}