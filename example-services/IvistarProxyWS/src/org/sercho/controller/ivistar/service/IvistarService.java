package org.sercho.controller.ivistar.service;

import java.util.List;

public interface IvistarService {
	/*
	 * list of available Rooms 
	 */
	public String[] getRooms();
	/**
	 * 
	 * @param room : name of the room, where the Window-Shade are collected
	 * @return list of line of all window shade in the room
	 */
	public List<String> getWindowShade(String room);
	/**
	 * 
	 * @param room room : ip of the room
	 * @param line from the device
	 * @return the actual value from the device
	 */
	public String getValue(String room, String line);
	/**
	 * 
	 * @param room
	 * @param line
	 * @param newValue from the device
	 * e.g the value from shade live between 100 ... 200
	 * 100 is top
	 * 200 is bottom
	 * 
	 * the value from light live between 0..100
	 */
	public void setValue(String room, String line, String newValue);
	/**
	 * 
	 * @param room : name of the room, where the Window-Shade are collected
	 * @return list of line of all Light  in the room
	 */
	public List<String>getLights(String room);
}
