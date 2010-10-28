package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.actions.OrganizePropertiesAction;


public class DataObjectSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_REQUIRED= "Required For Start",
							   DISPLAY_PRODUCED= "Produced At Completion",
							   DISPLAY_STATE= "State",
							   
							   DISPLAY_ORG_PROP= "Properties...";
							   
    protected DataObject dataObject;
    
    private Text stateText;
    private Button requiredButton;
    private Button producedButton;
    private Button orgPropButton;
    

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getDataObject();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof DataObject) {
        	this.dataObject= (DataObject) eObject;
        }
    }

    @Override
 	protected void internalRefresh() {
    	super.internalRefresh();
        stateText.setText(nonNull(dataObject.getState()));
        producedButton.setSelection(dataObject.isProducedAtCompletion());
        requiredButton.setSelection(dataObject.isRequiredForStart());
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        CLabel label;

        // organize buttons
        orgPropButton = addButton(DISPLAY_ORG_PROP);
        
        //checkBoxes
        requiredButton= FormLayoutUtil.addButton(composite, DISPLAY_REQUIRED, SWT.CHECK, lastControl, 0, null);
        producedButton= FormLayoutUtil.addButton(composite, DISPLAY_PRODUCED, SWT.CHECK, lastControl, requiredButton, null);
        requiredButton.addSelectionListener(this);
        producedButton.addSelectionListener(this);
        
        //state
        label= FormLayoutUtil.addLabel(composite, DISPLAY_STATE, requiredButton, 0);
        stateText= FormLayoutUtil.addText(composite, requiredButton, label, 100, SWT.MULTI | SWT.V_SCROLL);
        ((FormData)stateText.getLayoutData()).height= 50;
        stateText.addFocusListener(this);
    }
    
    public void focusLost(FocusEvent e) {
    	super.focusLost(e);
    	if (e.getSource().equals(stateText)) {
    		setPropertyValue(dataObject, pack.getDataObject_State(), nullIfEmpty(stateText.getText()));
    	}
    }
    
    public void widgetSelected(SelectionEvent e) {
    	super.widgetSelected(e);
    	Object src= e.getSource();
    	if (src.equals(orgPropButton)) {
			new OrganizePropertiesAction().run(dataObject);
    	}
    	if (src.equals(requiredButton)) {
    		setPropertyValue(dataObject, pack.getDataObject_RequiredForStart(), requiredButton.getSelection());
    	}
    	if (src.equals(producedButton)) {
    		setPropertyValue(dataObject, pack.getDataObject_ProducedAtCompletion(), producedButton.getSelection());
    	}
    }

}