package de.dailab.vsdt.diagram.imprt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Used for importing one or more Diagram files into another. This is not to be
 * confused with import features such as VSDT's 'BPEL to BPMN' Import, as both 
 * source and target files are of the same type. Rather this is a compensation
 * for the lack of working copy & paste support.
 * 
 * The most basic (and most useless) feature is the import of pure model data,
 * which can equally be accomplished by copy-pasting between the XML files. More
 * useful is the import with layout, which will preserve the layout of the 
 * imported files. This can not be done as easily in XML, as there might be id-
 * clashes. Finally, it should also be possible to smartly merge two versions of
 * a diagram.
 * 
 * While this import is written primarily for merging two versions of the same
 * VSDT diagram, it can also be used for merging e.g. two AWE diagrams, or any
 * other GMF- or EMF-based model -- it must not even have a diagram layer at 
 * all. It works best if the two (or more) models are versions derived from a
 * common ancestor, by working on the objects' ID attributes, but by adapting 
 * the canMerge method it can be changed to merging e.g. objects with the same
 * name or certain combinations of other attributes, as well. 
 * 
 * @author kuester
 */
public class DiagramImporter {

	/** the list of files that are imported */ 
	private final List<Resource> sources;

	/** the target file the source files are imported into */
	private final Resource target;

	/** list of warnings that occurred during import */
	protected final List<String> warnings;

	/** list of errors that occurred during import */
	protected final List<String> errors;

	/** create backup of target file */
	private final boolean backup;

	/** preserve layout? */
	private final boolean layout;

	/** merge identical objects? */
	private final boolean merge;
	
	/** ID of diagram root, or null */
	private final String diagramRoot;

	/** map holding association from model elements to diagrams */
	private final Map<EObject, Diagram> diagramMap;

	/**
	 * Map of elements being merged, with key-value pairs like
	 *   element_from_source -> element_from_target,
	 * where element_from_target can be contained once for each source resource.
	 */
	private Map<EObject, EObject> mergedMap;

	
	/**
	 * Create new VsdtDiagramImporter. The 'to' Resource will be saved if the
	 * import is complete. If the respective parameter is set, a backup of the
	 * 'to' Resource will be created first, with suffix '.bak'.
	 * Warning: The 'from' Resources will most likely be altered in the process
	 * of importing (i.e. parts of their contents will be moved, not copied, to
	 * the 'to' Resource), so _do not_ save these Resources after importing! 
	 * 
	 * @param from			List of Resources to import from
	 * @param to			Resource to import into
	 * @param backup		create backup?
	 * @param layout		import layout? (for GMF resources only!)
	 * @param merge			merge identical objects?
	 * @param diagramRoot	identifier of diagram root, if there are sub-diagrams
	 */
	public DiagramImporter(List<Resource> from, Resource to, boolean backup, 
			boolean layout, boolean merge, String diagramRoot) {
		this.sources = from;
		this.target = to;
		this.backup = backup;
		this.layout = layout;
		this.merge = merge;
		this.warnings = new ArrayList<String>();
		this.errors = new ArrayList<String>();
		this.diagramRoot = diagramRoot;
		this.diagramMap = new HashMap<EObject, Diagram>();
		this.mergedMap = new HashMap<EObject, EObject>();
	}

	/**
	 * @return	list of warnings that occurred during import
	 */
	public List<String> getWarnings() {
		return warnings;
	}

	/**
	 * @return list of errors that occurred during import
	 */
	public List<String> getErrors() {
		return errors;
	}
	
	/**
	 * test whether the diagram is the diagram root
	 * 
	 * @param diagram	some diagram
	 * @return			diagram is root diagram?
	 */
	protected final boolean isDiagramRoot(Diagram diagram) {
		if (diagramRoot == null) {
			// no diagram root identifier defined -> there is only one diagram
			return true;
		} else {
			// diagram's type must be equal to diagramRoot
			return diagramRoot.equals(diagram.getType());
		}
	}

