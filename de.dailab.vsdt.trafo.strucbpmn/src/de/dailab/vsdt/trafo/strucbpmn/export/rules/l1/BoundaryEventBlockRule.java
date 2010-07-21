package de.dailab.vsdt.trafo.strucbpmn.export.rules.l1;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.base.Variable;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Boundary Event Block Rule
 * 
 * This rule is intended to identify activities with boundary events and to wrap these activities in Boundary Event Blocks.
 *  
 * PATTERN: An activity with boundary event not being contained in a BpmnEventHandlerBlock yet.
 * 
 * EFFECT: the activity is put in a BpmnEventHandlerBlock, incoming and outgoing sequence flows are redirected
 */
public class BoundaryEventBlockRule extends AbstractVsdtRule {
	
	protected Activity 		_activity= null;
	protected Intermediate	_intermediate= null;
	
	@Override
	protected void resetVars() {
		_activity= null;
		_intermediate= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}
	
	/**
	 * - create EH block
	 * - put EH block in FOContainer
	 * - put activity in EH block
	 * - redirect sequence flows
	 */
	@Override
	protected void apply() {
		BpmnEventHandlerBlock ehBlock= StrucBpmnFactory.eINSTANCE.createBpmnEventHandlerBlock();
		
		FlowObjectContainer container= _activity.getParent();
		container.getContainedFlowObjects().add(ehBlock);
		
		ehBlock.setActivity(_activity);
		
		ehBlock.getIncomingSeq().addAll(_activity.getIncomingSeq());
		ehBlock.getOutgoingSeq().addAll(_activity.getOutgoingSeq());
		
	}

	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_activity=		(Activity)		matches.get(RuleWrapper.ACTIVITY);
		_intermediate=	(Intermediate)	matches.get(RuleWrapper.INTERMEDIATE);
	}
	
	/**
	 * wrapper class for this rule
	 * 
	 * @author tkuester
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
		
		public static final int ACTIVITY= 0,
								INTERMEDIATE= 1,
								//last LHS variable (for NACs)
								LAST_LHS_VAR= INTERMEDIATE;

		@Override
		public void initLHSVariables() {
			addVariableType(bpmn.getActivity(), lhsVariables);		// ACTIVITY
			addVariableType(bpmn.getIntermediate(), lhsVariables);	// INTERMEDIATE
			
			//queries
			addTargetQuery(lhsVariables,ACTIVITY,INTERMEDIATE,bpmn.getActivity_BoundaryEvents());
	 		
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
			addVariableType(bpmn.getActivity(), nacVars);	// ACTIVITY
			addNullMatches(nacVars, 1);						// INTERMEDIATE
			addVariableType(struc.getBpmnEventHandlerBlock(), nacVars);	// EHBLOCK
			
			//queries
			addSourceQuery(nacVars, NAC_EHBLOCK, ACTIVITY, struc.getBpmnEventHandlerBlock_Activity());
			
			return nacVars;
		}
		
	}
}