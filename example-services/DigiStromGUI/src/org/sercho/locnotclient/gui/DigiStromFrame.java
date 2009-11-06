package org.sercho.locnotclient.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class DigiStromFrame extends JFrame implements ActionListener {

	public static final String TITLE= "DigitalStrom-GUI";  
	public static final int BUFFER_SIZE= 1024;
	
	private JButton lightOnButton;
	private JButton lightOffButton;
	
	private JTextField ipTextField;
	private JTextField idTextField;
	
	public String ip= "192.168.2.220";
	public String id= "68";
	
	/**
	 * Create frame area.
	 */
	public DigiStromFrame(boolean exitOnClose) {
		this.setTitle(TITLE);
		if (exitOnClose) {
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	
	public void init() {
		JPanel mainPanel= new JPanel();
		mainPanel.setLayout(new GridLayout(3,2,10,10));
		
		mainPanel.add(new JLabel("IP"));
		ipTextField= new JTextField(ip);
		mainPanel.add(ipTextField);
		
		mainPanel.add(new JLabel("ID"));
		idTextField= new JTextField(id);
		mainPanel.add(idTextField);

		lightOnButton= new JButton("On");
		lightOnButton.addActionListener(this);
		mainPanel.add(lightOnButton);
		
		lightOffButton= new JButton("Off");
		lightOffButton.addActionListener(this);
		mainPanel.add(lightOffButton);

		this.getContentPane().add(mainPanel);
		this.pack();
		this.setResizable(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src= e.getSource();
		if (src == lightOnButton) {
			toggleLight(true);
		}
		if (src == lightOffButton) {
			toggleLight(false);
		}
	}
	
	
	public void toggleLight(boolean onOff) {
		String state= onOff ? "1" : "0";
    	//build full URL
    	StringBuffer buff= new StringBuffer();
    	buff.append("http://");
    	buff.append(ip);
    	buff.append("/exec?");
    	buff.append("p1=0&p2=");
    	buff.append(id);
    	buff.append("&p3=");
    	buff.append(state);
    	String urlString= buff.toString();
    	
    	//open stream
    	InputStream in= null;
        try {
            in = new URL(urlString).openStream();
      	} catch(Exception e) {
            System.err.println("Failed to connect to HC10 web server under url: " + urlString);
        }
        
        //read from stream
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            final StringBuffer response = new StringBuffer();
            final char[] buffer = new char[BUFFER_SIZE];
            int read = 0;
            while((read = reader.read(buffer)) != -1) {
                response.append(buffer, 0, read);
            }          
            // return response string
        }
        catch(Exception e) {
            System.err.println("Failed to read response from HC10 web server under url: " + urlString);
        }
        
        //close stream
        finally {
            try {
                in.close();
            }
            catch(Exception e) {
                System.err.println("Failed to close InputStream from HC10 web server: " + e.getMessage());
            }
        }
	}
}