	/**
	 * Do actual import work.
	 */
	public final void doImport() {

		// get target model and diagram root 
		EObject targetModel= null;
		Diagram targetDiagramRoot= null;
		for (EObject content : target.getContents()) {
			if (content instanceof EObject && ! (content instanceof Diagram)) {
				targetModel= (EObject) content;
			}
			if (content instanceof Diagram) {
				Diagram diagram = (Diagram) content;
				diagramMap.put(diagram.getElement(), diagram);
				if (isDiagramRoot(diagram)) {
					targetDiagramRoot= diagram;
				}
			}
		}

		// create backup of target file?
		if (backup) {
			createBackup(target, ".bak");
		}
		
		// iterate over source files
		for (Resource resource : sources) {
			
			// iterate over file contents
			for (EObject content : new ArrayList<EObject>(resource.getContents()) ) {
				
				// import model data
				if (content instanceof EObject && ! (content instanceof Diagram)) {
					EObject other= (EObject) content;
					if (merge) {
						// merge data models
						merge(targetModel, other);
						updateReferences(targetModel);
					} else {
						// just throw stuff together
						for (EReference reference : other.eClass().getEAllContainments()) {
							if (reference.isMany()) {
								// lists are throws together
								List<EObject> selfElements = (List<EObject>) targetModel.eGet(reference);
								List<EObject> otherElements = (List<EObject>) other.eGet(reference);
								selfElements.addAll(otherElements);
							} else {
								// contained objects are simply overwritten
								EObject val= (EObject) other.eGet(reference);
								targetModel.eSet(reference, val);
							}
						}
					}
				} // end import model data
				
				// import layout data
				if (layout && (content instanceof Diagram) ) {
					Diagram diagram = (Diagram) content;
					if (merge) {
						// merge view models
						if (isDiagramRoot(diagram)) {
							// merge root diagrams
							merge(targetDiagramRoot, diagram);
							updateReferences(targetDiagramRoot);
						} else {
							if (mergedMap.containsKey(diagram.getElement())) {
								Diagram selfDiagram = diagramMap.get(mergedMap.get(diagram.getElement()));
								merge(selfDiagram, diagram);
								updateReferences(selfDiagram);
							} else {
								// put other non-root diagram in resource
								target.getContents().add(diagram);
							}
						}
					} else {
						// just throw stuff together
						if (isDiagramRoot(diagram)) {
							// throw root diagrams together
							targetDiagramRoot.getPersistedChildren().addAll(diagram.getPersistedChildren());
							targetDiagramRoot.getPersistedEdges().addAll(diagram.getPersistedEdges());
						} else {
							// put other non-root diagrams in resource
							target.getContents().add(diagram);
						}
					}
				} // end import layout data
				
			} // end iterate over file contents
			
		} // end iterate over source files

		// save target file
		try {
			target.save(null);
		} catch (IOException e) {
			errors.add("Could not save target file.");
			e.printStackTrace();
		}
	}
	
