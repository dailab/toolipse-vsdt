/**
 * DigiStromServiceSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.DigiStrom;

import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Properties;

import org.sercho.DigiStrom.impl.DigiStromDummyImpl;
import org.sercho.DigiStrom.impl.DigiStromServiceImpl;

public class DigiStromServiceSOAPImpl implements org.sercho.DigiStrom.DigiStromPT{

	public static String NAME= "DigiStromWS";
	public static DigiStromPT impl;
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
			impl= new DigiStromDummyImpl();
		} else {
			impl= new DigiStromServiceImpl();
		}
	}
	
	@Override
    public void setState(String ip, BigInteger id, BigInteger state) throws java.rmi.RemoteException {
		impl.setState(ip, id, state);
    }

}
