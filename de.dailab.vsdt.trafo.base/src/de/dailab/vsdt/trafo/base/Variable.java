package de.dailab.vsdt.trafo.base;

import java.util.List;
import java.util.Vector;

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
	private List<EObject> constrainedDomain;

	
	/** status of variable */
	private boolean instanciated = false;
	
	/** index of current value for variable inside the domain */
	private int instanceIndex = 0;
	
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
		this.domain = new Vector<EObject>(domain);
		this.constraints = new Vector<Constraint>();
		this.constrainedDomain = new Vector<EObject>(domain);
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
	private boolean instanciate() {
		if (instanceIndex < domain.size()) {
			instanciated= true;

			// get next value from domain that is also in the constrained domain
			instanceValue= domain.get(instanceIndex);
			if (! constrainedDomain.contains(instanceValue)) {
				return nextInstance();
			}
			
			//Check Queries for Inconsistencies
			for (Constraint constraint : constraints) {
				if (! constraint.apply()){
					//try next possible value
					return nextInstance();
				}
			}
			//instantiation successful
			return true;

		} else {
			// no possible value found
			deinstanciate();
			return false;
		}
	}
	
	/**
	 * Instantiate variable with next possible value.
	 * 
	 * @return	instantiation successful?
	 */
	public boolean nextInstance() {
		if (instanciated) {
			instanceIndex++;			
		}
		return instanciate();
		
//		deinstanciate();
//		
//		if (instanceIndex < domain.size()) {
//			instanciated= true;
//
//			// get next value from domain that is also in the constrained domain
//			instanceValue= domain.get(instanceIndex);
//			if (! constrainedDomain.contains(instanceValue)) {
//				return nextInstance();
//			}
//			
//			//Check Queries for Inconsistencies
//			for (Constraint constraint : constraints) {
//				if (! constraint.apply()){
//					//try next possible value
//					return nextInstance();
//				}
//			}
//			//instantiation successful
//			return true;
//
//		} else {
//			// no possible value found; reset instance index and de-instantiate
//			instanceIndex= -1;
//			deinstanciate();
//			return false;
//		}
	}
	
	/**
	 * Reset this variable's instantiation. More importantly, this method undoes
	 * all the constraints associated with this variable, therefore also lifting
	 * the constraints imposed on other variables.
	 */
	public void deinstanciate() {
		instanceIndex= 0;
		instanceValue= null;
		instanciated= false;
		for (int i = constraints.size() - 1; i >= 0; i--) {
			constraints.get(i).undo();
		}
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
//		return new Vector<EObject>(constrainedDomain);
		return constrainedDomain;
	}
	
	/**
	 * Sets constrained domain for this variable.
	 * 
	 * @param constrainedDomain		new constrained domain
	 */ 
	@Deprecated
	public void setConstrainedDomain(List<EObject> domainValues) {
		constrainedDomain.clear();
		constrainedDomain.addAll(domainValues);
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
		return instanciated;
//		return instanceIndex >= 0;
	}
	
	/**
	 * @return	this variable's type
	 */
	public EClass getType() {
		return type;
	}
		
}
