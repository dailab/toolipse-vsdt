package de.dailab.common.swt.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * Simple dialog for selecting one or many of a number of elements.
 * 
 * @author kuester
 *
 * @param <T>	Type of the elements to select from
 */
public class MultiSelectDialog <T extends Object> extends TitleAreaDialog {

	/** dialog's title */
	protected final String title;
	
	/** message presented in the dialog */
	protected final String message;
	
	/** elements and current state of selection */
	protected final Map<T, Boolean> selectionMap;
	
	/**
	 * Create Dialog
	 * 
	 * @param parentShell		the parent shell
	 * @param title				the title
	 * @param message			the message
	 * @param selectionMap		elements and initial selection
	 */
	public MultiSelectDialog(Shell parentShell, String title, String message, Map<T, Boolean> selectionMap) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		setTitle(title);

		this.title = title;
		this.message = message;
		this.selectionMap = new HashMap<T, Boolean>(selectionMap);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
		parent.getShell().setText( title );
		setMessage(message);
		return superContent;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);
		
		for (final T element : selectionMap.keySet()) {
			final Button button = new Button(superComposite, SWT.CHECK);
			button.setText(getText(element));
			button.setSelection(selectionMap.get(element));
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					selectionMap.put(element, button.getSelection());
				}
			});
		}
		
		return superComposite;
	}

	/**
	 * @param element		some element
	 * @param state			selected or not?
	 */
	public void setSelected(T element, boolean state) {
		if (selectionMap.containsKey(element)) {
			selectionMap.put(element, state);
		}
	}
	
	/**
	 * @return				list of selected elements
	 */
	public List<T> getSelected() {
		List<T> selected = new ArrayList<T>();
		for (T key : selectionMap.keySet()) {
			if (selectionMap.get(key)) {
				selected.add(key);
			}
		}
		return selected;
	}
	
	/**
	 * @param element		some element
	 * @return				selected or not?
	 */
	public boolean isSelected(T element) {
		if (selectionMap.containsKey(element)) {
			return selectionMap.get(element);
		} else {
			return false;
		}
	}
	
	/**
	 * Overwrite this method to change the text displayed for the elements.
	 * 
	 * @param element		some element
	 * @return				text to be displayed next to the checkbox
	 */
	protected String getText(T element) {
		return String.valueOf(element);
	}
		
}
