/**
 * MailAndSMSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.MailAndSMS;

public class MailAndSMSServiceLocator extends org.apache.axis.client.Service implements org.sercho.MailAndSMS.MailAndSMSService {

    public MailAndSMSServiceLocator() {
    }


    public MailAndSMSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public MailAndSMSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for MailAndSMSServiceSOAP
    private java.lang.String MailAndSMSServiceSOAP_address = "http://localhost:8080/MailAndSmsWS/services/MailAndSMSServiceSOAP";

    public java.lang.String getMailAndSMSServiceSOAPAddress() {
        return MailAndSMSServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String MailAndSMSServiceSOAPWSDDServiceName = "MailAndSMSServiceSOAP";

    public java.lang.String getMailAndSMSServiceSOAPWSDDServiceName() {
        return MailAndSMSServiceSOAPWSDDServiceName;
    }

    public void setMailAndSMSServiceSOAPWSDDServiceName(java.lang.String name) {
        MailAndSMSServiceSOAPWSDDServiceName = name;
    }

    public org.sercho.MailAndSMS.MailAndSMSPT getMailAndSMSServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(MailAndSMSServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getMailAndSMSServiceSOAP(endpoint);
    }

    public org.sercho.MailAndSMS.MailAndSMSPT getMailAndSMSServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sercho.MailAndSMS.MailAndSMSSOAPStub _stub = new org.sercho.MailAndSMS.MailAndSMSSOAPStub(portAddress, this);
            _stub.setPortName(getMailAndSMSServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setMailAndSMSServiceSOAPEndpointAddress(java.lang.String address) {
        MailAndSMSServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sercho.MailAndSMS.MailAndSMSPT.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sercho.MailAndSMS.MailAndSMSSOAPStub _stub = new org.sercho.MailAndSMS.MailAndSMSSOAPStub(new java.net.URL(MailAndSMSServiceSOAP_address), this);
                _stub.setPortName(getMailAndSMSServiceSOAPWSDDServiceName());
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
        if ("MailAndSMSServiceSOAP".equals(inputPortName)) {
            return getMailAndSMSServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sercho.org/MailAndSMS/", "MailAndSMSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sercho.org/MailAndSMS/", "MailAndSMSServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("MailAndSMSServiceSOAP".equals(portName)) {
            setMailAndSMSServiceSOAPEndpointAddress(address);
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
