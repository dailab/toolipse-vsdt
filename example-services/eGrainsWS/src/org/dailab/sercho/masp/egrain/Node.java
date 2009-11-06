package org.dailab.sercho.masp.egrain;


/**
 * 
 * @author bedime
 *
 */
public class Node{

	/**
	 * Actual value of Temperature
	 */
	private String value;
	/**
	 * eGrainNodes value when value is NOACK
	 */
	public static String TEMPERATUR_VALUE_NOACK = "NOACK";
	/**
	 * eGrainNodes value when temperature is null
	 */
	public static String TEMPERATUR_VALUE_NULL = "NULL";
	/**
	 * ID of eGrainNode 
	 */
	private int NodeID;
	
	/**
	 *  eGrainNode is registered
	 */
	private boolean registered = false;
	
	/**
	 *  eGrainNode is enabled
	 */
	private boolean enabled = false;
	
	/**
	 * EGrainNaode construct with node id
	 * @param id
	 */
	public Node(int id) {
		super();
		NodeID = id;
		setTemperatureValue(TEMPERATUR_VALUE_NULL);
	}

	/**
	 * empty construct from EGrainNode
	 */
	public Node() {
		super();
	}

	public String getTemperatureValue() {
		if (isRegistered()) {
			if (! isEnabled()) {
				return TEMPERATUR_VALUE_NOACK;
			}
			else return value;
		}
		return TEMPERATUR_VALUE_NULL;
	}

	/**
	 * set the actual value of Node temperature
	 * @param value
	 */
	public void setTemperatureValue(String value) {
		this.value = value;
	}
	/**
	 * 
	 * @return Id of Node
	 */
	public int getID() {
		return NodeID;
	}

	/**
	 * 
	 * @param id of Node
	 */
	public void setID(int id) {
		NodeID = id;
	}
	
	public String toString(){
		return "{ID: "+NodeID+"; registered: "+registered+" enabled "+enabled+" temperature: "+value+"}";
	}

	/**
	 * 
	 * @return true if the node is registered
	 */
	public boolean isRegistered() {
		return registered;
	}

	/**
	 * 
	 * @param registered is true  to register a  node 
	 */
	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	/**
	 * 
	 * @return true if the node was registered but don't appear any more
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * 
	 * @param enabled true if the node appear 
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
