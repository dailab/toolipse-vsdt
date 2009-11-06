package LightAlarm.WSDL;

public class LightAlarmPTProxy implements LightAlarm.WSDL.LightAlarmPT {
  private String _endpoint = null;
  private LightAlarm.WSDL.LightAlarmPT lightAlarmPT = null;
  
  public LightAlarmPTProxy() {
    _initLightAlarmPTProxy();
  }
  
  public LightAlarmPTProxy(String endpoint) {
    _endpoint = endpoint;
    _initLightAlarmPTProxy();
  }
  
  private void _initLightAlarmPTProxy() {
    try {
      lightAlarmPT = (new LightAlarm.WSDL.LightAlarm_ParticipantServiceLocator()).getLightAlarm_ParticipantServicePort();
      if (lightAlarmPT != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)lightAlarmPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)lightAlarmPT)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (lightAlarmPT != null)
      ((javax.xml.rpc.Stub)lightAlarmPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public LightAlarm.WSDL.LightAlarmPT getLightAlarmPT() {
    if (lightAlarmPT == null)
      _initLightAlarmPTProxy();
    return lightAlarmPT;
  }
  
  public void initProcess(java.lang.String paramUsername, java.lang.String paramWaketime, java.lang.String paramCity, java.lang.String paramCountry, java.lang.String paramRoomName, java.lang.String paramLightIDs, java.lang.String paramBlindsIDs, boolean paramUseLight, boolean paramUseMusic) throws java.rmi.RemoteException{
    if (lightAlarmPT == null)
      _initLightAlarmPTProxy();
    lightAlarmPT.initProcess(paramUsername, paramWaketime, paramCity, paramCountry, paramRoomName, paramLightIDs, paramBlindsIDs, paramUseLight, paramUseMusic);
  }
  
  
}