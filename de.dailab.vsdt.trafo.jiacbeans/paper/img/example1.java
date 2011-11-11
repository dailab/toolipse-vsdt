public class Client_requestTaxi extends AbstractMethodExposingBean {
	public static String ACTION_REQUESTTAXI = "Client_requestTaxi#requestTaxi"; 
	TaxiResponse globalBest;
	boolean noResponse;
	String appID;
	String location;
	String destination;

	@Expose(name = ACTION_REQUESTTAXI, scope = ActionScope.GLOBAL)
	public String requestTaxi(String currentLoc, String currentDest) {
		location = currentLoc;
		destination = currentDest;
		sendRequest();
		WaitForRepliesSub waitForReplies = new WaitForRepliesSub();
		TimeoutEvent wait30Seconds = new TimeoutEvent(30000, waitForReplies);
		try {
			waitForReplies.start();
			wait30Seconds.start();
			waitForReplies.join();
			wait30Seconds.stop();
		} catch (InterruptedException e) { }
		if (noResponse) {
			String taxiID = "none available";
			return taxiID;
		} else {
			notifyTaxis();
			String taxiID = globalBest.getTaxiID();
			return taxiID;
		}
	}

	private void sendRequest() {
		TaxiRequest request = new TaxiRequest(location, appID, destination);
		Action sendAction = retrieveAction(ACTION_SEND);
		IGroupAddress group = createGroupAddress("TaxiRequest");
		JiacMessage msg = new JiacMessage(request);
		invoke(sendAction, new Serializable[] {msg, group});
	}

	private void notifyTaxis() {
		[ analogeous to sendRequest() ]
	}

	class WaitForRepliesSub extends Thread { [see below] }

	class TimeoutEvent extends Thread { [see below] }
}
