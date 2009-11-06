/**
 * MailAndSMSSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.MailAndSMS;

import java.rmi.RemoteException;

import org.sercho.mail.Notificator;

public class MailAndSMSSOAPImpl implements MailAndSMSPT {

	@Override
	public boolean sendMail(String to, String text) throws RemoteException {
		System.out.print("Invoking sendMail... ");
		boolean ret =new Notificator().sendEmail(to, text);
		System.out.println(ret);
        return ret;
    }

	@Override
    public boolean sendSMS(String to, String text) throws RemoteException {
    	System.out.print("Invoking sendSMS...");
        boolean ret= new Notificator().sendSMS(to, text);
        System.out.println(ret);
        return ret;
    }
    
}
