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
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertEmptyRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;
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
 * ehblock
 * gateway unmittelbar danach
 * intermediate abtrennen in ehcase
 * variable setzen
 * variable vorher initialisieren
 * im scope des prozesses deklarieren
 * 
 */
public class BoundaryEventLoopRule extends AbstractVsdtRule {

	protected BpmnEventHandlerBlock _ehBlock= null;
	protected SequenceFlow 			_seqFlowGL= null;
	protected SequenceFlow 			_seqFlowLA= null;
	protected SequenceFlow 			_seqFlowIC= null;
	protected SequenceFlow 			_seqFlowCG= null;
	protected Activity 				_activity= null;
	protected Intermediate 			_intermediate= null;
	protected Gateway 				_gateway= null;
	protected FlowObject 			_foLoop= null;
	protected FlowObject 			_foComp= null;
	
	/**
	 * Default constructor.
	 */
	public BoundaryEventLoopRule(EObject root) {
		super(root,"Boundary Event Loop Rule");
	}
	
	@Override
	protected void resetVars() {
		_seqFlowGL= null;
		_seqFlowLA= null;
		_seqFlowIC= null;
		_seqFlowCG= null;
		_intermediate= null;
		_activity= null;
		_gateway= null;
		_foLoop= null;
		_foComp= null;
	}
	
	/**
	 * - create BpmnEventHandlerCase
	 * - put ehCase in ehBlock
	 * - put intermediate and fo_comp in BEHC
	 * - TODO name further steps
	 */
	@Override
	protected void apply() {
		final BusinessProcessDiagram bpd= _gateway.getPool().getParentDiagram();
		
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
		branch.setName(_intermediate.getName() + "_BRANCH");
		_gateway.getFlowObjectContainer().getContainedFlowObjects().add(branch);
		
		// insert empty activity
		Activity empty= VsdtFactory.eINSTANCE.createActivity();
		empty.setName(InsertEmptyRule.EMPTY_NAME);
		_gateway.getFlowObjectContainer().getContainedFlowObjects().add(empty);
		
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
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_ehBlock=		(BpmnEventHandlerBlock)matches.get(RuleWrapper.EH_BLOCK);
		_seqFlowGL=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWGL);
		_seqFlowLA=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWLA);
		_seqFlowIC=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWIC);
		_seqFlowCG=		(SequenceFlow)	matches.get(RuleWrapper.SEQFLOWCG);
		_intermediate=	(Intermediate)	matches.get(RuleWrapper.INTERMEDIATE);
		_activity=		(Activity)		matches.get(RuleWrapper.ACTIVITY);
		_gateway=		(Gateway)		matches.get(RuleWrapper.GATEWAY);
		_foLoop=			(FlowObject)	matches.get(RuleWrapper.FO_LOOP);
		_foComp=			(FlowObject)	matches.get(RuleWrapper.FO_COMP);
	}
	
	/**
	 * wrapper class for this rule
	 * 
	 * @author tkuester
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
		
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
		
		@Override
		public void initLHSVariables() {
			addVariableType(struc.getBpmnEventHandlerBlock(), lhsVariables);// EH_BLOCK
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOWGL
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOWLA
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOWIC
			addVariableType(bpmn.getSequenceFlow(), lhsVariables);	// SEQFLOWCG
			addVariableType(bpmn.getIntermediate(), lhsVariables);	// INTERMEDIATE
			addVariableType(bpmn.getActivity(), lhsVariables);		// ACTIVITY
			addVariableType(bpmn.getGateway(), lhsVariables);		// GATEWAY
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FO_LOOP
			addVariableType(bpmn.getFlowObject(), lhsVariables);	// FO_COMP
			
			//queries
			addTargetQuery(lhsVariables,EH_BLOCK,ACTIVITY,struc.getBpmnEventHandlerBlock_Activity());
			addTargetQuery(lhsVariables,ACTIVITY,INTERMEDIATE,bpmn.getActivity_BoundaryEvents());
			
			addBranchTargetQueries(lhsVariables, GATEWAY, SEQFLOWGL, FO_LOOP, SEQFLOWLA, EH_BLOCK);
			addBranchTargetQueries(lhsVariables, INTERMEDIATE, SEQFLOWIC, FO_COMP, SEQFLOWCG, GATEWAY);
		}

		@Override
		protected void initNACVariables() {
		}
	}
	
}