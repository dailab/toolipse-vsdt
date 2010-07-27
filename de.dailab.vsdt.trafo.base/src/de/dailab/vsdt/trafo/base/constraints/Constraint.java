package de.dailab.vsdt.trafo.base.constraints;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * A Constraint is some clause that constrains the domains of two related 
 * variables. A Constraint can be related to the Variables having disjunct
 * values, having matching attribute values or one variable referencing the 
 * other. 
 */
public abstract class Constraint {
	
 	/** the variable this constraint is applied to */
	private final Variable variable;
	
	/** other variable which is constrained w.r.t. the first variable*/
	private final Variable other;
	
	/** stored constrained domain values of other variable */
	private List<EObject> oldDomain = null;
	
	
	/**
	 * Create new Constraint.
	 *  
	 * @param variable	instantiated variable
	 * @param other		other variable to be constrained
	 */
	public Constraint(Variable variable, Variable other) {
		this.variable = variable;
		this.other = other;
	}
	
	/**
	 * When applied, a constraint can do two things: If the other variable has
	 * already been instantiated, there is nothing more to do than to check
	 * whether the variable under evaluation is fit for this other variable's
	 * instantiation. Otherwise, if the other variable has not yet been
	 * instantiated but only the variable under evaluation, then the other
	 * variables domain is reduced to satisfy the constraint.
	 * 
	 * @return		True, if the constraint could be satisfied for any variable.
	 */
	public final boolean apply() {
		
		EObject self = variable.getInstanceValue();
		
		if (other.isInstanciated()) {
			// check variable value
			return checkVariableValue(self, other.getInstanceValue());

		} else {
			// create backup of other variable's domain values
			oldDomain = new ArrayList<EObject>(other.getConstrainedDomain());
				
			// constrain other variable's domain
			List<EObject> otherDomain= other.getConstrainedDomain();
			constrainTargetValues(self, otherDomain);
			return ! otherDomain.isEmpty();
		}
	}
	
	/**
	 * Check whether the variable's value (i.e. its instantiation) satisfies the
	 * constraint given the other variable's value.
	 * 
	 * @param self		the variable's instantiation
	 * @param other		the other variable's instantiation
	 * @return			instantiations satisfy constraint?
	 */
	public abstract boolean checkVariableValue(EObject self, EObject other);
	
	/**
	 * Reduce the given domain of the other variable (in-place) to satisfy the
	 * constraint given the variable's instantiation.
	 * 
	 * @param self			the variable's instantiation
	 * @param otherDomain	possible values for other variable
	 */
	public abstract void constrainTargetValues(EObject self, List<EObject> otherDomain);
	
	/**
	 * Undo apply method. This is only needed if the constainTargetValues method
	 * has been called (but will be invoked in any case non the less), restoring
	 * the other variables domain to what is was before the application of the
	 * constraint.
	 */
	public final void undo() {
		if (oldDomain != null) {
			other.getConstrainedDomain().clear();
			other.getConstrainedDomain().addAll(oldDomain);
			oldDomain = null; // undo may be called only once
		}
	}
	
}