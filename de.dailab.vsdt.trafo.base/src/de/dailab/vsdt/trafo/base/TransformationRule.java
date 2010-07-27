package de.dailab.vsdt.trafo.base;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.dailab.vsdt.trafo.base.constraints.AttributeConstraint;
import de.dailab.vsdt.trafo.base.constraints.InjectivityConstraint;
import de.dailab.vsdt.trafo.base.constraints.ReferenceConstraint;
import de.dailab.vsdt.trafo.base.util.Util;

/**
 * Class for a Transformation Rule. A Rule has a Left Hand Side (LHS), being the
 * rule's pattern, or head, and optionally some Negative Application Conditions
 * (NACs). The rule is executed if a match can be found for the LHS and for none
 * of the NACs. Variables in the LHS and NACs can be connected by Constraints.
 */
public abstract class TransformationRule {
	
	/**HashMap for collecting instance objects of model types*/
	protected Map<EClass, List<EObject>> instancesMap;
	
	/**variables for LHS nodes*/
	protected List<Variable> lhsVariables;
	
	/**variables for NAC nodes*/
	protected List<List<Variable>> nacVariables;
	
	/**
	 * Apply this rule. First a wrapper is instantiated and initialized. Then a
	 * match has to be found. If there is a match, the rule is applied according
	 * to the match.
	 * 
	 * @param instancesMap	map of types to instances
	 * @return				rule applied?
	 */
	public final boolean apply(Map<EClass, List<EObject>> instancesMap) {

		// initialize rule
		this.instancesMap = instancesMap;
		this.lhsVariables = new Vector<Variable>();
		this.nacVariables = new Vector<List<Variable>>();
		
		initLHSVariables();
		initNACVariables();
		
		// find match for LHS and NACs
		List<EObject> match = Matcher.findMatches(lhsVariables, nacVariables);

		// if match found, execute the rule
		if (match != null) {
			excecute(match);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Use this method to initialize the LHS variables stored in the field
	 * {@link #lhsVariables}.
	 * - use {@link #addVariable(List, EClass)} to add typed variables
	 * - use {@link Variable#getDomain()} to reduce the variables domain, e.g.
	 *   removing instance values which have illegal attribute values
	 * - use add...Constraint methods to add constraints linking the variables
	 *   to other variables
	 */
	protected abstract void initLHSVariables();
	
	/**
	 * Use this method to initialize the NACs' variables stored in the field
	 * {@link #nacVariables}, just like in {@link #initLHSVariables()}. Before
	 * their own variables, all NACs have to include all LHS variables, in the
	 * same order as in the LHS. Thus, the first NAC variable has the index
	 * #lhsVariables.size(). However, LHS variables that are of no relevance
	 * to the NAC can be substituted by a null-variable using the method
	 * {@link #addNullVariable(List, int)}.
	 */
	protected abstract void initNACVariables();

	/**
	 * Execute this rule. Match is a list of EObjects with the instantiation
	 * values of the variables in the order in which the variables were added to
	 * the LHS in initLHSVariables 
	 */
	protected abstract void excecute(List<EObject> match);
	
	
	
	// HELPER METHODS FOR MANAGING VARIABLES
	
	/**
	 * Use this for adding variables of a given type to one of the variable sets.
	 * 
	 * @param vars		list of variables
	 * @param type		the type of the variable to create
	 */
	protected void addVariable(List<Variable> vars, EClass type) {
		List<EObject> domain = instancesMap.get(type);
		if (domain == null) {
			domain= new Vector<EObject>();
		}
		vars.add(new Variable(type, domain));
	}
	
	/**
	 * Add multiple variables of one type at once.
	 * 
	 * @param vars		list of variables
	 * @param type		the type of the variables to create
	 * @param count		number of variables of given type to create
	 */
	protected void addVariable(List<Variable> vars, EClass type, int count) {
		for (int i = 0; i < count; i++) {
			addVariable(vars, type);
		}
	}
	
	/**
	 * Add a number of dummy variables to the given NAC varSet. This is useful
	 * if there are variables in the LHS that are not needed in the NAC.
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
	 * Create a ReferenceConstraint and add it to the variable.
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
	 * Create an AttributeConstraint add it to the Variable.
	 * 
	 * @param varSet	the variable set
	 * @param selfNr	the index of the source element
	 * @param otherNr	the index of the target element
	 * @param selfAtt	attribute of source element
	 * @param otherAtt	attribute of target element
	 */
	protected final void addAttributeConstraint(List<Variable> varSet, int selfNr, int otherNr, EAttribute selfAtt, EAttribute otherAtt) {
		Variable self = varSet.get(selfNr);
		Variable other = varSet.get(otherNr);
		self.addConstraint(new AttributeConstraint(self, other, selfAtt, otherAtt));
	}
	
	/**
	 * Create an InjectivityConstraint and add it to the variable.
	 * 
	 * @param vars		variable list
	 * @param selfNr 	index of first variable in list
	 * @param otherNr	index of second variable in list
	 */
	protected final void addInjectivityConstraint(List<Variable> varSet, int selfNr, int otherNr) {
		Variable self = varSet.get(selfNr);
		Variable other = varSet.get(otherNr);
		self.addConstraint(new InjectivityConstraint(self, other));
	}

	/**
	 * Create InjectivityConstraints for _all_ variables in the given list that
	 * can have shared instances. As result two variables can not have the same 
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
