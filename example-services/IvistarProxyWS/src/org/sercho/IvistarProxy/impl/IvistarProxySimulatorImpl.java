package org.sercho.IvistarProxy.impl;

import java.math.BigInteger;
import java.rmi.RemoteException;

import org.sercho.IvistarProxy.IvistarProxyPT;
import org.sercho.SheaSimulator.SheaSimulatorPT;
import org.sercho.SheaSimulator.SheaSimulatorPTProxy;

public class IvistarProxySimulatorImpl implements IvistarProxyPT{

	static SheaSimulatorPT proxy = new SheaSimulatorPTProxy();
	
	@Override
    public String getRooms() throws RemoteException {
    	return null;
    }

	@Override
    public String getLights(String room) throws RemoteException {
		return null;
	}

	@Override
    public String getShades(String room) throws RemoteException {
    	return null;
    }

	@Override
    public String getValue(String room, String line) throws  RemoteException {
		int val= proxy.getLight(room).intValue();
		if (val != -1) {
			return String.valueOf(val);
		}
		return "0";
    }

	@Override
    public void setValue(String room, String line, String value) throws RemoteException {
		proxy.setLight(room,new BigInteger(value));
	}
    
}

