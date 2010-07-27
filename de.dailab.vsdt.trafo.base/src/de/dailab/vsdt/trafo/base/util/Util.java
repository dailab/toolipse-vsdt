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
 */
public class Util {

	/**
	 * Returns topmost element of an EMF instance graph.
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
	 * @param eObject	deleted EObject
	 */
	public static void deleteFromModel(EObject eObject) {
		if (eObject != null && eObject.eContainer() != null) {
			EObject container = eObject.eContainer();
			EReference contains = (EReference)eObject.eContainingFeature();
			if(contains.isMany()){
				((EList) container.eGet(contains)).remove(eObject);
			}
			else{
				container.eUnset(contains);
			}
		}
	}
	

	/**
	 * Check if type1 is sub-type of type2 or vice versa.
	 * 
	 * @param type1		first checked type
	 * @param type2		second checked type
	 * @return			if there is a sub-type relation between types
	 */
	public static boolean typesLinked(EClass type1, EClass type2){
		return type1 != null && type2 != null &&
				(type1.equals(type2) || 
				 type1.isSuperTypeOf(type2) || 
				 type2.isSuperTypeOf(type1));
	}
	
	
	/**
	 * Associate objects inside the instance with their types. This method
	 * traverses the containment structure beginning with the root element.
	 * For each element's class and it's super classes a new entry in the
	 * typeToDomain map is created and the element is inserted in the list.
	 * Finally the method is called for the element's children.
	 * 
	 * @param root		topmost element of the instance (sub-)tree
	 * @return			map associating EClasses with Lists of EObjects
	 */
	public static Map<EClass,List<EObject>> createInstancesMap(EObject eObject) {
		Map<EClass, List<EObject>> instancesMap = new HashMap<EClass, List<EObject>>();
		EObject root = Util.getRoot(eObject);
		fillInstancesMap(instancesMap, root);
		return instancesMap;
	}
		
	/**
	 * Fill instances map by associating the given object to its class and all
	 * of its super classes and recursively calling the algorithm for all 
	 * objects contained in this object.
	 * 
	 * @param instancesMap	existing instance map, to be modified
	 * @param object		some object not yet in the map
	 */
	private static void fillInstancesMap(Map<EClass,List<EObject>> instancesMap, EObject object) {
		List<EObject> vec = null;
		
		// fill types vector with element's class and all super types
		List<EClass> types = new Vector<EClass>();
		types.add(object.eClass());
		types.addAll(object.eClass().getEAllSuperTypes());
		
		for (EClass type : types) {
			if (instancesMap.get(type) == null) {
				//initialize with empty vector
				vec = new Vector<EObject>();
				instancesMap.put(type, vec);
			} else {
				vec = instancesMap.get(type);
			}
			//put element in domain vector
			vec.add(object);
		}
		//recursive call for child elements
		for (EObject child : object.eContents()) { 
			fillInstancesMap(instancesMap, child);
		}
	}
	
}
