package de.dailab.vsdt.trafo.strucbpmn.export.rules.obsolete;

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
import de.dailab.vsdt.trafo.base.AbstractRule;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.base.Variable;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.AbstractVsdtWrapper;

/**
 * Block Rule
 * 
 * PATTERN: two gateways with at least two forked/merged sequence flows, two sequences of (complex) flow objects
 * spanning from the first to the second gateway and no other sequences staring at the first gateway 
 * and not ending at the second (the inverse is allowed) 
 * 
 * EFFECT: all sequences going from the first to the second gateway are identified. If the second gateway merges any other 
 * sequences it is split up. The sequences, their conditions and the gateways are put into a BpmnBlock. The inner sequence
 * flows are deleted, the outer sequence flows redirected. 
 */
public class BlockRule extends AbstractRule {
	
	/*
	 * the two branches identified by this rule are not used in the apply() method,
	 * but they are still used so the rule does take nested loops for blocks
	 */
	protected SequenceFlow	_seqFlow11= null;
	protected SequenceFlow	_seqFlow12= null;
	protected FlowObject	_flowobject1= null;
	protected SequenceFlow	_seqFlow21= null;
	protected SequenceFlow	_seqFlow22= null;
	protected FlowObject	_flowobject2= null;
	protected Gateway		_fork= null;
	protected Gateway		_merge= null;
	
	/**
	 * Default constructor.
	 */
	public BlockRule(EObject root) {
		super(root,"Block Rule");
	}
	
	
	@Override
	protected void resetVars() {
		_seqFlow11= null;
		_seqFlow12= null;
		_flowobject1= null;
		_seqFlow21= null;
		_seqFlow22= null;
		_flowobject2= null;
		_fork= null;
		_merge= null;
	}
		
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}
	
	/**
	 * - create block structure
	 * - insert everything in this block structure
	 * - redirect sequence flows
	 * - get all sequences spanning from the fork to the merge
	 * - eventually split the merge
	 * - remove obsolete sequence flows
	 */
	@Override
	protected void apply() {
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
	protected void setWeightedLHS(List<EObject> matches){
		_seqFlow11=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW11);
		_seqFlow12=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW12);
		_flowobject1=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECT1);
		_seqFlow21=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW21);
		_seqFlow22=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW22);
		_flowobject2=	(FlowObject)	matches.get(RuleWrapper.FLOWOBJECT2);
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
								FLOWOBJECT1= 2,
								SEQFLOW21= 3,
								SEQFLOW22= 4,
								FLOWOBJECT2= 5,
								FORK= 6,
								MERGE= 7,
								//last LHS variable (for NACs)
								LAST_LHS_VAR= MERGE;
		
		@Override
		public void initLHSVariables() {
			
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOW11
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOW12
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FLOWOBJECT1
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOW21
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOW22
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FLOWOBJECT2
			addVariableType(bpmn.getGateway(), lhsVariables);		// FORK
			addVariableType(bpmn.getGateway(), lhsVariables);		// MERGE
			
			//queries
			addInjectivityQuery(lhsVariables,FORK,MERGE);
			addInjectivityQuery(lhsVariables,FLOWOBJECT1,FLOWOBJECT2);
			
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
			addNullMatches(nacVars, 3);						// SEQFLOW1, SEQFLOW2, SEQ
			addNullMatches(nacVars, 3);						// SEQFLOW1, SEQFLOW2, SEQ
			addVariableType(bpmn.getGateway(), nacVars);	// FORK
			addVariableType(bpmn.getGateway(), nacVars);	// MERGE
			addVariableType(bpmn.getSequenceFlow(), nacVars);// NAC_SEQFLOW1
			addVariableType(bpmn.getSequenceFlow(), nacVars);// NAC_SEQFLOW2
			addVariableType(bpmn.getFlowObject(), nacVars);	// NAC_SEQ
			addVariableType(bpmn.getFlowObject(), nacVars);	// NAC_GATEWAY
			
			//queries
			addInjectivityQuery(nacVars, MERGE, NAC_GATEWAY);
			addSourceQuery(nacVars, NAC_SEQFLOW1, FORK, bpmn.getSequenceFlow_Source());
			addTargetQuery(nacVars, NAC_SEQFLOW1, NAC_SEQ, bpmn.getSequenceFlow_Target());
			addTargetQuery(nacVars, NAC_SEQFLOW2, NAC_SEQ, bpmn.getSequenceFlow_Source());
			addTargetQuery(nacVars, NAC_SEQFLOW2, NAC_GATEWAY, bpmn.getSequenceFlow_Target());
			
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
			addNullMatches(nacVars, 3);						// SEQFLOW1, SEQFLOW2, SEQ
			addNullMatches(nacVars, 3);						// SEQFLOW1, SEQFLOW2, SEQ
			addVariableType(bpmn.getGateway(), nacVars);	// FORK
			addNullMatches(nacVars, 1);						// MERGE
			addVariableType(bpmn.getSequenceFlow(), nacVars);// NAC_SEQFLOW1
			addVariableType(bpmn.getFlowObject(), nacVars);	// NAC_SEQ
			
			//queries
			addSourceQuery(nacVars, NAC_SEQFLOW1, FORK, bpmn.getSequenceFlow_Source());
			addTargetQuery(nacVars, NAC_SEQFLOW1, NAC_SEQ, bpmn.getSequenceFlow_Target());
			
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
}