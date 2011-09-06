package de.dailab.vsdt.trafo.jiacbeans.export;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import jiacbeans.ActivityMethod;
import jiacbeans.AgentBean;
import jiacbeans.CodeElement;
import jiacbeans.IfThenElse;
import jiacbeans.JavaVariable;
import jiacbeans.JiacbeansFactory;
import jiacbeans.Method;
import jiacbeans.Paralel;
import jiacbeans.Script;
import jiacbeans.Sequence;
import jiacbeans.SubProcess;
import jiacbeans.TryCatch;
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
 * @author pstan
 */
public class Bpmn2JiacBeansElementMapping extends BpmnElementMapping {
	
	final JiacbeansFactory beansFac = JiacbeansFactory.eINSTANCE;
	
	String _currentService;
	WorkflowMethod _currentWorkflow;
	AgentBean _currentBean;
	int __PARCOUNTER;
	
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
		// visit Pools and add resulting services to model
		for (Pool pool : bpd.getPools()) {
			AgentBean bean = visitPool(pool);
//			wrapper.map(pool, jc);
//			getWrapper().getBeans().add(bean);
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
		// build service (will automatically be added to the Agent model)
//		buildService(pool.getParent().getName() + "_" + pool.getName(), 
//				pool, 
//				pool.getGraphicalElements(), 
//				pool.getProperties());
//		
//		return model;
		
		WorkflowMethod workflow = beansFac.createWorkflowMethod();
		workflow.setName(pool.getParent().getName());
		_currentWorkflow = workflow;
		_currentBean.addMethod(workflow);
		//add a variable declaration for every pool property
		for(Property prop : pool.getProperties()){
			JavaVariable var = beansFac.createJavaVariable();
			var.setType(prop.getType());
			var.setName(prop.getName());
			_currentBean.getAttributes().add(var);
		}
		writeWorkflowSequence(pool, workflow, pool.getGraphicalElements());
		return _currentBean;
	}
	
	private void writeWorkflowSequence(Pool pool, WorkflowMethod workflow, List<FlowObject> flowObjects){
		Sequence seq = beansFac.createSequence();
		workflow.setContent(seq);
		
		for(FlowObject obj : flowObjects){
			seq.getScripts().add(visitFlowObject(obj));
		}
	}
	
	private Script visitFlowObject(FlowObject flowObject){
		Script script = beansFac.createCodeElement();
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
		//Create Subprocess for Activity
		SubProcess sp = beansFac.createSubProcess();
		sp.setName(block.getId());
		sp.setRunContent(visitActivity(block.getActivity()));
		mapping.getScripts().add(sp);
		CodeElement spStart = beansFac.createCodeElement();
		spStart.setCode(block.getId()+".start()");
		CodeElement spJoin = beansFac.createCodeElement();
		spJoin.setCode(block.getId()+".join()");
		starter.add(spStart);
		stopper.add(spJoin);
		//Event Handler Cases
		List<BpmnEventHandlerCase> cases = block.getEventHandlerCases();
		for (BpmnEventHandlerCase c : cases) {
			Event e = c.getIntermediate();
			switch (c.getIntermediate().getTrigger()) {
			case TIMER:
				if(e.isAsDuration()){
					CodeElement create = beansFac.createCodeElement();
					create.setCode("TimeEventHandler "+e.getId()+" = new TimeEventHandler("+e.getTimeExpression()+","+block.getId()+");");
					mapping.getScripts().add(create);
					CodeElement start = beansFac.createCodeElement();
					start.setCode(e.getId()+".start()");
					CodeElement stop = beansFac.createCodeElement();
					start.setCode(e.getId()+".stop()");
					starter.add(start);
					stopper.add(stop);
				}
				break;
			case MESSAGE:
				
				break;
			default:
				break;
			}
		}
		//add all starter
		mapping.getScripts().addAll(starter);
		//join subprocess, wrapped in try-catch block
		Sequence tcs = beansFac.createSequence();
		tcs.getScripts().addAll(stopper);
		TryCatch tc = beansFac.createTryCatch();
		tc.setTry(tcs);
		tc.getCatches().put("InterruptedException", beansFac.createCodeElement());
		mapping.getScripts().add(tcs);
		return mapping;
	}
	
	private Script visitBpmnElementToSkip(BpmnElementToSkip block){
		Script toSkip = visitFlowObject(block.getElement());
		IfThenElse skipCondition = beansFac.createIfThenElse();
		skipCondition.setCondition(block.getEventHandlerCase().getId()+".hasBeenTriggered()");
		skipCondition.setThenBranch(toSkip);
		return skipCondition;
	}
	private Script visitBpmnBlock(BpmnBlock block){
		TrafoLog.trace("Visiting BpmnBlock");
		Gateway fork = block.getFirstGateway();
		Script mapping = null;
//		
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
				mapping= wrapInPar(scripts);
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
						seq.getScripts().add(script);
						seq.getScripts().add(createAssign("false", varName, null));
						script= seq;
					}
					String condString= getCondition(branch.getCondition());
					
