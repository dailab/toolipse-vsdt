/**
 * SheaSimulatorSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.SheaSimulator;

public class SheaSimulatorSOAPSkeleton implements org.sercho.SheaSimulator.SheaSimulatorPT, org.apache.axis.wsdl.Skeleton {
    private org.sercho.SheaSimulator.SheaSimulatorPT impl;
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
        _oper = new org.apache.axis.description.OperationDesc("startSimulator", _params, new javax.xml.namespace.QName("", "message"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/SheaSimulator/", "StartSimulator"));
        _oper.setSoapAction("http://sercho.org/SheaSimulator/StartSimulator");
        _myOperationsList.add(_oper);
        if (_myOperations.get("startSimulator") == null) {
            _myOperations.put("startSimulator", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("startSimulator")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "roomname"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "posx"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), float.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "posy"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), float.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "posz"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), float.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "zones"), org.apache.axis.description.ParameterDesc.OUT, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getLocation", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/SheaSimulator/", "GetLocation"));
        _oper.setSoapAction("http://sercho.org/SheaSimulator/GetLocation");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getLocation") == null) {
            _myOperations.put("getLocation", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getLocation")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "username"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "zone"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("isInZone", _params, new javax.xml.namespace.QName("", "isin"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/SheaSimulator/", "IsInZone"));
        _oper.setSoapAction("http://sercho.org/SheaSimulator/IsInZone");
        _myOperationsList.add(_oper);
        if (_myOperations.get("isInZone") == null) {
            _myOperations.put("isInZone", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("isInZone")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getLight", _params, new javax.xml.namespace.QName("", "state"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/SheaSimulator/", "GetLight"));
        _oper.setSoapAction("http://sercho.org/SheaSimulator/GetLight");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getLight") == null) {
            _myOperations.put("getLight", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getLight")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "state"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("setLight", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/SheaSimulator/", "SetLight"));
        _oper.setSoapAction("http://sercho.org/SheaSimulator/SetLight");
        _myOperationsList.add(_oper);
        if (_myOperations.get("setLight") == null) {
            _myOperations.put("setLight", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("setLight")).add(_oper);
    }

    public SheaSimulatorSOAPSkeleton() {
        this.impl = new org.sercho.SheaSimulator.SheaSimulatorSOAPImpl();
    }

    public SheaSimulatorSOAPSkeleton(org.sercho.SheaSimulator.SheaSimulatorPT impl) {
        this.impl = impl;
    }
    public java.lang.String startSimulator() throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.startSimulator();
        return ret;
    }

    public void getLocation(java.lang.String username, javax.xml.rpc.holders.StringHolder roomname, javax.xml.rpc.holders.FloatHolder posx, javax.xml.rpc.holders.FloatHolder posy, javax.xml.rpc.holders.FloatHolder posz, javax.xml.rpc.holders.StringHolder zones) throws java.rmi.RemoteException
    {
        impl.getLocation(username, roomname, posx, posy, posz, zones);
    }

    public java.math.BigInteger isInZone(java.lang.String username, java.lang.String zone) throws java.rmi.RemoteException
    {
        java.math.BigInteger ret = impl.isInZone(username, zone);
        return ret;
    }

    public java.math.BigInteger getLight(java.lang.String id) throws java.rmi.RemoteException
    {
        java.math.BigInteger ret = impl.getLight(id);
        return ret;
    }

    public void setLight(java.lang.String id, java.math.BigInteger state) throws java.rmi.RemoteException
    {
        impl.setLight(id, state);
    }

}
