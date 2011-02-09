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
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.Node#getOutgoingMsg <em>Outgoing Msg</em>}</li>
 *   <li>{@link de.dailab.vsdt.Node#getIncomingMsg <em>Incoming Msg</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getNode()
 * @model abstract="true"
 * @generated
 */
public interface Node extends GraphicalObject {
	/**
	 * Returns the value of the '<em><b>Outgoing Msg</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.MessageFlow}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.MessageFlow#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Msg</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Msg</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getNode_OutgoingMsg()
	 * @see de.dailab.vsdt.MessageFlow#getSource
	 * @model opposite="source" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<MessageFlow> getOutgoingMsg();

	/**
	 * Returns the value of the '<em><b>Incoming Msg</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.MessageFlow}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.MessageFlow#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Msg</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Msg</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getNode_IncomingMsg()
	 * @see de.dailab.vsdt.MessageFlow#getTarget
	 * @model opposite="target" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<MessageFlow> getIncomingMsg();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Pool getPool();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void adaptToImplementation(Implementation implementation, boolean incoming);

} // Node
