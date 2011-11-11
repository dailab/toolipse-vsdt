class WaitForRepliesSub extends Thread {
	TaxiResponse currentResponse;
	
	public void run() {
		noResponse = true;
		while (true) {
			receiveResponse();
			if (currentResponse.compareTo(globalBest) > 0) {
				updateGlobalBest();
			} else {
				doNothing();
			}
		}
	}
 
	private void receiveResponse() {
		Action joinAction = retrieveAction(ACTION_JOIN_GROUP);
		Action leaveAction = retrieveAction(ACTION_LEAVE_GROUP);
		IGroupAddress group = createGroupAddress("TaxiResponseTo"+appID+"");
		invoke(joinAction, new Serializable[] {group});
		TaxiResponse response = null;
		while (response == null) {
			for (JiacMessage msg : memory.readAll(new JiacMessage())) {
				if (msg.getHeader(Header.SEND_TO).equals("TaxiResponseTo"+appID+"")
						&& msg.getPayload() instanceof TaxiResponse) {
					memory.remove(msg);
					response = (TaxiResponse) msg.getPayload();
					break;
				}
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) { }
		}
		invoke(leaveAction, new Serializable[] {group});
		noResponse = false;
		currentResponse = response;
	}
 
	private void doNothing() {
	}
 
	private void updateGlobalBest() {
		globalBest = currentResponse;
	}
}

class TimeoutEvent extends Thread {
	long timeout;
	Thread toStop;
	boolean triggered = false;
	
	public TimeoutEvent(long timeout, Thread toStop) {
		this.timeout = timeout;
		this.toStop = toStop;
	}
	
	public void run() {
		try {
			Thread.sleep(timeout);
			triggered = true;
			toStop.stop();
		} catch (InterruptedException e ) { }
	}
}
