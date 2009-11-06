/**
 * NotificationLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.masp.notification;

public class NotificationLocator extends org.apache.axis.client.Service implements org.sercho.masp.notification.Notification {

    public NotificationLocator() {
    }


    public NotificationLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public NotificationLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for NotificationHttpPort
    private java.lang.String NotificationHttpPort_address = "http://localhost:8080/shea/services/Notification";

    public java.lang.String getNotificationHttpPortAddress() {
        return NotificationHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String NotificationHttpPortWSDDServiceName = "NotificationHttpPort";

    public java.lang.String getNotificationHttpPortWSDDServiceName() {
        return NotificationHttpPortWSDDServiceName;
    }

    public void setNotificationHttpPortWSDDServiceName(java.lang.String name) {
        NotificationHttpPortWSDDServiceName = name;
    }

    public org.sercho.masp.notification.NotificationPortType getNotificationHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(NotificationHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getNotificationHttpPort(endpoint);
    }

    public org.sercho.masp.notification.NotificationPortType getNotificationHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sercho.masp.notification.NotificationHttpBindingStub _stub = new org.sercho.masp.notification.NotificationHttpBindingStub(portAddress, this);
            _stub.setPortName(getNotificationHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setNotificationHttpPortEndpointAddress(java.lang.String address) {
        NotificationHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sercho.masp.notification.NotificationPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sercho.masp.notification.NotificationHttpBindingStub _stub = new org.sercho.masp.notification.NotificationHttpBindingStub(new java.net.URL(NotificationHttpPort_address), this);
                _stub.setPortName(getNotificationHttpPortWSDDServiceName());
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
        if ("NotificationHttpPort".equals(inputPortName)) {
            return getNotificationHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://notification.masp.sercho.org", "Notification");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://notification.masp.sercho.org", "NotificationHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("NotificationHttpPort".equals(portName)) {
            setNotificationHttpPortEndpointAddress(address);
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
