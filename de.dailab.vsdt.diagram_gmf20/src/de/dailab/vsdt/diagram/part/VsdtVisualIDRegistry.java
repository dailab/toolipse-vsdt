package de.dailab.vsdt.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.parts.ActivityEditPart;
import de.dailab.vsdt.diagram.edit.parts.ActivityNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.ActivitySubprocessCompartmentEditPart;
import de.dailab.vsdt.diagram.edit.parts.AgentEditPart;
import de.dailab.vsdt.diagram.edit.parts.AgentNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.AssociationEditPart;
import de.dailab.vsdt.diagram.edit.parts.AssociationNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.diagram.edit.parts.DataObjectEditPart;
import de.dailab.vsdt.diagram.edit.parts.DataObjectNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.EndEditPart;
import de.dailab.vsdt.diagram.edit.parts.EndNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.GatewayEditPart;
import de.dailab.vsdt.diagram.edit.parts.GatewayNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.GroupEditPart;
import de.dailab.vsdt.diagram.edit.parts.Intermediate2EditPart;
import de.dailab.vsdt.diagram.edit.parts.IntermediateEditPart;
import de.dailab.vsdt.diagram.edit.parts.IntermediateNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.LaneEditPart;
import de.dailab.vsdt.diagram.edit.parts.LaneLaneCompartmentEditPart;
import de.dailab.vsdt.diagram.edit.parts.LaneNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.PoolPoolCompartmentEditPart;
import de.dailab.vsdt.diagram.edit.parts.SequenceFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.SequenceFlowNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.ServiceEditPart;
import de.dailab.vsdt.diagram.edit.parts.ServiceNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.StartEditPart;
import de.dailab.vsdt.diagram.edit.parts.StartNameEditPart;
import de.dailab.vsdt.diagram.edit.parts.TextAnnotationEditPart;
import de.dailab.vsdt.diagram.edit.parts.TextAnnotationTextEditPart;
import de.dailab.vsdt.diagram.expressions.VsdtAbstractExpression;

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
	private static final String DEBUG_KEY = VsdtDiagramEditorPlugin
			.getInstance().getBundle().getSymbolicName()
			+ "/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (BusinessProcessDiagramEditPart.MODEL_ID.equals(view.getType())) {
				return BusinessProcessDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry
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
				VsdtDiagramEditorPlugin.getInstance().logError(
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
		if (VsdtPackage.eINSTANCE.getBusinessProcessDiagram().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((BusinessProcessDiagram) domainElement)) {
			return BusinessProcessDiagramEditPart.VISUAL_ID;
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
		String containerModelID = de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry
				.getModelID(containerView);
		if (!BusinessProcessDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (BusinessProcessDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = BusinessProcessDiagramEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case ActivityEditPart.VISUAL_ID:
			if (VsdtPackage.eINSTANCE.getIntermediate().isSuperTypeOf(
					domainElement.eClass())) {
				return Intermediate2EditPart.VISUAL_ID;
			}
			break;
		case PoolPoolCompartmentEditPart.VISUAL_ID:
			if (VsdtPackage.eINSTANCE.getLane().isSuperTypeOf(
					domainElement.eClass())) {
				return LaneEditPart.VISUAL_ID;
			}
			break;
		case LaneLaneCompartmentEditPart.VISUAL_ID:
			if (VsdtPackage.eINSTANCE.getStart().isSuperTypeOf(
					domainElement.eClass())) {
				return StartEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getIntermediate().isSuperTypeOf(
					domainElement.eClass())) {
				return IntermediateEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getEnd().isSuperTypeOf(
					domainElement.eClass())) {
				return EndEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getActivity().isSuperTypeOf(
					domainElement.eClass())) {
				return ActivityEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getGateway().isSuperTypeOf(
					domainElement.eClass())) {
				return GatewayEditPart.VISUAL_ID;
			}
			break;
		case ActivitySubprocessCompartmentEditPart.VISUAL_ID:
			if (VsdtPackage.eINSTANCE.getActivity().isSuperTypeOf(
					domainElement.eClass())) {
				return ActivityEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getEnd().isSuperTypeOf(
					domainElement.eClass())) {
				return EndEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getGateway().isSuperTypeOf(
					domainElement.eClass())) {
				return GatewayEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getIntermediate().isSuperTypeOf(
					domainElement.eClass())) {
				return IntermediateEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getStart().isSuperTypeOf(
					domainElement.eClass())) {
				return StartEditPart.VISUAL_ID;
			}
			break;
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			if (VsdtPackage.eINSTANCE.getGroup().isSuperTypeOf(
					domainElement.eClass())) {
				return GroupEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getTextAnnotation().isSuperTypeOf(
					domainElement.eClass())) {
				return TextAnnotationEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getDataObject().isSuperTypeOf(
					domainElement.eClass())) {
				return DataObjectEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getPool().isSuperTypeOf(
					domainElement.eClass())) {
				return PoolEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getAgent().isSuperTypeOf(
					domainElement.eClass())) {
				return AgentEditPart.VISUAL_ID;
			}
			if (VsdtPackage.eINSTANCE.getService().isSuperTypeOf(
					domainElement.eClass())) {
				return ServiceEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry
				.getModelID(containerView);
		if (!BusinessProcessDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (BusinessProcessDiagramEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = BusinessProcessDiagramEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case TextAnnotationEditPart.VISUAL_ID:
			if (TextAnnotationTextEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case DataObjectEditPart.VISUAL_ID:
			if (DataObjectNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PoolEditPart.VISUAL_ID:
			if (PoolNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PoolPoolCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AgentEditPart.VISUAL_ID:
			if (AgentNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ServiceEditPart.VISUAL_ID:
			if (ServiceNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LaneEditPart.VISUAL_ID:
			if (LaneNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (LaneLaneCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StartEditPart.VISUAL_ID:
			if (StartNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case IntermediateEditPart.VISUAL_ID:
			if (IntermediateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case EndEditPart.VISUAL_ID:
			if (EndNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivityEditPart.VISUAL_ID:
			if (ActivityNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivitySubprocessCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Intermediate2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case GatewayEditPart.VISUAL_ID:
			if (GatewayNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case PoolPoolCompartmentEditPart.VISUAL_ID:
			if (LaneEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case LaneLaneCompartmentEditPart.VISUAL_ID:
			if (StartEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IntermediateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EndEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ActivityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GatewayEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case ActivitySubprocessCompartmentEditPart.VISUAL_ID:
			if (ActivityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (EndEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (GatewayEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (IntermediateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StartEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			if (GroupEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TextAnnotationEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (DataObjectEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PoolEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (AgentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (ServiceEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SequenceFlowEditPart.VISUAL_ID:
			if (SequenceFlowNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MessageFlowEditPart.VISUAL_ID:
			if (MessageFlowNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case AssociationEditPart.VISUAL_ID:
			if (AssociationNameEditPart.VISUAL_ID == nodeVisualID) {
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
		if (VsdtPackage.eINSTANCE.getSequenceFlow().isSuperTypeOf(
				domainElement.eClass())) {
			return SequenceFlowEditPart.VISUAL_ID;
		}
		if (VsdtPackage.eINSTANCE.getMessageFlow().isSuperTypeOf(
				domainElement.eClass())) {
			return MessageFlowEditPart.VISUAL_ID;
		}
		if (VsdtPackage.eINSTANCE.getAssociation().isSuperTypeOf(
				domainElement.eClass())) {
			return AssociationEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(BusinessProcessDiagram element) {
		return true;
	}

	/**
	 * @generated
	 */
	private static boolean evaluate(VsdtAbstractExpression expression,
			Object element) {
		Object result = expression.evaluate(element);
		return result instanceof Boolean && ((Boolean) result).booleanValue();
	}

	/**
	 * @generated
	 */
	private static class JavaConstraints {

	}

}
