package de.dailab.vsdt.diagram.figures;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

public class PlainLabelFigure extends WrapLabel {

	public PlainLabelFigure() {
	}

	private boolean myUseLocalCoordinates = false;

	protected boolean useLocalCoordinates() {
		return myUseLocalCoordinates;
	}

	protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
		myUseLocalCoordinates = useLocalCoordinates;
	}

}
