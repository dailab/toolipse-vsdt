package starter;

import java.util.Calendar;

import LightAlarm.WSDL.LightAlarmPTProxy;

@SuppressWarnings("serial")
public class LightAlarmProcessStarter extends AbstractProcessStarter {

	public LightAlarmProcessStarter(String pathToPropertiesFile) {
		super(pathToPropertiesFile);
	}

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
	
	@Override
	protected void internalReloadProperties() {
		super.internalReloadProperties();
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
	
	@Override
	protected void internalInit() throws Exception {
		ivistar.setValue(room, blinds, "100"); // jalousien kurz hochfahren (für kalibirierung?)
		radio.init(renderer);
		try { // could already be running
			simulator.startSimulator();
		} catch (Exception e) {}
	}
	
	@Override
	protected void internalDeploy() throws Exception {
	}
	
	@Override
	protected void internalStart() throws Exception {
		process.initProcess(username, createWaketimeString(offset), city, country, room, lights, blinds, useLight, useMusic);
	}
	
	@Override
	protected void internalStop() throws Exception {
	}
	
	@Override
	public boolean isStoppable() {
		return false;
	}
	
	protected void internalReset() throws Exception {
		ivistar.setValue(room, lights, "0");
		ivistar.setValue(room, blinds, "200");
		radio.stop();
		Thread.sleep(2000);
		radio.setAVTransportURI(trackUrl);
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
}
