package de.dailab.vsdt.diagram.views.bpmnprop;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

import sun.misc.Compare;
import sun.misc.Sort;
import de.dailab.vsdt.Property;

/**
 * This class is used to sort the content of the BPMN Properties View
 * 
 * @author kuester
 */
public class BpmnPropertiesViewSorter extends ViewerSorter {
	
	public static final int CRITERION_OWNER= 0;
	public static final int CRITERION_NAME= 1;
	public static final int CRITERION_TYPE= 2;
	
	/** sorting criterion */
	private int criterion= -1;
	
	/**
	 * Create new Sorter with special sorting criterion
	 * @param criterion		the sorting criterion to use
	 */
	public BpmnPropertiesViewSorter(int criterion) {
		this.criterion= criterion;
	}

	@Override
	public void sort(Viewer viewer, Object[] elements) {
		super.sort(viewer, elements);
		Sort.quicksort(elements, new Compare(){
			public int doCompare(Object o1, Object o2) {
				return compare( null, o1, o2 );
			}
		});
	}
	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof Property && e2 instanceof Property) {
			Property p1= (Property) e1;
			Property p2= (Property) e2;
			
			if (criterion == -1) {
				// no specific criterion; test all
				int result= compare(p1, p2, CRITERION_OWNER);
				if (result == 0) {
					result= compare(p1, p2, CRITERION_NAME);
					if (result == 0) {
						compare(p1, p2, CRITERION_TYPE);
					}
				}
				return result;
			} else {
				return compare(p1, p2, criterion);
			}
		}
		return 0;
	}
	
	/**
	 * Compare the two given Properties by one of the three criteria.
	 * 
	 * @param p1			Some Property
	 * @param p2			Some other Property
	 * @param criterion		Sorting criterion
	 * @return				First Property
	 */
	private int compare(Property p1, Property p2, int criterion) {
		if (criterion == CRITERION_OWNER) {
			int d1= getDepth(p1);
			int d2= getDepth(p2);
			if (d1 != d2) {
				return d1-d2;
			}
		}
		if (criterion == CRITERION_NAME){
			if (p1.getName() != null && ! p1.getName().equals(p2.getName())) {
				return p1.getName().compareTo(p2.getName());
			}
		}
		if (criterion == CRITERION_TYPE) {
			if (p1.getType() != null && ! p1.getType().equals(p2.getType())) {
				return p1.getType().compareTo(p2.getType());
			}
		}
		return 0;
	}
	
	/**
	 * This method return the distance of the given EObject to the root
	 * container. It is used for sorting elements by the hierarchy of
	 * their owners.
	 * 
	 * @param o		Some EObject
	 * @return		The distance of the element to the root container
	 */
	private int getDepth(EObject o) {
		if (o.eContainer() == null) {
			return 0;
		} else {
			return getDepth(o.eContainer()) + 1;
		}
	}
}