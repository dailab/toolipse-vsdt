package de.dailab.vsdt.trafo.jiaciv.export;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import de.dailab.jadltools.model.xmlbind.ActModel;
import de.dailab.jadltools.model.xmlbind.AltExecutionModel;
import de.dailab.jadltools.model.xmlbind.BoolModel;
import de.dailab.jadltools.model.xmlbind.BranchModel;
import de.dailab.jadltools.model.xmlbind.ConditionalModel;
import de.dailab.jadltools.model.xmlbind.EvalModel;
import de.dailab.jadltools.model.xmlbind.FormulaModel;
import de.dailab.jadltools.model.xmlbind.JADLFileModel;
import de.dailab.jadltools.model.xmlbind.ParExecutionModel;
import de.dailab.jadltools.model.xmlbind.PlanelementCallModel;
import de.dailab.jadltools.model.xmlbind.ReceiveSpeechactModel;
import de.dailab.jadltools.model.xmlbind.ScriptModel;
import de.dailab.jadltools.model.xmlbind.ScriptbodyModel;
import de.dailab.jadltools.model.xmlbind.SendSpeechactModel;
import de.dailab.jadltools.model.xmlbind.SeqExecutionModel;
import de.dailab.jadltools.model.xmlbind.StepModel;
import de.dailab.jadltools.model.xmlbind.TruthModel;
import de.dailab.jadltools.model.xmlbind.VarModel;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.trafo.jiaciv.util.JiacVisitorConstants;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;

/**
 * BPMN to JIAC visitor. This visitor is performing a top-down pass of the BPMN model. This way it creates
 * the element mapping for all the elements passed on the way. After the pass the structure mapping is 
 * delegated to the rule-based transformation.
 * 
 * @author tkuester
 */
public class Bpmn2JiacElementMapping extends MappingStage implements JiacVisitorConstants {
	
	/**this list is holding the JadlFiles*/
//	private List<JADLFileModel> jadlFiles= new ArrayList<JADLFileModel>();
	
	/**this list is holding the JadlFiles*/
//	private List<AgentRoleType> agents= new ArrayList<AgentRoleType>();
	
	/**the mapping assistant for this visitor*/
	private JiacMappingAssistant assistant;
	
	/**this HashTable is holding the scribtModels associated to the plans that can hold variable declarations*/
	private Map<Object, ScriptModel> scriptModels= new Hashtable<Object, ScriptModel>();

	@Override
	public void initialize() {
		assistant= null;
		assistant= new JiacMappingAssistant(this);
		scriptModels= null;
		scriptModels= new Hashtable<Object, ScriptModel>();
	}

	@Override
	protected boolean internalApply() {
		visitBusinessProcessDiagram((BusinessProcessDiagram) wrapper.getSourceModel());
		return true;
	}

	//////////////////////////////////////////////////////////
	// VISITOR LOGIC
	//////////////////////////////////////////////////////////
	
