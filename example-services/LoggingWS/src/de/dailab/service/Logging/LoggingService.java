/**
 * LoggingService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.dailab.service.Logging;

public interface LoggingService extends javax.xml.rpc.Service {
    public java.lang.String getLoggingPortAddress();

    public de.dailab.service.Logging.LoggingPT getLoggingPort() throws javax.xml.rpc.ServiceException;

    public de.dailab.service.Logging.LoggingPT getLoggingPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
