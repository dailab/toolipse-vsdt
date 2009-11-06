/**
 * EnergySavingPT.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package EnergySaving.WSDL;

public interface EnergySavingPT extends java.rmi.Remote {
    public void start(java.lang.String paramUserName, java.math.BigInteger paramDelaySec, java.lang.String paramZone, java.lang.String paramLightLine, java.lang.String paramRoom) throws java.rmi.RemoteException;
    public void stop() throws java.rmi.RemoteException;
}
