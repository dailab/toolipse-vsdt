package de.dailab.vsdt.diagram.actions.structuring;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * This Action can be used for sequentially appending a new Node to an existing node.
 * A sequence flow is created and connected to the newly created node.
 * 
 * This abstract superclass provides all that is necessary for inserting any of the 
 * node subclasses. Implementations of this class only have to provide the element(s) to
 * be inserted.
 * 
 * @author kuester
 */
public abstract class AppendNodeAction implements IActionDelegate {

	/** Flow Object Edit Part to append the Node */
	protected ShapeNodeEditPart flowObjectEditPart;
	
	/** Compartment Edit Part to insert the new Element into */
	protected ShapeCompartmentEditPart compEditPart;
	
	/** Adapter for the new node of the Pattern, needed for connecting a Sequence Flow */
	protected IAdaptable adapterForNewNode;

	/** the Flow Object (for determining the current number of outgoing sequences) */
	protected FlowObject flowObject;
	
	/**
	 * @return		The Name of the CompoundCommand to execute
	 */
	public String getCommandName() {
		return "Insert " + getElementType().getDisplayName();
	}
	
	/**
	 * This is the only method that has to be overwritten to implement this class.
	 * It has to return the specific VsdtElementType to create with the action.
	 * Of course the element to be created should be some kind of node...
	 * 
	 * @return		IElementType to create.
	 */
	public abstract IElementType getElementType();
	
	public void selectionChanged(IAction action, ISelection selection) {
		flowObjectEditPart= null;
		compEditPart= null;
		flowObject= null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof ShapeNodeEditPart) {
				ShapeNodeEditPart editPart= (ShapeNodeEditPart) structuredSelection.getFirstElement();
				EObject element= ((View) editPart.getModel()).getElement();
				if (editPart.getParent() instanceof ShapeCompartmentEditPart && element instanceof FlowObject) {
					flowObjectEditPart= editPart;
					compEditPart= (ShapeCompartmentEditPart) flowObjectEditPart.getParent();
					flowObject= (FlowObject) element;
				}
			}
		}
	}
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
	
	public void run(IAction action) {
		if (compEditPart == null || flowObjectEditPart == null) return;
		
		//this compound command will hold the various partial commands
		CompoundCommand cc= new CompoundCommand(getCommandName());
		
		// Create Node Command
		CreateViewRequest nodeRequest = CreateViewRequestFactory.getCreateShapeRequest(
				getElementType(), compEditPart.getDiagramPreferencesHint());
		Point p= flowObjectEditPart.getFigure().getBounds().getTopRight();
		p.translate(50, flowObject.getOutgoingSeq().size()*75); // XXX calculate position
		flowObjectEditPart.getFigure().translateToAbsolute(p);
		nodeRequest.setLocation(p);

		Command creatNodeCmd = compEditPart.getCommand(nodeRequest);
		cc.add(creatNodeCmd);
		
		adapterForNewNode = (IAdaptable) ((List<?>) nodeRequest.getNewObject()).get(0);
		
		// Create Sequence Flow Command
		CreateConnectionViewAndElementRequest seqFlowRequest= new CreateConnectionViewAndElementRequest(
				VsdtElementTypes.SequenceFlow_3001,
				((IHintedType) VsdtElementTypes.SequenceFlow_3001).getSemanticHint(),
				flowObjectEditPart.getDiagramPreferencesHint());
		ICommand createSequenceFlowCmd = new DeferredCreateConnectionViewAndElementCommand(
				seqFlowRequest,
				new EObjectAdapter((EObject) flowObjectEditPart.getModel()),
				adapterForNewNode,
				flowObjectEditPart.getViewer());
		cc.add(new ICommandProxy(createSequenceFlowCmd));
		
		// execute commands
		compEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(cc);
		
		// XXX rearrange nodes
		
		// put node into edit mode
		final EditPartViewer viewer = compEditPart.getViewer();
		final EditPart elementPart = (EditPart) viewer.getEditPartRegistry().get(adapterForNewNode.getAdapter(View.class));
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
