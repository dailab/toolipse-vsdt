package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.IFigure;

public interface IDecoratableFigure extends IFigure {

	void setDecorator(IFigureDecorator decorator);
	
	IFigureDecorator getDecorator();
	
}
