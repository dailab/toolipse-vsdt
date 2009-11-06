package org.sercho.locnotclient.client;

public class SerCHoDemoTestClient extends TestClient{
	
	final String url= "http://localhost:8080/active-bpel/services/CeBitDemoProzess_ParticipantService?wsdl";
	
	/**
	 * invoke the start process operation
	 * 
	 * @param username		the name of the user to track
	 * @param delay			the delay between two inquiries
	 */
	public void invokeStartExecution(String username, int delay) throws Exception {
		final String operation= "startExecution";
		final Object[] args= new Object[]{ username, new Integer(delay)};
		invokeCall(url, operation, args);
	}
	
	/**
	 * invoke the stop process operation
	 */
	public void invokeStopExecution() throws Exception {
		final String operation= "stopExecution";
		final Object[] args= new Object[]{ };
		invokeCall(url, operation, args);
	}
	
	public static void main(String[] args) {
		SerCHoDemoTestClient client= new SerCHoDemoTestClient();
		try {
			client.invokeStopExecution();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
