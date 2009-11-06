package org.sercho.WeatherProxyWS;

public class WeatherProxyPTProxy implements org.sercho.WeatherProxyWS.WeatherProxyPT {
  private String _endpoint = null;
  private org.sercho.WeatherProxyWS.WeatherProxyPT weatherProxyPT = null;
  
  public WeatherProxyPTProxy() {
    _initWeatherProxyPTProxy();
  }
  
  public WeatherProxyPTProxy(String endpoint) {
    _endpoint = endpoint;
    _initWeatherProxyPTProxy();
  }
  
  private void _initWeatherProxyPTProxy() {
    try {
      weatherProxyPT = (new org.sercho.WeatherProxyWS.WeatherProxyServiceLocator()).getWeatherProxyServiceSOAP();
      if (weatherProxyPT != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)weatherProxyPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)weatherProxyPT)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (weatherProxyPT != null)
      ((javax.xml.rpc.Stub)weatherProxyPT)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.sercho.WeatherProxyWS.WeatherProxyPT getWeatherProxyPT() {
    if (weatherProxyPT == null)
      _initWeatherProxyPTProxy();
    return weatherProxyPT;
  }
  
  public java.lang.String getWeather(java.lang.String city, java.lang.String country) throws java.rmi.RemoteException{
    if (weatherProxyPT == null)
      _initWeatherProxyPTProxy();
    return weatherProxyPT.getWeather(city, country);
  }
  
  
}