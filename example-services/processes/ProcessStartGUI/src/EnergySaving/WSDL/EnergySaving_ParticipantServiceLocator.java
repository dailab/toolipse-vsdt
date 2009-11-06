/**
 * EnergySaving_ParticipantServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package EnergySaving.WSDL;

public class EnergySaving_ParticipantServiceLocator extends org.apache.axis.client.Service implements EnergySaving.WSDL.EnergySaving_ParticipantService {

    public EnergySaving_ParticipantServiceLocator() {
    }


    public EnergySaving_ParticipantServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EnergySaving_ParticipantServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EnergySaving_ParticipantServicePort
    private java.lang.String EnergySaving_ParticipantServicePort_address = "http://localhost:8080/active-bpel/services/EnergySaving_ParticipantService";

    public java.lang.String getEnergySaving_ParticipantServicePortAddress() {
        return EnergySaving_ParticipantServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EnergySaving_ParticipantServicePortWSDDServiceName = "EnergySaving_ParticipantServicePort";

    public java.lang.String getEnergySaving_ParticipantServicePortWSDDServiceName() {
        return EnergySaving_ParticipantServicePortWSDDServiceName;
    }

    public void setEnergySaving_ParticipantServicePortWSDDServiceName(java.lang.String name) {
        EnergySaving_ParticipantServicePortWSDDServiceName = name;
    }

    public EnergySaving.WSDL.EnergySavingPT getEnergySaving_ParticipantServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EnergySaving_ParticipantServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEnergySaving_ParticipantServicePort(endpoint);
    }

    public EnergySaving.WSDL.EnergySavingPT getEnergySaving_ParticipantServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            EnergySaving.WSDL.EnergySaving_ParticipantServiceBindingStub _stub = new EnergySaving.WSDL.EnergySaving_ParticipantServiceBindingStub(portAddress, this);
            _stub.setPortName(getEnergySaving_ParticipantServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEnergySaving_ParticipantServicePortEndpointAddress(java.lang.String address) {
        EnergySaving_ParticipantServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (EnergySaving.WSDL.EnergySavingPT.class.isAssignableFrom(serviceEndpointInterface)) {
                EnergySaving.WSDL.EnergySaving_ParticipantServiceBindingStub _stub = new EnergySaving.WSDL.EnergySaving_ParticipantServiceBindingStub(new java.net.URL(EnergySaving_ParticipantServicePort_address), this);
                _stub.setPortName(getEnergySaving_ParticipantServicePortWSDDServiceName());
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
        if ("EnergySaving_ParticipantServicePort".equals(inputPortName)) {
            return getEnergySaving_ParticipantServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://EnergySaving/WSDL/", "EnergySaving_ParticipantService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://EnergySaving/WSDL/", "EnergySaving_ParticipantServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EnergySaving_ParticipantServicePort".equals(portName)) {
            setEnergySaving_ParticipantServicePortEndpointAddress(address);
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
