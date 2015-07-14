/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import org.eclipse.emf.common.util.EList;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.Event#isNonInterrupting <em>Non Interrupting</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#getTrigger <em>Trigger</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#getTimeExpression <em>Time Expression</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#isAsDuration <em>As Duration</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#getRuleExpression <em>Rule Expression</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#getErrorCode <em>Error Code</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#getActivity <em>Activity</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#getSignal <em>Signal</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#isSignalThrown <em>Signal Thrown</em>}</li>
 *   <li>{@link de.dailab.vsdt.Event#getLinkedTo <em>Linked To</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getEvent()
 * @model abstract="true"
 * @generated
 */
public interface Event extends FlowObject {
	/**
	 * Returns the value of the '<em><b>Non Interrupting</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Non Interrupting</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Non Interrupting</em>' attribute.
	 * @see #setNonInterrupting(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_NonInterrupting()
	 * @model
	 * @generated
	 */
	boolean isNonInterrupting();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#isNonInterrupting <em>Non Interrupting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Interrupting</em>' attribute.
	 * @see #isNonInterrupting()
	 * @generated
	 */
	void setNonInterrupting(boolean value);

	/**
	 * Returns the value of the '<em><b>Trigger</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.TriggerType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trigger</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trigger</em>' attribute.
	 * @see de.dailab.vsdt.TriggerType
	 * @see #setTrigger(TriggerType)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_Trigger()
	 * @model required="true"
	 * @generated
	 */
	TriggerType getTrigger();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#getTrigger <em>Trigger</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trigger</em>' attribute.
	 * @see de.dailab.vsdt.TriggerType
	 * @see #getTrigger()
	 * @generated
	 */
	void setTrigger(TriggerType value);

	/**
	 * Returns the value of the '<em><b>Implementation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementation</em>' reference.
	 * @see #setImplementation(Implementation)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_Implementation()
	 * @model
	 * @generated
	 */
	Implementation getImplementation();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#getImplementation <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' reference.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(Implementation value);

	/**
	 * Returns the value of the '<em><b>Time Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Expression</em>' containment reference.
	 * @see #setTimeExpression(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_TimeExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getTimeExpression();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#getTimeExpression <em>Time Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Expression</em>' containment reference.
	 * @see #getTimeExpression()
	 * @generated
	 */
	void setTimeExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>As Duration</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>As Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>As Duration</em>' attribute.
	 * @see #setAsDuration(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_AsDuration()
	 * @model default="true"
	 * @generated
	 */
	boolean isAsDuration();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#isAsDuration <em>As Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>As Duration</em>' attribute.
	 * @see #isAsDuration()
	 * @generated
	 */
	void setAsDuration(boolean value);

	/**
	 * Returns the value of the '<em><b>Rule Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Expression</em>' containment reference.
	 * @see #setRuleExpression(Expression)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_RuleExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getRuleExpression();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#getRuleExpression <em>Rule Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule Expression</em>' containment reference.
	 * @see #getRuleExpression()
	 * @generated
	 */
	void setRuleExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Error Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error Code</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error Code</em>' attribute.
	 * @see #setErrorCode(String)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_ErrorCode()
	 * @model
	 * @generated
	 */
	String getErrorCode();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#getErrorCode <em>Error Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error Code</em>' attribute.
	 * @see #getErrorCode()
	 * @generated
	 */
	void setErrorCode(String value);

	/**
	 * Returns the value of the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' reference.
	 * @see #setActivity(Activity)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_Activity()
	 * @model
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#getActivity <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Signal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal</em>' attribute.
	 * @see #setSignal(String)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_Signal()
	 * @model
	 * @generated
	 */
	String getSignal();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#getSignal <em>Signal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal</em>' attribute.
	 * @see #getSignal()
	 * @generated
	 */
	void setSignal(String value);

	/**
	 * Returns the value of the '<em><b>Signal Thrown</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal Thrown</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal Thrown</em>' attribute.
	 * @see #setSignalThrown(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_SignalThrown()
	 * @model
	 * @generated
	 */
	boolean isSignalThrown();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#isSignalThrown <em>Signal Thrown</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal Thrown</em>' attribute.
	 * @see #isSignalThrown()
	 * @generated
	 */
	void setSignalThrown(boolean value);

	/**
	 * Returns the value of the '<em><b>Linked To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked To</em>' reference.
	 * @see #setLinkedTo(Event)
	 * @see de.dailab.vsdt.VsdtPackage#getEvent_LinkedTo()
	 * @model
	 * @generated
	 */
	Event getLinkedTo();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Event#getLinkedTo <em>Linked To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked To</em>' reference.
	 * @see #getLinkedTo()
	 * @generated
	 */
	void setLinkedTo(Event value);

	/**
	 * <!-- begin-user-doc -->
	 * This method returns the trigger types that may be used for this event in the
	 * context it is used in. The trigger type depends on the event's type (Start, End,
	 * Intermediate), and in case of Intermediate whether it is attached to an activity
	 * and whether it is throwing or catching.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<TriggerType> getValidTriggerTypes();

	/**
	 * <!-- begin-user-doc -->
	 * Returns whether this event is throwing or catching. Start events are always catching,
	 * End events are always throwing. Intermediate events are always catching, if attached
	 * to an activity. Ambiguities exist in the case of Message and Signal trigger. In the first
	 * case, the Message's participant can be taken into account. The default is false.
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isThrowing();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isInEventedSubprocess();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isOnBoundary();

} // Event
