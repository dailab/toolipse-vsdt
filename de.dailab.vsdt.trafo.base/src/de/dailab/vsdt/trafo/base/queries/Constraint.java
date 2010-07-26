package de.dailab.vsdt.trafo.base.queries;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * TODO javadoc
 */
public abstract class Constraint {
	
 	/** instantiated variable - instantiation evaluated by query */
	private final Variable variable;
	
	/** uninstantiated variable - domain can be changed by query */
	private final Variable other;
	
	/** old domain values of target variable */
	private List<EObject> preDynamic = null;
	
	
	/**
	 * Default constructor.
	 *  
	 * @param variable	instantiated variable
	 * @param other		other variable to be constrained
	 */
	public Constraint(Variable variable, Variable other) {
		this.variable = variable;
		this.other = other;
	}
	
	/**
	 * Undo apply method - if evaluated variable gets other value or is 
	 * de-instantiated. Old domain of target variable is restored.
	 */
	public final void undo() {
		if (preDynamic != null) {
			this.other.setDynamicDomain(preDynamic);
		}
		this.preDynamic = null;
	}
	

	public final boolean apply() {
		
		EObject thisValue = variable.getInstanceValue();
		if (other.isInstanciated()) {
			EObject otherValue = other.getInstanceValue();
			return checkVariableValue(thisValue, otherValue);

		} else {
			if (preDynamic == null) {
				preDynamic = other.getDynamicDomain();
			}
			
			List<EObject> targetvalues= new Vector<EObject>(preDynamic);
			constrainTargetValues(thisValue, targetvalues);
			if (! targetvalues.isEmpty()) {
				other.setDynamicDomain(targetvalues);
				return true;
			} else {
				return false;	
			}
		}
	}
	
	public abstract boolean checkVariableValue(EObject thisValue, EObject otherValue);
	
	public abstract void constrainTargetValues(EObject thisValue, List<EObject> targetValues);
	
}