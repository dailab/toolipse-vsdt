package de.dailab.vsdt.diagram.dialogs;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.dialogs.AbstractOrganizeElementsDialog;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.diagram.actions.OrganizeMessagesAction;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;

/**
 * A dialog used for organizing web services of a BPMN model elements
 * 
 * @author kuester
 */
public class OrganizeImplementationsDialog extends AbstractOrganizeElementsDialog<Implementation> {

	public static final String LABEL_PARTICIPANT= "Participant";
	public static final String LABEL_INTERFACE= "Interface";
	public static final String LABEL_TYPE= "Type";
	public static final String LABEL_OPERATION= "Operation";
	public static final String LABEL_LOCATION= "Location";
	public static final String LABEL_INPUT= "Input Message";
	public static final String LABEL_OUTPUT= "Output Message";
	
	public static final String BUTTON_MSG= "Messages...";
	
	/**implementation.interface input field*/
	private Text interfaceText;
	
	/**implementation.operation input field*/
	private Text operationText;
	
	/**implementation.type*/
	private Text typeText;
	
	/**location*/
	private Text locationText;
	
	/**the list of possible participants*/
	private java.util.List<Participant> participants= new ArrayList<Participant>();
	
	/**implementation.participant input field*/
	private VsdtFeatureCombo<Participant> partCombo;
	
	/**the list of possible messages*/
	private java.util.List<Message> messages= new ArrayList<Message>();
	
	/**implementation.inputMessage input field*/
	private VsdtFeatureCombo<Message> inputCombo;
	
	/**implementation.outputMessage input field*/
	private VsdtFeatureCombo<Message> outputCombo;
	
	/**button for opening the organize messages dialog*/
	private Button msgButton;
	
	@Override
	public String getElementName() {
		return "Implementation";
	}
	
	@Override
	public int getHeight() {
		return 500;
	}
	
	/**
	 * create a new Organize Assignments Dialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 */
	public OrganizeImplementationsDialog(Shell parentShell, EObject parentElement) {
		super(parentShell, parentElement, true, 4);

		BusinessProcessSystem bps= null;
		if (parentElement instanceof BusinessProcessSystem) {
			bps= (BusinessProcessSystem) parentElement;
		} else if (parentElement instanceof BusinessProcessDiagram) {
			bps= (BusinessProcessSystem) ((BusinessProcessDiagram) parentElement).getParent();
		}
		if (bps != null) {
			elements= ((BusinessProcessSystem) parentElement).getImplementations();
			participants= ((BusinessProcessSystem) parentElement).getParticipants();
			messages= ((BusinessProcessSystem) parentElement).getMessages();
		} else {
			throw new IllegalArgumentException("Parent element must be of type BusinessProcessSystem");
		}
	}
	
	@Override
	protected void createEditGroupControls(Group editGroup) {
		//input lines

		new Label(editGroup,SWT.NONE).setText(LABEL_TYPE);
		typeText= new Text(editGroup,SWT.BORDER);
		typeText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		typeText.addModifyListener(this);

		new Label(editGroup,SWT.NONE).setText(LABEL_PARTICIPANT);
		partCombo= new VsdtFeatureCombo<Participant>(new Combo(editGroup,SWT.READ_ONLY));
		partCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		partCombo.getCombo().addSelectionListener(this);
		partCombo.fillCombo(participants);

		new Label(editGroup,SWT.NONE).setText(LABEL_INTERFACE);
		interfaceText= new Text(editGroup, SWT.BORDER);
		interfaceText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		interfaceText.addModifyListener(this);
		
		new Label(editGroup,SWT.NONE).setText(LABEL_OPERATION);
		operationText= new Text(editGroup,SWT.BORDER);
		operationText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		operationText.addModifyListener(this);

		new Label(editGroup,SWT.NONE).setText(LABEL_LOCATION);
		locationText= new Text(editGroup,SWT.BORDER);
		locationText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		locationText.addModifyListener(this);
		
		new Label(editGroup,SWT.NONE).setText(LABEL_INPUT);
		inputCombo= new VsdtFeatureCombo<Message>(new Combo(editGroup,SWT.READ_ONLY));
		inputCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		inputCombo.getCombo().addSelectionListener(this);
		inputCombo.fillCombo(messages);
		
		new Label(editGroup,SWT.NONE).setText(LABEL_OUTPUT);
		outputCombo= new VsdtFeatureCombo<Message>(new Combo(editGroup,SWT.READ_ONLY));
		outputCombo.getCombo().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		outputCombo.getCombo().addSelectionListener(this);
		outputCombo.fillCombo(messages);
	}

