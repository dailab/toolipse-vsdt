/**
 * UPnPRadioPT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.UPnPRadio;

public interface UPnPRadioPT extends java.rmi.Remote {
    public void init() throws java.rmi.RemoteException;
    public void setAVTransportURI(java.lang.String url) throws java.rmi.RemoteException;
    public void playPause(java.math.BigInteger state) throws java.rmi.RemoteException;
    public void play() throws java.rmi.RemoteException;
    public void pause() throws java.rmi.RemoteException;
    public void stop() throws java.rmi.RemoteException;
    public void setVolume(java.math.BigInteger volume) throws java.rmi.RemoteException;
}
