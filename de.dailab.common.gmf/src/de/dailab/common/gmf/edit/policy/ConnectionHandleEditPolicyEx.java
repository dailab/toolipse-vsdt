package de.dailab.common.gmf.edit.policy;

import java.util.List;

import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.Tool;
import org.eclipse.gef.tools.SelectionTool;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramAssistantEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandleLocator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantService;

/**
 * Derived from org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandlerEditPolicy
 * and from the respective class in the STP BPMN plugin.
 * 
 * For using this class, hook it into the default edit policies of some edit part:
 * 		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
 * 		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new ConnectionHandleEditPolicyEx());
 * 
 * @author kuester
 */
public abstract class ConnectionHandleEditPolicyEx extends DiagramAssistantEditPolicy {

	/** static field to show one handle at the time. */
	private static boolean isHandleCurrentlyShowing = false;

	/** listener for owner shape movement */
	private FigureListener ownerMovedListener = new FigureListener() {
		public void figureMoved(IFigure source) {
			hideDiagramAssistant();
		}
	};

	/** list of connection handles currently being displayed */
	private List<ConnectionHandle> handles = null;

	protected boolean isDiagramAssistant(Object object) {
		return object instanceof ConnectionHandle;
	}

	public void activate() {
		super.activate();
		((IGraphicalEditPart) getHost()).getFigure().addFigureListener(
				ownerMovedListener);
	}

	public void deactivate() {
		((IGraphicalEditPart) getHost()).getFigure().removeFigureListener(
				ownerMovedListener);
		super.deactivate();
	}

	protected boolean isDiagramAssistantShowing() {
		return handles != null;
	}
	
	@Override
	protected int getAppearanceDelay() {
		return 50;
	}

	@SuppressWarnings("unchecked")
	protected void showDiagramAssistant(Point referencePoint) {
		isHandleCurrentlyShowing = true;
		if (referencePoint == null) {
			referencePoint = getHostFigure().getBounds().getRight();
		}
		ConnectionHandleLocator locator = getConnectionHandleLocator(referencePoint);
		handles = getHandleFigures(locator.getBorderSide(),
				ModelingAssistantService.getInstance().getRelTypesOnSource(getHost()),
				ModelingAssistantService.getInstance().getRelTypesOnTarget(getHost()));

		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		for (ConnectionHandle handle : handles) {
			handle.setLocator(locator);
			locator.addHandle(handle);
			handle.addMouseMotionListener(this);
			layer.add(handle);
			// Register this figure with it's host EditPart so mouse events will be propagated to it's host.
			getHost().getViewer().getVisualPartMap().put(handle, getHost());
		}
		if(! shouldAvoidHidingDiagramAssistant()) {
			// dismiss the handles after a delay
			hideDiagramAssistantAfterDelay(getDisappearanceDelay());
		}
	}

	protected void hideDiagramAssistant() {
		isHandleCurrentlyShowing = false;
		if (handles == null) {
			return;
		}
		IFigure layer = getLayer(LayerConstants.HANDLE_LAYER);
		for (ConnectionHandle handle : handles) {
			handle.removeMouseMotionListener(this);
			layer.remove(handle);
			getHost().getViewer().getVisualPartMap().remove(handle);
		}
		handles = null;
	}

	/**
	 * Gets the two connection handle figures to be added to this shape if they support user gestures.
	 * 
	 * @param borderSide	the border from which the cursor is the nearest.
	 * @return				a list of <code>ConnectionHandle</code> objects
	 */
	protected abstract List<ConnectionHandle> getHandleFigures(int borderSide, List<IElementType> srcEltTypes, List<IElementType> tgtEltTypes);

	/**
	 * only show if in the top, bottom, left or right quarter
	 */
	protected boolean shouldShowDiagramAssistant(){
		if (isHandleCurrentlyShowing) {
			return false;
		}
		if (getAppearanceDelay() < 0) {
			return false;
		}
		if (!super.shouldShowDiagramAssistant()) {
			return false;
		}
		if (handles != null || !isSelectionToolActive()) {
			return false;
		}

		Point mouse = getMouseLocation().getCopy();
		Rectangle bounds = getHostFigure().getBounds().getCopy();
//		Rectangle innerBounds= bounds.getCopy().translate(bounds.width/4, bounds.height/4).resize(-bounds.width/2, -bounds.height/2);
		return bounds.contains(mouse); // && ! innerBounds.contains(mouse);
	}

