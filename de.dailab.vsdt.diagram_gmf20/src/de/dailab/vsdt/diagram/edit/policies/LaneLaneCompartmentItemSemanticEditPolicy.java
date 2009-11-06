package de.dailab.vsdt.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.commands.ActivityCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.EndCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.GatewayCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.IntermediateCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.StartCreateCommand;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class LaneLaneCompartmentItemSemanticEditPolicy extends
		VsdtBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (VsdtElementTypes.Start_2002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getFlowObjectContainer_ContainedFlowObjects());
			}
			return getGEFWrapper(new StartCreateCommand(req));
		}
		if (VsdtElementTypes.Intermediate_2003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getFlowObjectContainer_ContainedFlowObjects());
			}
			return getGEFWrapper(new IntermediateCreateCommand(req));
		}
		if (VsdtElementTypes.End_2004 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getFlowObjectContainer_ContainedFlowObjects());
			}
			return getGEFWrapper(new EndCreateCommand(req));
		}
		if (VsdtElementTypes.Activity_2005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getFlowObjectContainer_ContainedFlowObjects());
			}
			return getGEFWrapper(new ActivityCreateCommand(req));
		}
		if (VsdtElementTypes.Gateway_2006 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getFlowObjectContainer_ContainedFlowObjects());
			}
			return getGEFWrapper(new GatewayCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
