package de.dailab.vsdt.vsdtagents.sema;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.owlsdescription.ServiceDescription;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.util.VsdtHelper;
import de.dailab.vsdt.vsdtagents.Util;

/**
 * This bean is used to push services from the SeMa2 into the VSDT.
 *
 * @author kuester
 */
public class SemaIntegrationAgentBean extends AbstractMethodExposingBean {
	
	public static final String BEAN_NAME = "de.dailab.vsdt.vsdtagents.sema#SemaIntegrationAgentBean";
	public static final String ACTION_PUSH_SERVICE = BEAN_NAME + "#PushServiceIntoVSDT";
	public static final String ACTION_PUSH_SERVICE_PLAN = BEAN_NAME + "#pushServicePlanIntoVsdt";
	public static final String ACTION_GET_CONTEXT  = BEAN_NAME + "#GetContextOfSelectedElement";

	/**
	 * Create VSDT Service object from JIAC Action or ServiceDescription 
	 * and add it to the VSDT diagram opened in the active editor, if any.
	 * 
	 * @param action		the Action or ServiceDescription to add a corresponding VSDT service for
	 * @param asTemplate	whether the service description is just a template or actual service
	 * @throws Exception	exception in case anything goes wrong
	 */
	@Expose(name=ACTION_PUSH_SERVICE, scope=ActionScope.NODE)
	public void pushServiceIntoVsdt(Action action, Boolean asTemplate) throws Exception {
		
		// get BPS from editor, thus checking whether current editor is VSDT editor
		final IWorkbenchWindow[] wbws = PlatformUI.getWorkbench().getWorkbenchWindows();
		final IEditorPart editor = wbws[0].getActivePage().getActiveEditor();
		final BusinessProcessSystem bps = Util.getVsdtModel(editor);
		
		if (bps != null) {

			// create VSDT Service object corresponding to ServiceDescription
			final Service service = (action instanceof ServiceDescription)
					? SemanticServiceFactory.createService((ServiceDescription) action)
					: SemanticServiceFactory.createService(action);
			service.setTemplate(asTemplate);

			// create VSDT DataType objects corresponding to those used by the service
			final Set<DataType> dataTypes = (action instanceof ServiceDescription)
					? SemanticServiceFactory.createDatatypes((ServiceDescription) action)
					: SemanticServiceFactory.createDatatypes(action);
					
			// this JIAC agent is not running in the UI thread, so we have to asynch-exec this
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					// also, we have to put this inside a command
					ICommandProxy command = new ICommandProxy(new AbstractTransactionalCommand(
							TransactionUtil.getEditingDomain(bps), "Import Semantic Service", 
							Collections.singletonList(WorkspaceSynchronizer.getFile(bps.eResource()))) {
						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
							// finally, add the service to the BPS' list of services
							bps.getServices().add(service);
							// add data types referred to by service
							for (DataType dataType : dataTypes) {
								// EObject does not implement equals, so we have to do this ugly loop...
								boolean exists = false;
								for (DataType existing : bps.getDataTypes()) {
									exists = exists || EcoreUtil.equals(dataType, existing);
								}
								if (! exists) {
									bps.getDataTypes().add(dataType);
								}
							}
							return CommandResult.newOKCommandResult(bps);
						}
					});
					((DiagramEditor) editor).getDiagramEditDomain().getDiagramCommandStack().execute(command);
				}
			});

		} else {
			throw new Exception("Could not get Business Process System from active Editor. "
					+ "Make sure the active editor is a VSDT process diagram editor.");
		}
	}

	/**
	 * Create several VSDT service objects from the grounded services that make up
	 * the given Plan. The services are represented with tasks, that are connected
	 * with sequence flows and assignments. The plan can be inserted as a new pool,
	 * or onto an existing sequence flow edge.
	 *
	 * @param groundedPlan	the plan, consisting of several grounded services
	 * @throws Exception	exception in case anything goes wrong
	 */
	@Expose(name=ACTION_PUSH_SERVICE_PLAN, scope=ActionScope.NODE)
	public void pushServicePlanIntoVsdt(Object groundedPlan) throws Exception {
		System.out.println("CALLING PUSH SERVICE PLAN INTO VSDT");
		System.out.println("groundedPlan: " + groundedPlan);

		// TODO get currently opened BPMN diagram
		// TODO get selection

		// TODO if selection is sequence flow, insert on that flow
		// TODO if selection is pool or subprocess, insert into that pool (with start and end event)
		// TODO if no selection, add new pool with plan to process diagram

		// TODO for each service, derive a VSDT service (like in above action; maybe derive some common helper methods)
		// TODO for each service, create a task, invoking that service
		// TODO for each grounded service parameter, create an assignment for that parameter
		// TODO for each fact in the initial state (?) create a property in the pool
	}

	/**
	 * Calculate and return the "context" of the currently selected element. 
	 * The context is basically all the variables in the scope of that element. 
	 * The result is returned in the form of a map name -> type. It is used by 
	 * the semantic service matcher to find services that are likely to be useful 
	 * with whatever the developer is currently doing.
	 * 
	 * @return	Map {name: type} of properties in scope of selected element
	 */
	@Expose(name=ACTION_GET_CONTEXT, scope=ActionScope.NODE)
	public Map<String, String> getContextOfSelectedElement() {
		
		// get BPS from editor, thus checking whether current editor is VSDT editor
		final IWorkbenchWindow[] wbws = PlatformUI.getWorkbench().getWorkbenchWindows();
		final IEditorPart editor = wbws[0].getActivePage().getActiveEditor();
		
		// get selected elements
		EObject selected = null;
		if (editor instanceof DiagramEditor) {
			DiagramEditor diagramEditor= (DiagramEditor) editor;
			ISelectionProvider selProvider= diagramEditor.getEditorSite().getSelectionProvider();
			if (selProvider.getSelection() instanceof IStructuredSelection) {
				Object selection= ((IStructuredSelection) selProvider.getSelection()).getFirstElement();
				if (selection instanceof IGraphicalEditPart) {
					IGraphicalEditPart editPart = (IGraphicalEditPart) selection;
					selected = ((View)editPart.getModel()).getElement();
				}
			}
		}

		// get properties in scope of selected element
		if (selected != null) {
			Map<String, String> result = new HashMap<>();

			List<Property> properties = VsdtHelper.getVisibleProperties(selected);
			for (Property property : properties) {
				result.put(property.getName(), property.getType());
				// TODO map types to matching OWL classes (what if there are none?)
			}
			return result;
		}
		return null;
	}
	
}
