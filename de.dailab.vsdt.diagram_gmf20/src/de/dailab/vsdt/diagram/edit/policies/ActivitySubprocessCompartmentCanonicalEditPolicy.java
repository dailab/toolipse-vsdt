package de.dailab.vsdt.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.parts.ActivityEditPart;
import de.dailab.vsdt.diagram.edit.parts.EndEditPart;
import de.dailab.vsdt.diagram.edit.parts.GatewayEditPart;
import de.dailab.vsdt.diagram.edit.parts.IntermediateEditPart;
import de.dailab.vsdt.diagram.edit.parts.StartEditPart;
import de.dailab.vsdt.diagram.part.VsdtDiagramUpdater;
import de.dailab.vsdt.diagram.part.VsdtNodeDescriptor;
import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;

/**
 * @generated
 */
public class ActivitySubprocessCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = VsdtDiagramUpdater
				.getActivitySubprocessCompartment_5003SemanticChildren(
						viewObject).iterator(); it.hasNext();) {
			result.add(((VsdtNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = VsdtVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case ActivityEditPart.VISUAL_ID:
		case EndEditPart.VISUAL_ID:
		case GatewayEditPart.VISUAL_ID:
		case IntermediateEditPart.VISUAL_ID:
		case StartEditPart.VISUAL_ID:
			return !semanticChildren.contains(view.getElement())
					|| visualID != VsdtVisualIDRegistry.getNodeVisualID(
							(View) getHost().getModel(), view.getElement());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(VsdtPackage.eINSTANCE
					.getFlowObjectContainer_ContainedFlowObjects());
		}
		return myFeaturesToSynchronize;
	}

}
