package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RectangularDropShadowLineBorder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

import de.dailab.common.gmf.ui.figures.VerticalLabel;



/**
 * figure for the BPMN elements Lane and Pool
 */
public class SwimlaneFigure extends RectangleFigure {

	private RectangularDropShadowLineBorder border= new RectangularDropShadowLineBorder();
	private OneLineBorder nameBorder= new OneLineBorder(1, PositionConstants.RIGHT);
	
	private boolean boundaryVisible= true;
	
	private boolean isPool= true;
	
	/**
	 * this constructor should not be used. 
	 */
	public SwimlaneFigure() {
		this.boundaryVisible= true;
		System.err.println("warning: swimlane default constructor used");
		init();
	}
	
	/**
	 * @param useColor			use colors?
	 * @param isPool			is Pool or Lane?
	 * @param boundaryVisible	whether the boundary shall be visible
	 */
	public SwimlaneFigure(boolean useColor, boolean isPool, boolean boundaryVisible) {
		this.boundaryVisible= boundaryVisible;
		this.isPool= isPool;
		setUseColor(useColor);
		init();
	}
	
	/**
	 * do initialization work for both constructors
	 */
	private void init() {
		this.setLayoutManager(new BorderLayout());
		this.createContents();
		this.setBoundaryVisible(boundaryVisible);
	}

	/**
	 * create label and compartment figure
	 */
	private void createContents() {
		_swimlaneNamefigure= new VerticalLabel();
		_swimlaneNamefigure.setText("<...>");
		this.add(_swimlaneNamefigure, BorderLayout.LEFT);
		
		_swimlaneCompartmentfigure = new RectangleFigure();
		_swimlaneCompartmentfigure.setFill(false);
		_swimlaneCompartmentfigure.setOutline(false);
		this.add(_swimlaneCompartmentfigure, BorderLayout.CENTER);
	}
	
	
	/**
	 * set the boundary to be visible or hidden
	 * 
	 * @param boundaryVisible	new value for boundary visibility
	 */
	public void setBoundaryVisible(boolean boundaryVisible) {
		this.boundaryVisible= boundaryVisible;
		this.setFill(boundaryVisible);
		this.setLineStyle( boundaryVisible ? SWT.LINE_SOLID : SWT.LINE_DASH);
		this.setForegroundColor(boundaryVisible ? foreground : FOREGROUND_HIDDEN);
		this.setBackgroundColor(boundaryVisible ? background : BACKGROUND_HIDDEN);
		if (_swimlaneNamefigure != null) {
			_swimlaneNamefigure.setVisible(boundaryVisible);
			_swimlaneNamefigure.setBorder(boundaryVisible ? nameBorder : null);
		}
		if (isPool) {
			this.setBorder(boundaryVisible ? border : null);
		}
	}
	

	// INNER FIGURES
	
	private VerticalLabel _swimlaneNamefigure;

	public VerticalLabel getSwimlaneNameFigure() {
		return _swimlaneNamefigure;
	}
	
	private RectangleFigure _swimlaneCompartmentfigure;

	public RectangleFigure getSwimlaneCompartmentFigure() {
		return _swimlaneCompartmentfigure;
	}

	// GMF GENERATED SETTERS
	
	protected boolean myUseLocalCoordinates = false;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

	
	// COLORING
	
	public Color FOREGROUND_COLORED= new Color(null, 0, 0, 0);
	public Color BACKGROUND_COLORED= new Color(null, 240, 245, 255);
	public Color FOREGROUND_MONOCHROME= ColorConstants.black;
	public Color BACKGROUND_MONOCHROME= ColorConstants.white;
	public Color FOREGROUND_HIDDEN = ColorConstants.lightGray;
	public Color BACKGROUND_HIDDEN = ColorConstants.white;
	
	public Color foreground= FOREGROUND_MONOCHROME;
	public Color background= BACKGROUND_MONOCHROME;
	
	public void setUseColor(boolean useColor) {
		foreground= useColor ? FOREGROUND_COLORED : FOREGROUND_MONOCHROME;
		background= useColor ? BACKGROUND_COLORED : BACKGROUND_MONOCHROME;
		setForegroundColor(foreground);
		setBackgroundColor(background);
		border.setColor(foreground);
		nameBorder.setColor(foreground);
		this.repaint();
	}
}
