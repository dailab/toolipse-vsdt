/**
 * UPnPRadioSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.UPnPRadio;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Properties;

import org.sercho.UPnPRadio.impl.UPnPRadioDummyImpl;
import org.sercho.UPnPRadio.impl.UPnPRadioServiceImpl;

public class UPnPRadioSOAPImpl implements org.sercho.UPnPRadio.UPnPRadioPT{

	public static String NAME= "UPnPRadioWS";
	public static UPnPRadioPT impl;
	public static boolean useDummy= false;
	
	static {
		try {
			Properties properties= new Properties();
			properties.load(new FileInputStream("conf/WSDummyUsage.properties"));
			String prop= properties.getProperty(NAME);
			useDummy= Boolean.parseBoolean(prop);
		} catch (Exception e) {
			useDummy= false;
		}
		
		if (useDummy) {
			System.out.println("WARNING: USING DUMMY IMPLMENTATION FOR " + NAME);
			impl= new UPnPRadioDummyImpl();
		} else {
			impl= new UPnPRadioServiceImpl();
		}
	}
	
	@Override
	public void init(String deviceID) throws RemoteException {
		impl.init(deviceID);
	}
	
	@Override
	public void setAVTransportURI(String url) throws RemoteException {
		impl.setAVTransportURI(url);
	}
	
	@Override
	public void play() throws RemoteException {
		impl.play();
	}
	
	@Override
	public void pause() throws RemoteException {
		impl.pause();
	}
	
	@Override
	public void playPause(BigInteger state) throws RemoteException {
		impl.playPause(state);
	}
	
	@Override
	public void setVolume(BigInteger volume) throws RemoteException {
		impl.setVolume(volume);
	}
	
	@Override
	public void stop() throws RemoteException {
		impl.stop();
	}
}
