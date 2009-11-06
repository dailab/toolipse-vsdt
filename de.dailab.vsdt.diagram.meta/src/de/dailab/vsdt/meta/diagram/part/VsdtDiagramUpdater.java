package de.dailab.vsdt.meta.diagram.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessSystemEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantAssociatedProcessesEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantEditPart;
import de.dailab.vsdt.meta.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class VsdtDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case BusinessProcessSystemEditPart.VISUAL_ID:
			return getBusinessProcessSystem_79SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBusinessProcessSystem_79SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		BusinessProcessSystem modelElement = (BusinessProcessSystem) view
				.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getParticipants().iterator(); it
				.hasNext();) {
			Participant childElement = (Participant) it.next();
			int visualID = VsdtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == ParticipantEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		for (Iterator it = modelElement.getBusinessProcesses().iterator(); it
				.hasNext();) {
			BusinessProcessDiagram childElement = (BusinessProcessDiagram) it
					.next();
			int visualID = VsdtVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == BusinessProcessDiagramEditPart.VISUAL_ID) {
				result.add(new VsdtNodeDescriptor(childElement, visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case BusinessProcessSystemEditPart.VISUAL_ID:
			return getBusinessProcessSystem_79ContainedLinks(view);
		case ParticipantEditPart.VISUAL_ID:
			return getParticipant_1001ContainedLinks(view);
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return getBusinessProcessDiagram_1002ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case ParticipantEditPart.VISUAL_ID:
			return getParticipant_1001IncomingLinks(view);
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return getBusinessProcessDiagram_1002IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (VsdtVisualIDRegistry.getVisualID(view)) {
		case ParticipantEditPart.VISUAL_ID:
			return getParticipant_1001OutgoingLinks(view);
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return getBusinessProcessDiagram_1002OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBusinessProcessSystem_79ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getParticipant_1001ContainedLinks(View view) {
		Participant modelElement = (Participant) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Participant_AssociatedProcesses_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBusinessProcessDiagram_1002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getParticipant_1001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getBusinessProcessDiagram_1002IncomingLinks(View view) {
		BusinessProcessDiagram modelElement = (BusinessProcessDiagram) view
				.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result
				.addAll(getIncomingFeatureModelFacetLinks_Participant_AssociatedProcesses_3001(
						modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getParticipant_1001OutgoingLinks(View view) {
		Participant modelElement = (Participant) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingFeatureModelFacetLinks_Participant_AssociatedProcesses_3001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getBusinessProcessDiagram_1002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingFeatureModelFacetLinks_Participant_AssociatedProcesses_3001(
			BusinessProcessDiagram target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() == VsdtPackage.eINSTANCE
					.getParticipant_AssociatedProcesses()) {
				result.add(new VsdtLinkDescriptor(setting.getEObject(), target,
						VsdtElementTypes.ParticipantAssociatedProcesses_3001,
						ParticipantAssociatedProcessesEditPart.VISUAL_ID));
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingFeatureModelFacetLinks_Participant_AssociatedProcesses_3001(
			Participant source) {
		Collection result = new LinkedList();
		for (Iterator destinations = source.getAssociatedProcesses().iterator(); destinations
				.hasNext();) {
			BusinessProcessDiagram destination = (BusinessProcessDiagram) destinations
					.next();
			result.add(new VsdtLinkDescriptor(source, destination,
					VsdtElementTypes.ParticipantAssociatedProcesses_3001,
					ParticipantAssociatedProcessesEditPart.VISUAL_ID));
		}
		return result;
	}

}
