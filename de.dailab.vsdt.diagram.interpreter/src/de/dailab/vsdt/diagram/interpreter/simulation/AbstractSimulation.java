package de.dailab.vsdt.diagram.interpreter.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Color;

import de.dailab.common.gmf.Util;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.edit.parts.IVsdtEditPart;
import de.dailab.vsdt.diagram.figures.FigureHelper;
import de.dailab.vsdt.diagram.figures.IDecoratableFigure;
import de.dailab.vsdt.diagram.figures.IFigureDecorator;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * Abstract implementation of ISimulation.  This class handles large parts of
 * determining which FlowObjects are ready to be executed and for moving Tokens
 * from and to Sequence Flows.  Further, this class hooks into the editor to 
 * highlight the currently active elements and synchronizing with the InterpreterView.
 * 
 * This class implements all the methods of the ISimulator interface, including
 * the various step methods, and provides a number of abstract methods to be
 * implemented by subclasses for handling the "details".
 * 
 * Internally, the simulation works similarly to a PetriNet, regarding the
 * flow objects as transitions and connections as states, which can hold a number
 * of tokens. 
 * 
 * @author kuester
 */
public abstract class AbstractSimulation implements ISimulation {
	
	/** This Map holds the association of States to FlowObjects */
	protected final Map<FlowObject, State> stateMap;
	
	/** This Map holds the association of Tokens to Connections */
	protected final Map<ConnectingObject, Integer> tokenMap;
	
	/** Another Map, holding information in which step each element has been visited (last) */
	protected final Map<EObject, Integer> stepMap;

	/** The Viewer showing a tree structure of the activities */
	protected Viewer viewer;
	
	/** the Business Process Diagram on which to run the simulation */
	protected BusinessProcessDiagramEditPart diagramEditPart;

	/** The number of (full) steps the simulation has already taken. */
	protected int step;
	
	/**
	 * Initialize fields
	 */
	public AbstractSimulation() {
		stateMap = new HashMap<FlowObject, State>();
		tokenMap = new HashMap<ConnectingObject, Integer>();
		stepMap = new HashMap<EObject, Integer>();
		diagramEditPart = null;
		step = -1;
	}

	////////////////////////////////////////////////////////////////////////////
	// Interface methods (all final)
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * - initialize step counter
	 * - initialize token and state maps
	 */
	public final List<FlowObject> start(BusinessProcessDiagram diagram) {
		System.out.println("Starting Simulation");
		BusinessProcessDiagram bpd= diagram;
		// check diagram
		if (checkDiagram(bpd)) {
			List<FlowObject> result= new ArrayList<FlowObject>();
			// initialize some tables holding the currently activated elements
			step= 0;
			tokenMap.clear();
			for (ConnectingObject connection : bpd.getConnections()) {
				if (connection instanceof SequenceFlow || connection instanceof MessageFlow) {
					tokenMap.put(connection, 0);
				}
			}
			stateMap.clear();
			for (Pool pool : bpd.getPools()) {
				for (FlowObject flowObject : VsdtHelper.getAllGraphicalElements(pool)) {
					stateMap.put(flowObject, State.IDLE);
					if (updateState(flowObject)) {
						result.add(flowObject);
					}
				}
			}
			refreshViewer();
			return result;
		} else {
			return null;
		}
	}

	/**
	 * - set edit part reference
	 * - see above
	 */
	public final List<FlowObject> start(BusinessProcessDiagramEditPart diagramEditPart) {
		this.diagramEditPart= diagramEditPart;
		return start(diagramEditPart.getCastedModel());
	}

	/**
	 * - reset step counter
	 * - reset states of flow objects (being reflected in the diagram)
	 * - clear token and state maps
	 */
	public final void stop() {
		System.out.println("Stopping Simulation");
		step= -1;
		// clear activation tables
		stateMap.clear();
		tokenMap.clear();
		stepMap.clear();
		// remove markers
		clearViewer();
	}
	
	public final boolean isRunning() {
		return step != -1;
	}
	
	public final List<FlowObject> stepOver(FlowObject flowObject) {
		stepInto(flowObject);
		return stepOut(flowObject);
	}

