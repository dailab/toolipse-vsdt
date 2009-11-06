package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.AbstractGmfBorderedShapeEditPart;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.policies.DoubleClickOrgAssignEditPolicy;
import de.dailab.vsdt.diagram.figures.ActivityFigure;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.preferences.DiagramPreferenceInitializer;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractActivityEditPart extends AbstractGmfBorderedShapeEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractActivityEditPart(View view) {
		super(view);
	}
	
	/**
	 * notify the edit part when there are changes to the model
	 * - when the LoopType, the ActivityType or the AdHoc, Compensation or Transaction fields change, forward the change to the figure
	 * - when boundary events are added or removed, notify the figure whether the border compartment has to be shown  
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.ACTIVITY__LOOP_TYPE:
			getPrimaryShape().setLoopType(getCastedModel().getLoopType());;
			break;
		case VsdtPackage.ACTIVITY__AD_HOC:
			getPrimaryShape().setAdHoc(getCastedModel().isAdHoc());
			break;
		case VsdtPackage.ACTIVITY__ACTIVITY_TYPE:
			getPrimaryShape().setActivityType(getCastedModel().getActivityType());
			break;
		case VsdtPackage.ACTIVITY__IS_TRANSACTION:
			getPrimaryShape().setTransaction(getCastedModel().isIsTransaction());
			break;
		case VsdtPackage.NODE__INCOMING_ASS:
			getCastedModel().calculateIsCompensation();
			break;
		case VsdtPackage.ACTIVITY__IS_COMPENSATION:
			getPrimaryShape().setCompensation(getCastedModel().isIsCompensation());
			break;
		case VsdtPackage.FLOW_OBJECT__ASSIGNMENTS:
			getPrimaryShape().setHasAssignments(! getCastedModel().getAssignments().isEmpty());
			break;
		case VsdtPackage.ACTIVITY__PROPERTIES:
			getPrimaryShape().setHasProperties(! getCastedModel().getProperties().isEmpty());
			break;
		case VsdtPackage.ACTIVITY__FLOW_OBJECT_CONTAINER:
			getPrimaryShape().setDepth(getCastedModel().getDepth());
			break;
		}
		refreshVisuals();
	}
	
	/**
	 * @return the model, casted to its actual Type
	 */
	public Activity getCastedModel() {
		return (Activity) ((View) getModel()).getElement();
	}

	public abstract ActivityFigure getPrimaryShape();
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected IFigure initNodeShape() {
		boolean useColor=
			VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(
			DiagramPreferenceInitializer.PREF_USE_ADDITIONAL_COLORS);
		boolean useIcons=
			VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(
			DiagramPreferenceInitializer.PREF_USE_ACTIVITY_ICONS);
		Activity activity= getCastedModel();
		ActivityFigure figure= new ActivityFigure(
				useColor,
				useIcons,
				activity.getLoopType(),
				activity.getActivityType(),
				activity.isAdHoc(),
				activity.isIsTransaction(),
				activity.isIsCompensation(),
				! activity.getAssignments().isEmpty(),
				! activity.getProperties().isEmpty(),
				activity.getDepth());
		return figure;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,new DoubleClickOrgAssignEditPolicy());
	}
}
