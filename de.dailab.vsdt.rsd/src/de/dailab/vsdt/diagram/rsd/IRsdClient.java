package de.dailab.vsdt.diagram.rsd;

import java.util.List;

/**
 * Interface to be implemented by the RSD clients. For making a variety of clients
 * available for the RSD view, e.g. utilizing different frameworks and following
 * different approaches, this interface describes the most vital methods that have
 * to be supported by the clients.
 * 
 * This interface will be used in the RSD view, making the client currently in use
 * fully transparent.
 * 
 * @author kuester
 */
public interface IRsdClient {

	/**
	 * Connect to a Rich Service Directory located at the given endpoint.
	 *  
	 * @param endpoint	The endpoint where to find the RSD's WSDL (a URL)
	 * 					If null, a default may used.
	 */
	boolean connect(String endpoint);

	/**
	 * Retrieve a list of all currently registered services from the RSD
	 * 
	 * @return	a List of all services in WSData format 
	 */
	List<IRsdWS> getAllServices();
	
	/**
	 * Retrieve a cached list of services
	 * 
	 * @return	a cached list of services is WSData format
	 */
	List<IRsdWS> getCachedServices();
	
	/**
	 * Registers a web service at the RSD
	 * @param wsdlUrl	the webservice's WSDL file
	 * @return			new list of webservices known to the RSD
	 */
	List<IRsdWS> registerWebService(String wsdlUrl);
	
	/**
	 * Translate the service representation used in the client to the 'official'
	 * WSData representation
	 * 
	 * @param object	some service description
	 * @return			an equivalent WSData object
	 */
	IRsdWS createRsdWS(Object object);
	
	/**
	 * @return			Whether the client is connected to an RSD
	 */
	boolean isConnected();
	
}