	/**
	 * - increase step counter
	 * - remove tokens from incoming flows
	 * - set state to ACTIVE
	 * - handle start assignments
	 */
	public final List<FlowObject> stepInto(FlowObject flowObject) {
		System.out.println("Stepping Into " + flowObject);
		List<FlowObject> result= new ArrayList<FlowObject>();
		if (isInState(flowObject, State.READY, State.LOOPING_READY)) {
			step++;
			// remove tokens from incoming flows
			for (SequenceFlow seqFlow : flowObject.getIncomingSeq()) {
				if (seqFlow.getSource() instanceof Gateway && 
						((Gateway)seqFlow.getSource()).getGatewayType() == GatewayType.XOR_EVENT) {
					// event-based XOR: remove other tokens, too
					for (SequenceFlow seqFlow2 : seqFlow.getSource().getOutgoingSeq()) {
						changeToken(seqFlow2, -1);
						if (updateState(seqFlow2.getTarget())) {
							result.add(seqFlow2.getTarget());
						}
					}
				} else {
					changeToken(seqFlow, -1);
				}
			}
			// skip assignments when looping
			if (! isInState(flowObject, State.LOOPING_READY)) {
				// handle start Assignments
				handleAssignments(flowObject, AssignTimeType.START);
			}
			// set state to ACTIVE_WAITING
			setState(flowObject, State.ACTIVE_WAITING);
			// execute, part I
			executeBegin(flowObject);
			// possibly set state to ACTIVE_READY
			if (updateState(flowObject)) {
				result.add(flowObject);
			}
		}
		refreshViewer();
		return result;
	}
	
	/**
	 * - handle activity looping
	 * - select outgoing path to take
	 * - handle end assignments
	 * - set state to DONE
	 * - place tokens on outgoing flows
	 * - update states of succeeding flow objects
	 */
	public final List<FlowObject> stepOut(FlowObject flowObject) {
		System.out.println("Stepping out of " + flowObject);
		List<FlowObject> result= new ArrayList<FlowObject>();
		if (isInState(flowObject, State.ACTIVE_READY)) {
			// execute, part II
			executeEnd(flowObject);
			// handle activity looping
			if (flowObject instanceof Activity && isLooping((Activity) flowObject)) {
				// set state to DONE, and then right back to LOOPING_READY
				setState(flowObject, State.DONE);
				setState(flowObject, State.LOOPING_READY);
			} else {
				// handle end Assignments
				handleAssignments(flowObject, AssignTimeType.END);
				// OR-, XOR-Gateway: select outgoing sequence flow(s)
				List<SequenceFlow> seqFlows= needsToSelectPath(flowObject) 
						? selectOutgoingSequenceFlows(flowObject)
						: flowObject.getOutgoingSeq();
				if (seqFlows == null) {
					return result; // no selection; cancel
				}
				// set state to DONE
				setState(flowObject, State.DONE);
				// place tokens on outgoing sequence flows
				for (SequenceFlow seqFlow : seqFlows) {
					changeToken(seqFlow, +1);
					if (updateState(seqFlow.getTarget())) {
						result.add(seqFlow.getTarget());
					}
					stepMap.put(seqFlow, step);
				}
			}
			// set containing subprocess to ACTIVE_READY
			if (flowObject.getParent() instanceof Activity) {
				if (updateState((Activity) flowObject.getParent())) {
					result.add((Activity) flowObject.getParent());
				}
			}
		}
		refreshViewer();
		return result;
	}

	////////////////////////////////////////////////////////////////////////////
	// Life Cycle methods
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Perform some pre-simulation checks when the simulation is to be started.
	 * 
	 * @param diagram		The Business Process Diagram to be simulated
	 * @return				Whether there are any Problems with the diagrams
	 */
	protected abstract boolean checkDiagram(BusinessProcessDiagram diagram);
	
