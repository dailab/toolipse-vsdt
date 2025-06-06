/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.Artifact;
import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Association;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.ConditionType;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.DataType;
import de.dailab.vsdt.DirectionType;
import de.dailab.vsdt.End;
import de.dailab.vsdt.Event;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowConditionTypes;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.GraphicalObject;
import de.dailab.vsdt.Group;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.InputSet;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.LoopAttributeSet;
import de.dailab.vsdt.LoopType;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.Node;
import de.dailab.vsdt.OutputSet;
import de.dailab.vsdt.Parameter;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.ParticipantType;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.ProcessType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.Service;
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TextAnnotation;
import de.dailab.vsdt.Transaction;
import de.dailab.vsdt.TransactionMethodType;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VsdtPackageImpl extends EPackageImpl implements VsdtPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessProcessDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowObjectContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicalObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flowObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass intermediateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopAttributeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass standardLoopAttSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiLoopAttSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transactionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gatewayEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass poolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass laneEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass artifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass groupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectingObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass participantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageChannelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass idObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass businessProcessSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum processTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum triggerTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum flowConditionTypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum activityTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum loopTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum transactionMethodTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum gatewayTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum conditionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum directionTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum participantTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum assignTimeTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.dailab.vsdt.VsdtPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private VsdtPackageImpl() {
		super(eNS_URI, VsdtFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link VsdtPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static VsdtPackage init() {
		if (isInited) return (VsdtPackage)EPackage.Registry.INSTANCE.getEPackage(VsdtPackage.eNS_URI);

		// Obtain or create and register package
		VsdtPackageImpl theVsdtPackage = (VsdtPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VsdtPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VsdtPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theVsdtPackage.createPackageContents();

		// Initialize created meta-data
		theVsdtPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theVsdtPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(VsdtPackage.eNS_URI, theVsdtPackage);
		return theVsdtPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessProcessDiagram() {
		return businessProcessDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessDiagram_Parent() {
		return (EReference)businessProcessDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessDiagram_Pools() {
		return (EReference)businessProcessDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessDiagram_Artifacts() {
		return (EReference)businessProcessDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessDiagram_Connections() {
		return (EReference)businessProcessDiagramEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessDiagram_Participants() {
		return (EReference)businessProcessDiagramEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowObjectContainer() {
		return flowObjectContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowObjectContainer_ContainedFlowObjects() {
		return (EReference)flowObjectContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractProcess() {
		return abstractProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractProcess_AdHoc() {
		return (EAttribute)abstractProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractProcess_AdHocCompletionCondition() {
		return (EReference)abstractProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractProcess_Properties() {
		return (EReference)abstractProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphicalObject() {
		return graphicalObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicalObject_OutgoingAss() {
		return (EReference)graphicalObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphicalObject_IncomingAss() {
		return (EReference)graphicalObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_OutgoingMsg() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_IncomingMsg() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlowObject() {
		return flowObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowObject_Parent() {
		return (EReference)flowObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowObject_Assignments() {
		return (EReference)flowObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowObject_OutgoingSeq() {
		return (EReference)flowObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlowObject_IncomingSeq() {
		return (EReference)flowObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_NonInterrupting() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Trigger() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_Implementation() {
		return (EReference)eventEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_TimeExpression() {
		return (EReference)eventEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_AsDuration() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_RuleExpression() {
		return (EReference)eventEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_ErrorCode() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_Activity() {
		return (EReference)eventEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_Signal() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEvent_SignalThrown() {
		return (EAttribute)eventEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_LinkedTo() {
		return (EReference)eventEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStart() {
		return startEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntermediate() {
		return intermediateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntermediate_AttachedTo() {
		return (EReference)intermediateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnd() {
		return endEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActivity() {
		return activityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_InputSets() {
		return (EReference)activityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_OutputSets() {
		return (EReference)activityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_IORules() {
		return (EReference)activityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_LoopAttributes() {
		return (EReference)activityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_BoundaryEvents() {
		return (EReference)activityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_EventedSubprocess() {
		return (EAttribute)activityEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_ActivityType() {
		return (EAttribute)activityEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Implementation() {
		return (EReference)activityEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_Performers() {
		return (EAttribute)activityEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActivity_Script() {
		return (EAttribute)activityEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_Transaction() {
		return (EReference)activityEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_CalledElement() {
		return (EReference)activityEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_InputPropertyMaps() {
		return (EReference)activityEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActivity_OutputPropertyMaps() {
		return (EReference)activityEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputSet() {
		return inputSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputSet_Inputs() {
		return (EReference)inputSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputSet() {
		return outputSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputSet_Outputs() {
		return (EReference)outputSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopAttributeSet() {
		return loopAttributeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopAttributeSet_Parent() {
		return (EReference)loopAttributeSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStandardLoopAttSet() {
		return standardLoopAttSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStandardLoopAttSet_LoopCondition() {
		return (EReference)standardLoopAttSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardLoopAttSet_LoopMaximum() {
		return (EAttribute)standardLoopAttSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStandardLoopAttSet_TestBefore() {
		return (EAttribute)standardLoopAttSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiLoopAttSet() {
		return multiLoopAttSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiLoopAttSet_MI_Condition() {
		return (EReference)multiLoopAttSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiLoopAttSet_MI_FlowCondition() {
		return (EAttribute)multiLoopAttSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiLoopAttSet_ComplexMI_FlowCondition() {
		return (EReference)multiLoopAttSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiLoopAttSet_Sequential() {
		return (EAttribute)multiLoopAttSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransaction() {
		return transactionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransaction_TransactionId() {
		return (EAttribute)transactionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransaction_TransactionProtocol() {
		return (EAttribute)transactionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTransaction_TransactionMethod() {
		return (EAttribute)transactionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGateway() {
		return gatewayEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGateway_GatewayType() {
		return (EAttribute)gatewayEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGateway_IncomingCondition() {
		return (EReference)gatewayEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGateway_OutgoingCondition() {
		return (EReference)gatewayEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPool() {
		return poolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPool_Parent() {
		return (EReference)poolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPool_Participant() {
		return (EReference)poolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPool_Lanes() {
		return (EReference)poolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPool_BoundaryVisible() {
		return (EAttribute)poolEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPool_ProcessType() {
		return (EAttribute)poolEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLane() {
		return laneEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLane_Parent() {
		return (EReference)laneEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArtifact() {
		return artifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtifact_Parent() {
		return (EReference)artifactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArtifact_Pool() {
		return (EReference)artifactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataObject() {
		return dataObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataObject_Properties() {
		return (EReference)dataObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_RequiredForStart() {
		return (EAttribute)dataObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_ProducedAtCompletion() {
		return (EAttribute)dataObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataObject_State() {
		return (EAttribute)dataObjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextAnnotation() {
		return textAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGroup() {
		return groupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectingObject() {
		return connectingObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectingObject_Parent() {
		return (EReference)connectingObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceFlow() {
		return sequenceFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceFlow_ConditionType() {
		return (EAttribute)sequenceFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceFlow_ConditionExpression() {
		return (EReference)sequenceFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceFlow_Source() {
		return (EReference)sequenceFlowEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSequenceFlow_Target() {
		return (EReference)sequenceFlowEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageFlow() {
		return messageFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageFlow_Source() {
		return (EReference)messageFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageFlow_Target() {
		return (EReference)messageFlowEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociation_Direction() {
		return (EAttribute)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Source() {
		return (EReference)associationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Target() {
		return (EReference)associationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParticipant() {
		return participantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_AssociatedProcesses() {
		return (EReference)participantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_AssociatedPools() {
		return (EReference)participantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParticipant_Type() {
		return (EAttribute)participantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementation() {
		return implementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMessageChannel() {
		return messageChannelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageChannel_Channel() {
		return (EReference)messageChannelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageChannel_Payload() {
		return (EReference)messageChannelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageChannel_Sender() {
		return (EReference)messageChannelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMessageChannel_Receiver() {
		return (EReference)messageChannelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMessageChannel_MessageGroup() {
		return (EAttribute)messageChannelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Type() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Participant() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Interface() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Operation() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Description() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Location() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Input() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Output() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Preconditions() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Effects() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_Template() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_To() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_From() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignment_AssignTime() {
		return (EAttribute)assignmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssignment_ToQuery() {
		return (EAttribute)assignmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Name() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Type() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Key() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Value() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Description() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Expression() {
		return (EAttribute)expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpression_Language() {
		return (EAttribute)expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Name() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Package() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Language() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Url() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_Inherits() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataType_Members() {
		return (EAttribute)dataTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdObject() {
		return idObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdObject_Name() {
		return (EAttribute)idObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdObject_Id() {
		return (EAttribute)idObjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdObject_Documentation() {
		return (EAttribute)idObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBusinessProcessSystem() {
		return businessProcessSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessProcessSystem_Version() {
		return (EAttribute)businessProcessSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessProcessSystem_Author() {
		return (EAttribute)businessProcessSystemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessProcessSystem_Language() {
		return (EAttribute)businessProcessSystemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessProcessSystem_ExpressionLanguage() {
		return (EAttribute)businessProcessSystemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessProcessSystem_QueryLanguage() {
		return (EAttribute)businessProcessSystemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessProcessSystem_CreationDate() {
		return (EAttribute)businessProcessSystemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessProcessSystem_ModificationDate() {
		return (EAttribute)businessProcessSystemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBusinessProcessSystem_Executable() {
		return (EAttribute)businessProcessSystemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessSystem_BusinessProcesses() {
		return (EReference)businessProcessSystemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessSystem_Participants() {
		return (EReference)businessProcessSystemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessSystem_MessageChannels() {
		return (EReference)businessProcessSystemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessSystem_Services() {
		return (EReference)businessProcessSystemEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessSystem_DataTypes() {
		return (EReference)businessProcessSystemEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBusinessProcessSystem_Parameters() {
		return (EReference)businessProcessSystemEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProcessType() {
		return processTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTriggerType() {
		return triggerTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFlowConditionTypes() {
		return flowConditionTypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActivityType() {
		return activityTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLoopType() {
		return loopTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTransactionMethodType() {
		return transactionMethodTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGatewayType() {
		return gatewayTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConditionType() {
		return conditionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDirectionType() {
		return directionTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParticipantType() {
		return participantTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAssignTimeType() {
		return assignTimeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VsdtFactory getVsdtFactory() {
		return (VsdtFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		idObjectEClass = createEClass(ID_OBJECT);
		createEAttribute(idObjectEClass, ID_OBJECT__NAME);
		createEAttribute(idObjectEClass, ID_OBJECT__DOCUMENTATION);
		createEAttribute(idObjectEClass, ID_OBJECT__ID);

		businessProcessSystemEClass = createEClass(BUSINESS_PROCESS_SYSTEM);
		createEAttribute(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__VERSION);
		createEAttribute(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__AUTHOR);
		createEAttribute(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__LANGUAGE);
		createEAttribute(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE);
		createEAttribute(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE);
		createEAttribute(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__CREATION_DATE);
		createEAttribute(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE);
		createEAttribute(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__EXECUTABLE);
		createEReference(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES);
		createEReference(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__PARTICIPANTS);
		createEReference(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS);
		createEReference(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__SERVICES);
		createEReference(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__DATA_TYPES);
		createEReference(businessProcessSystemEClass, BUSINESS_PROCESS_SYSTEM__PARAMETERS);

		businessProcessDiagramEClass = createEClass(BUSINESS_PROCESS_DIAGRAM);
		createEReference(businessProcessDiagramEClass, BUSINESS_PROCESS_DIAGRAM__PARENT);
		createEReference(businessProcessDiagramEClass, BUSINESS_PROCESS_DIAGRAM__POOLS);
		createEReference(businessProcessDiagramEClass, BUSINESS_PROCESS_DIAGRAM__ARTIFACTS);
		createEReference(businessProcessDiagramEClass, BUSINESS_PROCESS_DIAGRAM__CONNECTIONS);
		createEReference(businessProcessDiagramEClass, BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS);

		abstractProcessEClass = createEClass(ABSTRACT_PROCESS);
		createEAttribute(abstractProcessEClass, ABSTRACT_PROCESS__AD_HOC);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION);
		createEReference(abstractProcessEClass, ABSTRACT_PROCESS__PROPERTIES);

		poolEClass = createEClass(POOL);
		createEReference(poolEClass, POOL__PARENT);
		createEReference(poolEClass, POOL__PARTICIPANT);
		createEReference(poolEClass, POOL__LANES);
		createEAttribute(poolEClass, POOL__BOUNDARY_VISIBLE);
		createEAttribute(poolEClass, POOL__PROCESS_TYPE);

		laneEClass = createEClass(LANE);
		createEReference(laneEClass, LANE__PARENT);

		flowObjectContainerEClass = createEClass(FLOW_OBJECT_CONTAINER);
		createEReference(flowObjectContainerEClass, FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS);

		graphicalObjectEClass = createEClass(GRAPHICAL_OBJECT);
		createEReference(graphicalObjectEClass, GRAPHICAL_OBJECT__OUTGOING_ASS);
		createEReference(graphicalObjectEClass, GRAPHICAL_OBJECT__INCOMING_ASS);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__OUTGOING_MSG);
		createEReference(nodeEClass, NODE__INCOMING_MSG);

		flowObjectEClass = createEClass(FLOW_OBJECT);
		createEReference(flowObjectEClass, FLOW_OBJECT__PARENT);
		createEReference(flowObjectEClass, FLOW_OBJECT__ASSIGNMENTS);
		createEReference(flowObjectEClass, FLOW_OBJECT__OUTGOING_SEQ);
		createEReference(flowObjectEClass, FLOW_OBJECT__INCOMING_SEQ);

		eventEClass = createEClass(EVENT);
		createEAttribute(eventEClass, EVENT__NON_INTERRUPTING);
		createEAttribute(eventEClass, EVENT__TRIGGER);
		createEReference(eventEClass, EVENT__IMPLEMENTATION);
		createEReference(eventEClass, EVENT__TIME_EXPRESSION);
		createEAttribute(eventEClass, EVENT__AS_DURATION);
		createEReference(eventEClass, EVENT__RULE_EXPRESSION);
		createEAttribute(eventEClass, EVENT__ERROR_CODE);
		createEReference(eventEClass, EVENT__ACTIVITY);
		createEAttribute(eventEClass, EVENT__SIGNAL);
		createEAttribute(eventEClass, EVENT__SIGNAL_THROWN);
		createEReference(eventEClass, EVENT__LINKED_TO);

		startEClass = createEClass(START);

		intermediateEClass = createEClass(INTERMEDIATE);
		createEReference(intermediateEClass, INTERMEDIATE__ATTACHED_TO);

		endEClass = createEClass(END);

		activityEClass = createEClass(ACTIVITY);
		createEReference(activityEClass, ACTIVITY__INPUT_SETS);
		createEReference(activityEClass, ACTIVITY__OUTPUT_SETS);
		createEReference(activityEClass, ACTIVITY__IO_RULES);
		createEReference(activityEClass, ACTIVITY__LOOP_ATTRIBUTES);
		createEReference(activityEClass, ACTIVITY__BOUNDARY_EVENTS);
		createEAttribute(activityEClass, ACTIVITY__EVENTED_SUBPROCESS);
		createEAttribute(activityEClass, ACTIVITY__ACTIVITY_TYPE);
		createEReference(activityEClass, ACTIVITY__IMPLEMENTATION);
		createEAttribute(activityEClass, ACTIVITY__PERFORMERS);
		createEAttribute(activityEClass, ACTIVITY__SCRIPT);
		createEReference(activityEClass, ACTIVITY__TRANSACTION);
		createEReference(activityEClass, ACTIVITY__CALLED_ELEMENT);
		createEReference(activityEClass, ACTIVITY__INPUT_PROPERTY_MAPS);
		createEReference(activityEClass, ACTIVITY__OUTPUT_PROPERTY_MAPS);

		loopAttributeSetEClass = createEClass(LOOP_ATTRIBUTE_SET);
		createEReference(loopAttributeSetEClass, LOOP_ATTRIBUTE_SET__PARENT);

		standardLoopAttSetEClass = createEClass(STANDARD_LOOP_ATT_SET);
		createEReference(standardLoopAttSetEClass, STANDARD_LOOP_ATT_SET__LOOP_CONDITION);
		createEAttribute(standardLoopAttSetEClass, STANDARD_LOOP_ATT_SET__LOOP_MAXIMUM);
		createEAttribute(standardLoopAttSetEClass, STANDARD_LOOP_ATT_SET__TEST_BEFORE);

		multiLoopAttSetEClass = createEClass(MULTI_LOOP_ATT_SET);
		createEReference(multiLoopAttSetEClass, MULTI_LOOP_ATT_SET__MI_CONDITION);
		createEAttribute(multiLoopAttSetEClass, MULTI_LOOP_ATT_SET__MI_FLOW_CONDITION);
		createEReference(multiLoopAttSetEClass, MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION);
		createEAttribute(multiLoopAttSetEClass, MULTI_LOOP_ATT_SET__SEQUENTIAL);

		inputSetEClass = createEClass(INPUT_SET);
		createEReference(inputSetEClass, INPUT_SET__INPUTS);

		outputSetEClass = createEClass(OUTPUT_SET);
		createEReference(outputSetEClass, OUTPUT_SET__OUTPUTS);

		transactionEClass = createEClass(TRANSACTION);
		createEAttribute(transactionEClass, TRANSACTION__TRANSACTION_ID);
		createEAttribute(transactionEClass, TRANSACTION__TRANSACTION_PROTOCOL);
		createEAttribute(transactionEClass, TRANSACTION__TRANSACTION_METHOD);

		gatewayEClass = createEClass(GATEWAY);
		createEAttribute(gatewayEClass, GATEWAY__GATEWAY_TYPE);
		createEReference(gatewayEClass, GATEWAY__INCOMING_CONDITION);
		createEReference(gatewayEClass, GATEWAY__OUTGOING_CONDITION);

		artifactEClass = createEClass(ARTIFACT);
		createEReference(artifactEClass, ARTIFACT__PARENT);
		createEReference(artifactEClass, ARTIFACT__POOL);

		dataObjectEClass = createEClass(DATA_OBJECT);
		createEReference(dataObjectEClass, DATA_OBJECT__PROPERTIES);
		createEAttribute(dataObjectEClass, DATA_OBJECT__REQUIRED_FOR_START);
		createEAttribute(dataObjectEClass, DATA_OBJECT__PRODUCED_AT_COMPLETION);
		createEAttribute(dataObjectEClass, DATA_OBJECT__STATE);

		textAnnotationEClass = createEClass(TEXT_ANNOTATION);

		groupEClass = createEClass(GROUP);

		connectingObjectEClass = createEClass(CONNECTING_OBJECT);
		createEReference(connectingObjectEClass, CONNECTING_OBJECT__PARENT);

		sequenceFlowEClass = createEClass(SEQUENCE_FLOW);
		createEAttribute(sequenceFlowEClass, SEQUENCE_FLOW__CONDITION_TYPE);
		createEReference(sequenceFlowEClass, SEQUENCE_FLOW__CONDITION_EXPRESSION);
		createEReference(sequenceFlowEClass, SEQUENCE_FLOW__SOURCE);
		createEReference(sequenceFlowEClass, SEQUENCE_FLOW__TARGET);

		messageFlowEClass = createEClass(MESSAGE_FLOW);
		createEReference(messageFlowEClass, MESSAGE_FLOW__SOURCE);
		createEReference(messageFlowEClass, MESSAGE_FLOW__TARGET);

		associationEClass = createEClass(ASSOCIATION);
		createEAttribute(associationEClass, ASSOCIATION__DIRECTION);
		createEReference(associationEClass, ASSOCIATION__SOURCE);
		createEReference(associationEClass, ASSOCIATION__TARGET);

		participantEClass = createEClass(PARTICIPANT);
		createEAttribute(participantEClass, PARTICIPANT__TYPE);
		createEReference(participantEClass, PARTICIPANT__ASSOCIATED_PROCESSES);
		createEReference(participantEClass, PARTICIPANT__ASSOCIATED_POOLS);

		implementationEClass = createEClass(IMPLEMENTATION);

		messageChannelEClass = createEClass(MESSAGE_CHANNEL);
		createEReference(messageChannelEClass, MESSAGE_CHANNEL__CHANNEL);
		createEReference(messageChannelEClass, MESSAGE_CHANNEL__PAYLOAD);
		createEReference(messageChannelEClass, MESSAGE_CHANNEL__SENDER);
		createEReference(messageChannelEClass, MESSAGE_CHANNEL__RECEIVER);
		createEAttribute(messageChannelEClass, MESSAGE_CHANNEL__MESSAGE_GROUP);

		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__TYPE);
		createEReference(serviceEClass, SERVICE__PARTICIPANT);
		createEAttribute(serviceEClass, SERVICE__INTERFACE);
		createEAttribute(serviceEClass, SERVICE__OPERATION);
		createEAttribute(serviceEClass, SERVICE__DESCRIPTION);
		createEAttribute(serviceEClass, SERVICE__LOCATION);
		createEReference(serviceEClass, SERVICE__INPUT);
		createEReference(serviceEClass, SERVICE__OUTPUT);
		createEReference(serviceEClass, SERVICE__PRECONDITIONS);
		createEReference(serviceEClass, SERVICE__EFFECTS);
		createEAttribute(serviceEClass, SERVICE__TEMPLATE);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__TO);
		createEReference(assignmentEClass, ASSIGNMENT__FROM);
		createEAttribute(assignmentEClass, ASSIGNMENT__ASSIGN_TIME);
		createEAttribute(assignmentEClass, ASSIGNMENT__TO_QUERY);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__NAME);
		createEAttribute(propertyEClass, PROPERTY__TYPE);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__KEY);
		createEAttribute(parameterEClass, PARAMETER__VALUE);
		createEAttribute(parameterEClass, PARAMETER__DESCRIPTION);

		expressionEClass = createEClass(EXPRESSION);
		createEAttribute(expressionEClass, EXPRESSION__EXPRESSION);
		createEAttribute(expressionEClass, EXPRESSION__LANGUAGE);

		dataTypeEClass = createEClass(DATA_TYPE);
		createEAttribute(dataTypeEClass, DATA_TYPE__NAME);
		createEAttribute(dataTypeEClass, DATA_TYPE__PACKAGE);
		createEAttribute(dataTypeEClass, DATA_TYPE__LANGUAGE);
		createEAttribute(dataTypeEClass, DATA_TYPE__URL);
		createEReference(dataTypeEClass, DATA_TYPE__INHERITS);
		createEAttribute(dataTypeEClass, DATA_TYPE__MEMBERS);

		// Create enums
		processTypeEEnum = createEEnum(PROCESS_TYPE);
		triggerTypeEEnum = createEEnum(TRIGGER_TYPE);
		activityTypeEEnum = createEEnum(ACTIVITY_TYPE);
		loopTypeEEnum = createEEnum(LOOP_TYPE);
		flowConditionTypesEEnum = createEEnum(FLOW_CONDITION_TYPES);
		transactionMethodTypeEEnum = createEEnum(TRANSACTION_METHOD_TYPE);
		gatewayTypeEEnum = createEEnum(GATEWAY_TYPE);
		conditionTypeEEnum = createEEnum(CONDITION_TYPE);
		directionTypeEEnum = createEEnum(DIRECTION_TYPE);
		participantTypeEEnum = createEEnum(PARTICIPANT_TYPE);
		assignTimeTypeEEnum = createEEnum(ASSIGN_TIME_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		businessProcessSystemEClass.getESuperTypes().add(this.getIdObject());
		businessProcessDiagramEClass.getESuperTypes().add(this.getIdObject());
		poolEClass.getESuperTypes().add(this.getNode());
		poolEClass.getESuperTypes().add(this.getAbstractProcess());
		laneEClass.getESuperTypes().add(this.getGraphicalObject());
		laneEClass.getESuperTypes().add(this.getFlowObjectContainer());
		graphicalObjectEClass.getESuperTypes().add(this.getIdObject());
		nodeEClass.getESuperTypes().add(this.getGraphicalObject());
		flowObjectEClass.getESuperTypes().add(this.getNode());
		eventEClass.getESuperTypes().add(this.getFlowObject());
		startEClass.getESuperTypes().add(this.getEvent());
		intermediateEClass.getESuperTypes().add(this.getEvent());
		endEClass.getESuperTypes().add(this.getEvent());
		activityEClass.getESuperTypes().add(this.getFlowObject());
		activityEClass.getESuperTypes().add(this.getAbstractProcess());
		activityEClass.getESuperTypes().add(this.getFlowObjectContainer());
		standardLoopAttSetEClass.getESuperTypes().add(this.getLoopAttributeSet());
		multiLoopAttSetEClass.getESuperTypes().add(this.getLoopAttributeSet());
		gatewayEClass.getESuperTypes().add(this.getFlowObject());
		artifactEClass.getESuperTypes().add(this.getGraphicalObject());
		dataObjectEClass.getESuperTypes().add(this.getArtifact());
		textAnnotationEClass.getESuperTypes().add(this.getArtifact());
		groupEClass.getESuperTypes().add(this.getArtifact());
		connectingObjectEClass.getESuperTypes().add(this.getGraphicalObject());
		sequenceFlowEClass.getESuperTypes().add(this.getConnectingObject());
		messageFlowEClass.getESuperTypes().add(this.getConnectingObject());
		associationEClass.getESuperTypes().add(this.getConnectingObject());
		participantEClass.getESuperTypes().add(this.getIdObject());
		messageChannelEClass.getESuperTypes().add(this.getImplementation());
		serviceEClass.getESuperTypes().add(this.getImplementation());

		// Initialize classes and features; add operations and parameters
		initEClass(idObjectEClass, IdObject.class, "IdObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdObject_Name(), ecorePackage.getEString(), "name", null, 0, 1, IdObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdObject_Documentation(), ecorePackage.getEString(), "documentation", "", 0, 1, IdObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIdObject_Id(), theXMLTypePackage.getID(), "id", null, 1, 1, IdObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(idObjectEClass, ecorePackage.getEString(), "getNameOrId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(businessProcessSystemEClass, BusinessProcessSystem.class, "BusinessProcessSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBusinessProcessSystem_Version(), ecorePackage.getEString(), "version", null, 0, 1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessProcessSystem_Author(), ecorePackage.getEString(), "author", null, 0, 1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessProcessSystem_Language(), ecorePackage.getEString(), "language", null, 0, 1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessProcessSystem_ExpressionLanguage(), ecorePackage.getEString(), "expressionLanguage", null, 0, 1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessProcessSystem_QueryLanguage(), ecorePackage.getEString(), "queryLanguage", null, 0, 1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessProcessSystem_CreationDate(), ecorePackage.getEDate(), "creationDate", null, 0, 1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessProcessSystem_ModificationDate(), ecorePackage.getEDate(), "modificationDate", null, 0, 1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBusinessProcessSystem_Executable(), ecorePackage.getEBoolean(), "executable", "true", 0, 1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessSystem_BusinessProcesses(), this.getBusinessProcessDiagram(), this.getBusinessProcessDiagram_Parent(), "businessProcesses", null, 0, -1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessSystem_Participants(), this.getParticipant(), null, "participants", null, 0, -1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessSystem_MessageChannels(), this.getMessageChannel(), null, "messageChannels", null, 0, -1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessSystem_Services(), this.getService(), null, "services", null, 0, -1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessSystem_DataTypes(), this.getDataType(), null, "dataTypes", null, 0, -1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessSystem_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, BusinessProcessSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(businessProcessDiagramEClass, BusinessProcessDiagram.class, "BusinessProcessDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBusinessProcessDiagram_Parent(), this.getBusinessProcessSystem(), this.getBusinessProcessSystem_BusinessProcesses(), "parent", null, 0, 1, BusinessProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessDiagram_Pools(), this.getPool(), this.getPool_Parent(), "pools", null, 1, -1, BusinessProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessDiagram_Artifacts(), this.getArtifact(), this.getArtifact_Parent(), "artifacts", null, 0, -1, BusinessProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessDiagram_Connections(), this.getConnectingObject(), this.getConnectingObject_Parent(), "connections", null, 0, -1, BusinessProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBusinessProcessDiagram_Participants(), this.getParticipant(), this.getParticipant_AssociatedProcesses(), "participants", null, 1, -1, BusinessProcessDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractProcessEClass, AbstractProcess.class, "AbstractProcess", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractProcess_AdHoc(), ecorePackage.getEBoolean(), "adHoc", "false", 1, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcess_AdHocCompletionCondition(), this.getExpression(), null, "adHocCompletionCondition", null, 0, 1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractProcess_Properties(), this.getProperty(), null, "properties", null, 0, -1, AbstractProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(abstractProcessEClass, null, "getGraphicalElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(this.getFlowObject());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(poolEClass, Pool.class, "Pool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPool_Parent(), this.getBusinessProcessDiagram(), this.getBusinessProcessDiagram_Pools(), "parent", null, 0, 1, Pool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPool_Participant(), this.getParticipant(), this.getParticipant_AssociatedPools(), "participant", null, 1, 1, Pool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPool_Lanes(), this.getLane(), this.getLane_Parent(), "lanes", null, 0, -1, Pool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPool_BoundaryVisible(), ecorePackage.getEBoolean(), "boundaryVisible", "true", 1, 1, Pool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPool_ProcessType(), this.getProcessType(), "processType", "PRIVATE", 1, 1, Pool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(laneEClass, Lane.class, "Lane", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLane_Parent(), this.getPool(), this.getPool_Lanes(), "parent", null, 0, 1, Lane.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(flowObjectContainerEClass, FlowObjectContainer.class, "FlowObjectContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowObjectContainer_ContainedFlowObjects(), this.getFlowObject(), this.getFlowObject_Parent(), "containedFlowObjects", null, 0, -1, FlowObjectContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicalObjectEClass, GraphicalObject.class, "GraphicalObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphicalObject_OutgoingAss(), this.getAssociation(), this.getAssociation_Source(), "outgoingAss", null, 0, -1, GraphicalObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGraphicalObject_IncomingAss(), this.getAssociation(), this.getAssociation_Target(), "incomingAss", null, 0, -1, GraphicalObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode_OutgoingMsg(), this.getMessageFlow(), this.getMessageFlow_Source(), "outgoingMsg", null, 0, -1, Node.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_IncomingMsg(), this.getMessageFlow(), this.getMessageFlow_Target(), "incomingMsg", null, 0, -1, Node.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(nodeEClass, this.getPool(), "getPool", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(nodeEClass, null, "adaptToImplementation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getImplementation(), "implementation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "incoming", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(flowObjectEClass, FlowObject.class, "FlowObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlowObject_Parent(), this.getFlowObjectContainer(), this.getFlowObjectContainer_ContainedFlowObjects(), "parent", null, 0, 1, FlowObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowObject_Assignments(), this.getAssignment(), null, "assignments", null, 0, -1, FlowObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowObject_OutgoingSeq(), this.getSequenceFlow(), this.getSequenceFlow_Source(), "outgoingSeq", null, 0, -1, FlowObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFlowObject_IncomingSeq(), this.getSequenceFlow(), this.getSequenceFlow_Target(), "incomingSeq", null, 0, -1, FlowObject.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(flowObjectEClass, ecorePackage.getEBoolean(), "isStartingNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(flowObjectEClass, ecorePackage.getEBoolean(), "isEndingNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(flowObjectEClass, this.getAbstractProcess(), "getAbstractProcess", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEvent_NonInterrupting(), ecorePackage.getEBoolean(), "nonInterrupting", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Trigger(), this.getTriggerType(), "trigger", null, 1, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Implementation(), this.getImplementation(), null, "implementation", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_TimeExpression(), this.getExpression(), null, "timeExpression", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_AsDuration(), ecorePackage.getEBoolean(), "asDuration", "true", 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_RuleExpression(), this.getExpression(), null, "ruleExpression", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_ErrorCode(), ecorePackage.getEString(), "errorCode", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_Activity(), this.getActivity(), null, "activity", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_Signal(), ecorePackage.getEString(), "signal", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEvent_SignalThrown(), ecorePackage.getEBoolean(), "signalThrown", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEvent_LinkedTo(), this.getEvent(), null, "linkedTo", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(eventEClass, this.getTriggerType(), "getValidTriggerTypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eventEClass, ecorePackage.getEBoolean(), "isThrowing", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eventEClass, ecorePackage.getEBoolean(), "isInEventedSubprocess", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(eventEClass, ecorePackage.getEBoolean(), "isOnBoundary", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(startEClass, Start.class, "Start", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(intermediateEClass, Intermediate.class, "Intermediate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIntermediate_AttachedTo(), this.getActivity(), this.getActivity_BoundaryEvents(), "attachedTo", null, 0, 1, Intermediate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endEClass, End.class, "End", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(activityEClass, Activity.class, "Activity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActivity_InputSets(), this.getInputSet(), null, "inputSets", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_OutputSets(), this.getOutputSet(), null, "outputSets", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_IORules(), this.getExpression(), null, "IORules", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_LoopAttributes(), this.getLoopAttributeSet(), this.getLoopAttributeSet_Parent(), "loopAttributes", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_BoundaryEvents(), this.getIntermediate(), this.getIntermediate_AttachedTo(), "boundaryEvents", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivity_EventedSubprocess(), ecorePackage.getEBoolean(), "eventedSubprocess", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivity_ActivityType(), this.getActivityType(), "activityType", null, 1, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_Implementation(), this.getImplementation(), null, "implementation", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivity_Performers(), ecorePackage.getEString(), "performers", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getActivity_Script(), ecorePackage.getEString(), "script", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_Transaction(), this.getTransaction(), null, "transaction", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_CalledElement(), this.getAbstractProcess(), null, "calledElement", null, 0, 1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_InputPropertyMaps(), this.getExpression(), null, "inputPropertyMaps", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActivity_OutputPropertyMaps(), this.getExpression(), null, "outputPropertyMaps", null, 0, -1, Activity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(activityEClass, null, "initializeInputSet", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, null, "initializeOutputSet", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(activityEClass, ecorePackage.getEBoolean(), "isCompensation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(loopAttributeSetEClass, LoopAttributeSet.class, "LoopAttributeSet", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopAttributeSet_Parent(), this.getActivity(), this.getActivity_LoopAttributes(), "parent", null, 1, 1, LoopAttributeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(standardLoopAttSetEClass, StandardLoopAttSet.class, "StandardLoopAttSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStandardLoopAttSet_LoopCondition(), this.getExpression(), null, "loopCondition", null, 0, 1, StandardLoopAttSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardLoopAttSet_LoopMaximum(), ecorePackage.getEInt(), "loopMaximum", null, 0, 1, StandardLoopAttSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStandardLoopAttSet_TestBefore(), ecorePackage.getEBoolean(), "testBefore", "true", 0, 1, StandardLoopAttSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiLoopAttSetEClass, MultiLoopAttSet.class, "MultiLoopAttSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiLoopAttSet_MI_Condition(), this.getExpression(), null, "MI_Condition", null, 1, 1, MultiLoopAttSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiLoopAttSet_MI_FlowCondition(), this.getFlowConditionTypes(), "MI_FlowCondition", null, 1, 1, MultiLoopAttSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiLoopAttSet_ComplexMI_FlowCondition(), this.getExpression(), null, "complexMI_FlowCondition", null, 0, 1, MultiLoopAttSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiLoopAttSet_Sequential(), ecorePackage.getEBoolean(), "sequential", null, 0, 1, MultiLoopAttSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputSetEClass, InputSet.class, "InputSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputSet_Inputs(), this.getArtifact(), null, "inputs", null, 1, -1, InputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputSetEClass, OutputSet.class, "OutputSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputSet_Outputs(), this.getArtifact(), null, "outputs", null, 1, -1, OutputSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transactionEClass, Transaction.class, "Transaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTransaction_TransactionId(), ecorePackage.getEString(), "transactionId", null, 1, 1, Transaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransaction_TransactionProtocol(), ecorePackage.getEString(), "transactionProtocol", null, 1, 1, Transaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTransaction_TransactionMethod(), this.getTransactionMethodType(), "transactionMethod", null, 1, 1, Transaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(gatewayEClass, Gateway.class, "Gateway", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGateway_GatewayType(), this.getGatewayType(), "gatewayType", null, 0, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGateway_IncomingCondition(), this.getExpression(), null, "incomingCondition", null, 0, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGateway_OutgoingCondition(), this.getExpression(), null, "outgoingCondition", null, 0, 1, Gateway.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(artifactEClass, Artifact.class, "Artifact", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArtifact_Parent(), this.getBusinessProcessDiagram(), this.getBusinessProcessDiagram_Artifacts(), "parent", null, 1, 1, Artifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArtifact_Pool(), this.getPool(), null, "pool", null, 0, 1, Artifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataObjectEClass, DataObject.class, "DataObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataObject_Properties(), this.getProperty(), null, "properties", null, 0, -1, DataObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataObject_RequiredForStart(), ecorePackage.getEBoolean(), "requiredForStart", "true", 1, 1, DataObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataObject_ProducedAtCompletion(), ecorePackage.getEBoolean(), "producedAtCompletion", "true", 1, 1, DataObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataObject_State(), ecorePackage.getEString(), "state", null, 0, 1, DataObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(textAnnotationEClass, TextAnnotation.class, "TextAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(groupEClass, Group.class, "Group", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(connectingObjectEClass, ConnectingObject.class, "ConnectingObject", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectingObject_Parent(), this.getBusinessProcessDiagram(), this.getBusinessProcessDiagram_Connections(), "parent", null, 1, 1, ConnectingObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceFlowEClass, SequenceFlow.class, "SequenceFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSequenceFlow_ConditionType(), this.getConditionType(), "conditionType", null, 1, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceFlow_ConditionExpression(), this.getExpression(), null, "conditionExpression", null, 0, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceFlow_Source(), this.getFlowObject(), this.getFlowObject_OutgoingSeq(), "source", null, 1, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSequenceFlow_Target(), this.getFlowObject(), this.getFlowObject_IncomingSeq(), "target", null, 1, 1, SequenceFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageFlowEClass, MessageFlow.class, "MessageFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessageFlow_Source(), this.getNode(), this.getNode_OutgoingMsg(), "source", null, 1, 1, MessageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageFlow_Target(), this.getNode(), this.getNode_IncomingMsg(), "target", null, 1, 1, MessageFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(messageFlowEClass, null, "initializeMessage", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssociation_Direction(), this.getDirectionType(), "direction", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociation_Source(), this.getGraphicalObject(), this.getGraphicalObject_OutgoingAss(), "source", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociation_Target(), this.getGraphicalObject(), this.getGraphicalObject_IncomingAss(), "target", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(participantEClass, Participant.class, "Participant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParticipant_Type(), this.getParticipantType(), "type", null, 0, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParticipant_AssociatedProcesses(), this.getBusinessProcessDiagram(), this.getBusinessProcessDiagram_Participants(), "associatedProcesses", null, 0, -1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParticipant_AssociatedPools(), this.getPool(), this.getPool_Participant(), "associatedPools", null, 0, -1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(implementationEClass, Implementation.class, "Implementation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(messageChannelEClass, MessageChannel.class, "MessageChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessageChannel_Channel(), this.getExpression(), null, "channel", null, 1, 1, MessageChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageChannel_Payload(), this.getProperty(), null, "payload", null, 0, 1, MessageChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageChannel_Sender(), this.getProperty(), null, "sender", null, 0, 1, MessageChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessageChannel_Receiver(), this.getProperty(), null, "receiver", null, 0, 1, MessageChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessageChannel_MessageGroup(), ecorePackage.getEBoolean(), "messageGroup", "true", 0, 1, MessageChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_Type(), ecorePackage.getEString(), "type", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Participant(), this.getParticipant(), null, "participant", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Interface(), ecorePackage.getEString(), "interface", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Operation(), ecorePackage.getEString(), "operation", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Description(), ecorePackage.getEString(), "description", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Location(), ecorePackage.getEString(), "location", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Input(), this.getProperty(), null, "input", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Output(), this.getProperty(), null, "output", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Preconditions(), this.getExpression(), null, "preconditions", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Effects(), this.getExpression(), null, "effects", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_Template(), ecorePackage.getEBoolean(), "template", "false", 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_To(), this.getProperty(), null, "to", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignment_From(), this.getExpression(), null, "from", null, 1, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignment_AssignTime(), this.getAssignTimeType(), "assignTime", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssignment_ToQuery(), ecorePackage.getEString(), "toQuery", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Name(), ecorePackage.getEString(), "name", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Type(), ecorePackage.getEString(), "type", null, 1, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Key(), ecorePackage.getEString(), "key", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Value(), ecorePackage.getEString(), "value", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Description(), ecorePackage.getEString(), "description", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpression_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpression_Language(), ecorePackage.getEString(), "language", null, 0, 1, Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(expressionEClass, ecorePackage.getEString(), "getGlobalExpressionLanguage", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expressionEClass, ecorePackage.getEString(), "getExpressionLanguageToBeUsed", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(expressionEClass, ecorePackage.getEBoolean(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataType_Name(), ecorePackage.getEString(), "name", null, 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_Package(), ecorePackage.getEString(), "package", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_Language(), ecorePackage.getEString(), "language", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_Url(), ecorePackage.getEString(), "url", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_Inherits(), this.getDataType(), null, "inherits", null, 0, -1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataType_Members(), ecorePackage.getEString(), "members", null, 0, -1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(processTypeEEnum, ProcessType.class, "ProcessType");
		addEEnumLiteral(processTypeEEnum, ProcessType.NONE);
		addEEnumLiteral(processTypeEEnum, ProcessType.PUBLIC);
		addEEnumLiteral(processTypeEEnum, ProcessType.PRIVATE);

		initEEnum(triggerTypeEEnum, TriggerType.class, "TriggerType");
		addEEnumLiteral(triggerTypeEEnum, TriggerType.NONE);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.MESSAGE);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.TIMER);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.RULE);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.LINK);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.ERROR);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.COMPENSATION);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.CANCEL);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.MULTIPLE);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.TERMINATE);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.SIGNAL);
		addEEnumLiteral(triggerTypeEEnum, TriggerType.ESCALATION);

		initEEnum(activityTypeEEnum, ActivityType.class, "ActivityType");
		addEEnumLiteral(activityTypeEEnum, ActivityType.NONE);
		addEEnumLiteral(activityTypeEEnum, ActivityType.SERVICE);
		addEEnumLiteral(activityTypeEEnum, ActivityType.RECEIVE);
		addEEnumLiteral(activityTypeEEnum, ActivityType.SEND);
		addEEnumLiteral(activityTypeEEnum, ActivityType.USER);
		addEEnumLiteral(activityTypeEEnum, ActivityType.MANUAL);
		addEEnumLiteral(activityTypeEEnum, ActivityType.SCRIPT);
		addEEnumLiteral(activityTypeEEnum, ActivityType.BUSINESSRULE);
		addEEnumLiteral(activityTypeEEnum, ActivityType.EMBEDDED);
		addEEnumLiteral(activityTypeEEnum, ActivityType.CALL);

		initEEnum(loopTypeEEnum, LoopType.class, "LoopType");
		addEEnumLiteral(loopTypeEEnum, LoopType.NONE);
		addEEnumLiteral(loopTypeEEnum, LoopType.STANDARD);
		addEEnumLiteral(loopTypeEEnum, LoopType.MULTIINSTANCE);

		initEEnum(flowConditionTypesEEnum, FlowConditionTypes.class, "FlowConditionTypes");
		addEEnumLiteral(flowConditionTypesEEnum, FlowConditionTypes.NONE);
		addEEnumLiteral(flowConditionTypesEEnum, FlowConditionTypes.ONE);
		addEEnumLiteral(flowConditionTypesEEnum, FlowConditionTypes.ALL);
		addEEnumLiteral(flowConditionTypesEEnum, FlowConditionTypes.COMPLEX);

		initEEnum(transactionMethodTypeEEnum, TransactionMethodType.class, "TransactionMethodType");
		addEEnumLiteral(transactionMethodTypeEEnum, TransactionMethodType.COMPENSATE);
		addEEnumLiteral(transactionMethodTypeEEnum, TransactionMethodType.STORE);
		addEEnumLiteral(transactionMethodTypeEEnum, TransactionMethodType.IMAGE);

		initEEnum(gatewayTypeEEnum, GatewayType.class, "GatewayType");
		addEEnumLiteral(gatewayTypeEEnum, GatewayType.XOR_DATA);
		addEEnumLiteral(gatewayTypeEEnum, GatewayType.XOR_EVENT);
		addEEnumLiteral(gatewayTypeEEnum, GatewayType.OR);
		addEEnumLiteral(gatewayTypeEEnum, GatewayType.COMPLEX);
		addEEnumLiteral(gatewayTypeEEnum, GatewayType.AND);

		initEEnum(conditionTypeEEnum, ConditionType.class, "ConditionType");
		addEEnumLiteral(conditionTypeEEnum, ConditionType.NONE);
		addEEnumLiteral(conditionTypeEEnum, ConditionType.EXPRESSION);
		addEEnumLiteral(conditionTypeEEnum, ConditionType.DEFAULT);

		initEEnum(directionTypeEEnum, DirectionType.class, "DirectionType");
		addEEnumLiteral(directionTypeEEnum, DirectionType.ONE);
		addEEnumLiteral(directionTypeEEnum, DirectionType.NONE);
		addEEnumLiteral(directionTypeEEnum, DirectionType.BOTH);

		initEEnum(participantTypeEEnum, ParticipantType.class, "ParticipantType");
		addEEnumLiteral(participantTypeEEnum, ParticipantType.ROLE);
		addEEnumLiteral(participantTypeEEnum, ParticipantType.ENTITY);

		initEEnum(assignTimeTypeEEnum, AssignTimeType.class, "AssignTimeType");
		addEEnumLiteral(assignTimeTypeEEnum, AssignTimeType.START);
		addEEnumLiteral(assignTimeTypeEEnum, AssignTimeType.END);

		// Create resource
		createResource(eNS_URI);
	}

} //VsdtPackageImpl
