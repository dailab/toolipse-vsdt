package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
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
import de.dailab.vsdt.diagram.actions.OrganizeAssignmentsAction;
import de.dailab.vsdt.diagram.actions.OrganizePropertiesAction;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;


public class PoolSection extends AbstractVsdtPropertySection {

	public static final String DISPLAY_NAME= "Name",
							   DISPLAY_BOUNDARY_VISIBLE= "Boundary Visible",
							   
							   DISPLAY_PROCESS_GROUP= "Process",
							   DISPLAY_PROC_TYPE= "Process Type",
							   DISPLAY_PROC_NONE= "None",
							   DISPLAY_PROC_PRIV= "Private",
							   DISPLAY_PROC_ABST= "Abstract",
							   DISPLAY_PROC_COLL= "Collaboration",
//							   DISPLAY_PROC_INSTCOMP= "Enable Instance Compensation",
//							   DISPLAY_PROC_SUPPJF= "Suppress Join Failure",
							   DISPLAY_SUB_ADHOC= "Ad Hoc",
							   DISPLAY_SUB_ADHOC_ORDERING= "Ad Hoc Ordering",
							   DISPLAY_SUB_ADHOC_PAR= "Parallel",
							   DISPLAY_SUB_ADHOC_SEQ= "Sequential",
							   DISPLAY_SUB_ADHOCCONDITION= "Completion Cond.",
							   
							   DISPLAY_PARTICIPANT= "Participant",
//							   DISPLAY_PART_ROLE= "Role",
//							   DISPLAY_PART_ENTITY= "Entity",

							   DISPLAY_ORG_PROP= "Process Properties...",
							   DISPLAY_ORG_ASS= "Process Assignments...",
							   DISPLAY_INIT_PART= "new Participant";
							   
    protected Pool pool;
    
    private Button boundaryvisButton;
    
//    private Group participantGroup;
    private VsdtFeatureCombo<Participant> participantCombo;
//    private Text partNameText;
//    private Text partRoleText;
//    private Text partEntityText;
//    private Button initPartButton;
    
    private Group processGroup;
//    private Text procNameText;
    private Button procTypeNoneButton;
    private Button procTypePrivButton;
    private Button procTypeAbstButton;
    private Button procTypeCollButton;
//    private Button suppJFButton;
//    private Button enabICButton;
    
//    private Group adHocGroup;
    private Button adHocButton;
    private ExpressionComposite adHocConditionText;
//    private Button adHocSeqButton;
//    private Button adHocParButton;
    
    private Button orgPropButton;
    private Button orgAssButton;
    

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
        boundaryvisButton.setSelection(pool.isBoundaryVisible());

        participantCombo.fillCombo(pool.getParent().getParticipants());
        participantCombo.setSelected(pool.getParticipant());
//        participantGroup.setVisible(pool.getParticipant() != null);
//        if (pool.getParticipant() != null) {
//            partNameText.setText(nonNull(pool.getParticipant().getName()));
//            partRoleText.setText(nonNull(pool.getParticipant().getRole()));
//            partEntityText.setText(nonNull(pool.getParticipant().getEntity()));
//        }

    	processGroup.setVisible(true);
    	Pool process = pool;
//        procNameText.setText(nonNull(process.getName()));
        procTypeNoneButton.setSelection(process.getProcessType() == ProcessType.NONE);
        procTypePrivButton.setSelection(process.getProcessType() == ProcessType.PRIVATE);
        procTypeAbstButton.setSelection(process.getProcessType() == ProcessType.ABSTRACT);
        procTypeCollButton.setSelection(process.getProcessType() == ProcessType.COLLABORATION);

//        enabICButton.setSelection(process.isEnableInstanceCompensation());
//        suppJFButton.setSelection(process.isSuppressJoinFailure());
        
    	adHocButton.setSelection(process.isAdHoc());
    	adHocConditionText.setEnabled(adHocButton.getSelection());
//        	adHocSeqButton.setSelection(process.getAdHocOrdering() == OrderingType.SEQUENTIAL);
//        	adHocParButton.setSelection(process.getAdHocOrdering() == OrderingType.PARALLEL);
    	adHocConditionText.setText(getExpression(process.getAdHocCompletionCondition()));
    	adHocConditionText.setOwnerAndFeature(process, pack.getAbstractProcess_AdHocCompletionCondition());
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        CLabel label;

        // pool's own attributes
        boundaryvisButton= FormLayoutUtil.addButton(composite, DISPLAY_BOUNDARY_VISIBLE, SWT.CHECK, 0, 0, null);
        boundaryvisButton.addSelectionListener(this);

