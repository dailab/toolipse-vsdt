package de.dailab.vsdt.diagram.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.FormLayoutUtil;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.End;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.actions.ParameterAssignmentsAction;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;

public class EventSection extends FlowObjectSection {
	
	public static final String DISPLAY_TRIGGER= "Trigger",
							   DISPLAY_GROUP= "Event Trigger Attributes",
							   DISPLAY_MESSAGE= "Message",
							   DISPLAY_IMPL= "Implementation",
							   DISPLAY_TIME_DATE= "Time Date",
							   DISPLAY_TIME_CYCLE= "Time Cycle",
							   DISPLAY_ERROR= "Error Code",
							   DISPLAY_RULE_NAME= "Rule Name",
							   DISPLAY_RULE_EXP= "Rule Expression",
							   DISPLAY_LINK= "Linked To",
							   DISPLAY_ACTIVITY= "Activity",
							   DISPLAY_SIGNAL= "Signal",

							   DISPLAY_HIGHLIGH_LINK= "Highlight Opposite",
							   DISPLAY_PAR_ASSIGN= "Parameter Assignments...";
		
	
    protected Event event;
    private boolean firstrun= true;

    private Combo eventTypeCombo;
    
    private Group triggerGroup;
    private VsdtFeatureCombo<Message> messageCombo;
    private VsdtFeatureCombo<Implementation> implementationCombo;
    private ExpressionComposite timeDateText;
    private ExpressionComposite timeCycleText;
    private Text ruleNameText;
    private ExpressionComposite ruleExpText;
    private VsdtFeatureCombo<Event> linkedToCombo;
    private Text errorCodeText;
    private VsdtFeatureCombo<Activity> activityCombo;
    private Text signalText;

