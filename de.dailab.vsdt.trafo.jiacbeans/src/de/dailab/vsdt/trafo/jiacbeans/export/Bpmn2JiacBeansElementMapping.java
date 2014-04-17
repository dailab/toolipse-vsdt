package de.dailab.vsdt.trafo.jiacbeans.export;

import java.util.ArrayList;
import java.util.List;

import jiacbeans.Action;
import jiacbeans.AgentBean;
import jiacbeans.CodeElement;
import jiacbeans.IfThenElse;
import jiacbeans.JiacbeansFactory;
import jiacbeans.Method;
import jiacbeans.Parallel;
import jiacbeans.Runner;
import jiacbeans.Script;
import jiacbeans.Sequence;
import jiacbeans.SubProcess;
import jiacbeans.TryCatch;
import jiacbeans.Variable;
import jiacbeans.While;

import org.eclipse.emf.ecore.util.EcoreUtil;

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
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.impl.BpmnElementMapping;
import de.dailab.vsdt.trafo.jiacbeans.Util;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.export.rules.l0.InitialGatewayRule;

/**
 * BPMN to JIAC AgentBeans visitor. This visitor is performing a top-down pass of 
 * the BPMN model. This way it creates the element mapping for all the elements 
 * passed on the way.
 * 
 * @author pstan, kuester
 */
public class Bpmn2JiacBeansElementMapping extends BpmnElementMapping {
	final JiacbeansFactory fac = JiacbeansFactory.eINSTANCE;
	
	/** the currently visited workflow */
	private Method currentWorkflow;
	
	/** currently visited Agent Bean */
	private AgentBean currentBean;

	/** current Agent Bean's doStart method, if any */
	private Method doStartMethod;
	
	/** current Agent Bean's execute method, if any */
	private Method executeMethod;
	
	/** currently visited SubProcess, if any */
	private SubProcess currentSubProcess;
	
	@Override
	public void initialize() {
		expressionVisitor = new JiacBeansExpressionVisitor(true, true);
	}
	
	public JiacBeansExportWrapper getWrapper(){
		return (JiacBeansExportWrapper) super.wrapper;
	}
	
	/**
	 * Entry point to the whole transformation. Transforms individual Process Diagrams.
	 */
	@Override
	protected void visitBusinessProcessSystem(BusinessProcessSystem bps) {
		TrafoLog.trace("Visiting Business Process System '" + bps.getName() + "'");
		
		// visit Business Processes, create JADL scripts
		for (BusinessProcessDiagram bpd : bps.getBusinessProcesses()) {
			visitBusinessProcessDiagram(bpd);
		}
	}
	
	/**
	 * Start the visitor's pass at the top-level business process diagram
	 * 
	 * @param bpd	the business process diagram to be mapped
	 */
	private void visitBusinessProcessDiagram(BusinessProcessDiagram bpd) {
		TrafoLog.trace("Visiting Business Process Diagram '" + bpd.getName() + "'");
		// visit Pools 
		for (Pool pool : bpd.getPools()) {
			visitPool(pool);
		}
	}
	
	/**
	 * Each Pool is mapped to one Workflow Agent Bean, containing a workflow
	 * method, a number of activity methods and optionally a few embedded
	 * subprocess classes.
	 * 
	 * @param pool		some Pool
	 * @return			Agent Bean file model
	 */
	private AgentBean visitPool(Pool pool) {
		TrafoLog.trace("Visiting Pool '" + pool.getName() + "'");
		//check adHoc
		if (pool.isAdHoc()) {
			TrafoLog.warn(pool.getName() + ": A mapping for AdHoc Processes is not defined. Skipping.");
			return null;
		}
		
		// create AgentBean file model
		currentBean = fac.createAgentBean();
		currentBean.setPackageName(pool.getName().toLowerCase());
		currentBean.setName(pool.getName() + "_" + pool.getParent().getName());
		currentBean.setDocumentation(pool.getDocumentation());
		getWrapper().addAgentBean(currentBean, pool);
		
		// add imports for Data Types
		for (DataType type : pool.getParent().getParent().getDataTypes()) {
			String fullType = type.getPackage() + "." + type.getName();
			currentBean.getImports().add(fullType);
		}
		
		//add variable declarations for pool properties
		for (Property property : pool.getProperties()) {
			currentBean.getVariables().add(createVariable(property));
		}
		
		//create doStart and execute methods
		doStartMethod = createMethod("doStart", createCode("super.doStart();"), "Exception");
		currentBean.getMethods().add(doStartMethod);
		executeMethod = createMethod("execute", createCode("super.execute();"));
		currentBean.getMethods().add(executeMethod);

		// create workflow method
		currentWorkflow = fac.createMethod();
		currentWorkflow.setName("workflow");
		currentWorkflow.setDocumentation("Workflow Method");
		currentBean.getMethods().add(currentWorkflow);
		
		// visit flow objects, thus filling the workflow method with content
		Script content = visitFlowObjects(pool.getGraphicalElements());
		currentWorkflow.setContent(content);
		
		return currentBean;
	}

	/**
	 * Visit each flowObject in the list and wrap them in a Sequence.
	 * This method does ALWAYS return a sequence, which can be empty or singleton
	 * 
	 * @param flowObjects	list of flow objects
	 * @return				sequence element holding mappings
	 */
	private Sequence visitFlowObjects(List<FlowObject> flowObjects){
		Sequence seq = fac.createSequence();
		for (FlowObject flowObject : flowObjects) {
			Script script = visitFlowObject(flowObject);
			if (script != null) {
				seq.getScripts().add(script);
			} else {
				TrafoLog.warn("No mapping for Flow Object " + flowObject);
			}
		}
		return seq;
	}
	
