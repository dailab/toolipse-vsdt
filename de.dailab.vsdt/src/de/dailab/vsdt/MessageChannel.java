/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Message Channel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.MessageChannel#getChannel <em>Channel</em>}</li>
 *   <li>{@link de.dailab.vsdt.MessageChannel#getPayload <em>Payload</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getMessageChannel()
 * @model
 * @generated
 */
public interface MessageChannel extends Implementation {
	/**
	 * Returns the value of the '<em><b>Channel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' reference.
	 * @see #setChannel(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getMessageChannel_Channel()
	 * @model required="true"
	 * @generated
	 */
	Expression getChannel();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MessageChannel#getChannel <em>Channel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' reference.
	 * @see #getChannel()
	 * @generated
	 */
	void setChannel(Expression value);

	/**
	 * Returns the value of the '<em><b>Payload</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Payload</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Payload</em>' containment reference.
	 * @see #setPayload(Property)
	 * @see de.dailab.vsdt.VsdtPackage#getMessageChannel_Payload()
	 * @model containment="true"
	 * @generated
	 */
	Property getPayload();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MessageChannel#getPayload <em>Payload</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Payload</em>' containment reference.
	 * @see #getPayload()
	 * @generated
	 */
	void setPayload(Property value);

} // MessageChannel
