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

	/**
	 * Start backtracking algorithm. The search will return the first match for
	 * the given LHS and NACs instantiating all the LHS variables according to
	 * the LHS without violating the NACs. The LHS and NAC variables have to be
	 * initialized correctly with a domain.
	 * 
	 * @param lhs	set of variables for LHS
	 * @param nacs	sets of variables for all NACs
	 * @return		Match or null
	 */
	public static List<EObject> findMatches(List<Variable> lhs, List<List<Variable>> nacs) {
		return findMatches(lhs, nacs, 0);
	}
	
	
	// EVALUATION OF LHS
	
	/**
	 * Find a match for LHS variables by backtracking. The Variables are
	 * instantiated one after another. When initially calling this method, index
	 * should be 0 (zero).
	 * 
	 * @param lhs		set of variables for LHS
	 * @param nacs		sets of variables for all NACs
	 * @param index		index of variable to match
	 * @return			Match or null
	 */
	private static List<EObject> findMatches(List<Variable> lhs, List<List<Variable>> nacs, int index) {
		
		// all LHS variables instantiated? 
		if (index >= lhs.size()) {
			// create potential match
			List<EObject> match = new ArrayList<EObject>(lhs.size());
			for (Variable variable : lhs) {
				match.add(variable.getInstanceValue());
			}
			// check whether the match is compatible with NACs
			return isCompatibleWithNACs(match, nacs) ? match : null;
		}

		// try next possible instantiation for this variable 
		Variable var = lhs.get(index);
		while (var.nextInstance()) {
			// find matches for next variables in LHS
			List<EObject> match = findMatches(lhs, nacs, index + 1);
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
	 * @param nacs		sets of variables for all NACs 
	 * @return			whether the variable match is compatible with the NACs
	 */
	private static boolean isCompatibleWithNACs(List<EObject> match, List<List<Variable>> nacs) {
		// for all the NACs in the list...
		for (List<Variable> nac : nacs) {

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
	 * @param nac	NAC variables, with domain reduced to LHS match
	 * @return		true, if the NAC did apply
	 */
	private static boolean findNacMatch(List<Variable> nac, int index) {
		
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
