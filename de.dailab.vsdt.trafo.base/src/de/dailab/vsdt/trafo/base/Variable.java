package de.dailab.vsdt.trafo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.constraints.Constraint;

/**
 * A Variable represents an instantiation for some object in the Transformation
 * Rule's patterns. It is defined by a type and a number of constraints. The 
 * variable provides functionality similar to an iterator, probing for the next
 * possible instance value for this variable, given the constraints and the
 * current instantiation of the other variables w.r.t. which this variable's
 * value is constrained.
 */
public class Variable {
	
	/** this variable's type */
	private final EClass type;

	/** all possible values for this variable */
	private final List<EObject> domain;
	
	/** constraints associated with this variable */
	private final List<Constraint> constraints;

	/** possible values, reduced by constraints */
	private final List<EObject> constrainedDomain;

	
	/** iterator used to check one possible instance value after the other */ 
	private Iterator<EObject> domainIterator= null;
	
	/** current value of variable */
	private EObject instanceValue = null;
	
	
	/**
	 * Create new Variable
	 * 
	 * @param type		type of this variable
	 * @param domain	all possible values for this variable
	 */
	public Variable(EClass type, List<EObject> domain) {
		this.type= type;
		this.domain = new ArrayList<EObject>(domain);
		this.constraints = new ArrayList<Constraint>();
		this.constrainedDomain = new ArrayList<EObject>(domain);
	}
	
	/**
	 * Adds a Constraint to this variable. The Constraint's variable should be
	 * this variable!
	 * 
	 * @param constraint Some Constraint to be added to this Variable
	 */		
	public void addConstraint(Constraint constraint) {
		constraints.add(constraint);
	}
	
	/**
	 * Instantiate the Variable with the next possible value from the domain so
	 * that all the Constraints are satisfied. The actual instance value can be
	 * retrieved with the {@link #getInstanceValue()} method. 
	 * 
	 * @return	instantiation successful?
	 */ 
	public boolean nextInstance() {
		// before trying the next value, undo the constraints imposed upon other
		// variables to comply to the current value
		undoConstraints();	
		
		if (domainIterator == null) {
			domainIterator = domain.iterator();
		}
		if (domainIterator.hasNext()) {
			instanceValue = domainIterator.next();

			// get next value from domain that is also in the constrained domain
			if (! constrainedDomain.contains(instanceValue)) {
				return nextInstance();
			}
			
			// check Constraints for Inconsistencies with other Variables
			for (Constraint constraint : constraints) {
				if (! constraint.apply()){
					// try next possible value
					return nextInstance();
				}
			}
			// instantiation successful
			return true;

		} else {
			// no possible value found; backtrack to previous variable
			deinstanciate();
			return false;
		}
	}
	
	/**
	 * This method undoes all the constraints associated with this variable, 
	 * therefore also lifting the constraints imposed on other variables.
	 */
	public void undoConstraints() {
		for (int i = constraints.size() - 1; i >= 0; i--) {
			constraints.get(i).undo();
		}
	}
	
	/**
	 * Reset this variable's instantiation, also undoing any constraints. 
	 */
	public void deinstanciate() {
		domainIterator = null;
		instanceValue  = null;
		undoConstraints();
	}

	/**
	 * This method can be used for further reducing a variables domain.
	 * Warning: This method returns the domain list itself, not a copy!
	 * 
     * @return	the List representing the variables domain
     */	
	public List<EObject> getDomain() {
		return this.domain;
	}
	
	/**
	 * This method can be used for constraining a variables domain.
	 * Warning: This method returns the domain list itself, not a copy!
	 * 
	 * @return	domain constrained according to constraints
	 */
	public List<EObject> getConstrainedDomain() {
		return constrainedDomain;
	}
	
	/**
	 * @return	the current instantiation value of variable
	 */
	public EObject getInstanceValue() {
		return instanceValue;
	}
	
	/**
	 * @return	true, if the variable is instantiated
	 */
	public boolean isInstanciated() {
		return instanceValue != null;
	}
	
	/**
	 * @return	this variable's type
	 */
	public EClass getType() {
		return type;
	}
		
}
