package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.ProcessType;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.actions.OrganizeElementsAction;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;


public class PoolSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_NAME= "Name",
							   DISPLAY_BOUNDARY_VISIBLE= "Boundary Visible",
							   
							   DISPLAY_PROCESS_GROUP= "Process",
							   DISPLAY_PROC_TYPE= "Process Type",
							   DISPLAY_PROC_NONE= "None",
							   DISPLAY_PROC_PUBLIC= "Public",
							   DISPLAY_PROC_PRIVATE= "Private",
							   DISPLAY_SUB_ADHOC= "Ad Hoc",
							   DISPLAY_SUB_IS_ADHOC= "Ad Hoc",
							   DISPLAY_SUB_ADHOCCONDITION= "Compltn. Cond.",
							   
							   DISPLAY_PARTICIPANT= "Participant",

							   DISPLAY_ORG_PROP= "Process Properties...";
							   
    protected Pool pool;
    
    private Button boundaryvisButton;
    
    private VsdtFeatureCombo<Participant> participantCombo;
    
    private Button procTypeNoneButton;
    private Button procTypePublicButton;
    private Button procTypePrivateButton;
    
    private Button adHocButton;
    private ExpressionComposite adHocConditionText;
    
    private Button orgPropButton;
    

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getPool();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof Pool) {
        	this.pool= (Pool) eObject;
        }
    }

    @Override
 	protected void internalRefresh() {
    	super.internalRefresh();
        boundaryvisButton.setSelection(pool.isBoundaryVisible());

        participantCombo.fillCombo(pool.getParent().getParticipants());
        participantCombo.setSelected(pool.getParticipant());

        procTypeNoneButton.setSelection(pool.getProcessType() == ProcessType.NONE);
        procTypePrivateButton.setSelection(pool.getProcessType() == ProcessType.PRIVATE);
        procTypePublicButton.setSelection(pool.getProcessType() == ProcessType.PUBLIC);

    	adHocButton.setSelection(pool.isAdHoc());
    	adHocConditionText.setEnabled(adHocButton.getSelection());
    	adHocConditionText.setValues(pool.getAdHocCompletionCondition());
    	adHocConditionText.setOwnerAndFeature(pool, pack.getAbstractProcess_AdHocCompletionCondition());
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        CLabel label;

        // buttons
        orgPropButton = addButton(DISPLAY_ORG_PROP);

        // main group
        label= FormLayoutUtil.addLabel(composite, DISPLAY_PARTICIPANT, lastControl, 0);
        participantCombo= new VsdtFeatureCombo<Participant>(FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, lastControl, label, 100));
        participantCombo.getCombo().addSelectionListener(this);

        boundaryvisButton= FormLayoutUtil.addButton(composite, DISPLAY_BOUNDARY_VISIBLE, SWT.CHECK, participantCombo.getCombo(), 0, null);
        boundaryvisButton.addSelectionListener(this);

        // process group
        Group processGroup= FormLayoutUtil.addGroup(composite, DISPLAY_PROCESS_GROUP, boundaryvisButton, 0, 100);
        label= FormLayoutUtil.addLabel(processGroup, DISPLAY_PROC_TYPE, 0, 0);
        procTypeNoneButton= FormLayoutUtil.addButton(processGroup, DISPLAY_PROC_NONE, SWT.RADIO, 0, label, null);
        procTypePrivateButton= FormLayoutUtil.addButton(processGroup, DISPLAY_PROC_PRIVATE, SWT.RADIO, 0, procTypeNoneButton, null);
        procTypePublicButton= FormLayoutUtil.addButton(processGroup, DISPLAY_PROC_PUBLIC, SWT.RADIO, 0, procTypePrivateButton, null);
        procTypeNoneButton.addSelectionListener(this);
        procTypePrivateButton.addSelectionListener(this);
        procTypePublicButton.addSelectionListener(this);
        
        Group adHocGroup= FormLayoutUtil.addGroup(composite, DISPLAY_SUB_ADHOC, processGroup, 0, 100);
        adHocButton= FormLayoutUtil.addButton(adHocGroup, DISPLAY_SUB_ADHOC, SWT.CHECK, procTypePrivateButton, 0, null);
    	adHocButton.addSelectionListener(this);
        label= FormLayoutUtil.addLabel(adHocGroup, DISPLAY_SUB_ADHOCCONDITION, adHocButton, 0);
    	adHocConditionText= addExpressionComposite(adHocGroup, adHocButton, label, 100);
    }
    
    public void widgetSelected(SelectionEvent e) {
    	super.widgetSelected(e);
    	Object src= e.getSource();
    	if (src.equals(orgPropButton)) {
			OrganizeElementsAction.getPropertiesAction(-1).run(pool);
    	}
		if (src.equals(participantCombo.getCombo())) {
    		setPropertyValue(pool, pack.getPool_Participant(), participantCombo.getSelected());
    	}
    	if (src.equals(boundaryvisButton)) {
    		setPropertyValue(pool, pack.getPool_BoundaryVisible(), boundaryvisButton.getSelection());
    	}
    	if (src.equals(procTypeNoneButton)) {
    		setPropertyValue(pool, pack.getPool_ProcessType(), ProcessType.NONE);
    	}
    	if (src.equals(procTypePublicButton)) {
    		setPropertyValue(pool, pack.getPool_ProcessType(), ProcessType.PUBLIC);
    	}
    	if (src.equals(procTypePrivateButton)) {
    		setPropertyValue(pool, pack.getPool_ProcessType(), ProcessType.PRIVATE);
    	}
    	if (src.equals(adHocButton)) {
    		setPropertyValue(pool, pack.getAbstractProcess_AdHoc(),adHocButton.getSelection());
    	}
    	refresh();
    }
}