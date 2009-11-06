package de.dailab.vsdt.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

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
import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;
import de.dailab.vsdt.diagram.view.factories.ActivityNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.ActivitySubprocessCompartmentViewFactory;
import de.dailab.vsdt.diagram.view.factories.ActivityViewFactory;
import de.dailab.vsdt.diagram.view.factories.AgentNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.AgentViewFactory;
import de.dailab.vsdt.diagram.view.factories.AssociationNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.AssociationViewFactory;
import de.dailab.vsdt.diagram.view.factories.BusinessProcessDiagramViewFactory;
import de.dailab.vsdt.diagram.view.factories.DataObjectNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.DataObjectViewFactory;
import de.dailab.vsdt.diagram.view.factories.EndNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.EndViewFactory;
import de.dailab.vsdt.diagram.view.factories.GatewayNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.GatewayViewFactory;
import de.dailab.vsdt.diagram.view.factories.GroupViewFactory;
import de.dailab.vsdt.diagram.view.factories.Intermediate2ViewFactory;
import de.dailab.vsdt.diagram.view.factories.IntermediateNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.IntermediateViewFactory;
import de.dailab.vsdt.diagram.view.factories.LaneLaneCompartmentViewFactory;
import de.dailab.vsdt.diagram.view.factories.LaneNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.LaneViewFactory;
import de.dailab.vsdt.diagram.view.factories.MessageFlowNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.MessageFlowViewFactory;
import de.dailab.vsdt.diagram.view.factories.PoolNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.PoolPoolCompartmentViewFactory;
import de.dailab.vsdt.diagram.view.factories.PoolViewFactory;
import de.dailab.vsdt.diagram.view.factories.SequenceFlowNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.SequenceFlowViewFactory;
import de.dailab.vsdt.diagram.view.factories.ServiceNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.ServiceViewFactory;
import de.dailab.vsdt.diagram.view.factories.StartNameViewFactory;
import de.dailab.vsdt.diagram.view.factories.StartViewFactory;
import de.dailab.vsdt.diagram.view.factories.TextAnnotationTextViewFactory;
import de.dailab.vsdt.diagram.view.factories.TextAnnotationViewFactory;

/**
 * @generated
 */
public class VsdtViewProvider extends AbstractViewProvider {

