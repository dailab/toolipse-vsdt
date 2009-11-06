package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Color;

import de.dailab.vsdt.GatewayType;


/**
 * create a BPMN gateway figure
 */
public class GatewayFigure extends RectangleFigure {

	private GatewayType gatewayType= GatewayType.XOR_DATA;
	
	private boolean markerVisible= false;
	
	/**
	 * this constructor should not be used. 
	 */
	public GatewayFigure() {
		this.gatewayType= GatewayType.XOR_DATA;
		this.markerVisible= false;
		System.err.println("warning: gateway default constructor used");
		init();
	}
	
	/**
	 * @param useColor		use colors?
	 * @param gatewayType	the gateway's type
	 * @param markerVisible	whether the marker shall be visible
	 */
	public GatewayFigure(boolean useColor, GatewayType gatewayType, boolean markerVisible) {
		this.gatewayType= gatewayType;
		this.markerVisible= markerVisible;
		setUseColor(useColor);
		init();
	}
	
	/**
	 * initialization work for both constructors
	 */
	private void init() {
		this.setLayoutManager(new XYLayout());
		this.setFill(false);
		this.setOutline(false);
		createContents();
		createInnerFigure();
	}

	/**
	 * create the diamond figure
	 */
	private void createContents() {
		Polygon diamondFig = new Polygon();
		diamondFig.setFill(true);

//		diamondFig.setForegroundColor(foreground);
//		diamondFig.setBackgroundColor(background);
		
		diamondFig.addPoint(new Point(20, 0));
		diamondFig.addPoint(new Point(40, 20));
		diamondFig.addPoint(new Point(20, 40));
		diamondFig.addPoint(new Point(0, 20));
		this.add(diamondFig, null);
	}

	/**
	 * create the symbols inner figure showing the type
	 */
	public void createInnerFigure() {
		//remove old figure
		if (innerFigure != null) {
			remove(innerFigure);
		}

		//get new figure
		IFigure figure = null;
		FigureProvider fp = new FigureProvider(foreground, background, 10, 10);
		switch (gatewayType.getValue()) {
		case GatewayType.AND_VALUE: 
			figure = fp.createAndGatewayFigure();
			break;
		case GatewayType.COMPLEX_VALUE: 
			figure = fp.createComplexGatewayFigure();
			break;
		case GatewayType.OR_VALUE: 
			figure = fp.createOrGatewayFigure();
			break;
		case GatewayType.XOR_DATA_VALUE:
			if (markerVisible) {
				figure = fp.createXorDataGatewayFigure();
			}
			break;
		case GatewayType.XOR_EVENT_VALUE: 
			figure = fp.createXorEventGatewayFigure();
			break;
		}

		//set new figure
		innerFigure= figure;
		
		if (figure != null) {
			add(figure, null);
		}
	}
	
	private IFigure innerFigure= null;

	//OTHER STUFF
	
	private boolean myUseLocalCoordinates = true;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}
	
	public void setGatewayType(GatewayType gatewayType, boolean markerVisible) {
		this.gatewayType = gatewayType;
		this.markerVisible= markerVisible;
		this.createInnerFigure();
	}

	
	// COLORING
	
	public Color FOREGROUND_COLORED= new Color(null, 64, 64, 64);
	public Color BACKGROUND_COLORED= new Color(null, 230, 230, 230);
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