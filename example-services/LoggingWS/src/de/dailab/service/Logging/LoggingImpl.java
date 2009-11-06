/**
 * LoggingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.dailab.service.Logging;

import java.math.BigInteger;

public class LoggingImpl implements de.dailab.service.Logging.LoggingPT{

    public void log(String message, BigInteger level) throws java.rmi.RemoteException {
    	String levelString;
    	switch (level.intValue()) {
    	case 0:  levelString= "DEBUG: "; break;
    	case 1:  levelString= "INFO:  "; break;
    	case 2:  levelString= "WARN:  "; break;
    	case 3:  levelString= "ERROR: "; break;
    	case 4:  levelString= "FATAL: "; break;
    	default: levelString= "INFO:  "; break;
    	}
    	System.out.println("LoggingWS - " + levelString + message);
    	
    }

}
