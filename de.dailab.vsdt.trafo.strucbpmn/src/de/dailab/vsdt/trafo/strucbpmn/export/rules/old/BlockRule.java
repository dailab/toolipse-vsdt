package de.dailab.vsdt.trafo.strucbpmn.export.rules.old;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.base.Variable;
import de.dailab.vsdt.trafo.strucbpmn.export.AbstractVsdtRule;

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
@Deprecated
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
	protected void excecute(List<EObject> matches){
//		SequenceFlow _seqFlow11=	(SequenceFlow)	matches.get(SEQFLOW11);
//		SequenceFlow _seqFlow12=	(SequenceFlow)	matches.get(SEQFLOW12);
//		FlowObject _flowobject1=	(FlowObject)	matches.get(FLOWOBJECT1);
//		SequenceFlow _seqFlow21=	(SequenceFlow)	matches.get(SEQFLOW21);
//		SequenceFlow _seqFlow22=	(SequenceFlow)	matches.get(SEQFLOW22);
//		FlowObject _flowobject2=	(FlowObject)	matches.get(FLOWOBJECT2);
//		Gateway _fork=				(Gateway)		matches.get(FORK);
//		Gateway _merge=				(Gateway)		matches.get(MERGE);
		
		/*
		 * ASSERTION:
		 * given NAC1 and NAC2, every sequence starting at the fork will end at the merge 
		 */
		/*
		// get sequences going from fork to merge (== sequences starting at fork) with their conditions
		List<SequenceFlow> obsoleteSequenceFlows= new ArrayList<SequenceFlow>();
		List<FlowObject> forkedFlowObjects= new ArrayList<FlowObject>();
		Map<FlowObject, Expression> conditions= new Hashtable<FlowObject, Expression>();
		FlowObject defaultElement= null;
		for (Iterator<SequenceFlow> iterator = _fork.getOutgoingSeq().iterator(); iterator.hasNext();) {
			SequenceFlow sf = iterator.next();
			FlowObject target= sf.getTarget();
			forkedFlowObjects.add(target);
			Expression condition= getCondition(sf);
			if (condition == null) {
				defaultElement= target;
			} else {
				conditions.put(target, condition);
			}
			obsoleteSequenceFlows.add(sf);
			obsoleteSequenceFlows.add((SequenceFlow)target.getOutgoingSeq().get(0));
		}
		
		// compare with sequences ending at merge: required to split the merging gateway?
		List<SequenceFlow> seqFlowsToSplit= new ArrayList<SequenceFlow>();
		for (Iterator<SequenceFlow> iterator = _merge.getIncomingSeq().iterator(); iterator.hasNext();) {
			SequenceFlow sf = iterator.next();
			if (! forkedFlowObjects.contains(sf.getSource())) {
				seqFlowsToSplit.add(sf);
			}
		}
		if (! seqFlowsToSplit.isEmpty()) {

			//create new gateway
			Gateway merge2= VsdtFactory.eINSTANCE.createGateway();
			merge2.setName(_merge.getName() + "_2");
			_merge.getFlowObjectContainer().getContainedFlowObjects().add(merge2);
			
			//redirect SeqFlows going out of merge
			merge2.getOutgoingSeq().addAll(_merge.getOutgoingSeq());
			
			//redirect sequence flows with false fork
			merge2.getIncomingSeq().addAll(seqFlowsToSplit);
			
			//connect gateways with new SeqFlow
			SequenceFlow seqFlow2= VsdtFactory.eINSTANCE.createSequenceFlow();
			seqFlow2.setSource(_merge);
			seqFlow2.setTarget(merge2);
			_merge.getPool().getParentDiagram().getConnections().add(seqFlow2);
		}
		

		//create block structure
		BpmnBlock block= StrucBpmnFactory.eINSTANCE.createBpmnBlock();
		FlowObjectContainer container= _fork.getFlowObjectContainer();
		container.getContainedFlowObjects().add(block);
		
		//fill block structure
		block.setFirstGateway(_fork);
		block.setSecondGateway(_merge);
		block.getElements().addAll(forkedFlowObjects);
		block.setConditions(conditions);
		block.setDefaultElement(defaultElement);
		
		//redirect sequence flows
		block.getIncomingSeq().addAll(_fork.getIncomingSeq());
		block.getOutgoingSeq().addAll(_merge.getOutgoingSeq());
		
		//delete sequence flows
		for (SequenceFlow sf : obsoleteSequenceFlows) {
			sf.setSource(null);
			sf.setTarget(null);
			deleteFromOwner(sf);
		}
		*/
	}

	public static Expression getCondition(SequenceFlow seqFlow) {
		if (seqFlow.getConditionType() == ConditionType.DEFAULT) {
			return null;
		} else {
			Expression nullExp= VsdtFactory.eINSTANCE.createExpression();
			nullExp.setExpression("null");
			return seqFlow.getConditionExpression() == null ? nullExp : seqFlow.getConditionExpression();
		}
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
		addInjectivityConstraint(lhsVariables,FORK,MERGE);
		addInjectivityConstraint(lhsVariables,FLOWOBJECT1,FLOWOBJECT2);
		
		addBranchTargetQueries(lhsVariables, FORK, SEQFLOW11, FLOWOBJECT1, SEQFLOW12, MERGE);
		addBranchTargetQueries(lhsVariables, FORK, SEQFLOW21, FLOWOBJECT2, SEQFLOW22, MERGE);
		
		//reduce fork
		for (Iterator<EObject> iter = lhsVariables.get(FORK).getDomain().iterator(); iter.hasNext();) {
			boolean ok= true;
			Gateway gateway = (Gateway) iter.next();
			
			//more than one outgoing sequence
			ok &= gateway.getOutgoingSeq().size() > 1;
			
			if (!ok) {
				iter.remove();
			}
		}	
		//reduce merge
		for (Iterator<EObject> iter = lhsVariables.get(MERGE).getDomain().iterator(); iter.hasNext();) {
			boolean ok= true;
			Gateway gateway = (Gateway) iter.next();
			
			//more than one incoming sequence
			ok &= gateway.getIncomingSeq().size() > 1;
			
			if (!ok) {
				iter.remove();
			}
		}
	}

	
	@Override
	protected void initNACVariables() {
		// NAC: there may not be a outgoing sequence not ending in the merge gateway.
		nacVariables.add(createNAC1());
		// NAC: there may not be a outgoing sequence not ending at all
		nacVariables.add(createNAC2());
		/* 
		 * incoming sequences not starting at the forking gateway, on the other hand, are no problem,
		 * since the merging gateway can easily be split (see splitMerge method)
		 */
	}
	
	/**
	 * NAC: there may not be a outgoing sequence not ending in the merge gateway.
	 * This NAC also makes sure that there are no child-blocks that have not yet been mapped.
	 * In this case the NAC_GATEWAY would be the forking gateway of the child block.
	 * 
	 * @return	new NAC
	 */
	private List<Variable> createNAC1() {
		final int NAC_SEQFLOW1=	LAST_LHS_VAR+1,
				  NAC_SEQFLOW2=	LAST_LHS_VAR+2,
				  NAC_SEQ=		LAST_LHS_VAR+3,
				  NAC_GATEWAY=	LAST_LHS_VAR+4;
		
		List<Variable> nacVars = new Vector<Variable>();
		addNullVariable(nacVars, 3);					// SEQFLOW1, SEQFLOW2, SEQ
		addNullVariable(nacVars, 3);					// SEQFLOW1, SEQFLOW2, SEQ
		addVariable(nacVars, bpmn.getGateway());	// FORK
		addVariable(nacVars, bpmn.getGateway());	// MERGE
		addVariable(nacVars, bpmn.getSequenceFlow());// NAC_SEQFLOW1
		addVariable(nacVars, bpmn.getSequenceFlow());// NAC_SEQFLOW2
		addVariable(nacVars, bpmn.getFlowObject());	// NAC_SEQ
		addVariable(nacVars, bpmn.getFlowObject());	// NAC_GATEWAY
		
		//queries
		addInjectivityConstraint(nacVars, MERGE, NAC_GATEWAY);
		addReferenceConstraint(nacVars, NAC_SEQFLOW1, FORK, bpmn.getSequenceFlow_Source());
		addReferenceConstraint(nacVars, NAC_SEQFLOW1, NAC_SEQ, bpmn.getSequenceFlow_Target());
		addReferenceConstraint(nacVars, NAC_SEQFLOW2, NAC_SEQ, bpmn.getSequenceFlow_Source());
		addReferenceConstraint(nacVars, NAC_SEQFLOW2, NAC_GATEWAY, bpmn.getSequenceFlow_Target());
		
		return nacVars;
	}
	
	/**
	 * NAC: there may not be a outgoing sequence not ending at all
	 * this should be handled by a different rule for "open blocks"
	 * 
	 * @return	new NAC
	 */
	private List<Variable> createNAC2() {
		final int NAC_SEQFLOW1=	LAST_LHS_VAR+1,
				  NAC_SEQ=	LAST_LHS_VAR+2;

		List<Variable> nacVars = new Vector<Variable>();
		addNullVariable(nacVars, 3);					// SEQFLOW1, SEQFLOW2, SEQ
		addNullVariable(nacVars, 3);					// SEQFLOW1, SEQFLOW2, SEQ
		addVariable(nacVars, bpmn.getGateway());	// FORK
		addNullVariable(nacVars, 1);					// MERGE
		addVariable(nacVars, bpmn.getSequenceFlow());// NAC_SEQFLOW1
		addVariable(nacVars, bpmn.getFlowObject());	// NAC_SEQ
		
		//queries
		addReferenceConstraint(nacVars, NAC_SEQFLOW1, FORK, bpmn.getSequenceFlow_Source());
		addReferenceConstraint(nacVars, NAC_SEQFLOW1, NAC_SEQ, bpmn.getSequenceFlow_Target());
		
		//reduce domains
		for (Iterator<EObject> iter = nacVars.get(NAC_SEQ).getDomain().iterator(); iter.hasNext();) {
			boolean ok= true;
			FlowObject flowObject = (FlowObject) iter.next();
			
			//no outgoing sequence
			ok &= flowObject.getOutgoingSeq().size() == 0;
			
			if (!ok) {
				iter.remove();
			}
		}
		return nacVars;
	}
	
}