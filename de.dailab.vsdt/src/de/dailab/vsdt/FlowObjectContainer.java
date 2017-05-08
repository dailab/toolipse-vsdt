/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Flow Object Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.FlowObjectContainer#getContainedFlowObjects <em>Contained Flow Objects</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getFlowObjectContainer()
 * @model abstract="true"
 * @generated
 */
public interface FlowObjectContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Contained Flow Objects</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.FlowObject}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.FlowObject#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Flow Objects</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Flow Objects</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getFlowObjectContainer_ContainedFlowObjects()
	 * @see de.dailab.vsdt.FlowObject#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<FlowObject> getContainedFlowObjects();

} // FlowObjectContainer
