package de.dailab.common.swt.dialogs;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * This class should be used as a superclass for Organize-Dialogs and similar for the VSDT.
 * Apart from saving some lines in the actual classes it provides a uniform look and feel.
 * 
 * Dialogs extending this class will be very easy to implement.
 * ( I) What has to be done:
 * 1.: Implement createEditGroupControls, populating the edit group with 
 *     e.g. TextField for the several attribute values.
 * 2.: Implement createNewElement, creating and initializing a new Element.
 * 3.: Implement updateElementFromEditGroup, writing the changes made in the edit group into the object.
 * 4.: Implement refreshEditGroup, writing the object's attribute values into the edit group controls.
 * (II) What can be done optionally:
 * 5.: Implement getString, returning the String representation of the Objects in the list.
 * 6.: Implement contributeToButtonsGroup and extend refreshButtons and widgetSelected
 *     for providing additional buttons and actions.
 * 7.: Implement handleDoubleClicked for providing double-click behavior. 
 * 
 * @author kuester
 */
public abstract class AbstractOrganizeElementsDialog<T extends EObject> extends TitleAreaDialog implements SelectionListener, MouseListener, ModifyListener {

	public static final String NL= System.getProperty("line.separator");
	
	private static final String BUTTON_NEW= "New";
	private static final String BUTTON_REMOVE= "Remove";
	private static final String BUTTON_UP= "Move up";
	private static final String BUTTON_DOWN= "Move down";
	private static final String ERROR__NO_MODEL_ELEMENT= "Error: No model element found";
	private static final String LABEL_EDIT_GROUP= "Edit selected Element";
	private static final String REMOVE_TITLE= "Remove Element?";
	private static final String REMOVE_MESSAGE= "The selected element might currently be used by other elements. " +
			NL + "Are you sure you want to remove the element?";
	
	/**the parent element*/
	protected final EObject parentElement;
	
	/**the list holding the model elements*/
	protected java.util.List<T> elements= new ArrayList<T>();

	/**visualization of the assignment list (a GUI element)*/
	protected List elementList;
	
	/**this determines whether the movement controls should be displayed, which only makes sense if the position of the element in the list is relvant*/
	protected boolean isMovableElement= false;
	
	/**this string is storing a error message that might be throws at initialization to be displayed when ready*/
	protected String errorMessage= null;
	
	/**whether the entire dialog shall be disabled, e.g. when there is a severe error that can not be corrected in the dialog*/
	protected boolean disable= false;
	
	/**number of rows for the edit group*/
	protected int editGroupColumns= 2;
	
	private Button addButton;
	private Button removeButton;
	private Button upButton;
	private Button downButton;
	
	/** last button in the button column, used for form layout */
	protected Button lastButton;
	
	/** the edit group, containing all the controls like text fields and combo boxes*/
	private Group editGroup;
	
	/** this field is set to true before updating the edit group; otherwise the model element would get updated in the process */ 
	private boolean preventUpdate= false;

	/**
	 * Constructor. Sets the dialog title and checks whether a parent model element is present.
	 * 
	 * @param parentShell		the shell
	 * @param parentElement		the model element holding the elements to organize
	 * @param isMovable			display move up/down buttons?
	 * @param numRows			number of rows for the edit group
	 */
	public AbstractOrganizeElementsDialog(Shell parentShell, EObject parentElement, boolean isMovable, int numRows) {
		super(parentShell);
		this.parentElement= parentElement;
		this.setTitle(getTitle());
		this.setShellStyle(getShellStyle() | SWT.RESIZE);
		this.editGroupColumns= numRows;
		this.isMovableElement= isMovable;
		
		if (parentElement == null) {
			errorMessage= ERROR__NO_MODEL_ELEMENT;
			disable= true;
		}
	}

