package de.dailab.vsdt.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.common.gmf.edit.part.AbstractGmfConnectionEditPart;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.figures.SequenceFlowFigure;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditorPlugin;
import de.dailab.vsdt.diagram.preferences.DiagramAppearancePreferencePage;


/**
 * this abstract edit part shall be subclassed by the actual edit part used by GMF
 * it contains most of the customizations necessary for the edit part and facilitates
 * the recreation of the editor
 */
public abstract class AbstractSequenceFlowEditPart extends AbstractGmfConnectionEditPart implements IVsdtEditPart {

	/**
	 * the standard constructor
	 */
	public AbstractSequenceFlowEditPart(View view) {
		super(view);
	}
	
	/**
	 * notify the edit part when there are changes to the model
	 * - when the condition type changes, forward the change to the figure
	 * - when the source changes, check if the source if a gateway and set the figure accordingly
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int feature = notification.getFeatureID(VsdtPackage.class);
		switch (feature) {
		case VsdtPackage.SEQUENCE_FLOW__CONDITION_TYPE:
			((SequenceFlowFigure)getFigure()).setConditionType(getCastedModel().getConditionType());
			refreshVisuals();
			break;
		case VsdtPackage.SEQUENCE_FLOW__SOURCE:
			if (getCastedModel() != null) {
				((SequenceFlowFigure)getFigure()).setSourceIsGateway(getCastedModel().getSource() instanceof Gateway);
				refreshVisuals();
			}
			break;
		}
	}
	
	/**
	 * @return the model, casted to its actual Type
	 */
	public SequenceFlow getCastedModel() {
		return (SequenceFlow) ((View)getModel()).getElement();
	}
	
	/**
	 * Creates figure for this edit part.
	 * sets all fields depending on the underlying model
	 */
	protected Connection createConnectionFigure() {
		boolean useColor= 
			VsdtDiagramEditorPlugin.getInstance().getPreferenceStore().getBoolean(
					DiagramAppearancePreferencePage.PREF_USE_ADDITIONAL_COLORS);
		SequenceFlowFigure figure= new SequenceFlowFigure(useColor, getCastedModel().getConditionType(),
				getCastedModel().getSource() instanceof Gateway);
		return figure;
	}
	
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		//mac1
		installEditPolicy(EditPolicyRoles.REFRESH_CONNECTIONS_ROLE,new ConnectionBendpointEditPolicy());
//		installEditPolicy(EditPolicyRoles.OPEN_ROLE,new DoubleClickOrgAssignEditPolicy());
	}

}
