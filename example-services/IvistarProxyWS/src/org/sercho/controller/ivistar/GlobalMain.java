package org.sercho.controller.ivistar;

import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import org.sercho.controller.ivistar.service.IvistarService;
import org.sercho.controller.ivistar.service.IvistarServiceImpl;

public class GlobalMain {

	static final Properties settings = new Properties();
//	private static IPProxy proxy1, proxy2, proxy3;
	final Logger logger = Logger.getLogger (this.getClass().getName());
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IvistarService serv= new IvistarServiceImpl();
//		List<String> shades = serv.getWindowShade("Living Room");
//		for (String string : shades) {
//			System.out.println("line "+string);
//		}
//		serv.setValue("Living Room", "95", "200");

//		System.out.println("Getting Rooms...");
//		String[] rooms= serv.getRooms();
//		for (String s : rooms) {
//			System.out.println("--- Room: " + s);
//		}
		String room= "Living Room";
		System.out.println("Getting Lights for " + room + "...");
		List<String> lights= serv.getLights(room);
		for (String s : lights) {
//			try {Thread.sleep(3000);}catch (Exception e) {}
			System.out.println("--- Light: " + s);
//			serv.setValue(room, s, "0");
		}
		System.out.println("Getting Blinds for " + room + "...");
		List<String> blinds= serv.getWindowShade(room);
		for (String s : blinds) {
			System.out.println("--- Blind: " + s);
//			serv.setValue(room, s, "100");
		}
//		System.out.println("Setting value...");
//		serv.setValue("Living Room", "96", "100");
//		serv.setValue("Living Room", "92", "200");
//		serv.setValue("Living Room", "34", "100");
//		serv.setValue("Living Room", "28", "0");
//		serv.setValue("Living Room", "34", "0");
//		serv.setValue("Living Room", "30", "100");
		
		try {Thread.sleep(8000);}catch (Exception e) {}
		System.exit(0);
		
//		proxy1 = new IPProxy();
//		proxy1.setUrl(settings.getProperty (Constants.TAG_URL, Constants.VALUE_URL), "10"); // room with id 10
//		proxy1.sync();
//		Vector<VObject> objects = proxy1.getObjects();
//		
//		for (VObject object : objects) {
//			System.out.println("IP: " + object.get(VObject.Property.IP));
//			System.out.println("Name: " + object.get(VObject.Property.Name));
//			System.out.println("UID: " + object.get(VObject.Property.UID));
//			System.out.println("InetAdress: " + object.get(VObject.Property.InetAddress));
//			System.out.println("InetAdress: " + object.get(VObject.Property.Label));
//			System.out.println("InetAdress: " + object.get(VObject.Property.Line));
//			System.out.println("value: " + object.get(VObject.Property.Value));
//			
//		object.setValue("0");
////			((com.ivistar.glt.ipproxy.VObject)object).setValue("0");
//		}
//		proxy1.exit();
		
	}

}

