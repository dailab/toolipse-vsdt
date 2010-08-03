package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

import de.dailab.vsdt.TriggerType;

/**
 * BPMN Event Figure
 * 
 * @author kuester
 */
public class EventFigure extends Ellipse implements IDecoratableFigure {

	public static final int START= 0;
	public static final int INTERMEDIATE= 1;
	public static final int END= 2;
	
	private int eventType= START;
	private TriggerType triggerType= TriggerType.NONE;
	private boolean throwing;
	private boolean nonInterrupting;
	
	private IFigureDecorator decorator;

	/**
	 * this constructor should not be used. 
	 */
	public EventFigure() {
		this.eventType= START;
		this.triggerType= TriggerType.NONE;
		System.err.println("warning: event default constructor used");
		init();
	}
	
	/**
	 * @param eventtype			the event type; one of START, INTERMEDIATE, or END
	 * @param triggerType		the trigger type to be shown
	 * @param throwing			whether the event is throwing or catching
	 * @param nonInterrupting	whether the event is non-interrupting or not
	 */
	public EventFigure(int eventType, TriggerType triggerType, boolean throwing, boolean nonInterrupting) {
		this.eventType= eventType;
		this.triggerType= triggerType;
		this.throwing= throwing;
		setNonInterrupting(nonInterrupting);
		init();
	}
	
	/**
	 * common initialization work
	 */
	private void init() {
		setForegroundColor(FigureHelper.getForeground(this, eventType));
		setBackgroundColor(FigureHelper.getBackground(this, eventType));
	}
	
