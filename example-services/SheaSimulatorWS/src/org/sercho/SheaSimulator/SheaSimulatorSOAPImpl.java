/**
 * SheaSimulatorSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.SheaSimulator;

import java.math.BigInteger;
import java.rmi.RemoteException;

import javax.xml.rpc.holders.FloatHolder;
import javax.xml.rpc.holders.StringHolder;

import org.sercho.SheaSimulator.impl.SheaSimulatorServiceImpl;

public class SheaSimulatorSOAPImpl implements SheaSimulatorPT{
    
	public static SheaSimulatorPT impl= new SheaSimulatorServiceImpl();
	
	@Override
	public BigInteger getLight(String id) throws RemoteException {
		return impl.getLight(id);
	}
	
	@Override
	public void getLocation(String username, StringHolder roomname,
			FloatHolder posx, FloatHolder posy, FloatHolder posz,
			StringHolder zones) throws RemoteException {
		impl.getLocation(username, roomname, posx, posy, posz, zones);
	}
	
	@Override
	public BigInteger isInZone(String username, String zone)
			throws RemoteException {
		return impl.isInZone(username, zone);
	}
	
	@Override
	public void setLight(String id, BigInteger state) throws RemoteException {
		impl.setLight(id, state);
	}

	@Override
	public String startSimulator() throws RemoteException {
		return impl.startSimulator();
	}

}
