package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.StrucBpmnElementFactory;

/**
 * Block Rule
 * 
 * PATTERN: two gateways with at least two forked/merged sequence flows, two 
 * sequences of (complex) flow objects spanning from the first to the second 
 * gateway and no other sequences staring at the first gateway and not ending at 
 * the second (the inverse is allowed) 
 * 
 * EFFECT: all sequences going from the first to the second gateway are 
 * identified. If the second gateway merges any other sequences it is split up. 
 * The sequences, their conditions and the gateways are put into a BpmnBlock. 
 * The inner sequence flows are deleted, the outer sequence flows redirected. 
 */
public class BlockRule extends AbstractVsdtRule {

	/*
	 * the two branches identified by this rule are not used in the apply() method,
	 * but they are still used so the rule does take nested loops for blocks
	 */
	public static final int SEQFLOW11= 0,
							SEQFLOW12= 1,
							FLOWOBJECT1= 2,
							SEQFLOW21= 3,
							SEQFLOW22= 4,
							FLOWOBJECT2= 5,
							FORK= 6,
							MERGE= 7,
							//last LHS variable (for NACs)
							LAST_LHS_VAR= MERGE;
	
	/**
	 * - create block structure
	 * - insert everything in this block structure
	 * - redirect sequence flows
	 * - get all sequences spanning from the fork to the merge
	 * - eventually split the merge
	 * - remove obsolete sequence flows
	 */
	@Override
	protected void apply(List<EObject> matches){
//		SequenceFlow _seqFlow11=	(SequenceFlow)	matches.get(SEQFLOW11);
//		SequenceFlow _seqFlow12=	(SequenceFlow)	matches.get(SEQFLOW12);
//		FlowObject _flowobject1=	(FlowObject)	matches.get(FLOWOBJECT1);
//		SequenceFlow _seqFlow21=	(SequenceFlow)	matches.get(SEQFLOW21);
//		SequenceFlow _seqFlow22=	(SequenceFlow)	matches.get(SEQFLOW22);
//		FlowObject _flowobject2=	(FlowObject)	matches.get(FLOWOBJECT2);
		Gateway _fork=				(Gateway)		matches.get(FORK);
		Gateway _merge=				(Gateway)		matches.get(MERGE);
		
		List<SequenceFlow> branches= new ArrayList<SequenceFlow>();
		List<SequenceFlow> falseFork= new ArrayList<SequenceFlow>();
		List<SequenceFlow> falseMerge= new ArrayList<SequenceFlow>();
		getBranches(_fork, _merge, branches, falseFork, falseMerge);

		splitFork(_fork, falseFork);
		splitMerge(_merge, falseMerge);

		List<SequenceFlow> obsoleteSequenceFlows= new ArrayList<SequenceFlow>();

		//create block structure
		BpmnBlock block= StrucBpmnFactory.eINSTANCE.createBpmnBlock();
		FlowObjectContainer container= _fork.getParent();
		container.getContainedFlowObjects().add(block);

		for (SequenceFlow seqFlow : branches) {
			FlowObject flowObject= seqFlow.getTarget();
			BpmnBranch branch= StrucBpmnElementFactory.createBranch(
					flowObject, 
					getCondition(seqFlow), 
					seqFlow.getConditionType() == ConditionType.DEFAULT);
			block.getElements().add(branch);
			
			obsoleteSequenceFlows.addAll(flowObject.getIncomingSeq());
			obsoleteSequenceFlows.addAll(flowObject.getOutgoingSeq());
		}
		
		//fill block structure
		block.setFirstGateway(_fork);
		block.setSecondGateway(_merge);
		
		//redirect sequence flows
		block.getIncomingSeq().addAll(_fork.getIncomingSeq());
		block.getOutgoingSeq().addAll(_merge.getOutgoingSeq());
		
		//delete sequence flows
		for (SequenceFlow sf : obsoleteSequenceFlows) {
			deleteSequenceFlow(sf);
		}
	}

	/**
	 * @param seqFlow	some SequenceFlow
	 * @return			returns null, if seqFlow is default, else the condition or 'null' if no condition is set
	 */
	private Expression getCondition(SequenceFlow seqFlow) {
		if (seqFlow.getConditionType() == ConditionType.DEFAULT) {
			return null;
		} else {
			Expression nullExp= VsdtFactory.eINSTANCE.createExpression();
			nullExp.setExpression("null");
			Expression condition= seqFlow.getConditionExpression() == null ? nullExp : seqFlow.getConditionExpression();
			return condition;
		}
	}
	
