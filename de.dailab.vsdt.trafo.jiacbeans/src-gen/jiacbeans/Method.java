/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.Method#getContent <em>Content</em>}</li>
 *   <li>{@link jiacbeans.Method#getParameters <em>Parameters</em>}</li>
 *   <li>{@link jiacbeans.Method#getVariables <em>Variables</em>}</li>
 *   <li>{@link jiacbeans.Method#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link jiacbeans.Method#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link jiacbeans.Method#getThrows <em>Throws</em>}</li>
 *   <li>{@link jiacbeans.Method#getExposedAs <em>Exposed As</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Content</em>' reference.
	 * @see #setContent(Script)
	 * @see jiacbeans.JiacbeansPackage#getMethod_Content()
	 * @model
	 * @generated
	 */
	Script getContent();

	/**
	 * Sets the value of the '{@link jiacbeans.Method#getContent <em>Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Content</em>' reference.
	 * @see #getContent()
	 * @generated
	 */
	void setContent(Script value);

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' attribute.
	 * @see #setReturnType(String)
	 * @see jiacbeans.JiacbeansPackage#getMethod_ReturnType()
	 * @model
	 * @generated
	 */
	String getReturnType();

	/**
	 * Sets the value of the '{@link jiacbeans.Method#getReturnType <em>Return Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' attribute.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(String value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"public"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see #setVisibility(String)
	 * @see jiacbeans.JiacbeansPackage#getMethod_Visibility()
	 * @model default="public"
	 * @generated
	 */
	String getVisibility();

	/**
	 * Sets the value of the '{@link jiacbeans.Method#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(String value);

	/**
	 * Returns the value of the '<em><b>Throws</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throws</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throws</em>' attribute list.
	 * @see jiacbeans.JiacbeansPackage#getMethod_Throws()
	 * @model
	 * @generated
	 */
	EList<String> getThrows();

	/**
	 * Returns the value of the '<em><b>Exposed As</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exposed As</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exposed As</em>' reference.
	 * @see #setExposedAs(Action)
	 * @see jiacbeans.JiacbeansPackage#getMethod_ExposedAs()
	 * @model
	 * @generated
	 */
	Action getExposedAs();

	/**
	 * Sets the value of the '{@link jiacbeans.Method#getExposedAs <em>Exposed As</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exposed As</em>' reference.
	 * @see #getExposedAs()
	 * @generated
	 */
	void setExposedAs(Action value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' reference list.
	 * The list contents are of type {@link jiacbeans.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' reference list.
	 * @see jiacbeans.JiacbeansPackage#getMethod_Parameters()
	 * @model
	 * @generated
	 */
	EList<Variable> getParameters();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link jiacbeans.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see jiacbeans.JiacbeansPackage#getMethod_Variables()
	 * @model
	 * @generated
	 */
	EList<Variable> getVariables();

} // Method
