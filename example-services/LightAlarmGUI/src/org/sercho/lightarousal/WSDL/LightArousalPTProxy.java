package org.sercho.lightarousal.WSDL;

public class LightArousalPTProxy implements org.sercho.lightarousal.WSDL.LightArousalPT {
  private String _endpoint = null;
  private org.sercho.lightarousal.WSDL.LightArousalPT lightArousalPT = null;
  
  public LightArousalPTProxy() {
    _initLightArousalPTProxy();
  }
  
  public LightArousalPTProxy(String endpoint) {
    _endpoint = endpoint;
    _initLightArousalPTProxy();
  }
  
  private void _initLightArousalPTProxy() {
    try {
      lightArousalPT = (new org.sercho.lightarousal.WSDL.LightArousal_ParticipantServiceLocator()).getLightArousal_ParticipantServicePort();
      if (lightArousalPT != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)lightArousalPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)lightArousalPT)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (lightArousalPT != null)
      ((javax.xml.rpc.Stub)lightArousalPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.sercho.lightarousal.WSDL.LightArousalPT getLightArousalPT() {
    if (lightArousalPT == null)
      _initLightArousalPTProxy();
    return lightArousalPT;
  }
  
  public void initProcess(java.lang.String paramUsername, java.lang.String paramWaketime, java.lang.String paramCity, java.lang.String paramCountry, java.lang.String paramRoomName, java.lang.String paramLightIDs, java.lang.String paramBlindsIDs, boolean paramUseLight, boolean paramUseMusic) throws java.rmi.RemoteException{
    if (lightArousalPT == null)
      _initLightArousalPTProxy();
    lightArousalPT.initProcess(paramUsername, paramWaketime, paramCity, paramCountry, paramRoomName, paramLightIDs, paramBlindsIDs, paramUseLight, paramUseMusic);
  }
  
  
}