package de.dailab.vsdt.diagram.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.diagram.actions.OrganizeElementsAction;
import de.dailab.vsdt.diagram.ui.VsdtFeatureCombo;

/**
 * A dialog used for organizing web services of a BPMN model elements
 * 
 * @author kuester
 */
public class OrganizeServicesDialog extends AbstractOrganizeElementsDialog<Service> {

	private static final String LABEL_PARTICIPANT = "Participant";
	private static final String LABEL_INTERFACE = "Interface";
	private static final String LABEL_TYPE = "Type";
	private static final String LABEL_OPERATION = "Operation";
	private static final String LABEL_LOCATION = "Location";
	private static final String BUTTON_INPUT = "Input...";
	private static final String BUTTON_OUTPUT = "Output...";
	private static final String BUTTON_PRE = "Precond's...";
	private static final String BUTTON_EFF = "Effects...";
	
	/**implementation.interface input field*/
	private Text interfaceText;
	
	/**implementation.operation input field*/
	private Text operationText;
	
	/**implementation.type*/
	private Combo typeCombo;
	
	/**location*/
	private Text locationText;
	
	/**the list of possible participants*/
	private java.util.List<Participant> participants= new ArrayList<Participant>();
	
	/**implementation.participant input field*/
	private VsdtFeatureCombo<Participant> partCombo;
	
	/**button for opening the organize input properties dialog*/
	private Button inputButton;
	
	/**button for opening the organize output properties dialog*/
	private Button outputButton;
	
	/** button for opening the organize preconditions dialog */
	private Button preButton;
	
	/** button for opening the organize effects dialog */
	private Button effButton;
	
	@Override
	public String getElementName() {
		return "Service";
	}
	
	/**
	 * create a new Organize Services Dialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 */
	public OrganizeServicesDialog(Shell parentShell, EObject parentElement) {
		super(parentShell, parentElement, true, 4);

		BusinessProcessSystem bps= null;
		if (parentElement instanceof BusinessProcessSystem) {
			bps= (BusinessProcessSystem) parentElement;
		} else if (parentElement instanceof BusinessProcessDiagram) {
			bps= (BusinessProcessSystem) ((BusinessProcessDiagram) parentElement).getParent();
		}
		if (bps != null) {
			elements= ((BusinessProcessSystem) parentElement).getServices();
			participants= ((BusinessProcessSystem) parentElement).getParticipants();
		} else {
			throw new IllegalArgumentException("Parent element must be of type BusinessProcessSystem");
		}
	}
	
	@Override
	protected void createEditGroupControls(Group editGroup) {
		//input lines

		new Label(editGroup,SWT.NONE).setText(LABEL_TYPE);
		typeCombo= new Combo(editGroup,SWT.BORDER);
		typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		typeCombo.addModifyListener(this);
		typeCombo.add("");
		typeCombo.add("JIAC Action");
		typeCombo.add("Web Service");

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
	}

	@Override
	protected Service createNewElement() {
		return VsdtFactory.eINSTANCE.createService();
	}
	
	@Override
	protected Control getElementToFocus() {
		return interfaceText;
	}

	@Override
	protected void updateElementFromEditGroup(Service service) {
		if (service!= null) {
			service.setParticipant(partCombo.getSelected());
			service.setOperation(Util.nullIfEmpty(operationText.getText()));
			service.setInterface(Util.nullIfEmpty(interfaceText.getText()));
			service.setType(Util.nullIfEmpty(typeCombo.getText()));
			service.setLocation(Util.nullIfEmpty(locationText.getText()));
		}
	}
	
	@Override
	protected void refreshEditGroup() {
		Service service = getSelectedElement();
		if (service != null) {
			//set interface
			String ifString= Util.nonNull(service.getInterface());
			interfaceText.setText(ifString);
			//set operation
			String opString= Util.nonNull(service.getOperation());
			operationText.setText(opString);
			//set type
			String typeString= Util.nonNull(service.getType());
			typeCombo.setText(typeString);
			//set location
			String locString= Util.nonNull(service.getLocation());
			locationText.setText(locString);
			//set participant, input / output message
			partCombo.setSelected(service.getParticipant());
		}
		partCombo.getCombo().setEnabled(service != null);
		interfaceText.setEnabled(service != null);
		operationText.setEnabled(service != null);
		inputButton.setEnabled(service != null);
		outputButton.setEnabled(service != null);
		preButton.setEnabled(service != null);
		effButton.setEnabled(service != null);
	}

	@Override
	protected Collection<Button> contributeToButtonsGroup(Composite buttonsGroup) {
		inputButton = new Button(buttonsGroup, SWT.NONE);
		inputButton.setText(BUTTON_INPUT);
		inputButton.addSelectionListener(this);
		
		outputButton = new Button(buttonsGroup, SWT.NONE);
		outputButton.setText(BUTTON_OUTPUT);
		outputButton.addSelectionListener(this);
		
		preButton = new Button(buttonsGroup, SWT.NONE);
		preButton.setText(BUTTON_PRE);
		preButton.addSelectionListener(this);
		
		effButton = new Button(buttonsGroup, SWT.NONE);
		effButton.setText(BUTTON_EFF);
		effButton.addSelectionListener(this);
		
		return Arrays.asList(inputButton, outputButton, preButton, effButton);
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		Service service = getSelectedElement();
		if (service != null) {
			if (e.getSource() == inputButton) {
				OrganizeElementsAction.getPropertiesAction(0).run(service);
			}
			if (e.getSource() == outputButton) {
				OrganizeElementsAction.getPropertiesAction(1).run(service);
			}
			if (e.getSource() == preButton) {
				OrganizeElementsAction.getExpressionsAction(0).run(service);
			}
			if (e.getSource() == effButton) {
				OrganizeElementsAction.getExpressionsAction(1).run(service);
			}
		}
	}
	
	@Override
	protected String getString(Service service) {
		if (service != null) {
			String ifString= service.getInterface();
			String opString= service.getOperation();
			String typeString= service.getType();
			StringBuffer buffer= new StringBuffer();
			buffer.append(ifString != null ? ifString : "<unknown>"); //$NON-NLS-1$
			buffer.append(".");
			buffer.append(opString != null ? opString : "<unknown>"); //$NON-NLS-1$
			if (service.getParticipant() != null) {
				buffer.append(" @ "); //$NON-NLS-1$
				buffer.append(service.getParticipant().getName());
			}
			buffer.append(" (");
			buffer.append(typeString != null ? typeString : "unknown type"); //$NON-NLS-1$
			buffer.append(")");
			return buffer.toString();
		}
		return super.getString(service);
	}
}
