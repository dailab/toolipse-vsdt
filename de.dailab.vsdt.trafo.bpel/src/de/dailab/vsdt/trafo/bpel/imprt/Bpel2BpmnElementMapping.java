package de.dailab.vsdt.trafo.bpel.imprt;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.xmlsoap.schemas.ws._2003._03.business.process.CaseType;
import org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot;
import org.xmlsoap.schemas.ws._2003._03.business.process.EventHandlerHolder;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TAssign;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCatch;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCopy;
import org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFlow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TFrom;
import org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke;
import org.xmlsoap.schemas.ws._2003._03.business.process.TLink;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPick;
import org.xmlsoap.schemas.ws._2003._03.business.process.TProcess;
import org.xmlsoap.schemas.ws._2003._03.business.process.TReceive;
import org.xmlsoap.schemas.ws._2003._03.business.process.TReply;
import org.xmlsoap.schemas.ws._2003._03.business.process.TScope;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSequence;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSource;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch;
import org.xmlsoap.schemas.ws._2003._03.business.process.TTarget;
import org.xmlsoap.schemas.ws._2003._03.business.process.TTerminate;
import org.xmlsoap.schemas.ws._2003._03.business.process.TThrow;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWait;
import org.xmlsoap.schemas.ws._2003._03.business.process.TWhile;
import org.xmlsoap.schemas.ws._2003._03.business.process.ToType;
import org.xmlsoap.schemas.ws._2003._03.business.process.util.BpelUtil;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.End;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.ProcessType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.bpel.wizard.BpelImportWizardOptionsPage;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.util.StrucBpmnElementFactory;
import de.dailab.vsdt.util.VsdtElementFactory;

/**
 * 
 * @author kuester
 */
public class Bpel2BpmnElementMapping extends MappingStage {

	/*
	 * TODO
	 * - create start and end events if the element is the first/last one in the process
	 * - what about variables, message types, partner links, etc.?
	 * - create other pools and message flows
	 * - map supporting types first, so the results can be looked up in a map
	 * - optionally create other pools and message flows
	 */
	
	public static final VsdtFactory vsdtFac= VsdtFactory.eINSTANCE;
	public static final StrucBpmnFactory strucFac= StrucBpmnFactory.eINSTANCE;
	
	private boolean ignoreEmpty= BpelImportWizardOptionsPage.DEFAULT_IGNORE_EMPTY;
	
	/** the source model */
	private DocumentRoot documentRoot;

	/** the process system */
	private BusinessProcessSystem bps;
	
	/** the working model */
	private BusinessProcessDiagram bpd;
	
	/** the process (each BPEL model will map to only one process)*/
	private Pool _process;
	
	public void setIgnoreEmpty(boolean ignoreEmpty) {
		this.ignoreEmpty = ignoreEmpty;
	}
	
	@Override
	public void initialize() {
		documentRoot= null;
		bps= null;
		_process= null;
	}
	
