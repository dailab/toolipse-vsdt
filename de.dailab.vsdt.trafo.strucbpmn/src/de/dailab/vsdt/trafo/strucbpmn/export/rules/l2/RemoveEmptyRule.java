package de.dailab.vsdt.trafo.strucbpmn.export.rules.l2;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.trafo.base.util.Util;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InsertEmptyRule;
import de.dailab.vsdt.trafo.strucbpmn.util.AbstractVsdtRule;

/**
 * Remove Empty Rule
 * 
 * PATTERN: An activity with a name string identical to that given in the InsertEmptyRule
 * 
 * EFFECT: The activity will be removed
 */
public class RemoveEmptyRule extends AbstractVsdtRule {

	public static final int EMPTY_ACT= 0;
	
	@Override
	protected void apply(List<EObject> matches){
		Activity _emptyAct=	(Activity)	matches.get(EMPTY_ACT);
		
		Util.deleteFromOwner(_emptyAct);
	}
	
	
	@Override
	public void initLHSVariables() {
		addVariable(lhsVariables, bpmn.getActivity()); // EMPTY_ACT
		
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