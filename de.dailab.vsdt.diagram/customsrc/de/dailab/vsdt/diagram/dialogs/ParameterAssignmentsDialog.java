package de.dailab.vsdt.diagram.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;
import de.dailab.vsdt.util.VsdtElementFactory;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * This Dialog can be used for easily assigning values to the input and output
 * parameters of service calls and sent and received messages.  For that purpose,
 * two columns of ComboBoxes are displayed, one for each Property of the input
 * and output Messages, which can be used for assigning values to the input
 * parameters and to assign the output parameters to local Properties.  Based on 
 * the selection in the ComboBoxes, Assignments are created for that element.
 *   
 * The benefit of this dialog, besides an improved usability, is that no input
 * and output parameter can be missed, and AssignTimes are set accordingly, too.
 * 
 * @author kuester
 */
public class ParameterAssignmentsDialog extends TitleAreaDialog {

	public static final String TITLE= "Parameter Assignments Dialog";
	public static final String MESSAGE= "Use this dialog for easily organizing " +
			"Assignments to the input and output Parameters \n of the Messages " +
			"outgoing and incoming to this Element.";
	public static final String WARNING_INCOMPLETE_INPUT= "There are unassigned " +
			"input parameters left. Exit anyway?";
	
	private static final String ARROW = "->"; // "\u2192"; // unicode rightward arrow
	
	/** The parent element (Activity or Event) */
	protected final FlowObject parentElement;
	
	/** The input properties for this activity or event */
	protected List<Property> input= null;
	
	/** The output properties for this activity or event */
	protected List<Property> output= null;
	
	/** Properties available for being assigned to the parameters */
	protected final List<Property> availableProperties;
	
	/** Associations of properties to parameters for the input message */ 
	protected final Map<Property, Combo> inputParameterMap;
	
	/** Associations of properties to parameters for the output message */
	protected final Map<Property, VsdtFeatureCombo<Property>> outputParameterMap;
	
	/** Existing assignments to and from service parameters */
	protected final Map<Property, Assignment> parameterAssignmentsMap;
	
	/** error message to be displayed, or null */
	protected String errorMessage= null;
	
