package de.dailab.vsdt.trafo.base.queries;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * This Constraint checks whether the variables are in some way related to each
 * other. 
 */
public class ReferenceConstraint extends Constraint {
	
	/** the variable's reference */
	private final EReference reference;
	
	/**
	 * Create Reference Constraint.
	 *  
	 * @param variable		instantiated variable
	 * @param other			other variable, target of a link from creator
	 * @param reference		reference feature
	 */
	public ReferenceConstraint(Variable variable, Variable other, EReference reference) {
		super(variable, other);
		this.reference= reference;
	}
	
	/**
	 * check whether self references other
	 */
	@Override
	public boolean checkVariableValue(EObject self, EObject other) {
		Object value = self.eGet(reference);
		if (reference.isMany()) {
			return ((List) value).contains(other);
		} else {
			return value == other;
		}
	}
	
	/**
	 * retain all elements from domain that are references by self
	 */
	@Override
	public void constrainTargetValues(EObject self, List<EObject> otherDomain) {
		Object value = self.eGet(reference);
		if (reference.isMany()) {
			otherDomain.retainAll((List) value);
		} else {
			otherDomain.retainAll(Collections.singletonList(value));
		}
	}
	
}
