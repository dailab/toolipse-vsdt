package de.dailab.vsdt.trafo.strucbpmn.export.rules.old;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.base.util.Util;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

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
@Deprecated
public class CreateBlockRule extends AbstractVsdtRule {

	public static final int SEQFLOW11= 0,
							SEQFLOW12= 1,
							FLOWOBJECT1= 2,
							SEQFLOW21= 3,
							SEQFLOW22= 4,
							FLOWOBJECT2= 5,
							FORK= 6,
							MERGE= 7;
	
	/**
	 */
	@Override
	protected void apply(List<EObject> matches){
//		SequenceFlow _seqFlow11=	(SequenceFlow)	matches.get(SEQFLOW11);
//		SequenceFlow _seqFlow12=	(SequenceFlow)	matches.get(SEQFLOW12);
//		FlowObject _flowobject1=	(FlowObject)	matches.get(FLOWOBJECT1);
//		SequenceFlow _seqFlow21=	(SequenceFlow)	matches.get(SEQFLOW21);
//		SequenceFlow _seqFlow22=	(SequenceFlow)	matches.get(SEQFLOW22);
//		FlowObject _flowobject2=	(FlowObject)	matches.get(FLOWOBJECT2);
//		Gateway _fork=				(Gateway)		matches.get(FORK);
//		Gateway _merge=				(Gateway)		matches.get(MERGE);
		
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
		Util.deleteFromOwner(seqFlow);
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