package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.VsdtPackage;


public class IdObjectSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_NAME= "Name",
							   DISPLAY_DOCUMENTATION= "Documentation",
							   DISPLAY_ID= "Id",
							   DISPLAY_GENERATE_ID= "Generate ID";

    protected IdObject idObject;
    
	private Text nameText;
    private Text idText;
    private Text docText;

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getIdObject();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof IdObject) {
        	this.idObject= (IdObject) eObject;
        }
    }

    @Override
 	protected void internalRefresh() {
    	nameText.setText(nonNull(idObject.getName()));
        idText.setText(nonNull(idObject.getId()));
        docText.setText(nonNull(idObject.getDocumentation()));
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        CLabel label;
        
        // name
        label = FormLayoutUtil.addLabel(composite, DISPLAY_NAME, 0, 0);
        nameText= FormLayoutUtil.addText(composite, 0, label, 50, SWT.NONE);
        nameText.addFocusListener(this); 

        // id
        label = FormLayoutUtil.addLabel(composite, "Identifier", 0, 50);
        idText= FormLayoutUtil.addText(composite, 0, label, 100, SWT.NONE);
        idText.setEditable(false);
        idText.addFocusListener(this);
        
        // documentation
        label = FormLayoutUtil.addLabel(composite, DISPLAY_DOCUMENTATION, nameText, 0);
        docText= FormLayoutUtil.addText(composite, nameText, label, 100, SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
        ((FormData) docText.getLayoutData()).height= 50;
        // improve text wrap
        ((FormData) docText.getLayoutData()).width= composite.getBounds().width;
        docText.addFocusListener(this);
    }
    
    public void widgetSelected(SelectionEvent e) {
    }
    
    public void focusLost(FocusEvent e) {
    	if (e.getSource().equals(nameText)) {
    		setPropertyValue(idObject, pack.getIdObject_Name(), nullIfEmpty(nameText.getText()));
    	}
    	if (e.getSource().equals(idText)) {
    		setPropertyValue(idObject, pack.getIdObject_Id(), nullIfEmpty(idText.getText()));
		}
    	if (e.getSource().equals(docText)) {
    		setPropertyValue(idObject, pack.getIdObject_Documentation(), nullIfEmpty(docText.getText()));
		}
    }

}