	/**
	 * in case the list of false forking sequence flows is not empty,
	 * a new gateway is inserted prior to the original fork, forking these
	 * sequence flows. it is connected to the original fork with a sequence
	 * flow given a disjunctive condition, e.g. "a or b or c" if the conditions
	 * of the branches are a, b and c.
	 * 
	 * @param falseFork		list of false forking sequence flows (possibly empty, but not null)
	 */
	private void splitFork(Gateway _fork, List<SequenceFlow> falseFork) {
		if (! falseFork.isEmpty()) {
			//create new gateway
			Gateway fork2= VsdtFactory.eINSTANCE.createGateway();
			fork2.setName(_fork.getName() + SUFFIX_SPLIT);
			fork2.setGatewayType(_fork.getGatewayType());
			_fork.getParent().getContainedFlowObjects().add(fork2);
			
			//redirect SeqFlows
			fork2.getIncomingSeq().addAll(_fork.getIncomingSeq());
			fork2.getOutgoingSeq().addAll(falseFork);
			
			//connect gateways with new SeqFlow
			SequenceFlow seqFlow2= VsdtFactory.eINSTANCE.createSequenceFlow();
			seqFlow2.setSource(fork2);
			seqFlow2.setTarget(_fork);
			_fork.getPool().getParent().getConnections().add(seqFlow2);
			
			// create complex condition for new seqFow (disjunctive: a or b or c...)
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
	}

	/**
	 * in case the list of false merging sequence flows is not empty,
	 * a new gateway is inserted after to the original merge, merging these
	 * sequence flows. it is connected to the original merge with an unconditioned
	 * sequence flow
	 * 
	 * @param falseMerge	list of false merging sequence flows (possibly empty, but not null)
	 */
	private void splitMerge(Gateway _merge, List<SequenceFlow> falseMerge) {
		if (! falseMerge.isEmpty()) {
			//create new gateway
			Gateway merge2= VsdtFactory.eINSTANCE.createGateway();
			merge2.setName(_merge.getName() + SUFFIX_SPLIT);
			merge2.setGatewayType(_merge.getGatewayType());
			_merge.getParent().getContainedFlowObjects().add(merge2);
			
			//redirect SeqFlows
			merge2.getOutgoingSeq().addAll(_merge.getOutgoingSeq());
			merge2.getIncomingSeq().addAll(falseMerge);
			
			//connect gateways with new SeqFlow
			SequenceFlow seqFlow2= VsdtFactory.eINSTANCE.createSequenceFlow();
			seqFlow2.setSource(_merge);
			seqFlow2.setTarget(merge2);
			_merge.getPool().getParent().getConnections().add(seqFlow2);
		}
	}

	/**
	 * Pass empty lists as arguments, which will be filled with the results.
	 * 
	 * - iterate over seqFlows outgoing from _fork
	 * - if branch is ending in _merge, add seqFlow to list 1 and add 2nd seqFlow to temp list
	 * - else add seqFlow to list 2
	 * - add all seq flows ending at merge except those in temp list to list 3
	 * 
	 * @param branches		seqFlows starting a branch form the fork to merge
	 * @param falseFork		seqFlows starting at fork but not starting a branch
	 * @param falseMerge	seqFlows ending at merge but not ending a branch
	 */
	private void getBranches(Gateway _fork, Gateway _merge, List<SequenceFlow> branches, List<SequenceFlow> falseFork, List<SequenceFlow> falseMerge) {
		List<SequenceFlow> endingAtMerge= new ArrayList<SequenceFlow>();
		for (SequenceFlow seqFlow : _fork.getOutgoingSeq()) {
			FlowObject flowObject= seqFlow.getTarget();
			if (flowObject.getOutgoingSeq().size() == 1) {
				SequenceFlow seqFlow2= flowObject.getOutgoingSeq().get(0);
				if (seqFlow2.getTarget() == _merge) {
					branches.add(seqFlow);
					endingAtMerge.add(seqFlow2);
					continue;
				}
			}
			falseFork.add(seqFlow);
		}
		falseMerge.addAll(_merge.getIncomingSeq());
		falseMerge.removeAll(endingAtMerge);
	}
	
	@Override
	public void initLHSVariables() {
		
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW11
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW12
		addVariable(lhsVariables, bpmn.getFlowObject());	// FLOWOBJECT1
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW21
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOW22
		addVariable(lhsVariables, bpmn.getFlowObject());	// FLOWOBJECT2
		addVariable(lhsVariables, bpmn.getGateway());		// FORK
		addVariable(lhsVariables, bpmn.getGateway());		// MERGE
		
		//queries
		addInjectivityQuery(lhsVariables,FORK,MERGE);
		addInjectivityQuery(lhsVariables,FLOWOBJECT1,FLOWOBJECT2);
		
		addBranchTargetQueries(lhsVariables, FORK, SEQFLOW11, FLOWOBJECT1, SEQFLOW12, MERGE);
		addBranchTargetQueries(lhsVariables, FORK, SEQFLOW21, FLOWOBJECT2, SEQFLOW22, MERGE);
	}
	
	@Override
	protected void initNACVariables() {
	}
}