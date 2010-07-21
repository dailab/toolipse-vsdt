package de.dailab.vsdt.trafo.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.dailab.vsdt.trafo.base.queries.InjectivityQuery;
import de.dailab.vsdt.trafo.base.queries.SourceQuery;
import de.dailab.vsdt.trafo.base.queries.TargetQuery;

/**
 * A wrapper class of the rule <em>SimpleRuleRule</em>'
 * for null, used for matching the LHS.
 */
public abstract class AbstractWrapper {
	
	/**HashMap for collecting instance objects of model types*/
	protected HashMap<EClass,List<EObject>> typeToDomain = new HashMap<EClass,List<EObject>>(5);
	
	/**variables for LHS nodes*/
	protected List<Variable> lhsVariables = new Vector<Variable>();
	
	/**variables for NAC nodes*/
	protected List<List<Variable>> nacVariables = new Vector<List<Variable>>(0);
	
	protected boolean random= true;
	
	
	/**
	 * Calls all required methods:
	 */
	public void init(EObject root) {
		fillTypeMap(root);
		initLHSVariables();
		initNACVariables();
//		createLinkQueries();
//		createNACLinkQueries();
		initVarQueries();
	}
	
	
	/**
	 * Associate objects inside the instance with their types.
	 * This method traverses the containment structure beginning with the root
	 * element. For each element's class and it's super classes a new entry in 
	 * the typeToDomain map is created and the element is inserted in the list.
	 * Finally the method is called for the element's children.
	 * 
	 * @param root topmost element of the instance (sub-)tree
	 */
	@SuppressWarnings("unchecked")
	protected void fillTypeMap(EObject root) {
		List<EObject> vec = null;
		
		// fill types vector with element's class and all super types
		List<EClass> types = new Vector<EClass>();
		types.add(root.eClass());
		types.addAll(root.eClass().getEAllSuperTypes());
		
		for (EClass type : types) {
			if (typeToDomain.get(type) == null) {
				//initialize with empty vector
				vec = new Vector<EObject>();
				typeToDomain.put(type, vec);
			} else {
				vec = typeToDomain.get(type);
			}
			//put element in domain vector
			vec.add(root);
		}
		if (root instanceof EAttribute) {
			fillTypeMap(((EAttribute)root).getEAttributeType());
		}
		//recursive call for child elements
		for (EObject child : root.eContents()) { 
			fillTypeMap(child);
		}
	}
	
	/**
	 * Initialization of LHS variables. Domain are all elements of the 
	 * instance with correct type or a child type.
	 * 1.: Add Variable Types
	 * 2.: Add Queries
	 * 3.: Reduce Domains
	 * 
	 *  example:
	 *  addVariableType(refPackage.getSequenceRef(), types, lhsVariables);
	 *  ...
	 *  addinjectivityQuery(lhsVariables,SEQREF1,SEQREF2);
	 *  addTargetQuery(lhsVariables,SEQFLOW1,FORK,bpmn.getSequenceFlow_Source());
	 *  ...
	 *  reduce domains
	 */
	protected abstract void initLHSVariables();
	
	/**
	 * Initialization of NAC variables. Domain are all elements of the 
	 * instance with correct type or a child type. Type queries are also
	 * created.
	 * 
	 * Here one method should be called for each NAC, being structured like 
	 * initLHSVariables() and returning the List of NAC variables
	 * 
	 * Example:
	 * nacVariables.add(createNAC1());
	 */
	protected abstract void initNACVariables();
	
	
	/**
	 * to be used in initLHSvariables and initNACVariables
	 * 
	 * @param type		the type to create
	 * @param vars		list of variables
	 */
	protected void addVariableType(EClass type, List<Variable> vars) {
		List<EObject> domain = getDomainForType(type);
		if (random) {
			domain = new Vector<EObject>(domain);
			Collections.shuffle(domain);
		}
		vars.add(new Variable(type,domain));
	}
	
