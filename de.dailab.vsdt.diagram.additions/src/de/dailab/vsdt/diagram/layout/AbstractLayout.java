package de.dailab.vsdt.diagram.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.JComponent;
import javax.swing.JFrame;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.End;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;

/**
 * Abstract superclass for BPMN Layout Algorithms. Provides some constants, e.g.
 * for default node sizes, and a couple of methods for generating a command from
 * the calculated Layout information.
 * 
 * @author kuester
 */
public abstract class AbstractLayout {
	
	/** Offset from top-left corner in parent container, both for x and y */
	public static final int OFFSET= 30;
	
	/** Horizontal margin between nodes */
	public static final int MARGIN_H= 50;
	
	/** Vertical margin between nodes */
	public static final int MARGIN_V= 30;

	/** default sizes for various nodes */
	public static final Point SIZE_DEFAULT= new Point(40, 40);
	public static final Point SIZE_EVENT= SIZE_DEFAULT;
	public static final Point SIZE_GATEWAY= SIZE_DEFAULT;
	public static final Point SIZE_ACTIVITY= new Point(60, 40);

	/** name of the command to issue */
	public final String commandName;
	
	/**
	 * Create new Instance of Layout Algorithm
	 * 
	 * @param commandName	name of the command to issue
	 */
	public AbstractLayout(String commandName) {
		this.commandName= commandName;
	}
	

	/**
	 * Create and return a Command that applies the calculated Layout to the
	 * given List of Edit Parts.
	 * 
	 * @param editPartList		List of Edit Parts to layout
	 * @param layoutChildren	apply layout recursively, e.g. to subprocesses?
	 * @param layoutMap			List holding the layout information for the nodes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Command getLayoutCommand(List<AbstractGraphicalEditPart> editPartList, boolean layoutChildren, Map<FlowObject, Rectangle> layoutMap) {
		Queue<AbstractGraphicalEditPart> editParts= new LinkedList<AbstractGraphicalEditPart>();
		editParts.addAll(editPartList);
		CompoundCommand cc= new CompoundCommand(commandName);
		while (! editParts.isEmpty()) {
			AbstractGraphicalEditPart editPart= editParts.remove();
			EObject element= ((View) editPart.getModel()).getElement();
			if (element instanceof FlowObject) {
				FlowObject flowObject = (FlowObject) element;

				// FIXME workaround
				for (FlowObject flowObject2 : layoutMap.keySet()) {
					if (flowObject.getId().equals(flowObject2.getId())) {
						flowObject= flowObject2;
						break;
					}
				}
				
				Rectangle rect= layoutMap.get(flowObject);
				if (rect != null) {
					ChangeBoundsRequest request = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
	                Point ptLocation = new PrecisionPoint(rect.preciseX(), rect.preciseY());

	                PrecisionPoint ptOldLocation = new PrecisionPoint(editPart.getFigure().getBounds().getLocation());
	                editPart.getFigure().translateToAbsolute(ptOldLocation);
	                
	                editPart.getFigure().translateToAbsolute(ptLocation);
	                PrecisionPoint delta = new PrecisionPoint(ptLocation.preciseX()
	                    - ptOldLocation.preciseX(), ptLocation.preciseY()
	                    - ptOldLocation.preciseY());

	                request.setEditParts(editPart);
	                request.setMoveDelta(delta);
	                request.setLocation(ptLocation);
	                
	                Command cmd = editPart.getCommand(request);
	                if (cmd != null && cmd.canExecute()) {
	                    cc.add(cmd);
	                }
				}
			}
			if (element instanceof ConnectingObject) {
				// TODO remove all bend-points but one
			}
			editParts.addAll((Collection<? extends AbstractGraphicalEditPart>) editPart.getChildren());
		}
		return cc;
	}
	
	/**
	 * Calculate and return Layout Map for given VSDT Diagram Editor.
	 * 
	 * @param editor	Current Editor holding the Business Process Diagram
	 * @return			Map holding the association of FlowObjects to Positions.
	 */
	public final Map<FlowObject, Rectangle> createLayoutMap(VsdtDiagramEditor editor) {
		BusinessProcessDiagramEditPart diagramEditPart= (BusinessProcessDiagramEditPart) editor.getDiagramEditPart();
		BusinessProcessDiagram bpd= diagramEditPart.getCastedModel();
		return createLayoutMap(bpd);
	}
	
	/**
	 * @param p1	some point
	 * @param p2	some other point
	 * @return		distance between points
	 */
	protected final double getDistance(Point p1, Point p2) {
		int dx = p2.x - p1.x;
		int dy = p2.y - p1.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	
	/**
	 * Calculate the Bounding Box for each Element in the Business Process
	 * Diagram and return it in a Map. Currently the Layout is calculated only
	 * for Flow Objects, but this might be extended to Connections Artifacts,
	 * and Pools in the Future.  
	 * 
	 * @param strucBpd		Copy of Business Process Diagram
	 * @return				Map holding association of FlowObjects to Rectangles
	 */
	protected abstract Map<FlowObject, Rectangle> createLayoutMap(BusinessProcessDiagram bpd);
	

	/**
	 * A simple frame that can be used for previewing the layout prior to
	 * applying it to the diagram.
	 *  
	 * @author kuester
	 */
	@SuppressWarnings("serial")
	protected static class MockupFrame extends JFrame {
		
		Map<FlowObject, Rectangle> layoutMap;
		
		public MockupFrame(Map<FlowObject, Rectangle> layoutMap) {
			super("Layout Preview");
			this.layoutMap = layoutMap;
			JComponent component= new JComponent() {

				public void paint(Graphics g) {
					super.paint(g);
					if (MockupFrame.this.layoutMap != null) {
						for (FlowObject flowObject : MockupFrame.this.layoutMap.keySet()) {
							g.setColor(Color.GRAY);
							if (flowObject instanceof Activity) g.setColor(Color.WHITE);
							if (flowObject instanceof Start) g.setColor(Color.GREEN);
							if (flowObject instanceof Intermediate) g.setColor(Color.YELLOW);
							if (flowObject instanceof End) g.setColor(Color.RED);
							if (flowObject instanceof Gateway) g.setColor(Color.ORANGE);
							Rectangle r= MockupFrame.this.layoutMap.get(flowObject);
							if (g.getColor() == Color.GRAY) {
								g.drawRect(r.x, r.y, r.width, r.height);	
							} else {
								g.fillRect(r.x, r.y, r.width, r.height);
								g.setColor(Color.BLACK);
								g.drawString(flowObject.getName() == null ? "" : flowObject.getName(), r.x, r.y+15);
							}
							g.setColor(Color.black);
							for (SequenceFlow seqFlow : flowObject.getOutgoingSeq()) {
								FlowObject other= seqFlow.getTarget();
								Point p1= r.getCenter();
								Point p2= MockupFrame.this.layoutMap.get(other).getCenter();
								g.drawLine(p1.x, p1.y, p2.x, p2.y);
							}
							
						}
					}
				}
				
			};
			this.getContentPane().add(component);
			this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			this.setSize(1000, 800);
			this.setVisible(true);
		}
		
		public void update(Map<FlowObject, Rectangle> layoutMap) {
			this.layoutMap = layoutMap;
			repaint();
		}
		
	}
	
}
