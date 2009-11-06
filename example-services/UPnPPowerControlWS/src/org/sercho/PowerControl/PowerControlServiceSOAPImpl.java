/**
 * PowerControlServiceSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.PowerControl;

import java.math.BigInteger;

import org.sercho.esc.UPnPPowerControl;

public class PowerControlServiceSOAPImpl implements org.sercho.PowerControl.PowerControlPT{

	/**static instace of the power control*/
	private static UPnPPowerControl powerControl;
	
	/**
	 * if the power control does not exist already, it is created, then the thread sleeps
	 * some seconds and then inquires on visible devices
	 */
	public UPnPPowerControl getPowerControl(String deviceName) {
		if (powerControl == null) {
			powerControl= new UPnPPowerControl();
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
			}
			powerControl.printDevices();
		}
		powerControl.setDeviceName(deviceName);
		return powerControl;
	}
	
	/**
	 * switch the device on/off. for switching the device on, a 1 has to be passed, for switching
	 * it off, a 0 has to be passed. if any other value is passed, the device is just switched
	 */
    public java.math.BigInteger switchOnOff(java.lang.String deviceName, java.math.BigInteger onOff) throws java.rmi.RemoteException {

    	boolean ok= false;

    	if (onOff.intValue() > 0) {
    		//an
    		System.out.println("--- switching the device on");
    		ok= getPowerControl(deviceName).switchPower(true);
    	}
    	if (onOff.intValue() < 0) {
    		//aus
    		System.out.println("--- switching the device off");
    		ok= getPowerControl(deviceName).switchPower(false);
    	}
    	if (onOff.intValue() == 0) {
    		//schalten
    		System.out.println("--- switching the device");
			int i= getPowerControl(deviceName).getPowerStatus();
    		ok= getPowerControl(deviceName).switchPower(i == 0);
    	}
    	if (! ok) {
    		System.err.println("--- failed");
    	}
    	return ok? BigInteger.ONE : BigInteger.ZERO;
    }

    public java.math.BigInteger getState(java.lang.String deviceName) throws java.rmi.RemoteException {
    	System.out.println("--- entered getState");
    	
    	int state= getPowerControl(deviceName).getPowerStatus();
    	System.out.println("--- device status is " + state);
    	
        return BigInteger.valueOf(state);
    }

}