	/**
	 * Pick adequate visitor method for given flow object type. This method will
	 * return NULL, of the given flow object is null, or if it can not be mapped.
	 * 
	 * @param flowObject	some flow object
	 * @return				mapping
	 */
	private Script visitFlowObject(FlowObject flowObject){
		// delegate to specialized methods
		if (flowObject instanceof Event) {
			return visitEvent((Event) flowObject);
		}
		if (flowObject instanceof Activity) {
			return visitActivity((Activity) flowObject);
		}
		if (flowObject instanceof Gateway) {
			return visitGateway((Gateway) flowObject);
		}
		// special structured BPMN elements
		if (flowObject instanceof BpmnSequence) {
			return visitBpmnSequence((BpmnSequence) flowObject);
		}
		if (flowObject instanceof BpmnBlock) {
			return visitBpmnBlock((BpmnBlock) flowObject);
		}
		if (flowObject instanceof BpmnLoopBlock) {
			return visitBpmnLoopBlock((BpmnLoopBlock) flowObject);
		}
		if (flowObject instanceof BpmnEventHandlerBlock) {
			return visitBpmnEventHandlerBlock((BpmnEventHandlerBlock) flowObject);
		}
		if (flowObject instanceof BpmnElementToSkip) {
			return visitBpmnElementToSkip((BpmnElementToSkip) flowObject);
		}
		// implement missing mappings
		if (flowObject instanceof BpmnDerivedProcess) {
			TrafoLog.nyi("Mapping for BpmnDerivedProcess element");
		}
		// unknown or unsupported type or null
		return null;
	}
	
	
	/*
	 * VISITORS FOR BASIC FLOW OBJECT
	 */

	/**
	 * Visit Event. For Events, the mapping is somewhat complicated, e.g. there
	 * are differences w.r.t. whether it is a Start, Intermediate or End Event.
	 * 
	 * @param event		some Event
	 * @return			mapping of the event
	 */
	private Script visitEvent(Event event){
		TrafoLog.trace("Visiting Event '" + event.getName() + "'");
		
		// list holding all the properties relevant to this event
		List<Property> properties= new ArrayList<Property>();

		// name to use for executed flags for this start event
		String executedFlag = "executed_" + event.getNameOrId();
		
		Script mapping = null;
		switch (event.getTrigger()) {
			case NONE: {
				if (event instanceof Start) {
					// if this is not the usual none-start event of a subprocess... 
					if (currentSubProcess == null) {
						// ... run workflow method once when the agent is started
						currentBean.getVariables().add(createVariable("long", executedFlag));
						addToMethod(doStartMethod, createCode(executedFlag + " = 0;"));
						Sequence runWorkflow = createSequence(
								createCode(executedFlag + " = 1;"),
								createCode(currentWorkflow.getName() + "();"));
						IfThenElse ifthenElse = createIfThenElse(executedFlag + " == 0", runWorkflow, null);
						
						// add to execute method
						addToMethod(executeMethod, ifthenElse);
					}
				}
				break;
			}
			case MESSAGE: {
				// CASE 1: MESSAGE CHANNEL IMPLEMENTATION
				if (event.getImplementation() instanceof MessageChannel) {
					MessageChannel messageChannel = (MessageChannel) event.getImplementation();
					Property payload = messageChannel.getPayload();
					String address = messageChannel.getChannel().getExpression();
					
					if (event instanceof Start) {
						String payloadCheck = payload == null ? "" :
								"message.getPayload() instanceof " + payload.getType() + " && ";
						String payloadParam = payload == null ? "" :
								"(" + payload.getType() + ") message.getPayload()";
						// Message Channel Start Event
						// -> create message observer in doStart method 
						String name = "messageObserver_" + Util.toJavaName(event.getId(), false);
						Sequence attachObserver = createSequence(
								createJoin(address),
								createCode("SpaceObserver<IFact> " + name + " = new SpaceObserver<IFact>() {"),
								createCode("	public void notify(SpaceEvent<? extends IFact> event) { "),
								createCode("		if (event instanceof WriteCallEvent) { "),
								createCode("			IJiacMessage message = (IJiacMessage) ((WriteCallEvent<?>) event).getObject();"),
								createCode("			if (" + payloadCheck + "message.getHeader(IJiacMessage.Header.SEND_TO).equalsIgnoreCase(\"" + address + "\")) {"),
								createCode("				memory.remove(message);"),
								createCode("				" + currentWorkflow.getName() + "(message);"),
								createCode("			}"),
								createCode("		}"),
								createCode("	}"),
								createCode("};"),
								createCode("memory.attach(" + name + ", new JiacMessage());"));
						addToMethod(doStartMethod, attachObserver);
						
						// add payload as parameter to workflow method
						if (payload != null) {
							currentWorkflow.getParameters().add(createVariable("IJiacMessage", "__msg"));
						}
						mapping = createSequence(createCode("String __sender = __msg.getSender().getName();"),
								payload != null ? createCode(payload.getType() + " " + payload.getName() + " = (" + 
										payload.getType() + ") __msg.getPayload();") : null);
						
					} else if (event.isThrowing()) {
						// Message Channel throwing Intermediate or End Event
						// -> send message to channel
						properties.add(payload);
						properties.add(messageChannel.getReceiver());
						mapping = createSend(messageChannel);
					} else {
						// Message Channel catching Intermediate Event
						// -> receive message from channel
						properties.add(payload);
						properties.add(messageChannel.getSender());
						mapping = createReceive(messageChannel);
					}
				}
				// CASE 2: SERVICE IMPLEMENTATION
				if (event.getImplementation() instanceof Service) {
					Service service = (Service) event.getImplementation();
					
					if (event instanceof Start) {
						// Service Start Event -> @Expose and Input Parameters
						for (Property property : service.getInput()) {
							currentWorkflow.getParameters().add(createVariable(property));
						}
						//create action to be exposed by the bean
						Action action = fac.createAction();
						action.setVariableName("ACTION_" + currentWorkflow.getName().toUpperCase());
//						action.setActionId(currentBean.getPackageName() + "." + currentBean.getName() + "#" + currentWorkflow.getName());
						action.setActionId(service.getOperation());
						currentBean.getActions().add(action);
						currentWorkflow.setExposedAs(action);
					}
					if (event instanceof End) {
						// Service End Event -> Return Values of Workflow Method
						// assignments are made to local variables ...
						properties.addAll(service.getOutput());
						// ... which are then returned, wrapped in an array
						currentWorkflow.setReturnType("Serializable[]");
						String allOutputs = buildPropertyString(service.getOutput());
						mapping = createCode("return new Serializable[] {" + allOutputs + "};");
					}
					if (event instanceof Intermediate) {
						// Service Intermediate Event -> Service Invocation
						properties.addAll(service.getInput());
						properties.addAll(service.getOutput());
						mapping = createServiceInvocation(service);
					}
				}
				break;
			}
			case TIMER: {
				String timeExpression = event.getTimeExpression().getExpression();
				// Intermediate Event -> suspend execution with Thread.sleep()
				if (event instanceof Intermediate) {
	
					Sequence doSleep = null;
				 	if (event.isAsDuration()) {
						// try to parse Long and sleep
						doSleep = createSequence(
								createCode("long toSleep = Long.parseLong(\"" + timeExpression + "\");"),
								createCode("Thread.sleep(toSleep);"));
					} else {
						// try to parse Date and sleep
						doSleep = createSequence(
								createCode("Date then = new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss.SSSZ\").parse(\"" + timeExpression + "\");"),
								createCode("long toSleep = then.getTime() - System.currentTimeMillis();"),
								createCode("Thread.sleep(toSleep);"));
					}
				 	mapping = createTryInterrupt(doSleep, true);
				}
				// Start Event -> Create time-based process starter in execute()
				if (event instanceof Start) {
					
					Sequence setup = null;
					String condition = null;
					if (event.isAsDuration()) {
						// start process, if now - lastExecuted > timeExpression 
						setup = createSequence(
								createCode("long interval = Long.parseLong(\"" + timeExpression + "\");"),
								createCode("long now  = System.currentTimeMillis();"));
						condition = "now - " + executedFlag + " > interval";
					} else {
						// start process, if lastExecuted == 0 and startTime > now
						setup = createSequence(
								createCode("Date then = new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss.SSSZ\").parse(\"" + timeExpression + "\");"),
								createCode("long startTime = then.getTime();"),
								createCode("long now  = System.currentTimeMillis();"));
						condition = executedFlag + " == 0 && startTime > now";
						
					}
					//add lastExecuted flag
					currentBean.getVariables().add(createVariable("long", executedFlag));
					addToMethod(doStartMethod, createCode(executedFlag + " = System.currentTimeMillis();"));
				
					// check condition and start process
					Sequence runWorkflow = createSequence(
							createCode(executedFlag + " = now;"), 
							createCode(currentWorkflow.getName() + "();"));
					IfThenElse checkAndRun = createIfThenElse(condition, runWorkflow, null);

					// add to execute method
					addToMethod(executeMethod, createSequence(setup, checkAndRun));
				}
				break;
			}
			case RULE: {
				String rule = event.getRuleExpression().getExpression();

				// Start Event -> Check Condition in Execute Method
				if (event instanceof Start) {
					// if flag is 1 and the rule does no longer apply -> reset flag
					IfThenElse resetFlag = createIfThenElse(executedFlag + " != 0 && ! (" + rule + ")",
							createCode(executedFlag + " = 0;"), 
							null);
					// if flag is 0 and rule applies -> start workflow
					IfThenElse checkRule = createIfThenElse(executedFlag + " == 0 && (" + rule + ")", 
											createSequence(
													createCode(executedFlag + " = 1;"),
													createCode(currentWorkflow.getName() + "();")), 
											resetFlag);
					// add lastExecuted flag
					currentBean.getVariables().add(createVariable("long", executedFlag));
					addToMethod(doStartMethod, createCode(executedFlag + " = 0;"));
					// add to execute method
					addToMethod(executeMethod, checkRule);
				}
				// Intermediate Event: suspend workflow while rule is not true
				if (event instanceof Intermediate) {
					mapping = createWhile("! (" + rule + ")", createTryInterrupt(null, true));
				}
				break;
			}
			case ERROR: {
				// throw Exception: use Error Code as class or as message?
				String code = event.getErrorCode() != null ? event.getErrorCode() : "";
				mapping = createCode("throw new Exception(" + code + ");");
				break;
			}
			case TERMINATE: {
				// terminate and remove agent (done by agent node)
				CodeElement cleanup = createCode("thisAgent.cleanup();");
				CodeElement except = createCode("e.printStackTrace();");
				CodeElement remove = createCode("thisAgent.getAgentNode().removeAgent(thisAgent);");
				mapping = createSequence(createTryCatch(cleanup, "Exception", except), remove);
				break;
			}
			case SIGNAL: {
				// TODO Signal: Variable setzen und in Schleife auslesen
			}
			default: {
				TrafoLog.nyi("No Mapping for Event with type " + event.getTrigger().getName() + "; " + event);
			}
		}

		// wrap in sequence with properties and assignments
		mapping = buildSequence(mapping, properties, event.getAssignments(), false);
		
		if (event instanceof Intermediate) {
			// create activity method to keep code cleaner
			String methodName = addActivityMethod(event, mapping);
			return createCode(methodName + "();");
		} else {
			// inline event code into workflow method
			return mapping;
		}
	}
	
