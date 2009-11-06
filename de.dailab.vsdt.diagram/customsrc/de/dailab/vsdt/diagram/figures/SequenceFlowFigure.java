package de.dailab.vsdt.diagram.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;

import de.dailab.common.gmf.ui.figures.RoundedPolylineConnection;
import de.dailab.vsdt.ConditionType;


/**
 * figure for BPMN sequence flows
 */
public class SequenceFlowFigure extends RoundedPolylineConnection {

	private ConditionType conditionType= ConditionType.NONE;
	
	private boolean sourceIsGateway= false;
	
	/**
	 * this constructor should not be used. 
	 */
	public SequenceFlowFigure() {
		this.conditionType= ConditionType.NONE;
		this.sourceIsGateway= false;
		System.err.println("warning: sequence flow default constructor used");
		init();
	}
	
	/**
	 * @param useColor			use Color?
	 * @param conditionType		the condition type
	 * @param sourceIsGateway	whether the source if a gateway (if so, no expression marker is used)
	 */
	public SequenceFlowFigure(boolean useColor, ConditionType conditionType, boolean sourceIsGateway) {
		this.conditionType= conditionType;
		this.sourceIsGateway= sourceIsGateway;
		init();
	}
	
	/**
	 * initialization work common for both constructors
	 */
	private void init() {
		setForegroundColor(FigureHelper.getForeground(this));
		setTargetDecoration(createTargetDecoration());
		// set source decoration
		refreshDecoration();
	}

	/**
	 * create and return the decoration used for the target side
	 */
	private RotatableDecoration createTargetDecoration() {
		PolygonDecoration df = new PolygonDecoration();
		df.setFill(true);
		PointList pl = new PointList();
		pl.addPoint(0, 0);
		pl.addPoint(-2, 1);
		pl.addPoint(-2, -1);
		df.setTemplate(pl);
		return df;
	}

	/**
	 * refresh the decorations depending on the condition type
	 */
	public void refreshDecoration() {
		setSourceDecoration(null);
		switch(conditionType.getValue()) {
		case ConditionType.DEFAULT_VALUE:
			setSourceDecoration(createSourceDefaultDecoration());
			break;
		case ConditionType.EXPRESSION_VALUE:
			if (! sourceIsGateway) {
				setSourceDecoration(createSourceExpressionDecoration());
			}
			break;
		}
	}

	/**
	 * create source decoration for condition type default
	 */
	private RotatableDecoration createSourceDefaultDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		PointList pl = new PointList();
		pl.addPoint(-1, 1);
		pl.addPoint(-3, -1);
		df.setTemplate(pl);
		df.setScale(3,3);
		return df;
	}

	/**
	 * create source decoration for contition type expression
	 */
	private RotatableDecoration createSourceExpressionDecoration() {
		PolygonDecoration df = new PolygonDecoration();
		df.setFill(true);
		df.setBackgroundColor(ColorConstants.white);
		PointList pl = new PointList();
		pl.addPoint(0, 0);
		pl.addPoint(-1, 1);
		pl.addPoint(-2, 0);
		pl.addPoint(-1, -1);
		df.setTemplate(pl);
		return df;
	}

	// OTHER STUFF
	
	public void setConditionType(ConditionType conditionType) {
		this.conditionType = conditionType;
		this.refreshDecoration();
	}
	
	public void setSourceIsGateway(boolean b) {
		this.sourceIsGateway= b;
		this.refreshDecoration();
	}
	
	private boolean myUseLocalCoordinates = false;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}
	
}