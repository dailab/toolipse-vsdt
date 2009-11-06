package de.dailab.jiactng.rsd.ws;

public class WSRichServiceDirectoryPortTypeProxy implements de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType {
  private String _endpoint = null;
  private de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType wSRichServiceDirectoryPortType = null;
  
  public WSRichServiceDirectoryPortTypeProxy() {
    _initWSRichServiceDirectoryPortTypeProxy();
  }
  
  public WSRichServiceDirectoryPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSRichServiceDirectoryPortTypeProxy();
  }
  
  private void _initWSRichServiceDirectoryPortTypeProxy() {
    try {
      wSRichServiceDirectoryPortType = (new de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryLocator()).getWSRichServiceDirectorySOAP11port_http();
      if (wSRichServiceDirectoryPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSRichServiceDirectoryPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSRichServiceDirectoryPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSRichServiceDirectoryPortType != null)
      ((javax.xml.rpc.Stub)wSRichServiceDirectoryPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortType getWSRichServiceDirectoryPortType() {
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType;
  }
  
  public java.lang.Boolean deregisterService(de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription description) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.deregisterService(description);
  }
  
  public java.lang.String[] findServiceByNameSimple(java.lang.String regex) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.findServiceByNameSimple(regex);
  }
  
  public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] findServiceByKeyword(java.lang.String[] keywords) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.findServiceByKeyword(keywords);
  }
  
  public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] getAllServices() throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.getAllServices();
  }
  
  public java.lang.String registerWebServiceAndKeywordsSimple(java.lang.String wsdlUrl, java.lang.String[] keywords) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.registerWebServiceAndKeywordsSimple(wsdlUrl, keywords);
  }
  
  public java.lang.Boolean updateService(de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription description) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.updateService(description);
  }
  
  public java.lang.Boolean deregisterServiceSimple(java.lang.String wsdlUrl) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.deregisterServiceSimple(wsdlUrl);
  }
  
  public java.lang.String[] findServiceByKeywordsSimple(java.lang.String[] keywords) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.findServiceByKeywordsSimple(keywords);
  }
  
  public java.lang.String updateWebServiceSimple(java.lang.String wsdlUrl, java.lang.String[] keywords) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.updateWebServiceSimple(wsdlUrl, keywords);
  }
  
  public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] registerWebService(java.lang.String wsdlUrl) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.registerWebService(wsdlUrl);
  }
  
  public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] findServiceByName(java.lang.String regex) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.findServiceByName(regex);
  }
  
  public de.dailab.jiactng.rsd.ws.xsd.Axis2ServiceDescription[] registerWebServiceAndKeywords(java.lang.String wsdlUrl, java.lang.String[] keywords) throws java.rmi.RemoteException{
    if (wSRichServiceDirectoryPortType == null)
      _initWSRichServiceDirectoryPortTypeProxy();
    return wSRichServiceDirectoryPortType.registerWebServiceAndKeywords(wsdlUrl, keywords);
  }
  
  
}