package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;


public class GatewaySection extends AbstractVsdtPropertySection
implements SelectionListener {
	
	public static final String DISPLAY_TYPE= "Gateway Type",
							   DISPLAY_TYPE_GROUP= "Gateway Type Attributes",
							   
							   DISPLAY_XOR_EVENT_INSTANTIATE= "Instantiate",
							   DISPLAY_COMPLEX_INCOMINGCOND= "Incoming Cond.",
							   DISPLAY_COMPLEX_OUTGOINGCOND= "Outgoing Cond.";
							   
    protected Gateway gateway;

    private Combo typeCombo;
    private ExpressionComposite complexIncomingCondText;
    private ExpressionComposite complexOutgoingCondText;
    
    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getGateway();
    }
    
    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof Gateway) {
        	this.gateway= (Gateway) eObject;
        	complexIncomingCondText.setOwnerAndFeature(gateway, pack.getGateway_IncomingCondition());
        	complexOutgoingCondText.setOwnerAndFeature(gateway, pack.getGateway_OutgoingCondition());
        }
    }

    @Override
 	protected void internalRefresh() {
    	super.internalRefresh();
    	typeCombo.select(gateway.getGatewayType().getValue());
    	
    	complexIncomingCondText.setEnabled(gateway.getGatewayType() == GatewayType.COMPLEX);
    	complexOutgoingCondText.setEnabled(gateway.getGatewayType() == GatewayType.COMPLEX);
    	
		complexIncomingCondText.setText(getExpression(gateway.getIncomingCondition()));
		complexOutgoingCondText.setText(getExpression(gateway.getOutgoingCondition()));
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        CLabel label;

        // activity type and attributes
        label= FormLayoutUtil.addLabel(composite, DISPLAY_TYPE, lastControl, 0);
        typeCombo= FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, lastControl, label, 50);
        typeCombo.addSelectionListener(this);
        for (GatewayType gatewayType : GatewayType.values()) {
        	typeCombo.add(gatewayType.getLiteral());
        }
        
        // gateway type attributes
        Group attributesGroup= FormLayoutUtil.addGroup(composite, DISPLAY_TYPE_GROUP, typeCombo, 0, 100);
        
    	label= FormLayoutUtil.addLabel(attributesGroup, DISPLAY_COMPLEX_INCOMINGCOND, lastControl, 0);
    	complexIncomingCondText= addExpressionComposite(attributesGroup, lastControl, label, 50);

    	label= FormLayoutUtil.addLabel(attributesGroup, DISPLAY_COMPLEX_OUTGOINGCOND, lastControl, 50);
    	complexOutgoingCondText= addExpressionComposite(attributesGroup, lastControl, label, 100);
    }
    
    
    @Override
    public void widgetSelected(SelectionEvent e) {
    	super.widgetSelected(e);
    	Object src= e.getSource();
    	if (src.equals(typeCombo)) {
    		setPropertyValue(gateway, pack.getGateway_GatewayType(), GatewayType.get(typeCombo.getSelectionIndex()));
    	}
    	refresh();
    }

    
}