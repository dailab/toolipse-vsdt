package org.sercho.esc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.cybergarage.upnp.Action;
import org.cybergarage.upnp.Argument;
import org.cybergarage.upnp.ControlPoint;
import org.cybergarage.upnp.Device;

@SuppressWarnings("serial")
public class UPnPPowerControl implements ActionListener {
	
	public static final String FIND= "FIND",
							   ON= "ON",
							   OFF= "OFF",
							   STATUS= "STATUS",
							   QUIT= "QUIT";
							   
	
	/**
	 * this field is for better usability in a tomcat environment. if the system would be exited on closing the
	 * gui, the tomcat would be stopped, too.
	 */
	private boolean exitOnClose= false;
	
	private String deviceName= "tinilamp";

	private JFrame frame;
	
	private JTextField textField;
	
	private ControlPoint controlPoint;
	
	
	/**
	 * 
	 */
	public UPnPPowerControl() {
		this(null);
	}
	
	/**
	 * 
	 * @param ctrlPoint
	 */
	public UPnPPowerControl(ControlPoint ctrlPoint) {
		if (ctrlPoint == null) {
			controlPoint = new ControlPoint();
			controlPoint.start();
		} else  {
			this.controlPoint = ctrlPoint;
		}
	}
	
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * 
	 * @param exitOnClose
	 */
	public void initGui(boolean exitOnClose) {
		this.exitOnClose= exitOnClose;
		frame= new JFrame("UPnP Power Controller");
		frame.setDefaultCloseOperation(exitOnClose ? JFrame.EXIT_ON_CLOSE : JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		
		textField= new JTextField(deviceName);
		textField.setColumns(15);
		textField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}
			public void focusLost(FocusEvent e) {
				deviceName= textField.getText();
			}
		});
		panel.add(textField);
		
		JButton button = new JButton(FIND);
		button.addActionListener(this);
		panel.add(button);
		
		button = new JButton(ON);
		button.addActionListener(this);
		panel.add(button);
		
		button = new JButton(OFF);
		button.addActionListener(this);
		panel.add(button);
		
		button = new JButton(STATUS);
		button.addActionListener(this);
		panel.add(button);
		
		button = new JButton(QUIT);
		button.addActionListener(this);
		panel.add(button);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals(QUIT)) {
			frame.setVisible(false);
			frame.dispose();
			if (exitOnClose) {
				System.exit(0);
			}
		}
		if (ae.getActionCommand().equals(FIND)) {
			printDevices();
		} 
		if (ae.getActionCommand().equals(ON)) {
			boolean result = switchPower(true);
			setColor( (JButton) ae.getSource(),result ? 1 : -1);
		}
		if (ae.getActionCommand().equals(OFF)) {
			boolean result = switchPower(false);
			setColor( (JButton) ae.getSource(),result ? 1 : -1);
		}
		if (ae.getActionCommand().equals(STATUS)) {
			int result = getPowerStatus();
			setColor( (JButton) ae.getSource(),result);
		}
	}
	
	/**
	 * 
	 * @param button
	 * @param state
	 */
	private void setColor(JButton button, int state) {
		switch (state) {
		case -1:
			button.setBackground(Color.RED);
			break;
		case 0:
			button.setBackground(Color.LIGHT_GRAY);
			break;
		case 1:
			button.setBackground(Color.YELLOW);
			break;
		}
	}

	/**
	 * 
	 */
	public void printDevices() {
		System.out.println("Searching devices...");
		Iterator<Device> it = controlPoint.getDeviceList().iterator();
		while (it.hasNext()) {
			Device dev = it.next();
			System.out.println("Found: " + dev.getFriendlyName() + " (" + dev.getUDN() + ")");
		}
	}
	
	/**
	 * 
	 * @param onOff
	 * @return
	 */
	public boolean switchPower(boolean onOff) {
		Device dev= getDevice(deviceName);
		if (dev != null) {
			Action a = dev.getAction("SetPower");
			if (a != null) {
				System.out.println("Invoking Action");
				a.setArgumentValue("Power", onOff? "true" : "false");
				return a.postControlAction();
			} else {
				System.err.println("Action \"SetPower\" not found!");
				return false;
			}
		} else {
			System.err.println("Device " + deviceName + " not found");
			System.out.println("Available devices: ");
			printDevices();
			return false;	
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPowerStatus() {
		Device dev= getDevice(deviceName);
		if (dev != null) {
			Action a = dev.getAction("GetPower");
			if (a != null) {
				System.out.println("Invoking Action");
				if (a.postControlAction()) {
					Argument arg = a.getArgument("Power");
					System.out.println("Result=" + arg.getValue());
					return arg.getIntegerValue();
				} else {
					System.err.println("Action \"GetPower\" failed");
					return -1;
				}
			} else {
				System.err.println("Action \"GetPower\" not found!");
				return -1;
			}
		} else {
			System.err.println("Device " + deviceName + " not found");
			System.out.println("Available devices: ");
			printDevices();
			return -1;
		}
	}
	
	/**
	 * 
	 * @param deviceName
	 * @return
	 */
	private Device getDevice(String deviceName) {
		Iterator<Device> it = controlPoint.getDeviceList().iterator();
		while (it.hasNext()) {
			Device dev = it.next();
			String devname = dev.getUDN();
			if (devname.toLowerCase().contains(deviceName)) {
				return dev;
			}
		}
		return null;
	}
	
	/**
	 * Test start this class
	 */
	public static void main(String[] args) {
		UPnPPowerControl lamp = new UPnPPowerControl();
		lamp.setDeviceName("tinilamp");
		lamp.initGui(true);
		
	}
}
