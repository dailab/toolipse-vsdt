/**
 * LightArousal_ParticipantServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.lightarousal.WSDL;

public class LightArousal_ParticipantServiceLocator extends org.apache.axis.client.Service implements org.sercho.lightarousal.WSDL.LightArousal_ParticipantService {

    public LightArousal_ParticipantServiceLocator() {
    }


    public LightArousal_ParticipantServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LightArousal_ParticipantServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LightArousal_ParticipantServicePort
    private java.lang.String LightArousal_ParticipantServicePort_address = "http://localhost:8080/active-bpel/services/LightAlarm_ParticipantService";

    public java.lang.String getLightArousal_ParticipantServicePortAddress() {
        return LightArousal_ParticipantServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LightArousal_ParticipantServicePortWSDDServiceName = "LightAlarm_ParticipantServicePort";

    public java.lang.String getLightArousal_ParticipantServicePortWSDDServiceName() {
        return LightArousal_ParticipantServicePortWSDDServiceName;
    }

    public void setLightArousal_ParticipantServicePortWSDDServiceName(java.lang.String name) {
        LightArousal_ParticipantServicePortWSDDServiceName = name;
    }

    public org.sercho.lightarousal.WSDL.LightArousalPT getLightArousal_ParticipantServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LightArousal_ParticipantServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLightArousal_ParticipantServicePort(endpoint);
    }

    public org.sercho.lightarousal.WSDL.LightArousalPT getLightArousal_ParticipantServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sercho.lightarousal.WSDL.LightArousal_ParticipantServiceBindingStub _stub = new org.sercho.lightarousal.WSDL.LightArousal_ParticipantServiceBindingStub(portAddress, this);
            _stub.setPortName(getLightArousal_ParticipantServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLightArousal_ParticipantServicePortEndpointAddress(java.lang.String address) {
        LightArousal_ParticipantServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sercho.lightarousal.WSDL.LightArousalPT.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sercho.lightarousal.WSDL.LightArousal_ParticipantServiceBindingStub _stub = new org.sercho.lightarousal.WSDL.LightArousal_ParticipantServiceBindingStub(new java.net.URL(LightArousal_ParticipantServicePort_address), this);
                _stub.setPortName(getLightArousal_ParticipantServicePortWSDDServiceName());
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
        if ("LightAlarm_ParticipantServicePort".equals(inputPortName)) {
            return getLightArousal_ParticipantServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://LightAlarm/WSDL/", "LightAlarm_ParticipantService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://LightAlarm/WSDL/", "LightAlarm_ParticipantServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LightAlarm_ParticipantServicePort".equals(portName)) {
            setLightArousal_ParticipantServicePortEndpointAddress(address);
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
