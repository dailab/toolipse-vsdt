package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.AbstractGmfConnectionEditPart;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.figures.AssociationFigure;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractAssociationEditPart extends AbstractGmfConnectionEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractAssociationEditPart(View view) {
		super(view);
	}

	/**
	 * notify the edit part when there are changes to the model
	 * - if the direction changed, update the figures decorators
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.ASSOCIATION__DIRECTION:
			((AssociationFigure)getFigure()).setDirectionType(getCastedModel().getDirection());
			refreshVisuals();
		}
	}
	
	/**
	 * @return the model, casted to its actual Type
	 */
	public Association getCastedModel() {
		return (Association) ((View)getModel()).getElement();
	}
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected Connection createConnectionFigure() {
		AssociationFigure figure= new AssociationFigure(getCastedModel().getDirection());
		return figure;
	}
	
}
