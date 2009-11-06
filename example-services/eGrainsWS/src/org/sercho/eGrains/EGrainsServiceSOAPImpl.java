/**
 * EGrainsServiceSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.eGrains;

import java.math.BigInteger;
import java.rmi.RemoteException;

import org.dailab.sercho.masp.egrain.CommLink;
import org.sercho.eGrains.messages.Messages;

public class EGrainsServiceSOAPImpl implements EGrainsPT {
	
	public static String COMM_PORT = Messages.getString("EGrainsServiceSOAPImpl.COMPORT"); //$NON-NLS-1$
	public static int TIMEOUT = 2000;
	
	private static CommLink comm= new CommLink(COMM_PORT,TIMEOUT);
	
	@Override
	public void connect(String value) throws RemoteException {
		System.out.println("--- connecting"); //$NON-NLS-1$
		String port= COMM_PORT;
		if (value != null && value.startsWith("COM")) { //$NON-NLS-1$
			port= value;
			comm= new CommLink(port,TIMEOUT);
		}
		comm.connect();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}
	
	@Override
	public void disconnect() throws RemoteException {
		System.out.println("--- disconnecting"); //$NON-NLS-1$
		comm.disconnect();
	}
	
	@Override
	public float getTemperature(BigInteger value) throws RemoteException {
		String temp= comm.getController().getNode(value.intValue()).getTemperatureValue();
    	System.out.println("--- temperature is " + temp); //$NON-NLS-1$
		try {
			return Float.parseFloat(temp);
		} catch (NumberFormatException e) {
			return -1f;
		}
    }

	@Override
	public boolean isRegistered(BigInteger value) throws RemoteException {
    	boolean temp= comm.getController().getNode(value.intValue()).isRegistered();
    	System.out.println("--- node is " + (temp? "" : "not ") + "registered"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    	return temp;
    }

	@Override
	public boolean isEnabled(BigInteger value) throws RemoteException {
    	boolean temp= comm.getController().getNode(value.intValue()).isEnabled();
    	System.out.println("--- node is " + (temp? "" : "not ") + "enabled"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    	return temp;
    }
    
	@Override
	public String getIDs() throws RemoteException {
    	int[] ids= comm.getController().getIDs();
    	StringBuffer temp= new StringBuffer();
    	for (int i : ids) {
    		temp.append(i).append(" "); //$NON-NLS-1$
    	}
    	System.out.println("--- IDs: " + temp.toString()); //$NON-NLS-1$
    	return temp.toString();
    }
    
	/**
	 * Test method
	 */
    public static void main(String[] args) {
    	try {
			EGrainsServiceSOAPImpl impl= new EGrainsServiceSOAPImpl();

			impl.connect(null);
//			impl.getTemperature(BigInteger.valueOf(0));
			
			impl.disconnect();
			
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
	}

}
