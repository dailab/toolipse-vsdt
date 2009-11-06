/**
 * UPnPRadioServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.UPnPRadio;

public class UPnPRadioServiceLocator extends org.apache.axis.client.Service implements org.sercho.UPnPRadio.UPnPRadioService {

    public UPnPRadioServiceLocator() {
    }


    public UPnPRadioServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public UPnPRadioServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for UPnPRadioServiceSOAP
    private java.lang.String UPnPRadioServiceSOAP_address = "http://localhost:8080/UPnPRadioWS/services/UPnPRadioServiceSOAP";

    public java.lang.String getUPnPRadioServiceSOAPAddress() {
        return UPnPRadioServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String UPnPRadioServiceSOAPWSDDServiceName = "UPnPRadioServiceSOAP";

    public java.lang.String getUPnPRadioServiceSOAPWSDDServiceName() {
        return UPnPRadioServiceSOAPWSDDServiceName;
    }

    public void setUPnPRadioServiceSOAPWSDDServiceName(java.lang.String name) {
        UPnPRadioServiceSOAPWSDDServiceName = name;
    }

    public org.sercho.UPnPRadio.UPnPRadioPT getUPnPRadioServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(UPnPRadioServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getUPnPRadioServiceSOAP(endpoint);
    }

    public org.sercho.UPnPRadio.UPnPRadioPT getUPnPRadioServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sercho.UPnPRadio.UPnPRadioSOAPStub _stub = new org.sercho.UPnPRadio.UPnPRadioSOAPStub(portAddress, this);
            _stub.setPortName(getUPnPRadioServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setUPnPRadioServiceSOAPEndpointAddress(java.lang.String address) {
        UPnPRadioServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sercho.UPnPRadio.UPnPRadioPT.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sercho.UPnPRadio.UPnPRadioSOAPStub _stub = new org.sercho.UPnPRadio.UPnPRadioSOAPStub(new java.net.URL(UPnPRadioServiceSOAP_address), this);
                _stub.setPortName(getUPnPRadioServiceSOAPWSDDServiceName());
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
        if ("UPnPRadioServiceSOAP".equals(inputPortName)) {
            return getUPnPRadioServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sercho.org/UPnPRadio/", "UPnPRadioService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sercho.org/UPnPRadio/", "UPnPRadioServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("UPnPRadioServiceSOAP".equals(portName)) {
            setUPnPRadioServiceSOAPEndpointAddress(address);
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