	@Override
	public void paintFigure(Graphics g) {
		super.paintFigure(g);

		// abbreviations
		Rectangle b= getBounds();
		int w= b.width;		// overall width of the diamond figure
		int s= 6*w/8;		// width of the inner figure
		int x= b.x + w/8;	// x position of inner figure
		int y= b.y + w/8;	// y position of inner figure
		
		if (nonInterrupting) {
			g.setLineStyle(SWT.LINE_DASH);
		}
		switch (eventType) {
		case START:
			break;
		case INTERMEDIATE:
			g.drawOval(x, y, s, s);
			break;
		case END:
			g.setBackgroundColor(FigureHelper.getForeground(this, eventType));
			g.fillOval(b.x, b.y, w, w);
			g.setBackgroundColor(FigureHelper.getBackground(this, eventType));
			g.fillOval(x, y, s, s);
			break;
		}
		g.setLineStyle(SWT.LINE_SOLID);

		// more abbreviations
		s= w/2;			// width of the trigger figure
		x= b.x + w/4;	// x position of trigger
		y= b.y + w/4;	// y position of trigger
		int s2=s/2, s3=s/3, s4=s/4, s23=2*s/3, s34=3*s/4, s8=s/8, s68=6*s/8, s6=s/6;
		
		g.setBackgroundColor(FigureHelper.getForeground(this, eventType));
		switch (triggerType) {
		case MESSAGE:
			if (throwing) {
				g.fillRectangle(x, y+s8, s, s34);
				g.setForegroundColor(FigureHelper.getBackground(this, eventType));
			}
			g.drawRectangle(x, y+s8, s, s34);
			g.drawLine(x, y+s6, x+s2, y+s2);
			g.drawLine(x+s2, y+s2, x+s, y+s6);
			break;
		case RULE:
			g.drawRectangle(x+s8, y, s68, s);
			g.drawLine(x+s4, y+s4, x+s34, y+s4);
			g.drawLine(x+s4, y+s2, x+s34, y+s2);
			g.drawLine(x+s4, y+s34, x+s34, y+s34);
			break;
		case TIMER:
			g.drawOval(x, y, s, s);
			g.drawLine(x+s2,y, x+s2,y+s8);
			g.drawLine(x+s,y+s2, x+s-s8,y+s2);
			g.drawLine(x+s2,y+s, x+s2,y+s-s8);
			g.drawLine(x,y+s2, x+s8,y+s2);
			g.drawLine(x+s2,y+s2, x+s2+s8,y);
			g.drawLine(x+s2,y+s2, x+s34,y+s2+s8);
			break;
		case LINK:
			int[] arrow= new int[] { x+s23, y, x+s, y+s2, x+s23, y+s,
					x+s23,y+s34, x,y+s34, x,y+s4, x+s23, y+s4};
			if (throwing) {
				g.fillPolygon(arrow);
			} else {
				g.drawPolygon(arrow);
			}
			break;
		case COMPENSATION:
			int[] arrow1= new int[] { x, y+s2, x+s2, y+s8, x+s2, y+s-s8 };
			int[] arrow2= new int[] { x+s2, y+s2, x+s, y+s8, x+s, y+s-s8 };
			if (throwing) {
				g.fillPolygon(arrow1);
				g.fillPolygon(arrow2);
			} else {
				g.drawPolygon(arrow1);
				g.drawPolygon(arrow2);
			}
			break;
		case TERMINATE:
			// for better distinguishing terminate from multiple 
			g.fillOval(x-s8/2, y-s8/2, s+s8, s+s8);
			break;
		case ERROR:
			int[] error= new int[] { x,y+s, x+s4,y+s4, x+s23,y+s2, 
					x+s,y, x+s34,y+s34, x+s3,y+s2 };
			if (throwing) {
				g.fillPolygon(error);
			} else {
				g.drawPolygon(error);
			}
			break;
		case MULTIPLE:
			// BPMN 1.0
//			int[] star= new int[] { x,y+s4, x+s3,y+s4, x+s2,y, x+s23,y+s4,
//					x+s, y+s4, x+4*s/5,y+s2, x+s,y+s34,	x+s23,y+s34, 
//					x+s2,y+s, x+s3,y+s34, x,y+s34, x+s/5,y+s2};
			// BPMN 1.1
			int[] star= new int[] { x,y+s3+s8, x+s2,y, x+s,y+s3+s8, x+s34,y+s-s8, x+s4,y+s-s8};
			if (throwing) {
				g.fillPolygon(star);
			} else {
				g.drawPolygon(star);
			}
			break;
		case CANCEL:
			int[] cross= new int[] {x+s6,y, x+s2,y+s2-s6, x+s-s6,y, x+s, y+s6,
					x+s2+s6,y+s2, x+s,y+s-s6, x+s-s6,y+s, x+s2,y+s2+s6,
					x+s6,y+s, x,y+s-s6, x+s2-s6, y+s2, x,y+s6};
			if (throwing) {
				g.fillPolygon(cross);
			} else {
				g.drawPolygon(cross);
			}
			break;
		case SIGNAL:
			int[] triangle= new int[] {x+s2,y, x+s,y+s-s6, x,y+s-s6};
			if (throwing) {
				g.fillPolygon(triangle);
			} else {
				g.drawPolygon(triangle);
			}
			break;
		case ESCALATION:
			int[] startrek= new int[] {x+s2,y, x+s-s6,y+s-s6, x+s2,y+s-s3, x+s6,y+s-s6};
			if (throwing) {
				g.fillPolygon(startrek);
			} else {
				g.drawPolygon(startrek);
			}
			break;
		}
		// decorate figure
		if (decorator != null) {
			decorator.decorateFigure(this, g);
		}
	}

	public void setDecorator(IFigureDecorator decorator) {
		this.decorator= decorator;
	}
	
	public IFigureDecorator getDecorator() {
		return decorator;
	}
	
	//OTHER STUFF
	
	private boolean myUseLocalCoordinates = true;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}
	
	public void setTriggerType(TriggerType triggerType) {
		this.triggerType = triggerType;
		this.revalidate(); // for boundary event, repaint is not enough
	}
	
	public void setThrowing(boolean throwing) {
		this.throwing = throwing;
		this.revalidate();
	}
	
	public void setNonInterrupting(boolean nonInterrupting) {
		this.nonInterrupting = nonInterrupting;
		if (nonInterrupting) {
			this.setLineStyle(SWT.LINE_DASH);
		} else {
			this.setLineStyle(SWT.LINE_SOLID);
		}
	}
}
