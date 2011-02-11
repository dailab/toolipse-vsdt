package de.dailab.vsdt.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.GraphicalObject;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.LoopAttributeSet;
import de.dailab.vsdt.LoopType;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.StandardLoopAttSet;


/**
 * Some non-creational static helper methods that otherwise would have to be 
 * implemented multiple times, e.g. due to multiple inheritances.
 * 
 * Some of these methods could also be included in the model classes.
 * 
 * @author tkuester
 */
public class VsdtHelper {

	/**
	 * create and initialize a new id object for the given
	 * idObject and bind it to the idObject
	 * 
	 * @param idObject	some ID object, needing a new ID
	 */
	public static void generateNewID(IdObject idObject) {
		String id= EcoreUtil.generateUUID();
		idObject.setId(id);
	}
	
	/**
	 * Get the condition expression from the given sequence flow or return a 
	 * message that the condition has to be implemented.
	 * 
	 * @param seq	some conditional sequence flow
	 * @return		the sequence flow's condition expression or a message that the condition has to be implemented
	 */
	public static String getConditionExpression(SequenceFlow seq) {
		String cond= null;
		if (seq != null && seq.getConditionExpression() != null) {
			cond= seq.getConditionExpression().getExpression();
		}
		if (cond == null) {
			cond= "null";
		}
		return cond;
	}
	
	/**
	 * @param eObject	some eObject
	 * @return			the name of the eObject, if any, or null
	 */
	public static String getName(EObject eObject) {
		if (eObject instanceof IdObject) {
			return ((IdObject) eObject).getNameOrId();
		}
		return null;
	}
	
	/**
	 * Gets the source of a given Connecting Object
	 * 
	 * @param connection	Some BPMN Connection, i.e. SequenceFlow, MessageFlow, or Association
	 * @return				The connection's source
	 */
	public static GraphicalObject getSource(ConnectingObject connection) {
		if (connection instanceof SequenceFlow) {
			return ((SequenceFlow) connection).getSource();
		}
		if (connection instanceof MessageFlow) {
			return ((MessageFlow) connection).getSource();
		}
		if (connection instanceof Association) {
			return ((Association) connection).getSource();
			
		}
		return null;
	}
	
	/**
	 * Gets the target of a given Connecting Object
	 * 
	 * @param connection	Some BPMN Connection, i.e. SequenceFlow, MessageFlow, or Association
	 * @return				The connection's target
	 */
	public static GraphicalObject getTarget(ConnectingObject connection) {
		if (connection instanceof SequenceFlow) {
			return ((SequenceFlow) connection).getTarget();
		}
		if (connection instanceof MessageFlow) {
			return ((MessageFlow) connection).getTarget();
		}
		if (connection instanceof Association) {
			return ((Association) connection).getTarget();
			
		}
		return null;
	}

	/**
	 * translate the (nonexistence of) some loop attribute set to a loop type
	 */
	public static LoopType toLoopType(LoopAttributeSet attSet) {
		if (attSet instanceof StandardLoopAttSet) {
			return LoopType.STANDARD;
		}
		if (attSet instanceof MultiLoopAttSet) {
			return LoopType.MULTIINSTANCE;
		}
		return LoopType.NONE;
	}
	
