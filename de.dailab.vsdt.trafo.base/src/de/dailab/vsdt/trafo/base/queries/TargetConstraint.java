package de.dailab.vsdt.trafo.base.queries;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * TODO javadoc
 */
public class TargetConstraint extends Constraint {
	
	/**the reference*/
	private final EStructuralFeature ref;
	
	/**
	 * Default constructor.
	 *  
	 * @param creator	instantiated variable
	 * @param target	other variable, target of a link from creator
	 * @param ref		reference feature
	 */
	public TargetConstraint (Variable creator, Variable target, EStructuralFeature ref) {
		super(creator,target);
		this.ref= ref;
	}
	
	/**
	 * Domain of the target variable is reduced to the elements which are
	 * referenced from the source value.
	 */
	public boolean internalApply() {
		List<EObject> values= new Vector<EObject>();
		EObject sourceValue= variable.getInstanceValue();
		
		//add values referenced by creator in values list, if in preDynamic
		if (ref.isMany()) {
			List<EObject> targetValues = (List) sourceValue.eGet(ref);
			for (EObject targetValue : targetValues) {
				if (preDynamic.contains(targetValue)) {
					values.add(targetValue);
				}
			}
		} else {
			EObject targetValue= (EObject) sourceValue.eGet(ref); 
			if (preDynamic.contains(targetValue)) {
				values.add(targetValue);
			}
		}
		if (! values.isEmpty()) {
			target.setDynamicDomain(values);
			return true;
		}
		return false;
	}
	
}
