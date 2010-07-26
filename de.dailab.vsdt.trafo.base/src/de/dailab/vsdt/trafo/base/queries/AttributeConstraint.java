package de.dailab.vsdt.trafo.base.queries;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * This constraint checks whether the variable and the other variable have some
 * attribute value in common.
 */
public class AttributeConstraint extends Constraint {
	
	/** variable's attribute */
	private final EAttribute selfAttribute;
	
	/** other variable's attribute */
	private final EAttribute otherAttribute;
	
	/**
	 * Create Attribute Constraint.
	 * 
	 * @param self				instantiated variable 
	 * @param other				second variable, has equal attribute value to creator
	 * @param selfAttribute		compared attribute at creator
	 * @param otherAttribute	compared attribute at target
	 */
	public AttributeConstraint(Variable self, Variable other, EAttribute selfAttribute, EAttribute otherAttribute) {
		super(self, other);
		this.selfAttribute = selfAttribute;
		this.otherAttribute = otherAttribute;
	}

	@Override
	public boolean checkVariableValue(EObject self, EObject other) {
		return matches(self.eGet(selfAttribute),
				       other.eGet(otherAttribute));
	}
	
	@Override
	public void constrainTargetValues(EObject self, List<EObject> otherDomain) {
		Object value = self.eGet(selfAttribute);
		for (Iterator<EObject> iter = otherDomain.iterator(); iter.hasNext();) {
			Object other = iter.next().eGet(otherAttribute);
			if (! matches(value, other)) {
				iter.remove();
			}
		}
	}
	
	/**
	 * @param source	some object
	 * @param target	some other object
	 * @return			true, if both are null or equal
	 */
	private boolean matches(Object source, Object target) {
		if (source == null) {
			return target == null;
		} else {
			return source.equals(target);
		}
	}
}
