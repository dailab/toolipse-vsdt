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
 *   <li>{@link de.dailab.vsdt.Pool#getParentDiagram <em>Parent Diagram</em>}</li>
 *   <li>{@link de.dailab.vsdt.Pool#getProcess <em>Process</em>}</li>
 *   <li>{@link de.dailab.vsdt.Pool#getParticipant <em>Participant</em>}</li>
 *   <li>{@link de.dailab.vsdt.Pool#getLanes <em>Lanes</em>}</li>
 *   <li>{@link de.dailab.vsdt.Pool#isBoundaryVisible <em>Boundary Visible</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getPool()
 * @model
 * @generated
 */
public interface Pool extends Node {
	/**
	 * Returns the value of the '<em><b>Parent Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.BusinessProcessDiagram#getPools <em>Pools</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Diagram</em>' container reference.
	 * @see #setParentDiagram(BusinessProcessDiagram)
	 * @see de.dailab.vsdt.VsdtPackage#getPool_ParentDiagram()
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getPools
	 * @model opposite="pools" required="true" transient="false"
	 * @generated
	 */
	BusinessProcessDiagram getParentDiagram();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Pool#getParentDiagram <em>Parent Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Diagram</em>' container reference.
	 * @see #getParentDiagram()
	 * @generated
	 */
	void setParentDiagram(BusinessProcessDiagram value);

	/**
	 * Returns the value of the '<em><b>Process</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.BpmnProcess#getParentPool <em>Parent Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process</em>' containment reference.
	 * @see #setProcess(BpmnProcess)
	 * @see de.dailab.vsdt.VsdtPackage#getPool_Process()
	 * @see de.dailab.vsdt.BpmnProcess#getParentPool
	 * @model opposite="parentPool" containment="true"
	 * @generated
	 */
	BpmnProcess getProcess();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Pool#getProcess <em>Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process</em>' containment reference.
	 * @see #getProcess()
	 * @generated
	 */
	void setProcess(BpmnProcess value);

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
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Lane#getParentPool <em>Parent Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lanes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lanes</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getPool_Lanes()
	 * @see de.dailab.vsdt.Lane#getParentPool
	 * @model opposite="parentPool" containment="true"
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void initializeParticipant();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setBoundaryVisibility();

} // Pool
