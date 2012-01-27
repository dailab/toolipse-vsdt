package de.dailab.vsdt.trafo.jiacbeans.export;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.util.EcoreUtil;

import jiacbeans.Action;
import jiacbeans.ActivityMethod;
import jiacbeans.AgentBean;
import jiacbeans.CodeElement;
import jiacbeans.IfThenElse;
import jiacbeans.JavaVariable;
import jiacbeans.JiacbeansFactory;
import jiacbeans.Method;
import jiacbeans.Paralel;
import jiacbeans.Recieve;
import jiacbeans.Runnable;
import jiacbeans.Script;
import jiacbeans.Send;
import jiacbeans.Sequence;
import jiacbeans.SubProcess;
import jiacbeans.TryCatch;
import jiacbeans.Wait;
import jiacbeans.While;
import jiacbeans.WorkflowMethod;
import jiacbeans.impl.MethodImpl;
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
import de.dailab.vsdt.trafo.jiacbeans.util.Util;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;

/**
 * BPMN to JIAC AgentBeans visitor. This visitor is performing a top-down pass of 
 * the BPMN model. This way it creates the element mapping for all the elements 
 * passed on the way.
 * 
 * edited by kuester
 * 
 * @author pstan
 */
public class Bpmn2JiacBeansElementMappingTK extends BpmnElementMapping {
	
	final JiacbeansFactory beansFac = JiacbeansFactory.eINSTANCE;
	
	String _currentService;
	WorkflowMethod _currentWorkflow;
	Method _doStart;
	Method _execute;
	AgentBean _currentBean;
	SubProcess _currentSubProcess;
	
	@Override
	public void initialize() {
		expressionVisitor = new JiacBeansExpressionVisitor(true, true);
	}
	
