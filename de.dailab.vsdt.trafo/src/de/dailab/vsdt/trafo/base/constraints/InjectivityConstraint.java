package de.dailab.vsdt.trafo.base.constraints;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * This constraint checks the variable's injectivity, i.e. whether the variable
 * has another instantiation than the other variable.
 */
public class InjectivityConstraint extends Constraint {
	
	/**
	 * Create Injectivity Constraint.
	 * 
	 * @param variable	instantiated variable
	 * @param other		other variable of same type
	 */
	public InjectivityConstraint(Variable variable, Variable other) {
		super(variable, other);
	}

	/**
	 * not the same
	 */
	@Override
	public boolean checkVariableValue(EObject self, EObject other) {
		return self != other;
	}
	
	/**
	 * remove self from domain
	 */
	@Override
	public void constrainTargetValues(EObject self, List<EObject> otherDomain) {
		otherDomain.remove(self);
	}
}
