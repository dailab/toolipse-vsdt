package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.diagram.preferences.DiagramAppearancePreferencePage;


/**
 * create a BPMN gateway figure
 */
public class GatewayFigure extends RectangleFigure implements IDecoratableFigure {

	private GatewayType gatewayType= GatewayType.XOR_DATA;
	
	private boolean markerVisible= false;
	
	private IFigureDecorator decorator;
	
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
	 * @param gatewayType	the gateway's type
	 */
	public GatewayFigure(GatewayType gatewayType) {
		setGatewayType(gatewayType);
		init();
	}
	
	/**
	 * initialization work for both constructors
	 */
	private void init() {
		setLayoutManager(new XYLayout());
		setFill(false);
		setOutline(false);
		setForegroundColor(FigureHelper.getForeground(this));
		setBackgroundColor(FigureHelper.getBackground(this));
	}

	@Override
	public void paintFigure(Graphics g) {
		super.paintFigure(g);
		g.setForegroundColor(FigureHelper.getForeground(this));
		g.setBackgroundColor(FigureHelper.getBackground(this));
		
		Rectangle b= getBounds();
		int w= b.width;		// overall width of the diamond figure
		int s= w/2;			// width of the marker figure
		int l= 3;			// line width of marker
		int x= b.x;			// x position of diamond
		int y= b.y;			// y position of diamond
		int[] diamond= new int[]{x+s, y, x+w, y+s, x+s, y+w, x, y+s};
		
		g.setLineWidth(1);
		g.fillPolygon(diamond);
		g.drawPolygon(diamond);
		
		// inner figure
		x= x + w/4;			// x position of marker
		y= y + w/4;			// y position of marker
		g.setLineWidth(l);
		switch (gatewayType) {
		case AND: 
			g.drawLine(x+s/2, y,     x+s/2, y+s  );
			g.drawLine(x,     y+s/2, x+s,   y+s/2);
			break;
		case COMPLEX: 
			g.drawLine(x+s/2, y,     x+s/2, y+s  );
			g.drawLine(x,     y+s/2, x+s,   y+s/2);
			g.drawLine(x+l  ,y+l, x+s-l,y+s-l);
			g.drawLine(x+s-l,y+l, x+l,  y+s-l);
			break;
		case OR: 
			g.drawOval(x+s/12, y+s/12, s-s/6, s-s/6);
			break;
		case XOR_DATA:
			if (markerVisible) {
				g.drawLine(x+l  ,y+l, x+s-l,y+s-l);
				g.drawLine(x+s-l,y+l, x+l,  y+s-l);
			}
			break;
		case XOR_EVENT:
			g.setLineWidth(1);
			g.setBackgroundColor(FigureHelper.getForeground(this));
			g.drawOval(x-l, y-l, s+2*l, s+2*l);
			g.drawOval(x-1, y-1, s+2, s+2);
			// BPMN 1.0
//			int[] up=   new int[]{x+s/2, y,   x+s, y+s-s4,   x, y+s-s4  };
//			int[] down= new int[]{x+s/2, y+s, x+s, y+s4, x, y+s4};
//			g.fillPolygon(up);
//			g.fillPolygon(down);
			// BPMN 1.1
			int[] star= new int[] { x+s/6,		y+s/3+s/8, 
									x+s/2,		y+s/6, 
									x+s-s/6,	y+s/3+s/8, 
									x+s-s/4,	y+s-s/4, 
									x+s/4,		y+s-s/4};
			g.drawPolygon(star);
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
	
	public void setGatewayType(GatewayType gatewayType) {
		this.gatewayType = gatewayType;
		this.markerVisible= DiagramAppearancePreferencePage.isShowXorMarkerByDefault();
		this.repaint();
	}
}