package de.dailab.vsdt.diagram.dialogs;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.dialogs.AbstractOrganizeElementsDialog;
import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.diagram.actions.OrganizeElementsAction;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * A dialog used for organizing Properties of a BPMN model element
 * 
 * @author kuester
 */
public class OrganizePropertiesDialog extends AbstractOrganizeElementsDialog<Property> {
	
	private static final String NEW_PROP_NAME= "";
	private static final String NEW_PROP_TYPE= de.dailab.vsdt.vxl.util.Util.TYPE_STRING;
	private static final String LABEL_NAME= "Name";
	private static final String LABEL_TYPE= "Type";
	private static final String BUTTON_DATATYPES = "DataTypes...";

	private static final int CHECK_OK= 0;
	private static final int CHECK_WARNING= 1;
	private static final int CHECK_ERROR= 2;
	
	/**property name input field*/
	private Text propNameText;
	
	/**property type input field*/
	private Combo propTypeCombo;
	
	private List<Property> visibleProperties;
	
	@Override
	public String getElementName() {
		return "Property";
	}
	@Override
	public String getElementNamePlural() {
		return "Properties";
	}
	
	/**create a new Organize Assignments Dialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 * @param parentElement
	 */
	public OrganizePropertiesDialog(Shell parentShell, EObject parentElement, int hint) {
		super(parentShell, parentElement, true, 4);
		if (parentElement instanceof AbstractProcess) {
			elements= ((AbstractProcess) parentElement).getProperties();
		}
		if (parentElement instanceof DataObject) {
			elements= ((DataObject) parentElement).getProperties();
		}
		if (parentElement instanceof Service) {
			if (hint == 0) {
				elements= ((Service) parentElement).getInput();
			} else if (hint == 1) {
				elements= ((Service) parentElement).getOutput();
			}
		}
		if (parentElement instanceof Pool) {
			elements= ((Pool) parentElement).getProperties();
		}
		visibleProperties= VsdtHelper.getVisibleProperties(parentElement);
	}
	
	@Override
	protected void createEditGroupControls(Group editGroup) {
		//input lines
		new Label(editGroup,SWT.NONE).setText(LABEL_NAME);
		propNameText= new Text(editGroup,SWT.BORDER);
		propNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		propNameText.addModifyListener(this);
		
		new Label(editGroup,SWT.NONE).setText(LABEL_TYPE);
		propTypeCombo= new Combo(editGroup, SWT.BORDER | SWT.DROP_DOWN);
		propTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		updateDataTypes(propTypeCombo, parentElement);
		propTypeCombo.addModifyListener(this);
	}

	@Override
	protected Property createNewElement() {
		Property property= VsdtFactory.eINSTANCE.createProperty();
		property.setName(NEW_PROP_NAME);
		property.setType(NEW_PROP_TYPE);
		return property;
	}
	
	@Override
	protected Control getElementToFocus() {
		return propNameText;
	}

	@Override
	protected void updateElementFromEditGroup(Property property) {
		if (property != null) {
			property.setName(Util.nullIfEmpty(propNameText.getText()));
			property.setType(Util.nullIfEmpty(propTypeCombo.getText()));
			checkPropertyName(property);
		}
	}
	
	@Override
	protected void refreshEditGroup() {
		Property property = getSelectedElement();
		if (property != null) {
			propNameText.setText(Util.nonNull(property.getName()));
			propTypeCombo.setText(Util.nonNull(property.getType()));
		}
		propNameText.setEnabled(property != null);
		propTypeCombo.setEnabled(property != null);
	}
	
	@Override
	protected String getString(Property property) {
		if (property != null) {
			StringBuffer buffer= new StringBuffer();
			buffer.append(property.getName());
			buffer.append(": "); //$NON-NLS-1$
			buffer.append(property.getType());
			return buffer.toString();
		}
		return super.getString(null);
	}
	
	@Override
	protected Collection<Button> contributeToButtonsGroup(Composite buttonsGroup) {
		Button button= new Button(buttonsGroup,SWT.NONE);
		button.setText(BUTTON_DATATYPES);
		button.addSelectionListener(this);
		return Arrays.asList(button);
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		if (e.getSource() instanceof Button	) {
			if (BUTTON_DATATYPES.equals(((Button) e.getSource()).getText())) {
				OrganizeElementsAction.getDataTypesAction().run(VsdtHelper.getRootElement(parentElement));
				// update data types combo
				updateDataTypes(propTypeCombo, parentElement);
			}
		}
	}
	
	@Override
	protected void okPressed() {
		for (Property property : elements) {
			if (checkPropertyName(property) == CHECK_ERROR) {
				selectElement(property);
				propNameText.setFocus();
				return;
			}
			if (checkPropertyType(property) == CHECK_ERROR) {
				selectElement(property);
				propTypeCombo.setFocus();
				return;
			}
		}
		super.okPressed();
	}
	
	/**
	 * Check the given Property's name
	 * @param name	some property
	 * @return		name ok (0), same name in parent scope (1), 
	 * 				duplicate name in same scope (2), other (-1)
	 */
	private int checkPropertyName(Property prop) {
		if (prop == null) return -1;
		String name= prop.getName();
		setErrorMessage(null);
		if (name == null || name.isEmpty()) {
			setErrorMessage("Property name must not be empty!");
			return CHECK_ERROR;
		}
		for (Property property : elements) {
			if (prop == property) continue;
			if (name.equals(property.getName())) {
				setErrorMessage("A Property with the name '" + name + 
						"' already exists in this element's scope.");
				return CHECK_ERROR;
			}
		}
		for (Property property : visibleProperties) {
			if (prop == property) continue;
			if (name.equals(property.getName())) {
				setMessage("A Property with name '" + name + 
						"' already exists in a parent scope.", IMessageProvider.WARNING);
				return CHECK_WARNING;
			}
		}
		return CHECK_OK;
	}
	
	/**
	 * Check the given Property's type
	 * @param name	some property
	 * @return		type ok (0), type unknown or not set (2), other (-1)
	 */
	private int checkPropertyType(Property prop) {
		if (prop == null) return -1;
		String type= prop.getType();
		setErrorMessage(null);
		if (type == null || type.isEmpty()) {
			setErrorMessage("Property must have a type!");
			return CHECK_ERROR;
		}
		for (String t : propTypeCombo.getItems()) {
			if (type.equals(t)) {
				return CHECK_OK;
			}
		}
		setErrorMessage("Unknown type: " + type);
		return CHECK_ERROR;
	}
	
	/**
	 * Update the data types in the combo box
	 */
	public static void updateDataTypes(Combo combo, EObject parentElement) {
		String selected = combo.getText();
		combo.removeAll();
		// basic data types
		for (String type : de.dailab.vsdt.vxl.util.Util.datatypes) {
			combo.add(type);
		}
		// complex data types
		BusinessProcessSystem bps = (BusinessProcessSystem) VsdtHelper.getRootElement(parentElement); 
		for (DataType datatype: bps.getDataTypes()) {
			String type = datatype.getPackage() != null ? 
					(datatype.getPackage() + "." + datatype.getName()) : datatype.getName();
			combo.add(type);
		}
		combo.setText(selected);
	}
}
