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

import de.dailab.common.gmf.ui.FormLayoutUtil;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.DirectionType;
import de.dailab.vsdt.VsdtPackage;


public class AssociationSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_DIRECTION= "Direction",
	   						   DISPLAY_DIRECTION_NONE= "None",
	   						   DISPLAY_DIRECTION_ONE= "One",
	   						   DISPLAY_DIRECTION_BOTH= "Both";
	
    private Button dirNoneButton;
    private Button dirOneButton;
    private Button dirBothButton;

    protected Association association;

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getAssociation();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof Association) {
        	this.association= (Association) eObject;
        }
    }

    @Override
 	protected void internalRefresh() {
    	dirNoneButton.setSelection(association.getDirection() == DirectionType.NONE);
    	dirOneButton.setSelection(association.getDirection() == DirectionType.ONE);
    	dirBothButton.setSelection(association.getDirection() == DirectionType.BOTH);
    }
    
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        CLabel label;
        
        label= FormLayoutUtil.addLabel(composite, DISPLAY_DIRECTION, 0, 0);
        dirNoneButton= FormLayoutUtil.addButton(composite, DISPLAY_DIRECTION_NONE, SWT.RADIO, 0, label, null);
        dirOneButton= FormLayoutUtil.addButton(composite, DISPLAY_DIRECTION_ONE, SWT.RADIO, 0, dirNoneButton, null);
        dirBothButton= FormLayoutUtil.addButton(composite, DISPLAY_DIRECTION_BOTH, SWT.RADIO, 0, dirOneButton, null);
        dirNoneButton.addSelectionListener(this);
        dirOneButton.addSelectionListener(this);
        dirBothButton.addSelectionListener(this);
    }
    
    public void widgetSelected(SelectionEvent e) {
    	Object src= e.getSource();
    	if (src.equals(dirNoneButton)) {
    		setPropertyValue(association, pack.getAssociation_Direction(), DirectionType.NONE);
    	}
    	if (src.equals(dirOneButton)) {
    		setPropertyValue(association, pack.getAssociation_Direction(), DirectionType.ONE);
    	}
    	if (src.equals(dirBothButton)) {
    		setPropertyValue(association, pack.getAssociation_Direction(), DirectionType.BOTH);
    	}
    }
    
    public void focusLost(FocusEvent e) {
    }
}