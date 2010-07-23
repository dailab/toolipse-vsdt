package de.dailab.vsdt.trafo.base;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.trafo.base.util.Util;

/**
 * AbstractRule
 * 
 * This class contains common functionality 
 * and is a parent class for all generated rule classes. <br/>
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public abstract class AbstractRule {
		
//	/**the rule's wrapper*/
//	private AbstractWrapper wrapper = null;
	
	/**
	 * Executes this rule. First a wrapper is instantiated and initialized.
	 * then a match has to be found. if there is a match, the variables are instantiated
	 * according to the match and the rule is applied.
	 * 
	 * @return	rule applied?
	 */
	public final boolean execute(EObject object) {
		
		EObject root = Util.getRoot(object);
		AbstractWrapper wrapper = getWrapper();
		wrapper.init(root);
		List<EObject> match = wrapper.getSolution();
		
		if (match == null){
//			reset();
//			resetVars();
			return false;
		} else {

//			try {
//				setWeightedLHS(match);
				apply(match);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
			
//			resetVars();
			return true;
		}
	}
	
	
	/**
	 * apply this rule. transforms the LHS to the RHS.
	 */
	protected abstract void apply(List<EObject> match);
	
	
	/**
	 * this method has to be overwritten in the sub class and
	 * has to return a concrete wrapper for the concrete rule.
	 * 
	 * @return	the wrapper
	 */
	protected abstract AbstractWrapper getWrapper();
	
	
//	/**
//	 * instantiates the rule variables according to the match found by the wrapper
//	 * 
//	 * @param matches	the match
//	 */
//	protected abstract void setWeightedLHS(List<EObject> matches);// throws Exception;
//	
	
//	/**
//	 * set all vars to null
//	 */
//	@Deprecated
//	protected abstract void resetVars();
	
	
}
