package de.dailab.vsdt.trafo.base;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * AbstractRule
 * 
 * This class contains common functionality 
 * and is a parent class for all generated rule classes. <br/>
 * 
 * edited by holger endert and tobias küster
 * 
 * @author Enrico Biermann <br>
 * @author Guenter Kuhns <br>
 */
public abstract class AbstractRule {
		
	/**the root object*/
	private EObject root = null;

	/**the rule's wrapper*/
	private AbstractWrapper wrapper = null;
	
	/**the rules name (for debugging)*/
	private String name= "Unnamed Rule";
	
	/**
	 * default constructor
	 * 
	 * @param root	the root object
	 * @param name	the rule's name
	 */
	public AbstractRule(EObject root, String name) {
		this.root= root;
		this.name= name==null ? getClass().getSimpleName() : name;
	}
	
	/**
	 * @return	the rule's name
	 */
	protected String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected EObject getRoot() {
		return root;
	}
	
	protected void setRoot(EObject root) {
		this.root = root;
	}

	/**
	 * Sets a reference to an EObject inside the instance which shall be changed by the rule application.
	 * @param instanceNode arbitrary node inside the instance
	 */
	public void setInstanceSymbol(EObject instanceNode){
		this.root = getRoot(instanceNode);
	}
	
	
	/**
	 * Executes this rule. First a wrapper is instantiated and initialized.
	 * then a match has to be found. if there is a match, the variables are instantiated
	 * according to the match and the rule is applied.
	 * 
	 * @return	rule applied?
	 */
	public boolean execute() {
		
		wrapper = getWrapper();
		wrapper.init(root);
		List<EObject> match = wrapper.getSolution();
		
		if (match == null){
			return false;
		} else {
			internalSetWeightedLHS(match);
			apply();
 			return true;
		}
	}
	
	
	/**
	 * apply this rule. transforms the LHS to the RHS.
	 */
	protected abstract void apply();
	
	
	/**
	 * this method has to be overwritten in the sub class and
	 * has to return a concrete wrapper for the concrete rule.
	 * 
	 * @return	the wrapper
	 */
	protected abstract AbstractWrapper getWrapper();
	
	
	/**
	 * instantiates the rule variables according to the match found by the wrapper
	 * 
	 * @param matches	the match
	 */
	protected abstract void setWeightedLHS(List<EObject> matches) throws Exception;
	
	private void internalSetWeightedLHS(List<EObject> matches) {
		if( matches==null ) {
			resetVars();
		} else {
			try {
				setWeightedLHS(matches);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * reset the rule after execution by assigning the variables with it's default values
	 * call's subclass's resetVars method to reset the rule-dependent variables
	 */
	public void reset() {
		this.wrapper= null;
		resetVars();
	}
	
	/**
	 * set all vars to null
	 */
	protected abstract void resetVars();
	
	
	/**
	 * Returns topmost element of an EMF instance.
	 * 
	 * @param currentObject	object inside the EMF tree 
	 * @return				topmost element in EMF tree
	 */
	protected EObject getRoot(EObject currentObject) {
		EObject parent = currentObject.eContainer();
		if (parent != null) {
			return getRoot(parent);
		} else {
			return currentObject;
		}	
	}
	
	
	/**
	 * Removes containing reference from parent to the deleted EObject.
	 *  
	 * @param eObject deleted EObject
	 */
	public static void deleteFromOwner(EObject eObject) {
		if (eObject != null && eObject.eContainer() != null) {
			EObject owner = eObject.eContainer();
			EReference contains = (EReference)eObject.eContainingFeature();
			if(contains.isMany()){
				((EList)owner.eGet(contains)).remove(eObject);
			}
			else{
				owner.eUnset(contains);
			}
		}
	}
	
}
