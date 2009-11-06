/**
 * EGrainsServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.eGrains;

public class EGrainsServiceLocator extends org.apache.axis.client.Service implements org.sercho.eGrains.EGrainsService {

    public EGrainsServiceLocator() {
    }


    public EGrainsServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EGrainsServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for eGrainsServiceSOAP
    private java.lang.String eGrainsServiceSOAP_address = "http://localhost:8080/eGrainsWS/services/eGrainsServiceSOAP";

    public java.lang.String geteGrainsServiceSOAPAddress() {
        return eGrainsServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String eGrainsServiceSOAPWSDDServiceName = "eGrainsServiceSOAP";

    public java.lang.String geteGrainsServiceSOAPWSDDServiceName() {
        return eGrainsServiceSOAPWSDDServiceName;
    }

    public void seteGrainsServiceSOAPWSDDServiceName(java.lang.String name) {
        eGrainsServiceSOAPWSDDServiceName = name;
    }

    public org.sercho.eGrains.EGrainsPT geteGrainsServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(eGrainsServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return geteGrainsServiceSOAP(endpoint);
    }

    public org.sercho.eGrains.EGrainsPT geteGrainsServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sercho.eGrains.EGrainsServiceSOAPStub _stub = new org.sercho.eGrains.EGrainsServiceSOAPStub(portAddress, this);
            _stub.setPortName(geteGrainsServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void seteGrainsServiceSOAPEndpointAddress(java.lang.String address) {
        eGrainsServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sercho.eGrains.EGrainsPT.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sercho.eGrains.EGrainsServiceSOAPStub _stub = new org.sercho.eGrains.EGrainsServiceSOAPStub(new java.net.URL(eGrainsServiceSOAP_address), this);
                _stub.setPortName(geteGrainsServiceSOAPWSDDServiceName());
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
        if ("eGrainsServiceSOAP".equals(inputPortName)) {
            return geteGrainsServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sercho.org/eGrains/", "eGrainsService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sercho.org/eGrains/", "eGrainsServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("eGrainsServiceSOAP".equals(portName)) {
            seteGrainsServiceSOAPEndpointAddress(address);
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
