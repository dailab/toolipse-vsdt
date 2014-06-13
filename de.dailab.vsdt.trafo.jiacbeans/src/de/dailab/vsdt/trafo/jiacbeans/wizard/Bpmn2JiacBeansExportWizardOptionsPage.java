package de.dailab.vsdt.trafo.jiacbeans.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;

public class Bpmn2JiacBeansExportWizardOptionsPage extends BpmnExportWizardOptionsPage {
	
	public static final String LABEL_PARENT_PACKAGE= "Parent Package (optional)";
	public static final String LABEL_CREATE_SUBPACKAGE = "Create sub-packages for individual roles";
	public static final String DEFAULT_PARENT_PACKAGE = "";
	public static final boolean DEFAULT_CREATE_SUBPACKAGE = true;
	
	/*
	 * static, so the value is preserved between exports
	 * might also store this in preferences or in an attribute of the diagram itself
	 */
	private static String parentPackage = DEFAULT_PARENT_PACKAGE;
	private static boolean createSubpackage = DEFAULT_CREATE_SUBPACKAGE;
	
	public Bpmn2JiacBeansExportWizardOptionsPage(String title, IStructuredSelection selection) {
		super(title, selection);
	}
	
	@Override
	protected void createOptionsGroup(Composite parent) {
		super.createOptionsGroup(parent);
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout= new GridLayout(2, false);
		composite.setLayout(gridLayout);
		
		final Label label = new Label(composite, SWT.NONE);
		label.setText(LABEL_PARENT_PACKAGE);
		
		final Text parentPackageText = new Text(composite, SWT.BORDER);
		parentPackageText.setText(parentPackage);
		parentPackageText.setLayoutData(new GridData(300, -1));
		parentPackageText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				parentPackage = parentPackageText.getText();
			}
		});
		
		final Button subpackageCheck= new Button(composite, SWT.CHECK);
		subpackageCheck.setText(LABEL_CREATE_SUBPACKAGE);
		subpackageCheck.setSelection(createSubpackage);
		subpackageCheck.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				createSubpackage = subpackageCheck.getSelection();
			}
		});
	}

	public static String getParentPackage() {
		return parentPackage;
	}
	
	public static boolean getCreateSubpackages() {
		return createSubpackage;
	}
	
}
