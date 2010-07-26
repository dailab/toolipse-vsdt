package de.dailab.vsdt.trafo.base.queries;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * TODO javadoc
 */
public class InjectivityConstraint extends Constraint {
	
	/**
	 * Default constructor. 
	 * @param creator instantiated variable
	 * @param target other variable of same type
	 */
	public InjectivityConstraint(Variable creator, Variable target) {
		super(creator, target);
	}
	
	/**
	 * Checks if an injective match is possible and ensures that other variable
	 * can't be instantiated with the current value of the evaluated one.
	 */
	public boolean internalApply() {
		List<EObject> values= new Vector<EObject>(preDynamic);
		values.remove(variable.getInstanceValue());
		if (! values.isEmpty()) {
			target.setDynamicDomain(values);
			return true;
		} else {
			return false;	
		}
	}
	
}