	@Override
	protected Implementation createNewElement() {
		Implementation implementation= VsdtFactory.eINSTANCE.createImplementation();
		return implementation;
	}
	
	@Override
	protected Control getElementToFocus() {
		return interfaceText;
	}

	@Override
	protected void updateElementFromEditGroup(Implementation implementation) {
		if (implementation != null) {
			implementation.setParticipant(partCombo.getSelected());
			implementation.setOperation(Util.nullIfEmpty(operationText.getText()));
			implementation.setInterface(Util.nullIfEmpty(interfaceText.getText()));
			implementation.setType(Util.nullIfEmpty(typeText.getText()));
			implementation.setLocation(Util.nullIfEmpty(locationText.getText()));
			implementation.setInputMessage(inputCombo.getSelected());
			implementation.setOutputMessage(outputCombo.getSelected());
		}
	}
	
	@Override
	protected void refreshEditGroup() {
		Implementation implementation= getSelectedElement();
		if (implementation != null) {
			//set interface
			String ifString= Util.nonNull(implementation.getInterface());
			interfaceText.setText(ifString);
			//set operation
			String opString= Util.nonNull(implementation.getOperation());
			operationText.setText(opString);
			//set type
			String typeString= Util.nonNull(implementation.getType());
			typeText.setText(typeString);
			//set location
			String locString= Util.nonNull(implementation.getLocation());
			locationText.setText(locString);
			//set participant, input / output message
			partCombo.setSelected(implementation.getParticipant());
			inputCombo.setSelected(implementation.getInputMessage());
			outputCombo.setSelected(implementation.getOutputMessage());
		}
		partCombo.getCombo().setEnabled(implementation != null);
		interfaceText.setEnabled(implementation != null);
		operationText.setEnabled(implementation != null);
	}
	

	@Override
	protected void contributeToButtonsGroup(Composite buttonsGroup) {
		msgButton= new Button(buttonsGroup,SWT.NONE);
		msgButton.setText(BUTTON_MSG);
		msgButton.addSelectionListener(this);
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		if (e.getSource() instanceof Button	) {
			Button button = (Button) e.getSource();
			String cmd= button.getText();
			if (BUTTON_MSG.equals(cmd)) {
				new OrganizeMessagesAction().run(parentElement);
				// update message combos
				inputCombo.fillCombo(messages);
				outputCombo.fillCombo(messages);
			}
		}
	}
	
	@Override
	protected String getString(Implementation implementation) {
		if (implementation != null) {
			String ifString= implementation.getInterface();
			String opString= implementation.getOperation();
			String typeString= implementation.getType();
			StringBuffer buffer= new StringBuffer();
			buffer.append(ifString != null ? ifString : "<unknown>"); //$NON-NLS-1$
			buffer.append(".");
			buffer.append(opString != null ? opString : "<unknown>"); //$NON-NLS-1$
			if (implementation.getParticipant() != null) {
				buffer.append(" @ "); //$NON-NLS-1$
				buffer.append(implementation.getParticipant().getName());
			}
			buffer.append(" (");
			buffer.append(typeString != null ? typeString : "unknown type"); //$NON-NLS-1$
			buffer.append(")");
			return buffer.toString();
		}
		return super.getString(implementation);
	}
}
