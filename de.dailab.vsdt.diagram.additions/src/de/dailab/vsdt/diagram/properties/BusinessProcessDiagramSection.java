package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.actions.OrganizeDataTypesAction;
import de.dailab.vsdt.diagram.actions.OrganizeImplementationsAction;
import de.dailab.vsdt.diagram.actions.OrganizeMessagesAction;


public class BusinessProcessDiagramSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_ORG_IMPL="Implementations...",
							   DISPLAY_ORG_MSG= "Messages...",
							   DISPLAY_ORG_DATA= "Data Types...";;
	
    protected BusinessProcessDiagram bpd;

    private Button orgImplButton;
    private Button orgMsgButton;
    private Button orgDataButton;
    
    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getBusinessProcessDiagram();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof BusinessProcessDiagram) {
        	this.bpd= (BusinessProcessDiagram) eObject;
        }
    }

    @Override
 	protected void internalRefresh() {
    	// nothing to refresh
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
//        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        
        // organize buttons
//        orgImplButton= FormLayoutUtil.addButton(composite, DISPLAY_ORG_IMPL, 0, lastControl, null, 100);
//        orgImplButton = new Button(buttonComposite, SWT.NONE);
//        orgImplButton.setText(DISPLAY_ORG_IMPL);
//        orgImplButton.addSelectionListener(this);
        orgImplButton = addButton(DISPLAY_ORG_IMPL);
        
//        orgMsgButton= FormLayoutUtil.addButton(composite, DISPLAY_ORG_MSG, 0, lastControl, null, orgImplButton);
//        orgMsgButton = new Button(buttonComposite, SWT.NONE);
//        orgMsgButton.setText(DISPLAY_ORG_MSG);
//        orgMsgButton.addSelectionListener(this);
        orgMsgButton = addButton(DISPLAY_ORG_MSG);
        
//        orgDataButton= FormLayoutUtil.addButton(composite, DISPLAY_ORG_DATA, 0, lastControl, null, orgMsgButton);
//        orgDataButton = new Button(buttonComposite, SWT.NONE);
//        orgDataButton.setText(DISPLAY_ORG_DATA);
//        orgDataButton.addSelectionListener(this);
        orgDataButton = addButton(DISPLAY_ORG_DATA);
    }
    
    public void focusLost(FocusEvent e) {
    }

    public void widgetSelected(SelectionEvent e) {
    	Object src= e.getSource();
    	if (src.equals(orgImplButton)) {
			new OrganizeImplementationsAction().run(bpd.getParent());
    	}
    	if (src.equals(orgMsgButton)) {
			new OrganizeMessagesAction().run(bpd.getParent());
    	}
    	if (src.equals(orgDataButton)) {
			new OrganizeDataTypesAction().run(bpd.getParent());
    	}
    }

}