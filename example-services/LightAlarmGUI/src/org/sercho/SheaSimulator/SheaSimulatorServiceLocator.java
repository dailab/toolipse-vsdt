/**
 * SheaSimulatorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.SheaSimulator;

public class SheaSimulatorServiceLocator extends org.apache.axis.client.Service implements org.sercho.SheaSimulator.SheaSimulatorService {

    public SheaSimulatorServiceLocator() {
    }


    public SheaSimulatorServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SheaSimulatorServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SheaSimulatorServiceSOAP
    private java.lang.String SheaSimulatorServiceSOAP_address = "http://localhost:8080/SheaSimulatorWS/services/SheaSimulatorServiceSOAP";

    public java.lang.String getSheaSimulatorServiceSOAPAddress() {
        return SheaSimulatorServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SheaSimulatorServiceSOAPWSDDServiceName = "SheaSimulatorServiceSOAP";

    public java.lang.String getSheaSimulatorServiceSOAPWSDDServiceName() {
        return SheaSimulatorServiceSOAPWSDDServiceName;
    }

    public void setSheaSimulatorServiceSOAPWSDDServiceName(java.lang.String name) {
        SheaSimulatorServiceSOAPWSDDServiceName = name;
    }

    public org.sercho.SheaSimulator.SheaSimulatorPT getSheaSimulatorServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SheaSimulatorServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSheaSimulatorServiceSOAP(endpoint);
    }

    public org.sercho.SheaSimulator.SheaSimulatorPT getSheaSimulatorServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sercho.SheaSimulator.SheaSimulatorSOAPStub _stub = new org.sercho.SheaSimulator.SheaSimulatorSOAPStub(portAddress, this);
            _stub.setPortName(getSheaSimulatorServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSheaSimulatorServiceSOAPEndpointAddress(java.lang.String address) {
        SheaSimulatorServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sercho.SheaSimulator.SheaSimulatorPT.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sercho.SheaSimulator.SheaSimulatorSOAPStub _stub = new org.sercho.SheaSimulator.SheaSimulatorSOAPStub(new java.net.URL(SheaSimulatorServiceSOAP_address), this);
                _stub.setPortName(getSheaSimulatorServiceSOAPWSDDServiceName());
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
        if ("SheaSimulatorServiceSOAP".equals(inputPortName)) {
            return getSheaSimulatorServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sercho.org/SheaSimulator/", "SheaSimulatorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sercho.org/SheaSimulator/", "SheaSimulatorServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SheaSimulatorServiceSOAP".equals(portName)) {
            setSheaSimulatorServiceSOAPEndpointAddress(address);
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