	/**
	 * Provides a type-independent variant of getVisibleProperties
	 * 
	 * @param object	some BPMN object that might have or inherit properties
	 * @return			visible properties of that element
	 */
	public static List<Property> getVisibleProperties(EObject object) {
		if (object instanceof Pool) {
			return ((Pool) object).getProperties();
		}
		if (object instanceof DataObject) {
			return ((DataObject) object).getProperties();
		}
		if (object instanceof MessageChannel) {
			MessageChannel channel = (MessageChannel) object;
			return channel.getPayload() == null ? new ArrayList<Property>() : 
					Arrays.asList(channel.getPayload());
		}
		if (object instanceof Service) {
			Service service = (Service) object;
			List<Property> properties = new ArrayList<Property>();
			properties.addAll(service.getInput());
			properties.addAll(service.getOutput());
			return properties;
		}
//		if (object instanceof MessageFlow) {
//			return getVisibleProperties(((MessageFlow) object).getMessage());
//		}
		if (object instanceof SequenceFlow) {
			return getVisibleProperties(((SequenceFlow) object).getSource());
		}
		if (object instanceof Expression) {
			return getVisibleProperties(object.eContainer());
		}
		if (object instanceof Assignment) {
			return getVisibleProperties(object.eContainer());			
		}
		if (object instanceof LoopAttributeSet) {
			LoopAttributeSet loopAttributes = (LoopAttributeSet) object;
			return getVisibleProperties(loopAttributes.getParent());
		}
		if (object instanceof FlowObject) {
			List<Property> properties = new ArrayList<Property>();
			FlowObject flowObject = (FlowObject) object;
			if (object instanceof Activity) {
				Activity activity= (Activity) object;
				properties.addAll(activity.getProperties());
				if (activity.getImplementation() != null) {
					properties.addAll(getVisibleProperties(activity.getImplementation()));
				}
			}
			if (object instanceof Event) {
				Event event= (Event) object;
				if (event.getImplementation() != null) {
					properties.addAll(getVisibleProperties(event.getImplementation()));
				}
			}
			properties.addAll(getVisibleProperties(flowObject.getAbstractProcess()));
			return properties;
		}
		return new ArrayList<Property>();
	}
	
	/**
	 * Print a uniformly formatted string representation of the given property 
	 * to be used in the assignment list as well as in the comboBox
	 * 
	 * @param property		the property
	 * @param printType		print the property's type, too?
	 * @return				string representation
	 */
	public static String getPropertyString(Property property, boolean printType) {
		StringBuffer buff= new StringBuffer();
		if (property == null) {
			return "<null>";//$NON-NLS-1$
		}
		EObject container= property.eContainer();
		String name= null;
		if (container instanceof IdObject) {
			name= ((IdObject) container).getName();
		}
		if (container instanceof Service) {
			name= ((Service) container).getOperation();
		}
		if (container instanceof MessageChannel) {
			name= ((MessageChannel) container).getChannel().getExpression();
		}
		if (name != null) {
			buff.append(name);
			buff.append(" -> ");//$NON-NLS-1$
		}
		buff.append(property.getName() != null ? property.getName() : "<unnamed>");//$NON-NLS-1$
		if (printType) {
			buff.append(": ");//$NON-NLS-1$
			buff.append(property.getType());
		}
		return buff.toString();
	}
	
	/**
	 * Get the depth of containment for the given Flow Object.  A Flow Object
	 * directly contained in a Lane/Pool/Process will have depth==0
	 * 
	 * @param flowObject	the FlowObject which's depth is to be determined
	 * @return				depth (0 for top level elements, or -1 if error
	 */
	public static int getDepth(FlowObject flowObject) {
		if (flowObject.getParent() instanceof Lane) {
			return 0;
		}
		if (flowObject.getParent() instanceof FlowObject) {
			return getDepth((FlowObject) flowObject.getParent()) + 1;
		}
		return -1;
	}

	/**
	 * Computes and returns a list of possible types for that flow object, i.e.
	 * 'Service' Task, or 'Timer' Event.
	 * 
	 * @param flowObject	some Flow Object, i.e. Activity, Event, or Gateway
	 * @return				list of possible types for that flow object
	 */
	public static List<Enum<?>> getPossibleTypes(FlowObject flowObject) {
		List<Enum<?>> types= new ArrayList<Enum<?>>();
		if (flowObject instanceof Event) {
			Event event = (Event) flowObject;
			types.addAll(event.getValidTriggerTypes());
		}
		if (flowObject instanceof Activity) {
			types.addAll(ActivityType.VALUES);			
		}
		if (flowObject instanceof Gateway) {
			types.addAll(GatewayType.VALUES);
		}
		return types;
	}
	
