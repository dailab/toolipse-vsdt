package de.dailab.vsdt.trafo.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

/**
 * Options page for the abstract VSDT export wizard.
 *
 * @author kuester
 */
public class BpmnExportWizardOptionsPage extends BpmnTrafoWizardOptionsPage {

	public static final String LABEL_TRANSLATE_EXPRESSIONS= "Translate Expressions given in the VSDT Expression Language (VXL)";
	public static final String LABEL_SUBST_PROP_GT= "For other Expressions, find and Replace Property Accessors (e.g. '$someProperty.someQuery + 1')";
	
	public static final boolean DEFAULT_TRANSLATE_EXPRESSIONS= true;
	public static final boolean DEFAULT_SUBST_PROP_GT= true;
	
	private boolean translateExpressions= DEFAULT_TRANSLATE_EXPRESSIONS;
	private boolean substitutePropertyGetters= DEFAULT_SUBST_PROP_GT;
	
	public BpmnExportWizardOptionsPage(String pageName, 
			IStructuredSelection selection) {
		super(pageName, selection);
	}
	
	@Override
	public String getExtension() {
		return "vsdtd";
	}
	
	@Override
	public String getDescription() {
		return "Select VSDT Diagram file to be exported.";
	}
	
	@Override
	protected void createOptionsGroup(Composite parent) {
		super.createOptionsGroup(parent);
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout= new GridLayout(1,false);
		composite.setLayout(gridLayout);
		
		final Button button1= new Button(composite, SWT.CHECK);
		button1.setText(LABEL_TRANSLATE_EXPRESSIONS);
		button1.setSelection(DEFAULT_TRANSLATE_EXPRESSIONS);
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				translateExpressions= button1.getSelection();
			}
		});
		
		final Button button2= new Button(composite, SWT.CHECK);
		button2.setText(LABEL_SUBST_PROP_GT);
		button2.setSelection(DEFAULT_SUBST_PROP_GT);
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				substitutePropertyGetters= button2.getSelection();
			}
		});
	}
	
	public boolean isSubstitutePropertyGetters() {
		return substitutePropertyGetters;
	}
	
	public boolean isTranslateExpressions() {
		return translateExpressions;
	}
	
}
