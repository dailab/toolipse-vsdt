package org.sercho.SheaSimulator;

public class SheaSimulatorPTProxy implements org.sercho.SheaSimulator.SheaSimulatorPT {
  private String _endpoint = null;
  private org.sercho.SheaSimulator.SheaSimulatorPT sheaSimulatorPT = null;
  
  public SheaSimulatorPTProxy() {
    _initSheaSimulatorPTProxy();
  }
  
  public SheaSimulatorPTProxy(String endpoint) {
    _endpoint = endpoint;
    _initSheaSimulatorPTProxy();
  }
  
  private void _initSheaSimulatorPTProxy() {
    try {
      sheaSimulatorPT = (new org.sercho.SheaSimulator.SheaSimulatorServiceLocator()).getSheaSimulatorServiceSOAP();
      if (sheaSimulatorPT != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sheaSimulatorPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sheaSimulatorPT)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sheaSimulatorPT != null)
      ((javax.xml.rpc.Stub)sheaSimulatorPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.sercho.SheaSimulator.SheaSimulatorPT getSheaSimulatorPT() {
    if (sheaSimulatorPT == null)
      _initSheaSimulatorPTProxy();
    return sheaSimulatorPT;
  }
  
  public java.lang.String startSimulator() throws java.rmi.RemoteException{
    if (sheaSimulatorPT == null)
      _initSheaSimulatorPTProxy();
    return sheaSimulatorPT.startSimulator();
  }
  
  public void getLocation(java.lang.String username, javax.xml.rpc.holders.StringHolder roomname, javax.xml.rpc.holders.FloatHolder posx, javax.xml.rpc.holders.FloatHolder posy, javax.xml.rpc.holders.FloatHolder posz, javax.xml.rpc.holders.StringHolder zones) throws java.rmi.RemoteException{
    if (sheaSimulatorPT == null)
      _initSheaSimulatorPTProxy();
    sheaSimulatorPT.getLocation(username, roomname, posx, posy, posz, zones);
  }
  
  public java.math.BigInteger isInZone(java.lang.String username, java.lang.String zone) throws java.rmi.RemoteException{
    if (sheaSimulatorPT == null)
      _initSheaSimulatorPTProxy();
    return sheaSimulatorPT.isInZone(username, zone);
  }
  
  
}