					IfThenElse ifThenElse= buildIfThenElse(condString, script, null);
					if (ifThenElse != null) {
						scripts.add(ifThenElse);
					}
				}
				Script par= wrapInPar(scripts);
				if (hasDefault) {
					// create tracking variable
					CodeElement declaration= createVariableDeclaration(varName, "boolean");
					CodeElement assign= createAssign("true", varName, null);
					// create default case
					FlowObject flowObject= block.getDefaultElement();
					Script script= visitFlowObject(flowObject);
					IfThenElse ifThenElse= buildIfThenElse(varName, script, null);
					// create sequence holding the par and the other stuff
					Sequence seq= beansFac.createSequence();
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
					IfThenElse thisElement= buildIfThenElse(condString, script, lastElement);
					lastElement= thisElement;
				}
				mapping= lastElement;
				break;
			case XOR_EVENT:
//				Switch block= jadlFac.createSwitch();
//
//				for (BpmnBranch branch : bpmnBlock.getElements()) {
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
//				}
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
//		for(BpmnBranch branch : block.getElements()){
//			seq.getScripts().add(visitFlowObject((FlowObject)branch.getElement()));
//		}
		return mapping;
	}
	
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
		
		// IV. ASSEMBLE SEQUENCE HOLDING THE LOOP (and return it)
		if (untilPart == null) {
			// only the loop
			return loop;
		} else {
			// a sequence holding a copy of activity 1 and the loop
			Sequence sequence = beansFac.createSequence();
			sequence.getScripts().add((Script) EcoreUtil.copy(untilPart));
			sequence.getScripts().add(loop);
			return sequence;
		}
	}
	
	private Script visitBpmnSequence(BpmnSequence bpmnSequence) {
		TrafoLog.trace("Visiting BpmnSequence");
		Sequence seq = beansFac.createSequence();
		for (FlowObject flowObject :  bpmnSequence.getElements()) {
			seq.getScripts().add(visitFlowObject(flowObject));
		}
		return seq;
	}
	
	private Script visitEvent(Event event, TriggerType multiType){
		TrafoLog.trace("Visiting Event '" + event.getName() + "'");
		Script mapping= null;
		TriggerType trigger= multiType != null ? multiType : event.getTrigger();
		
		List<Property> properties= new ArrayList<Property>();

		// enrich service name with name of current start event
		if (event instanceof Start && event.getName() != null) {
			_currentService += "_" + event.getName();
		}
		
		//create doStart Method
		Method doStart = beansFac.createMethod();
		doStart.setName("doStart");
		doStart.setVisibility(MethodImpl.PUBLIC);
		switch (trigger) {
		case MESSAGE:
			Implementation implementation= event.getImplementation();
			if (event instanceof Start && event.getImplementation() instanceof MessageChannel) {
				//create Space Observer and join the message channel in doStart()
			}
			// get parameters for this event
			List<Property> parameters = new ArrayList<Property>();
			if (implementation instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) implementation;
				parameters.add(channel.getPayload());
			}
			if (implementation instanceof de.dailab.vsdt.Service) {
				de.dailab.vsdt.Service service = (de.dailab.vsdt.Service) implementation;
				if(event instanceof Start){
					List<Property> inputs = service.getInput();
					for (Property property : inputs) {
						JavaVariable var = beansFac.createJavaVariable();
						var.setType(property.getType());
						var.setName(property.getName());
						_currentWorkflow.getParameters().add(var);
					}
				}
				if(event instanceof End){
					List<Property> output = service.getOutput();
					if(output.size()==1){
						_currentWorkflow.setReturnType(output.get(0).getType());
					}
					//TODO handle multiple output
				}
				parameters.addAll((event instanceof Start) ? service.getInput() : service.getOutput());
			}
			if (event instanceof Start || event instanceof End) {
				// start/end: map message properties to service signature
//				List<HeaderDeclaration> serviceParameters= event instanceof Start
//						? _currentService.getInputs()
//						: _currentService.getOutputs();
//				for (HeaderDeclaration declaration : jef.createHeaderDeclarations(parameters)) {
//					boolean alreadyDeclared= false;
//					for (HeaderDeclaration param : serviceParameters) {
//						alreadyDeclared |= declaration.getName().equals(param.getName());
//					}
//					if (! alreadyDeclared) {
//						serviceParameters.add(declaration);
//					}
//				}
//			} else {
//				// message intermediate event: send/receive, or service invocation
//				if (implementation instanceof MessageChannel) {
//					MessageChannel channel = (MessageChannel) implementation;
//					if (event.isThrowing()) {
//						mapping= buildSend(channel);
//					} else {
//						mapping= buildReceive(channel);
//					}
//				}
//				if (implementation instanceof de.dailab.vsdt.Service) {
//					if (event.isThrowing()) {
//						// TODO asynchronous service invocation
//						TrafoLog.nyi("Message Event with Service");
//					} else {
//						// TODO receive result of asynchronous service invocation
//						TrafoLog.nyi("Message Event with Service");
//					}
//				}
//				// add message properties to properties
				properties.addAll(parameters);
			}
			break;
		case NONE:
			break;
		case TIMER:
			if (event instanceof Start) {
				//start _currentWorkflow in execute() 
				CodeElement methodCall = beansFac.createCodeElement();
				methodCall.setCode(_currentWorkflow.getName()+"();");
				Method execute = beansFac.createMethod();
				execute.setName("execute");
				execute.setContent(methodCall);
				execute.setVisibility(MethodImpl.PUBLIC);
				_currentBean.addMethod(execute);
			}
//			if (event instanceof Intermediate) {
//				Case timerCase= jadlFac.createCase();
//				timerCase.setBody(jadlFac.createSeq()); // empty case body
//				TimerEvent timer= jadlFac.createTimerEvent();
//				if (event.isAsDuration()) {
//					try {
//						timer.setTimeout(Integer.parseInt(event.getTimeExpression().getExpression()));
//						timerCase.setEventedCase(timer);
//					} catch (NumberFormatException e) {
//						e.printStackTrace();
//					}
//				} else {
//					TimeConst time= jadlFac.createTimeConst();
//					time.setConst(event.getTimeExpression().getExpression());
//					timer.setTime(time);
//					timerCase.setEventedCase(timer);
//				}
//				if (timerCase.getEventedCase() != null) {
//					Seq seq = jef.createSequence(jef.createPrint("done waiting"));
//					timerCase.setBody(seq);
//					mapping= timerCase;
//				}
//			}
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
	
	private Script visitActivity(Activity activity){
		if(activity.getName().equals("__DO_NOTHING__")){
			return beansFac.createCodeElement();
		}
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
			// TODO check if script contains more than one line
			CodeElement code = beansFac.createCodeElement();
			code.setCode(activity.getScript());
			mapping = code;
			break;
		case SERVICE:
			if (activity.getImplementation() instanceof de.dailab.vsdt.Service) {
				de.dailab.vsdt.Service service = (de.dailab.vsdt.Service) activity.getImplementation();
				_currentBean.getImports().add(service.getLocation());//importing the service location
				// invoke another plan
				Sequence invokeSeq = beansFac.createSequence();
				String varName = (""+service.getOperation()).toLowerCase()+"Action";
				CodeElement actionVarDeclaration = beansFac.createCodeElement();
				actionVarDeclaration.setCode("Action "+varName+" = retrieveAction("+service.getInterface()+"."+service.getOperation()+");");
				CodeElement exception = beansFac.createCodeElement();
				exception.setCode("throw new RuntimeException(\"send action not found!\");");
				IfThenElse actionCheck = beansFac.createIfThenElse();
				actionCheck.setCondition(varName+" == null");
				actionCheck.setThenBranch(exception);
				invokeSeq.getScripts().add(actionVarDeclaration);
				invokeSeq.getScripts().add(actionCheck);//throws exception if action==null
				// set input and output variables according to message variables
				String parameter ="";
				for (Property property : service.getInput()) {
					if(parameter.length()>0) parameter +=",";
					parameter += property.getName();
				}
				CodeElement invokeCall = beansFac.createCodeElement();
				invokeCall.setCode("invoke("+varName+", new Serializeable[]{"+parameter+"});");
				for (Property property : service.getOutput()) {
					//TODO implement the return variables 
//					invoke.getReturnVariables().add(jef.createVariable(property.getName()).getName());
				}
				// move copy of message variables to the activity itself, so they are added to the scope
				properties.addAll(service.getInput());
				properties.addAll(service.getOutput());
				mapping= invokeSeq;
			}
			if (activity.getImplementation() instanceof MessageChannel) {
				// TODO asynchronous service invocation
				TrafoLog.nyi("Service Task with MessageChannel");
			}
			break;
		case EMBEDDED:
			// do not create a new plan; just put contents in a seq or par
			mapping= visitFlowObjects(activity.getContainedFlowObjects());
			break;
		case CALL:
			if (activity.getCalledElement() instanceof Activity) {
				Activity calledAct = (Activity) activity.getCalledElement();
				mapping= (Script) EcoreUtil.copy(visitFlowObject(calledAct));
			} else if (activity.getCalledElement() instanceof Pool) {
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
				//TODO
//				mapping= buildSend(channel);
			}
			break;
		case RECEIVE:
			// receive element
//			if (activity.getImplementation() instanceof Service) {
//				// TODO receive result of asynchronous service invocation
//				TrafoLog.nyi("Send Task with Service");
//			}
//			if (activity.getImplementation() instanceof MessageChannel) {
//				MessageChannel channel = (MessageChannel) activity.getImplementation();
//				if (channel.getPayload() != null) {
//					properties.add(channel.getPayload());
//				}
//				mapping= buildReceive(channel);
//			}
			break;
		case MANUAL:
		case USER:
			// TODO implement missing mappings
			TrafoLog.nyi("Mapping for Activity with type " + activity.getActivityType().getName());
		default:
			TrafoLog.warn("Could not find a Mapping for Activity " + activity.getNameOrId());
		}

		if (mapping == null) {
		}
		
		// create loop mappings: basic mapping is embedded in loop structure
		if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
			//TODO pstan
//			mapping= createStandardLoop(activity, mapping);
		}
		if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
			//TODO pstan
