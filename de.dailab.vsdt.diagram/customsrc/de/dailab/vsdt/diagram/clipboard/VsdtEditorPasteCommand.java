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
			pasteCmd = new PasteTransactionalCommand(domain, new ArrayList<>(copied.keySet()));
			IStatus status = pasteCmd.execute(progressMonitor, info);
			
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

		protected final List<EObject> originalObjects;
		protected List<EObject> copiedObjects;
		
		public PasteTransactionalCommand(TransactionalEditingDomain domain, List<EObject> originalObjects) {
	        super(domain, PasteTransactionalCommand.class.getName(),
	        		getWorkspaceFiles(originalObjects));
	        this.originalObjects = originalObjects;
	    }

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			try {
				// VSDT Copier can handle some stuff that EcoreUtil can't, but can't copy between files
				copiedObjects = new VsdtCopier().deepCopyWithReferences(originalObjects);
				insertCopies(targetElement, copiedObjects);
			} catch (Exception e) {
				// use EcoreUtil.copyAll as fallback for copying between resources
				System.err.println("VSDT Copier failed. Using EcoreUtil.copyAll.");
				copiedObjects = new ArrayList<>(EcoreUtil.copyAll(originalObjects));
				insertCopies(targetElement, copiedObjects);
			}
			
			return CommandResult.newOKCommandResult();
		}
		
		private void insertCopies(EObject targetElement, List<EObject> copiedObjects) {
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
					if (obj instanceof Artifact) {
						Artifact artifact = (Artifact) obj;
						VsdtHelper.getRootBPD(targetElement).getArtifacts().add(artifact);
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
					if (obj instanceof ConnectingObject) {
						ConnectingObject connection = (ConnectingObject) obj;
						container.getConnections().add(connection);
					}
				}
			}
		}

		@Override
		public void addContext(IUndoContext context) {
			super.addContext(context);
			VsdtEditorPasteCommand.this.addContext(context);
		}
	}

}
