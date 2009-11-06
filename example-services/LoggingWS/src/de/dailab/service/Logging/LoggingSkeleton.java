/**
 * LoggingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package de.dailab.service.Logging;

public class LoggingSkeleton implements de.dailab.service.Logging.LoggingPT, org.apache.axis.wsdl.Skeleton {
    private de.dailab.service.Logging.LoggingPT impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "message"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "level"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("log", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://service.dailab.de/Logging/", "log"));
        _oper.setSoapAction("http://service.dailab.de/Logging/log");
        _myOperationsList.add(_oper);
        if (_myOperations.get("log") == null) {
            _myOperations.put("log", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("log")).add(_oper);
    }

    public LoggingSkeleton() {
        this.impl = new de.dailab.service.Logging.LoggingImpl();
    }

    public LoggingSkeleton(de.dailab.service.Logging.LoggingPT impl) {
        this.impl = impl;
    }
    public void log(java.lang.String message, java.math.BigInteger level) throws java.rmi.RemoteException
    {
        impl.log(message, level);
    }

}
