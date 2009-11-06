/**
 * WSRichServiceDirectoryLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.dailab.jiactng.rsd.ws;

public class WSRichServiceDirectoryLocator extends org.apache.axis.client.Service implements de.dailab.jiactng.rsd.ws.WSRichServiceDirectory {

	private static final long serialVersionUID = -2332943788435566946L;

	public WSRichServiceDirectoryLocator() {
    }


    public WSRichServiceDirectoryLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSRichServiceDirectoryLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSRichServiceDirectorySOAP11port_http
    private java.lang.String WSRichServiceDirectorySOAP11port_http_address = "http://localhost:90/axis2/services/WSRichServiceDirectory";

    public java.lang.String getWSRichServiceDirectorySOAP11port_httpAddress() {
        return WSRichServiceDirectorySOAP11port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSRichServiceDirectorySOAP11port_httpWSDDServiceName = "WSRichServiceDirectorySOAP11port_http";

    public java.lang.String getWSRichServiceDirectorySOAP11port_httpWSDDServiceName() {
        return WSRichServiceDirectorySOAP11port_httpWSDDServiceName;
    }

    public void setWSRichServiceDirectorySOAP11port_httpWSDDServiceName(java.lang.String name) {
        WSRichServiceDirectorySOAP11port_httpWSDDServiceName = name;
    }

    public de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType getWSRichServiceDirectorySOAP11port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSRichServiceDirectorySOAP11port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSRichServiceDirectorySOAP11port_http(endpoint);
    }

    public de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType getWSRichServiceDirectorySOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            de.dailab.jiactng.rsd.ws.WSRichServiceDirectorySOAP11BindingStub _stub = new de.dailab.jiactng.rsd.ws.WSRichServiceDirectorySOAP11BindingStub(portAddress, this);
            _stub.setPortName(getWSRichServiceDirectorySOAP11port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSRichServiceDirectorySOAP11port_httpEndpointAddress(java.lang.String address) {
        WSRichServiceDirectorySOAP11port_http_address = address;
    }


    // Use to get a proxy class for WSRichServiceDirectorySOAP12port_http
    private java.lang.String WSRichServiceDirectorySOAP12port_http_address = "http://localhost:90/axis2/services/WSRichServiceDirectory";

    public java.lang.String getWSRichServiceDirectorySOAP12port_httpAddress() {
        return WSRichServiceDirectorySOAP12port_http_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSRichServiceDirectorySOAP12port_httpWSDDServiceName = "WSRichServiceDirectorySOAP12port_http";

    public java.lang.String getWSRichServiceDirectorySOAP12port_httpWSDDServiceName() {
        return WSRichServiceDirectorySOAP12port_httpWSDDServiceName;
    }

    public void setWSRichServiceDirectorySOAP12port_httpWSDDServiceName(java.lang.String name) {
        WSRichServiceDirectorySOAP12port_httpWSDDServiceName = name;
    }

    public de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType getWSRichServiceDirectorySOAP12port_http() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSRichServiceDirectorySOAP12port_http_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSRichServiceDirectorySOAP12port_http(endpoint);
    }

    public de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType getWSRichServiceDirectorySOAP12port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            de.dailab.jiactng.rsd.ws.WSRichServiceDirectorySOAP12BindingStub _stub = new de.dailab.jiactng.rsd.ws.WSRichServiceDirectorySOAP12BindingStub(portAddress, this);
            _stub.setPortName(getWSRichServiceDirectorySOAP12port_httpWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSRichServiceDirectorySOAP12port_httpEndpointAddress(java.lang.String address) {
        WSRichServiceDirectorySOAP12port_http_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                de.dailab.jiactng.rsd.ws.WSRichServiceDirectorySOAP11BindingStub _stub = new de.dailab.jiactng.rsd.ws.WSRichServiceDirectorySOAP11BindingStub(new java.net.URL(WSRichServiceDirectorySOAP11port_http_address), this);
                _stub.setPortName(getWSRichServiceDirectorySOAP11port_httpWSDDServiceName());
                return _stub;
            }
            if (de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                de.dailab.jiactng.rsd.ws.WSRichServiceDirectorySOAP12BindingStub _stub = new de.dailab.jiactng.rsd.ws.WSRichServiceDirectorySOAP12BindingStub(new java.net.URL(WSRichServiceDirectorySOAP12port_http_address), this);
                _stub.setPortName(getWSRichServiceDirectorySOAP12port_httpWSDDServiceName());
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
        if ("WSRichServiceDirectorySOAP11port_http".equals(inputPortName)) {
            return getWSRichServiceDirectorySOAP11port_http();
        }
        else if ("WSRichServiceDirectorySOAP12port_http".equals(inputPortName)) {
            return getWSRichServiceDirectorySOAP12port_http();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de", "WSRichServiceDirectory");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de", "WSRichServiceDirectorySOAP11port_http"));
            ports.add(new javax.xml.namespace.QName("http://ws.rsd.jiactng.dailab.de", "WSRichServiceDirectorySOAP12port_http"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSRichServiceDirectorySOAP11port_http".equals(portName)) {
            setWSRichServiceDirectorySOAP11port_httpEndpointAddress(address);
        }
        else 
if ("WSRichServiceDirectorySOAP12port_http".equals(portName)) {
            setWSRichServiceDirectorySOAP12port_httpEndpointAddress(address);
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
