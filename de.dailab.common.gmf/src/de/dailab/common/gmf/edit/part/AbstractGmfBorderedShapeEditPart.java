package de.dailab.common.gmf.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 */
public abstract class AbstractGmfBorderedShapeEditPart extends AbstractBorderedShapeEditPart implements IModelCastingEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractGmfBorderedShapeEditPart(View view) {
		super(view);
	}
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected abstract IFigure initNodeShape();

}
