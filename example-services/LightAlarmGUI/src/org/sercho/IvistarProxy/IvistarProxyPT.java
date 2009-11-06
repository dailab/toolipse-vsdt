/**
 * IvistarProxyPT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.IvistarProxy;

public interface IvistarProxyPT extends java.rmi.Remote {
    public java.lang.String getRooms() throws java.rmi.RemoteException;
    public java.lang.String getLights(java.lang.String room) throws java.rmi.RemoteException;
    public java.lang.String getShades(java.lang.String room) throws java.rmi.RemoteException;
    public java.lang.String getValue(java.lang.String room, java.lang.String line) throws java.rmi.RemoteException;
    public void setValue(java.lang.String room, java.lang.String line, java.lang.String value) throws java.rmi.RemoteException;
}
