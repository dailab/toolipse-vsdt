package de.dailab.vsdt.trafo.bpel.export;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.xmlsoap.schemas.ws._2003._03.business.process.CaseType;
import org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessFactory;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TAssign;
import org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCatch;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCompensate;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCompensationHandler;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCopy;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFlow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFrom;
import org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke;
import org.xmlsoap.schemas.ws._2003._03.business.process.TLink;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPick;
import org.xmlsoap.schemas.ws._2003._03.business.process.TProcess;
import org.xmlsoap.schemas.ws._2003._03.business.process.TReceive;
import org.xmlsoap.schemas.ws._2003._03.business.process.TReply;
import org.xmlsoap.schemas.ws._2003._03.business.process.TScope;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSequence;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSource;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch;
import org.xmlsoap.schemas.ws._2003._03.business.process.TTarget;
import org.xmlsoap.schemas.ws._2003._03.business.process.TThrow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TVariable;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWait;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWhile;
import org.xmlsoap.schemas.ws._2003._03.business.process.ToType;
import org.xmlsoap.schemas.wsdl.TMessage;
import org.xmlsoap.schemas.wsdl.TOperation;
import org.xmlsoap.schemas.wsdl.TParam;
import org.xmlsoap.schemas.wsdl.TPart;
import org.xmlsoap.schemas.wsdl.TPortType;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.BpmnProcess;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowConditionTypes;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.ProcessType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.base.logger.TrafoLog;
import de.dailab.vsdt.trafo.bpel.util.BpelProcessSet;
import de.dailab.vsdt.trafo.bpel.util.BpelStaticHelper;
import de.dailab.vsdt.trafo.bpel.util.BpelVisitorConstants;
import de.dailab.vsdt.trafo.impl.BpmnElementMapping;
import de.dailab.vsdt.trafo.impl.BpmnMappingHelper;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.export.StrucBpmnMappingAssistant;

/**
 * BPMN to BPEL visitor. This visitor is performing a top-down pass of the BPMN model. this way it creates
 * the element mapping for all the elements passed on the way. after the pass the structure mapping is 
 * delegated to the rule based transformation.
 * 
 * This class is holding a number of methods "visitXXX", which in most cases
 * - receive some BPMN element as parameter
 * - call visitXXX on the parameter's child elements
 * - return a BPEL element being the result of the mapping of the input element
 * - can require additional parameters, for context
 * - can have side effects (e.g. manipulation of the maps or of the context-parameters) if the mapping affects more than the creation of an element
 * 
 * @author tkuester
 */
public class Bpmn2BpelElementMapping extends BpmnElementMapping implements BpelVisitorConstants {
	
	/*
	 * OPEN ISSUES
	 * 
	 * what to do, when there is a none-trigger start event with assignments?
	 * these assignments have to be placed after the first receive/pick!
	 * 
	 * spawn process when embedded subprocess is referenced by its children?
	 * 
	 * Meaning of Tags:
	 * - xxx    Mapping not specified (sufficiently), ignore.
	 * - todo   Mapping implementation incomplete
	 * - fixme  Mapping implementation faulty
	 */
	
	/**
	 * The currently edited process. With each Pool being mapped, the variable is assigned
	 * a new value being used in the following mapping, until the next Pool is reached.
	 * This variable also is assigned a different value for a short time when a MI-Loop
	 * is being mapped.
	 */
	private BpelProcessSet _current;

	public static boolean translateExpressions= true;
	
	public static boolean replaceVarNames= true;
	
	@Override
	public void initialize() {
		_current= null;
		expressionVisitor= new BpelExpressionVisitor(translateExpressions, replaceVarNames);
	}
	
	/**
	 * Adds a newly created Process Set to the wrapper's set of target models
	 * - the ProcessSet is added to the Object-List (for saving)
	 * - the BPEL-Process is added to the Object-List (for the rule-based cleanup-stage)
	 * 
	 * @param procSet	newly created Process Set to be added to the MappingWrapper
	 */
	private void addProcess(BpelProcessSet procSet) {
		wrapper.getTargetModels().add(_current);
		wrapper.getTargetModels().add((DocumentRoot) _current.process.eContainer());
	}

	/*
	 * ///////////////////////////////////////////////////////////
	 * // MAIN VISITOR LOGIC
	 * //////////////////////////////////////////////////////////
	 */
	
	/**
	 * Start the visitor's pass at the top-level Business Process System,
	 * iterate over all Business Process Diagrams and Pools
	 * 
	 * @param bpd	the business process system to be mapped
	 */
	@Override
	protected void visitBusinessProcessSystem(BusinessProcessSystem bps) {
		TrafoLog.trace("Visiting Business Process System'" + bps.getName() + "'");
		for (BusinessProcessDiagram bpd : bps.getBusinessProcesses()) {
			TrafoLog.trace("Visiting Business Process Diagram'" + bpd.getName() + "'");
			for (Pool pool : bpd.getPools()) {
				visitPool(pool);
			}
		}
	}
	
