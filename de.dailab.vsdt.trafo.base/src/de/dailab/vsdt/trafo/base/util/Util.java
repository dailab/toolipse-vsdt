package de.dailab.vsdt.trafo.base.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * Utility class providing some methods needed for the Pattern Matching and
 * Graph Transformation stuff.
 * 
 * @author kuester
 */
public class Util {

	/**
	 * Returns topmost element of an EMF instance.
	 * 
	 * @param currentObject	object inside the EMF tree 
	 * @return				topmost element in EMF tree
	 */
	public static EObject getRoot(EObject currentObject) {
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
	

	/**
	 * Check if type1 is subtype of type2 or vice versa.
	 * 
	 * @param type1	first checked type
	 * @param type2	second checked type
	 * @return		if there is a subtype relation between types
	 */
	public static boolean typesLinked(EClass type1, EClass type2){
		if(type1==null || type2==null){
			return false;
		}
		if(type1.equals(type2)){
			return true;
		}
		if(type1.getEAllSuperTypes().contains(type2)){
			return true;
		}
		if(type2.getEAllSuperTypes().contains(type1)){
			return true;
		}
		return false;
	}
	
}
