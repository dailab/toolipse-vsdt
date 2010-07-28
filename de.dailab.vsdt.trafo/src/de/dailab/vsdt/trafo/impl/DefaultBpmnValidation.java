package de.dailab.vsdt.trafo.impl;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.Artifact;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowConditionTypes;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.LoopAttributeSet;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.trafo.MappingStage;
import de.dailab.vsdt.trafo.base.util.TrafoLog;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * Abstract BPMN pre-visitor. This purpose of the pre-visitor is to check if all
 * constraints needed for the mapping are satisfied and to put the diagram in a 
 * normalized form, e.g. by applying normalization rules and by removing illegal 
 * characters from names. Afterwards, the actual export visitor will not have to 
 * care much about null-checks, naming conventions etc., making the export logic 
 * less heavy and easier to understand.
 * 
 * Methods that are encouraged to be overwritten in a subclass are marked with three 'X'
 * 
 * Objects and attributes that are NOT visited yet are
 * - most BPD attributes
 * - adHoc attributes
 * - input, output, IOrules, quantities
 * - transactions
 * 
 * @author tkuester
 */
public class DefaultBpmnValidation extends MappingStage {
	
	public static final int NORM_NAME_DIAGRAM= 0;
	public static final int NORM_NAME_ELEMENT= 1;
	public static final int NORM_NAME_PROPERTY= 2;
	public static final int NORM_NAME_MESSAGE= 3;
	
	/**BPMN package instance*/
	public static final VsdtPackage vsdt= VsdtPackage.eINSTANCE;
	
	/**this map is holding names that are already in use*/
	private Map<String, Object> _uniqueNamesInUse;

	@Override
	public void initialize() {
		_uniqueNamesInUse= new HashMap<String, Object>();
	}
	
	@Override
	protected boolean internalApply() {
		return visitBusinessProcessSystem((BusinessProcessSystem) wrapper.getSourceModel());
	}
	
	//////////////////////////////////////////////////////////
	// NORMALIZATION, E.G. OF NAMES
	//////////////////////////////////////////////////////////
	
	/**
	 * trim a name off all white spaces and other non-alphanumeric chars
	 * and append a number if the string is not unique
	 * 
	 * @param string	valid BPMN name
	 * @param type		type of the string to norm, e.g. expression, condition, name, ...
	 * @param owner
	 * @return			unique valid BPEL/JIAC/whatever name
	 */
	public String normUnique(String string, int type, Object owner) {
		return norm(string, type, owner, true);
	}
	
	/**
	 * trim a name off all white spaces and other non-alphanumeric chars
	 * 
	 * @param string	valid BPMN name
	 * @param type		type of the string to norm, e.g. expression, condition, name, ...
	 * @return			valid BPEL/JIAC/whatever name
	 */
	public String norm(String string, int type) {
		return norm(string, type, null, false);
	}
	
	private String norm(String string, int type, Object owner, boolean unique) {
		String newName;
		if (string == null) {
			newName= ""; //$NON-NLS-1$
		} else {
			newName= replaceIllegalChars(string, type);
		}
		if (unique) {
			if (newName.startsWith("__")) { //$NON-NLS-1$
				//this marks auto-generated names, e.g. for empty activities temporarily inserted between gateways
				return newName;
			}
			//note: contains uses 'equals'
			int i= 1;
			String newUniqueName= newName;
			while (_uniqueNamesInUse.containsKey(newUniqueName) && _uniqueNamesInUse.get(newUniqueName) != owner) {
				newUniqueName= newName + i;
				i++;
			}
			newName= newUniqueName;
			_uniqueNamesInUse.put(newName, owner);
		}
		if (string != null && ! newName.equals(string)) {
			TrafoLog.info("Changed identifier '" + string + "' to '" + newName + "'");
		}
		
		return newName;
	}
	
	/**
	 * Replace illegal characters.
	 * XXX This method should be overwritten if the specific language allows 
	 * more or less characters to be used in names or another replacing algorithm 
	 * shall be used. Default: special chars and white spaces replaced with ''.
	 * 
	 * @param s			the string to norm
	 * @param type		type of the string to norm, e.g. expression, condition, name, ...
	 * @return
	 */
	protected String replaceIllegalChars(String s, int type) {
		return s.replaceAll("\\s", "").replaceAll("\\W", ""); //$NON-NLS1$
	}

	//////////////////////////////////////////////////////////
	// TESTING
	//////////////////////////////////////////////////////////
	
