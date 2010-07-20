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
 * A representation of the model object '<em><b>Business Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.BusinessProcessDiagram#getParent <em>Parent</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessDiagram#getPools <em>Pools</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessDiagram#getArtifacts <em>Artifacts</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessDiagram#getConnections <em>Connections</em>}</li>
 *   <li>{@link de.dailab.vsdt.BusinessProcessDiagram#getParticipants <em>Participants</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessDiagram()
 * @model
 * @generated
 */
public interface BusinessProcessDiagram extends IdObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.BusinessProcessSystem#getBusinessProcesses <em>Business Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(BusinessProcessSystem)
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessDiagram_Parent()
	 * @see de.dailab.vsdt.BusinessProcessSystem#getBusinessProcesses
	 * @model opposite="businessProcesses" transient="false"
	 * @generated
	 */
	BusinessProcessSystem getParent();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BusinessProcessDiagram#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(BusinessProcessSystem value);

	/**
	 * Returns the value of the '<em><b>Pools</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Pool}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Pool#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pools</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pools</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessDiagram_Pools()
	 * @see de.dailab.vsdt.Pool#getParent
	 * @model opposite="parent" containment="true" required="true"
	 * @generated
	 */
	EList<Pool> getPools();

	/**
	 * Returns the value of the '<em><b>Artifacts</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Artifact}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Artifact#getParentDiagram <em>Parent Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifacts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifacts</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessDiagram_Artifacts()
	 * @see de.dailab.vsdt.Artifact#getParentDiagram
	 * @model opposite="parentDiagram" containment="true"
	 * @generated
	 */
	EList<Artifact> getArtifacts();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.ConnectingObject}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.ConnectingObject#getParentDiagram <em>Parent Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessDiagram_Connections()
	 * @see de.dailab.vsdt.ConnectingObject#getParentDiagram
	 * @model opposite="parentDiagram" containment="true"
	 * @generated
	 */
	EList<ConnectingObject> getConnections();

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Participant}.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Participant#getAssociatedProcesses <em>Associated Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getBusinessProcessDiagram_Participants()
	 * @see de.dailab.vsdt.Participant#getAssociatedProcesses
	 * @model opposite="associatedProcesses" required="true"
	 * @generated
	 */
	EList<Participant> getParticipants();

} // BusinessProcessDiagram
