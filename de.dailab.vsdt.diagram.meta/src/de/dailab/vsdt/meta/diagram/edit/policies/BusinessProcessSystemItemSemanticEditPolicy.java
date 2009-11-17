package de.dailab.vsdt.meta.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.meta.diagram.edit.commands.BusinessProcessDiagramCreateCommand;
import de.dailab.vsdt.meta.diagram.edit.commands.ParticipantCreateCommand;
import de.dailab.vsdt.meta.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class BusinessProcessSystemItemSemanticEditPolicy extends
		VsdtBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (VsdtElementTypes.Participant_1001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getBusinessProcessSystem_Participants());
			}
			return getGEFWrapper(new ParticipantCreateCommand(req));
		}
		if (VsdtElementTypes.BusinessProcessDiagram_1002 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getBusinessProcessSystem_BusinessProcesses());
			}
			return getGEFWrapper(new BusinessProcessDiagramCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
