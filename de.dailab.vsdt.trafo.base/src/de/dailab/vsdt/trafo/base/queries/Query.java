package de.dailab.vsdt.trafo.base.queries;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.Variable;


/**
 * Class : Query <br/>
 * Package : rules <br/>
 * Project : RuleProject <br/>
 * Created On : 10.01.2006 <br/>
 * Description : Parent class of the other query types.
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
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
	public Query(Variable creator, Variable target){
		this.creator = creator;
		this.target = target;
	}
	
	/**
	 * Returns new domain of target variable.
	 * 
	 * @return	new domain of target variable
	 */
	public List<EObject> getValues(){
		return this.values;
	}
	
	
	/**
	 * evaluate this query
	 */
	public abstract boolean eval();
	
	
	/**
	 * Query initialisation. Current domain of target variables is saved.
	 */
	public void init(){
		if (this.preDynamic==null) {
			this.preDynamic = target.getDynamicDomain();
		}
		this.values.clear();
	}
	
	/**
	 * Undo eval method - if evaluated variable gets other value or is 
	 * de-instantiated. Old domain of target variable is restored.
	 */
	public void reEval(){
		if(preDynamic!=null){
			this.target.setDynamicDomain(preDynamic);
		}
		this.preDynamic = null;
	}
}