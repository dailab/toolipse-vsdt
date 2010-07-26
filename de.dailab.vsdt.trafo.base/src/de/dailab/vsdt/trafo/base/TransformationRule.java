package de.dailab.vsdt.trafo.base;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.dailab.vsdt.trafo.base.queries.InjectivityConstraint;
import de.dailab.vsdt.trafo.base.queries.ReferenceConstraint;
import de.dailab.vsdt.trafo.base.queries.VariableConstraint;
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
	
	protected void addVariable(List<Variable> vars, EClass type, int count) {
		for (int i = 0; i < count; i++) {
			addVariable(vars, type);
		}
	}
	
	/**
	 * add a number of null-matches to the given NAC-varSet. This is useful if
	 * there are variables in the LHS that are not needed in the NAC.
	 * 
	 * @param vars		the list of (NAC) variables
	 * @param types		the list of types
	 * @param count		the number of null-matches to insert
	 */
	protected final void addNullVariable(List<Variable> vars, int count) {
		for (int i= 0; i < count; i++) {
			vars.add(null);
		}
	}
	
	
	// HELPER METHODS FOR MANAGING VARIABLE CONSTRAINTS
	

	/**
	 * add a new target query for a reference.
	 * use this query, if the source variable has been declared first
	 * 
	 * @param varSet	the variable set
	 * @param selfNr	the index of the source element
	 * @param otherNr	the index of the target element
	 * @param ref		the reference
	 */
	protected final void addReferenceConstraint(List<Variable> varSet, int selfNr, int otherNr, EReference ref) {
		Variable self = varSet.get(selfNr);
		Variable other = varSet.get(otherNr);
		self.addConstraint(new ReferenceConstraint(self, other, ref));
	}
	
	/**
	 * add a new variable query for an attribute value.
	 * 
	 * @param varSet	the variable set
	 * @param selfNr	the index of the source element
	 * @param otherNr	the index of the target element
	 * @param selfAtt	attribute of source element
	 * @param otherAtt	attribute of target element
	 */
	protected final void addVariableConstraint(List<Variable> varSet, int selfNr, int otherNr, EAttribute selfAtt, EAttribute otherAtt) {
		Variable self = varSet.get(selfNr);
		Variable other = varSet.get(otherNr);
		self.addConstraint(new VariableConstraint(self, other, selfAtt, otherAtt));
	}
	
	/**
	 * create a single injectivity query for the given variables
	 * note that the first variable has to be instantiated before the second!
	 * 
	 * @param vars		variable list
	 * @param creator	index of first variable in list
	 * @param other	index of second variable in list
	 */
	protected final void addInjectivityConstraint(List<Variable> varSet, int selfNr, int otherNr) {
		Variable self = varSet.get(selfNr);
		Variable other = varSet.get(otherNr);
		self.addConstraint(new InjectivityConstraint(self, other));
	}

	/**
	 * Create InjectivityQueries for _all_ variables in the given list that can
	 * have shared instances. As result two variables can not have the same 
	 * instance.
	 * 
	 * @param vars	list of variables
	 */ 
	protected final void createInjectivityConstraints(List<Variable> vars) {
		for(int i = 0; i < vars.size(); i++) {
			Variable var1= vars.get(i);
			for (int j = i + 1; j < vars.size(); j++) {
				Variable var2= vars.get(j);
				if (Util.typesLinked(var1.getType(), var2.getType())) {
					var1.addConstraint(new InjectivityConstraint(var1, var2));
				}
			}
		}
	}
	
}
