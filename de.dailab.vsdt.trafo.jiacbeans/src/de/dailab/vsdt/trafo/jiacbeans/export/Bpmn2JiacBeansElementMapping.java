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
	Method _doStart;
	Method _execute;
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
			getWrapper().getBeans().add(bean);
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
		workflow.setName(pool.getParent().getName());
		_currentWorkflow = workflow;
		_currentBean.addMethod(workflow);
		//create doStart and execute, but don't attach them to the bean yet
		_doStart = beansFac.createMethod();
		_doStart.setName("doStart");
		_doStart.setVisibility(MethodImpl.PUBLIC);
		_execute = beansFac.createMethod();
		_execute.setName("doStart");
		_execute.setVisibility(MethodImpl.PUBLIC);
		//create action to be exposed by the bean
		Action action = beansFac.createAction();
		action.setName("ACTION_"+_currentService.toUpperCase());
		action.setLocation(_currentBean.getPackageName()+"."+_currentBean.getName()+"#"+_currentService);
		_currentBean.getActions().add(action);
		//add a variable declaration for every pool property
		for(Property prop : pool.getProperties()){
			JavaVariable var = beansFac.createJavaVariable();
			var.setType(Util.getType(prop));
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
		String activityName = Util.toJavaName(block.getActivity().getName());
		SubProcess sp = beansFac.createSubProcess();
		sp.setName(activityName);
		sp.setRunContent(visitActivity(block.getActivity()));
		mapping.getScripts().add(sp);
		CodeElement spStart = beansFac.createCodeElement();
		spStart.setCode(activityName+".start();");
		CodeElement spJoin = beansFac.createCodeElement();
		spJoin.setCode(activityName+".join();");
		starter.add(spStart);
		stopper.add(spJoin);
		//Event Handler Cases
		List<BpmnEventHandlerCase> cases = block.getEventHandlerCases();
		for (BpmnEventHandlerCase c : cases) {
			Event e = c.getIntermediate();
			String eName = Util.toJavaName(c.getId())+"EventHandler";
			switch (c.getIntermediate().getTrigger()) {
			case TIMER:
				if(e.isAsDuration()){
					CodeElement create = beansFac.createCodeElement();
					create.setCode("TimeEventHandler "+eName+" = new TimeEventHandler("+e.getTimeExpression().getExpression()+","+activityName+");");
					mapping.getScripts().add(create);
					CodeElement start = beansFac.createCodeElement();
					start.setCode(eName+".start();");
					CodeElement stop = beansFac.createCodeElement();
					stop.setCode(eName+".stop();");
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
		mapping.getScripts().add(tc);
		return mapping;
	}
	
	private Script visitBpmnElementToSkip(BpmnElementToSkip block){
		Script toSkip = visitFlowObject(block.getElement());
		Script compensate = visitFlowObject(block.getEventHandlerCase().getCompensationElement());
		IfThenElse skipCondition = beansFac.createIfThenElse();
		String eName = Util.toJavaName(block.getEventHandlerCase().getId())+"EventHandler";
		skipCondition.setCondition("!"+eName+".hasBeenTriggered()");
		skipCondition.setThenBranch(toSkip);
		skipCondition.setElseBranch(compensate);
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
//		if (event instanceof Start && event.getName() != null) {
//			_currentService += "_" + event.getName();
//		}
		
		switch (trigger) {
		case MESSAGE:
			//create Space Observer and join the message channel in doStart()
			Implementation implementation= event.getImplementation();
			if (event instanceof Start && event.getImplementation() instanceof MessageChannel) {
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
				Sequence seq = beansFac.createSequence();
				MessageChannel channel = (MessageChannel)event.getImplementation();
				String adress = channel.getChannel().getExpression();
				String payloadType = channel.getPayload().getType();
				if(payloadType.contains("."))_currentBean.getImports().add(payloadType);
				//register to channel
				CodeElement code = beansFac.createCodeElement();
				code.setCode("Action joinAction = retrieveAction(ICommunicationBean.ACTION_JOIN_GROUP);");
				seq.getScripts().add(code);
				//create Groupaddress
				code = beansFac.createCodeElement();
				code.setCode("IGroupAddress groupAdress = CommunicationAddressFactory.createGroupAddress(\""+adress+"\");");
				seq.getScripts().add(code);
				//invoke join action
				code = beansFac.createCodeElement();
				code.setCode("invoke(joinAction,new Serializable[]{groupAdress});");
				seq.getScripts().add(code);
				//create space Observer
				String name = Util.toJavaName(event.getId())+"_observer";
				code = beansFac.createCodeElement();
				code.setCode("SpaceObserver<IFact> "+ name +" = new SpaceObserver<IFact>(){");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\tpublic void notify(SpaceEvent<? extends IFact> event) { ");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\t\tif(event instanceof WriteCallEvent<?>){ ");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\t\t\tWriteCallEvent<IJiacMessage> wce = (WriteCallEvent<IJiacMessage>) event;");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\t\t\tIJiacMessage message = memory.remove(wce.getObject());");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\t\t\tIFact payload = message.getPayload();");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\t\t\tif(payload instanceof "+payloadType.substring(payloadType.lastIndexOf(".")+1)+"){");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\t\t\t\t"+_currentService+"(("+payloadType+")payload);");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\t\t\t}");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\t\t}");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("\t}");
				seq.getScripts().add(code);
				code = beansFac.createCodeElement();
				code.setCode("};");
				seq.getScripts().add(code);
				//append the sequence to doStart();
				Script existing = _doStart.getContent();
				if(existing!=null)seq.getScripts().add(0, existing);
				else _doStart.setContent(seq);
				//attach _doStart to the bean
				_currentBean.addMethod(_doStart);
			}
			// get parameters for this event
			List<Property> parameters = new ArrayList<Property>();
			if (implementation instanceof MessageChannel) {
				MessageChannel channel = (MessageChannel) implementation;
				Property prop = channel.getPayload();
				JavaVariable var = beansFac.createJavaVariable();
				var.setType(Util.getType(prop));
				var.setName(Util.toJavaName(prop.getName()));
				_currentWorkflow.getParameters().add(var);
			}
			if (implementation instanceof de.dailab.vsdt.Service) {
				de.dailab.vsdt.Service service = (de.dailab.vsdt.Service) implementation;
				if(event instanceof Start){
					List<Property> inputs = service.getInput();
					for (Property property : inputs) {
						JavaVariable var = beansFac.createJavaVariable();
						var.setType(Util.getType(property));
						var.setName(Util.toJavaName(property.getName()));
						_currentWorkflow.getParameters().add(var);
					}
				}
				if(event instanceof End){
					List<Property> output = service.getOutput();
					if(output.size()==1){
						if(output.get(0).getType().contains(".")){
							_currentBean.getImports().add(output.get(0).getType());
						}
						_currentWorkflow.setReturnType(Util.getType(output.get(0)));
						CodeElement returnCode = beansFac.createCodeElement();
						returnCode.setCode("return "+output.get(0).getName()+";");
						mapping = returnCode;
					}else{
						//put multiple outputs in Serializable array
						String outputs = "";
						for (Property property : output) {
							if(!outputs.equals(""))outputs+= ",";
							outputs+= property.getName();
						}
						_currentBean.getImports().add("java.io.Serializable");
						_currentWorkflow.setReturnType("Serializable[]");
						CodeElement returnCode = beansFac.createCodeElement();
						returnCode.setCode("return new Serializable[]{"+outputs+"};");
						mapping = returnCode;
					}
				}
				/*
				 * add output parameter declaration
				 * input are already declared as method parameters, 
				 * so they shouldn't be declared again.
				 */
				if(event instanceof End) parameters.addAll(service.getOutput());
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
				_currentBean.addMethod(_execute);
				//create methodCall
				CodeElement methodCall = beansFac.createCodeElement();
				methodCall.setCode(_currentWorkflow.getName()+"();");
				if(event.isAsDuration()){
					int duration;
					try{
						duration = Integer.parseInt(event.getTimeExpression().getExpression());
					}catch(NumberFormatException e){
						duration = -1;//default
					}
					//create loop
					While execLoop = beansFac.createWhile();
					execLoop.setCondition("true");
					CodeElement sleep = beansFac.createCodeElement();
					sleep.setCode("Thread.sleep("+duration+");");
					TryCatch tryToSleep = beansFac.createTryCatch();
					tryToSleep.setTry(sleep);
					tryToSleep.getCatches().put("InterruptedException", beansFac.createCodeElement());
					Sequence seq = beansFac.createSequence();
					seq.getScripts().add(methodCall);
					seq.getScripts().add(tryToSleep);
					execLoop.setContent(seq);
					_execute.setContent(execLoop);
				}else{
					//TODO start when the time has come
				}
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
				_currentBean.getImports().add(service.getInterface());//importing the service location
				_currentBean.getImports().add("de.dailab.jiactng.agentcore.action.Action");
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
				mapping= buildSend(channel);
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
		
		
		//build activity sequence: properties, assignments, mapping, more assignments
		mapping= buildSequence(mapping, properties, activity.getAssignments());
		// create loop mappings: basic mapping is embedded in loop structure
		if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
			mapping= createStandardLoop(activity, mapping);
		}
		if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
			mapping= createMultiInstanceLoop(activity, mapping);
		}
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
	
	private Script visitGateway(Gateway g){
		//TODO implement this
		Script script = beansFac.createCodeElement();
		((CodeElement)script).setCode("//TODO implement visitGateway");
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
		if(script!=null)innerSeq.getScripts().add(script);

		// build and parse loop expression
		String cond= condition;
		//append additional condition for loop maximum
		if (useLoopCounter) {
			String cond2= varName + " < " + maximum;
			cond= cond != null && cond.length()>0 ? "("+ cond +") && (" + cond2 + ")" : cond2;
		}
		//for testTime=after: instead of inserting a copy of the activity here, which could be quite long, an additional test is appended
		if (! testBefore) {
			String cond2= varName + " < 1";
			cond= cond != null && cond.length()>0 ? "("+ cond +") || (" + cond2 + ")" : cond2;
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
	
	@Override
	public void initialize() {
		expressionVisitor = new JiacBeansExpressionVisitor(true, true);
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
	
	
	private CodeElement createVariableDeclaration(String varName, String typeName){
		CodeElement code = beansFac.createCodeElement();
		code.setCode(typeName + " " + varName+";");
		return code;
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
	 * Creates a sendaction-invoke for the given message
	 * 
	 * @param channel		the message to be sent
	 * @return				code sequence containing the invocation of 
	 * 						ICommunicationBean.sendAction()
	 */
	private Script buildSend(MessageChannel channel) {
		//imports
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.action.Action");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.ICommunicationBean");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.IGroupAddress");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.CommunicationAddressFactory");
		_currentBean.getImports().add("java.io.Serializable");
		_currentBean.getImports().add("de.dailab.jiactng.agentcore.comm.message.JiacMessage;");
		String address = channel.getChannel().getExpression();
		Sequence send = beansFac.createSequence();
		CodeElement retrieveAction = beansFac.createCodeElement();
		retrieveAction.setCode("Action sendAction = retrieveAction(ICommunicationBean.ACTION_SEND);");
		send.getScripts().add(retrieveAction);
		//Adress
		CodeElement code = beansFac.createCodeElement();
		code.setCode("IGroupAddress groupAddress = CommunicationAddressFactory.createGroupAddress("+address+");");
		send.getScripts().add(code);
		//Message
		code = beansFac.createCodeElement();
		code.setCode("JiacMessage message = new JiacMessage("+channel.getPayload().getName()+");");
		send.getScripts().add(code);
		//invoke
		code = beansFac.createCodeElement();
		code.setCode("invoke(sendAction, new Serializable[]{message, groupAddress});");
		send.getScripts().add(code);
		return send;
	}
	
	/**
	 * create recieve-sequence:
	 * - join the group
	 * - wait for the message to come
	 * - leave the group
	 * 
	 * @param message		the channel from where to receive
	 * @param participant	to whom the message is directed (e.g. a group)
	 * @return				Receive element, or multiple Receive elements in a Seq element
	 */
	private Script buildReceive(MessageChannel channel) {
		Sequence recieve = beansFac.createSequence();
		return recieve;
	}
}
