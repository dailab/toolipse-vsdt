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
	 * The number of structural features of the '<em>Agent Bean</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_BEAN_FEATURE_COUNT = 3;

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
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__CONTENT = 0;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__RETURN_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD__CONTENT = METHOD__CONTENT;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WORKFLOW_METHOD__RETURN_TYPE = METHOD__RETURN_TYPE;

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
	 * The feature id for the '<em><b>Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD__CONTENT = METHOD__CONTENT;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD__RETURN_TYPE = METHOD__RETURN_TYPE;

	/**
	 * The number of structural features of the '<em>Activity Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_METHOD_FEATURE_COUNT = METHOD_FEATURE_COUNT + 0;


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
	 * Returns the meta object for class '{@link jiacbeans.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see jiacbeans.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the attribute '{@link jiacbeans.Method#getContent <em>Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Content</em>'.
	 * @see jiacbeans.Method#getContent()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Content();

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
		 * The meta object literal for the '{@link jiacbeans.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see jiacbeans.impl.MethodImpl
		 * @see jiacbeans.impl.JiacbeansPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__CONTENT = eINSTANCE.getMethod_Content();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__RETURN_TYPE = eINSTANCE.getMethod_ReturnType();

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

	}

} //JiacbeansPackage
