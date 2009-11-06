/**
 * NotificationPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.masp.notification;

public interface NotificationPortType extends java.rmi.Remote {
    public java.lang.String[] getUserIDs() throws java.rmi.RemoteException;
    public void showMessage(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException;
}
