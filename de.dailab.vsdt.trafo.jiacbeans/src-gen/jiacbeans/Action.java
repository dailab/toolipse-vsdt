/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.Action#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link jiacbeans.Action#getActionId <em>Action Id</em>}</li>
 *   <li>{@link jiacbeans.Action#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getAction()
 * @model
 * @generated
 */
public interface Action extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' attribute.
	 * @see #setVariableName(String)
	 * @see jiacbeans.JiacbeansPackage#getAction_VariableName()
	 * @model
	 * @generated
	 */
	String getVariableName();

	/**
	 * Sets the value of the '{@link jiacbeans.Action#getVariableName <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' attribute.
	 * @see #getVariableName()
	 * @generated
	 */
	void setVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Action Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Id</em>' attribute.
	 * @see #setActionId(String)
	 * @see jiacbeans.JiacbeansPackage#getAction_ActionId()
	 * @model
	 * @generated
	 */
	String getActionId();

	/**
	 * Sets the value of the '{@link jiacbeans.Action#getActionId <em>Action Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Id</em>' attribute.
	 * @see #getActionId()
	 * @generated
	 */
	void setActionId(String value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see #setScope(String)
	 * @see jiacbeans.JiacbeansPackage#getAction_Scope()
	 * @model
	 * @generated
	 */
	String getScope();

	/**
	 * Sets the value of the '{@link jiacbeans.Action#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(String value);

} // Action
