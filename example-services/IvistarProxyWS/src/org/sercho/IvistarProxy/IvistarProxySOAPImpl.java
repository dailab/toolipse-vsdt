/**
 * IvistarProxySOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.IvistarProxy;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.util.Properties;

import org.sercho.IvistarProxy.impl.IvistarProxyDummyImpl;
import org.sercho.IvistarProxy.impl.IvistarProxyServiceImpl;
import org.sercho.IvistarProxy.impl.IvistarProxySimulatorImpl;
import org.sercho.IvistarProxy.impl.IvistarPseudoDigiStromServiceImpl;

public class IvistarProxySOAPImpl implements IvistarProxyPT{

	public static String NAME= "IvistarProxyWS";
	public static IvistarProxyPT impl;
	
	public static IvistarProxyPT simulator= new IvistarProxySimulatorImpl();
	
	static {
		try {
			Properties properties= new Properties();
			properties.load(new FileInputStream("conf/WSDummyUsage.properties"));
			String prop= properties.getProperty(NAME);
			
			if ("ivistar".equals(prop.toLowerCase())) {
				impl= new IvistarProxyServiceImpl();
			}
			if ("digitalstrom".equals(prop.toLowerCase())) {
				impl= new IvistarPseudoDigiStromServiceImpl();
			}
			if ("simulator".equals(prop.toLowerCase())) {
				impl= new IvistarProxySimulatorImpl();
			}
		} catch (Exception e) {
		}
		
		if (impl == null) {
			System.out.println("WARNING: USING DUMMY IMPLMENTATION FOR " + NAME);
			impl= new IvistarProxyDummyImpl();
		}
	}

	@Override
    public String getRooms() throws RemoteException {
		simulator.getRooms();
    	return impl.getRooms();
    }

	@Override
    public String getLights(String room) throws RemoteException {
		simulator.getLights(room);
		return impl.getLights(room);
	}

	@Override
    public String getShades(String room) throws RemoteException {
		simulator.getShades(room);
    	return impl.getShades(room);
    }

	@Override
    public String getValue(String room, String line) throws  RemoteException {
		simulator.getValue(room, line);
    	return impl.getValue(room, line);
    }

	@Override
    public void setValue(String room, String line, String value) throws RemoteException {
		simulator.setValue(room, line, value);
		impl.setValue(room, line, value);
	}

}
