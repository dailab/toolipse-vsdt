package de.dailab.vsdt.diagram.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.FlowConditionTypes;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.LoopAttributeSet;
import de.dailab.vsdt.LoopType;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.actions.OrganizePropertiesAction;
import de.dailab.vsdt.diagram.actions.ParameterAssignmentsAction;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;
import de.dailab.vsdt.util.VsdtHelper;


public class ActivitySection extends FlowObjectSection
implements FocusListener, SelectionListener {

	/*
	 * TODO
	 * transaction (wenn subprocess / teil der subprocess attribute)
	 * compensation 
	 */
	
	public static final String DISPLAY_ACT_TYPE= "Activity Type",
							   DISPLAY_TASK_GROUP= "Activity Type Attributes",
							   DISPLAY_SUBPROCESS_GROUP= "Subprocess Type Attributes",
							   
							   DISPLAY_LOOP_TYPE= "Loop Type",
							   DISPLAY_LOOP_GROUP= "Loop Type Attributes",
							   DISPLAY_STD_COND= "Loop Condition",
							   DISPLAY_STD_MAX= "Loop Maximum",
							   DISPLAY_STD_TESTTIME= "Test Before",
							   DISPLAY_MULTI_COND= "Condition",
							   DISPLAY_MULTI_ORD_SEQ= "Sequential Execution",
							   DISPLAY_MULTI_FLOW= "Flow Condition",
							   DISPLAY_MULTI_COMPLEX= "Complex Flow Condition",
							   
							   DISPLAY_TASK_IMPL= "Implementation",
							   DISPLAY_TASK_INMESSAGE= "In Message",
							   DISPLAY_TASK_OUTMESSAGE= "Out Message",
							   DISPLAY_TASK_INSTANTIATE= "Instantiate",
							   DISPLAY_TASK_SCRIPT= "Script",
							   DISPLAY_TASK_ACTIVITYREF= "Activity Ref",
							   
							   DISPLAY_SUB_TRANSACTION= "Transaction",
							   DISPLAY_SUB_ADHOC= "Ad Hoc",
							   DISPLAY_SUB_ADHOC_ORDERING= "Ad Hoc Ordering",
//							   DISPLAY_SUB_ADHOC_PAR= "Parallel",
//							   DISPLAY_SUB_ADHOC_SEQ= "Sequential",
							   DISPLAY_SUB_ADHOCCONDITION= "Completion Cond.",
							   DISPLAY_SUB_DIAGRAMREF= "Diagram Ref",
							   DISPLAY_SUB_PROCESSREF= "Process Ref",
							   
							   DISPLAY_COMP= "Is Compensation",
							   
							   DISPLAY_ORG_PROP= "Properties...",
							   DISPLAY_PAR_ASSIGN= "Parameter Assignments...";
							   
    protected Activity activity;
    private boolean firstRun= true;

    private Combo actTypeCombo;
    private Combo loopTypeCombo;
    
    private Group loopTypeStdGroup;
    private ExpressionComposite stdCondText;
    private Spinner stdMaxSpinner;
    private Button stdBeforeButton;
    
    private Group loopTypeMultiGroup;
    private ExpressionComposite multiMIConditionText;
    private Button multiOrderingSeqButton;
    private Combo multiFlowCombo;
    private ExpressionComposite multiComplexMICondText;
    
    private Group taskAttGroup;
    private VsdtFeatureCombo<Implementation> implCombo;
    private VsdtFeatureCombo<Message> inMessageCombo;
    private VsdtFeatureCombo<Message> outMessageCombo;
    private Button instantiateButton;
    private Text scriptText;
    private VsdtFeatureCombo<Activity> taskRefCombo;
    
    private Group subprocessAttGroup;
    private Button transactionButton;
    private Button adHocButton;
    private ExpressionComposite adHocConditionText;
//    private Button adHocSeqButton;
//    private Button adHocParButton;
    private VsdtFeatureCombo<BusinessProcessDiagram> diagramRefCombo;
    private VsdtFeatureCombo<Pool> processRefCombo;
    private VsdtFeatureCombo<Activity> subprocessRefCombo;
    
    private Button orgPropButton;
    private Button parAssignButton;

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getActivity();
    }
    
    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof Activity) {
        	this.activity= (Activity) eObject;
        	adHocConditionText.setOwnerAndFeature(activity, pack.getAbstractProcess_AdHocCompletionCondition());
        }
    }

    @Override
 	protected void internalRefresh() {
    	if (firstRun) {
    		BusinessProcessDiagram bpd= activity.getPool().getParent();
    		BusinessProcessSystem bps= bpd.getParent();
    		implCombo.fillCombo(bps.getImplementations());
    		inMessageCombo.fillCombo(bps.getMessages());
    		outMessageCombo.fillCombo(bps.getMessages());
    		//fill activityRef combo - a bit more complicated
    		List<FlowObject> fos;
    		List<Activity> acts= new ArrayList<Activity>();
    		for (Pool p : bpd.getPools()) {
    			fos= p.getTransitiveGraphicalElements();
    			for (FlowObject fo : fos) {
    				if (fo instanceof Activity && fo != activity) {
    					acts.add((Activity) fo);
    				}
    			}
    		}
    		taskRefCombo.fillCombo(acts);
    		diagramRefCombo.fillCombo(activity.getPool().getParent().getParent().getBusinessProcesses());
    		subprocessRefCombo.fillCombo(acts);
    		firstRun= false;
    	}
    	//if a diagram reference is set, add the diagram's processes to the list 
    	processRefCombo.fillCombo(getValidProcesses(activity.getDiagramRef()));
    	
    	//visibility and enablement
    	ActivityType at= activity.getActivityType();
    	taskAttGroup.setVisible(at.getValue() > ActivityType.NONE_VALUE && at.getValue() < ActivityType.EMBEDDED_VALUE);
    	inMessageCombo.getCombo().setEnabled(at == ActivityType.SEND || at == ActivityType.SERVICE || at == ActivityType.USER);
    	outMessageCombo.getCombo().setEnabled(at == ActivityType.RECEIVE || at == ActivityType.SERVICE || at == ActivityType.USER);
    	implCombo.getCombo().setEnabled(at == ActivityType.RECEIVE || at == ActivityType.SEND || at == ActivityType.SERVICE || at == ActivityType.USER);
    	instantiateButton.setEnabled(at == ActivityType.RECEIVE);
    	scriptText.setEnabled(at == ActivityType.SCRIPT);
    	taskRefCombo.getCombo().setEnabled(at == ActivityType.TASKREFERENCE);
    	
    	subprocessAttGroup.setVisible(activity.getActivityType().getValue() >= ActivityType.EMBEDDED_VALUE);
    	transactionButton.setEnabled(at == ActivityType.EMBEDDED);
    	adHocButton.setEnabled(at == ActivityType.EMBEDDED);
//    	adHocParButton.setEnabled(at == ActivityType.EMBEDDED && activity.isAdHoc());
//    	adHocSeqButton.setEnabled(at == ActivityType.EMBEDDED && activity.isAdHoc());
    	adHocConditionText.setEnabled(at == ActivityType.EMBEDDED && activity.isAdHoc());
    	diagramRefCombo.getCombo().setEnabled(at == ActivityType.INDEPENDENT);
    	processRefCombo.getCombo().setEnabled(at == ActivityType.INDEPENDENT && activity.getDiagramRef() != null);
    	subprocessRefCombo.getCombo().setEnabled(at == ActivityType.SUBPROCESSREFERENCE);
    	
    	parAssignButton.setEnabled(activity.getImplementation() != null && (at == ActivityType.SERVICE || at == ActivityType.RECEIVE || at == ActivityType.SEND || at == ActivityType.USER));
    	
    	loopTypeCombo.select(VsdtHelper.toLoopType(activity.getLoopAttributes()).getValue());
    	actTypeCombo.select(activity.getActivityType().getValue());
    	
    	loopTypeStdGroup.setVisible(activity.getLoopAttributes() instanceof StandardLoopAttSet);
    	loopTypeMultiGroup.setVisible(activity.getLoopAttributes() instanceof MultiLoopAttSet);
    	
    	// refresh task attributes
    	inMessageCombo.setSelected(activity.getInMessage());
    	outMessageCombo.setSelected(activity.getOutMessage());
    	implCombo.setSelected(activity.getImplementation());
    	scriptText.setText(nonNull(activity.getScript()));
    	taskRefCombo.setSelected(activity.getActivityRef());
    	instantiateButton.setSelection(activity.isInstantiate());
    	
    	//refresh subprocess attributes
    	transactionButton.setSelection(activity.getTransaction() != null);
    	adHocButton.setSelection(activity.isAdHoc());
//    	adHocSeqButton.setSelection(activity.getAdHocOrdering() == OrderingType.SEQUENTIAL);
//    	adHocParButton.setSelection(activity.getAdHocOrdering() == OrderingType.PARALLEL);
    	adHocConditionText.setText(getExpression(activity.getAdHocCompletionCondition()));
    	diagramRefCombo.setSelected(activity.getDiagramRef());
    	processRefCombo.setSelected(activity.getProcessRef());
    	subprocessRefCombo.setSelected(activity.getActivityRef());
    	
    	if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
			MultiLoopAttSet attSet = (MultiLoopAttSet) activity.getLoopAttributes();
			multiMIConditionText.setText(getExpression(attSet.getMI_Condition()));
			multiComplexMICondText.setText(getExpression(attSet.getComplexMI_FlowCondition()));
			multiFlowCombo.select(attSet.getMI_FlowCondition().getValue());
			multiOrderingSeqButton.setSelection(attSet.isSequential());
			multiFlowCombo.setEnabled(! attSet.isSequential());
			multiComplexMICondText.setEnabled(! attSet.isSequential() && attSet.getMI_FlowCondition() == FlowConditionTypes.COMPLEX);
			multiMIConditionText.setOwnerAndFeature(attSet, pack.getMultiLoopAttSet_MI_Condition());
			multiComplexMICondText.setOwnerAndFeature(attSet, pack.getMultiLoopAttSet_ComplexMI_FlowCondition());
    	}
    	if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
			StandardLoopAttSet attSet = (StandardLoopAttSet) activity.getLoopAttributes();
			stdCondText.setText(getExpression(attSet.getLoopCondition()));
			stdMaxSpinner.setSelection(attSet.getLoopMaximum());
			stdBeforeButton.setSelection(attSet.isTestBefore());
			stdCondText.setOwnerAndFeature(attSet, pack.getStandardLoopAttSet_LoopCondition());
		}
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        CLabel label;
        
        addAssignmentButton(composite);

        orgPropButton= FormLayoutUtil.addButton(composite, DISPLAY_ORG_PROP, 0, 0, null, orgAssButton);
        orgPropButton.addSelectionListener(this);
        
        parAssignButton= FormLayoutUtil.addButton(composite, DISPLAY_PAR_ASSIGN, 0, 0, null, orgPropButton);
        parAssignButton.addSelectionListener(this);

        // activity type and attributes
        label= FormLayoutUtil.addLabel(composite, DISPLAY_ACT_TYPE, orgPropButton, 0);
        actTypeCombo= FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, orgPropButton, label, 50);
        actTypeCombo.addSelectionListener(this);
        for (ActivityType activityType : ActivityType.values()) {
        	actTypeCombo.add(activityType.getLiteral());
        }
        // loop type and attributes
        label= FormLayoutUtil.addLabel(composite, DISPLAY_LOOP_TYPE, orgPropButton, 50);
        loopTypeCombo= FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, orgPropButton, label, 100);
        loopTypeCombo.addSelectionListener(this);
        for (LoopType loopType : LoopType.values()) {
        	loopTypeCombo.add(loopType.getLiteral());
        }

        // task group
        taskAttGroup= FormLayoutUtil.addGroup(composite, DISPLAY_TASK_GROUP, actTypeCombo, 0, 50);
        fillTaskAttributesGroup(taskAttGroup);
        
        // subprocess group
        subprocessAttGroup= FormLayoutUtil.addGroup(composite, DISPLAY_SUBPROCESS_GROUP,actTypeCombo, 0, 50);
        fillSubprocessAttributesGroup(subprocessAttGroup);
        
        // standard loop type group
        loopTypeStdGroup= FormLayoutUtil.addGroup(composite, DISPLAY_LOOP_GROUP, loopTypeCombo, taskAttGroup, 100);
        fillLoopTypeStandardGroup(loopTypeStdGroup);
		
		// multi instance loop attributes
		loopTypeMultiGroup= FormLayoutUtil.addGroup(composite, DISPLAY_LOOP_GROUP, loopTypeCombo, taskAttGroup, 100);
		fillLoopTypeMultiGroup(loopTypeMultiGroup);
    }
    
    @Override
    public void focusGained(FocusEvent e) {
    }
    
    public void focusLost(FocusEvent e) {
    	Object src= e.getSource();
		if (src.equals(scriptText)) {
			setPropertyValue(activity, pack.getActivity_Script(), nullIfEmpty(scriptText.getText()));
		}
//		if (src.equals(adHocConditionText.getTextfield())) {
//			setPropertyValue(activity, pack.getAbstractProcess_AdHocCompletionCondition(), createExpression(adHocConditionText.getText()));
//		}
//    	if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
//			MultiLoopAttSet attSet = (MultiLoopAttSet) activity.getLoopAttributes();
//			if (src.equals(multiMIConditionText.getTextfield())) {
//				setPropertyValue(attSet, pack.getMultiLoopAttSet_MI_Condition(), createExpression(multiMIConditionText.getText()));
//				}
//			if (src.equals(multiComplexMICondText.getTextfield())) {
//				setPropertyValue(attSet, pack.getMultiLoopAttSet_ComplexMI_FlowCondition(), createExpression(multiComplexMICondText.getText()));
//			}
//		}
//    	if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
//			StandardLoopAttSet attSet = (StandardLoopAttSet) activity.getLoopAttributes();
//			if (src.equals(stdCondText.getTextfield())) {
//				setPropertyValue(attSet, pack.getStandardLoopAttSet_LoopCondition(), createExpression(stdCondText.getText()));
//			}
//		}
    }
    
    @Override
    public void widgetSelected(SelectionEvent e) {
    	super.widgetSelected(e);
    	Object src= e.getSource();
    	if (src.equals(orgPropButton)) {
			new OrganizePropertiesAction().run(activity);
    	}
    	if (src.equals(parAssignButton)) {
			new ParameterAssignmentsAction().run(activity);
    	}
    	if (src.equals(actTypeCombo)) {
    		setPropertyValue(activity, pack.getActivity_ActivityType(), ActivityType.get(actTypeCombo.getSelectionIndex()));
    	}
    	if (src.equals(loopTypeCombo)) {
    		LoopAttributeSet attSeq= null;
    		if (LoopType.get(loopTypeCombo.getSelectionIndex()) == LoopType.STANDARD) {
    			attSeq= VsdtFactory.eINSTANCE.createStandardLoopAttSet();
    		}
    		if (LoopType.get(loopTypeCombo.getSelectionIndex()) == LoopType.MULTIINSTANCE) {
    			attSeq= VsdtFactory.eINSTANCE.createMultiLoopAttSet();
    		}
    		setPropertyValue(activity, pack.getActivity_LoopAttributes(), attSeq);
    	}
    	if (src.equals(inMessageCombo.getCombo())) {
    		setPropertyValue(activity, pack.getActivity_InMessage(), inMessageCombo.getSelected());
    	}
    	if (src.equals(outMessageCombo.getCombo())) {
    		setPropertyValue(activity, pack.getActivity_OutMessage(), outMessageCombo.getSelected());
    	}
    	if (src.equals(implCombo.getCombo())) {
    		Implementation implementation= implCombo.getSelected();
    		setPropertyValue(activity, pack.getActivity_Implementation(), implCombo.getSelected());
    		
    		// set input and/or output message according to implementation
    		if (implementation != null) {
	    		switch (activity.getActivityType()) {
	    		case SERVICE:
	    		case USER:
	    			// here the case is clear: set input and output as set in the implementation
	    			setPropertyValue(activity, pack.getActivity_InMessage(), implementation.getInputMessage());
	    			setPropertyValue(activity, pack.getActivity_OutMessage(), implementation.getOutputMessage());
	    			break;
	    		case SEND:
	    			if (implementation.getParticipant() == activity.getPool().getParticipant()) {
	    				setPropertyValue(activity, pack.getActivity_InMessage(), implementation.getOutputMessage());
		    		} else {
		    			setPropertyValue(activity, pack.getActivity_InMessage(), implementation.getInputMessage());
		    		}
	    			break;
	    		case RECEIVE:
	    			if (implementation.getParticipant() == activity.getPool().getParticipant()) {
	    				setPropertyValue(activity, pack.getActivity_OutMessage(), implementation.getInputMessage());
		    		} else {
		    			setPropertyValue(activity, pack.getActivity_OutMessage(), implementation.getOutputMessage());
		    		}
	    			break;
	    		}
    		}
    	}
    	if (src.equals(taskRefCombo.getCombo())) {
    		setPropertyValue(activity, pack.getActivity_ActivityRef(), taskRefCombo.getSelected());
    	}
    	if (src.equals(transactionButton)) {
    		setPropertyValue(activity, pack.getActivity_Transaction(), transactionButton.getSelection() ? VsdtFactory.eINSTANCE.createTransaction() : null);
    	}
    	if (src.equals(adHocButton)) {
    		setPropertyValue(activity, pack.getAbstractProcess_AdHoc(), adHocButton.getSelection());
    	}
//    	if (src.equals(adHocSeqButton) || src.equals(adHocParButton)) {
//    		setPropertyValue(activity, pack.getAbstractProcess_AdHocOrdering(), adHocSeqButton.getSelection() ? OrderingType.SEQUENTIAL : OrderingType.PARALLEL);
//    	}
    	if (src.equals(subprocessRefCombo.getCombo())) {
    		setPropertyValue(activity, pack.getActivity_ActivityRef(), subprocessRefCombo.getSelected());
    	}
    	if (src.equals(diagramRefCombo.getCombo())) {
    		BusinessProcessDiagram selected= diagramRefCombo.getSelected();
    		setPropertyValue(activity, pack.getActivity_DiagramRef(), selected);
    		if (selected != null) {
    			List<Pool> processes= getValidProcesses(selected);
    			if (processes.size() == 1) {
    				setPropertyValue(activity, pack.getActivity_ProcessRef(), processes.get(0));
    			}
    		}
    	}
    	if (src.equals(processRefCombo.getCombo())) {
    		setPropertyValue(activity, pack.getActivity_ProcessRef(), processRefCombo.getSelected());
    	}
    	if (src.equals(instantiateButton)) {
    		setPropertyValue(activity, pack.getActivity_Instantiate(), instantiateButton.getSelection());
    	}
    	if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
			MultiLoopAttSet attSet = (MultiLoopAttSet) activity.getLoopAttributes();
	    	if (src.equals(multiOrderingSeqButton)) {
	    		setPropertyValue(attSet, pack.getMultiLoopAttSet_Sequential(), multiOrderingSeqButton.getSelection());
	    	}
	    	if (src.equals(multiFlowCombo)) {
	    		setPropertyValue(attSet, pack.getMultiLoopAttSet_MI_FlowCondition(), FlowConditionTypes.get(multiFlowCombo.getSelectionIndex()));
	    	}
		}
    	if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
			StandardLoopAttSet attSet = (StandardLoopAttSet) activity.getLoopAttributes();
			if (src.equals(stdBeforeButton)) {
				setPropertyValue(attSet, pack.getStandardLoopAttSet_TestBefore(), stdBeforeButton.getSelection());
			}
			if (src.equals(stdMaxSpinner)) {
				setPropertyValue(attSet, pack.getStandardLoopAttSet_LoopMaximum(), stdMaxSpinner.getSelection());
			}
		}
    	refresh();
    }
    
    
    private void fillLoopTypeStandardGroup(Group group) {
    	CLabel label;
        
    	label= FormLayoutUtil.addLabel(group, DISPLAY_STD_COND, 0, 0);
		stdCondText= addExpressionComposite(group, 0, label, 100);
//		((FormData) stdCondText.getLayoutData()).height= 50;
//		stdCondText.addFocusListener(this);
		
		label= FormLayoutUtil.addLabel(group, DISPLAY_STD_MAX, stdCondText, 0);
		stdMaxSpinner= FormLayoutUtil.addSpinner(group, stdCondText, label, null);
		stdMaxSpinner.addSelectionListener(this);
		
		stdBeforeButton= FormLayoutUtil.addButton(group, DISPLAY_STD_TESTTIME, SWT.CHECK, stdMaxSpinner, 0, null);
		stdBeforeButton.addSelectionListener(this);
    }
    
    private void fillLoopTypeMultiGroup(Group group) {
    	CLabel label;

    	label= FormLayoutUtil.addLabel(group, DISPLAY_MULTI_COND, 0, 0);
		multiMIConditionText= addExpressionComposite(group, 0, label, 100);
//		((FormData) multiMIConditionText.getLayoutData()).height= 35;
//		multiMIConditionText.addFocusListener(this);
		
		multiOrderingSeqButton= FormLayoutUtil.addButton(group, DISPLAY_MULTI_ORD_SEQ, SWT.CHECK, multiMIConditionText, 0, null);
		multiOrderingSeqButton.addSelectionListener(this);

		label= FormLayoutUtil.addLabel(group, DISPLAY_MULTI_FLOW, multiOrderingSeqButton, 0);
		multiFlowCombo= FormLayoutUtil.addCombo(group, SWT.READ_ONLY, multiOrderingSeqButton, label, 100);
		multiFlowCombo.addSelectionListener(this);
		for (FlowConditionTypes flowConditionType : FlowConditionTypes.values()) {
			multiFlowCombo.add(flowConditionType.getLiteral());
        }

		label= FormLayoutUtil.addLabel(group, DISPLAY_MULTI_COMPLEX, multiFlowCombo, 0);
		multiComplexMICondText= addExpressionComposite(group, multiFlowCombo, label, 100);
//		((FormData) multiComplexMICondText.getLayoutData()).height= 35;
//		multiComplexMICondText.addFocusListener(this);
    }
    
    private void fillTaskAttributesGroup(Group group) {
    	CLabel label;

		instantiateButton= FormLayoutUtil.addButton(group, DISPLAY_TASK_INSTANTIATE, SWT.CHECK, 0, 0, null);
		instantiateButton.addSelectionListener(this);
		
		label= FormLayoutUtil.addLabel(group, DISPLAY_TASK_IMPL, instantiateButton, 0);
		implCombo= new VsdtFeatureCombo<Implementation>(FormLayoutUtil.addCombo(group, SWT.READ_ONLY, instantiateButton, label, 100));
		implCombo.getCombo().addSelectionListener(this);
		
		label= FormLayoutUtil.addLabel(group, DISPLAY_TASK_INMESSAGE, implCombo.getCombo(), 0);
		inMessageCombo= new VsdtFeatureCombo<Message>(FormLayoutUtil.addCombo(group, SWT.READ_ONLY, implCombo.getCombo(), label, 100));
		inMessageCombo.getCombo().addSelectionListener(this);
		
		label= FormLayoutUtil.addLabel(group, DISPLAY_TASK_OUTMESSAGE, inMessageCombo.getCombo(), 0);
		outMessageCombo= new VsdtFeatureCombo<Message>(FormLayoutUtil.addCombo(group, SWT.READ_ONLY, inMessageCombo.getCombo(), label, 100));
		outMessageCombo.getCombo().addSelectionListener(this);
		
		label= FormLayoutUtil.addLabel(group, DISPLAY_TASK_SCRIPT, outMessageCombo.getCombo(), 0);
		scriptText= FormLayoutUtil.addText(group, outMessageCombo.getCombo(), label, 100, SWT.MULTI | SWT.V_SCROLL);
		((FormData) scriptText.getLayoutData()).height= 50;
		scriptText.addFocusListener(this);

		label= FormLayoutUtil.addLabel(group, DISPLAY_TASK_ACTIVITYREF, scriptText, 0);
		taskRefCombo= new VsdtFeatureCombo<Activity>(FormLayoutUtil.addCombo(group, SWT.READ_ONLY, scriptText, label, 100));
		taskRefCombo.getCombo().addSelectionListener(this);
    }
    
    private void fillSubprocessAttributesGroup(Group group) {
    	CLabel label;
    	
    	transactionButton= FormLayoutUtil.addButton(group, DISPLAY_SUB_TRANSACTION, SWT.CHECK, 0, 0, null);
    	transactionButton.addSelectionListener(this);
    	
    	adHocButton= FormLayoutUtil.addButton(group, DISPLAY_SUB_ADHOC, SWT.CHECK, transactionButton, 0, null);
    	adHocButton.addSelectionListener(this);
    	
    	label= FormLayoutUtil.addLabel(group, DISPLAY_SUB_ADHOCCONDITION, adHocButton, 0);
    	adHocConditionText= addExpressionComposite(group, adHocButton, label, 100);
//    	adHocConditionText.addFocusListener(this);
    	
//    	label= FormLayoutUtil.addLabel(group, DISPLAY_SUB_ADHOC_ORDERING, adHocConditionText, 0);
//    	adHocSeqButton= FormLayoutUtil.addButton(group, DISPLAY_SUB_ADHOC_SEQ, SWT.RADIO, adHocConditionText, label, null);
//    	adHocParButton= FormLayoutUtil.addButton(group, DISPLAY_SUB_ADHOC_PAR, SWT.RADIO, adHocConditionText, adHocSeqButton, null);
//    	adHocSeqButton.addSelectionListener(this);
//    	adHocParButton.addSelectionListener(this);

    	label= FormLayoutUtil.addLabel(group, DISPLAY_SUB_DIAGRAMREF, adHocConditionText, 0);
    	diagramRefCombo= new VsdtFeatureCombo<BusinessProcessDiagram>(FormLayoutUtil.addCombo(group, SWT.READ_ONLY, adHocConditionText, label, 100));
    	diagramRefCombo.getCombo().addSelectionListener(this);

    	label= FormLayoutUtil.addLabel(group, DISPLAY_SUB_PROCESSREF, diagramRefCombo.getCombo(), 0);
    	processRefCombo= new VsdtFeatureCombo<Pool>(FormLayoutUtil.addCombo(group, SWT.READ_ONLY, diagramRefCombo.getCombo(), label, 100));
    	processRefCombo.getCombo().addSelectionListener(this);

    	label= FormLayoutUtil.addLabel(group, DISPLAY_TASK_ACTIVITYREF, processRefCombo.getCombo(), 0);
    	subprocessRefCombo= new VsdtFeatureCombo<Activity>(FormLayoutUtil.addCombo(group, SWT.READ_ONLY, processRefCombo.getCombo(), label, 100));
    	subprocessRefCombo.getCombo().addSelectionListener(this);
    }
    
    private List<Pool> getValidProcesses(BusinessProcessDiagram diagramRef) {
    	List<Pool> processes= new ArrayList<Pool>();
		//if a diagram reference is set, add the diagram's processes to the list 
		if (activity.getDiagramRef() != null) {
			BusinessProcessDiagram bpd= activity.getDiagramRef();
			for (Pool pool : bpd.getPools()) {
				if (pool.getParticipant() == activity.getPool().getParticipant()) {
					processes.add(pool);
				}
			}
		}
		return processes;
    }

}