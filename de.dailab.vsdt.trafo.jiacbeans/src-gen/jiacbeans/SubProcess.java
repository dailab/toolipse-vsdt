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
 * A representation of the model object '<em><b>Sub Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.SubProcess#getSubprocesses <em>Subprocesses</em>}</li>
 *   <li>{@link jiacbeans.SubProcess#getName <em>Name</em>}</li>
 *   <li>{@link jiacbeans.SubProcess#getMethods <em>Methods</em>}</li>
 *   <li>{@link jiacbeans.SubProcess#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getSubProcess()
 * @model
 * @generated
 */
public interface SubProcess extends EObject {
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
	 * @see jiacbeans.JiacbeansPackage#getSubProcess_Subprocesses()
	 * @model
	 * @generated
	 */
	EList<SubProcess> getSubprocesses();

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
	 * @see jiacbeans.JiacbeansPackage#getSubProcess_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jiacbeans.SubProcess#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see jiacbeans.JiacbeansPackage#getSubProcess_Methods()
	 * @model
	 * @generated
	 */
	EList<Method> getMethods();

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
	 * @see jiacbeans.JiacbeansPackage#getSubProcess_Attributes()
	 * @model
	 * @generated
	 */
	EList<JavaVariable> getAttributes();

} // SubProcess
