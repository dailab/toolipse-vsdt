package de.dailab.vsdt.trafo.stp.export;

import org.eclipse.stp.bpmn.BpmnDiagram;
import org.eclipse.stp.bpmn.BpmnFactory;
import org.eclipse.stp.bpmn.DirectionType;
import org.eclipse.stp.bpmn.Identifiable;
import org.eclipse.stp.bpmn.MessageVertex;
import org.eclipse.stp.bpmn.MessagingEdge;
import org.eclipse.stp.bpmn.NamedBpmnObject;
import org.eclipse.stp.bpmn.SequenceEdge;
import org.eclipse.stp.bpmn.SequenceFlowConditionType;
import org.eclipse.stp.bpmn.SubProcess;
import org.eclipse.stp.bpmn.Vertex;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.Artifact;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.End;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Group;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TextAnnotation;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;
import de.dailab.vsdt.trafo.impl.BpmnElementMapping;

/**
 * BPMN to STP visitor. This visitor is performing a top-down pass of the BPMN model. 
 * This way it creates the element mapping for all the elements passed on the way.
 * 
 *  This mapping supports only a small subset of the VSDT BPMN metamodel, because the 
 *  STP BPMN metamodel has much fewer attributes.
 * 
 * @author tkuester
 */
public class Bpmn2StpBpmnElementMapping extends BpmnElementMapping {

	protected BpmnFactory stpFac= BpmnFactory.eINSTANCE;
	
	/*
	 * TODO
	 * - mapping of lanes
	 */
	
	private BpmnDiagram _currentDiagram;
	
	@Override
	public void initialize() {
		_currentDiagram= null;
	}

	@Override
	protected void visitBusinessProcessSystem(BusinessProcessSystem bps) {
		for (BusinessProcessDiagram bpd : bps.getBusinessProcesses()) {
			BpmnDiagram target= visitBusinessProcessDiagram(bpd);
			if (target != null) {
				wrapper.getTargetModels().add(target);
			}
		}
	}

	/*
	 * ///////////////////////////////////////////////////////////
	 * // MAIN VISITOR LOGIC
	 * //////////////////////////////////////////////////////////
	 */
	
	/**
	 * Start the visitor's pass at the top-level business process diagram
	 * 
	 * @param source	the business process diagram to be mapped
	 */
	private BpmnDiagram visitBusinessProcessDiagram(BusinessProcessDiagram source) {
		TrafoLog.trace("Visiting Business Process Diagram '" + source.getName() + "'");
		
		BpmnDiagram target= stpFac.createBpmnDiagram();
		_currentDiagram= target;
		mapBasicAttributes(source, target);
		target.setAuthor(source.getBusinessProcessSystem().getAuthor());
		target.setTitle(source.getName());
		wrapper.map(source, target);
		
		for (Pool pool : source.getPools()) {
			visitPool(pool);
		}
		for (Artifact artifact : source.getArtifacts()) {
			visitArtifact(artifact);
		}
		for (ConnectingObject connection : source.getConnections()) {
			if (connection instanceof SequenceFlow) {
				visitSequenceFlow((SequenceFlow) connection);
			}
			if (connection instanceof MessageFlow) {
				visitMessageFlow((MessageFlow) connection);
			}
			if (connection instanceof Association) {
				visitAssociation((Association) connection);
			}
		}
		return target;
	}

	
	private org.eclipse.stp.bpmn.Pool visitPool(Pool source) {
		TrafoLog.trace("Visiting Pool '" + source.getName() + "'");
		
		org.eclipse.stp.bpmn.Pool target= stpFac.createPool();
		wrapper.map(source, target);
		mapBasicAttributes(source, target);
		target.setBpmnDiagram(_currentDiagram);
		
		for (Lane lane : source.getLanes()) {
			org.eclipse.stp.bpmn.Lane sLane= visitLane(lane);
//			target.getLanes().add(sLane); // XXX 
			target.getVertices().addAll(sLane.getActivities());
			sLane.getActivities().clear(); // XXX 
		}
		return target;
	}

	
	private org.eclipse.stp.bpmn.Lane visitLane(Lane source) {
		/*
		 * In STP, the relation of Lanes to Flow Objects is defined through the layout,
		 * so exporting these might not work properly.
		 */
		TrafoLog.trace("Visiting Lane '" + source.getName() + "'");
		
		org.eclipse.stp.bpmn.Lane target= stpFac.createLane();
		wrapper.map(source, target);
		mapBasicAttributes(source, target);

		for (FlowObject flowObject : source.getContainedFlowObjects()) {
			org.eclipse.stp.bpmn.Activity activity= visitFlowObject(flowObject);
			target.getActivities().add(activity); // XXX 
		}

		return target;
	}
	
	
	private org.eclipse.stp.bpmn.Activity visitFlowObject(FlowObject source) {
		TrafoLog.trace("Visiting FlowObject'" + source.getName() + "'");

		org.eclipse.stp.bpmn.Activity target;
		if (source instanceof Activity && 
				( ((Activity) source).getActivityType() == ActivityType.EMBEDDED ||
				! ((Activity) source).getBoundaryEvents().isEmpty()) ) {
			Activity activity= (Activity) source;
			SubProcess sSubProcess= stpFac.createSubProcess();
			wrapper.map(activity, sSubProcess);
			for (FlowObject flowObject2 : activity.getContainedFlowObjects()) {
				sSubProcess.getVertices().add(visitFlowObject(flowObject2));
			}
			for (Intermediate intermediate : activity.getBoundaryEvents()) {
				sSubProcess.getEventHandlers().add(visitFlowObject(intermediate));
			}
			sSubProcess.setIsTransaction(activity.getTransaction() != null);
			target= sSubProcess;
		} else {
			target= stpFac.createActivity();
			wrapper.map(source, target);
		}
		mapBasicAttributes(source, target);
		
		target.setActivityType(getActivityType(source));
		if (source instanceof Activity) {
			target.setLooping(((Activity)source).getLoopAttributes() != null);
		}
		return target;
	}
	

