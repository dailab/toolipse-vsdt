/**
 * DigiStromServiceSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.IvistarProxy.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import org.sercho.IvistarProxy.IvistarProxyPT;

public class IvistarPseudoDigiStromServiceImpl extends IvistarProxyDummyImpl implements IvistarProxyPT {
	
	/*
	 * p1: 0 = power
	 * p2: id in [65..68]
	 * p3: (1,0) = (on,off)
	 * 
	 * beispiel: http://192.168.1.220/exec?p2=66&p1=0&p3=1(&p5=1)
	 */
	
	public static int BUFFER_SIZE= 1024;
	
	protected static Map<String, String> lastState= new HashMap<String, String>();
	
	@Override
	public String getValue(String room, String line) throws RemoteException {
		System.out.println("Invoking getValue with room=" + room+ ", line=" + line);

		int delimeter= line.indexOf("-");
		String id= line.substring(delimeter+1);
			
		System.out.println("Getting last value from map");
		String last= lastState.get(id);
		return last != null ? last : "0";
	}

	@Override
	public void setValue(String room, String line, String value) throws RemoteException {
		System.out.println("Invoking setValue with room=" + room+ ", line=" + line + ", value=" + value);
		int delimeter= line.indexOf("-");
		String ip= line.substring(0, delimeter);
		String id= line.substring(delimeter+1);
		String state= "0".equals(value) ? "0" : "1";
		System.out.println("Calling DigitalStrom with ip=" + ip + ", id=" + id + ", state=" + state);
		
    	//build full URL
    	StringBuffer buff= new StringBuffer();
    	buff.append("http://");
    	buff.append(ip);
    	buff.append("/exec?");
    	buff.append("p1=0&p2=");
    	buff.append(id);
    	buff.append("&p3=");
    	buff.append(state);
    	buff.append("&p5=1");
    	String urlString= buff.toString();
    	
    	//open stream
    	InputStream in= null;
        try {
            in = new URL(urlString).openStream();
            lastState.put(id, state);
      	} catch(Exception e) {
            System.err.println("Failed to connect to HC10 web server under url: " + urlString);
            lastState.put(id, "0".equals(state) ? "1" : "0");
        }
        
        //read from stream
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            final StringBuffer response = new StringBuffer();
            final char[] buffer = new char[BUFFER_SIZE];
            int read = 0;
            while((read = reader.read(buffer)) != -1) {
                response.append(buffer, 0, read);
            }          
            // could return response string here, but no response is needed
            System.out.println("Response is: " + response.toString());
        }
        catch(Exception e) {
            System.err.println("Failed to read response from HC10 web server under url: " + urlString);
        }
        
        //close stream
        finally {
            try {
                in.close();
            }
            catch(Exception e) {
                System.err.println("Failed to close InputStream from HC10 web server: " + e.getMessage());
            }
        }
	}
	
}
