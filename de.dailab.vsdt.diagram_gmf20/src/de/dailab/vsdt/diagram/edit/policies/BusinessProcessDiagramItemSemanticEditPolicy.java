package de.dailab.vsdt.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.commands.AgentCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.DataObjectCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.GroupCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.PoolCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.ServiceCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.TextAnnotationCreateCommand;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * @generated
 */
public class BusinessProcessDiagramItemSemanticEditPolicy extends
		VsdtBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (VsdtElementTypes.Group_1001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getBusinessProcessDiagram_Artifacts());
			}
			return getGEFWrapper(new GroupCreateCommand(req));
		}
		if (VsdtElementTypes.TextAnnotation_1002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getBusinessProcessDiagram_Artifacts());
			}
			return getGEFWrapper(new TextAnnotationCreateCommand(req));
		}
		if (VsdtElementTypes.DataObject_1003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getBusinessProcessDiagram_Artifacts());
			}
			return getGEFWrapper(new DataObjectCreateCommand(req));
		}
		if (VsdtElementTypes.Pool_1004 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getBusinessProcessDiagram_Pools());
			}
			return getGEFWrapper(new PoolCreateCommand(req));
		}
		if (VsdtElementTypes.Agent_1005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getBusinessProcessDiagram_Artifacts());
			}
			return getGEFWrapper(new AgentCreateCommand(req));
		}
		if (VsdtElementTypes.Service_1006 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(VsdtPackage.eINSTANCE
						.getBusinessProcessDiagram_Artifacts());
			}
			return getGEFWrapper(new ServiceCreateCommand(req));
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
