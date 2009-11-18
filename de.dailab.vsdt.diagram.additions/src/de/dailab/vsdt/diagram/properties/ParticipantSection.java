package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.ParticipantType;
import de.dailab.vsdt.VsdtPackage;


public class ParticipantSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_TYPE= "Type",
	   						   DISPLAY_TYPE_ROLE= "Role",
	   						   DISPLAY_TYPE_ENTITY= "Entity";
	
    private Button typeRoleButton;
    private Button typeEntityButton;

    protected Participant participant;

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getParticipant();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof Participant) {
        	this.participant= (Participant) eObject;
        }
    }

    @Override
 	protected void internalRefresh() {
    	typeRoleButton.setSelection(participant.getType() == ParticipantType.ROLE);
    	typeEntityButton.setSelection(participant.getType() == ParticipantType.ENTITY);
    }
    
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        CLabel label;
        
        label= FormLayoutUtil.addLabel(composite, DISPLAY_TYPE, 0, 0);
        typeRoleButton= FormLayoutUtil.addButton(composite, DISPLAY_TYPE_ROLE, SWT.RADIO, 0, label, null);
        typeEntityButton= FormLayoutUtil.addButton(composite, DISPLAY_TYPE_ENTITY, SWT.RADIO, 0, typeRoleButton, null);
        typeRoleButton.addSelectionListener(this);
        typeEntityButton.addSelectionListener(this);
    }
    
    public void widgetSelected(SelectionEvent e) {
    	Object src= e.getSource();
    	if (src.equals(typeRoleButton)) {
    		setPropertyValue(participant, pack.getParticipant_Type(), ParticipantType.ROLE);
    	}
    	if (src.equals(typeEntityButton)) {
    		setPropertyValue(participant, pack.getParticipant_Type(), ParticipantType.ENTITY);
    	}
    }
    
    public void focusLost(FocusEvent e) {
    }
}