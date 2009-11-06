package org.sercho.locnotclient.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.sercho.locnotclient.client.REClient;
import org.sercho.locnotclient.client.SerCHoDemoTestClient;
import org.sercho.locnotclient.client.SheaTestClient;
import org.sercho.locnotclient.client.ShemTestClient;


/**
 * This frame can be used as a simple to use client for the Locate-and-Notify process.
 * Of course it can also be adapted to be used with other processes. The idea behind this
 * client is, beside from simply triggering the process, is to provide a count-down function,
 * triggering a popup-dialog which then starts the process.
 * 
 * @author kuester
 */
@SuppressWarnings("serial")
public class ClientFrame extends JFrame implements ActionListener {

	public static final String TITLE= "SerCHo Locate&Light CeBit Demo Start GUI";  
	public static final String DIALOG_TITLE= "New Process Available";
	public static final String MESSAGE= "New Process Available. Start Process?";
	public static final String propFile= "ruleClient.properties";

	private JButton startCountdownButton;
	private JButton startProcessButton;
	private JButton stopProcessButton;
	private JButton deployRuleButton;
	private JButton undeployRuleButton;
	
	private JLabel countdownLabel;
	private JLabel statusLine;
	
	private JTextField uidTextField;
	private JTextField delayTextField;
	private JTextField startInTextField;
	
	private int countdown= -1;

	/**
	 * Create frame area.
	 */
	public ClientFrame(boolean exitOnClose) {
		this.setTitle(TITLE);
		if (exitOnClose) {
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new GridLayout(6,2,10,10));
		
		JLabel uidLabel= new JLabel("Paramter: user ID");
		uidTextField= new JTextField(defaultUID);
		mainPanel.add(uidLabel);
		mainPanel.add(uidTextField);
		
		JLabel delayLabel= new JLabel("Parameter: delay (in s)");
		delayTextField= new JTextField(defaultDelay);
		mainPanel.add(delayLabel);
		mainPanel.add(delayTextField);

		JLabel startInLabel= new JLabel("show dialog in x seconds");
		startInTextField= new JTextField(defaultCountdown);		
		mainPanel.add(startInLabel);
		mainPanel.add(startInTextField);
		
		startCountdownButton= new JButton("Start countdown");
		startCountdownButton.addActionListener(this);
		countdownLabel= new JLabel();
		mainPanel.add(startCountdownButton);
		mainPanel.add(countdownLabel);
		
		startProcessButton= new JButton("Start Process");
		startProcessButton.addActionListener(this);
		stopProcessButton= new JButton("Stop Process");
		stopProcessButton.addActionListener(this);
		mainPanel.add(startProcessButton);
		mainPanel.add(stopProcessButton);

		deployRuleButton= new JButton("Deploy Rule");
		deployRuleButton.addActionListener(this);
		undeployRuleButton= new JButton("Undeploy Rule");
		undeployRuleButton.addActionListener(this);
		mainPanel.add(deployRuleButton);
		mainPanel.add(undeployRuleButton);
		
		statusLine= new JLabel(" ");
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(mainPanel,BorderLayout.CENTER);
		this.getContentPane().add(statusLine,BorderLayout.SOUTH);

		this.pack();
		this.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src= e.getSource();
		if (src == startCountdownButton) {
			statusLine.setText("countdown started");
			new Thread(new CountDown()).start();
		}
		if (src == startProcessButton) {
			startProcess();
		}
		if (src == stopProcessButton) {
			stopProcess();
		}
		if (src == deployRuleButton) {
			deployRule();
		}
		if (src == undeployRuleButton) {
			undeployRule();
		}
	}
	
	/**
	 * create and run an instance of the start client
	 */
	public void startProcess() {
		statusLine.setText("starting");
		SerCHoDemoTestClient client= new SerCHoDemoTestClient();
		try {
			client.invokeStartExecution(getUid(), getDelaySec());
			statusLine.setText("process started");
		} catch (Exception e) {
			statusLine.setText("starting failed");
		}
	}
	
