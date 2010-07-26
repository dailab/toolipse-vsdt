package de.dailab.vsdt.trafo.base.queries;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * TODO javadoc
 */
public class ReferenceConstraint extends Constraint {
	
	/**the reference*/
	private final EReference ref;
	
	/**
	 * Default constructor.
	 *  
	 * @param creator	instantiated variable
	 * @param target	other variable, target of a link from creator
	 * @param ref		reference feature
	 */
	public ReferenceConstraint (Variable creator, Variable target, EReference ref) {
		super(creator, target);
		this.ref= ref;
	}
	
	@Override
	public boolean checkVariableValue(EObject self, EObject other) {
		Object value = self.eGet(ref);
		if (ref.isMany()) {
			return ((List) value).contains(other);
		} else {
			return value == other;
		}
	}
	
	@Override
	public void constrainTargetValues(EObject self, List<EObject> otherDomain) {
		Object value = self.eGet(ref);
		if (ref.isMany()) {
			otherDomain.retainAll((List) value);
		} else {
			otherDomain.retainAll(Collections.singletonList(value));
		}
	}
	
}
