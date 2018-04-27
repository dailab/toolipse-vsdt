package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.actions.CleanupAction;
import de.dailab.vsdt.diagram.actions.OrganizeElementsAction;


public class BusinessProcessDiagramSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_ORG_IMPL="Services...",
							   DISPLAY_ORG_MSG= "Message Channels...",
							   DISPLAY_ORG_DATA= "Data Types...",
							   DISPLAY_ORG_PARAM= "Parameters...",
							   DISPLAY_CLEANUP = "Cleanup Diagram...";
	
    protected BusinessProcessDiagram bpd;

    private Button orgImplButton;
    private Button orgMsgButton;
    private Button orgDataButton;
    private Button orgParamButton;
    private Button cleanupButton;
    
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
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        
        // organize buttons
        orgImplButton = addButton(DISPLAY_ORG_IMPL);
        orgMsgButton = addButton(DISPLAY_ORG_MSG);
        orgDataButton = addButton(DISPLAY_ORG_DATA);
        orgParamButton = addButton(DISPLAY_ORG_PARAM);
        cleanupButton = addButton(DISPLAY_CLEANUP);
    }
    
    public void widgetSelected(SelectionEvent e) {
    	super.widgetSelected(e);
    	Object src= e.getSource();
    	if (src.equals(orgImplButton)) {
			OrganizeElementsAction.getServicesAction().run(bpd.getParent());
    	}
    	if (src.equals(orgMsgButton)) {
			OrganizeElementsAction.getMessageChannelAction().run(bpd.getParent());
    	}
    	if (src.equals(orgDataButton)) {
			OrganizeElementsAction.getDataTypesAction().run(bpd.getParent());
    	}
    	if (src.equals(orgParamButton)) {
			OrganizeElementsAction.getParametersAction().run(bpd.getParent());
    	}
    	if (src.equals(cleanupButton)) {
    		new CleanupAction().run(bpd.getParent());
    	}
    }

}