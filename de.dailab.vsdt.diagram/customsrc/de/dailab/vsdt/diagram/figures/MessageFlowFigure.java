package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;

import de.dailab.common.gmf.figures.RoundedPolylineConnection;

/**
 * figure for the bpmn message flow element
 */
public class MessageFlowFigure extends RoundedPolylineConnection {

	/**
	 * create new message flow figure
	 */
	public MessageFlowFigure() {
		init();
	}
	
	private void init() {
		setLineStyle(org.eclipse.draw2d.Graphics.LINE_CUSTOM);
		setLineDash(new int[]{6,6});
		setForegroundColor(FigureHelper.getForeground(this));
		setTargetDecoration(createTargetDecoration());
		setSourceDecoration(createSourceDecoration());
	}

	/**
	 * create and return new message flow target decoration
	 */
	private RotatableDecoration createTargetDecoration() {
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
	private RotatableDecoration createSourceDecoration() {
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

}