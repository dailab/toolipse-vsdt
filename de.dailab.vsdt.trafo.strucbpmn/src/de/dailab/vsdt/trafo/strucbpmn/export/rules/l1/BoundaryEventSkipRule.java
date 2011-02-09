package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.export.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertEmptyRule;

/**
 * Boundary Event Skip Rule
 * 
 * this rule is intended for boundary events that skip a number of activities 
 * before merging back into normal flow.
 * 
 * PATTERN: an activity with boundary event being contained in a 
 * BpmnEventHandlerBlock with a sequence ("skip sequence") going from the 
 * activity to a gateway and one ("compensation sequence") from the intermediate
 * to the same gateway.
 * 
 * EFFECT: the intermediate and the compensation sequence are put in a 
 * BpmnEventHandlerCase, also referencing the skip sequence, if not empty. the 
 * sequence flows involved in the compensation sequence are deleted, the others 
 * are not.  
 */
public class BoundaryEventSkipRule extends AbstractVsdtRule {
	
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
	
	/**
	 * - create BpmnEventHandlerCase
	 * - put ehCase in ehBlock
	 * - put intermediate and fo_comp in BEHC
	 * - reference fo_skip in BEHC, wrap fo_skip in BpmnElementToSkip object, redirect sequence flows
	 * - remove sequence flows IC and CG
	 */
	@Override
	protected void excecute(List<EObject> matches){
		BpmnEventHandlerBlock _ehBlock=	(BpmnEventHandlerBlock)matches.get(EH_BLOCK);
//		SequenceFlow _seqFlowAS=		(SequenceFlow)	matches.get(SEQFLOWAS);
//		SequenceFlow _seqFlowSG=		(SequenceFlow)	matches.get(SEQFLOWSG);
		SequenceFlow _seqFlowIC=		(SequenceFlow)	matches.get(SEQFLOWIC);
		SequenceFlow _seqFlowCG=		(SequenceFlow)	matches.get(SEQFLOWCG);
		Intermediate _intermediate=		(Intermediate)	matches.get(INTERMEDIATE);
//		Activity _activity=				(Activity)		matches.get(ACTIVITY);
		Gateway _gateway=				(Gateway)		matches.get(GATEWAY);
		FlowObject _foSkip=				(FlowObject)	matches.get(FO_SKIP);
		FlowObject _foComp=	 			(FlowObject)	matches.get(FO_COMP);
		
		BpmnEventHandlerCase ehCase= StrucBpmnFactory.eINSTANCE.createBpmnEventHandlerCase();
		ehCase.setIntermediate(_intermediate);
		ehCase.setCompensationElement(_foComp);
		ehCase.setGateway(_gateway);
		_ehBlock.getEventHandlerCases().add(ehCase);
		
		//set the reference only if foSkip is not a temporary 'placeholder'-activity
		if (! (_foSkip.getName() == InsertEmptyRule.EMPTY_NAME)) {
			BpmnElementToSkip elementToSkip= StrucBpmnFactory.eINSTANCE.createBpmnElementToSkip();
			//assertion: foSkip can not be integrated into a StrucBpmn object yet (although it might be one itself)
			FlowObjectContainer container= _foSkip.getParent();
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
	public void initLHSVariables() {
		addVariable(lhsVariables, struc.getBpmnEventHandlerBlock());// EH_BLOCK
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOWAF1
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOWL1G
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOWIF2
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOWL2G
		addVariable(lhsVariables, bpmn.getIntermediate());	// INTERMEDIATE
		addVariable(lhsVariables, bpmn.getActivity());		// ACTIVITY
		addVariable(lhsVariables, bpmn.getGateway());		// GATEWAY
		addVariable(lhsVariables, bpmn.getFlowObject());	// FO_SKIP
		addVariable(lhsVariables, bpmn.getFlowObject());	// FO_COMP
		
		//queries
		addReferenceConstraint(lhsVariables,EH_BLOCK,ACTIVITY,struc.getBpmnEventHandlerBlock_Activity());
		addReferenceConstraint(lhsVariables,ACTIVITY,INTERMEDIATE,bpmn.getActivity_BoundaryEvents());
		
		addBranchTargetQueries(lhsVariables, EH_BLOCK, SEQFLOWAS, FO_SKIP, SEQFLOWSG, GATEWAY);
		addBranchTargetQueries(lhsVariables, INTERMEDIATE, SEQFLOWIC, FO_COMP, SEQFLOWCG, GATEWAY);
	}

	@Override
	protected void initNACVariables() {
	}
	
}