	/**
	 * Visit Activity and create the corresponding Java code. Each activity is
	 * mapped to an activity method, which is then invoked in the workflow method.
	 * In the case of a subprocess, an additional subprocess class is created,
	 * holding the actual content of the subprocess in another workflow method.
	 * 
	 * @param activity		Some Activity (Task or Subprocess)
	 * @return				invoke statement, calling the activity method
	 */
	private Script visitActivity(Activity activity){
		TrafoLog.trace("Visiting Activity '" + activity.getName() + "'");

		//checks
		if (activity.getName().equals("__DO_NOTHING__")) {
			return null;
		}
		if (activity.getTransaction() != null) {
			TrafoLog.warn("A mapping for transactions is not defined. Ignoring transaction attributes.");
		}
		if (activity.isAdHoc()) {
			TrafoLog.warn("A mapping for AdHoc activities is not defined. Ignoring AdHoc attributes.");
		}
		
		// create list of all properties (activity, messages, etc.)
		List<Property> properties = new ArrayList<Property>(activity.getProperties());
		
		Script mapping = null;
		switch (activity.getActivityType()) {
			case NONE: {
				// nothing but properties and assignments
				break;
			}
			case SCRIPT: {
				// break script down into lines, aggregate lines to sequence
				String script = activity.getScript();
				if (script != null) {
					String[] lines = script.split("\n");
					Sequence seq = fac.createSequence();
					for (String line : lines) {
						seq.getScripts().add(createCode(line));
					}
					mapping = seq;
				}
				break;
			}
			case SERVICE: {
				// Validation checks that the correct implementation type is used
				// retrieve and invoke JIAC action
				if (activity.getImplementation() instanceof Service) {
					Service service = (Service) activity.getImplementation();
					properties.addAll(service.getInput());
					properties.addAll(service.getOutput());
					mapping = createServiceInvocation(service);
				}
				break;
			}
			// TODO User Task?
			case SEND: {
				// Validation checks that the correct implementation type is used
				// create call to 'send' convenience method
				if (activity.getImplementation() instanceof MessageChannel) {
					MessageChannel channel = (MessageChannel) activity.getImplementation();
					properties.add(channel.getPayload());
					properties.add(channel.getReceiver());
					mapping = createSend(channel);
				}
				break;
			}
			case RECEIVE: {
				// Validation checks that the correct implementation type is used
				// create call to 'receive' convenience method
				if (activity.getImplementation() instanceof MessageChannel) {
					MessageChannel channel = (MessageChannel) activity.getImplementation();
					properties.add(channel.getPayload());
					properties.add(channel.getSender());
					mapping = createReceive(channel);
				}
				break;
			}
			case CALL: {
				if (activity.getCalledElement() instanceof Activity) {
					Activity calledAct = (Activity) activity.getCalledElement();
					mapping = createCode(calledAct.getName() + "();");
				}
				if (activity.getCalledElement() instanceof Pool) {
					TrafoLog.nyi("Call Activity calling another Pool");
				}
				break;
			}
			case EMBEDDED: {
				SubProcess lastSubprocess = currentSubProcess;
	
				// create and add subprocess class
				String className = "Subprocess_" + activity.getName();
				currentSubProcess = fac.createSubProcess();
				currentSubProcess.setName(className);
				currentSubProcess.setDocumentation(activity.getDocumentation());
				for (Property prop : activity.getProperties()) {
					currentSubProcess.getVariables().add(createVariable(prop));
				}
				if (lastSubprocess != null) {
					lastSubprocess.getSubprocesses().add(currentSubProcess);
				} else {
					currentBean.getSubprocesses().add(currentSubProcess);
				}
				
				// create and add workflow() method
				Script content = visitFlowObjects(activity.getContainedFlowObjects());
				content = wrapIntoLoop(activity, content);
				content = buildSequence(content, null, activity.getAssignments(), true);
				currentSubProcess.getMethods().add(0, createMethod("workflow", content));
				
				// create and run subprocess instance
				String variable = "subprocess_" + activity.getName();
				mapping = createSequence(
						createCode(className + " " + variable + " = new " + className + "();"),
						createCode(variable + ".workflow();"));
				
				currentSubProcess = lastSubprocess;
				
				// skip remainder of method, i.e. do not create Activity Method for Subprocess
				return mapping;
			}
			default: {
				TrafoLog.nyi("No Mapping for Activity with type " + activity.getActivityType().getName() + "; " + activity);
			}
		}

		// wrap into sequence with properties and assignments
		mapping = buildSequence(mapping, properties, activity.getAssignments(), true);
		mapping = wrapIntoLoop(activity, mapping);
		
		// build activity method: properties, assignments, mapping, more assignments
		// the actual mapping is the invocation of the activity method
		String methodName = addActivityMethod(activity, mapping);
		return createCode(methodName + "();");
	}
	
