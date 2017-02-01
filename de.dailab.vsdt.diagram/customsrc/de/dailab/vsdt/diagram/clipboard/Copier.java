package de.dailab.vsdt.diagram.clipboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * Because EcoreUtil.copyAll just does not do it...
 * 
 * - when pool is copied, connections connecting the contained flow objects are not copied
 * - when flow object is copied, reference to process-properties is lost in assignments
 *
 * @author kuester
 */
public class Copier {

	private final Map<EObject, EObject> mapping = new HashMap<>();
	
	public List<EObject> deepCopyWithReferences(List<EObject> originals) {
		
		// create copy of elements and all contained elements
		List<EObject> results = new ArrayList<>(originals.size());
		for (EObject obj : originals) {
			EObject copy = copy(obj);
			results.add(copy);
		}
		
		// TODO add connections where source and target is in mapping
		
		BusinessProcessDiagram bpd = VsdtHelper.getRootBPD(originals.get(0));
		for (ConnectingObject conn : bpd.getConnections()) {
			if (! mapping.containsKey(conn)
					&& mapping.containsKey(VsdtHelper.getSource(conn)) 
					&& mapping.containsKey(VsdtHelper.getTarget(conn))) {
				copy(conn);
			}
		}
		
		
		// restore references
		for (EObject original: mapping.keySet()) {
			copyReferences(original, mapping.get(original));
		}
		
		return results;
	}
	
	/**
	 * Copy attributes and recursively copy contained objects, but don't change references
	 */
	private EObject copy(EObject obj) {
		if (obj != null) {
			EClass clazz = obj.eClass();
			EObject copy = clazz.getEPackage().getEFactoryInstance().create(clazz);
			mapping.put(obj, copy);
			
			// copy attributes (assuming non-mutable values)
			for (EAttribute attribute : clazz.getEAllAttributes()) {
				if (attribute.isMany()) {
					((List) copy.eGet(attribute)).addAll((List) obj.eGet(attribute));
				} else {
					copy.eSet(attribute, obj.eGet(attribute));
				}
			}
			
			// deep-copy containment references
			for (EReference ref : clazz.getEAllContainments()) {
				if (ref.isMany()) {
					List<EObject> copies = new ArrayList();
					for (EObject orig : (List<EObject>) obj.eGet(ref)) {
						copies.add(copy(orig));
					}
					((List) copy.eGet(ref)).addAll(copies);
				} else {
					copy.eSet(ref, copy((EObject) obj.eGet(ref)));
				}
			}
			return copy;
		}
		return null;
	}
	
	/**
	 * if target of reference has been copied, use the copy, otherwise use original
	 */
	private void copyReferences(EObject orig, EObject copy) {
		EClass clazz = orig.eClass();
		
		for (EReference ref : clazz.getEAllReferences()) {
			if (ref.isMany()) {
				
				List<EObject> objects = new ArrayList();
				for (EObject obj : (List<EObject>) orig.eGet(ref)) {
					if (mapping.containsKey(obj)) {
						// target has been copied -> use copy
						objects.add(mapping.get(obj));
					} else if (ref.getEOpposite() == null || ref.getEOpposite().isMany()) {
						// target has not been copied -> use original, if this does not change it
						objects.add(obj);
					}
				}
				((List) copy.eGet(ref)).addAll(objects);

			} else {
				EObject obj = (EObject) orig.eGet(ref);
				if (mapping.containsKey(obj)) {
					// target has been copied -> use copy
					copy.eSet(ref, mapping.get(obj));
				} else if (ref.getEOpposite() == null || ref.getEOpposite().isMany()) {
					// target has not been copied -> use original, if this does not change it
					copy.eSet(ref, obj);
				}
			}
		}
	}

}
