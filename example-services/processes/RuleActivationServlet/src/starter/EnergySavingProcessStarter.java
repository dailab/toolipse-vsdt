package starter;

import java.math.BigInteger;

import EnergySaving.WSDL.EnergySavingPTProxy;

@SuppressWarnings("serial")
public class EnergySavingProcessStarter extends AbstractProcessStarter {

	public EnergySavingProcessStarter(String pathToPropertiesFile) {
		super(pathToPropertiesFile);
	}
	
	@Override
	public String getProcessName() {
		return "Energy Saving";
	}

	@Override
	protected String getPropPrefix() {
		return "energysaving_";
	}

	private EnergySavingPTProxy process;
	
	@Override
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
	
	@Override
	protected void internalReloadProperties() {
		super.internalReloadProperties();
		username=	getPrefixedProp("username");
		zone=		getPrefixedProp("zone");
		room=		getPrefixedProp("room");
		lights=		getPrefixedProp("lights");
		trackUrl=	getPrefixedProp("trackUrl");
		renderer=	getPrefixedProp("renderer");
		delay=		Integer.parseInt(getPrefixedProp("delay"));
	}
	
	@Override
	protected void internalInit() throws Exception {
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
		process.start(username, BigInteger.valueOf(delay), zone, lights, room);
	}
	
	@Override
	protected void internalStop() throws Exception {
		process.stop();
	}
	
	@Override
	protected void internalReset() throws Exception {
		ivistar.setValue(room, lights, "0");
		radio.stop();
		Thread.sleep(2000);
		radio.setAVTransportURI(trackUrl);
	}
}
