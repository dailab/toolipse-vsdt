/*
 * $Id: ComponentAddress.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Unique address of an IP-based building control component.
 *
 * @author Philipp Berndt
 */
public class ComponentAddress implements Comparable, Serializable {
    private static final int DEFAULTPORT = 956;
    private static final String SCHEME = "vroom";

    /**
     * Holds value of property socketAddress.
     */
    public InetSocketAddress socketAddress;
    
    /**
     * Holds value of property line.
     */
    public int line;
    
    /** Creates a new instance of ComponentAddress */
    public ComponentAddress() {
    }
    
    public ComponentAddress(InetSocketAddress isa, int line) {
        this.socketAddress = isa;
        this.line = line;
    }
    
    public ComponentAddress(String a) throws URISyntaxException {
        this(new URI(a));
    }
    
    public ComponentAddress(URI u) {
        int port = u.getPort();
        if (port == -1)
            port = DEFAULTPORT;
        socketAddress = new InetSocketAddress(u.getHost(), port);
        
//        line = Integer.parseInt(u.getPath().substring(1));

        final int position = u.getPath().lastIndexOf ('/');
        line = Integer.parseInt (u.getPath().substring (position + 1));
    }
    
    /**
     * Getter for property socketAddress.
     * @return Value of property socketAddress.
     */
    public InetSocketAddress getSocketAddress() {
        
        return this.socketAddress;
    }
    
    /**
     * Setter for property socketAddress.
     * @param socketAddress New value of property socketAddress.
     */
    public void setSocketAddress(InetSocketAddress socketAddress) {
        
        this.socketAddress = socketAddress;
    }
    
    /**
     * Getter for property line.
     * @return Value of property line.
     */
    public int getLine() {
        
        return this.line;
    }
    
    /**
     * Setter for property line.
     * @param line New value of property line.
     */
    public void setLine(int line) {
        
        this.line = line;
    }
    
    /**
     * Indicates whether some other object is "equal to" this one.
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ComponentAddress)) return false;
        ComponentAddress ca = (ComponentAddress)obj;
        return socketAddress.equals(ca.socketAddress) && line == ca.line;
    }
    
    public int hashCode() {
        return socketAddress.hashCode() + line;
    }
    
    protected static int sgn(int i) {
        return i < 0 ? -1 : i>0 ? 1 : 0;
    }
    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.<p>
     * 
     * @param   o the Object to be compared.
     * @return  a negative integer, zero, or a positive integer as this object
     * 		is less than, equal to, or greater than the specified object.
     * 
     * @throws ClassCastException if the specified object's type prevents it
     *         from being compared to this Object.
     */
    public int compareTo(Object o) {
        ComponentAddress other = (ComponentAddress)(o);
        byte[] b1 = socketAddress.getAddress().getAddress();
        byte[] b2 = other.socketAddress.getAddress().getAddress();
        int l = b1.length - b2.length;
        if (l != 0)
            return sgn(l);
        
        for (int i=0; i<b1.length; ++i) {
            int c = b1[i] - b2[i];
            if (c != 0)
                return sgn(c);
        }

        int p = socketAddress.getPort() - other.socketAddress.getPort();
        if (p != 0)
            return sgn(p);
        
        return sgn(line - other.line);
    }

//    public URL getURL() {
//    	try {
////            return (socketAddress.getPort() == DEFAULTPORT)
////            ? new URL(SCHEME, socketAddress.getHostName(), Integer.toString(line))
////            : new URL(SCHEME, socketAddress.getHostName(), socketAddress.getPort(), Integer.toString(line));
//
//			return new URL (
//				SCHEME + "://" +
//				socketAddress.getHostName() +
//				':' +
//				((socketAddress.getPort() == -1) ? 80 : socketAddress.getPort()) +
//				'/' + Integer.toString(line)
//			);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//			return null;
//		}
//    }
    
//    public URI getURI() {
//        try {
////            return (socketAddress.getPort() == DEFAULTPORT)
////            ? new URI(SCHEME, socketAddress.getHostName(), Integer.toString(line), "")
////            : new URI(SCHEME, "", socketAddress.getHostName(), socketAddress.getPort(), Integer.toString(line), "", "");
//
//			return getURL().toURI();
//        } catch (URISyntaxException ex) {
//        	ex.printStackTrace();
//            return null;
//        }
//    }
    
    /**
     * Returns a string representation of the object.
     *
     * @return  a string representation of the object.
     */
    public String toString() {
//        return getURI().toString();
      return (socketAddress.getPort() == DEFAULTPORT)
      ? SCHEME + "://" + socketAddress.getAddress().getHostAddress() + "/" + line
      : SCHEME + "://" + socketAddress.getAddress().getHostAddress() + ":"+socketAddress.getPort()+ "/" + line;
    }

}