	protected void visitBusinessProcessDiagram(BusinessProcessDiagram bpd) {
		TrafoLog.trace("visiting business process diagram '" + bpd.getName() + "'");
		
		for (Iterator<Pool> iter = bpd.getPools().iterator(); iter.hasNext();) {
			try {
				Pool pool= iter.next();
				JADLFileModel jadlFile= visitPool(pool);
				wrapper.getTargetModels().add(jadlFile);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		for (Iterator<ConnectingObject> iter = bpd.getConnections().iterator(); iter.hasNext();) {
			ConnectingObject connection= iter.next();
			visitConnection(connection);
		}
//		for (Iterator<Artifact> iter = bpd.getArtifacts().iterator(); iter.hasNext();) {
//			Artifact artifact= iter.next();
//			if (artifact instanceof Agent) {
//				AgentRoleType agent= visitAgent((Agent)artifact,bpd.getName());
//				wrapper.getTargetModels().add(agent);
//			}
//			if (artifact instanceof Service) {
//				try {
//					JADLFileModel service= visitService((Service)artifact,bpd.getName());
//					wrapper.getTargetModels().add(service);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
	}
	
	/**
	 * A BPMN pool/process is mapped to a (act ) element within a new JADL file.
	 * 
	 * @param pool		some BPMN pool
	 * @return			the JADL file model for the process
	 */
	private JADLFileModel visitPool(Pool pool) throws JAXBException {
		Pool process= pool;
		String name= process.getName();
		
		JADLFileModel jadlFileModel= jadlFac.createJADLFileModel();
		jadlFileModel.setFile(name);
		
		ActModel actModel= assistant.createActModel(name + "_act");
		jadlFileModel.getAct().add(actModel);

		ScriptModel scriptModel= jadlFac.createScriptModel();
		actModel.setBody(scriptModel);

		//create references (Note: references have to be created _before_ visiting child elements)
		wrapper.map(process, jadlFileModel);
		scriptModels.put(process, scriptModel);

		//map graphical elements
		ScriptbodyModel scriptBody= visitFlowObjects(process.getGraphicalElements());

		//map process assignments
//		scriptBody= assistant.addAssignmentMappings(scriptBody, process.getAssignments());
		
		//map properties
		assistant.visitProperties(process.getProperties(),scriptModel);
		
		scriptModel.setScript(scriptBody);
		
		//has service? iterate over service artifacts
//		for (Iterator<Artifact> iter = pool.getParentDiagram().getArtifacts().iterator(); iter.hasNext();) {
//			Artifact artifact = iter.next();
//			if (artifact instanceof Service) {
//				Service service= (Service) artifact;
//				
//				if (service.getUser() == pool || service.getProvider() == pool) {
//					String serviceName= service.getName();
//					
//					ProtocolModel protModel= jadlFac.createProtocolModel();
//					protModel.setServicename(serviceName);
//					protModel.setProtocolname(serviceName + PROTOCOL_SUFFIX);
//					if (service.isMultiple()) {
//						protModel.setMulti(true);
//						protModel.setMultivar("id");
//					}
//					
//					//add prot object for user side
//					protModel.setRole(service.getUser() == pool ? "user" : "provider");
//					actModel.setProtocol(protModel);
//				}
//					
//			}
//		}
				
		return jadlFileModel;
	}
	
	
	/**
	 * Map the given flow objects by iterating the list and visiting each single flow object.
	 * If the list contains more than one (possibly complex) flow object, the resulting
	 * elements are put into a par execution model.
	 * 
	 * @param flowObjects	a list of flow objects
	 * @param scriptModel	the scriptModel
	 */
	private ScriptbodyModel visitFlowObjects(List<FlowObject> flowObjects) throws JAXBException {
		
		if (flowObjects.size() == 1) {
			return visitFlowObject(flowObjects.get(0));
		} else{
			ParExecutionModel parModel= jadlFac.createParExecutionModel();
			for (Iterator<FlowObject> iterator = flowObjects.iterator(); iterator.hasNext();) {
				FlowObject flowObject = iterator.next();
				ScriptbodyModel activity= visitFlowObject(flowObject);
				
				//put result into the parModel
				if (activity != null) {
					parModel.getSteps().add(activity);	
				}
			}
			return parModel;
		}
	}
	
	
	/**
	 * This method maps the given flow object to a sequence of
	 * 1.: assignments to be done at the start
	 * 2.: the actual flow object's mapping (delegating to one of the specialized methods)
	 * 3.: assignments to be done at the end
	 * 
	 * @param flowObject	the flow object to be mapped
	 * @return				the mapping result or a sequence wrapping the actual mapping result and the assignments
	 */
	private ScriptbodyModel visitFlowObject(FlowObject flowObject) throws JAXBException {
		if (flowObject == null) {
			return null;
		}
		
		//find a mapping for the FlowObject
		ScriptbodyModel scriptBodyModel= null;
		if (flowObject instanceof Event) {
			scriptBodyModel= visitEvent((Event) flowObject);
		}
		if (flowObject instanceof Activity) {
			scriptBodyModel= visitActivity((Activity) flowObject);
		}
		if (flowObject instanceof Gateway) {
			scriptBodyModel= visitGateway((Gateway) flowObject);
		}
		//special structured BPMN elements
		if (flowObject instanceof BpmnSequence) {
			scriptBodyModel= visitBpmnSequence((BpmnSequence) flowObject);
		}
		if (flowObject instanceof BpmnBlock) {
			scriptBodyModel= visitBpmnBlock((BpmnBlock) flowObject);
		}
		if (flowObject instanceof BpmnLoopBlock) {
			scriptBodyModel= visitBpmnLoopBlock((BpmnLoopBlock) flowObject);
		}
		if (flowObject instanceof BpmnDerivedProcess) {
			scriptBodyModel= visitBpmnDerivedProcess((BpmnDerivedProcess) flowObject);
		}
		if (flowObject instanceof BpmnEventHandlerBlock) {
			scriptBodyModel= visitBpmnEventHandlerBlock((BpmnEventHandlerBlock) flowObject);
		}
		if (flowObject instanceof BpmnElementToSkip) {
			scriptBodyModel= visitBpmnElementToSkip((BpmnElementToSkip) flowObject);
		}
		
		//create mapping
		wrapper.map(flowObject,scriptBodyModel);
		
		return assistant.addAssignmentMappings(scriptBodyModel, flowObject.getAssignments());
		
		//replaced by method call
//		if (flowObject.getAssignments().isEmpty()) {
//			return scriptBodyModel;
//		} else {
//			//create wrapping sequence for the activity and its assignments
//			SeqExecutionModel seqModel= jadlFac.createSeqExecutionModel();
//			
//			//get assignments for the flow objects, which are mapped to bind models, each wrapped in a step model
//			List<StepModel> startAssigns= assistant.createAssignsFromList(flowObject.getAssignments(), AssignTimeType.START_LITERAL);
//			List<StepModel> endAssigns= assistant.createAssignsFromList(flowObject.getAssignments(), AssignTimeType.END_LITERAL);
//			
//			//build sequence
//			seqModel.getSteps().addAll(startAssigns);
//			if (scriptBodyModel != null) {
//				seqModel.getSteps().add(scriptBodyModel);	
//			}
//			seqModel.getSteps().addAll(endAssigns);
//			
//			return seqModel;
//		}
	}
	
	
	/**
	 * Maps the given Event to various JADL elements, depending on the events types and attributes.
	 * Please refer to the inline-comments for the actual mapping for each type.
	 * 
	 * @param event		the event
	 * @return			result of the mapping
	 */
	private ScriptbodyModel visitEvent(Event event) throws JAXBException {
		TrafoLog.trace("visiting end event '" + event.getName() + "'");
		ScriptbodyModel mapping= null;
		
		switch (event.getTrigger()) {
		case RULE:
			if (event instanceof Start) {
				JADLFileModel jadlFile= (JADLFileModel) wrapper.getMapping(event.getPool());
				ActModel act= (ActModel) jadlFile.getAct().get(0);
				if (event.getRuleExpression() != null) {
					String ruleString= event.getRuleExpression().getExpression();
					JiacMiniParser.parsePreEff(act, ruleString);
				}
			}
			break;
		case MESSAGE:
			// create send/receive speech-act and plan element call
			if (event.isThrowing()) {
				SendSpeechactModel send= assistant.createSendSpeechact(event.getName(), (JADLFileModel) wrapper.getMapping(event.getPool()));
				mapping= assistant.createPlanelementCallModel(send.getName());
			} else {
				ReceiveSpeechactModel receive= assistant.createReceiveSpeechact(event.getName(), (JADLFileModel) wrapper.getMapping(event.getPool()));
				mapping= assistant.createPlanelementCallModel(receive.getName());
			}
		case CANCEL:
			//end with cancel trigger
			mapping= jadlFac.createStepModel();
			((StepModel)mapping).setFail(true);
			break;
		case ERROR:
			//end with error trigger
			mapping= jadlFac.createStepModel();
			((StepModel)mapping).setFail(true);
			break;
		case TERMINATE:
			//end with terminate trigger
			mapping= jadlFac.createStepModel();
			((StepModel)mapping).setEnd(jadlFac.createEndModel());
			break;
		case LINK:
		case COMPENSATION:
		case TIMER:
		case SIGNAL:
			break;
		case MULTIPLE:
			//end with multiple trigger
//			MultipleTriggerAttSet multiAttSet= (MultipleTriggerAttSet) attSet;
//			ParExecutionModel parModel= jadlFac.createParExecutionModel();
//			for (Iterator<TriggerAttributeSet> iter = multiAttSet.getTriggers().iterator(); iter.hasNext();) {
//				TriggerAttributeSet attSet2 = iter.next();
//				ScriptbodyModel child= visitEnd(end, attSet2);
//				parModel.getSteps().add(child);
//			}
//			mapping= parModel;
			break;
		}
		
		if (mapping == null) {
			TrafoLog.warn("No Mapping found for Event " + event.getNameOrId());
			mapping= assistant.createLogInfo(event.getName());
		}
		
		return mapping;
	}
	
	/**
	 * Maps the given Activity to various JADL elements, depending on the activity's types and attributes.
	 * Please refer to the inline-comments for the actual mapping for each type.
	 * 
	 * @param activity		the activity to map
	 * @return				result of the mapping, including loops etc. 
	 */
	private ScriptbodyModel visitActivity(Activity activity) throws JAXBException {
		TrafoLog.trace("visiting activity '" + activity.getName() + "'");
		String name= activity.getName();
		ScriptbodyModel mapping= null;
		
		switch (activity.getActivityType()) {
		case EMBEDDED:
			//create new JADL action element
			ActModel actModel= assistant.createActModel(name);
			ScriptModel scriptModel2= jadlFac.createScriptModel();
			ScriptbodyModel scriptBody= visitFlowObjects(activity.getGraphicalElements()); 
			scriptModel2.setScript(scriptBody);
			actModel.setBody(scriptModel2);
			scriptModels.put(activity, scriptModel2);
			
			//insert into jadlFile
			JADLFileModel jadlFile= (JADLFileModel) wrapper.getMapping(activity.getPool());
			jadlFile.getAct().add(actModel);
			
			//create PE call
			mapping= jadlFac.createStepModel();
			((StepModel)mapping).setPecall(assistant.createPlanelementCallModel(actModel.getName()));
			break;
		case SUBPROCESSREFERENCE:
			//create PE call
			mapping= jadlFac.createStepModel();
			((StepModel)mapping).setPecall(assistant.createPlanelementCallModel(activity.getActivityRef().getName()));
			break;
		case INDEPENDENT:
			if (activity.getProcessRef() != null) {
				String procName= activity.getProcessRef() + "_act";
				PlanelementCallModel peCall= jadlFac.createPlanelementCallModel();
				peCall.setPlanelement(procName);
				mapping= peCall;
				//TODO input and output property maps: map to parameters? would need to be in synch with the actual process parameters... 
			}
			break;
		case RECEIVE:
			ReceiveSpeechactModel receiveModel= assistant.createReceiveSpeechact(name,(JADLFileModel)wrapper.getMapping(activity.getPool()));
			mapping= assistant.createPlanelementCallModel(receiveModel.getName());
			break;
		case SEND:
			SendSpeechactModel sendModel= assistant.createSendSpeechact(name,(JADLFileModel)wrapper.getMapping(activity.getPool()));
			mapping= assistant.createPlanelementCallModel(sendModel.getName());
			break;
		case SCRIPT:
			mapping= JiacMiniParser.parseScript(activity.getScript());
			break;
		case TASKREFERENCE:
			if (activity.getActivityRef() != activity) {
				return visitActivity(activity.getActivityRef());	
			}
			break;
		default: 
			mapping= assistant.createLogInfo(activity.getName());
		}
		
		//loop mappings
		if (activity.getLoopAttributes() instanceof StandardLoopAttSet) {
			mapping= createStandardLoop(activity, mapping);
		}
		if (activity.getLoopAttributes() instanceof MultiLoopAttSet) {
			mapping= createMultiInstanceLoop(activity, mapping);
		}
		
		//map properties
		ScriptModel scriptModel= scriptModels.get(activity.getAbstractProcess());
		assistant.visitProperties(activity.getProperties(), scriptModel);
		
		return mapping;
	}
	

	/**
	 * Standard Loop Mapping
	 * 
	 * @param activity			the original activity holding the loop attributes
	 * @param scriptbodyModel	the activity's mapping to be embedded in the loop
	 * @return					sequence with loop
	 */
	private ScriptbodyModel createStandardLoop(Activity activity, ScriptbodyModel scriptbodyModel) throws JAXBException {
		TrafoLog.info("creating standard loop structure for '" + activity.getName() + "'");
		StandardLoopAttSet attSet= (StandardLoopAttSet) activity.getLoopAttributes();
		
		//the sequence model holding the loop, assignments, etc.
		SeqExecutionModel seqModel= jadlFac.createSeqExecutionModel();
		
		if (! attSet.isTestBefore()) {
			//insert copy of the loop body before the loop
			seqModel.getSteps().add(scriptbodyModel);
		}
		
		/*
		 * TODO support loopCounter
		 * this will require the use of ontology functions (for counting)
		 */
		
		//create loop conditional (automatically inserted into JadlFile)
		String loopCond= attSet.getLoopCondition() != null ? attSet.getLoopCondition().getExpression() : "true";
		FormulaModel formulaModel= JiacMiniParser.parseFormula(loopCond);
		ConditionalModel conditional= assistant.createSimpleConditional(activity.getName() + "_loopCondition", activity, formulaModel);
		
		//create pe call model for the conditional
		PlanelementCallModel peCall= jadlFac.createPlanelementCallModel();
		peCall.setPlanelement(conditional.getName());
		
		//create abort case
		StepModel abortCase= jadlFac.createStepModel();
		abortCase.setBreak(true);
		
		//create branch model for the loop
		BranchModel branchModel= jadlFac.createBranchModel();
		branchModel.setType("loop");
		branchModel.setPlanelement(peCall);
		branchModel.getCase().add(scriptbodyModel);
		branchModel.getCase().add(abortCase);
		
		//create step model and put it into the sequence model
		StepModel loopStepModel= jadlFac.createStepModel();
		loopStepModel.setLoop(branchModel);
		seqModel.getSteps().add(loopStepModel);
		
		return seqModel;
	}
	
	
	/**
	 * TODO MultiInstance Loop Mapping
	 * 
	 * @param activity			the original activity holding the loop attributes
	 * @param scriptbodyModel	the activity's mapping to be embedded in the loop
	 * @return					sequence with MI loop
	 */
	private ScriptbodyModel createMultiInstanceLoop(Activity activity, ScriptbodyModel scriptbodyModel) throws JAXBException {
		return null;
	}
	
	
	/**
	 * Gateways themselves have no mapping. If they are part of a block-structure, they will determine the mapping of
	 * the block-structure. If they have assignments, the assignments will be mapped in the visitFlowObject method.
	 * 
	 * @param gateway	the gateway
	 * @return			the mapping result (in this case, null)
	 */
	private ScriptbodyModel visitGateway(Gateway gateway) {
		return null;
	}
	

	/**
	 * Visit connection: Nothing special is done here.
	 * 
	 * @param connection	some BPMN connection object
	 */
	private void visitConnection(ConnectingObject connection) {
	}
	
	
	/**
	 * Visit a given BPMN agent artifact and create an AgentRole file for it.
	 * 
	 * @param bpmnAgent	BPMN Agent artifact
	 * @param pack		package name
	 * @return			new AgentRoleType to be saved in a AgentRole file
	 */
//	private AgentRoleType visitAgent(Agent bpmnAgent, String pack) {
//		AgentRoleFactory fac= AgentRoleFactory.eINSTANCE;
//		AgentRoleType agent= fac.createAgentRoleType();
//		//set name and type and package
//		agent.setName(pack + "." + bpmnAgent.getName());
//		agent.setType(bpmnAgent.getType().getName().toLowerCase());
//		agent.setPackage(pack);
//		
//		//create properties container
//		agent.setBeans(fac.createBeans());
//		agent.setFacts(fac.createFacts());
//		agent.setOntologies(fac.createOntologies());
//		agent.setPlans(fac.createPlans());
//		agent.setRules(fac.createRules());
//		agent.setServices(fac.createServices());
//		
//		//iterate over associated artifacts and pool to fill agents, roles and plans lists
//		List<Association> allAssociations= new ArrayList<Association>();
//		allAssociations.addAll(bpmnAgent.getIncomingAss());
//		allAssociations.addAll(bpmnAgent.getOutgoingAss());
//		List<Agent> agentList= new ArrayList<Agent>();
//		List<Agent> roleList= new ArrayList<Agent>();
//		List<Pool> planList= new ArrayList<Pool>();
//		for (Association ass : allAssociations) {
//			GraphicalObject obj= ass.getSource() == bpmnAgent ? ass.getTarget() : ass.getSource();
//			if (obj instanceof Agent && ((Agent) obj).getType() == AgentType.AGENT) {
//				agentList.add((Agent) obj);
//			}
//			if (obj instanceof Agent && ((Agent) obj).getType() == AgentType.ROLE &&
//					(obj == ass.getTarget() && ass.getDirection() == DirectionType.ONE)) {
//				roleList.add((Agent) obj);
//			}
//			if (obj instanceof Pool) {
//				planList.add((Pool) obj);
//			}
//		}
//		
//		if (bpmnAgent.getType() == AgentType.PLATFORM) {
//			if (! agentList.isEmpty()) {
//				//create AMS bean
//				BeanType bean= fac.createBeanType();
//				bean.setName("#AMSProviderBean");
//				bean.setPackage("#de.dailab.jiac.component");
//				BeanProperties beanProp= fac.createBeanProperties();
//				beanProp.setDescription("The agents residing on this platform.");
//				beanProp.setKey("de.dailab.jiac.component.AMSProviderBean.agents");
//				StringBuffer value= new StringBuffer();
//				
//				//add agent references to AMS bean
//				Hashtable<String, Integer> counter= new Hashtable<String, Integer>();
//				for (Agent a : agentList) {
//					if (a.getType() == AgentType.AGENT) {
//						String name= a.getName();
//						BeanProperties dependent= fac.createBeanProperties();
//						dependent.setKey("PropFile");
//						dependent.setValue(pack+"."+name);
//						Integer c= counter.get(name);
//						c= c==null? 0 : c;
//						counter.put(name, c+1);
//						dependent.setDepends(name + c);
//						value.append(name + c + " ");
//						beanProp.getDependentproperty().add(dependent);
//					}
//				}
//				beanProp.setValue(value.toString().trim());
//				bean.getBeanproperties().add(beanProp);
//				agent.getBeans().getBean().add(bean);
//			}
//			//DF agent role reference
//			AgentRoleRefType ref= fac.createAgentRoleRefType();
//			ref.setName("de.dailab.jiac.StandardJIACAgentRole:StandardJIACAgentPlatformDistributedDF");
//			ref.setPackage("de.dailab.jiac");
//			agent.getAgentRoleRef().add(ref);
//		}
//		
//		if (bpmnAgent.getType() == AgentType.AGENT) {
//			//add Mobility agent role ref
//			AgentRoleRefType ref= fac.createAgentRoleRefType();
//			ref.setName("de.dailab.jiac.StandardJIACAgentRole:MobileAgent");
//			ref.setPackage("de.dailab.jiac");
//			agent.getAgentRoleRef().add(ref);
//		}
//		
//		//AgentRoles referenced by associations
//		for (Agent a : roleList) {
//			AgentRoleRefType ref= fac.createAgentRoleRefType();
//			ref.setName(pack + "." + a.getName());
//			ref.setPackage(pack);
//			agent.getAgentRoleRef().add(ref);
//		}
//		
//		//plans referenced by associations
//		for (Pool pool : planList) {
//			PlanType plan= fac.createPlanType();
//			plan.setName(pool.getName());
//			plan.setPackage(pack);
//			agent.getPlans().getPlan().add(plan);
//			
//			//add services, too; iterate over service artifacts
//			for (Iterator<Artifact> iter2 = pool.getParentDiagram().getArtifacts().iterator(); iter2.hasNext();) {
//				Artifact artifact = iter2.next();
//				if (artifact instanceof Service) {
//					Service bpmnService= (Service) artifact;
//					if (bpmnService.getUser() == pool || bpmnService.getProvider() == pool) {
//						ServiceType service= fac.createServiceType();
//						service.setName(bpmnService.getName());
//						service.setPackage(pack);
//						agent.getServices().getService().add(service);
//					}
//				}
//			}
//		}
//		return agent;
//	}
	
	/**
	 * Visit a given BPMN Service Artifact and create a JADL Service file for it.
	 * 
	 * @param bpmnService	the BPMN service artifact
	 * @param pack			the package
	 * @return				JADL file model with service action
	 * @throws JAXBException
	 */
//	private JADLFileModel visitService(Service bpmnService, String pack) throws JAXBException {
//		
//		String name= bpmnService.getName();
//		
//		ProtocolObjModel protObj= jadlFac.createProtocolObjModel();
//		protObj.setName(name + PROTOCOL_SUFFIX);
//		protObj.setMulti(bpmnService.isMultiple());
//		protObj.setProvider(bpmnService.getUser() == null);
//		
//		ServiceObjModel serviceObj= jadlFac.createServiceObjModel();
//		serviceObj.setName(name);
//		serviceObj.getOntology().add("de.dailab.kit.ontology.Service:DAI_1");
//		serviceObj.getProtocol().add(protObj);
//		
//		ActModel actModel= assistant.createActModel(name + "_act");
//		actModel.setBody(serviceObj);
//		
//		JADLFileModel service= jadlFac.createJADLFileModel();
//		service.getAct().add(actModel);
//		service.setFile(name);
//		service.setPackage(pack);
//		
//		return service;
//	}
	
	
	//////////////////////////////////////////////////////
	// SPECIAL STRUCTURED BPMN OBJECTS
	//////////////////////////////////////////////////////
	
	/**
	 * - visit elements
	 * - put elements in sequence
	 * - if elements already are sequences, flatten sequence
	 * 
	 * @param bpmnSequence	a BPMN sequence, that has been created with the SequenceRule
	 * @return				the activity to which the BpmnSequence has been mapped (a TSequence)
	 */
	private ScriptbodyModel visitBpmnSequence(BpmnSequence bpmnSequence) throws JAXBException {
		
		SeqExecutionModel seqModel= jadlFac.createSeqExecutionModel();
		for (Iterator<FlowObject> iterator = bpmnSequence.getElements().iterator(); iterator.hasNext();) {
			FlowObject flowObject = iterator.next();
			ScriptbodyModel activity= visitFlowObject(flowObject);
			if (activity instanceof SeqExecutionModel) {
				SeqExecutionModel seq2 = (SeqExecutionModel) activity;
				seqModel.getSteps().addAll(seq2.getSteps());
			} else {
				seqModel.getSteps().add(activity);
			}
		}
		return seqModel;
	}
	
	/**
	 * - determine block type from the forking gateway and create block structure
	 * - in a loop, fill the block with it' elements
	 * 
	 * @param bpmnBlock		a BPMN block, that has been created with the BlockRule
	 * @return				the activity to which the BpmnBlock has been mapped (a TFlow, TSwitch or TPick)
	 */
	private ScriptbodyModel visitBpmnBlock(BpmnBlock bpmnBlock) throws JAXBException {
		Gateway fork= bpmnBlock.getFirstGateway();

		//AND Gateway: Create a simple Par
		if (fork.getGatewayType() == GatewayType.AND ) {
			ParExecutionModel block= jadlFac.createParExecutionModel();
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				ScriptbodyModel activity= visitFlowObject(flowObject);
				block.getSteps().add(activity);
			}
			return block;
		}
		
		if (fork.getGatewayType() == GatewayType.XOR_DATA ) {
			//create branch model
			StepModel block= jadlFac.createStepModel();
			BranchModel branchModel= jadlFac.createBranchModel();
			branchModel.setType("branch");
			block.setBranch(branchModel);
			
			ConditionalModel condModel= assistant.createPlainConditional(fork.getName() + "_conditional", fork);
			branchModel.setPlanelement(assistant.createPlanelementCallModel(condModel.getName()));
			
			//index of non-default cases
			int index= 0;
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				ScriptbodyModel activity= visitFlowObject(flowObject);
				
				
				//insert case into branch and extend conditional model
				if (bpmnBlock.getDefaultElement() == flowObject) {
					branchModel.getCase().add(activity);
					//insert true at the end of the conditional
					TruthModel truthModel= jadlFac.createTruthModel();
					truthModel.setValue("true");
					condModel.getFormula().add(truthModel);
				} else {
					branchModel.getCase().add(index,activity);
					//parse condition and insert at first position into the condition model
					String condition= assistant.getCondition(branch.getCondition());
					FormulaModel formulaModel= JiacMiniParser.parseFormula(condition);
					condModel.getFormula().add(index,formulaModel);
					index++;
				}
			}
			return block;
		}
		
		if (fork.getGatewayType() == GatewayType.XOR_EVENT ) {
			//TODO XOR Event Gateway Block Mapping
		}
		
		if (fork.getGatewayType() == GatewayType.OR ) {
			boolean hasDefault= false;
			String varName= fork.getName() + "_defaultRequired";
			
			//create par
			ParExecutionModel parModel= jadlFac.createParExecutionModel();
			SeqExecutionModel outerSeqModel= null;
			
			if (bpmnBlock.getDefaultElement() != null) {
				hasDefault= true;
				//has default gate -> outer sequence and tracking variable needed
				outerSeqModel= jadlFac.createSeqExecutionModel();
				
				//create tracking variable and message
				ScriptModel scriptModel= scriptModels.get(fork.getAbstractProcess());
				assistant.createVariable(varName, "bool", null, scriptModel, true);
				
				//create initializing assign
				VarModel varModel= jadlFac.createVarModel();
				varModel.setVariable(varName);
				BoolModel termModel= jadlFac.createBoolModel();
				termModel.setBool(true);
				StepModel assign= assistant.createAssign(varModel,termModel);
				outerSeqModel.getSteps().add(assign);
				outerSeqModel.getSteps().add(parModel);
			}
			
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				ScriptbodyModel activity= visitFlowObject(flowObject);
				
				//FIXME maybe a branch should be used here instead of eval, since this might have side effects
				//the again, using a set of branches would complicate the understanding of the code a lot...
				
				//create sequence (for the evaluation of the condition)
				SeqExecutionModel seqModel= null;
				if (activity instanceof SeqExecutionModel) {
					seqModel= (SeqExecutionModel) activity;
				} else {
					seqModel= jadlFac.createSeqExecutionModel();
					seqModel.getSteps().add(activity);
				}
			
				if (bpmnBlock.getDefaultElement() == flowObject) {
					//FIXME handling the default case
					AltExecutionModel alt= jadlFac.createAltExecutionModel();
					EvalModel eval= jadlFac.createEvalModel();
					String condition= "isTrue("+varName+")"; //FIXME test condition for executing the default
					eval.setFormula(JiacMiniParser.parseFormula(condition));
					StepModel evalStep= jadlFac.createStepModel();
					evalStep.setEval(eval);
					seqModel.getSteps().add(0,evalStep);
					StepModel contStep= jadlFac.createStepModel();
					contStep.setCont(true);
					alt.getSteps().add(seqModel);
					alt.getSteps().add(contStep);
					outerSeqModel.getSteps().add(alt);
					
				} else {
					
					if (hasDefault) {
						SeqExecutionModel seqForAct= null;
						if (activity instanceof SeqExecutionModel) {
							seqForAct = (SeqExecutionModel) activity;
						} else {
							seqForAct= jadlFac.createSeqExecutionModel();
							seqForAct.getSteps().add(activity);
						}
						//add an assignment to the defaultRequired variable at the end of the case
						VarModel varModel= jadlFac.createVarModel();
						varModel.setVariable(varName);
						BoolModel boolModel= jadlFac.createBoolModel();
						boolModel.setBool(false);
						StepModel assign= assistant.createAssign(varModel,boolModel);
						seqForAct.getSteps().add(assign);
						activity= seqForAct;
					}
					
					AltExecutionModel alt= jadlFac.createAltExecutionModel();
					EvalModel eval= jadlFac.createEvalModel();
					String condition= assistant.getCondition(branch.getCondition());
					eval.setFormula(JiacMiniParser.parseFormula(condition));
					StepModel evalStep= jadlFac.createStepModel();
					evalStep.setEval(eval);
					seqModel.getSteps().add(0,evalStep);
					StepModel contStep= jadlFac.createStepModel();
					contStep.setCont(true);
					alt.getSteps().add(seqModel);
					alt.getSteps().add(contStep);
					parModel.getSteps().add(alt);
				}	
			}
			return hasDefault ? outerSeqModel : parModel;	
		}
		
