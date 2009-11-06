package starter;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.sercho.IvistarProxy.IvistarProxyPTProxy;
import org.sercho.SheaSimulator.SheaSimulatorPTProxy;
import org.sercho.UPnPRadio.UPnPRadioPTProxy;
import org.sercho.masp.notification.NotificationPortTypeProxy;
import org.sercho.shea.rules.REClient;

import de.dailab.jiactng.sercho.rulesengine.SheaRule;

@SuppressWarnings("serial")
public abstract class AbstractProcessStarter {
	
	protected StringBuffer log= new StringBuffer();
	public static String logDelimeter= "\r\n";
	
	public final StringBuffer getLog() {
		return log;
	}

	public abstract String getProcessName();

	public final int getProcessID() {
		return ruleID;
	}
	
	public AbstractProcessStarter(String pathToPropertiesFile) {
		this.propertiesPath= pathToPropertiesFile;
		log("Properties File location: " + new File("./"+pathToPropertiesFile).getAbsolutePath());
		reloadProperties();
	}
	
	protected String propertiesPath;

	public boolean isStoppable() {
		return true;
	}
	
	/*
	 * properties fields and methods
	 */
	
	protected Properties properties= new Properties();
	
	protected abstract String getPropPrefix();
	
	protected final String getProp(String key) {
		String prop= properties.getProperty(key);
		if (prop != null) {
			log("Got Property '" + key + "': " + prop);
		} else{
			log("WARNING: Property '" + key + "' not found!");
		}
		return prop;
	}
	
	protected final String getPrefixedProp(String key) {
		return getProp(getPropPrefix() + key);
	}

	public final void reloadProperties() {
		try {
			log("reloading properties...");
			properties.load(new FileReader(propertiesPath));
			internalReloadProperties();
			initProxys();
			loadRuleProps();
			initializeRuleClient();
		} catch (Exception e) {
			e.printStackTrace();
			log("ERROR: Could not load Properties.");
		}
	}
	
	protected void internalReloadProperties() {
		deploymentDelay= 	Integer.parseInt(getProp("deploymentDelay"));
		sheaUser=			getProp("sheaUser");
		notificationMessage=getPrefixedProp("notification");
	}
	
	/*
	 * Process Lifecycle
	 */
	
	public final void init() {
		try {
			internalInit();
			internalReset();
			log("Process '" + getProcessName() + "' initialized");
		} catch (Exception e) {
			log("ERROR: Initialize failed: " + e.getMessage());
		}
	}
	
	public final void deploy() {
		try {
			internalDeploy();
			deployRule();
			log("Process '" + getProcessName() + "' deployed");
		} catch (Exception e) {
			log("ERROR: Deploy failed: " + e.getMessage());
		}
	}
	
	public final void start() {
		try {
			internalStart();
			activateRule(true);
			log("Process '" + getProcessName() + "' started");
		} catch (Exception e) {
			log("ERROR: Start failed: " + e.getMessage());
		}
	}
	
	public final void stop() {
		try {
			internalStop();
			activateRule(false);
			log("Process '" + getProcessName() + "' stopped");
		} catch (Exception e) {
			log("ERROR: Stop failed: " + e.getMessage());
		}
	}
	
	public final void reset() {
		try {
			internalReset();
			undeployRule();
			log("Process '" + getProcessName() + "' reset");
		} catch (Exception e) {
			log("ERROR: Reset failed: " + e.getMessage());
		}
	}
	
	protected abstract void internalInit() throws Exception ;
	
	protected abstract void internalDeploy() throws Exception ;
	
	protected abstract void internalStart() throws Exception ;
	
	protected abstract void internalStop() throws Exception ;
	
	protected abstract void internalReset() throws Exception ;
	
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
	
	private final void initializeRuleClient() {
		ruleClient= new REClient(getPrefixedProp("ruleEngineIP"), 3000);
//		removeHardcodedRules();
	}
	
	private final void loadRuleProps() {
		ruleCat=	getPrefixedProp("ruleCat");
		ruleTitle=	getPrefixedProp("ruleTitle");
		ruleText=	getPrefixedProp("ruleText");
		ruleTextAdd=getPrefixedProp("ruleTextAdd");
		ruleID=		Integer.parseInt(getPrefixedProp("ruleID"));
	}
	
//	/**
//	 * remove hard-coded rules. this is not the finest way of doing this, but a workaround
//	 * This method is assuming, that the process rules have a rule Id greater or equal to 10
//	 * in fact the processes should have an ID like "10+[no. of demo scenario]"
//	 */
//	private final void removeHardcodedRules() {
//		try {
//			SheaRule[] rules= ruleClient.getRules();
//			if (rules != null) {
//				boolean removeRules= false;
//				for (SheaRule rule : rules) {
//					if (rule.getId() < 10) {
//						removeRules= true;
//						break;
//					}
//				}
//				if (removeRules) {
//					ruleClient.clear();
//				}
//			}
//		} catch (Exception e) {
//			println(e.getMessage());
//		}
//	}
	
	protected final SheaRule getRule() {
		if (rule == null) {
			int cat= 0;
			if (ruleCat.startsWith("C")) cat= SheaRule.CATEGORY_COMFORT;
			if (ruleCat.startsWith("E")) cat= SheaRule.CATEGORY_ECO;
			if (ruleCat.startsWith("S")) cat= SheaRule.CATEGORY_SECURITY;
			rule= new SheaRule(null,ruleText, ruleTextAdd, ruleTitle, ruleID, cat, SheaRule.NOT_ACTIVATED);
		}
		return rule;
	}
	
	public final void deployRule() throws Exception {
		try {
			Thread.sleep(1000 * deploymentDelay);
		} catch (Exception e) { }
		ruleClient.addRule(getRule());
		notification.showMessage(sheaUser, notificationMessage);
	}
	
	public final void activateRule(boolean activate) throws Exception {
		ruleClient.setActivation(getRule(), activate);
	}

	public final void undeployRule() throws Exception {
		ruleClient.removeRule(getRule());
	}
	
	protected void log(String s) {
		String s2= getClass() + " - " + s;
		if (log != null) {
			log.append(s2);
			log.append(logDelimeter);
		} else {
			System.out.println(s2);
		}
	}
	
}