	protected void addVariableType(EClass type, List<Variable> vars, int multiplicity) {
		for (int i = 0; i < multiplicity; i++) {
			addVariableType(type, vars);
		}
	}
			
	
	/**
	 * Create InjectivityQueries for _all_ variables in the given list.
	 * the types in the second list have to correspond to the variables
	 * in the first list.
	 * as result two variables can not have the same instance.
	 * 
	 * @param vars	list of variables
	 */ 
	protected void createInjectivityQueries(List<Variable> vars) {
		for(int i = 0; i < vars.size(); i++) {
			Variable var1= vars.get(i);
			for (int j = i + 1; j < vars.size(); j++) {
				Variable var2= vars.get(j);
				if(typesLinked(var1.getType(), var2.getType())) {
					InjectivityQuery iq = new InjectivityQuery(var1, var2);
					vars.get(i).addQuery(iq);
				}
			}
		}
	}
	
	
	/**
	 * create a single injectivity query for the given variables
	 * note that the first variable has to be instantiated before the second!
	 * 
	 * @param vars		variable list
	 * @param creator	index of first variable in list
	 * @param target	index of second variable in list
	 */
	protected void addInjectivityQuery(List<Variable> vars, int creator, int target) {
		addInjectivityQuery(vars.get(creator), vars.get(target));
	}
	
	
	/**
	 * create a single injectivity query for the given variables
	 * note that the first variable has to be instantiated before the second!
	 * 
	 * @param creator	first variable
	 * @param target	second variable
	 */
	protected void addInjectivityQuery(Variable creator, Variable target) {
		InjectivityQuery iq = new InjectivityQuery(creator,target);
		creator.addQuery(iq);
	}
	
	
	/**
	 * Check if type1 is subtype of type2 or vice versa.
	 * 
	 * @param type1	first checked type
	 * @param type2	second checked type
	 * @return		if there is a subtype relation between types
	 */
	protected boolean typesLinked(EClass type1, EClass type2){
		if(type1==null || type2==null){
			return false;
		}
		if(type1.equals(type2)){
			return true;
		}
		if(type1.getEAllSuperTypes().contains(type2)){
			return true;
		}
		if(type2.getEAllSuperTypes().contains(type1)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * Create VariableQueries (LHS only)
	 */
	protected void initVarQueries(){
	}
		
	/**
	 * Using Matchfinder for computing solutions. Matches for LHS are checked with NACs.
	 * 
	 * @return		first solution with correct index
	 */
	public List<EObject> getSolution() {
		Matchfinder matchfinder= new Matchfinder(lhsVariables,nacVariables);
		matchfinder.findMatches();
		return matchfinder.getSolution();
	}
	
	
//	/**
//	 * shuffle the vector of EObjects (the domain set) and return it
//	 * 
//	 * @param domain	domain
//	 * @return			randomized domain
//	 */
//	protected List<EObject> shuffleDomain(List<EObject> domain){
//		List<EObject> domainCopy = new Vector<EObject>(domain);
//		Collections.shuffle(domainCopy);
//		return domainCopy;
//	}
	
	/**
	 * returns the list of all instances for a give eClass
	 * 
	 * @param type	the eClass of interest
	 * @return		list of all instances
	 */
	protected List<EObject> getDomainForType(EClass type) {
		List<EObject> domain = typeToDomain.get(type);
		if(domain == null){
			domain = new Vector<EObject>();
		}
		return domain;
	}
	
	/**
	 * add a new target query for a reference.
	 * use this query, if the source variable has been declared first
	 * 
	 * @param varSet	the variable set
	 * @param sourceNr	the index of the source element
	 * @param targetNr	the index of the target element
	 * @param ref		the reference
	 */
	protected void addTargetQuery(List<Variable> varSet, int sourceNr, int targetNr, EStructuralFeature ref) {
		Variable source = varSet.get(sourceNr);
		Variable target = varSet.get(targetNr);
		TargetQuery tq = new TargetQuery(source, target, ref);
		source.addQuery(tq);
	}
	
	/**
	 * add a new source query for a reference.
	 * use this query, if the target variable has been declared first
	 * 
	 * @param varSet	the variable set
	 * @param sourceNr	the index of the source element
	 * @param targetNr	the index of the target element
	 * @param ref		the reference
	 */
	protected void addSourceQuery(List<Variable> varSet, int sourceNr, int targetNr, EStructuralFeature ref) {
		Variable source = varSet.get(sourceNr);
		Variable target = varSet.get(targetNr);
		SourceQuery sq = new SourceQuery(source, target, ref);
		target.addQuery(sq);
	}
	
	/**
	 * add a number of null-matches to the given NAC-varSet
	 * 
	 * @param vars		the list of (NAC) variables
	 * @param types		the list of types
	 * @param count		the number of null-matches to insert
	 */
	protected void addNullMatches(List<Variable> vars, int count) {
		for (int i=0; i<count; i++) {
			vars.add(null);
		}
	}
	
	// ONLY OBSOLETE METHODS BEYOND THIS POINT

	/**
	 * add a new target query for a reference.
	 * use this query, if the source variable has been declared first
	 * 
	 * @param varSet	the variable set
	 * @param sourceNr	the index of the source element
	 * @param targetNr	the index of the target element
	 * @param refName	the name of the reference
	 */
//	@Deprecated
//	protected void addTargetQuery(List<Variable> varSet, int sourceNr, int targetNr, String refName) {
//		Variable source = varSet.get(sourceNr);
//		EReference ref= (EReference) source.getType().getEStructuralFeature(refName);
//		addTargetQuery(varSet, sourceNr, targetNr, ref);
//	}
	
	/**
	 * add a new source query for a reference.
	 * use this query, if the target variable has been declared first
	 * 
	 * @param varSet	the variable set
	 * @param sourceNr	the index of the source element
	 * @param targetNr	the index of the target element
	 * @param refName	the name of the reference
	 */
//	@Deprecated
//	protected void addSourceQuery(List<Variable> varSet, int sourceNr, int targetNr, String refName) {
//		Variable source = varSet.get(sourceNr);
//		EReference ref= (EReference) source.getType().getEStructuralFeature(refName);
//		addSourceQuery(varSet, sourceNr, targetNr, ref);
//	}
	
	/**
	 * Create source and target queries for LHS variables.
	 * 
	 * example:
	 * addTargetQuery(lhsVariables,SEQFLOW1,FORK,"source");
	 * ...
	 */
//	protected abstract void createLinkQueries();
	
	/**
	 * Create Source- and TargetQueries for NAC variables.
	 */
//	protected abstract void createNACLinkQueries();
	
	/**
	 * Remove objects from domain of LHS variables that don't have correct attribute values.
	 * 
	 * example:
	 *	List<EObject> domain = null;
	 *	domain = lhsVariables.get(FORK).getDomain();
	 *	for (int i = domain.size()-1; i>=0; i--) {
	 *		boolean ok= true;
	 *		...
	 *		if (!ok) {
	 *			domain.remove(gateway);
	 *		}
	 *	}	
	 */
//	protected abstract void reduceLHSDomains();
	
	/**
	 * Remove objects from domain of NAC variables that don't have correct attribute values.
	 * 
	 * example: same as for lhs, just with domain= nacVariables.get(X).get(...)
	 */
//	protected abstract void reduceNACDomains();
	
	/**
	 * Using Matchfinder for computing solutions. Matches for LHS are checked with NACs.
	 * 
	 * @return		all solutions 
	 */
//	public List<List<EObject>> getSolutions(){
//		Matchfinder matchfinder = new Matchfinder(lhsVariables,nacVariables,false);
//		return matchfinder.getSolutions();
//	}
	
	/**
	 * Returns all possible solutions for a specific object.
	 * 
	 * @param index	the index of the object
	 * @return		A vector with all possible solutions.
	 */
//	public List<EObject> getSolutionForIndex(int index) {
//		List<List<EObject>> solutions = getSolutions();
//		List<EObject> result = new Vector<EObject>();
//		if (solutions != null) {
//			if (solutions.get(0).size() < index) return null;
//			for (int i = 0; i < solutions.size(); i++) {
//				EObject current = (EObject) solutions.get(i).get(index);
//				if (!result.contains(current))
//					result.add(current);
//			}
//		}
//		return result;
//	}
	
	/**
	 * reduce both LHS and NAC domains
	 */
//	public void reduceDomains() {
//		reduceLHSDomains();
//		reduceNACDomains();
//	}	
	
	/**
	 * Set a (partial) mapping for LHS. Domain of variables is reduced to mapped objects if mapping is possible.
	 * 
	 * this method is called, but actually not needed
	 */
//	public void instanciateVariables(List<EObject> mapping) {
//		for (int i = 0; i < mapping.size(); i++) {
//			if (mapping.get(i) != null) {
//				EObject eObject = mapping.get(i);
//				Variable var = lhsVariables.get(i);
//				if (var.getDomain().contains(eObject)) {
//					var.setDomain(eObject);
//				}
//				else {
//					System.err.println("Assigned value is not part of the variable domain");
//				}
//			}
//		}
//	}
	
	
		
}