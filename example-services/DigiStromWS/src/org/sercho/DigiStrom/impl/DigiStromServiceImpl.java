/**
 * DigiStromServiceSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.DigiStrom.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;

public class DigiStromServiceImpl implements org.sercho.DigiStrom.DigiStromPT{
	
	/*
	 * p1: 0 = power
	 * p2: id in [65..68]
	 * p3: (1,0) = (on,off)
	 * 
	 * beispiel: http://192.168.1.220/exec?p2=66&p1=0&p3=1
	 */
	
	public static int BUFFER_SIZE= 1024;
	
	@Override
    public void setState(String ip, BigInteger id, BigInteger state) throws java.rmi.RemoteException {
		
		System.out.println("Invoking setState with ip="+ip+", id="+id.intValue()+", state="+state.intValue());
		
    	//build full URL
    	StringBuffer buff= new StringBuffer();
    	buff.append("http://");
    	buff.append(ip);
    	buff.append("/exec?");
    	buff.append("p1=0&p2=");
    	buff.append(id.intValue());
    	buff.append("&p3=");
    	buff.append(state.intValue());
    	String urlString= buff.toString();
    	
    	//open stream
    	InputStream in= null;
        try {
            in = new URL(urlString).openStream();
      	} catch(Exception e) {
            System.err.println("Failed to connect to HC10 web server under url: " + urlString);
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
