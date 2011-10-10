/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see jiacbeans.JiacbeansFactory
 * @model kind="package"
 * @generated
 */
public interface JiacbeansPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "jiacbeans";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://jiacbeans/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "jiacbeans";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JiacbeansPackage eINSTANCE = jiacbeans.impl.JiacbeansPackageImpl.init();

	/**
	 * The meta object id for the '{@link jiacbeans.impl.AgentBeanImpl <em>Agent Bean</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.AgentBeanImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getAgentBean()
	 * @generated
	 */
	int AGENT_BEAN = 0;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__METHODS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__NAME = 1;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__PACKAGE_NAME = 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__ATTRIBUTES = 3;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__ACTIONS = 4;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__IMPORTS = 5;

	/**
	 * The feature id for the '<em><b>Subprocesses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__SUBPROCESSES = 6;

	/**
	 * The feature id for the '<em><b>Handling Timeout Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__HANDLING_TIMEOUT_EVENT = 7;

	/**
	 * The feature id for the '<em><b>Handling Message Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__HANDLING_MESSAGE_EVENT = 8;

	/**
	 * The feature id for the '<em><b>Handling Time Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN__HANDLING_TIME_EVENT = 9;

	/**
	 * The number of structural features of the '<em>Agent Bean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.MethodImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 1;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__RETURN_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__PARAMETERS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__NAME = 2;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__IS_STATIC = 3;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__VISIBILITY = 4;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__CONTENT = 5;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ATTRIBUTES = 6;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.WorkflowMethodImpl <em>Workflow Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.WorkflowMethodImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getWorkflowMethod()
	 * @generated
	 */
	int WORKFLOW_METHOD = 2;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD__RETURN_TYPE = METHOD__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD__PARAMETERS = METHOD__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD__NAME = METHOD__NAME;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD__IS_STATIC = METHOD__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD__VISIBILITY = METHOD__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD__CONTENT = METHOD__CONTENT;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD__ATTRIBUTES = METHOD__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Workflow Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.ActivityMethodImpl <em>Activity Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.ActivityMethodImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getActivityMethod()
	 * @generated
	 */
	int ACTIVITY_METHOD = 3;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD__RETURN_TYPE = METHOD__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD__PARAMETERS = METHOD__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD__NAME = METHOD__NAME;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD__IS_STATIC = METHOD__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD__VISIBILITY = METHOD__VISIBILITY;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD__CONTENT = METHOD__CONTENT;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD__ATTRIBUTES = METHOD__ATTRIBUTES;

	/**
	 * The number of structural features of the '<em>Activity Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link jiacbeans.impl.JavaVariableImpl <em>Java Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.JavaVariableImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getJavaVariable()
	 * @generated
	 */
	int JAVA_VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VARIABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VARIABLE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Java Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_VARIABLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.ActionImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 5;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__TRIGGER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__LOCATION = 2;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.TriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.TriggerImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getTrigger()
	 * @generated
	 */
	int TRIGGER = 6;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGER_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link jiacbeans.impl.ScriptImpl <em>Script</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.ScriptImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getScript()
	 * @generated
	 */
	int SCRIPT = 7;

	/**
	 * The number of structural features of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.SequenceImpl <em>Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.SequenceImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getSequence()
	 * @generated
	 */
	int SEQUENCE = 8;

	/**
	 * The feature id for the '<em><b>Scripts</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__SCRIPTS = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.IfThenElseImpl <em>If Then Else</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.IfThenElseImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getIfThenElse()
	 * @generated
	 */
	int IF_THEN_ELSE = 9;

	/**
	 * The feature id for the '<em><b>Then Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_ELSE__THEN_BRANCH = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_ELSE__ELSE_BRANCH = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_ELSE__CONDITION = SCRIPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Then Else</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_ELSE_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.ForEachImpl <em>For Each</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.ForEachImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getForEach()
	 * @generated
	 */
	int FOR_EACH = 10;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH__CONTENT = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>For Each</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.WhileImpl <em>While</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.WhileImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getWhile()
	 * @generated
	 */
	int WHILE = 11;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__CONTENT = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__CONDITION = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link jiacbeans.impl.CodeElementImpl <em>Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.CodeElementImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getCodeElement()
	 * @generated
	 */
	int CODE_ELEMENT = 12;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT__CODE = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Code Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.TryCatchImpl <em>Try Catch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.TryCatchImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getTryCatch()
	 * @generated
	 */
	int TRY_CATCH = 13;

	/**
	 * The feature id for the '<em><b>Try</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_CATCH__TRY = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Catches</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_CATCH__CATCHES = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Finally</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_CATCH__FINALLY = SCRIPT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Try Catch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRY_CATCH_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.ParalelImpl <em>Paralel</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.ParalelImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getParalel()
	 * @generated
	 */
	int PARALEL = 14;

	/**
	 * The feature id for the '<em><b>Branches</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALEL__BRANCHES = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Branch Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALEL__BRANCH_PREFIX = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Paralel</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALEL_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.RunnableImpl <em>Runnable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.RunnableImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getRunnable()
	 * @generated
	 */
	int RUNNABLE = 15;

	/**
	 * The feature id for the '<em><b>Run Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNNABLE__RUN_CONTENT = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNNABLE__NAME = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Runnable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNNABLE_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.RecieveImpl <em>Recieve</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.RecieveImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getRecieve()
	 * @generated
	 */
	int RECIEVE = 16;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIEVE__ADDRESS = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Payload</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIEVE__PAYLOAD = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Recieve</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECIEVE_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.SubProcessImpl <em>Sub Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.SubProcessImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getSubProcess()
	 * @generated
	 */
	int SUB_PROCESS = 17;

	/**
	 * The feature id for the '<em><b>Subprocesses</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__SUBPROCESSES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__NAME = 1;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__METHODS = 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS__ATTRIBUTES = 3;

	/**
	 * The number of structural features of the '<em>Sub Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUB_PROCESS_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link jiacbeans.impl.SendImpl <em>Send</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.SendImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getSend()
	 * @generated
	 */
	int SEND = 18;

	/**
	 * The feature id for the '<em><b>Payload</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__PAYLOAD = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND__ADDRESS = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Send</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEND_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link jiacbeans.AgentBean <em>Agent Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent Bean</em>'.
	 * @see jiacbeans.AgentBean
	 * @generated
	 */
	EClass getAgentBean();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.AgentBean#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Methods</em>'.
	 * @see jiacbeans.AgentBean#getMethods()
	 * @see #getAgentBean()
	 * @generated
	 */
	EReference getAgentBean_Methods();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.AgentBean#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jiacbeans.AgentBean#getName()
	 * @see #getAgentBean()
	 * @generated
	 */
	EAttribute getAgentBean_Name();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.AgentBean#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see jiacbeans.AgentBean#getPackageName()
	 * @see #getAgentBean()
	 * @generated
	 */
	EAttribute getAgentBean_PackageName();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.AgentBean#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see jiacbeans.AgentBean#getAttributes()
	 * @see #getAgentBean()
	 * @generated
	 */
	EReference getAgentBean_Attributes();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.AgentBean#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Actions</em>'.
	 * @see jiacbeans.AgentBean#getActions()
	 * @see #getAgentBean()
	 * @generated
	 */
	EReference getAgentBean_Actions();

	/**
	 * Returns the meta object for the attribute list '{@link jiacbeans.AgentBean#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Imports</em>'.
	 * @see jiacbeans.AgentBean#getImports()
	 * @see #getAgentBean()
	 * @generated
	 */
	EAttribute getAgentBean_Imports();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.AgentBean#getSubprocesses <em>Subprocesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subprocesses</em>'.
	 * @see jiacbeans.AgentBean#getSubprocesses()
	 * @see #getAgentBean()
	 * @generated
	 */
	EReference getAgentBean_Subprocesses();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.AgentBean#isHandlingTimeoutEvent <em>Handling Timeout Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Handling Timeout Event</em>'.
	 * @see jiacbeans.AgentBean#isHandlingTimeoutEvent()
	 * @see #getAgentBean()
	 * @generated
	 */
	EAttribute getAgentBean_HandlingTimeoutEvent();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.AgentBean#isHandlingMessageEvent <em>Handling Message Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Handling Message Event</em>'.
	 * @see jiacbeans.AgentBean#isHandlingMessageEvent()
	 * @see #getAgentBean()
	 * @generated
	 */
	EAttribute getAgentBean_HandlingMessageEvent();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.AgentBean#isHandlingTimeEvent <em>Handling Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Handling Time Event</em>'.
	 * @see jiacbeans.AgentBean#isHandlingTimeEvent()
	 * @see #getAgentBean()
	 * @generated
	 */
	EAttribute getAgentBean_HandlingTimeEvent();

	/**
	 * Returns the meta object for class '{@link jiacbeans.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see jiacbeans.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.Method#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Content</em>'.
	 * @see jiacbeans.Method#getContent()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Content();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.Method#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see jiacbeans.Method#getAttributes()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Attributes();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Method#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Type</em>'.
	 * @see jiacbeans.Method#getReturnType()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_ReturnType();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.Method#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Parameters</em>'.
	 * @see jiacbeans.Method#getParameters()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Parameters();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Method#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jiacbeans.Method#getName()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Name();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Method#isIsStatic <em>Is Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static</em>'.
	 * @see jiacbeans.Method#isIsStatic()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_IsStatic();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Method#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see jiacbeans.Method#getVisibility()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Visibility();

	/**
	 * Returns the meta object for class '{@link jiacbeans.WorkflowMethod <em>Workflow Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Workflow Method</em>'.
	 * @see jiacbeans.WorkflowMethod
	 * @generated
	 */
	EClass getWorkflowMethod();

	/**
	 * Returns the meta object for class '{@link jiacbeans.ActivityMethod <em>Activity Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity Method</em>'.
	 * @see jiacbeans.ActivityMethod
	 * @generated
	 */
	EClass getActivityMethod();

	/**
	 * Returns the meta object for class '{@link jiacbeans.JavaVariable <em>Java Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Variable</em>'.
	 * @see jiacbeans.JavaVariable
	 * @generated
	 */
	EClass getJavaVariable();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.JavaVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jiacbeans.JavaVariable#getName()
	 * @see #getJavaVariable()
	 * @generated
	 */
	EAttribute getJavaVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.JavaVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see jiacbeans.JavaVariable#getType()
	 * @see #getJavaVariable()
	 * @generated
	 */
	EAttribute getJavaVariable_Type();

	/**
	 * Returns the meta object for class '{@link jiacbeans.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see jiacbeans.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.Action#getTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Trigger</em>'.
	 * @see jiacbeans.Action#getTrigger()
	 * @see #getAction()
	 * @generated
	 */
	EReference getAction_Trigger();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Action#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jiacbeans.Action#getName()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Name();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Action#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see jiacbeans.Action#getLocation()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Location();

	/**
	 * Returns the meta object for class '{@link jiacbeans.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see jiacbeans.Trigger
	 * @generated
	 */
	EClass getTrigger();

	/**
	 * Returns the meta object for class '{@link jiacbeans.Script <em>Script</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Script</em>'.
	 * @see jiacbeans.Script
	 * @generated
	 */
	EClass getScript();

	/**
	 * Returns the meta object for class '{@link jiacbeans.Sequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequence</em>'.
	 * @see jiacbeans.Sequence
	 * @generated
	 */
	EClass getSequence();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.Sequence#getScripts <em>Scripts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Scripts</em>'.
	 * @see jiacbeans.Sequence#getScripts()
	 * @see #getSequence()
	 * @generated
	 */
	EReference getSequence_Scripts();

	/**
	 * Returns the meta object for class '{@link jiacbeans.IfThenElse <em>If Then Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Then Else</em>'.
	 * @see jiacbeans.IfThenElse
	 * @generated
	 */
	EClass getIfThenElse();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.IfThenElse#getThenBranch <em>Then Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Then Branch</em>'.
	 * @see jiacbeans.IfThenElse#getThenBranch()
	 * @see #getIfThenElse()
	 * @generated
	 */
	EReference getIfThenElse_ThenBranch();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.IfThenElse#getElseBranch <em>Else Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Else Branch</em>'.
	 * @see jiacbeans.IfThenElse#getElseBranch()
	 * @see #getIfThenElse()
	 * @generated
	 */
	EReference getIfThenElse_ElseBranch();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.IfThenElse#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see jiacbeans.IfThenElse#getCondition()
	 * @see #getIfThenElse()
	 * @generated
	 */
	EAttribute getIfThenElse_Condition();

	/**
	 * Returns the meta object for class '{@link jiacbeans.ForEach <em>For Each</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Each</em>'.
	 * @see jiacbeans.ForEach
	 * @generated
	 */
	EClass getForEach();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.ForEach#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Content</em>'.
	 * @see jiacbeans.ForEach#getContent()
	 * @see #getForEach()
	 * @generated
	 */
	EReference getForEach_Content();

	/**
	 * Returns the meta object for class '{@link jiacbeans.While <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While</em>'.
	 * @see jiacbeans.While
	 * @generated
	 */
	EClass getWhile();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.While#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Content</em>'.
	 * @see jiacbeans.While#getContent()
	 * @see #getWhile()
	 * @generated
	 */
	EReference getWhile_Content();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.While#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see jiacbeans.While#getCondition()
	 * @see #getWhile()
	 * @generated
	 */
	EAttribute getWhile_Condition();

	/**
	 * Returns the meta object for class '{@link jiacbeans.CodeElement <em>Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Element</em>'.
	 * @see jiacbeans.CodeElement
	 * @generated
	 */
	EClass getCodeElement();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.CodeElement#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see jiacbeans.CodeElement#getCode()
	 * @see #getCodeElement()
	 * @generated
	 */
	EAttribute getCodeElement_Code();

	/**
	 * Returns the meta object for class '{@link jiacbeans.TryCatch <em>Try Catch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Try Catch</em>'.
	 * @see jiacbeans.TryCatch
	 * @generated
	 */
	EClass getTryCatch();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.TryCatch#getTry <em>Try</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Try</em>'.
	 * @see jiacbeans.TryCatch#getTry()
	 * @see #getTryCatch()
	 * @generated
	 */
	EReference getTryCatch_Try();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.TryCatch#getCatches <em>Catches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Catches</em>'.
	 * @see jiacbeans.TryCatch#getCatches()
	 * @see #getTryCatch()
	 * @generated
	 */
	EAttribute getTryCatch_Catches();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.TryCatch#getFinally <em>Finally</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Finally</em>'.
	 * @see jiacbeans.TryCatch#getFinally()
	 * @see #getTryCatch()
	 * @generated
	 */
	EReference getTryCatch_Finally();

	/**
	 * Returns the meta object for class '{@link jiacbeans.Paralel <em>Paralel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paralel</em>'.
	 * @see jiacbeans.Paralel
	 * @generated
	 */
	EClass getParalel();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.Paralel#getBranches <em>Branches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Branches</em>'.
	 * @see jiacbeans.Paralel#getBranches()
	 * @see #getParalel()
	 * @generated
	 */
	EReference getParalel_Branches();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Paralel#getBranchPrefix <em>Branch Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Branch Prefix</em>'.
	 * @see jiacbeans.Paralel#getBranchPrefix()
	 * @see #getParalel()
	 * @generated
	 */
	EAttribute getParalel_BranchPrefix();

	/**
	 * Returns the meta object for class '{@link jiacbeans.Runnable <em>Runnable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runnable</em>'.
	 * @see jiacbeans.Runnable
	 * @generated
	 */
	EClass getRunnable();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.Runnable#getRunContent <em>Run Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Run Content</em>'.
	 * @see jiacbeans.Runnable#getRunContent()
	 * @see #getRunnable()
	 * @generated
	 */
	EReference getRunnable_RunContent();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Runnable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jiacbeans.Runnable#getName()
	 * @see #getRunnable()
	 * @generated
	 */
	EAttribute getRunnable_Name();

	/**
	 * Returns the meta object for class '{@link jiacbeans.Recieve <em>Recieve</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recieve</em>'.
	 * @see jiacbeans.Recieve
	 * @generated
	 */
	EClass getRecieve();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Recieve#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see jiacbeans.Recieve#getAddress()
	 * @see #getRecieve()
	 * @generated
	 */
	EAttribute getRecieve_Address();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.Recieve#getPayload <em>Payload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Payload</em>'.
	 * @see jiacbeans.Recieve#getPayload()
	 * @see #getRecieve()
	 * @generated
	 */
	EReference getRecieve_Payload();

	/**
	 * Returns the meta object for class '{@link jiacbeans.SubProcess <em>Sub Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sub Process</em>'.
	 * @see jiacbeans.SubProcess
	 * @generated
	 */
	EClass getSubProcess();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.SubProcess#getSubprocesses <em>Subprocesses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subprocesses</em>'.
	 * @see jiacbeans.SubProcess#getSubprocesses()
	 * @see #getSubProcess()
	 * @generated
	 */
	EReference getSubProcess_Subprocesses();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.SubProcess#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jiacbeans.SubProcess#getName()
	 * @see #getSubProcess()
	 * @generated
	 */
	EAttribute getSubProcess_Name();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.SubProcess#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Methods</em>'.
	 * @see jiacbeans.SubProcess#getMethods()
	 * @see #getSubProcess()
	 * @generated
	 */
	EReference getSubProcess_Methods();

	/**
	 * Returns the meta object for the reference list '{@link jiacbeans.SubProcess#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see jiacbeans.SubProcess#getAttributes()
	 * @see #getSubProcess()
	 * @generated
	 */
	EReference getSubProcess_Attributes();

	/**
	 * Returns the meta object for class '{@link jiacbeans.Send <em>Send</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Send</em>'.
	 * @see jiacbeans.Send
	 * @generated
	 */
	EClass getSend();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.Send#getPayload <em>Payload</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Payload</em>'.
	 * @see jiacbeans.Send#getPayload()
	 * @see #getSend()
	 * @generated
	 */
	EReference getSend_Payload();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Send#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see jiacbeans.Send#getAddress()
	 * @see #getSend()
	 * @generated
	 */
	EAttribute getSend_Address();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JiacbeansFactory getJiacbeansFactory();

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
		 * The meta object literal for the '{@link jiacbeans.impl.AgentBeanImpl <em>Agent Bean</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.AgentBeanImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getAgentBean()
		 * @generated
		 */
		EClass AGENT_BEAN = eINSTANCE.getAgentBean();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_BEAN__METHODS = eINSTANCE.getAgentBean_Methods();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_BEAN__NAME = eINSTANCE.getAgentBean_Name();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_BEAN__PACKAGE_NAME = eINSTANCE.getAgentBean_PackageName();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_BEAN__ATTRIBUTES = eINSTANCE.getAgentBean_Attributes();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_BEAN__ACTIONS = eINSTANCE.getAgentBean_Actions();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_BEAN__IMPORTS = eINSTANCE.getAgentBean_Imports();

		/**
		 * The meta object literal for the '<em><b>Subprocesses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_BEAN__SUBPROCESSES = eINSTANCE.getAgentBean_Subprocesses();

		/**
		 * The meta object literal for the '<em><b>Handling Timeout Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_BEAN__HANDLING_TIMEOUT_EVENT = eINSTANCE.getAgentBean_HandlingTimeoutEvent();

		/**
		 * The meta object literal for the '<em><b>Handling Message Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_BEAN__HANDLING_MESSAGE_EVENT = eINSTANCE.getAgentBean_HandlingMessageEvent();

		/**
		 * The meta object literal for the '<em><b>Handling Time Event</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_BEAN__HANDLING_TIME_EVENT = eINSTANCE.getAgentBean_HandlingTimeEvent();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.MethodImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__CONTENT = eINSTANCE.getMethod_Content();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__ATTRIBUTES = eINSTANCE.getMethod_Attributes();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__RETURN_TYPE = eINSTANCE.getMethod_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__PARAMETERS = eINSTANCE.getMethod_Parameters();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__NAME = eINSTANCE.getMethod_Name();

		/**
		 * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__IS_STATIC = eINSTANCE.getMethod_IsStatic();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__VISIBILITY = eINSTANCE.getMethod_Visibility();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.WorkflowMethodImpl <em>Workflow Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.WorkflowMethodImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getWorkflowMethod()
		 * @generated
		 */
		EClass WORKFLOW_METHOD = eINSTANCE.getWorkflowMethod();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.ActivityMethodImpl <em>Activity Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.ActivityMethodImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getActivityMethod()
		 * @generated
		 */
		EClass ACTIVITY_METHOD = eINSTANCE.getActivityMethod();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.JavaVariableImpl <em>Java Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.JavaVariableImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getJavaVariable()
		 * @generated
		 */
		EClass JAVA_VARIABLE = eINSTANCE.getJavaVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_VARIABLE__NAME = eINSTANCE.getJavaVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_VARIABLE__TYPE = eINSTANCE.getJavaVariable_Type();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.ActionImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Trigger</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTION__TRIGGER = eINSTANCE.getAction_Trigger();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__NAME = eINSTANCE.getAction_Name();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__LOCATION = eINSTANCE.getAction_Location();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.TriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.TriggerImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getTrigger()
		 * @generated
		 */
		EClass TRIGGER = eINSTANCE.getTrigger();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.ScriptImpl <em>Script</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.ScriptImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getScript()
		 * @generated
		 */
		EClass SCRIPT = eINSTANCE.getScript();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.SequenceImpl <em>Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.SequenceImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getSequence()
		 * @generated
		 */
		EClass SEQUENCE = eINSTANCE.getSequence();

		/**
		 * The meta object literal for the '<em><b>Scripts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCE__SCRIPTS = eINSTANCE.getSequence_Scripts();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.IfThenElseImpl <em>If Then Else</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.IfThenElseImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getIfThenElse()
		 * @generated
		 */
		EClass IF_THEN_ELSE = eINSTANCE.getIfThenElse();

		/**
		 * The meta object literal for the '<em><b>Then Branch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_THEN_ELSE__THEN_BRANCH = eINSTANCE.getIfThenElse_ThenBranch();

		/**
		 * The meta object literal for the '<em><b>Else Branch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_THEN_ELSE__ELSE_BRANCH = eINSTANCE.getIfThenElse_ElseBranch();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_THEN_ELSE__CONDITION = eINSTANCE.getIfThenElse_Condition();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.ForEachImpl <em>For Each</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.ForEachImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getForEach()
		 * @generated
		 */
		EClass FOR_EACH = eINSTANCE.getForEach();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH__CONTENT = eINSTANCE.getForEach_Content();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.WhileImpl <em>While</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.WhileImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getWhile()
		 * @generated
		 */
		EClass WHILE = eINSTANCE.getWhile();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE__CONTENT = eINSTANCE.getWhile_Content();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHILE__CONDITION = eINSTANCE.getWhile_Condition();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.CodeElementImpl <em>Code Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.CodeElementImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getCodeElement()
		 * @generated
		 */
		EClass CODE_ELEMENT = eINSTANCE.getCodeElement();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_ELEMENT__CODE = eINSTANCE.getCodeElement_Code();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.TryCatchImpl <em>Try Catch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.TryCatchImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getTryCatch()
		 * @generated
		 */
		EClass TRY_CATCH = eINSTANCE.getTryCatch();

		/**
		 * The meta object literal for the '<em><b>Try</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_CATCH__TRY = eINSTANCE.getTryCatch_Try();

		/**
		 * The meta object literal for the '<em><b>Catches</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRY_CATCH__CATCHES = eINSTANCE.getTryCatch_Catches();

		/**
		 * The meta object literal for the '<em><b>Finally</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRY_CATCH__FINALLY = eINSTANCE.getTryCatch_Finally();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.ParalelImpl <em>Paralel</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.ParalelImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getParalel()
		 * @generated
		 */
		EClass PARALEL = eINSTANCE.getParalel();

		/**
		 * The meta object literal for the '<em><b>Branches</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALEL__BRANCHES = eINSTANCE.getParalel_Branches();

		/**
		 * The meta object literal for the '<em><b>Branch Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARALEL__BRANCH_PREFIX = eINSTANCE.getParalel_BranchPrefix();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.RunnableImpl <em>Runnable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.RunnableImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getRunnable()
		 * @generated
		 */
		EClass RUNNABLE = eINSTANCE.getRunnable();

		/**
		 * The meta object literal for the '<em><b>Run Content</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNNABLE__RUN_CONTENT = eINSTANCE.getRunnable_RunContent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNNABLE__NAME = eINSTANCE.getRunnable_Name();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.RecieveImpl <em>Recieve</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.RecieveImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getRecieve()
		 * @generated
		 */
		EClass RECIEVE = eINSTANCE.getRecieve();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECIEVE__ADDRESS = eINSTANCE.getRecieve_Address();

		/**
		 * The meta object literal for the '<em><b>Payload</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECIEVE__PAYLOAD = eINSTANCE.getRecieve_Payload();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.SubProcessImpl <em>Sub Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.SubProcessImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getSubProcess()
		 * @generated
		 */
		EClass SUB_PROCESS = eINSTANCE.getSubProcess();

		/**
		 * The meta object literal for the '<em><b>Subprocesses</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_PROCESS__SUBPROCESSES = eINSTANCE.getSubProcess_Subprocesses();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SUB_PROCESS__NAME = eINSTANCE.getSubProcess_Name();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_PROCESS__METHODS = eINSTANCE.getSubProcess_Methods();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUB_PROCESS__ATTRIBUTES = eINSTANCE.getSubProcess_Attributes();

		/**
		 * The meta object literal for the '{@link jiacbeans.impl.SendImpl <em>Send</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.SendImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getSend()
		 * @generated
		 */
		EClass SEND = eINSTANCE.getSend();

		/**
		 * The meta object literal for the '<em><b>Payload</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEND__PAYLOAD = eINSTANCE.getSend_Payload();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEND__ADDRESS = eINSTANCE.getSend_Address();

	}

} //JiacbeansPackage
