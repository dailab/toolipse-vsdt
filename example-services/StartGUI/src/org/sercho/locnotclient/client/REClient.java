package org.sercho.locnotclient.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import de.dailab.jiactng.sercho.rulesengine.ISheaRulesEngine;
import de.dailab.jiactng.sercho.rulesengine.SheaRE;
import de.dailab.jiactng.sercho.rulesengine.SheaRule;

public class REClient {

	private ISheaRulesEngine _re= null;
	private SheaRule _rule= null;
	
	
	
	String ip= "localhost";
	String timeout= "5000";
	String description1= "Turn off lights if no person is in the room.";
	String description2= "This rule can save around 30 kW/year which equals 20 euro/year.";
	String catName= "Green Energy";
	int ruleID= 0;

	public REClient(String propFile) {
		//load properties
		try {
			InputStream in= new FileInputStream(new File(propFile));
			Properties prop= new Properties();
			prop.load(in);
			ip= prop.getProperty("ip");
			timeout= prop.getProperty("timeout");
			description1= prop.getProperty("description1");
			description2= prop.getProperty("description2");
			catName= prop.getProperty("catName");
			ruleID= Integer.parseInt(prop.getProperty("ruleID"));
		} catch (Exception e) {
			System.err.println(propFile + " not found");
		}
		//create rule
		_rule= new SheaRule(
				null,
				description1,
				description2,
				catName,
				ruleID,
				SheaRule.CATEGORY_ECO,
				SheaRule.ACTIVATED);
		//create Rules engine
		lookupRulesEngine(ip, timeout);
	}
	
	public boolean addRule() {
		try {
			if (_re != null) {
				return _re.addRule(_rule);
			} else {
				return false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean removeRule(boolean all) {
		try {
			if (_re != null) {
				if (all) {
					_re.removeAllRules();
					for (SheaRule rule : SheaRE.RULE_LIST) {
						_re.addRule(rule);
					}
					return true;
				} else {
					return _re.removeRule(_rule);
				}
			} else {
				return false;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
		
	private void lookupRulesEngine(String ip, String timeout) {
		int timeoutValue = Integer.parseInt(timeout);
		long start = System.currentTimeMillis();
		long end = start;
		while ((_re == null) && (end - start < timeoutValue)) {
			try {
				this._re = (ISheaRulesEngine) Naming.lookup("rmi://" + ip + "/" + SheaRE.RMI_NAME);
			} catch (MalformedURLException e) {
				throw new IllegalArgumentException("IP is not valid!", e);
			} catch (NotBoundException e) {
				System.out.println("Manager with name '" + SheaRE.RMI_NAME
						+ "'not found in registry (reason = NotBoundException)! Retry.");
				System.out.println("mist. " + e.getMessage());
			} catch (RemoteException e) {
				System.out.println("Cannot connect to registry (reason = RemoteException)! Retry.");
				e.printStackTrace();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("Interrupted Exception.");
			}
			end = System.currentTimeMillis();
		}
	}

}