	private SequenceEdge visitSequenceFlow(SequenceFlow source) {
		TrafoLog.trace("Visiting SequenceFlow'" + source.getName() + "'");
		SequenceEdge target= stpFac.createSequenceEdge();
		wrapper.map(source, target);
		mapBasicAttributes(source, target);
		target.setSource((Vertex) wrapper.getMapping(source.getSource()));
		target.setTarget((Vertex) wrapper.getMapping(source.getTarget()));
		target.setGraph(target.getSource().getGraph());
		target.setIsDefault(source.getConditionType() == ConditionType.DEFAULT);
		switch (source.getConditionType()) {
		case NONE:
			target.setConditionType(SequenceFlowConditionType.NONE_LITERAL);
			break;
		case DEFAULT:
			target.setConditionType(SequenceFlowConditionType.DEFAULT_LITERAL);
			break;
		case EXPRESSION:
			target.setConditionType(SequenceFlowConditionType.EXPRESSION_LITERAL);
			break;
		}	
		if (target.getSource() == null || target.getTarget() == null) {
			TrafoLog.warn("Source or Target Feature is null for Sequence Edge '" + target.getName() + "'");
		}
		return target;
	}

	
	private MessagingEdge visitMessageFlow(MessageFlow source) {
		TrafoLog.trace("Visiting MessageFlow'" + source.getName() + "'");
		MessagingEdge target= stpFac.createMessagingEdge();
		wrapper.map(source, target);
		mapBasicAttributes(source, target);
		target.setBpmnDiagram(_currentDiagram);
		target.setSource((MessageVertex) wrapper.getMapping(source.getSource()));
		target.setTarget((MessageVertex) wrapper.getMapping(source.getTarget()));
		if (target.getSource() == null || target.getTarget() == null) {
			TrafoLog.warn("Source or Target Feature is null for Messaging Edge '" + target.getName() + "'");
		}
		return target;
	}

	
	private org.eclipse.stp.bpmn.Association visitAssociation(Association source) {
		TrafoLog.trace("Visiting Association'" + source.getName() + "'");
		org.eclipse.stp.bpmn.Association target= stpFac.createAssociation();
		wrapper.map(source, target);

		boolean swapDirection= false;
		Object src= wrapper.getMapping(source.getSource());
		Object trg= wrapper.getMapping(source.getTarget());
		if (src instanceof org.eclipse.stp.bpmn.Artifact) {
			target.setSource((org.eclipse.stp.bpmn.Artifact) src);
			target.setTarget((org.eclipse.stp.bpmn.Vertex) trg);
		} else 
		if (target instanceof org.eclipse.stp.bpmn.Artifact) {
			target.setSource((org.eclipse.stp.bpmn.Artifact) trg);
			target.setTarget((org.eclipse.stp.bpmn.Vertex) src);
			swapDirection= true;
		}
		switch (source.getDirection()) {
		case NONE:
			target.setDirection(DirectionType.NONE_LITERAL);
			break;
		case ONE:
			target.setDirection(swapDirection ? DirectionType.TO_LITERAL : DirectionType.FROM_LITERAL);
			break;
		case BOTH:
			target.setDirection(DirectionType.BOTH_LITERAL);
			break;
		}
		if (target.getSource() == null || target.getTarget() == null) {
			TrafoLog.warn("Source or Target Feature is null for Association '" + source.getName() + "'");
		}
		return target;
	}

	
	private org.eclipse.stp.bpmn.Artifact visitArtifact(Artifact source) {
		TrafoLog.trace("Visiting Artifact'" + source.getName() + "'");
		org.eclipse.stp.bpmn.Artifact target= null;
		if (source instanceof DataObject) {
			target= stpFac.createDataObject();
		}
		if (source instanceof Group) {
			target= stpFac.createGroup();
		}
		if (source instanceof TextAnnotation) {
			target= stpFac.createTextAnnotation();
			source.setName(source.getDocumentation()); // in STP, the text is stored in the name
		}
		if (target != null) {
			wrapper.map(source, target);
			mapBasicAttributes(source, target);
			target.setArtifactsContainer(_currentDiagram);
		}
		return target;
	}

	
	private void mapBasicAttributes(IdObject source, NamedBpmnObject target) {
		if (source.getDocumentation() != null && ! source.getDocumentation().trim().isEmpty()) {
			target.setDocumentation(source.getDocumentation());
		}
		target.setName(source.getName());
		if (target instanceof Identifiable) {
			((Identifiable)	target).setID(source.getId());
		}
	}
	
