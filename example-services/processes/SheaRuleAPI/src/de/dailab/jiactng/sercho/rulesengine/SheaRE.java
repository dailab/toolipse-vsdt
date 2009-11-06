package de.dailab.jiactng.sercho.rulesengine;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class SheaRE extends UnicastRemoteObject implements ISheaRulesEngine {

	private static final long serialVersionUID = -8342557212012170649L;

	public static String RMI_NAME= "SheaRE";
	
	public static SheaRule[] RULE_LIST;
	
	private static SheaRE INSTANCE;

	private List<SheaRule> rules= new ArrayList<SheaRule>();
	
	private List<ISheaRuleObserver> observers= new ArrayList<ISheaRuleObserver>();
	
	public static void doRegister() {
		try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        } catch (RemoteException e) {
            System.err.println("Cannot create registry! Already running?");
        }
        try {
        	try {
        		LocateRegistry.getRegistry().lookup(RMI_NAME);
        		System.out.println("Already bound");
        	} catch (NotBoundException e) {
    		   LocateRegistry.getRegistry().rebind(RMI_NAME, getInstance());
               System.out.println("Bound SheaRE to registry (name=" + RMI_NAME + ")");	
        	}
        } catch (AccessException e) {
        	System.err.println("Cannot bind SheaRE to registry!");
        } catch (RemoteException e) {
        	System.err.println("Cannot bind SheaRE to registry!");
        }
	}
	
	public static SheaRE getInstance() {
		if (INSTANCE == null) {
			try {
				INSTANCE= new SheaRE();
			} catch (RemoteException e) {
				System.err.println("Failed to create instance of SheaRE");
			}
		}
		return INSTANCE;
	}
	
	private SheaRE() throws RemoteException {
		super();
	}
	
	private SheaRule getMatch(SheaRule rule) {
		if (rule != null) {
			for (SheaRule r : rules) {
				if (rule.equals(r)) {
					return r;
				}
			}
		}
		return null;
	}
	
	@Override
	public void addObserver(ISheaRuleObserver observer) throws RemoteException {
		if (observer != null) {
			observers.add(observer);
		}
	}

	@Override
	public boolean addRule(SheaRule rule) throws RemoteException {
		SheaRule match= getMatch(rule);
		if (match == null && rule != null) {
			rules.add(rule);
			update();
			return true;
		}
		return false;
	}

	@Override
	public boolean activate(SheaRule rule) throws RemoteException {
		SheaRule match= getMatch(rule);
		if (match != null) {
			rule.setState(SheaRule.ACTIVATED);
			update();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deactivate(SheaRule rule) throws RemoteException {
		SheaRule match= getMatch(rule);
		if (match != null) {
			match.setState(SheaRule.NOT_ACTIVATED);
			update();
			return true;
		}
		return false;
	}
	
	@Override
	public SheaRule[] getRules() throws RemoteException {
		return rules.toArray(new SheaRule[rules.size()]);
	}
	
	@Override
	public boolean removeRule(SheaRule rule) throws RemoteException {
		SheaRule match= getMatch(rule);
		if (match != null) {
			rules.remove(match);
			update();
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAllRules() throws RemoteException {
		rules.clear();
		update();
		return true;
	}
	
	@Override
	public void updateObservers() throws RemoteException {
		System.out.println("Number of observers: " + observers.size());
		for (ISheaRuleObserver observer : observers) {
			System.out.println("Updating Observer " + observer.toString());
			observer.update();
		}
	}
	
	private void update() throws RemoteException {
		RULE_LIST= getRules();
		updateObservers();
	}

}
