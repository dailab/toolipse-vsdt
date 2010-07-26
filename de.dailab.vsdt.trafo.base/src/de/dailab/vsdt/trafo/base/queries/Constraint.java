package de.dailab.vsdt.trafo.base.queries;

import java.util.List;
import java.util.Vector;

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
	
	/** stored domain values of other variable */
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
			EObject otherValue = other.getInstanceValue();
			return checkVariableValue(self, otherValue);

		} else {
			// create backup of other's domain values
			if (oldDomain == null) {
				oldDomain = other.getDynamicDomain();
			}
			
			List<EObject> otherDomain= new Vector<EObject>(oldDomain);
			constrainTargetValues(self, otherDomain);
			if (! otherDomain.isEmpty()) {
				other.setDynamicDomain(otherDomain);
				return true;
			} else {
				return false;	
			}
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
	 * Reduce the given domain of the other variable to satisfy the constraint
	 * given the variable's instantiation.
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
			other.setDynamicDomain(oldDomain);
		}
		oldDomain = null;
	}
	
}