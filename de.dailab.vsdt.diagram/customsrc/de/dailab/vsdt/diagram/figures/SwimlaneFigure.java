package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.OneLineBorder;

import de.dailab.vsdt.Pool;



/**
 * figure for the BPMN elements Lane and Pool
 */
public class SwimlaneFigure extends RectangleFigure {

	private boolean boundaryVisible= true;
	
	private boolean isPool= true;
	
	private final Pool pool;
	
	/**
	 * this constructor should not be used. 
	 */
	public SwimlaneFigure() {
		System.err.println("warning: swimlane default constructor used");
		this.pool = null;
		init();
	}
	
	/**
	 * @param isPool			is Pool or Lane?
	 * @param boundaryVisible	whether the boundary shall be visible
	 * @param pool				the pool, if it is a pool, else null
	 */
	public SwimlaneFigure(boolean isPool, boolean boundaryVisible, Pool pool) {
		this.boundaryVisible= boundaryVisible;
		this.isPool= isPool;
		this.pool = pool;
		init();
	}
	
	/**
	 * do initialization work for both constructors
	 */
	private void init() {
		setLayoutManager(new BorderLayout());
		createContents();
		setForegroundColor(FigureHelper.getForeground(this));
		setBackgroundColor(FigureHelper.getBackground(this, isPool));
		setFill(false);		// filling is done in the paintFigure method
		setOutline(isPool);
		setBoundaryVisible(boundaryVisible);
	}

	/**
	 * create label and compartment figure
	 */
	private void createContents() {
		_swimlaneNamefigure= new VerticalLabel2();
		_swimlaneNamefigure.setText("");
		this.add(_swimlaneNamefigure, BorderLayout.LEFT);
		
		_swimlaneCompartmentfigure = new RectangleFigure();
		_swimlaneCompartmentfigure.setFill(false);
		_swimlaneCompartmentfigure.setOutline(false);
		this.add(_swimlaneCompartmentfigure, BorderLayout.CENTER);
	}
	
	@Override
	public void paintFigure(Graphics g) {
		super.paintFigure(g);
		if (isPool && boundaryVisible) {
			FigureHelper.drawGradient(g, getBounds(), FigureHelper.getBackground(this, isPool), ColorConstants.white, true);
		}
	}
	
	/**
	 * set the boundary to be visible or hidden
	 * 
	 * @param boundaryVisible	new value for boundary visibility
	 */
	public void setBoundaryVisible(boolean boundaryVisible) {
		this.boundaryVisible= boundaryVisible;
		this.setForegroundColor(boundaryVisible ? FigureHelper.getForeground(this, isPool) : ColorConstants.lightGray);
		if (_swimlaneNamefigure != null) {
//			_swimlaneNamefigure.setVisible(boundaryVisible);
			_swimlaneNamefigure.setBorder(boundaryVisible ? new OneLineBorder(1, PositionConstants.RIGHT) : null);
		}
		if (isPool) {
			this.setBorder(boundaryVisible ? new LineBorder() : null);
		}
	}
	
	@Override
	public IFigure getToolTip() {
		String text = FigureHelper.getToolTipText(pool);
		return text != null ? new Label(text) : super.getToolTip();
	}


	// INNER FIGURES
	
	private VerticalLabel2 _swimlaneNamefigure;

	public VerticalLabel2 getSwimlaneNameFigure() {
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

}