	/**
	 * helper method for testing conditions. If the condition is false, the 
	 * given errorMessage is logged.
	 * 
	 * @param condition		some test condition
	 * @param errorMessage	error message to be logged in case the test fails
	 * @return				test successful?
	 */
	protected boolean test(boolean condition, String errorMessage) {
		if (! condition) {
			TrafoLog.error(errorMessage);
		}
		return condition;
	}
	
	/**
	 * test whether the given element is null and print out a message accordingly
	 * 
	 * @param object	some required element, that may not be null
	 * @return			element is null?
	 */
	protected boolean testIsNull(EObject object) {
		if (object == null) {
			TrafoLog.error("Required element is null");
		}
		return object == null;
	}
	
	/**
	 * helper method for testing a children's condition. If the condition fails 
	 * (that is, the child contains errors) an "at"-entry is logged.
	 * 
	 * @param condition		some test condition for a child element
	 * @param parent		the parent element
	 * @return				test successful?
	 */
	protected boolean testChild(boolean condition, EObject parent, EStructuralFeature feature) {
		String name= VsdtHelper.getName(parent); 
		if (! condition) {
			TrafoLog.error("  at Feature " + parent.eClass().getName() + "." + feature.getName() + 
					(name == null || "".equals(name) ? "" : (" of object '" + name + "'")));
		}
		return condition;
	}
	
	//////////////////////////////////////////////////////////
	// VISITOR LOGIC
	//////////////////////////////////////////////////////////
	
	protected boolean visitBusinessProcessSystem(BusinessProcessSystem bps) {
		if (testIsNull(bps)) return false;
		boolean isOK= true;
		
		//normalize business process system's name
		bps.setName(norm(bps.getName(), NORM_NAME_DIAGRAM));
		
		for (BusinessProcessDiagram bpd : bps.getBusinessProcesses()) {
			isOK&= testChild(visitBusinessProcessDiagram(bpd), bps, vsdt.getBusinessProcessSystem_BusinessProcesses());
		}
		
		for (Message message : bps.getMessages()) {
			isOK&= testChild(visitMessage(message),bps,vsdt.getBusinessProcessSystem_Messages());
		}
		for (Participant participant : bps.getParticipants()) {
			isOK&= testChild(visitParticipant(participant),bps,vsdt.getBusinessProcessSystem_Participants());
		}
		for (Implementation webService : bps.getImplementations()) {
			isOK&= testChild(visitImplementation(webService),bps,vsdt.getBusinessProcessSystem_Implementations());
		}
		return isOK;
	}
	
	
	/**
	 * trim name, visit pools, connections, artifacts and supporting types
	 */
	protected boolean visitBusinessProcessDiagram(BusinessProcessDiagram bpd) {
		if (testIsNull(bpd)) return false;
		boolean isOK= true;
		
		//normalize business process diagram's name
		bpd.setName(norm(bpd.getName(), NORM_NAME_DIAGRAM));
		
		//visit children
		for (Pool pool : bpd.getPools()) {
			isOK&= testChild(visitPool(pool),bpd,vsdt.getBusinessProcessDiagram_Pools());
		}
		for (ConnectingObject connection : bpd.getConnections()) {
			isOK&= testChild(visitConnection(connection),bpd,vsdt.getBusinessProcessDiagram_Connections());
		}
		for (Artifact artifact : bpd.getArtifacts()) {
			isOK&= testChild(visitArtifact(artifact),bpd,vsdt.getBusinessProcessDiagram_Artifacts());
		}
		return isOK;
	}
	
	// NODES
	
	/**
	 * trim name, visit process and participant
	 */
	protected boolean visitPool(Pool pool) {
		if (testIsNull(pool)) return false;
		boolean isOK= true;
		
		//normalize name
		pool.setName(norm(pool.getName(), NORM_NAME_ELEMENT));
		
		//visit children
		for (Lane lane : pool.getLanes()) {
			isOK&= testChild(visitLane(lane),pool,vsdt.getPool_Lanes());
		}
		for (Property property : pool.getProperties()) {
			isOK&= testChild(visitProperty(property),pool,vsdt.getAbstractProcess_Properties());
		}
		
		//tested in visitSuportingTypes
		isOK&= test(pool.getParticipant() != null, "Participant must not be null");
		
		return isOK;
	}
	
