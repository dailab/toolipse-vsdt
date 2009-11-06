package org.sercho.SheaSimulator.impl;

import java.awt.Point;

public class Zone {

	public String name;
	public Point p1;
	public Point p2;
	
	public Zone(String name, int x1, int y1, int x2, int y2) {
		this.name= name;
		this.p1= new Point(x1,y1);
		this.p2= new Point(x2,y2);
	}
	
	public boolean contains(int x, int y) {
		return p1.x<x && x<p2.x && p1.y<y && y<p2.y;
	}
}
