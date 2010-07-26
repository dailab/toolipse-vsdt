package de.dailab.vsdt.trafo.base;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * TODO javadoc
 */
public class Matchfinder {
	
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
	public Matchfinder(List<Variable> lhsVars, List<List<Variable>> nacVars){
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
			// check NACs for this match, return match if OK, else null
			return evalAllNacsForMatch(match);
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
	 * @return			null if a match is found for any of the NACs, otherwise the match
	 */
	private List<EObject> evalAllNacsForMatch(List<EObject> match) {
		// for all the NACs in the list...
		for (List<Variable> nac : nacVars) {
			// instantiate the NAC variables according to the match
			for (int i=0; i < match.size() && i < nac.size(); i++) {
				if (nac.get(i) != null) {
					nac.get(i).setDomain(match.get(i));
				}
			}
			
			// return null, if a match can be found for the remaining NAC variables
			if (findNacMatch(nac, 0)) {
				return null;
			}
		}
		return match;
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
			// reset variables
			for (Variable var : nac) {
				if (var != null) {
					var.deinstanciate();
					var.setDynamicDomain(null);
				}
			}
			return true;
		}
		
		Variable var = nac.get(index);
		if (var == null) {
			// variable not relevant for the NAC; continue with next variable
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
