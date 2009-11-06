package org.sercho.locnotclient.client;


public class SheaTestClient extends ShemTestClient {
	
	private String url= "http://localhost:8080/shea/services/Notification"; 
	
	public SheaTestClient(String url) {
		if (url != null) {
			this.url= url;
		}
	}
	
	@Override
	protected String getUrl() {
		return url;
	}
	
//	public static void main(String[] args) {
//		SheaTestClient client= new SheaTestClient(null);
//		try {
//			client.displayStartProcessButton("Kind",1);
////			client.invokeShowMessage("Kind", "bla bla bla");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}
