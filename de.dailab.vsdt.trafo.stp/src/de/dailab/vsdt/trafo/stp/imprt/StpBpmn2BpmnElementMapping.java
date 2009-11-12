package de.dailab.vsdt.trafo.stp.imprt;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.stp.bpmn.BpmnDiagram;
import org.eclipse.stp.bpmn.BpmnFactory;
import org.eclipse.stp.bpmn.Identifiable;
import org.eclipse.stp.bpmn.MessagingEdge;
import org.eclipse.stp.bpmn.NamedBpmnObject;
import org.eclipse.stp.bpmn.SequenceEdge;
import org.eclipse.stp.bpmn.SubProcess;
import org.eclipse.stp.bpmn.Vertex;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.Artifact;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.GraphicalObject;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.Node;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;

/**
 * STP to BPMN visitor. This visitor is performing a top-down pass of the STP BPMN model. 
 * This way it creates the element mapping for all the elements passed on the way.
 * 
 *  This mapping supports only a small subset of the VSDT BPMN metamodel, because the 
 *  STP BPMN metamodel has much fewer attributes.
 * 
 * @author tkuester
 */
public class StpBpmn2BpmnElementMapping extends MappingStage {

	/*
	 * TODO
	 * - map Lanes
	 */
	
	/** this list is used for collecting the sequence edges from all (sub)processes to be mapped after all the vertices have been mapped */
	private List<SequenceEdge> sequenceEdges= new ArrayList<SequenceEdge>();
	
	/** this list is used for collecting the associations from all (sub)processes to be mapped after all the vertices have been mapped */
	private List<org.eclipse.stp.bpmn.Association> associations= new ArrayList<org.eclipse.stp.bpmn.Association>();
	
	protected VsdtFactory vsdtFac= VsdtFactory.eINSTANCE;

	/** often needed for inserting connections, artifacts etc.*/
	private BusinessProcessDiagram _currentDiagram;
	
	@Override
	public void initialize() {
		_currentDiagram= null;
	}

