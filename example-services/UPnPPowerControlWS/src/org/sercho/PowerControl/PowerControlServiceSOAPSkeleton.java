/**
 * PowerControlServiceSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.PowerControl;

public class PowerControlServiceSOAPSkeleton implements org.sercho.PowerControl.PowerControlPT, org.apache.axis.wsdl.Skeleton {
    private org.sercho.PowerControl.PowerControlPT impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "deviceName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "onOff"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("switchOnOff", _params, new javax.xml.namespace.QName("", "state"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/PowerControl/", "switchOnOff"));
        _oper.setSoapAction("http://sercho.org/PowerControl/switchOnOff");
        _myOperationsList.add(_oper);
        if (_myOperations.get("switchOnOff") == null) {
            _myOperations.put("switchOnOff", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("switchOnOff")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "deviceName"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getState", _params, new javax.xml.namespace.QName("", "state"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/PowerControl/", "getState"));
        _oper.setSoapAction("http://sercho.org/PowerControl/getState");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getState") == null) {
            _myOperations.put("getState", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getState")).add(_oper);
    }

    public PowerControlServiceSOAPSkeleton() {
        this.impl = new org.sercho.PowerControl.PowerControlServiceSOAPImpl();
    }

    public PowerControlServiceSOAPSkeleton(org.sercho.PowerControl.PowerControlPT impl) {
        this.impl = impl;
    }
    public java.math.BigInteger switchOnOff(java.lang.String deviceName, java.math.BigInteger onOff) throws java.rmi.RemoteException
    {
        java.math.BigInteger ret = impl.switchOnOff(deviceName, onOff);
        return ret;
    }

    public java.math.BigInteger getState(java.lang.String deviceName) throws java.rmi.RemoteException
    {
        java.math.BigInteger ret = impl.getState(deviceName);
        return ret;
    }

}
