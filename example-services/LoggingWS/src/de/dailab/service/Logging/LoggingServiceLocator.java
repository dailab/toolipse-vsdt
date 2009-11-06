/**
 * LoggingServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.dailab.service.Logging;

public class LoggingServiceLocator extends org.apache.axis.client.Service implements de.dailab.service.Logging.LoggingService {

    public LoggingServiceLocator() {
    }


    public LoggingServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LoggingServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LoggingPort
    private java.lang.String LoggingPort_address = "http://localhost:8080/LoggingWS/services/LoggingPort";

    public java.lang.String getLoggingPortAddress() {
        return LoggingPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LoggingPortWSDDServiceName = "LoggingPort";

    public java.lang.String getLoggingPortWSDDServiceName() {
        return LoggingPortWSDDServiceName;
    }

    public void setLoggingPortWSDDServiceName(java.lang.String name) {
        LoggingPortWSDDServiceName = name;
    }

    public de.dailab.service.Logging.LoggingPT getLoggingPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LoggingPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLoggingPort(endpoint);
    }

    public de.dailab.service.Logging.LoggingPT getLoggingPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            de.dailab.service.Logging.LoggingStub _stub = new de.dailab.service.Logging.LoggingStub(portAddress, this);
            _stub.setPortName(getLoggingPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLoggingPortEndpointAddress(java.lang.String address) {
        LoggingPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (de.dailab.service.Logging.LoggingPT.class.isAssignableFrom(serviceEndpointInterface)) {
                de.dailab.service.Logging.LoggingStub _stub = new de.dailab.service.Logging.LoggingStub(new java.net.URL(LoggingPort_address), this);
                _stub.setPortName(getLoggingPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LoggingPort".equals(inputPortName)) {
            return getLoggingPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.dailab.de/Logging/", "LoggingService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.dailab.de/Logging/", "LoggingPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LoggingPort".equals(portName)) {
            setLoggingPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
