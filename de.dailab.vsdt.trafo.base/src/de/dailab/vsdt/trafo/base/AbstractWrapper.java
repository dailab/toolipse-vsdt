package de.dailab.vsdt.trafo.base;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.dailab.vsdt.trafo.base.queries.InjectivityQuery;
import de.dailab.vsdt.trafo.base.queries.SourceQuery;
import de.dailab.vsdt.trafo.base.queries.TargetQuery;
import de.dailab.vsdt.trafo.base.queries.VariableQuery;
import de.dailab.vsdt.trafo.base.util.Util;

/**
 * Class wrapping the matching part of the Rules.
 */
public abstract class AbstractWrapper {
	
	/**HashMap for collecting instance objects of model types*/
	protected Map<EClass, List<EObject>> typeToDomain;
	
	/**variables for LHS nodes*/
	protected List<Variable> lhsVariables = new Vector<Variable>();
	
	/**variables for NAC nodes*/
	protected List<List<Variable>> nacVariables = new Vector<List<Variable>>();
	
	
	/**
	 * Calls all required methods:
	 */
	public void init(EObject root, Map<EClass,List<EObject>> typeToDomain) {

		// XXX why does the type map have to be recalculated each time?
//		this.typeToDomain = typeToDomain;
		this.typeToDomain = Util.createTypeMap(root);
		
		initLHSVariables();
		initNACVariables();
		initVarQueries();
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
		vars.add(new Variable(type, getDomainForType(type)));
	}
	
	protected void addVariableType(EClass type, List<Variable> vars, int multiplicity) {
		for (int i = 0; i < multiplicity; i++) {
			addVariableType(type, vars);
		}
	}
			
	
	/**
	 * Create InjectivityQueries for _all_ variables in the given list that can
	 * have shared instances. As result two variables can not have the same 
	 * instance.
	 * 
	 * @param vars	list of variables
	 */ 
	protected void createInjectivityQueries(List<Variable> vars) {
		for(int i = 0; i < vars.size(); i++) {
			Variable var1= vars.get(i);
			for (int j = i + 1; j < vars.size(); j++) {
				Variable var2= vars.get(j);
				if (Util.typesLinked(var1.getType(), var2.getType())) {
					InjectivityQuery iq = new InjectivityQuery(var1, var2);
					var1.addQuery(iq);
				}
			}
		}
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
		Matchfinder matchfinder= new Matchfinder(lhsVariables, nacVariables);
		return matchfinder.findMatches();
	}
	
	
	/**
	 * returns the list of all instances for a give eClass
	 * 
	 * @param type	the eClass of interest
	 * @return		list of all instances
	 */
	protected List<EObject> getDomainForType(EClass type) {
		List<EObject> domain = typeToDomain.get(type);
		if (domain == null) {
			return new Vector<EObject>();
		}
		return new Vector<EObject>(domain);
	}
	
	/**
	 * add a number of null-matches to the given NAC-varSet
	 * 
	 * @param vars		the list of (NAC) variables
	 * @param types		the list of types
	 * @param count		the number of null-matches to insert
	 */
	protected void addNullMatches(List<Variable> vars, int count) {
		for (int i= 0; i < count; i++) {
			vars.add(null);
		}
	}
	
	
	
	// HELPER METHODS FOR MANAGING VARIABLE QUERIES
	

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
	 * add a new variable query for an attribute value.
	 * 
	 * @param varSet	the variable set
	 * @param sourceNr	the index of the source element
	 * @param targetNr	the index of the target element
	 * @param srcAtt	attribute of source element
	 * @param trgAtt	attribute of target element
	 */
	protected void addVariableQuery(List<Variable> varSet, int sourceNr, int targetNr, EAttribute srcAtt, EAttribute trgAtt) {
		Variable source = varSet.get(sourceNr);
		Variable target = varSet.get(targetNr);
		VariableQuery vq = new VariableQuery(source, target, srcAtt, trgAtt);
		target.addQuery(vq);
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
		InjectivityQuery iq = new InjectivityQuery(creator, target);
		creator.addQuery(iq);
	}
		
}