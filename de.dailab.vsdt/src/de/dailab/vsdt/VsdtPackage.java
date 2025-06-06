/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.VsdtFactory
 * @model kind="package"
 * @generated
 */
public interface VsdtPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "vsdt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.dailab.vsdt";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "vsdt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VsdtPackage eINSTANCE = de.dailab.vsdt.impl.VsdtPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.IdObjectImpl <em>Id Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.IdObjectImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getIdObject()
	 * @generated
	 */
	int ID_OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_OBJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_OBJECT__DOCUMENTATION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_OBJECT__ID = 2;

	/**
	 * The number of structural features of the '<em>Id Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ID_OBJECT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl <em>Business Process System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.BusinessProcessSystemImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getBusinessProcessSystem()
	 * @generated
	 */
	int BUSINESS_PROCESS_SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__NAME = ID_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__DOCUMENTATION = ID_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__VERSION = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__AUTHOR = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__LANGUAGE = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Query Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE = ID_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__CREATION_DATE = ID_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Modification Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE = ID_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Executable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__EXECUTABLE = ID_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Business Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES = ID_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__PARTICIPANTS = ID_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Message Channels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS = ID_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__SERVICES = ID_OBJECT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Data Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__DATA_TYPES = ID_OBJECT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM__PARAMETERS = ID_OBJECT_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>Business Process System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_SYSTEM_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.BusinessProcessDiagramImpl <em>Business Process Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.BusinessProcessDiagramImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getBusinessProcessDiagram()
	 * @generated
	 */
	int BUSINESS_PROCESS_DIAGRAM = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DIAGRAM__NAME = ID_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DIAGRAM__DOCUMENTATION = ID_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DIAGRAM__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DIAGRAM__PARENT = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pools</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DIAGRAM__POOLS = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DIAGRAM__ARTIFACTS = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DIAGRAM__CONNECTIONS = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS = ID_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Business Process Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUSINESS_PROCESS_DIAGRAM_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.AbstractProcessImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getAbstractProcess()
	 * @generated
	 */
	int ABSTRACT_PROCESS = 3;

	/**
	 * The feature id for the '<em><b>Ad Hoc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__AD_HOC = 0;

	/**
	 * The feature id for the '<em><b>Ad Hoc Completion Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS__PROPERTIES = 2;

	/**
	 * The number of structural features of the '<em>Abstract Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PROCESS_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.FlowObjectContainerImpl <em>Flow Object Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.FlowObjectContainerImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getFlowObjectContainer()
	 * @generated
	 */
	int FLOW_OBJECT_CONTAINER = 6;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.GraphicalObjectImpl <em>Graphical Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.GraphicalObjectImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getGraphicalObject()
	 * @generated
	 */
	int GRAPHICAL_OBJECT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_OBJECT__NAME = ID_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_OBJECT__DOCUMENTATION = ID_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_OBJECT__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_OBJECT__OUTGOING_ASS = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_OBJECT__INCOMING_ASS = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Graphical Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICAL_OBJECT_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.NodeImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = GRAPHICAL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__DOCUMENTATION = GRAPHICAL_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = GRAPHICAL_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_ASS = GRAPHICAL_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_ASS = GRAPHICAL_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_MSG = GRAPHICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_MSG = GRAPHICAL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = GRAPHICAL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.FlowObjectImpl <em>Flow Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.FlowObjectImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getFlowObject()
	 * @generated
	 */
	int FLOW_OBJECT = 9;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.EventImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 10;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.StartImpl <em>Start</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.StartImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getStart()
	 * @generated
	 */
	int START = 11;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.IntermediateImpl <em>Intermediate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.IntermediateImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getIntermediate()
	 * @generated
	 */
	int INTERMEDIATE = 12;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.EndImpl <em>End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.EndImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getEnd()
	 * @generated
	 */
	int END = 13;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.ActivityImpl <em>Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.ActivityImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getActivity()
	 * @generated
	 */
	int ACTIVITY = 14;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.InputSetImpl <em>Input Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.InputSetImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getInputSet()
	 * @generated
	 */
	int INPUT_SET = 18;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.OutputSetImpl <em>Output Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.OutputSetImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getOutputSet()
	 * @generated
	 */
	int OUTPUT_SET = 19;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.LoopAttributeSetImpl <em>Loop Attribute Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.LoopAttributeSetImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getLoopAttributeSet()
	 * @generated
	 */
	int LOOP_ATTRIBUTE_SET = 15;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.StandardLoopAttSetImpl <em>Standard Loop Att Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.StandardLoopAttSetImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getStandardLoopAttSet()
	 * @generated
	 */
	int STANDARD_LOOP_ATT_SET = 16;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.MultiLoopAttSetImpl <em>Multi Loop Att Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.MultiLoopAttSetImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getMultiLoopAttSet()
	 * @generated
	 */
	int MULTI_LOOP_ATT_SET = 17;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.TransactionImpl <em>Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.TransactionImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getTransaction()
	 * @generated
	 */
	int TRANSACTION = 20;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.GatewayImpl <em>Gateway</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.GatewayImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getGateway()
	 * @generated
	 */
	int GATEWAY = 21;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.PoolImpl <em>Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.PoolImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getPool()
	 * @generated
	 */
	int POOL = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__DOCUMENTATION = NODE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__OUTGOING_ASS = NODE__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__INCOMING_ASS = NODE__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__OUTGOING_MSG = NODE__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__INCOMING_MSG = NODE__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Ad Hoc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__AD_HOC = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ad Hoc Completion Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__AD_HOC_COMPLETION_CONDITION = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__PROPERTIES = NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__PARENT = NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Participant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__PARTICIPANT = NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Lanes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__LANES = NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Boundary Visible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__BOUNDARY_VISIBLE = NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Process Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL__PROCESS_TYPE = NODE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POOL_FEATURE_COUNT = NODE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.LaneImpl <em>Lane</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.LaneImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getLane()
	 * @generated
	 */
	int LANE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__NAME = GRAPHICAL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__DOCUMENTATION = GRAPHICAL_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__ID = GRAPHICAL_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__OUTGOING_ASS = GRAPHICAL_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__INCOMING_ASS = GRAPHICAL_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Contained Flow Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__CONTAINED_FLOW_OBJECTS = GRAPHICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE__PARENT = GRAPHICAL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Lane</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LANE_FEATURE_COUNT = GRAPHICAL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Contained Flow Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS = 0;

	/**
	 * The number of structural features of the '<em>Flow Object Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__DOCUMENTATION = NODE__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__OUTGOING_ASS = NODE__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__INCOMING_ASS = NODE__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__OUTGOING_MSG = NODE__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__INCOMING_MSG = NODE__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__PARENT = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__ASSIGNMENTS = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__OUTGOING_SEQ = NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT__INCOMING_SEQ = NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Flow Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_OBJECT_FEATURE_COUNT = NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DOCUMENTATION = FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ID = FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__OUTGOING_ASS = FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__INCOMING_ASS = FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__OUTGOING_MSG = FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__INCOMING_MSG = FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PARENT = FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ASSIGNMENTS = FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__OUTGOING_SEQ = FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__INCOMING_SEQ = FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Non Interrupting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NON_INTERRUPTING = FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TRIGGER = FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__IMPLEMENTATION = FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Time Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TIME_EXPRESSION = FLOW_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>As Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__AS_DURATION = FLOW_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Rule Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__RULE_EXPRESSION = FLOW_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ERROR_CODE = FLOW_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ACTIVITY = FLOW_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SIGNAL = FLOW_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Signal Thrown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__SIGNAL_THROWN = FLOW_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Linked To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__LINKED_TO = FLOW_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = FLOW_OBJECT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__DOCUMENTATION = EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__OUTGOING_ASS = EVENT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__INCOMING_ASS = EVENT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__OUTGOING_MSG = EVENT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__INCOMING_MSG = EVENT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__PARENT = EVENT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__ASSIGNMENTS = EVENT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__OUTGOING_SEQ = EVENT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__INCOMING_SEQ = EVENT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Non Interrupting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__NON_INTERRUPTING = EVENT__NON_INTERRUPTING;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__TRIGGER = EVENT__TRIGGER;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__IMPLEMENTATION = EVENT__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Time Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__TIME_EXPRESSION = EVENT__TIME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>As Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__AS_DURATION = EVENT__AS_DURATION;

	/**
	 * The feature id for the '<em><b>Rule Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__RULE_EXPRESSION = EVENT__RULE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__ERROR_CODE = EVENT__ERROR_CODE;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__ACTIVITY = EVENT__ACTIVITY;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__SIGNAL = EVENT__SIGNAL;

	/**
	 * The feature id for the '<em><b>Signal Thrown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__SIGNAL_THROWN = EVENT__SIGNAL_THROWN;

	/**
	 * The feature id for the '<em><b>Linked To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START__LINKED_TO = EVENT__LINKED_TO;

	/**
	 * The number of structural features of the '<em>Start</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__DOCUMENTATION = EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__OUTGOING_ASS = EVENT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__INCOMING_ASS = EVENT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__OUTGOING_MSG = EVENT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__INCOMING_MSG = EVENT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__PARENT = EVENT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__ASSIGNMENTS = EVENT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__OUTGOING_SEQ = EVENT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__INCOMING_SEQ = EVENT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Non Interrupting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__NON_INTERRUPTING = EVENT__NON_INTERRUPTING;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__TRIGGER = EVENT__TRIGGER;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__IMPLEMENTATION = EVENT__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Time Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__TIME_EXPRESSION = EVENT__TIME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>As Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__AS_DURATION = EVENT__AS_DURATION;

	/**
	 * The feature id for the '<em><b>Rule Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__RULE_EXPRESSION = EVENT__RULE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__ERROR_CODE = EVENT__ERROR_CODE;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__ACTIVITY = EVENT__ACTIVITY;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__SIGNAL = EVENT__SIGNAL;

	/**
	 * The feature id for the '<em><b>Signal Thrown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__SIGNAL_THROWN = EVENT__SIGNAL_THROWN;

	/**
	 * The feature id for the '<em><b>Linked To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__LINKED_TO = EVENT__LINKED_TO;

	/**
	 * The feature id for the '<em><b>Attached To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE__ATTACHED_TO = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Intermediate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERMEDIATE_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__DOCUMENTATION = EVENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__OUTGOING_ASS = EVENT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__INCOMING_ASS = EVENT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__OUTGOING_MSG = EVENT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__INCOMING_MSG = EVENT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__PARENT = EVENT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__ASSIGNMENTS = EVENT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__OUTGOING_SEQ = EVENT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__INCOMING_SEQ = EVENT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Non Interrupting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__NON_INTERRUPTING = EVENT__NON_INTERRUPTING;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__TRIGGER = EVENT__TRIGGER;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__IMPLEMENTATION = EVENT__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Time Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__TIME_EXPRESSION = EVENT__TIME_EXPRESSION;

	/**
	 * The feature id for the '<em><b>As Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__AS_DURATION = EVENT__AS_DURATION;

	/**
	 * The feature id for the '<em><b>Rule Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__RULE_EXPRESSION = EVENT__RULE_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__ERROR_CODE = EVENT__ERROR_CODE;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__ACTIVITY = EVENT__ACTIVITY;

	/**
	 * The feature id for the '<em><b>Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__SIGNAL = EVENT__SIGNAL;

	/**
	 * The feature id for the '<em><b>Signal Thrown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__SIGNAL_THROWN = EVENT__SIGNAL_THROWN;

	/**
	 * The feature id for the '<em><b>Linked To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__LINKED_TO = EVENT__LINKED_TO;

	/**
	 * The number of structural features of the '<em>End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_FEATURE_COUNT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__NAME = FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__DOCUMENTATION = FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__ID = FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__OUTGOING_ASS = FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__INCOMING_ASS = FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__OUTGOING_MSG = FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__INCOMING_MSG = FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__PARENT = FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__ASSIGNMENTS = FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__OUTGOING_SEQ = FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__INCOMING_SEQ = FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Ad Hoc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__AD_HOC = FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ad Hoc Completion Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__AD_HOC_COMPLETION_CONDITION = FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__PROPERTIES = FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Contained Flow Objects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__CONTAINED_FLOW_OBJECTS = FLOW_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Input Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__INPUT_SETS = FLOW_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Output Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__OUTPUT_SETS = FLOW_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>IO Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__IO_RULES = FLOW_OBJECT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Loop Attributes</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__LOOP_ATTRIBUTES = FLOW_OBJECT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Boundary Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__BOUNDARY_EVENTS = FLOW_OBJECT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Evented Subprocess</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__EVENTED_SUBPROCESS = FLOW_OBJECT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Activity Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__ACTIVITY_TYPE = FLOW_OBJECT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__IMPLEMENTATION = FLOW_OBJECT_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Performers</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__PERFORMERS = FLOW_OBJECT_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__SCRIPT = FLOW_OBJECT_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Transaction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__TRANSACTION = FLOW_OBJECT_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Called Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__CALLED_ELEMENT = FLOW_OBJECT_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Input Property Maps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__INPUT_PROPERTY_MAPS = FLOW_OBJECT_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Output Property Maps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__OUTPUT_PROPERTY_MAPS = FLOW_OBJECT_FEATURE_COUNT + 17;

	/**
	 * The number of structural features of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FEATURE_COUNT = FLOW_OBJECT_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ATTRIBUTE_SET__PARENT = 0;

	/**
	 * The number of structural features of the '<em>Loop Attribute Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_ATTRIBUTE_SET_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_ATT_SET__PARENT = LOOP_ATTRIBUTE_SET__PARENT;

	/**
	 * The feature id for the '<em><b>Loop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_ATT_SET__LOOP_CONDITION = LOOP_ATTRIBUTE_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Loop Maximum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_ATT_SET__LOOP_MAXIMUM = LOOP_ATTRIBUTE_SET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Test Before</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_ATT_SET__TEST_BEFORE = LOOP_ATTRIBUTE_SET_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Standard Loop Att Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STANDARD_LOOP_ATT_SET_FEATURE_COUNT = LOOP_ATTRIBUTE_SET_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LOOP_ATT_SET__PARENT = LOOP_ATTRIBUTE_SET__PARENT;

	/**
	 * The feature id for the '<em><b>MI Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LOOP_ATT_SET__MI_CONDITION = LOOP_ATTRIBUTE_SET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>MI Flow Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LOOP_ATT_SET__MI_FLOW_CONDITION = LOOP_ATTRIBUTE_SET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Complex MI Flow Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION = LOOP_ATTRIBUTE_SET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Sequential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LOOP_ATT_SET__SEQUENTIAL = LOOP_ATTRIBUTE_SET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Multi Loop Att Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_LOOP_ATT_SET_FEATURE_COUNT = LOOP_ATTRIBUTE_SET_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET__INPUTS = 0;

	/**
	 * The number of structural features of the '<em>Input Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SET_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET__OUTPUTS = 0;

	/**
	 * The number of structural features of the '<em>Output Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SET_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Transaction Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__TRANSACTION_ID = 0;

	/**
	 * The feature id for the '<em><b>Transaction Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__TRANSACTION_PROTOCOL = 1;

	/**
	 * The feature id for the '<em><b>Transaction Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION__TRANSACTION_METHOD = 2;

	/**
	 * The number of structural features of the '<em>Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSACTION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__NAME = FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__DOCUMENTATION = FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__ID = FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__OUTGOING_ASS = FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__INCOMING_ASS = FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__OUTGOING_MSG = FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__INCOMING_MSG = FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__PARENT = FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__ASSIGNMENTS = FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__OUTGOING_SEQ = FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__INCOMING_SEQ = FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Gateway Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__GATEWAY_TYPE = FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__INCOMING_CONDITION = FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY__OUTGOING_CONDITION = FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Gateway</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GATEWAY_FEATURE_COUNT = FLOW_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.ArtifactImpl <em>Artifact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.ArtifactImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getArtifact()
	 * @generated
	 */
	int ARTIFACT = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__NAME = GRAPHICAL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__DOCUMENTATION = GRAPHICAL_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__ID = GRAPHICAL_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__OUTGOING_ASS = GRAPHICAL_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__INCOMING_ASS = GRAPHICAL_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__PARENT = GRAPHICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT__POOL = GRAPHICAL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTIFACT_FEATURE_COUNT = GRAPHICAL_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.DataObjectImpl <em>Data Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.DataObjectImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getDataObject()
	 * @generated
	 */
	int DATA_OBJECT = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__NAME = ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__DOCUMENTATION = ARTIFACT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__ID = ARTIFACT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__OUTGOING_ASS = ARTIFACT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__INCOMING_ASS = ARTIFACT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__PARENT = ARTIFACT__PARENT;

	/**
	 * The feature id for the '<em><b>Pool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__POOL = ARTIFACT__POOL;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__PROPERTIES = ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required For Start</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__REQUIRED_FOR_START = ARTIFACT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Produced At Completion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__PRODUCED_AT_COMPLETION = ARTIFACT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT__STATE = ARTIFACT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Data Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OBJECT_FEATURE_COUNT = ARTIFACT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.TextAnnotationImpl <em>Text Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.TextAnnotationImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getTextAnnotation()
	 * @generated
	 */
	int TEXT_ANNOTATION = 24;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__NAME = ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__DOCUMENTATION = ARTIFACT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__ID = ARTIFACT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__OUTGOING_ASS = ARTIFACT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__INCOMING_ASS = ARTIFACT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__PARENT = ARTIFACT__PARENT;

	/**
	 * The feature id for the '<em><b>Pool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION__POOL = ARTIFACT__POOL;

	/**
	 * The number of structural features of the '<em>Text Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_ANNOTATION_FEATURE_COUNT = ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.GroupImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = ARTIFACT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DOCUMENTATION = ARTIFACT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__ID = ARTIFACT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__OUTGOING_ASS = ARTIFACT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__INCOMING_ASS = ARTIFACT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__PARENT = ARTIFACT__PARENT;

	/**
	 * The feature id for the '<em><b>Pool</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__POOL = ARTIFACT__POOL;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = ARTIFACT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.ConnectingObjectImpl <em>Connecting Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.ConnectingObjectImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getConnectingObject()
	 * @generated
	 */
	int CONNECTING_OBJECT = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTING_OBJECT__NAME = GRAPHICAL_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTING_OBJECT__DOCUMENTATION = GRAPHICAL_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTING_OBJECT__ID = GRAPHICAL_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTING_OBJECT__OUTGOING_ASS = GRAPHICAL_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTING_OBJECT__INCOMING_ASS = GRAPHICAL_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTING_OBJECT__PARENT = GRAPHICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connecting Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTING_OBJECT_FEATURE_COUNT = GRAPHICAL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.SequenceFlowImpl <em>Sequence Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.SequenceFlowImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getSequenceFlow()
	 * @generated
	 */
	int SEQUENCE_FLOW = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__NAME = CONNECTING_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__DOCUMENTATION = CONNECTING_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__ID = CONNECTING_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__OUTGOING_ASS = CONNECTING_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__INCOMING_ASS = CONNECTING_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__PARENT = CONNECTING_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Condition Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__CONDITION_TYPE = CONNECTING_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__CONDITION_EXPRESSION = CONNECTING_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__SOURCE = CONNECTING_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW__TARGET = CONNECTING_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sequence Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FLOW_FEATURE_COUNT = CONNECTING_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.MessageFlowImpl <em>Message Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.MessageFlowImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getMessageFlow()
	 * @generated
	 */
	int MESSAGE_FLOW = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__NAME = CONNECTING_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__DOCUMENTATION = CONNECTING_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__ID = CONNECTING_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__OUTGOING_ASS = CONNECTING_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__INCOMING_ASS = CONNECTING_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__PARENT = CONNECTING_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__SOURCE = CONNECTING_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW__TARGET = CONNECTING_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Message Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FLOW_FEATURE_COUNT = CONNECTING_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.AssociationImpl <em>Association</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.AssociationImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getAssociation()
	 * @generated
	 */
	int ASSOCIATION = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__NAME = CONNECTING_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__DOCUMENTATION = CONNECTING_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__ID = CONNECTING_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__OUTGOING_ASS = CONNECTING_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__INCOMING_ASS = CONNECTING_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__PARENT = CONNECTING_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__DIRECTION = CONNECTING_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__SOURCE = CONNECTING_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION__TARGET = CONNECTING_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Association</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_FEATURE_COUNT = CONNECTING_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.ParticipantImpl <em>Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.ParticipantImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getParticipant()
	 * @generated
	 */
	int PARTICIPANT = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__NAME = ID_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__DOCUMENTATION = ID_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__ID = ID_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__TYPE = ID_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Associated Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__ASSOCIATED_PROCESSES = ID_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Associated Pools</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__ASSOCIATED_POOLS = ID_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_FEATURE_COUNT = ID_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.ImplementationImpl <em>Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.ImplementationImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getImplementation()
	 * @generated
	 */
	int IMPLEMENTATION = 31;

	/**
	 * The number of structural features of the '<em>Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.MessageChannelImpl <em>Message Channel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.MessageChannelImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getMessageChannel()
	 * @generated
	 */
	int MESSAGE_CHANNEL = 32;

	/**
	 * The feature id for the '<em><b>Channel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CHANNEL__CHANNEL = IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Payload</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CHANNEL__PAYLOAD = IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sender</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CHANNEL__SENDER = IMPLEMENTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CHANNEL__RECEIVER = IMPLEMENTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Message Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CHANNEL__MESSAGE_GROUP = IMPLEMENTATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Message Channel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_CHANNEL_FEATURE_COUNT = IMPLEMENTATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.ServiceImpl <em>Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.ServiceImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getService()
	 * @generated
	 */
	int SERVICE = 33;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TYPE = IMPLEMENTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Participant</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PARTICIPANT = IMPLEMENTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__INTERFACE = IMPLEMENTATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__OPERATION = IMPLEMENTATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__DESCRIPTION = IMPLEMENTATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__LOCATION = IMPLEMENTATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__INPUT = IMPLEMENTATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__OUTPUT = IMPLEMENTATION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__PRECONDITIONS = IMPLEMENTATION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Effects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__EFFECTS = IMPLEMENTATION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE__TEMPLATE = IMPLEMENTATION_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_FEATURE_COUNT = IMPLEMENTATION_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.AssignmentImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 34;

	/**
	 * The feature id for the '<em><b>To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__TO = 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__FROM = 1;

	/**
	 * The feature id for the '<em><b>Assign Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__ASSIGN_TIME = 2;

	/**
	 * The feature id for the '<em><b>To Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__TO_QUERY = 3;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.PropertyImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.ParameterImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 36;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__DESCRIPTION = 2;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.ExpressionImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 37;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION__LANGUAGE = 1;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.impl.DataTypeImpl
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__PACKAGE = 1;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__LANGUAGE = 2;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__URL = 3;

	/**
	 * The feature id for the '<em><b>Inherits</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__INHERITS = 4;

	/**
	 * The feature id for the '<em><b>Members</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__MEMBERS = 5;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.ProcessType <em>Process Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.ProcessType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getProcessType()
	 * @generated
	 */
	int PROCESS_TYPE = 39;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.TriggerType <em>Trigger Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.TriggerType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getTriggerType()
	 * @generated
	 */
	int TRIGGER_TYPE = 40;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.FlowConditionTypes <em>Flow Condition Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.FlowConditionTypes
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getFlowConditionTypes()
	 * @generated
	 */
	int FLOW_CONDITION_TYPES = 43;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.ActivityType <em>Activity Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.ActivityType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getActivityType()
	 * @generated
	 */
	int ACTIVITY_TYPE = 41;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.LoopType <em>Loop Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.LoopType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getLoopType()
	 * @generated
	 */
	int LOOP_TYPE = 42;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.TransactionMethodType <em>Transaction Method Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.TransactionMethodType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getTransactionMethodType()
	 * @generated
	 */
	int TRANSACTION_METHOD_TYPE = 44;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.GatewayType <em>Gateway Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.GatewayType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getGatewayType()
	 * @generated
	 */
	int GATEWAY_TYPE = 45;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.ConditionType <em>Condition Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.ConditionType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getConditionType()
	 * @generated
	 */
	int CONDITION_TYPE = 46;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.DirectionType <em>Direction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.DirectionType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getDirectionType()
	 * @generated
	 */
	int DIRECTION_TYPE = 47;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.ParticipantType <em>Participant Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.ParticipantType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getParticipantType()
	 * @generated
	 */
	int PARTICIPANT_TYPE = 48;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.AssignTimeType <em>Assign Time Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.AssignTimeType
	 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getAssignTimeType()
	 * @generated
	 */
	int ASSIGN_TIME_TYPE = 49;

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.BusinessProcessDiagram <em>Business Process Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Process Diagram</em>'.
	 * @see de.dailab.vsdt.BusinessProcessDiagram
	 * @generated
	 */
	EClass getBusinessProcessDiagram();

	/**
	 * Returns the meta object for the container reference '{@link de.dailab.vsdt.BusinessProcessDiagram#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getParent()
	 * @see #getBusinessProcessDiagram()
	 * @generated
	 */
	EReference getBusinessProcessDiagram_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.BusinessProcessDiagram#getPools <em>Pools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pools</em>'.
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getPools()
	 * @see #getBusinessProcessDiagram()
	 * @generated
	 */
	EReference getBusinessProcessDiagram_Pools();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.BusinessProcessDiagram#getArtifacts <em>Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Artifacts</em>'.
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getArtifacts()
	 * @see #getBusinessProcessDiagram()
	 * @generated
	 */
	EReference getBusinessProcessDiagram_Artifacts();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.BusinessProcessDiagram#getConnections <em>Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Connections</em>'.
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getConnections()
	 * @see #getBusinessProcessDiagram()
	 * @generated
	 */
	EReference getBusinessProcessDiagram_Connections();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.BusinessProcessDiagram#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Participants</em>'.
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getParticipants()
	 * @see #getBusinessProcessDiagram()
	 * @generated
	 */
	EReference getBusinessProcessDiagram_Participants();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.FlowObjectContainer <em>Flow Object Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Object Container</em>'.
	 * @see de.dailab.vsdt.FlowObjectContainer
	 * @generated
	 */
	EClass getFlowObjectContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.FlowObjectContainer#getContainedFlowObjects <em>Contained Flow Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Flow Objects</em>'.
	 * @see de.dailab.vsdt.FlowObjectContainer#getContainedFlowObjects()
	 * @see #getFlowObjectContainer()
	 * @generated
	 */
	EReference getFlowObjectContainer_ContainedFlowObjects();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.AbstractProcess <em>Abstract Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Process</em>'.
	 * @see de.dailab.vsdt.AbstractProcess
	 * @generated
	 */
	EClass getAbstractProcess();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.AbstractProcess#isAdHoc <em>Ad Hoc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ad Hoc</em>'.
	 * @see de.dailab.vsdt.AbstractProcess#isAdHoc()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EAttribute getAbstractProcess_AdHoc();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.AbstractProcess#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ad Hoc Completion Condition</em>'.
	 * @see de.dailab.vsdt.AbstractProcess#getAdHocCompletionCondition()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_AdHocCompletionCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.AbstractProcess#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see de.dailab.vsdt.AbstractProcess#getProperties()
	 * @see #getAbstractProcess()
	 * @generated
	 */
	EReference getAbstractProcess_Properties();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.GraphicalObject <em>Graphical Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphical Object</em>'.
	 * @see de.dailab.vsdt.GraphicalObject
	 * @generated
	 */
	EClass getGraphicalObject();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.GraphicalObject#getOutgoingAss <em>Outgoing Ass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Ass</em>'.
	 * @see de.dailab.vsdt.GraphicalObject#getOutgoingAss()
	 * @see #getGraphicalObject()
	 * @generated
	 */
	EReference getGraphicalObject_OutgoingAss();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.GraphicalObject#getIncomingAss <em>Incoming Ass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Ass</em>'.
	 * @see de.dailab.vsdt.GraphicalObject#getIncomingAss()
	 * @see #getGraphicalObject()
	 * @generated
	 */
	EReference getGraphicalObject_IncomingAss();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see de.dailab.vsdt.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.Node#getOutgoingMsg <em>Outgoing Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Msg</em>'.
	 * @see de.dailab.vsdt.Node#getOutgoingMsg()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutgoingMsg();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.Node#getIncomingMsg <em>Incoming Msg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Msg</em>'.
	 * @see de.dailab.vsdt.Node#getIncomingMsg()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_IncomingMsg();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.FlowObject <em>Flow Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Object</em>'.
	 * @see de.dailab.vsdt.FlowObject
	 * @generated
	 */
	EClass getFlowObject();

	/**
	 * Returns the meta object for the container reference '{@link de.dailab.vsdt.FlowObject#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see de.dailab.vsdt.FlowObject#getParent()
	 * @see #getFlowObject()
	 * @generated
	 */
	EReference getFlowObject_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.FlowObject#getAssignments <em>Assignments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignments</em>'.
	 * @see de.dailab.vsdt.FlowObject#getAssignments()
	 * @see #getFlowObject()
	 * @generated
	 */
	EReference getFlowObject_Assignments();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.FlowObject#getOutgoingSeq <em>Outgoing Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Seq</em>'.
	 * @see de.dailab.vsdt.FlowObject#getOutgoingSeq()
	 * @see #getFlowObject()
	 * @generated
	 */
	EReference getFlowObject_OutgoingSeq();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.FlowObject#getIncomingSeq <em>Incoming Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Seq</em>'.
	 * @see de.dailab.vsdt.FlowObject#getIncomingSeq()
	 * @see #getFlowObject()
	 * @generated
	 */
	EReference getFlowObject_IncomingSeq();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see de.dailab.vsdt.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Event#isNonInterrupting <em>Non Interrupting</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Non Interrupting</em>'.
	 * @see de.dailab.vsdt.Event#isNonInterrupting()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_NonInterrupting();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Event#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Trigger</em>'.
	 * @see de.dailab.vsdt.Event#getTrigger()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Trigger();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Event#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see de.dailab.vsdt.Event#getImplementation()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Implementation();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.Event#getTimeExpression <em>Time Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Expression</em>'.
	 * @see de.dailab.vsdt.Event#getTimeExpression()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_TimeExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Event#isAsDuration <em>As Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>As Duration</em>'.
	 * @see de.dailab.vsdt.Event#isAsDuration()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_AsDuration();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.Event#getRuleExpression <em>Rule Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rule Expression</em>'.
	 * @see de.dailab.vsdt.Event#getRuleExpression()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_RuleExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Event#getErrorCode <em>Error Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Error Code</em>'.
	 * @see de.dailab.vsdt.Event#getErrorCode()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_ErrorCode();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Event#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity</em>'.
	 * @see de.dailab.vsdt.Event#getActivity()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_Activity();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Event#getSignal <em>Signal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signal</em>'.
	 * @see de.dailab.vsdt.Event#getSignal()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_Signal();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Event#isSignalThrown <em>Signal Thrown</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Signal Thrown</em>'.
	 * @see de.dailab.vsdt.Event#isSignalThrown()
	 * @see #getEvent()
	 * @generated
	 */
	EAttribute getEvent_SignalThrown();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Event#getLinkedTo <em>Linked To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked To</em>'.
	 * @see de.dailab.vsdt.Event#getLinkedTo()
	 * @see #getEvent()
	 * @generated
	 */
	EReference getEvent_LinkedTo();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Start <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start</em>'.
	 * @see de.dailab.vsdt.Start
	 * @generated
	 */
	EClass getStart();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Intermediate <em>Intermediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Intermediate</em>'.
	 * @see de.dailab.vsdt.Intermediate
	 * @generated
	 */
	EClass getIntermediate();

	/**
	 * Returns the meta object for the container reference '{@link de.dailab.vsdt.Intermediate#getAttachedTo <em>Attached To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Attached To</em>'.
	 * @see de.dailab.vsdt.Intermediate#getAttachedTo()
	 * @see #getIntermediate()
	 * @generated
	 */
	EReference getIntermediate_AttachedTo();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.End <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End</em>'.
	 * @see de.dailab.vsdt.End
	 * @generated
	 */
	EClass getEnd();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity</em>'.
	 * @see de.dailab.vsdt.Activity
	 * @generated
	 */
	EClass getActivity();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Activity#getInputSets <em>Input Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Sets</em>'.
	 * @see de.dailab.vsdt.Activity#getInputSets()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_InputSets();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Activity#getOutputSets <em>Output Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Sets</em>'.
	 * @see de.dailab.vsdt.Activity#getOutputSets()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_OutputSets();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Activity#getIORules <em>IO Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>IO Rules</em>'.
	 * @see de.dailab.vsdt.Activity#getIORules()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_IORules();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.Activity#getLoopAttributes <em>Loop Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop Attributes</em>'.
	 * @see de.dailab.vsdt.Activity#getLoopAttributes()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_LoopAttributes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Activity#getBoundaryEvents <em>Boundary Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Boundary Events</em>'.
	 * @see de.dailab.vsdt.Activity#getBoundaryEvents()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_BoundaryEvents();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Activity#isEventedSubprocess <em>Evented Subprocess</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Evented Subprocess</em>'.
	 * @see de.dailab.vsdt.Activity#isEventedSubprocess()
	 * @see #getActivity()
	 * @generated
	 */
	EAttribute getActivity_EventedSubprocess();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Activity#getActivityType <em>Activity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activity Type</em>'.
	 * @see de.dailab.vsdt.Activity#getActivityType()
	 * @see #getActivity()
	 * @generated
	 */
	EAttribute getActivity_ActivityType();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Activity#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see de.dailab.vsdt.Activity#getImplementation()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Implementation();

	/**
	 * Returns the meta object for the attribute list '{@link de.dailab.vsdt.Activity#getPerformers <em>Performers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Performers</em>'.
	 * @see de.dailab.vsdt.Activity#getPerformers()
	 * @see #getActivity()
	 * @generated
	 */
	EAttribute getActivity_Performers();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Activity#getScript <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Script</em>'.
	 * @see de.dailab.vsdt.Activity#getScript()
	 * @see #getActivity()
	 * @generated
	 */
	EAttribute getActivity_Script();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.Activity#getTransaction <em>Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transaction</em>'.
	 * @see de.dailab.vsdt.Activity#getTransaction()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_Transaction();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Activity#getCalledElement <em>Called Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Called Element</em>'.
	 * @see de.dailab.vsdt.Activity#getCalledElement()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_CalledElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Activity#getInputPropertyMaps <em>Input Property Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Property Maps</em>'.
	 * @see de.dailab.vsdt.Activity#getInputPropertyMaps()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_InputPropertyMaps();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Activity#getOutputPropertyMaps <em>Output Property Maps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Property Maps</em>'.
	 * @see de.dailab.vsdt.Activity#getOutputPropertyMaps()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_OutputPropertyMaps();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.InputSet <em>Input Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Set</em>'.
	 * @see de.dailab.vsdt.InputSet
	 * @generated
	 */
	EClass getInputSet();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.InputSet#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see de.dailab.vsdt.InputSet#getInputs()
	 * @see #getInputSet()
	 * @generated
	 */
	EReference getInputSet_Inputs();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.OutputSet <em>Output Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Set</em>'.
	 * @see de.dailab.vsdt.OutputSet
	 * @generated
	 */
	EClass getOutputSet();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.OutputSet#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see de.dailab.vsdt.OutputSet#getOutputs()
	 * @see #getOutputSet()
	 * @generated
	 */
	EReference getOutputSet_Outputs();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.LoopAttributeSet <em>Loop Attribute Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Attribute Set</em>'.
	 * @see de.dailab.vsdt.LoopAttributeSet
	 * @generated
	 */
	EClass getLoopAttributeSet();

	/**
	 * Returns the meta object for the container reference '{@link de.dailab.vsdt.LoopAttributeSet#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see de.dailab.vsdt.LoopAttributeSet#getParent()
	 * @see #getLoopAttributeSet()
	 * @generated
	 */
	EReference getLoopAttributeSet_Parent();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.StandardLoopAttSet <em>Standard Loop Att Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Standard Loop Att Set</em>'.
	 * @see de.dailab.vsdt.StandardLoopAttSet
	 * @generated
	 */
	EClass getStandardLoopAttSet();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.StandardLoopAttSet#getLoopCondition <em>Loop Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop Condition</em>'.
	 * @see de.dailab.vsdt.StandardLoopAttSet#getLoopCondition()
	 * @see #getStandardLoopAttSet()
	 * @generated
	 */
	EReference getStandardLoopAttSet_LoopCondition();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.StandardLoopAttSet#getLoopMaximum <em>Loop Maximum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loop Maximum</em>'.
	 * @see de.dailab.vsdt.StandardLoopAttSet#getLoopMaximum()
	 * @see #getStandardLoopAttSet()
	 * @generated
	 */
	EAttribute getStandardLoopAttSet_LoopMaximum();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.StandardLoopAttSet#isTestBefore <em>Test Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Test Before</em>'.
	 * @see de.dailab.vsdt.StandardLoopAttSet#isTestBefore()
	 * @see #getStandardLoopAttSet()
	 * @generated
	 */
	EAttribute getStandardLoopAttSet_TestBefore();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.MultiLoopAttSet <em>Multi Loop Att Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Loop Att Set</em>'.
	 * @see de.dailab.vsdt.MultiLoopAttSet
	 * @generated
	 */
	EClass getMultiLoopAttSet();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.MultiLoopAttSet#getMI_Condition <em>MI Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>MI Condition</em>'.
	 * @see de.dailab.vsdt.MultiLoopAttSet#getMI_Condition()
	 * @see #getMultiLoopAttSet()
	 * @generated
	 */
	EReference getMultiLoopAttSet_MI_Condition();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.MultiLoopAttSet#getMI_FlowCondition <em>MI Flow Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>MI Flow Condition</em>'.
	 * @see de.dailab.vsdt.MultiLoopAttSet#getMI_FlowCondition()
	 * @see #getMultiLoopAttSet()
	 * @generated
	 */
	EAttribute getMultiLoopAttSet_MI_FlowCondition();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.MultiLoopAttSet#getComplexMI_FlowCondition <em>Complex MI Flow Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Complex MI Flow Condition</em>'.
	 * @see de.dailab.vsdt.MultiLoopAttSet#getComplexMI_FlowCondition()
	 * @see #getMultiLoopAttSet()
	 * @generated
	 */
	EReference getMultiLoopAttSet_ComplexMI_FlowCondition();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.MultiLoopAttSet#isSequential <em>Sequential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequential</em>'.
	 * @see de.dailab.vsdt.MultiLoopAttSet#isSequential()
	 * @see #getMultiLoopAttSet()
	 * @generated
	 */
	EAttribute getMultiLoopAttSet_Sequential();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Transaction <em>Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transaction</em>'.
	 * @see de.dailab.vsdt.Transaction
	 * @generated
	 */
	EClass getTransaction();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Transaction#getTransactionId <em>Transaction Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Id</em>'.
	 * @see de.dailab.vsdt.Transaction#getTransactionId()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_TransactionId();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Transaction#getTransactionProtocol <em>Transaction Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Protocol</em>'.
	 * @see de.dailab.vsdt.Transaction#getTransactionProtocol()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_TransactionProtocol();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Transaction#getTransactionMethod <em>Transaction Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transaction Method</em>'.
	 * @see de.dailab.vsdt.Transaction#getTransactionMethod()
	 * @see #getTransaction()
	 * @generated
	 */
	EAttribute getTransaction_TransactionMethod();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Gateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gateway</em>'.
	 * @see de.dailab.vsdt.Gateway
	 * @generated
	 */
	EClass getGateway();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Gateway#getGatewayType <em>Gateway Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gateway Type</em>'.
	 * @see de.dailab.vsdt.Gateway#getGatewayType()
	 * @see #getGateway()
	 * @generated
	 */
	EAttribute getGateway_GatewayType();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.Gateway#getIncomingCondition <em>Incoming Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Incoming Condition</em>'.
	 * @see de.dailab.vsdt.Gateway#getIncomingCondition()
	 * @see #getGateway()
	 * @generated
	 */
	EReference getGateway_IncomingCondition();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.Gateway#getOutgoingCondition <em>Outgoing Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Outgoing Condition</em>'.
	 * @see de.dailab.vsdt.Gateway#getOutgoingCondition()
	 * @see #getGateway()
	 * @generated
	 */
	EReference getGateway_OutgoingCondition();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Pool <em>Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pool</em>'.
	 * @see de.dailab.vsdt.Pool
	 * @generated
	 */
	EClass getPool();

	/**
	 * Returns the meta object for the container reference '{@link de.dailab.vsdt.Pool#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see de.dailab.vsdt.Pool#getParent()
	 * @see #getPool()
	 * @generated
	 */
	EReference getPool_Parent();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Pool#getParticipant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Participant</em>'.
	 * @see de.dailab.vsdt.Pool#getParticipant()
	 * @see #getPool()
	 * @generated
	 */
	EReference getPool_Participant();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Pool#getLanes <em>Lanes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lanes</em>'.
	 * @see de.dailab.vsdt.Pool#getLanes()
	 * @see #getPool()
	 * @generated
	 */
	EReference getPool_Lanes();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Pool#isBoundaryVisible <em>Boundary Visible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boundary Visible</em>'.
	 * @see de.dailab.vsdt.Pool#isBoundaryVisible()
	 * @see #getPool()
	 * @generated
	 */
	EAttribute getPool_BoundaryVisible();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Pool#getProcessType <em>Process Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Type</em>'.
	 * @see de.dailab.vsdt.Pool#getProcessType()
	 * @see #getPool()
	 * @generated
	 */
	EAttribute getPool_ProcessType();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Lane <em>Lane</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lane</em>'.
	 * @see de.dailab.vsdt.Lane
	 * @generated
	 */
	EClass getLane();

	/**
	 * Returns the meta object for the container reference '{@link de.dailab.vsdt.Lane#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see de.dailab.vsdt.Lane#getParent()
	 * @see #getLane()
	 * @generated
	 */
	EReference getLane_Parent();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Artifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact</em>'.
	 * @see de.dailab.vsdt.Artifact
	 * @generated
	 */
	EClass getArtifact();

	/**
	 * Returns the meta object for the container reference '{@link de.dailab.vsdt.Artifact#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see de.dailab.vsdt.Artifact#getParent()
	 * @see #getArtifact()
	 * @generated
	 */
	EReference getArtifact_Parent();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Artifact#getPool <em>Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Pool</em>'.
	 * @see de.dailab.vsdt.Artifact#getPool()
	 * @see #getArtifact()
	 * @generated
	 */
	EReference getArtifact_Pool();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.DataObject <em>Data Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Object</em>'.
	 * @see de.dailab.vsdt.DataObject
	 * @generated
	 */
	EClass getDataObject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.DataObject#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see de.dailab.vsdt.DataObject#getProperties()
	 * @see #getDataObject()
	 * @generated
	 */
	EReference getDataObject_Properties();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.DataObject#isRequiredForStart <em>Required For Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required For Start</em>'.
	 * @see de.dailab.vsdt.DataObject#isRequiredForStart()
	 * @see #getDataObject()
	 * @generated
	 */
	EAttribute getDataObject_RequiredForStart();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.DataObject#isProducedAtCompletion <em>Produced At Completion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Produced At Completion</em>'.
	 * @see de.dailab.vsdt.DataObject#isProducedAtCompletion()
	 * @see #getDataObject()
	 * @generated
	 */
	EAttribute getDataObject_ProducedAtCompletion();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.DataObject#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>State</em>'.
	 * @see de.dailab.vsdt.DataObject#getState()
	 * @see #getDataObject()
	 * @generated
	 */
	EAttribute getDataObject_State();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.TextAnnotation <em>Text Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text Annotation</em>'.
	 * @see de.dailab.vsdt.TextAnnotation
	 * @generated
	 */
	EClass getTextAnnotation();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see de.dailab.vsdt.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.ConnectingObject <em>Connecting Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connecting Object</em>'.
	 * @see de.dailab.vsdt.ConnectingObject
	 * @generated
	 */
	EClass getConnectingObject();

	/**
	 * Returns the meta object for the container reference '{@link de.dailab.vsdt.ConnectingObject#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see de.dailab.vsdt.ConnectingObject#getParent()
	 * @see #getConnectingObject()
	 * @generated
	 */
	EReference getConnectingObject_Parent();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.SequenceFlow <em>Sequence Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence Flow</em>'.
	 * @see de.dailab.vsdt.SequenceFlow
	 * @generated
	 */
	EClass getSequenceFlow();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.SequenceFlow#getConditionType <em>Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition Type</em>'.
	 * @see de.dailab.vsdt.SequenceFlow#getConditionType()
	 * @see #getSequenceFlow()
	 * @generated
	 */
	EAttribute getSequenceFlow_ConditionType();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.SequenceFlow#getConditionExpression <em>Condition Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition Expression</em>'.
	 * @see de.dailab.vsdt.SequenceFlow#getConditionExpression()
	 * @see #getSequenceFlow()
	 * @generated
	 */
	EReference getSequenceFlow_ConditionExpression();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.SequenceFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.dailab.vsdt.SequenceFlow#getSource()
	 * @see #getSequenceFlow()
	 * @generated
	 */
	EReference getSequenceFlow_Source();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.SequenceFlow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.dailab.vsdt.SequenceFlow#getTarget()
	 * @see #getSequenceFlow()
	 * @generated
	 */
	EReference getSequenceFlow_Target();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.MessageFlow <em>Message Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Flow</em>'.
	 * @see de.dailab.vsdt.MessageFlow
	 * @generated
	 */
	EClass getMessageFlow();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.MessageFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.dailab.vsdt.MessageFlow#getSource()
	 * @see #getMessageFlow()
	 * @generated
	 */
	EReference getMessageFlow_Source();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.MessageFlow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.dailab.vsdt.MessageFlow#getTarget()
	 * @see #getMessageFlow()
	 * @generated
	 */
	EReference getMessageFlow_Target();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Association <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association</em>'.
	 * @see de.dailab.vsdt.Association
	 * @generated
	 */
	EClass getAssociation();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Association#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see de.dailab.vsdt.Association#getDirection()
	 * @see #getAssociation()
	 * @generated
	 */
	EAttribute getAssociation_Direction();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.dailab.vsdt.Association#getSource()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Source();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.dailab.vsdt.Association#getTarget()
	 * @see #getAssociation()
	 * @generated
	 */
	EReference getAssociation_Target();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant</em>'.
	 * @see de.dailab.vsdt.Participant
	 * @generated
	 */
	EClass getParticipant();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.Participant#getAssociatedProcesses <em>Associated Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associated Processes</em>'.
	 * @see de.dailab.vsdt.Participant#getAssociatedProcesses()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_AssociatedProcesses();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.Participant#getAssociatedPools <em>Associated Pools</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Associated Pools</em>'.
	 * @see de.dailab.vsdt.Participant#getAssociatedPools()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_AssociatedPools();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Participant#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.dailab.vsdt.Participant#getType()
	 * @see #getParticipant()
	 * @generated
	 */
	EAttribute getParticipant_Type();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation</em>'.
	 * @see de.dailab.vsdt.Implementation
	 * @generated
	 */
	EClass getImplementation();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.MessageChannel <em>Message Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Channel</em>'.
	 * @see de.dailab.vsdt.MessageChannel
	 * @generated
	 */
	EClass getMessageChannel();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.MessageChannel#getChannel <em>Channel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Channel</em>'.
	 * @see de.dailab.vsdt.MessageChannel#getChannel()
	 * @see #getMessageChannel()
	 * @generated
	 */
	EReference getMessageChannel_Channel();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.MessageChannel#getPayload <em>Payload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Payload</em>'.
	 * @see de.dailab.vsdt.MessageChannel#getPayload()
	 * @see #getMessageChannel()
	 * @generated
	 */
	EReference getMessageChannel_Payload();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.MessageChannel#getSender <em>Sender</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sender</em>'.
	 * @see de.dailab.vsdt.MessageChannel#getSender()
	 * @see #getMessageChannel()
	 * @generated
	 */
	EReference getMessageChannel_Sender();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.MessageChannel#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Receiver</em>'.
	 * @see de.dailab.vsdt.MessageChannel#getReceiver()
	 * @see #getMessageChannel()
	 * @generated
	 */
	EReference getMessageChannel_Receiver();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.MessageChannel#isMessageGroup <em>Message Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Group</em>'.
	 * @see de.dailab.vsdt.MessageChannel#isMessageGroup()
	 * @see #getMessageChannel()
	 * @generated
	 */
	EAttribute getMessageChannel_MessageGroup();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service</em>'.
	 * @see de.dailab.vsdt.Service
	 * @generated
	 */
	EClass getService();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Service#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.dailab.vsdt.Service#getType()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Type();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Service#getParticipant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Participant</em>'.
	 * @see de.dailab.vsdt.Service#getParticipant()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Participant();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Service#getInterface <em>Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interface</em>'.
	 * @see de.dailab.vsdt.Service#getInterface()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Interface();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Service#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.dailab.vsdt.Service#getOperation()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Operation();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Service#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.vsdt.Service#getDescription()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Service#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see de.dailab.vsdt.Service#getLocation()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Location();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Service#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input</em>'.
	 * @see de.dailab.vsdt.Service#getInput()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Input();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Service#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output</em>'.
	 * @see de.dailab.vsdt.Service#getOutput()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Output();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Service#getPreconditions <em>Preconditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Preconditions</em>'.
	 * @see de.dailab.vsdt.Service#getPreconditions()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Preconditions();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.Service#getEffects <em>Effects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Effects</em>'.
	 * @see de.dailab.vsdt.Service#getEffects()
	 * @see #getService()
	 * @generated
	 */
	EReference getService_Effects();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Service#isTemplate <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template</em>'.
	 * @see de.dailab.vsdt.Service#isTemplate()
	 * @see #getService()
	 * @generated
	 */
	EAttribute getService_Template();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see de.dailab.vsdt.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.Assignment#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To</em>'.
	 * @see de.dailab.vsdt.Assignment#getTo()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_To();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.Assignment#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>From</em>'.
	 * @see de.dailab.vsdt.Assignment#getFrom()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_From();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Assignment#getAssignTime <em>Assign Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assign Time</em>'.
	 * @see de.dailab.vsdt.Assignment#getAssignTime()
	 * @see #getAssignment()
	 * @generated
	 */
	EAttribute getAssignment_AssignTime();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Assignment#getToQuery <em>To Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Query</em>'.
	 * @see de.dailab.vsdt.Assignment#getToQuery()
	 * @see #getAssignment()
	 * @generated
	 */
	EAttribute getAssignment_ToQuery();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see de.dailab.vsdt.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Property#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.vsdt.Property#getName()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Property#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.dailab.vsdt.Property#getType()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Type();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see de.dailab.vsdt.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Parameter#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see de.dailab.vsdt.Parameter#getKey()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Key();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Parameter#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.dailab.vsdt.Parameter#getValue()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Value();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Parameter#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.vsdt.Parameter#getDescription()
	 * @see #getParameter()
	 * @generated
	 */
	EAttribute getParameter_Description();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see de.dailab.vsdt.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Expression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see de.dailab.vsdt.Expression#getExpression()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Expression();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.Expression#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see de.dailab.vsdt.Expression#getLanguage()
	 * @see #getExpression()
	 * @generated
	 */
	EAttribute getExpression_Language();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see de.dailab.vsdt.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.DataType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.vsdt.DataType#getName()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.DataType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see de.dailab.vsdt.DataType#getPackage()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Package();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.DataType#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see de.dailab.vsdt.DataType#getLanguage()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Language();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.DataType#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see de.dailab.vsdt.DataType#getUrl()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Url();

	/**
	 * Returns the meta object for the reference list '{@link de.dailab.vsdt.DataType#getInherits <em>Inherits</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inherits</em>'.
	 * @see de.dailab.vsdt.DataType#getInherits()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Inherits();

	/**
	 * Returns the meta object for the attribute list '{@link de.dailab.vsdt.DataType#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Members</em>'.
	 * @see de.dailab.vsdt.DataType#getMembers()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Members();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.IdObject <em>Id Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Id Object</em>'.
	 * @see de.dailab.vsdt.IdObject
	 * @generated
	 */
	EClass getIdObject();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.IdObject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.vsdt.IdObject#getName()
	 * @see #getIdObject()
	 * @generated
	 */
	EAttribute getIdObject_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.IdObject#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.dailab.vsdt.IdObject#getId()
	 * @see #getIdObject()
	 * @generated
	 */
	EAttribute getIdObject_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.IdObject#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Documentation</em>'.
	 * @see de.dailab.vsdt.IdObject#getDocumentation()
	 * @see #getIdObject()
	 * @generated
	 */
	EAttribute getIdObject_Documentation();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.BusinessProcessSystem <em>Business Process System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Business Process System</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem
	 * @generated
	 */
	EClass getBusinessProcessSystem();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.BusinessProcessSystem#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getVersion()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EAttribute getBusinessProcessSystem_Version();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.BusinessProcessSystem#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getAuthor()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EAttribute getBusinessProcessSystem_Author();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.BusinessProcessSystem#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getLanguage()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EAttribute getBusinessProcessSystem_Language();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.BusinessProcessSystem#getExpressionLanguage <em>Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Language</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getExpressionLanguage()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EAttribute getBusinessProcessSystem_ExpressionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.BusinessProcessSystem#getQueryLanguage <em>Query Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query Language</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getQueryLanguage()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EAttribute getBusinessProcessSystem_QueryLanguage();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.BusinessProcessSystem#getCreationDate <em>Creation Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Date</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getCreationDate()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EAttribute getBusinessProcessSystem_CreationDate();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.BusinessProcessSystem#getModificationDate <em>Modification Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Modification Date</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getModificationDate()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EAttribute getBusinessProcessSystem_ModificationDate();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.BusinessProcessSystem#isExecutable <em>Executable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Executable</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#isExecutable()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EAttribute getBusinessProcessSystem_Executable();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.BusinessProcessSystem#getBusinessProcesses <em>Business Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Business Processes</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getBusinessProcesses()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EReference getBusinessProcessSystem_BusinessProcesses();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.BusinessProcessSystem#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Participants</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getParticipants()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EReference getBusinessProcessSystem_Participants();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.BusinessProcessSystem#getMessageChannels <em>Message Channels</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Message Channels</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getMessageChannels()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EReference getBusinessProcessSystem_MessageChannels();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.BusinessProcessSystem#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Services</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getServices()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EReference getBusinessProcessSystem_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.BusinessProcessSystem#getDataTypes <em>Data Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Types</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getDataTypes()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EReference getBusinessProcessSystem_DataTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.BusinessProcessSystem#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see de.dailab.vsdt.BusinessProcessSystem#getParameters()
	 * @see #getBusinessProcessSystem()
	 * @generated
	 */
	EReference getBusinessProcessSystem_Parameters();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.ProcessType <em>Process Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Process Type</em>'.
	 * @see de.dailab.vsdt.ProcessType
	 * @generated
	 */
	EEnum getProcessType();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.TriggerType <em>Trigger Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Trigger Type</em>'.
	 * @see de.dailab.vsdt.TriggerType
	 * @generated
	 */
	EEnum getTriggerType();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.FlowConditionTypes <em>Flow Condition Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Flow Condition Types</em>'.
	 * @see de.dailab.vsdt.FlowConditionTypes
	 * @generated
	 */
	EEnum getFlowConditionTypes();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.ActivityType <em>Activity Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Activity Type</em>'.
	 * @see de.dailab.vsdt.ActivityType
	 * @generated
	 */
	EEnum getActivityType();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.LoopType <em>Loop Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Loop Type</em>'.
	 * @see de.dailab.vsdt.LoopType
	 * @generated
	 */
	EEnum getLoopType();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.TransactionMethodType <em>Transaction Method Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transaction Method Type</em>'.
	 * @see de.dailab.vsdt.TransactionMethodType
	 * @generated
	 */
	EEnum getTransactionMethodType();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.GatewayType <em>Gateway Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Gateway Type</em>'.
	 * @see de.dailab.vsdt.GatewayType
	 * @generated
	 */
	EEnum getGatewayType();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.ConditionType <em>Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Condition Type</em>'.
	 * @see de.dailab.vsdt.ConditionType
	 * @generated
	 */
	EEnum getConditionType();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.DirectionType <em>Direction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Direction Type</em>'.
	 * @see de.dailab.vsdt.DirectionType
	 * @generated
	 */
	EEnum getDirectionType();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.ParticipantType <em>Participant Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Participant Type</em>'.
	 * @see de.dailab.vsdt.ParticipantType
	 * @generated
	 */
	EEnum getParticipantType();

	/**
	 * Returns the meta object for enum '{@link de.dailab.vsdt.AssignTimeType <em>Assign Time Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Assign Time Type</em>'.
	 * @see de.dailab.vsdt.AssignTimeType
	 * @generated
	 */
	EEnum getAssignTimeType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VsdtFactory getVsdtFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.BusinessProcessDiagramImpl <em>Business Process Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.BusinessProcessDiagramImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getBusinessProcessDiagram()
		 * @generated
		 */
		EClass BUSINESS_PROCESS_DIAGRAM = eINSTANCE.getBusinessProcessDiagram();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_DIAGRAM__PARENT = eINSTANCE.getBusinessProcessDiagram_Parent();

		/**
		 * The meta object literal for the '<em><b>Pools</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_DIAGRAM__POOLS = eINSTANCE.getBusinessProcessDiagram_Pools();

		/**
		 * The meta object literal for the '<em><b>Artifacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_DIAGRAM__ARTIFACTS = eINSTANCE.getBusinessProcessDiagram_Artifacts();

		/**
		 * The meta object literal for the '<em><b>Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_DIAGRAM__CONNECTIONS = eINSTANCE.getBusinessProcessDiagram_Connections();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS = eINSTANCE.getBusinessProcessDiagram_Participants();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.FlowObjectContainerImpl <em>Flow Object Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.FlowObjectContainerImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getFlowObjectContainer()
		 * @generated
		 */
		EClass FLOW_OBJECT_CONTAINER = eINSTANCE.getFlowObjectContainer();

		/**
		 * The meta object literal for the '<em><b>Contained Flow Objects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS = eINSTANCE.getFlowObjectContainer_ContainedFlowObjects();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.AbstractProcessImpl <em>Abstract Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.AbstractProcessImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getAbstractProcess()
		 * @generated
		 */
		EClass ABSTRACT_PROCESS = eINSTANCE.getAbstractProcess();

		/**
		 * The meta object literal for the '<em><b>Ad Hoc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PROCESS__AD_HOC = eINSTANCE.getAbstractProcess_AdHoc();

		/**
		 * The meta object literal for the '<em><b>Ad Hoc Completion Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION = eINSTANCE.getAbstractProcess_AdHocCompletionCondition();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_PROCESS__PROPERTIES = eINSTANCE.getAbstractProcess_Properties();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.GraphicalObjectImpl <em>Graphical Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.GraphicalObjectImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getGraphicalObject()
		 * @generated
		 */
		EClass GRAPHICAL_OBJECT = eINSTANCE.getGraphicalObject();

		/**
		 * The meta object literal for the '<em><b>Outgoing Ass</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICAL_OBJECT__OUTGOING_ASS = eINSTANCE.getGraphicalObject_OutgoingAss();

		/**
		 * The meta object literal for the '<em><b>Incoming Ass</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICAL_OBJECT__INCOMING_ASS = eINSTANCE.getGraphicalObject_IncomingAss();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.NodeImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Outgoing Msg</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING_MSG = eINSTANCE.getNode_OutgoingMsg();

		/**
		 * The meta object literal for the '<em><b>Incoming Msg</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING_MSG = eINSTANCE.getNode_IncomingMsg();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.FlowObjectImpl <em>Flow Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.FlowObjectImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getFlowObject()
		 * @generated
		 */
		EClass FLOW_OBJECT = eINSTANCE.getFlowObject();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_OBJECT__PARENT = eINSTANCE.getFlowObject_Parent();

		/**
		 * The meta object literal for the '<em><b>Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_OBJECT__ASSIGNMENTS = eINSTANCE.getFlowObject_Assignments();

		/**
		 * The meta object literal for the '<em><b>Outgoing Seq</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_OBJECT__OUTGOING_SEQ = eINSTANCE.getFlowObject_OutgoingSeq();

		/**
		 * The meta object literal for the '<em><b>Incoming Seq</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_OBJECT__INCOMING_SEQ = eINSTANCE.getFlowObject_IncomingSeq();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.EventImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '<em><b>Non Interrupting</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__NON_INTERRUPTING = eINSTANCE.getEvent_NonInterrupting();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__TRIGGER = eINSTANCE.getEvent_Trigger();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__IMPLEMENTATION = eINSTANCE.getEvent_Implementation();

		/**
		 * The meta object literal for the '<em><b>Time Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__TIME_EXPRESSION = eINSTANCE.getEvent_TimeExpression();

		/**
		 * The meta object literal for the '<em><b>As Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__AS_DURATION = eINSTANCE.getEvent_AsDuration();

		/**
		 * The meta object literal for the '<em><b>Rule Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__RULE_EXPRESSION = eINSTANCE.getEvent_RuleExpression();

		/**
		 * The meta object literal for the '<em><b>Error Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__ERROR_CODE = eINSTANCE.getEvent_ErrorCode();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__ACTIVITY = eINSTANCE.getEvent_Activity();

		/**
		 * The meta object literal for the '<em><b>Signal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__SIGNAL = eINSTANCE.getEvent_Signal();

		/**
		 * The meta object literal for the '<em><b>Signal Thrown</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT__SIGNAL_THROWN = eINSTANCE.getEvent_SignalThrown();

		/**
		 * The meta object literal for the '<em><b>Linked To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT__LINKED_TO = eINSTANCE.getEvent_LinkedTo();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.StartImpl <em>Start</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.StartImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getStart()
		 * @generated
		 */
		EClass START = eINSTANCE.getStart();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.IntermediateImpl <em>Intermediate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.IntermediateImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getIntermediate()
		 * @generated
		 */
		EClass INTERMEDIATE = eINSTANCE.getIntermediate();

		/**
		 * The meta object literal for the '<em><b>Attached To</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERMEDIATE__ATTACHED_TO = eINSTANCE.getIntermediate_AttachedTo();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.EndImpl <em>End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.EndImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getEnd()
		 * @generated
		 */
		EClass END = eINSTANCE.getEnd();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.ActivityImpl <em>Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.ActivityImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getActivity()
		 * @generated
		 */
		EClass ACTIVITY = eINSTANCE.getActivity();

		/**
		 * The meta object literal for the '<em><b>Input Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__INPUT_SETS = eINSTANCE.getActivity_InputSets();

		/**
		 * The meta object literal for the '<em><b>Output Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__OUTPUT_SETS = eINSTANCE.getActivity_OutputSets();

		/**
		 * The meta object literal for the '<em><b>IO Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__IO_RULES = eINSTANCE.getActivity_IORules();

		/**
		 * The meta object literal for the '<em><b>Loop Attributes</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__LOOP_ATTRIBUTES = eINSTANCE.getActivity_LoopAttributes();

		/**
		 * The meta object literal for the '<em><b>Boundary Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__BOUNDARY_EVENTS = eINSTANCE.getActivity_BoundaryEvents();

		/**
		 * The meta object literal for the '<em><b>Evented Subprocess</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY__EVENTED_SUBPROCESS = eINSTANCE.getActivity_EventedSubprocess();

		/**
		 * The meta object literal for the '<em><b>Activity Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY__ACTIVITY_TYPE = eINSTANCE.getActivity_ActivityType();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__IMPLEMENTATION = eINSTANCE.getActivity_Implementation();

		/**
		 * The meta object literal for the '<em><b>Performers</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY__PERFORMERS = eINSTANCE.getActivity_Performers();

		/**
		 * The meta object literal for the '<em><b>Script</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTIVITY__SCRIPT = eINSTANCE.getActivity_Script();

		/**
		 * The meta object literal for the '<em><b>Transaction</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__TRANSACTION = eINSTANCE.getActivity_Transaction();

		/**
		 * The meta object literal for the '<em><b>Called Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__CALLED_ELEMENT = eINSTANCE.getActivity_CalledElement();

		/**
		 * The meta object literal for the '<em><b>Input Property Maps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__INPUT_PROPERTY_MAPS = eINSTANCE.getActivity_InputPropertyMaps();

		/**
		 * The meta object literal for the '<em><b>Output Property Maps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__OUTPUT_PROPERTY_MAPS = eINSTANCE.getActivity_OutputPropertyMaps();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.InputSetImpl <em>Input Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.InputSetImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getInputSet()
		 * @generated
		 */
		EClass INPUT_SET = eINSTANCE.getInputSet();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_SET__INPUTS = eINSTANCE.getInputSet_Inputs();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.OutputSetImpl <em>Output Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.OutputSetImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getOutputSet()
		 * @generated
		 */
		EClass OUTPUT_SET = eINSTANCE.getOutputSet();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_SET__OUTPUTS = eINSTANCE.getOutputSet_Outputs();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.LoopAttributeSetImpl <em>Loop Attribute Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.LoopAttributeSetImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getLoopAttributeSet()
		 * @generated
		 */
		EClass LOOP_ATTRIBUTE_SET = eINSTANCE.getLoopAttributeSet();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_ATTRIBUTE_SET__PARENT = eINSTANCE.getLoopAttributeSet_Parent();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.StandardLoopAttSetImpl <em>Standard Loop Att Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.StandardLoopAttSetImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getStandardLoopAttSet()
		 * @generated
		 */
		EClass STANDARD_LOOP_ATT_SET = eINSTANCE.getStandardLoopAttSet();

		/**
		 * The meta object literal for the '<em><b>Loop Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STANDARD_LOOP_ATT_SET__LOOP_CONDITION = eINSTANCE.getStandardLoopAttSet_LoopCondition();

		/**
		 * The meta object literal for the '<em><b>Loop Maximum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_LOOP_ATT_SET__LOOP_MAXIMUM = eINSTANCE.getStandardLoopAttSet_LoopMaximum();

		/**
		 * The meta object literal for the '<em><b>Test Before</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STANDARD_LOOP_ATT_SET__TEST_BEFORE = eINSTANCE.getStandardLoopAttSet_TestBefore();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.MultiLoopAttSetImpl <em>Multi Loop Att Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.MultiLoopAttSetImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getMultiLoopAttSet()
		 * @generated
		 */
		EClass MULTI_LOOP_ATT_SET = eINSTANCE.getMultiLoopAttSet();

		/**
		 * The meta object literal for the '<em><b>MI Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_LOOP_ATT_SET__MI_CONDITION = eINSTANCE.getMultiLoopAttSet_MI_Condition();

		/**
		 * The meta object literal for the '<em><b>MI Flow Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_LOOP_ATT_SET__MI_FLOW_CONDITION = eINSTANCE.getMultiLoopAttSet_MI_FlowCondition();

		/**
		 * The meta object literal for the '<em><b>Complex MI Flow Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION = eINSTANCE.getMultiLoopAttSet_ComplexMI_FlowCondition();

		/**
		 * The meta object literal for the '<em><b>Sequential</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTI_LOOP_ATT_SET__SEQUENTIAL = eINSTANCE.getMultiLoopAttSet_Sequential();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.TransactionImpl <em>Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.TransactionImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getTransaction()
		 * @generated
		 */
		EClass TRANSACTION = eINSTANCE.getTransaction();

		/**
		 * The meta object literal for the '<em><b>Transaction Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__TRANSACTION_ID = eINSTANCE.getTransaction_TransactionId();

		/**
		 * The meta object literal for the '<em><b>Transaction Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__TRANSACTION_PROTOCOL = eINSTANCE.getTransaction_TransactionProtocol();

		/**
		 * The meta object literal for the '<em><b>Transaction Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRANSACTION__TRANSACTION_METHOD = eINSTANCE.getTransaction_TransactionMethod();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.GatewayImpl <em>Gateway</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.GatewayImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getGateway()
		 * @generated
		 */
		EClass GATEWAY = eINSTANCE.getGateway();

		/**
		 * The meta object literal for the '<em><b>Gateway Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GATEWAY__GATEWAY_TYPE = eINSTANCE.getGateway_GatewayType();

		/**
		 * The meta object literal for the '<em><b>Incoming Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATEWAY__INCOMING_CONDITION = eINSTANCE.getGateway_IncomingCondition();

		/**
		 * The meta object literal for the '<em><b>Outgoing Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GATEWAY__OUTGOING_CONDITION = eINSTANCE.getGateway_OutgoingCondition();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.PoolImpl <em>Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.PoolImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getPool()
		 * @generated
		 */
		EClass POOL = eINSTANCE.getPool();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POOL__PARENT = eINSTANCE.getPool_Parent();

		/**
		 * The meta object literal for the '<em><b>Participant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POOL__PARTICIPANT = eINSTANCE.getPool_Participant();

		/**
		 * The meta object literal for the '<em><b>Lanes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POOL__LANES = eINSTANCE.getPool_Lanes();

		/**
		 * The meta object literal for the '<em><b>Boundary Visible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POOL__BOUNDARY_VISIBLE = eINSTANCE.getPool_BoundaryVisible();

		/**
		 * The meta object literal for the '<em><b>Process Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POOL__PROCESS_TYPE = eINSTANCE.getPool_ProcessType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.LaneImpl <em>Lane</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.LaneImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getLane()
		 * @generated
		 */
		EClass LANE = eINSTANCE.getLane();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LANE__PARENT = eINSTANCE.getLane_Parent();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.ArtifactImpl <em>Artifact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.ArtifactImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getArtifact()
		 * @generated
		 */
		EClass ARTIFACT = eINSTANCE.getArtifact();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT__PARENT = eINSTANCE.getArtifact_Parent();

		/**
		 * The meta object literal for the '<em><b>Pool</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTIFACT__POOL = eINSTANCE.getArtifact_Pool();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.DataObjectImpl <em>Data Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.DataObjectImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getDataObject()
		 * @generated
		 */
		EClass DATA_OBJECT = eINSTANCE.getDataObject();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_OBJECT__PROPERTIES = eINSTANCE.getDataObject_Properties();

		/**
		 * The meta object literal for the '<em><b>Required For Start</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_OBJECT__REQUIRED_FOR_START = eINSTANCE.getDataObject_RequiredForStart();

		/**
		 * The meta object literal for the '<em><b>Produced At Completion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_OBJECT__PRODUCED_AT_COMPLETION = eINSTANCE.getDataObject_ProducedAtCompletion();

		/**
		 * The meta object literal for the '<em><b>State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_OBJECT__STATE = eINSTANCE.getDataObject_State();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.TextAnnotationImpl <em>Text Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.TextAnnotationImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getTextAnnotation()
		 * @generated
		 */
		EClass TEXT_ANNOTATION = eINSTANCE.getTextAnnotation();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.GroupImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.ConnectingObjectImpl <em>Connecting Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.ConnectingObjectImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getConnectingObject()
		 * @generated
		 */
		EClass CONNECTING_OBJECT = eINSTANCE.getConnectingObject();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTING_OBJECT__PARENT = eINSTANCE.getConnectingObject_Parent();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.SequenceFlowImpl <em>Sequence Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.SequenceFlowImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getSequenceFlow()
		 * @generated
		 */
		EClass SEQUENCE_FLOW = eINSTANCE.getSequenceFlow();

		/**
		 * The meta object literal for the '<em><b>Condition Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCE_FLOW__CONDITION_TYPE = eINSTANCE.getSequenceFlow_ConditionType();

		/**
		 * The meta object literal for the '<em><b>Condition Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_FLOW__CONDITION_EXPRESSION = eINSTANCE.getSequenceFlow_ConditionExpression();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_FLOW__SOURCE = eINSTANCE.getSequenceFlow_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE_FLOW__TARGET = eINSTANCE.getSequenceFlow_Target();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.MessageFlowImpl <em>Message Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.MessageFlowImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getMessageFlow()
		 * @generated
		 */
		EClass MESSAGE_FLOW = eINSTANCE.getMessageFlow();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_FLOW__SOURCE = eINSTANCE.getMessageFlow_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_FLOW__TARGET = eINSTANCE.getMessageFlow_Target();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.AssociationImpl <em>Association</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.AssociationImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getAssociation()
		 * @generated
		 */
		EClass ASSOCIATION = eINSTANCE.getAssociation();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION__DIRECTION = eINSTANCE.getAssociation_Direction();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__SOURCE = eINSTANCE.getAssociation_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION__TARGET = eINSTANCE.getAssociation_Target();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.ParticipantImpl <em>Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.ParticipantImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getParticipant()
		 * @generated
		 */
		EClass PARTICIPANT = eINSTANCE.getParticipant();

		/**
		 * The meta object literal for the '<em><b>Associated Processes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__ASSOCIATED_PROCESSES = eINSTANCE.getParticipant_AssociatedProcesses();

		/**
		 * The meta object literal for the '<em><b>Associated Pools</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__ASSOCIATED_POOLS = eINSTANCE.getParticipant_AssociatedPools();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTICIPANT__TYPE = eINSTANCE.getParticipant_Type();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.ImplementationImpl <em>Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.ImplementationImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getImplementation()
		 * @generated
		 */
		EClass IMPLEMENTATION = eINSTANCE.getImplementation();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.MessageChannelImpl <em>Message Channel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.MessageChannelImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getMessageChannel()
		 * @generated
		 */
		EClass MESSAGE_CHANNEL = eINSTANCE.getMessageChannel();

		/**
		 * The meta object literal for the '<em><b>Channel</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_CHANNEL__CHANNEL = eINSTANCE.getMessageChannel_Channel();

		/**
		 * The meta object literal for the '<em><b>Payload</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_CHANNEL__PAYLOAD = eINSTANCE.getMessageChannel_Payload();

		/**
		 * The meta object literal for the '<em><b>Sender</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_CHANNEL__SENDER = eINSTANCE.getMessageChannel_Sender();

		/**
		 * The meta object literal for the '<em><b>Receiver</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_CHANNEL__RECEIVER = eINSTANCE.getMessageChannel_Receiver();

		/**
		 * The meta object literal for the '<em><b>Message Group</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_CHANNEL__MESSAGE_GROUP = eINSTANCE.getMessageChannel_MessageGroup();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.ServiceImpl <em>Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.ServiceImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getService()
		 * @generated
		 */
		EClass SERVICE = eINSTANCE.getService();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__TYPE = eINSTANCE.getService_Type();

		/**
		 * The meta object literal for the '<em><b>Participant</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__PARTICIPANT = eINSTANCE.getService_Participant();

		/**
		 * The meta object literal for the '<em><b>Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__INTERFACE = eINSTANCE.getService_Interface();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__OPERATION = eINSTANCE.getService_Operation();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__DESCRIPTION = eINSTANCE.getService_Description();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__LOCATION = eINSTANCE.getService_Location();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__INPUT = eINSTANCE.getService_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__OUTPUT = eINSTANCE.getService_Output();

		/**
		 * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__PRECONDITIONS = eINSTANCE.getService_Preconditions();

		/**
		 * The meta object literal for the '<em><b>Effects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE__EFFECTS = eINSTANCE.getService_Effects();

		/**
		 * The meta object literal for the '<em><b>Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE__TEMPLATE = eINSTANCE.getService_Template();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.AssignmentImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__TO = eINSTANCE.getAssignment_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__FROM = eINSTANCE.getAssignment_From();

		/**
		 * The meta object literal for the '<em><b>Assign Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT__ASSIGN_TIME = eINSTANCE.getAssignment_AssignTime();

		/**
		 * The meta object literal for the '<em><b>To Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT__TO_QUERY = eINSTANCE.getAssignment_ToQuery();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.PropertyImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__NAME = eINSTANCE.getProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__TYPE = eINSTANCE.getProperty_Type();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.ParameterImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__KEY = eINSTANCE.getParameter_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__VALUE = eINSTANCE.getParameter_Value();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER__DESCRIPTION = eINSTANCE.getParameter_Description();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.ExpressionImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__EXPRESSION = eINSTANCE.getExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXPRESSION__LANGUAGE = eINSTANCE.getExpression_Language();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.DataTypeImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__NAME = eINSTANCE.getDataType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__PACKAGE = eINSTANCE.getDataType_Package();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__LANGUAGE = eINSTANCE.getDataType_Language();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__URL = eINSTANCE.getDataType_Url();

		/**
		 * The meta object literal for the '<em><b>Inherits</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__INHERITS = eINSTANCE.getDataType_Inherits();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE__MEMBERS = eINSTANCE.getDataType_Members();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.IdObjectImpl <em>Id Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.IdObjectImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getIdObject()
		 * @generated
		 */
		EClass ID_OBJECT = eINSTANCE.getIdObject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ID_OBJECT__NAME = eINSTANCE.getIdObject_Name();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ID_OBJECT__ID = eINSTANCE.getIdObject_Id();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ID_OBJECT__DOCUMENTATION = eINSTANCE.getIdObject_Documentation();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.impl.BusinessProcessSystemImpl <em>Business Process System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.impl.BusinessProcessSystemImpl
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getBusinessProcessSystem()
		 * @generated
		 */
		EClass BUSINESS_PROCESS_SYSTEM = eINSTANCE.getBusinessProcessSystem();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_PROCESS_SYSTEM__VERSION = eINSTANCE.getBusinessProcessSystem_Version();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_PROCESS_SYSTEM__AUTHOR = eINSTANCE.getBusinessProcessSystem_Author();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_PROCESS_SYSTEM__LANGUAGE = eINSTANCE.getBusinessProcessSystem_Language();

		/**
		 * The meta object literal for the '<em><b>Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_PROCESS_SYSTEM__EXPRESSION_LANGUAGE = eINSTANCE.getBusinessProcessSystem_ExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Query Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_PROCESS_SYSTEM__QUERY_LANGUAGE = eINSTANCE.getBusinessProcessSystem_QueryLanguage();

		/**
		 * The meta object literal for the '<em><b>Creation Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_PROCESS_SYSTEM__CREATION_DATE = eINSTANCE.getBusinessProcessSystem_CreationDate();

		/**
		 * The meta object literal for the '<em><b>Modification Date</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_PROCESS_SYSTEM__MODIFICATION_DATE = eINSTANCE.getBusinessProcessSystem_ModificationDate();

		/**
		 * The meta object literal for the '<em><b>Executable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUSINESS_PROCESS_SYSTEM__EXECUTABLE = eINSTANCE.getBusinessProcessSystem_Executable();

		/**
		 * The meta object literal for the '<em><b>Business Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES = eINSTANCE.getBusinessProcessSystem_BusinessProcesses();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_SYSTEM__PARTICIPANTS = eINSTANCE.getBusinessProcessSystem_Participants();

		/**
		 * The meta object literal for the '<em><b>Message Channels</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_SYSTEM__MESSAGE_CHANNELS = eINSTANCE.getBusinessProcessSystem_MessageChannels();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_SYSTEM__SERVICES = eINSTANCE.getBusinessProcessSystem_Services();

		/**
		 * The meta object literal for the '<em><b>Data Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_SYSTEM__DATA_TYPES = eINSTANCE.getBusinessProcessSystem_DataTypes();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUSINESS_PROCESS_SYSTEM__PARAMETERS = eINSTANCE.getBusinessProcessSystem_Parameters();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.ProcessType <em>Process Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.ProcessType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getProcessType()
		 * @generated
		 */
		EEnum PROCESS_TYPE = eINSTANCE.getProcessType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.TriggerType <em>Trigger Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.TriggerType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getTriggerType()
		 * @generated
		 */
		EEnum TRIGGER_TYPE = eINSTANCE.getTriggerType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.FlowConditionTypes <em>Flow Condition Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.FlowConditionTypes
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getFlowConditionTypes()
		 * @generated
		 */
		EEnum FLOW_CONDITION_TYPES = eINSTANCE.getFlowConditionTypes();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.ActivityType <em>Activity Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.ActivityType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getActivityType()
		 * @generated
		 */
		EEnum ACTIVITY_TYPE = eINSTANCE.getActivityType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.LoopType <em>Loop Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.LoopType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getLoopType()
		 * @generated
		 */
		EEnum LOOP_TYPE = eINSTANCE.getLoopType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.TransactionMethodType <em>Transaction Method Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.TransactionMethodType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getTransactionMethodType()
		 * @generated
		 */
		EEnum TRANSACTION_METHOD_TYPE = eINSTANCE.getTransactionMethodType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.GatewayType <em>Gateway Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.GatewayType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getGatewayType()
		 * @generated
		 */
		EEnum GATEWAY_TYPE = eINSTANCE.getGatewayType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.ConditionType <em>Condition Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.ConditionType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getConditionType()
		 * @generated
		 */
		EEnum CONDITION_TYPE = eINSTANCE.getConditionType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.DirectionType <em>Direction Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.DirectionType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getDirectionType()
		 * @generated
		 */
		EEnum DIRECTION_TYPE = eINSTANCE.getDirectionType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.ParticipantType <em>Participant Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.ParticipantType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getParticipantType()
		 * @generated
		 */
		EEnum PARTICIPANT_TYPE = eINSTANCE.getParticipantType();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.AssignTimeType <em>Assign Time Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.AssignTimeType
		 * @see de.dailab.vsdt.impl.VsdtPackageImpl#getAssignTimeType()
		 * @generated
		 */
		EEnum ASSIGN_TIME_TYPE = eINSTANCE.getAssignTimeType();

	}

} //VsdtPackage