		// Complex Gateway: Not mappped to JADL; Create a simple Par instead.
		if (fork.getGatewayType() == GatewayType.COMPLEX ) {
			//use flow, but post a warning  
			TrafoLog.warn("The mapping for complex gateways still is an open issue. Using Flow element");
			ParExecutionModel block= jadlFac.createParExecutionModel();
			for (BpmnBranch branch : bpmnBlock.getElements()) {
				FlowObject flowObject = branch.getElement();
				ScriptbodyModel activity= visitFlowObject(flowObject);
				block.getSteps().add(activity);
			}
			return block;
		}
		
		return null;
	}
	
	/**
	 * - compose loop condition from given loopCondition and exitCondition
	 * - assemble the loop body from firstElement and/or secondElement
	 * - create the actual loop structure, holding the loop body
	 * - return the loop structure, eventually wrapped in a sequence and preceded by a copy of firstElement 
	 * 
	 * @param bpmnLoopBlock	a BPMN loop block, that has been created with the LoopRule
	 * @return				the activity to which the BpmnLoopBlock has been mapped (a TSequence or TSwitch)
	 */
	private ScriptbodyModel visitBpmnLoopBlock(BpmnLoopBlock bpmnLoopBlock) throws JAXBException {
		
		ScriptbodyModel activity1= visitFlowObject(bpmnLoopBlock.getFirstBranch().getElement());
		ScriptbodyModel activity2= visitFlowObject(bpmnLoopBlock.getSecondBranch().getElement());
		
		// I. COMPOSE LOOP CONDITION AND CONDITIONAL MODEL
		String cond= assistant.getCondition(bpmnLoopBlock.getSecondBranch().getCondition());
		if (bpmnLoopBlock.getSecondBranch().getCondition() == null) {
			//use negated exit condition
			cond= "not (" + bpmnLoopBlock.getExitBranch().getCondition() + ")";
		}
		String name= bpmnLoopBlock.getFirstGateway().getName() + "_" + bpmnLoopBlock.getSecondGateway().getName() + "_loop";
		String condName= name + "_conditional";
		FormulaModel formulaModel= JiacMiniParser.parseFormula(cond);
		assistant.createSimpleConditional(condName, bpmnLoopBlock.getFirstGateway(), formulaModel);
		
		
		// II. ASSEMBLE LOOP BODY
		ScriptbodyModel loopBody= null;
		if (activity1 != null && activity2 != null) {
			//create sequence holding activity 2 and 1
			SeqExecutionModel seq;
			if (activity2 instanceof SeqExecutionModel) {
				seq= (SeqExecutionModel) activity2;
			} else {
				seq= jadlFac.createSeqExecutionModel();
				seq.getSteps().add(activity2);
			}
			if (activity1 instanceof SeqExecutionModel) {
				SeqExecutionModel seq2 = (SeqExecutionModel) activity1;
				seq.getSteps().addAll(seq2.getSteps());
			} else {
				seq.getSteps().add(activity1);
			}
			loopBody= seq;
		} else {
			//use existing element
			loopBody= activity1 != null ? activity1 : activity2;
		}
		
		// III. CREATE WHILE LOOP STRUCTURE
		//create pe call model, calling the conditional
		PlanelementCallModel peCall= assistant.createPlanelementCallModel(condName);
		
		//create break model, ending the loop
		StepModel breakModel= jadlFac.createStepModel();
		breakModel.setBreak(true);
		
		BranchModel branch= jadlFac.createBranchModel();
		branch.setType("loop");
		branch.setPlanelement(peCall);
		branch.getCase().add(loopBody);
		branch.getCase().add(breakModel);
		
		StepModel branchStep= jadlFac.createStepModel();
		branchStep.setBranch(branch);
		
		// IV. ASSEMBLE SEQUENCE HODING THE LOOP (and return it)
		if (activity1 == null) {
			// only the loop
			return branchStep;
		} else {
			// a sequence holding a copy of activity 1 and the loop
			ScriptbodyModel activity1_copy= activity1 != null ? activity1 : null; //no copy needed using JAXB
			if (activity1_copy instanceof SeqExecutionModel) {
				SeqExecutionModel act1_copy_sequence = (SeqExecutionModel) activity1_copy;
				act1_copy_sequence.getSteps().add(branchStep);
				return act1_copy_sequence;
			} else {
				SeqExecutionModel sequence= jadlFac.createSeqExecutionModel();
				sequence.getSteps().add(activity1_copy);
				sequence.getSteps().add(branchStep);
				return sequence;
			}
		}
	}
	
	/**
	 * - create a call to the derived process
	 * - if no such process exists yet, create the process
	 * 
	 * @param bpmnDerivedProcess	a BPMN derived process
	 * @return						the activity to which the process has been mapped
	 */
	private ScriptbodyModel visitBpmnDerivedProcess(BpmnDerivedProcess bpmnDerivedProcess) throws JAXBException {
		return null;
	}
	
	/**
	 * TODO visitBpmnEventHandlerBlock
	 * - map the contained activity
	 * - wrap it in a scope if it isn't one, yet
	 * - for each event handler case...
	 *   - map the intermediate and the compensation part
	 *   - if it has a skip part, create a variable and assignments accordingly 
	 * 
	 * @param bpmnEventHandlerBlock	a BPMN event handler block, that has been created in the BoundaryEventBlockRule
	 * @return						the activity to which the block has been mapped (a TScope)
	 */
	private ScriptbodyModel visitBpmnEventHandlerBlock(BpmnEventHandlerBlock bpmnEventHandlerBlock) throws JAXBException {
		return null;
	}
	
	/**
	 * TODO visitBpmnElementToSkip
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
	private ScriptbodyModel visitBpmnElementToSkip(BpmnElementToSkip bpmnElementToSkip) throws JAXBException {
		return null;
	}
	
	
}
