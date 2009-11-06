package org.dailab.sercho.masp.egrain;

public class Controller {

	/**
	 * list of all eGrain Sensors
	 */
	private Node[] nodes = new Node[8]; 
	
	public Controller() {
		super();
		for (int i = 0; i < nodes.length; i++) {
			nodes[i]= new Node(i);
		}
	}
	
	/**
	 * 
	 * @return list of all nodes id
	 */
	public int[] getIDs() {
		int [] ids = new int[nodes.length];
		for (int i = 0; i < ids.length; i++) {
			ids[i]=nodes[i].getID();
		}
		return ids;
	}
	/**
	 * 
	 * @param id of the node
	 * @return sensor
	 */
	public Node getNode(int id){
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].getID() == id) {
				return nodes[i];
			}
		}
		return null;
	}
}
