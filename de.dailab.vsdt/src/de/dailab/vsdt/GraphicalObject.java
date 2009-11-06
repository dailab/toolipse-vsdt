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
 * A representation of the model object '<em><b>Graphical Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.GraphicalObject#getOutgoingAss <em>Outgoing Ass</em>}</li>
 *   <li>{@link de.dailab.vsdt.GraphicalObject#getIncomingAss <em>Incoming Ass</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getGraphicalObject()
 * @model abstract="true"
 * @generated
 */
public interface GraphicalObject extends IdObject {
	/**
	 * Returns the value of the '<em><b>Outgoing Ass</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Association}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Association#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Ass</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Ass</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getGraphicalObject_OutgoingAss()
	 * @see de.dailab.vsdt.Association#getSource
	 * @model opposite="source" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<Association> getOutgoingAss();

	/**
	 * Returns the value of the '<em><b>Incoming Ass</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Association}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Association#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Ass</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Ass</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getGraphicalObject_IncomingAss()
	 * @see de.dailab.vsdt.Association#getTarget
	 * @model opposite="target" resolveProxies="false" transient="true"
	 * @generated
	 */
	EList<Association> getIncomingAss();

} // GraphicalObject
