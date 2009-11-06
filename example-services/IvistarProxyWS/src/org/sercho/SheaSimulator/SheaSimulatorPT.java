/**
 * SheaSimulatorPT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.SheaSimulator;

public interface SheaSimulatorPT extends java.rmi.Remote {
    public java.lang.String startSimulator() throws java.rmi.RemoteException;
    public void getLocation(java.lang.String username, javax.xml.rpc.holders.StringHolder roomname, javax.xml.rpc.holders.FloatHolder posx, javax.xml.rpc.holders.FloatHolder posy, javax.xml.rpc.holders.FloatHolder posz, javax.xml.rpc.holders.StringHolder zones) throws java.rmi.RemoteException;
    public java.math.BigInteger isInZone(java.lang.String username, java.lang.String zone) throws java.rmi.RemoteException;
    public java.math.BigInteger getLight(java.lang.String id) throws java.rmi.RemoteException;
    public void setLight(java.lang.String id, java.math.BigInteger state) throws java.rmi.RemoteException;
}
