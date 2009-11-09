package de.dailab.vsdt.trafo.bpel.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;

public class Bpmn2BpelExportWizardOptionsPage extends BpmnExportWizardOptionsPage {
	
	public static final String LABEL_USE_SUFFIXES= "Use Suffixes (e.g. 'someMessage_MessageData')";
	
	public static final boolean DEFAULT_USE_SUFFIXES= true;
	
	private boolean useSuffixes= DEFAULT_USE_SUFFIXES;
	
	public Bpmn2BpelExportWizardOptionsPage(String title, IStructuredSelection selection) {
		super(title,selection);
	}
	
	@Override
	protected void createOptionsGroup(Composite parent) {
		super.createOptionsGroup(parent);
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout= new GridLayout(1,false);
		composite.setLayout(gridLayout);
		
		final Button button1= new Button(composite, SWT.CHECK);
		button1.setText(LABEL_USE_SUFFIXES);
		button1.setSelection(DEFAULT_USE_SUFFIXES);
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				useSuffixes= button1.getSelection();
			}
		});
	}
	
	public boolean isUseSuffixes() {
		return useSuffixes;
	}

}
