/**
 * IvistarProxySOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.IvistarProxy;

public class IvistarProxySOAPSkeleton implements org.sercho.IvistarProxy.IvistarProxyPT, org.apache.axis.wsdl.Skeleton {
    private org.sercho.IvistarProxy.IvistarProxyPT impl;
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
        };
        _oper = new org.apache.axis.description.OperationDesc("getRooms", _params, new javax.xml.namespace.QName("", "rooms"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/Ivistar/", "GetRooms"));
        _oper.setSoapAction("http://sercho.org/Ivistar/GetRooms");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getRooms") == null) {
            _myOperations.put("getRooms", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getRooms")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "room"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getLights", _params, new javax.xml.namespace.QName("", "lights"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/Ivistar/", "GetLights"));
        _oper.setSoapAction("http://sercho.org/Ivistar/GetLights");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getLights") == null) {
            _myOperations.put("getLights", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getLights")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "room"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getShades", _params, new javax.xml.namespace.QName("", "shades"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/Ivistar/", "GetShades"));
        _oper.setSoapAction("http://sercho.org/Ivistar/GetShades");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getShades") == null) {
            _myOperations.put("getShades", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getShades")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "room"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "line"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getValue", _params, new javax.xml.namespace.QName("", "value"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/Ivistar/", "GetValue"));
        _oper.setSoapAction("http://sercho.org/Ivistar/GetValue");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getValue") == null) {
            _myOperations.put("getValue", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getValue")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "room"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "line"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "value"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("setValue", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/Ivistar/", "SetValue"));
        _oper.setSoapAction("http://sercho.org/Ivistar/SetValue");
        _myOperationsList.add(_oper);
        if (_myOperations.get("setValue") == null) {
            _myOperations.put("setValue", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("setValue")).add(_oper);
    }

    public IvistarProxySOAPSkeleton() {
        this.impl = new org.sercho.IvistarProxy.IvistarProxySOAPImpl();
    }

    public IvistarProxySOAPSkeleton(org.sercho.IvistarProxy.IvistarProxyPT impl) {
        this.impl = impl;
    }
    public java.lang.String getRooms() throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getRooms();
        return ret;
    }

    public java.lang.String getLights(java.lang.String room) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getLights(room);
        return ret;
    }

    public java.lang.String getShades(java.lang.String room) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getShades(room);
        return ret;
    }

    public java.lang.String getValue(java.lang.String room, java.lang.String line) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getValue(room, line);
        return ret;
    }

    public void setValue(java.lang.String room, java.lang.String line, java.lang.String value) throws java.rmi.RemoteException
    {
        impl.setValue(room, line, value);
    }

}
