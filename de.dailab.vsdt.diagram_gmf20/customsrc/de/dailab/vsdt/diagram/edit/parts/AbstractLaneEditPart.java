package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.AbstractGmfNodeEditPart;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.figures.SwimlaneFigure;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.preferences.DiagramPreferenceInitializer;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractLaneEditPart extends AbstractGmfNodeEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractLaneEditPart(View view) {
		super(view);
	}

	/**
	 * notify the edit part when there are changes to the model
	 * 
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.LANE__BOUNDARY_VISIBLE:
			getPrimaryShape().setBoundaryVisible(getCastedModel().isBoundaryVisible());;
			refreshVisuals();
			break;
		}
	}
	
	/**
	 * @return the model, casted to its actual Type
	 */
	public Lane getCastedModel() {
		return (Lane) ((View) getModel()).getElement();
	}

	public abstract SwimlaneFigure getPrimaryShape();

	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		boolean useColor=
			VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(
			DiagramPreferenceInitializer.PREF_USE_ADDITIONAL_COLORS);
		SwimlaneFigure figure= new SwimlaneFigure(useColor, false,
				getCastedModel().isBoundaryVisible());
		return figure;
	}
}
