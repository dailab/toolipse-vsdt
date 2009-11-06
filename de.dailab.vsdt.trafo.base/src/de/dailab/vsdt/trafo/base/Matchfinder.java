package de.dailab.vsdt.trafo.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * Class : Matchfinder <br/>
 * Package : rules <br/>
 * Project : RuleProject <br/>
 * Created On : 10.01.2006 <br/>
 * Description : Main class of CSP algorithm for match finding.
 * 
 * modified by tobias küster
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public class Matchfinder {
	
	/**current set of evaluated LHS variables*/
	private List<Variable> lhsVars = new ArrayList<Variable>();
	
	/**all sets of evaluated NAC variables*/
	private List<List<Variable>> nacVars = new ArrayList<List<Variable>>();
	
	/**current match*/
	private List<EObject> match= null;
	
	
	/**
	 * Default constructor.
	 * 
	 * @param lhsVars	set of evaluated LHS variables
	 * @param nacVars	set of all NAC variables
	 */
	public Matchfinder(List<Variable> lhsVars, List<List<Variable>> nacVars){
		this.lhsVars = lhsVars;
		this.nacVars = nacVars;
	}
		
	
	// EVALUATION OF LHS
	
	/**
	 * start backtracking algorithm
	 */
	public boolean findMatches() {
		return findMatches(0);
	}
	
	
	/**
	 * Find a match for LHS by a (restricted) depth-first search.
	 * Variables are instantiated in their order.
	 */
	private boolean findMatches(int index) {
		
		if (index >= lhsVars.size()) {
			//all LHS vars instantiated: copy instance values to matches-list
			match = new ArrayList<EObject>();
			for (Iterator<Variable> iter = lhsVars.iterator(); iter.hasNext();) {
				match.add(iter.next().getInstanceValue());
			}
			
			//check NACs for this match, return if match is OK
			return evalAllNacsForMatch();
		}
		
		Variable var = lhsVars.get(index);
		
		boolean result = var.nextInstance();
		while (result) {
			//try next value			
			if (findMatches(index+1)) {
				//match for current variable found, try next variable
				return true;
			}
			result= var.nextInstance();
		};
		
		return false;
	}

	
	// EVALUATION OF NACS
	
	/**
	 * evaluate all the NACs for the match found at this point.
	 */
	private boolean evalAllNacsForMatch() {
		for (Iterator<List<Variable>> iter = nacVars.iterator(); iter.hasNext();) {
			List<Variable> nac= iter.next();
			setNacVariables(nac, match);
			if (findNacMatch(nac,0)) {
				match= null;
				return false;
			}
		}
		return true;
	}
	
	
	private void setNacVariables(List<Variable> nac, List<EObject> match) {
		for (int i=0; i < match.size() && i < nac.size(); i++) {
			if (nac.get(i) != null) {
				nac.get(i).setDomain(match.get(i));
			}
		}
	}
	
	
	/**
	 * Find a match for the current NAC by a (restricted) depth-first search.
	 * mostly the same as for LHS-variables
	 * 
	 * @return true, if the NAC did apply
	 */
	
	private boolean findNacMatch(List<Variable> nac, int index) {
		
		if (index >= nac.size()) {
			//NAC match found
			for (int i=0; i<nac.size(); i++) {
				//deinstantiate variables
				Variable current = nac.get(i);
				if (current!=null) {
					current.deinstanciate();
					current.setDynamicDomain(null);
				}
			}
			return true;
		}
		
		Variable var = nac.get(index);
		if (var == null) {
			//var not relevant for the NAC; continue with next variable
			return findNacMatch(nac,index+1);
		}
		
		boolean result = var.nextInstance();
		while (result) {
			//try next value			
			if (findNacMatch(nac,index+1)) {
				//match for current variable found, try next variable
				return true;
			}
			result= var.nextInstance();
		};
		
		return false;
	}
	

	// SOLUTIONS
	
	/**
	 * Returns the match
	 *
	 * @return	solution
	 */
	public List<EObject> getSolution(){
		return match;
	}

}