	/**
	 * Create new Parameter Assignment Dialog.  Besides the Shell, the element
	 * being parent to the Assignment to create has to be passed.  As this dialog
	 * is about easily assigning values to Message Parameters, the parent element
	 * has to be of class Activity or Event and has to have one of the types
	 * SERVICE, SEND, RECEIVE, or MESSAGE respectively.  Further, the element's 
	 * implementation must not be null, which is needed to determine which 
	 * Message is the input and which one the output to the parent element (and 
	 * not to the service to be called!).
	 * 
	 * After the Messages have been determined, the Properties available for the 
	 * parent element are determined, which are the visibleProperties of that 
	 * FlowObject (see {@link FlowObject#getVisibleProperties()}), minus the 
	 * Properties of the two Messages.
	 * 
	 * @param parentShell		The Shell
	 * @param parentElement		Activity or Event with Implementation != null
	 */
	public ParameterAssignmentsDialog(Shell parentShell, EObject parentElement) {
		super(parentShell);
		setTitle(TITLE);
		setShellStyle(getShellStyle() | SWT.RESIZE);

		Implementation implementation = null;
		
		// set input and output according to parent element
		if (parentElement instanceof Activity) {
			Activity activity = (Activity) parentElement;
			implementation = activity.getImplementation();
			if (implementation instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) implementation;
				if (channel.getPayload() != null) {
					if (activity.getActivityType() == ActivityType.SEND) {
						input= Arrays.asList(channel.getPayload());
					} else if (activity.getActivityType() == ActivityType.RECEIVE) {
						output= Arrays.asList(channel.getPayload());
					}
				}
			}
			if (implementation instanceof Service) {
				Service service = (Service) implementation;
				boolean notSameParticipant = activity.getPool().getParticipant() != service.getParticipant();
				switch (activity.getActivityType()) {
				case SEND:
					// send can be service invocation or reply
					input = notSameParticipant ? service.getInput() : service.getOutput(); 
					break;
				case RECEIVE:
					// receive can be reply or service invocation
					output = notSameParticipant ? service.getOutput() : service.getInput();
					break;
				case SERVICE:
				case USER:
					input = service.getInput();
					output = service.getOutput();
					break;
				}
			}
		} else if (parentElement instanceof Event) {
			Event event = (Event) parentElement;
			implementation = event.getImplementation();
			if (implementation instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) implementation;
				if (channel.getPayload() != null) {
					if (event.isThrowing()) {
						input= Arrays.asList(channel.getPayload());
					} else {
						output= Arrays.asList(channel.getPayload());
					}
				}
			}
			if (implementation instanceof Service) {
				Service service = (Service) implementation;
				boolean notSameParticipant = event.getPool().getParticipant() != service.getParticipant();
				if (event.isThrowing()) {
					input= notSameParticipant ? service.getInput() : service.getOutput();
				} else {
					output= notSameParticipant ? service.getOutput() : service.getInput();
				}
			}
		} else {
			throw new IllegalArgumentException("Expecting an Activity or Event with Implementation != null");
		}
		this.parentElement= (FlowObject) parentElement;

		/*
		 * Available Properties are the Properties of the element and its parent 
		 * elements, but not the Properties of the input and output Messages.
		 */
		availableProperties= new ArrayList<Property>();
		if (parentElement != null) {
			availableProperties.addAll(VsdtHelper.getVisibleProperties(parentElement));
			// remove the message's / service's own properties
			if (implementation != null) {
				List<Property> params = VsdtHelper.getVisibleProperties(implementation);
				availableProperties.removeAll(params);
			}
		}
		inputParameterMap= new HashMap<Property, Combo>();
		outputParameterMap= new HashMap<Property, VsdtFeatureCombo<Property>>();
		parameterAssignmentsMap= new HashMap<Property, Assignment>();
	}
	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.TitleAreaDialog#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(Composite parent) {
		Control superContent = super.createContents(parent);

		parent.getShell().setText( TITLE );
		setMessage( MESSAGE );
		setErrorMessage(errorMessage);
		if (errorMessage != null) {
			getButton(IDialogConstants.OK_ID).setEnabled( false );
		}
		return superContent;
	}
	

	/**
	 * Create the groups of ComboBoxes for the input or output message.  For each
	 * Property of the respective Message, a ComboBox is created.  For input
	 * messages, the ComboBox can be edited, as the value will result in an
	 * Expression.  For output messages, the ComboBox is read-only, as in this
	 * case the value has to correspond to an existing property.  Initially, all 
	 * existing Properties of the FlowObject and its parents are inserted into 
	 * the ComboBoxes.
	 * 
	 * After the groups have been created, the initial selection of the ComboBoxes 
	 * is derived from existing Assignments.  Iterating over the Properties of 
	 * the inMessage and outMessage, if an Assignment if found to or from that 
	 * Property, the Expression or Property assigned to that Property is selected 
	 * for the respective ComboBox. If more than one Assignment correspond to a 
	 * given Property, only the first one is taken into account.  
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite superComposite = (Composite) super.createDialogArea(parent);
		
		ScrolledComposite scrolledComposite= new ScrolledComposite(superComposite, SWT.V_SCROLL | SWT.H_SCROLL);
		scrolledComposite.setLayoutData( new GridData( GridData.FILL_BOTH ) );
		scrolledComposite.setLayout(new FillLayout());
		
		Composite composite = new Composite( scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(2,true));
		
		// add input parameter group
		Group inputGroup= new Group(composite, SWT.NONE);
		inputGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		inputGroup.setLayout(new GridLayout(2, false));
		inputGroup.setText("Sending");
		if (input != null) {
			for (Property property : input) {
				// create ComboBox
				Combo combo= new Combo(inputGroup, SWT.NONE);
				combo.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
				for (Property prop : availableProperties) {
					combo.add(getString(prop));
				}
				for (Assignment assignment : parentElement.getAssignments()) {
					if (assignment.getTo() == property) {
						if (assignment.getFrom() != null &&
								assignment.getAssignTime() == AssignTimeType.START) {
							combo.setText(assignment.getFrom().getExpression());
							parameterAssignmentsMap.put(property, assignment);
							break;
						}
					}
				}
				inputParameterMap.put(property, combo);
				// create Label
				Label label= new Label(inputGroup, SWT.NONE);
				label.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
				label.setText(ARROW + " " + property.getName());
			}
		}
		
		// add output parameter group
		Group outputGroup= new Group(composite, SWT.NONE);
		outputGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		outputGroup.setLayout(new GridLayout(2, false));
		outputGroup.setText("Receiving");
		if (output != null) {
			for (Property property : output) {
				// create Label
				Label label= new Label(outputGroup, SWT.NONE);
				label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
				label.setText(property.getName() + " " + ARROW);
				// create ComboBox
				VsdtFeatureCombo<Property> combo= new VsdtFeatureCombo<Property>(new Combo(outputGroup, SWT.READ_ONLY)) {
					protected String getLabel(Property o) {
						return getString(o);
					}
				};
				combo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
				combo.fillCombo(availableProperties);
				for (Assignment assignment : parentElement.getAssignments()) {
					if (assignment.getFrom().getExpression() != null &&
							assignment.getAssignTime() == AssignTimeType.END && 
							assignment.getFrom().getExpression().equals(getString(property))) {
						combo.setSelected(assignment.getTo());
						parameterAssignmentsMap.put(property, assignment);
						break;
					}
				}
				outputParameterMap.put(property, combo);
			}
		}
		scrolledComposite.setContent(composite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		scrolledComposite.setMinHeight(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
		return superComposite;
	}

	/**
	 * On pressing the OK button, the Assignments specified in the dialog are 
	 * synchronized with existing Assignments.  For that purpose, the 
	 * {@link #parameterAssignmentsMap} is searched for an existing Assignments 
	 * to that Property, inserted into the Map in the {@link #setInitialSelection()} 
	 * method.  In this case, the existing Assignment will be updated or removed 
	 * accordingly.  Otherwise, a new Assignments may be created.
	 */
	@Override
	protected void okPressed() {
		// check for unassigned input parameters
		if (input != null) {
			for (Property property : input) {
				Combo combo= inputParameterMap.get(property);
				String text= combo.getText().trim();
				if (text.isEmpty()) {
					MessageDialog dialog = new MessageDialog(getShell(), "Warning", 
							null, WARNING_INCOMPLETE_INPUT, MessageDialog.WARNING, 
							new String[] { IDialogConstants.OK_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
					if (dialog.open() == IDialogConstants.OK_ID) {
						break;
					} else {
						return;
					}
				}
			}
		}
		
		// handle input message parameters
		if (input != null) {
			for (Property property : input) {
				Combo combo= inputParameterMap.get(property);
				String text= combo.getText().trim();
				// test whether an assignment exists for that property
				if (parameterAssignmentsMap.containsKey(property)) {
					Assignment assignment= parameterAssignmentsMap.get(property);
					if (text.equals("")) {
						// remove assignment
						parentElement.getAssignments().remove(assignment);
					} else {
						// update assignment
						if (assignment.getFrom() == null) {
							assignment.setFrom(VsdtElementFactory.createExpression(text));
						} else {
							assignment.getFrom().setExpression(text);
						}
					}
				} else if (! text.equals("")) {
					// create a new assignment and add it to the parent element
					Assignment assignment= VsdtFactory.eINSTANCE.createAssignment();
					assignment.setAssignTime(AssignTimeType.START);
					assignment.setTo(property);
					assignment.setFrom(VsdtElementFactory.createExpression(combo.getText()));
					parentElement.getAssignments().add(assignment);
				}
			}
		}
		// handle output message parameters
		if (output != null) {
			for (Property property : output) {
				VsdtFeatureCombo<Property> combo= outputParameterMap.get(property);
				Property selected= combo.getSelected();
				// test whether an assignment exists for that property
				if (parameterAssignmentsMap.containsKey(property)) {
					Assignment assignment= parameterAssignmentsMap.get(property);
					if (selected == null) {
						// remove assignment
						parentElement.getAssignments().remove(assignment);
					} else {
						// update assignment
						assignment.setTo(selected);
					}
				} else if (selected != null) {
					// create a new assignment and add it to the parent element
					Assignment assignment= VsdtFactory.eINSTANCE.createAssignment();
					assignment.setAssignTime(AssignTimeType.END);
					assignment.setTo(selected);
					assignment.setFrom(VsdtElementFactory.createExpression(getString(property)));
					parentElement.getAssignments().add(assignment);
				}
			}
		}
		super.okPressed();
	}
	
	/**
	 * Little helper method for uniform string representation of properties. 
	 * This also has to comply to the VSDT Expression Language syntax.
	 * A Property with name "foo" is represented as "foo"
	 * 
	 * @param p		some property
	 * @return		uniformly formatted string representation
	 */
	private String getString(Property p) {
		return p != null? p.getName() : null;
	}
		
}
