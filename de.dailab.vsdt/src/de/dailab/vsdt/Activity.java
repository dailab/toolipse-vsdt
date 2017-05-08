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
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.Activity#getInputSets <em>Input Sets</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getOutputSets <em>Output Sets</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getIORules <em>IO Rules</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getLoopAttributes <em>Loop Attributes</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getBoundaryEvents <em>Boundary Events</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#isEventedSubprocess <em>Evented Subprocess</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getActivityType <em>Activity Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getImplementation <em>Implementation</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getPerformers <em>Performers</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getScript <em>Script</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getTransaction <em>Transaction</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getCalledElement <em>Called Element</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getInputPropertyMaps <em>Input Property Maps</em>}</li>
 *   <li>{@link de.dailab.vsdt.Activity#getOutputPropertyMaps <em>Output Property Maps</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends FlowObject, AbstractProcess, FlowObjectContainer {
	/**
	 * Returns the value of the '<em><b>Input Sets</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.InputSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Sets</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_InputSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputSet> getInputSets();

	/**
	 * Returns the value of the '<em><b>Output Sets</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.OutputSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Sets</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_OutputSets()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputSet> getOutputSets();

	/**
	 * Returns the value of the '<em><b>IO Rules</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>IO Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>IO Rules</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_IORules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getIORules();

	/**
	 * Returns the value of the '<em><b>Loop Attributes</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.LoopAttributeSet#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Attributes</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Attributes</em>' containment reference.
	 * @see #setLoopAttributes(LoopAttributeSet)
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_LoopAttributes()
	 * @see de.dailab.vsdt.LoopAttributeSet#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	LoopAttributeSet getLoopAttributes();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Activity#getLoopAttributes <em>Loop Attributes</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Attributes</em>' containment reference.
	 * @see #getLoopAttributes()
	 * @generated
	 */
	void setLoopAttributes(LoopAttributeSet value);

	/**
	 * Returns the value of the '<em><b>Boundary Events</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Intermediate}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Intermediate#getAttachedTo <em>Attached To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundary Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundary Events</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_BoundaryEvents()
	 * @see de.dailab.vsdt.Intermediate#getAttachedTo
	 * @model opposite="attachedTo" containment="true"
	 * @generated
	 */
	EList<Intermediate> getBoundaryEvents();

	/**
	 * Returns the value of the '<em><b>Evented Subprocess</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Evented Subprocess</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Evented Subprocess</em>' attribute.
	 * @see #setEventedSubprocess(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_EventedSubprocess()
	 * @model
	 * @generated
	 */
	boolean isEventedSubprocess();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Activity#isEventedSubprocess <em>Evented Subprocess</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evented Subprocess</em>' attribute.
	 * @see #isEventedSubprocess()
	 * @generated
	 */
	void setEventedSubprocess(boolean value);

	/**
	 * Returns the value of the '<em><b>Activity Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.ActivityType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity Type</em>' attribute.
	 * @see de.dailab.vsdt.ActivityType
	 * @see #setActivityType(ActivityType)
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_ActivityType()
	 * @model required="true"
	 * @generated
	 */
	ActivityType getActivityType();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Activity#getActivityType <em>Activity Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity Type</em>' attribute.
	 * @see de.dailab.vsdt.ActivityType
	 * @see #getActivityType()
	 * @generated
	 */
	void setActivityType(ActivityType value);

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
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_Implementation()
	 * @model
	 * @generated
	 */
	Implementation getImplementation();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Activity#getImplementation <em>Implementation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implementation</em>' reference.
	 * @see #getImplementation()
	 * @generated
	 */
	void setImplementation(Implementation value);

	/**
	 * Returns the value of the '<em><b>Performers</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Performers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Performers</em>' attribute list.
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_Performers()
	 * @model
	 * @generated
	 */
	EList<String> getPerformers();

	/**
	 * Returns the value of the '<em><b>Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Script</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Script</em>' attribute.
	 * @see #setScript(String)
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_Script()
	 * @model
	 * @generated
	 */
	String getScript();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Activity#getScript <em>Script</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script</em>' attribute.
	 * @see #getScript()
	 * @generated
	 */
	void setScript(String value);

	/**
	 * Returns the value of the '<em><b>Transaction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transaction</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transaction</em>' containment reference.
	 * @see #setTransaction(Transaction)
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_Transaction()
	 * @model containment="true"
	 * @generated
	 */
	Transaction getTransaction();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Activity#getTransaction <em>Transaction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transaction</em>' containment reference.
	 * @see #getTransaction()
	 * @generated
	 */
	void setTransaction(Transaction value);

	/**
	 * Returns the value of the '<em><b>Called Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Element</em>' reference.
	 * @see #setCalledElement(AbstractProcess)
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_CalledElement()
	 * @model
	 * @generated
	 */
	AbstractProcess getCalledElement();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Activity#getCalledElement <em>Called Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Element</em>' reference.
	 * @see #getCalledElement()
	 * @generated
	 */
	void setCalledElement(AbstractProcess value);

	/**
	 * Returns the value of the '<em><b>Input Property Maps</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Property Maps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Property Maps</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_InputPropertyMaps()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getInputPropertyMaps();

	/**
	 * Returns the value of the '<em><b>Output Property Maps</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Property Maps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Property Maps</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getActivity_OutputPropertyMaps()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getOutputPropertyMaps();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initializeInputSet();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initializeOutputSet();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isCompensation();

} // Activity
