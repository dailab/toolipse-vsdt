package de.dailab.vsdt.meta.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessDiagramEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessDiagramNameEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.BusinessProcessSystemEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantAssociatedProcessesEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantEditPart;
import de.dailab.vsdt.meta.diagram.edit.parts.ParticipantNameEditPart;
import de.dailab.vsdt.meta.diagram.part.VsdtVisualIDRegistry;
import de.dailab.vsdt.meta.diagram.view.factories.BusinessProcessDiagramNameViewFactory;
import de.dailab.vsdt.meta.diagram.view.factories.BusinessProcessDiagramViewFactory;
import de.dailab.vsdt.meta.diagram.view.factories.BusinessProcessSystemViewFactory;
import de.dailab.vsdt.meta.diagram.view.factories.ParticipantAssociatedProcessesViewFactory;
import de.dailab.vsdt.meta.diagram.view.factories.ParticipantNameViewFactory;
import de.dailab.vsdt.meta.diagram.view.factories.ParticipantViewFactory;

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
		if (BusinessProcessSystemEditPart.MODEL_ID.equals(diagramKind)
				&& VsdtVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
			return BusinessProcessSystemViewFactory.class;
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
				if (!BusinessProcessSystemEditPart.MODEL_ID
						.equals(VsdtVisualIDRegistry.getModelID(containerView))) {
					return null; // foreign diagram
				}
				switch (visualID) {
				case ParticipantEditPart.VISUAL_ID:
				case BusinessProcessDiagramEditPart.VISUAL_ID:
					if (domainElement == null
							|| visualID != VsdtVisualIDRegistry
									.getNodeVisualID(containerView,
											domainElement)) {
						return null; // visual id in semantic hint should match visual id for domain element
					}
					break;
				case ParticipantNameEditPart.VISUAL_ID:
					if (ParticipantEditPart.VISUAL_ID != VsdtVisualIDRegistry
							.getVisualID(containerView)
							|| containerView.getElement() != domainElement) {
						return null; // wrong container
					}
					break;
				case BusinessProcessDiagramNameEditPart.VISUAL_ID:
					if (BusinessProcessDiagramEditPart.VISUAL_ID != VsdtVisualIDRegistry
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
		case ParticipantEditPart.VISUAL_ID:
			return ParticipantViewFactory.class;
		case ParticipantNameEditPart.VISUAL_ID:
			return ParticipantNameViewFactory.class;
		case BusinessProcessDiagramEditPart.VISUAL_ID:
			return BusinessProcessDiagramViewFactory.class;
		case BusinessProcessDiagramNameEditPart.VISUAL_ID:
			return BusinessProcessDiagramNameViewFactory.class;
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
		case ParticipantAssociatedProcessesEditPart.VISUAL_ID:
			return ParticipantAssociatedProcessesViewFactory.class;
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
