package de.dailab.vsdt.vsdtagents.interpreter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.diagram.interpreter.simulation.InterpretingSimulation;

/**
 * JIAC Enabled VSDT Interpreter. This class extends the InterpretingSimulation
 * with a binding to a JIAC Agent Bean, enabling it to actually invoke the
 * services described in the VSDT processes.
 * 
 * Currently this works fine for primitive data types, but not for complex ones.
 * 
 * @author kuester
 */
public class JiacEnabledVsdtInterpreter extends InterpretingSimulation {

	/*
	 * TODO
	 * - make asynchronous: use executeBegin, executeEnd, calculateCanFinish
	 * - support for messaging (send, receive), too
	 * - VXL needs to be extended with property accessors
	 * - SHOWSTOPPER?: payload classes have to be on the classpath!
	 */
	
	/** the bean used for invoking the services */
	private final VsdtInterpreterBean bean;
	
	/** the list of currently known actions */
	private final Map<Service, IActionDescription> actionsMap;

	public JiacEnabledVsdtInterpreter(VsdtInterpreterBean bean) {
		this.bean = bean;
		this.actionsMap = new HashMap<Service, IActionDescription>();
	}
	
	@Override
	public String getName() {
		return "JIAC Enabled Interpreter";
	}
	
	/*
	 * INTERPRTER LIFECYCLE METHODS
	 */
	
	/**
	 * check whether all the services declared in the diagram are known as
	 * actions; populate actiosMap on the fly
	 */
	@Override
	public boolean isApplicable(BusinessProcessDiagram diagram) throws Exception {
		actionsMap.clear();
		List<IActionDescription> actions = bean.getActions();
		for (Service service : getInvokedServices(diagram)) {
			for (IActionDescription action : actions) {
				if (matches(action, service)) {
					actionsMap.put(service, action);
					break;
				}
			}
			if (actionsMap.get(service) == null) {
				throw new Exception("No matching Action found for Service " + service.toString());
			}
		}
		return super.checkDiagram(diagram);
	}
	
	/**
	 * in case of service task, invoke matching JIAC action for service
	 */
	@Override
	protected void executeBegin(FlowObject flowObject) {
		super.executeBegin(flowObject);
		if (flowObject instanceof Activity) {
			Activity activity = (Activity) flowObject;
			switch (activity.getActivityType()) {
			case SERVICE:
			case USER:
				if (activity.getImplementation() instanceof Service) {
					Service service = (Service) activity.getImplementation();
					
					// find actions matching service
					IActionDescription action = actionsMap.get(service);
					
					try {
						// get parameters
						List<Serializable> parameters = new ArrayList<Serializable>();
						for (Property input : service.getInput()) {
							Serializable value = getPropertyValue(input);
							parameters.add(value);
						}
					
						// invoke action with parameters
						Serializable[] results = bean.invokeAction(action, parameters.toArray(new Serializable[parameters.size()]));
						assert results.length == service.getOutput().size();
						
						// assign action results to properties
						for (int i=0; i < service.getOutput().size(); i++) {
							Property output = service.getOutput().get(i);
							Serializable result = results[i];
							setPropertyValue(output, result);
						}
						
					} catch (Exception e) {
						// TODO what to do with exception?
						e.printStackTrace();
					}
				}
				break;
			case SEND:
			case RECEIVE:
				// TODO
				break;
			default:
				break;
			}
		}
	}
	
	/*
	 * HELPER METHODS
	 */
	
	/**
	 * Check whether the given action matches the given service description.
	 * 
	 * @param action		some JIAC action description
	 * @param service		some VSDT service description
	 * @return				match?
	 */
	private boolean matches(IActionDescription action, Service service) {
		if (action == null) return false;
		if (service == null) return false;
		// check action name
		if (! action.getName().equals(service.getOperation())) return false;
		// TODO check parameters
		return true;
	}
	
	/**
	 * Get the Services invoked by the given element or it's child elements
	 * @param eObject
	 * @return
	 */
	private List<Service> getInvokedServices(EObject eObject) {
		List<Service> services = new ArrayList<Service>();
		if (eObject instanceof BusinessProcessDiagram) {
			BusinessProcessDiagram bpd = (BusinessProcessDiagram) eObject;
			for (Pool pool : bpd.getPools()) {
				services.addAll(getInvokedServices(pool));
			}
		}
		if (eObject instanceof Pool) {
			Pool pool = (Pool) eObject;
			for (FlowObject flowObject : pool.getGraphicalElements()) {
				services.addAll(getInvokedServices(flowObject));
			}
		}
		if (eObject instanceof Activity) {
			Activity activity = (Activity) eObject;
			switch (activity.getActivityType()) {
			case EMBEDDED:
				for (FlowObject flowObject : activity.getContainedFlowObjects()) {
					services.addAll(getInvokedServices(flowObject));
				}
				break;
			case SERVICE:
			case USER:
				if (activity.getImplementation() instanceof Service) {
					services.add((Service) activity.getImplementation());
				}
				break;
			default:
				break;
			}
			if (activity.getActivityType() == ActivityType.EMBEDDED) {
			}
		}
		return services;
	}
	
}
