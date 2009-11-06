package org.sercho.processgui.dynamic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.wsdl.Definition;
import javax.wsdl.Operation;
import javax.wsdl.Part;
import javax.wsdl.PortType;
import javax.wsdl.factory.WSDLFactory;
import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.soap.SOAPConstants;

/**
 * 
 * @author kuester
 */
@SuppressWarnings("serial")
public class DynamicServiceInvocationGUI extends JFrame {

	/*
	 * TODO
	 * history per properties datei
	 * bedienung verbessern
	 */
	
	private JPanel parameterPanel;
	
	private JButton invokeButton;
	
	private JTextField urlTextField;
	
	private JLabel statusLine;
	
	private DefaultListModel listModel;
	
	private Map<String, Operation> operations= new HashMap<String, Operation>();
	
	/**
	 * Create frame area.
	 */
	public DynamicServiceInvocationGUI() {
		this.setTitle("Dynamic Service Invocation GUI");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JPanel urlPanel= new JPanel(new FlowLayout());
		urlPanel.add(new JLabel("Service URL"));
		urlPanel.add(urlTextField= new JTextField());
		urlTextField.setPreferredSize(new Dimension(300,20));
		JButton loadWsdlButton= new JButton("Load WSDL");
		urlPanel.add(loadWsdlButton);
		loadWsdlButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshOperationList();	
			}
		});
		mainPanel.add(urlPanel,BorderLayout.NORTH);

		JList operationList= new JList(listModel= new DefaultListModel());
		operationList.setBorder(new LineBorder(Color.BLACK));
		mainPanel.add(operationList, BorderLayout.CENTER);
		operationList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				statusLine.setText("");
				Object selected= listModel.getElementAt(((JList)e.getSource()).getSelectedIndex());
				refreshParameterPanel((String) selected);
			}
		});
		
		invokeButton= new JButton("Invoke");
		invokeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoke();
			}
		});
		invokeButton.setEnabled(false);
		
		parameterPanel= new JPanel();
		
		statusLine= new JLabel("");
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(mainPanel,BorderLayout.NORTH);
		this.getContentPane().add(parameterPanel);
		this.getContentPane().add(invokeButton, BorderLayout.EAST);
		this.getContentPane().add(statusLine,BorderLayout.SOUTH);

		this.pack();
	}
	
	protected void refreshOperationList() {
		listModel.clear();
		parameterPanel.removeAll();
		try {
			serviceUrl= urlTextField.getText();
			Definition definition= WSDLFactory.newInstance().newWSDLReader().readWSDL(serviceUrl);
			for (Object pt : definition.getPortTypes().values()) {
				PortType portType= (PortType) pt;
				for (Object op : portType.getOperations()) {
					Operation operation= (Operation) op;
					String key= portType.getQName().getLocalPart() + " : " + operation.getName();
					listModel.addElement(key);
					operations.put(key, operation);
				}
			}
		} catch (Exception e) {
			statusLine.setText("No service found for given URL");
		}
		invokeButton.setEnabled(false);
		pack();
	}
	
	protected void refreshParameterPanel(String opName) {
		parameterPanel.removeAll();
		try {
			Operation operation= operations.get(opName);
			operationName= operation.getName();
			parameterPanel.setLayout(new GridLayout(operation.getInput().getMessage().getParts().values().size(),2));
			
			for (Object p : operation.getInput().getMessage().getOrderedParts(null)) {
				Part part= (Part) p;
				parameterPanel.add(new JLabel(part.getName()));
				parameterPanel.add(new JTextField());
			}
			
			invokeButton.setEnabled(true);
		} catch (Exception e) {
			statusLine.setText("A Problem occured when retrieving the parameters");
			e.printStackTrace();
			invokeButton.setEnabled(false);
		}
		pack();
	}
	
	protected String serviceUrl;
	protected String operationName;
	protected Object[] arguments;
	
	/**
	 * create and run an instance of the start client
	 */
	public void invoke() {
		statusLine.setText("Invoking...");
		try {
			Call call= (Call) new Service().createCall();
			call.setTargetEndpointAddress(serviceUrl);
			call.setOperationName(new QName("", operationName));
			
			arguments= new Object[parameterPanel.getComponentCount() /2 ];
			int i= 0;
			for (Component comp : parameterPanel.getComponents()) {
				if (comp instanceof JTextField) {
					JTextField tf = (JTextField) comp;
					arguments[i++]= tf.getText();
				}
			}
			
			Object result= null;
			result= call.invoke(arguments);
			if (result != null) {
				statusLine.setText(result.toString());
			}
			statusLine.setText("finished");
		} catch (Exception e) {
			statusLine.setText(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new DynamicServiceInvocationGUI().setVisible(true);
	}
	
	
	public static void test() {
		
		String url= "http://localhost:8080/active-bpel/services/EnergySaving_ParticipantService";
		String operation= "start";
//		String port= "EnergySaving_ParticipantServicePort";
		
		String paramUserName="George";
		String paramRoom=	"Living Room";
		String paramZone=	"Living Room";
		String paramLightLine=	"192.168.1.220-65";
		String paramDelaySec=	"2";

		Object[] arguments= new Object[] {paramUserName, paramDelaySec, paramZone, paramLightLine, paramRoom};
		
		try {
			Call call = new Call(url);
	        call.setOperation(operation);
	        call.setUseSOAPAction(true);
	        call.setSOAPActionURI("");
	        call.setSOAPVersion(SOAPConstants.SOAP11_CONSTANTS);
//	        call.setOperationName(new javax.xml.namespace.QName("", "start"));
	        call.setOperationName(new javax.xml.namespace.QName("", "stop"));

	        call.invokeOneWay(arguments);
	        call.invokeOneWay(new Object[]{});
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
