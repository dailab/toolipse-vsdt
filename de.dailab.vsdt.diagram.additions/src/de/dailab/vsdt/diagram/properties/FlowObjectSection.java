package de.dailab.vsdt.diagram.properties;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.actions.OrganizeAssignmentsAction;

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

    protected void addAssignmentButton(Composite parent) {
        // organize assignments
        orgAssButton= FormLayoutUtil.addButton(parent, DISPLAY_ORG_ASS, 0, 0, null, 100);
        orgAssButton.addSelectionListener(this);
    }

    public void widgetSelected(SelectionEvent e) {
    	Object src= e.getSource();
    	if (src.equals(orgAssButton)) {
			new OrganizeAssignmentsAction().run(flowObject);
    	}
    }
}