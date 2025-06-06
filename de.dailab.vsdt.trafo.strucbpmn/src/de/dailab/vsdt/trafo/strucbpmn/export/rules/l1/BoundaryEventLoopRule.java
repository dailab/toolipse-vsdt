package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.export.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertEmptyRule;
import de.dailab.vsdt.util.VsdtElementFactory;

/**
 * Boundary Event Loop Rule
 * 
 * this rule is intended for boundary events that merge back into normal flow
 * before the activity, acting like a loop
 * 
 * PATTERN: an activity with boundary event being contained in a BpmnEventHandlerBlock 
 * with a sequence ("loop sequence") going from the activity to a gateway 
 * one activity before the activity
 * 
 * EFFECT: the intermediate and the compensation sequence are put in a 
 * BpmnEventHandlerCase, also referencing the skip sequence, if not empty. the 
 * sequence flows involved in the compensation sequence are deleted, the others are not.
 * 
 */
public class BoundaryEventLoopRule extends AbstractVsdtRule {

	public static final int EH_BLOCK= 0,
							SEQFLOWGL= 1,
							SEQFLOWLA= 2,
							SEQFLOWIC= 3,
							SEQFLOWCG= 4,
							INTERMEDIATE= 5,
							ACTIVITY= 6,
							GATEWAY= 7,
							FO_LOOP= 8,
							FO_COMP= 9;
	