	@Override
	protected boolean internalApply() {
		this.documentRoot= (DocumentRoot) getWrapper().getSourceModel();
		this.bps= vsdtFac.createBusinessProcessSystem();
		this.bpd= vsdtFac.createBusinessProcessDiagram();
		bps.getBusinessProcesses().add(bpd);
		wrapper.getTargetModels().add(bps);
		
		TProcess process= documentRoot.getProcess();
		bps.setQueryLanguage(process.getQueryLanguage());
		bps.setExpressionLanguage(process.getExpressionLanguage());
		bps.setAuthor("Generated from BPEL file");
		try {
			if (visitProcess(process, bpd)) {
				return true;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * VISITOR LOGIC
	 */

	protected boolean visitProcess(TProcess tProcess, BusinessProcessDiagram bpd) {
		TrafoLog.trace("Visiting Process " + tProcess.toString());
		// set remaining BPD attributes
		bpd.setName(tProcess.getName());
		
		TrafoLog.nyi("Mapping of Supporting Elements (Variables, Partner Links, ...)");
		// TODO Variables: Name, Type, Message Type, Element
		// TODO Partners: Name, PartnerLink
		// TODO PartnerLinks: Name, Type, MyRole, PartnerRole
		
		// create pool
		Pool pool= vsdtFac.createPool();
		pool.setName(tProcess.getName());
		pool.setParent(bpd);
		
		// create process
		_process = pool;
		_process.setProcessType( tProcess.isSetAbstractProcess() ? ProcessType.PUBLIC : ProcessType.PRIVATE);
//		_process.setEnableInstanceCompensation(tProcess.isSetEnableInstanceCompensation());
//		_process.setSuppressJoinFailure(tProcess.isSetSuppressJoinFailure());
		
		// create Lane
		Lane lane= vsdtFac.createLane();
		lane.setParent(pool);
		
		// map process contents
		FlowObject flowObject= visitActivity(BpelUtil.getActivity(tProcess));
		if (flowObject != null) {
			// mapping of event handlers
			BpmnEventHandlerBlock block= visitEventHandlers(tProcess);
			if (block.getEventHandlerCases().isEmpty()) {
				// put original results into lane
				lane.getContainedFlowObjects().add(flowObject);
			} else {
				// wrap results into subprocess and event handler block
				Activity subprocess= VsdtElementFactory.createActivity("Process with Event Handlers", ActivityType.EMBEDDED);
				subprocess.getContainedFlowObjects().add(flowObject);
				block.setActivity(subprocess);
				lane.getContainedFlowObjects().add(block);
			}
		}
		
		return true;
	}
	
	protected FlowObject visitActivity(TActivity tActivity) {
		FlowObject mapping= null;
		
		// delegate...
		if (tActivity instanceof TAssign) {
			mapping= visitAssign((TAssign) tActivity);
		}
		if (tActivity instanceof TEmpty) {
			mapping= visitEmpty((TEmpty) tActivity);
		}
		if (tActivity instanceof TFlow) {
			mapping= visitFlow((TFlow) tActivity);
		}
		if (tActivity instanceof TInvoke) {
			mapping= visitInvoke((TInvoke) tActivity);
		}
		if (tActivity instanceof TPick) {
			mapping= visitPick((TPick) tActivity);
		}
		if (tActivity instanceof TReceive) {
			mapping= visitReceive((TReceive) tActivity);
		}
		if (tActivity instanceof TReply) {
			mapping= visitReply((TReply) tActivity);
		}
		if (tActivity instanceof TScope) {
			mapping= visitScope((TScope) tActivity);
		}
		if (tActivity instanceof TSequence) {
			mapping= visitSequence((TSequence) tActivity);
		}
		if (tActivity instanceof TSwitch) {
			mapping= visitSwitch((TSwitch) tActivity);
		}
		if (tActivity instanceof TTerminate) {
			mapping= visitTerminate((TTerminate) tActivity);
		}
		if (tActivity instanceof TThrow) {
			mapping= visitThrow((TThrow) tActivity);
		}
		if (tActivity instanceof TWait) {
			mapping= visitWait((TWait) tActivity);
		}
		if (tActivity instanceof TWhile) {
			mapping= visitWhile((TWhile) tActivity, false);
		}
		
		// complete with common activity mapping
		if (mapping != null) {
			mapping.setName(getActivityName(tActivity));
		}
		
		return mapping;
	}
	
	/**
	 * none task with assignments
	 */
	protected FlowObject visitAssign(TAssign tAssign) {
		TrafoLog.trace("Visiting Assign " + tAssign.toString());
		Activity activity= vsdtFac.createActivity();
		for (TCopy copy : tAssign.getCopy()) {
			TFrom from= copy.getFrom();
			ToType to= copy.getTo();
			Assignment assignment= vsdtFac.createAssignment();
			assignment.setTo(getProperty(to));
			assignment.setToQuery(to.getQuery());
			assignment.setFrom(createExpression(from));
			activity.getAssignments().add(assignment);
		}
		return activity;
	}

	/**
	 * none task
	 */
	protected FlowObject visitEmpty(TEmpty tEmpty) {
		TrafoLog.trace("Visiting Empty " + tEmpty.toString());
		if (ignoreEmpty) {
			return null;
		} else {
			return vsdtFac.createActivity();
		}
	}

	/**
	 * block oder subprocess, wenn es links gibt
	 */
	protected FlowObject visitFlow(TFlow tFlow) {
		TrafoLog.trace("Visiting Flow " + tFlow.toString());
		if (tFlow.getLinks() == null) {
			TrafoLog.trace("Mapping Flow to Block");
			// create block
			BpmnBlock block= strucFac.createBpmnBlock();
			for (Entry entry : tFlow.getActivity()) {
				TActivity tActivity= (TActivity) entry.getValue();
				FlowObject flowObject= visitActivity(tActivity);
				BpmnBranch branch= StrucBpmnElementFactory.createBranch(flowObject, null, false);
				block.getElements().add(branch);
			}
			block.setFirstGateway(VsdtElementFactory.createGateway(getActivityName(tFlow) + "_FORK", GatewayType.AND));
			block.setSecondGateway(VsdtElementFactory.createGateway(getActivityName(tFlow) + "_MERGE", GatewayType.AND));
			return block;
		} else {
			TrafoLog.trace("Mapping Flow to Embedded Subprocess");
			// create subprocess
			TrafoLog.warn("By now, only direct children of the flow can be connected with links");
			/*
			 * TODO this is not complete yet, as links can not only connect the top level
			 * elements of a flow. maybe a separate 'link-cycle' will be necessary...
			 */
			Activity subprocess= vsdtFac.createActivity();
			subprocess.setActivityType(ActivityType.EMBEDDED);
			Map<String, SequenceFlow> linkMap= new HashMap<String, SequenceFlow>();
			for (TLink link : tFlow.getLinks().getLink()) {
				SequenceFlow seqFlow= vsdtFac.createSequenceFlow();
				seqFlow.setName(link.getName());
				linkMap.put(link.getName(), seqFlow);
				bpd.getConnections().add(seqFlow);
			}
			for (Entry entry : tFlow.getActivity()) {
				TActivity tActivity= (TActivity) entry.getValue();
				FlowObject flowObject= visitActivity(tActivity);
				if (flowObject != null) {
					subprocess.getContainedFlowObjects().add(flowObject);
					for (TSource source : tActivity.getSource()) {
						SequenceFlow seqFlow= linkMap.get(source.getLinkName());
						seqFlow.setSource(flowObject);
						if (source.getTransitionCondition() != null) {
							seqFlow.setConditionExpression(VsdtElementFactory.createExpression(source.getTransitionCondition()));
							seqFlow.setConditionType(ConditionType.EXPRESSION);
						}
					}
					for (TTarget target : tActivity.getTarget()) {
						SequenceFlow seqFlow= linkMap.get(target.getLinkName());
						seqFlow.setTarget(flowObject);
					}
				}
			}
		}
		
		return null;
	}

	/**
	 * service task or send task
	 */
	protected FlowObject visitInvoke(TInvoke tInvoke) {
		TrafoLog.trace("Visiting Invoke " + tInvoke.toString());
		// TODO catch, catchAll, compensationHandler
		TrafoLog.nyi("Mapping of catch, catchAll and compensatioHandler");
		Activity activity= vsdtFac.createActivity();
		activity.setImplementation(getImplementation(tInvoke.getPortType().toString(), tInvoke.getOperation()));
		activity.setInMessage(getMessage(tInvoke.getInputVariable()));
		if (tInvoke.getOutputVariable() != null) {
			activity.setActivityType(ActivityType.SERVICE);
			activity.setOutMessage(getMessage(tInvoke.getOutputVariable()));
		} else {
			activity.setActivityType(ActivityType.SEND);
		}
		return activity;
	}

	/**
	 * bpmn block
	 */
	protected FlowObject visitPick(TPick tPick) {
		TrafoLog.trace("Visiting Pick " + tPick.toString());
		BpmnBlock block= strucFac.createBpmnBlock();
		for (TOnMessage onMessage : tPick.getOnMessage()) {
			Intermediate event= vsdtFac.createIntermediate();
			event.setTrigger(TriggerType.MESSAGE);
			event.setImplementation(getImplementation(onMessage.getPortType().toString(), onMessage.getOperation()));
			event.setMessage(getMessage(onMessage.getVariable()));
			
			TActivity tActivity= BpelUtil.getActivity(onMessage);
			FlowObject flowObject= visitActivity(tActivity);
			
			BpmnSequence sequence= strucFac.createBpmnSequence();
			sequence.getElements().add(event);
			if (flowObject != null) {
				sequence.getElements().add(flowObject);
			}
			block.getElements().add(StrucBpmnElementFactory.createBranch(sequence, null, false));
		}
		for (TOnAlarm onAlarm : tPick.getOnAlarm()) {
			Intermediate event= vsdtFac.createIntermediate();
			event.setTrigger(TriggerType.TIMER);
			if (onAlarm.getUntil() != null) {
				event.setTimeExpression(VsdtElementFactory.createExpression(onAlarm.getUntil()));
				event.setAsDuration(false);
			} else if (onAlarm.getFor() != null) {
				event.setTimeExpression(VsdtElementFactory.createExpression(onAlarm.getFor()));
				event.setAsDuration(true);
			}
			TActivity tActivity= BpelUtil.getActivity(onAlarm);
			FlowObject flowObject= visitActivity(tActivity);
			
			BpmnSequence sequence= strucFac.createBpmnSequence();
			sequence.getElements().add(event);
			if (flowObject != null) {
				sequence.getElements().add(flowObject);	
			}
			block.getElements().add(StrucBpmnElementFactory.createBranch(sequence, null, false));
		}
		block.setFirstGateway(VsdtElementFactory.createGateway(getActivityName(tPick) + "_FORK", GatewayType.XOR_EVENT));
		block.setSecondGateway(VsdtElementFactory.createGateway(getActivityName(tPick) + "_MERGE", GatewayType.XOR_EVENT));
		return block;
	}

	/**
	 * receive task
	 */
	protected FlowObject visitReceive(TReceive tReceive) {
		TrafoLog.trace("Visiting Receive " + tReceive.toString());
		Activity activity= vsdtFac.createActivity();
		activity.setActivityType(ActivityType.RECEIVE);
		activity.setImplementation(getImplementation(tReceive.getPortType().toString(), tReceive.getOperation()));
		activity.setOutMessage(getMessage(tReceive.getVariable()));
		return activity;
	}

	/**
	 * send task
	 */
	protected FlowObject visitReply(TReply tReply) {
		TrafoLog.trace("Visiting Reply" + tReply.toString());
		Activity activity= vsdtFac.createActivity();
		activity.setActivityType(ActivityType.SEND);
		activity.setImplementation(getImplementation(tReply.getPortType().toString(), tReply.getOperation()));
		activity.setInMessage(getMessage(tReply.getVariable()));
		return activity;
	}

	/**
	 * subprocess
	 */
	protected FlowObject visitScope(TScope tScope) {
		TrafoLog.nyi("Visiting Scope " + tScope.toString());

		TActivity tActivity= BpelUtil.getActivity(tScope);
		FlowObject flowObject= visitActivity(tActivity);
		
		Activity subprocess= vsdtFac.createActivity();
		subprocess.setActivityType(ActivityType.EMBEDDED);
		if (flowObject != null) {
			subprocess.getContainedFlowObjects().add(flowObject);	
		}

		// TODO variables
		
		BpmnEventHandlerBlock block= visitEventHandlers(tScope);
		if (block.getEventHandlerCases().isEmpty()) {
			// return just the subprocess
			return subprocess;
		} else {
			// wrap activity in the block and return it
			block.setActivity(subprocess);
			return block;
		}
	}
	
	protected BpmnEventHandlerBlock visitEventHandlers(EventHandlerHolder ehb) {
		BpmnEventHandlerBlock block= strucFac.createBpmnEventHandlerBlock();
		if (ehb.getCompensationHandler() != null) {
			Intermediate intermediate= VsdtElementFactory.createIntermediate(null, TriggerType.COMPENSATION);
			FlowObject flowObject= visitActivity(BpelUtil.getActivity(ehb.getCompensationHandler()));
			block.getEventHandlerCases().add(StrucBpmnElementFactory.createEventHandlerCase(intermediate, flowObject, null, null));
		}
		if (ehb.getFaultHandlers() != null) {
			for (TCatch c : ehb.getFaultHandlers().getCatch()) {
				Intermediate intermediate= VsdtElementFactory.createIntermediate(null, TriggerType.ERROR);
				intermediate.setErrorCode(c.getFaultName().toString());
				FlowObject flowObject= visitActivity(BpelUtil.getActivity(c));
				block.getEventHandlerCases().add(StrucBpmnElementFactory.createEventHandlerCase(intermediate, flowObject, null, null));
			}
			if (ehb.getFaultHandlers().getCatchAll() != null) {
				Intermediate intermediate= VsdtElementFactory.createIntermediate(null, TriggerType.ERROR);
				FlowObject flowObject= visitActivity(BpelUtil.getActivity(ehb.getFaultHandlers().getCatchAll()));
				block.getEventHandlerCases().add(StrucBpmnElementFactory.createEventHandlerCase(intermediate, flowObject, null, null));
			}
		}
		
		
		if (ehb.getEventHandlers() != null) {
			for (TOnAlarm onAlarm : ehb.getEventHandlers().getOnAlarm()) {
				Intermediate intermediate= VsdtElementFactory.createIntermediate(null, TriggerType.TIMER);
				if (onAlarm.getUntil() != null) {
					intermediate.setTimeExpression(VsdtElementFactory.createExpression(onAlarm.getUntil()));
					intermediate.setAsDuration(false);
				} else if (onAlarm.getFor() != null) {
					intermediate.setTimeExpression(VsdtElementFactory.createExpression(onAlarm.getFor()));
					intermediate.setAsDuration(true);
				}
				FlowObject flowObject= visitActivity(BpelUtil.getActivity(onAlarm));
				block.getEventHandlerCases().add(StrucBpmnElementFactory.createEventHandlerCase(intermediate, flowObject, null, null));
			}
			for (TOnMessage onMessage : ehb.getEventHandlers().getOnMessage()) {
				Intermediate intermediate= VsdtElementFactory.createIntermediate(null, TriggerType.MESSAGE);
				intermediate.setImplementation(getImplementation(onMessage.getPortType().toString(), onMessage.getOperation()));
				intermediate.setMessage(getMessage(onMessage.getVariable()));
				FlowObject flowObject= visitActivity(BpelUtil.getActivity(onMessage));
				block.getEventHandlerCases().add(StrucBpmnElementFactory.createEventHandlerCase(intermediate, flowObject, null, null));
			}
		}
		return block;
	}

	/**
	 * strucBpmn sequence
	 */
	protected FlowObject visitSequence(TSequence tSequence) {
		TrafoLog.trace("Visiting Sequence " + tSequence.toString());
		BpmnSequence sequence= strucFac.createBpmnSequence();
		for (Entry entry : tSequence.getActivity()) {
			TActivity tActivity= (TActivity) entry.getValue();
			FlowObject flowObject= visitActivity(tActivity);
			if (flowObject != null) {
				sequence.getElements().add(flowObject);	
			}
		}
		return sequence;
	}

	/**
	 * strucBpmn block
	 */
	protected FlowObject visitSwitch(TSwitch tSwitch) {
		TrafoLog.trace("Visiting Switch " + tSwitch.toString());
		BpmnBlock block= strucFac.createBpmnBlock();
		for (CaseType cas : tSwitch.getCase()) {
			FlowObject flowObject= visitActivity(BpelUtil.getActivity(cas));
			block.getElements().add(StrucBpmnElementFactory.createBranch(flowObject, VsdtElementFactory.createExpression(cas.getCondition()), false));
		}
		if (tSwitch.getOtherwise() != null) {
			FlowObject flowObject= visitActivity(BpelUtil.getActivity(tSwitch.getOtherwise()));
			block.getElements().add(StrucBpmnElementFactory.createBranch(flowObject, null, true));
		} else {
			if (tSwitch.getCase().size() < 2) {
				// create artificial second branch
				FlowObject flowObject= VsdtElementFactory.createActivity("Otherwise", ActivityType.NONE);
				block.getElements().add(StrucBpmnElementFactory.createBranch(flowObject, null, true));
			}
		}
		block.setFirstGateway(VsdtElementFactory.createGateway(getActivityName(tSwitch) + "_FORK", GatewayType.XOR_DATA));
		block.setSecondGateway(VsdtElementFactory.createGateway(getActivityName(tSwitch) + "_MERGE", GatewayType.XOR_DATA));
		return block;
	}

	/**
	 * terminate end event
	 */
	protected FlowObject visitTerminate(TTerminate tTerminate) {
		TrafoLog.trace("Visiting Terminate " + tTerminate.toString());
		End event= vsdtFac.createEnd();
		event.setTrigger(TriggerType.TERMINATE);
		return event;
	}

	/**
	 * error intermediate
	 */
	protected FlowObject visitThrow(TThrow tThrow) {
		TrafoLog.trace("Visiting Throw" + tThrow.toString());
		Intermediate event= vsdtFac.createIntermediate();
		event.setTrigger(TriggerType.ERROR);
		event.setErrorCode(tThrow.getFaultName().toString());
		// TODO fault variable
		return event;
	}

	/**
	 * create timer intermediate event
	 */
	protected FlowObject visitWait(TWait tWait) {
		TrafoLog.trace("Visiting Wait" + tWait.toString());
		Intermediate event= vsdtFac.createIntermediate();
		event.setTrigger(TriggerType.TIMER);
		if (tWait.getUntil() != null) {
			event.setTimeExpression(VsdtElementFactory.createExpression(tWait.getUntil()));
			event.setAsDuration(false);
		} else if (tWait.getFor() != null) {
			event.setTimeExpression(VsdtElementFactory.createExpression(tWait.getFor()));
			event.setAsDuration(true);
		}
		return event;
	}

	/**
	 * create strucBpmn loop
	 */
	protected FlowObject visitWhile(TWhile tWhile, boolean upstreamLoop) {
		TrafoLog.trace("Visiting While " + tWhile.toString());
		FlowObject flowObject= visitActivity(BpelUtil.getActivity(tWhile));
		String condition= tWhile.getCondition();
		if (upstreamLoop) {
			BpmnLoopBlock loop= strucFac.createBpmnLoopBlock();
			loop.setSecondBranch(StrucBpmnElementFactory.createBranch(flowObject, VsdtElementFactory.createExpression(condition), false));
			loop.setExitBranch(StrucBpmnElementFactory.createBranch(null, null, true));
			loop.setFirstGateway(VsdtElementFactory.createGateway(null, GatewayType.XOR_DATA));
			loop.setSecondGateway(VsdtElementFactory.createGateway(null, GatewayType.XOR_DATA));
			return loop;
		} else {
			Activity loop;
			if (flowObject instanceof Activity) {
				loop= (Activity) flowObject;
			} else {
				loop= vsdtFac.createActivity();
				loop.setActivityType(ActivityType.EMBEDDED);
				loop.getContainedFlowObjects().add(flowObject);
			}
			StandardLoopAttSet attSet= vsdtFac.createStandardLoopAttSet();
			attSet.setLoopCondition(VsdtElementFactory.createExpression(condition));
			loop.setLoopAttributes(attSet);
			return loop;
		}
	}
	
	/*
	 * GENERAL HELPER METHODS
	 */
	
	/** this field holds the number of the next activity that does not have a name by itself*/
	private int _actNameCounter= 0;
	
	/**
	 * @param tActivity		Some TActivity
	 * @return				the activity's name, or 'activity_n' if no name is given
	 */
	private String getActivityName(TActivity tActivity) {
		String name= tActivity.getName();
		if (name == null || name.isEmpty()) {
			name= "activity_" + _actNameCounter++;
		}
		return name;
	}
	
	/**
	 * Get the respective Property for the given ToType
	 * 
	 * @param to	Some ToType from a TAssign
	 * @return		Property object matching the ToType
	 */
	private Property getProperty(ToType to) {
		// TODO support for variable, part, expression, query, ...
		// endpoint ref, expression, opaque, part, partnerlink, property, query, variablename
		return getProperty(to.getPart());
	}
	
	/**
	 * Create an expression matching for the given TFrom
	 * 
	 * @param from	Some TFrom from a TAssign
	 * @return		Expression matching the TFrom
	 */
	private Expression createExpression(TFrom from) {
		// TODO create expression from all kinds of froms
		// endpoint ref, expression, opaque, part, partnerlink, property, query, variablename 
		return VsdtElementFactory.createExpression(from.getExpression());
	}
	
	/*
	 * MAPS HOLDING EXISTING SUPPORTING TYPES
	 */

	
	/** this map is holding already created properties */
	private Map<String, Property> _propertyMap= new HashMap<String, Property>();

	/** this map is holding already created messages */
	private Map<String, Message> _messageMap= new HashMap<String, Message>();

	/** this map is holding already created implementations */
	private Map<String, Implementation> _implementationMap= new HashMap<String, Implementation>();

	private Property getProperty(String name) {
		Property property= _propertyMap.get(name);
		if (property == null) {
			// TODO type 
			property= VsdtElementFactory.createProperty(name, "xsd:integer");
			TrafoLog.debug("Creating Property " + property.toString());
			_process.getProperties().add(property);
			_propertyMap.put(name, property);
		}
		return property;
	}

	private Message getMessage(String varName) {
		Message message= _messageMap.get(varName);
		if (message == null) {
//			 TODO properties
			message= VsdtElementFactory.createMessage(varName, /* null, null, */ null);
			TrafoLog.debug("Creating Message " + message.toString());
			bpd.getParent().getMessages().add(message);
			_messageMap.put(varName, message);
		}
		return message;
	}
	
	private Implementation getImplementation(String portType, String operation) {
		String key= portType+":"+operation;
		Implementation implementation= _implementationMap.get(key);
		if (implementation == null) {
			// TODO partner link
			implementation= VsdtElementFactory.createImplementation("WebService", portType, operation, null);
			TrafoLog.debug("Creating Implementation " + implementation.toString());
			bpd.getParent().getImplementations().add(implementation);
			_implementationMap.put(key, implementation);
		}
		return implementation;
	}
	
}
