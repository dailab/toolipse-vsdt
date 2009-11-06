/*
 * $Id: HttpStatusResponse.java,v 1.1.2.1 2008/02/18 14:25:44 bogart Exp $
 * Created Winter 2004/2005 by Philipp Berndt <philipp.berndt@ivistar.de>
 *
 * Code (c) Ivistar AG, Berlin, Germany
 */

package com.ivistar.vroomctrl.net;

/**
 * This class holds status information sent back by a webserver
 * in reply to a HTTP GET or POST request.
 *
 * @author Philipp Berndt <philipp.berndt@ivistar.de>
 */
public class HttpStatusResponse extends Exception {
    private int code;
    private String message;
    
    /** Creates a new instance of HttpResponse */
    public HttpStatusResponse(int code) {
        this(code, "");
    }
    
    public HttpStatusResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
    return code;
    }

    public String getMessage() {
    return message;
    }
    
    public String toString() {
    return "HTTP Response "+code+" "+message;
    }
}
