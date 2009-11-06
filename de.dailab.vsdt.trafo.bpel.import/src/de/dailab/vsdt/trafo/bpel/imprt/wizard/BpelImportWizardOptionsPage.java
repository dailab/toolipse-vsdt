package de.dailab.vsdt.trafo.bpel.imprt.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import de.dailab.vsdt.trafo.wizard.BpmnTrafoWizardOptionsPage;

public class BpelImportWizardOptionsPage extends BpmnTrafoWizardOptionsPage {
	
	public BpelImportWizardOptionsPage(String pageName, 
			IStructuredSelection selection) {
		super(pageName, selection);
	}
	
	@Override
	public String getDescription() {
		return "Select the BPEL model file to be imported to BPMN";
	}
	
	@Override
	public String getExtension() {
		return "bpel";
	}
	
	public static final String LABEL_IGNORE_EMPTY= "Ignore Empty Activities";
	
	public static final boolean DEFAULT_IGNORE_EMPTY= false;
	
	private boolean ignoreEmpty= DEFAULT_IGNORE_EMPTY;
	
	@Override
	protected void createOptionsGroup(Composite parent) {
		super.createOptionsGroup(parent);
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout= new GridLayout(1,false);
		composite.setLayout(gridLayout);
		
		final Button button1= new Button(composite, SWT.CHECK);
		button1.setText(LABEL_IGNORE_EMPTY);
		button1.setSelection(DEFAULT_IGNORE_EMPTY);
		button1.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent e) {
				ignoreEmpty= button1.getSelection();
			}
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		// XXX this does not work properly yet 
//		button1.setEnabled(false);
	}
	
	public boolean isIgnoreEmpty() {
		return ignoreEmpty;
	}
	
}