	/**
	 * normalize name, visit flow objects
	 */
	protected boolean visitLane(Lane lane) {
		if (testIsNull(lane)) return false;
		boolean isOK= true;
		
		//normalize name
		lane.setName(norm(lane.getName(), NORM_NAME_ELEMENT));
		
		//visit children
		for (FlowObject flowObject : lane.getContainedFlowObjects()) {
			isOK&= testChild(visitFlowObject(flowObject),lane,vsdt.getFlowObjectContainer_ContainedFlowObjects());
		}
		
		return isOK;
	}
	
	
	/**
	 * trim name, visit assignments, delegate to specializations
	 */
	protected boolean visitFlowObject(FlowObject flowObject) {
		if (testIsNull(flowObject)) return false;
		boolean isOK= true;
		
		//normalize name
		flowObject.setName(norm(flowObject.getName(), NORM_NAME_ELEMENT));
		
		//visit children
		for (Assignment assignment : flowObject.getAssignments()) {
			isOK&= testChild(visitAssignment(assignment),flowObject,vsdt.getFlowObject_Assignments());
		}
		//delegate
		if (flowObject instanceof Event) {
			Event event = (Event) flowObject;
			isOK&= visitEvent(event);
		}
		if (flowObject instanceof Activity) {
			Activity activity = (Activity) flowObject;
			isOK&= visitActivity(activity);
		}
		if (flowObject instanceof Gateway) {
			Gateway gateway = (Gateway) flowObject;
			isOK&= visitGateway(gateway);
		}
		
		return isOK;
	}
	
	/**
	 * visit attribute set
	 */
	protected boolean visitEvent(Event event) {
		if (testIsNull(event)) return false;
		boolean isOK= true;
		
		if (event.getTrigger() == TriggerType.MESSAGE) {
			isOK&= testChild(visitMessage(event.getMessage()),event,vsdt.getEvent_Message());
			isOK&= testChild(visitImplementation(event.getImplementation()),event,vsdt.getEvent_Message());
		}
		if (event.getTrigger() == TriggerType.RULE) {
//			event.setRuleName(norm(event.getRuleName(), NORM_NAME_ELEMENT));
			isOK&= testChild(visitExpression(event.getRuleExpression()),event,vsdt.getEvent_RuleExpression());
		}
		if (event.getTrigger() == TriggerType.TIMER) {
			visitExpression(event.getTimeExpression());
//			isOK&= test(event.getTimeCycle() != null || event.getTimeDate() != null,
//					"Either Time Cycle or Time Date must be set");
//			if (event.getTimeCycle() != null) {
//				visitExpression(event.getTimeCycle());
//			}
//			if (event.getTimeDate() != null) {
//				visitExpression(event.getTimeDate());
//			}
		}
		if (event.getTrigger() == TriggerType.LINK) {
			isOK&= test(event.getLinkedTo() != null,"Link must not be null");
		}
		if (event.getTrigger() == TriggerType.COMPENSATION) {
			isOK&= test(event.getActivity() != null,"Activity must not be null");
		}

		return isOK;
	}
	
	/**
	 * visit loop attributes, activity attributes, boundary events
	 */
	protected boolean visitActivity(Activity activity) {
		if (testIsNull(activity)) return false;
		boolean isOK= true;
		
		//visit children
		if (activity.getLoopAttributes() != null) {
			isOK&= testChild(visitLoopAttributes(activity.getLoopAttributes()),activity,vsdt.getActivity_LoopAttributes());
		}
		for (Intermediate intermediate : activity.getBoundaryEvents()) {
			isOK&= testChild(visitFlowObject(intermediate),activity,vsdt.getActivity_BoundaryEvents());
		}
		for (FlowObject flowObject : activity.getContainedFlowObjects()) {
			isOK&= testChild(visitFlowObject(flowObject),activity,vsdt.getFlowObjectContainer_ContainedFlowObjects());
		}

		switch (activity.getActivityType().getValue()) {
		case ActivityType.SERVICE_VALUE:
			isOK&= testChild(visitMessage(activity.getInMessage()),activity,vsdt.getActivity_InMessage());
			isOK&= testChild(visitMessage(activity.getOutMessage()),activity,vsdt.getActivity_OutMessage());
			isOK&= testChild(visitImplementation(activity.getImplementation()),activity,vsdt.getActivity_Implementation());
			break;
		case ActivityType.SEND_VALUE:	
			isOK&= testChild(visitMessage(activity.getInMessage()),activity,vsdt.getActivity_InMessage());
			isOK&= testChild(visitImplementation(activity.getImplementation()),activity,vsdt.getActivity_Implementation());
			break;
		case ActivityType.RECEIVE_VALUE:	
			isOK&= testChild(visitMessage(activity.getOutMessage()),activity,vsdt.getActivity_OutMessage());
			isOK&= testChild(visitImplementation(activity.getImplementation()),activity,vsdt.getActivity_Implementation());
			break;
		case ActivityType.USER_VALUE:
			isOK&= testChild(visitMessage(activity.getInMessage()),activity,vsdt.getActivity_InMessage());
			isOK&= testChild(visitMessage(activity.getOutMessage()),activity,vsdt.getActivity_OutMessage());
			isOK&= testChild(visitImplementation(activity.getImplementation()),activity,vsdt.getActivity_Implementation());
			break;
		case ActivityType.TASKREFERENCE_VALUE:
		case ActivityType.SUBPROCESSREFERENCE_VALUE:
			isOK&= test(activity.getActivityRef() != null,"Task Reference Must not be null");
			isOK&= test(activity.getActivityRef() != activity,"An Activity may not reference itself");
			break;
		case ActivityType.INDEPENDENT_VALUE:
			BusinessProcessDiagram diagram= activity.getDiagramRef();
			Pool process= activity.getProcessRef();
			isOK&= test(diagram != null,"Diagram Reference must not be null");
			isOK&= test(process != null,"Process Reference must not be null");
			isOK&= test(process.getParent() == diagram, "Referenced Process must be part of Referenced Diagram");
			break;
		}
		return isOK;
	}
	
