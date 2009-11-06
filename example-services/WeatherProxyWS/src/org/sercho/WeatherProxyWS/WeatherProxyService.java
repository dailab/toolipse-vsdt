/**
 * WeatherProxyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.WeatherProxyWS;

public interface WeatherProxyService extends javax.xml.rpc.Service {
    public java.lang.String getWeatherProxyServiceSOAPAddress();

    public org.sercho.WeatherProxyWS.WeatherProxyPT getWeatherProxyServiceSOAP() throws javax.xml.rpc.ServiceException;

    public org.sercho.WeatherProxyWS.WeatherProxyPT getWeatherProxyServiceSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