        // organize buttons
        orgPropButton= FormLayoutUtil.addButton(composite, DISPLAY_ORG_PROP, SWT.NONE, boundaryvisButton, null, 100);
        orgPropButton.addSelectionListener(this);
        orgAssButton= FormLayoutUtil.addButton(composite, DISPLAY_ORG_ASS, SWT.NONE, boundaryvisButton, null, orgPropButton);
        orgAssButton.addSelectionListener(this);

//        // participant group
//        initPartButton= FormLayoutUtil.addButton(composite, DISPLAY_INIT_PART, SWT.NONE, boundaryvisButton, null, 50);
//        initPartButton.addSelectionListener(this);
        label= FormLayoutUtil.addLabel(composite, DISPLAY_PARTICIPANT, boundaryvisButton, 0);
        participantCombo= new VsdtFeatureCombo<Participant>(FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, boundaryvisButton, label, 50));
        participantCombo.getCombo().addSelectionListener(this);
//        
//        participantGroup= FormLayoutUtil.addGroup(composite, DISPLAY_PARTICIPANT_GROUP, participantCombo.getCombo(), 0, 50);
//        label= FormLayoutUtil.addLabel(participantGroup, DISPLAY_NAME, 0, 0);
//        partNameText= FormLayoutUtil.addText(participantGroup, 0, label, 100, 0);
//        partNameText.addFocusListener(this);
//        label= FormLayoutUtil.addLabel(participantGroup, DISPLAY_PART_ROLE, partNameText, 0);
//        partRoleText= FormLayoutUtil.addText(participantGroup, partNameText, label, 100, 0);
//        partRoleText.addFocusListener(this);
//        label= FormLayoutUtil.addLabel(participantGroup, DISPLAY_PART_ENTITY, partRoleText, 0);
//        partEntityText= FormLayoutUtil.addText(participantGroup, partRoleText, label, 100, 0);
//        partEntityText.addFocusListener(this);
        
        // process group
        processGroup= FormLayoutUtil.addGroup(composite, DISPLAY_PROCESS_GROUP, orgPropButton, participantCombo.getCombo(), 100);
        label= FormLayoutUtil.addLabel(processGroup, DISPLAY_NAME, 0, 0);
//        procNameText= FormLayoutUtil.addText(processGroup, 0, label, 100, 0);
//        procNameText.addFocusListener(this);
        label= FormLayoutUtil.addLabel(processGroup, DISPLAY_PROC_TYPE, 0, 0);
        procTypeNoneButton= FormLayoutUtil.addButton(processGroup, DISPLAY_PROC_NONE, SWT.RADIO, 0, label, null);
        procTypePrivButton= FormLayoutUtil.addButton(processGroup, DISPLAY_PROC_PRIV, SWT.RADIO, 0, procTypeNoneButton, null);
        procTypeAbstButton= FormLayoutUtil.addButton(processGroup, DISPLAY_PROC_ABST, SWT.RADIO, label, label, null);
        procTypeCollButton= FormLayoutUtil.addButton(processGroup, DISPLAY_PROC_COLL, SWT.RADIO, label, procTypeAbstButton, null);
        procTypeNoneButton.addSelectionListener(this);
        procTypePrivButton.addSelectionListener(this);
        procTypeAbstButton.addSelectionListener(this);
        procTypeCollButton.addSelectionListener(this);
//        enabICButton= FormLayoutUtil.addButton(processGroup, DISPLAY_PROC_INSTCOMP, SWT.CHECK, procTypeCollButton, 0, null);
//        enabICButton.addSelectionListener(this);
//        suppJFButton= FormLayoutUtil.addButton(processGroup, DISPLAY_PROC_SUPPJF, SWT.CHECK, procTypeCollButton, enabICButton, null);
//        suppJFButton.addSelectionListener(this);
        adHocButton= FormLayoutUtil.addButton(processGroup, DISPLAY_SUB_ADHOC, SWT.CHECK, procTypeCollButton, 0, null);
    	adHocButton.addSelectionListener(this);
//    	adHocGroup= FormLayoutUtil.addGroup(processGroup, DISPLAY_SUB_ADHOC, adHocButton, 0, 100);
        label= FormLayoutUtil.addLabel(processGroup, DISPLAY_SUB_ADHOCCONDITION, adHocButton, 0);
    	adHocConditionText= addExpressionComposite(processGroup, adHocButton, label, 100);
