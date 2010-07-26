package de.dailab.vsdt.trafo.base.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

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
	
	
	/**
	 * Associate objects inside the instance with their types. This method
	 * traverses the containment structure beginning with the root element.
	 * For each element's class and it's super classes a new entry in the
	 * typeToDomain map is created and the element is inserted in the list.
	 * Finally the method is called for the element's children.
	 * 
	 * @param root	topmost element of the instance (sub-)tree
	 * @return		map associating EClasses with Lists of EObjects
	 */
	public static Map<EClass,List<EObject>> createTypeMap(EObject eObject) {
		Map<EClass,List<EObject>> typeToDomain = new HashMap<EClass,List<EObject>>();
		EObject root = Util.getRoot(eObject);
		fillTypeMap(typeToDomain, root);
		return typeToDomain;
	}
		
	private static void fillTypeMap(Map<EClass,List<EObject>> typeToDomain, EObject root) {
		List<EObject> vec = null;
		
		// fill types vector with element's class and all super types
		List<EClass> types = new Vector<EClass>();
		types.add(root.eClass());
		types.addAll(root.eClass().getEAllSuperTypes());
		
		for (EClass type : types) {
			if (typeToDomain.get(type) == null) {
				//initialize with empty vector
				vec = new Vector<EObject>();
				typeToDomain.put(type, vec);
			} else {
				vec = typeToDomain.get(type);
			}
			//put element in domain vector
			vec.add(root);
		}
		//recursive call for child elements
		for (EObject child : root.eContents()) { 
			fillTypeMap(typeToDomain, child);
		}
	}
	
	
}
