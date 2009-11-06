/**
 * UPnPRadioSOAPImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.sercho.UPnPRadio.impl;

import java.io.File;
import java.math.BigInteger;
import java.rmi.RemoteException;

import org.cybergarage.upnp.Action;
import org.cybergarage.upnp.ControlPoint;
import org.cybergarage.upnp.Device;
import org.cybergarage.upnp.Service;
import org.cybergarage.upnp.device.DeviceChangeListener;

public class UPnPRadioServiceImpl implements org.sercho.UPnPRadio.UPnPRadioPT{
	
	public static String deviceID= "PHILIPS WAS700";
	
	protected static final ControlPoint controlPoint= new ControlPoint();
	protected static Device renderingDevice= null;
	protected static Service controlService= null;
	protected static Service renderingService= null;
	
	protected static boolean isInitialized= false;
	
	protected static void initialize() {
		System.out.println("Initializing UPnP Radio WS");
		if (isInitialized) {
			System.out.println("already initialized");
			return;
		}
		controlPoint.addDeviceChangeListener(new DeviceChangeListener() {
			@Override
			public void deviceAdded(Device dev) {
				System.out.println("Device added: "+dev.getFriendlyName());
				if (dev.getFriendlyName().toLowerCase().contains(deviceID)) {
					renderingDevice= dev;
					System.out.println("AV Rendering Device found");

					for (Service s : renderingDevice.getServiceList()) {
						System.out.println("- " + s.getServiceID());
						
						if (s.getServiceID().contains("AVTransport")) {
							System.out.println("control service found");
							controlService= s;
						}
						if (s.getServiceID().contains("RenderingControl")) {
							renderingService= s;
							System.out.println("rendering service found");
						}
					}
				}
			}
			@Override
			public void deviceRemoved(Device dev) {
			}
		});
		controlPoint.start();
		isInitialized= true;
	}
	
	@Override
	public void init(String deviceID) throws RemoteException {
		UPnPRadioServiceImpl.deviceID= deviceID;
		initialize();
	}
	
	@Override
	public void setAVTransportURI(String url) throws RemoteException {
		if (! isInitialized) {
			initialize();
		}
		System.out.println("Invoking setAVTransport...");
    	if (controlService != null) {
	    	Action a = controlService.getAction("SetAVTransportURI");
			a.setArgumentValue("InstanceID", 0);
			a.setArgumentValue("CurrentURI", url);
			System.out.println(a.postControlAction());
    	} else {
    		System.err.println("ERROR: conrol service not available");
    	}
	}
	
	@Override
	public void play() throws RemoteException {
		if (! isInitialized) {
			initialize();
		}
		System.out.println("Invoking Play..");
    	if (controlService != null) {
    		Action a= controlService.getAction("Play");
			a.setArgumentValue("InstanceID", 0);
			a.setArgumentValue("Speed", 1);
			System.out.println(a.postControlAction());
    	} else {
    		System.err.println("ERROR: conrol service not available");
    	}
	}
	
	@Override
	public void pause() throws RemoteException {
		if (! isInitialized) {
			initialize();
		}
		System.out.println("Invoking Pause...");
    	if (controlService != null) {
    		Action a= controlService.getAction("Pause");
			a.setArgumentValue("InstanceID", 0);
			System.out.println(a.postControlAction());
    	} else {
    		System.err.println("ERROR: conrol service not available");
    	}
	}
	
	@Override
	public void playPause(BigInteger state) throws RemoteException {
		if (state.intValue() == 1) {
			play();
		} else {
			pause();
		}
	}
	
	@Override
	public void setVolume(BigInteger volume) throws RemoteException {
		if (! isInitialized) {
			initialize();
		}
		System.out.println("Setting Volume to " + volume);
    	if (renderingService != null) {
    		System.err.println("not yet supported");
    		//TODO
//    		Action a= wasRenderingService.getAction("SetVolume");
//    		// Channel ?
//			a.setArgumentValue("InstanceID", 0);
//    		a.setArgumentValue("DesiredVolume", volume.intValue());
//			System.out.println(a.postControlAction());
    	} else {
    		System.err.println("ERROR: rendering service not available");
    	}
	}
	
	@Override
	public void stop() throws RemoteException {
		if (! isInitialized) {
			initialize();
		}
		System.out.println("Invoking Stop...");
    	if (controlService != null) {
    		Action a= controlService.getAction("Stop");
			a.setArgumentValue("InstanceID", 0);
			System.out.println(a.postControlAction());
    	} else {
    		System.err.println("ERROR: conrol service not available");
    	}
	}
	
	public static void main(String[] args) {
		final String url= "C:\\Users\\kuester\\Music\\Apocalyptica\\Cult (Disc 1)\\01 - Path.mp3";
		try {
			File file= new File(url);
			System.out.println(file.getAbsolutePath());
			if (file.exists()) {
				UPnPRadioServiceImpl control= new UPnPRadioServiceImpl();
				control.init("intel");
				Thread.sleep(15000);
				control.setAVTransportURI(url);
				control.play();
				Thread.sleep(4000);
				control.stop();
			} else {
				System.err.println("file does not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
