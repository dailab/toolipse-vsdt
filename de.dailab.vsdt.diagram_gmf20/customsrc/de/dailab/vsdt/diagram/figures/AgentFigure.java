package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;

import de.dailab.vsdt.AgentType;


/**
 * figure for an BPMN custom agent artifact
 */
public class AgentFigure extends RectangleFigure {

	private AgentType type= null;
	
	/**
	 * this constructor should not be used. 
	 */
	public AgentFigure() {
		this.type= AgentType.AGENT;
		System.err.println("warning: agent default constructor used");
		init();
	}
	
	/**
	 * 
	 * @param type	the agent type (e.g. platform, agent, agentrole, ...)
	 */
	public AgentFigure(AgentType type) {
		this.type= type;
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
		switch (type.getValue()) {
		case AgentType.AGENT_VALUE:
			//draw agent
			this.setPreferredSize(40,40);
			g.setBackgroundColor(ColorConstants.black);
			g.fillOval(b.x+15, b.y, 11, 11);
			g.fillOval(b.x+10, b.y+15, 21, 21);
			g.fillRectangle(b.x+10, b.y+25, 21, 15);
			break;
		case AgentType.PLATFORM_VALUE:
			//draw platform
			this.setPreferredSize(100,50);
			g.setForegroundColor(ColorConstants.black);
			g.setBackgroundColor(ColorConstants.white);
			int[] points= {b.x+20,b.y+10,b.x+99,b.y+10,b.x+80,b.y+49,b.x,b.y+49};
			g.fillPolygon(points);
			g.drawPolygon(points);
			//draw ams
			g.setBackgroundColor(ColorConstants.black);
			g.fillOval(b.x+30, b.y+5, 11, 11);
			g.fillOval(b.x+25, b.y+20, 21, 21);
			g.fillOval(b.x+20, b.y+20, 7, 7);
			g.fillOval(b.x+44, b.y+20, 7, 7);
			g.fillPolygon(new int[]{b.x+35,b.y+25,b.x+46,b.y+20,b.x+48,b.y+26,b.x+35,b.y+30});
			g.fillPolygon(new int[]{b.x+35,b.y+25,b.x+24,b.y+20,b.x+22,b.y+26,b.x+35,b.y+30});
			g.fillRectangle(b.x+25, b.y+30, 21, 15);
			break;
		case AgentType.ROLE_VALUE:
			//draw agent
			this.setPreferredSize(40,40);
			g.setBackgroundColor(ColorConstants.black);
			g.fillOval(b.x+15, b.y, 11, 11);
			g.fillOval(b.x+10, b.y+15, 21, 21);
			g.fillRectangle(b.x+10, b.y+25, 21, 15);
			g.setBackgroundColor(ColorConstants.white);
			g.fillOval(b.x+16, b.y+1, 9, 9);
			g.fillOval(b.x+11, b.y+16, 19, 19);
			g.fillRectangle(b.x+11, b.y+26, 19, 13);
			break;
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
	
	public void setType(AgentType type) {
		this.type= type;
	}

}