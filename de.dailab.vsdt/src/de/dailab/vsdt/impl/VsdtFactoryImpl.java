/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import de.dailab.vsdt.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.BpmnProcess;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.DirectionType;
import de.dailab.vsdt.End;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowConditionTypes;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.Group;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.InputSet;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.LoopType;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.OutputSet;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.ParticipantType;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.ProcessType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.StatusType;
import de.dailab.vsdt.TextAnnotation;
import de.dailab.vsdt.Transaction;
import de.dailab.vsdt.TransactionMethodType;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VsdtFactoryImpl extends EFactoryImpl implements VsdtFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static VsdtFactory init() {
		try {
			VsdtFactory theVsdtFactory = (VsdtFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.dailab.vsdt"); 
			if (theVsdtFactory != null) {
				return theVsdtFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VsdtFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VsdtFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VsdtPackage.BUSINESS_PROCESS_SYSTEM: return createBusinessProcessSystem();
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM: return createBusinessProcessDiagram();
			case VsdtPackage.BPMN_PROCESS: return createBpmnProcess();
			case VsdtPackage.START: return createStart();
			case VsdtPackage.INTERMEDIATE: return createIntermediate();
			case VsdtPackage.END: return createEnd();
			case VsdtPackage.ACTIVITY: return createActivity();
			case VsdtPackage.STANDARD_LOOP_ATT_SET: return createStandardLoopAttSet();
			case VsdtPackage.MULTI_LOOP_ATT_SET: return createMultiLoopAttSet();
			case VsdtPackage.INPUT_SET: return createInputSet();
			case VsdtPackage.OUTPUT_SET: return createOutputSet();
			case VsdtPackage.TRANSACTION: return createTransaction();
			case VsdtPackage.GATEWAY: return createGateway();
			case VsdtPackage.POOL: return createPool();
			case VsdtPackage.LANE: return createLane();
			case VsdtPackage.DATA_OBJECT: return createDataObject();
			case VsdtPackage.TEXT_ANNOTATION: return createTextAnnotation();
			case VsdtPackage.GROUP: return createGroup();
			case VsdtPackage.SEQUENCE_FLOW: return createSequenceFlow();
			case VsdtPackage.MESSAGE_FLOW: return createMessageFlow();
			case VsdtPackage.ASSOCIATION: return createAssociation();
			case VsdtPackage.PARTICIPANT: return createParticipant();
			case VsdtPackage.MESSAGE: return createMessage();
			case VsdtPackage.IMPLEMENTATION: return createImplementation();
			case VsdtPackage.ASSIGNMENT: return createAssignment();
			case VsdtPackage.PROPERTY: return createProperty();
			case VsdtPackage.EXPRESSION: return createExpression();
			case VsdtPackage.DATA_TYPE: return createDataType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case VsdtPackage.PROCESS_TYPE:
				return createProcessTypeFromString(eDataType, initialValue);
			case VsdtPackage.STATUS_TYPE:
				return createStatusTypeFromString(eDataType, initialValue);
			case VsdtPackage.TRIGGER_TYPE:
				return createTriggerTypeFromString(eDataType, initialValue);
			case VsdtPackage.ACTIVITY_TYPE:
				return createActivityTypeFromString(eDataType, initialValue);
			case VsdtPackage.LOOP_TYPE:
				return createLoopTypeFromString(eDataType, initialValue);
			case VsdtPackage.FLOW_CONDITION_TYPES:
				return createFlowConditionTypesFromString(eDataType, initialValue);
			case VsdtPackage.TRANSACTION_METHOD_TYPE:
				return createTransactionMethodTypeFromString(eDataType, initialValue);
			case VsdtPackage.GATEWAY_TYPE:
				return createGatewayTypeFromString(eDataType, initialValue);
			case VsdtPackage.CONDITION_TYPE:
				return createConditionTypeFromString(eDataType, initialValue);
			case VsdtPackage.DIRECTION_TYPE:
				return createDirectionTypeFromString(eDataType, initialValue);
			case VsdtPackage.PARTICIPANT_TYPE:
				return createParticipantTypeFromString(eDataType, initialValue);
			case VsdtPackage.ASSIGN_TIME_TYPE:
				return createAssignTimeTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case VsdtPackage.PROCESS_TYPE:
				return convertProcessTypeToString(eDataType, instanceValue);
			case VsdtPackage.STATUS_TYPE:
				return convertStatusTypeToString(eDataType, instanceValue);
			case VsdtPackage.TRIGGER_TYPE:
				return convertTriggerTypeToString(eDataType, instanceValue);
			case VsdtPackage.ACTIVITY_TYPE:
				return convertActivityTypeToString(eDataType, instanceValue);
			case VsdtPackage.LOOP_TYPE:
				return convertLoopTypeToString(eDataType, instanceValue);
			case VsdtPackage.FLOW_CONDITION_TYPES:
				return convertFlowConditionTypesToString(eDataType, instanceValue);
			case VsdtPackage.TRANSACTION_METHOD_TYPE:
				return convertTransactionMethodTypeToString(eDataType, instanceValue);
			case VsdtPackage.GATEWAY_TYPE:
				return convertGatewayTypeToString(eDataType, instanceValue);
			case VsdtPackage.CONDITION_TYPE:
				return convertConditionTypeToString(eDataType, instanceValue);
			case VsdtPackage.DIRECTION_TYPE:
				return convertDirectionTypeToString(eDataType, instanceValue);
			case VsdtPackage.PARTICIPANT_TYPE:
				return convertParticipantTypeToString(eDataType, instanceValue);
			case VsdtPackage.ASSIGN_TIME_TYPE:
				return convertAssignTimeTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessSystem createBusinessProcessSystem() {
		BusinessProcessSystemImpl businessProcessSystem = new BusinessProcessSystemImpl();
		return businessProcessSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessDiagram createBusinessProcessDiagram() {
		BusinessProcessDiagramImpl businessProcessDiagram = new BusinessProcessDiagramImpl();
		return businessProcessDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnProcess createBpmnProcess() {
		BpmnProcessImpl bpmnProcess = new BpmnProcessImpl();
		return bpmnProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Start createStart() {
		StartImpl start = new StartImpl();
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intermediate createIntermediate() {
		IntermediateImpl intermediate = new IntermediateImpl();
		return intermediate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public End createEnd() {
		EndImpl end = new EndImpl();
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity createActivity() {
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputSet createInputSet() {
		InputSetImpl inputSet = new InputSetImpl();
		return inputSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputSet createOutputSet() {
		OutputSetImpl outputSet = new OutputSetImpl();
		return outputSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StandardLoopAttSet createStandardLoopAttSet() {
		StandardLoopAttSetImpl standardLoopAttSet = new StandardLoopAttSetImpl();
		return standardLoopAttSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiLoopAttSet createMultiLoopAttSet() {
		MultiLoopAttSetImpl multiLoopAttSet = new MultiLoopAttSetImpl();
		return multiLoopAttSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transaction createTransaction() {
		TransactionImpl transaction = new TransactionImpl();
		return transaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway createGateway() {
		GatewayImpl gateway = new GatewayImpl();
		return gateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pool createPool() {
		PoolImpl pool = new PoolImpl();
		return pool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lane createLane() {
		LaneImpl lane = new LaneImpl();
		return lane;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataObject createDataObject() {
		DataObjectImpl dataObject = new DataObjectImpl();
		return dataObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextAnnotation createTextAnnotation() {
		TextAnnotationImpl textAnnotation = new TextAnnotationImpl();
		return textAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Group createGroup() {
		GroupImpl group = new GroupImpl();
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceFlow createSequenceFlow() {
		SequenceFlowImpl sequenceFlow = new SequenceFlowImpl();
		return sequenceFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MessageFlow createMessageFlow() {
		MessageFlowImpl messageFlow = new MessageFlowImpl();
		return messageFlow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association createAssociation() {
		AssociationImpl association = new AssociationImpl();
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant createParticipant() {
		ParticipantImpl participant = new ParticipantImpl();
		return participant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message createMessage() {
		MessageImpl message = new MessageImpl();
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Implementation createImplementation() {
		ImplementationImpl implementation = new ImplementationImpl();
		return implementation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusType createStatusTypeFromString(EDataType eDataType, String initialValue) {
		StatusType result = StatusType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStatusTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessType createProcessTypeFromString(EDataType eDataType, String initialValue) {
		ProcessType result = ProcessType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertProcessTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TriggerType createTriggerTypeFromString(EDataType eDataType, String initialValue) {
		TriggerType result = TriggerType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTriggerTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowConditionTypes createFlowConditionTypesFromString(EDataType eDataType, String initialValue) {
		FlowConditionTypes result = FlowConditionTypes.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFlowConditionTypesToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityType createActivityTypeFromString(EDataType eDataType, String initialValue) {
		ActivityType result = ActivityType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActivityTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopType createLoopTypeFromString(EDataType eDataType, String initialValue) {
		LoopType result = LoopType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoopTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionMethodType createTransactionMethodTypeFromString(EDataType eDataType, String initialValue) {
		TransactionMethodType result = TransactionMethodType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTransactionMethodTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GatewayType createGatewayTypeFromString(EDataType eDataType, String initialValue) {
		GatewayType result = GatewayType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGatewayTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionType createConditionTypeFromString(EDataType eDataType, String initialValue) {
		ConditionType result = ConditionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConditionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DirectionType createDirectionTypeFromString(EDataType eDataType, String initialValue) {
		DirectionType result = DirectionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDirectionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipantType createParticipantTypeFromString(EDataType eDataType, String initialValue) {
		ParticipantType result = ParticipantType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParticipantTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignTimeType createAssignTimeTypeFromString(EDataType eDataType, String initialValue) {
		AssignTimeType result = AssignTimeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssignTimeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VsdtPackage getVsdtPackage() {
		return (VsdtPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VsdtPackage getPackage() {
		return VsdtPackage.eINSTANCE;
	}

} //VsdtFactoryImpl
