/**
 * EGrainsPT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.eGrains;

public interface EGrainsPT extends java.rmi.Remote {
    public void connect(java.lang.String value) throws java.rmi.RemoteException;
    public void disconnect() throws java.rmi.RemoteException;
    public float getTemperature(java.math.BigInteger value) throws java.rmi.RemoteException;
    public java.lang.String getIDs() throws java.rmi.RemoteException;
    public boolean isRegistered(java.math.BigInteger value) throws java.rmi.RemoteException;
    public boolean isEnabled(java.math.BigInteger value) throws java.rmi.RemoteException;
}
