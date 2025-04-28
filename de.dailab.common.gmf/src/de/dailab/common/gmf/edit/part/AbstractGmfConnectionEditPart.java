package de.dailab.common.gmf.edit.part;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 *
 */
public abstract class AbstractGmfConnectionEditPart extends ConnectionNodeEditPart implements IModelCastingEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractGmfConnectionEditPart(View view) {
		super(view);
	}

	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected abstract Connection createConnectionFigure();
	
}
