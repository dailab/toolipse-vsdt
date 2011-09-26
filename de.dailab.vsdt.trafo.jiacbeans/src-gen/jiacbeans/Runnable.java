/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Runnable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.Runnable#getRunContent <em>Run Content</em>}</li>
 *   <li>{@link jiacbeans.Runnable#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getRunnable()
 * @model
 * @generated
 */
public interface Runnable extends Script {
	/**
	 * Returns the value of the '<em><b>Run Content</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run Content</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run Content</em>' reference.
	 * @see #setRunContent(Script)
	 * @see jiacbeans.JiacbeansPackage#getRunnable_RunContent()
	 * @model
	 * @generated
	 */
	Script getRunContent();

	/**
	 * Sets the value of the '{@link jiacbeans.Runnable#getRunContent <em>Run Content</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run Content</em>' reference.
	 * @see #getRunContent()
	 * @generated
	 */
	void setRunContent(Script value);

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
	 * @see jiacbeans.JiacbeansPackage#getRunnable_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link jiacbeans.Runnable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Runnable
