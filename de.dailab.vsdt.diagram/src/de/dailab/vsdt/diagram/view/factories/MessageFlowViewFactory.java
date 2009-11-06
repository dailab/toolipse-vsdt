package de.dailab.vsdt.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

import de.dailab.vsdt.diagram.edit.parts.MessageFlowEditPart;
import de.dailab.vsdt.diagram.edit.parts.MessageFlowNameEditPart;
import de.dailab.vsdt.diagram.part.VsdtVisualIDRegistry;
import de.dailab.vsdt.diagram.preferences.DiagramConnectionsPreferencePage;

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
	 * @generated
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
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected void initializeFromPreferences(View view) {
		super.initializeFromPreferences(view);

		IPreferenceStore store = (IPreferenceStore) getPreferencesHint()
				.getPreferenceStore();

		RoutingStyle routingStyle = (RoutingStyle) view
				.getStyle(NotationPackage.Literals.ROUTING_STYLE);
		if (routingStyle != null) {
			Routing routing = Routing
					.get(store
							.getInt(DiagramConnectionsPreferencePage.PREF_ROUTING_MESSAGE));
			if (routing != null) {
				routingStyle.setRouting(routing);
			}
		}
	}
}
