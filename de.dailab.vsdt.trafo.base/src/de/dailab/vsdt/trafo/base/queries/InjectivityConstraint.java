package de.dailab.vsdt.trafo.base.queries;

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
	 * @param self		instantiated variable
	 * @param other		other variable of same type
	 */
	public InjectivityConstraint(Variable self, Variable other) {
		super(self, other);
	}

	@Override
	public boolean checkVariableValue(EObject self, EObject other) {
		return self != other;
	}
	
	@Override
	public void constrainTargetValues(EObject self, List<EObject> otherDomain) {
		otherDomain.remove(self);
	}
}
