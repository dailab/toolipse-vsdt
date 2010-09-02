package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.LoopType;


/**
 * a figure for the BPMN activity object, including subprocesses
 * inspired by the GMF tutorial editor
 */
public class ActivityFigure extends RoundedRectangle implements IDecoratableFigure {

	private LoopType loopType= LoopType.NONE;
	
	private ActivityType activityType= ActivityType.NONE;
	
	private boolean adHoc= false;
	
	private boolean isTransaction= false;
	
	private boolean isCompensation= false;
	
	private boolean isSubprocess= false;
	
	private boolean hasAssignments= false;
	
	private boolean hasProperties= false;
	
	private boolean eventedSubprocess = false;
	
	private int depth= 0;
	
	private IFigureDecorator decorator;
	
	
	/**
	 * this constructor should not be used. 
	 */
	public ActivityFigure() {
		System.err.println("warning: activity default constructor used");
		init();
	}
	
	/**
	 * @param loopType				the loop type
	 * @param activityType			the activity type
	 * @param adHoc					whether the activity is adHoc
	 * @param isTransaction			whether it is a transaction
	 * @param isCompensation		whether it is a compensation
	 * @param hasAssignments		whether the activity has assignments
	 * @param hasProperties			whether the activity has properties 
	 * @param isEventedSubprocess	whether the activity is an evented subprocess
	 * @param depth					depth of containment of this activity
	 */
	public ActivityFigure(
			LoopType loopType,
			ActivityType activityType,
			boolean adHoc, 
			boolean isTransaction, 
			boolean isCompensation,
			boolean hasAssignments,
			boolean hasProperties,
			boolean isEventedSubprocess,
			int depth) {
		setDepth(depth);
		init();
		setLoopType(loopType);
		setActivityType(activityType);
		setAdHoc(adHoc);
		setTransaction(isTransaction);
		setCompensation(isCompensation);
		setHasAssignments(hasAssignments);
		setHasProperties(hasProperties);
		setEventedSubprocess(isEventedSubprocess);
	}
	
	/**
	 * do initialization work for both constructors
	 */
	private void init() {
		setFill(true);
		setCornerDimensions(new Dimension(20,20));
		createContents();
		createInnerFigures();
		setForegroundColor(FigureHelper.getForeground(this, depth));
		setBackgroundColor(FigureHelper.getBackground(this, depth));
	}
	
	/**
	 * create the label, compartment, decoration and border figures
	 */
	private void createContents() {
		
		// border
		MarginBorder border= new MarginBorder(7, 7, 7, 7);
		setBorder(border);
		
		// wrap label for the name
		_activityNameLabel= new WrappingLabel();
		_activityNameLabel.setTextJustification(PositionConstants.CENTER);
		_activityNameLabel.setTextWrap(true);
//		_activityNameLabel.setBorder(new LineBorder(ColorConstants.green));
		
		//label figure, holding the label (for better size control)
		_labelFigure = new RectangleFigure();
		_labelFigure.setLayoutManager(new BorderLayout());
		_labelFigure.setFill(false);
		_labelFigure.setOutline(false);
		_labelFigure.add(_activityNameLabel,BorderLayout.CENTER);
//		_labelFigure.setBorder(new LineBorder(ColorConstants.red));
		this.add(_labelFigure,null);
		
		//compartment figure
		_compFigure = new RectangleFigure();
		_compFigure.setOutline(false);
		_compFigure.setFill(false);
		this.add(_compFigure);
	}

	/**
	 * create the symbols showing the types
	 */
	public void createInnerFigures() {
		//hide compartment and expand label, if not embedded
		if (activityType == ActivityType.EMBEDDED) {
			_labelFigure.setMaximumSize(new Dimension(300,15)); //allows for one line of text
			getActivityCompartmentFigure().setVisible(true);
			_activityNameLabel.setTextWrap(false);
		} else {
			_labelFigure.setMaximumSize(null); //allows for some lines of text
			_labelFigure.setMinimumSize(new Dimension(30,15));
			_compFigure.setVisible(false);
			_activityNameLabel.setTextWrap(true);
		}
	}
	
