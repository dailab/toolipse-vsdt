package org.sercho.processgui;

import java.math.BigInteger;

import EnergySaving.WSDL.EnergySavingPTProxy;

@SuppressWarnings("serial")
public class EnergySavingGUI extends AbstractProcessStartGUI {

	@Override
	public String getProcessName() {
		return "Energy Saving";
	}

	@Override
	protected String getPropPrefix() {
		return "energysaving_";
	}

	private EnergySavingPTProxy process;
	
	protected void initProxys() throws Exception {
		super.initProxys();
		process= new EnergySavingPTProxy(getProp("endpoint_process_energysaving"));
	}
	
	/*
	 * web service call fields and methods
	 */

	private String username;
	private String room;
	private String zone;
	private String lights;
	private String trackUrl;
	private String renderer;
	private int delay;
	
	protected void reloadProperties() {
		super.reloadProperties();
		username=	getPrefixedProp("username");
		zone=		getPrefixedProp("zone");
		room=		getPrefixedProp("room");
		lights=		getPrefixedProp("lights");
		trackUrl=	getPrefixedProp("trackUrl");
		renderer=	getPrefixedProp("renderer");
		delay=		Integer.parseInt(getPrefixedProp("delay"));
	}
	
	public void init() throws Exception {
		radio.init(renderer);
		try { // could already be running
			simulator.startSimulator();
		} catch (Exception e) {}
	}
	
	public void start() throws Exception {
		process.start(username, BigInteger.valueOf(delay), zone, lights, room);
	}
	
	@Override
	public void stop() throws Exception {
		process.stop();
	}
	
	public void reset() throws Exception {
		ivistar.setValue(room, lights, "0");
		radio.stop();
		Thread.sleep(2000);
		radio.setAVTransportURI(trackUrl);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EnergySavingGUI gui= new EnergySavingGUI();
		gui.initializeGUI();
		gui.initializeProperties();
		gui.initializeRuleClient();
	}
}
