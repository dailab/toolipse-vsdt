/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gateway</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.Gateway#getGatewayType <em>Gateway Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.Gateway#getIncomingCondition <em>Incoming Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.Gateway#getOutgoingCondition <em>Outgoing Condition</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getGateway()
 * @model
 * @generated
 */
public interface Gateway extends FlowObject {
	/**
	 * Returns the value of the '<em><b>Gateway Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.GatewayType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateway Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateway Type</em>' attribute.
	 * @see de.dailab.vsdt.GatewayType
	 * @see #setGatewayType(GatewayType)
	 * @see de.dailab.vsdt.VsdtPackage#getGateway_GatewayType()
	 * @model
	 * @generated
	 */
	GatewayType getGatewayType();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Gateway#getGatewayType <em>Gateway Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gateway Type</em>' attribute.
	 * @see de.dailab.vsdt.GatewayType
	 * @see #getGatewayType()
	 * @generated
	 */
	void setGatewayType(GatewayType value);

	/**
	 * Returns the value of the '<em><b>Incoming Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Condition</em>' containment reference.
	 * @see #setIncomingCondition(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getGateway_IncomingCondition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getIncomingCondition();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Gateway#getIncomingCondition <em>Incoming Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Incoming Condition</em>' containment reference.
	 * @see #getIncomingCondition()
	 * @generated
	 */
	void setIncomingCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Outgoing Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Condition</em>' containment reference.
	 * @see #setOutgoingCondition(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getGateway_OutgoingCondition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getOutgoingCondition();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Gateway#getOutgoingCondition <em>Outgoing Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Condition</em>' containment reference.
	 * @see #getOutgoingCondition()
	 * @generated
	 */
	void setOutgoingCondition(Expression value);

} // Gateway
