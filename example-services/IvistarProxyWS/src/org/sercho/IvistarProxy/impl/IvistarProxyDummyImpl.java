package org.sercho.IvistarProxy.impl;

import java.rmi.RemoteException;

import org.sercho.IvistarProxy.IvistarProxyPT;

public class IvistarProxyDummyImpl implements IvistarProxyPT{

	@Override
    public String getRooms() throws RemoteException {
    	System.out.print("Invoking getRooms...");
    	String ret= "[ Living Room, Office, Studio, Kitchen ]";
    	System.out.println(ret);
    	return ret;
    }

	@Override
    public String getLights(String room) throws RemoteException {
    	System.out.print("Invoking getLights for "+room+"...");
        String ret= "[ 1, 2, 3, 4, 5 ]";
        System.out.println(ret);
        return ret;
    }

	@Override
    public String getShades(String room) throws RemoteException {
    	System.out.print("Invoking getShades for "+room+" ...");
    	String ret= "[ 6, 7, 8, 9, 10 ]";
    	System.out.println(ret);
    	return ret;
    }

	@Override
    public String getValue(String room, String line) throws  RemoteException {
    	System.out.print("Invoking setValue for "+room+", "+line+"...");
    	String ret= "100"; 
		System.out.println(ret);
    	return ret;
    }

	@Override
    public void setValue(String room, String line, String value) throws RemoteException {
    	System.out.println("Invoking setValue for "+room+", "+line+", "+value);
    }
    
}