	/**
	 * If a gateway is left after structuring the workflow, this is most likely
	 * the gateway merging normal flow with exception flow. Just add a comment.
	 * 
	 * @param g		gateway merging exception flow and normal flow
	 * @return		comment
	 */
	private CodeElement visitGateway(Gateway g){
		return null;
	}
	
	
	/*
	 * VISITORS FOR STRUCTURED BPMN BLOCKS
	 */

	/**
	 * Just call visitFlowObjects for the Sequence's elements
	 * 
	 * @param bpmnSequence	some BPMN sequence
	 * @return				java-sequence
	 */
	private Script visitBpmnSequence(BpmnSequence bpmnSequence) {
		TrafoLog.trace("Visiting BpmnSequence");
		return visitFlowObjects(bpmnSequence.getElements());
	}

	/**
	 * Visit BPMN Block and create the resulting structure to be inserted into
	 * the workflow method.
	 * 
	 * @param block		some BPMN Block
	 * @return			corresponding Java workflow structure
	 */
	private Script visitBpmnBlock(BpmnBlock block){
		TrafoLog.trace("Visiting BpmnBlock");
		Gateway fork = block.getFirstGateway();

		switch (fork.getGatewayType()) {
			case AND: {
				Parallel andPar = fac.createParallel();
				andPar.setBranchPrefix(fork.getNameOrId());
				
				// just put everything in the parallel
				for (BpmnBranch branch : block.getElements()) {
					FlowObject flowObject = branch.getElement();
					Script script= visitFlowObject(flowObject);
					if (script != null) {
						andPar.getBranches().add(script);
					}
				}
				return andPar;
			}
			case OR: {
				Parallel orPar = fac.createParallel();
				orPar.setBranchPrefix(fork.getNameOrId());
				
				// mapping for default element
				String variable = "defaultRequired_" + fork.getId();
				Script defaultScript = visitFlowObject(block.getDefaultElement());
				
				// mapping for regular branches
				for (BpmnBranch branch : block.getElements()) {
					FlowObject flowObject = branch.getElement();
					if (flowObject != block.getDefaultElement()) {
						Sequence seq = createSequence();
						if (defaultScript != null) {
							seq.getScripts().add(createAssign("false", variable, null));
						}
						Script script= visitFlowObject(flowObject);
						if (script != null) {
							seq.getScripts().add(script);
						}
						String condString = Util.getCondition(branch.getCondition());
						orPar.getBranches().add(createIfThenElse(condString, seq, null));
					}
				}
				
				if (defaultScript == null) {
					return orPar;
				} else {
					// create tracking variable in bean scope, because of threads
					currentBean.getVariables().add(createVariable("boolean", variable));
//					addToMethod(doStartMethod, createCode(variable + " = false;"));
					return createSequence(
							createAssign("true", variable, null), 
							orPar, 
							createIfThenElse(variable, defaultScript, null));
				}
			}
			case XOR_DATA: {
				// create a chain of if-else blocks, starting from the 'inside'
				// with the default case and working its way out to the outermost
				// if-else, which then is the mapped element
				Script lastElement = visitFlowObject(block.getDefaultElement());
				for (BpmnBranch branch : block.getElements()) {
					FlowObject flowObject = branch.getElement();
					if (flowObject != block.getDefaultElement()) {
						String condString = Util.getCondition(branch.getCondition());
						Script script = visitFlowObject(flowObject);
						IfThenElse thisElement = createIfThenElse(condString, script, lastElement);
						lastElement = thisElement;
					}
				}
				return lastElement;
			}
			case XOR_EVENT: {
				// similar to mapping of Event Handler Block

				// thread waiting for any of the events to happen
				While waitLoop = createWhile("true", createTryInterrupt(null, true));
				Runner waitThread = fac.createRunner();
				waitThread.setVariableName("thread_wait_" + fork.getNameOrId());
				waitThread.setRunContent(waitLoop);
				
				// creating, starting and stopping the threads, and compensation
				Sequence threads = createSequence(waitThread);
				Sequence starter = createSequence(createCode(waitThread.getVariableName() + ".start();"));
				Sequence stopper = createSequence(createCode(waitThread.getVariableName() + ".join();"));
				Sequence compensation = createSequence();
				
				// Event Handler Cases
				for (BpmnBranch branch : block.getElements()) {

					// wrap branch element in BpmnSequence
					BpmnSequence branchSeq = null;
					if (branch.getElement() instanceof BpmnSequence) {
						branchSeq = (BpmnSequence) branch.getElement();
					} else {
						branchSeq = StrucBpmnFactory.eINSTANCE.createBpmnSequence();
						branchSeq.getElements().add(branch.getElement());
					}
					
					// get first event from Sequence
					Event event = popFirstEvent(branchSeq);
					if (event == null) {
						TrafoLog.error("Event-based XOR-Gateway must be followed by Event!");
						return null;
					}
					
					String[] ret = createEventHandler(event, waitThread.getVariableName());
					String threadName = ret[0], className  = ret[1], parameters = ret[2], impl = ret[3];
					
					// common for all event handler: create starter and stopper
					threads.getScripts().add(createCode("EventHandler " + threadName + " = new " + className + "(" + parameters + ")" + impl + ";"));
					starter.getScripts().add(createCode(threadName + ".start();"));
					stopper.getScripts().add(createCode(threadName + ".stopEventHandler();"));
					
					// create compensation code
					compensation.getScripts().add(createIfThenElse(
							threadName + ".isTriggered()", visitFlowObject(branchSeq), null));
				}
				// assemble sequence: create, start and join threads, do compensation
				TryCatch tryCatch = createTryCatch(
						createSequence(starter, stopper),
						"InterruptedException", createCode(""));
				return createSequence(threads, tryCatch, compensation);
			}
			case COMPLEX: {
				/*
				 * For Complex Gateways created from the Initial Gateway Rule,
				 * a new service will be created for each branch, finally calling
				 * the original service, starting after the block.
				 * Also see buildService for further processing of the services. 
				 */
				if (fork.getName().contains(InitialGatewayRule.INITIAL_GATEWAY)) {
					// memorize current workflow method
					Method mainWorkflow = currentWorkflow;
					
					int counter = 0;
					for (BpmnBranch branch : block.getElements()) {
						// for each branch, create new workflow method
						currentWorkflow = fac.createMethod();
						currentWorkflow.setName("workflow_" + counter);
						currentWorkflow.setDocumentation("Workflow Method (Multiple Start Events)");
						if (currentSubProcess == null) {
							currentBean.getMethods().add(currentWorkflow);
						} else {
							currentSubProcess.getMethods().add(currentWorkflow);
						}
						// the content is the branch, plus invoke to main workflow
						Sequence content = createSequence(
								visitFlowObject(branch.getElement()),
								createCode(mainWorkflow.getName() + "();"));
						currentWorkflow.setContent(content);
						counter++;
					}
					// at the end of these workflow methods, add call to main workflow
					
					// remember original workflow method
					currentWorkflow = mainWorkflow;
					currentWorkflow.setDocumentation("workflow Method (Common Parts)");
					// note that in this case null is returned!
				}
			}
		}
		return null;
	}

