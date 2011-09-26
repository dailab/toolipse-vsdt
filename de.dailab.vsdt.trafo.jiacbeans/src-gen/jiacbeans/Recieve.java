/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jiacbeans;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recieve</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jiacbeans.Recieve#getAddress <em>Address</em>}</li>
 *   <li>{@link jiacbeans.Recieve#getPayload <em>Payload</em>}</li>
 * </ul>
 * </p>
 *
 * @see jiacbeans.JiacbeansPackage#getRecieve()
 * @model
 * @generated
 */
public interface Recieve extends Script {
	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see #setAddress(String)
	 * @see jiacbeans.JiacbeansPackage#getRecieve_Address()
	 * @model
	 * @generated
	 */
	String getAddress();

	/**
	 * Sets the value of the '{@link jiacbeans.Recieve#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(String value);

	/**
	 * Returns the value of the '<em><b>Payload</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload</em>' reference.
	 * @see #setPayload(JavaVariable)
	 * @see jiacbeans.JiacbeansPackage#getRecieve_Payload()
	 * @model required="true"
	 * @generated
	 */
	JavaVariable getPayload();

	/**
	 * Sets the value of the '{@link jiacbeans.Recieve#getPayload <em>Payload</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload</em>' reference.
	 * @see #getPayload()
	 * @generated
	 */
	void setPayload(JavaVariable value);

} // Recieve
