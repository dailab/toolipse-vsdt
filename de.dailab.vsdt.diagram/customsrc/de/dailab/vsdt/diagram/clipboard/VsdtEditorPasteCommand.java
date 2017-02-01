package de.dailab.vsdt.diagram.clipboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import de.dailab.vsdt.Artifact;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * VSDT paste command. Create the actual copies of the elements to be copied
 * and insert them into their new target containers.
 *
 * @author kuester
 */
public class VsdtEditorPasteCommand extends AbstractCommand {

	private final IGraphicalEditPart targetEditPart;
	private final EObject targetElement;
	
	private PasteTransactionalCommand pasteCmd;
	
	public VsdtEditorPasteCommand(IGraphicalEditPart target) {
        super("Paste");
        this.targetEditPart = target;
        this.targetElement = target.resolveSemanticElement();
    }
	
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		Map<EObject, EditPart> copied = VsdtEditorCopyCommand.elementsToCopy;
		if (copied != null) {
			
			TransactionalEditingDomain domain = (TransactionalEditingDomain) AdapterFactoryEditingDomain.getEditingDomainFor(targetElement);
			pasteCmd = new PasteTransactionalCommand(domain, copied);
			IStatus status = pasteCmd.execute(progressMonitor, info);
			
			// position newly created edit parts?
//			 EditPart eoEditPart = targetEditPart.findEditPart(targetEditPart,eObject);
			
			// refresh
			EditPart mainEditPart = (EditPart) (targetEditPart.getRoot().getChildren().get(0));
			CanonicalEditPolicy cep = (CanonicalEditPolicy) mainEditPart
					.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
			if (cep != null) {
				cep.refresh();
			}
			
			return new CommandResult(status);
		}
		return null;
	}
	
	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		return new CommandResult(pasteCmd.undo(progressMonitor, info));
	}
	
	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		return new CommandResult(pasteCmd.redo(progressMonitor, info));
	}
	

	/**
	 *
	 * @author kuester
	 */
	private class PasteTransactionalCommand extends AbstractTransactionalCommand {

		final Map<EObject, EditPart> mapping;
		
		public PasteTransactionalCommand(TransactionalEditingDomain domain, Map<EObject, EditPart> mapping) {
	        super(domain, PasteTransactionalCommand.class.getName(),
	        		getWorkspaceFiles(new ArrayList<>(mapping.keySet())));
	        this.mapping = mapping;
	    }

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			List<EObject> originalObjects = new ArrayList<>(mapping.keySet());
//			List<EObject> copiedObjects = new ArrayList<>(EcoreUtil.copyAll(originalObjects));
			List<EObject> copiedObjects = new Copier().deepCopyWithReferences(originalObjects);
			for (EObject obj : copiedObjects) {
				if (obj instanceof IdObject) {
					VsdtHelper.generateNewID((IdObject) obj);
				}
			}
			
			if (targetElement instanceof FlowObjectContainer) {
				FlowObjectContainer container = (FlowObjectContainer) targetElement;
				
				for (EObject obj : copiedObjects) {
					if (obj instanceof FlowObject) {
						FlowObject flowObj = (FlowObject) obj;
						container.getContainedFlowObjects().add(flowObj);
						
					}
					if (obj instanceof ConnectingObject) {
						ConnectingObject connection = (ConnectingObject) obj;
						VsdtHelper.getRootBPD(targetElement).getConnections().add(connection);
					}
					
				}
			}
			
			if (targetElement instanceof BusinessProcessDiagram) {
				BusinessProcessDiagram container = (BusinessProcessDiagram) targetElement;
				for (EObject obj : copiedObjects) {
					if (obj instanceof Pool) {
						Pool pool = (Pool) obj;
						container.getPools().add(pool);
					}
					if (obj instanceof Artifact) {
						Artifact artifact = (Artifact) obj;
						container.getArtifacts().add(artifact);
					}
				}
			}
			
			// TODO position new edit parts?
			
			
//			@Override
//			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
//			// Code taken from the duplicate command
//
//			// Remove elements whose container is getting copied.
//			ClipboardSupportUtil.getCopyElements(BuilderEditorCopyCommand.mySelectedEObjectsList);
//
//			// Perform the copy and update the references.
//			EcoreUtil.Copier copier = new EcoreUtil.Copier();
//			copier.copyAll(BuilderEditorCopyCommand.mySelectedEObjectsList);
//			copier.copyReferences();
//
//			// Add the duplicates to the original's container.
//			for (Iterator i = BuilderEditorCopyCommand.mySelectedEObjectsList.iterator(); i.hasNext();) {
//			EObject original = (EObject) i.next();
//			EObject duplicate = copier.get(original);
//
//			EReference reference = original.eContainmentFeature();
//			if (reference != null && FeatureMapUtil.isMany(this.targetElement, reference)
//			&& ClipboardSupportUtil.isOkToAppendEObjectAt(this.targetElement, reference, duplicate)) {
//
//			ClipboardSupportUtil.appendEObjectAt(this.targetElement, reference, duplicate);
//			}
//			}
//			return CommandResult.newOKCommandResult();
//			}
			
			return null;
		}

		@Override
		public void addContext(IUndoContext context) {
			super.addContext(context);
			VsdtEditorPasteCommand.this.addContext(context);
		}
	}

}