	/**
	 * draw double border, when activity is a transaction
	 */
	@Override
	public void paintFigure(Graphics g) {
		super.paintFigure(g);
		
		// set border style

		if ((activityType == ActivityType.EMBEDDED) && eventedSubprocess) {
			this.setLineDash(new float[] {5, 5});
			this.setLineStyle(SWT.LINE_CUSTOM);
		} else {
			this.setLineStyle(SWT.LINE_SOLID);
			this.setLineDash(null);
		}
		this.setLineWidth(activityType == ActivityType.CALL ? 3 : 1);
		
		g.setLineStyle(SWT.LINE_SOLID);
		
		Rectangle b= getBounds();
		// draw transaction border
		int t= 4;								// transaction border spacing
		int r= 20;								// transaction rounding
		if (isSubprocess && isTransaction) {
			//draw double border
		    g.drawRoundRectangle(b.getCopy().shrink(t, t), r, r);
		}
		// draw markers
		int n= getNoOfMarkers();				// number of markers
		int s= 12;								// side of marker
		int m= 3;								// margin between markers
		int x= b.x + (b.width-n*s-(n-1)*m)/2;	// x position of marker
		int y= b.y + b.height-s-m;				// y position of marker
		y= isTransaction ? y-t : y;
		g.setLineWidth(2);
		if (isSubprocess) {
			g.setLineWidth(1);
			g.drawRectangle(x,y,s-1,s-1);
			g.setLineWidth(2);
			g.drawLine(x+s/2, y+s/6, x+s/2, y+s-s/6);
			g.drawLine(x+s/6, y+s/2, x+s-s/6, y+s/2);
			x+= s + m;
		}
		if (adHoc) {
			g.drawArc(x, y+s/4, s/2, s/2, 0, 180);
			g.drawArc(x+s/2, y+s/4, s/2, s/2, 180, 180);
			x+= s + m;
		}
		if (loopType == LoopType.STANDARD) {
			g.drawArc(x, y, s, s, 300, 300);
			g.drawLine(x, y+s, x+s/3, y+s);
			g.drawLine(x+s/3, y+2*s/3, x+s/3, y+s);
			x+= s + m;
		}
		if (loopType == LoopType.MULTIINSTANCE) {
			g.drawLine(x+s/6, y, x+s/6, y+s);
			g.drawLine(x+s/2, y, x+s/2, y+s);
			g.drawLine(x+s-s/6, y, x+s-s/6, y+s);
			x+= s + m;
		}
		if (isCompensation) {
			g.setLineWidth(1);
			g.drawPolygon(new int[] {x+s/2,y, x+s/2,y+s, x,y+s/2});
			g.drawPolygon(new int[] {x+s,y, x+s,y+s, x+s/2,y+s/2});
			g.setLineWidth(2);
			x+= s + m;
		}
		if (FigureHelper.isUseActivityIcons()) {
			int imgSize= 14;
			int marginX= 3;
			int marginY= 3;
			if (activityType != ActivityType.NONE && activityType != ActivityType.EMBEDDED && activityType != ActivityType.CALL) {
				Image icon= FigureHelper.getIcon(activityType.getName().toLowerCase());
				if (icon != null) {
					// marker at top-right corner (VSDT's own)
					g.drawImage(icon, b.x + b.width - imgSize - marginX, b.y + marginY);
					// marker at top-left corner (standard since BPMN 2.0)
	//				g.drawImage(icon, b.x + marginX, b.y + marginY);
				}
			}
			if (hasProperties) {
				Image icon= FigureHelper.getIcon("property");
				g.drawImage(icon, b.x + marginX, b.y + b.height - imgSize - marginY);
			}
			if (hasAssignments) {
				Image icon= FigureHelper.getIcon("assignment");
				g.drawImage(icon, b.x + b.width - imgSize - marginX, b.y + b.height - imgSize - marginY);
			}
		}
		// decorate figure
		if (decorator != null) {
			decorator.decorateFigure(this, g);
		}
	}
	
	private int getNoOfMarkers() {
		int n= 0;
		if (isSubprocess) n++;
		if (adHoc) n++;
		if (isCompensation) n++;
		if (loopType != LoopType.NONE) n++;
		return n;
	}
	 
	// EMBEDDED FIGURES

	private RectangleFigure _labelFigure;
	
	private WrappingLabel _activityNameLabel;
	
	public WrappingLabel getActivityNameLabel() {
		return _activityNameLabel;
	}

	private RectangleFigure _compFigure;
	
	public RectangleFigure getActivityCompartmentFigure() {
		return _compFigure;
	}
	
	// SETTERS FOR ACTIVITY ATTRIBUTES
	
	public void setLoopType(LoopType loopType) {
		this.loopType = loopType;
		this.createInnerFigures();
	}
	
	public void setActivityType(ActivityType activityType) {
		this.activityType= activityType;
		isSubprocess= activityType == ActivityType.EMBEDDED;
		// TODO set subprocess flag also if called element is subprocess
		this.createInnerFigures();
	}
	
	public void setAdHoc(boolean adHoc) {
		this.adHoc = adHoc;
		this.createInnerFigures();
	}
	
	public void setTransaction(boolean transaction) {
		this.isTransaction = transaction;
	}
	
	public void setCompensation(boolean compensation) {
		this.isCompensation= compensation;
		this.createInnerFigures();
	}

	public void setHasAssignments(boolean hasAssignments) {
		this.hasAssignments = hasAssignments;
	}
	
	public void setHasProperties(boolean hasProperties) {
		this.hasProperties = hasProperties;
	}
	
	public void setEventedSubprocess(boolean isEventedSubprocess) {
		this.eventedSubprocess = isEventedSubprocess;
		repaint();
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}

	public void setDecorator(IFigureDecorator decorator) {
		this.decorator= decorator;
	}
	
	public IFigureDecorator getDecorator() {
		return decorator;
	}
	
	// COLORING
	
	public static final Color FOREGROUND= ColorConstants.black;
	public static final Color BACKGROUND_COLORED= new Color(null, 250, 250, 250);
	public static final Color BACKGROUND_COLORED_ALTERNATIVE= new Color(null, 240, 240, 240);
	public static final Color BACKGROUND_MONOCHROME= ColorConstants.white;
	
	
	// GMF GENERATED SETTERS
	
	private boolean myUseLocalCoordinates = false;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

}