//			mapping= createMultiInstanceLoop(activity, mapping);
		}
		
		//build activity sequence: properties, assignments, mapping, more assignments
		mapping= buildSequence(mapping, properties, activity.getAssignments());
		ActivityMethod method = beansFac.createActivityMethod();
		method.setName(activity.getName());
		method.setIsStatic(false);
		method.setVisibility(MethodImpl.PRIVATE);
		method.setContent(mapping);
		_currentBean.addMethod(method);
		CodeElement code = beansFac.createCodeElement();
		code.setCode(activity.getName()+"();");
		return code;
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
					//TODO implement this
//					CodeElement assign = beansFac.createCodeElement();
//					assign.setCode(varName+" = new "+typeName+"()");
//					declarations.add(assign);
				}
			}
		}
		return declarations;
	}
	
	private CodeElement createVariableDeclaration(String varName, String typeName){
		CodeElement code = beansFac.createCodeElement();
		code.setCode(typeName + " " + varName+";");
		return code;
	}
	private Script visitGateway(Gateway g){
		//TODO implement this
		Script script = beansFac.createCodeElement();
		((CodeElement)script).setCode("//TODO implement visitGateway");
		return script;
	}
	@Override
	public void initialize() {
		expressionVisitor = new JiacBeansExpressionVisitor(true, true);
	}
	
	
	/**
	 * Visit each flowObject in the list and wrap them in a Sequence
	 * @param flowObjects
	 * @return
	 */
	public Script visitFlowObjects(List<FlowObject> flowObjects){
		if(flowObjects.size()==1){
			//single activity: return that activity
			return visitFlowObject(flowObjects.get(0));
		} else{
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
					assigns.getScripts().add(createAssign(assignment.getFrom().getExpression(), assignment.getTo().getName(), assignment.getToQuery()));
				}
			}
		}
		return assigns;
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
		code += "= "+from+";";
		assign.setCode(code);
		return assign;
	}
	
	/**
	 * Wrap the branches in a Paralel Method call.
	 * @param branches   contains Script of each Paralel branches
	 * @return
	 */
	private Script wrapInPar(List<Script> branches){
		int current = __PARCOUNTER;
		__PARCOUNTER++;
		CodeElement callCode = beansFac.createCodeElement();
		callCode.setCode("__par"+current+"();");
		Method parMethod = beansFac.createMethod();
		Paralel par = beansFac.createParalel();
		par.getBranches().addAll(branches);
		parMethod.setContent(par);
		parMethod.setName("__par"+current);
		_currentBean.addMethod(parMethod);
		return callCode;
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
	 * Builds an IfThenElse holding the given expression, then, and else elements
	 * 
	 * @param expression	some JADL expression
	 * @param thenCase		some JADL script for the then case
	 * @param elseCase		some JADL script for the else case
	 * @return				newly created IfThenElse
	 */
	private IfThenElse buildIfThenElse(String condition, Script thenCase, Script elseCase) {
		IfThenElse ifThenElse= beansFac.createIfThenElse();
		ifThenElse.setCondition(condition);
		ifThenElse.setThenBranch(thenCase);
		ifThenElse.setElseBranch(elseCase);
		return ifThenElse;
	}
	
	/**
	 * Create Starter Rule for given event and add it to the list of starter rules.
	 * Starter Rules currently make sense only for a limited set of Events, i.e.
	 * Rule Events, Timer Events, and Message Events (with MessageChannels)
	 * 
	 * @param event		some (start) event
	 */
	private void addStarterRule(Event event) {
		//TODO
		// create Start Rule
		if (event instanceof Start) {
//			JiacVStarterRule startRule= new JiacVStarterRule(event, _currentService);
//			((JiacVExportWrapper) wrapper).addStarterRule(event.getPool().getParticipant(), startRule);
		}
	}
	
}
