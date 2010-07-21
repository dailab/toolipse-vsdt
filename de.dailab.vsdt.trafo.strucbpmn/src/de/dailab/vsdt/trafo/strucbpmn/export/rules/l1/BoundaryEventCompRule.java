package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Boundary Event Compensation Rule
 *  
 * PATTERN: an activity with intermediate event in a BpmnEventHandlerBlock,
 * where the intermediate is of type Compensate and connected to it's 
 * compensation activity via an association.
 * 
 * EFFECT: the intermediate and the compensation activity are put in a 
 * BpmnEventHandlerCase. The association is removed.
 */
public class BoundaryEventCompRule extends AbstractVsdtRule {
	
	protected BpmnEventHandlerBlock	_ehBlock= null;
	protected Association			_association= null;
	protected Activity 				_activity= null;
	protected Intermediate 			_intermediate= null;
	protected Activity 				_compAct= null;
	
	@Override
	protected void resetVars() {
		_ehBlock= null;
		_association= null;
		_activity= null;
		_intermediate= null;
		_compAct= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}
	
	/**
	 * - create BpmnEventHandlerCase
	 * - put BEHC in BEHB
	 * - put intermediate and comp_act in BEHC
	 * - remove association
	 */
	@Override
	protected void apply() {
		BpmnEventHandlerCase ehCase= StrucBpmnFactory.eINSTANCE.createBpmnEventHandlerCase();
		_ehBlock.getEventHandlerCases().add(ehCase);
		
		ehCase.setIntermediate(_intermediate);
		ehCase.setCompensationElement(_compAct);
		
		deleteAssociation(_association);
	}

	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_ehBlock=	(BpmnEventHandlerBlock)matches.get(RuleWrapper.EHBLOCK);
		_association=(Association)	matches.get(RuleWrapper.ASSOCIATION);
		_activity=	(Activity)		matches.get(RuleWrapper.ACTIVITY);
		_intermediate=(Intermediate)	matches.get(RuleWrapper.INTERMEDIATE);
		_compAct=	(Activity)		matches.get(RuleWrapper.COMP_ACT);
	}
	
	/**
	 * wrapper class for this rule
	 * 
	 * @author tkuester
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
		
		public static final int EHBLOCK= 0,
								ASSOCIATION= 1,
								ACTIVITY= 2,
								INTERMEDIATE= 3,
								COMP_ACT= 4,
								//last LHS variable (for NACs)
								LAST_LHS_VAR= COMP_ACT;

		@Override
		public void initLHSVariables() {
			addVariableType(struc.getBpmnEventHandlerBlock(), lhsVariables);// EHBLOCK
			addVariableType(bpmn.getAssociation(), lhsVariables);	// ASSOCIATION
			addVariableType(bpmn.getActivity(), lhsVariables);		// ACTIVITY
			addVariableType(bpmn.getIntermediate(), lhsVariables);	// INTERMEDIATE
			addVariableType(bpmn.getActivity(), lhsVariables);		// COMP_ACT
			
			//queries
			addTargetQuery(lhsVariables,EHBLOCK,ACTIVITY,struc.getBpmnEventHandlerBlock_Activity());
			addTargetQuery(lhsVariables,ACTIVITY,INTERMEDIATE,bpmn.getActivity_BoundaryEvents());
			addTargetQuery(lhsVariables,INTERMEDIATE,COMP_ACT,bpmn.getEvent_Activity());
			addTargetQuery(lhsVariables,ASSOCIATION,INTERMEDIATE,bpmn.getAssociation_Source());
	 		addTargetQuery(lhsVariables,ASSOCIATION,COMP_ACT,bpmn.getAssociation_Target());
	 		
			//reduce activity
	 		for (Iterator<EObject> iter = lhsVariables.get(ACTIVITY).getDomain().iterator(); iter.hasNext();) {
				boolean ok= true;
				Activity activity= (Activity) iter.next();
				
				//has neither incoming nor outgoing sequence flows
				ok &= activity.getIncomingSeq().size() == 0;
				ok &= activity.getOutgoingSeq().size() == 0;
					
				if (!ok) {
					iter.remove();
				}
			}
		}

		@Override
		protected void initNACVariables() {
		}	
		
	}
}