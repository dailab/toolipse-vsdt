package org.sercho.IvistarProxy;

public class IvistarProxyPTProxy implements org.sercho.IvistarProxy.IvistarProxyPT {
  private String _endpoint = null;
  private org.sercho.IvistarProxy.IvistarProxyPT ivistarProxyPT = null;
  
  public IvistarProxyPTProxy() {
    _initIvistarProxyPTProxy();
  }
  
  public IvistarProxyPTProxy(String endpoint) {
    _endpoint = endpoint;
    _initIvistarProxyPTProxy();
  }
  
  private void _initIvistarProxyPTProxy() {
    try {
      ivistarProxyPT = (new org.sercho.IvistarProxy.IvistarProxyServiceLocator()).getIvistarProxyServiceSOAP();
      if (ivistarProxyPT != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)ivistarProxyPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)ivistarProxyPT)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (ivistarProxyPT != null)
      ((javax.xml.rpc.Stub)ivistarProxyPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.sercho.IvistarProxy.IvistarProxyPT getIvistarProxyPT() {
    if (ivistarProxyPT == null)
      _initIvistarProxyPTProxy();
    return ivistarProxyPT;
  }
  
  public java.lang.String getRooms() throws java.rmi.RemoteException{
    if (ivistarProxyPT == null)
      _initIvistarProxyPTProxy();
    return ivistarProxyPT.getRooms();
  }
  
  public java.lang.String getLights(java.lang.String room) throws java.rmi.RemoteException{
    if (ivistarProxyPT == null)
      _initIvistarProxyPTProxy();
    return ivistarProxyPT.getLights(room);
  }
  
  public java.lang.String getShades(java.lang.String room) throws java.rmi.RemoteException{
    if (ivistarProxyPT == null)
      _initIvistarProxyPTProxy();
    return ivistarProxyPT.getShades(room);
  }
  
  public java.lang.String getValue(java.lang.String room, java.lang.String line) throws java.rmi.RemoteException{
    if (ivistarProxyPT == null)
      _initIvistarProxyPTProxy();
    return ivistarProxyPT.getValue(room, line);
  }
  
  public void setValue(java.lang.String room, java.lang.String line, java.lang.String value) throws java.rmi.RemoteException{
    if (ivistarProxyPT == null)
      _initIvistarProxyPTProxy();
    ivistarProxyPT.setValue(room, line, value);
  }
  
  
}