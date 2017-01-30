package de.dailab.vsdt.diagram.clipboard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
import de.dailab.vsdt.diagram.part.VsdtUriEditorInputTester;
import de.dailab.vsdt.util.VsdtHelper;

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
		System.out.println("CALLING PASTE EXECUTE WITH RESULT");
		List<EObject> copied = VsdtEditorCopyCommand.objectsToCopy;
		if (copied != null) {

			List<EObject> objectsToPaste = new ArrayList<>(EcoreUtil.copyAll(copied));
			for (EObject obj : objectsToPaste) {
				if (obj instanceof IdObject) {
					VsdtHelper.generateNewID((IdObject) obj);
				}
			}
			
			TransactionalEditingDomain domain = (TransactionalEditingDomain) AdapterFactoryEditingDomain.getEditingDomainFor(targetElement);
			pasteCmd = new PasteTransactionalCommand(domain, objectsToPaste);
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
	
	
	private class PasteTransactionalCommand extends AbstractTransactionalCommand {

		protected final List<EObject> elementsToPaste;
		protected final List<EObject> elementsCreated;
		
		public PasteTransactionalCommand(TransactionalEditingDomain domain, List<EObject> elemToPaste) {
	        super(domain, PasteTransactionalCommand.class.getName(),
	        getWorkspaceFiles(elemToPaste));
	        this.elementsToPaste = elemToPaste;
	        this.elementsCreated = new LinkedList<>();
	    }

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			// TODO Auto-generated method stub
			System.out.println("CALLING PASTE INNER EXECUTE WITH RESULT");
			
			if (targetElement instanceof FlowObjectContainer) {
				FlowObjectContainer container = (FlowObjectContainer) targetElement;
				
				for (EObject obj : elementsToPaste) {
					if (obj instanceof FlowObject) {
						FlowObject flowObj = (FlowObject) obj;
						container.getContainedFlowObjects().add(flowObj);
						
					}
					if (obj instanceof ConnectingObject) {
						ConnectingObject connection = (ConnectingObject) obj;
						getRootDiagram(targetElement).getConnections().add(connection);
					}
					
				}
			}
			
			if (targetElement instanceof BusinessProcessDiagram) {
				BusinessProcessDiagram container = (BusinessProcessDiagram) targetElement;
				for (EObject obj : elementsToPaste) {
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
	
	
	private BusinessProcessDiagram getRootDiagram(EObject obj) {
		while (obj.eContainer() != null && ! (obj instanceof BusinessProcessDiagram)) {
			obj = obj.eContainer();
		}
		if (obj instanceof BusinessProcessDiagram) {
			return (BusinessProcessDiagram) obj;
		}
		return null;
	}
	
}
