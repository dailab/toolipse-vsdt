package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.AbstractGmfBorderedShapeEditPart;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.figures.ServiceFigure;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractServiceEditPart extends AbstractGmfBorderedShapeEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractServiceEditPart(View view) {
		super(view);
	}
	
	/**
	 * notify the edit part when there are changes to the model
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.SERVICE__USER:
			getPrimaryShape().setHasUser(getCastedModel().getUser() != null);
			refreshVisuals();
			break;
		case VsdtPackage.SERVICE__MULTIPLE:
			getPrimaryShape().setMultiple(getCastedModel().isMultiple());
			refreshVisuals();
			break;
		}
	}
	
	/**
	 * @return the model, casted to its actual Type
	 */
	public Service getCastedModel() {
		return (Service) ((View) getModel()).getElement();
	}

	public abstract ServiceFigure getPrimaryShape();
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		return new ServiceFigure(
				getCastedModel().getUser() != null,
				getCastedModel().isMultiple()
				);
	}

}
