package de.dailab.vsdt.trafo.base;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * This class provides a simple backtracking search algorithm for finding a 
 * match for the given LHS and NACs. First, a match for the LHS is searched for.
 * Then, given the variable instantiation provided by the match, a match for the
 * NACs is searched. If no NAC match can be found, the match is valid and will
 * be returned. Both algorithms work very similar, as a depth-first backtracking
 * search, returning the first-possible match for LHS and NACs, i.e. it is not
 * possible to use this class to find all matches for the LHS and NAC!
 */
public class Matcher {
	
	/** Current set of evaluated LHS variables */
	private final List<Variable> lhsVars;
	
	/** All sets of evaluated NAC variables */
	private final List<List<Variable>> nacVars;
	
	/**
	 * Default constructor.
	 * 
	 * @param lhsVars	set of variables for LHS
	 * @param nacVars	sets of variables for all NACs
	 */
	public Matcher(List<Variable> lhsVars, List<List<Variable>> nacVars){
		this.lhsVars = lhsVars;
		this.nacVars = nacVars;
	}

	/**
	 * Start backtracking algorithm. The search will return the first match for
	 * the given LHS and NACs instantiating all the LHS variables according to
	 * the LHS without violating the NACs
	 * 
	 * @return	Match or null
	 */
	public List<EObject> findMatches() {
		return findMatches(0);
	}
	
	
	// EVALUATION OF LHS
	
	/**
	 * Find a match for LHS variables by backtracking. The Variables are
	 * instantiated one after another
	 */
	private List<EObject> findMatches(int index) {
		
		// all LHS variables instantiated? 
		if (index >= lhsVars.size()) {
			// create potential match
			List<EObject> match = new ArrayList<EObject>(lhsVars.size());
			for (Variable variable : lhsVars) {
				match.add(variable.getInstanceValue());
			}
			// check whether the match is compatible with NACs
			return isCompatibleWithNACs(match) ? match : null;
		}

		// try next possible instantiation for this variable 
		Variable var = lhsVars.get(index);
		while (var.nextInstance()) {
			// find matches for next variables in LHS
			List<EObject> match = findMatches(index + 1);
			// match found for this instantiation?
			if (match != null) {
				return match;
			}
		}
		
		return null;
	}

	
	// EVALUATION OF NACS
	
	/**
	 * Try to find a match for one of the NACs instantiating the variables
	 * according to the match.
	 *
	 * @param match		a match for the LHS variables 
	 * @return			whether the variable match is compatible with the NACs
	 */
	private boolean isCompatibleWithNACs(List<EObject> match) {
		// for all the NACs in the list...
		for (List<Variable> nac : nacVars) {

			// set the NAC variables' domains according to the match
			for (int i=0; i < match.size() && i < nac.size(); i++) {
				if (nac.get(i) != null) {
					List<EObject> domain = nac.get(i).getDomain();
					domain.clear();
					domain.add(match.get(i));
				}
			}

			// find NAC match
			boolean matchesNac= findNacMatch(nac, 0);
			
			// reset variables
			for (Variable var : nac) {
				if (var != null) {
					var.deinstanciate();
				}
			}
			
			// return false if a match can be found for any of the NACs
			if (matchesNac) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Try to find a match for the NAC variables using backtracking. Matching
	 * works mostly like the one for the LHS variables.
	 * 
	 * @return true, if the NAC did apply
	 */
	private boolean findNacMatch(List<Variable> nac, int index) {
		
		// all NAC variables instantiated -> match found!
		if (index >= nac.size()) {
			return true;
		}
		
		Variable var = nac.get(index);
		// variable not relevant for the NAC; continue with next variable
		if (var == null) {
			return findNacMatch(nac, index + 1);
		}
		// try next possible instantiation for this variable 
		while (var.nextInstance()) {
			// find matches for next variables in NAC
			if (findNacMatch(nac, index + 1)) {
				// match found for this instantiation
				return true;
			}
		}
		return false;
	}
	
}
