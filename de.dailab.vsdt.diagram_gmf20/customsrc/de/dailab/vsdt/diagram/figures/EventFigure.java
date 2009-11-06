package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

import de.dailab.vsdt.TriggerType;

/**
 * BPMN Event Figure
 * 
 * @author kuester
 */
public class EventFigure extends Ellipse {

	public static final int START= 0;
	public static final int INTERMEDIATE= 1;
	public static final int END= 2;
	
	private int eventType= START;
	private int triggerType= TriggerType.NONE_VALUE;

	private IFigure triggerFigure= null;
	
	/**
	 * this constructor should not be used. 
	 */
	public EventFigure() {
		this.eventType= START;
		this.triggerType= TriggerType.NONE_VALUE;
		System.err.println("warning: event default constructor used");
		init();
	}
	
	/**
	 * @param useColor		use colors?
	 * @param eventtype		the event type; one of START, INTERMEDIATE, or END
	 * @param triggerType	the trigger type to be shown
	 */
	public EventFigure(boolean useColor, int eventType, int triggerType) {
		this.eventType= eventType;
		this.triggerType= triggerType;
		setUseColor(useColor);
		init();
	}
	
	/**
	 * common initialization work
	 */
	private void init() {
		this.setLayoutManager(new XYLayout());
		createContents();
		createInnerFigure();
	}

	/**
	 * create contents
	 */
	private void createContents() {
		Ellipse innerFig= null;
		Rectangle layoutdata = new Rectangle();
		layoutdata.x = 5;
		layoutdata.y = 5;
		layoutdata.width = 30;
		layoutdata.height = 30;
		switch (eventType) {
		case START:
			break;
		case INTERMEDIATE:
			innerFig = new Ellipse();
			innerFig.setFill(false);
			this.add(innerFig, layoutdata);	
			break;
		case END: 
			this.setBackgroundColor(foreground);
			innerFig = new Ellipse();
			innerFig.setForegroundColor(background);
			innerFig.setBackgroundColor(background);
			this.add(innerFig, layoutdata);
			break;
		}
	}
	
	/**
	 * create the symbols inner figure showing the type
	 */
	public void createInnerFigure() {
		//remove old figure
		if (triggerFigure != null) {
			remove(triggerFigure);
		}

		//get new figure
		IFigure figure = null;
		FigureProvider fp = new FigureProvider(foreground, background, 10, 10);
		switch (triggerType) {
		case TriggerType.MESSAGE_VALUE: 
			figure = fp.createMessageEventFigure();
			break;
		case TriggerType.TIMER_VALUE: 
			figure = fp.createTimerEventFigure();
			break;
		case TriggerType.ERROR_VALUE: 
			figure = fp.createErrorEventFigure();
			break;
		case TriggerType.CANCEL_VALUE: 
			figure = fp.createCancelEventFigure();
			break;
		case TriggerType.COMPENSATION_VALUE: 
			figure = fp.createCompensationEventFigure();
			break;
		case TriggerType.LINK_VALUE: 
			figure = fp.createLinkEventFigure();
			break;
		case TriggerType.RULE_VALUE: 
			figure = fp.createRuleEventFigure();
			break;
		case TriggerType.MULTIPLE_VALUE: 
			figure = fp.createMultipleEventFigure();
			break;
		case TriggerType.TERMINATE_VALUE:
			figure = fp.createTerminateEventFigure();
			break;
		}

		//set new figure
		triggerFigure= figure;
		
		if (figure != null) {
			add(figure, null);
		}
	}
	

	//OTHER STUFF
	
	private boolean myUseLocalCoordinates = true;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}
	
	public void setTriggerType(int triggerType) {
		this.triggerType = triggerType;
		this.createInnerFigure();
	}

	
	// COLORING
	
	public Color FOREGROUND_COLORED_S= new Color(null, 64, 96, 64);
	public Color FOREGROUND_COLORED_I= new Color(null, 96, 96, 64);
	public Color FOREGROUND_COLORED_E= new Color(null, 96, 64, 64);
	public Color BACKGROUND_COLORED_S= new Color(null, 230, 255, 230);
	public Color BACKGROUND_COLORED_I= new Color(null, 255, 255, 230);
	public Color BACKGROUND_COLORED_E= new Color(null, 255, 230, 230);
	public Color FOREGROUND_MONOCHROME= ColorConstants.black;
	public Color BACKGROUND_MONOCHROME= ColorConstants.white;
	
	public Color foreground= FOREGROUND_MONOCHROME;
	public Color background= BACKGROUND_MONOCHROME;
	
	public void setUseColor(boolean useColor) {
		if (useColor) {
			switch (eventType) {
			case START:
				foreground= FOREGROUND_COLORED_S;
				background= BACKGROUND_COLORED_S;	
				break;
			case INTERMEDIATE:
				foreground= FOREGROUND_COLORED_I;
				background= BACKGROUND_COLORED_I;
				break;
			case END:
				foreground= FOREGROUND_COLORED_E;
				background= BACKGROUND_COLORED_E;
				break;
			}
		} else {
			foreground= FOREGROUND_MONOCHROME;
			background= BACKGROUND_MONOCHROME;
		}
		setForegroundColor(foreground);
		setBackgroundColor(background);
		this.repaint();
	}
}
