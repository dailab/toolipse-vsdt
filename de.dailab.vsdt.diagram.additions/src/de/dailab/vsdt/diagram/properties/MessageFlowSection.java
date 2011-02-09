package de.dailab.vsdt.diagram.properties;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;

import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.VsdtPackage;


public class MessageFlowSection extends AbstractVsdtPropertySection {

//	public static final String DISPLAY_NAME= "Name",
//							   DISPLAY_MESSAGE= "Message",
//							   DISPLAY_INIT_MESSAGE= "Initialize New Message",
//							   DISPLAY_MSG_ATTRIBUTES= "Message Attributes",
//							   DISPLAY_FROM= "From",
//							   DISPLAY_TO= "To",
//	   						   DISPLAY_ORG_PROP= "Message Properties...",
//							   DISPLAY_ORG_MSG= "Messages...";

    protected MessageFlow messageFlow;
    
//    private VsdtFeatureCombo<Message> messageCombo;
//    private Text msgNameText;
//    private Button orgPropButton;
//    private Button orgMsgButton;
//    private Button initMsgButton;

    @Override
    protected EClass getObjectClass() {
    	return VsdtPackage.eINSTANCE.getMessageFlow();
    }

    @Override
    public void setInput(IWorkbenchPart part, ISelection selection) {
        super.setInput(part, selection);
        if (eObject instanceof MessageFlow) {
        	this.messageFlow= (MessageFlow) eObject;
        }
    }

//    @Override
// 	protected void internalRefresh() {
//    	super.internalRefresh();
//    	messageCombo.fillCombo(messageFlow.getParent().getParent().getMessages());
//    	
//    	messageCombo.setSelected(messageFlow.getMessage());
//    	boolean hasMessage= messageFlow.getMessage() != null;
//    	if (hasMessage) {
//    		Message msg= messageFlow.getMessage();
//    		msgNameText.setText(nonNull(msg.getName()));
//    	}
//        msgNameText.setEnabled(hasMessage);
//        orgPropButton.setEnabled(hasMessage);
//    }
    
//    @Override
//    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
//        super.createControls(parent, aTabbedPropertySheetPage);
//        CLabel label;
//
//        // buttons
//        orgMsgButton = addButton(DISPLAY_ORG_MSG);
//        initMsgButton = addButton(DISPLAY_INIT_MESSAGE);
//        
//        label= FormLayoutUtil.addLabel(composite, DISPLAY_MESSAGE, lastControl, 0);
//        messageCombo= new VsdtFeatureCombo<Message>(FormLayoutUtil.addCombo(composite, SWT.READ_ONLY, lastControl, label, 100));
//        messageCombo.getCombo().addSelectionListener(this);
//        
//        //message group
//        Group msgGroup= FormLayoutUtil.addGroup(composite, DISPLAY_MSG_ATTRIBUTES, label, 0, 100);
//
//        // organize properties button
//        orgPropButton= FormLayoutUtil.addButton(msgGroup, DISPLAY_ORG_PROP, 0, 0, null, 100);
//        orgPropButton.addSelectionListener(this);
//        
//        // name label
//        label= FormLayoutUtil.addLabel(msgGroup, DISPLAY_NAME, 0, 0);
//        msgNameText= FormLayoutUtil.addText(msgGroup, 0, label, orgPropButton, 0);
//        msgNameText.addFocusListener(this);
//    }

//    public void focusLost(FocusEvent e) {
//    	super.focusLost(e);
//    	if (e.getSource().equals(msgNameText)) {
//    		if (messageFlow.getMessage() != null) {
//	    		setPropertyValue(messageFlow.getMessage(), pack.getMessage_Name(), nullIfEmpty(msgNameText.getText()));
//	    		refresh();
//    		}
//		}
//    }
    
//    public void widgetSelected(SelectionEvent e) {
//    	super.widgetSelected(e);
//    	Object src= e.getSource();
//    	if (src.equals(orgPropButton)) {
//			new OrganizePropertiesAction().run(messageFlow.getMessage());
//    	}
//    	if (src.equals(initMsgButton)) {
//    		String title= "Create new Message?";
//    		String message= "A new Message Object will be created and associated to the Message Flow and, if possible, to its source and target. Continue?";
//    		Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//    		if (MessageDialog.openQuestion(shell, title, message)) {
//    			new InitMessageAction().run(messageFlow);
//    		}
//    	}
//    	if (src.equals(orgMsgButton)) {
//			new OrganizeMessagesAction().run(messageFlow.getParent().getParent());
//    	}
//    	if (src.equals(messageCombo.getCombo())) {
//    		Message message= messageCombo.getSelected();
//    		setPropertyValue(messageFlow, pack.getMessageFlow_Message(), message);
//    	}
//    	refresh();
//    }
}