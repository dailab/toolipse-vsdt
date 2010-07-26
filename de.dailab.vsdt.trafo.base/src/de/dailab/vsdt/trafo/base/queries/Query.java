package de.dailab.vsdt.trafo.base.queries;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;

/**
 * TODO javadoc
 */
public abstract class Query {
	
 	/**instantiated variable - instantiation evaluated by query*/
	protected Variable creator = null;
	
	/**uninstantiated variable - domain can be changed by query*/
	protected Variable target = null;
	
	/**old domain values of target variable*/
	protected List<EObject> preDynamic = null;
	
	/**new domain values for target variable
	 * this list is filled with values during eval and then replaces the preDynamic list
	 */
	protected List<EObject> values = new Vector<EObject>();
	
	/**
	 * Default constructor.
	 *  
	 * @param creator	instantiated variable
	 * @param target	other variable
	 */
	public Query(Variable creator, Variable target) {
		this.creator = creator;
		this.target = target;
	}
	
	/**
	 * Returns new domain of target variable.
	 * 
	 * @return	new domain of target variable
	 */
	public final List<EObject> getValues() {
		return this.values;
	}
	
	/**
	 * Query initialization. Current domain of target variables is saved.
	 */
	public final void init(){
		if (this.preDynamic == null) {
			this.preDynamic = target.getDynamicDomain();
		}
		this.values.clear();
	}
	
	/**
	 * Undo eval method - if evaluated variable gets other value or is 
	 * de-instantiated. Old domain of target variable is restored.
	 */
	public final void reEval() {
		if (preDynamic != null) {
			this.target.setDynamicDomain(preDynamic);
		}
		this.preDynamic = null;
	}
	
	/**
	 * evaluate this query
	 */
	public abstract boolean eval();
	
}