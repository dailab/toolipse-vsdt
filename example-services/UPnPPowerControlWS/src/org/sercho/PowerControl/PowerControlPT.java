/**
 * PowerControlPT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.PowerControl;

public interface PowerControlPT extends java.rmi.Remote {
    public java.math.BigInteger switchOnOff(java.lang.String deviceName, java.math.BigInteger onOff) throws java.rmi.RemoteException;
    public java.math.BigInteger getState(java.lang.String deviceName) throws java.rmi.RemoteException;
}
