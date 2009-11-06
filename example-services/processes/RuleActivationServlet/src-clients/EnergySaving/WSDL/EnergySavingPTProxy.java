package EnergySaving.WSDL;

public class EnergySavingPTProxy implements EnergySaving.WSDL.EnergySavingPT {
  private String _endpoint = null;
  private EnergySaving.WSDL.EnergySavingPT energySavingPT = null;
  
  public EnergySavingPTProxy() {
    _initEnergySavingPTProxy();
  }
  
  public EnergySavingPTProxy(String endpoint) {
    _endpoint = endpoint;
    _initEnergySavingPTProxy();
  }
  
  private void _initEnergySavingPTProxy() {
    try {
      energySavingPT = (new EnergySaving.WSDL.EnergySaving_ParticipantServiceLocator()).getEnergySaving_ParticipantServicePort();
      if (energySavingPT != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)energySavingPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)energySavingPT)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (energySavingPT != null)
      ((javax.xml.rpc.Stub)energySavingPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public EnergySaving.WSDL.EnergySavingPT getEnergySavingPT() {
    if (energySavingPT == null)
      _initEnergySavingPTProxy();
    return energySavingPT;
  }
  
  public void start(java.lang.String paramUserName, java.math.BigInteger paramDelaySec, java.lang.String paramZone, java.lang.String paramLightLine, java.lang.String paramRoom) throws java.rmi.RemoteException{
    if (energySavingPT == null)
      _initEnergySavingPTProxy();
    energySavingPT.start(paramUserName, paramDelaySec, paramZone, paramLightLine, paramRoom);
  }
  
  public void stop() throws java.rmi.RemoteException{
    if (energySavingPT == null)
      _initEnergySavingPTProxy();
    energySavingPT.stop();
  }
  
  
}