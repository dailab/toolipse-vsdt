package de.dailab.vsdt.meta.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;

import de.dailab.vsdt.diagram.preferences.DiagramAppearancePreferencePage;


/**
 * This is the figure used for participants in the VSDT's "meta" diagram.
 * The visuals for this figure are borrowed from the UML usecase diagrams.
 */
public class ParticipantFigure extends RectangleFigure {

	public static final int HEIGHT= 60;
	public static final int WIDTH= 40;
	
	public ParticipantFigure() {
		init();
	}
	
	/**
	 * initialization work for both constructors
	 */
	private void init() {
		this.setOutline(false);
		this.setFill(false);	
		this.setPreferredSize(WIDTH, HEIGHT);
	}
		
	@Override
	public void paintFigure(Graphics g) {
		super.paintFigure(g);
		Rectangle b= getBounds();
		int x= b.x;
		int y= b.y;
		int w= b.width;
		int h= b.height;

		g.setForegroundColor(ColorConstants.black);
		g.setLineWidth(2);
		
		if (DiagramAppearancePreferencePage.isMetaDiagramStyleUsecase()) {
			// draw UML-like Actor figure
			g.drawOval(x+w/4, y+1, w/2, w/2); // head
			g.drawLine(x+w/2, y+w/2, x+w/2, y+2*h/3); // body
			g.drawLine(x, y+h/2, x+w, y+h/2); // arms
			g.drawLine(x+w/2, y+2*h/3, x, y+h); // leg 1
			g.drawLine(x+w/2, y+2*h/3, x+w, y+h); // leg 2
		} else {
			// draw boring rectangle
			g.drawRectangle(x+1, y+1, w-2, h-2);
		}
	}

}