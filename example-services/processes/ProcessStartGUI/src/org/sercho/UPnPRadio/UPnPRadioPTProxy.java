package org.sercho.UPnPRadio;

public class UPnPRadioPTProxy implements org.sercho.UPnPRadio.UPnPRadioPT {
  private String _endpoint = null;
  private org.sercho.UPnPRadio.UPnPRadioPT uPnPRadioPT = null;
  
  public UPnPRadioPTProxy() {
    _initUPnPRadioPTProxy();
  }
  
  public UPnPRadioPTProxy(String endpoint) {
    _endpoint = endpoint;
    _initUPnPRadioPTProxy();
  }
  
  private void _initUPnPRadioPTProxy() {
    try {
      uPnPRadioPT = (new org.sercho.UPnPRadio.UPnPRadioServiceLocator()).getUPnPRadioServiceSOAP();
      if (uPnPRadioPT != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)uPnPRadioPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)uPnPRadioPT)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (uPnPRadioPT != null)
      ((javax.xml.rpc.Stub)uPnPRadioPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.sercho.UPnPRadio.UPnPRadioPT getUPnPRadioPT() {
    if (uPnPRadioPT == null)
      _initUPnPRadioPTProxy();
    return uPnPRadioPT;
  }
  
  public void init(java.lang.String deviceID) throws java.rmi.RemoteException{
    if (uPnPRadioPT == null)
      _initUPnPRadioPTProxy();
    uPnPRadioPT.init(deviceID);
  }
  
  public void setAVTransportURI(java.lang.String url) throws java.rmi.RemoteException{
    if (uPnPRadioPT == null)
      _initUPnPRadioPTProxy();
    uPnPRadioPT.setAVTransportURI(url);
  }
  
  public void playPause(java.math.BigInteger state) throws java.rmi.RemoteException{
    if (uPnPRadioPT == null)
      _initUPnPRadioPTProxy();
    uPnPRadioPT.playPause(state);
  }
  
  public void play() throws java.rmi.RemoteException{
    if (uPnPRadioPT == null)
      _initUPnPRadioPTProxy();
    uPnPRadioPT.play();
  }
  
  public void pause() throws java.rmi.RemoteException{
    if (uPnPRadioPT == null)
      _initUPnPRadioPTProxy();
    uPnPRadioPT.pause();
  }
  
  public void stop() throws java.rmi.RemoteException{
    if (uPnPRadioPT == null)
      _initUPnPRadioPTProxy();
    uPnPRadioPT.stop();
  }
  
  public void setVolume(java.math.BigInteger volume) throws java.rmi.RemoteException{
    if (uPnPRadioPT == null)
      _initUPnPRadioPTProxy();
    uPnPRadioPT.setVolume(volume);
  }
  
  
}