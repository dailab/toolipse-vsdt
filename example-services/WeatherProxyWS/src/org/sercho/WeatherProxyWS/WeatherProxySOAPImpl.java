/**
 * WeatherProxySOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.WeatherProxyWS;

import java.rmi.RemoteException;

import NET.webserviceX.www.GlobalWeatherSoapProxy;

public class WeatherProxySOAPImpl implements WeatherProxyPT{
	
	protected static GlobalWeatherSoapProxy proxy= new GlobalWeatherSoapProxy(null);
	
	@Override
    public java.lang.String getWeather(String city, String country) throws RemoteException {
		System.out.println("Invoking getWeather for "+city+", "+country+"...");
		String ret= proxy.getWeather(city, country);
		System.out.println(ret);
    	return ret;
    }

}