    private Button highlightOpposite;
    private Button parAssignButton;

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getEvent();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof Event) {
        	this.event= (Event) eObject;
        	timeDateText.setOwnerAndFeature(event, pack.getEvent_TimeDate());
        	timeCycleText.setOwnerAndFeature(event, pack.getEvent_TimeCycle());
        	ruleExpText.setOwnerAndFeature(event, pack.getEvent_RuleExpression());
        }
    }

    @Override
 	protected void internalRefresh() {
    	if (firstrun) {
    		BusinessProcessDiagram bpd= event.getPool().getParentDiagram();
    		BusinessProcessSystem bps= bpd.getBusinessProcessSystem();
    		messageCombo.fillCombo(bps.getMessages());
    		implementationCombo.fillCombo(bps.getImplementations());
    		List<Event> events= new ArrayList<Event>();
    		for (FlowObject flowObject : event.getAbstractProcess().getGraphicalElements()) {
    			if (flowObject instanceof Event) {
					Event event = (Event) flowObject;
					if (event != this.event && event.getTrigger() == TriggerType.LINK || event.getTrigger() == TriggerType.MULTIPLE) {
						events.add(event);
					}
				}
    		}
    		linkedToCombo.fillCombo(events);

    		List<Activity> acts= new ArrayList<Activity>();
			List<FlowObject> fos= event.getPool().getProcess().getTransitiveGraphicalElements();
			for (FlowObject fo : fos) {
				if (fo instanceof Activity) {
					acts.add((Activity) fo);
				}
    		}
    		activityCombo.fillCombo(acts);
	        firstrun= false;
    	}
    	eventTypeCombo.removeAll();
    	for (TriggerType triggerType : event.getValidTriggerTypes()) {
        	eventTypeCombo.add(triggerType.getLiteral());
        }
		eventTypeCombo.select(eventTypeCombo.indexOf(event.getTrigger().getLiteral()));
//    	if (event instanceof Start) {
//	        for (StartEventTriggerType triggerType : StartEventTriggerType.values()) {
//	        	eventTypeCombo.add(triggerType.getLiteral());
//	        }
//			eventTypeCombo.select(eventTypeCombo.indexOf(((Start)event).getTrigger().getLiteral()));
//        }
//        if (event instanceof Intermediate) {
//	        for (IntermediateEventTriggerType triggerType : IntermediateEventTriggerType.values()) {
//	        	eventTypeCombo.add(triggerType.getLiteral());
//	        }
//			eventTypeCombo.select(eventTypeCombo.indexOf(((Intermediate)event).getTrigger().getLiteral()));
//		}
//        if (event instanceof End) {
//	        for (EndEventTriggerType triggerType : EndEventTriggerType.values()) {
//	        	eventTypeCombo.add(triggerType.getLiteral());
//	        }
//	        eventTypeCombo.select(eventTypeCombo.indexOf(((End)event).getTrigger().getLiteral()));
//		}
    	messageCombo.setSelected(event.getMessage());
    	implementationCombo.setSelected(event.getImplementation());
    	timeDateText.setText(getExpression(event.getTimeDate()));
    	timeCycleText.setText(getExpression(event.getTimeCycle()));
    	errorCodeText.setText(nonNull(event.getErrorCode()));
    	ruleNameText.setText(nonNull(event.getRuleName()));
    	ruleExpText.setText(getExpression(event.getRuleExpression()));
    	linkedToCombo.setSelected(event.getLinkedTo());
    	activityCombo.setSelected(event.getActivity());
    	signalText.setText(nonNull(event.getSignal()));
    	
    	parAssignButton.setEnabled(event.getImplementation() != null && event.getTrigger() == TriggerType.MESSAGE);
    	
    	if (eventTypeCombo.getSelectionIndex() != -1) {
    		String trigger= eventTypeCombo.getItem(eventTypeCombo.getSelectionIndex());
    		boolean isMulti= TriggerType.MULTIPLE.getLiteral().equals(trigger);
        	messageCombo.getCombo().setEnabled(TriggerType.MESSAGE.getLiteral().equals(trigger) || isMulti);
        	implementationCombo.getCombo().setEnabled(TriggerType.MESSAGE.getLiteral().equals(trigger) || isMulti);
        	errorCodeText.setEnabled(TriggerType.ERROR.getLiteral().equals(trigger) || isMulti && !(event instanceof Start));
        	timeCycleText.setEnabled(TriggerType.TIMER.getLiteral().equals(trigger) || isMulti && !(event instanceof End));
        	timeDateText.setEnabled(TriggerType.TIMER.getLiteral().equals(trigger) || isMulti && !(event instanceof End));
        	ruleNameText.setEnabled(TriggerType.RULE.getLiteral().equals(trigger) || isMulti && !(event instanceof End));
        	ruleExpText.setEnabled(TriggerType.RULE.getLiteral().equals(trigger) || isMulti && !(event instanceof End));
        	linkedToCombo.getCombo().setEnabled(TriggerType.LINK.getLiteral().equals(trigger) || isMulti);
        	highlightOpposite.setEnabled((TriggerType.LINK.getLiteral().equals(trigger) || isMulti) && event.getLinkedTo() != null);
        	activityCombo.getCombo().setEnabled(TriggerType.COMPENSATION.getLiteral().equals(trigger) || isMulti && !(event instanceof Start));
        	signalText.setEnabled(TriggerType.SIGNAL.getLiteral().equals(trigger) || isMulti);
    	}
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        CLabel label;
        
        addAssignmentButton(composite);
        
        parAssignButton= FormLayoutUtil.addButton(composite, DISPLAY_PAR_ASSIGN, 0, 0, null, orgAssButton);
        parAssignButton.addSelectionListener(this);

        // event type and attributes
        label= FormLayoutUtil.addLabel(composite, DISPLAY_TRIGGER, 0, 0);
        eventTypeCombo= FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, 0, label, parAssignButton);
        eventTypeCombo.addSelectionListener(this);
        
        // standard loop type group
        triggerGroup= FormLayoutUtil.addGroup(composite, DISPLAY_GROUP, eventTypeCombo, 0, 100);
        
        //message trigger
        label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_IMPL, 0, 0);
    	implementationCombo= new VsdtFeatureCombo<Implementation>(FormLayoutUtil.addCombo(triggerGroup, SWT.READ_ONLY, 0, label, 50));
		implementationCombo.getCombo().addSelectionListener(this);
		
        label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_MESSAGE, implementationCombo.getCombo(), 0);
    	messageCombo= new VsdtFeatureCombo<Message>(FormLayoutUtil.addCombo(triggerGroup, SWT.READ_ONLY, implementationCombo.getCombo(), label, 50));
    	messageCombo.getCombo().addSelectionListener(this);
		
		//timer trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_TIME_DATE, messageCombo.getCombo(), 0);
		timeDateText= addExpressionComposite(triggerGroup, messageCombo.getCombo(), label, 50);
//		timeDateText= FormLayoutUtil.addText(triggerGroup, implementationCombo.getCombo(), label, 50, SWT.NONE);
//		timeDateText.addFocusListener(this);
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_TIME_CYCLE, timeDateText, 0);
		timeCycleText= addExpressionComposite(triggerGroup, timeDateText, label, 50);
//		timeCycleText= FormLayoutUtil.addText(triggerGroup, timeDateText, label, 50, SWT.NONE);
//		timeCycleText.addFocusListener(this);
		
		//error trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_ERROR, timeCycleText, 0);
		errorCodeText= FormLayoutUtil.addText(triggerGroup, timeCycleText, label, 50, SWT.NONE);
		errorCodeText.addFocusListener(this);
		
		//compensation trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_ACTIVITY, errorCodeText, 0);
		activityCombo= new VsdtFeatureCombo<Activity>(FormLayoutUtil.addCombo(triggerGroup, SWT.READ_ONLY, errorCodeText, label, 50));
		activityCombo.getCombo().addSelectionListener(this);
		
		//rule trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_RULE_NAME, 0, 50);
		ruleNameText= FormLayoutUtil.addText(triggerGroup, 0, label, 100, SWT.NONE);
		ruleNameText.addFocusListener(this);
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_RULE_EXP, ruleNameText, 50);
		ruleExpText= addExpressionComposite(triggerGroup, ruleNameText, label, 100);
