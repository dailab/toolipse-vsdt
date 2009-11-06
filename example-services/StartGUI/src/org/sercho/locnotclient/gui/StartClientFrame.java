package org.sercho.locnotclient.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class StartClientFrame {

	public static void main(String[] args) {
		ClientFrame frame= new ClientFrame(true);
		
		if (args.length > 0) {
			String url= args[0];
			System.out.println("Using SHEA at " + url);
			frame.setNotificationURL(url);
		}
		
		final String propFile= "startGui.properties"; 
		try {
			File file= new File(propFile);
			InputStream in= new FileInputStream(file);
			Properties prop= new Properties();
			prop.load(in);
			String notificationUrl= prop.getProperty("notificationUrl");
			String servletUrl= prop.getProperty("servletUrl");
			String uid= prop.getProperty("uid");
			String delay= prop.getProperty("delay");
			String countdown= prop.getProperty("countdown");
			String style= prop.getProperty("btnStyle");
			String message= prop.getProperty("message");
			String fullMessage= prop.getProperty("fullMessage");
			String countdown2= prop.getProperty("countdown2");
			
			frame.setUID(uid);
			frame.setDelay(delay);
			frame.setCountdown(countdown);
			frame.setNotificationURL(notificationUrl);
			frame.setServletURL(servletUrl);
			frame.message= message;
			frame.style= style;
			frame.fullMessage= fullMessage;
			frame.countdown2= Integer.parseInt(countdown2);
			
		} catch (Exception e) {
			System.err.println(propFile + " not found");
		}

		frame.setVisible(true);
	}
	
}
