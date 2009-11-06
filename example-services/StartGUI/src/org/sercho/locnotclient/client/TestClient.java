package org.sercho.locnotclient.client;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public abstract class TestClient {

	/**
	 * Invoke a call to a web service
	 * 
	 * @param url			the URL of the web service's WSDL
	 * @param operation		the name of the operation to invoke
	 * @param args			list of arguments
	 * @return				result
	 */
	protected Object invokeCall(String url, String operation, Object[] args) throws Exception {
		Call call= (Call) new Service().createCall();
		call.setTargetEndpointAddress(url);
		call.setOperationName(operation);
		return call.invoke(args);
	}
	
	
}