	/**
	 * - create BpmnEventHandlerCase
	 * - put ehCase in ehBlock
	 * - put intermediate and fo_comp in BEHC
	 * - TODO name further steps
	 */
	@Override
	protected void excecute(List<EObject> matches){
		BpmnEventHandlerBlock _ehBlock=	(BpmnEventHandlerBlock)matches.get(EH_BLOCK);
//		SequenceFlow _seqFlowGL=		(SequenceFlow)	matches.get(SEQFLOWGL);
//		SequenceFlow _seqFlowLA=		(SequenceFlow)	matches.get(SEQFLOWLA);
		SequenceFlow _seqFlowIC=		(SequenceFlow)	matches.get(SEQFLOWIC);
		SequenceFlow _seqFlowCG=		(SequenceFlow)	matches.get(SEQFLOWCG);
		Intermediate _intermediate=		(Intermediate)	matches.get(INTERMEDIATE);
//		Activity _activity=				(Activity)		matches.get(ACTIVITY);
		Gateway _gateway=				(Gateway)		matches.get(GATEWAY);
//		FlowObject _foLoop=				(FlowObject)	matches.get(FO_LOOP);
		FlowObject _foComp=				(FlowObject)	matches.get(FO_COMP);
		
		final BusinessProcessDiagram bpd= _gateway.getPool().getParent();
		
		// create Event Handler Case
		BpmnEventHandlerCase ehCase= StrucBpmnFactory.eINSTANCE.createBpmnEventHandlerCase();
		ehCase.setIntermediate(_intermediate);
		ehCase.setCompensationElement(_foComp);
		ehCase.setGateway(_gateway);
		_ehBlock.getEventHandlerCases().add(ehCase);

		// create property and assignments
		Property property= VsdtFactory.eINSTANCE.createProperty();
		String varName= _ehBlock.getActivity().getNameOrId()+ "_" + _intermediate.getNameOrId()+ "_normalCompletion";
		property.setName(varName);
		property.setType("boolean");
		_ehBlock.getActivity().getAbstractProcess().getProperties().add(property);
		
		Assignment assignInit= VsdtFactory.eINSTANCE.createAssignment();
		assignInit.setAssignTime(AssignTimeType.START);
		assignInit.setTo(property);
		assignInit.setFrom(VsdtElementFactory.createExpression("true"));
		_ehBlock.getActivity().getAssignments().add(assignInit);
		
		Assignment assignComp= VsdtFactory.eINSTANCE.createAssignment();
		assignComp.setAssignTime(AssignTimeType.START);
		assignComp.setTo(property);
		assignComp.setFrom(VsdtElementFactory.createExpression("false"));
		_foComp.getAssignments().add(assignComp);
		
		// insert gateway: branch to loop back to original gateway
		Gateway branch= VsdtFactory.eINSTANCE.createGateway();
		branch.setName(_intermediate.getName() + SUFFIX_BRANCH);
		_gateway.getParent().getContainedFlowObjects().add(branch);
		
		// insert empty activity
		Activity empty= VsdtFactory.eINSTANCE.createActivity();
		empty.setName(InsertEmptyRule.EMPTY_NAME);
		_gateway.getParent().getContainedFlowObjects().add(empty);
		
		// sequence flow from ehBlock to branch
		FlowObject foAfterActivity= null;
		SequenceFlow actToMerge= null;
		if (_ehBlock.getOutgoingSeq().size() == 1) {
			actToMerge= _ehBlock.getOutgoingSeq().get(0);
			foAfterActivity= actToMerge.getTarget();
		} else {
			actToMerge= VsdtFactory.eINSTANCE.createSequenceFlow();
			bpd.getConnections().add(actToMerge);
			actToMerge.setSource(_ehBlock);
		}
		actToMerge.setTarget(branch);
		
		// sequence flow from branch to empty activity
		SequenceFlow branchToEmpty= VsdtFactory.eINSTANCE.createSequenceFlow();
		branchToEmpty.setSource(branch);
		branchToEmpty.setTarget(empty);
		branchToEmpty.setConditionType(ConditionType.EXPRESSION);
		branchToEmpty.setConditionExpression(VsdtElementFactory.createExpression("! " + varName));
		bpd.getConnections().add(branchToEmpty);

		// sequence flow from empty to original gateway
		SequenceFlow emptyToGateway= VsdtFactory.eINSTANCE.createSequenceFlow();
		emptyToGateway.setSource(empty);
		emptyToGateway.setTarget(_gateway);
		bpd.getConnections().add(emptyToGateway);
		
		// sequence flow from branch to flow object after activity
		if (foAfterActivity != null) {
			SequenceFlow branchToAfterAct= VsdtFactory.eINSTANCE.createSequenceFlow();
			branchToAfterAct.setConditionType(ConditionType.DEFAULT);
			branchToAfterAct.setSource(branch);
			branchToAfterAct.setTarget(foAfterActivity);
			bpd.getConnections().add(branchToAfterAct);
		}
		
		// delete obsolete sequence flows
		deleteSequenceFlow(_seqFlowIC);
		deleteSequenceFlow(_seqFlowCG);
	}
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, struc.getBpmnEventHandlerBlock());//EH_BLOCK
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOWGL
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOWLA
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOWIC
		addVariable(lhsVariables, bpmn.getSequenceFlow());	// SEQFLOWCG
		addVariable(lhsVariables, bpmn.getIntermediate());	// INTERMEDIATE
		addVariable(lhsVariables, bpmn.getActivity());		// ACTIVITY
		addVariable(lhsVariables, bpmn.getGateway());		// GATEWAY
		addVariable(lhsVariables, bpmn.getFlowObject());	// FO_LOOP
		addVariable(lhsVariables, bpmn.getFlowObject());	// FO_COMP
		
		//queries
		addReferenceConstraint(lhsVariables,EH_BLOCK,ACTIVITY,struc.getBpmnEventHandlerBlock_Activity());
		addReferenceConstraint(lhsVariables,ACTIVITY,INTERMEDIATE,bpmn.getActivity_BoundaryEvents());
		
		addBranchTargetQueries(lhsVariables, GATEWAY, SEQFLOWGL, FO_LOOP, SEQFLOWLA, EH_BLOCK);
		addBranchTargetQueries(lhsVariables, INTERMEDIATE, SEQFLOWIC, FO_COMP, SEQFLOWCG, GATEWAY);
	}

	@Override
	protected void initNACVariables() {
	}
	
}