	public JiacBeansExportWrapper getWrapper(){
		return (JiacBeansExportWrapper)super.wrapper;
	}
	
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
		_currentService = bpd.getName();
		// visit Pools 
		for (Pool pool : bpd.getPools()) {
			visitPool(pool);
		}
	}
	
	private AgentBean visitPool(Pool pool) {
		TrafoLog.trace("Visiting Pool '" + pool.getName() + "'");
		//check adHoc
		if (pool.isAdHoc()) {
			TrafoLog.warn(pool.getName() + ": A mapping for AdHoc Processes is not defined. Skipping.");
			return null;
		}
		// create AgentBean file model and map it to the Pool
		AgentBean bean = beansFac.createAgentBean();
		_currentBean= bean;
		//group the beans with the same pool name in a package
		_currentBean.setPackageName(pool.getName().toLowerCase());
		_currentBean.setName(pool.getName()+"_"+_currentService);
		getWrapper().addAgentBean(bean, pool);
		// add imports for all Data Types
		for (DataType dataType : pool.getParent().getParent().getDataTypes()) {
			String clazz = dataType.getPackage() + "." + dataType.getName();
			bean.getImports().add(clazz);
		}
		WorkflowMethod workflow = beansFac.createWorkflowMethod();
		workflow.setName(Util.toJavaName(pool.getParent().getName()));
		workflow.setVisibility(MethodImpl.PUBLIC);
		_currentWorkflow = workflow;
		_currentBean.addMethod(workflow);
		//create doStart and execute, but don't attach them to the bean yet
		_doStart = beansFac.createMethod();
		_doStart.setName("doStart");
		_doStart.setVisibility(MethodImpl.PUBLIC);
		_execute = beansFac.createMethod();
		_execute.setName("execute");
		_execute.setVisibility(MethodImpl.PUBLIC);
		//create action to be exposed by the bean
		Action action = beansFac.createAction();
		action.setName("ACTION_"+_currentService.toUpperCase());
		action.setLocation(_currentBean.getPackageName()+"."+_currentBean.getName()+"#"+Util.toJavaName(_currentService));
		_currentBean.getActions().add(action);
		//add a variable declaration for every pool property
		for(Property prop : pool.getProperties()){
			if (prop.getType().contains(".")) {
				_currentBean.getImports().add(prop.getType());
			}
			JavaVariable var = createVariable(Util.getType(prop), Util.toJavaName(prop.getName()));
			_currentBean.getAttributes().add(var);
		}
		writeWorkflowSequence(pool, workflow, pool.getGraphicalElements());
		return _currentBean;
	}
	
	private void writeWorkflowSequence(Pool pool, WorkflowMethod workflow, List<FlowObject> flowObjects){
		Sequence seq = beansFac.createSequence();
		workflow.setContent(seq);
		
		for (FlowObject obj : flowObjects) {
			Script mapping = visitFlowObject(obj);
			if(mapping!=null)seq.getScripts().add(mapping);
		}
	}
	
	private Script visitFlowObject(FlowObject flowObject){
		Script script = beansFac.createCodeElement();
		if(flowObject==null)return script;
		//delegate to specialized methods
		System.out.println(flowObject.getClass());
		if (flowObject instanceof Event) {
			Event event= (Event) flowObject;
			return visitEvent(event, null);
		}
		if (flowObject instanceof Activity) {
			Activity act = (Activity)flowObject;
			return visitActivity(act);
		}
		if (flowObject instanceof Gateway) {
			Gateway gateway= (Gateway) flowObject;
			return visitGateway(gateway);
		}
		//special structured BPMN elements
		if (flowObject instanceof BpmnSequence) {
			BpmnSequence bpmnSequence = (BpmnSequence) flowObject;
			return visitBpmnSequence(bpmnSequence);
		}
		if (flowObject instanceof BpmnBlock) {
			BpmnBlock bpmnBlock = (BpmnBlock) flowObject;
			return visitBpmnBlock(bpmnBlock);
		}
		if (flowObject instanceof BpmnLoopBlock) {
			BpmnLoopBlock bpmnLoopBlock = (BpmnLoopBlock) flowObject;
			return visitBpmnLoopBlock(bpmnLoopBlock);
		}
		if (flowObject instanceof BpmnEventHandlerBlock) {
			BpmnEventHandlerBlock eventHandlerBlock = (BpmnEventHandlerBlock) flowObject;
			return visitBpmnEventHandlerBlock(eventHandlerBlock);
		}
		if (flowObject instanceof BpmnElementToSkip) {
			BpmnElementToSkip bpmnElementToSkip = (BpmnElementToSkip) flowObject;
			return visitBpmnElementToSkip(bpmnElementToSkip);
		}
		
		// TODO implement missing mappings
		if (flowObject instanceof BpmnDerivedProcess) {
			TrafoLog.nyi("Mapping for BpmnDerivedProcess element");
//			BpmnDerivedProcess bpmnDerivedProcess = (BpmnDerivedProcess) flowObject;
//			script= visitBpmnDerivedProcess(bpmnDerivedProcess);
		}
		return script;
	}
	
	private Script visitBpmnEventHandlerBlock(BpmnEventHandlerBlock block){
		Sequence mapping = beansFac.createSequence();
		List<Script> starter = new ArrayList<Script>();
		List<Script> stopper = new ArrayList<Script>();

		// Create Subprocess for Activity
		String activityName = Util.toJavaName(block.getActivity().getName());
		Script runScript = visitActivity(block.getActivity());
		Runnable sp = beansFac.createRunnable();
		sp.setName(activityName);
		sp.setRunContent(runScript);
		mapping.getScripts().add(sp);
		starter.add(createCode(activityName+".start();"));
		stopper.add(createCode(activityName+".join();"));
		Sequence compensation = beansFac.createSequence();
		
		// Event Handler Cases
		List<BpmnEventHandlerCase> cases = block.getEventHandlerCases();
		for (BpmnEventHandlerCase c : cases) {
			Event e = c.getIntermediate();
			String eName = Util.toJavaName(e.getNameOrId());
			switch (c.getIntermediate().getTrigger()) {
			case TIMER:
				// TODO vereinheitlichen
				if (e.isAsDuration()) {
					eName += "_TimeoutHandler";
					_currentBean.setHandlingTimeoutEvent(true);

					mapping.getScripts().add(createCode("TimeoutEventHandler " + eName + " = new TimeoutEventHandler(" + e.getTimeExpression().getExpression() + "," + activityName + ");"));
					starter.add(createCode(eName + ".start();"));
					stopper.add(createCode(eName + ".stop();"));
					
					Script script = visitFlowObject(c.getCompensationElement());
					if (script != null && ! script.toJavaCode().isEmpty()){
						compensation.getScripts().add(createIfThenElse(eName + ".hasBeenTriggered()", script, null));
					}
				} else {
					eName += "_TimeHandler";
					_currentBean.setHandlingTimeEvent(true);
					_currentBean.getImports().add("java.text.*");
					_currentBean.getImports().add("java.util.Date");

					mapping.getScripts().add(createCode("TimeEventHandler " + eName + " = new TimeEventHandler(\"" + e.getTimeExpression().getExpression() + "\"," + activityName + ");"));
					starter.add(createCode(eName + ".start();"));
					stopper.add(createCode(eName + ".stop();"));

					Script script = visitFlowObject(c.getCompensationElement());
					if(script!=null && !script.toJavaCode().isEmpty()){
						compensation.getScripts().add(createIfThenElse(eName + ".hasBeenTriggered()", script, null));
					}
				}
				break;
			case MESSAGE:
				if(e.getImplementation() instanceof MessageChannel){
					eName += "_MessageHandler";
					_currentBean.getImports().add("de.dailab.jiactng.agentcore.action.Action");
					_currentBean.getImports().add("java.io.Serializable");
					_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.CommunicationAddressFactory");
					_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.IGroupAddress");
					_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.ICommunicationBean");
					_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.message.IJiacMessage");
					_currentBean.getImports().add("de.dailab.jiactng.agentcore.knowledge.IFact");
					_currentBean.getImports().add("org.sercho.masp.space.event.SpaceEvent");
					_currentBean.getImports().add("org.sercho.masp.space.event.SpaceObserver");
					_currentBean.getImports().add("org.sercho.masp.space.event.WriteCallEvent");
					_currentBean.setHandlingMessageEvent(true);

					MessageChannel channel = (MessageChannel)e.getImplementation();
					String address = channel.getChannel().getExpression();
					String payloadType = channel.getPayload().getType();
					if (payloadType.contains("."))
						_currentBean.getImports().add(payloadType);
					payloadType = Util.getType(channel.getPayload());
					
					mapping.getScripts().add(createCode("MessageEventHandler " + eName + " = new MessageEventHandler(\"" + address + "\",\"" + payloadType + "\"," + activityName + ");"));
					starter.add(createCode(eName + ".start();"));
					stopper.add(createCode(eName + ".doStop();"));
					
					Script script = visitFlowObject(c.getCompensationElement());
					if (script != null && ! script.toJavaCode().isEmpty()) {
						compensation.getScripts().add(createIfThenElse(eName + ".hasBeenTriggered()", script, null));
					}
				}
				break;
			case ERROR:
				String flagName = Util.toJavaName(e.getNameOrId())+"_ErrorFlag";
				JavaVariable flag = createVariable("boolean", flagName);
				_currentBean.getAttributes().add(flag);
				//wrap runContent in try catch block
				TryCatch tc = createTryCatch(runScript, "Exception", 
						createCode(flagName+" = true; //triggered, set flag to true"));
				sp.setRunContent(tc);
				Script script = visitFlowObject(c.getCompensationElement());
				if (script != null && ! script.toJavaCode().isEmpty()) {
					IfThenElse compensate = createIfThenElse(eName, script, null);
					compensation.getScripts().add(compensate);
				}
				break;
			}
		}
		// start and join subprocess, wrapped in try-catch block
		Sequence trySeq = beansFac.createSequence();
		trySeq.getScripts().addAll(starter);
		trySeq.getScripts().addAll(stopper);
		
		mapping.getScripts().add(createTryCatch(trySeq, "InterruptedException", createCode("")));
		mapping.getScripts().add(compensation);
		return mapping;
	}
	
	/**
	 * 
	 * @param block
	 * @return
	 */
	private Script visitBpmnElementToSkip(BpmnElementToSkip block){
		Script toSkip = visitFlowObject(block.getElement());
		String condition = "false";
		Event e = block.getEventHandlerCase().getIntermediate();
		String eName = Util.toJavaName(e.getNameOrId());
		switch (e.getTrigger()) {
		case TIMER:
			String postFix = "_TimeHandler";
			if (e.isAsDuration())
				postFix = "_TimeoutHandler";
			condition = "!" + eName + postFix + ".hasBeenTriggered()";
			break;
		case ERROR:
			condition = "!" + eName + "_ErrorFlag";
			break;
		case MESSAGE:
			condition = "!" + eName + "_MessageHandler.hasBeenTriggered()";
			break;
		default:
			break;
		}
		return createIfThenElse(condition, toSkip, null);
	}
	
	/**
	 * 
	 * @param block
	 * @return
	 */
	private Script visitBpmnBlock(BpmnBlock block){
		TrafoLog.trace("Visiting BpmnBlock");
		Gateway fork = block.getFirstGateway();
		Script mapping = null;

		switch (fork.getGatewayType()) {
			case AND:
				List<Script> scripts= new ArrayList<Script>();
				for (BpmnBranch branch : block.getElements()) {
					FlowObject flowObject = branch.getElement();
					Script script= visitFlowObject(flowObject);
					if (script != null) {
						scripts.add(script);
					}
				}
				mapping= wrapInPar(scripts,Util.toJavaName(fork.getNameOrId()));
				break;
			case OR:
				boolean hasDefault= block.getDefaultElement() != null;
				String varName= fork.getId() + "_defaultRequired";
				scripts= new ArrayList<Script>();
				for (BpmnBranch branch : block.getElements()) {
					FlowObject flowObject = branch.getElement();
					if (block.getDefaultElement() == flowObject) {
						continue;
					}
					Script script= visitFlowObject(flowObject);
					if (hasDefault) {
						// add assign to the tracking variable to the script
						Sequence seq = beansFac.createSequence();
						if (script != null)
							seq.getScripts().add(script);
						seq.getScripts().add(createAssign("false", varName, null));
						script= seq;
					}
					String condString= getCondition(branch.getCondition());
					scripts.add(createIfThenElse(condString, script, null));
				}
				Script par= wrapInPar(scripts,Util.toJavaName(fork.getNameOrId()));
				if (hasDefault) {
					// create tracking variable
					JavaVariable var = createVariable("boolean", varName);
					//add the tracking variable to the bean, otherwise it will not be visible in the thread
					_currentBean.getAttributes().add(var);
					CodeElement assign= createAssign("true", varName, null);
					// create default case
					FlowObject flowObject= block.getDefaultElement();
					Script script= visitFlowObject(flowObject);
					IfThenElse ifThenElse= createIfThenElse(varName, script, null);
					// return sequence holding the par and the other stuff
					mapping= createSequence(assign, par, ifThenElse);
				} else {
					// return the par
					mapping= par;
				}
				break;
			case XOR_DATA:
				// create a chain of if-else blocks, starting from the 'inside' with the default case
				// and working its way out to the outermost if-else, which then is the mapped element
				Script lastElement= null;
				if (block.getDefaultElement() != null) {
					lastElement= visitFlowObject(block.getDefaultElement());
				}
				for (BpmnBranch branch : block.getElements()) {
					FlowObject flowObject = branch.getElement();
					if (block.getDefaultElement() == flowObject) {
						continue;
					}
					String condString= getCondition(branch.getCondition());
					Script script= visitFlowObject(flowObject);
					IfThenElse thisElement= createIfThenElse(condString, script, lastElement);
					lastElement= thisElement;
				}
				mapping= lastElement;
				break;
			case XOR_EVENT:
				Wait waitThread = beansFac.createWait();
				waitThread.setName(fork.getNameOrId()+"_wait_thread");
				Sequence seq = beansFac.createSequence();
				seq.getScripts().add(waitThread);
				List<Script> starter = new ArrayList<Script>();
				List<Script> stopper = new ArrayList<Script>();
				starter.add(createCode(fork.getNameOrId() + "_wait_thread"));
				for (BpmnBranch branch : block.getElements()) {
//					XOR_E
//					FlowObject flowObject = branch.getElement();
//
//					// parse body and wrap in sequence
//					Script script= visitFlowObject(flowObject);
//					Seq body= null;
//					if (script instanceof Seq) {
//						body= (Seq) script;
//					} else {
//						body= jef.createSequence(script);
//					}
//					
//					// get event activity
//					Script event= getFirstEventElement(body);
//
//					// modify body
//					if (event instanceof Case) {
//						// remove timer case from sequence
//						body.getScripts().remove(event);
//						Case timerCase= (Case) event;
//						timerCase.setBody(body);
//						block.getCases().add(timerCase);
//					} else if (event instanceof Receive) {
//						// receive can stay in sequence
//						Receive receive= (Receive) event;
//						// will be preceded by listen and onMessage
//						MessageEvent messageEvent= jadlFac.createMessageEvent();
//						Expression address = receive.getAddress();
//						messageEvent.setAddress((Expression) EcoreUtil.copy(address));
//						Property property= (Property) wrapper.getMapping(receive);
//						messageEvent.setType(jef.createType(Util.getType(property)));
//						Case messageCase= jadlFac.createCase();
//						messageCase.setEventedCase(messageEvent);
//						messageCase.setBody(body);
//						block.getCases().add(messageCase);
//						// add listen
//						messageListeners.get(_currentService).add((Expression) EcoreUtil.copy(address));
//					}
				}
//				mapping= block;
				break;
			case COMPLEX:
				/*
				 * For Complex Gateways created from the Initial Gateway Rule,
				 * a new service will be created for each branch, finally calling
				 * the original service, starting after the block.
				 * Also see buildService for further processing of the services. 
				 */
//				if (fork.getName().contains(InitialGatewayRule.INITIAL_GATEWAY)) {
//					// memorize original service (_currentService will be bound to the new one)
//					final Service parentService= _currentService;
//					List<Service> services= new ArrayList<Service>();
//					int counter= 0;
//					for (BpmnBranch branch : bpmnBlock.getElements()) {
//						// create service for each branch
//						Service service= buildService(parentService.getName() + "_" + counter++, 
//								branch, 
//								Arrays.asList(branch.getElement()), 
//								bpmnBlock.getPool().getProperties());
//						services.add(service);
//					}
//					// set relation in map and set _currentService back to the parentService
//					callingServices.put(parentService, services);
//					_currentService= parentService;
//				} else {
//					TrafoLog.nyi("Mapping for Gateway Type " + fork.getGatewayType().getName());
//				}
//				break;
		}
		return mapping;
	}
	
	/**
	 * 
	 * @param block
	 * @return
	 */
	private Script visitBpmnLoopBlock(BpmnLoopBlock block){
		TrafoLog.trace("Visiting BpmnLoopBlock");
		Script untilPart= visitFlowObject(block.getFirstBranch().getElement());
		Script whilePart= visitFlowObject(block.getSecondBranch().getElement());
		
		String condition = "";
		// compose and parse loop condition expression
		if (block.getSecondBranch().getCondition() != null) {
			condition = block.getSecondBranch().getCondition().getExpression();
		} else {
			//use negated exit condition
			condition = "! (" + block.getExitBranch().getCondition().getExpression() + ")";
		}
		
		// assemble loop body
		Sequence loopBody= beansFac.createSequence();
		if (whilePart != null) {
			loopBody.getScripts().add(whilePart);
		}
		if (untilPart != null) {
			loopBody.getScripts().add(untilPart);
		}
		
		While loop = beansFac.createWhile();
		loop.setCondition(condition);
		loop.setContent(loopBody);
		
		// assemble complete loop sequence
		if (untilPart == null) {
			// only the loop
			return loop;
		} else {
			// a sequence holding a copy of activity 1 and the loop
			return createSequence( (Script) EcoreUtil.copy(untilPart), loop);
		}
	}

	/**
	 * 
	 * @param bpmnSequence
	 * @return
	 */
	private Script visitBpmnSequence(BpmnSequence bpmnSequence) {
		TrafoLog.trace("Visiting BpmnSequence");
		Sequence seq = beansFac.createSequence();
		for (FlowObject flowObject :  bpmnSequence.getElements()) {
			Script script = visitFlowObject(flowObject);
			if (script != null) {
				seq.getScripts().add(script);
			}
		}
		return seq;
	}
	
	/**
	 * 
	 * @param event
	 * @param multiType
	 * @return
	 */
	private Script visitEvent(Event event, TriggerType multiType){
		TrafoLog.trace("Visiting Event '" + event.getName() + "'");
		Script mapping= beansFac.createCodeElement();
		TriggerType trigger= multiType != null ? multiType : event.getTrigger();
		
		List<Property> properties= new ArrayList<Property>();
		
		switch (trigger) {
		case MESSAGE:
			//create Space Observer and join the message channel in doStart()
			Implementation implementation= event.getImplementation();
			if (event instanceof Start && event.getImplementation() instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) event.getImplementation();
				_currentBean.getImports().add("de.dailab.jiactng.agentcore.action.Action");
				_currentBean.getImports().add("java.io.Serializable");
				_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.CommunicationAddressFactory");
				_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.IGroupAddress");
				_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.ICommunicationBean");
				_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.message.IJiacMessage");
				_currentBean.getImports().add("de.dailab.jiactng.agentcore.knowledge.IFact");
				_currentBean.getImports().add("org.sercho.masp.space.event.SpaceEvent");
				_currentBean.getImports().add("org.sercho.masp.space.event.SpaceObserver");
				_currentBean.getImports().add("org.sercho.masp.space.event.WriteCallEvent");
				String address = channel.getChannel().getExpression();
				String payloadType = channel.getPayload().getType();
				if (payloadType.contains(".")) {
					_currentBean.getImports().add(payloadType);
				}
				payloadType = Util.getType(channel.getPayload());
				String name = Util.toJavaName(event.getId())+"_observer";
				// register to channel, create Groupaddress, invoke join action, create space Observer
				Sequence seq = createSequence(
						createCode("Action joinAction = retrieveAction(ICommunicationBean.ACTION_JOIN_GROUP);"),
						createCode("IGroupAddress groupAddress = CommunicationAddressFactory.createGroupAddress(\""+address+"\");"),
						createCode("invoke(joinAction,new Serializable[]{groupAddress});"),
						createCode("SpaceObserver<IFact> "+ name +" = new SpaceObserver<IFact>(){"),
						createCode("\tpublic void notify(SpaceEvent<? extends IFact> event) { "),
						createCode("\t\tif(event instanceof WriteCallEvent){ "),
						createCode("\t\t\tObject obj  = ((WriteCallEvent) event).getObject();"),
						createCode("\t\t\tif (obj instanceof IJiacMessage){"),
						createCode("\t\t\t\tIJiacMessage message = (IJiacMessage)obj;"),
						createCode("\t\t\t\tIFact payload = message.getPayload();"),
						createCode("\t\t\t\tif(payload!=null && payload instanceof " + payloadType +
								     "&& message.getHeader(IJiacMessage.Header.SEND_TO).equalsIgnoreCase(\"" + address + "\")){"),
						createCode("\t\t\t\t\tmemory.remove(message);"),
						createCode("\t\t\t\t\t" + Util.toJavaName(_currentService) + "((" + payloadType + ")payload);"),
						createCode("\t\t\t\t}"),
						createCode("\t\t\t}"),
						createCode("\t\t}"),
						createCode("\t}"),
						createCode("};"),
						createCode("memory.attach("+name+");"));
				//append the sequence to doStart();
				Script existing = _doStart.getContent();
				if (existing != null) {
					seq.getScripts().add(0, existing);
				} else {
					_doStart.setContent(seq);
				}
				//attach _doStart to the bean
				_currentBean.addMethod(_doStart);
			}
			// get parameters for this event
			List<Property> parameters = new ArrayList<Property>();
			if (implementation instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) implementation;
				Property prop = channel.getPayload();
				JavaVariable var = createVariable(Util.getType(prop), Util.toJavaName(prop.getName()));
				if (event instanceof Start) {
					_currentWorkflow.getParameters().add(var);
				}
				if (event instanceof End) {
					properties.add(channel.getPayload());
					mapping = buildSend(channel);
				}
			}
			if (implementation instanceof Service) {
				Service service = (Service) implementation;
				if (event instanceof Start) {
					List<Property> inputs = service.getInput();
					for (Property property : inputs) {
						JavaVariable var = createVariable(Util.getType(property), Util.toJavaName(property.getName()));
						_currentWorkflow.getParameters().add(var);
					}
				}
				if (event instanceof End) {
					List<Property> output = service.getOutput();
					if (output.size() == 1) {
						if (output.get(0).getType().contains(".")) {
							_currentBean.getImports().add(output.get(0).getType());
						}
						_currentWorkflow.setReturnType(Util.getType(output.get(0)));
						mapping = createCode("return " + output.get(0).getName() + ";");
					} else {
						//put multiple outputs in Serializable array
						String outputs = buildPropertyString(output);
						_currentBean.getImports().add("java.io.Serializable");
						_currentWorkflow.setReturnType("Serializable[]");
						mapping = createCode("return new Serializable[]{" + outputs + "};");
					}
				}
				/*
				 * add output parameter declaration
				 * input are already declared as method parameters, 
				 * so they shouldn't be declared again.
				 */
				if (event instanceof End) {
					parameters.addAll(service.getOutput());
				}
			}
			if (event instanceof End) {
				properties.addAll(parameters);
			}
			
			if (event instanceof Intermediate) {
				if (event.getImplementation() instanceof MessageChannel) {
					MessageChannel channel = (MessageChannel) implementation;
					/*
					 * create a recieve script and wrap it in an activity
					 * to keep the workflow method readable 
					 */
					String methodName = Util.toJavaName(event.getNameOrId()+"_recieve");
					Method wrapper = beansFac.createActivityMethod();
					wrapper.setName(methodName);
					Sequence seq = buildSequence(buildReceive(channel), properties, event.getAssignments());
					wrapper.setContent(seq);
					if (_currentSubProcess == null) {
						_currentBean.addMethod(wrapper);
					} else {
						_currentSubProcess.getMethods().add(wrapper);
					}
					mapping = createCode(methodName + "();");
				}
			}
			break;
		case NONE:
			if (event instanceof Start) {
				_currentBean.addMethod(_execute);
				//create executed flag
				JavaVariable flag = createVariable("boolean", "executed");
				_currentBean.getAttributes().add(flag);
				//create MethodCall
				Sequence body = createSequence(
						createCode(_currentWorkflow.getName() + "();"),
						createCode("executed = true;"));
				//create IfThen Block
				_execute.setContent(createIfThenElse("! executed", body, null));
			}
			break;
		case TIMER:
			if (event instanceof Start) {
				_currentBean.addMethod(_execute);
				CodeElement methodCall = createCode(_currentWorkflow.getName()+"();");
				if (event.isAsDuration()) {
					//add lastExecuted
					JavaVariable flag = createVariable("long", "lastExecuted");
					_currentBean.getAttributes().add(flag);
					int duration;
					try {
						duration = Integer.parseInt(event.getTimeExpression().getExpression());
					} catch (NumberFormatException e) {
						duration = -1;//default
					}
					//create ifThenElse
					Sequence body = createSequence(
							methodCall,
							createCode("lastExecuted = now;"));
					IfThenElse ifThen = createIfThenElse("now - lastExecuted >= " + duration, body, null);

					// wrap in sequence
					Sequence seq = createSequence(
							createCode("long now = System.currentTimeMillis();"),
							ifThen);
					_execute.setContent(seq);
				} else {
					_currentBean.getImports().add("java.util.Date");
					_currentBean.getImports().add("java.text.ParseException");
					_currentBean.getImports().add("java.text.SimpleDateFormat");
					
					TryCatch tc = createTryCatch(
							createCode("Thread.sleep(toSleep);"),
							"InterruptedException", createCode(""));
					
					Sequence trySeq = createSequence(
							createCode("Date then = new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss.SSSZ\").parse(\"" + event.getTimeExpression().getExpression() + "\");"),
							createCode("long toSleep = then.getTime() - System.currentTimeMillis();"),
							createIfThenElse("toSleep >= 0", createSequence(tc, methodCall), null));
					
					Sequence catchSeq = createSequence(
							createCode("System.out.println(\"ParseException: Time has to be in yyyy-MM-dd'T'HH:mm:ss.SSSZ form\");"),
							createCode("e.printStackTrace();"));
					
					//wrap everything in a try catch
					_execute.setContent(createTryCatch(trySeq, "ParseException", catchSeq));
				}
			}
			if (event instanceof Intermediate) {
				// TODO fast identisch mit Start -> mergen?
				String timeExpression = event.getTimeExpression().getExpression();
			 	if (event.isAsDuration()) {
					try {
						long timeout = Long.parseLong(timeExpression);
						mapping = createTryCatch(
								createCode("Thread.sleep(" + timeout + ");"),
								"InterruptedException", beansFac.createCodeElement());
					} catch (Exception e) {
						mapping = createComment("TODO Cannot parse timeExpression for sleep: " + timeExpression);
					}
				} else {
					_currentBean.getImports().add("java.util.Date");
					_currentBean.getImports().add("java.text.ParseException");
					_currentBean.getImports().add("java.text.SimpleDateFormat");
					
					Sequence trySeq = createSequence(
							createCode("Date then = new SimpleDateFormat(\"yyyy-MM-dd'T'HH:mm:ss.SSSZ\").parse(\"" + timeExpression + "\");"),
							createCode("long toSleep = then.getTime() - System.currentTimeMillis();"),
							createTryCatch(createCode("Thread.sleep(toSleep);"), "InterruptedException", createCode("")));

					Sequence catchSeq = createSequence(
							createCode("System.out.println(\"ParseException: Time has to be in yyyy-MM-dd'T'HH:mm:ss.SSSZ form\");"),
							createCode("e.printStackTrace();"));
					
					//wrap everything in a try catch
					mapping = createTryCatch(trySeq, "ParseException", catchSeq);
				}
			 	
			 	/*
				 * wrap the mapping in an activity
				 * to keep the workflow method readable 
				 */
			 	mapping= buildSequence(mapping, properties, event.getAssignments());
			 	String methodName = Util.toJavaName(event.getNameOrId() + "_wait");
				Method wrapper = beansFac.createActivityMethod();
				wrapper.setName(methodName);
				wrapper.setContent(mapping);
				if(_currentSubProcess==null){
					_currentBean.addMethod(wrapper);
				} else {
					_currentSubProcess.getMethods().add(wrapper);
				}
				mapping = createCode(methodName + "();");
			}
			break;
		case RULE:
