/**
 * DigiStromServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.DigiStrom;

public class DigiStromServiceLocator extends org.apache.axis.client.Service implements org.sercho.DigiStrom.DigiStromService {
    public DigiStromServiceLocator() {
    }


    public DigiStromServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DigiStromServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DigiStromServiceSOAP
    private java.lang.String DigiStromServiceSOAP_address = "http://sercho.org";

    public java.lang.String getDigiStromServiceSOAPAddress() {
        return DigiStromServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DigiStromServiceSOAPWSDDServiceName = "DigiStromServiceSOAP";

    public java.lang.String getDigiStromServiceSOAPWSDDServiceName() {
        return DigiStromServiceSOAPWSDDServiceName;
    }

    public void setDigiStromServiceSOAPWSDDServiceName(java.lang.String name) {
        DigiStromServiceSOAPWSDDServiceName = name;
    }

    public org.sercho.DigiStrom.DigiStromPT getDigiStromServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DigiStromServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDigiStromServiceSOAP(endpoint);
    }

    public org.sercho.DigiStrom.DigiStromPT getDigiStromServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sercho.DigiStrom.DigiStromServiceSOAPStub _stub = new org.sercho.DigiStrom.DigiStromServiceSOAPStub(portAddress, this);
            _stub.setPortName(getDigiStromServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDigiStromServiceSOAPEndpointAddress(java.lang.String address) {
        DigiStromServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sercho.DigiStrom.DigiStromPT.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sercho.DigiStrom.DigiStromServiceSOAPStub _stub = new org.sercho.DigiStrom.DigiStromServiceSOAPStub(new java.net.URL(DigiStromServiceSOAP_address), this);
                _stub.setPortName(getDigiStromServiceSOAPWSDDServiceName());
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
        if ("DigiStromServiceSOAP".equals(inputPortName)) {
            return getDigiStromServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sercho.org/DigiStrom/", "DigiStromService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sercho.org/DigiStrom/", "DigiStromServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DigiStromServiceSOAP".equals(portName)) {
            setDigiStromServiceSOAPEndpointAddress(address);
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