	/**
	 * @generated
	 */
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		EObject semanticElement = getSemanticElement(semanticAdapter);
		if (BusinessProcessDiagramEditPart.MODEL_ID.equals(diagramKind)
				&& VsdtVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return BusinessProcessDiagramViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (containerView == null) {
			return null;
		}
		IElementType elementType = getSemanticElementType(semanticAdapter);
		EObject domainElement = getSemanticElement(semanticAdapter);
		int visualID;
		if (semanticHint == null) {
			// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
			// In this situation there should be NO elementType, visualID will be determined
			// by VisualIDRegistry.getNodeVisualID() for domainElement.
			if (elementType != null || domainElement == null) {
				return null;
			}
			visualID = VsdtVisualIDRegistry.getNodeVisualID(containerView,
					domainElement);
		} else {
			visualID = VsdtVisualIDRegistry.getVisualID(semanticHint);
			if (elementType != null) {
				// Semantic hint is specified together with element type.
				// Both parameters should describe exactly the same diagram element.
				// In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
				// domainElement (if specified) is the same as in element type.
				if (!VsdtElementTypes.isKnownElementType(elementType)
						|| (!(elementType instanceof IHintedType))) {
					return null; // foreign element type
				}
				String elementTypeHint = ((IHintedType) elementType)
						.getSemanticHint();
				if (!semanticHint.equals(elementTypeHint)) {
					return null; // if semantic hint is specified it should be the same as in element type
				}
				if (domainElement != null
						&& visualID != VsdtVisualIDRegistry.getNodeVisualID(
								containerView, domainElement)) {
					return null; // visual id for node EClass should match visual id from element type
				}
			} else {
				// Element type is not specified. Domain element should be present (except pure design elements).
				// This method is called with EObjectAdapter as parameter from:
				//   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
				//   - generated ViewFactory.decorateView() for parent element
				if (!BusinessProcessDiagramEditPart.MODEL_ID
						.equals(VsdtVisualIDRegistry.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case GroupEditPart.VISUAL_ID:
				case TextAnnotationEditPart.VISUAL_ID:
				case DataObjectEditPart.VISUAL_ID:
				case PoolEditPart.VISUAL_ID:
				case AgentEditPart.VISUAL_ID:
				case ServiceEditPart.VISUAL_ID:
				case LaneEditPart.VISUAL_ID:
				case StartEditPart.VISUAL_ID:
				case IntermediateEditPart.VISUAL_ID:
				case EndEditPart.VISUAL_ID:
				case ActivityEditPart.VISUAL_ID:
				case GatewayEditPart.VISUAL_ID:
				case Intermediate2EditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != VsdtVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case TextAnnotationTextEditPart.VISUAL_ID:
					if (TextAnnotationEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case DataObjectNameEditPart.VISUAL_ID:
					if (DataObjectEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case PoolNameEditPart.VISUAL_ID:
				case PoolPoolCompartmentEditPart.VISUAL_ID:
					if (PoolEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AgentNameEditPart.VISUAL_ID:
					if (AgentEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ServiceNameEditPart.VISUAL_ID:
					if (ServiceEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case LaneNameEditPart.VISUAL_ID:
				case LaneLaneCompartmentEditPart.VISUAL_ID:
					if (LaneEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case StartNameEditPart.VISUAL_ID:
					if (StartEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case IntermediateNameEditPart.VISUAL_ID:
					if (IntermediateEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case EndNameEditPart.VISUAL_ID:
					if (EndEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case ActivityNameEditPart.VISUAL_ID:
				case ActivitySubprocessCompartmentEditPart.VISUAL_ID:
					if (ActivityEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case GatewayNameEditPart.VISUAL_ID:
					if (GatewayEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case SequenceFlowNameEditPart.VISUAL_ID:
					if (SequenceFlowEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case MessageFlowNameEditPart.VISUAL_ID:
					if (MessageFlowEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case AssociationNameEditPart.VISUAL_ID:
					if (AssociationEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				default:
					return null;
				}
			}
		}
		return getNodeViewClass(containerView, visualID);
	}

	/**
	 * @generated
	 */
	protected Class getNodeViewClass(View containerView, int visualID) {
		if (containerView == null
				|| !VsdtVisualIDRegistry.canCreateNode(containerView, visualID)) {
			return null;
		}
		switch (visualID) {
		case GroupEditPart.VISUAL_ID:
			return GroupViewFactory.class;
		case TextAnnotationEditPart.VISUAL_ID:
			return TextAnnotationViewFactory.class;
		case TextAnnotationTextEditPart.VISUAL_ID:
			return TextAnnotationTextViewFactory.class;
		case DataObjectEditPart.VISUAL_ID:
			return DataObjectViewFactory.class;
		case DataObjectNameEditPart.VISUAL_ID:
			return DataObjectNameViewFactory.class;
		case PoolEditPart.VISUAL_ID:
			return PoolViewFactory.class;
		case PoolNameEditPart.VISUAL_ID:
			return PoolNameViewFactory.class;
		case AgentEditPart.VISUAL_ID:
			return AgentViewFactory.class;
		case AgentNameEditPart.VISUAL_ID:
			return AgentNameViewFactory.class;
		case ServiceEditPart.VISUAL_ID:
			return ServiceViewFactory.class;
		case ServiceNameEditPart.VISUAL_ID:
			return ServiceNameViewFactory.class;
		case LaneEditPart.VISUAL_ID:
			return LaneViewFactory.class;
		case LaneNameEditPart.VISUAL_ID:
			return LaneNameViewFactory.class;
		case StartEditPart.VISUAL_ID:
			return StartViewFactory.class;
		case StartNameEditPart.VISUAL_ID:
			return StartNameViewFactory.class;
		case IntermediateEditPart.VISUAL_ID:
			return IntermediateViewFactory.class;
		case IntermediateNameEditPart.VISUAL_ID:
			return IntermediateNameViewFactory.class;
		case EndEditPart.VISUAL_ID:
			return EndViewFactory.class;
		case EndNameEditPart.VISUAL_ID:
			return EndNameViewFactory.class;
		case ActivityEditPart.VISUAL_ID:
			return ActivityViewFactory.class;
		case ActivityNameEditPart.VISUAL_ID:
			return ActivityNameViewFactory.class;
		case GatewayEditPart.VISUAL_ID:
			return GatewayViewFactory.class;
		case GatewayNameEditPart.VISUAL_ID:
			return GatewayNameViewFactory.class;
		case Intermediate2EditPart.VISUAL_ID:
			return Intermediate2ViewFactory.class;
		case PoolPoolCompartmentEditPart.VISUAL_ID:
			return PoolPoolCompartmentViewFactory.class;
		case LaneLaneCompartmentEditPart.VISUAL_ID:
			return LaneLaneCompartmentViewFactory.class;
		case ActivitySubprocessCompartmentEditPart.VISUAL_ID:
			return ActivitySubprocessCompartmentViewFactory.class;
		case SequenceFlowNameEditPart.VISUAL_ID:
			return SequenceFlowNameViewFactory.class;
		case MessageFlowNameEditPart.VISUAL_ID:
			return MessageFlowNameViewFactory.class;
		case AssociationNameEditPart.VISUAL_ID:
			return AssociationNameViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		IElementType elementType = getSemanticElementType(semanticAdapter);
		if (!VsdtElementTypes.isKnownElementType(elementType)
				|| (!(elementType instanceof IHintedType))) {
			return null; // foreign element type
		}
		String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
		if (elementTypeHint == null) {
			return null; // our hint is visual id and must be specified
		}
		if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
			return null; // if semantic hint is specified it should be the same as in element type
		}
		int visualID = VsdtVisualIDRegistry.getVisualID(elementTypeHint);
		EObject domainElement = getSemanticElement(semanticAdapter);
		if (domainElement != null
				&& visualID != VsdtVisualIDRegistry
						.getLinkWithClassVisualID(domainElement)) {
			return null; // visual id for link EClass should match visual id from element type
		}
		return getEdgeViewClass(visualID);
	}

	/**
	 * @generated
	 */
	protected Class getEdgeViewClass(int visualID) {
		switch (visualID) {
		case SequenceFlowEditPart.VISUAL_ID:
			return SequenceFlowViewFactory.class;
		case MessageFlowEditPart.VISUAL_ID:
			return MessageFlowViewFactory.class;
		case AssociationEditPart.VISUAL_ID:
			return AssociationViewFactory.class;
		}
		return null;
	}

	/**
	 * @generated
	 */
	private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (IElementType) semanticAdapter.getAdapter(IElementType.class);
	}
}
