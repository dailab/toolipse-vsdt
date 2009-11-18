package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
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


public class GatewaySection extends FlowObjectSection
implements SelectionListener {
	
	public static final String DISPLAY_TYPE= "Gateway Type",
							   DISPLAY_TYPE_GROUP= "Gateway Type Attributes",
							   
							   DISPLAY_XOR_DATA_MARKERVIS= "Marker Visible",
							   DISPLAY_XOR_EVENT_INSTANTIATE= "Instantiate",
							   DISPLAY_COMPLEX_INCOMINGCOND= "Incoming Condition",
							   DISPLAY_COMPLEX_OUTGOINGCOND= "Outgoing Condition";
							   
//							   DISPLAY_GATES= "Gates",
//							   DISPLAY_GATE_NAME= "Name",
//							   DISPLAY_GATE_CONDITION= "Condition",
//							   DISPLAY_GATE_DEFAULT= "Default";
//							   DISPLAY_GATE_ORG_ASS= "Gate Assignments...";
							   
    protected Gateway gateway;

    private Combo typeCombo;
    
    private Button xorMarkerButton;
    
    private Button xorEventInstantiateButton;
    
    private ExpressionComposite complexIncomingCondText;
    private ExpressionComposite complexOutgoingCondText;
    
//    private List gateList;
//    private Text gateNameText;
//    private Text gateConditionText;
//    private Button gateDefaultButton;
//    private Button gateOrgAssButton;
    

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
    	typeCombo.select(gateway.getGatewayType().getValue());
    	
    	xorMarkerButton.setEnabled(gateway.getGatewayType() == GatewayType.XOR_DATA);
    	xorEventInstantiateButton.setEnabled(gateway.getGatewayType() == GatewayType.XOR_EVENT);
    	complexIncomingCondText.setEnabled(gateway.getGatewayType() == GatewayType.COMPLEX);
    	complexOutgoingCondText.setEnabled(gateway.getGatewayType() == GatewayType.COMPLEX);
    	
		xorMarkerButton.setSelection(gateway.isMarkerVisible());
		xorEventInstantiateButton.setSelection(gateway.isInstantiate());
		complexIncomingCondText.setText(getExpression(gateway.getIncomingCondition()));
		complexOutgoingCondText.setText(getExpression(gateway.getOutgoingCondition()));

//		fillGateList();
//    	Gate gate= getSelectedGate();
//    	if (gate != null) {
//    		gateNameText.setText(nonNull(gate.getName()));
//    	}
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        CLabel label;

        addAssignmentButton(composite);
        
        // activity type and attributes
        label= FormLayoutUtil.addLabel(composite, DISPLAY_TYPE, 0, 0);
        typeCombo= FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, 0, label, 50);
        typeCombo.addSelectionListener(this);
        for (GatewayType gatewayType : GatewayType.values()) {
        	typeCombo.add(gatewayType.getLiteral());
        }
        
        // gateway type attributes
        Group attributesGroup= FormLayoutUtil.addGroup(composite, DISPLAY_TYPE_GROUP, typeCombo, 0, 50);
        
    	xorMarkerButton= FormLayoutUtil.addButton(attributesGroup, DISPLAY_XOR_DATA_MARKERVIS, SWT.CHECK, 0, 0, null);
    	xorMarkerButton.addSelectionListener(this);

    	xorEventInstantiateButton= FormLayoutUtil.addButton(attributesGroup, DISPLAY_XOR_EVENT_INSTANTIATE, SWT.CHECK, xorMarkerButton, 0, null);
    	xorEventInstantiateButton.addSelectionListener(this);
    	
    	label= FormLayoutUtil.addLabel(attributesGroup, DISPLAY_COMPLEX_INCOMINGCOND, xorEventInstantiateButton, 0);
    	complexIncomingCondText= addExpressionComposite(attributesGroup, xorEventInstantiateButton, label, 100);
//    	((FormData) complexIncomingCondText.getLayoutData()).height= 35;
//    	complexIncomingCondText.addFocusListener(this);
    	label= FormLayoutUtil.addLabel(attributesGroup, DISPLAY_COMPLEX_OUTGOINGCOND, complexIncomingCondText, 0);
    	complexOutgoingCondText= addExpressionComposite(attributesGroup, complexIncomingCondText, label, 100);
//    	((FormData) complexOutgoingCondText.getLayoutData()).height= 35;
//    	complexOutgoingCondText.addFocusListener(this);
		
        // gate list
