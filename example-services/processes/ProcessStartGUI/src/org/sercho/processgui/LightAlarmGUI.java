package org.sercho.processgui;

import java.util.Calendar;

import LightAlarm.WSDL.LightAlarmPTProxy;

@SuppressWarnings("serial")
public class LightAlarmGUI extends AbstractProcessStartGUI {

	@Override
	public String getProcessName() {
		return "Light Alarm";
	}

	@Override
	protected String getPropPrefix() {
		return "lightalarm_";
	}
	
	private LightAlarmPTProxy process;
	
	protected void initProxys() throws Exception {
		super.initProxys();
		process= new LightAlarmPTProxy(getProp("endpoint_process_lightalarm"));
	}
	
	/*
	 * web service call fields and methods
	 */

	private String username;
	private String room;
	private String blinds;
	private String lights;
	private String city;
	private String country;
	private String trackUrl;
	private String renderer;
	private int offset;
	private boolean useLight;
	private boolean useMusic;
	
	protected void reloadProperties() {
		super.reloadProperties();
		username=	getPrefixedProp("username");
		room=		getPrefixedProp("room");
		blinds=		getPrefixedProp("blinds");
		lights=		getPrefixedProp("lights");
		city=		getPrefixedProp("city");
		country=	getPrefixedProp("country");
		trackUrl=	getPrefixedProp("trackUrl");
		renderer=	getPrefixedProp("renderer");
		offset=		Integer.parseInt(getPrefixedProp("offset"));
		useLight=	Boolean.parseBoolean(getPrefixedProp("useLight"));
		useMusic=	Boolean.parseBoolean(getPrefixedProp("useMusic"));
	}
	
	public void init() throws Exception {
		ivistar.setValue(room, blinds, "100"); // jalousien kurz hochfahren (für kalibirierung?)
		radio.init(renderer);
		try { // could already be running
			simulator.startSimulator();
		} catch (Exception e) {}
	}
	
	public void start() throws Exception {
		process.initProcess(username, createWaketimeString(offset), city, country, room, lights, blinds, useLight, useMusic);
	}
	
	@Override
	public void stop() throws Exception {
	}
	
	public void reset() throws Exception {
		ivistar.setValue(room, lights, "0");
		ivistar.setValue(room, blinds, "200");
		radio.stop();
		Thread.sleep(2000);
		radio.setAVTransportURI(trackUrl);
		// TODO lautstärke normalisieren
	}

	private String createWaketimeString(int offset) {
		Calendar cal= Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis() + offset*1000);
		StringBuffer buff= new StringBuffer();
		buff.append(normDatePart(cal.get(Calendar.YEAR))).append("-");
		buff.append(normDatePart(cal.get(Calendar.MONTH)+1)).append("-");
		buff.append(normDatePart(cal.get(Calendar.DAY_OF_MONTH))).append("T");
		buff.append(normDatePart(cal.get(Calendar.HOUR_OF_DAY))).append(":");
		buff.append(normDatePart(cal.get(Calendar.MINUTE))).append(":");
		buff.append(normDatePart(cal.get(Calendar.SECOND)));
		//time zone
		buff.append("+").append("02:00"); //+1 wegen zeitzone, +1 wegen sommerzeit
		System.out.println(buff.toString());
		return buff.toString();
	}
	
	private String normDatePart(int part) {
		return (part<10?"0":"")+part;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LightAlarmGUI gui= new LightAlarmGUI();
		gui.initializeGUI();
		gui.initializeProperties();
		gui.initializeRuleClient();
	}
}