	/**Creates the contents.
	 * 
	 * @see org.eclipse.jface.window.Window#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected final Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);
		
		parent.getShell().setText( getTitle() );
		setMessage( getMessage() );
		
		setErrorMessage(errorMessage);
		if (disable || errorMessage != null) {
			getButton(IDialogConstants.OK_ID).setEnabled( false );
		}
		return superContent;
	}

	/**
	 * Creates the dialog area.
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected final Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);
		Composite composite = new Composite( superComposite, 0 );
		composite.setLayoutData( new GridData( GridData.FILL_BOTH ) );

		GridLayout layout = new GridLayout(2,false);
		composite.setLayout( layout );
		
		//the list showing the current elements
		elementList= new org.eclipse.swt.widgets.List(composite,SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		elementList.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,true));
		elementList.addSelectionListener(this);
		elementList.addMouseListener(this);
		
		// Buttons
		Composite buttonsGroup= new Composite(composite,SWT.NONE);
		buttonsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		layout = new GridLayout(1,false);
		buttonsGroup.setLayout( layout );

		GridData buttonGridData= new GridData(SWT.FILL,SWT.FILL,true,false);

		addButton= new Button(buttonsGroup,SWT.NONE);
		addButton.setText(BUTTON_NEW);
		addButton.setLayoutData(buttonGridData);
		addButton.addSelectionListener(this);
		
		removeButton= new Button(buttonsGroup,SWT.NONE);
		removeButton.setText(BUTTON_REMOVE);
		removeButton.addSelectionListener(this);
		
		if (isMovableElement) {
			removeButton.setLayoutData(buttonGridData);
			
			upButton= new Button(buttonsGroup,SWT.NONE);
			upButton.setText(BUTTON_UP);
			upButton.setLayoutData(buttonGridData);
			upButton.addSelectionListener(this);
			
			downButton= new Button(buttonsGroup,SWT.NONE);
			downButton.setText(BUTTON_DOWN);
			downButton.addSelectionListener(this);
		}
		lastButton= isMovableElement ? downButton : removeButton;
		
		Collection<Button> moreButtons = contributeToButtonsGroup(buttonsGroup);
		for (Button button : moreButtons) {
			button.setLayoutData(buttonGridData);
		}

		
		editGroup= new Group(composite,SWT.NONE);
		editGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 2));
		layout = new GridLayout(editGroupColumns,false);
		editGroup.setLayout( layout );
		editGroup.setText(LABEL_EDIT_GROUP);
		
		createEditGroupControls(editGroup);

		refreshElementsList();
		refreshEditGroup();
		refreshButtons();
		
		return superComposite;
	}
	
	/**
	 * @return		The widget to focus after a new element has been created
	 */
	protected Control getElementToFocus() {
		return null;
	}

	/**
	 * Override this method to contribute additional buttons to the buttons group
	 * @param buttonGroup	
	 */
	protected Collection<Button> contributeToButtonsGroup(Composite buttonsGroup) {
		return new ArrayList<Button>();
	}

	/**
	 * Override this method to handle double clicks on elements in the list
	 */
	protected void handleDoubleClick(T selected) {
	}
	
	/**
	 * create and initialize the text fields and combo boxes to appear in the edit group.
	 * @param editGroup		the edit group to insert the elements into
	 */
	protected abstract void createEditGroupControls(Group editGroup);

	
	/**
	 * Enable / Disable all the controls in the edit group
	 * @param enable
	 */
	protected void enableGroupControls(Group group, boolean enable) {
		for (Control c : group.getChildren()) {
			c.setEnabled(enable);
		}
	}
	
	/**
	 * @return	The Title for this dialog
	 */
	public String getTitle() {
		StringBuffer buff= new StringBuffer();
		buff.append("Organize ");
		buff.append(getElementNamePlural());
		buff.append(" for ");
		buff.append(parentElement.eClass().getName());
		return buff.toString();
	}
	
	/**
	 * @return	The message/description to be shown in this dialog
	 */
	public String getMessage() {
		StringBuffer buff= new StringBuffer();
		buff.append("Use the Buttons to add, arrange and remove ");
		buff.append(getElementNamePlural());
		buff.append(". ").append(NL);
		buff.append("To edit a");
		if (getElementName().startsWith("A")) {
			buff.append("n");
		}
		buff.append(" ");
		buff.append(getElementName());
		buff.append(", select it from the list and edit its values in the area below.");
		return buff.toString();
	}
	
	/**
	 * @return	Name of the Element (Type) to edit, used e.g. in getDescription
	 */
	public abstract String getElementName();
	
	/**
	 * @return	Name of the Element (Type) to edit in plural form. Normally, this is the 
	 *          name with an appended s, however there may be cases, when this is not the case.
	 */
	public String getElementNamePlural() {
		return getElementName() + "s";
	}
	
	/**
	 * enable/disable buttons according to the current selection.
	 */
	protected void refreshButtons() {
		boolean oneSelected= elementList.getSelectionCount() == 1;
		boolean firstSelected= elementList.getSelectionIndex()== 0;
		boolean lastSelected= elementList.getSelectionIndex()== elementList.getItemCount()-1;
		removeButton.setEnabled(oneSelected);
		if (isMovableElement) {
			upButton.setEnabled(oneSelected && ! firstSelected);
			downButton.setEnabled(oneSelected && ! lastSelected);
		}
	}

	/**
	 * create and add a new element, add it to the list, and select it.
	 */
	protected final void addNewElement() {
		T object= createNewElement();
		elements.add(object);
		refreshElementsList();
		elementList.setSelection(elementList.getItemCount()-1);
		doAutofocus();
	}
	
	/**
	 * Create a new Element. Do NOT insert the newly created element into the list in
	 * this method, as this is done in the addNewElement method, which is called on 
	 * clicking the button.
	 * 
	 * @return		Newly created Element to be inserted into the list.
	 */
	protected abstract T createNewElement();
	
	protected final void updateSelectedElement() {
		T object= getSelectedElement();
		if (object != null) {
			updateElementFromEditGroup(object);
			refreshElementsList();
		}
	}
	
