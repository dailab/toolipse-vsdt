package de.dailab.vsdt.trafo.strucbpmn.export.rules.layer1;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.AbstractVsdtWrapper;

/**
 * Sequence Rule
 * 
 * PATTERN: two FlowObjects, connected with a sequence flow. The flowObjects may not be boundary events on an activity
 * boundary, an activity with boundary events or a gateway with more than one incoming or outgoing sequence flow.
 * 
 * EFFECT: the two FlowObjects are put in a BpmnSequence and the incoming and outgoing sequence flows are redirected.
 * The sequence flow connecting the FOs will be deleted.
 */
public class SequenceRule extends AbstractVsdtRule {

	protected SequenceFlow	_seqFlow= null;
	protected FlowObject	_flowObject1= null;
	protected FlowObject	_flowObject2= null;
	
	/**
	 * Default constructor.
	 */
	public SequenceRule(EObject root) {
		super(root,"Sequence Rule");
	}
	
	@Override
	protected void resetVars() {
		_seqFlow= null;
		_flowObject1= null;
		_flowObject2= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_seqFlow=	(SequenceFlow)	matches.get(RuleWrapper.SEQFLOW);
		_flowObject1=(FlowObject)	matches.get(RuleWrapper.FLOWOBJECT1);
		_flowObject2=(FlowObject)	matches.get(RuleWrapper.FLOWOBJECT2);
	}
	
	/**
	 * - If one of the flowObjects is a bpmnSeq, use this, otherwise create a new one
	 * - Insert the bpmnSequence in the flowObjects container
	 * - Put the flowObjects in the bpmnSequence
	 * - Redirect incoming and outgoing sequence flows to point to the sequence instead of the flowObjects
	 * - remove the sequence flow in between the flowObjects
	 */
	@Override
	protected void apply() {
		// create new sequence or use existing one
		BpmnSequence sequence= null;
		
		if (_flowObject1 instanceof BpmnSequence) {
			sequence= (BpmnSequence) _flowObject1;
		} else {
			sequence= StrucBpmnFactory.eINSTANCE.createBpmnSequence();
		
			// put sequence in container
			FlowObjectContainer container= _flowObject2.getFlowObjectContainer();
			container.getContainedFlowObjects().add(sequence);
			
			sequence.getElements().add(_flowObject1);
		}
		
		if (_flowObject2 instanceof BpmnSequence
				&& !((BpmnSequence) _flowObject2).isNeedsToPersist()) {
			sequence.getElements().addAll(((BpmnSequence) _flowObject2).getElements());
			deleteFromOwner(_flowObject2);
		} else {
			sequence.getElements().add(_flowObject2);
		}
		
		sequence.getIncomingSeq().addAll(_flowObject1.getIncomingSeq());
		sequence.getOutgoingSeq().addAll(_flowObject2.getOutgoingSeq());
		
		deleteSequenceFlow(_seqFlow);
	}
	
	/**
	 * wrapper class for this rule
	 * 
	 * @author tkuester
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
		
		public static final int SEQFLOW= 0,
								FLOWOBJECT1= 1,
								FLOWOBJECT2= 2,
								//last LHS variable
								LAST_LHS_VAR= FLOWOBJECT2;

		@Override
		public void initLHSVariables() {
			 
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOW 
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FLOWOBJECT1
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FLOWOBJECT2

			//queries
			addSeqFlowTargetQueries(lhsVariables, SEQFLOW, FLOWOBJECT1, FLOWOBJECT2);
			addInjectivityQuery(lhsVariables,FLOWOBJECT1,FLOWOBJECT2);

			//reduce flowobject1
			for (Iterator<EObject> iter = lhsVariables.get(FLOWOBJECT1).getDomain().iterator(); iter.hasNext();) {
				FlowObject flowObject= (FlowObject) iter.next();
				if (! acceptFlowObject(flowObject)) {
					iter.remove();
				}
			}
			
			//reduce flowobject2 (see flowobject1)
			for (Iterator<EObject> iter = lhsVariables.get(FLOWOBJECT2).getDomain().iterator(); iter.hasNext();) {
				FlowObject flowObject= (FlowObject) iter.next();
				if (! acceptFlowObject(flowObject)) {
					iter.remove();
				}
			}
		}
		
		/**
		 * common checks for domain reduction for flow object 1 and 2
		 * 
		 * @param flowObject	the flow object to accept or decline
		 * @return				accepted?
		 */
		private boolean acceptFlowObject(FlowObject flowObject) {
			boolean ok= true;
			
			/*
			 * General Checks
			 */
			//not more than one incoming and outgoing sequence flow
			ok&= flowObject.getIncomingSeq().size() <= 1;
			ok&= flowObject.getOutgoingSeq().size() <= 1;
			
			/*
			 * Checks related to Boudary Event
			 */
			//do not integrate activities with boundary events
			if (flowObject instanceof Activity) {
				Activity activity = (Activity) flowObject;
				ok&= activity.getBoundaryEvents().isEmpty();
			}
			//do not integrate EHBlocks as long as the activity still has Boundary Events
			if (flowObject instanceof BpmnEventHandlerBlock) {
				BpmnEventHandlerBlock ehBlock = (BpmnEventHandlerBlock) flowObject;
				ok&= ehBlock.getActivity().getBoundaryEvents().isEmpty();
			}
			//no boundary events
			if (flowObject instanceof Intermediate) {
				ok &= ((Intermediate)flowObject).getAttachedTo() == null;	
			}
			
			/*
			 * Checks that are currently not needed
			 * The following is needed only when using the alternative Block rule,
			 * which first builds a simple block and then adds more branches to it.
			 */
//			//do not integrate gateways that are part of a (partially identified) block
//			if (flowObject instanceof Gateway) {
//				ok&= flowObject.getFlowObjectContainer() != null;
//			}
//			//do not integrate partially identified blocks
//			if (flowObject instanceof BpmnBlock) {
//				BpmnBlock block = (BpmnBlock) flowObject;
//				ok&= block.getFirstGateway().getOutgoingSeq().isEmpty();
//				ok&= block.getSecondGateway().getIncomingSeq().isEmpty();
//			}
			
			return ok;
		}
		
		@Override
		protected void initNACVariables() {
		}
		
	}
	
}