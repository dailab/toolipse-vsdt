package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.AbstractGmfBorderedShapeEditPart;
import de.dailab.vsdt.Agent;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.figures.AgentFigure;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractAgentEditPart extends AbstractGmfBorderedShapeEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractAgentEditPart(View view) {
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
		case VsdtPackage.AGENT__TYPE:
			getPrimaryShape().setType(getCastedModel().getType());
			refreshVisuals();
			break;
		}
	}
	
	/**
	 * @return the model, casted to its actual Type
	 */
	public Agent getCastedModel() {
		return (Agent) ((View) getModel()).getElement();
	}

	public abstract AgentFigure getPrimaryShape();
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		return new AgentFigure(
				getCastedModel().getType()
				);
	}

}
