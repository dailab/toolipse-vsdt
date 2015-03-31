package de.dailab.vsdt.diagram.dialogs;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.dialogs.AbstractOrganizeElementsDialog;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.VsdtFactory;

/**
 * A dialog used for organizing Data Types of a BPMN model
 * 
 * @author kuester
 */
public class OrganizeDataTypesDialog extends AbstractOrganizeElementsDialog<DataType> {

	/*
	 * TODO 
	 * - add attributes inherits, members
	 *   - controls, update, refresh
	 * - add 'view definition' button
	 */

	private static final String LABEL_PACKAGE= "Package";
	private static final String LABEL_NAME= "Name";
	private static final String LABEL_LANGUAGE= "Language";
	private static final String LABEL_URL= "URL";
//	private static final String LABEL_MEMBERS= "Members";
//	private static final String LABEL_INHERITS= "Inherits";
	private static final String BUTTON_DEF= "Definition...";
	
	/**package input field*/
	private Text packageText;
	
	/**name input field*/
	private Text nameText;
	
	/**language input field */
	private Text languageText;
	
	/**URL input field */
	private Text urlText;
	
	
	@Override
	public String getElementName() {
		return "Data Type";
	}
	
	/**
	 * create a new Dialog Instance
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 */
	public OrganizeDataTypesDialog(Shell parentShell, EObject parentElement) {
		super(parentShell, parentElement, true, 4);

		BusinessProcessSystem bps= null;
		if (parentElement instanceof BusinessProcessSystem) {
			bps= (BusinessProcessSystem) parentElement;
		} else if (parentElement instanceof BusinessProcessDiagram) {
			bps= (BusinessProcessSystem) ((BusinessProcessDiagram) parentElement).getParent();
		}
		if (bps != null) {
			elements= ((BusinessProcessSystem) parentElement).getDataTypes();
		} else {
			throw new IllegalArgumentException("Parent element must be of type BusinessProcessSystem");
		}
	}
	
	@Override
	protected void createEditGroupControls(Group editGroup) {

		new Label(editGroup,SWT.NONE).setText(LABEL_PACKAGE);
		packageText= new Text(editGroup,SWT.BORDER);
		packageText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		packageText.addModifyListener(this);

		new Label(editGroup,SWT.NONE).setText(LABEL_NAME);
		nameText= new Text(editGroup,SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		nameText.addModifyListener(this);

		new Label(editGroup,SWT.NONE).setText(LABEL_LANGUAGE);
		languageText= new Text(editGroup, SWT.BORDER);
		languageText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		languageText.addModifyListener(this);
		
		new Label(editGroup,SWT.NONE).setText(LABEL_URL);
		urlText= new Text(editGroup,SWT.BORDER);
		urlText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		urlText.addModifyListener(this);

	}

	@Override
	protected DataType createNewElement() {
		return VsdtFactory.eINSTANCE.createDataType();
	}
	
	@Override
	protected Control getElementToFocus() {
		return packageText;
	}

	@Override
	protected void updateElementFromEditGroup(DataType dataType) {
		if (dataType!= null) {
			dataType.setPackage(Util.nullIfEmpty(packageText.getText()));
			dataType.setName(Util.nullIfEmpty(nameText.getText()));
			dataType.setLanguage(Util.nullIfEmpty(languageText.getText()));
			dataType.setUrl(Util.nullIfEmpty(urlText.getText()));
		}
	}
	
	@Override
	protected void refreshEditGroup() {
		DataType dataType= getSelectedElement();
		if (dataType != null) {
			packageText.setText(Util.nonNull(dataType.getPackage()));
			nameText.setText(Util.nonNull(dataType.getName()));
			languageText.setText(Util.nonNull(dataType.getLanguage()));
			urlText.setText(Util.nonNull(dataType.getUrl()));
		}
//		partCombo.getCombo().setEnabled(implementation != null);
	}
	

	@Override
	protected Collection<Button> contributeToButtonsGroup(Composite buttonsGroup) {
		Button button= new Button(buttonsGroup,SWT.NONE);
		button.setText(BUTTON_DEF);
		button.addSelectionListener(this);
		return Arrays.asList(button);
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		if (e.getSource() instanceof Button	) {
			if (BUTTON_DEF.equals(((Button) e.getSource()).getText())) {
				/*
				 * TODO
				 * - open file dialog
				 * - parse file (XSD, OWL, Java-Class, ...)
				 * - create DataTypes accordingly 
				 */
				MessageDialog.openInformation(getShell(), "Not yet implemented", "This feature is not yet implemented.");
			}
		}
	}
	
	@Override
	protected String getString(DataType datatype) {
		if (datatype != null) {
			String packageString= Util.nonNull(datatype.getPackage());
			String nameString= Util.nonNull(datatype.getName());
			return packageString + "." + nameString;
		}
		return super.getString(datatype);
	}
}
