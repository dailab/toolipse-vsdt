package de.dailab.vsdt.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.diagram.edit.parts.MessageFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowNameEditPart;
import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;

/**
 * @generated
 */
public class MessageFlowViewFactory extends ConnectionViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createRoutingStyle());
		styles.add(NotationFactory.eINSTANCE.createFontStyle());
		return styles;
	}

	/**
	 * @generated NOT
	 */
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		if (semanticHint == null) {
			semanticHint = VsdtVisualIDRegistry
					.getType(MessageFlowEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService()
				.createNode(
						eObjectAdapter,
						view,
						VsdtVisualIDRegistry
								.getType(MessageFlowNameEditPart.VISUAL_ID),
						ViewUtil.APPEND, true, getPreferencesHint());

		/*
		 * another way of setting the initial routing style
		 * now moved to PropertiesInitializer, which seems to be the cleaner way
		 */
		//		//rectilinear routing
		//		NotationPackage NOTATION = NotationPackage.eINSTANCE;
		//		EClass routingStyle = NOTATION.getRoutingStyle();
		//		RoutingStyle routing = (RoutingStyle) view.getStyle(routingStyle);
		//		if (routing == null) {
		//			routing = (RoutingStyle) view.createStyle(routingStyle);
		//		}
		//		routing.setRouting(Routing.RECTILINEAR_LITERAL);
	}
}
