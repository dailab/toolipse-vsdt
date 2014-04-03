package de.dailab.vsdt.diagram.interpreter.view;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import de.dailab.common.gmf.Util;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.edit.parts.IVsdtEditPart;
import de.dailab.vsdt.diagram.figures.FigureHelper;
import de.dailab.vsdt.diagram.figures.IDecoratableFigure;
import de.dailab.vsdt.diagram.figures.IFigureDecorator;
import de.dailab.vsdt.interpreter.ISimulationObserver;
import de.dailab.vsdt.interpreter.State;

/**
 * This class encapsulates all the stuff needed to link the VSDT interpreter
 * to the VSDT Eclipse editor.
 * 
 * @author kuester
 */
public class EclipseInterpreterObserver implements ISimulationObserver {

	/** Map holding the association of EObjects to EditParts */
	protected final Map<EObject, IFigure> figureMap= new HashMap<>();

	/** the viewer */
	protected final Viewer viewer;
	
	/** the diagram edit part */
	protected final BusinessProcessDiagramEditPart diagramEditPart;
	
	public EclipseInterpreterObserver(Viewer viewer, BusinessProcessDiagramEditPart diagramEditPart) {
		this.viewer = viewer;
		this.diagramEditPart = diagramEditPart;
	}

	/**
	 * - refresh the viewer
	 * - refresh figures
	 */
	public void refresh(int step, Map<EObject,Integer> stepMap, Map<FlowObject,State> stateMap) {
		
		// refresh tree viewer
				if (viewer != null) {
					viewer.refresh();
				}
				// refresh diagram view
				if (diagramEditPart != null) {
					for (FlowObject flowObject : stateMap.keySet()) {
						IFigure figure= getFigure(flowObject);
						// MarkerDecorator
						if (figure instanceof IDecoratableFigure) {
							IDecoratableFigure decoratableFigure= (IDecoratableFigure) figure;
							if (! (decoratableFigure.getDecorator() instanceof FlowObjectMarkerDecorator)) {
								decoratableFigure.setDecorator(new FlowObjectMarkerDecorator());
							}
							FlowObjectMarkerDecorator decorator = (FlowObjectMarkerDecorator) decoratableFigure.getDecorator();
							decorator.state= stateMap.get(flowObject);
							figure.repaint();
						}
					}
					for (EObject eObject: stepMap.keySet()) {
						IFigure figure= getFigure(eObject);
						if (figure instanceof PolylineConnectionEx) {
							PolylineConnectionEx connectionFigure = (PolylineConnectionEx) figure;
							int lastVisited= stepMap.get(eObject);
							if (lastVisited > 0 && figure instanceof PolylineConnectionEx) {
								connectionFigure.setLineWidth(3);
								Color color= figure.getForegroundColor();
								int red= color.getRed();
								int green= color.getGreen();
								int blue= (int) (255 * ((float) lastVisited / (float) step));
								connectionFigure.setForegroundColor(new Color(color.getDevice(), red, green, blue));
							}
						}
					}
				}
		
	};

	/**
	 * Remove all decorations and refresh the viewer
	 */
	public void clear() {
		// remove decorations
		if (diagramEditPart != null) {
			for (EObject eObject : figureMap.keySet()) {
				IFigure figure= getFigure(eObject);
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
		// refresh viewer
		if (viewer != null) {
			viewer.refresh();
		}
	}

	public void logMessage(LogLevel level, String title, String message) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		if (level == LogLevel.INFO) {
			MessageDialog.openInformation(shell, title, message.toString());
		}
		if (level == LogLevel.WARN) {
			MessageDialog.openWarning(shell, title, message.toString());
		}
		if (level == LogLevel.ERROR) {
			MessageDialog.openError(shell, title, message.toString());
		}
	}
	
	
	
	
	protected final IFigure getFigure(EObject eObject) {
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
	protected static class FlowObjectMarkerDecorator implements IFigureDecorator {
		
		static final Color butter = new Color(null, 252, 233, 79); // tango butter 1
		static final Color sky = new Color(null, 114, 159, 207);// tango sky blue 1
		static final Color chameleon = new Color(null, 138, 226, 52);// tango chameleon 1
		static final Color scarlet = new Color(null, 239, 41, 41);// tango scarlet red 1
		
		State state= null;

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
