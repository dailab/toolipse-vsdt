package de.dailab.vsdt.diagram.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.dialogs.AbstractOrganizeElementsDialog;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Parameter;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * A dialog used for organizing Parameters of a BPMN model.
 * 
 * Parameters are similar to Properties, with the difference that their scope is
 * the entire VSDT diagram (with all embedded BPMN diagrams) and that it can not
 * be set with an assignment but only in this dialog itself.
 * 
 * @author kuester
 */
public class OrganizeParametersDialog extends AbstractOrganizeElementsDialog<Parameter> {

	private static final String LABEL_KEY= "Key";
	private static final String LABEL_VALUE= "Value";
	private static final String LABEL_DESCRIPTION= "Description";
	
	/** key input field */
	private Text keyText;
	
	/** value input field */
	private Text valueText;
	
	/** description input field */
	private Text descriptionText;
	
	
	@Override
	public String getElementName() {
		return "Parameter";
	}
	
	/**
	 * create a new Dialog Instance
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 */
	public OrganizeParametersDialog(Shell parentShell, EObject parentElement) {
		super(parentShell, parentElement, true, 4);

		BusinessProcessSystem bps= null;
		if (parentElement instanceof BusinessProcessSystem) {
			bps= (BusinessProcessSystem) parentElement;
		} else if (parentElement instanceof BusinessProcessDiagram) {
			bps= (BusinessProcessSystem) ((BusinessProcessDiagram) parentElement).getParent();
		}
		if (bps != null) {
			elements= ((BusinessProcessSystem) parentElement).getParameters();
		} else {
			throw new IllegalArgumentException("Parent element must be of type BusinessProcessSystem");
		}
	}
	
	@Override
	protected void createEditGroupControls(Group editGroup) {

		new Label(editGroup,SWT.NONE).setText(LABEL_KEY);
		keyText= new Text(editGroup,SWT.BORDER);
		keyText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		keyText.addModifyListener(this);

		new Label(editGroup,SWT.NONE).setText(LABEL_VALUE);
		valueText= new Text(editGroup,SWT.BORDER);
		valueText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		valueText.addModifyListener(this);
		
		new Label(editGroup,SWT.NONE).setText(LABEL_DESCRIPTION);
		descriptionText= new Text(editGroup,SWT.BORDER);
		descriptionText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		descriptionText.addModifyListener(this);
	}

	@Override
	protected Parameter createNewElement() {
		return VsdtFactory.eINSTANCE.createParameter();
	}
	
	@Override
	protected Control getElementToFocus() {
		return keyText;
	}

	@Override
	protected void updateElementFromEditGroup(Parameter parameter) {
		if (parameter != null) {
			parameter.setKey(Util.nullIfEmpty(keyText.getText()));
			parameter.setValue(Util.nullIfEmpty(valueText.getText()));
			parameter.setDescription(Util.nullIfEmpty(descriptionText.getText()));
		}
	}
	
	@Override
	protected void refreshEditGroup() {
		Parameter parameter = getSelectedElement();
		if (parameter != null) {
			keyText.setText(Util.nonNull(parameter.getKey()));
			valueText.setText(Util.nonNull(parameter.getValue()));
			descriptionText.setText(Util.nonNull(parameter.getDescription()));
		}
	}
		
	@Override
	protected String getString(Parameter parameter) {
		if (parameter != null) {
			String keyString= Util.nonNull(parameter.getKey());
			String valueString= Util.nonNull(parameter.getValue());
			return VsdtHelper.ESCAPE_PARAMETER + keyString + " = " + valueString;
		}
		return super.getString(parameter);
	}
}
