package de.dailab.vsdt.diagram.actions.structuring;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.diagram.edit.parts.SequenceFlowEditPart;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * This Action can be used to insert a new Structure on an existing Sequence Flow edge.
 * The existing sequence flow is split up, i.e. the existing sequence flow (possibly
 * with conditions) is inserted before the new structure and a new sequence flow is created
 * and inserted after the newly created node.
 * 
 * This abstract superclass provides all that is necessary for inserting any of the 
 * node subclasses. Implementations of this class only have to provide the element(s) to
 * be inserted.
 * 
 * @author kuester
 */
public abstract class InsertPatternAction implements IObjectActionDelegate {

	/** Sequence Flow to insert the Pattern on */
	protected SequenceFlowEditPart seqFlowEditPart;
	
	/** Compartment Edit Part to insert the new Element into */
	protected ShapeCompartmentEditPart compEditPart;
	
	/** Adapter for the first node of the Pattern, needed for reconnecting the Sequence Flow */
	protected IAdaptable adapterForFirstNode;
	
	/** Adapter for the last node of the Pattern, needed for creating the new Sequence Flow*/
	protected IAdaptable adapterForLastNode;
	
	/** Adapter of the Node to be set in edit mode after the creation of the pattern, if any */
	protected IAdaptable adapterForNodeToBeEdited;

	/**
	 * @return		The Name of the CompoundCommand to execute
	 */
	public abstract String getCommandName();
	
	/**
	 * Implementations of this methods have to add the Creation Commands for the new 
	 * nodes and connections to the given compound command in the right order. Further
	 * the protected fields adapterFor... have to be set so the Sequence Flows can be
	 * reconnected/created appropriately and one of the nodes can be set to edit mode.
	 * Example: adapterFor... = (IAdaptable) ((List) nodeRequest.getNewObject()).get(0);
	 * 
	 * @param cc	The compound Command to add the new Create Commands to
	 * @return		Successful? Otherwise the action is aborted
	 */
	public abstract boolean addCreationCommands(CompoundCommand cc);
	
