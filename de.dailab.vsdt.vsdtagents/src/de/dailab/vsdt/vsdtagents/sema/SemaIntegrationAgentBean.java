package de.dailab.vsdt.vsdtagents.sema;

import java.util.ArrayList;
import java.util.Collection;
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
import de.dailab.jiactng.sema2.planning.util.GroundedRatedServiceDescription;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
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
		DiagramEditor editor = getEditor();
		BusinessProcessSystem bps = Util.getVsdtModelBps(editor);
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
							mergeInto(dataTypes, bps.getDataTypes());
							return CommandResult.newOKCommandResult(bps);
						}
					});
					editor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
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
	public void pushServicePlanIntoVsdt(List<GroundedRatedServiceDescription> groundedPlan) throws Exception {
		System.out.println("CALLING PUSH SERVICE PLAN INTO VSDT");
		System.out.println("groundedPlan: " + groundedPlan);

		// get BPS from editor, thus checking whether current editor is VSDT editor
		DiagramEditor editor = getEditor();
		BusinessProcessDiagram bpd = Util.getVsdtModelBpd(editor);
		if (bpd != null) {

			// stuff that will get created in this action
			List<DataType> allTypes = new ArrayList<>();
			List<Service> services = new ArrayList<>();
			List<Activity> tasks = new ArrayList<>();
			List<SequenceFlow> flows = new ArrayList<>();

			// TODO for each fact, create a property in the pool, if not already exists
			
			// for each service constituting the plan...
			for (GroundedRatedServiceDescription grsd : groundedPlan) {
				// ... derive the service and the data types used therein
				Service service = SemanticServiceFactory.createService(grsd.getSd());
				allTypes.addAll(SemanticServiceFactory.createDatatypes(grsd.getSd()));

				// ... create a task, invoking that service
				Activity task = VsdtFactory.eINSTANCE.createActivity();
				task.setName("Invoke " + grsd.getSd().getName());
				task.setActivityType(ActivityType.SERVICE);
				task.setImplementation(service);

				// TODO ...create assignments for the grounded parameters

				services.add(service);
				tasks.add(task);
			}

			// finally, connect the tasks with sequence flows
			for (int i = 1; i < tasks.size(); i++) {
				SequenceFlow flow = VsdtFactory.eINSTANCE.createSequenceFlow();
				flow.setSource(tasks.get(i - 1));
				flow.setTarget(tasks.get(i));
				flows.add(flow);
			}
			
			// this JIAC agent is not running in the UI thread, so we have to async-exec this
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					// also, we have to put this inside a command
					ICommandProxy command = new ICommandProxy(new AbstractTransactionalCommand(
							TransactionUtil.getEditingDomain(bpd), "Import Grounded Services Plan",
							Collections.singletonList(WorkspaceSynchronizer.getFile(bpd.eResource()))) {
						@Override
						protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

							// merge newly created services and data types
							mergeInto(services, bpd.getParent().getServices());
							mergeInto(allTypes, bpd.getParent().getDataTypes());

							// XXX for now, just insert the activities into the first pool and see what happens...
							bpd.getPools().get(0).getLanes().get(0).getContainedFlowObjects().addAll(tasks);
							
							
							// TODO get selection

							// TODO if selection is sequence flow, insert on that flow
							// TODO if selection is pool or subprocess, insert into that pool (with start and end event)
							// TODO if no selection, add new pool with plan to process diagram

							return CommandResult.newOKCommandResult(bpd);
						}
					});
					editor.getDiagramEditDomain().getDiagramCommandStack().execute(command);
				}
			});
		} else {
			throw new Exception("Could not get Business Process System from active Editor. "
					+ "Make sure the active editor is a VSDT process diagram editor.");
		}
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
		DiagramEditor editor = getEditor();
		
		// get selected elements
		EObject selected = null;
		if (editor != null) {
			ISelectionProvider selProvider= editor.getEditorSite().getSelectionProvider();
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


	/*
	 * HELPER METHODS
	 */

	/**
	 * Get and return the active editor from the workbench
	 */
	private DiagramEditor getEditor() {
		IWorkbenchWindow[] wbws = PlatformUI.getWorkbench().getWorkbenchWindows();
		IEditorPart editor = wbws[0].getActivePage().getActiveEditor();
		if (editor instanceof DiagramEditor) {
			return (DiagramEditor) editor;
		}
		return null;
	}

	/**
	 * EObject does not implement equals properly, so we can't rely on Sets here...
	 * instead, compare each and every pair using EcoreUtils.equals. Annoying, but
	 * not a problem assuming that those lists are not excessively large.
	 *
	 * @param source	newly created services or datatypes
	 * @param target	list of existing elements, to be modified
	 */
	private <T extends EObject> void mergeInto(Collection<T> source, Collection<T> target) {
		for (T element : source) {
			boolean exists = false;
			for (T existing : target) {
				exists |= EcoreUtil.equals(element, existing);
			}
			if (! exists) {
				target.add(element);
			}
		}
	}
}
