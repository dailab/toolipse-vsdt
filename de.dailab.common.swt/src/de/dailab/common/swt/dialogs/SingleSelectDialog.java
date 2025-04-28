package de.dailab.common.swt.dialogs;

import java.util.ArrayList;
import java.util.List;

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
public class SingleSelectDialog <T extends Object> extends TitleAreaDialog {

	/** dialog's title */
	protected final String title;
	
	/** message presented in the dialog */
	protected final String message;
	
	/** elements for selection */
	protected final List<T> selectionList;
	
	/** the currently selected element */
	protected T selected = null;
	
	/**
	 * Create Dialog
	 * 
	 * @param parentShell		the parent shell
	 * @param title				the title
	 * @param message			the message
	 * @param selectionMap		elements for selection
	 */
	public SingleSelectDialog(Shell parentShell, String title, String message, List<T> selectionMap) {
		super(parentShell);
		setShellStyle(getShellStyle() | SWT.RESIZE);
		setTitle(title);

		this.title = title;
		this.message = message;
		this.selectionList = new ArrayList<T>(selectionMap);
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
		
		for (final T element : selectionList) {
			final Button button = new Button(superComposite, SWT.RADIO);
			button.setText(getText(element));
			if (selected == null) {
				button.setSelection(true);
				selected = element;
			} else {
				button.setSelection(false);
			}
			button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent e) {
					selected = element;
				}
			});
		}
		
		return superComposite;
	}

	/**
	 * @return				list of selected elements
	 */
	public T getSelected() {
		return selected;
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
