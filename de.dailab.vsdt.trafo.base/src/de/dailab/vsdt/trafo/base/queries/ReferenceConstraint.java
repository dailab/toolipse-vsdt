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
	 * @param self			instantiated variable
	 * @param other			other variable, target of a link from creator
	 * @param reference		reference feature
	 */
	public ReferenceConstraint(Variable self, Variable other, EReference reference) {
		super(self, other);
		this.reference= reference;
	}
	
	@Override
	public boolean checkVariableValue(EObject self, EObject other) {
		Object value = self.eGet(reference);
		if (reference.isMany()) {
			return ((List) value).contains(other);
		} else {
			return value == other;
		}
	}
	
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
