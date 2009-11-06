package de.dailab.vsdt.diagram.figures;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.LoopType;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;


/**
 * a figure for the BPMN activity object, including subprocesses
 * inspired by the GMF tutorial editor
 */
public class ActivityFigure extends RoundedRectangle {
	
	/** this list is used to cache the activity icons */ 
	public static Map<String, Image> activityIcons= new HashMap<String, Image>();
	
	private LoopType loopType= LoopType.NONE;
	
	private ActivityType activityType= ActivityType.NONE;
	
	private boolean adHoc= false;
	
	private boolean isTransaction= false;
	
	private boolean isCompensation= false;
	
	private boolean isSubprocess= false;
	
	private boolean useIcons= false;
	
	private boolean hasAssignments= false;
	
	private boolean hasProperties= false;
	
	private int depth= 0;
	
	
	/**
	 * this constructor should not be used. 
	 */
	public ActivityFigure() {
		System.err.println("warning: activity default constructor used");
		init();
	}
	
	/**
	 * @param useColor			use colors?
	 * @param useIcons			use Activity Icons?
	 * @param loopType			the loop type
	 * @param activityType		the activity type
	 * @param adHoc				whether the activity is adHoc
	 * @param isTransaction		whether it is a transaction
	 * @param isCompensation	whether it is a compensation
	 * @param hasAssignments	whether the activity has assignments
	 * @param hasProperties		whether the activity has properties 
	 * @param depth				depth of containment of this activity
	 */
	public ActivityFigure(
			boolean useColor,
			boolean useIcons,
			LoopType loopType,
			ActivityType activityType,
			boolean adHoc, 
			boolean isTransaction, 
			boolean isCompensation,
			boolean hasAssignments,
			boolean hasProperties,
			int depth) {
		setDepth(depth);
		setUseColor(useColor);
		setUseIcons(useIcons);
		init();
		setLoopType(loopType);
		setActivityType(activityType);
		setAdHoc(adHoc);
		setTransaction(isTransaction);
		setCompensation(isCompensation);
		setHasAssignments(hasAssignments);
		setHasProperties(hasProperties);
	}
	
	/**
	 * do initialization work for both constructors
	 */
	private void init() {
		this.setFill(true);
		this.setCornerDimensions(new Dimension(20,20));
		createContents();
		createInnerFigures();
	}
	
	/**
	 * create the label, compartment, decorator and border figures
	 */
	private void createContents() {
		
		// border
		MarginBorder border= new MarginBorder(5, 10, 5, 10);
		setBorder(border);
		
		// wrap label for the name
		_activityNameLabel= new WrapLabel();
		_activityNameLabel.setTextAlignment(PositionConstants.CENTER);
		_activityNameLabel.setTextWrap(true);
		
		//label figure, holding the label (for better size control)
		_labelFigure = new RectangleFigure();
		_labelFigure.setLayoutManager(new BorderLayout());
		_labelFigure.setFill(false);
		_labelFigure.setOutline(false);
		_labelFigure.add(_activityNameLabel,BorderLayout.CENTER);
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
		g.setForegroundColor(foreground);
		g.setBackgroundColor(foreground);
		
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
			g.drawLine(x+s/3, y, x+s/3, y+s);
			g.drawLine(x+2*s/3, y, x+2*s/3, y+s);
			x+= s + m;
		}
		if (isCompensation) {
			g.fillPolygon(new int[] {x+s/2,y, x+s/2,y+s, x,y+s/2});
			g.fillPolygon(new int[] {x+s,y, x+s,y+s, x+s/2,y+s/2});
			x+= s + m;
		}
		if (useIcons) {
			int imgSize= 14;
			int margin= 3;
			Image icon= getIcon(activityType.getName().toLowerCase());
			if (icon != null) {
				g.drawImage(icon, b.x + b.width - imgSize - margin, b.y + margin);
			}
			if (hasProperties) {
				icon= getIcon("property");
				g.drawImage(icon, b.x + margin, b.y + b.height - 10 - margin);
			}
			if (hasAssignments) {
				icon= getIcon("assignment");
				g.drawImage(icon, b.x + b.width - 14 - margin, b.y + b.height - 10 - margin);
			}
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
	
	private WrapLabel _activityNameLabel;
	
	public WrapLabel getActivityNameLabel() {
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
		isSubprocess= activityType == ActivityType.EMBEDDED || activityType == ActivityType.INDEPENDENT || activityType == ActivityType.SUBPROCESSREFERENCE;
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

	public void setUseIcons(boolean useIcons) {
		this.useIcons = useIcons;
		repaint();
	}
	
	public void setHasAssignments(boolean hasAssignments) {
		this.hasAssignments = hasAssignments;
	}
	
	public void setHasProperties(boolean hasProperties) {
		this.hasProperties = hasProperties;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	// COLORING
	
	public Color FOREGROUND_COLORED= new Color(null, 64, 64, 128);
	public Color BACKGROUND_COLORED= new Color(null, 250, 250, 250);
	public Color BACKGROUND_COLORED_ALTERNATIVE= new Color(null, 240, 240, 240);
	public Color FOREGROUND_MONOCHROME= ColorConstants.black;
	public Color BACKGROUND_MONOCHROME= ColorConstants.white;
	
	public Color foreground= FOREGROUND_MONOCHROME;
	public Color background= BACKGROUND_MONOCHROME;
	
	/**
	 * Set the foreground and background colors according to whether the use of color
	 * is requested or not.
	 * 
	 * @param useColor		use-Color option activated?
	 */
	public void setUseColor(boolean useColor) {
		this.setForegroundColor(useColor ? FOREGROUND_COLORED : FOREGROUND_MONOCHROME);
		this.setBackgroundColor(useColor ? (depth % 2 == 0 ? BACKGROUND_COLORED : BACKGROUND_COLORED_ALTERNATIVE) : BACKGROUND_MONOCHROME);
		this.repaint();
	}
	
	// ICONS
	
	/**
	 * Sets the activityIcon field to the image appropriate for the current activity type.
	 * The images are stored in a static map, so they do not have to be reloaded on each 
	 * change of the activity type and for each individual activity.
	 */
	protected Image getIcon(String key) {
		Image icon= activityIcons.get(key);
		if (icon == null) {
			String path= "icons/activityIcons/" + key + ".gif";
			ImageDescriptor descriptor= VsdtDiagramEditorPlugin.imageDescriptorFromPlugin(VsdtDiagramEditorPlugin.ID, path);
			if (descriptor != null) {
				icon= descriptor.createImage();
				activityIcons.put(key, icon);
		    } else {
		        System.err.println("Could not find file: " + path);
			}			
		}
		return icon;
	}
	
	// GMF GENERATED SETTERS
	
	private boolean myUseLocalCoordinates = false;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

}
