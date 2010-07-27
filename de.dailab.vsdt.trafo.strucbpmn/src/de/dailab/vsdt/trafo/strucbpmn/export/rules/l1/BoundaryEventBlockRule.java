package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.trafo.base.Variable;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Boundary Event Block Rule
 * 
 * This rule is intended to identify activities with boundary events and to wrap
 * these activities in Boundary Event Blocks.
 *  
 * PATTERN: An activity with boundary event not being contained in a 
 * BpmnEventHandlerBlock yet.
 * 
 * EFFECT: the activity is put in a BpmnEventHandlerBlock, incoming and outgoing
 * sequence flows are redirected
 */
public class BoundaryEventBlockRule extends AbstractVsdtRule {
	
	public static final int ACTIVITY= 0,
							INTERMEDIATE= 1,
							//last LHS variable (for NACs)
							LAST_LHS_VAR= INTERMEDIATE;
	
	/**
	 * - create EH block
	 * - put EH block in FOContainer
	 * - put activity in EH block
	 * - redirect sequence flows
	 */
	@Override
	protected void excecute(List<EObject> matches){
		Activity _activity=		(Activity)		matches.get(ACTIVITY);
//		Intermediate _intermediate=	(Intermediate)	matches.get(INTERMEDIATE);
		
		BpmnEventHandlerBlock ehBlock= StrucBpmnFactory.eINSTANCE.createBpmnEventHandlerBlock();
		
		FlowObjectContainer container= _activity.getParent();
		container.getContainedFlowObjects().add(ehBlock);
		
		ehBlock.setActivity(_activity);
		
		ehBlock.getIncomingSeq().addAll(_activity.getIncomingSeq());
		ehBlock.getOutgoingSeq().addAll(_activity.getOutgoingSeq());
		
	}

	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpmn.getActivity());		// ACTIVITY
		addVariable(lhsVariables, bpmn.getIntermediate());	// INTERMEDIATE
		
		//queries
		addReferenceConstraint(lhsVariables,ACTIVITY,INTERMEDIATE,bpmn.getActivity_BoundaryEvents());
 		
	}

	@Override
	protected void initNACVariables() {
		nacVariables.add(createNAC1());
	}
	
	/**
	 * NAC1: The activity is not yet wrapped in a BoundaryEventBlock
	 * @return
	 */
	private List<Variable> createNAC1() {
		final int NAC_EHBLOCK=	LAST_LHS_VAR+1;
		
		List<Variable> nacVars = new Vector<Variable>();
		addVariable(nacVars, bpmn.getActivity());	// ACTIVITY
		addNullVariable(nacVars, 1);						// INTERMEDIATE
		addVariable(nacVars, struc.getBpmnEventHandlerBlock());	// EHBLOCK
		
		//queries
		addReferenceConstraint(nacVars, NAC_EHBLOCK, ACTIVITY, struc.getBpmnEventHandlerBlock_Activity());
		
		return nacVars;
	}

}