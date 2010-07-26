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
	protected final Variable variable;
	
	/** uninstantiated variable - domain can be changed by query */
	protected final Variable target;
	
	/** old domain values of target variable */
	protected List<EObject> preDynamic = null;
	
	
	/**
	 * Default constructor.
	 *  
	 * @param variable	instantiated variable
	 * @param target	other variable to be constrained
	 */
	public Constraint(Variable creator, Variable target) {
		this.variable = creator;
		this.target = target;
	}
	
	
	/**
	 * Query initialization. Current domain of target variables is saved.
	 */
	public final void init(){
//		if (preDynamic == null) {
//			preDynamic = target.getDynamicDomain();
//		}
	}
	
	/**
	 * Undo eval method - if evaluated variable gets other value or is 
	 * de-instantiated. Old domain of target variable is restored.
	 */
	public final void undo() {
		if (preDynamic != null) {
			this.target.setDynamicDomain(preDynamic);
		}
		this.preDynamic = null;
	}
	

	public final boolean apply() {
		if (preDynamic == null) {
			// set preDynamic only if target is the target and not the source!
			preDynamic = target.getDynamicDomain();
		}
		return internalApply();
	}
	
	/**
	 * evaluate this query
	 */
	public abstract boolean internalApply();
	
}