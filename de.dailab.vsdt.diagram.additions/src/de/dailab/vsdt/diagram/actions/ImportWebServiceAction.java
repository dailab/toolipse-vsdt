package de.dailab.vsdt.diagram.actions;

import java.util.Collections;
import java.util.List;

import javax.wsdl.Input;
import javax.wsdl.Operation;
import javax.wsdl.Output;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredCreateConnectionViewAndElementCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.Node;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.diagram.edit.parts.PoolEditPart;
import de.dailab.vsdt.diagram.part.VsdtDiagramEditor;
import de.dailab.vsdt.diagram.providers.VsdtElementTypes;
import de.dailab.vsdt.diagram.views.VsdtViewsPlugin;
import de.dailab.vsdt.diagram.views.webservices.WebSeviceAccessor;

/**
 * Generic version of the RSD's former Import Web Service Action.
 * 
 * TODO Support for importing only a Message
 * TODO Support for importing multiple elements at once
 * 
 * @author kuester
 */
public class ImportWebServiceAction extends Action {

	public static final String TEXT= "Import to BPMN";
	public static final String TITLE= "Import into BPMN Diagram";
	public static final String TOOLTIP= "Imports the selected element into the currently opened BPMN diagram.";
	public static final String COMMAND_NAME= "Import Web Service Element";
	
	public static final String DIALOG_IMPORT_MESSAGE= "Import selected element into BPMN diagram?";
	private static final String DIALOG_IMPORT_CREATE_POOL= "Shall a pool be created for the newly imported Webservice?";
	private static final String DIALOG_IMPORT_USE_WEBSERVICE= "Shall the currently selected Node use the webservice?";
	public static final String ERROR_NO_EDITOR= "There is currently no BPMN Diagram Editor " +
			"of the Visual Service Design Tool opened. Please open an appropriate editor first.";
	public static final String ERROR_GENERAL= "An Error occured when trying to import the selected elements.";

	private final Viewer viewer;
	
	protected BusinessProcessSystem bps= null;
	protected Message message= null;
	protected Message inMessage= null;
	protected Message outMessage= null;
	protected Implementation implementation= null;
	
	public ImportWebServiceAction(Viewer viewer) {
		this.viewer= viewer;
		this.setText(TITLE);
		this.setToolTipText(TOOLTIP);
		this.setImageDescriptor(VsdtViewsPlugin.getImageDescriptor(VsdtViewsPlugin.IMAGE_IMPORT));
	}

	/**
	 * Get the elements to import, depending on which view to import from. 
	 * 
	 * @param viewer	The Viewer to import the elements from, e.g. Web Service View, RSD View, ...
	 * @return			Success, or Error?
	 */
	protected boolean getElementsToImport(Viewer viewer) {
		WebSeviceAccessor accessor= (WebSeviceAccessor) viewer.getInput();
		// Get Selected Element
		Object viewerSelection= ((StructuredSelection) viewer.getSelection()).getFirstElement();
		if (viewerSelection instanceof javax.wsdl.Message) {
			message= accessor.createBpmnElement((javax.wsdl.Message) viewerSelection);
		}
		if (viewerSelection instanceof javax.wsdl.Operation) {
			Operation operation= (Operation) viewerSelection;
			implementation= accessor.createBpmnElement(operation);
			inMessage= accessor.createBpmnElement(operation.getInput().getMessage());
			outMessage= accessor.createBpmnElement(operation.getOutput().getMessage());
			implementation.setInputMessage(inMessage);
			implementation.setOutputMessage(outMessage);
		}
		if (viewerSelection instanceof Input) {
			Input input= (Input) viewerSelection;
			inMessage= accessor.createBpmnElement(input.getMessage());
		}
		if (viewerSelection instanceof Output) {
			Output output= (Output) viewerSelection;
			outMessage= accessor.createBpmnElement(output.getMessage());
		}
		return true;
	}
	