	private org.eclipse.stp.bpmn.ActivityType getActivityType(FlowObject flowObject) {
		org.eclipse.stp.bpmn.ActivityType at= org.eclipse.stp.bpmn.ActivityType.TASK_LITERAL;
		if (flowObject instanceof Activity) {
			switch (((Activity) flowObject).getActivityType()) {
			case EMBEDDED:
			case INDEPENDENT:
			case SUBPROCESSREFERENCE:
				at= org.eclipse.stp.bpmn.ActivityType.SUB_PROCESS_LITERAL;
				break;
			case MANUAL:
			case NONE:
			case RECEIVE:
			case SCRIPT:
			case SEND:
			case SERVICE:
			case TASKREFERENCE:
			case USER:
				at= org.eclipse.stp.bpmn.ActivityType.TASK_LITERAL;
				break;
			}
		}
		if (flowObject instanceof Start) {
			switch (((Start) flowObject).getTrigger()) {
			case LINK:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_START_LINK_LITERAL;
				break;
			case MESSAGE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_START_MESSAGE_LITERAL;
				break;
			case MULTIPLE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_START_MULTIPLE_LITERAL;
				break;
			case NONE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_START_EMPTY_LITERAL;
				break;
			case RULE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_START_RULE_LITERAL;
				break;
			case TIMER:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_START_TIMER_LITERAL;
				break;
			case SIGNAL:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_START_SIGNAL_LITERAL;
				break;
			}
		}
		if (flowObject instanceof End) {
			switch (((End) flowObject).getTrigger()) {
			case CANCEL:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_END_CANCEL_LITERAL;
				break;
			case COMPENSATION:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_END_COMPENSATION_LITERAL;
				break;
			case ERROR:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_END_ERROR_LITERAL;
				break;
			case LINK:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_END_LINK_LITERAL;
				break;
			case MESSAGE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_END_MESSAGE_LITERAL;
				break;
			case MULTIPLE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_END_MULTIPLE_LITERAL;
				break;
			case NONE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_END_EMPTY_LITERAL;
				break;
			case TERMINATE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_END_TERMINATE_LITERAL;
				break;
			case SIGNAL:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_END_SIGNAL_LITERAL;
				break;
			}
		}
		if (flowObject instanceof Intermediate) {
			switch (((Intermediate) flowObject).getTrigger()) {
			case CANCEL:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_CANCEL_LITERAL;
				break;
			case COMPENSATION:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_COMPENSATION_LITERAL;
				break;
			case ERROR:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_ERROR_LITERAL;
				break;
			case LINK:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_LINK_LITERAL;
				break;
			case MESSAGE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_MESSAGE_LITERAL;
				break;
			case MULTIPLE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_MULTIPLE_LITERAL;
				break;
			case NONE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_EMPTY_LITERAL;
				break;
			case RULE:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_RULE_LITERAL;
				break;
			case TIMER:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_TIMER_LITERAL;
				break;
			case SIGNAL:
				at= org.eclipse.stp.bpmn.ActivityType.EVENT_INTERMEDIATE_SIGNAL_LITERAL;
				break;
			}
		}
		if (flowObject instanceof Gateway) {
			switch (((Gateway) flowObject).getGatewayType()) {
			case AND:
				at= org.eclipse.stp.bpmn.ActivityType.GATEWAY_PARALLEL_LITERAL;
				break;
			case COMPLEX:
				at= org.eclipse.stp.bpmn.ActivityType.GATEWAY_COMPLEX_LITERAL;
				break;
			case OR:
				at= org.eclipse.stp.bpmn.ActivityType.GATEWAY_DATA_BASED_INCLUSIVE_LITERAL;
				break;
			case XOR_DATA:
				at= org.eclipse.stp.bpmn.ActivityType.GATEWAY_DATA_BASED_EXCLUSIVE_LITERAL;
				break;
			case XOR_EVENT:
				at= org.eclipse.stp.bpmn.ActivityType.GATEWAY_EVENT_BASED_EXCLUSIVE_LITERAL;
				break;
			}
		}
		return at;
	}
	
}
