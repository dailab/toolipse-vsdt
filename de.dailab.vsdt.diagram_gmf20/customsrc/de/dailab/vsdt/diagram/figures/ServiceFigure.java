package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * figure for an bpmn custom service artifact
 */
public class ServiceFigure extends RectangleFigure {

	private boolean hasUser= false;
	
	private boolean isMultiple= false;
	
	/**
	 * this constructor should not be used. 
	 */
	public ServiceFigure() {
		System.err.println("warning: service default constructor used");
		init();
	}
	
	/**
	 * 
	 * @param type	the agent type (e.g. platform, agent, agentrole, ...)
	 */
	public ServiceFigure(boolean hasUser, boolean isMultiple) {
		this.hasUser= hasUser;
		this.isMultiple= isMultiple;
		init();
	}
	
	/**
	 * initialization work for both constructors
	 */
	private void init() {
		this.setOutline(false);
		this.setFill(false);
	}
		
	@Override
	public void paintFigure(Graphics g) {
		super.paintFigure(g);
		Rectangle b= getBounds();

		this.setPreferredSize(40,40);
		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(ColorConstants.black);
		
		//draw basic figure
		g.drawArc(b.x, b.y, 39, 39, 0, 60);
		g.drawArc(b.x, b.y, 39, 39, 120, 60);
		g.drawArc(b.x, b.y, 39, 39, 240, 60);

		g.fillOval(b.x+30+3, b.y+20, 4, 4);
		g.fillOval(b.x+30+1, b.y+20+5, 8, 8);
		g.fillRectangle(b.x+30+1, b.y+20+9, 8, 6);
		
		if (hasUser) {
			//draw user marker
			g.fillOval(b.x+15+3, b.y, 4, 4);
			g.fillOval(b.x+15+1, b.y+5, 8, 8);
			g.fillRectangle(b.x+15+1, b.y+9, 8, 6);
			g.drawLine(b.x+23, b.y+16, b.x+30, b.y+25);
		}
		if (isMultiple) {
			//draw multiple marker
			g.fillOval(b.x+3, b.y+20, 4, 4);
			g.fillOval(b.x+1, b.y+20+5, 8, 8);
			g.fillRectangle(b.x+1, b.y+20+9, 8, 6);
			g.drawLine(b.x+17, b.y+16, b.x+10, b.y+25);
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
	
	public void setMultiple(boolean isMultiple) {
		this.isMultiple = isMultiple;
	}
	
	public void setHasUser(boolean hasUser) {
		this.hasUser = hasUser;
	}

}