	/**
	 * create and run an instance of the stop client
	 */
	public void stopProcess() {
		statusLine.setText("stopping");
		SerCHoDemoTestClient client= new SerCHoDemoTestClient();
		try {
			client.invokeStopExecution();
			statusLine.setText("process stopped");
		} catch (Exception e) {
			statusLine.setText("stopping failed");
		}
	}
	
	public void deployRule() {
		REClient client= new REClient(propFile);
		if (client.addRule()) {
			statusLine.setText("rule deployed");
		} else {
			statusLine.setText("failed to deploy rule");
		}
	}
	
	public void undeployRule() {
		REClient client= new REClient(propFile);
		if (client.removeRule(false)) {
			statusLine.setText("rule undeployed");
		} else {
			statusLine.setText("failed to undeploy rule");
		}
	}
	
	/**
	 * This runnable starts the count down, visualizes it using the countdown label,
	 * and opens the popup-dialog once the countdown is finished.
	 * 
	 * @author kuester
	 */
	public class CountDown implements Runnable {
		@Override
		public void run() {
			try {
				countdown= Integer.parseInt(startInTextField.getText());
				while (countdown > 0) {
					countdownLabel.setText(String.valueOf(countdown--));
					ClientFrame.this.repaint();
					Thread.sleep(1000);
				}
				countdownLabel.setText("0");
				if (countdown == 0) {
					showMessage();
				}
			} catch (NumberFormatException e) {
				statusLine.setText("malformed time to start");
			} catch (InterruptedException e) {
				statusLine.setText("interrupted exception");
			}
		}
	}
	
	public String getUid() {
		return uidTextField.getText();
	}
	
	public int getDelaySec() {
		return Integer.parseInt(delayTextField.getText());
	}
	
	/**
	 * create and run an instance of the start client
	 */
//	public void showMessage() {
//		statusLine.setText("showing message on MASP");
//		ShemTestClient client= new SheaTestClient(notificationURL);
//		try {
//			String uid= uidTextField.getText();
//			String message= assembleMessage();
//			client.invokeShowMessage(uid, message);
//			statusLine.setText("message shown");
//		} catch (Exception e) {
//			statusLine.setText("showing message failed");
//		}
//	}
	
