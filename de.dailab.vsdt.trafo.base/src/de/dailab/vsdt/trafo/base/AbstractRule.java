package de.dailab.vsdt.trafo.base;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * AbstractRule
 * 
 * This class contains common functionality 
 * and is a parent class for all generated rule classes. <br/>
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public abstract class AbstractRule {
	
	/**
	 * Executes this rule. First a wrapper is instantiated and initialized.
	 * Then a match has to be found. If there is a match, the rule is applied
	 * according to the match.
	 * 
	 * @return	rule applied?
	 */
	public final boolean execute(EObject object, Map<EClass, List<EObject>> typeToDomain) {

		// find match for LHS and NACs
		AbstractWrapper wrapper = getWrapper();
		wrapper.init(object, typeToDomain);
		List<EObject> match = wrapper.getSolution();

		// if match found, apply rule's RHS
		if (match != null) {
			apply(match);
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * apply this rule. transforms the LHS to the RHS.
	 */
	protected abstract void apply(List<EObject> match);
	
	
	/**
	 * this method has to be overwritten in the sub class and
	 * has to return a concrete wrapper for the concrete rule.
	 * 
	 * @return	the wrapper
	 */
	protected abstract AbstractWrapper getWrapper();
	
}
