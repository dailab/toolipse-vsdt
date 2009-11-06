package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.graphics.Color;

public class GroupFigure extends RoundedRectangle {

	public GroupFigure() {
		System.err.println("warning: group default constructor used");
		init();
	}
	
	public GroupFigure(boolean useColor) {
		setUseColor(useColor);
		init();
	}
	
	private void init() {
		this.setFill(false);
		this.setLineStyle(org.eclipse.draw2d.Graphics.LINE_DASHDOT);
		this.setCornerDimensions(new Dimension(20, 20));
	}

	private boolean myUseLocalCoordinates = false;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

	
	// COLORING
	
	public Color FOREGROUND_COLORED= ColorConstants.black;
	public Color BACKGROUND_COLORED= ColorConstants.white;
	public Color FOREGROUND_MONOCHROME= ColorConstants.black;
	public Color BACKGROUND_MONOCHROME= ColorConstants.white;
	
	public Color foreground= FOREGROUND_MONOCHROME;
	public Color background= BACKGROUND_MONOCHROME;
	
	public void setUseColor(boolean useColor) {
		foreground= useColor ? FOREGROUND_COLORED : FOREGROUND_MONOCHROME;
		background= useColor ? BACKGROUND_COLORED : BACKGROUND_MONOCHROME;
		setForegroundColor(foreground);
		setBackgroundColor(background);
		this.repaint();
	}
}
