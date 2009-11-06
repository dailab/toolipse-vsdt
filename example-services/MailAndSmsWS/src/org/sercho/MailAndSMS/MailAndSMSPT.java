/**
 * MailAndSMSPT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.MailAndSMS;

public interface MailAndSMSPT extends java.rmi.Remote {
    public boolean sendMail(java.lang.String to, java.lang.String text) throws java.rmi.RemoteException;
    public boolean sendSMS(java.lang.String to, java.lang.String text) throws java.rmi.RemoteException;
}