	/**
	 * getViewer calls getParent so check for null
	 * 
	 * @return		ActiveTool is SelectionTool?
	 */
	private boolean isSelectionToolActive() {
		if (getHost().getParent() != null) {
			Tool theTool = getHost().getViewer().getEditDomain().getActiveTool();
			if((theTool != null) && theTool instanceof SelectionTool) {
				return true;
			}
		}
		return false;		
	}

	/**
	 * get the connection handle locator using the host and the passed reference point
	 * 
	 * This makes the Handle always appear in the center of the respective figure side
	 * 
	 * @param		referencePoint
	 * @return		<code>ConnectionHandleLocator</code>
	 */
	protected ConnectionHandleLocator getConnectionHandleLocator(Point referencePoint){
		Rectangle bounds= getHostFigure().getBounds();
		if (bounds.width != 0 && bounds.height != 0) {
			// we create the two equations representing the diagonals of the rectangle
			// first the one starting from the top left and going to the bottom right
			int borderSide = PositionConstants.NONE;
			boolean overFirstDiag = isOverALine(bounds.getBottomRight(), bounds.getTopLeft(), referencePoint);
			boolean overSecondDiag = isOverALine(bounds.getTopRight(), bounds.getBottomLeft(), referencePoint);
			if (overFirstDiag) {
				if (overSecondDiag) {
					referencePoint = bounds.getTop().getCopy();
					borderSide = PositionConstants.NORTH;
				} else {
					referencePoint = bounds.getRight().getCopy();
					borderSide = PositionConstants.EAST;
				}
			} else {
				if (overSecondDiag) {
					referencePoint = bounds.getLeft().getCopy();
					borderSide = PositionConstants.WEST;
				} else {
					referencePoint = bounds.getBottom().getCopy();
					borderSide = PositionConstants.SOUTH;
				}
			}
			getHostFigure().translateToAbsolute(referencePoint);
			return new ConnectionHandleLocatorEx(getHostFigure(), referencePoint, borderSide);
		}

		return new ConnectionHandleLocator(getHostFigure(), referencePoint);		
	}

	/**
	 * Evaluates whether a point is above a line formed by two other points
	 * 
	 * @param firstPoint	the first point to form the line
	 * @param secondPoint	the second point to form the line
	 * @param toEvaluate	the point to evaluate
	 * @return				true if the point is above the line
	 */
	private boolean isOverALine(Point firstPoint, Point secondPoint, Point toEvaluate) {
		int xa = firstPoint.x;
		int ya = firstPoint.y;
		int xb = secondPoint.x;
		int yb = secondPoint.y;
		double coeff = (double) (yb - ya)/(xb - xa);
		double constant = (double) (xb*ya - yb*xa)/(xb - xa);
		return toEvaluate.y < coeff*toEvaluate.x + constant;
	}

	/**
	 * We are more straight-forward than the super class regarding where
	 * we want our handles. In particular, the border side is set and should
	 * not change during the appearance of the handle.
	 */
	private class ConnectionHandleLocatorEx extends ConnectionHandleLocator {

		/** number of pixels between connection handles */
		private static final int HANDLE_SPACING = 15;

		private int borderSide;

		public ConnectionHandleLocatorEx(IFigure shape, Point reference, int borderSide) {
			super(shape, reference);
			this.borderSide = borderSide;
		}

		public void relocate(IFigure target) {
			// set location based on side
			Dimension offset = Dimension.SINGLETON.getCopy();

			switch (borderSide) {
			case PositionConstants.NORTH:
				offset.height = -target.getBounds().height;
				break;
			case PositionConstants.WEST:
				offset.width = -target.getBounds().width;
				break;
			default:
				break;
			}
			Point targetLocation = getCursorPosition().getCopy().translate(offset);
			target.translateToRelative(targetLocation);
			target.setLocation(targetLocation);

			// space out handles
			int index = handles.indexOf(target);
			double centerOffset = index - (handles.size() / 2.0);

			if (borderSide == PositionConstants.WEST || borderSide == PositionConstants.EAST) {
				target.translate(0, (int) (centerOffset * HANDLE_SPACING));
			} else {
				target.translate((int) (centerOffset * HANDLE_SPACING), 0);
			}
		}

		@Override
		public int getBorderSide() {
			return borderSide;
		}
	}
}
