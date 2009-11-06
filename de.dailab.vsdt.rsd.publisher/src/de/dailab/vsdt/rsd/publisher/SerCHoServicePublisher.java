package de.dailab.vsdt.rsd.publisher;

import java.io.FileInputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import de.dailab.jiactng.rsd.ws.WSRichServiceDirectoryPortTypeProxy;

public class SerCHoServicePublisher {
	
	private static WSRichServiceDirectoryPortTypeProxy proxy= null;
	
	public static void main(String[] args) {
		try {
			if (args.length == 0) {
				proxy= new WSRichServiceDirectoryPortTypeProxy();
			} else {
				proxy= new WSRichServiceDirectoryPortTypeProxy(args[0]);
			}
			List<String> services= loadFromPropertiesFile("webservices.properties");
			publishTestServices(services);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public static void publishTestServices(List<String> services) throws RemoteException {
		System.out.println("Publishing SerCHo Test Services to the RSD");
		for (String url : services) {
			System.out.println("publishing " + url + " ...");
			proxy.registerWebService(url);
		}
		System.out.println("Done.");
	}
	
	public static void unpublishTestServices(List<String> services) throws RemoteException {
		System.out.println("Publishing SerCHo Test Services to the RSD");
		for (String url : services) {
			System.out.println("publishing " + url + " ...");
			proxy.deregisterServiceSimple(url);
		}
		System.out.println("Done.");
	}
	
	
	private static List<String> loadFromPropertiesFile(String filename) {
		Properties props= new Properties();
		try {
			props.load(new FileInputStream(filename));
			List<String> list= new ArrayList<String>();

			Set<Object> keys=  props.keySet();
			for (Object key : keys) {
				String val= (String) props.get(key);
				System.out.println(key.toString() + " -> " + val);
				list.add(val);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