	/**
	 * Return the currently selected type of the given FlowObject, independently
	 * of its actual class, e.g. 'Service' for a Task, or 'Timer' for an Event
	 * @param flowObject
	 * @return
	 */
	public static Enum<?> getType(FlowObject flowObject) {
		if (flowObject instanceof Event) {
			return ((Event) flowObject).getTrigger();
		}
		if (flowObject instanceof Gateway) {
			return ((Gateway) flowObject).getGatewayType();
		}
		if (flowObject instanceof Activity) {
			return ((Activity) flowObject).getActivityType();
		}
		return null;
	}
	
	/**
	 * Returns a nicely formatted representation for that object, including
	 * the name of its class, an if possible the element's name and type. 
	 * 
	 * @param element		some EObject, preferably a FlowObject
	 * @return				type ? eClass ' name ' 
	 */
	public static String getDescriptiveName(EObject element) {
		if (element == null) {
			return null;
		}
		StringBuffer buffer= new StringBuffer();
		String type= null;
		if (element instanceof Event) {
			type= ((Event) element).getTrigger().getName();
		}
		if (element instanceof Gateway) {
			type= ((Gateway) element).getGatewayType().getName();
		}
		if (element instanceof Activity) {
			type= ((Activity) element).getActivityType().getName();
		}
		if (type != null && ! type.equals("NONE")) {
			// title case type
			type= type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
			buffer.append(type).append(" ");
		}
		buffer.append(element.eClass().getName());
		Object name= element.eGet(element.eClass().getEStructuralFeature("name"));
		if (name instanceof String && ! ((String) name).isEmpty()) {
			((String) name).replace("\r\n", " ");
			buffer.append(" '").append(name).append("'");
		}
		return buffer.toString();
	}
	
//	/**
//	 * Helper method for comparing two (non-identical) IdObjects based on their
//	 * (hopefully unique) ID feature. Both IDs have to be non-null.
//	 * 
//	 * @param object1	First Object
//	 * @param object2	Second Object
//	 * @return			object1.id equals object2.id ?
//	 */
//	public static boolean equals(IdObject object1, IdObject object2) {
//		if (object1.getId() != null && object2.getId() != null) {
//			return object1.getId().equals(object2.getId());
//		}
//		return false;
//	}

	/**
	 * Get Root Element for any EObject.
	 * 
	 * @param child		some EObject
	 * @return			the EObject being (grand) parent of the EObject just beneath the Resource 
	 */
	public static EObject getRootElement(EObject object) {
		if (object != null) {
			if (object.eContainer() == null || object.eContainer() == object.eResource()) {
				return object;
			} else {
				return getRootElement(object.eContainer());
			}
		}
		return null;
	}
	
	/**
	 * Get all the FlowObjects transitively contained in the given Process, i.e.
	 * including Flow Objects contained in Subprocesses, as Boundary Events, or
	 * in Structuring Elements.
	 * 
	 * @param process	Some Process
	 * @return			All Flow Objects contained in the Process
	 */
	public static List<FlowObject> getAllGraphicalElements(AbstractProcess process) {
		List<FlowObject> list= new ArrayList<FlowObject>();
		list.addAll(process.getGraphicalElements());
		if (process instanceof Activity) {
			list.addAll(((Activity) process).getBoundaryEvents());
		}
		
		Queue<FlowObject> queue = new LinkedList<FlowObject>();
		queue.addAll(list);
		while (! queue.isEmpty()) {
			FlowObject flowObject = queue.remove();
			for (EObject content : flowObject.eContents()) {
				if (content instanceof FlowObject) {
					FlowObject fo = (FlowObject) content;
					list.add(fo);
					queue.add(fo);
				}
			}
		}
		return list;
	}
}
