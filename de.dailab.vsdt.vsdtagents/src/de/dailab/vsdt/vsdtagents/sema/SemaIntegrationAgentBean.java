package de.dailab.vsdt.vsdtagents.sema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import de.dailab.common.gmf.command.AbstractGmfCommand;
import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.owlsdescription.ServiceDescription;
import de.dailab.jiactng.sema2.planning.util.GroundedRatedServiceDescription;
import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.util.VsdtElementFactory;
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
			
			// also, we have to put this inside a command
			AbstractGmfCommand command = new AbstractGmfCommand(bps, "Import Semantic Service") {
				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					// finally, add the service to the BPS' list of services
					bps.getServices().add(service);
					// add data types referred to by service
					mergeInto(dataTypes, bps.getDataTypes());
					return CommandResult.newOKCommandResult(bps);
				}
			};
			
			// this JIAC agent is not running in the UI thread, so we have to asynch-exec this
			Display.getDefault().asyncExec(() -> editor.getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(command)));
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

			// get selection
			AbstractProcess process = null;
			FlowObjectContainer container = null;
			ISelection selection = editor.getEditorSite().getSelectionProvider().getSelection();
			if (selection instanceof StructuredSelection) {
				StructuredSelection ssel = (StructuredSelection) selection;
				System.out.println(ssel);
				if (ssel.getFirstElement() instanceof IGraphicalEditPart) {
					IGraphicalEditPart editPart= (IGraphicalEditPart) ssel.getFirstElement();
					EObject selected = ((View) editPart.getModel()).getElement();
					if (selected instanceof Activity && ((Activity) selected).getActivityType() == ActivityType.EMBEDDED) {
						process = (Activity) selected;
						container = (Activity) selected;
					}
					if (selected instanceof Pool && ! ((Pool) selected).getLanes().isEmpty()) {
						process = (Pool) selected;
						container = ((Pool) selected).getLanes().get(0);
					}
					if (selected instanceof Lane) {
						process = ((Lane) selected).getParent();
						container = (Lane) selected;
					}
				}
			}
			if (process == null || container == null) {
				// XXX this kind of exception does not get propagated correctly
				throw new RuntimeException("Please select the Pool or Subprocess where to insert the plan!");
			}
			final AbstractProcess theProcess = process;
			final FlowObjectContainer theContainer = container;
			// TODO if selection is sequence flow, insert on that flow?
			// TODO if no selection, add new pool with plan to process diagram?

			// stuff that will get created in this action
			List<DataType> allTypes = new ArrayList<>();
			List<Service> services = new ArrayList<>();
			List<Activity> tasks = new ArrayList<>();
			List<SequenceFlow> flows = new ArrayList<>();
			Map<String, Property> properties = process.getProperties().stream()
					.collect(Collectors.toMap(p -> p.getName(), p -> p));
			
			// for each service constituting the plan...
			for (GroundedRatedServiceDescription grsd : groundedPlan) {
				// ... derive the service and the data types used therein
				Service service = SemanticServiceFactory.createService(grsd.getSd());
				allTypes.addAll(SemanticServiceFactory.createDatatypes(grsd.getSd()));

				// ... create a task, invoking that service
				Activity task = VsdtFactory.eINSTANCE.createActivity();
				task.setName("Invoke " + grsd.getSd().getServiceName());
				task.setActivityType(ActivityType.SERVICE);
				task.setImplementation(service);

				// ...create assignments for the grounded parameters
				Map<OWLNamedIndividual, OWLClass> inputTypes = reverse(grsd.getInputBindingClassMapping());
				int index = 0;
				for (OWLNamedIndividual individual : grsd.getInputBinding()) {
					String name = individual.getIRI().getFragment();
					// XXX not working correctly yet, maybe no class for some individuals?
					String type = inputTypes.containsKey(individual) ? inputTypes.get(individual).getIRI().getFragment() : "unknown";
					// for each fact, create a property, if not already exists
					properties.putIfAbsent(name, VsdtElementFactory.createProperty(name, type));
					Assignment assign = VsdtElementFactory.createAssignmen(service.getInput().get(index++),
							VsdtElementFactory.createExpression(name), AssignTimeType.START);
					task.getAssignments().add(assign);
				}
				// TODO do the same for the outputs...

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

							// merge newly created services, data types and properties
							mergeInto(services, bpd.getParent().getServices());
							mergeInto(allTypes, bpd.getParent().getDataTypes());
							mergeInto(properties.values(), theProcess.getProperties());

							// this actually works quite well, except they are not laid out properly
							theContainer.getContainedFlowObjects().addAll(tasks);
							// flows appear only upon reloading the diagram, though. still okay for testing
							bpd.getConnections().addAll(flows);

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

	/**
	 * Inverse a Map<K, Collection<V>> to Map<V, K>. Obviously, the V should
	 * be unique across all collections, otherwise the result is undefined.
	 * This can be used e.g. for reversing the class-to-instances map.
	 *
	 * @param map	map mapping X to some Y
	 * @return		map mapping Y to X
	 */
	private <K, V, C extends Collection<V>> Map<V, K> reverse(Map<K, C> map) {
		Map<V, K> result = new HashMap<>();
		for (K key : map.keySet()) {
			for (V value : map.get(key)) {
				result.put(value, key);
			}
		}
		return result;
//		return map.entrySet().stream()
//				.flatMap(e -> e.getValue().stream()
//						.map(v -> new SimpleEntry<K, V>(e.getKey(), v)))
//				.collect(Collectors.toMap(e -> e.getValue(), e -> e.getKey()));
	}
}
