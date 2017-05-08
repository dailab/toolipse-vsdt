/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.Association#getDirection <em>Direction</em>}</li>
 *   <li>{@link de.dailab.vsdt.Association#getSource <em>Source</em>}</li>
 *   <li>{@link de.dailab.vsdt.Association#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends ConnectingObject {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.DirectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see de.dailab.vsdt.DirectionType
	 * @see #setDirection(DirectionType)
	 * @see de.dailab.vsdt.VsdtPackage#getAssociation_Direction()
	 * @model required="true"
	 * @generated
	 */
	DirectionType getDirection();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Association#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see de.dailab.vsdt.DirectionType
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(DirectionType value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.GraphicalObject#getOutgoingAss <em>Outgoing Ass</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(GraphicalObject)
	 * @see de.dailab.vsdt.VsdtPackage#getAssociation_Source()
	 * @see de.dailab.vsdt.GraphicalObject#getOutgoingAss
	 * @model opposite="outgoingAss" resolveProxies="false" required="true"
	 * @generated
	 */
	GraphicalObject getSource();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Association#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(GraphicalObject value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.GraphicalObject#getIncomingAss <em>Incoming Ass</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(GraphicalObject)
	 * @see de.dailab.vsdt.VsdtPackage#getAssociation_Target()
	 * @see de.dailab.vsdt.GraphicalObject#getIncomingAss
	 * @model opposite="incomingAss" resolveProxies="false" required="true"
	 * @generated
	 */
	GraphicalObject getTarget();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Association#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(GraphicalObject value);

} // Association