	/**
	 * visit gates, gateway attributes (no checks needed on attributes)
	 */
	protected boolean visitGateway(Gateway gateway){
		if (testIsNull(gateway)) return false;
		boolean isOK= true;

		//visit children
//		switch (gateway.getGatewayType().getValue()) {
//		case GatewayType.AND_VALUE:
//		case GatewayType.XOR_DATA_VALUE:
//		case GatewayType.XOR_EVENT_VALUE:
//		case GatewayType.OR_VALUE:
//		case GatewayType.COMPLEX_VALUE:
//		}
		
		return isOK;
	}
	
	//CONNECTIONS
	
	/**
	 * normalize name, delegate
	 */
	protected boolean visitConnection(ConnectingObject connection) {
		if (testIsNull(connection)) return false;
		boolean isOK= true;

		//normalize name (actually, a connection's name is never needed, but anyway)
		connection.setName(norm(connection.getName(), NORM_NAME_ELEMENT));
		
		//delegate
		if (connection instanceof SequenceFlow) {
			SequenceFlow sequenceFlow = (SequenceFlow) connection;
			isOK&= visitSequenceFlow(sequenceFlow);
		}
		if (connection instanceof MessageFlow) {
			MessageFlow messageFlow = (MessageFlow) connection;
			isOK&= visitMessageFlow(messageFlow);
		}
		if (connection instanceof Association) {
			Association association = (Association) connection;
			isOK&= visitAssociation(association);
		}
		return isOK;
	}
	
	/**
	 * source and target have to be placed in the same abstract process
	 * visit condition
	 */
	protected boolean visitSequenceFlow(SequenceFlow sequenceFlow) {
		if (testIsNull(sequenceFlow)) return false;
		boolean isOK= true;
		
		isOK&= test(sequenceFlow.getSource() != null &&
				sequenceFlow.getTarget() != null &&
				sequenceFlow.getSource().getAbstractProcess() == sequenceFlow.getTarget().getAbstractProcess(),
				"Source and Target must be contained in the same Process or Subprocess");

		//visit condition
		if (sequenceFlow.getConditionType() == ConditionType.EXPRESSION) {
			isOK&= testChild(visitExpression(sequenceFlow.getConditionExpression()),sequenceFlow,vsdt.getSequenceFlow_ConditionExpression());
		}
		
		return isOK;
	}
	
	/**
	 * no checks here.
	 * message is NOT checked, because it is only important if referred to by an 
	 * event or activity; thus the check will be made in the event and activity 
	 * attribute sets
	 */
	protected boolean visitMessageFlow(MessageFlow messageFlow) {
		if (testIsNull(messageFlow)) return false;
		boolean isOK= true;
		return isOK;
	}
	
	/**
	 * no checks here.
	 */
	protected boolean visitAssociation(Association association) {
		if (testIsNull(association)) return false;
		boolean isOK= true;
		return isOK;
	}
	
	//ARTIFACTS
	
	/**
	 * no checks here.
	 * because artifacts are not mapped yet.
	 * XXX may be overwritten in subclass
	 */
	protected boolean visitArtifact(Artifact artifact) {
		if (testIsNull(artifact)) return false;
		boolean isOK= true;
		return isOK;
	}
	
	//SUPPORTING TYPES
	