	/**
	 * This method is executed at the end of the {@link #stepInto(FlowObject)}
	 * method and after the Start Assignments. Typically, Message handling should
	 * go here, depending on the type of the simulation e.g. placing tokens on 
	 * outgoing Message Flows or Messages, passing values to message parameters, 
	 * etc. Other stuff that has to be done when "executing an activity may also 
	 * go here. 
	 * 
	 * @param flowObject	Some FlowObject being "executed"
	 */
	protected abstract void executeBegin(FlowObject flowObject);
	
	/**
	 * Analogous to {@link #executeBegin(FlowObject)}, this method is executed 
	 * at the end of the {@link #stepInto(FlowObject)} method and before the End
	 * Assignments. Typically, Message handling should go here, depending on the 
	 * type of the simulation e.g. removing tokens from incoming Message Flows 
	 * or Messages, reading values from message parameters, etc.. Other stuff 
	 * that has to be done when "executing" an activity may also go here. 
	 * 
	 * @param flowObject	Some FlowObject being "executed"
	 */
	protected abstract void executeEnd(FlowObject flowObject);
	
	/**
	 * Handle the Objects assignments, if any. The second parameter determines
	 * whether to handle the Start or End assignments..
	 * 
	 * @param eObject	Some FlowObject or the Process
	 * @param assignTime	AssignTime (START or STOP)
	 */
	protected abstract void handleAssignments(EObject eObject, AssignTimeType assignTime);
	
	/**
	 * Determine whether the activity shall be looping, e.g. by prompting the
	 * user or by evaluating the loop condition, if any.
	 * 
	 * @param flowObject	Some Activity with Looping != NONE 
	 * @return				Whether this activity shall be repeated
	 */
	protected abstract boolean isLooping(Activity activity);
	
	/**
	 * Set the state of the given FlowObject. This method is intended to not 
	 * only set the state, but also to (recursively) alter the States of related
	 * Flow Objects, e.g. when setting an Embedded Subprocess to ACTIVE, the 
	 * contained Flow Objects and Boundary Events should be set to ready, and
	 * when executing a Boundary Event, the according activity should be set to
	 * failed, etc.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @param state			New State for that FlowObject
	 */
	protected abstract void setState(FlowObject flowObject, State state);
	
	/**
	 * Calculate whether the given FlowObject is ready for execution, i.e. whether
	 * its state can be changed from {@value State#IDLE} to {@value State#READY},
	 * basically checking the tokens on the incoming Sequence Flows, but also 
	 * the activation of the parent element, if any.  Some special cases have to 
	 * be considered, too, such as Service Tasks or Link and Signal Events.
	 * Note: This method should not /change/ the state of that FlowObject or any 
	 * other element.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @return				whether the FlowObject can be set to {@value State#READY}
	 */
	protected abstract boolean calculateIsReady(FlowObject flowObject);
	
	/**
	 * Analogous to {@link #calculateIsReady(FlowObject)}, this method checks
	 * whether the given FlowObject can finish (i.e. change it's state from 
	 * {@value State#ACTIVE_WAITING} to {@value State#ACTIVE_READY}.  Depending
	 * on the type of simulation, this check may involve checking for tokens on
	 * Messages or Message Flows, and for the state of children, if any.
	 * Note: This method should not /change/ the state of that FlowObject or any 
	 * other element.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @return				whether the FlowObject can be set to {@value State#ACTIVE_READY}
	 */
	protected abstract boolean calculateCanFinish(FlowObject flowObject);
	
	/**
	 * Select the outgoing paths to take for the given FlowObject, e.g. an XOR
	 * Gateway, for instance by prompting the user to select some or by 
	 * evaluating the Properties and Conditions.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @return				List of SequenceFlows starting the paths to take after this FlowObject
	 */
	protected abstract List<SequenceFlow> selectOutgoingSequenceFlows(FlowObject flowObject);

	////////////////////////////////////////////////////////////////////////////
	// Helper Methods
	////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Depending on whether the FlowObject is IDLE or ACTIVE_WAITING, check 
	 * whether it can be set to READY or ACTIVE_READY respectively and do so.
	 * 
	 *  @param flowObject	Some FlowObject being part of the Simulation
	 */
	protected final boolean updateState(FlowObject flowObject) {
		if (isInState(flowObject, State.ACTIVE_WAITING, State.ACTIVE_READY)) {
			if (calculateCanFinish(flowObject)) {
				setState(flowObject, State.ACTIVE_READY);
				return true;
			}
		} else {
			if (calculateIsReady(flowObject)) {
				setState(flowObject, State.READY);
				return true;
			} else {
				setState(flowObject, State.IDLE);
			}
		}
		return false;
	}
	
