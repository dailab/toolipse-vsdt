package de.dailab.common.swt;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

/**
 * This Class provides a comfortable way for working with a SWT combo.
 * Internally, the elements passed to the combo will be associated with
 * the indices they have in the list. Additionally, a null-entry will
 * be added to each collection of objects, which will also be regarded
 * in the several access methods.
 * 
 * Note that the FeatureCombo is not the GUI element, but only wraps 
 * a GUI element. For access to the GUI element, e.g. for adding 
 * listeners or having access to other methods of that element, 
 * use the {@link #getCombo()} method to retrieve the actual combo.
 * 
 * This class works best with a read-only combo box, which in most
 * cases where a combo is storing non-string objects is the only 
 * thing that makes sense, anyway.
 * 
 * @author kuester
 * @param <T>	Type of element to collect in this combo
 */
public class FeatureCombo<T extends Object> {
	
	/** the actual combo GUI element */
	private Combo combo;
	
	/** map holding the association of indices to elements */
    private Map<Integer, T> indexToObject= new Hashtable<Integer, T>();
	
    /**
     * Create a new FeatureCombo. Creates a simple combo, 
     * which may need further refinement, e.g. for adding listeners.
     * 
     * @param parent	parent composite of the combo to be created
     * @param style		style of the combo to be created
     */
	public FeatureCombo(Composite parent, int style) {
		Combo combo= new Combo(parent, style);
		this.combo= combo;
	}
	
	/**
	 * Create a new FeatureCombo wrapping an existing combo.
	 *   
	 * @param combo		some existing combo
	 */
	public FeatureCombo(Combo combo) {
		this.combo= combo;
	}

	/**
	 * Fill the combo with entries for the elements in the given list.
	 * Besides the given elements, a null entry will be created, too.
	 * The existing elements are removed and the map of indices to 
	 * elements is populated anew.  The element currently selected
	 * in the combo, if any, is being preserved.
	 * 
	 * @param objects	new objects for being selected in the combo
	 */
	public void fillCombo(List<? extends T> objects) {
		T selected= getSelected();
		indexToObject.clear();
		combo.removeAll();
		combo.add("");
    	int index= 1;
		for (T o : objects) {
			String label= getLabel(o);
			combo.add(label);
			indexToObject.put(index++, o);
    	}
		setSelected(selected);
	}
	
	/**
	 * Override this method, to provide custom Labels for the 
	 * several items in the combo, Alternatively you can also 
	 * override the object class' toString method. 
	 * 
	 * @param o		Some EObject
	 * @return		o.toString(), by default
	 */
	protected String getLabel(T o) {
		return o.toString();
	}
	
	/**
	 * @return		the selected element, or null, if no element is selected
	 */
	public T getSelected() {
		return indexToObject.get(combo.getSelectionIndex());
	}
	
	/**
	 * Selects the given element.  If the element is null or not in the list,
	 * then the first entry in the combo, i.e. the null-entry, is selected.
	 * 
	 * @param o		some element from the list, or null
	 */
	public void setSelected(T o) {
		combo.select(0);
		for (int i=0; i<combo.getItemCount(); i++) {
			if (indexToObject.get(i) == o) {
				combo.select(i);
			}
		}
	}
	
	/**
	 * @return		the elements formerly passed to the combo box
	 * @see #fillCombo(List)
	 */
	public Collection<T> getElements() {
		return indexToObject.values();
	}
	
	/**
	 * @return		the underlying GUI element
	 */
	public Combo getCombo() {
		return combo;
	}
}
