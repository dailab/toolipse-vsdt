/**
 * MailAndSMSSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.MailAndSMS;

public class MailAndSMSSOAPSkeleton implements org.sercho.MailAndSMS.MailAndSMSPT, org.apache.axis.wsdl.Skeleton {
    private org.sercho.MailAndSMS.MailAndSMSPT impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "to"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "text"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("sendMail", _params, new javax.xml.namespace.QName("", "result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/MailAndSMS/", "SendMail"));
        _oper.setSoapAction("http://sercho.org/MailAndSMS/SendMail");
        _myOperationsList.add(_oper);
        if (_myOperations.get("sendMail") == null) {
            _myOperations.put("sendMail", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("sendMail")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "to"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "text"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("sendSMS", _params, new javax.xml.namespace.QName("", "result"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/MailAndSMS/", "SendSMS"));
        _oper.setSoapAction("http://sercho.org/MailAndSMS/SendSMS");
        _myOperationsList.add(_oper);
        if (_myOperations.get("sendSMS") == null) {
            _myOperations.put("sendSMS", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("sendSMS")).add(_oper);
    }

    public MailAndSMSSOAPSkeleton() {
        this.impl = new org.sercho.MailAndSMS.MailAndSMSSOAPImpl();
    }

    public MailAndSMSSOAPSkeleton(org.sercho.MailAndSMS.MailAndSMSPT impl) {
        this.impl = impl;
    }
    public boolean sendMail(java.lang.String to, java.lang.String text) throws java.rmi.RemoteException
    {
        boolean ret = impl.sendMail(to, text);
        return ret;
    }

    public boolean sendSMS(java.lang.String to, java.lang.String text) throws java.rmi.RemoteException
    {
        boolean ret = impl.sendSMS(to, text);
        return ret;
    }

}
