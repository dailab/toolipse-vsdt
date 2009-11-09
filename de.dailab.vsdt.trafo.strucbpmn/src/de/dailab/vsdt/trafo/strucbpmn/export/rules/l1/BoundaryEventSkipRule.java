package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertEmptyRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Boundary Event Skip Rule
 * 
 * this rule is intended for boundary events that skip a number of activities before merging back into normal flow.
 * 
 * PATTERN: an activity with boundary event being contained in a BpmnEventHandlerBlock with a sequence ("skip sequence")
 * going from the activity to a gateway and one ("compensation sequence") from the intermediate to the same gateway.
 * 
 * EFFECT: the intermediate and the compensation sequence are put in a BpmnEventHandlerCase, also referencing the 
 * skip sequence, if not empty. the sequence flows involved in the compensation sequence are deleted, the others are not.  
 */
public class BoundaryEventSkipRule extends AbstractVsdtRule {

	protected BpmnEventHandlerBlock _ehBlock= null;
	protected SequenceFlow 			_seqFlowAS= null;
	protected SequenceFlow 			_seqFlowIC= null;
	protected SequenceFlow 			_seqFlowSG= null;
	protected SequenceFlow 			_seqFlowCG= null;
	protected Activity 				_activity= null;
	protected Intermediate 			_intermediate= null;
	protected Gateway 				_gateway= null;
	protected FlowObject 			_foSkip= null;
	protected FlowObject 			_foComp= null;
	
	/**
	 * Default constructor.
	 */
	public BoundaryEventSkipRule(EObject root) {
		super(root,"Boundary Event Skip Rule");
	}
	
	@Override
	protected void resetVars() {
		_seqFlowAS= null;
		_seqFlowSG= null;
		_seqFlowIC= null;
		_seqFlowCG= null;
		_intermediate= null;
		_activity= null;
		_gateway= null;
		_foSkip= null;
		_foComp= null;
	}
	
	/**
	 * - create BpmnEventHandlerCase
	 * - put ehCase in ehBlock
	 * - put intermediate and fo_comp in BEHC
	 * - reference fo_skip in BEHC, wrap fo_skip in BpmnElementToSkip object, redirect sequence flows
	 * - remove sequence flows IC and CG
	 */
	@Override
	protected void apply() {
		
		BpmnEventHandlerCase ehCase= StrucBpmnFactory.eINSTANCE.createBpmnEventHandlerCase();
		ehCase.setIntermediate(_intermediate);
		ehCase.setCompensationElement(_foComp);
		ehCase.setGateway(_gateway);
		_ehBlock.getEventHandlerCases().add(ehCase);
		
		//set the reference only if foSkip is not a temporary 'placeholder'-activity
		if (! (_foSkip.getName() == InsertEmptyRule.EMPTY_NAME)) {
			BpmnElementToSkip elementToSkip= StrucBpmnFactory.eINSTANCE.createBpmnElementToSkip();
			//assertion: foSkip can not be integrated into a StrucBpmn object yet (although it might be one itself)
			FlowObjectContainer container= _foSkip.getFlowObjectContainer();
			container.getContainedFlowObjects().add(elementToSkip);
			elementToSkip.setElement(_foSkip);
			//redirect sequence flows
			elementToSkip.getIncomingSeq().addAll(_foSkip.getIncomingSeq());
			elementToSkip.getOutgoingSeq().addAll(_foSkip.getOutgoingSeq());
			
			//the variable name should be set later in the visitor since it depends on the execution language's capabilities
			
			ehCase.setElementToSkip(elementToSkip);
		}
		
		deleteSequenceFlow(_seqFlowIC);
		deleteSequenceFlow(_seqFlowCG);
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_ehBlock=		(BpmnEventHandlerBlock)matches.get(RuleWrapper.EH_BLOCK);
		_seqFlowAS=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWAS);
		_seqFlowSG=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWSG);
		_seqFlowIC=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWIC);
		_seqFlowCG=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWCG);
		_intermediate=	(Intermediate)	matches.get(RuleWrapper.INTERMEDIATE);
		_activity=		(Activity)		matches.get(RuleWrapper.ACTIVITY);
		_gateway=		(Gateway)		matches.get(RuleWrapper.GATEWAY);
		_foSkip=			(FlowObject)	matches.get(RuleWrapper.FO_SKIP);
		_foComp=			(FlowObject)	matches.get(RuleWrapper.FO_COMP);
	}
	
	/**
	 * wrapper class for this rule
	 * 
	 * @author tkuester
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
		
		public static final int EH_BLOCK= 0,
								SEQFLOWAS= 1,
								SEQFLOWSG= 2,
								SEQFLOWIC= 3,
								SEQFLOWCG= 4,
								INTERMEDIATE= 5,
								ACTIVITY= 6,
								GATEWAY= 7,
								FO_SKIP= 8,
								FO_COMP= 9;
		
		@Override
		public void initLHSVariables() {
			addVariableType(struc.getBpmnEventHandlerBlock(), lhsVariables);// EH_BLOCK
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOWAF1
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOWL1G
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOWIF2
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOWL2G
			addVariableType(bpmn.getIntermediate(), lhsVariables);	// INTERMEDIATE
			addVariableType(bpmn.getActivity(), lhsVariables);		// ACTIVITY
			addVariableType(bpmn.getGateway(), lhsVariables);		// GATEWAY
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FO_SKIP
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FO_COMP
			
			//queries
			addTargetQuery(lhsVariables,EH_BLOCK,ACTIVITY,struc.getBpmnEventHandlerBlock_Activity());
			addTargetQuery(lhsVariables,ACTIVITY,INTERMEDIATE,bpmn.getActivity_BoundaryEvents());
			
			addBranchTargetQueries(lhsVariables, EH_BLOCK, SEQFLOWAS, FO_SKIP, SEQFLOWSG, GATEWAY);
			addBranchTargetQueries(lhsVariables, INTERMEDIATE, SEQFLOWIC, FO_COMP, SEQFLOWCG, GATEWAY);
		}

		@Override
		protected void initNACVariables() {
		}
	}
	
}