	/**
	 * Update the selected element with the values from the edit group, e.g. text
	 * field, combo boxes, etc.
	 * 
	 * @param object
	 */
	protected abstract void updateElementFromEditGroup(T object);

	/**
	 * Move the currently selected element up or down by the specified value
	 * 
	 * @param movement		direction and amount of movement
	 */
	protected final void moveSelectedElement(int movement) {
		T object= getSelectedElement();
		if (object != null) {
			int newIndex= elementList.getSelectionIndex() + movement;
			if (newIndex > -1 && newIndex < elements.size()) {
				elements.remove(object);
				elements.add(newIndex, object);
				refreshElementsList();
				elementList.setSelection(newIndex);
			}	
		}
	}

	/**
	 * Remove the currently selected element from the model element and refresh the element list.
	 */
	protected final void removeSelectedElement() {
		T object= getSelectedElement();
		if (object != null &&
				MessageDialog.openQuestion(this.getShell(), REMOVE_TITLE, REMOVE_MESSAGE)) {
			recursiveRemove(object);
			refreshElementsList();
		}
	}
	
	/**
	 * Remove the given EObject and all of its eContents from the model.
	 * 
	 * @param object	EObject to remove recursively.
	 */
	private final void recursiveRemove(EObject object) {
		for (EObject child : object.eContents()) {
			recursiveRemove(child);
		}
		EcoreUtil.delete(object);
	}
	
	/**
	 * @return		the model element corresponding to the line currently selected in the list
	 */
	protected final T getSelectedElement() {
		T object= null;
		int index= elementList.getSelectionIndex();
		if (index != -1) {
			object= elements.get(index);
		}
		return object;
	}
	
	/**
	 * select the given element in the List, if contained
	 * 
	 * @param element	some element, should be in the list
	 * @return			element successfully selected?
	 */
	protected final boolean selectElement(T element) {
		int index = elements.indexOf(element);
		if (index != -1) {
			elementList.select(index);
			preventUpdate= true;
			refreshEditGroup();
			doAutofocus();
			preventUpdate= false;
			return true;
		}
		return false;
	}
	
	/**
	 * populate the element list with the existing elements from the model element
	 */
	protected void refreshElementsList() {
		int lastIndex= elementList.getSelectionIndex();
		elementList.removeAll();
		for (T element : elements) {
			elementList.add(getString(element));
		}
		elementList.setSelection((lastIndex < elementList.getItemCount() ? lastIndex : elementList.getItemCount()-1));
		enableGroupControls(editGroup, elementList.getItemCount() != 0);
	}
	
	/**
	 * refresh the edit group by setting the values of the text fields and combo boxes accordingly
	 * to the values of the currently selected assignment
	 */
	protected abstract void refreshEditGroup();
	
	/**
	 * returns the string representation of the object as displayed in the list
	 * 
	 * @param object		some eObject
	 * @return				string representation of the object
	 */
	protected String getString(T object) {
		return object != null? object.toString() : ""; //$NON-NLS-1$
	}
	
	/**
	 * Set Focus to Element to Focus, if any.
	 * @see #getElementToFocus()
	 */
	protected final void doAutofocus() {
		Control toBeFocused = getElementToFocus();
		if (toBeFocused != null) {
			toBeFocused.setFocus();
		}
	}
	
	// MODIFY LISTENER
	
	public void modifyText(ModifyEvent e) {
		if (! preventUpdate) {
			updateSelectedElement();
		}
	}
	
	// SELECTION LISTENER
	
	public void widgetDefaultSelected(SelectionEvent e) {
	}
	
	/**
	 * update edit group, listen to buttons
	 */
	public void widgetSelected(SelectionEvent e) {
		Object source= e.getSource();
		if (source instanceof Button) {
			Button button = (Button) source;
			String cmd= button.getText();

			if (BUTTON_NEW.equals(cmd)) {
				addNewElement();
			}
			if (BUTTON_REMOVE.equals(cmd)) {
				removeSelectedElement();
			}
			if (BUTTON_UP.equals(cmd)) {
				moveSelectedElement(-1);
			}
			if (BUTTON_DOWN.equals(cmd)) {
				moveSelectedElement(+1);
			}
			refreshButtons();
		}
		if (source instanceof List) {
			refreshButtons();
		}
		if (source instanceof Combo) {
			updateSelectedElement();
		}
		preventUpdate= true;
		refreshEditGroup();
		doAutofocus();
		preventUpdate= false;
		enableGroupControls(editGroup, getSelectedElement() != null);
	}

	
	// MOUSE LISTENER
	
	public final void mouseDoubleClick(MouseEvent e) {
		if (e.getSource() instanceof List) {
			handleDoubleClick(getSelectedElement());
		}		
	}

	public void mouseDown(MouseEvent e) {
	}
	
	public void mouseUp(MouseEvent e) {
	}
	
}
