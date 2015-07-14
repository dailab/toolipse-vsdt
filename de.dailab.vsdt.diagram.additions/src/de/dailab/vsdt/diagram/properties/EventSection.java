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
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.actions.ParameterAssignmentsAction;
import de.dailab.vsdt.diagram.ui.ExpressionComposite;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;
import de.dailab.vsdt.util.VsdtHelper;

public class EventSection extends FlowObjectSection {
	
	public static final String DISPLAY_TRIGGER= "Trigger",
							   DISPLAY_INTERRUPTING= "Non-Interrupting",
							   DISPLAY_GROUP= "Event Trigger Attributes",
//							   DISPLAY_MESSAGE= "Message",
							   DISPLAY_IMPL= "Implementation",
							   DISPLAY_TIME_EXPRESSION= "Time Expr.",
							   DISPLAY_TIME_IS_DURATION= "As Duration?",
							   DISPLAY_ERROR= "Error Code",
							   DISPLAY_RULE_EXP= "Rule Expression",
							   DISPLAY_LINK= "Linked To",
							   DISPLAY_ACTIVITY= "Compensate",
							   DISPLAY_SIGNAL= "Signal",
							   DISPLAY_SIGNAL_THROWN = "thrown",

							   DISPLAY_HIGHLIGH_LINK= "Highlight Opposite",
							   DISPLAY_PAR_ASSIGN= "Parameter Assignments...";
	
    protected Event event;
    private boolean firstrun= true;

    private Combo eventTypeCombo;
    
    private Group triggerGroup;
//    private VsdtFeatureCombo<Message> messageCombo;
    private VsdtFeatureCombo<Implementation> implementationCombo;
    private ExpressionComposite timeExpressionComp;
    private Button asDurationButton;
    private ExpressionComposite ruleExpText;
    private VsdtFeatureCombo<Event> linkedToCombo;
    private Text errorCodeText;
    private VsdtFeatureCombo<Activity> activityCombo;
    private Text signalText;
    private Button signalThrownButton;
    
    private Button nonInterruptingButton;

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
        	timeExpressionComp.setOwnerAndFeature(event, pack.getEvent_TimeExpression());
        	ruleExpText.setOwnerAndFeature(event, pack.getEvent_RuleExpression());
        }
    }

    @Override
 	protected void internalRefresh() {
    	super.internalRefresh();
    	if (firstrun) {
    		BusinessProcessDiagram bpd= event.getPool().getParent();
    		BusinessProcessSystem bps= bpd.getParent();
    		List<Implementation> allImplementations = new ArrayList<Implementation>();
    		allImplementations.addAll(bps.getServices());
    		allImplementations.addAll(bps.getMessageChannels());
    		implementationCombo.fillCombo(allImplementations);
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
			List<FlowObject> fos= VsdtHelper.getAllGraphicalElements(event.getPool());
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
		nonInterruptingButton.setSelection(event.isNonInterrupting());
        nonInterruptingButton.setEnabled(event.isOnBoundary() || ((event instanceof Start) && event.isInEventedSubprocess()));

//		messageCombo.setSelected(event.getMessage());
    	implementationCombo.setSelected(event.getImplementation());
    	timeExpressionComp.setText(getExpression(event.getTimeExpression()));
    	asDurationButton.setSelection(event.isAsDuration());
    	errorCodeText.setText(nonNull(event.getErrorCode()));
    	ruleExpText.setText(getExpression(event.getRuleExpression()));
    	linkedToCombo.setSelected(event.getLinkedTo());
    	activityCombo.setSelected(event.getActivity());
    	signalText.setText(nonNull(event.getSignal()));
    	signalThrownButton.setSelection(event.isSignalThrown());
    	
    	parAssignButton.setEnabled(event.getImplementation() != null && event.getTrigger() == TriggerType.MESSAGE);
    	
    	if (eventTypeCombo.getSelectionIndex() != -1) {
    		TriggerType trigger = TriggerType.get(eventTypeCombo.getItem(eventTypeCombo.getSelectionIndex()));
    		List<TriggerType> validTriggerTypes= event.getValidTriggerTypes();
    		boolean isMulti= TriggerType.MULTIPLE == trigger;
    		implementationCombo.getCombo().setEnabled(TriggerType.MESSAGE == trigger || isMulti && validTriggerTypes.contains(TriggerType.MESSAGE));
//        	messageCombo.getCombo().setEnabled(messageCombo.getCombo().isEnabled());
        	errorCodeText.setEnabled(TriggerType.ERROR== trigger || isMulti && validTriggerTypes.contains(TriggerType.ERROR));
        	timeExpressionComp.setEnabled(TriggerType.TIMER == trigger || isMulti && validTriggerTypes.contains(TriggerType.TIMER));
        	asDurationButton.setEnabled(timeExpressionComp.isEnabled());
        	ruleExpText.setEnabled(TriggerType.RULE== trigger || isMulti && validTriggerTypes.contains(TriggerType.RULE));
        	linkedToCombo.getCombo().setEnabled(TriggerType.LINK == trigger || isMulti && validTriggerTypes.contains(TriggerType.LINK));
        	highlightOpposite.setEnabled(linkedToCombo.getCombo().isEnabled() && event.getLinkedTo() != null);
        	activityCombo.getCombo().setEnabled(TriggerType.COMPENSATION == trigger || isMulti && validTriggerTypes.contains(TriggerType.COMPENSATION));
        	signalText.setEnabled(TriggerType.SIGNAL== trigger || isMulti && validTriggerTypes.contains(TriggerType.SIGNAL));
    	}
    }
 
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        CLabel label;
        
        parAssignButton = addButton(DISPLAY_PAR_ASSIGN);

        // event type and attributes
        label= FormLayoutUtil.addLabel(composite, DISPLAY_TRIGGER, lastControl, 0);
        eventTypeCombo= FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, lastControl, label, 50);
        eventTypeCombo.addSelectionListener(this);
        
        // non-interrupting?
        nonInterruptingButton= FormLayoutUtil.addButton(composite, DISPLAY_INTERRUPTING, SWT.CHECK, lastControl, eventTypeCombo, null);
        nonInterruptingButton.addSelectionListener(this);
        
        // trigger type group
        triggerGroup= FormLayoutUtil.addGroup(composite, DISPLAY_GROUP, eventTypeCombo, 0, 100);
        
        //message trigger
        label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_IMPL, 0, 0);
    	implementationCombo= new VsdtFeatureCombo<Implementation>(FormLayoutUtil.addCombo(triggerGroup, SWT.READ_ONLY, 0, label, 50));
		implementationCombo.getCombo().addSelectionListener(this);
		
