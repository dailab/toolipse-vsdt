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

import de.dailab.vsdt.BusinessProcessSystem;

/**
 * Used for importing one or more VSDT files into another. This is not to be
 * confused with import features such as 'BPEL to BPMN', as both source and 
 * target files are of the same type. Rather this is a compensation for the lack
 * of working copy & paste support.
 * 
 * The most basic (and most useless) feature is the import of pure model data,
 * which can equally be accomplished by copy-pasting between the XML files. More
 * useful is the import with layout, which will preserve the layout of the 
 * imported files. This can not be done as easily in XML, as there might be id-
 * clashes. Finally, it should also be possible to smartly merge two versions of
 * a VSDT diagram.
 * 
 * @author kuester
 */
public class VsdtDiagramImporter {

	/*
	 * TODO
	 * make merging work
	 * make import of layout and merging work together
	 */
	
	private static final String DIAGRAM_VSDT= "Vsdt";
	private static final String DIAGRAM_META= "Vsdt_meta";

	/** the list of files that are imported */ 
	private final List<Resource> sources;

	/** the target file the source files are imported into */
	private final Resource target;

	/** list of warnings that occurred during import */
	private final List<String> warnings;

	/** list of errors that occurred during import */
	private final List<String> errors;

	/** create backup of target file */
	private final boolean backup;

	/** preserve layout? */
	private final boolean layout;

	/** merge identical objects? */
	private final boolean merge;

	/**
	 * Create new VsdtDiagramImporter.
	 * 
	 * @param from		List of Resources to import from
	 * @param to		Resource to import into
	 * @param backup	create backup?
	 * @param layout	import layout?
	 * @param merge		merge identical objects?
	 */
	public VsdtDiagramImporter(List<Resource> from, Resource to,
			boolean backup, boolean layout, boolean merge) {
		this.sources = from;
		this.target = to;
		this.backup = backup;
		this.layout = layout;
		this.merge = merge;
		this.warnings = new ArrayList<String>();
		this.errors = new ArrayList<String>();
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
	 * Do actual import work.
	 */
	public void doImport() {

		// get target BPS and diagram root 
		BusinessProcessSystem targetBps= null;
		Diagram targetDiagramRoot= null;
		for (EObject content : target.getContents()) {
			if (content instanceof BusinessProcessSystem) {
				targetBps= (BusinessProcessSystem) content;
			}
			if (content instanceof Diagram 
					&& DIAGRAM_META.equals(((Diagram) content).getType())) {
				targetDiagramRoot= (Diagram) content;
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
				if (content instanceof BusinessProcessSystem) {
					BusinessProcessSystem otherBps= (BusinessProcessSystem) content;
					if (merge) {
						merge(targetBps, otherBps);
						updateReferences(targetBps);
					} else {
						// just throw stuff together
						targetBps.getBusinessProcesses().addAll(otherBps.getBusinessProcesses());
						targetBps.getParticipants().addAll(otherBps.getParticipants());
						targetBps.getImplementations().addAll(otherBps.getImplementations());
						targetBps.getMessages().addAll(otherBps.getMessages());
					}
				}
				
				// import layout data
				if (layout) {
					if (content instanceof Diagram) {
						Diagram diagram = (Diagram) content;
						// import BPMN diagrams
						if (DIAGRAM_VSDT.equals(diagram.getType())) {
							target.getContents().add(diagram);
						}
						// merge Meta diagrams
						if (DIAGRAM_META.equals(diagram.getType())) {
							targetDiagramRoot.getPersistedChildren().addAll(diagram.getPersistedChildren());
							targetDiagramRoot.getPersistedEdges().addAll(diagram.getPersistedEdges());
						}
					}
				}
			}
		}

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
	protected void createBackup(Resource resource, String appendix) {
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
	 * Map of elements being merged, with key-value pairs like
	 *   element_from_source -> element_from_target,
	 * where element_from_target can be contained once for each source resource.
	 */
	private Map<EObject, EObject> mergedMap= new HashMap<EObject, EObject>();
	
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
	 * @param merged	merged EObjects whichs references are to be updated 
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
	private boolean canMerge(EObject first, EObject second) {
		if (first == null || second == null) return false;
		if (first.eClass() != second.eClass()) return false;

		EClass clazz= first.eClass();
		if (clazz.getEIDAttribute() != null) {
			// class has explicit ID attribute
			return testAttributeEqualNotNull(clazz.getEIDAttribute(), first, second);
		} else {
			// look for other appropriate attributes, like 'id' or 'name'
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
		return false;
	}

	/**
	 * Test whether the given EAttribute is equal on both given EObjects
	 * 
	 * @param att		some EAttribute which should be an attribute of both EObjects
	 * @param obj1		first of two EObjects, should have same class
	 * @param obj2		second of two EObjects, should have same class
	 * @return			attribute values are both non null and equal
	 */
	private boolean testAttributeEqualNotNull(EAttribute att, EObject obj1, EObject obj2) {
		Object v1 = obj1.eGet(att);
		Object v2 = obj2.eGet(att);
		return v1 != null && v2 != null && v1.equals(v2);
	}

}
