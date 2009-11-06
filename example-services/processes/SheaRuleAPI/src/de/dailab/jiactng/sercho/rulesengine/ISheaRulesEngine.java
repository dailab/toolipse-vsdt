package de.dailab.jiactng.sercho.rulesengine;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISheaRulesEngine extends Remote, Serializable {
	
	boolean activate(SheaRule rule) throws RemoteException;
	
	boolean deactivate(SheaRule rule) throws RemoteException;
	
	boolean addRule(SheaRule rule) throws RemoteException;
	
	boolean removeRule(SheaRule rule) throws RemoteException;
	
	boolean removeAllRules() throws RemoteException;
	
	SheaRule[] getRules() throws RemoteException;
	
	void addObserver(ISheaRuleObserver observer) throws RemoteException;
	
	void updateObservers() throws RemoteException;

}