	/**
	 * visit to, from
	 */
	protected boolean visitAssignment(Assignment assignment) {
		if (testIsNull(assignment)) return false;
		boolean isOK= true;

		//visit children
		isOK&= testChild(visitProperty(assignment.getTo()),assignment,vsdt.getAssignment_To());
		isOK&= testChild(visitExpression(assignment.getFrom()),assignment,vsdt.getAssignment_From());
		
		return isOK;
	}
	
	/**
	 * normalize name
	 */
	protected boolean visitParticipant(Participant participant) {
		if (testIsNull(participant)) return false;
		boolean isOK= true;
		
		participant.setName(normUnique(participant.getName(), NORM_NAME_ELEMENT ,participant));
		
		return isOK;
	}
	
	/**
	 * Expression not null
	 */
	protected boolean visitExpression(Expression expression) {
		if (testIsNull(expression)) return false;
		boolean isOK= true;
		
		isOK&= test(expression.getExpression() != null,"Expression must not be null");
		
		return isOK;
	}
	
	/**
	 * normalize name, visit properties, visit participants
	 */
	protected boolean visitMessage(Message message) {
		if (testIsNull(message)) return false;
		boolean isOK= true;
		
		message.setName(normUnique(message.getName(), NORM_NAME_MESSAGE, message));
		
		for (Property property : message.getProperties()) {
			isOK&= testChild(visitProperty(property),message,vsdt.getMessage_Properties());
		}
		
		return isOK;
	}
	
	/**
	 * normalize name, type 
	 */
	protected boolean visitProperty(Property property) {
		if (testIsNull(property)) return false;
		boolean isOK= true;

		property.setName(norm(property.getName(), NORM_NAME_PROPERTY)); //not unique, since they might be in another scope
		//not normed until better replacement method
//		property.setType(norm(property.getType()));
		
		return isOK;
	}
	
	/**
	 * delegate.
	 * XXX this method should be overwritten if the target language supports other implementation types
	 */
	protected boolean visitImplementation(Implementation implementation) {
		if (testIsNull(implementation)) return false;
		boolean isOK= true;

		isOK&= test(implementation.getType() != null, "Type must not be null");
		isOK&= test(implementation.getOperation() != null,"Operation must not be null");
		isOK&= test(implementation.getInterface() != null,"Interface must not be null");
		isOK&= test(implementation.getParticipant() != null,"Participant must not be null");
		
		return isOK;
	}
	
	/**
	 * delegate
	 */
	protected boolean visitLoopAttributes(LoopAttributeSet loopAttributeSet) {
		if (testIsNull(loopAttributeSet)) return false;
		boolean isOK= true;

		//delegate
		if (loopAttributeSet instanceof StandardLoopAttSet) {
			StandardLoopAttSet standardLoopAttSet = (StandardLoopAttSet) loopAttributeSet;
			isOK&= visitStandardLoopAttributes(standardLoopAttSet);
		}
		if (loopAttributeSet instanceof MultiLoopAttSet) {
			MultiLoopAttSet multiLoopAttSet = (MultiLoopAttSet) loopAttributeSet;
			isOK&= visitMultiLoopAttributes(multiLoopAttSet);
		}
		return isOK;
	}
	
	/**
	 * standard expression check
	 * XXX subclasses may check the loop condition in more detail
	 */
	protected boolean visitStandardLoopAttributes(StandardLoopAttSet standardLoopAttSet) {
		if (testIsNull(standardLoopAttSet)) return false;
		boolean isOK= true;

		//visit children
		if (standardLoopAttSet.getLoopMaximum() < 1) {
			isOK&= testChild(visitExpression(standardLoopAttSet.getLoopCondition()),standardLoopAttSet,vsdt.getStandardLoopAttSet_LoopCondition());	
		}
		
		return isOK;
	}
	
	/**
	 * standard expression check
	 * XXX subclasses may check the loop conditions in more detail
	 */
	protected boolean visitMultiLoopAttributes(MultiLoopAttSet multiLoopAttSet) {
		if (testIsNull(multiLoopAttSet)) return false;
		boolean isOK= true;

		//visit children
		isOK&= testChild(visitExpression(multiLoopAttSet.getMI_Condition()),multiLoopAttSet,vsdt.getMultiLoopAttSet_MI_Condition());
		if (multiLoopAttSet.getMI_FlowCondition() == FlowConditionTypes.COMPLEX) {
			isOK&= testChild(visitExpression(multiLoopAttSet.getComplexMI_FlowCondition()),multiLoopAttSet,vsdt.getMultiLoopAttSet_ComplexMI_FlowCondition());
		}
		
		return isOK;
	}
		
}
