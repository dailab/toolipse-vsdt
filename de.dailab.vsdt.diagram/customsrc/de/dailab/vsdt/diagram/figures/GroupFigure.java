package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;

public class GroupFigure extends RoundedRectangle {

	public GroupFigure() {
		init();
	}
	
	private void init() {
		setFill(false);
		setLineStyle(org.eclipse.draw2d.Graphics.LINE_DASHDOT);
		setCornerDimensions(new Dimension(20, 20));
		setForegroundColor(FigureHelper.getForeground(this));
	}

	private boolean myUseLocalCoordinates = false;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}
}
