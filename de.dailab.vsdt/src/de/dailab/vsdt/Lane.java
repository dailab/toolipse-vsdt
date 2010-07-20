/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.Lane#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getLane()
 * @model
 * @generated
 */
public interface Lane extends GraphicalObject, FlowObjectContainer {

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Pool#getLanes <em>Lanes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Pool)
	 * @see de.dailab.vsdt.VsdtPackage#getLane_Parent()
	 * @see de.dailab.vsdt.Pool#getLanes
	 * @model opposite="lanes" transient="false"
	 * @generated
	 */
	Pool getParent();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Lane#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Pool value);

} // Lane
