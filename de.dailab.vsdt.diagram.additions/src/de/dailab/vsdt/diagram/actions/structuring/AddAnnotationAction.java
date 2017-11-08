package de.dailab.vsdt.diagram.actions.structuring;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.handlers.HandlerUtil;

import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.TextAnnotation;
import de.dailab.vsdt.diagram.figures.FigureHelper;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;

/**
 * This Action can be used for appending an Annotation to a node. The annotation
 * will hold the same text as the tool-tip of that node, which might be useful for
 * printing.
 * 
 * @author kuester
 */
public class AddAnnotationAction implements IActionDelegate {

	/** Flow Object Edit Part to append the Node */
	protected ShapeNodeEditPart flowObjectEditPart;
	
	/** the diagram edit part */
	protected DiagramEditPart diagramEditPart;
	
	/** the Flow Object (for determining the current number of outgoing sequences) */
	protected FlowObject flowObject;
	
	/**
	 * @return		The Name of the CompoundCommand to execute
	 */
	public String getCommandName() {
		return "Add Annotation";
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		flowObjectEditPart= null;
		flowObject= null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof ShapeNodeEditPart) {
				ShapeNodeEditPart editPart= (ShapeNodeEditPart) structuredSelection.getFirstElement();
				EObject element= ((View) editPart.getModel()).getElement();
				if (editPart != null && editPart.getParent() instanceof ShapeCompartmentEditPart && element instanceof FlowObject) {
					flowObjectEditPart= editPart;
					flowObject= (FlowObject) element;
					
					// get diagram edit part
					EditPart part = editPart;
					while (part != null && ! (part instanceof DiagramEditPart)) {
						part = part.getParent();
					}
					diagramEditPart = (DiagramEditPart) part;
				}
			}
		}
	}
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}
	
	public void run(IAction action) {
		if (diagramEditPart == null) return;
		final EditPartViewer viewer = diagramEditPart.getViewer();
				
		// Create Node Command
		CreateViewRequest nodeRequest = CreateViewRequestFactory.getCreateShapeRequest(
				VsdtElementTypes.TextAnnotation_1002, flowObjectEditPart.getDiagramPreferencesHint());
		Point p= flowObjectEditPart.getFigure().getBounds().getBottomLeft().translate(20, 75);
		flowObjectEditPart.getFigure().translateToAbsolute(p);
		nodeRequest.setLocation(p);
		Command creatNodeCmd = diagramEditPart.getCommand(nodeRequest);
		
		final IAdaptable adapterForNewNode = (IAdaptable) ((List<?>) nodeRequest.getNewObject()).get(0);
		
		// Create Association Command
		CreateConnectionViewAndElementRequest associationRequest= new CreateConnectionViewAndElementRequest(
				VsdtElementTypes.Association_3003,
				((IHintedType) VsdtElementTypes.Association_3003).getSemanticHint(),
				flowObjectEditPart.getDiagramPreferencesHint());
		ICommand createSequenceFlowCmd = new DeferredCreateConnectionViewAndElementCommand(
				associationRequest,
				new EObjectAdapter((EObject) flowObjectEditPart.getModel()),
				adapterForNewNode,
				flowObjectEditPart.getViewer());
		
		// Set tool tip text
		AbstractGmfCommand setTextCommand= new AbstractGmfCommand(flowObject, "Set Documentation") {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				EditPart elementPart = (EditPart) viewer.getEditPartRegistry()
						.get(adapterForNewNode.getAdapter(View.class));
				TextAnnotation annotation = (TextAnnotation) ((View) elementPart.getModel()).getElement();
				annotation.setDocumentation(FigureHelper.getToolTipText(flowObject));
				return CommandResult.newOKCommandResult();
			}
		};
		
		//this compound command will hold the various partial commands
		CompoundCommand cc= new CompoundCommand(getCommandName());
		cc.add(creatNodeCmd);
		cc.add(new ICommandProxy(createSequenceFlowCmd));
		cc.add(new ICommandProxy(setTextCommand));
		diagramEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(cc);

		// put node into edit mode
		final EditPart elementPart = getNewEditPart(viewer, adapterForNewNode);
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
	
	private EditPart getNewEditPart(EditPartViewer viewer, IAdaptable adaptable) {
		return (EditPart) viewer.getEditPartRegistry().get(adaptable.getAdapter(View.class));
	}
	
	/**
	 * Handler needed for keyboard shortcut in plugin.xml
	 * 
	 * @author kuester
	 */
	public static class Handler extends AbstractHandler {
	
		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			ISelection selection = HandlerUtil.getCurrentSelection(event);
			AddAnnotationAction action = new AddAnnotationAction();
			action.selectionChanged(null, selection);
			action.run(null);
			return null;
		}
	}
}
