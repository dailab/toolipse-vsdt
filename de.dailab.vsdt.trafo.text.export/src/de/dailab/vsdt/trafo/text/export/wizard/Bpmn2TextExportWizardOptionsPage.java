package de.dailab.vsdt.trafo.text.export.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.dailab.vsdt.trafo.text.export.stages.Bpmn2TextElementMapping;
import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;

public class Bpmn2TextExportWizardOptionsPage extends BpmnExportWizardOptionsPage {
	
	public static final String LABEL_SELECT_FORMAT= "Select Format";
	
	public static final String DEFAULT_FORMAT= Bpmn2TextElementMapping.textFormat;
	
	private String selectedFormat= DEFAULT_FORMAT;
	
	public Bpmn2TextExportWizardOptionsPage(String title, IStructuredSelection selection) {
		super(title,selection);
	}
	
	@Override
	protected void createOptionsGroup(Composite parent) {
		// do not create super class's group
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout= new GridLayout(4,false);
		composite.setLayout(gridLayout);
		
		Label label= new Label(composite, SWT.NONE);
		label.setText(LABEL_SELECT_FORMAT);

		createButton(composite, Bpmn2TextElementMapping.FORMAT_PLAIN);
		createButton(composite, Bpmn2TextElementMapping.FORMAT_HTML);
		createButton(composite, Bpmn2TextElementMapping.FORMAT_LATEX);
	}
	
	private void createButton(Composite parent, String label) {
		final Button button= new Button(parent, SWT.RADIO);
		button.setText(label);
		button.setSelection(DEFAULT_FORMAT.equals(label));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedFormat= button.getText();
			}
		});
	}
	
	public String getSelectedFormat() {
		return selectedFormat;
	}
	
}
