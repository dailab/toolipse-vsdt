/**
 * LightAlarm_ParticipantServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package LightAlarm.WSDL;

public class LightAlarm_ParticipantServiceLocator extends org.apache.axis.client.Service implements LightAlarm.WSDL.LightAlarm_ParticipantService {

    public LightAlarm_ParticipantServiceLocator() {
    }


    public LightAlarm_ParticipantServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LightAlarm_ParticipantServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LightAlarm_ParticipantServicePort
    private java.lang.String LightAlarm_ParticipantServicePort_address = "http://localhost:8080/active-bpel/services/LightAlarm_ParticipantService";

    public java.lang.String getLightAlarm_ParticipantServicePortAddress() {
        return LightAlarm_ParticipantServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LightAlarm_ParticipantServicePortWSDDServiceName = "LightAlarm_ParticipantServicePort";

    public java.lang.String getLightAlarm_ParticipantServicePortWSDDServiceName() {
        return LightAlarm_ParticipantServicePortWSDDServiceName;
    }

    public void setLightAlarm_ParticipantServicePortWSDDServiceName(java.lang.String name) {
        LightAlarm_ParticipantServicePortWSDDServiceName = name;
    }

    public LightAlarm.WSDL.LightAlarmPT getLightAlarm_ParticipantServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LightAlarm_ParticipantServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLightAlarm_ParticipantServicePort(endpoint);
    }

    public LightAlarm.WSDL.LightAlarmPT getLightAlarm_ParticipantServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            LightAlarm.WSDL.LightAlarm_ParticipantServiceBindingStub _stub = new LightAlarm.WSDL.LightAlarm_ParticipantServiceBindingStub(portAddress, this);
            _stub.setPortName(getLightAlarm_ParticipantServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLightAlarm_ParticipantServicePortEndpointAddress(java.lang.String address) {
        LightAlarm_ParticipantServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (LightAlarm.WSDL.LightAlarmPT.class.isAssignableFrom(serviceEndpointInterface)) {
                LightAlarm.WSDL.LightAlarm_ParticipantServiceBindingStub _stub = new LightAlarm.WSDL.LightAlarm_ParticipantServiceBindingStub(new java.net.URL(LightAlarm_ParticipantServicePort_address), this);
                _stub.setPortName(getLightAlarm_ParticipantServicePortWSDDServiceName());
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
            return getLightAlarm_ParticipantServicePort();
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
            setLightAlarm_ParticipantServicePortEndpointAddress(address);
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
