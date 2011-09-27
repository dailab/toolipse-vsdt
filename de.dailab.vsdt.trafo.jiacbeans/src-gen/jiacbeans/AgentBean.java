/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent Bean</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.AgentBean#getMethods <em>Methods</em>}</li>
 *   <li>{@link jiacbeans.AgentBean#getName <em>Name</em>}</li>
 *   <li>{@link jiacbeans.AgentBean#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link jiacbeans.AgentBean#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link jiacbeans.AgentBean#getActions <em>Actions</em>}</li>
 *   <li>{@link jiacbeans.AgentBean#getImports <em>Imports</em>}</li>
 *   <li>{@link jiacbeans.AgentBean#getSubprocesses <em>Subprocesses</em>}</li>
 *   <li>{@link jiacbeans.AgentBean#isHandlingTimeoutEvent <em>Handling Timeout Event</em>}</li>
 *   <li>{@link jiacbeans.AgentBean#isHandlingMessageEvent <em>Handling Message Event</em>}</li>
 *   <li>{@link jiacbeans.AgentBean#isHandlingTimeEvent <em>Handling Time Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getAgentBean()
 * @model
 * @generated
 */
public interface AgentBean extends EObject {

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' reference list.
	 * The list contents are of type {@link jiacbeans.Method}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' reference list.
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_Methods()
	 * @model
	 * @generated
	 */
	EList<Method> getMethods();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jiacbeans.AgentBean#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_PackageName()
	 * @model
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link jiacbeans.AgentBean#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' reference list.
	 * The list contents are of type {@link jiacbeans.JavaVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' reference list.
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_Attributes()
	 * @model
	 * @generated
	 */
	EList<JavaVariable> getAttributes();

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' reference list.
	 * The list contents are of type {@link jiacbeans.Action}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' reference list.
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_Actions()
	 * @model
	 * @generated
	 */
	EList<Action> getActions();

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' attribute list.
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_Imports()
	 * @model
	 * @generated
	 */
	EList<String> getImports();

	/**
	 * Returns the value of the '<em><b>Subprocesses</b></em>' reference list.
	 * The list contents are of type {@link jiacbeans.SubProcess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subprocesses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subprocesses</em>' reference list.
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_Subprocesses()
	 * @model
	 * @generated
	 */
	EList<SubProcess> getSubprocesses();

	/**
	 * Returns the value of the '<em><b>Handling Timeout Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handling Timeout Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handling Timeout Event</em>' attribute.
	 * @see #setHandlingTimeoutEvent(boolean)
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_HandlingTimeoutEvent()
	 * @model required="true"
	 * @generated
	 */
	boolean isHandlingTimeoutEvent();

	/**
	 * Sets the value of the '{@link jiacbeans.AgentBean#isHandlingTimeoutEvent <em>Handling Timeout Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handling Timeout Event</em>' attribute.
	 * @see #isHandlingTimeoutEvent()
	 * @generated
	 */
	void setHandlingTimeoutEvent(boolean value);

	/**
	 * Returns the value of the '<em><b>Handling Message Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handling Message Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handling Message Event</em>' attribute.
	 * @see #setHandlingMessageEvent(boolean)
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_HandlingMessageEvent()
	 * @model required="true"
	 * @generated
	 */
	boolean isHandlingMessageEvent();

	/**
	 * Sets the value of the '{@link jiacbeans.AgentBean#isHandlingMessageEvent <em>Handling Message Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handling Message Event</em>' attribute.
	 * @see #isHandlingMessageEvent()
	 * @generated
	 */
	void setHandlingMessageEvent(boolean value);

	/**
	 * Returns the value of the '<em><b>Handling Time Event</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Handling Time Event</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Handling Time Event</em>' attribute.
	 * @see #setHandlingTimeEvent(boolean)
	 * @see jiacbeans.JiacbeansPackage#getAgentBean_HandlingTimeEvent()
	 * @model required="true"
	 * @generated
	 */
	boolean isHandlingTimeEvent();

	/**
	 * Sets the value of the '{@link jiacbeans.AgentBean#isHandlingTimeEvent <em>Handling Time Event</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Handling Time Event</em>' attribute.
	 * @see #isHandlingTimeEvent()
	 * @generated
	 */
	void setHandlingTimeEvent(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addMethod(Method m);
} // AgentBean
