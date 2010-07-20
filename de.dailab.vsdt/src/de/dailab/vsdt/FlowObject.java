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
 * A representation of the model object '<em><b>Flow Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.FlowObject#getParent <em>Parent</em>}</li>
 *   <li>{@link de.dailab.vsdt.FlowObject#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link de.dailab.vsdt.FlowObject#getOutgoingSeq <em>Outgoing Seq</em>}</li>
 *   <li>{@link de.dailab.vsdt.FlowObject#getIncomingSeq <em>Incoming Seq</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getFlowObject()
 * @model abstract="true"
 * @generated
 */
public interface FlowObject extends Node {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.FlowObjectContainer#getContainedFlowObjects <em>Contained Flow Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(FlowObjectContainer)
	 * @see de.dailab.vsdt.VsdtPackage#getFlowObject_Parent()
	 * @see de.dailab.vsdt.FlowObjectContainer#getContainedFlowObjects
	 * @model opposite="containedFlowObjects" transient="false"
	 * @generated
	 */
	FlowObjectContainer getParent();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.FlowObject#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(FlowObjectContainer value);

	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Assignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getFlowObject_Assignments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Assignment> getAssignments();

	/**
	 * Returns the value of the '<em><b>Outgoing Seq</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.SequenceFlow}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.SequenceFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Seq</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Seq</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getFlowObject_OutgoingSeq()
	 * @see de.dailab.vsdt.SequenceFlow#getSource
	 * @model opposite="source" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<SequenceFlow> getOutgoingSeq();

	/**
	 * Returns the value of the '<em><b>Incoming Seq</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.SequenceFlow}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.SequenceFlow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Seq</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Seq</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getFlowObject_IncomingSeq()
	 * @see de.dailab.vsdt.SequenceFlow#getTarget
	 * @model opposite="target" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<SequenceFlow> getIncomingSeq();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isStartingNode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isEndingNode();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	AbstractProcess getAbstractProcess();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
//	EList<Property> getVisibleProperties();

} // FlowObject
