package de.dailab.vsdt.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.commands.LaneCreateCommand;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class PoolPoolCompartmentItemSemanticEditPolicy extends
		VsdtBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (VsdtElementTypes.Lane_2001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(VsdtPackage.eINSTANCE
								.getPool_Lanes());
			}
			return getGEFWrapper(new LaneCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
