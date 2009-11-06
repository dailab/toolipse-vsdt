package org.sercho.locnotclient.client;


public class ShemTestClient extends TestClient {

	protected String getUrl() {
		return "http://localhost:8080/SHEM/services/Notification";
	}
	
	/**
	 * display a message on the SHEA
	 * 
	 * @param username		user for whom to display the message
	 * @param message		the message (may contain HTML)
	 */
	public void invokeShowMessage(String username, String message) throws Exception {
		final String operation= "showMessage";
		final Object[] args= new Object[]{ username, message};
		invokeCall(getUrl(), operation, args);
	}
//
//	
//	public static void main(String[] args) {
//		ShemTestClient client= new ShemTestClient();
//		try {
//			client.displayStartProcessButton("Kind",1);
////			client.invokeShowMessage("Kind", "bla bla bla");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
