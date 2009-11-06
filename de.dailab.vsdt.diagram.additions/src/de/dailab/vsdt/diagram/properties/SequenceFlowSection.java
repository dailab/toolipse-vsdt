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
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;


public class SequenceFlowSection extends AbstractVsdtPropertySection {
	
	public static final String DISPLAY_TYPE= "Condition Type",
	   						   DISPLAY_TYPE_NONE= "None",
	   						   DISPLAY_TYPE_DEF= "Default",
	   						   DISPLAY_TYPE_COND= "Expression",
	   						   DISPLAY_CONDITION= "Condition Expression",
	   						   DISPLAY_EXPRESSION= "Expression";
	
	private ExpressionComposite conditionText;
	
    private Button typeNoneButton;
    private Button typeDefButton;
    private Button typeCondButton;

    protected SequenceFlow sequenceFlow;
    
    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getSequenceFlow();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof SequenceFlow) {
        	this.sequenceFlow= (SequenceFlow) eObject;
            conditionText.setOwnerAndFeature(sequenceFlow, pack.getSequenceFlow_ConditionExpression());
        }
    }

    @Override
 	protected void internalRefresh() {
    	if (sequenceFlow.getConditionExpression() != null) {
        	conditionText.setText(getExpression(sequenceFlow.getConditionExpression()));	
    	}
        typeNoneButton.setSelection(sequenceFlow.getConditionType() == ConditionType.NONE);
        typeDefButton.setSelection(sequenceFlow.getConditionType() == ConditionType.DEFAULT);
        typeCondButton.setSelection(sequenceFlow.getConditionType() == ConditionType.EXPRESSION);
        conditionText.setEnabled(typeCondButton.getSelection());
    }
    
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        CLabel label;
        
        label= FormLayoutUtil.addLabel(composite, DISPLAY_TYPE, 0, 0);
        typeNoneButton= FormLayoutUtil.addButton(composite, DISPLAY_TYPE_NONE, SWT.RADIO, 0, label, null);
        typeDefButton= FormLayoutUtil.addButton(composite, DISPLAY_TYPE_DEF, SWT.RADIO, 0, typeNoneButton, null);
        typeCondButton= FormLayoutUtil.addButton(composite, DISPLAY_TYPE_COND, SWT.RADIO, 0, typeDefButton, null);
        typeNoneButton.addSelectionListener(this);
        typeDefButton.addSelectionListener(this);
        typeCondButton.addSelectionListener(this);

        label= FormLayoutUtil.addLabel(composite, DISPLAY_CONDITION, typeNoneButton, 0);
//        conditionText= FormLayoutUtil.addText(composite, typeNoneButton, label, 100, 1);
//        ((FormData) conditionText.getLayoutData()).height= 50;
        conditionText= addExpressionComposite(composite, typeNoneButton, label, 100);
//        conditionText= addExpressionText(composite, sequenceFlow, pack.getSequenceFlow_ConditionExpression());
//        conditionText.addFocusListener(this);
    }

    public void focusLost(FocusEvent e) {
//    	if (e.getSource().equals(conditionText.getTextfield())) {
//			setPropertyValue(sequenceFlow, pack.getSequenceFlow_ConditionExpression(), createExpression(conditionText.getText()));
//		}
    }

    public void widgetSelected(SelectionEvent e) {
    	Object src= e.getSource();
    	if (src.equals(typeNoneButton)) {
    		conditionText.setEnabled(false);
    		setPropertyValue(sequenceFlow, pack.getSequenceFlow_ConditionType(), ConditionType.NONE);
    		setPropertyValue(sequenceFlow, pack.getSequenceFlow_ConditionExpression(), null);
    	}
    	if (src.equals(typeDefButton)) {
    		conditionText.setEnabled(false);
			setPropertyValue(sequenceFlow, pack.getSequenceFlow_ConditionType(), ConditionType.DEFAULT);
			setPropertyValue(sequenceFlow, pack.getSequenceFlow_ConditionExpression(), null);
    	}
    	if (src.equals(typeCondButton)) {
    		conditionText.setEnabled(true);
			setPropertyValue(sequenceFlow, pack.getSequenceFlow_ConditionType(), ConditionType.EXPRESSION);
			setPropertyValue(sequenceFlow, pack.getSequenceFlow_ConditionExpression(), createExpression(conditionText.getText()));
    	}
    }
}