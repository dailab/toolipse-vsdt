package de.dailab.vsdt.trafo.strucbpmn.export.rules.l2;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.trafo.base.AbstractRule;
import de.dailab.vsdt.trafo.base.AbstractWrapper;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertEmptyRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtWrapper;

/**
 * Remove Empty Rule
 * 
 * PATTERN: An activity with a name string identical to that given in the InsertEmptyRule
 * 
 * EFFECT: The activity will be removed
 */
public class RemoveEmptyRule extends AbstractRule {
	
	protected Activity _emptyAct= null;
	
	/**
	 * Default constructor.
	 */
	public RemoveEmptyRule(EObject root) {
		super(root,"Remove Empty Rule");
	}
	
	@Override
	protected void resetVars() {
		_emptyAct= null;
	}
	
	@Override
	protected AbstractWrapper getWrapper() {
		return new RuleWrapper();
	}

	
	@Override
	protected void apply() {
		deleteFromOwner(_emptyAct);
	}
	
	@Override
	protected void setWeightedLHS(List<EObject> matches){
		_emptyAct=	(Activity)	matches.get(RuleWrapper.EMPTY_ACT);
	}
	
	/**
	 * wrapper for the rule
	 */
	class RuleWrapper extends AbstractVsdtWrapper {
		
		public static final int EMPTY_ACT= 0;
		
		@Override
		public void initLHSVariables() {
			addVariableType(bpmn.getActivity(), lhsVariables); // EMPTY_ACT
			
			//reduce domains
			for (Iterator<EObject> iter = lhsVariables.get(EMPTY_ACT).getDomain().iterator(); iter.hasNext();) {
				Activity activity= (Activity) iter.next();
				boolean ok= true;
				/*
				 * by checking for identity instead of equality only those activities that
				 * were created by the rules are affected, and not those that were just
				 * coincidentally given that name
				 */
				ok&= activity.getName() == InsertEmptyRule.EMPTY_NAME;

				/*
				 * the Empty Activity must not be the only flow object in it's container
				 */
				int n= 0;
				for (Object o : activity.eContainer().eContents()) {
					if (o instanceof FlowObject) {
						n++;
					}
				}
				ok&= n> 1;
				
				if (! ok) {
					iter.remove();
				}
			}
			
		}

		@Override
		protected void initNACVariables() {
		}
	}
	
}