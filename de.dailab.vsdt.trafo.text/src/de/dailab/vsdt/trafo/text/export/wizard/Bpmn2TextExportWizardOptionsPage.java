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
	
	public static final String LABEL_SELECT_FORMAT= "Select format:";
	public static final String DEFAULT_FORMAT= Bpmn2TextElementMapping.textFormat;
	private String selectedFormat= DEFAULT_FORMAT;
	
	public static final String LABEL_LONG_DOC= "Create separate paragraphs for activity documentation";
	public static final boolean DEFAULT_LONG_DOC= false;
	private boolean createLongDocumentation= DEFAULT_LONG_DOC;
	
	public static final String LABEL_SCREENSHOT= "Integrate pictures of the diagrams (generation of pictures can take a few seconds)";
	public static final boolean DEFAULT_SCREENSHOT= false;
	private boolean integrateScreenshot= DEFAULT_SCREENSHOT;
	
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
		createFormatButton(composite, Bpmn2TextElementMapping.FORMAT_PLAIN);
		createFormatButton(composite, Bpmn2TextElementMapping.FORMAT_HTML);
		createFormatButton(composite, Bpmn2TextElementMapping.FORMAT_LATEX);
		
		final Button longDescButton= new Button(parent, SWT.CHECK);
		longDescButton.setText(LABEL_LONG_DOC);
		longDescButton.setSelection(DEFAULT_LONG_DOC);
		longDescButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				createLongDocumentation= longDescButton.getSelection();
			}
		});
		
		final Button screenshotButton= new Button(parent, SWT.CHECK);
		screenshotButton.setText(LABEL_SCREENSHOT);
		screenshotButton.setSelection(DEFAULT_SCREENSHOT);
		screenshotButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				integrateScreenshot= screenshotButton.getSelection();
			}
		});
	}
	
	private void createFormatButton(Composite parent, String label) {
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
	
	public boolean isCreateLongDocumentation() {
		return createLongDocumentation;
	}

	public boolean isIntegrateScreenshot() {
		return integrateScreenshot;
	}
	
}
