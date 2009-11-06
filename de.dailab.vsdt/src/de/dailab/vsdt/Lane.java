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
 *   <li>{@link de.dailab.vsdt.Lane#getParentPool <em>Parent Pool</em>}</li>
 *   <li>{@link de.dailab.vsdt.Lane#isBoundaryVisible <em>Boundary Visible</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getLane()
 * @model
 * @generated
 */
public interface Lane extends FlowObjectContainer, GraphicalObject {
	/**
	 * Returns the value of the '<em><b>Parent Pool</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Pool#getLanes <em>Lanes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Pool</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Pool</em>' container reference.
	 * @see #setParentPool(Pool)
	 * @see de.dailab.vsdt.VsdtPackage#getLane_ParentPool()
	 * @see de.dailab.vsdt.Pool#getLanes
	 * @model opposite="lanes" required="true" transient="false"
	 * @generated
	 */
	Pool getParentPool();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Lane#getParentPool <em>Parent Pool</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Pool</em>' container reference.
	 * @see #getParentPool()
	 * @generated
	 */
	void setParentPool(Pool value);

	/**
	 * Returns the value of the '<em><b>Boundary Visible</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boundary Visible</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boundary Visible</em>' attribute.
	 * @see #setBoundaryVisible(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getLane_BoundaryVisible()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isBoundaryVisible();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Lane#isBoundaryVisible <em>Boundary Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boundary Visible</em>' attribute.
	 * @see #isBoundaryVisible()
	 * @generated
	 */
	void setBoundaryVisible(boolean value);

} // Lane
