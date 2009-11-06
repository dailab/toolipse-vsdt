package de.dailab.vsdt.diagram.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.gmf.ui.dialogs.AbstractOrganizeElementsDialog;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.diagram.actions.OrganizePropertiesAction;

/**
 * A dialog used for organizing messages of a BPMN model elements
 * 
 * @author kuester
 */
public class OrganizeMessagesDialog extends AbstractOrganizeElementsDialog<Message> {

//	public static final String LABEL_TO= "To";
//	public static final String LABEL_FROM= "From";
	public static final String LABEL_NAME= "Name";

	public static final String BUTTON_PROP= "Properties";
	
//	/**message.to input field*/
//	private Combo toPartCombo;
//	
//	/**message.from input field*/
//	private Combo fromPartCombo;
	
	/**message.name input field*/
	private Text nameText;
	
	/**button for opening the organize properties dialog for the selected message*/
	private Button propButton;
	
//	/**the list of possible participants*/
//	private java.util.List<Participant> participants= new ArrayList<Participant>();

//	/**
//	 * These tables hold the relationship between participants and entries in the ComboBox. 
//	 */
//	private Hashtable<Participant, Integer> partToIndexTable= new Hashtable<Participant, Integer>();
//	private Hashtable<Integer, Participant> indexToPartTable= new Hashtable<Integer, Participant>();

	@Override
	public String getElementName() {
		return "Message";
	}
	
	/**
	 * create a new Organize Messages Dialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 */
	public OrganizeMessagesDialog(Shell parentShell, EObject parentElement) {
		super(parentShell, parentElement, true, 4);

		BusinessProcessSystem bps= null;
		if (parentElement instanceof BusinessProcessSystem) {
			bps= (BusinessProcessSystem) parentElement;
		} else if (parentElement instanceof BusinessProcessDiagram) {
			bps= (BusinessProcessSystem) ((BusinessProcessDiagram) parentElement).getBusinessProcessSystem();
		}
		if (bps != null) {
			elements= ((BusinessProcessSystem) parentElement).getMessages();
//			participants= ((BusinessProcessSystem) parentElement).getParticipants();
		} else {
			throw new IllegalArgumentException("Parent element must be of type BusinessProcessSystem");
		}
	}

	@Override
	protected void createEditGroupControls(Group editGroup) {
		//input lines
		new Label(editGroup,SWT.NONE).setText(LABEL_NAME);
		nameText= new Text(editGroup, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
		nameText.addModifyListener(this);
		
//		new Label(editGroup,SWT.NONE).setText(LABEL_FROM);
//		fromPartCombo= new Combo(editGroup,SWT.READ_ONLY);
//		fromPartCombo.addSelectionListener(this);
//
//		new Label(editGroup,SWT.NONE).setText(LABEL_TO);
//		toPartCombo= new Combo(editGroup,SWT.READ_ONLY);
//		toPartCombo.addSelectionListener(this);
//		
//		//populate combo boxes
//		//null-entry (this has to be synchronized with the refreshEditGroup-method!)
//		toPartCombo.add("");
//		fromPartCombo.add("");
//		int index= 1;
//		for (Participant participant : participants) {
//			String label= participant.getName();
//			toPartCombo.add(label);
//			fromPartCombo.add(label);
//			partToIndexTable.put(participant, index);
//			indexToPartTable.put(index, participant);
//			index++;
//		}
	}
	
	@Override
	protected Message createNewElement() {
		Message message= VsdtFactory.eINSTANCE.createMessage();
		return message;
	}
	
	@Override
	protected Control getElementToFocus() {
		return nameText;
	}

	@Override
	protected void refreshButtons() {
		super.refreshButtons();
		propButton.setEnabled(elementList.getSelectionCount()==1);
	}
	
	@Override
	protected void updateElementFromEditGroup(Message message) {
		if (message != null) {
//			int selectedPart= toPartCombo.getSelectionIndex();
//			Participant participant= indexToPartTable.get(selectedPart);
//			message.setTo(participant);
//			
//			selectedPart= fromPartCombo.getSelectionIndex();
//			participant= indexToPartTable.get(selectedPart);
//			message.setFrom(participant);
			
			String nameString= Util.nullIfEmpty(nameText.getText());
			message.setName(nameString);
		}
	}
	
	@Override
	protected void refreshEditGroup() {
		Message message= getSelectedElement();
		if (message != null) {
			//select participant from Combo box 
//			Participant participant= message.getTo();
//			if (participant != null) {
//				toPartCombo.select(partToIndexTable.get(participant));
//			} else {
//				//select first entry, which is the null entry
//				toPartCombo.select(0);
//			}
//			participant= message.getFrom();
//			if (participant != null) {
//				fromPartCombo.select(partToIndexTable.get(participant));
//			} else {
//				//select first entry, which is the null entry
//				fromPartCombo.select(0);
//			}
			
			String nameString= Util.nonNull(message.getName());
			nameText.setText(nameString);
		}
//		toPartCombo.setEnabled(message != null);
//		fromPartCombo.setEnabled(message != null);
		nameText.setEnabled(message != null);
	}
	
	@Override
	protected String getString(Message message) {
		if (message != null) {
			String nameString= message.getName();
			StringBuffer buffer= new StringBuffer();
			buffer.append(nameString != null ? nameString : "<unnamed>"); //$NON-NLS-1$
//			buffer.append(" ( ");
//			buffer.append(getParticipantName(message.getFrom()));
//			buffer.append(" -> ");
//			buffer.append(getParticipantName(message.getTo()));
//			buffer.append(" )");
			return buffer.toString();	
		}
		return super.getString(message);
	}
	
//	private String getParticipantName(Participant participant) {
//		final String unknown= "<unknown>";
//		if (participant == null || participant.getName() == null || participant.getName().isEmpty()) {
//			return unknown;
//		}
//		return participant.getName();
//	}
	
	@Override
	protected void contributeToButtonsGroup(Composite buttonsGroup) {
		propButton= new Button(buttonsGroup,SWT.NONE);
		propButton.setText(BUTTON_PROP);
		propButton.addSelectionListener(this);
	}
	
	@Override
	protected void handleDoubleClick(Message selected) {
		displayPropertiesDialog();
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		super.widgetSelected(e);
		if (e.getSource() instanceof Button	) {
			Button button = (Button) e.getSource();
			String cmd= button.getText();
			if (BUTTON_PROP.equals(cmd)) {
				displayPropertiesDialog();
			}
		}
	}
	
	private void displayPropertiesDialog() {
		Message message= (Message) getSelectedElement();
		new OrganizePropertiesAction().run(message);
	}
}
