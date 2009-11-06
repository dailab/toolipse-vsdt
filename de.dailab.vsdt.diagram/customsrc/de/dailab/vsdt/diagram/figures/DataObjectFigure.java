package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

/**
 * figure for the BPMN object data object
 */
public class DataObjectFigure extends RectangleFigure {

	/**
	 * create new data object figure
	 */
	public DataObjectFigure() {
		init();
	}
	
	private void init() {
		setFill(false);
		setOutline(false);
		setPreferredSize(new Dimension(30,41));
		setForegroundColor(FigureHelper.getForeground(this));
		setBackgroundColor(FigureHelper.getBackground(this));
		createContents();
	}

	/**
	 * create contents
	 */
	private void createContents() {
		Polygon fileFig = new Polygon();
		fileFig.setFill(true);
		fileFig.addPoint(new Point(5, 0));
		fileFig.addPoint(new Point(25, 0));
		fileFig.addPoint(new Point(35, 10));
		fileFig.addPoint(new Point(35, 40));
		fileFig.addPoint(new Point(5, 40));
		this.add(fileFig,null);
		
		Polyline dogEarFig = new Polyline();
		dogEarFig.addPoint(new Point(25, 0));
		dogEarFig.addPoint(new Point(25, 10));
		dogEarFig.addPoint(new Point(35, 10));
		this.add(dogEarFig,null);
	}
	
	//OTHER STUFF

	private boolean myUseLocalCoordinates = true;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}
}