	/**
	 * Create Mapping for BPMN Loop Block. The result is a while-loop placed in
	 * the workflow method (as opposed to a while loop to be placed in the
	 * activity method).
	 * 
	 * @param block		BPMN Loop Block
	 * @return			corresponding while loop
	 */
	private Script visitBpmnLoopBlock(BpmnLoopBlock block){
		TrafoLog.trace("Visiting BpmnLoopBlock");
		
		// compose loop condition expression
		String condition = "NO CONDITION GIVEN";
		if (block.getSecondBranch().getCondition() != null) {
			condition = block.getSecondBranch().getCondition().getExpression();
		} else if (block.getExitBranch().getCondition() != null) {
			//use negated exit condition
			condition = "! (" + block.getExitBranch().getCondition().getExpression() + ")";
		}
		
		// assemble loop body
		Sequence loopBody= fac.createSequence();
		loopBody.getScripts().add(createCheckInterrupt());
		Script whilePart= visitFlowObject(block.getSecondBranch().getElement());
		if (whilePart != null) {
			loopBody.getScripts().add(whilePart);
		}
		Script untilPart= visitFlowObject(block.getFirstBranch().getElement());
		if (untilPart != null) {
			loopBody.getScripts().add(untilPart);
		}

		// only the loop, or extra call to the until part before the loop?
		While loop = createWhile(condition, loopBody);
		if (untilPart == null) {
			return loop;
		} else {
			return createSequence((Script) EcoreUtil.copy(untilPart), loop);
		}
	}

