package org.dailab.sercho.masp.egrain;

import java.util.Enumeration;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("java.library.path"));
		Enumeration enumeration= javax.comm.CommPortIdentifier.getPortIdentifiers();
		while (enumeration.hasMoreElements()) {
			Object o= enumeration.nextElement();
			System.out.println(o.toString());
		}
		CommLink com = new CommLink("COM1",2000);
//		Controller con = new Controller();
		while (true) {
			try {
				com.connect();
				System.out.println(com.readInput());
				
				Thread.sleep(3000);
				com.disconnect();
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				
				break;
			}
		}
		
	}

}
