package de.dailab.vsdt.trafo.jiacbeans.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import de.dailab.vsdt.trafo.wizard.BpmnExportWizardOptionsPage;

public class Bpmn2JiacBeansExportWizardOptionsPage extends BpmnExportWizardOptionsPage {
	
	public static final String LABEL_MAMS_SPECIALS= "Use MAMS Specials";
	public static final String LABEL_GROUPING= "Grouping of Services";
	public static final String LABEL_GROUPING_USECASE= "Group Services by Use Case";
	public static final String LABEL_GROUPING_ROLE= "Group Services by Role";
	
	public static final boolean DEFAULT_MAMS_SPECIALS= false;
	public static final boolean DEFAULT_GROUP_BY_USECASE= false;
	
	private boolean useMAMSspecials= DEFAULT_MAMS_SPECIALS;
	private boolean groupByUsecase= DEFAULT_GROUP_BY_USECASE;
	
	public Bpmn2JiacBeansExportWizardOptionsPage(String title, IStructuredSelection selection) {
		super(title,selection);
	}
	
	@Override
	protected void createOptionsGroup(Composite parent) {
		super.createOptionsGroup(parent);
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout gridLayout= new GridLayout(1,false);
		composite.setLayout(gridLayout);
		
		final Button mams= new Button(composite, SWT.CHECK);
		mams.setText(LABEL_MAMS_SPECIALS);
		mams.setSelection(DEFAULT_MAMS_SPECIALS);
		mams.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				useMAMSspecials= mams.getSelection();
			}
		});

		Group buttonGroup= new Group(composite, SWT.NONE);
		buttonGroup.setText(LABEL_GROUPING);
		buttonGroup.setLayout(new GridLayout(2, true));
		
		final Button role= new Button(buttonGroup, SWT.RADIO);
		role.setText(LABEL_GROUPING_ROLE);
		role.setSelection(! DEFAULT_GROUP_BY_USECASE);
		role.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				groupByUsecase= ! role.getSelection();
			}
		});
		
		final Button usecase= new Button(buttonGroup, SWT.RADIO);
		usecase.setText(LABEL_GROUPING_USECASE);
		usecase.setSelection(DEFAULT_GROUP_BY_USECASE);
		usecase.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				groupByUsecase= usecase.getSelection();
			}
		});
		
	}
	
	public boolean isUseMAMSSpecials() {
		return useMAMSspecials;
	}
	
	public boolean isGroupByUsecase() {
		return groupByUsecase;
	}
	
}
