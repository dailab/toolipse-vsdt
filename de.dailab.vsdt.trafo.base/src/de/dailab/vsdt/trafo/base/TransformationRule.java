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
 * TODO javadoc
 */
public abstract class TransformationRule {
	
	/**HashMap for collecting instance objects of model types*/
	protected Map<EClass, List<EObject>> instancesMap;
	
	/**variables for LHS nodes*/
	protected List<Variable> lhsVariables;
	
	/**variables for NAC nodes*/
	protected List<List<Variable>> nacVariables;
	
	/**
	 * Executes this rule. First a wrapper is instantiated and initialized.
	 * Then a match has to be found. If there is a match, the rule is applied
	 * according to the match.
	 * 
	 * @param instancesMap		map of types to instances
	 * @return	rule applied?
	 */
	public final boolean execute(Map<EClass, List<EObject>> instancesMap) {

		// initialize rule
		this.instancesMap = instancesMap;
		this.lhsVariables = new Vector<Variable>();
		this.nacVariables = new Vector<List<Variable>>();
		
		initLHSVariables();
		initNACVariables();
		
		// find match for LHS and NACs
		Matcher matcher = new Matcher(lhsVariables, nacVariables);
		List<EObject> match = matcher.findMatches();

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

	
	
	// HELPER METHODS
	
	/**
	 * to be used in initLHSvariables and initNACVariables
	 * 
	 * @param vars		list of variables
	 * @param type		the type to create
	 */
	protected void addVariable(List<Variable> vars, EClass type) {
		List<EObject> domain = instancesMap.get(type);
		if (domain == null) {
			domain= new Vector<EObject>();
		}
		vars.add(new Variable(type, domain));
	}
	
	protected void addVariable(List<Variable> vars, EClass type, int multiplicity) {
		for (int i = 0; i < multiplicity; i++) {
			addVariable(vars, type);
		}
	}
	
	/**
	 * Create InjectivityQueries for _all_ variables in the given list that can
	 * have shared instances. As result two variables can not have the same 
	 * instance.
	 * 
	 * @param vars	list of variables
	 */ 
	protected final void createInjectivityQueries(List<Variable> vars) {
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
	 * returns the list of all instances for a give eClass
	 * 
	 * @param type	the eClass of interest
	 * @return		list of all instances
	 */
//	protected final List<EObject> getDomainForType(EClass type) {
//		List<EObject> domain = instancesMap.get(type);
//		if (domain == null) {
//			return new Vector<EObject>();
//		}
//		return new Vector<EObject>(domain);
//	}
	
	/**
	 * add a number of null-matches to the given NAC-varSet. This is useful if
	 * there are variables in the LHS that are not needed in the NAC.
	 * 
	 * @param vars		the list of (NAC) variables
	 * @param types		the list of types
	 * @param count		the number of null-matches to insert
	 */
	protected final void addNullMatches(List<Variable> vars, int count) {
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
	protected final void addTargetQuery(List<Variable> varSet, int sourceNr, int targetNr, EStructuralFeature ref) {
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
	protected final void addSourceQuery(List<Variable> varSet, int sourceNr, int targetNr, EStructuralFeature ref) {
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
	protected final void addVariableQuery(List<Variable> varSet, int sourceNr, int targetNr, EAttribute srcAtt, EAttribute trgAtt) {
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
	protected final void addInjectivityQuery(List<Variable> varSet, int sourceNr, int targetNr) {
		Variable source = varSet.get(sourceNr);
		Variable target = varSet.get(targetNr);
		InjectivityQuery iq = new InjectivityQuery(source, target);
		source.addQuery(iq);
	}
	
}
