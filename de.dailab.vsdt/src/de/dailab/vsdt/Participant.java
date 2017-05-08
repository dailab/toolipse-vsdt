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
 * A representation of the model object '<em><b>Participant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.Participant#getType <em>Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.Participant#getAssociatedProcesses <em>Associated Processes</em>}</li>
 *   <li>{@link de.dailab.vsdt.Participant#getAssociatedPools <em>Associated Pools</em>}</li>
 * </ul>
 *
 * @see de.dailab.vsdt.VsdtPackage#getParticipant()
 * @model
 * @generated
 */
public interface Participant extends IdObject {
	/**
	 * Returns the value of the '<em><b>Associated Processes</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.BusinessProcessDiagram}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.BusinessProcessDiagram#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Processes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Processes</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getParticipant_AssociatedProcesses()
	 * @see de.dailab.vsdt.BusinessProcessDiagram#getParticipants
	 * @model opposite="participants"
	 * @generated
	 */
	EList<BusinessProcessDiagram> getAssociatedProcesses();

	/**
	 * Returns the value of the '<em><b>Associated Pools</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Pool}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Pool#getParticipant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Associated Pools</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Associated Pools</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getParticipant_AssociatedPools()
	 * @see de.dailab.vsdt.Pool#getParticipant
	 * @model opposite="participant"
	 * @generated
	 */
	EList<Pool> getAssociatedPools();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.ParticipantType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.dailab.vsdt.ParticipantType
	 * @see #setType(ParticipantType)
	 * @see de.dailab.vsdt.VsdtPackage#getParticipant_Type()
	 * @model
	 * @generated
	 */
	ParticipantType getType();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.Participant#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.dailab.vsdt.ParticipantType
	 * @see #getType()
	 * @generated
	 */
	void setType(ParticipantType value);

} // Participant
