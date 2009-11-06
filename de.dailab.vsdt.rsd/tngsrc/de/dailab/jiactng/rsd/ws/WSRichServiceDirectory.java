/**
 * WSRichServiceDirectory.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.dailab.jiactng.rsd.ws;

public interface WSRichServiceDirectory extends javax.xml.rpc.Service {
    public java.lang.String getWSRichServiceDirectorySOAP11port_httpAddress();

    public de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType getWSRichServiceDirectorySOAP11port_http() throws javax.xml.rpc.ServiceException;

    public de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType getWSRichServiceDirectorySOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public java.lang.String getWSRichServiceDirectorySOAP12port_httpAddress();

    public de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType getWSRichServiceDirectorySOAP12port_http() throws javax.xml.rpc.ServiceException;

    public de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType getWSRichServiceDirectorySOAP12port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