	/**
	 * Create Java code for Event Handler. The basic principle is always the same:
	 * The event Handler is realized as a thread (defined in the Abstract Workflow
	 * Agent Bean)
	 * 
	 * @param block		some BPMN Event Handler Block
	 * @return			corresponding Java code (some Threads)
	 */
	private Script visitBpmnEventHandlerBlock(BpmnEventHandlerBlock block){
		// thread running the actual activity method or subprocess
		Runner mainThread = fac.createRunner();
		mainThread.setVariableName("thread_" + block.getActivity().getName());
		mainThread.setRunContent(visitActivity(block.getActivity()));
		
		// creating, starting and stopping the threads, and compensation
		Sequence threads = createSequence(mainThread);
		Sequence starter = createSequence(createCode(mainThread.getVariableName() + ".start();"));
		Sequence stopper = createSequence(createCode(mainThread.getVariableName() + ".join();"));
		Sequence compensation = createSequence();
		
		// Event Handler Cases
		for (BpmnEventHandlerCase ehCase : block.getEventHandlerCases()) {
			Event event = ehCase.getIntermediate();
			
			if (event.getTrigger() == TriggerType.ERROR) {
				// error event is special: wrap main threads content into another try-catch
				Script activityScript = mainThread.getRunContent();
				String exception = event.getErrorCode() != null ?
						event.getErrorCode() : "Exception";
				
				// add tracking variable for element to skip
				String variable = "errorFlag_" + event.getNameOrId();
				currentBean.getVariables().add(createVariable("boolean", variable));
//				addToMethod(doStartMethod, createCode(variable + " = false;"));

				// create new content for main thread
				Script compensate = createSequence(
						visitFlowObject(ehCase.getCompensationElement()),
						createAssign("true", variable, null));
				mainThread.setRunContent(createSequence(createCode(variable + " = false;"), 
						createTryCatch(activityScript, exception, compensate)));

			} else {
				// non-error event handlers are implemented as threads
				String[] ret = createEventHandler(event, mainThread.getVariableName());
				String threadName = ret[0], className  = ret[1], parameters = ret[2], impl = ret[3];
				
				// common for all event handler: create starter and stopper
				threads.getScripts().add(createCode("EventHandler " + threadName + " = new " + className + "(" + parameters + ")" + impl + ";"));
				starter.getScripts().add(createCode(threadName + ".start();"));
				stopper.getScripts().add(createCode(threadName + ".stopEventHandler();"));
				// TODO das ganze starten und stoppen der threads in hilfsmethode auslagern?
				
				// create compensation code
				Script script = visitFlowObject(ehCase.getCompensationElement());
				if (script != null) {
					compensation.getScripts().add(createIfThenElse(threadName + ".isTriggered()", script, null));
				}
				// TODO assign message payloads to variables!
			}
		}
		
		// check whether threads are needed (not the case if only error event)
		if (threads.getScripts().size() == 1) {
			return mainThread.getRunContent();
		} else {
			// assemble sequence: create, start and join threads, do compensation
			TryCatch tryCatch = createTryCatch(
					createSequence(starter, stopper),
					"InterruptedException", createCode(""));
			return createSequence(threads, tryCatch, compensation);
		}
	}
	
	/**
	 * Visit Element To Skip, resulting in a if-else, checking whether the
	 * respective thread has been triggered.
	 * 
	 * @param block		some Element-to-Skip block
	 * @return			if-else, checking whether the element is to be skipped
	 */
	private Script visitBpmnElementToSkip(BpmnElementToSkip block){
		Script toSkip = visitFlowObject(block.getElement());
		Event event = block.getEventHandlerCase().getIntermediate();
		
		String condition = "false";
		if (event.getTrigger() == TriggerType.ERROR) {
			condition = "! errorFlag_" + event.getNameOrId();
		} else {
			String threadName = "thread_" + event.getNameOrId();
			if (event.getTrigger() == TriggerType.TIMER) {
				threadName += event.isAsDuration() ? "_timeout" : "_time";
			}
			if (event.getTrigger() == TriggerType.MESSAGE) {
				threadName += "_message";
			}
			condition = "! " + threadName + ".isTriggered()";
		}
		return createIfThenElse(condition, toSkip, null);
	}

	
	/*
	 * ASSEMBLY OF ACTIVITY METHODS AND RELATED STUFF
	 */
	
	/**
	 * Builds a sequence holding variable declarations, start time assignments, 
	 * a script, and end time assignments.
	 * 
	 * @param script		already mapped script, the main part of the sequence
	 * @param properties	List of BPMN properties to be mapped to variable declarations
	 * @param assignments	List of BPMN assignments to be mapped to assigns
	 * @param comments		print comments separating the sections
	 */
	private Sequence buildSequence(Script script, List<Property> properties, List<Assignment> assignments, boolean comments) {
		Sequence seq= fac.createSequence();
		//Properties
		if (properties != null && ! properties.isEmpty()) {
			if (comments) {
				seq.getScripts().add(createComment("Properties"));
			}
			for (Property property : properties) {
				if (property != null) {
					seq.getScripts().add(createCode(property.getType() + " " + property.getName() + " = null;"));
				}
			}
		}
		//Start Assignments
		List<CodeElement> startAss = createAssigns(assignments, AssignTimeType.START);
		if (comments && ! startAss.isEmpty()) {
			seq.getScripts().add(createComment("Start Assignments"));
		}
		seq.getScripts().addAll(startAss);
		//Body
		if (script != null) {
			if (comments) {
				seq.getScripts().add(createComment("Body"));
			}
			seq.getScripts().add(script);	
		}
		//End Assignments
		List<CodeElement> endAss = createAssigns(assignments, AssignTimeType.END);
		if (comments && ! endAss.isEmpty()) {
			seq.getScripts().add(createComment("End Assignments"));
		}
		seq.getScripts().addAll(endAss);
		return seq;
	}
	
	/**
	 * Create Activity Method with given content and add it to the current
	 * subprocess or directly to the agent bean.
	 * 
	 * @param methodName	name of the activity method to be created
	 * @param script		already mapped script for the actual activity
	 */
	private String addActivityMethod(FlowObject flowObject, Script body) {
		Method method = createMethod(flowObject.getNameOrId(),
				createSequence(createCheckInterrupt(), body));
		method.setVisibility("protected");
		method.setDocumentation(flowObject.getDocumentation());
		if (currentSubProcess != null) {
			currentSubProcess.getMethods().add(method);
		} else {
			currentBean.getMethods().add(method);
		}
		return method.getName();
	}
	
	/**
	 * Add Script to an Existing Method
	 * 
	 * @param method	some existing method
	 * @param script	new script to be added to that method
	 */
	private void addToMethod(Method method, Script script) {
		Script existing = method.getContent();
		if (existing == null) {
			method.setContent(script);
		} else {
			method.setContent(createSequence(existing, script));
		}
	}
	
	
	/*
	 * HELPER METHODS FOR ACTIVITY LOOPING
	 * 
	 * for loops created by upstream connections, see the respective BPMN block
	 */
	
