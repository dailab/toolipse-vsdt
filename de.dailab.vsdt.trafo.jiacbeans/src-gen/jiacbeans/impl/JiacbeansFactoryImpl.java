/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans.impl;

import jiacbeans.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JiacbeansFactoryImpl extends EFactoryImpl implements JiacbeansFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JiacbeansFactory init() {
		try {
			JiacbeansFactory theJiacbeansFactory = (JiacbeansFactory)EPackage.Registry.INSTANCE.getEFactory("http://jiacbeans/1.0"); 
			if (theJiacbeansFactory != null) {
				return theJiacbeansFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JiacbeansFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JiacbeansFactoryImpl() {
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
			case JiacbeansPackage.AGENT_BEAN: return createAgentBean();
			case JiacbeansPackage.METHOD: return createMethod();
			case JiacbeansPackage.WORKFLOW_METHOD: return createWorkflowMethod();
			case JiacbeansPackage.ACTIVITY_METHOD: return createActivityMethod();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentBean createAgentBean() {
		AgentBeanImpl agentBean = new AgentBeanImpl();
		return agentBean;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowMethod createWorkflowMethod() {
		WorkflowMethodImpl workflowMethod = new WorkflowMethodImpl();
		return workflowMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityMethod createActivityMethod() {
		ActivityMethodImpl activityMethod = new ActivityMethodImpl();
		return activityMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JiacbeansPackage getJiacbeansPackage() {
		return (JiacbeansPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JiacbeansPackage getPackage() {
		return JiacbeansPackage.eINSTANCE;
	}

} //JiacbeansFactoryImpl
