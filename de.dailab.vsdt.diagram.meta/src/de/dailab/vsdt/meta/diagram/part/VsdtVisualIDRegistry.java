package de.dailab.vsdt.meta.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessDiagramNameEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessSystemEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantNameEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class VsdtVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "de.dailab.vsdt.diagram.meta/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (BusinessProcessSystemEditPart.MODEL_ID.equals(view.getType())) {
				return BusinessProcessSystemEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return de.dailab.vsdt.meta.diagram.part.VsdtVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				VsdtMetaDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (VsdtPackage.eINSTANCE.getBusinessProcessSystem().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((BusinessProcessSystem) domainElement)) {
			return BusinessProcessSystemEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = de.dailab.vsdt.meta.diagram.part.VsdtVisualIDRegistry
				.getModelID(containerView);
		if (!BusinessProcessSystemEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (BusinessProcessSystemEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.dailab.vsdt.meta.diagram.part.VsdtVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = BusinessProcessSystemEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case BusinessProcessSystemEditPart.VISUAL_ID:
			if (VsdtPackage.eINSTANCE.getParticipant().isSuperTypeOf(
					domainElement.eClass())) {
				return ParticipantEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getBusinessProcessDiagram()
					.isSuperTypeOf(domainElement.eClass())) {
				return BusinessProcessDiagramEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = de.dailab.vsdt.meta.diagram.part.VsdtVisualIDRegistry
				.getModelID(containerView);
		if (!BusinessProcessSystemEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (BusinessProcessSystemEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.dailab.vsdt.meta.diagram.part.VsdtVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = BusinessProcessSystemEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case ParticipantEditPart.VISUAL_ID:
			if (ParticipantNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			if (BusinessProcessDiagramNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BusinessProcessSystemEditPart.VISUAL_ID:
			if (ParticipantEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (BusinessProcessDiagramEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(BusinessProcessSystem element) {
		return true;
	}

}