	public void selectionChanged(IAction action, ISelection selection) {
		seqFlowEditPart = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof SequenceFlowEditPart) {
				seqFlowEditPart = (SequenceFlowEditPart) structuredSelection.getFirstElement();
				compEditPart= (ShapeCompartmentEditPart) seqFlowEditPart.getTarget().getParent();
			}
		}
	}
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
	
	public void run(IAction action) {
		//this compound command will hold the various partial commands
		CompoundCommand cc= new CompoundCommand(getCommandName());
		
		// Get Create Commands
		if (! addCreationCommands(cc)) {
			return; // abort
		}

		if (adapterForLastNode != null) {
			// Create Sequence Flow Command
			CreateConnectionViewAndElementRequest seqFlowRequest= new CreateConnectionViewAndElementRequest(
					VsdtElementTypes.SequenceFlow_3001,
					((IHintedType) VsdtElementTypes.SequenceFlow_3001).getSemanticHint(),
					seqFlowEditPart.getDiagramPreferencesHint());
			ICommand createSequenceFlowCmd = new DeferredCreateConnectionViewAndElementCommand(
					seqFlowRequest,
					adapterForLastNode,
					new EObjectAdapter((EObject) seqFlowEditPart.getTarget().getModel()),
					seqFlowEditPart.getViewer());
			cc.add(new ICommandProxy(createSequenceFlowCmd));
		}

		if (adapterForFirstNode != null) {
			// Reconnect original Sequence Flow
	//		ReconnectRequest reconnectRequest= new ReconnectRequest();
	//		reconnectRequest.setConnectionEditPart(seqFlowEditPart);
	//		reconnectRequest.setTargetEditPart(seqFlowEditPart.getSource());
	//		Command reconnectCommand= seqFlowEditPart.getCommand(reconnectRequest);
	//		cc.add(reconnectCommand);
			
			// reconnecting doesn't work yet; workaround: create new connection
			//XXX BEGIN WORKAROUND
			// Create Sequence Flow Command
			CreateConnectionViewAndElementRequest seqFlowRequest= new CreateConnectionViewAndElementRequest(
					VsdtElementTypes.SequenceFlow_3001,
					((IHintedType) VsdtElementTypes.SequenceFlow_3001).getSemanticHint(),
					seqFlowEditPart.getDiagramPreferencesHint());
			ICommand createSequenceFlowCmd = new DeferredCreateConnectionViewAndElementCommand(
					seqFlowRequest,
					new EObjectAdapter((EObject) seqFlowEditPart.getSource().getModel()),
					adapterForFirstNode,
					seqFlowEditPart.getViewer());
			cc.add(new ICommandProxy(createSequenceFlowCmd));
			
			// copy attributes
			cc.add(new ICommandProxy(new CopySeqFlowAttCommand(compEditPart.getViewer(), seqFlowEditPart.getCastedModel(), (IAdaptable) seqFlowRequest.getNewObject())));
			
			//delete old connection (edge first, then model element)
			DeleteCommand delCommand= new DeleteCommand((View) seqFlowEditPart.getModel());
			cc.add(new ICommandProxy(delCommand));
			DestroyElementRequest destroyRequest= new DestroyElementRequest(seqFlowEditPart.getCastedModel(), false);
			destroyRequest.setEditingDomain(compEditPart.getEditingDomain());
			DestroyElementCommand destroyCommand= new DestroyElementCommand(destroyRequest);
			cc.add(new ICommandProxy(destroyCommand));
			// XXX END WORKAROUND
		}
		
		// execute commands
		compEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(cc);
		
		// XXX rearrange nodes
		
		// put node into edit mode
		if (adapterForNodeToBeEdited != null) {
			final EditPartViewer viewer = compEditPart.getViewer();
			final EditPart elementPart = (EditPart) viewer.getEditPartRegistry().get(adapterForNodeToBeEdited.getAdapter(View.class));
			if (elementPart != null) {
				Display.getCurrent().asyncExec(new Runnable() {
					public void run() {
						viewer.setSelection(new StructuredSelection(elementPart));
						Request der = new Request(RequestConstants.REQ_DIRECT_EDIT);
						elementPart.performRequest(der);
					}
				});
			}
		}
	}

	/**
	 * @param request		some create view request
	 * @return				the newly created object
	 */
	protected IAdaptable getCreatedObject(CreateViewRequest request) {
		return (IAdaptable) ((List<?>) request.getNewObject()).get(0);
	}

	/**
	 * This command copies the Attributes from the existing Sequence Flow to the
	 * newly created one. This is only needed for the above Workaround and can be 
	 * removed once the Sequence Flow can be reconnected instead of deleting it and
	 * creating a new one.  
	 * 
	 * @author kuester
	 */
	protected class CopySeqFlowAttCommand extends AbstractTransactionalCommand {
		SequenceFlow oldSeqFlow;
		EditPartViewer viewer;
		IAdaptable newSeqFlowViewAdapter;
		public CopySeqFlowAttCommand(EditPartViewer editPartViewer, SequenceFlow sequenceFlow, IAdaptable adaptable) {
			super(TransactionUtil.getEditingDomain(sequenceFlow), "Copy SequenceFlow Attributes", Collections
			    		.singletonList(WorkspaceSynchronizer.getFile(sequenceFlow.eResource())));
			this.viewer= editPartViewer;
			this.oldSeqFlow= sequenceFlow;
			this.newSeqFlowViewAdapter= adaptable;
		}
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable adaptable) throws ExecutionException {
			EditPart editPart = (EditPart) viewer.getEditPartRegistry().get(newSeqFlowViewAdapter.getAdapter(View.class));
			if (editPart instanceof SequenceFlowEditPart) {
				SequenceFlowEditPart newSeqFlowEditPart = (SequenceFlowEditPart) editPart;
				SequenceFlow newSeqFlow= newSeqFlowEditPart.getCastedModel();
				if (oldSeqFlow != null && newSeqFlow != null) {
					newSeqFlow.setConditionExpression(oldSeqFlow.getConditionExpression());
					newSeqFlow.setConditionType(oldSeqFlow.getConditionType());
					newSeqFlow.setDocumentation(oldSeqFlow.getDocumentation());
					newSeqFlow.setId(oldSeqFlow.getId());
					newSeqFlow.setName(oldSeqFlow.getName());
					newSeqFlow.getCategories().addAll(oldSeqFlow.getCategories());
					return CommandResult.newOKCommandResult();
				}
			}
			return null;
		}
	}
	
}
