package de.dailab.vsdt.trafo.strucbpmn.export.rules.old;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Add To Block Rule
 * 
 * PATTERN: ...
 * 
 * EFFECT: ... 
 */
@Deprecated
public class AddToBlockRule extends AbstractVsdtRule {
	
	public static final int SEQFLOW1= 0,
							SEQFLOW2= 1,
							FLOWOBJECT= 2,
							BLOCK= 3,
							FORK= 4,
							MERGE= 5;
	
	/**
	 */
	@Override
	protected void excecute(List<EObject> matches){
//		SequenceFlow _seqFlow1=		(SequenceFlow)	matches.get(SEQFLOW1);
//		SequenceFlow _seqFlow2=		(SequenceFlow)	matches.get(SEQFLOW2);
//		FlowObject _flowobject=	(FlowObject)	matches.get(FLOWOBJECT);
//		BpmnBlock _block=			(BpmnBlock)		matches.get(BLOCK);
//		Gateway _fork=			(Gateway)		matches.get(FORK);
//		Gateway _merge=			(Gateway)		matches.get(MERGE);
		
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
	public void initLHSVariables() {
		
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW1
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW2
		addVariable(lhsVariables, bpmn.getFlowObject());	// FLOWOBJECT
		addVariable(lhsVariables, struc.getBpmnBlock());	// BLOCK
		addVariable(lhsVariables, bpmn.getGateway());		// FORK
		addVariable(lhsVariables, bpmn.getGateway());		// MERGE
		
		//queries
		addInjectivityConstraint(lhsVariables,FORK,MERGE);
		
		addBranchTargetQueries(lhsVariables, FORK, SEQFLOW1, FLOWOBJECT, SEQFLOW2, MERGE);
		
		addReferenceConstraint(lhsVariables, BLOCK, FORK, struc.getBpmnBlock_FirstGateway());
		addReferenceConstraint(lhsVariables, BLOCK, MERGE, struc.getBpmnBlock_SecondGateway());
	}
	
	@Override
	protected void initNACVariables() {
	}
}