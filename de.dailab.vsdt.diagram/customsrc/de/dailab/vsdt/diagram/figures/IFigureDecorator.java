package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;

public interface IFigureDecorator {

	void decorateFigure(IFigure figure, Graphics g);
	
}