//        label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_MESSAGE, implementationCombo.getCombo(), 0);
//    	messageCombo= new VsdtFeatureCombo<Message>(FormLayoutUtil.addCombo(triggerGroup, SWT.READ_ONLY, implementationCombo.getCombo(), label, 50));
//    	messageCombo.getCombo().addSelectionListener(this);
		
		//timer trigger
        asDurationButton= FormLayoutUtil.addButton(triggerGroup, DISPLAY_TIME_IS_DURATION, SWT.CHECK, implementationCombo.getCombo(), null, 50);
        asDurationButton.addSelectionListener(this);
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_TIME_EXPRESSION, implementationCombo.getCombo(), 0);
		timeExpressionComp= addExpressionComposite(triggerGroup, implementationCombo.getCombo(), label, asDurationButton);
		
		//error trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_ERROR, timeExpressionComp, 0);
		errorCodeText= FormLayoutUtil.addText(triggerGroup, timeExpressionComp, label, 50, SWT.NONE);
		errorCodeText.addFocusListener(this);
		
		//compensation trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_ACTIVITY, errorCodeText, 0);
		activityCombo= new VsdtFeatureCombo<Activity>(FormLayoutUtil.addCombo(triggerGroup, SWT.READ_ONLY, errorCodeText, label, 50));
		activityCombo.getCombo().addSelectionListener(this);
		
		//rule trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_RULE_EXP, 0, 50);
		ruleExpText= addExpressionComposite(triggerGroup, 0, label, 100);
		
		//link trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_LINK, ruleExpText, 50);
		highlightOpposite= FormLayoutUtil.addButton(triggerGroup, DISPLAY_HIGHLIGH_LINK, SWT.NONE, ruleExpText, null, 100);
		highlightOpposite.addSelectionListener(this);
		linkedToCombo= new VsdtFeatureCombo<Event>(FormLayoutUtil.addCombo(triggerGroup, SWT.READ_ONLY, ruleExpText, label, highlightOpposite));
		linkedToCombo.getCombo().addSelectionListener(this);
		
		//signal trigger
		label= FormLayoutUtil.addLabel(triggerGroup, DISPLAY_SIGNAL, linkedToCombo.getCombo(), 50);
		signalThrownButton = FormLayoutUtil.addButton(triggerGroup, DISPLAY_SIGNAL_THROWN, SWT.CHECK, linkedToCombo.getCombo(), null, 100);
		signalThrownButton.addSelectionListener(this);
		signalText= FormLayoutUtil.addText(triggerGroup, linkedToCombo.getCombo(), label, signalThrownButton, SWT.NONE);
		signalText.addFocusListener(this);
    }
    
    public void focusLost(FocusEvent e) {
    	super.focusLost(e);
    	Object src= e.getSource();
    	// expressions are handled by the ExpressionComposites (see setInput)
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
//    	if (src.equals(messageCombo.getCombo())) {
//    		setPropertyValue(event, pack.getEvent_Message(), messageCombo.getSelected());
//    	}
    	if (src.equals(implementationCombo.getCombo())) {
    		Implementation implementation= implementationCombo.getSelected();
    		setPropertyValue(event, pack.getEvent_Implementation(), implementation);
//    		if (implementation != null) {
//	    		if (event.isThrowing() ^ implementation.getParticipant() == event.getPool().getParticipant()) {
//    				setPropertyValue(event, pack.getEvent_Message(), implementation.getInputMessage());
//	    		} else {
//    				setPropertyValue(event, pack.getEvent_Message(), implementation.getOutputMessage());
//	    		}
//    		}
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
    	if (src.equals(asDurationButton)) {
    		setPropertyValue(event, pack.getEvent_AsDuration(), asDurationButton.getSelection());
    	}
    	if (src.equals(nonInterruptingButton)) {
    		setPropertyValue(event, pack.getEvent_NonInterrupting(), nonInterruptingButton.getSelection());
    	}
    	if (src.equals(signalThrownButton)) {
    		setPropertyValue(event, pack.getEvent_SignalThrown(), signalThrownButton.getSelection());
    	}
    	refresh();
    }

}