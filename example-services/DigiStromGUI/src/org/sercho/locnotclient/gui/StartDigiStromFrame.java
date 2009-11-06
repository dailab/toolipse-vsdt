package org.sercho.locnotclient.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class StartDigiStromFrame {

	public static void main(String[] args) {
		DigiStromFrame frame= new DigiStromFrame(true);
		
		final String propFile= "digiStromGui.properties"; 
		try {
			File file= new File(propFile);
			InputStream in= new FileInputStream(file);
			Properties prop= new Properties();
			prop.load(in);
			frame.ip= prop.getProperty("ip");
			frame.id= prop.getProperty("id");
		} catch (Exception e) {
			System.err.println(propFile + " not found");
		}

		frame.init();
		frame.setVisible(true);
	}
	
}