	/**
	 * Wrap Activity mapping into loop, if applicable.
	 */
	private Script wrapIntoLoop(Activity activity, Script mapping) {
		if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
			mapping = createStandardLoop(activity, mapping);
		}
		if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
			mapping = createMultiInstanceLoop(activity, mapping);
		}
		return mapping;
	}
	
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
	 * @param activity		the original activity holding the loop attributes
	 * @param script		the activity's mapping to be embedded in the loop
	 * @return				sequence with MI loop
	 */
	private Script createMultiInstanceLoop(Activity activity, Script script) {
		TrafoLog.nyi("Mapping for Multi Instance Loop");
		return script;
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
	private Script createLoopSequence(FlowObject activity, Script script, String condition, int maximum, boolean testBefore) {
		// loop counter needed?
		boolean useLoopCounter = maximum > 0 || ! testBefore;
		String counter= activity.getName().toLowerCase() + "_loopCounter";

		// build and parse loop expression
		String cond = condition == null ? "true" : condition;
		// append additional condition for loop maximum
		if (maximum > 0) {
			cond = "(" + cond + ") && (" + counter + " < " + maximum + ")";
		}
		// for testTime==after: check if loop counter is zero
		if (! testBefore && condition != null) {
			cond = "(" + condition + ") || (" + counter + " == 0)";
		}

		// create loop body holding the mapped activity and the increment for the loop counter
		Sequence innerSeq= fac.createSequence();
		innerSeq.getScripts().add(createCheckInterrupt());
		if (script != null) {
			innerSeq.getScripts().add(script);
		}
		if (useLoopCounter) {
			innerSeq.getScripts().add(createAssign(counter + " + 1", counter, null));
		}

		// assemble the whole loop structure, including loop counter, until-part, etc.
		if (useLoopCounter) {
			return createSequence(
					createCode("int " + counter + " = 0;"), 
					createWhile(cond, innerSeq));
		} else {
			return createWhile(cond, innerSeq);
		}
	}
	
	
	/*
	 * MORE COMPLEX CREATION HELPER METHODS
	 */
	
	/**
	 * Pop and return the First Event in the given BPMN Sequence. If the Sequence
	 * is null or empty, or the first element is not an event, return null.
	 */
	private Event popFirstEvent(BpmnSequence sequence) {
		// failure case: Sequence is null or empty
		if (sequence == null || sequence.getElements().isEmpty()) {
			return null;
		}
		FlowObject first = sequence.getElements().get(0);
		// happy case: first element is event
		if (first instanceof Event) {
			return (Event) sequence.getElements().remove(0);
		}
		// recursion case: first element is embedded sequence
		if (first instanceof BpmnSequence) {
			return popFirstEvent((BpmnSequence) first);
		}
		// failure case: first element is something else
		return null;
	}

	/**
	 * Build a comma-separated string of properties, for method invocations
	 */
	private String buildPropertyString(List<Property> properties) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < properties.size(); i++) {
			if (i > 0) {
				buffer.append(", ");
			}
			buffer.append(properties.get(i).getName());
		}
		return buffer.toString();
	}
	
	/**
	 * Create a new code element for the given assignment.
	 * 
	 * @param from			the from-expression
	 * @param toVarName		the name of the variable name to bind the expression to
	 * @param toQuery		an optional query (i.e. property or array index) or null
	 */
	private CodeElement createAssign(String from, String toVarName, String toQuery) {
		String code = toVarName;
		if (toQuery != null) {
			// try to parse as array index, if this fails interpret as complex property
			try {
				int index= Integer.parseInt(toQuery);
				code += "[" + index + "]";
			} catch (NumberFormatException e) {
				code += "." + toQuery;
			}
		}
		code += " = " + from + ";";
		CodeElement assign= fac.createCodeElement();
		assign.setCode(code);
		return assign;
	}
	
	/**
	 * Visit many assignments and return them as a list
	 * 
	 * @param assignments	the BPMN assignments
	 * @param assignTime	assign time to regard, or null to regard all assign times 
	 * @return
	 */
	private List<CodeElement> createAssigns(List<Assignment> assignments, AssignTimeType assignTime) {
		List<CodeElement> assigns = new ArrayList<CodeElement>();
		if (assignments != null) {
			for (Assignment ass : assignments) {
				if (assignTime == null || ass.getAssignTime() == assignTime) {
					CodeElement assign = createAssign(ass.getFrom().getExpression(), 
							ass.getTo().getName(), ass.getToQuery());
					assigns.add(assign);
				}
			}
		}
		return assigns;
	}
	
	/**
	 * Create the rather complex sequence used for a Service or Action invocation.
	 * This includes adding the action provider to imports, retrieving the action,
	 * invoking the actions, handling invocation errors and assigning the results.
	 * 
	 * This is used for both, Service Intermediate Events and Service Tasks.
	 * 
	 * @param service	some Service Implementation
	 * @return			sequence for invoking the corresponding JIAC action
	 */
	private Sequence createServiceInvocation(Service service) {
		// collect code elements
		CodeElement retrieveAction = createCode("IActionDescription action = thisAgent.searchAction(" +
				"new Action(\"" + service.getOperation() + "\"));");
		CodeElement throwException = createCode("throw new RuntimeException(\"Action " + service.getOperation() + " not found!\");");
		IfThenElse checkAction = createIfThenElse("action == null", throwException, null);
		CodeElement invokeAction = createCode("ActionResult actionResult = invokeAndWaitForResult(action, new Serializable[] {" + 
				buildPropertyString(service.getInput()) + "});");

		// error handling
		String resultCheck = "actionResult.getFailure() == null";
		CodeElement notifyError = createCode("log.error(\"Action " + service.getOperation() + " failed: \" + actionResult.getFailure());");

		// assign the results to the respective variables
		Sequence resultAssigns = createSequence(createCode("Serializable[] results = (Serializable[]) actionResult.getResults()[0];"));
		for (int i = 0; i < service.getOutput().size(); i++) {
			Property property = service.getOutput().get(i);
			resultAssigns.getScripts().add(createCode(
					property.getName()+ " = (" + property.getType() + ") results[" + i + "];"));
		}
		IfThenElse resultHandling = createIfThenElse(resultCheck, resultAssigns, notifyError);
		
		// put it all together
		return createSequence(retrieveAction, checkAction, invokeAction, resultHandling);
	}
	
	/**
	 * Create code element for joining message group
	 * 
	 * @param groupname		the name of the group
	 * @return				call to convenience-method 'join'
	 */
	private CodeElement createJoin(String groupname) {
		return createCode("join(\"" + groupname+ "\");");
	}
	
	/**
	 * Creates a invoke to send action for the given message
	 * 
	 * @param channel		the message to be sent
	 * @return send 		code sequence containing the invocation of 
	 * 						ICommunicationBean.sendAction()
	 */
	private CodeElement createSend(MessageChannel channel) {
		String payload = channel.getPayload() != null ?
				channel.getPayload().getName() : "null";
		String address = channel.isMessageGroup() ? 
				"\"" + channel.getChannel().getExpression() + "\"" : "__receiver";
		boolean isGroup = channel.isMessageGroup();
		return createCode("send(" + payload + ", " + address + ", " + isGroup + ");");
	}
	
	/**
	 * create receive-sequence:
	 * see also jiacbeans.impl.RecieveImpl
	 * 
	 * @param message		the channel from where to receive
	 * @param participant	to whom the message is directed (e.g. a group)
	 * @return				Receive element
	 */
	private Sequence createReceive(MessageChannel channel) {
		//join message group
		addToMethod(doStartMethod, createJoin(channel.getChannel().getExpression()));
		String address = channel.isMessageGroup() ? 
				channel.getChannel().getExpression() : "null";
		Property payload = channel.getPayload();
		String clazz = channel.getPayload() != null ?
				channel.getPayload().getType() + ".class" : "null";
		return createSequence(
				createCode("IJiacMessage __msg = receiveMessage(" + clazz + ", \"" + address + "\", -1);"),
				createCode("__sender = __msg.getSender().getName();"),
				payload != null ? createCode(payload.getName() + " = (" + payload.getType() + ") __msg.getPayload();") : null);
	}
	
	/**
	 * Create Event Handler Threads, to be used for Event Handler Block as well
	 * as for Event-based XOR-Gateway.
	 * 
	 * @param event				some intermediate event
	 * @param mainThreadName	name of the main thread (for stopping)
	 * @return					name, class and parameters of the event handler thread
	 */
	private String[] createEventHandler(Event event, String mainThreadName) {
		// non-error event handlers are implemented as threads
		String threadName = "thread_" + event.getNameOrId();
		String className = "EventHandler";
		String parameters = mainThreadName;
		String implementation = "";
		
		// Timer Event (Duration and Date Time)
		if (event.getTrigger() == TriggerType.TIMER) {
			if (event.isAsDuration()) {
				threadName = threadName + "_timeout";
				className  = "Timeout" + className;
			} else {
				threadName = threadName +  "_time";
				className  = "Time" + className;
			}
			parameters = parameters + ", " + event.getTimeExpression().getExpression();
		}
		
		// Message Event (Message Channel)
		if (event.getTrigger() == TriggerType.MESSAGE) {
			if (event.getImplementation() instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) event.getImplementation();
				String address = channel.getChannel().getExpression();
				String payloadType = channel.getPayload() != null ?
						channel.getPayload().getType() + ".class" : "null";

				threadName = threadName + "_message";
				className  = "Message" + className;
				parameters = parameters + ", \"" + address + "\", " + payloadType;
			}
		}
		
		// Rule Event
		if (event.getTrigger() == TriggerType.RULE) {
			String rule = event.getRuleExpression() != null ? event.getRuleExpression().getExpression() : "null";
			threadName = threadName + "_rule";
			className = "Rule" + className;
			implementation = " { public boolean checkRule() {return " + rule +  ";}}";
		}
		
		return new String[] {threadName, className, parameters, implementation};
	}
	
	private CodeElement createCheckInterrupt() {
		// do this as a one liner to not obstruct the code too much
		return createCode("if (checkInterrupted()) return;");
	}

	private TryCatch createTryInterrupt(Script script, boolean doReturn) {
		if (script == null) {
			script = createCode("Thread.sleep(500);");
		}
		Script interrupt = createCode("Thread.currentThread().interrupt();");
		if (doReturn) {
			interrupt = createSequence(interrupt, createCode("return;"));
		}
		return createTryCatch(script, "InterruptedException", interrupt);
	}
	
	
	
	/*
	 * SIMPLE, SIDE-EFFECT FREE ELEMENT CREATION HELPER METHODS
	 */
	
	private CodeElement createCode(String code){
		CodeElement codeElem = fac.createCodeElement();
		codeElem.setCode(code);
		return codeElem;
	}
	
	private Variable createVariable(String type, String name) {
		Variable var = fac.createVariable();
		var.setName(name);
		var.setType(type);
		return var;
	}
	
	private Variable createVariable(Property property) {
		return createVariable(property.getType(), property.getName());
	}

	private CodeElement createComment(String msg) {
		CodeElement comment = fac.createCodeElement();
		comment.setCode("// " + msg);
		return comment;
	}
	
	private Sequence createSequence(Script... scripts) {
		Sequence seq = fac.createSequence();
		for (Script script: scripts) {
			if (script != null) {
				seq.getScripts().add(script);
			}
		}
		return seq;
	}
	
	private IfThenElse createIfThenElse(String condition, Script thenCase, Script elseCase) {
		IfThenElse ifThenElse= fac.createIfThenElse();
		ifThenElse.setCondition(condition);
		ifThenElse.setThenBranch(thenCase);
		ifThenElse.setElseBranch(elseCase);
		return ifThenElse;
	}
	
	private TryCatch createTryCatch(Script tryScript, String exception, Script catchScript) {
		TryCatch tryCatch = fac.createTryCatch();
		tryCatch.setTry(tryScript);
		tryCatch.getCatches().put(exception, catchScript);
		return tryCatch;
	}
	
	private While createWhile(String condition, Script body) {
		While loop = fac.createWhile();
		loop.setCondition(condition);
		loop.setContent(body);
		return loop;
	}
	
	private Method createMethod(String name, Script content, String... exceptions) {
		Method method = fac.createMethod();
		method.setName(name);
		method.setContent(content);
		for (String exception : exceptions) {
			method.getThrows().add(exception);
		}
		return method;
	}
	
}
