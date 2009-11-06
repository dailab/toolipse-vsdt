package de.dailab.vsdt.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.diagram.edit.commands.DataObjectCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.GroupCreateCommand;
import de.dailab.vsdt.diagram.edit.commands.PoolCreateCommand;
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

		//        /**
		//         * @generated NOT
		//    	 * Overrides the super method by regenerating the id of the identifiable
		//    	 * if the object duplicated is an identifiable.
		//    	 * 
		//    	 * Taken from STP-BPMN-Editor
		//    	 * Has been inserted for ClipBoard Support, but doesn't work yet
		//    	 */
		//    	protected CommandResult doExecuteWithResult(
		//                IProgressMonitor progressMonitor, IAdaptable info)
		//            throws ExecutionException {
		//    		// Remove elements whose container is getting copied.
		//    		ClipboardSupportUtil.getCopyElements(getObjectsToBeDuplicated());
		//
		//    		// Perform the copy and update the references.
		//    		EcoreUtil.Copier copier = new EcoreUtil.Copier();
		//    		copier.copyAll(getObjectsToBeDuplicated());
		//    		copier.copyReferences();
		//
		//    		// Update the map with all elements duplicated.
		//    		getAllDuplicatedObjectsMap().putAll(copier);
		//
		//    		// Add the duplicates to the original's container.
		//    		for (Iterator i = getObjectsToBeDuplicated().iterator(); i.hasNext();) {
		//    			EObject original = (EObject) i.next();
		//    			EObject duplicate = (EObject) copier.get(original);
		//    			// callback to reset the identifiable
		//    			if (duplicate instanceof IdObject) {
		//    				duplicate.eSet(VsdtPackage.eINSTANCE.getIdObject_Id(), 
		//    						EcoreUtil.generateUUID());
		//    			}
		//    			EReference reference = original.eContainmentFeature();
		//    			if (reference != null
		//    				&& FeatureMapUtil.isMany(original.eContainer(),reference)
		//    				&& ClipboardSupportUtil.isOkToAppendEObjectAt(
		//    					original.eContainer(), reference, duplicate)) {
		//    				
		//    				ClipboardSupportUtil.appendEObjectAt(original.eContainer(),
		//    					reference, duplicate);
		//    			}
		//    		}
		//    		return CommandResult.newOKCommandResult(getAllDuplicatedObjectsMap());
		//    	}

	}

}
