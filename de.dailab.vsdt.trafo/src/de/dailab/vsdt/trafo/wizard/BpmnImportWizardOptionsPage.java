package de.dailab.vsdt.trafo.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Options page for the abstract VSDT import wizard.
 *
 * @author kuester
 */
public abstract class BpmnImportWizardOptionsPage extends BpmnTrafoWizardOptionsPage {

	public static final String LABEL_CREATE_MODEL_FILE= "Create only a Model file";
	public static final String LABEL_CREATE_DIAGRAM_FILE= "Create a Diagram file for the generated model";

	public static final boolean DEFAULT_CREATE_DIAGRAM_FILE= true;
	
	private boolean createDiagramFile= DEFAULT_CREATE_DIAGRAM_FILE;
	
	public BpmnImportWizardOptionsPage(String title, IStructuredSelection selection) {
		super(title,selection);
	}
	
	@Override
	protected void createOptionsGroup(Composite parent) {
		super.createOptionsGroup(parent);
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout= new GridLayout(1,false);
		composite.setLayout(gridLayout);
		
		Composite buttonGroup= new Composite(composite, SWT.NONE);
		buttonGroup.setLayout(new GridLayout(2, false));
		
		final Button createDiagram= new Button(buttonGroup, SWT.RADIO);
		createDiagram.setText(LABEL_CREATE_DIAGRAM_FILE);
		createDiagram.setSelection(DEFAULT_CREATE_DIAGRAM_FILE);
		createDiagram.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				createDiagramFile= createDiagram.getSelection();
			}
		});

		final Button createModel= new Button(buttonGroup, SWT.RADIO);
		createModel.setText(LABEL_CREATE_MODEL_FILE);
		createModel.setSelection(! DEFAULT_CREATE_DIAGRAM_FILE);
		createModel.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				createDiagramFile= ! createModel.getSelection();
			}
		});
	}
	
	public boolean isCreateDiagramFile() {
		return createDiagramFile;
	}
	
	
}
