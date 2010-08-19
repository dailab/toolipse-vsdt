package de.dailab.vsdt.trafo.jiacv.export;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.dailab.agentworld.AgentWorld;
import de.dailab.agentworld.Component;
import de.dailab.agentworld.ComponentLink;
import de.dailab.agentworld.Role;
import de.dailab.jiactng.jadl.AccessLevel;
import de.dailab.jiactng.jadl.Agent;
import de.dailab.jiactng.jadl.Assign;
import de.dailab.jiactng.jadl.Atom;
import de.dailab.jiactng.jadl.AtomList;
import de.dailab.jiactng.jadl.Case;
import de.dailab.jiactng.jadl.ComplexType;
import de.dailab.jiactng.jadl.ComplexValue;
import de.dailab.jiactng.jadl.Expression;
import de.dailab.jiactng.jadl.HeaderDeclaration;
import de.dailab.jiactng.jadl.IfThenElse;
import de.dailab.jiactng.jadl.Import;
import de.dailab.jiactng.jadl.Invoke;
import de.dailab.jiactng.jadl.Listen;
import de.dailab.jiactng.jadl.MessageEvent;
import de.dailab.jiactng.jadl.Par;
import de.dailab.jiactng.jadl.Print;
import de.dailab.jiactng.jadl.Receive;
import de.dailab.jiactng.jadl.Script;
import de.dailab.jiactng.jadl.Send;
import de.dailab.jiactng.jadl.Seq;
import de.dailab.jiactng.jadl.Service;
import de.dailab.jiactng.jadl.Switch;
import de.dailab.jiactng.jadl.TimeConst;
import de.dailab.jiactng.jadl.TimerEvent;
import de.dailab.jiactng.jadl.VariableDeclaration;
import de.dailab.jiactng.jadl.While;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.End;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.impl.BpmnElementMapping;
import de.dailab.vsdt.trafo.jiacv.util.Bpmn2JiacConstants;
import de.dailab.vsdt.trafo.jiacv.util.JadlElementFactory;
import de.dailab.vsdt.trafo.jiacv.util.Util;
import de.dailab.vsdt.trafo.jiacv.wizard.Bpmn2JiacVExportWizardOptionsPage;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InitialGatewayRule;

/**
 * BPMN to JIAC TNG JADL visitor. This visitor is performing a top-down pass of 
 * the BPMN model. This way it creates the element mapping for all the elements 
 * passed on the way.
 * 
 * @author tkuester
 */
public class Bpmn2JiacVElementMapping extends BpmnElementMapping implements Bpmn2JiacConstants {

	/**
	 * Enables some MAMS-specific specials, such as parameter names leading the 
	 * actual parameters in an invoke: invoke foobar("parName" $foo) ( )
	 */
	public static boolean useMAMSspecials= Bpmn2JiacVExportWizardOptionsPage.DEFAULT_MAMS_SPECIALS;

	/** service currently under construction */
	private Service _currentService;
	
	/** the JADL file currently under construction */
	private Agent _currentModel;
	
	/** map holding relation of services to listeners ( @see {@link Listen} ) */
	private Map<Service, Set<Expression>> messageListeners;
	
	/** map holding a relation of services to services calling this service (e.g. in case of multiple start events) */
	private Map<Service, List<Service>> callingServices;
	
	@Override
	public JiacVExportWrapper getWrapper() {
		return (JiacVExportWrapper) super.wrapper;
	}

	@Override
	public void initialize() {
		_currentService= null;
		_currentModel= null;
		messageListeners= new HashMap<Service, Set<Expression>>();
		callingServices= new HashMap<Service, List<Service>>();
		expressionVisitor= new JiacVExpressionVisitor(true, true);
	}
	
	//////////////////////////////////////////////////////////
	// VISITOR LOGIC
	//////////////////////////////////////////////////////////

	@Override
	protected void visitBusinessProcessSystem(BusinessProcessSystem bps) {
		TrafoLog.trace("Visiting Business Process System '" + bps.getName() + "'");
		
		// visit Business Processes, create JADL scripts
		for (BusinessProcessDiagram bpd : bps.getBusinessProcesses()) {
			visitBusinessProcessDiagram(bpd);
		}
		
		// create AgentWorldDiagram
		AgentWorld agentWorld= aweFac.createAgentWorld();
		agentWorld.setAuthor(bps.getAuthor());
		agentWorld.setDate(bps.getModificationDate());
		agentWorld.setVersion(bps.getVersion());
		agentWorld.setName(bps.getName());
		agentWorld.setNamespace(bps.getName());
		getWrapper().setAgentWorld(agentWorld);
		
		// create one AgentRole per Participant
		for (Participant participant : bps.getParticipants()) {
			Role role= aweFac.createRole();
			agentWorld.getHosts().add(role);
			role.setName(participant.getName() + "Role");
			role.setNamespace(agentWorld.getDefaultNamespace());
			for (Pool pool : participant.getAssociatedPools()) {

				// create components referring to created jadl files
				if (wrapper.getMapping(pool) instanceof Agent) {
					Agent model= (Agent) wrapper.getMapping(pool);
					String fileName= getWrapper().getJadlFileName(model);
					
					Component component= aweFac.createComponent();
					agentWorld.getHosts().add(component);
					// TODO name nur name, class relativ zum Project
					component.setName(fileName.substring(fileName.lastIndexOf('/')+1, fileName.lastIndexOf('.')));
					component.setURI(fileName);
					component.setType("_serviceType");
					
					// link Components to Roles
					ComponentLink link= aweFac.createComponentLink();
					agentWorld.getHosts().add(link);
					link.setUser(role);
					link.setComponent(component);
				}
			}
		}
	}
	
