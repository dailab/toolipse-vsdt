package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.figures.SwimlaneFigure;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractPoolEditPart extends AbstractVsdtNodeEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractPoolEditPart(View view) {
		super(view);
	}

	/**
	 * notify the edit part when there are changes to the model
	 * - when the boundaryVisible-feature has changed, set the figure accordingly
	 * - when the number of lanes has changed, recalculate the boundary-visibility of the pool and its lanes
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.POOL__BOUNDARY_VISIBLE:
			getPrimaryShape().setBoundaryVisible(getCastedModel().isBoundaryVisible());;
//			getCastedModel().setBoundaryVisibility();
			refreshChildren();
			break;
//		case VsdtPackage.POOL__LANES:
//			getCastedModel().setBoundaryVisibility();
//			break;
		}
		refreshVisuals();
	}
	
	/**
	 * @return the model, casted to its actual Type
	 */
	public Pool getCastedModel() {
		return (Pool) ((View) getModel()).getElement();
	}

	public abstract SwimlaneFigure getPrimaryShape();

	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		SwimlaneFigure figure= new SwimlaneFigure(true,
				getCastedModel().isBoundaryVisible());
		return figure;
	}
}
