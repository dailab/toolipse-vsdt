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
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * Because EcoreUtil.copyAll just does not do it... this class is probably not as
 * complete and as EcoreUtil and does not cover every case, but it should be enough
 * for the VSDT and it fixes some problems with EcoreUtil.copyAll:
 * 
 * - copies connections between flow objects in copied pool
 * - correctly sets reference to non-copied elements
 *
 * @author kuester
 */
public class VsdtCopier {

	/** holding mapping from original to copied elements */
	private final Map<EObject, EObject> mapping = new HashMap<>();
	
	/**
	 * Deep-copy the selected elements. Note: More than just the selected
	 * elements can be copied, e.g. also any element contained in those,
	 * or connections between copied elements.
	 *
	 * @param originals		list of selected elements to be copied
	 * @return				list of copies of those elements
	 */
	public List<EObject> deepCopyWithReferences(List<EObject> originals) {
		
		// create copy of elements and all contained elements
		List<EObject> results = new ArrayList<>(originals.size());
		for (EObject obj : originals) {
			EObject copy = copy(obj);
			results.add(copy);
		}
		
		// copy connections where source and target have been copied
		if (! originals.isEmpty()) {
			BusinessProcessDiagram bpd = VsdtHelper.getRootBPD(originals.get(0));
			for (ConnectingObject conn : bpd.getConnections()) {
				if (! mapping.containsKey(conn)
						&& mapping.containsKey(VsdtHelper.getSource(conn))
						&& mapping.containsKey(VsdtHelper.getTarget(conn))) {
					copy(conn);
				}
			}
		}
		
		// restore references in copied elements
		for (EObject original: mapping.keySet()) {
			copyReferences(original, mapping.get(original));
		}
		
		return results;
	}
	
	/**
	 * Copy attributes and recursively copy contained objects, but don't set references.
	 * References are set in another method.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EObject copy(EObject obj) {
		if (obj != null) {
			// first, check whether object has already been copied
			// this can be the case if both container and contained are selected
			if (mapping.containsKey(obj)) {
				return mapping.get(obj);
			}
			
			// create new instance and add it to the mapping
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

			// generate new ID (do this after setting the attributes)
			if (copy instanceof IdObject) {
				VsdtHelper.generateNewID((IdObject) copy);
			}

			return copy;
		}
		return null;
	}
	
	/**
	 * Set references in copied object according to original object. If the referred
	 * object also has been copied, use the copy, otherwise use the original, unless
	 * the reference has an opposite with cardinality 1, and setting the reference
	 * to the original would un-set its original target.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void copyReferences(EObject orig, EObject copy) {
		EClass clazz = orig.eClass();
		
		for (EReference ref : clazz.getEAllReferences()) {
			if (ref.isMany()) {
				// iterate objects and set reference according to original
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
				// same as above, just without the loop...
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
