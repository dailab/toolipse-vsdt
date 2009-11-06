package de.dailab.vsdt.meta.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

import de.dailab.vsdt.diagram.preferences.DiagramAppearancePreferencePage;


/**
 * This is the figure for BusinessProcessDiagrams, being represented as a node
 * in the VSDT's "meta" diagram.  While the participants' figure is similar to
 * an actor from a usecase diagram, this figure is not the classical usecase
 * ellipse, but simply a rectangle, showing the name of the business process 
 * as well as the number of pools within. 
 */
public class BusinessProcessFigure extends RectangleFigure {
	
	public BusinessProcessFigure(int pools) {
		init();
		setPools(pools);
	}
	
	public BusinessProcessFigure() {
		System.err.println("Warning: using default constructor");
		init();
	}
	
	/**
	 * do initialization work for both constructors
	 */
	private void init() {
		setOutline(false);
		setFill(false);
		createContents();
		setForegroundColor(ColorConstants.black);
		setBackgroundColor(ColorConstants.white);
	}
	
	/**
	 * create the label, compartment, decoration and border figures
	 */
	private void createContents() {
		// border
		MarginBorder border= new MarginBorder(10, 10, 10, 10);
		setBorder(border);
		
		// wrap label for the name
		businessProcessNameLabel= new WrappingLabel();
		businessProcessNameLabel.setTextJustification(PositionConstants.CENTER);
		businessProcessNameLabel.setTextWrap(true);
		this.add(businessProcessNameLabel,null);
		
		poolsLabel= new Label();
		poolsLabel.setTextAlignment(Label.CENTER);
		this.add(poolsLabel,null);
		
	}
	
	@Override
	public void paintFigure(Graphics g) {
		super.paintFigure(g);
		Rectangle b= getBounds();
		int r= Math.min(b.width, b.height) / 2 -1;
		int x= b.x+ b.width/2;
		int y= b.y+ b.height/2;
		
		g.setForegroundColor(ColorConstants.darkGray);
		g.setLineWidth(2);
		
		if (! DiagramAppearancePreferencePage.isMetaDiagramStyleUsecase()) {
			// draw hexagon
			int[] points= new int[] {
					x-r, y, 
					x-r/2, y-r,
					x+r/2, y-r,
					x+r, y,
					x+r/2, y+r,
					x-r/2, y+r
			};
			g.drawPolygon(points);
		} else {
			// draw ellipse
			g.drawArc(b.x+1, b.y+1, b.width-2, b.height-2, 0, 360);
		}

	}
	
	public void setPools(int pools) {
		poolsLabel.setText(pools + (pools==1 ? " Pool" : " Pools"));
	}

	// EMBEDDED FIGURES

	private WrappingLabel businessProcessNameLabel;
	
	private Label poolsLabel;
	
	public WrappingLabel getFigureBusinessProcessNameFigure() {
		return businessProcessNameLabel;
	}

}
