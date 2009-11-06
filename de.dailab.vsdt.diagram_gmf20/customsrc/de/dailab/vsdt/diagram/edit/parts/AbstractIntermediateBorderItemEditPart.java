package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.policies.DoubleClickOrgAssignEditPolicy;
import de.dailab.vsdt.diagram.figures.EventFigure;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.preferences.DiagramPreferenceInitializer;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractIntermediateBorderItemEditPart extends AbstractBorderItemEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractIntermediateBorderItemEditPart(View view) {
		super(view);
	}
	
	/**
	 * notify the edit part when there are changes to the model
	 * - when the trigger has changed, set the figures trigger accordingly
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.INTERMEDIATE__TRIGGER:
			getPrimaryShape().setTriggerType(getCastedModel().getTrigger().getValue());
			refreshVisuals();
			break;
		}
	}

	/**
	 * @return the model, casted to its actual Type
	 */
	public Intermediate getCastedModel() {
		return (Intermediate) ((View) getModel()).getElement();
	}

	public abstract EventFigure getPrimaryShape();
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		boolean useColor=
			VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(
			DiagramPreferenceInitializer.PREF_USE_ADDITIONAL_COLORS);
		EventFigure figure= new EventFigure(useColor, EventFigure.INTERMEDIATE, getCastedModel()
				.getTrigger().getValue());
		return figure;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,new DoubleClickOrgAssignEditPolicy());
	}
}
