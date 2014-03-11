package de.dailab.vsdt.diagram.dialogs;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.dailab.common.gmf.Util;
import de.dailab.common.swt.dialogs.AbstractOrganizeElementsDialog;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.util.VsdtElementFactory;

/**
 * A dialog used for organizing messages of a BPMN model elements
 * 
 * @author kuester
 */
public class OrganizeMessageChannelsDialog extends AbstractOrganizeElementsDialog<MessageChannel> {

	// TODO use the same combo boxes for types as in OrganizePropertiesDialog
	
	public static final String LABEL_CHANNEL= "Name / Channel";
	public static final String LABEL_PAYLOAD_NAME= "Name";
	public static final String LABEL_PAYLOAD_TYPE= "Type";

	public static final String BUTTON_IS_CHANNEL= "Message Channel?";
	public static final String BUTTON_HAS_PAYLOAD= "Has Payload?";
	
	/** messagechannel.channel input field */
	private Text channelText;
	
	/** check box for whether this message channel is a message channel, or a message to an individual agent */
	//XXX transitional, until message element is split up in channel and individual message
	private Button isChannelButton;
	
	/** check box for whether the message has a paylod (if no payload, it could be e.g. a pure 'ping' signal) */
	private Button hasPayloadButton;
	
	/** group holding information on payload, similar to PropertiesDialog */
	private Group payloadGroup;
	
	/** messagechannel.payload.name input field */
	private Text payloadNameText;

	/** messagechannel.payload.type input field */
	private Text payloadTypeText;

	@Override
	public String getElementName() {
		return "MessageChannel";
	}
	
	/**
	 * create a new Organize Messages Dialog
	 * 
	 * @param parentShell	the parent shell (will be blocked)
	 */
	public OrganizeMessageChannelsDialog(Shell parentShell, EObject parentElement) {
		super(parentShell, parentElement, true, 4);

		BusinessProcessSystem bps= null;
		if (parentElement instanceof BusinessProcessSystem) {
			bps= (BusinessProcessSystem) parentElement;
		} else if (parentElement instanceof BusinessProcessDiagram) {
			bps= (BusinessProcessSystem) ((BusinessProcessDiagram) parentElement).getParent();
		}
		if (bps != null) {
			elements= ((BusinessProcessSystem) parentElement).getMessageChannels();
		} else {
			throw new IllegalArgumentException("Parent element must be of type BusinessProcessSystem");
		}
	}

	@Override
	protected void createEditGroupControls(Group editGroup) {
		//input lines
		new Label(editGroup, SWT.NONE).setText(LABEL_CHANNEL);
		channelText= new Text(editGroup, SWT.BORDER);
		channelText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		channelText.addModifyListener(this);
		
		isChannelButton= new Button(editGroup, SWT.CHECK);
		isChannelButton.setText(BUTTON_IS_CHANNEL);
		isChannelButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		isChannelButton.addSelectionListener(this);
		
		hasPayloadButton = new Button(editGroup, SWT.CHECK);
		hasPayloadButton.setText(BUTTON_HAS_PAYLOAD);
		hasPayloadButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		hasPayloadButton.addSelectionListener(this);
		
		payloadGroup = new Group(editGroup, SWT.NONE);
		payloadGroup.setText("Payload");
		payloadGroup.setLayout(new GridLayout(4, false));
		payloadGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
		
		new Label(payloadGroup, SWT.NONE).setText(LABEL_PAYLOAD_NAME);
		payloadNameText= new Text(payloadGroup, SWT.BORDER);
		payloadNameText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		payloadNameText.addModifyListener(this);
		
		new Label(payloadGroup, SWT.NONE).setText(LABEL_PAYLOAD_TYPE);
		payloadTypeText= new Text(payloadGroup, SWT.BORDER);
		payloadTypeText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		payloadTypeText.addModifyListener(this);
		
		enableGroupControls(payloadGroup, false);
	}
	
	@Override
	protected MessageChannel createNewElement() {
		return VsdtElementFactory.createMessageChannel("new channel", null);
	}
	
	@Override
	protected Control getElementToFocus() {
		return channelText;
	}

	@Override
	protected void updateElementFromEditGroup(MessageChannel message) {
		if (message != null) {			
			// update channel
			String channelString= Util.nullIfEmpty(channelText.getText());
			message.getChannel().setExpression(channelString);
			
			// update payload
			if (message.getPayload() != null) {
				String payloadNameString= Util.nullIfEmpty(payloadNameText.getText());
				message.getPayload().setName(payloadNameString);
				
				String payloadTypeString= Util.nullIfEmpty(payloadTypeText.getText());
				message.getPayload().setType(payloadTypeString);
			}
		}
	}
	
	@Override
	protected void refreshEditGroup() {
		MessageChannel message= getSelectedElement();
		if (message != null) {
			String channelString= Util.nonNull(message.getChannel().getExpression());
			channelText.setText(channelString);
			boolean hasPayload = message.getPayload() != null;
			hasPayloadButton.setSelection(hasPayload);
			isChannelButton.setSelection(message.isMessageGroup());
			enableGroupControls(payloadGroup, hasPayload);
			if (hasPayload) {
				String payloadNameString= Util.nonNull(message.getPayload().getName());
				payloadNameText.setText(payloadNameString);
				String payloadTypeString= Util.nonNull(message.getPayload().getType());
				payloadTypeText.setText(payloadTypeString);
			}
		}
	}
	
	@Override
	protected String getString(MessageChannel message) {
		if (message != null) {
			String nameString= message.getChannel() != null ? message.getChannel().getExpression() : "<unknown>";
			StringBuffer buffer= new StringBuffer();
			buffer.append(nameString != null ? nameString : "<null>"); //$NON-NLS-1$
			buffer.append("(");
			if (message.getPayload() != null) {
				buffer.append(message.getPayload().getName());
				buffer.append(": ");
				buffer.append(message.getPayload().getType());
			}
			buffer.append(")");
			return buffer.toString();	
		}
		return super.getString(message);
	}
	
	@Override
	public void widgetSelected(SelectionEvent e) {
		MessageChannel message = getSelectedElement();
		if (e.getSource() == hasPayloadButton) {
			if (hasPayloadButton.getSelection()) {
				message.setPayload(VsdtFactory.eINSTANCE.createProperty());
			} else {
				message.setPayload(null);
			}
		}
		if (e.getSource() == isChannelButton) {
			message.setMessageGroup(isChannelButton.getSelection());
		}
		super.widgetSelected(e);
	}
	
}
