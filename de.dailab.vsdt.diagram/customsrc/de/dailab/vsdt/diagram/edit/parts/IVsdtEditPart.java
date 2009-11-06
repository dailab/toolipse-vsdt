package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;

/**
 * This is merely a marker interface implemented by all edit parts of the 
 * Visual Service Design Tool. Its is used for enabling certain menus
 * and menu actions for those edit parts. 
 * 
 * @author kuester
 */
public interface IVsdtEditPart {

	public IFigure getPrimaryShape();
	
}
