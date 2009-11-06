package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.swt.graphics.Color;

import de.dailab.common.gmf.ui.figures.RoundedPolylineConnection;

/**
 * figure for the bpmn message flow element
 */
public class MessageFlowFigure extends RoundedPolylineConnection {

	public MessageFlowFigure() {
		System.err.println("warning: sequence flow default constructor used");
		init();
	}
	
	/**
	 * create new message flow figure
	 * 
	 * @param useColor	use Color?
	 */
	public MessageFlowFigure(boolean useColor) {
		setUseColor(useColor);
		init();
	}
	
	private void init() {
//		this.setForegroundColor(ColorConstants.black);
		this.setLineStyle(org.eclipse.draw2d.Graphics.LINE_CUSTOM);
		setLineDash(new int[]{6,6});
		setTargetDecoration(createTargetDecoration());
		setSourceDecoration(createSourceDecoration());
	}

	/**
	 * create and return new message flow target decoration
	 */
	private PolygonDecoration createTargetDecoration() {
		PolygonDecoration df = new PolygonDecoration();
		df.setFill(true);
		df.setBackgroundColor(ColorConstants.white);
		PointList pl = new PointList();
		pl.addPoint(0, 0);
		pl.addPoint(-2, -1);
		pl.addPoint(-2, 1);
		df.setTemplate(pl);
		return df;
	}
	
	/**
	 * create new message flow source devoration
	 */
	private PolygonDecoration createSourceDecoration() {
		PolygonDecoration df = new PolygonDecoration();
		df.setFill(true);
		df.setBackgroundColor(ColorConstants.white);
		PointList pl = new PointList();
		pl.addPoint(-3, 0);
		pl.addPoint(-2, 2);
		pl.addPoint(0, 3);
		pl.addPoint(2, 2);
		pl.addPoint(3, 0);
		pl.addPoint(2, -2);
		pl.addPoint(0, -3);
		pl.addPoint(-2, -2);
		df.setTemplate(pl);
		df.setScale(1, 1);
		return df;
	}
	
	//OTHER STUFF

	private boolean myUseLocalCoordinates = false;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

	
	// COLORING
	
	public Color FOREGROUND_COLORED= ColorConstants.black;
	public Color FOREGROUND_MONOCHROME= ColorConstants.black;
	
	public Color foreground= FOREGROUND_MONOCHROME;
	
	public void setUseColor(boolean useColor) {
		this.setForegroundColor(useColor ? FOREGROUND_COLORED : FOREGROUND_MONOCHROME);
		this.repaint();
	}
}