//    	adHocConditionText.addFocusListener(this);
//    	label= FormLayoutUtil.addLabel(adHocGroup, DISPLAY_SUB_ADHOC_ORDERING, adHocConditionText, 0);
//    	adHocSeqButton= FormLayoutUtil.addButton(adHocGroup, DISPLAY_SUB_ADHOC_SEQ, SWT.RADIO, adHocConditionText, label, null);
//    	adHocParButton= FormLayoutUtil.addButton(adHocGroup, DISPLAY_SUB_ADHOC_PAR, SWT.RADIO, adHocConditionText, adHocSeqButton, null);
//    	adHocSeqButton.addSelectionListener(this);
//    	adHocParButton.addSelectionListener(this);
    }
    
    public void focusLost(FocusEvent e) {
//    	if (e.getSource().equals(partNameText)) {
//    		setPropertyValue(pool.getParticipant(), pack.getParticipant_Name(), nullIfEmpty(partNameText.getText()));
//    	}
//    	if (e.getSource().equals(partRoleText)) {
//    		setPropertyValue(pool.getParticipant(), pack.getParticipant_Role(), nullIfEmpty(partRoleText.getText()));
//    	}
//    	if (e.getSource().equals(partEntityText)) {
//    		setPropertyValue(pool.getParticipant(), pack.getParticipant_Entity(), nullIfEmpty(partEntityText.getText()));
//    	}
//    	if (e.getSource().equals(procNameText)) {
//    		setPropertyValue(pool, pack.getProperty_Name(), nullIfEmpty(procNameText.getText()));
//    	}
//    	if (e.getSource().equals(adHocConditionText.getTextfield())) {
//    		setPropertyValue(pool.getProcess(), pack.getAbstractProcess_AdHocCompletionCondition(), createExpression(adHocConditionText.getText()));
//    	}
    }
    
    public void widgetSelected(SelectionEvent e) {
    	Object src= e.getSource();
    	if (src.equals(orgPropButton)) {
			new OrganizePropertiesAction().run(pool);
    	}
    	if (src.equals(orgAssButton)) {
			new OrganizeAssignmentsAction().run(pool);
    	}
//    	if (src.equals(initPartButton)) {
//    		try {
//				OperationHistoryFactory.getOperationHistory().execute(new InitParticipantCommand(pool),new NullProgressMonitor(), null);
//			} catch (ExecutionException ex) {
//				ex.printStackTrace();
//			}
//    	}
		if (src.equals(participantCombo.getCombo())) {
    		setPropertyValue(pool, pack.getPool_Participant(), participantCombo.getSelected());
    	}
    	if (src.equals(boundaryvisButton)) {
    		setPropertyValue(pool, pack.getPool_BoundaryVisible(), boundaryvisButton.getSelection());
    	}
//    	if (pool.getProcess() != null) {
			Pool process= pool;
	    	if (src.equals(procTypeNoneButton)) {
	    		setPropertyValue(process, pack.getPool_ProcessType(), ProcessType.NONE);
	    	}
	    	if (src.equals(procTypeAbstButton)) {
	    		setPropertyValue(process, pack.getPool_ProcessType(), ProcessType.ABSTRACT);
	    	}
	    	if (src.equals(procTypePrivButton)) {
	    		setPropertyValue(process, pack.getPool_ProcessType(), ProcessType.PRIVATE);
	    	}
	    	if (src.equals(procTypeCollButton)) {
	    		setPropertyValue(process, pack.getPool_ProcessType(), ProcessType.COLLABORATION);
	    	}
	    	if (src.equals(adHocButton)) {
	    		setPropertyValue(process, pack.getAbstractProcess_AdHoc(),adHocButton.getSelection());
	    	}
//	    	if (src.equals(adHocSeqButton) || src.equals(adHocParButton)) {
//	    		setPropertyValue(process, pack.getAbstractProcess_AdHocOrdering(), adHocSeqButton.getSelection() ? OrderingType.SEQUENTIAL : OrderingType.PARALLEL);
//	    	}
//	    	if (src.equals(enabICButton)) {
//	    		setPropertyValue(process, pack.getBpmnProcess_EnableInstanceCompensation(), enabICButton.getSelection());
//	    	}
//	    	if (src.equals(suppJFButton)) {
//	    		setPropertyValue(process, pack.getBpmnProcess_SuppressJoinFailure(), suppJFButton.getSelection());
//	    	}
//    	}
//    	if (pool.getParticipant() != null) {
//	    	if (src.equals(partTypeRoleButton)) {
//	    		setPropertyValue(pool.getParticipant(), pack.getParticipant_ParticipantType(), ParticipantType.ROLE);
//	    	}
//	    	if (src.equals(partTypeEntityButton)) {
//	    		setPropertyValue(pool.getParticipant(), pack.getParticipant_ParticipantType(), ParticipantType.ENTITY);
//	    	}
//    	}
    	refresh();
    }
}