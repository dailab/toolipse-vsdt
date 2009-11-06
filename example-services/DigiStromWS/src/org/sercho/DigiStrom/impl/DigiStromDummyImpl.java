/**
 * DigiStromServiceSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.DigiStrom.impl;

import java.math.BigInteger;

public class DigiStromDummyImpl implements org.sercho.DigiStrom.DigiStromPT{

	@Override
    public void setState(String ip, BigInteger id, BigInteger state) throws java.rmi.RemoteException {
		
		System.out.println("Invoking setState with ip="+ip+", id="+id.intValue()+", state="+state.intValue());
		
    }

}
