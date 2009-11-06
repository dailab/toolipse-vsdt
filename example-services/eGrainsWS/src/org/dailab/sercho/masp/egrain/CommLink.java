package org.dailab.sercho.masp.egrain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.comm.CommPortIdentifier;
import javax.comm.SerialPort;
import javax.comm.SerialPortEvent;
import javax.comm.SerialPortEventListener;

public class CommLink {

	/**
	 * Name of the comm name have to look like e.g COM1, COM2
	 */
	private final String comm_Name;
	
	/**
	 * Human name of the of the comm port
	 */
	private static final String portName = "eGrains";

	/**
	 * ID of the comm port
	 */
	static CommPortIdentifier portID;
	
	/**
	 * Stream coming the serial port
	 */
	private InputStream ins;
	
	/**
	 * serial port 
	 */
	private SerialPort serss;
	
	/**
	 * time waiting for the connection before closing
	 */
	private int timeout;
	/**
	 * physical data for transfer information
	 */
	private static final int BAUDRATE = 19200;
	
	/**
	 * Response string from the transfer  
	 */
	String input;
	/**
	 * String parser
	 */
	private final Parser parser;
	
	/**
	 * 
	 * @param commPortName: name of the comm port
	 * @param timeout: time to waiting before closing the connection
	 */
	public CommLink(String commPortName, int timeout) {
		super();
		this.comm_Name = commPortName;
		this.timeout = timeout;
		input = new String();
		parser = new Parser();
	}
	/**
	 * Connect to the comm port
	 */
	public void connect(){
		try {
			portID = CommPortIdentifier.getPortIdentifier(comm_Name);
	        serss = (SerialPort) portID.open(portName,timeout);
	        System.out.println("Port "+comm_Name+" connected...");
			ins = serss.getInputStream();
			serss.addEventListener(new commListener());
			serss.notifyOnDataAvailable(true);
			serss.setSerialPortParams(BAUDRATE,SerialPort.DATABITS_8,
                                                SerialPort.STOPBITS_1 ,
                                                SerialPort.PARITY_NONE);
		} catch (Exception e) {
			System.out.println("Fehler: "+e);
		}
	}

	public void disconnect(){
		if (serss !=null) {
			serss.close();
			System.out.println("SSD is desconnected...");
		}
	}
	/**
	 * 
	 * @return string from the comm line
	 */
	public String readInput() {
		return input;
	}
	public Controller getController(){
		return parser.getController();
	}
	/**
	 * 
	 * Listen if some stream coming form the comm port
	 *
	 */
	public class commListener implements SerialPortEventListener{
	    public void serialEvent(SerialPortEvent event) {
	      if(event.getEventType()==SerialPortEvent.DATA_AVAILABLE){
	        	try {
		        	while (ins.available() > 0) {
						input = new BufferedReader(new InputStreamReader(ins)).readLine();
						parser.parse(input);
		        	}
		        }
		        catch (IOException e) {System.out.println("Fehler: "+e);}
	    }
	  }
	}
}
