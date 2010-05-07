package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * A figure for BPMN text annotations
 */
public class TextAnnotationFigure extends RectangleFigure {

	/**
	 * create text annotation figure
	 */
	public TextAnnotationFigure() {
		this.setFill(false);
		this.setOutline(false);
		this.setForegroundColor(ColorConstants.black);
		createContents();
	}

	/**
	 * create label
	 */
	private void createContents() {
		MarginBorder border= new MarginBorder(5);
		this.setBorder(border);

		fTextAnnotationTextFigure= new WrappingLabel();
		fTextAnnotationTextFigure.setTextWrap(true);
		this.add(fTextAnnotationTextFigure);
	}
	
	@Override
	public void paintFigure(Graphics g) {
		super.paintFigure(g);
		g.setLineWidth(1);
		g.drawLine(getBounds().getTopLeft(),getBounds().getBottomLeft());
		g.drawLine(getBounds().getTopLeft(),getBounds().getTopLeft().getCopy().translate(20,0));
		g.drawLine(getBounds().getBottomLeft().getCopy().translate(0, -1),getBounds().getBottomLeft().getCopy().translate(20,-1));
		// Cleanups
	    g.restoreState();
	}

	//OTHER STUFF
	
	private WrappingLabel fTextAnnotationTextFigure;

	public WrappingLabel  getFigureTextAnnotationTextFigure() {
		return fTextAnnotationTextFigure;
	}

	private boolean myUseLocalCoordinates = true;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}
}