	@Override
	protected boolean internalApply() {
		BpmnDiagram bpmnDiagram= BpmnFactory.eINSTANCE.createBpmnDiagram();
		bpmnDiagram= (BpmnDiagram) wrapper.getSourceModel();
		BusinessProcessDiagram bpd= visitBusinessProcessDiagram(bpmnDiagram);
		if (bpd!= null) {
			
			BusinessProcessSystem bps= vsdtFac.createBusinessProcessSystem();
			bps.setName(bpd.getName());
			bps.getBusinessProcesses().add(bpd);
			wrapper.getTargetModels().add(bps);
			return true;
		} else {
			return false;
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
	 * @param diagram	the BPMN process diagram to be mapped
	 */
	private BusinessProcessDiagram visitBusinessProcessDiagram(BpmnDiagram source) {
		TrafoLog.trace("Visiting Business Process Diagram '" + source.getName() + "'");
		
		BusinessProcessDiagram target= vsdtFac.createBusinessProcessDiagram();
		_currentDiagram= target;
		mapBasicAttributes(source, target);
		wrapper.map(source, target);
//		target.setAuthor(source.getAuthor());
//		target.setCreationDate(new Date());
//		target.setModificationDate(new Date());
		
		for (org.eclipse.stp.bpmn.Pool pool : source.getPools()) {
			visitPool(pool);
		}
		for (org.eclipse.stp.bpmn.Artifact artifact : source.getArtifacts()) {
			visitArtifact(artifact);
		}
		for (MessagingEdge messagingEdge : source.getMessages()) {
			visitMessageFlow(messagingEdge);
		}
		// now, visit the collected sequence edges and artifacts
		for (SequenceEdge sequenceEdge : sequenceEdges) {
			visitSequenceEdge(sequenceEdge);
		}
		for (org.eclipse.stp.bpmn.Association association : associations) {
			visitAssociation(association);
		}
		return target;
	}

	
	private Pool visitPool(org.eclipse.stp.bpmn.Pool source) {
		TrafoLog.trace("Visiting Pool '" + source.getName() + "'");
		
		Pool target= vsdtFac.createPool();
		wrapper.map(source, target);
		mapBasicAttributes(source, target);
		target.setParentDiagram(_currentDiagram);
		for (org.eclipse.stp.bpmn.Lane lane : source.getLanes()) {
			visitLane(lane);
		}
		Lane lane= vsdtFac.createLane();
		target.getLanes().add(lane);
		target.setProcess(vsdtFac.createBpmnProcess());
		for (Vertex vertex : source.getVertices()) {
			lane.getContainedFlowObjects().add(visitActivity((org.eclipse.stp.bpmn.Activity) vertex));
		}
		for (org.eclipse.stp.bpmn.Artifact artifact : source.getArtifacts()) {
			visitArtifact(artifact);
		}
		// sequence edges are mapped later, after all the nodes have been mapped
		sequenceEdges.addAll(source.getSequenceEdges());
		return target;
	}

	
	private Lane visitLane(org.eclipse.stp.bpmn.Lane source) {
		TrafoLog.trace("Visiting Lane '" + source.getName() + "'");
		
//		Lane target= vsdtFac.createLane();
//		map(source, target);
//		mapBasicAttributes(source, target);
//		target.setParentPool((Pool) getMapping(source.getPool()));
//		
////		for (org.eclipse.stp.bpmn.Activity activity : source.getActivities()) {
////			visitActivity(activity);
////		}
//		return target;
		// TODO implement this method
		return null;
	}
	
	
	private FlowObject visitActivity(org.eclipse.stp.bpmn.Activity source) {
		TrafoLog.trace("Visiting Activity'" + source.getName() + "'");
		
		// default: None-Task
		FlowObject target= vsdtFac.createActivity();
		String typeString= source.getActivityType().getLiteral();
		
		// Events
		if (typeString.startsWith("Event")) {
			if (typeString.startsWith("EventStart")) {
				target= vsdtFac.createStart();
			}
			if (typeString.startsWith("EventIntermediate")) {
				target= vsdtFac.createIntermediate();
			}
			if (typeString.startsWith("EventEnd")) {
				target= vsdtFac.createEnd();
			}
			TriggerType trigger= TriggerType.NONE;
			if (typeString.endsWith("Empty")) trigger= TriggerType.NONE; 
			if (typeString.endsWith("Message")) trigger= TriggerType.MESSAGE;
			if (typeString.endsWith("Rule")) trigger= TriggerType.RULE;
			if (typeString.endsWith("Link")) trigger= TriggerType.LINK;
			if (typeString.endsWith("Multiple")) trigger= TriggerType.MULTIPLE;
			if (typeString.endsWith("Compensation")) trigger= TriggerType.COMPENSATION;
			if (typeString.endsWith("Cancel")) trigger= TriggerType.CANCEL;
			if (typeString.endsWith("Terminate")) trigger= TriggerType.TERMINATE;
			if (typeString.endsWith("Error")) trigger= TriggerType.ERROR;
			if (typeString.endsWith("Timer")) trigger= TriggerType.TIMER;
			if (typeString.endsWith("Signal")) trigger= TriggerType.SIGNAL;
			((Event)target).setTrigger(trigger);
		}
		
		// Gateways
		if (typeString.startsWith("Gateway")) {
			target= vsdtFac.createGateway();
			GatewayType type= GatewayType.XOR_DATA;
			if (typeString.endsWith("Parallel")) type= GatewayType.AND;
			if (typeString.endsWith("Inclusive")) type= GatewayType.OR;
			if (typeString.endsWith("Complex")) type= GatewayType.COMPLEX;
			if (typeString.endsWith("DataBasedExclusive")) type= GatewayType.XOR_DATA; 
			if (typeString.endsWith("EventBasedExclusive")) type= GatewayType.XOR_EVENT;
			((Gateway) target).setGatewayType(type);
		}
		
		// Subprocess
		if (source instanceof SubProcess) {
			SubProcess subProcess= (SubProcess) source;
			((Activity) target).setActivityType(ActivityType.EMBEDDED);
			for (Vertex vertex : subProcess.getVertices()) {
				FlowObject flowObject= visitActivity((org.eclipse.stp.bpmn.Activity) vertex);
				((Activity) target).getContainedFlowObjects().add(flowObject);
			}
			for (org.eclipse.stp.bpmn.Activity eventHandler : subProcess.getEventHandlers()) {
				FlowObject flowObject= visitActivity(eventHandler);
				if (flowObject instanceof Intermediate) {
					((Activity) target).getBoundaryEvents().add((Intermediate) flowObject);
				}
			}
			for (org.eclipse.stp.bpmn.Artifact artifact : subProcess.getArtifacts()) {
				visitArtifact(artifact);
			}
			// sequence edges are mapped later, after all the nodes have been mapped
			sequenceEdges.addAll(subProcess.getSequenceEdges());
			if (subProcess.isIsTransaction()) {
				((Activity) target).setTransaction(vsdtFac.createTransaction());
			}
		}
		
		if (target instanceof Activity && source.isLooping()) {
			((Activity) target).setLoopAttributes(vsdtFac.createStandardLoopAttSet());
		}
		
		mapBasicAttributes(source, target);
		wrapper.map(source, target);
		return target;
	}
	

	private SequenceFlow visitSequenceEdge(SequenceEdge source) {
		TrafoLog.trace("Visiting SequenceFlow'" + source.getName() + "'");
		SequenceFlow target= vsdtFac.createSequenceFlow();
		wrapper.map(source, target);
		mapBasicAttributes(source, target);
		target.setParentDiagram(_currentDiagram);
		target.setSource((FlowObject) wrapper.getMapping(source.getSource()));
		target.setTarget((FlowObject) wrapper.getMapping(source.getTarget()));
		switch (source.getConditionType()) {
		case NONE_LITERAL:
			target.setConditionType(ConditionType.NONE);
			break;
		case DEFAULT_LITERAL:
			target.setConditionType(ConditionType.DEFAULT);
			break;
		case EXPRESSION_LITERAL:
			target.setConditionType(ConditionType.EXPRESSION);
			break;
		}
		if (target.getSource() == null || target.getTarget() == null) {
			TrafoLog.warn("Source or Target Feature is null for Sequence Flow '" + target.getName() + "'");
		}
		return target;
	}

	
	private MessageFlow visitMessageFlow(MessagingEdge source) {
		TrafoLog.trace("Visiting MessagingEdge'" + source.getName() + "'");
		MessageFlow target= vsdtFac.createMessageFlow();
		wrapper.map(source, target);
		mapBasicAttributes(source, target);
		target.setParentDiagram(_currentDiagram);
		target.setSource((Node) wrapper.getMapping(source.getSource()));
		target.setTarget((Node) wrapper.getMapping(source.getTarget()));
		if (target.getSource() == null || target.getTarget() == null) {
			TrafoLog.warn("Source or Target Feature is null for Message Flow '" + target.getName() + "'");
		}
		return target;
	}

	
	private Association visitAssociation(org.eclipse.stp.bpmn.Association source) {
		TrafoLog.trace("Visiting Association");
		Association target= vsdtFac.createAssociation();
		wrapper.map(source, target);
		target.setSource((GraphicalObject) wrapper.getMapping(source.getSource()));
		target.setTarget((GraphicalObject) wrapper.getMapping(source.getTarget()));
		target.setParentDiagram(_currentDiagram);
		switch (source.getDirection()) {
		case NONE_LITERAL:
			target.setDirection(de.dailab.vsdt.DirectionType.NONE);
			break;
		case FROM_LITERAL:
			target.setDirection(de.dailab.vsdt.DirectionType.ONE);
			break;
		case BOTH_LITERAL:
			target.setDirection(de.dailab.vsdt.DirectionType.BOTH);
			break;
		}
		if (target.getSource() == null || target.getTarget() == null) {
			TrafoLog.warn("Source or Target Feature is null for Association '" + target.getName() + "'");
		}
		return target;
	}

	
	private Artifact visitArtifact(org.eclipse.stp.bpmn.Artifact source) {
		TrafoLog.trace("Visiting Artifact'" + source.getName() + "'");
		Artifact target= null;
		if (source instanceof org.eclipse.stp.bpmn.DataObject) {
			target= vsdtFac.createDataObject();
		}
		if (source instanceof org.eclipse.stp.bpmn.Group) {
			target= vsdtFac.createGroup();
		}
		if (source instanceof org.eclipse.stp.bpmn.TextAnnotation) {
			target= vsdtFac.createTextAnnotation();
			target.setDocumentation(source.getName());
		}
		wrapper.map(source, target);
		mapBasicAttributes(source, target);
		target.setParentDiagram(_currentDiagram);
		// associations are mapped later, after all the nodes have been mapped
		associations.addAll(source.getAssociations());
		return target;
	}

//	private BpmnDiagram getParentDiagram(EObject object) {
//		if (object == null) {
//			throw new IllegalArgumentException("Object may not be null");
//		}
//		if (object instanceof BpmnDiagram) {
//			return (BpmnDiagram) object;
//		} else {
//			return getParentDiagram(object.eContainer());
//		}
//	}
	
	
	private void mapBasicAttributes(NamedBpmnObject source, IdObject target) {
		if (source.getDocumentation() != null && ! source.getDocumentation().trim().isEmpty()) {
			target.setDocumentation(source.getDocumentation());
		}
		target.setName(source.getName());
		if (source instanceof Identifiable) {
			target.setId(((Identifiable) source).getID());
		}
	}
	
}
