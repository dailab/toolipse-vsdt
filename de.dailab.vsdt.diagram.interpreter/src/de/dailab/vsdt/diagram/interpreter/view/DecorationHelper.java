package de.dailab.vsdt.diagram.interpreter.view;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.swt.graphics.Color;

import de.dailab.common.gmf.Util;
import de.dailab.vsdt.diagram.edit.parts.IVsdtEditPart;
import de.dailab.vsdt.diagram.figures.FigureHelper;
import de.dailab.vsdt.diagram.figures.IDecoratableFigure;
import de.dailab.vsdt.diagram.figures.IFigureDecorator;
import de.dailab.vsdt.interpreter.State;

/**
 * Helper class to be used by Interpreter Observer and for Process Interpreter Integration
 * 
 * @author kuester
 */
public class DecorationHelper {

	/** Map holding the association of EObjects to EditParts */
	protected static final Map<EObject, IFigure> figureMap= new HashMap<>();

	public static void decorateNode(IFigure figure, State state) {
		// MarkerDecorator
		if (figure instanceof IDecoratableFigure) {
			IDecoratableFigure decoratableFigure= (IDecoratableFigure) figure;
			if (! (decoratableFigure.getDecorator() instanceof FlowObjectMarkerDecorator)) {
				decoratableFigure.setDecorator(new FlowObjectMarkerDecorator());
			}
			FlowObjectMarkerDecorator decorator = (FlowObjectMarkerDecorator) decoratableFigure.getDecorator();
			decorator.state = state;
			figure.repaint();
		}
	}

	public static void decorateEdge(IFigure figure, int visited, int maxSteps) {
		if (figure instanceof PolylineConnectionEx) {
			PolylineConnectionEx connectionFigure = (PolylineConnectionEx) figure;
			if (visited > 0) {
				connectionFigure.setLineWidth(3);
				Color color= figure.getForegroundColor();
				int red= color.getRed();
				int green= color.getGreen();
				int blue= (int) (255 * ((float) visited / (float) maxSteps));
				connectionFigure.setForegroundColor(new Color(color.getDevice(), red, green, blue));
			} else {
				connectionFigure.setForegroundColor(FigureHelper.getForeground(connectionFigure));
				connectionFigure.setLineWidth(1);
			}
		}
	}
	
	public static void clearDecorators(DiagramEditPart diagramEditPart) {
		for (EObject eObject : figureMap.keySet()) {
			IFigure figure= getFigure(diagramEditPart, eObject);
			// remove DecorationMarkers from FlowObject Figures
			if (figure instanceof IDecoratableFigure) {
				((IDecoratableFigure) figure).setDecorator(null);
				figure.repaint();
			}
			// reset line color and line with for connections
			if (figure instanceof PolylineConnectionEx) {
				PolylineConnectionEx connectionFigure = (PolylineConnectionEx) figure;
				connectionFigure.setForegroundColor(FigureHelper.getForeground(connectionFigure));
				connectionFigure.setLineWidth(1);
			}
		}
	}
	
	public static final IFigure getFigure(DiagramEditPart diagramEditPart, EObject eObject) {
		// XXX can caching be a problem when closing and re-opening a diagram?
		IFigure figure = figureMap.get(eObject);
		if (figure == null) {
			IVsdtEditPart editPart= (IVsdtEditPart) Util.findFirstEditPart(eObject, diagramEditPart, IVsdtEditPart.class);
			if (editPart != null) {
				figure= editPart.getPrimaryShape();
				figureMap.put(eObject, figure);
			}
		}
		return figure;
	}
	
	/**
	 * FigureDecorator responsible for decorating the FlowObjects' figures
	 * according to the States the FlowObject currently are in. This Decorator 
	 * will place a small colored circle in the upper left corner of the figure. 
	 * 
	 * @author kuester
	 */
	public static class FlowObjectMarkerDecorator implements IFigureDecorator {
		
		static final Color butter = new Color(null, 252, 233, 79); // tango butter 1
		static final Color sky = new Color(null, 114, 159, 207);// tango sky blue 1
		static final Color chameleon = new Color(null, 138, 226, 52);// tango chameleon 1
		static final Color scarlet = new Color(null, 239, 41, 41);// tango scarlet red 1
		
		public State state= null;

		public void decorateFigure(IFigure figure, Graphics g) {
			if (state == null || state == State.IDLE) return;
			Point p= figure.getBounds().getTopLeft();
			Color color= ColorConstants.white;
			if (state == State.READY) color= butter;
			if (state == State.LOOPING_READY) color= butter;
			if (state == State.ACTIVE_WAITING) color= sky;
			if (state == State.ACTIVE_READY) color= sky;
			if (state == State.DONE) color= chameleon;
			if (state == State.FAILED) color= scarlet;
			g.setForegroundColor(ColorConstants.black);
			g.setBackgroundColor(color);
			g.setLineWidth(1);
			int w= 16;
			g.fillOval(p.x, p.y, w, w);
			g.drawOval(p.x, p.y, w, w);
			if (state == State.ACTIVE_WAITING) {
				// draw pause symbol
				g.setBackgroundColor(butter);
				g.fillRectangle(p.x+2*w/5, p.y+w/2, w/5, w/2);
				g.fillRectangle(p.x+4*w/5, p.y+w/2, w/5, w/2);
				g.drawRectangle(p.x+2*w/5, p.y+w/2, w/5, w/2);
				g.drawRectangle(p.x+4*w/5, p.y+w/2, w/5, w/2);
			}
			if (state == State.ACTIVE_READY) {
				// draw play symbol
				g.setBackgroundColor(chameleon);
				g.fillPolygon(new int[] {p.x+w/2, p.y+w/2, p.x+w, p.y+3*w/4, p.x+w/2, p.y+w});
				g.drawPolygon(new int[] {p.x+w/2, p.y+w/2, p.x+w, p.y+3*w/4, p.x+w/2, p.y+w});
			}
			// Icon does not look good in diagram
//			Image image= ImageLoader.getInstance().getImage(state.getImageDescriptor());
//			g.drawImage(image, p);
		}
	}
	
}
