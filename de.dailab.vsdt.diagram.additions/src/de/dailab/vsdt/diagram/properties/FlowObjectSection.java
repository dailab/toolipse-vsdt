package de.dailab.vsdt.diagram.properties;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.actions.OrganizeElementsAction;

public abstract class FlowObjectSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_ORG_ASS= "Assignments...";
	
    protected Button orgAssButton;

    protected FlowObject flowObject;
    

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof FlowObject) {
        	this.flowObject= (FlowObject) eObject;
        }
    }

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
     
        // organize assignments
        orgAssButton = addButton(DISPLAY_ORG_ASS);
    }

    public void widgetSelected(SelectionEvent e) {
    	super.widgetSelected(e);
    	Object src= e.getSource();
    	if (src.equals(orgAssButton)) {
			OrganizeElementsAction.getAssignmentsAction().run(flowObject);
    	}
    }
}