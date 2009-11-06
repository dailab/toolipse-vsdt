package org.sercho.locnotclient.client;

public class LocationMapTestClient extends TestClient {

	final String url= "http://localhost:8080/LocationMapWS_2/services/LocationMapSOAP?wsdl";
	
	/**
	 * invoke set Location method
	 * 
	 * @param username		the user whose location to set
	 * @param x				x coordinate
	 * @param y				y coordinate
	 * @param z				z coordinate
	 */
	public void invokeSetLocation(String username, float x, float y, float z) throws Exception {
		final String operation= "setLocation";
		final Object[] args= new Object[]{ username, new Float(x), new Float(y), new Float(z)};
		invokeCall(url, operation, args);
	}
	
	/**
	 * FIXME invoke get Location method
	 * 
	 * @param username		the name of the user to locate
	 * @return				position (complex type)
	 */
	public Object invokeGetLocation(String username) throws Exception {
		final String operation= "getLocation";
		final Object[] args= new Object[]{ username};
		return invokeCall(url, operation, args);
	}

	/**
	 * Test
	 */
	public static void main(String[] args) {
		LocationMapTestClient client= new LocationMapTestClient();
		try {
			client.invokeSetLocation("test", 1, 2, 3);
			client.invokeGetLocation("test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
