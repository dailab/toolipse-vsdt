package de.dailab.vsdt.trafo.base;

import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.queries.Constraint;

/**
 * TODO javadoc
 */
public class Variable {
	
	/** this variable's type */
	private final EClass type;

	/** all possible values for this variable */
	private final List<EObject> domain;
	
	/** constraints associated with this variable */
	private final List<Constraint> constraints;

	/** possible values, already reduced by constraints */
	private List<EObject> dynamicDomain = null;

	
	/** status of variable */
	private boolean instanciated = false;
	
	/** index of current value for variable inside the domain */
	private int instanceIndex = 0;
	
	/** current value of variable */
	private EObject instanceValue = null;
	
	
	/**
	 * Default constructor.
	 * 
	 * @param domain	all possible values for this variable
	 */
	public Variable(EClass type, List<EObject> domain) {
		this.type= type;
		this.domain = new Vector<EObject>(domain);
		this.constraints = new Vector<Constraint>();
		this.dynamicDomain = new Vector<EObject>(domain);
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
	 * Adds a Constraint to this variable. The Constraint's variable should be
	 * this variable!
	 * 
	 * @param constraint Some Constraint to be added to this Variable
	 */		
	public void addConstraint(Constraint query) {
		this.constraints.add(query);
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
			for (Constraint query : constraints) {
				if (! query.apply()){
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
	 * Remove value from variable. Restore variable status before first
	 * instantiation.
	 */
	public void deinstanciate() {
		instanceIndex= 0;
		instanceValue= null;
		instanciated= false;
		for (int i = constraints.size() - 1; i >= 0; i--) {
			constraints.get(i).undo();
		}
		dynamicDomain = null;
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