	@Override
	public void run() {
		//this compound command will hold the various partial commands
		CompoundCommand cc= new CompoundCommand(COMMAND_NAME);
		
		// Get Active Editor
		final IWorkbenchWindow window= PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IEditorPart editor= window.getActivePage().getActiveEditor();
		
		try {
			// Active Editor of Type BPMN Editor ?
			if (editor instanceof DiagramEditor) { // || editor instanceof de.dailab.vsdt.meta.diagram.part.VsdtDiagramEditor) {
				DiagramEditor diagramEditor= (DiagramEditor) editor;
				if (! ( "de.dailab.vsdt.diagram".equals(diagramEditor.getContributorId()) || 
						"de.dailab.vsdt.diagram.meta".equals(diagramEditor.getContributorId()))) {
					// not a VSDT Diagram Editor
					MessageDialog.openWarning(window.getShell(), TITLE, ERROR_NO_EDITOR);
					return;
				}
				
				final DiagramEditPart diagramEditPart= diagramEditor.getDiagramEditPart();
				
				EObject modelElement= (EObject) ((View)diagramEditPart.getModel()).getElement(); 
				if (modelElement instanceof BusinessProcessDiagram) {
					bps = ((BusinessProcessDiagram) modelElement).getBusinessProcessSystem();
				} else {
					bps= (BusinessProcessSystem) modelElement;
				}
				
				// Import the Web service and/or message into the diagram ?
				if (MessageDialog.openConfirm(window.getShell(), TITLE, DIALOG_IMPORT_MESSAGE)) {
	
					// clear
					message= null;
					inMessage= null;
					outMessage= null;
					implementation= null;
					if (! getElementsToImport(viewer)) {
						throw new Exception();
					}
					cc.add(new ICommandProxy(new ImportBpmnElementCommand()));
					
					if (implementation != null) {
					
						// Create Pool for the new Implementation ?
						IAdaptable poolViewAdapter= null;
						if (editor instanceof VsdtDiagramEditor && MessageDialog.openQuestion(window.getShell(), TITLE, DIALOG_IMPORT_CREATE_POOL)) {
		
							//Create Pool Request
							CreateViewRequest poolRequest = CreateViewRequestFactory.getCreateShapeRequest(VsdtElementTypes.Pool_1004, diagramEditPart.getDiagramPreferencesHint());
							Point p = diagramEditPart.getFigure().getBounds().getTopLeft().getCopy();
							p.translate(20, 20);
							int yMax= 0;
							int width= 500;
							for (Object o : diagramEditPart.getChildren()) {
								if (o instanceof PoolEditPart) {
									PoolEditPart poolEditPart= (PoolEditPart) o;
									if (yMax < poolEditPart.getFigure().getBounds().getBottom().y) {
										yMax= poolEditPart.getFigure().getBounds().getBottom().y;
										width= poolEditPart.getFigure().getBounds().width;
										p= poolEditPart.getFigure().getBounds().getBottomLeft().getCopy();
										p.translate(0, 100);
									}
								}
							}
							diagramEditPart.getFigure().translateToAbsolute(p);
							poolRequest.setLocation(p);
							poolRequest.setSize(new Dimension(width,100));
		
							Command createPoolCmd = diagramEditPart.getCommand(poolRequest);
							poolViewAdapter = (IAdaptable) ((List) poolRequest.getNewObject()).get(0);
		
							// create pool and set pool properties
							cc.add(createPoolCmd);
							cc.add(new ICommandProxy(new UseWebserviceForPoolCommand(diagramEditPart, poolViewAdapter)));
						}
							
						// Let the selected Activity or Event use the web service ?
						ISelectionProvider selProvider= diagramEditor.getEditorSite().getSelectionProvider();
						if (selProvider.getSelection() instanceof IStructuredSelection) {
							Object selection= ((IStructuredSelection) selProvider.getSelection()).getFirstElement();
							if (selection instanceof IGraphicalEditPart) {
								IGraphicalEditPart editPart = (IGraphicalEditPart) selection;
								EObject eObject= ((View)editPart.getModel()).getElement();
								if (eObject instanceof Node && MessageDialog.openQuestion(window.getShell(), TITLE, DIALOG_IMPORT_USE_WEBSERVICE)) {
		
									//use web service and implementation for selected node
									cc.add(new ICommandProxy(new UseWebserviceForSelectedNodeCommand((Node) eObject)));
									
									if (poolViewAdapter != null) {
										// pool will be created -> create message flows, too
										
										// outgoing message flow
										CreateConnectionViewAndElementRequest msgFlowRequest= new CreateConnectionViewAndElementRequest(
												VsdtElementTypes.MessageFlow_3002,
												((IHintedType) VsdtElementTypes.MessageFlow_3002).getSemanticHint(),
												editPart.getDiagramPreferencesHint());
										
										ICommand createMessageFlowCmd = new DeferredCreateConnectionViewAndElementCommand(
												msgFlowRequest,
												new EObjectAdapter((EObject) editPart.getModel()),
												poolViewAdapter,
												editPart.getViewer());
					
										cc.add(new ICommandProxy(createMessageFlowCmd));
										
										// incoming message flow
										msgFlowRequest= new CreateConnectionViewAndElementRequest(
												VsdtElementTypes.MessageFlow_3002,
												((IHintedType) VsdtElementTypes.MessageFlow_3002).getSemanticHint(),
												editPart.getDiagramPreferencesHint());
										
										createMessageFlowCmd = new DeferredCreateConnectionViewAndElementCommand(
												msgFlowRequest,
												poolViewAdapter,
												new EObjectAdapter((EObject) editPart.getModel()),
												editPart.getViewer());
					
										cc.add(new ICommandProxy(createMessageFlowCmd));
				
										//set message flow properties and create messages
										cc.add(new ICommandProxy(new UseWebserviceForMessageFlowCommand(diagramEditPart, poolViewAdapter)));
		
									}
								}
							}
						}
					}
				}
	
				diagramEditPart.getDiagramEditDomain().getDiagramCommandStack().execute(cc);
			}
		} catch (Exception e) {
			MessageDialog.openError(window.getShell(), TITLE, ERROR_GENERAL);
		}
	}

