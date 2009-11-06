package org.sercho.shea.rules;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import de.dailab.jiactng.sercho.rulesengine.ISheaRulesEngine;
import de.dailab.jiactng.sercho.rulesengine.SheaRE;
import de.dailab.jiactng.sercho.rulesengine.SheaRule;

public class REClient {

	private String ip;
	private int timeout;
	private ISheaRulesEngine re;
	
	public REClient(String ip, int timeout) {
		this.ip= ip;
		this.timeout= timeout;
	}
	
	public boolean addRule(SheaRule rule) throws RemoteException {
		lookupRulesEngine();
		if (re != null) {
			for (SheaRule r : re.getRules()) {
				if (rule.getId() == r.getId()) {
					return false;
				}
			}
			return re.addRule(rule);
		}
		return false;
	}
	
	public boolean removeRule(SheaRule rule) throws RemoteException {
		lookupRulesEngine();
		if (re != null) {
			return re.removeRule(rule);
		}
		return false;
	}
	
	public SheaRule[] getRules() throws RemoteException {
		lookupRulesEngine();
		if (re != null) {
			return re.getRules();
		}
		return null;
	}
	
	public boolean clear() throws RemoteException {
		lookupRulesEngine();
		if (re != null) {
			re.removeAllRules();
			return true;
		}
		return false;
	}
	
	public boolean setActivation(SheaRule rule, boolean activate) throws RemoteException {
		lookupRulesEngine();
		if (re != null) {
			if (activate) {
				return re.activate(rule);
			} else {
				return re.deactivate(rule);
			}
		}
		return false;
	}
		
	protected ISheaRulesEngine lookupRulesEngine() {
		long start = System.currentTimeMillis();
		while ((re == null) && (System.currentTimeMillis() - start < timeout)) {
			try {
				re = (ISheaRulesEngine) Naming.lookup("rmi://" + ip + "/" + SheaRE.RMI_NAME);
			} catch (MalformedURLException e) {
				throw new IllegalArgumentException("IP is not valid!", e);
			} catch (NotBoundException e) {
				System.out.println("Manager with name '" + SheaRE.RMI_NAME
						+ "'not found in registry (reason = NotBoundException)! Retry.");
			} catch (RemoteException e) {
				System.out.println("Cannot connect to registry (reason = RemoteException)! Retry.");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		return re;
	}
	
	public static String toString(SheaRule rule) {
		if (rule == null) {
			return null;
		}
		StringBuffer buffer= new StringBuffer();
		buffer.append("ID: ");
		buffer.append(rule.getId());
		buffer.append(", Title: ");
		buffer.append(rule.getTitle());
		buffer.append(", Text: ");
		buffer.append(rule.getHudText());
		buffer.append(", State: ");
		buffer.append(rule.getState());
		return buffer.toString();
	}

//	private void test() {
//		ISheaRulesEngine re= lookupRulesEngine();
//		
//		if (re != null) {
//			System.out.println("Rule Engine found");
//			try {
//				
//				System.out.println("Printing Rules");
//				for (SheaRule rule : _re.getRules()) {
//					System.out.println(toString(rule));
//				}
//				
//				System.out.println("Removing Rules from RE");
//				re.removeAllRules();
//				System.out.println("Registering new Rules at RE");
//				re.addRule(new SheaRule(null, "Text1", "AddText1", "Title1", 1, SheaRule.CATEGORY_COMFORT,SheaRule.NOT_ACTIVATED));
//				re.addRule(new SheaRule(null, "Text2", "AddText2", "Title2", 2, SheaRule.CATEGORY_ECO,SheaRule.NOT_ACTIVATED));
//				re.addRule(new SheaRule(null, "Text3", "AddText3", "Title3", 3, SheaRule.CATEGORY_SECURITY,SheaRule.ACTIVATED));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} else {
//			System.err.println("No Rule Engine found");
//		}
//	}
//	
//	public static void main(String[] args) {
//		System.out.println(SheaRE.RMI_NAME);
//		String ip= "localhost";
//		int timeout= 10000;
//		new REClient(ip,timeout).test();
//	}
}