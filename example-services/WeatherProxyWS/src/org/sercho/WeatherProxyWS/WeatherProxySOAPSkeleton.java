/**
 * WeatherProxySOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.WeatherProxyWS;

public class WeatherProxySOAPSkeleton implements org.sercho.WeatherProxyWS.WeatherProxyPT, org.apache.axis.wsdl.Skeleton {
    private org.sercho.WeatherProxyWS.WeatherProxyPT impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "city"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "country"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getWeather", _params, new javax.xml.namespace.QName("", "weatherdata"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/WeatherProxyWS/", "GetWeather"));
        _oper.setSoapAction("http://sercho.org/WeatherProxyWS/GetWeather");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getWeather") == null) {
            _myOperations.put("getWeather", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getWeather")).add(_oper);
    }

    public WeatherProxySOAPSkeleton() {
        this.impl = new org.sercho.WeatherProxyWS.WeatherProxySOAPImpl();
    }

    public WeatherProxySOAPSkeleton(org.sercho.WeatherProxyWS.WeatherProxyPT impl) {
        this.impl = impl;
    }
    public java.lang.String getWeather(java.lang.String city, java.lang.String country) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getWeather(city, country);
        return ret;
    }

}