	/**
	 * A BPMN pool/process is mapped to a BPEL process and a WSDL definitions file is created.
	 * Some attributes for the BPEL process are taken from the business process diagram and the pool.
	 * 
	 * @param pool		the BPMN pool
	 * @return			result of mapping
	 */
	private TProcess visitPool(Pool pool) {
		TrafoLog.trace("Visiting Pool '" + pool.getName() + "'");
		BpmnProcess process= pool.getProcess();
		
		//check process type
		ProcessType type= process.getProcessType();
		if (type != ProcessType.ABSTRACT && type != ProcessType.PRIVATE) {
			TrafoLog.info(pool.getName() + ": Process with Process Type " + type.getName() + " will not be mapped. Skipping.");
			return null;
		}
		//check adHoc
		if (process.isAdHoc()) {
			TrafoLog.warn(pool.getName() + ": A mapping for AdHoc Processes is not defined. Skipping.");
			return null;
		}
		
		//create process with WSDL definitions and assign it to the currently used process
		_current= new BpelProcessSet(createProcess(process), null);
		addProcess(_current);
		
		//create references
		wrapper.map(process, _current.process.getPartnerLinks());
		
		//visit children: graphical elements, properties, assignments
		TActivity tActivity= visitFlowObjects(process.getGraphicalElements());
		
		visitProperties(process.getProperties(),process);
		
		//visit assignments: the start-time-assigns have to be inserted after the initializing receive/pick!
		if (! process.getAssignments().isEmpty()) {
			//assignments: create wrapping sequence for the activity and its assignments
			TSequence tSequence= bpelFac.createTSequence();

			//create assignments
			TAssign startAssignments= createAssignFromList(process.getAssignments(), AssignTimeType.START);
			if (startAssignments != null) {
				startAssignments.setName(_current.process.getName() + "_startAssignments");
			}
			TAssign endAssignments= createAssignFromList(process.getAssignments(), AssignTimeType.END);
			if (endAssignments != null) {
				endAssignments.setName(_current.process.getName() + "_endAssignments");
			}
			
			//insert startAssignments after the first receive or pick
			if (startAssignments != null) {
				TActivity firstRoP= null;
				if (tActivity instanceof TReceive || tActivity instanceof TPick) {
					firstRoP= tActivity;
					tActivity= null;
				}
				if (tActivity instanceof TSequence) {
					//firstRoP, if any, will be removed from the sequence and inserted prior to the assignment
					firstRoP= BpelStaticHelper.extractFirstReceiveOrPick((TSequence) tActivity);
				}
				if (firstRoP != null) {
					tSequence.addActivity(firstRoP);
				}
				tSequence.getAssign().add(startAssignments);
			}
			if (tActivity != null) {
				tSequence.addActivity(tActivity);
			}
			if (endAssignments != null) {
				tSequence.getAssign().add(endAssignments);
			}
			tActivity= tSequence;
		}
   
		//if the process has a scope, insert the result in this scope, otherwise insert it directly into the process
		if (_current.process.getScope() != null) {
			_current.process.getScope().setActivity(tActivity);
		} else {
			_current.process.setActivity(tActivity);
		}
		
		return _current.process;
	}
	
	
	/**
	 * Map the given flow objects by iterating the list and visiting each single flow object.
	 * If the list contains only one flowObject, this flowObject is returned, otherwise the flowObjects
	 * are put in a tFlow.
	 * 
	 * @param flowObjects	a list of flow objects
	 */
	private TActivity visitFlowObjects(List<FlowObject> flowObjects) {
		if (flowObjects.size() == 1) {
			//single activity: return that activity
			return visitFlowObject(flowObjects.get(0));
		} else{
			//multiple activities: create flow
			TFlow flow= bpelFac.createTFlow();
			for (FlowObject flowObject : flowObjects) {
				TActivity activity= visitFlowObject(flowObject);
				//put result into the flow
				if (activity != null) {
					flow.getActivityList(activity).add(activity);
					addLinks(activity, flow, flowObject);	
				}
			}
			return flow;
		}
	}
	
	
	/**
	 * This method maps the given flow object to a sequence, holding:
	 * 1.: assignments to be done at the start
	 * 2.: the actual flow object's mapping (delegating to one of the specialized methods)
	 * 3.: assignments to be done at the end
	 * 
	 * @param flowObject	the flow object to be mapped
	 * @return				a sequence wrapping the actual mapping result
	 */
	private TActivity visitFlowObject(FlowObject flowObject) {
		if (flowObject == null) {
			return null;
		}
		TActivity tActivity= null;
		
		//delegate to specialized methods
		if (flowObject instanceof Event) {
			tActivity= visitEvent((Event)flowObject, null);
		}
		if (flowObject instanceof Activity) {
			tActivity= visitActivity((Activity)flowObject);
		}
		if (flowObject instanceof Gateway) {
			tActivity= visitGateway((Gateway)flowObject);
		}
		//special structured BPMN elements
		if (flowObject instanceof BpmnSequence) {
			tActivity= visitBpmnSequence((BpmnSequence)flowObject);
		}
		if (flowObject instanceof BpmnBlock) {
			tActivity= visitBpmnBlock((BpmnBlock)flowObject);
		}
		if (flowObject instanceof BpmnLoopBlock) {
			tActivity= visitBpmnLoopBlock((BpmnLoopBlock)flowObject);
		}
		if (flowObject instanceof BpmnDerivedProcess) {
			tActivity= visitBpmnDerivedProcess((BpmnDerivedProcess)flowObject);
		}
		if (flowObject instanceof BpmnEventHandlerBlock) {
			tActivity= visitBpmnEventHandlerBlock((BpmnEventHandlerBlock)flowObject);
		}
		if (flowObject instanceof BpmnElementToSkip) {
			tActivity= visitBpmnElementToSkip((BpmnElementToSkip)flowObject);
		}
		//the mapping is not stopped if activity==null, since it may still contain some assignments
		if (tActivity == null) {
			tActivity= bpelFac.createTEmpty();
		}
		//set the activity's name (this is the same for all flow objects)
		tActivity.setName(flowObject.getName());
		tActivity= visitAssignments(flowObject, tActivity);

		// this part of the activities mapping is done here, as these other two things have to be done first
		if (flowObject instanceof Activity) {
			Activity activity = (Activity) flowObject;
			//create loop mappings: basic mapping is embedded in loop structure
			if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
				tActivity= createStandardLoop(activity, tActivity);
			}
			if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
				tActivity= createMultiInstanceLoop(activity, tActivity);
			}
		}
		
		wrapper.map(flowObject,tActivity);
		TrafoLog.debug("FlowObject '" + flowObject.getName() + "' has been mapped to " + tActivity.getClass().getName());
		return tActivity;
	}
	
	/**
	 * If a FlowObject has Assignments, the mapping of these Assignments is put in 
	 * a Sequence together with the FlowObject's original mapping, if any.
	 * 
	 * @param flowObject		some FlowObject with or without Assignments
	 * @param mapping			the FlowObjects original mapping
	 * @return
	 */
	private TActivity visitAssignments(FlowObject flowObject, TActivity mapping) {
		if (flowObject != null && ! flowObject.getAssignments().isEmpty()) {
			//assignments: create wrapping sequence for the activity and its assignments
			TSequence tSequence= bpelFac.createTSequence();
			
			//visit assignments: for start events, both start and end assignments have to be done after; for end both have to be done before
			boolean isStart= StrucBpmnMappingAssistant.isStartingOrEndingNode(flowObject, false);
			boolean isEnd=   StrucBpmnMappingAssistant.isStartingOrEndingNode(flowObject, true);
			//insert assignments with AssignTime==before
			if (!isStart) {
				TAssign startAssignments= createAssignFromList(flowObject.getAssignments(), isEnd ? null : AssignTimeType.START);
				if (startAssignments != null) {
					startAssignments.setName(flowObject.getName() + "_startAssignments");
					tSequence.getAssign().add(startAssignments);
				}
			}
			//insert the activity itself in between the assignments
			if (mapping != null) {
				tSequence.addActivity(mapping);
			}
			//insert assignments with AssignTime==after
			if (!isEnd) {
				TAssign endAssignments= createAssignFromList(flowObject.getAssignments(), isStart ? null : AssignTimeType.END);
				if (endAssignments != null) {
					endAssignments.setName(flowObject.getName() + "_endAssignments");
					tSequence.getAssign().add(endAssignments);
				}
			}
			return tSequence;
		}
		return mapping;
	}
	
	/**
	 * Maps the given Event to various BPEL elements, depending on the events types and attributes.
	 *
	 * @param event		the event
	 * @return			result of the mapping
	 */
	private TActivity visitEvent(Event event, TriggerType multiType) {
		TrafoLog.trace("Visiting Event '" + event.getName() + "'");
		TActivity mapping= null;

		TriggerType trigger= multiType != null ? multiType : event.getTrigger();
		switch (trigger) {
		case NONE:
		case LINK:
			// no mapping, but do not issue a warning either
			break;
		case MESSAGE:
			if (event instanceof Intermediate && StrucBpmnMappingAssistant.isStartingOrEndingNode(event, false)) {
				//create onMessage on the processes scope
				//XXX But: won't this END the process instead of starting it?!
//				if (event.getMessage().getTo() == event.getPool().getParticipant()) {
					TProcess process= (TProcess) wrapper.getMapping(event.getProcess());
					TScope scope= BpelStaticHelper.getScope(process);
					TOnMessage onMessage= createOnMessage(event.getMessage(), event.getImplementation());
					BpelStaticHelper.getEventHandlers(scope).getOnMessage().add(onMessage);
//				} else {
//					TrafoLog.error("Intermediate Event '" + event.getName() + "': 'to' must be the same Participant as that of the Intermediate's Pool");
//				}
			} else {
				if (event.isThrowing()) {
					//create Invoke or Reply, depending on whether there is a receive earlier
					Implementation webService= (Implementation) event.getImplementation();
					if (existsUpstreamReceive(event, webService.getInterface(), webService.getOperation())) {
						//create reply with variable = message
						mapping= createReply(event.getMessage(), webService);
					} else {
						//create invoke with outputVariable = message
						mapping= createInvoke(event.getMessage(),null, webService);
					}
				} else {
					//create Receive
					mapping= createReceive(event.getMessage(), event.getImplementation(), event instanceof Start);	
				}
			}
			break;
		case TIMER:
			if (event instanceof Intermediate) {
				//create Wait or event handler
				if (StrucBpmnMappingAssistant.isStartingOrEndingNode(event, false)) {
					//no incoming sequence flow: create onMessage on the processes scope
					//XXX But: won't this END the process instead of starting it?!
					TProcess process= (TProcess) wrapper.getMapping(event.getProcess());
					TScope scope= BpelStaticHelper.getScope(process);
					TOnAlarm onAlarm= bpelFac.createTOnAlarm();
					onAlarm.setFor(BpelStaticHelper.getCondition(event.getTimeCycle()));
					onAlarm.setUntil(BpelStaticHelper.getCondition(event.getTimeDate()));
					BpelStaticHelper.getEventHandlers(scope).getOnAlarm().add(onAlarm);
				} else {
					TWait tWait= bpelFac.createTWait();
					tWait.setFor(BpelStaticHelper.getCondition(event.getTimeCycle()));
					tWait.setUntil(BpelStaticHelper.getCondition(event.getTimeDate()));
					mapping= tWait;
				}
			} else {
				
			}
			break;
		case ERROR:
			//create Throw with faultName == error code
			mapping= bpelFac.createTThrow();
			((TThrow)mapping).setFaultName(BpelStaticHelper.makeQName(event.getErrorCode()));
			break;
		case COMPENSATION:
			//create Compensate with scope == activity
			mapping= bpelFac.createTCompensate();
			((TCompensate)mapping).setScope(event.getActivity().getName());
			break;
		case TERMINATE:
			//create Terminate
			mapping= bpelFac.createTTerminate();
			break;
		default:
			TrafoLog.warn("No mapping found for " + trigger.getName() + " Event '" + event.getNameOrId() + "'");
		}
		
		if (event.getTrigger() == TriggerType.MULTIPLE && multiType == null) {
			
			List<TActivity> children= new ArrayList<TActivity>();
			if (event.getMessage() != null && event.getImplementation() != null) {
				children.add(visitEvent(event, TriggerType.MESSAGE));
			}
			if (event.getTimeCycle() != null || event.getTimeDate() != null) {
				children.add(visitEvent(event, TriggerType.TIMER));
			}
			if (event.getRuleExpression() != null && event.getRuleExpression().getExpression() != null) {
				children.add(visitEvent(event, TriggerType.RULE));
			}
			if (event.getLinkedTo() != null) {
				children.add(visitEvent(event, TriggerType.LINK));
			}
			if (event.getErrorCode() != null) {
				children.add(visitEvent(event, TriggerType.ERROR));
			}
			if (event.getActivity() != null) {
				children.add(visitEvent(event, TriggerType.COMPENSATION));
			}
			if (event.getSignal() != null) {
				children.add(visitEvent(event, TriggerType.SIGNAL));
			}
			if (event.isThrowing()) {
				//create Flow, holding the child triggers
				TFlow tFlow= bpelFac.createTFlow();
				for (TActivity child : children) {
					tFlow.getActivityList(child).add(child);
				}
				mapping= tFlow;
			} else {
				//create Pick, put children mapping to Receive in the pick as onMessages
				TPick tPick= bpelFac.createTPick();
				for (TActivity child : children) {
					if (child instanceof TReceive) {
						TReceive receive= (TReceive) child;
						TOnMessage tOnMessage= bpelFac.createTOnMessage();
						tOnMessage.setPortType(BpelStaticHelper.makeQName(receive.getOperation()));
						tOnMessage.setPartnerLink(receive.getPartnerLink());
						tOnMessage.setOperation(receive.getOperation());
						tOnMessage.setVariable(receive.getVariable());
						tPick.getOnMessage().add(tOnMessage);
					}
				}
				tPick.setCreateInstance(event instanceof Start ? TBoolean.YES : null);
				mapping= tPick;
			}
		}
		return mapping;
	}
	
	/**
	 * Maps the given Activity to various BPEL elements, depending on the activity's types and attributes.
	 * 
	 * @param activity	the activity to map
	 * @return			result of the mapping, including loops etc. 
	 */
	private TActivity visitActivity(Activity activity) {
		TrafoLog.trace("Visiting Activity '" + activity.getName() + "'");
		TActivity mapping= null;
		
		//checks
		if (activity.getTransaction() != null) {
			TrafoLog.warn("A mapping for transactions is not defined. Ignoring transaction attributes.");
		}
		if (activity.isAdHoc()) {
			TrafoLog.warn("A mapping for AdHoc activities is not defined. Ignoring AdHoc attributes.");
		}

		switch (activity.getActivityType()) {
		case NONE:
			// has no mapping, but does not require a warning
			break;
		case EMBEDDED:
			//create Scope and visit child Flow Objects
			mapping= bpelFac.createTScope();
			TActivity childActivity= visitFlowObjects(activity.getGraphicalElements());
			((TScope)mapping).setActivity(childActivity);
			break;
		case TASKREFERENCE:
		case SUBPROCESSREFERENCE:
			//create copy of the mapping of the referenced activity
			Activity ref= activity.getActivityRef();
			//prevent infinite loop (in case of recursive-like references)
			if (ref != activity && ! BpmnMappingHelper.isParentOrEqual(ref, activity)) {
				EObject mappedRef= (EObject) wrapper.getMapping(ref);
				if (mappedRef != null) {
					mapping= (TActivity) EcoreUtil.copy(mappedRef);
				} else {
					mapping= visitActivity(ref);
				}
			}
			break;
		case RECEIVE:
			//create Receive
			mapping= createReceive(activity.getOutMessage(),activity.getImplementation(), activity.isInstantiate());
			break;
		case SEND:
			//create Reply/Invoke
			Implementation webService= (Implementation) activity.getImplementation();
			if (existsUpstreamReceive(activity, webService.getInterface(), webService.getOperation())) {
				//create reply with variable = message
				mapping= createReply(activity.getInMessage(),webService);
			} else {
				//create invoke with inputVariable = message
				mapping= createInvoke(activity.getInMessage(),null,webService);
			}
			break;
		case SERVICE:
		case USER:
			//create Invoke
			// TODO distinguish mapping of USER and SERVICE task
			mapping= createInvoke(activity.getInMessage(),activity.getOutMessage(),activity.getImplementation());
			break;
		case INDEPENDENT:
		case SCRIPT:
			// TODO: Implement missing mappings: INDEPENDENT, SCRIPT, USER
		default:
			TrafoLog.warn("Unable to map " + activity.getActivityType() + " Activity " + activity.getNameOrId());
		}

		// TODO Activity-Life-cycle?
		// StartAss - Act - (Looping? StartAss - Act)* - EndAss
		
		//map properties
		visitProperties(activity.getProperties(), activity);

		// Note: The mapping of Loops is done is visitFlowObject, as some other things have to be done first
		
		return mapping;
	}
	

	/**
	 * Maps the given Boundary Intermediate Event to various BPEL elements, depending on the events types and attributes,
	 * which are put in the scope alongside the activity's mapping.
	 * 
	 * @param intermediate	the intermediate event
	 * @param scope			the scope in which the result of the mapping of the event's activity is wrapped into
	 */
	private TActivityOrCompensateContainer visitIntermediateOnBoundary(Intermediate intermediate, TriggerType multiTrigger, TScope scope) {
		TrafoLog.trace("Visiting Boundary Intermediate Event '" + intermediate.getName() + "'");
		TActivityOrCompensateContainer mapping= null;
		
		TriggerType trigger= multiTrigger != null ? multiTrigger : intermediate.getTrigger();
		switch (trigger) {
		case MESSAGE: {
			//create onMessage + Throw + Catch
			Message message= intermediate.getMessage();
			QName faultName= new QName(message.getName() + "_Exit");
			
			TOnMessage onMessage= createOnMessage(message, intermediate.getImplementation());
			TThrow tThrow= bpelFac.createTThrow();
			tThrow.setFaultName(faultName);
			onMessage.setThrow(tThrow);
			BpelStaticHelper.getEventHandlers(scope).getOnMessage().add(onMessage);
			
			mapping= bpelFac.createTCatch();
			((TCatch)mapping).setFaultName(faultName);
			BpelStaticHelper.getFaultHandlers(scope).getCatch().add((TCatch)mapping);
			break;
		}
		case TIMER: {
			//create onAlarm + Throw + Catch
			QName faultName= new QName(intermediate.getName() + "_Exit");
			
			TOnAlarm onAlarm= bpelFac.createTOnAlarm();
			onAlarm.setFor(BpelStaticHelper.getCondition(intermediate.getTimeCycle()));
			onAlarm.setUntil(BpelStaticHelper.getCondition(intermediate.getTimeDate()));
			TThrow tThrow= bpelFac.createTThrow();
			tThrow.setFaultName(faultName);
			onAlarm.setThrow(tThrow);
			BpelStaticHelper.getEventHandlers(scope).getOnAlarm().add(onAlarm);
			
			mapping= bpelFac.createTCatch();
			((TCatch)mapping).setFaultName(faultName);
			BpelStaticHelper.getFaultHandlers(scope).getCatch().add((TCatch)mapping);
			break;
		}
		case ERROR:
			//create Catch for given error code or CatchAll
			TCatch tcatch= bpelFac.createTCatch();
			if (intermediate.getErrorCode() == null) {
				BpelStaticHelper.getFaultHandlers(scope).setCatchAll(tcatch);
			} else {
				tcatch.setFaultName(BpelStaticHelper.makeQName(intermediate.getErrorCode()));
				BpelStaticHelper.getFaultHandlers(scope).getCatch().add(tcatch);
			}
			mapping= tcatch;
			break;
		case COMPENSATION:
			//create Compensation handler
			//just create the container; will be filled by BoundaryEventCompensationRule
			mapping= bpelFac.createTCompensationHandler();
			scope.setCompensationHandler((TCompensationHandler) mapping);
			break;
		default:
			TrafoLog.warn("Unable to map " + intermediate.getTrigger() + " Boundary Event " + intermediate.getNameOrId());
		}
		if (intermediate.getTrigger() == TriggerType.MULTIPLE) {
			//iterate over child triggers. Results will be added to Event Handlers within the execution of the method
			if (intermediate.getMessage() != null && intermediate.getImplementation() != null) {
				visitIntermediateOnBoundary(intermediate, TriggerType.MESSAGE, scope);
			}
			if (intermediate.getErrorCode() != null) {
				visitIntermediateOnBoundary(intermediate, TriggerType.ERROR, scope);
			}
			if (intermediate.getActivity() != null) {
				visitIntermediateOnBoundary(intermediate, TriggerType.COMPENSATION, scope);
			}
			if (intermediate.getLinkedTo() != null) {
				visitIntermediateOnBoundary(intermediate, TriggerType.LINK, scope);
			}
			if (intermediate.getTimeCycle() != null || intermediate.getTimeDate() != null) {
				visitIntermediateOnBoundary(intermediate, TriggerType.TIMER, scope);
			}
			if (intermediate.getRuleExpression() != null && intermediate.getRuleExpression().getExpression() != null) {
				visitIntermediateOnBoundary(intermediate, TriggerType.RULE, scope);
			}
		}
		wrapper.map(intermediate, mapping);
		return mapping;
	}
	
	
	/**
	 * gateways themselves have no mapping. If they are part of a block-structure, they will determine the mapping of
	 * the block-structure. If they have assignments, the assignments will be mapped in the visitFlowObject method.
	 * 
	 * @param gateway	the gateway
	 * @return			the mapping result (in this case, null)
	 */
	private TActivity visitGateway(Gateway gateway) {
		TrafoLog.trace("Visiting Gateway '" + gateway.getName() + "'");
		TActivity mapping= null;
		/*
		 * NOTE: The Gates of the Gateway are mapped indirectly using the 
		 * GateAssignmentRule of the normalization stage, separating the Gate
		 * Assignments from the Gate, so they are treated like a normal FlowObject.
		 */
		return mapping;
	}
	
	/*
	 * //////////////////////////////////////////////////////
	 * // VISITOR METHODS FOR SPECIAL STRUCTURED BPMN OBJECTS
	 * //////////////////////////////////////////////////////
	 */
	
	/**
	 * - visit elements
	 * - put elements in sequence
	 * - if elements already are sequences, flatten sequence
	 * 
	 * @param bpmnSequence	a BPMN sequence, that has been created with the SequenceRule
	 * @return				the activity to which the BpmnSequence has been mapped (a TSequence)
	 */
	private TActivity visitBpmnSequence(BpmnSequence bpmnSequence) {
		TrafoLog.trace("Visiting BpmnSequence");
		TSequence tSequence= bpelFac.createTSequence();
		for (FlowObject flowObject : bpmnSequence.getElements()) {
			TActivity activity= visitFlowObject(flowObject);
			// nested sequences are handled in the FlattenSequenceRule now
			tSequence.addActivity(activity);
		}
		return tSequence;
	}
	
	/**
	 * - determine block type from the forking gateway and create block structure
	 * - in a loop, fill the block with it' elements
	 * 
	 * @param bpmnBlock		a BPMN block, that has been created with the BlockRule
	 * @return				the activity to which the BpmnBlock has been mapped (a TFlow, TSwitch or TPick)
	 */
	private TActivity visitBpmnBlock(BpmnBlock bpmnBlock) {
		TrafoLog.trace("Visiting BpmnBlock");
		Gateway fork= bpmnBlock.getFirstGateway();
		Gateway join= bpmnBlock.getSecondGateway();
		TActivity mapping= null;

		switch (fork.getGatewayType()) {
		
		case AND: {
			TFlow block= bpelFac.createTFlow();
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				TActivity activity= visitFlowObject(flowObject);
				block.getActivityList(activity).add(activity);
			}
			mapping= block;
			break;
		}
		case XOR_DATA: {
			//create switch
			TSwitch block= ProcessFactory.eINSTANCE.createTSwitch();
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				TActivity activity= visitFlowObject(flowObject);
				if (bpmnBlock.getDefaultElement() == flowObject) {
					// add as otherwise
					TActivityContainer otherwise= ProcessFactory.eINSTANCE.createTActivityContainer();
					otherwise.setActivity(activity);
					block.setOtherwise(otherwise);
				} else {
					//add as case
					CaseType caseType= ProcessFactory.eINSTANCE.createCaseType();
					Expression condition= branch.getCondition();
					caseType.setCondition(BpelStaticHelper.getCondition(condition));
					caseType.setActivity(activity);
					block.getCase().add(caseType);
				}
			}
			mapping= block;
			break;
		}
		case XOR_EVENT: {
			//create pick
			TPick block= ProcessFactory.eINSTANCE.createTPick();
			if (fork.isInstantiate()) {
				((TPick) block).setCreateInstance(TBoolean.YES);
			}

			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				TActivity activity= visitFlowObject(flowObject);
				
				//get event activity
				TActivity event= null;
				if (activity instanceof TSequence) {
					TSequence actAsSeq = (TSequence) activity;
					event= getFirstEventElement(actAsSeq);
					//remove event from sequence
					if (event instanceof TReceive) {
						actAsSeq.getReceive().remove(event);
					}
					if (event instanceof TWait) {
						actAsSeq.getWait().remove(event);
					}
				} else {
					//atomic activity
					event= activity;
					activity= bpelFac.createTEmpty();
				}
				
				if (event instanceof TReceive) {
					//case 1: TReceive -> TOnMessage
					TReceive receive= (TReceive) event;
					TOnMessage onMessage= ProcessFactory.eINSTANCE.createTOnMessage();
					onMessage.setVariable(receive.getVariable());
					onMessage.setPartnerLink(receive.getPartnerLink());
					onMessage.setPortType(receive.getPortType());
					onMessage.setOperation(receive.getOperation());
					onMessage.setActivity(activity);
					block.getOnMessage().add(onMessage);
				} else if (event instanceof TWait) {
					//case 2: TWait -> TOnAlarm
					TWait wait= (TWait) event;
					TOnAlarm onAlarm= ProcessFactory.eINSTANCE.createTOnAlarm();
					onAlarm.setFor(wait.getFor());
					onAlarm.setUntil(wait.getUntil());
					onAlarm.setActivity(activity);
					block.getOnAlarm().add(onAlarm);
				}
			}
			mapping= block;
			break;
		}
		case OR: {
			//create flow  
			TFlow block= ProcessFactory.eINSTANCE.createTFlow();
			TSequence sequence= null;
			boolean hasDefault= false;

			String name= fork.getName();
			if (name == null || name.isEmpty()) name= fork.getId();
			String msgName= TYPE_BOOLEAN;
			String partName= null;
			String varName= name + "_noDefaultRequired";
			
			if (bpmnBlock.getDefaultElement() != null) {
				hasDefault= true;
				//has default gate -> outer sequence and tracking variable needed
				sequence= ProcessFactory.eINSTANCE.createTSequence();
				
				//create tracking variable
				addVariable(varName, msgName, partName==null, true);
				
				//create initializing assign
				TAssign assign= createAssign(name + "_initialize_noDefault", "false()", varName, partName,null);
				sequence.getAssign().add(assign);
				sequence.getFlow().add(block);
			}

			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				TActivity activity= visitFlowObject(flowObject);
				
				if (bpmnBlock.getDefaultElement() == flowObject) {
					//default case: create a switch in the sequence and after
					TSwitch tSwitch= ProcessFactory.eINSTANCE.createTSwitch();
					
					CaseType caseType= ProcessFactory.eINSTANCE.createCaseType();
					caseType.setCondition(BpelStaticHelper.getVarData(varName, partName, null) + "=true()");
					caseType.setEmpty(ProcessFactory.eINSTANCE.createTEmpty());
					
					TActivityContainer otherwise= ProcessFactory.eINSTANCE.createTActivityContainer();
					otherwise.setActivity(activity);
					
					tSwitch.getCase().add(caseType);
					tSwitch.setOtherwise(otherwise);
					sequence.getSwitch().add(tSwitch);
				} else {
					//conditional case: create a switch for the activity in the flow
					TSwitch tSwitch= ProcessFactory.eINSTANCE.createTSwitch();
					
					if (hasDefault) {
						TSequence seqForAct= null;
						if (activity instanceof TSequence) {
							seqForAct = (TSequence) activity;
						} else {
							seqForAct= bpelFac.createTSequence();
							seqForAct.addActivity(activity);
						}
						//add an assignment to the noDefaultRequired variable at the end of the case
						TAssign assign= createAssign(name + "_set_noDefault","true()",varName,partName,null);
						seqForAct.getAssign().add(assign);
						activity= seqForAct;
					}
					
					CaseType caseType= ProcessFactory.eINSTANCE.createCaseType();
					Expression condition= branch.getCondition();
					caseType.setCondition(BpelStaticHelper.getCondition(condition));
					caseType.setActivity(activity);
					
					TActivityContainer otherwise= ProcessFactory.eINSTANCE.createTActivityContainer();
					otherwise.setEmpty(ProcessFactory.eINSTANCE.createTEmpty());
					
					tSwitch.getCase().add(caseType);
					tSwitch.setOtherwise(otherwise);
					block.getSwitch().add(tSwitch);
				}		
			}
			mapping= hasDefault ? sequence : block;
			break;
		}
		case COMPLEX: {
			// Complex Gateway: Not mapped to BPEL; Create a Flow instead.
			TrafoLog.warn("The mapping for complex gateways still is an open issue. Using Flow element");
			TFlow block= bpelFac.createTFlow();
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				TActivity activity= visitFlowObject(flowObject);
				block.getActivityList(activity).add(activity);
			}
			mapping= block;
			break;
		}
		}
		
		// Map Gateway Assignments (Gate Assignments are extracted in normalization stage)
		if (! fork.getAssignments().isEmpty() || ! join.getAssignments().isEmpty()) {
			TActivity forkAssignments= visitAssignments(fork, null);
			TActivity joinAssignments= visitAssignments(join, null);
			TSequence seq= bpelFac.createTSequence();
			if (forkAssignments != null) {
				seq.addActivity(forkAssignments);
			}
			seq.addActivity(mapping);
			if (joinAssignments != null) {
				seq.addActivity(joinAssignments);
			}
			mapping= seq;
		}
		
		return mapping;
	}
	
	/**
	 * - compose loop condition from given loopCondition and exitCondition
	 * - assemble the loop body from firstElement and/or secondElement
	 * - create the actual loop structure, holding the loop body
	 * - return the loop structure, eventually wrapped in a sequence and preceded by a copy of firstElement 
	 * 
	 * NOTE: This method does use none of the below createLoop-Methods.
	 * 
	 * @param bpmnLoopBlock	a BPMN loop block, that has been created with the LoopRule
	 * @return				the activity to which the BpmnLoopBlock has been mapped (a TSequence or TSwitch)
	 */
	private TActivity visitBpmnLoopBlock(BpmnLoopBlock bpmnLoopBlock) {
		
		TActivity activity1= visitFlowObject(bpmnLoopBlock.getFirstBranch().getElement());
		TActivity activity2= visitFlowObject(bpmnLoopBlock.getSecondBranch().getElement());

		// Assignments of the two Gateways, if any, are added before/after the do-until part
		// (Gate Assignments are extracted in normalization stage)
		if (! bpmnLoopBlock.getFirstGateway().getAssignments().isEmpty() || 
				! bpmnLoopBlock.getSecondGateway().getAssignments().isEmpty()) {
			TActivity assignments1= visitAssignments(bpmnLoopBlock.getFirstGateway(), null);
			TActivity assignments2= visitAssignments(bpmnLoopBlock.getSecondGateway(), null);
			TSequence seq= bpelFac.createTSequence();
			if (assignments1 != null) {
				seq.addActivity(assignments1);
			}
			seq.addActivity(activity1);
			if (assignments2 != null) {
				seq.addActivity(assignments2);
			}
			activity1= seq;
		}
		
		// I. COMPOSE LOOP CONDITION
		String cond= BpelStaticHelper.getCondition(bpmnLoopBlock.getSecondBranch().getCondition());
		if (cond == null || cond.isEmpty()) {
			//use negated exit condition
			cond= "not (" + BpelStaticHelper.getCondition(bpmnLoopBlock.getExitBranch().getCondition()) + ")";
		}
		
		// II. ASSEMBLE LOOP BODY
		TActivity loopBody= null;
		if (activity1 != null && activity2 != null) {
			//create sequence holding activity 2 and 1
			TSequence seq= bpelFac.createTSequence();
			seq.addActivity(activity2);
			seq.addActivity(activity1);
			loopBody= seq;
		} else {
			//use existing element
			loopBody= activity1 != null ? activity1 : activity2;
		}
		if (loopBody == null) {
			loopBody= bpelFac.createTEmpty();
		}
		
		// III. CREATE WHILE LOOP STRUCTURE
		TWhile tWhile= ProcessFactory.eINSTANCE.createTWhile();
		String name= bpmnLoopBlock.getFirstGateway().getName() + "_" + bpmnLoopBlock.getSecondGateway().getName() + "_loop";
		tWhile.setName(name);
		tWhile.setCondition(cond);
		tWhile.setActivity(loopBody);
		
		// IV. ASSEMBLE SEQUENCE HODING THE LOOP (and return it)
		if (activity1 == null) {
			// only the loop
			return tWhile;
		} else {
			// a sequence holding a copy of activity 1 and the loop
			TSequence sequence= bpelFac.createTSequence();
			sequence.addActivity((TActivity) EcoreUtil.copy(activity1));
			sequence.getWhile().add(tWhile);
			return sequence;
		}
	}
	
	/**
	 * - create a call to the derived process
	 * - if no such process exists yet, create the process
	 * 
	 * @param bpmnDerivedProcess	a BPMN derived process
	 * @return						the activity to which the process has been mapped
	 */
	private TActivity visitBpmnDerivedProcess(BpmnDerivedProcess bpmnDerivedProcess) {
		return null;
	}
	
	/**
	 * - map the contained activity
	 * - wrap it in a scope if it isn't one, yet
	 * - for each event handler case...
	 *   - map the intermediate, it's assignments and the compensation part
	 *   - if it has a skip part, create a variable and assignments accordingly 
	 * 
	 * @param bpmnEventHandlerBlock	a BPMN event handler block, that has been created in the BoundaryEventBlockRule
	 * @return						the activity to which the block has been mapped (a TScope)
	 */
	private TActivity visitBpmnEventHandlerBlock(BpmnEventHandlerBlock bpmnEventHandlerBlock) {
		//map the activity
		TActivity activity= visitFlowObject(bpmnEventHandlerBlock.getActivity());
		//get scope
		TScope scope= null;
		if (activity instanceof TScope) {
			scope = (TScope) activity;
		} else {
			scope= bpelFac.createTScope();
			scope.setActivity(activity);
		}
		//the TActivity to return (the scope or a wrapping sequence
		TActivity result= scope;
		
		for (BpmnEventHandlerCase eventHandlerCase : bpmnEventHandlerBlock.getEventHandlerCases()) {
			Intermediate intermediate= eventHandlerCase.getIntermediate();
			TActivity compAct= visitFlowObject(eventHandlerCase.getCompensationElement());
			if ( compAct==null ) {
				compAct= bpelFac.createTEmpty();
			}
			//map assignments of the intermediate event
			TActivity assignments= visitAssignments(intermediate, null);
			if (assignments instanceof TSequence) { 
				//assignments available
				((TSequence)assignments).addActivity(compAct);
				compAct= assignments;
			}
			
			//map the intermediate event
			//the resulting compensate will be put into the scope in this method
			TActivityOrCompensateContainer compensate= visitIntermediateOnBoundary(
					intermediate, 
					null,
					scope);
		
			//Create tracking variable?
			if (eventHandlerCase.getElementToSkip() != null) {
				String actName= activity.getName();
				String intName= intermediate.getNameOrId();
				String varName= actName + "_" + intName + "_normalCompletion";
				String msgName= TYPE_BOOLEAN;
				String partName= null;

				addVariable(varName, msgName, true, partName==null);
		
				//insert initializing assign before scope
				TAssign initVarAssign= createAssign(actName + "_initialize_" + varName, "true()", varName, partName, null);
				TSequence seqWithScope= bpelFac.createTSequence();
				seqWithScope.getAssign().add(initVarAssign);
				seqWithScope.getScope().add(scope);
				result= seqWithScope;
		
				//insert assign to compSeq
				TAssign setVarAssign= createAssign(actName + "_set_" + varName, "false()", varName, partName, null);
				TSequence compSeq= bpelFac.createTSequence();
				compSeq.getAssign().add(setVarAssign);
				compSeq.addActivity(compAct);
				compAct= compSeq;
				
				//set variable name. 
				//assertion: with the BEHB and the BETS in a sequence, the BEHB will always be mapped before the BETS
				String variable= "'" + varName + "'";
				eventHandlerCase.getElementToSkip().setVariableName(variable);
			}
			//insert compensation activity in compensation handler
			//has to be done after the assignment to the tracking variable has been created
			compensate.setActivity(compAct);
		}
		return result;
	}
	
	/**
	 * A BpmnElementToSkip is some flow object after an Activity with Boundary Event and before
	 * the compensation flow merges back into the normal flow. Its execution depends on an auxiliary variable. The name
	 * for the variable should be set in the visitBpmnEventHandlerBock method.
	 * 
	 * - map the embedded flow object
	 * - wrap the result in a TSwitch, using the given variable for the condition
	 * - return the TSwitch
	 * 
	 * @param bpmnElementToSkip	
	 * @return
	 */
	private TActivity visitBpmnElementToSkip(BpmnElementToSkip bpmnElementToSkip) {
		
		TActivity activity= visitFlowObject(bpmnElementToSkip.getElement());
		String varName= bpmnElementToSkip.getVariableName();
		
		//put the content of the skip sequence in a switch
		TSwitch tSwitch = ProcessFactory.eINSTANCE.createTSwitch();
		
		CaseType caseType= ProcessFactory.eINSTANCE.createCaseType();
		caseType.setCondition("bpws:getVariableData("+varName+")=true()");
		caseType.setActivity(activity);
		tSwitch.getCase().add(caseType);
		
		TActivityContainer otherwise= ProcessFactory.eINSTANCE.createTActivityContainer();
		otherwise.setEmpty(ProcessFactory.eINSTANCE.createTEmpty());
		tSwitch.setOtherwise(otherwise);
		
		return tSwitch;
	}
	
	
	/*
	 * //////////////////////////////////////
	 * ////ASSISTANT METHODS
	 * //////////////////////////////////////
	 */
	//CREATION HELPER METHODS
	
	/**
	 * create a tProcess with all primitive attributes. note that this method does not create the processes children.
	 * NOTE: using pool's name instead of process' name
	 * 
	 * @param process	a BPMN process
	 * @return			a BPEL process (basic attributes only)
	 */
	protected static TProcess createProcess(BpmnProcess process) {
		BusinessProcessSystem bps= process.getParentPool().getParentDiagram().getBusinessProcessSystem();
		TProcess tProcess= bpelFac.createTProcess();
		tProcess.setName(process.getParentPool().getName());
		tProcess.setAbstractProcess(TBoolean.get(process.getProcessType()==ProcessType.ABSTRACT));
		tProcess.setSuppressJoinFailure(TBoolean.get(process.isSuppressJoinFailure()));
		tProcess.setEnableInstanceCompensation(TBoolean.get(process.isEnableInstanceCompensation()));
		tProcess.setQueryLanguage(bps.getQueryLanguage() != null ? bps.getQueryLanguage() : NS_XPATH_URI);
//		tProcess.setExpressionLanguage(diagram.getExpressionLanguage() != null ? diagram.getExpressionLanguage() : NS_XPATH_URI);
		// always use xPath, as the expressions e.g. in a loop with max set are in xPath
		tProcess.setExpressionLanguage(NS_XPATH_URI);
		return tProcess;
	}
	
	/**
	 * Very simple creation method for a receive, just to get sure not to miss some attribute
	 * 
	 * @param name				the name
	 * @param inputVar			the input variable
	 * @param partnerLink		the partner link
	 * @param portType			the port type
	 * @param operation			the operation
	 * @param createInstance	create instance?
	 * @return					the newly created TReceive
	 */
	protected static TReceive createReceive(String name, String inputVar, String partnerLink, String portType, String operation, boolean createInstance) {
		TReceive receive= bpelFac.createTReceive();
		receive.setName(name);
		receive.setVariable(inputVar);
		receive.setPartnerLink(partnerLink);
		receive.setPortType(new QName(portType));
		receive.setOperation(operation);
		receive.setCreateInstance(TBoolean.get(createInstance));
		return receive;
	}
	

	/**
	 * Very simple creation method for a invoke, just to get sure not to miss some attribute
	 * 
	 * @param name				the name
	 * @param inputVar			the input variable
	 * @param outputvar			the output variable
	 * @param partnerLink		the partner link
	 * @param portType			the port type
	 * @param operation			the operation
	 * @return					the newly created TReceive
	 */
	protected static TInvoke createInvoke(String name, String inputVar, String outputvar, String partnerLink, String portType, String operation) {
		TInvoke invoke= bpelFac.createTInvoke();
		invoke.setName(name);
		invoke.setInputVariable(inputVar);
		invoke.setOutputVariable(outputvar);
		invoke.setPartnerLink(partnerLink);
		invoke.setPortType(new QName(portType));
		invoke.setOperation(operation);
		return invoke;
	}
	
	/**
	 * creates a new tReceive and visit the message's properties
	 * 
	 * @param inMessage			message, mapping to variable
	 * @param impl				implementation (see visitWebService)
	 * @param createInstance	create instance?
	 * @return					new tReceive
	 */
	private TReceive createReceive(Message inMessage, Implementation impl, boolean createInstance) {
		TReceive tReceive= bpelFac.createTReceive();
		if (inMessage != null) {
			tReceive.setVariable(BpelStaticHelper.getVarNameFor(inMessage));
			visitProperties(inMessage.getProperties(), inMessage);
		}
		tReceive.setCreateInstance(TBoolean.get(createInstance));
		tReceive.setPartnerLink(BpelStaticHelper.getPartnerLinkName(impl.getParticipant()));
		tReceive.setPortType(new QName(NS_THIS + ":" + impl.getInterface()));
		tReceive.setOperation(impl.getOperation());
		addPartnerLinkAndOperation(impl, inMessage, null, true, false);
		return tReceive;
	}
	
	
	/**
	 * creates a tReply and visit the message's properties
	 * 
	 * @param outMessage	message, mapping to variable
	 * @param impl			implementation (see visitWebService)
	 * @return				new tReply
	 */
	private TReply createReply(Message outMessage, Implementation impl) {
		TReply tReply= bpelFac.createTReply();
		if (outMessage != null) {
			tReply.setVariable(BpelStaticHelper.getVarNameFor(outMessage));	
			visitProperties(outMessage.getProperties(), outMessage);		
		}
		tReply.setPartnerLink(BpelStaticHelper.getPartnerLinkName(impl.getParticipant()));
		tReply.setPortType(new QName(NS_THIS + ":" + impl.getInterface()));
		tReply.setOperation(impl.getOperation());
		addPartnerLinkAndOperation(impl, null, outMessage, false, true); //TODO self or partner?
		return tReply;
	}
	
	
	/**
	 * create a new tInvoke and visit the message's properties
	 * 
	 * @param inMessage		inMessage, mapping to input variable
	 * @param outMessage	outMessage, mapping to output variable
	 * @param impl			implementation (see visitWebService)
	 * @return				new tInvoke
	 */
	private TInvoke createInvoke(Message inMessage, Message outMessage, Implementation impl) {
		TInvoke tInvoke= bpelFac.createTInvoke();
		if (inMessage != null) {
			tInvoke.setInputVariable(BpelStaticHelper.getVarNameFor(inMessage));
			visitProperties(inMessage.getProperties(), inMessage);	
		}
		if (outMessage != null) {
			tInvoke.setOutputVariable(BpelStaticHelper.getVarNameFor(outMessage));
			visitProperties(outMessage.getProperties(), outMessage);	
		}
		tInvoke.setPartnerLink(BpelStaticHelper.getPartnerLinkName(impl.getParticipant()));
		tInvoke.setPortType(new QName(NS_THIS + ":" + impl.getInterface()));
		tInvoke.setOperation(impl.getOperation());
		addPartnerLinkAndOperation(impl, inMessage, outMessage, false, true);
		return tInvoke;
	}
	
	
	/**
	 * creates a new tOnMessage and visit the message's properties
	 * 
	 * @param inMessage			message, mapping to variable
	 * @param impl				implementation (see visitWebService)
	 * @param process			process (for the WSDL definition)
	 * @return					new tReceive
	 */
	private TOnMessage createOnMessage(Message inMessage, Implementation impl) {
		TOnMessage tOnMessage= bpelFac.createTOnMessage();
		if (inMessage != null) {
			tOnMessage.setVariable(BpelStaticHelper.getVarNameFor(inMessage));
			visitProperties(inMessage.getProperties(), inMessage);
		}
		tOnMessage.setPartnerLink(BpelStaticHelper.getPartnerLinkName(impl.getParticipant()));
		tOnMessage.setPortType(new QName(NS_THIS + ":" + impl.getInterface()));
		tOnMessage.setOperation(impl.getOperation());
		addPartnerLinkAndOperation(impl, inMessage, null, true, false);
		return tOnMessage;
	}
	
	/*
	 * //////////////////////////////////////////////
	 * /// ASIGNMENTS AND VARIABLES AND MESSAGES
	 * //////////////////////////////////////////////
	 */
	
	/**
	 * create a assign to copy a value from a expression to a variable part
	 * @param name				name for the assign
	 * @param fromExpression	expression to assign
	 * @param toVariable		variable to assign expression to
	 * @param toPart			variable part
	 * @param query				to-Query
	 * @return					the newly created tAssign
	 */
	protected static TAssign createAssign(String name, String fromExpression, String toVariable, String toPart, String query) {
		TAssign assign= bpelFac.createTAssign();
		assign.setName(name);
		TCopy copy= bpelFac.createTCopy();
		TFrom from= bpelFac.createTFrom();
		from.setExpression(fromExpression);
		copy.setFrom(from);
		ToType to= bpelFac.createToType();
		to.setVariable(toVariable);
		to.setPart(toPart);
		to.setQuery(query);
		copy.setTo(to);
		assign.getCopy().add(copy);
		return assign;
	}
	
	/**
	 * creates a new assign expression, then iterates the given list of assignments and adds a copy to the assign 
	 * for each assignment with the given assign time type.
	 * This method does not use the createAssign()-Method, since that method would create one assign per assignment,
	 * while this method creates only one copy per assignment and one assign for the whole list.
	 *  
	 * @param assignments	list with all the BPMN assignments	
	 * @param assignTime	include assignments with this assignTime (if null, include all)
	 * @return				the assignment, or null if the assignTime doesn't matter
	 * 
	 */
	private TAssign createAssignFromList(List<Assignment> assignments, AssignTimeType assignTime) {
		TAssign tAssign= bpelFac.createTAssign();
		for (Iterator<Assignment> iter = assignments.iterator(); iter.hasNext();) {
			Assignment assignment= iter.next();
			if (assignTime == null || assignment.getAssignTime() == assignTime) {
				TCopy tCopy= bpelFac.createTCopy();
				TFrom tFrom= bpelFac.createTFrom();
				tFrom.setExpression(assignment.getFrom().getExpression());
				tCopy.setFrom(tFrom);
				
				ToType toType= bpelFac.createToType();
				Property to= assignment.getTo();
				toType.setPart(to.getName());
				toType.setVariable(BpelStaticHelper.getVarNameFor(to.eContainer()));
				toType.setQuery(assignment.getToQuery());
				tCopy.setTo(toType);
				tAssign.getCopy().add(tCopy);
			}
		}
		return tAssign.getCopy().isEmpty() ? null : tAssign;
	}
	
	
	/**
	 * map some BPMN element's properties set. for the whole set of properties one variable and one message
	 * is created. the message is made up of the several properties (as parts) and the variable is of the
	 * message's type
	 * 
	 * @param properties	list of BPMN properties
	 * @param owner			owner of the properties (influencing the resulting variable names)
	 */
	private void visitProperties(List<Property> properties, EObject owner) {
		final boolean noDuplicates= true;
		//always create variable for a message, even when empty (because it will be used in the invoke/receive)
		if (! properties.isEmpty() || owner instanceof Message) {
			//get the original element's process and derive names
			String varName= BpelStaticHelper.getVarNameFor(owner);
			String msgName= BpelStaticHelper.getMessageName(varName);
			//get process and WSDL definitions from process
			
			//create variable and insert into tProcess
			addVariable(varName, msgName, noDuplicates, false);
			
			//if the message already exists, quit
			//this can be the case if a message has been referenced by multiple tasks
			for (TMessage msg : _current.definitions.getMessage()) {
				if (msg.getName().equals(msgName)) {
					return;
				}
			}
			
			//create message and insert into tDefinition
			TMessage tMsg= wsdlFac.createTMessage();
			tMsg.setName(msgName);
			for (Property property : properties) {
				TPart tPart= wsdlFac.createTPart();
				tPart.setName(property.getName());
				tPart.setType(new QName(property.getType()));
				
				if (property.isCorrelation()) {
					/*
					 * TODO correlation sets?
					 * property with type==Set -> correlationSet
					 * child-property(?) of set -> entry in 'properties' QName-list
					 */
					TrafoLog.nyi("Mapping for Correlation Sets attribute");	
				}
				tMsg.getPart().add(tPart);
			}
			_current.definitions.getMessage().add(tMsg);
		}
	}

	
	/**
	 * creates a new variable, adds it to the processes variables and returns it
	 * if a variable with the same name already exists the variable is not created
	 * instead the existing variable is returned
	 * 
	 * @param process	tProcess (containing the new variable)
	 * @param name		variable name
	 * @param message	variable message
	 * @param noDuplicate	do not create variable, if variable with same name already exists
	 * @param simple	is simple variable (like integer or string), using element instead of type
	 * @return			the variable
	 */
	private TVariable addVariable(String name, String message, boolean noDuplicate, boolean simple) {
		if (_current.process.getVariables()==null) {
			_current.process.setVariables(bpelFac.createTVariables());
		}
		if (noDuplicate) {
			for (TVariable variable : _current.process.getVariables().getVariable()) {
				if (variable.getName().equals(name)) {
					return variable;
				}
			}
		}
		TVariable tVar= bpelFac.createTVariable();
		tVar.setName(name);
		if (simple) {
			tVar.setType(new QName(message));
		} else {
			tVar.setMessageType(new QName(NS_THIS + ":" + message));
		}
		_current.process.getVariables().getVariable().add(tVar);
		return tVar;
	}
	
	/*
	 * //////////////////////////////////////////////////////////////////////////////////////
	 * /// WEB SERVICE STUFF: PARTNER LINKS, PARTNER LINK TYPES, PORT TYPES, OPERATIONS, etc.
	 * /////////////////////////////////////////////////////////////////////////////////////
	 */
	
	/**
	 * abbreviation to be used in the various create onMessage / invoke / receive / reply methods
	 * 
	 * @param process		the BPMN process for which the PL, PLT, PT and OP shall be created. Used to access BPEL process and WSDL definition
	 * @param webservice	the BPMN web service, providing names for port type and operation and access to the participant (for the partner link)
	 * @param inMessage		the in message (or null)
	 * @param outMessage	the out message (or null)
	 * @param isSelf		set myRole?
	 * @param isPartner		set partnerRole?
	 */
	private void addPartnerLinkAndOperation(Implementation webservice, Message inMessage, Message outMessage, boolean isSelf, boolean isPartner) {
		addPartnerLink(webservice, isSelf, isPartner);
		addOperation(webservice, inMessage, outMessage);
	}
	

	/**
	 * Creates a partnerLink from the given participant.
	 * The partnerLink is then inserted into the given process' mapping
	 * 
	 * @param webservice	a BPMN webService, referencing the participant and holding the operation's name
	 * @param isSelf		set myRole?
	 * @param isPartner		set partnerRole?
	 */
	private void addPartnerLink(Implementation webservice, boolean isSelf, boolean isPartner) {
		if (webservice==null || webservice.getParticipant()==null) {
			return;
		}
		final Participant participant= webservice.getParticipant();
		final String plName= BpelStaticHelper.getPartnerLinkName(participant);
		final QName pltName= new QName(plName + "_PLT");
		final String roleNameSelf= plName + "_myRole";
		final String roleNamePartner= plName + "_partnerRole";
		final String ptName= webservice.getInterface();
		
		//get or create partner link
		TPartnerLink partnerLink= null;
		if (_current.process.getPartnerLinks() == null) {
			_current.process.setPartnerLinks(bpelFac.createTPartnerLinks());
		}
		for (TPartnerLink pl : _current.process.getPartnerLinks().getPartnerLink()) {
			if (pl.getName().equals(plName)) {
				//use existing 
				partnerLink= pl;
				break;
			}
		}
		if (partnerLink == null) {
			//create new partner link
			partnerLink= bpelFac.createTPartnerLink();
			partnerLink.setName(plName);
			partnerLink.setPartnerLinkType(new QName(NS_THIS + ":" + pltName.getLocalPart()));
			_current.process.getPartnerLinks().getPartnerLink().add(partnerLink);
		}
		//set partner link's roles
		if (isSelf) {
			partnerLink.setMyRole(roleNameSelf);
		}
		if (isPartner) {
			partnerLink.setPartnerRole(roleNamePartner);
		}
		
		// create or extend partner link types
		if (_current.definitions != null) {	
			//add partner link type to WSDL definitions
			AnyType plt= null;
			for (int i=0; i<_current.definitions.getAny().size(); i++) {
				AnyType value= (AnyType) _current.definitions.getAny().getValue(i);
				for (int j = 0; j < value.getAnyAttribute().size(); j++) {
					EStructuralFeature feature= value.getAnyAttribute().getEStructuralFeature(j);
					if ("name".equals(feature.getName()) && pltName.equals(value.getAnyAttribute().getValue(j))) {
						plt= value;
					}
				}
				System.out.println(value);
			}
			if (plt == null) {
				plt= xmlFac.createAnyType();
				plt.eSet(emd.demandFeature(null, "name", false),pltName);
				_current.definitions.getAny().add(emd.demandFeature(NS_PLNK_URI, "partnerLinkType", true),plt);
			}
			
			List<String> roleNames= new ArrayList<String>();
			if (isSelf) roleNames.add(roleNameSelf);
			if (isPartner) roleNames.add(roleNamePartner);
			
			for (String roleName : roleNames) {
				boolean roleExists= false;
				for (int i=0; i<plt.getAny().size(); i++) {
					AnyType value= (AnyType) plt.getAny().getValue(i);
					for (int j = 0; j < value.getAnyAttribute().size(); j++) {
						EStructuralFeature feature= value.getAnyAttribute().getEStructuralFeature(j);
						if ("name".equals(feature.getName()) && roleName.equals(value.getAnyAttribute().getValue(j))) {
							roleExists= true; // role already defined
						}
					}
				}
				if (! roleExists) {
					AnyType role= xmlFac.createAnyType();
					role.eSet(emd.demandFeature(null, "name", false),roleName);
					role.eSet(emd.demandFeature(null, "portType", false),NS_TNS + ":" + ptName);
					FeatureMapUtil.addText(plt.getMixed(),"\n    ");
					plt.getAny().add(emd.demandFeature(NS_PLNK_URI, "role", true),role);
					FeatureMapUtil.addText(plt.getMixed(),"\n  ");
				}
			}
		}
		
	}
	
	
	/**
	 * Use the given web service to create and add an operation to the given definitions object. If no port type for
	 * the web service interface exists yet, a port type is also created.
	 * 
	 * @param webservice	the webService describing the port type and operation
	 * @param inMessage		incoming message for the operation (can be of type Message, Activity or Process)
	 * @param outMessage	outgoing message for the operation (can be of type Message, Activity or Process)
	 * @return				the newly created TOperation
	 */
	private TOperation addOperation(Implementation webservice, EObject inMessage, EObject outMessage) {
		if (webservice==null) {
			return null;
		}
		final String ptName= webservice.getInterface();
		final String opName= webservice.getOperation();
		
		//get or create port type
		TPortType portType= null;
		for (TPortType pt : _current.definitions.getPortType()) {
			if (pt.getName().equals(ptName)) {
				portType= pt;
				break;
			}
		}
		if (portType == null) {
			portType= wsdlFac.createTPortType();
			portType.setName(ptName);
			//TODO insert comment here, holding the WSDL-URL
			_current.definitions.getPortType().add(portType);
		}
		
		//get or create operation
		TOperation operation= null;
		for (TOperation op : portType.getOperation()) {
			if (op.getName().equals(opName)) {
				operation= op;
				break;
			}
		}
		if (operation == null) {
			operation= wsdlFac.createTOperation();
			operation.setName(opName);
			portType.getOperation().add(operation);
		}
		
		//create input/output messages
		if (operation.getInput() == null && inMessage != null) {
			TParam param= wsdlFac.createTParam();
			param.setMessage(new QName(NS_TNS + ":" + BpelStaticHelper.getMessageName(BpelStaticHelper.getVarNameFor(inMessage))));
			operation.setInput(param);
		}
		if (operation.getOutput() == null && outMessage != null) {
			TParam param= wsdlFac.createTParam();
			param.setMessage(new QName(NS_TNS + ":" + BpelStaticHelper.getMessageName(BpelStaticHelper.getVarNameFor(outMessage))));
			operation.setOutput(param);
		}
		return operation;
	}
	
	/*
	 * ////////////////////////////////////////////
	 * // LOOPING STUFF
	 * ////////////////////////////////////////////
	 * 
	 * The below methods are used by the activity loop mapping only, and not for loops
	 * that were created with upstream connections.
	 */
	
	/**
	 * In the Standard Loop Mapping the Activity being result to the mapping is wrapped in a sequence,
	 * in which a loop counter variable is defined and initialized.
	 * Then, in a tWhile, the condition is checked, the activity gets executed and the counter is incremented.
	 * 
	 * @param activity		the original activity holding the loop attributes
	 * @param tActivity		the activity's mapping to be embedded in the loop
	 * @return				sequence with loop
	 */
	private TActivity createStandardLoop(Activity activity, TActivity tActivity) {
		StandardLoopAttSet attSet= (StandardLoopAttSet) activity.getLoopAttributes();
		TSequence loop= createLoopSequence(
				activity, 
				tActivity, 
				attSet.getLoopCondition() != null? attSet.getLoopCondition().getExpression() : null, 
				attSet.getLoopMaximum(), 
				attSet.isTestBefore()); 
		return loop;
	}
	
	/**
	 * This method will create the complex Activity being result of the mapping of a multi instance loop.
	 * If the ordering type is SEQUENTIAL, this methods does mostly the same as createStandardLoop.
	 * If the ordering type is PARALLEL, the procedure is much more complex, including the creation of a 
	 * spawned process, invoking and joining the instances of this process in loops, and the creation of partner
	 * links, port types and stuff for calling the process.
	 *  
	 * @param activity		the original activity holding the loop attributes
	 * @param tActivity		the activity's mapping to be embedded in the loop
	 * @return				sequence with MI loop
	 */
	private TActivity createMultiInstanceLoop(Activity activity, TActivity tActivity) {
		MultiLoopAttSet attSet= (MultiLoopAttSet) activity.getLoopAttributes();
		String actName= activity.getName();
		BpmnProcess process= activity.getProcess();
		String procVarName= process.getProperties().isEmpty() ? null : BpelStaticHelper.getVarNameFor(process);
		String plInternal= BpelStaticHelper.getPartnerLinkName(activity.getPool().getParticipant());
		String ptSpawnedProcess= NS_THIS + ":" + actName + "_SpawnedProcessPT";
		String spawnOperation= "spawnProcess";
		String joinOperation= "joinProcess";

		/*
		 * This part is similar for Sequential and Parallel MI Loops, only with the difference,
		 * that in case of the sequential loop the activity itself is looped while in case of the
		 * parallel loop a call to a spawned process is looped over.
		 */
		// the activity that is contained in the loop
		TActivity loopBodyActivity= tActivity;
		// the sequence holding the whole of the loop
		TSequence overallSequence= bpelFac.createTSequence();
		// parallel ordering
		if (! attSet.isSequential()) {
			TrafoLog.warn("The Mapping of a Multi Instance Parallel Loop is at a rather early stage. Please check the result.");
			// if the MI-Loop is parallel, the first loop will hold  a one-way invoke to a spawned process holding the activity
			loopBodyActivity= createInvoke("Spawn_Process_For_" + actName, procVarName, null, plInternal, ptSpawnedProcess, spawnOperation);
		}
		// build temporary variables' names
		String varNameLC= actName + "_loopCounter";
		String partNameLC= null;
		String varNameFE= actName + "_forEachCounter";
		String partNameFE= null;
		String msgNameFE= TYPE_INTEGER;
		// create and add the forEach variable
		addVariable(varNameFE, msgNameFE, true, partNameFE==null);
		// assign the initial value held in the MI-Condition to the forEach-variable
		TAssign determineIntance= createAssign(actName+"_determine_instances", attSet.getMI_Condition().getExpression(), varNameFE, partNameFE, null);
		overallSequence.getAssign().add(determineIntance);
		String forEachCondition = BpelStaticHelper.getVarData(varNameLC, partNameLC, null) + " <= " + BpelStaticHelper.getVarData(varNameFE, partNameFE, null);
		// similar to standard loop: create a loop sequence
		TSequence loopSeq= createLoopSequence(
				activity, 
				loopBodyActivity, 
				forEachCondition,
				-1, 
				true);
		overallSequence.getSequence().add(loopSeq);
		
		// parallel ordering
		if (! attSet.isSequential()) {
			/*
			 * For parallel ordering a new process has to be spawned for each iteration.
			 * This process will (1) receive its instantiation message, (2) execute the original
			 * activity, and (3) send a response to the main process.
			 */
			//create new process, using the original process's WSDL definitions
			TProcess derivedProcess= bpelFac.createTProcess();
			derivedProcess.setName("Spawned_Process_For_" + actName);
			derivedProcess.setAbstractProcess(TBoolean.NO);
			derivedProcess.setQueryLanguage(_current.process.getQueryLanguage());
			derivedProcess.setExpressionLanguage(_current.process.getExpressionLanguage());
			derivedProcess.setEnableInstanceCompensation(_current.process.getEnableInstanceCompensation());
			derivedProcess.setSuppressJoinFailure(_current.process.getSuppressJoinFailure());
			//create sequence holding the receive, the loop body and the invoke
			TSequence sequence= bpelFac.createTSequence();
			sequence.getReceive().add(createReceive("Spawn_Process_For_" + actName, procVarName, plInternal, ptSpawnedProcess, spawnOperation, true));
			sequence.addActivity(tActivity);
			sequence.getInvoke().add(createInvoke(actName + "_Completed", procVarName, null, plInternal, ptSpawnedProcess, joinOperation));
			derivedProcess.setSequence(sequence);

			// adding the variable is a bit tricky: create and switch to new process set first
			BpelProcessSet mainProcessSet= _current;
			_current= new BpelProcessSet(derivedProcess, mainProcessSet.definitions);
			addProcess(_current);
			wrapper.getTargetModels().add(_current);
			// create variable holding the original processes properties (now operating on the new process)
			if (! process.getProperties().isEmpty()) {
				addVariable(procVarName, BpelStaticHelper.getMessageName(procVarName), false, false);
			}
			// switch back to the original process set
			_current= mainProcessSet;

			/*
			 * Join the spawned instances. Depending on the FlowCondition, none, one, all or 
			 * some other number of instances are joined using a receive.
			 */
			//create receive for returning to the original process
			TReceive joinReceive= createReceive(actName + "_Completed", procVarName, plInternal, ptSpawnedProcess, joinOperation, false);
			switch (attSet.getMI_FlowCondition().getValue()) {
				case FlowConditionTypes.ALL_VALUE:
				case FlowConditionTypes.COMPLEX_VALUE: {
					//create a second loop, receiving n messages from all the spawned processes
					//or create a second loop, receiving messages until the complex flow condition makes it stop
					boolean isComplex = attSet.getMI_FlowCondition() == FlowConditionTypes.COMPLEX;
					TSequence joinLoopSeq= createLoopSequence(
							activity, 
							joinReceive, 
							isComplex ? attSet.getComplexMI_FlowCondition().getExpression() : forEachCondition, 
							-1, 
							true);
					overallSequence.getSequence().add(joinLoopSeq);
					break;
				}
				case FlowConditionTypes.ONE_VALUE: {
					//receive only one message from one of the spawned processes, then continue
					overallSequence.getReceive().add(joinReceive);
					break;
				}
				case FlowConditionTypes.NONE_VALUE: {
					//no synchronization, just continue after the spawning loop
					break;
				}
			}
			
			/*
			 * Create PartnerLinks, PartnerLinkType, PortType and Operation
			 */
			// using pseudo web service as wrapper
			Implementation webservice= VsdtFactory.eINSTANCE.createImplementation();
			webservice.setInterface(ptSpawnedProcess);
			webservice.setOperation(spawnOperation);
			addOperation(webservice, process.getProperties().isEmpty()? null : process, null);
			webservice.setOperation(joinOperation);
			addOperation(webservice, process.getProperties().isEmpty()? null : process, null);
			
			webservice.setParticipant(activity.getPool().getParticipant());
			addPartnerLink(webservice, true, true);
		}
		return overallSequence;
	}
	

	/**
	 * Create and return a loop based on a given FlowObject with LoopType==Standard or MultiInstance with sequential ordering
	 * This method will also create the assignments initializing the loop variable(s).
	 * 
	 * @param flowObject	the source object
	 * @param tActivity		the target object
	 * @param conditon		the condition expression
	 * @param maximum		the loop maximum (in case of Standard Loop)
	 * @param testBefore	the test time, depending on which the condition will be extended
	 * @return				a TSequence holding initializing TAssigns followed by a TWhile for the loop (using createLoop)
	 */
	private TSequence createLoopSequence(FlowObject activity, TActivity tActivity, String condition, int maximum, boolean testBefore) {
		String actName= activity.getName();
		String varName= actName + "_loopCounter";
		String partName= null;
		
		//create assigns for initialization and increment of loop counter
		TAssign initLoopCounter= createAssign(actName+"_initialize_loopCounter", "0", varName, partName ,null);
		
		TWhile loopBody= createLoopWhileElement(activity, tActivity, condition, maximum, testBefore);
		
		//this sequence is the whole loop structure, including variable initialization
		TSequence loop= bpelFac.createTSequence();
		loop.getAssign().add(initLoopCounter);
		loop.getWhile().add(loopBody);
		return loop;
	}
	
	
	/**
	 * Create and return a loop based on a given FlowObject with LoopType==Standard or MultiInstance with sequential ordering
	 * Note: This method creates ONLY the TWhile without any initialization of loop variables. For this purpose, please use
	 * createLoopSeq instead
	 * 
	 * @param flowObject	the source object
	 * @param tActivity		the target object
	 * @param condition		the condition expression
	 * @param maximum		the loop maximum (in case of Standard Loop)
	 * @param testBefore	the test time, depending on which the condition will be extended
	 */
	private TWhile createLoopWhileElement(FlowObject activity, TActivity tActivity, String condition, int maximum, boolean testBefore) {
		String actName= activity.getName();
		String varNameLC= actName + "_loopCounter";
		String partNameLC= null;
		String msgNameLC= TYPE_INTEGER;
		String lcBpelGetter= BpelStaticHelper.getVarData(varNameLC, partNameLC, null);
		String lcIncrement= lcBpelGetter + " + 1";
		
		//create a variable for the loop counter
		addVariable(varNameLC, msgNameLC, true, partNameLC==null); 
		
		TAssign incrementLoopCounter= createAssign(actName+"_increment_loopCounter", lcIncrement, varNameLC, partNameLC, null);
		
		//loop body and loop condition
		String cond= condition;

		//append additional condition for loop maximum
		if (maximum > 0) {
			String cond2= lcBpelGetter + " <= " + maximum;
			cond= cond != null && cond.length()>0 ? "("+ cond +") and (" + cond2 + ")" : cond2;
		}
		//for testTime=after: instead of inserting a copy of the tActivity here, which could be quite long, an additional test is appended
		if (! testBefore) {
			String cond2= lcBpelGetter + " <= 0";
			cond= cond != null && cond.length()>0 ? "("+ cond +") or (" + cond2 + ")" : cond2;
		}
		
		//create inner sequence, holding the mapped activity and the loopCounter increment
		TSequence innerSeq= bpelFac.createTSequence();
		innerSeq.addActivity(tActivity);
		innerSeq.getAssign().add(incrementLoopCounter);
		
		//create and return the loop's while element, holding the sequence and the condition
		TWhile loopBody= bpelFac.createTWhile();
		loopBody.setCondition(cond);
		loopBody.setSequence(innerSeq);
		return loopBody;
	}

	/*
	 * ////////////////////////////////////////////
	 * // OTHER HELPER METHODS
	 * ////////////////////////////////////////////
	 */
	
	/**
	 * Checks if there is an upstream tReceive activity with the same portType and operation.
	 * Used to decide whether to use a reply or an invoke in some mappings.
	 * 
	 * @param flowObject	the flowObject to be mapped
	 * @param porttype		the portType
	 * @param operation		the operation
	 * @return				exist upstream receive with same portType and operation?
	 */
	private boolean existsUpstreamReceive(FlowObject flowObject, String porttype, String operation) {
		/*
		 * fact: all upstream flow objects have already been mapped
		 * -> search mapping table for receive with given portType and operation
		 * TODO problem: could be in a concurrent flow of control
		 * This method could need some refinement, but with low priority.
		 * Idea: Search backwards through the containers, look up the mappings in the mapping table.
		 */
		for (Object key : wrapper.getMappedElements().keySet()) {
			if (key instanceof FlowObject) {
				FlowObject fo= (FlowObject) key;
				if (fo.getPool() == flowObject.getPool()) {
					Object value= wrapper.getMapping(key);
					TReceive receive= null;
					if (value instanceof TReceive) {
						receive = (TReceive) value;
					}
					if (value instanceof TSequence) {
						TSequence seq = (TSequence) value;
						if (! seq.getReceive().isEmpty()) {
							receive= seq.getReceive().get(0);
						}
					}
					if (receive != null) {
						String porttype2= NS_THIS + ":" + porttype; // FIXME quick fix, improve later
						if (receive.getPortType() != null && receive.getOperation() != null
								&& receive.getPortType().getLocalPart().equals(porttype2) && receive.getOperation().equals(operation)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Return the first non-Assign element of a (nested) sequence. This method is adequate
	 * for determining the 'event' behind an event-based xor-gateway. Such a gateway can not
	 * be followed by a loop or block, as a gateway would not be allowed as a consecutive element.
	 * 
	 * @param sequence	Some Sequence
	 * @return			First element that is not an assign
	 */
	private TActivity getFirstEventElement(TSequence sequence) {
		int index= 0;
		while (sequence.getActivity().size() > index && 
				(sequence.getActivity().getValue(index) instanceof TAssign ||
				sequence.getActivity().getValue(index) instanceof TEmpty )) {
			index++;
		}
		TActivity activity= null;
		if (sequence.getActivity().size() > index) {
			activity= (TActivity) sequence.getActivity().getValue(index);
			if (activity instanceof TSequence) {
				return getFirstEventElement((TSequence) activity);
			}
		}
		return activity;
	}
	
	/*
	 * ////////////////////////////////////////////////////
	 * // Structure Maximisation (Flows and Links)
	 * ////////////////////////////////////////////////////
	 */

	/** This map is holding an association of Sequence Flows to Links */
	private Map<SequenceFlow, TLink> linkMap= new HashMap<SequenceFlow, TLink>();
	
	/** running number to be appended to link name */
	private int linkNr= 0;

	/**
	 * Add Links to the given activity, if the original Flow Object still has any 
	 * incoming or outgoing Sequence Flows.
	 * 
	 * @param activity		Some already mapped activity
	 * @param flow			TFlow to contain the links
	 * @param original		Original Flow Object
	 */
	private void addLinks(TActivity activity, TFlow flow, FlowObject original) {
		if (activity != null && original != null) {
			for (SequenceFlow seqFlow : original.getOutgoingSeq()) {
				TLink link= getLink(seqFlow, activity, flow);
				TSource source= bpelFac.createTSource();
				source.setLinkName(link.getName());
				String condition= BpelStaticHelper.getCondition(seqFlow.getConditionExpression());
				if (condition != null) {
					source.setTransitionCondition(condition);
				}
				activity.getSource().add(source);
			}
			for (SequenceFlow seqFlow : original.getIncomingSeq()) {
				TLink link= getLink(seqFlow, activity, flow);
				TTarget target= bpelFac.createTTarget();
				target.setLinkName(link.getName());
				activity.getTarget().add(target);
			}
		}
	}
	
	/**
	 * Create, if necessary, a Link for the given SequenceFlow and return it.
	 * The Link is put in the LinkMap together with the original Sequence Flow,
	 * and is inserted into the Link-Set of the given Flow object.
	 * 
	 * @param seqFlow		Some Sequence Flow to get or create a Link for.
	 * @param activity		One of the Activities the Link will link.
	 * @param flow			Flow object to contain the link
	 * @return				The link, newly created or retrieved from the map.
	 */
	private TLink getLink(SequenceFlow seqFlow, TActivity activity, TFlow flow) {
		TLink link= linkMap.get(seqFlow);
		if (link == null) {
			// create new Link for this Sequence Flow
			link= bpelFac.createTLink();
			link.setName(seqFlow.getName() + "_" + linkNr++);
			linkMap.put(seqFlow, link);
			if (flow != null) {
				if (flow.getLinks() == null) {
					flow.setLinks(bpelFac.createTLinks());
				}
				flow.getLinks().getLink().add(link);
			}
		}
		return link;
	}
	
}
