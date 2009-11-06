/**
 * WeatherProxyServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.WeatherProxy;

public class WeatherProxyServiceLocator extends org.apache.axis.client.Service implements org.sercho.WeatherProxy.WeatherProxyService {

    public WeatherProxyServiceLocator() {
    }


    public WeatherProxyServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WeatherProxyServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WeatherProxyServiceSOAP
    private java.lang.String WeatherProxyServiceSOAP_address = "http://localhost:8080/WeatherProxy/services/WeatherProxyServiceSOAP";

    public java.lang.String getWeatherProxyServiceSOAPAddress() {
        return WeatherProxyServiceSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WeatherProxyServiceSOAPWSDDServiceName = "WeatherProxyServiceSOAP";

    public java.lang.String getWeatherProxyServiceSOAPWSDDServiceName() {
        return WeatherProxyServiceSOAPWSDDServiceName;
    }

    public void setWeatherProxyServiceSOAPWSDDServiceName(java.lang.String name) {
        WeatherProxyServiceSOAPWSDDServiceName = name;
    }

    public org.sercho.WeatherProxy.WeatherProxyPT getWeatherProxyServiceSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WeatherProxyServiceSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWeatherProxyServiceSOAP(endpoint);
    }

    public org.sercho.WeatherProxy.WeatherProxyPT getWeatherProxyServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.sercho.WeatherProxy.WeatherProxySOAPStub _stub = new org.sercho.WeatherProxy.WeatherProxySOAPStub(portAddress, this);
            _stub.setPortName(getWeatherProxyServiceSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWeatherProxyServiceSOAPEndpointAddress(java.lang.String address) {
        WeatherProxyServiceSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.sercho.WeatherProxy.WeatherProxyPT.class.isAssignableFrom(serviceEndpointInterface)) {
                org.sercho.WeatherProxy.WeatherProxySOAPStub _stub = new org.sercho.WeatherProxy.WeatherProxySOAPStub(new java.net.URL(WeatherProxyServiceSOAP_address), this);
                _stub.setPortName(getWeatherProxyServiceSOAPWSDDServiceName());
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
        if ("WeatherProxyServiceSOAP".equals(inputPortName)) {
            return getWeatherProxyServiceSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sercho.org/WeatherProxy/", "WeatherProxyService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sercho.org/WeatherProxy/", "WeatherProxyServiceSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WeatherProxyServiceSOAP".equals(portName)) {
            setWeatherProxyServiceSOAPEndpointAddress(address);
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
