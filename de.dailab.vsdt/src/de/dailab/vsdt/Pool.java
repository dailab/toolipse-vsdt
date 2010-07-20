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
 * A representation of the model object '<em><b>Pool</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.Pool#getParent <em>Parent</em>}</li>
 *   <li>{@link de.dailab.vsdt.Pool#getParticipant <em>Participant</em>}</li>
 *   <li>{@link de.dailab.vsdt.Pool#getLanes <em>Lanes</em>}</li>
 *   <li>{@link de.dailab.vsdt.Pool#isBoundaryVisible <em>Boundary Visible</em>}</li>
 *   <li>{@link de.dailab.vsdt.Pool#getProcessType <em>Process Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getPool()
 * @model
 * @generated
 */
public interface Pool extends Node, AbstractProcess {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.BusinessProcessDiagram#getPools <em>Pools</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(BusinessProcessDiagram)
	 * @see de.dailab.vsdt.VsdtPackage#getPool_Parent()
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getPools
	 * @model opposite="pools" transient="false"
	 * @generated
	 */
	BusinessProcessDiagram getParent();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Pool#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(BusinessProcessDiagram value);

	/**
	 * Returns the value of the '<em><b>Participant</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Participant#getAssociatedPools <em>Associated Pools</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participant</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participant</em>' reference.
	 * @see #setParticipant(Participant)
	 * @see de.dailab.vsdt.VsdtPackage#getPool_Participant()
	 * @see de.dailab.vsdt.Participant#getAssociatedPools
	 * @model opposite="associatedPools" required="true"
	 * @generated
	 */
	Participant getParticipant();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Pool#getParticipant <em>Participant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Participant</em>' reference.
	 * @see #getParticipant()
	 * @generated
	 */
	void setParticipant(Participant value);

	/**
	 * Returns the value of the '<em><b>Lanes</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Lane}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Lane#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lanes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lanes</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getPool_Lanes()
	 * @see de.dailab.vsdt.Lane#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Lane> getLanes();

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
	 * @see de.dailab.vsdt.VsdtPackage#getPool_BoundaryVisible()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isBoundaryVisible();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Pool#isBoundaryVisible <em>Boundary Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boundary Visible</em>' attribute.
	 * @see #isBoundaryVisible()
	 * @generated
	 */
	void setBoundaryVisible(boolean value);

	/**
	 * Returns the value of the '<em><b>Process Type</b></em>' attribute.
	 * The default value is <code>"PRIVATE"</code>.
	 * The literals are from the enumeration {@link de.dailab.vsdt.ProcessType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Type</em>' attribute.
	 * @see de.dailab.vsdt.ProcessType
	 * @see #setProcessType(ProcessType)
	 * @see de.dailab.vsdt.VsdtPackage#getPool_ProcessType()
	 * @model default="PRIVATE" required="true"
	 * @generated
	 */
	ProcessType getProcessType();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Pool#getProcessType <em>Process Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Type</em>' attribute.
	 * @see de.dailab.vsdt.ProcessType
	 * @see #getProcessType()
	 * @generated
	 */
	void setProcessType(ProcessType value);

} // Pool