	/**
	 * Start the visitor's pass at the top-level business process diagram
	 * 
	 * @param bpd	the business process diagram to be mapped
	 */
	private void visitBusinessProcessDiagram(BusinessProcessDiagram bpd) {
		TrafoLog.trace("Visiting Business Process Diagram '" + bpd.getName() + "'");

		// visit Pools and add resulting services to model
		for (Pool pool : bpd.getPools()) {
			visitPool(pool);
		}
	}
	
	/**
	 * A BPMN pool/process is mapped to a JADL file. Basically, each Pool maps
	 * to one Service, which is wrapped in this file, but a Pool might also map
	 * to several Services, which are then all contained in the same file. 
	 * 
	 * @param pool		the BPMN pool
	 * @return			result of mapping
	 */
	public Agent visitPool(Pool pool) {
		TrafoLog.trace("Visiting Pool '" + pool.getName() + "'");
		
		//check adHoc
		if (pool.isAdHoc()) {
			TrafoLog.warn(pool.getName() + ": A mapping for AdHoc Processes is not defined. Skipping.");
			return null;
		}
		
		// create JADL file model and map it to the Pool
		Agent model= jadlFac.createAgent();
		_currentModel= model;
		getWrapper().addJadlFile(model, pool);
		
		// add imports for all Data Types
		for (DataType dataType : pool.getParent().getParent().getDataTypes()) {
			Import imprt = jadlFac.createImport();
			String clazz = dataType.getPackage() + "." + dataType.getName();
			imprt.setJavaClass(clazz);
			model.getHeader().add(imprt);
		}
		
		// build service (will automatically be added to the Agent model)
		buildService(pool.getParent().getName() + "_" + pool.getName(), 
				pool, 
				pool.getGraphicalElements(), 
				pool.getProperties());
		
		return model;
	}
	
	
	/**
	 * Map the given flow objects by iterating the list and visiting each single 
	 * flow object. If the list contains only one flowObject, the mapping for 
	 * this flowObject is returned, otherwise the flowObjects are put in a 
	 * structure (a par)
	 * 
	 * @param flowObjects	a list of flow objects
	 */
	private Script visitFlowObjects(List<FlowObject> flowObjects) {
		if (flowObjects.size() == 1) {
			//single activity: return that activity
			return visitFlowObject(flowObjects.get(0));
		} else{
			//multiple activities: create par
			List<Script> scripts= new ArrayList<Script>();
			for (FlowObject flowObject : flowObjects) {
				Script script= visitFlowObject(flowObject);
				if (script != null) {
					scripts.add(script);
				}
			}
			return wrapInPar(scripts);
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
	private Script visitFlowObject(FlowObject flowObject) {
		if (flowObject == null) {
			return null;
		}
		Script script= (Script) wrapper.getMapping(flowObject);
		if (script != null ) {
			// already mapped
			return script;
		}
		
		//delegate to specialized methods
		if (flowObject instanceof Event) {
			Event event= (Event) flowObject;
			script= visitEvent(event,null);
		}
		if (flowObject instanceof Activity) {
			Activity activity=(Activity) flowObject;
			script= visitActivity(activity);
		}
		if (flowObject instanceof Gateway) {
			Gateway gateway= (Gateway) flowObject;
			script= visitGateway(gateway);
		}
		//special structured BPMN elements
		if (flowObject instanceof BpmnSequence) {
			BpmnSequence bpmnSequence = (BpmnSequence) flowObject;
			script= visitBpmnSequence(bpmnSequence);
		}
		if (flowObject instanceof BpmnBlock) {
			BpmnBlock bpmnBlock = (BpmnBlock) flowObject;
			script= visitBpmnBlock(bpmnBlock);
		}
		if (flowObject instanceof BpmnLoopBlock) {
			BpmnLoopBlock bpmnLoopBlock = (BpmnLoopBlock) flowObject;
			script= visitBpmnLoopBlock(bpmnLoopBlock);
		}
		// TODO implement missing mappings
		if (flowObject instanceof BpmnDerivedProcess) {
			TrafoLog.nyi("Mapping for BpmnDerivedProcess element");
//			BpmnDerivedProcess bpmnDerivedProcess = (BpmnDerivedProcess) flowObject;
//			script= visitBpmnDerivedProcess(bpmnDerivedProcess);
		}
		if (flowObject instanceof BpmnEventHandlerBlock) {
			TrafoLog.nyi("Mapping for BpmnEventHandlerBlock element");
//			BpmnEventHandlerBlock eventHandlerBlock = (BpmnEventHandlerBlock) flowObject;
//			script= visitBpmnEventHandlerBlock(eventHandlerBlock);
		}
		if (flowObject instanceof BpmnElementToSkip) {
			TrafoLog.nyi("Mapping for BpmnElementToSkip element");
//			BpmnElementToSkip bpmnElementToSkip = (BpmnElementToSkip) flowObject;
//			script= visitBpmnElementToSkip(bpmnElementToSkip);
		}
		
		if (script != null) {
			wrapper.map(flowObject,script);
			TrafoLog.debug("FlowObject '" + flowObject.getName() + "' has been mapped to " + script.getClass().getName());
		} else {
			TrafoLog.warn("No mapping found for FlowObject '" + flowObject.getName() + "'");
		}
		
		return script;
	}
	
	/**
	 * Maps the given Event to various JADL elements, depending on the event's 
	 * type and attributes. Note that currently Start-, End-, and Intermediate 
	 * Events are mapped equally.
	 * 
	 * @param intermediate	the intermediate event
	 * @param multiType		trigger type to be used if the event has a multiple trigger
	 * @return				result of the mapping
	 */
	private Script visitEvent(Event event, TriggerType multiType) {
		TrafoLog.trace("Visiting Event '" + event.getName() + "'");
		Script mapping= null;
		TriggerType trigger= multiType != null ? multiType : event.getTrigger();
		
		List<Property> properties= new ArrayList<Property>();

		// enrich service name with name of current start event
		if (event instanceof Start && event.getName() != null) {
			_currentService.setName(_currentService.getName() + "_" + event.getName());
		}
		
		// create Start Rule
		if (event instanceof Start) {
			JiacVStarterRule startRule= new JiacVStarterRule(event, _currentService);
			((JiacVExportWrapper) wrapper).addStarterRule(event.getPool().getParticipant(), startRule);
		}
		
		switch (trigger) {
		case MESSAGE:
			Message message= event.getMessage();
			Implementation implementation= event.getImplementation();
			if (message != null) {
				if (event instanceof Start || event instanceof End) {
					// start/end: map message properties to service signature
					List<HeaderDeclaration> parameters= event instanceof Start
							? _currentService.getInputs()
							: _currentService.getOutputs();
					for (HeaderDeclaration declaration : jef.createHeaderDeclarations(message.getProperties())) {
						boolean alreadyDeclared= false;
						for (HeaderDeclaration param : parameters) {
							alreadyDeclared |= declaration.getName().equals(param.getName());
						}
						if (! alreadyDeclared) {
							parameters.add(declaration);
						}
					}
				} else {
					// message intermediate event: send/receive
					if (event.isThrowing()) {
						mapping= buildSend(event.getMessage(), implementation != null ? implementation.getParticipant() : null);
					} else {
						mapping= buildReceive(event.getMessage(), event.getPool().getParticipant());
					}
					// add message properties to properties
					properties.addAll(event.getMessage().getProperties());
				}
			}
			break;
		case NONE:
			break;
		case TIMER:
			if (event instanceof Start) {
				// timer start event is handled by starter rule	
			}
			if (event instanceof Intermediate) {
				Case timerCase= jadlFac.createCase();
				timerCase.setBody(jadlFac.createSeq()); // empty case body
				TimerEvent timer= jadlFac.createTimerEvent();
				if (event.isAsDuration()) {
					try {
						timer.setTimeout(Integer.parseInt(event.getTimeExpression().getExpression()));
						timerCase.setEventedCase(timer);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
				} else {
					TimeConst time= jadlFac.createTimeConst();
					time.setConst(event.getTimeExpression().getExpression());
					timer.setTime(time);
					timerCase.setEventedCase(timer);
				}
				if (timerCase.getEventedCase() != null) {
					mapping= timerCase;
				}
			}
			break;
		case RULE:
			String rule = event.getRuleExpression().getExpression();
			if (event instanceof Start) {
				// starter rule will be created holding the rule expression
				// create service parameters according to properties used in rule
				for (Property property : event.getPool().getProperties()) {
					if (rule.contains(property.getName())) {
						HeaderDeclaration header = jef.createHeaderVariableDeclaration(property.getName(), Util.getType(property));
						_currentService.getInputs().add(header);
					}
				}
			}
			if (event instanceof Intermediate) {
				// create case, waiting for the rule expression to become true
				Case expressionCase = jadlFac.createCase();
				Expression expression = jef.createExpression(rule);
				expressionCase.setExpressionCase(expression);
				mapping = expressionCase;
			}
			break;
		case LINK:
		case CANCEL:
		case COMPENSATION:
		case ERROR:
		case SIGNAL:
		case TERMINATE:
			// TODO implement missing mappings
			TrafoLog.nyi("Mapping for Event with trigger " + trigger.getName());
			break;
		case MULTIPLE:
			//create Par, holding the child triggers
			List<Script> children= new ArrayList<Script>();
			if (event.getMessage() != null && event.getImplementation() != null) {
				children.add(visitEvent(event, TriggerType.MESSAGE));
			}
			if (event.getErrorCode() != null) {
				children.add(visitEvent(event, TriggerType.ERROR));
			}
			if (event.getActivity() != null) {
				children.add(visitEvent(event, TriggerType.COMPENSATION));
			}
			if (event.getLinkedTo() != null) {
				children.add(visitEvent(event, TriggerType.LINK));
			}
			if (event.getTimeExpression() != null && event.getTimeExpression().getExpression() != null) {
				children.add(visitEvent(event, TriggerType.TIMER));
			}
			if (event.getRuleExpression() != null && event.getRuleExpression().getExpression() != null) {
				children.add(visitEvent(event, TriggerType.RULE));
			}
			mapping= wrapInPar(children);
			break;
		default:
			TrafoLog.warn("Could not find a Mapping for Event " + event.getNameOrId());
		}
		
		if (! (event.getAssignments().isEmpty() && properties.isEmpty())) {
			mapping= buildSequence(mapping, properties, event.getAssignments());
		}
		
		return mapping;
	}
	
	
	/**
	 * Maps the given Activity to various BPEL elements, depending on the 
	 * activity's types and attributes.
	 * 
	 * @param activity	the activity to map
	 * @return			result of the mapping, including loops etc. 
	 */
	private Script visitActivity(Activity activity) {
		TrafoLog.trace("Visiting Activity '" + activity.getName() + "'");
		Script mapping= null;
		
		//checks
		if (activity.getTransaction() != null) {
			TrafoLog.warn("A mapping for transactions is not defined. Ignoring transaction attributes.");
		}
		if (activity.isAdHoc()) {
			TrafoLog.warn("A mapping for AdHoc activities is not defined. Ignoring AdHoc attributes.");
		}
		List<Property> properties= new ArrayList<Property>();
		properties.addAll(activity.getProperties());
		switch (activity.getActivityType()) {
		case NONE:
			break;
		case SCRIPT:
			// parse the script
			mapping= jef.parseScript(activity.getScript(), null);
			break;
		case SERVICE:
			// TODO add import according to service location?
			// invoke another plan
			Invoke invoke= jadlFac.createInvoke();
			// set name of action to be invoked according to the implementation
			invoke.setAction(activity.getImplementation().getOperation());
			invoke.setNamespace(activity.getImplementation().getInterface());
			// set input and output variables according to message variables
			for (Property property : activity.getInMessage().getProperties()) {
				if (useMAMSspecials) {
					invoke.getParameters().add(jef.createInputForMAMS(property.getName(), property.getName()));
				} else {
					invoke.getParameters().add(jef.createVariable(property.getName()));
				}
			}
			for (Property property : activity.getOutMessage().getProperties()) {
				invoke.getReturnVariables().add(jef.createVariable(property.getName()).getName());
			}
			// move copy of message variables to the activity itself, so they are added to the scope
			activity.getProperties().addAll(EcoreUtil.copyAll(activity.getInMessage().getProperties()));
			activity.getProperties().addAll(EcoreUtil.copyAll(activity.getOutMessage().getProperties()));
			mapping= invoke;
			break;
		case EMBEDDED:
			// do not create a new plan; just put contents in a seq or par
			mapping= visitFlowObjects(activity.getContainedFlowObjects());
			break;
		case REFERENCE:
			mapping= (Script) EcoreUtil.copy(visitFlowObject(activity.getActivityRef()));
			break;
		case SEND:
			// send element
			Message message= activity.getInMessage();
			Implementation implementation= activity.getImplementation();
			properties.addAll(message.getProperties());
			mapping= buildSend(message, implementation != null ? implementation.getParticipant() : null);
			break;
		case RECEIVE:
			// receive element
			message= activity.getOutMessage();
			properties.addAll(message.getProperties());
			mapping= buildReceive(message, activity.getPool().getParticipant());
			break;
		case INDEPENDENT:
			// call another service, similar to invoke
		case MANUAL:
		case USER:
			// TODO implement missing mappings
			TrafoLog.nyi("Mapping for Activity with type " + activity.getActivityType().getName());
		default:
			TrafoLog.warn("Could not find a Mapping for Activity " + activity.getNameOrId());
		}

		if (mapping == null) {
			Print print= jadlFac.createPrint();
			print.setExpression(jef.createExpression("Executing " + activity.getName()));
			mapping= print;
		}
		
		// create loop mappings: basic mapping is embedded in loop structure
		if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
			mapping= createStandardLoop(activity, mapping);
		}
		if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
			mapping= createMultiInstanceLoop(activity, mapping);
		}
		
		//build activity sequence: properties, assignments, mapping, more assignments
		mapping= buildSequence(mapping, properties, activity.getAssignments());
		
		return mapping;
	}
	

	/**
	 * gateways themselves have no mapping. If they are part of a block-structure, 
	 * they will determine the mapping of the block-structure. If they have 
	 * assignments, the assignments will be mapped.
	 * 
	 * @param gateway	the gateway
	 * @return			the mapping result (in this case, null)
	 */
	private Script visitGateway(Gateway gateway) {
		TrafoLog.trace("Visiting Gateway '" + gateway.getName() + "'");
		if (gateway.getAssignments().isEmpty()) {
			return buildSequence(null, null, gateway.getAssignments());
		} else {
			return null;	
		}
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
	private Script visitBpmnSequence(BpmnSequence bpmnSequence) {
		TrafoLog.trace("Visiting BpmnSequence");
		Seq seq= jadlFac.createSeq();
		for (FlowObject flowObject :  bpmnSequence.getElements()) {
			Script script= visitFlowObject(flowObject);
			if (script != null) {
				seq.getScripts().add(script);
			}
		}
		return seq;
	}
	
	/**
	 * - determine block type from the forking gateway and create block structure
	 * - in a loop, fill the block with it' elements
	 * 
	 * @param bpmnBlock		a BPMN block, that has been created with the BlockRule
	 * @return				the activity to which the BpmnBlock has been mapped (a TFlow, TSwitch or TPick)
	 */
	private Script visitBpmnBlock(BpmnBlock bpmnBlock) {
		TrafoLog.trace("Visiting BpmnBlock");
		Gateway fork= bpmnBlock.getFirstGateway();
		Script mapping= null;

		switch (fork.getGatewayType()) {
		case AND: {
			List<Script> scripts= new ArrayList<Script>();
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				Script script= visitFlowObject(flowObject);
				if (script != null) {
					scripts.add(script);
				}
			}
			mapping= wrapInPar(scripts);
			break;
		}
		case OR: {
			// par with one if for each branch
			boolean hasDefault= bpmnBlock.getDefaultElement() != null;
			String varName= fork.getId() + "_defaultRequired";
			List<Script> scripts= new ArrayList<Script>();
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				if (bpmnBlock.getDefaultElement() == flowObject) {
					continue;
				}
				Script script= visitFlowObject(flowObject);
				if (hasDefault) {
					// add assign to the tracking variable to the script
					Seq seq= jadlFac.createSeq();
					seq.getScripts().add(script);
					seq.getScripts().add(jef.createAssign("false", varName, null));
					script= seq;
				}
				String condString= JadlElementFactory.INSTANCE.getCondition(branch.getCondition());
				Expression expression= jef.parseExpression(condString);
				IfThenElse ifThenElse= buildIfThenElse(expression, script, null);
				if (ifThenElse != null) {
					scripts.add(ifThenElse);
				}
			}
			Par par= wrapInPar(scripts);
			if (hasDefault) {
				// create tracking variable
				VariableDeclaration declaration= jef.createVariableDeclaration(varName, TYPE_BOOL);
				Assign assign= jef.createAssign("true", varName, null);
				// create default case
				FlowObject flowObject= bpmnBlock.getDefaultElement();
				Script script= visitFlowObject(flowObject);
				Expression expression= jadlFac.createExpression();
				expression.setHeadTerm(jef.createVariable(varName));
				IfThenElse ifThenElse= buildIfThenElse(expression, script, null);
				// create sequence holding the par and the other stuff
				Seq seq= jadlFac.createSeq();
				seq.getScripts().add(declaration);
				seq.getScripts().add(assign);
				seq.getScripts().add(par);
				seq.getScripts().add(ifThenElse);
				// return the sequence
				mapping= seq;
			} else {
				// return the par
				mapping= par;
			}
			break;
		}
		case XOR_DATA: {
			// create a chain of if-else blocks, starting from the 'inside' with the default case
			// and working its way out to the outermost if-else, which then is the mapped element
			Script lastElement= null;
			if (bpmnBlock.getDefaultElement() != null) {
				lastElement= visitFlowObject(bpmnBlock.getDefaultElement());
			}
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				if (bpmnBlock.getDefaultElement() == flowObject) {
					continue;
				}
				String condString= JadlElementFactory.INSTANCE.getCondition(branch.getCondition());
				Expression expression= jef.parseExpression(condString);
				Script script= visitFlowObject(flowObject);
				IfThenElse thisElement= buildIfThenElse(expression, script, lastElement);
				lastElement= thisElement;
			}
			mapping= lastElement;
			break;
		}
		case XOR_EVENT:
			//create switch
			Switch block= jadlFac.createSwitch();

			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();

				// parse body and wrap in sequence
				Script script= visitFlowObject(flowObject);
				Seq body= null;
				if (script instanceof Seq) {
					body= (Seq) script;
				} else {
					body= jef.createSequence(script);
				}
				
				// get event activity
				Script event= getFirstEventElement(body);

				// modify body
				if (event instanceof Case) {
					// remove timer case from sequence
					body.getScripts().remove(event);
					Case timerCase= (Case) event;
					timerCase.setBody(body);
					block.getCases().add(timerCase);
				} else if (event instanceof Receive) {
					// receive can stay in sequence
					Receive receive= (Receive) event;
					// will be preceded by listen and onMessage
					MessageEvent messageEvent= jadlFac.createMessageEvent();
					Expression address = receive.getAddress();
					messageEvent.setAddress((Expression) EcoreUtil.copy(address));
					Property property= (Property) wrapper.getMapping(receive);
					messageEvent.setType(jef.createType(Util.getType(property)));
					Case messageCase= jadlFac.createCase();
					messageCase.setEventedCase(messageEvent);
					messageCase.setBody(body);
					block.getCases().add(messageCase);
					// add listen
					messageListeners.get(_currentService).add((Expression) EcoreUtil.copy(address));
				}
			}
			mapping= block;
			break;
		case COMPLEX:
			// TODO Mapping for Complex Gateway (in general)