	/**
	 * alternate version, sending the message and starting the process
	 */
	public void showMessage() {
		statusLine.setText("showing message on MASP");
		ShemTestClient client= new SheaTestClient(notificationURL);
		try {
			String uid= uidTextField.getText();
			String message= assembleMessage();
			client.invokeShowMessage(uid, message);
			statusLine.setText("message shown");
		} catch (Exception e) {
			statusLine.setText("showing message failed");
		}
		try {
			Thread.sleep(1000*countdown2);
			startProcess();
			deployRule();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int countdown2;
	
	private String assembleMessage() {
		return fullMessage;
	}

	public String fullMessage;
	
//	private String assembleMessage() {
//		
//		final String style= this.style != null ? this.style : 
//			"background-color: #aaa;" +
//			"border: solid thin;" +
//			"font-family: sans-serif;" +
//			"color: #000;" +
//			"text-decoration: none;" +
//			"border-color: #000;"  +
//			"padding: .1em 1em .1em 1em;" +
//			"margin: 0 1em 0 1em;" +
//			"text-align: center";
//		final String params= "?uid=" + getUid() + "&delay=" + getDelaySec();
//		final String message= this.message != null ? this.message : 
//			"Dear "+getUid()+",<br> " +
//			"it was noticed that whenever you enter or leave the room you switch the light on or off respectively. <br>" +
//			"A new rule process could be derived from that behaviour, automatically switching the light when you enter and leave the room. <br>" +
//			"Should the process be started now?";
//		
//		final String buttonYes= "<td id=\"notMes1\" MCFocusable=\"true\" class=\"notificationButton\" " +
//				"onclick=\"callURL('" + servletURL + params + "');" +
//				"if(document.getElementsByName('CloseButtonNotification').length > 0)" +
//				"{var tmp = new Object(); tmp.type='click';document.getElementsByName('CloseButtonNotification')[0].onclick(tmp)}\">YES</td>"; 
//			
//		final String buttonNo= "<td id=\"notMes2\" MCFocusable=\"true\" class=\"notificationButton\" " +
//				"onclick=\"if(document.getElementsByName('CloseButtonNotification').length > 0)" +
//				//"{var tmp = new Object(); tmp.type='click';" +
//				"document.getElementsByName('CloseButtonNotification')[0].fireIdEvent('click', document.getElementsByName('CloseButtonNotification')[0])}\">NO</td>";
//		
//		/*final String buttonNo= "<td id=\"notMes2\" MCFocusable=\"true\" class=\"notificationButton\" " +
//		"onclick=\"if(document.getElementsByName('CloseButtonNotification').length > 0)" +
//		"{var tmp = new Object(); tmp.type='click';" +
//		"document.getElementsByName('CloseButtonNotification')[0].onclick(tmp)}\">NO</td>";*/
//		
//		StringBuffer buffer=  new StringBuffer();
//		buffer.append("<table><tr><td colspan='2'>");
//		buffer.append(message);
//		buffer.append("</td></tr><tr>");
//		buffer.append(buttonYes);
//		buffer.append(buttonNo);
//		buffer.append("</tr></table>");
//		System.out.println(buffer.toString());
//		return buffer.toString();
//	}
	

//	private String assembleMessage() {
//		
//		final String style= this.style != null ? this.style : 
//			"background-color: #aaa;" +
//			"border: solid thin;" +
//			"font-family: sans-serif;" +
//			"color: #000;" +
//			"text-decoration: none;" +
//			"border-color: #000;"  +
//			"padding: .1em 1em .1em 1em;" +
//			"margin: 0 1em 0 1em;" +
//			"text-align: right";
//		
//		
//		
//		final String params= "?uid=" + getUid() + "&delay=" + getDelaySec();
//		final String message= this.message != null ? this.message : 
//			"Dear "+getUid()+",<br> " +
//			"it was noticed that whenever you enter or leave the room you switch the light on or off respectively. <br>" +
//			"A new rule process could be derived from that behaviour, automatically switching the light when you enter and leave the room. <br>" +
//			"Should the process be started now?";
//		final String buttonYes= "<a href='" + servletURL +params+"' style='"+style+"' target='_blank'>Yes</a>";
//		final String buttonNo= "<a href='#' style='"+style+"' target='_blank'>No</a>";
//		StringBuffer buffer=  new StringBuffer();
//		buffer.append(message);
//		buffer.append(buttonYes);
//		buffer.append(buttonNo);
//		return buffer.toString();
//	}

	private String defaultUID= "George";
	private String defaultDelay= "2";
	private String defaultCountdown= "60";
	private String notificationURL= "http://localhost:8080/shea/services/Notification";
	private String servletURL= "http://localhost:8080/MaspServlet/MaspServlet";
	
	public String style= null;
	public String message= null;
	
	public void setUID(String defaultUID) {
		if (defaultUID != null) 
			uidTextField.setText(defaultUID);
	}
	
	public void setDelay(String defaultDelay) {
		if (defaultDelay != null)
			delayTextField.setText(defaultDelay);
	}
	
	public void setCountdown(String defaultCountdown) {
		if (defaultCountdown != null) 
			startInTextField.setText(defaultCountdown);
	}
	
	public void setNotificationURL(String sheaURL) {
		if (sheaURL != null)
			this.notificationURL = sheaURL;
	}
	
	public void setServletURL(String thisURL) {
		if (thisURL != null)
			this.servletURL = thisURL;
	}
}
