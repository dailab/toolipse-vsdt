package de.dailab.vsdt.diagram.figures;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.swt.graphics.Color;

import de.dailab.vsdt.DirectionType;


/**
 * custom association figure
 * depending on the direction type none, an error will be shown on none, one or both ends of the connection
 *
 */
public class AssociationFigure extends PolylineConnectionEx {

	private DirectionType directionType= DirectionType.NONE;
	
	/**
	 * this constructor should not be used. 
	 */
	public AssociationFigure() {
		this.directionType= DirectionType.NONE;
		System.err.println("warning: association default constructor used");
		init();
	}
	
	/**
	 * used to initialize the figure after reloading from a file
	 * @param useColor		use Colors?
	 * @param directionType	the direction type
	 */
	public AssociationFigure(boolean useColor, DirectionType directionType) {
		this.directionType= directionType;
		setUseColor(useColor);
		init();
	}
	
	/**
	 * do initialization work for both constructors
	 */
	private void init() {
		this.setForegroundColor(ColorConstants.black);
		this.setLineStyle(org.eclipse.draw2d.Graphics.LINE_CUSTOM);
		setLineDash(new int[]{3,3});
		refreshDecoration();
	}

	/**
	 * create source/target decorations depending on direction
	 */
	public void refreshDecoration() {
		setSourceDecoration(null);
		setTargetDecoration(null);

		if (directionType == DirectionType.FROM) {
			setSourceDecoration(createDecoration());
		}
		if (directionType == DirectionType.TO) {
			setTargetDecoration(createDecoration());
		}
		if (directionType == DirectionType.BOTH) {
			setSourceDecoration(createDecoration());
			setTargetDecoration(createDecoration());
		}
	}

	/**
	 * create the decoration used both for source and target
	 */
	private PolylineDecoration createDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		PointList pl = new PointList();
		pl.addPoint(0, 0);
		pl.addPoint(-2, 1);
		pl.addPoint(0, 0);
		pl.addPoint(-2, -1);
		pl.addPoint(0, 0);
		df.setTemplate(pl);
		return df;
	}

	// OTHER STUFF
	
	public void setDirectionType(DirectionType directionType) {
		this.directionType = directionType;
		this.refreshDecoration();
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
	public Color FOREGROUND_MONOCHROME= ColorConstants.black;
	
	public Color foreground= FOREGROUND_MONOCHROME;
	
	public void setUseColor(boolean useColor) {
		this.setForegroundColor(useColor ? FOREGROUND_COLORED : FOREGROUND_MONOCHROME);
		this.repaint();
	}
	
}