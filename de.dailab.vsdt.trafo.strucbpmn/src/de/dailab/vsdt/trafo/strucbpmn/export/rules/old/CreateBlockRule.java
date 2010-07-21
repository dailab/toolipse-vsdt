package de.dailab.vsdt.trafo.strucbpmn.export.rules.old;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Create Block Rule
 * 
 * PATTERN: two gateways with at least two forked/merged sequence flows, two sequences of (complex) flow objects
 * spanning from the first to the second gateway and no other sequences staring at the first gateway 
 * and not ending at the second (the inverse is allowed) 
 * 
 * EFFECT: all sequences going from the first to the second gateway are identified. If the second gateway merges any other 
 * sequences it is split up. The sequences, their conditions and the gateways are put into a BpmnBlock. The inner sequence
 * flows are deleted, the outer sequence flows redirected. 
 */
public class CreateBlockRule extends AbstractVsdtRule {
	
	protected SequenceFlow	_seqFlow11= null;
	protected SequenceFlow	_seqFlow12= null;
	protected FlowObject	_flowobject1= null;
	protected SequenceFlow	_seqFlow21= null;
	protected SequenceFlow	_seqFlow22= null;
	protected FlowObject	_flowobject2= null;
	protected Gateway		_fork= null;
	protected Gateway		_merge= null;
	
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
	 */
	@Override
	protected void apply() {
		/*
		// create condition map
		Map<FlowObject, Expression> conditions= new HashMap<FlowObject, Expression>();
		FlowObject defaultElement= null;
		Expression condition= getCondition(_seqFlow11);
		if (condition == null) {
			defaultElement= _flowobject1;
		} else {
			conditions.put(_flowobject1, condition);
		}
		condition= getCondition(_seqFlow21);
		if (condition == null) {
			defaultElement= _flowobject2;
		} else {
			conditions.put(_flowobject2, condition);
		}
		
		//create block structure
		BpmnBlock block= StrucBpmnFactory.eINSTANCE.createBpmnBlock();
		FlowObjectContainer container= _fork.getFlowObjectContainer();
		container.getContainedFlowObjects().add(block);
		
		//fill block structure
		block.setFirstGateway(_fork);
		block.setSecondGateway(_merge);
		block.getElements().add(_flowobject1);
		block.getElements().add(_flowobject2);
		block.setConditions(conditions);
		block.setDefaultElement(defaultElement);
		
		//redirect sequence flows
		block.getIncomingSeq().addAll(_fork.getIncomingSeq());
		block.getOutgoingSeq().addAll(_merge.getOutgoingSeq());
		
		//delete sequence flows
		delete(_seqFlow11);
		delete(_seqFlow12);
		delete(_seqFlow21);
		delete(_seqFlow22);
		*/
	}
	
	/**
	 * @param seqFlow	some SequenceFlow
	 * @return			returns null, if seqFlow is default, else the condition or 'null' if no condition is set
	 */
	public static Expression getCondition(SequenceFlow seqFlow) {
		if (seqFlow.getConditionType() == ConditionType.DEFAULT) {
			return null;
		} else {
			Expression nullExp= VsdtFactory.eINSTANCE.createExpression();
			nullExp.setExpression("null");
			return seqFlow.getConditionExpression() == null ? nullExp : seqFlow.getConditionExpression();
		}
	}

	/**
	 * @param seqFlow	delete this SequenceFlow
	 */
	public static void delete(SequenceFlow seqFlow) {
		seqFlow.setSource(null);
		seqFlow.setTarget(null);
		deleteFromOwner(seqFlow);
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
								MERGE= 7;
		
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
				Gateway gateway = (Gateway) iter.next();
				// not yet added to a block
				if (gateway.getParent() == null) {
					iter.remove();
				}
			}	
			//reduce merge
			for (Iterator<EObject> iter = lhsVariables.get(MERGE).getDomain().iterator(); iter.hasNext();) {
				Gateway gateway = (Gateway) iter.next();
				// not yet added to a block
				if (gateway.getParent() == null) {
					iter.remove();
				}
			}
		}
		
		@Override
		protected void initNACVariables() {
		}
	}
}