//        ((FormData) ruleExpText.getLayoutData()).height= 30;
//		ruleExpText.addFocusListener(this);
		
		//link trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_LINK, ruleExpText, 50);
		highlightOpposite= FormLayoutUtil.addButton(triggerGroup, DISPLAY_HIGHLIGH_LINK, SWT.NONE, ruleExpText, null, 100);
		highlightOpposite.addSelectionListener(this);
		linkedToCombo= new VsdtFeatureCombo<Event>(FormLayoutUtil.addCombo(triggerGroup, SWT.READ_ONLY, ruleExpText, label, highlightOpposite));
		linkedToCombo.getCombo().addSelectionListener(this);
		
		//signal trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_SIGNAL, linkedToCombo.getCombo(), 50);
		signalText= FormLayoutUtil.addText(triggerGroup, linkedToCombo.getCombo(), label, 100, SWT.NONE);
		signalText.addFocusListener(this);
    }
    
    public void focusLost(FocusEvent e) {
    	Object src= e.getSource();
//    	if (src.equals(timeCycleText)) {
//    		setPropertyValue(event, pack.getEvent_TimeCycle(), nullIfEmpty(timeCycleText.getText()));
//    	}
//    	if (src.equals(timeDateText)) {
//    		setPropertyValue(event, pack.getEvent_TimeDate(), nullIfEmpty(timeDateText.getText()));
//    	}
    	if (src.equals(ruleNameText)) {
    		setPropertyValue(event, pack.getEvent_RuleName(), nullIfEmpty(ruleNameText.getText()));
    	}
//    	if (src.equals(ruleExpText.getTextfield())) {
//    		setPropertyValue(event, pack.getEvent_RuleExpression(), createExpression(ruleExpText.getText()));
//    	}
    	if (src.equals(errorCodeText)) {
    		setPropertyValue(event, pack.getEvent_ErrorCode(), nullIfEmpty(errorCodeText.getText()));
    	}
    	if (src.equals(signalText)) {
    		setPropertyValue(event, pack.getEvent_Signal(), nullIfEmpty(signalText.getText()));
    	}
    }
    
    @Override
    public void widgetSelected(SelectionEvent e) {
    	super.widgetSelected(e);
    	Object src= e.getSource();
    	if (src.equals(parAssignButton)) {
			new ParameterAssignmentsAction().run(event);
    	}
    	if (src.equals(eventTypeCombo)) {
			setPropertyValue(event, pack.getEvent_Trigger(), TriggerType.get(eventTypeCombo.getText()));
    	}
    	if (src.equals(messageCombo.getCombo())) {
    		setPropertyValue(event, pack.getEvent_Message(), messageCombo.getSelected());
    	}
    	if (src.equals(implementationCombo.getCombo())) {
    		Implementation implementation= implementationCombo.getSelected();
    		setPropertyValue(event, pack.getEvent_Implementation(), implementation);
    		if (implementation != null) {
	    		if (event.isThrowing() ^ implementation.getParticipant() == event.getPool().getParticipant()) {
    				setPropertyValue(event, pack.getEvent_Message(), implementation.getInputMessage());
	    		} else {
    				setPropertyValue(event, pack.getEvent_Message(), implementation.getOutputMessage());
	    		}
    		}
    	}
    	if (src.equals(linkedToCombo.getCombo())) {
    		Event otherEvent= linkedToCombo.getSelected();
    		if (otherEvent != null) {
    			Event otherLinkedTo= otherEvent.getLinkedTo();
    			if (otherLinkedTo != null) {
    				if (otherLinkedTo != event) {
	    				Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	    				boolean okPressed= MessageDialog.openConfirm(shell, "Link Already Existing", 
	    						"The selected Link Event is already linked to another " +
	    						"Link Event.  Establish link anyway?");
	    				if (! okPressed) {
	    					return;
	    				}
    				}
    				// remove old opposite Link
    				setPropertyValue(otherLinkedTo, pack.getEvent_LinkedTo(), null);
    			}
    			// establish opposite Link
    			setPropertyValue(otherEvent, pack.getEvent_LinkedTo(), event);
    		}
    		// establish Link
    		setPropertyValue(event, pack.getEvent_LinkedTo(), otherEvent);
    	}
    	if (src.equals(highlightOpposite)) {
    		if (event.getLinkedTo() != null) {
    			DiagramEditor editor= (DiagramEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
    			AbstractGraphicalEditPart editPart= Util.getEditPart(event.getLinkedTo(), editor, null);
    			Util.highlight(editPart, editor);
    		}
    	}
    	if (src.equals(activityCombo.getCombo())) {
    		setPropertyValue(event, pack.getEvent_Activity(), activityCombo.getSelected());
    	}
    	refresh();
    }

}