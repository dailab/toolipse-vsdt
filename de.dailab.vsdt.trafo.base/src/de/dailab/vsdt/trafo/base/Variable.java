package de.dailab.vsdt.trafo.base;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.queries.Query;

/**
 * TODO javadoc
 */
public class Variable {
	
	/**status of variable*/
	private boolean instanciated = false;
	
	/**index of current value for variable inside the domain*/
	private int instanceIndex = 0;
	
	/**current value of variable*/
	private EObject instanceValue = null;
	
	/**all possible values for this variable*/
	private List<EObject> domain = new Vector<EObject>();
	
	/**possible values - already reduced by queries*/
	private List<EObject> dynamicDomain = null;
	
	/**queries associated with this variable*/
	private List<Query> queries = new Vector<Query>();
	
	/**this variable's type*/
	private EClass type= null;

	
	/**
	 * Default constructor.
	 * 
	 * @param domain	all possible values for this variable
	 */
	public Variable(EClass type, List<EObject> domain) {
		this.type= type;
		if (domain != null) {
			this.domain.addAll(domain);
		}
	}
	
	/**
     * @return	all possible values for this variable
     */	
	public List<EObject> getDomain() {
		return this.domain;
	}
	
	
	/**
	 * Reduce domain to a single value - used for defining matches in the NAC.
	 * 
	 * @param dom	value for this variable
	 */
	public void setDomain(EObject dom) {
		this.domain.clear();
		this.domain.add(dom);
	}
	
	/**
	 * Returns domain reduced by values which are already excluded by queries.
	 * 
	 * @return	domain reduced by queries
	 */
	public List<EObject> getDynamicDomain() {
		if (dynamicDomain == null) {
			dynamicDomain = new Vector<EObject>();
			dynamicDomain.addAll(domain);
		}
		return dynamicDomain;
	}
	
	/**
	 * Sets possible values for this variable.
	 * 
	 * @param dynamicDomain	new possible values
	 */ 
	public void setDynamicDomain(List<EObject> dynamicDomain) {
		this.dynamicDomain = dynamicDomain;
	}
	
	/**
	 * Adds a query to this variable.
	 * 
	 * @param query	query for adding
	 */		
	public void addQuery(Query query) {
		this.queries.add(query);
	}
	
	/**
	 * Instantiates variable with possible value from domain. This triggers query evaluation.
	 * If conflict occurs at queries, variable is instantiated with next possible value.
	 * 
	 * @return	instantiation successful?
	 */ 
	private boolean instanciate() {
		if (instanceIndex < domain.size()) {
			//initialize dynamic domain, if needed
			getDynamicDomain();
			
			instanciated= true;
			instanceValue= domain.get(instanceIndex);
			if (!dynamicDomain.contains(instanceValue)) {
				return nextInstance();
			}
			
			//Check Queries for Inconsistencies
			for (Query query : queries) {
				if (! query.eval()){
					//try next possible value
					return nextInstance();
				}
			}
			//instantiation successful
			return true;

		} else {
			// no possible value found
			deinstanciate();
			return false;
		}
	}
	
	/**
	 * Instantiate variable with next possible value.
	 * 
	 * @return	instantiation successful?
	 */
	public boolean nextInstance() {
		if (instanciated) {
			instanceIndex++;			
		}
		return instanciate();
	}
	
	/**
	 * Remove value from variable. Restore variable status before first instanciation.
	 */
	public void deinstanciate() {
		instanceIndex= 0;
		instanceValue= null;
		instanciated= false;
		for (int i = queries.size() - 1; i >= 0; i--) {
			queries.get(i).reEval();
		}
	}
	
	/**
	 * Returns current value of variable.
	 * 
	 * @return	current value of variable
	 */
	public EObject getInstanceValue() {
		return instanceValue;
	}
	
	/**
	 * Returns if variable is instantiated (has a value).
	 * 
	 * @return	if variable is instantiated (has a value)
	 */
	public boolean isInstanciated() {
		return instanciated;
	}
	
	/**
	 * @return	this variable's type
	 */
	public EClass getType() {
		return type;
	}
		
}
