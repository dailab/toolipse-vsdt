/**
 * UPnPRadioSOAPSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.UPnPRadio;

public class UPnPRadioSOAPSkeleton implements org.sercho.UPnPRadio.UPnPRadioPT, org.apache.axis.wsdl.Skeleton {
    private org.sercho.UPnPRadio.UPnPRadioPT impl;
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "url"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("setAVTransportURI", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/UPnPRadio/", "SetAVTransportURI"));
        _oper.setSoapAction("http://sercho.org/UPnPRadio/SetAVTransportURI");
        _myOperationsList.add(_oper);
        if (_myOperations.get("setAVTransportURI") == null) {
            _myOperations.put("setAVTransportURI", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("setAVTransportURI")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "volume"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("setVolume", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/UPnPRadio/", "SetVolume"));
        _oper.setSoapAction("http://sercho.org/UPnPRadio/SetVolume");
        _myOperationsList.add(_oper);
        if (_myOperations.get("setVolume") == null) {
            _myOperations.put("setVolume", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("setVolume")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("stop", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/UPnPRadio/", "Stop"));
        _oper.setSoapAction("http://sercho.org/UPnPRadio/Stop");
        _myOperationsList.add(_oper);
        if (_myOperations.get("stop") == null) {
            _myOperations.put("stop", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("stop")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "deviceID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("init", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/UPnPRadio/", "Init"));
        _oper.setSoapAction("http://sercho.org/UPnPRadio/Init");
        _myOperationsList.add(_oper);
        if (_myOperations.get("init") == null) {
            _myOperations.put("init", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("init")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "state"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"), java.math.BigInteger.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("playPause", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/UPnPRadio/", "PlayPause"));
        _oper.setSoapAction("http://sercho.org/UPnPRadio/PlayPause");
        _myOperationsList.add(_oper);
        if (_myOperations.get("playPause") == null) {
            _myOperations.put("playPause", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("playPause")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("play", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/UPnPRadio/", "Play"));
        _oper.setSoapAction("http://sercho.org/UPnPRadio/Play");
        _myOperationsList.add(_oper);
        if (_myOperations.get("play") == null) {
            _myOperations.put("play", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("play")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("pause", _params, null);
        _oper.setElementQName(new javax.xml.namespace.QName("http://sercho.org/UPnPRadio/", "Pause"));
        _oper.setSoapAction("http://sercho.org/UPnPRadio/Pause");
        _myOperationsList.add(_oper);
        if (_myOperations.get("pause") == null) {
            _myOperations.put("pause", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("pause")).add(_oper);
    }

    public UPnPRadioSOAPSkeleton() {
        this.impl = new org.sercho.UPnPRadio.UPnPRadioSOAPImpl();
    }

    public UPnPRadioSOAPSkeleton(org.sercho.UPnPRadio.UPnPRadioPT impl) {
        this.impl = impl;
    }
    public void setAVTransportURI(java.lang.String url) throws java.rmi.RemoteException
    {
        impl.setAVTransportURI(url);
    }

    public void setVolume(java.math.BigInteger volume) throws java.rmi.RemoteException
    {
        impl.setVolume(volume);
    }

    public void stop() throws java.rmi.RemoteException
    {
        impl.stop();
    }

    public void init(java.lang.String deviceID) throws java.rmi.RemoteException
    {
        impl.init(deviceID);
    }

    public void playPause(java.math.BigInteger state) throws java.rmi.RemoteException
    {
        impl.playPause(state);
    }

    public void play() throws java.rmi.RemoteException
    {
        impl.play();
    }

    public void pause() throws java.rmi.RemoteException
    {
        impl.pause();
    }

}