//			String rule = event.getRuleExpression().getExpression();
//			if (event instanceof Start) {
//				// starter rule will be created holding the rule expression
//				addStarterRule(event);
//				// create service parameters according to properties used in rule
//				for (Property property : event.getPool().getProperties()) {
//					if (rule.contains(property.getName())) {
//						HeaderDeclaration header = jef.createHeaderVariableDeclaration(property.getName(), Util.getType(property));
//						_currentService.getInputs().add(header);
//					}
//				}
//			}
//			if (event instanceof Intermediate) {
//				// create case, waiting for the rule expression to become true
//				Case expressionCase = jadlFac.createCase();
//				Expression expression = jef.createExpression(rule);
//				expressionCase.setExpressionCase(expression);
//				mapping = expressionCase;
//			}
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
			if (event.getImplementation() != null) {
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
			mapping= wrapInPar(children,"startEvent");
			break;
		default:
			TrafoLog.warn("Could not find a Mapping for Event " + event.getNameOrId());
		}
		if (! (event instanceof Intermediate) && ! (event.getAssignments().isEmpty() && properties.isEmpty())) {
			mapping= buildSequence(mapping, properties, event.getAssignments());
		}
		
		return mapping;
	}

	/**
	 * 
	 * @param activity
	 * @return
	 */
	private Script visitActivity(Activity activity){
		if (activity.getName().equals("__DO_NOTHING__")) {
			return beansFac.createCodeElement();
		}
		TrafoLog.trace("Visiting Activity '" + activity.getName() + "'");
		Script mapping= beansFac.createCodeElement();
		//checks
		if (activity.getTransaction() != null) {
			TrafoLog.warn("A mapping for transactions is not defined. Ignoring transaction attributes.");
		}
		if (activity.isAdHoc()) {
			TrafoLog.warn("A mapping for AdHoc activities is not defined. Ignoring AdHoc attributes.");
		}
		// list of all properties (activity, messages, etc.)
		List<Property> properties= new ArrayList<Property>();
		properties.addAll(activity.getProperties());
		
		switch (activity.getActivityType()) {
		case NONE:
			break;
		case SCRIPT:
			String script = activity.getScript();
			if (script!=null) {
				String[] lines = script.split("\n");
				Sequence seq = beansFac.createSequence();
				for (String line : lines) {
					seq.getScripts().add(createCode(line));
				}
				mapping = seq;
			}
			break;
		case SERVICE:
			if (activity.getImplementation() instanceof Service) {
				Service service = (Service) activity.getImplementation();
				_currentBean.getImports().add(service.getLocation()+"."+service.getInterface());//importing the service location
				_currentBean.getImports().add("de.dailab.jiactng.agentcore.action.Action");
				
				// action name and parameters
				String varName = ("" + service.getOperation()).toLowerCase() + "Action";
				String parameter = buildPropertyString(service.getInput());
				
				// collect code elements
				CodeElement retrieveAction = createCode("Action " + varName + " = retrieveAction(" + service.getInterface() + "." + service.getOperation() + ");");
				CodeElement throwException = createCode("throw new RuntimeException(\"action " + service.getOperation() + " not found!\");");
				IfThenElse checkAction = createIfThenElse(varName + " == null", throwException, null);
				CodeElement invokeCall = createCode("Serializable[] results = invokeAndWaitForResult(" + varName + ", new Serializable[]{" + parameter + "}).getResults();");
				Sequence invokeSeq = createSequence(retrieveAction, checkAction, invokeCall);

				//assign the results from the serializeable array
				for (int i = 0; i < service.getOutput().size(); i++) {
					Property property = service.getOutput().get(i);
					String type = Util.getNonPrimitiveType(Util.getType(property));
					String name = Util.toJavaName(property.getName());
					invokeSeq.getScripts().add(createCode(name + " = (" + type + ")results[" + i + "];"));
				}
				// move copy of message variables to the activity itself, so they are added to the scope
				properties.addAll(service.getInput());
				properties.addAll(service.getOutput());
				mapping= invokeSeq;
			}
			if (activity.getImplementation() instanceof MessageChannel) {
				// TODO asynchronous service invocation (?)
				TrafoLog.nyi("Service Task with MessageChannel");
			}
			break;
		case EMBEDDED:
			String className = Util.toJavaType(activity.getName()) + "SubProcess";
			SubProcess sp = beansFac.createSubProcess();
			sp.setName(className);
			SubProcess old = _currentSubProcess;
			_currentSubProcess = sp;
			_currentBean.getSubprocesses().add(sp);
			Method run = beansFac.createMethod();
			run.setName("run");
			run.setVisibility(MethodImpl.PUBLIC);
			_currentSubProcess.getMethods().add(run);
			Script content = visitFlowObjects(activity.getContainedFlowObjects());
			_currentSubProcess = old;
			//looping?
			if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
				content =  createStandardLoop(activity, content);
			}
			if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
				content = createMultiInstanceLoop(activity, content);
			}
			run.setContent(buildSequence(content, null, activity.getAssignments()));
			for (Property prop : activity.getProperties()) {
				sp.getAttributes().add(createVariable(Util.getType(prop), Util.toJavaName(prop.getName())));
			}
			String varName = Util.toJavaName(activity.getName());
			mapping = createSequence(
					createCode(className + " " + varName + " = new " + className + "();"),
					createCode(varName + ".run();"));
			break;
		case CALL:
			if (activity.getCalledElement() instanceof Activity) {
				Activity calledAct = (Activity) activity.getCalledElement();
				mapping = createCode(Util.toJavaName(calledAct.getName()) + "();");
			}
			if (activity.getCalledElement() instanceof Pool) {
				// TODO call another service, similar to invoke
//				Pool calledPool = (Pool) activity.getCalledElement();
			}
			break;
		case SEND:
			// send element
			if (activity.getImplementation() instanceof de.dailab.vsdt.Service) {
				// TODO asynchronous service invocation
				TrafoLog.nyi("Send Task with Service");
			}
			if (activity.getImplementation() instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) activity.getImplementation();
				properties.add(channel.getPayload());
				mapping= buildSend(channel);
			}
			break;
		case RECEIVE:
			// receive element
			if (activity.getImplementation() instanceof Service) {
				// TODO receive result of asynchronous service invocation
				TrafoLog.nyi("Receive Task with Service");
			}
			if (activity.getImplementation() instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) activity.getImplementation();
				mapping= buildReceive(channel);
			}
			break;
		case USER:
			// TODO user task: present generic input dialogue
		case MANUAL:
			// TODO implement missing mappings
			TrafoLog.nyi("Mapping for Activity with type " + activity.getActivityType().getName());
		default:
			TrafoLog.warn("Could not find a Mapping for Activity " + activity.getNameOrId());
		}

		if (mapping == null) {
			System.err.println("MAPPING IS NULL"); // does this ever happen?
		}
		// create loop mappings: basic mapping is embedded in loop structure
		if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
			mapping= createStandardLoop(activity, mapping);
		}
		if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
			mapping= createMultiInstanceLoop(activity, mapping);
		}
		//build activity method: properties, assignments, mapping, more assignments
		createActivityMethod(activity.getName(), mapping, properties, activity.getAssignments());
		
		return createCode(Util.toJavaName(activity.getName()) + "();");
	}
	
	
	/**
	 * Visit each flowObject in the list and wrap them in a Sequence
	 * @param flowObjects
	 * @return
	 */
	public Script visitFlowObjects(List<FlowObject> flowObjects){
		if (flowObjects.size() == 1) {
			//single activity: return that activity
			return visitFlowObject(flowObjects.get(0));
		} else {
			Sequence seq = beansFac.createSequence();
			for (FlowObject flowObject : flowObjects) {
				seq.getScripts().add(visitFlowObject(flowObject));
			}
			return seq;
		}
	}
	
	/**
	 * Visit many assignments and return them as a list
	 * 
	 * @param assignments	the BPMN assignments
	 * @param assignTime	assign time to regard, or null to regard all assign times 
	 * @return
	 */
	private Sequence visitAssignments(List<Assignment> assignments, AssignTimeType assignTime) {
		Sequence assigns= beansFac.createSequence();
		if (assignments != null) {
			for (Assignment assignment : assignments) {
				if (assignTime == null || assignment.getAssignTime() == assignTime) {
					CodeElement assign = createAssign(assignment.getFrom().getExpression(), assignment.getTo().getName(), assignment.getToQuery());
					assigns.getScripts().add(assign);
				}
			}
		}
		return assigns;
	}
	
	/**
	 * map some BPMN element's properties set. For the whole set of properties 
	 * a number of VariableDeclarations are created and returned in a list.
	 * 
	 * @param properties	list of BPMN properties
	 */
	private List<CodeElement> visitProperties(List<Property> properties) {
		List<CodeElement> declarations= new ArrayList<CodeElement>();
		if (properties != null) {
			for (Property property : properties) {
				final String varName = property.getName();
				final String typeName = Util.getType(property);
				declarations.add(createVariableDeclaration(varName, typeName));
				// initialize variables...
				if (property.getType().contains(".")) {
					// ...only if it is a complex type
					//TODO initialize variable ("new ...()")
//					CodeElement assign = beansFac.createCodeElement();
//					assign.setCode(varName+" = new "+typeName+"()");
//					declarations.add(assign);
				}
			}
		}
		return declarations;
	}
	
	private Script visitGateway(Gateway g){
		Script script = beansFac.createCodeElement();
		((CodeElement)script).setCode("// closing gateway of event handler block");
		return script;
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
	private Script createLoopSequence(FlowObject activity, Script script, String condition, int maximum, boolean testBefore) {
		String actName= activity.getName();
		String varName= actName.toLowerCase() + "_loopCounter";
		boolean useLoopCounter= maximum > 0;
		
		// counter variable and assigns
		CodeElement declaration= createVariableDeclaration(varName, "int");
		CodeElement initAssign= createAssign("0", varName, null);
		CodeElement incAssign= createAssign(varName+"+1", varName, null);

		// this sequence is the whole loop structure, including variable initialization
		Sequence outerSeq= beansFac.createSequence();
		if (useLoopCounter) {
			outerSeq.getScripts().add(declaration);
			outerSeq.getScripts().add(initAssign);
		}
		// create loop body holding the mapped activity and the increment for the loop counter
		Sequence innerSeq= beansFac.createSequence();
		if (useLoopCounter) {
			innerSeq.getScripts().add(incAssign);
		}
		if (script != null) {
			innerSeq.getScripts().add(script);
		}

		// build and parse loop expression
		String cond= condition;
		//append additional condition for loop maximum
		if (useLoopCounter) {
			String cond2= varName + " < " + maximum;
			cond= cond != null && cond.length()>0 ? "("+ cond +") && (" + cond2 + ")" : cond2;
		}
		//for testTime=after: instead of inserting a copy of the activity here, which could be quite long, an additional test is appended
		if (! testBefore) {
			String cond2= useLoopCounter? "|| ("+varName + " < 1)": "";
			cond= cond != null && cond.length()>0 ? "("+ cond +") " + cond2  : "true";
		}

		//create the loop element, holding the sequence and the condition
		While loop= beansFac.createWhile();
		loop.setContent(innerSeq);
		loop.setCondition(cond);
		
		outerSeq.getScripts().add(loop);
		
		return outerSeq;
	}
	
	/**
	 * Builds a sequence holding variable declarations, start time assignments, 
	 * a script, and end time assignments.
	 * 
	 * @param script		already mapped script
	 * @param properties	List of BPMN properties to be mapped to variable declarations
	 * @param assignments	List of BPMN assignments to be mapped to assigns
	 */
	private Sequence buildSequence(Script script, List<Property> properties, List<Assignment> assignments) {
		Sequence seq= beansFac.createSequence();
		seq.getScripts().addAll(visitProperties(properties));
		seq.getScripts().addAll(visitAssignments(assignments, AssignTimeType.START).getScripts());
		if (script != null) {
			seq.getScripts().add(script);	
		}
		seq.getScripts().addAll(visitAssignments(assignments, AssignTimeType.END).getScripts());
		return seq;
	}
	
	// TODO braucht man die alle beide?
	
	/**
	 * Create and build the content of an ActivityMethod
	 * 
	 * @param script		already mapped script
	 * @param properties	List of BPMN properties to be mapped to variable declarations
	 * @param assignments	List of BPMN assignments to be mapped to assigns
	 */
	private void createActivityMethod(String methodName, Script body, List<Property> properties, List<Assignment> assignments) {
		Sequence seq= beansFac.createSequence();
		//Properties
		List<CodeElement> propScripts = visitProperties(properties);
		if (! propScripts.isEmpty()) {
			seq.getScripts().add(createComment("Properties"));
			seq.getScripts().addAll(propScripts);
		}
		//Start Assignments
		Sequence start = visitAssignments(assignments, AssignTimeType.START);
		if (! start.getScripts().isEmpty()) {
			seq.getScripts().add(createComment("Start Assignments"));
			seq.getScripts().addAll(start.getScripts());
		}
		//Body
		if (body != null && ! body.toJavaCode().isEmpty()) {
			seq.getScripts().add(createComment("Body"));
			seq.getScripts().add(body);	
		}
		//End Assignments
		Sequence end = visitAssignments(assignments, AssignTimeType.END);
		if (! start.getScripts().isEmpty()) {
			seq.getScripts().add(createComment("End Assignments"));
			seq.getScripts().addAll(end.getScripts());
		}
		ActivityMethod method = beansFac.createActivityMethod();
		method.setName(Util.toJavaName(methodName));
		method.setIsStatic(false);
		method.setVisibility(MethodImpl.PRIVATE);
		method.setContent(seq);
		if (_currentSubProcess == null) {
			_currentBean.addMethod(method);
		} else {
			_currentSubProcess.getMethods().add(method);
		}
	}
	
	/**
	 * Create a new code element for the given assignment.
	 * 
	 * @param from			the from-expression
	 * @param toVarName		the name of the variable name to bind the expression to
	 * @param toQuery		an optional query (i.e. property or array index) or null
	 */
	private CodeElement createAssign(String from, String toVarName, String toQuery) {
		CodeElement assign= beansFac.createCodeElement();
		String code = toVarName;
		if (toQuery != null) {
			// try to parse as array index, if this fails interpret as complex property
			try {
				int index= Integer.parseInt(toQuery);
				code += code+"["+index+"]";
			} catch (NumberFormatException e) {
				code += code+"."+toQuery;
			}
		}
		code += " = " + from + ";";
		assign.setCode(code);
		return assign;
	}
	
	/**
	 * Wrap the branches in a Parallel Method call.
	 * @param branches   contains Script of each Parallel branches
	 * @return
	 */
	private Script wrapInPar(List<Script> branches, String prefix){
		Paralel par = beansFac.createParalel();
		par.getBranches().addAll(branches);
		par.setBranchPrefix(prefix);
		return par;
	}
	
	/**
	 * Takes an expression (null, Expression, or DisjunctiveExpression) and returns
	 * the wrapped expressions. In case of a disjunctiveCondition the several
	 * conditions are concatenated with 'or'.
	 * 
	 * @param		expression some (Struc)BPMN Expression
	 * @return		expression(s) wrapped in the Expression
	 */
	private String getCondition(de.dailab.vsdt.Expression expression) {
		if (expression == null) {
			return null;
		}
		if (expression instanceof DisjunctiveExpression) {
			DisjunctiveExpression disjunctive = (DisjunctiveExpression) expression;
			StringBuffer buff= new StringBuffer();
			for (int i = 0; i < disjunctive.getExpressions().size(); i++) {
				if (i > 0) {
					buff.append(" || ");
				}
				buff.append("( ");
				buff.append(disjunctive.getExpressions().get(i));
				buff.append(" )");
			}
			return buff.toString();
		} else {
			return expression.getExpression();
		}
	}
	
	/**
	 * Creates a sendaction-invoke for the given message
	 * 
	 * @param channel		the message to be sent
	 * @return send 		code sequence containing the invocation of 
	 * 						ICommunicationBean.sendAction()
	 */
	private Script buildSend(MessageChannel channel) {
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.action.Action");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.ICommunicationBean");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.IGroupAddress");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.CommunicationAddressFactory");
		_currentBean.getImports().add("java.io.Serializable");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.message.JiacMessage");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.knowledge.IFact");

		Send send = beansFac.createSend();
		send.setAddress(channel.getChannel().getExpression());
		
		if (channel.getPayload() != null) {
			String payloadType = channel.getPayload().getType();
			if (payloadType.contains("."))
				_currentBean.getImports().add(payloadType);
			String type = Util.getType(channel.getPayload());
			String name = Util.toJavaName(channel.getPayload().getName());
			send.setPayload(createVariable(type, name));
		}
		return send;
	}
	
	/**
	 * create recieve-sequence:
	 * see also jiacbeans.impl.RecieveImpl
	 * 
	 * @param message		the channel from where to receive
	 * @param participant	to whom the message is directed (e.g. a group)
	 * @return				Receive element
	 */
	private Script buildReceive(MessageChannel channel) {
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.action.Action");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.ICommunicationBean");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.IGroupAddress");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.CommunicationAddressFactory");
		_currentBean.getImports().add("java.util.Set");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.message.JiacMessage");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.message.IJiacMessage");

		Recieve receive = beansFac.createRecieve();
		receive.setAddress(channel.getChannel().getExpression());
		
		if (channel.getPayload() != null) {
			String payloadType = channel.getPayload().getType();
			if (payloadType.contains("."))
				_currentBean.getImports().add(payloadType);
			String type = Util.getType(channel.getPayload());
			String name = Util.toJavaName(channel.getPayload().getName());
			receive.setPayload(createVariable(type, name));
		}
		return receive;
	}
	
	/*
	 * SIMPLE ELEMENT CREATION HELPER
	 */
	
	private CodeElement createCode(String code){
		CodeElement codeElem = beansFac.createCodeElement();
		codeElem.setCode(code);
		return codeElem;
	}
	
	private JavaVariable createVariable(String type, String name) {
		JavaVariable var = beansFac.createJavaVariable();
		var.setName(name);
		var.setType(type);
		return var;
	}

	private CodeElement createVariableDeclaration(String varName, String typeName){
		CodeElement code = beansFac.createCodeElement();
		code.setCode(typeName + " " + varName+";");
		return code;
	}
	
	private CodeElement createComment(String msg) {
		CodeElement comment = beansFac.createCodeElement();
		comment.setCode("// " + msg);
		return comment;
	}
	
	private Sequence createSequence(Script... scripts) {
		Sequence seq = beansFac.createSequence();
		for (Script script: scripts) {
			seq.getScripts().add(script);
		}
		return seq;
	}
	
	private IfThenElse createIfThenElse(String condition, Script thenCase, Script elseCase) {
		IfThenElse ifThenElse= beansFac.createIfThenElse();
		ifThenElse.setCondition(condition);
		ifThenElse.setThenBranch(thenCase);
		ifThenElse.setElseBranch(elseCase);
		return ifThenElse;
	}
	
	private TryCatch createTryCatch(Script tryScript, String exception, Script catchScript) {
		TryCatch tryCatch = beansFac.createTryCatch();
		tryCatch.setTry(tryScript);
		tryCatch.getCatches().put(exception, catchScript);
		return tryCatch;
	}
	
	private String buildPropertyString(List<Property> properties) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < properties.size(); i++) {
			if (i > 0) {
				buffer.append(",");
			}
			buffer.append(properties.get(i).getName());
		}
		return buffer.toString();
	}
	
}
