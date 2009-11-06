/**
 * EGrainsServiceSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.eGrains;

public class EGrainsServiceSOAPSkeleton implements org.sercho.eGrains.EGrainsPT, org.apache.axis.wsdl.Skeleton {
    private org.sercho.eGrains.EGrainsPT impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "value"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("connect", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/eGrains/", "connect"));
        _oper.setSoapAction("http://sercho.org/eGrains/connect");
        _myOperationsList.add(_oper);
        if (_myOperations.get("connect") == null) {
            _myOperations.put("connect", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("connect")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("disconnect", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/eGrains/", "disconnect"));
        _oper.setSoapAction("http://sercho.org/eGrains/disconnect");
        _myOperationsList.add(_oper);
        if (_myOperations.get("disconnect") == null) {
            _myOperations.put("disconnect", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("disconnect")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "value"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getTemperature", _params, new javax.xml.namespace.QName("", "value"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/eGrains/", "getTemperature"));
        _oper.setSoapAction("http://sercho.org/eGrains/getTemperature");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getTemperature") == null) {
            _myOperations.put("getTemperature", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getTemperature")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("getIDs", _params, new javax.xml.namespace.QName("", "value"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/eGrains/", "getIDs"));
        _oper.setSoapAction("http://sercho.org/eGrains/getIDs");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getIDs") == null) {
            _myOperations.put("getIDs", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getIDs")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "value"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("isRegistered", _params, new javax.xml.namespace.QName("", "value"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/eGrains/", "isRegistered"));
        _oper.setSoapAction("http://sercho.org/eGrains/isRegistered");
        _myOperationsList.add(_oper);
        if (_myOperations.get("isRegistered") == null) {
            _myOperations.put("isRegistered", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("isRegistered")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "value"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("isEnabled", _params, new javax.xml.namespace.QName("", "value"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/eGrains/", "isEnabled"));
        _oper.setSoapAction("http://sercho.org/eGrains/isEnabled");
        _myOperationsList.add(_oper);
        if (_myOperations.get("isEnabled") == null) {
            _myOperations.put("isEnabled", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("isEnabled")).add(_oper);
    }

    public EGrainsServiceSOAPSkeleton() {
        this.impl = new org.sercho.eGrains.EGrainsServiceSOAPImpl();
    }

    public EGrainsServiceSOAPSkeleton(org.sercho.eGrains.EGrainsPT impl) {
        this.impl = impl;
    }
    public void connect(java.lang.String value) throws java.rmi.RemoteException
    {
        impl.connect(value);
    }

    public void disconnect() throws java.rmi.RemoteException
    {
        impl.disconnect();
    }

    public float getTemperature(java.math.BigInteger value) throws java.rmi.RemoteException
    {
        float ret = impl.getTemperature(value);
        return ret;
    }

    public java.lang.String getIDs() throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getIDs();
        return ret;
    }

    public boolean isRegistered(java.math.BigInteger value) throws java.rmi.RemoteException
    {
        boolean ret = impl.isRegistered(value);
        return ret;
    }

    public boolean isEnabled(java.math.BigInteger value) throws java.rmi.RemoteException
    {
        boolean ret = impl.isEnabled(value);
        return ret;
    }

}
