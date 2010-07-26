package de.dailab.vsdt.trafo.base.queries;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * TODO javadoc
 */
public class VariableConstraint extends Constraint {
	
	/** compared attributes: source */
	private final EAttribute sourceAttribute;
	
	/** compared attributes: target */
	private final EAttribute targetAttribute;
	
	/**
	 * Default constructor.
	 * 
	 * @param creator			instantiated variable 
	 * @param target			second variable, has equal attribute value to creator
	 * @param sourceAttribute	compared attribute at creator
	 * @param targetAttribute	compared attribute at target
	 */
	public VariableConstraint(Variable creator, Variable target, EAttribute sourceAttribute, EAttribute targetAttribute) {
		super(creator, target);
		this.sourceAttribute = sourceAttribute;
		this.targetAttribute = targetAttribute;
	}

	@Override
	public boolean checkVariableValue(EObject thisValue, EObject otherValue) {
		return matches(thisValue.eGet(sourceAttribute),
				       otherValue.eGet(targetAttribute));
	}
	
	@Override
	public void constrainTargetValues(EObject thisValue, List<EObject> targetValues) {
		Object value = thisValue.eGet(sourceAttribute);
		for (Iterator<EObject> iter = targetValues.iterator(); iter.hasNext();) {
			Object other = iter.next().eGet(targetAttribute);
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
