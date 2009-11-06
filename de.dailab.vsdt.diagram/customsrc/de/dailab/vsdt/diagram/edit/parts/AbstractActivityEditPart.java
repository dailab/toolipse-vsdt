package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.policies.DoubleClickOrgAssignEditPolicy;
import de.dailab.vsdt.diagram.figures.ActivityFigure;
import de.dailab.vsdt.util.VsdtHelper;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractActivityEditPart extends AbstractVsdtBorderedShapeEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractActivityEditPart(View view) {
		super(view);
	}
	
	/**
	 * notify the edit part when there are changes to the model
	 * - when the LoopType, the ActivityType or the AdHoc, Compensation or Transaction fields change, forward the change to the figure
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES:
			getPrimaryShape().setLoopType(VsdtHelper.toLoopType(getCastedModel().getLoopAttributes()));;
			break;
		case VsdtPackage.ACTIVITY__AD_HOC:
			getPrimaryShape().setAdHoc(getCastedModel().isAdHoc());
			break;
		case VsdtPackage.ACTIVITY__ACTIVITY_TYPE:
			getPrimaryShape().setActivityType(getCastedModel().getActivityType());
			break;
		case VsdtPackage.ACTIVITY__TRANSACTION:
			getPrimaryShape().setTransaction(getCastedModel().getTransaction() != null);
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
			getPrimaryShape().setDepth(VsdtHelper.getDepth(getCastedModel()));
			break;
		}
		if (feature != VsdtPackage.ACTIVITY__BOUNDARY_EVENTS) {
			// problem with refreshing in this case since GMF 2.1
			refreshVisuals();
		}
	}
	
	/**
	 * Overriding this method fixes the bug <https://bugs.eclipse.org/bugs/show_bug.cgi?id=202894> that affixed-parent-
	 * side children may disappear, when deleting other than that one last inserted into the container, e.g. when creating
	 * boundary events A, B and C (in this order) and deleting B, C would disappear and re-appear only on saving and
	 * reopening the diagram. In this case this method invokes kind of a super-repaint.
	 * 
	 * Note: If the second check for the reference feature is omitted then this fix will cause a severe bug when
	 * removing elements other than the boundary event handler intermediate event! 
	 * 
	 * Update: This bug seems to be resolved in GMF 2.1.
	 * For now, keeping this method just in case...
	 * 
	 * @generated NOT
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
//		if (notification.getEventType() == Notification.REMOVE
//				&& notification.getFeature() == VsdtPackage.eINSTANCE
//						.getActivity_BoundaryEvents()) {
//			handleMajorSemanticChange();
//		}
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
		Activity activity= getCastedModel();
		ActivityFigure figure= new ActivityFigure(
				VsdtHelper.toLoopType(activity.getLoopAttributes()),
				activity.getActivityType(),
				activity.isAdHoc(),
				activity.getTransaction() != null,
				activity.isIsCompensation(),
				! activity.getAssignments().isEmpty(),
				! activity.getProperties().isEmpty(),
				VsdtHelper.getDepth(activity));
		return figure;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,new DoubleClickOrgAssignEditPolicy());
//		installEditPolicy(EditPolicyRoles.OPEN_ROLE,new OpenDiagramEditPolicy());
	}
	
}
