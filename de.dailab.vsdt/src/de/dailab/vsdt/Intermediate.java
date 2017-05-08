/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Intermediate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.Intermediate#getAttachedTo <em>Attached To</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getIntermediate()
 * @model
 * @generated
 */
public interface Intermediate extends Event {
	/**
	 * Returns the value of the '<em><b>Attached To</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Activity#getBoundaryEvents <em>Boundary Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attached To</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attached To</em>' container reference.
	 * @see #setAttachedTo(Activity)
	 * @see de.dailab.vsdt.VsdtPackage#getIntermediate_AttachedTo()
	 * @see de.dailab.vsdt.Activity#getBoundaryEvents
	 * @model opposite="boundaryEvents" transient="false"
	 * @generated
	 */
	Activity getAttachedTo();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Intermediate#getAttachedTo <em>Attached To</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attached To</em>' container reference.
	 * @see #getAttachedTo()
	 * @generated
	 */
	void setAttachedTo(Activity value);

} // Intermediate
