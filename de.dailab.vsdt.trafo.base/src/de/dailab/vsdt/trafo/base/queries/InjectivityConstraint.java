package de.dailab.vsdt.trafo.base.queries;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * TODO javadoc
 */
public class InjectivityConstraint extends Constraint {
	
	/**
	 * Default constructor.
	 * 
	 * @param creator	instantiated variable
	 * @param target	other variable of same type
	 */
	public InjectivityConstraint(Variable creator, Variable target) {
		super(creator, target);
	}

	@Override
	public boolean checkVariableValue(EObject thisValue, EObject otherValue) {
		return thisValue != otherValue;
	}
	
	@Override
	public void constrainTargetValues(EObject thisValue, List<EObject> targetValues) {
		targetValues.remove(thisValue);
	}
}
