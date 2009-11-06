package de.dailab.vsdt.diagram.figures;


import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

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
	 * @param directionType	the direction type
	 */
	public AssociationFigure(DirectionType directionType) {
		this.directionType= directionType;
		init();
	}
	
	/**
	 * do initialization work for both constructors
	 */
	private void init() {
		setLineStyle(org.eclipse.draw2d.Graphics.LINE_CUSTOM);
		setLineDash(new int[]{3,3});
		setForegroundColor(FigureHelper.getForeground(this));
		refreshDecoration();
	}

	/**
	 * create source/target decorations depending on direction
	 */
	public void refreshDecoration() {
		setSourceDecoration(null);
		setTargetDecoration(null);

		if (directionType == DirectionType.ONE) {
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
	private RotatableDecoration createDecoration() {
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

}