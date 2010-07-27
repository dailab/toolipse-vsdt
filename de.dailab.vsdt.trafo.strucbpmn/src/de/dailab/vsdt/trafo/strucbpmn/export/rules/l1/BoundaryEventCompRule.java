package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

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
	
	public static final int EHBLOCK= 0,
							ASSOCIATION= 1,
							ACTIVITY= 2,
							INTERMEDIATE= 3,
							COMP_ACT= 4,
							//last LHS variable (for NACs)
							LAST_LHS_VAR= COMP_ACT;
	
	/**
	 * - create BpmnEventHandlerCase
	 * - put BEHC in BEHB
	 * - put intermediate and comp_act in BEHC
	 * - remove association
	 */
	@Override
	protected void excecute(List<EObject> matches){
		BpmnEventHandlerBlock _ehBlock=	(BpmnEventHandlerBlock)matches.get(EHBLOCK);
		Association _association=(Association)	matches.get(ASSOCIATION);
//		Activity _activity=	(Activity)		matches.get(ACTIVITY);
		Intermediate _intermediate=(Intermediate)	matches.get(INTERMEDIATE);
		Activity _compAct=	(Activity)		matches.get(COMP_ACT);
		
		BpmnEventHandlerCase ehCase= StrucBpmnFactory.eINSTANCE.createBpmnEventHandlerCase();
		_ehBlock.getEventHandlerCases().add(ehCase);
		
		ehCase.setIntermediate(_intermediate);
		ehCase.setCompensationElement(_compAct);
		
		deleteAssociation(_association);
	}

	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, struc.getBpmnEventHandlerBlock());// EHBLOCK
		addVariable(lhsVariables, bpmn.getAssociation());	// ASSOCIATION
		addVariable(lhsVariables, bpmn.getActivity());		// ACTIVITY
		addVariable(lhsVariables, bpmn.getIntermediate());	// INTERMEDIATE
		addVariable(lhsVariables, bpmn.getActivity());		// COMP_ACT
		
		//queries
		addReferenceConstraint(lhsVariables,EHBLOCK,ACTIVITY,struc.getBpmnEventHandlerBlock_Activity());
		addReferenceConstraint(lhsVariables,ACTIVITY,INTERMEDIATE,bpmn.getActivity_BoundaryEvents());
		addReferenceConstraint(lhsVariables,INTERMEDIATE,COMP_ACT,bpmn.getEvent_Activity());
		addReferenceConstraint(lhsVariables,ASSOCIATION,INTERMEDIATE,bpmn.getAssociation_Source());
 		addReferenceConstraint(lhsVariables,ASSOCIATION,COMP_ACT,bpmn.getAssociation_Target());
 		
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