	/**
	 * Superclass for the import commands, providing a new constructor 
	 * 
	 * @author kuester
	 */
	protected abstract class MyAbstractTransactionalCommand extends AbstractTransactionalCommand {
		public MyAbstractTransactionalCommand() {
		    super(TransactionUtil.getEditingDomain(bps), "Internal Command", Collections
		    		.singletonList(WorkspaceSynchronizer.getFile(bps.eResource())));
		}
	}
	
	/**
	 * - adds the given Messages and/or Implementations to the BPD
	 * 
	 * @author kuester
	 */
	protected class ImportBpmnElementCommand extends MyAbstractTransactionalCommand {
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			if (bps != null) {
				if (implementation != null) {
					bps.getImplementations().add(implementation);
				}
				if (inMessage != null) {
					bps.getMessages().add(inMessage);
				}
				if (outMessage != null) {
					bps.getMessages().add(outMessage);
				}
				if (message != null) {
					bps.getMessages().add(message);
				}
				return CommandResult.newOKCommandResult(bps);
			}
			return null;
		}
	}
	
	/**
	 * - sets the Participant of the Messages and Implementation to the Pool's Participant
	 * 
	 * @author kuester
	 */
	protected class UseWebserviceForPoolCommand extends MyAbstractTransactionalCommand {
		DiagramEditPart diagramEditPart;
		IAdaptable poolViewAdapter;
		public UseWebserviceForPoolCommand(DiagramEditPart diagramEditPart, IAdaptable adaptable) {
			this.diagramEditPart= diagramEditPart;
			this.poolViewAdapter= adaptable;
		}
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			
			final EditPartViewer viewer = diagramEditPart.getViewer();
			EditPart elementPart = (EditPart) viewer.getEditPartRegistry().get(poolViewAdapter.getAdapter(View.class));
			if (elementPart instanceof PoolEditPart) {
				PoolEditPart poolEditPart = (PoolEditPart) elementPart;
				Pool pool= poolEditPart.getCastedModel();
				if (pool != null && implementation != null) {
					pool.setName(implementation.getInterface() + "_Pool");//$NON-NLS-1$
					Participant participant= pool.getParticipant();
					//set implementation's and messages' participants
					implementation.setParticipant(participant);
//					inMessage.setTo(participant);
//					outMessage.setFrom(participant);
					return CommandResult.newOKCommandResult();
				}
			}
			return null;
		}
	}

	/**
	 * - gets the newly created Message Flows from the newly created Pool
	 * - sets the Message Flows' Messages to be the imported messages 
	 * 
	 * @author kuester
	 */
	protected class UseWebserviceForMessageFlowCommand extends MyAbstractTransactionalCommand {
		private DiagramEditPart diagramEditPart;
		private IAdaptable poolViewAdapter;
		public UseWebserviceForMessageFlowCommand(DiagramEditPart diagramEditPart, IAdaptable adaptable) {
			this.diagramEditPart= diagramEditPart;
			this.poolViewAdapter= adaptable;
		}
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			final EditPartViewer viewer = diagramEditPart.getViewer();
			EditPart elementPart = (EditPart) viewer.getEditPartRegistry().get(poolViewAdapter.getAdapter(View.class));
			if (elementPart instanceof PoolEditPart) {
				PoolEditPart poolEditPart = (PoolEditPart) elementPart;
				Pool pool= poolEditPart.getCastedModel();
				if (pool != null) {
					if (pool.getIncomingMsg().size() == 1 && pool.getOutgoingMsg().size() == 1) {
						//set the input message flow's message
						MessageFlow incomingMsgFlow= pool.getIncomingMsg().get(0);
						incomingMsgFlow.setMessage(inMessage);
						//set the output message flow's message
						MessageFlow outgoingMsgFlow= pool.getOutgoingMsg().get(0);
						outgoingMsgFlow.setMessage(outMessage);
					}
					return CommandResult.newOKCommandResult();
				}
			}
			return null;
		}
	}
	
	/**
	 * - adapts the selected Node to the imported Implementation and Messages
	 * - sets the Activity's/Event's incoming and/or outgoing Message
	 * - implicitly sets the Activity/Event-Type accordingly
	 * - sets the Implementation
	 * 
	 * @author kuester
	 */
	protected class UseWebserviceForSelectedNodeCommand extends MyAbstractTransactionalCommand {
		Node node;
		public UseWebserviceForSelectedNodeCommand(Node node) {
			this.node= node;
		}
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
			// set message (implicitly setting the type, too)
			node.adaptToMessage(inMessage, false);
			node.adaptToMessage(outMessage, true);
			// set implementation
			if (node instanceof Activity) {
				((Activity)node).setImplementation(implementation);
			}
			if (node instanceof Event) {
				((Event)node).setImplementation(implementation);
			}
			//set messages' participants
//			inMessage.setFrom(node.getPool().getParticipant());
//			outMessage.setTo(node.getPool().getParticipant());
			return CommandResult.newOKCommandResult();
		}
	}
}