	/**
	 * This method determines whether a path needs to be selected or not.  For
	 * example, a path needs to be selected for an XOR-Data Gateway, while no
	 * path needs to be selected for an AND Gateway.  Somewhat problematic are
	 * the cases of Complex and XOR-Event Gateways.  In the first case, a path
	 * needs to be selected, but this can not be done automatically, so the user
	 * needs to be asked.  In the latter case, the current solution is to select
	 * both path (i.e. to return false in this method) and then to deactivate 
	 * the other paths after one path has been selected.
	 * 
	 * @param flowObject	Some FlowObject, possibly with more than one outgoing SequenceFlow
	 * @return				Whether a path needs to be selected.
	 */
	protected final boolean needsToSelectPath(FlowObject flowObject) {
		if (flowObject.getOutgoingSeq().size() > 1) {
			if (flowObject instanceof Gateway) {
				return ((Gateway)flowObject).getGatewayType() != GatewayType.AND
						&& ((Gateway)flowObject).getGatewayType() != GatewayType.XOR_EVENT;
			} else {
				for (SequenceFlow seqFlow : flowObject.getOutgoingSeq()) {
					if (seqFlow.getConditionType() != ConditionType.NONE) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Change the tokens for the given Connection. The given delta will be added
	 * to the connections tokens in the token map. A connection can have arbitrarily
	 * many tokens, but not less than zero.
	 * 
	 * @param connection	Some Connection being part of the Simulation
	 * @param delta			Delta to add on the tokens for this connection
	 */
	protected final void changeToken(ConnectingObject connection, int delta) {
		Integer token= tokenMap.get(connection);
		if (token != null) {
			token= token + delta;
		} else {
			token= delta;
		}
		tokenMap.put(connection, token < 0 ? 0 : token);
	}

	public final State getState(FlowObject flowObject) {
		return stateMap.get(flowObject);
	}
	
	public final int getToken(ConnectingObject connection) {
		return tokenMap.get(connection);
	}
	
	public final int getStep(EObject object) {
		return stepMap.get(object);
	}
	
	/**
	 * Check whether the given FlowObject is in one of the given states.
	 * 
	 * @param flowObject	Some FlowObject being part of the Simulation
	 * @param states		One or more states
	 * @return				Whether the FlowObject is in one of these States
	 */
	protected final boolean isInState(FlowObject flowObject, State... states) {
		for (State state : states) {
			if (stateMap.get(flowObject) == state) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Print Information on States and Tokens to console. 
	 */
	protected final void printStates() {
		// print details to console
		System.out.println("--- State Table ---");
		for (FlowObject flowObject : stateMap.keySet()) {
			System.out.println(stateMap.get(flowObject) + "\t" + VsdtHelper.getDescriptiveName(flowObject));
		}
		System.out.println("--- Token Table ---");
		for (ConnectingObject connection : tokenMap.keySet()) {
			System.out.println(tokenMap.get(connection) + "\t" + connection.getName());
		}
	}
	
	////////////////////////////////////////////////////////////////////////////
	// Graphics and Displaying
	////////////////////////////////////////////////////////////////////////////
	
	/** Map holding the association of EObjects to EditParts */
	protected final Map<EObject, IFigure > figureMap= new HashMap<EObject, IFigure>();
	
	/**
	 * Sets the Viewer for controlling this Simulation
	 */
	public final void setViewer(Viewer viewer) {
		this.viewer = viewer;
	}
	
	/**
	 * - refresh the viewer
	 * - refresh figures
	 */
	protected final void refreshViewer() {
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
					decorator.state= getState(flowObject);
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
	}
	
	/**
	 * Remove all decorations and refresh the viewer
	 */
	protected final void clearViewer() {
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
