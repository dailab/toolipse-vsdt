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
	 * The number of structural features of the '<em>Agent Bean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN_FEATURE_COUNT = 5;

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
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = 6;

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
	 * The number of structural features of the '<em>Activity Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link jiacbeans.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see jiacbeans.impl.VariableImpl
	 * @see jiacbeans.impl.JiacbeansPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = 2;

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
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 1;

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
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT__CODE = 0;

	/**
	 * The number of structural features of the '<em>Script</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCRIPT_FEATURE_COUNT = 1;

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
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCE__CODE = SCRIPT__CODE;

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
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_ELSE__CODE = SCRIPT__CODE;

	/**
	 * The feature id for the '<em><b>Then</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_ELSE__THEN = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_ELSE__ELSE = SCRIPT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>If Then Else</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_THEN_ELSE_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH__CODE = SCRIPT__CODE;

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
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__CODE = SCRIPT__CODE;

	/**
	 * The feature id for the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__CONTENT = SCRIPT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_FEATURE_COUNT = SCRIPT_FEATURE_COUNT + 1;


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
	 * Returns the meta object for class '{@link jiacbeans.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see jiacbeans.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Variable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see jiacbeans.Variable#getName()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Variable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see jiacbeans.Variable#getType()
	 * @see #getVariable()
	 * @generated
	 */
	EAttribute getVariable_Type();

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
	 * Returns the meta object for the attribute '{@link jiacbeans.Script#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see jiacbeans.Script#getCode()
	 * @see #getScript()
	 * @generated
	 */
	EAttribute getScript_Code();

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
	 * Returns the meta object for the reference '{@link jiacbeans.IfThenElse#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Then</em>'.
	 * @see jiacbeans.IfThenElse#getThen()
	 * @see #getIfThenElse()
	 * @generated
	 */
	EReference getIfThenElse_Then();

	/**
	 * Returns the meta object for the reference '{@link jiacbeans.IfThenElse#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Else</em>'.
	 * @see jiacbeans.IfThenElse#getElse()
	 * @see #getIfThenElse()
	 * @generated
	 */
	EReference getIfThenElse_Else();

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
		 * The meta object literal for the '{@link jiacbeans.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.VariableImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE__TYPE = eINSTANCE.getVariable_Type();

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
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCRIPT__CODE = eINSTANCE.getScript_Code();

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
		 * The meta object literal for the '<em><b>Then</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_THEN_ELSE__THEN = eINSTANCE.getIfThenElse_Then();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_THEN_ELSE__ELSE = eINSTANCE.getIfThenElse_Else();

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

	}

} //JiacbeansPackage