			/*
			 * For Complex Gateways created from the Initial Gateway Rule,
			 * a new service will be created for each branch, finally calling
			 * the original service, starting after the block.
			 * Also see buildService for further processing of the services. 
			 */
			if (fork.getName().contains(InitialGatewayRule.INITIAL_GATEWAY)) {
				// memorize original service (_currentService will be bound to the new one)
				final Service parentService= _currentService;
				List<Service> services= new ArrayList<Service>();
				int counter= 0;
				for (BpmnBranch branch : bpmnBlock.getElements()) {
					// create service for each branch
					Service service= buildService(parentService.getName() + "_" + counter++, 
							branch, 
							Arrays.asList(branch.getElement()), 
							bpmnBlock.getPool().getProperties());
					services.add(service);
				}
				// set relation in map and set _currentService back to the parentService
				callingServices.put(parentService, services);
				_currentService= parentService;
			} else {
				TrafoLog.nyi("Mapping for Gateway Type " + fork.getGatewayType().getName());
			}
		}
		return mapping;
	}
	

	/**
	 * Create a new Service element. The Service is automatically mapped to the 
	 * original Element and added to the current Agent model.  Following this,
	 * the FlowObjects are visited and the service's body sequence is composed
	 * from the properties (variable declarations), process assignments (initial
	 * variable definition), listener calls, if any, and the mapping of the 
	 * FlowObjects.  If the service is to be called by other services, this will
	 * be taken care of here, too.
	 * 
	 * {@link #callingServices}
	 * 
	 * @param name			Name of the Service to create
	 * @param source		Source object, mainly for the mapping
	 * @param body			Flow Objects forming the body of the service
	 * @param properties	Process Properties, to be declared as variables
	 * @return				new JADL service instance
	 */
	private Service buildService(String name, EObject source, List<FlowObject> flowObjects, List<Property> properties) {
		// create service model
		Service service= jadlFac.createService();
		service.setAccessLevel(AccessLevel.NODE);
		_currentService= service;
		_currentModel.getServices().add(service);
		wrapper.map(source, service);
		messageListeners.put(service, new HashSet<Expression>());
		
		service.setName(name);
		if (useMAMSspecials) {
			service.setAccessLevel(AccessLevel.GLOBAL);
		}
		
		// visit FlowObjects  
		Script script= visitFlowObjects(flowObjects);

		// build body sequence
		Seq body= jadlFac.createSeq();
		service.setBody(body);
		
		// 1.: Variable declarations
		// declare only those process variables that are not used as service parameters
		List<Property> properProperties= new ArrayList<Property>(properties);
		for (Iterator<Property> iter= properProperties.iterator(); iter.hasNext(); ) {
			String propName = "$" + iter.next().getName();
			for (HeaderDeclaration input : service.getInputs()) {
				if (propName.equals(input.getName())) {
					iter.remove();
					break;
				}
			}
		}
		body.getScripts().addAll(visitProperties(properProperties));
		
		// 2.: Initial Assignments
		if (callingServices.containsKey(service)) {
			// set services input parameters to all process properties and add assignments
			for (Property property : properties) {
				String inputName= "input_" + property.getName();
				service.getInputs().add(jef.createHeaderVariableDeclaration(inputName, Util.getType(property)));
				service.getBody().getScripts().add(jef.createAssign("$" + "input_" + property.getName(), property.getName(), null));
			}
			// adapt the calling services to this (the called) service
			List<Service> otherServices= callingServices.get(service);
			for (Service otherService : otherServices) {
				// set calling services return value to this services return values
				otherService.getOutputs().addAll(EcoreUtil.copyAll(service.getOutputs()));
				// create invoke calling the parent process
				Invoke invoke= jadlFac.createInvoke();
				invoke.setAction(service.getName());
				for (Property property : properties) {
					invoke.getParameters().add(jef.createVariable(property.getName()));
				}
				for (HeaderDeclaration varDecl : service.getOutputs()) {
					invoke.getReturnVariables().add(varDecl.getName());
				}
				// insert the invoke at the end
				otherService.getBody().getScripts().add(invoke);
			}
		}
		
		// 3.: add listeners
		for (Expression address : messageListeners.get(service)) {
			Listen listen= jadlFac.createListen();
			listen.setAddress(address);
			body.getScripts().add(listen);
		}
		
		// 4.: script
		if (script != null) {
			body.getScripts().add(script);	
		}
		
		return service;
	}
	
	
	
	/**
	 * - compose loop condition from given loopCondition and exitCondition
	 * - assemble the loop body from firstElement and/or secondElement
	 * - create the actual loop structure, holding the loop body
	 * - return the loop structure, eventually wrapped in a sequence and preceded 
	 *   by a copy of firstElement 
	 * 
	 * NOTE: This method does use none of the below createLoop-Methods.
	 * 
	 * @param bpmnLoopBlock	a BPMN loop block, that has been created with the LoopRule
	 * @return				the activity to which the BpmnLoopBlock has been mapped
	 */
	private Script visitBpmnLoopBlock(BpmnLoopBlock bpmnLoopBlock) {
		Script untilPart= visitFlowObject(bpmnLoopBlock.getFirstBranch().getElement());
		Script whilePart= visitFlowObject(bpmnLoopBlock.getSecondBranch().getElement());
		
		// compose and parse loop condition expression
		Expression expression= null;
		if (bpmnLoopBlock.getSecondBranch().getCondition() != null) {
			expression= jef.parseExpression(bpmnLoopBlock.getSecondBranch().getCondition());
		} else {
			//use negated exit condition
			expression= jef.parseExpression("! (" + bpmnLoopBlock.getExitBranch().getCondition().getExpression() + ")");
		}

		// assemble loop body
		Seq loopBody= jadlFac.createSeq();
		if (whilePart != null) {
			loopBody.getScripts().add(whilePart);
		}
		if (untilPart != null) {
			loopBody.getScripts().add(untilPart);
		}
		
		// create loop element
		While loop= jadlFac.createWhile();
		loop.setExpression(expression);
		loop.setBody(loopBody);
		
		// IV. ASSEMBLE SEQUENCE HOLDING THE LOOP (and return it)
		if (untilPart == null) {
			// only the loop
			return loop;
		} else {
			// a sequence holding a copy of activity 1 and the loop
			Seq seq= jadlFac.createSeq();
			seq.getScripts().add((Script) EcoreUtil.copy(untilPart));
			seq.getScripts().add(loop);
			return seq;
		}
	}
	
	
	/*
	 * //////////////////////////////////////
	 * //// SUPPORTING TYPES
	 * //////////////////////////////////////
	 */	
	
	/**
	 * map some BPMN element's properties set. For the whole set of properties 
	 * a number of VariableDeclarations are created and returned in a list.
	 * 
	 * @param properties	list of BPMN properties
	 */
	private List<Atom> visitProperties(List<Property> properties) {
		List<Atom> declarations= new ArrayList<Atom>();
		if (properties != null) {
			for (Property property : properties) {
				final String varName = property.getName();
				final String typeName = Util.getType(property);
				declarations.add(jef.createVariableDeclaration(varName, typeName));
				// initialize variables...
				if (property.getType().contains(".")) {
					// ...only if it is a complex type
					Assign assign= jadlFac.createAssign();
					assign.setVariable(jef.createVariable(varName));
					assign.setNew(true);
					ComplexType type = jadlFac.createComplexType();
					type.setClazz(typeName);
					ComplexValue complex = jadlFac.createComplexValue();
					complex.setType(type);
					assign.setInstance(complex);
					declarations.add(assign);
				}
			}
		}
		return declarations;
	}
	
	/**
	 * Visit many assignments and return them as a list
	 * 
	 * @param assignments	the BPMN assignments
	 * @param assignTime	assign time to regard, or null to regard all assign times 
	 * @return
	 */
	private List<Assign> visitAssignments(List<Assignment> assignments, AssignTimeType assignTime) {
		List<Assign> assigns= new ArrayList<Assign>();
		if (assignments != null) {
			for (Assignment assignment : assignments) {
				if (assignTime == null || assignment.getAssignTime() == assignTime) {
					Assign assign= jef.createAssign(assignment.getFrom().getExpression(), assignment.getTo().getName(), assignment.getToQuery());
					if (assign != null) {
						assigns.add(assign);
					}
				}
			}
		}
		return assigns;
	}

	/*
	 * ////////////////////////////////////////////
	 * // ACTIVITY LOOPING (for upstream looping see above)
	 * ////////////////////////////////////////////
	 * 
	 * The below methods are used by the activity loop mapping only, and not for loops
	 * that were created with upstream connections.
	 */
	
	/**
	 * In the Standard Loop Mapping the Activity being result to the mapping is 
	 * wrapped in a sequence, in which a loop counter variable is defined and 
	 * initialized. Then, in a tWhile, the condition is checked, the activity 
	 * gets executed and the counter is incremented.
	 * 
	 * @param activity		the original activity holding the loop attributes
	 * @param script		the activity's mapping to be embedded in the loop
	 * @return				sequence with loop
	 */
	private Script createStandardLoop(Activity activity, Script script) {
		StandardLoopAttSet attSet= (StandardLoopAttSet) activity.getLoopAttributes();
		Script loop= createLoopSequence(
				activity, 
				script, 
				attSet.getLoopCondition() != null ? attSet.getLoopCondition().getExpression() : null, 
				attSet.getLoopMaximum(), 
				attSet.isTestBefore()); 
		return loop;
	}
	
	
	/**
	 * This method will create the complex Activity being result of the mapping 
	 * of a multi instance loop. If the ordering type is SEQUENTIAL, this methods 
	 * does mostly the same as createStandardLoop. If the ordering type is PARALLEL, 
	 * the procedure is much more complex, including the creation of a spawned 
	 * process, invoking and joining the instances of this process in loops, and 
	 * the creation of partner links, port types and stuff for calling the process.
	 *  
	 *  TODO MI-Loops
	 *  
	 * @param activity		the original activity holding the loop attributes
	 * @param script		the activity's mapping to be embedded in the loop
	 * @return				sequence with MI loop
	 */
	private Script createMultiInstanceLoop(Activity activity, Script script) {
		TrafoLog.nyi("Mapping for Multi Instance Loop");
		return null;
	}
	

	/**
	 * Create and return a loop based on a given FlowObject with LoopType==Standard 
	 * or MultiInstance with sequential ordering. This method will also create 
	 * the assignments initializing the loop variable(s).
	 * 
	 * @param flowObject	the source object
	 * @param script		the target object
	 * @param condition		the condition expression
	 * @param maximum		the loop maximum (in case of Standard Loop)
	 * @param testBefore	the test time, depending on which the condition will be extended
	 * @return				a TSequence holding initializing TAssigns followed by a TWhile for the loop (using createLoop)
	 */
	private Seq createLoopSequence(FlowObject activity, Script script, String condition, int maximum, boolean testBefore) {
		String actName= activity.getName();
		String varName= actName.toLowerCase() + "_loopCounter";
		boolean useLoopCounter= maximum > 0;
		
		// counter variable and assigns
		VariableDeclaration declaration= jef.createVariableDeclaration(varName, TYPE_INT);
		Assign initAssign= jef.createAssign("0", varName, null);
		Assign incAssign= jef.createAssign("$"+varName+"+1", varName, null);

		// this sequence is the whole loop structure, including variable initialization
		Seq outerSeq= jadlFac.createSeq();
		if (useLoopCounter) {
			outerSeq.getScripts().add(declaration);
			outerSeq.getScripts().add(initAssign);
		}
		// create loop body holding the mapped activity and the increment for the loop counter
		Seq innerSeq= jadlFac.createSeq();
		if (useLoopCounter) {
			innerSeq.getScripts().add(incAssign);
		}
		innerSeq.getScripts().add(script);

		// build and parse loop expression
		String cond= condition;
		//append additional condition for loop maximum
		if (useLoopCounter) {
			String cond2= "$"+varName + " < " + maximum;
			cond= cond != null && cond.length()>0 ? "("+ cond +") && (" + cond2 + ")" : cond2;
		}
		//for testTime=after: instead of inserting a copy of the activity here, which could be quite long, an additional test is appended
		if (! testBefore) {
			String cond2= "$"+varName + " < 1";
			cond= cond != null && cond.length()>0 ? "("+ cond +") || (" + cond2 + ")" : cond2;
		}

		//create the loop element, holding the sequence and the condition
		While loop= jadlFac.createWhile();
		loop.setBody(innerSeq);
		loop.setExpression(jef.parseExpression(cond));
		
		outerSeq.getScripts().add(loop);
		
		return outerSeq;
	}
	
	/*
	 * ////////////////////////////////////////////
	 * // MORE HELPER METHODS
	 * ////////////////////////////////////////////
	 */
	
	/**
	 * Return the first non-Assign element of a (nested) sequence. This method 
	 * is useful for determining the 'event' behind an event-based xor-gateway. 
	 * Such a gateway can not be followed by a loop or block, as a gateway would 
	 * not be allowed as a consecutive element.
	 * 
	 * @param sequence	Some JADL Sequence
	 * @return			First element that is not an assign (receive or timer case)
	 */
	private Script getFirstEventElement(Seq sequence) {
		for (Script script : sequence.getScripts()) {
			// case 1: case with timer event 
			if (script instanceof Case && ((Case) script).getEventedCase() instanceof TimerEvent) {
				return script;
			}
			// case 2: receive
			if (script instanceof Receive) {
				return script;
			}
			// case 3: receive as an assign value is no longer the case
			// case 4: a sequence wrapped in a sequence
			if (script instanceof Seq) {
				Script rec= getFirstEventElement((Seq) script);
				if (rec != null) {
					return rec;
				}
			}
		}
		return null;
	}
	
	/**
	 * Builds a sequence holding variable declarations, start time assignments, 
	 * a script, and end time assignments.
	 * 
	 * @param script		already mapped script
	 * @param properties	List of BPMN properties to be mapped to variable declarations
	 * @param assignments	List of BPMN assignments to be mapped to assigns
	 */
	private Seq buildSequence(Script script, List<Property> properties, List<Assignment> assignments) {
		Seq seq= jadlFac.createSeq();
		seq.getScripts().addAll(visitProperties(properties));
		seq.getScripts().addAll(visitAssignments(assignments, AssignTimeType.START));
		if (script != null) {
			seq.getScripts().add(script);	
		}
		seq.getScripts().addAll(visitAssignments(assignments, AssignTimeType.END));
		return seq;
	}
	
	/**
	 * Builds an IfThenElse holding the given expression, then, and else elements
	 * 
	 * @param expression	some JADL expression
	 * @param thenCase		some JADL script for the then case
	 * @param elseCase		some JADL script for the else case
	 * @return				newly created IfThenElse
	 */
	private IfThenElse buildIfThenElse(Expression expression, Script thenCase, Script elseCase) {
		IfThenElse ifThenElse= jadlFac.createIfThenElse();
		ifThenElse.setExpression(expression);
		ifThenElse.setThen(wrapInSeq(thenCase));
		ifThenElse.setElse(wrapInSeq(elseCase));
		return ifThenElse;
	}
	
	/**
	 * Creates one or more Send elements form the given message.  For each of
	 * the Message's Properties an individual Send element is created.  If more
	 * than one Send needs to be created, they are wrapped in a Seq element.
	 * 
	 * @param message		the message to be sent
	 * @param participant	whom to send the message
	 * @return				Send element, or multiple Send elements in a Seq element
	 */
	private Script buildSend(Message message, Participant participant) {
		Expression address = jef.createAddress(message, participant);
		if (message.getProperties().size() == 1) {
			Send send= jef.createSend(address, message.getProperties().get(0));
			return send;
		} else {
			Seq seq= jadlFac.createSeq();
			for (Property property : message.getProperties()) {
				Send send= jef.createSend(address, property);
				seq.getScripts().add(send);
			}
			return seq;
		}
	}

	/**
	 * Creates one or more Receive elements form the given message.  For each of
	 * the Message's Properties an individual Receive element is created.  If more 
	 * than one Receive needs to be created, they are wrapped in a Seq element.
	 * 
	 * @param message		the message to be received
	 * @param participant	to whom the message is directed (e.g. a group)
	 * @return				Receive element, or multiple Receive elements in a Seq element
	 */
	private Script buildReceive(Message message, Participant participant) {
		Expression address = jef.createAddress(message, participant);
		int timeout= 10000;
		if (message.getProperties().size() == 1) {
			Property property= message.getProperties().get(0);
			Receive receive= jef.createReceive(address, Util.getType(property), property.getName(), timeout);
			wrapper.map(receive, property); // put type in map, for later retrieval when creating onMessage
			// this is necessary as the receive itself only known the name of the variable, but not the type
			// however, one could use another map for this association, too
			return receive;
		} else {
			Seq seq= jadlFac.createSeq();
			for (Property property : message.getProperties()) {
				Receive receive= jef.createReceive(address, Util.getType(property), property.getName(), timeout);
				seq.getScripts().add(receive);
				wrapper.map(receive, property); // put type in map, for later retrieval when creating onMessage
			}
			return seq;
		}			
	}
	
	/**
	 * Takes a script and wraps it in a sequence, if necessary. 
	 * Useful for e.g. loop bodies.
	 * 
	 * @param script	some script of arbitrary type
	 * @return			a sequence holding only the script, or the script itself, if it was a sequence
	 */
	private Seq wrapInSeq(Script script) {
		if (script == null) {
			return null;
		}
		if (script instanceof Seq) {
			return (Seq) script;
		} else {
			Seq seq= jadlFac.createSeq();
			seq.getScripts().add(script);
			return seq;
		}
	}
	
	private Par wrapInPar(List<Script> scripts) {
		Par par= jadlFac.createPar();
		if (scripts != null) {
			for (Script script : scripts) {
				AtomList list = jadlFac.createAtomList();
				if (script instanceof Atom) {
					list.getAtoms().add((Atom) script);
				} else if (script instanceof Seq) {
					for (Script script2 : ((Seq) script).getScripts()) {
						if (script2 instanceof Atom) {
							Atom atom = (Atom) EcoreUtil.copy(script2);
							list.getAtoms().add(atom);
						}
					}
				} else {
					TrafoLog.warn("A Par can only hold atomic elements. failed to insert " + script.eClass().getName());
				}
				par.getAtoms().add(list);
			}
		}
		return par;
	}
}
