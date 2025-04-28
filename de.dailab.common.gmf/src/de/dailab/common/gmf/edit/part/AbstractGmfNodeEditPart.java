package de.dailab.common.gmf.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 */
public abstract class AbstractGmfNodeEditPart extends ShapeNodeEditPart implements IModelCastingEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractGmfNodeEditPart(View view) {
		super(view);
	}
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected abstract IFigure initNodeShape();

}
