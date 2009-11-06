/**
 * UPnPRadioSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.UPnPRadio.impl;

import java.math.BigInteger;
import java.rmi.RemoteException;

public class UPnPRadioDummyImpl implements org.sercho.UPnPRadio.UPnPRadioPT{
	
	@Override
	public void init(String deviceID) throws RemoteException {
		System.out.println("Invoking Init...");
	}
	
	@Override
	public void setAVTransportURI(String url) throws RemoteException {
		System.out.println("Invoking setAVTransport...");
	}
	
	@Override
	public void play() throws RemoteException {
		System.out.println("Invoking Play..");
	}
	
	@Override
	public void pause() throws RemoteException {
		System.out.println("Invoking Pause...");
	}
	
	@Override
	public void playPause(BigInteger state) throws RemoteException {
		if (state.intValue() == 1) {
			play();
		} else {
			pause();
		}
	}
	
	@Override
	public void setVolume(BigInteger volume) throws RemoteException {
		System.out.println("Setting Volume to " + volume);
	}
	
	@Override
	public void stop() throws RemoteException {
		System.out.println("Invoking Stop...");
	}
}
