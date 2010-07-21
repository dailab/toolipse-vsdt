package de.dailab.vsdt.trafo.strucbpmn.export.rules.old;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Add To Block Rule
 * 
 * PATTERN: ...
 * 
 * EFFECT: ... 
 */
@Deprecated
public class AddToBlockRule extends AbstractVsdtRule {
	
	protected SequenceFlow	_seqFlow1= null;
	protected SequenceFlow	_seqFlow2= null;
	protected FlowObject	_flowobject= null;
	protected BpmnBlock		_block= null;
	protected Gateway		_fork= null;
	protected Gateway		_merge= null;
	
	@Override
	protected void resetVars() {
		_seqFlow1= null;
		_seqFlow2= null;
		_flowobject= null;
		_block= null;
		_fork= null;
		_merge= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}
	
	/**
	 */
	@Override
	protected void apply() {
		/*
		// add condition to block
		Expression condition= CreateBlockRule.getCondition(_seqFlow1);
		if (condition == null) {
			_block.setDefaultElement(_flowobject);
		} else {
			_block.getConditions().put(_flowobject, condition);
		}
		
		// put into block structure
		_block.getElements().add(_flowobject);
		
		//delete sequence flows
		CreateBlockRule.delete(_seqFlow1);
		CreateBlockRule.delete(_seqFlow2);
		*/
	}
	
	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_seqFlow1=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW1);
		_seqFlow2=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW2);
		_flowobject=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECT);
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
			
		public static final int SEQFLOW1= 0,
								SEQFLOW2= 1,
								FLOWOBJECT= 2,
								BLOCK= 3,
								FORK= 4,
								MERGE= 5;
		
		@Override
		public void initLHSVariables() {
			
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOW1
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOW2
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FLOWOBJECT
			addVariableType(struc.getBpmnBlock(), lhsVariables);	// BLOCK
			addVariableType(bpmn.getGateway(), lhsVariables);		// FORK
			addVariableType(bpmn.getGateway(), lhsVariables);		// MERGE
			
			//queries
			addInjectivityQuery(lhsVariables,FORK,MERGE);
			
			addBranchTargetQueries(lhsVariables, FORK, SEQFLOW1, FLOWOBJECT, SEQFLOW2, MERGE);
			
			addTargetQuery(lhsVariables, BLOCK, FORK, struc.getBpmnBlock_FirstGateway());
			addTargetQuery(lhsVariables, BLOCK, MERGE, struc.getBpmnBlock_SecondGateway());
		}
		
		@Override
		protected void initNACVariables() {
		}
	}
}