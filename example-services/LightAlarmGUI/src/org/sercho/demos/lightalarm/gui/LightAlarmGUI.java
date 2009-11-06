package org.sercho.demos.lightalarm.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.sercho.IvistarProxy.IvistarProxyPTProxy;
import org.sercho.SheaSimulator.SheaSimulatorPTProxy;
import org.sercho.UPnPRadio.UPnPRadioPTProxy;
import org.sercho.demos.ruleapiclient.REClient;
import org.sercho.lightarousal.WSDL.LightArousalPTProxy;

import de.dailab.jiactng.sercho.rulesengine.ISheaRulesEngine;
import de.dailab.jiactng.sercho.rulesengine.SheaRule;

@SuppressWarnings("serial")
public class LightAlarmGUI extends JFrame implements ActionListener {

	/*
	 * properties fields and methods
	 */
	
	protected Properties properties= new Properties();
	
	protected String getPropFile() {
		return "LightAlarmGUI.properties";
	}

	private String getProp(String key) {
		String prop= properties.getProperty(key);
		System.out.println("Got Property '" + key + "': " + prop);
		return prop;
	}
	
	/*
	 * GUI fields and methods
	 */
	
	private JLabel messageLabel= new JLabel("All Parameters are set via Properties Files in the JAR's directory.");
	private JButton initButton= new JButton("Initialize");
	private JButton startButton= new JButton("Start");
	private JButton resetButton= new JButton("Reset");
	
	public LightAlarmGUI() {
		super("Light Alarm Demo GUI");
		JPanel buttons= new JPanel(new GridLayout(1,3));
		buttons.add(initButton);
		buttons.add(startButton);
		buttons.add(resetButton);
		this.getContentPane().setLayout(new GridLayout(2,1));
		this.getContentPane().add(buttons);
		this.getContentPane().add(messageLabel);
		initButton.addActionListener(this);
		startButton.addActionListener(this);
		resetButton.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600, 200);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src= e.getSource();
		try {
			properties.load(new FileReader(getPropFile()));
			System.out.println(new File(".").getAbsolutePath());
			reloadProperties();
			if (src == initButton) {
				write("Initializing...");
				initProxys();
				init();
				reset();
				write("Initialized");
			}
			if (src == startButton) {
				write("Starting Process...");
				start();
				write("Process started");
			}
			if (src == resetButton) {
				write("Resetting...");
				reset();
				write("Reset finished");
			}
		} catch (Exception ex) {
			write(ex.getMessage());
		}
	}

	private void write(String message) {
		messageLabel.setText(message);
	}
	
	/*
	 * proxy fields and methods
	 */
	
	private LightArousalPTProxy process= new LightArousalPTProxy();
	private IvistarProxyPTProxy ivistar= new IvistarProxyPTProxy();
	private SheaSimulatorPTProxy simulator= new SheaSimulatorPTProxy();
	private UPnPRadioPTProxy radio= new UPnPRadioPTProxy();
	private REClient ruleClient= new REClient(getProp("ip")); 
	
	protected void initProxys() throws Exception {
		process.setEndpoint(endpoint_process);
		ivistar.setEndpoint(endpoint_ivistar);
		simulator.setEndpoint(endpoint_simulator);
		radio.setEndpoint(endpoint_radio);
	}
	
	/*
	 * web service call fields and methods
	 */

	private String endpoint_process=	"http://localhost:8080/active-bpel/services/LightAlarm_ParticipantService";
	private String endpoint_ivistar=	"http://localhost:8080/IvistarProxy/services/IvistarProxyServiceSOAP";
	private String endpoint_simulator=	"http://localhost:8080/SheaSimulatorWS/services/SheaSimulatorServiceSOAP";
	private String endpoint_radio=		"http://localhost:8080/UPnPRadioWS/services/UPnPRadioServiceSOAP";
	private String username= "George";
	private String room= "Living Room";
	private String blinds= "92";
	private String lights= "31";
	private String city= "Berlin";
	private String country= "Germany";
	private String trackUrl= "";
	private int offset= 20;
	private boolean useLight= true;
	private boolean useMusic= true;
	
	protected void reloadProperties() throws Exception {
		endpoint_process= getProp("endpoint_process");
		endpoint_ivistar= getProp("endpoint_ivistar");
		endpoint_simulator= getProp("endpoint_simulator");
		endpoint_radio= getProp("endpoint_radio");
		
		username=	getProp("username");
		room=		getProp("room");
		blinds=		getProp("blinds");
		lights=		getProp("lights");
		city=		getProp("city");
		country=	getProp("country");
		trackUrl=	getProp("trackUrl");
		offset=		Integer.parseInt(getProp("offset"));
		useLight=	Boolean.parseBoolean(getProp("useLight"));
		useMusic=	Boolean.parseBoolean(getProp("useMusic"));
	}
	
	public void init() throws Exception {
		ivistar.setValue(room, blinds, "100"); // jalousien kurz hochfahren (für kalibirierung?)
		simulator.startSimulator();
		radio.init();

		ISheaRulesEngine re= ruleClient.getRuleEngine();
		re.removeAllRules();
		SheaRule rule1= new SheaRule(null,
				"SerCHo Home Security System",
				"Send notification when anomaly is detected.",
				"Security",
				1,
				SheaRule.CATEGORY_SECURITY,
				SheaRule.ACTIVATED);
		SheaRule rule2= new SheaRule(null,
				"Light Alarm",
				"Wakes you up with light and music",
				"Comfort",
				3,
				SheaRule.CATEGORY_COMFORT,
				SheaRule.NOT_ACTIVATED);
		re.addRule(rule1);
		re.addRule(rule2);
	}
	
	public void start() throws Exception {
		process.initProcess(username, createWaketimeString(offset), city, country, room, lights, blinds, useLight, useMusic);
	}
	
	public void reset() throws Exception {
		ivistar.setValue(room, lights, "0");
		ivistar.setValue(room, blinds, "200");
		radio.stop();
		Thread.sleep(2000);
		radio.setAVTransportURI(trackUrl);
		// TODO lautstärke normalisieren
	}

	private String createWaketimeString(int offset) {
		Calendar cal= Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis() + offset*1000);
		StringBuffer buff= new StringBuffer();
		buff.append(normDatePart(cal.get(Calendar.YEAR))).append("-");
		buff.append(normDatePart(cal.get(Calendar.MONTH)+1)).append("-");
		buff.append(normDatePart(cal.get(Calendar.DAY_OF_MONTH))).append("T");
		buff.append(normDatePart(cal.get(Calendar.HOUR_OF_DAY))).append(":");
		buff.append(normDatePart(cal.get(Calendar.MINUTE))).append(":");
		buff.append(normDatePart(cal.get(Calendar.SECOND)));
		//time zone
		buff.append("+").append("02:00"); //+1 wegen zeitzone, +1 wegen sommerzeit
		System.out.println(buff.toString());
		return buff.toString();
	}
	
	private String normDatePart(int part) {
		return (part<10?"0":"")+part;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LightAlarmGUI gui= new LightAlarmGUI();
		gui.setVisible(true);
	}
}
