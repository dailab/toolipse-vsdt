/**
 * IvistarProxyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.IvistarProxy;

public class IvistarProxyServiceLocator extends org.apache.axis.client.Service implements org.sercho.IvistarProxy.IvistarProxyService {

    public IvistarProxyServiceLocator() {
    }


    public IvistarProxyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IvistarProxyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IvistarProxyServiceSOAP
    private java.lang.String IvistarProxyServiceSOAP_address = "http://localhost:8080/IvistarProxy/services/IvistarProxyServiceSOAP";

    public java.lang.String getIvistarProxyServiceSOAPAddress() {
        return IvistarProxyServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IvistarProxyServiceSOAPWSDDServiceName = "IvistarProxyServiceSOAP";

    public java.lang.String getIvistarProxyServiceSOAPWSDDServiceName() {
        return IvistarProxyServiceSOAPWSDDServiceName;
    }

    public void setIvistarProxyServiceSOAPWSDDServiceName(java.lang.String name) {
        IvistarProxyServiceSOAPWSDDServiceName = name;
    }

    public org.sercho.IvistarProxy.IvistarProxyPT getIvistarProxyServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IvistarProxyServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIvistarProxyServiceSOAP(endpoint);
    }

    public org.sercho.IvistarProxy.IvistarProxyPT getIvistarProxyServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sercho.IvistarProxy.IvistarProxySOAPStub _stub = new org.sercho.IvistarProxy.IvistarProxySOAPStub(portAddress, this);
            _stub.setPortName(getIvistarProxyServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIvistarProxyServiceSOAPEndpointAddress(java.lang.String address) {
        IvistarProxyServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sercho.IvistarProxy.IvistarProxyPT.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sercho.IvistarProxy.IvistarProxySOAPStub _stub = new org.sercho.IvistarProxy.IvistarProxySOAPStub(new java.net.URL(IvistarProxyServiceSOAP_address), this);
                _stub.setPortName(getIvistarProxyServiceSOAPWSDDServiceName());
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
        if ("IvistarProxyServiceSOAP".equals(inputPortName)) {
            return getIvistarProxyServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sercho.org/IvistarProxy/", "IvistarProxyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sercho.org/IvistarProxy/", "IvistarProxyServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IvistarProxyServiceSOAP".equals(portName)) {
            setIvistarProxyServiceSOAPEndpointAddress(address);
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
