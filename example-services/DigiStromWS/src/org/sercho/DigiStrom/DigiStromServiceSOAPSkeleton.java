/**
 * DigiStromServiceSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.DigiStrom;

public class DigiStromServiceSOAPSkeleton implements org.sercho.DigiStrom.DigiStromPT, org.apache.axis.wsdl.Skeleton {
	private static final long serialVersionUID = 1L;
	private org.sercho.DigiStrom.DigiStromPT impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ip"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "id"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "state"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("setState", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/DigiStrom/", "setState"));
        _oper.setSoapAction("http://sercho.org/DigiStrom/setState");
        _myOperationsList.add(_oper);
        if (_myOperations.get("setState") == null) {
            _myOperations.put("setState", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("setState")).add(_oper);
    }

    public DigiStromServiceSOAPSkeleton() {
        this.impl = new org.sercho.DigiStrom.DigiStromServiceSOAPImpl();
    }

    public DigiStromServiceSOAPSkeleton(org.sercho.DigiStrom.DigiStromPT impl) {
        this.impl = impl;
    }
    public void setState(java.lang.String ip, java.math.BigInteger id, java.math.BigInteger state) throws java.rmi.RemoteException
    {
        impl.setState(ip, id, state);
    }

}
