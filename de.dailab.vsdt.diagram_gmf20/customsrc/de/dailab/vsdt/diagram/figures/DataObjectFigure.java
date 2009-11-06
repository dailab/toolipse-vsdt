package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Color;

/**
 * figure for the BPMN object data object
 */
public class DataObjectFigure extends RectangleFigure {

	/**
	 * create new data object figure
	 * @param useColor		use colors?
	 */
	public DataObjectFigure() {
		System.err.println("warning: data object default constructor used");
		init();
	}
	
	/**
	 * @param useColor	Use Color?
	 */
	public DataObjectFigure(boolean useColor) {
		setUseColor(useColor);
		init();
	}
	
	private void init() {
		this.setFill(false);
		this.setOutline(false);
		setPreferredSize(new Dimension(30,41));
		createContents();
	}

	/**
	 * create contents
	 */
	private void createContents() {
		Polygon fileFig = new Polygon();
		fileFig.setFill(true);
		this.setForegroundColor(foreground);
		this.setBackgroundColor(background);
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

	
	// COLORING
	
	public Color FOREGROUND_COLORED= ColorConstants.black;
	public Color BACKGROUND_COLORED= new Color(null, 240, 240, 240);
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
