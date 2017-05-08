/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sequence Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.SequenceFlow#getConditionType <em>Condition Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.SequenceFlow#getConditionExpression <em>Condition Expression</em>}</li>
 *   <li>{@link de.dailab.vsdt.SequenceFlow#getSource <em>Source</em>}</li>
 *   <li>{@link de.dailab.vsdt.SequenceFlow#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getSequenceFlow()
 * @model
 * @generated
 */
public interface SequenceFlow extends ConnectingObject {
	/**
	 * Returns the value of the '<em><b>Condition Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.ConditionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Type</em>' attribute.
	 * @see de.dailab.vsdt.ConditionType
	 * @see #setConditionType(ConditionType)
	 * @see de.dailab.vsdt.VsdtPackage#getSequenceFlow_ConditionType()
	 * @model required="true"
	 * @generated
	 */
	ConditionType getConditionType();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.SequenceFlow#getConditionType <em>Condition Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Type</em>' attribute.
	 * @see de.dailab.vsdt.ConditionType
	 * @see #getConditionType()
	 * @generated
	 */
	void setConditionType(ConditionType value);

	/**
	 * Returns the value of the '<em><b>Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition Expression</em>' containment reference.
	 * @see #setConditionExpression(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getSequenceFlow_ConditionExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getConditionExpression();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.SequenceFlow#getConditionExpression <em>Condition Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition Expression</em>' containment reference.
	 * @see #getConditionExpression()
	 * @generated
	 */
	void setConditionExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.FlowObject#getOutgoingSeq <em>Outgoing Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(FlowObject)
	 * @see de.dailab.vsdt.VsdtPackage#getSequenceFlow_Source()
	 * @see de.dailab.vsdt.FlowObject#getOutgoingSeq
	 * @model opposite="outgoingSeq" resolveProxies="false" required="true"
	 * @generated
	 */
	FlowObject getSource();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.SequenceFlow#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(FlowObject value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.FlowObject#getIncomingSeq <em>Incoming Seq</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(FlowObject)
	 * @see de.dailab.vsdt.VsdtPackage#getSequenceFlow_Target()
	 * @see de.dailab.vsdt.FlowObject#getIncomingSeq
	 * @model opposite="incomingSeq" resolveProxies="false" required="true"
	 * @generated
	 */
	FlowObject getTarget();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.SequenceFlow#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(FlowObject value);

} // SequenceFlow