//        Group gateGroup= FormLayoutUtil.addGroup(composite, DISPLAY_GATES, typeCombo, attributesGroup, 100);
//        gateList= FormLayoutUtil.addList(gateGroup, SWT.SINGLE | SWT.V_SCROLL, 0, 0, 100);
//        ((FormData) gateList.getLayoutData()).height= 50;
//        gateList.addSelectionListener(this);
//        
//        label= FormLayoutUtil.addLabel(gateGroup, DISPLAY_GATE_NAME, gateList, 0);
//        gateNameText= FormLayoutUtil.addText(gateGroup, gateList, label, 100, 0);
//        gateNameText.addFocusListener(this);
//        label= FormLayoutUtil.addLabel(gateGroup, DISPLAY_GATE_CONDITION, gateNameText, 0);
//        gateConditionText= FormLayoutUtil.addText(gateGroup, gateNameText, label, 100, SWT.MULTI);
//        ((FormData) gateConditionText.getLayoutData()).height= 35;
//        gateDefaultButton= FormLayoutUtil.addButton(gateGroup, DISPLAY_GATE_DEFAULT, SWT.CHECK, label, 0, null);
//        gateOrgAssButton= FormLayoutUtil.addButton(gateGroup, DISPLAY_GATE_ORG_ASS, 0, gateConditionText, null, 100);
//        gateOrgAssButton.addSelectionListener(this);
//        gateConditionText.setEnabled(false);
//        gateDefaultButton.setEnabled(false);
//        gateOrgAssButton.setEnabled(false);
    }
    
    
    public void focusLost(FocusEvent e) {
//    	Object src= e.getSource();
//		if (src.equals(complexIncomingCondText.getTextfield())) {
//			setPropertyValue(gateway, pack.getGateway_IncomingCondition(), createExpression(complexIncomingCondText.getText()));
//		}
//		if (src.equals(complexOutgoingCondText.getTextfield())) {
//			setPropertyValue(gateway, pack.getGateway_OutgoingCondition(), createExpression(complexOutgoingCondText.getText()));
//		}
//    	if (src.equals(gateNameText)) {
//    		Gate gate= getSelectedGate();
//    		if (gate != null) {
//    			setPropertyValue(gate, pack.getGate_Name(), nullIfEmpty(gateNameText.getText()));
//    		}
//    	}
    }
    
    @Override
    public void widgetSelected(SelectionEvent e) {
    	super.widgetSelected(e);
    	Object src= e.getSource();
    	if (src.equals(typeCombo)) {
    		setPropertyValue(gateway, pack.getGateway_GatewayType(), GatewayType.get(typeCombo.getSelectionIndex()));
    	}
		if (src.equals(xorMarkerButton)) {
			setPropertyValue(gateway, pack.getGateway_MarkerVisible(), xorMarkerButton.getSelection());
		}
		if (src.equals(xorEventInstantiateButton)) {
			setPropertyValue(gateway, pack.getGateway_Instantiate(), xorEventInstantiateButton.getSelection());
		}
//    	if (src.equals(gateOrgAssButton) && gateList.getSelectionIndex() != -1) {
//    		try {
//    			Gate gate= gateway.getGates().get(gateList.getSelectionIndex());
//    			AbstractTransactionalCommand command= new OrganizeAssignmentsCommand(gate);
//				OperationHistoryFactory.getOperationHistory().execute(command,new NullProgressMonitor(), null);
//			} catch (ExecutionException ex) {
//				ex.printStackTrace();
//			}
//    	}
//    	if (src.equals(gateList)) {
//    		gateOrgAssButton.setEnabled(gateList.getSelectionIndex() != -1);
//			Gate gate= getSelectedGate();
//    		if (gate != null) {
//    			SequenceFlow seqFlow= gate.getOutgoingSequenceFlow();
//    			if (seqFlow != null) {
//    				gateConditionText.setText(getExpression(seqFlow.getConditionExpression()));
//    				gateDefaultButton.setSelection(seqFlow.getConditionType() == ConditionType.DEFAULT);
//    			}
//    		}
//    	}
    	refresh();
    }

//    private void fillGateList() {
//    	int index= gateList.getSelectionIndex();
//    	gateList.removeAll();
//        for (Gate gate : gateway.getGates()) {
//        	gateList.add(nonNull(gate.getName()));
//        }
//        gateList.setSelection(index);
//    }
//    
//    private Gate getSelectedGate() {
//    	if (gateList.getSelectionIndex() != -1) {
//    		return gateway.getGates().get(gateList.getSelectionIndex());
//    	} else {
//    		return null;
//    	}
//    }
    
}