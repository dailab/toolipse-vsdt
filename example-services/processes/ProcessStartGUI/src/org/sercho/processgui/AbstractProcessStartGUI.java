package org.sercho.processgui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.sercho.IvistarProxy.IvistarProxyPTProxy;
import org.sercho.SheaSimulator.SheaSimulatorPTProxy;
import org.sercho.UPnPRadio.UPnPRadioPTProxy;
import org.sercho.masp.notification.NotificationPortTypeProxy;
import org.sercho.shea.rules.REClient;

import de.dailab.jiactng.sercho.rulesengine.SheaRule;

@SuppressWarnings("serial")
public abstract class AbstractProcessStartGUI extends JFrame implements ActionListener {

	public abstract String getProcessName();

	public int getProcessID() {
		return ruleID;
	}

	public AbstractProcessStartGUI() {
		super("Process Start GUI");
	}
	
	/*
	 * properties fields and methods
	 */
	
	protected Properties properties= new Properties();
	
	protected abstract String getPropPrefix();
	
	protected String getPropFile() {
		String path="conf/ProcessStartGUI.properties";
		System.out.println("Properties File location: " + new File("./"+path).getAbsolutePath());
		return path;
	}

	protected String getProp(String key) {
		String prop= properties.getProperty(key);
		if (prop != null) {
			System.out.println("Got Property '" + key + "': " + prop);
		} else {
			System.err.println("Warning: Property '" + key + "' not found!");
		}
		return prop;
	}
	
	protected String getPrefixedProp(String key) {
		return getProp(getPropPrefix() + key);
	}

	public void initializeProperties() {
		try {
			properties.load(new FileReader(getPropFile()));
			reloadProperties();
			initProxys();
			loadRuleProps();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not load Properties. Program will terminate.");
			System.exit(1);
		}
	}
	
	protected void reloadProperties() {
		deploymentDelay= 	Integer.parseInt(getProp("deploymentDelay"));
		sheaUser=			getProp("sheaUser");
		notificationMessage=getPrefixedProp("notification");
	}
	
	/*
	 * GUI fields and methods
	 */
	
	private JLabel messageLabel= new JLabel("All Parameters are set via Properties Files in the JAR's directory.");
	private JButton initButton= new JButton("Initialize");
	private JButton deployButton= new JButton("Deploy");
	private JButton startButton= new JButton("Start");
	private JButton stopButton= new JButton("Stop");
	private JButton resetButton= new JButton("Reset");
	
	public void initializeGUI() {
		setTitle(getProcessName() + " Start GUI");
		JPanel buttons= new JPanel(new GridLayout(1,4));
		buttons.add(initButton);
		buttons.add(deployButton);
		buttons.add(startButton);
		buttons.add(stopButton);
		buttons.add(resetButton);
		this.getContentPane().setLayout(new GridLayout(2,1));
		this.getContentPane().add(buttons);
		this.getContentPane().add(messageLabel);
		initButton.addActionListener(this);
		deployButton.addActionListener(this);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		resetButton.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 200);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src= e.getSource();
		try {
			if (src == initButton) {
				write("Initializing...");
				init();
				reset();
				write("Initialized");
			}
			if (src == deployButton) {
				write("Deploying Process...");
				deploy();
				write("Process deployed");
			}
			if (src == startButton) {
				write("Starting Process...");
				activate(true);
				start();
				write("Process started");
			}
			if (src == stopButton) {
				write("Stopping Process...");
				stop();
				activate(false);
				write("Process stopped");
			}
			if (src == resetButton) {
				write("Resetting...");
				undeploy();
				reset();
				write("Reset finished");
			}
		} catch (Exception ex) {
			write(ex.getMessage());
		}
	}

	protected void write(String message) {
		messageLabel.setText(message);
	}

	
	
	
	/*
	 * Process Lifecycle
	 */
	
	public abstract void init() throws Exception;
	
	public abstract void start() throws Exception;
	
	public abstract void stop() throws Exception;
	
	public abstract void reset() throws Exception;
	
	
	
	
	
	/*
	 * Webservice Proxies
	 */

	protected IvistarProxyPTProxy ivistar= new IvistarProxyPTProxy();
	protected SheaSimulatorPTProxy simulator= new SheaSimulatorPTProxy();
	protected UPnPRadioPTProxy radio= new UPnPRadioPTProxy();
	protected NotificationPortTypeProxy notification= new NotificationPortTypeProxy();
	
	protected void initProxys() throws Exception {
		ivistar.setEndpoint(getProp("endpoint_ivistar"));
		simulator.setEndpoint(getProp("endpoint_simulator"));
		radio.setEndpoint(getProp("endpoint_radio"));
		notification.setEndpoint(getProp("endpoint_notification"));
	}
	
	
	
	
	/*
	 * SHEA RuleClient Stuff
	 */
	
	protected REClient ruleClient=	null;
	protected SheaRule rule=		null;
	protected int deploymentDelay;
	protected int ruleID;
	protected String ruleTitle;
	protected String ruleText;
	protected String ruleTextAdd;
	protected String ruleCat;
	protected String sheaUser;
	protected String notificationMessage;
	
	public void initializeRuleClient() {
		ruleClient= new REClient(getPrefixedProp("ruleEngineIP"), 5000);
		removeHardcodedRules();
	}
	
	private void loadRuleProps() {
		ruleCat=	getPrefixedProp("ruleCat");
		ruleTitle=	getPrefixedProp("ruleTitle");
		ruleText=	getPrefixedProp("ruleText");
		ruleTextAdd=getPrefixedProp("ruleTextAdd");
		ruleID=		Integer.parseInt(getPrefixedProp("ruleID"));
	}
	
	/**
	 * remove hardcoded rules. this is not the finest way of doing this, but a workaround
	 * This method is assuming, that the process rules have a rule Id greater or equal to 10
	 * in fact the proceses should have an ID like "10+[no. of demo scenario]"
	 */
	private void removeHardcodedRules() {
		try {
			SheaRule[] rules= ruleClient.getRules();
			if (rules != null) {
				boolean removeRules= false;
				for (SheaRule rule : rules) {
					if (rule.getId() < 10) {
						removeRules= true;
						break;
					}
				}
				if (removeRules) {
					ruleClient.clear();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected SheaRule getRule() {
		if (rule == null) {
			int cat= 0;
			if (ruleCat.startsWith("C")) cat= SheaRule.CATEGORY_COMFORT;
			if (ruleCat.startsWith("E")) cat= SheaRule.CATEGORY_ECO;
			if (ruleCat.startsWith("S")) cat= SheaRule.CATEGORY_SECURITY;
			rule= new SheaRule(null,ruleText, ruleTextAdd, ruleTitle, ruleID, cat, SheaRule.NOT_ACTIVATED);
		}
		return rule;
	}
	
	public void deploy() throws Exception {
		try {
			Thread.sleep(1000 * deploymentDelay);
		} catch (Exception e) { }
		ruleClient.addRule(getRule());
		notification.showMessage(sheaUser, notificationMessage);
	}
	
	public void activate(boolean activate) throws Exception {
		ruleClient.setActivation(getRule(), activate);
	}

	public void undeploy() throws Exception {
		ruleClient.removeRule(getRule());
	}
	
}
