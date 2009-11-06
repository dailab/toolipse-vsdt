package de.dailab.vsdt.diagram.edit.commands;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.preferences.DiagramAppearancePreferencePage;

/**
 * @generated
 */
public class GatewayCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	public GatewayCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest) getRequest())
				.getContainer();
		if (container instanceof View) {
			container = ((View) container).getElement();
		}
		return container;
	}

	/**
	 * @generated
	 */
	protected EClass getEClassToEdit() {
		return VsdtPackage.eINSTANCE.getFlowObjectContainer();
	}

	/**
	 * set marker visible, or not
	 * 
	 * @generated NOT
	 */
	protected EObject doDefaultElementCreation() {
		Gateway newElement = (Gateway) super.doDefaultElementCreation();
		if (newElement != null) {
			boolean markerVisible = DiagramAppearancePreferencePage
					.isShowXorMarkerByDefault();
			newElement.setMarkerVisible(markerVisible);
		}
		return newElement;
	}
}