	/**
	 * Create backup of given Resource. The resource is opened as an ordinary
	 * file and read byte by byte. The contents are then written to another file
	 * with the same name with an appendix.
	 * 
	 * @param resource	Resource to create a backup for.
	 * @param appendix	Appendix for backup file, e.g. ".bak" or "~"
	 */
	protected final void createBackup(Resource resource, String appendix) {
		String path = resource.getURI().path();
		try {
			File f1 = new File(path);
			File f2 = new File(path + appendix);
			InputStream in = new FileInputStream(f1);
			OutputStream out = new FileOutputStream(f2);

			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			
			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			errors.add("Could not create backup file: File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			errors.add("Could not create backup file: I/O Exception.");
			e.printStackTrace();
		}
	}
	
	/**
	 * If two EObjects are considered identical (e.g. using their name or ID 
	 * attribute, if any), they are 'merged', recursively repeating the process
	 * for their children. If an attribute or 1-reference is set in both objects
	 * and can not be merged, it is taken from the second, i.e. imported, object.    
	 * 
	 * @param first		first EObject
	 * @param second	second EObject
	 * @return			merged?
	 */
	protected boolean merge(EObject first, EObject second) {
		if (first == null || second == null)
			throw new IllegalArgumentException("Arguments must not be null");
		if (first.eClass() != second.eClass())
			throw new IllegalArgumentException("Arguments must be of the same EClass");
		mergedMap.put(second, first);

		System.out.println("Merging:\r\n\t" + first + "\r\n\t" + second);

		/*
		 * - three cases:
		 *   - attribute: take value from second
		 *   - 1-reference: try to merge values
		 *   - n-reference: merge, if identical, else add to first
		 * - keep references to objects from first
		 *   - create map holding reference from second to first
		 *   - update of references is done afterwards
		 */
		for (EStructuralFeature feature : first.eClass().getEAllStructuralFeatures()) {
			if (feature instanceof EAttribute) {
				// take the attribute value from second
				// null-values are *not* ignored, otherwise the result could be inconsistent
				first.eSet(feature, second.eGet(feature));
			}
			if (feature instanceof EReference) {
				EReference reference = (EReference) feature;
				if (reference.isContainment()) {
					if (reference.isMany()) {
						// check if can be merged, otherwise add to list
						List<EObject> selfList = (List<EObject>) first.eGet(reference);
						List<EObject> otherList = (List<EObject>) second.eGet(reference);
						List<EObject> notMerged = new ArrayList<EObject>();
						for (EObject other : otherList) {
							boolean merged= false;
							for (EObject self : selfList) {
								if (canMerge(self, other)) {
									merge(self, other);
									merged= true;
									continue;
								}
							}
							if (! merged) {
								notMerged.add(other);
							}
						}
						for (EObject other : notMerged) {
							selfList.add(other);
						}
					} else {
						// merge the referenced objects
						EObject self = (EObject) first.eGet(reference);
						EObject other = (EObject) second.eGet(reference);
						if (self != null && other != null) {
							merge(self, other);
						} else {
							first.eSet(reference, other);
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * Update references in the merged Object using the mergedMap. References to
	 * objects from the source model that are contained in the mergedMap are
	 * updated to the respective merged objects.
	 * 
	 * @param merged	merged EObjects which's references are to be updated 
	 */
	protected void updateReferences(EObject merged) {
		// update non-containment references
		for (EReference reference : merged.eClass().getEAllReferences()) {
			if (! reference.isContainment()) {
				if (reference.isMany()) {
					List<EObject> values = (List<EObject>) merged.eGet(reference);
					List<EObject> toReplace = new ArrayList<EObject>();
					for (EObject val : values) {
						if (mergedMap.containsKey(val)) {
							toReplace.add(val);
						}
					}
					for (EObject val : toReplace) {
						int index= values.indexOf(val);
						values.remove(val);
						values.add(index, mergedMap.get(val));
					}
				} else {
					EObject val= (EObject) merged.eGet(reference);
					if (mergedMap.containsKey(val)) {
						merged.eSet(reference, mergedMap.get(val));
					}
				}
			}
		}
		// repeat for children
		for (TreeIterator<EObject> iter = merged.eAllContents(); iter.hasNext(); ) {
			EObject child = iter.next();
			updateReferences(child);
		}
	}
	
	/**
	 * Determine whether the two EObjects can be merged, which is determined by
	 * some special attribute, like 'name' or 'id'.
	 * 
	 * @param first		First Object
	 * @param second	Second Object
	 * @return			can be merged?
	 */
	protected boolean canMerge(EObject first, EObject second) {
		if (first == null || second == null) return false;
		if (first.eClass() != second.eClass()) return false;
		EClass clazz= first.eClass();

		if (first instanceof Style) {
			// styles of same type (i.e. same eClass, see above) are merged
			return true;
		}
		
		if (first instanceof View) {
			// compare view elements
			View firstView = (View) first;
			View secondView = (View) second;
			
			/*
			 * 	if views have same type
			 *		if views have model elements
			 *			merge views if model elements have been merged
			 *		else
			 *			if view is edge
			 * 				merge views if source and target model elements have been merged
			 *			else 
			 *				merge container views
			 */
			if (firstView.getType().equals(secondView.getType())) {
				// views have same type
				if (firstView.getElement() != null || secondView.getElement() != null) {
					// one of the views has an element -> merge views, if elements have been merged
					return mergedMap.get(secondView.getElement()) == firstView.getElement();
				} else {
					// views have no element
					if (first instanceof Edge) {
						// views are edges, connected to other views that should have elements
						Edge firstEdge = (Edge) first;
						Edge secondEdge = (Edge) second;
						return mergedMap.get(secondEdge.getSource().getElement()) == firstEdge.getSource().getElement() &&
						mergedMap.get(secondEdge.getTarget().getElement()) == firstEdge.getTarget().getElement();
					} else {
						// views must be unlabeled container views and can be merged
						return true;
					}
				}
			} else {
				// views do not have same type
				return false;
			}
			
		} else {
			// compare model elements
			if (clazz.getEIDAttribute() != null) {
				// class has explicit ID attribute
				return testAttributeEqualNotNull(clazz.getEIDAttribute(), first, second);
			} else {
				// look for generic ID attributes, like 'id' or 'name'
				for (EAttribute att : clazz.getEAllAttributes()) {
					if ("id".equalsIgnoreCase(att.getName())) {
						return testAttributeEqualNotNull(att, first, second);
					}
				}
				for (EAttribute att : clazz.getEAllAttributes()) {
					if ("name".equalsIgnoreCase(att.getName())) {
						return testAttributeEqualNotNull(att, first, second);
					}
				}
			}
			
		}
		return false;
	}

	/**
	 * Test whether the given EAttribute is non-null and equal on both given EObjects
	 * 
	 * @param att		some EAttribute which should be an attribute of both EObjects
	 * @param obj1		first of two EObjects, should have same class
	 * @param obj2		second of two EObjects, should have same class
	 * @return			attribute values are both non null and equal
	 */
	protected final boolean testAttributeEqualNotNull(EAttribute att, EObject obj1, EObject obj2) {
		Object v1 = obj1.eGet(att);
		Object v2 = obj2.eGet(att);
		return testEquals(v1, v2);
	}
	
	/**
	 * Test whether the two object values are equal and not null.
	 * 
	 * @param value1	some object
	 * @param value2	some other object
	 * @return			objects equal and not null?
	 */
	protected final boolean testEquals(Object value1, Object value2) {
		return value1 != null && value2 != null && value1.equals(value2);
	}
	
	/**
	 * Test whether the two object values are equal or null.
	 * 
	 * @param value1	some object
	 * @param value2	some other object
	 * @return			objects equal or null?
	 */
	protected final boolean testEqualsOrNull(Object value1, Object value2) {
		return value1 == null ? value2 == null : value1.equals(value2); 
	}

}
