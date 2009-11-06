package de.dailab.vsdt.meta.diagram.figures;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

import de.dailab.vsdt.diagram.preferences.DiagramAppearancePreferencePage;


/**
 * This is the figure used for the association from participants to business
 * processes, a simple arrow line.
 */
public class ParticipantProcessAssociationFigure extends PolylineConnectionEx {

	public ParticipantProcessAssociationFigure() {
		init();
	}
	
	private RotatableDecoration arrowDecoration;
	
	private RotatableDecoration deltaDecoration;
	
	/**
	 * do initialization work for both constructors
	 */
	private void init() {
		setLineStyle(org.eclipse.draw2d.Graphics.LINE_SOLID);
		setForegroundColor(ColorConstants.black);
	
		arrowDecoration= createArrowDecoration();
		deltaDecoration= createDeltaDecoration();
		
	}
	
	@Override
	public void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		if (DiagramAppearancePreferencePage.isMetaDiagramStyleUsecase()) {
			// set arrow decoration
			if (getTargetDecoration() != arrowDecoration) {
				setTargetDecoration(arrowDecoration);
			}
			if (getSourceDecoration() != null) {
				setSourceDecoration(null);
			}
		} else {
			// set delta decoration, if multiple instances
			if (getTargetDecoration() != null) {
				setTargetDecoration(null);
			}
			// TODO determine whether the participant has multiple instances in this process
//			if (getSourceDecoration() != deltaDecoration) {
//				setSourceDecoration(deltaDecoration);
//			}
		}		
	}

	/**
	 * create the decoration used for the target for usecase-style diagrams
	 */
	private RotatableDecoration createArrowDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		PointList pl = new PointList();
		pl.addPoint(-2, 2);
		pl.addPoint(0, 0);
		pl.addPoint(-2, -2);
		df.setTemplate(pl);
		return df;
	}
	
	/**
	 * create the decoration used for the source for conversation-style diagrams
	 */
	private RotatableDecoration createDeltaDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		PointList pl = new PointList();
		pl.addPoint(0, 2);
		pl.addPoint(-2, 0);
		pl.addPoint(0, -2);
		df.setTemplate(pl);
		return df;
	}

}