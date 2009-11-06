package de.dailab.vsdt.diagram.rsd.client;

import de.dailab.jiactng.agentcore.servicediscovery.xsd.ServiceParameter;
import de.dailab.vsdt.diagram.rsd.IRsdParam;

public class Axis2RsdParam implements IRsdParam{
	
	private ServiceParameter param;
	
	public Axis2RsdParam(ServiceParameter param) {
		this.param= param;
	}
	
	public String getName() {
		return param.getName();
	}
	
	public String getType() {
		return param.getType();
	}
	
	public String getData() {
		return null;
	}
	
	public String toString() {
		return getName() + " : " + getType();
	}
	
}
