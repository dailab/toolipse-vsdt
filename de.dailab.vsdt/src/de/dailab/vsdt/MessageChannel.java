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
 *   <li>{@link de.dailab.vsdt.MessageChannel#getSender <em>Sender</em>}</li>
 *   <li>{@link de.dailab.vsdt.MessageChannel#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link de.dailab.vsdt.MessageChannel#isMessageGroup <em>Message Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getMessageChannel()
 * @model
 * @generated
 */
public interface MessageChannel extends Implementation {
	/**
	 * Returns the value of the '<em><b>Channel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' containment reference.
	 * @see #setChannel(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getMessageChannel_Channel()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getChannel();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MessageChannel#getChannel <em>Channel</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' containment reference.
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

	/**
	 * Returns the value of the '<em><b>Sender</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sender</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sender</em>' containment reference.
	 * @see #setSender(Property)
	 * @see de.dailab.vsdt.VsdtPackage#getMessageChannel_Sender()
	 * @model containment="true"
	 * @generated
	 */
	Property getSender();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MessageChannel#getSender <em>Sender</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sender</em>' containment reference.
	 * @see #getSender()
	 * @generated
	 */
	void setSender(Property value);

	/**
	 * Returns the value of the '<em><b>Receiver</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiver</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiver</em>' containment reference.
	 * @see #setReceiver(Property)
	 * @see de.dailab.vsdt.VsdtPackage#getMessageChannel_Receiver()
	 * @model containment="true"
	 * @generated
	 */
	Property getReceiver();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MessageChannel#getReceiver <em>Receiver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiver</em>' containment reference.
	 * @see #getReceiver()
	 * @generated
	 */
	void setReceiver(Property value);

	/**
	 * Returns the value of the '<em><b>Message Group</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Group</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Group</em>' attribute.
	 * @see #setMessageGroup(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getMessageChannel_MessageGroup()
	 * @model
	 * @generated
	 */
	boolean isMessageGroup();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.MessageChannel#isMessageGroup <em>Message Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Group</em>' attribute.
	 * @see #isMessageGroup()
	 * @generated
	 */
	void setMessageGroup(boolean value);

} // MessageChannel
