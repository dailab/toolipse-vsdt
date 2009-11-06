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
 * A representation of the model object '<em><b>Bpmn Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.BpmnProcess#getParentPool <em>Parent Pool</em>}</li>
 *   <li>{@link de.dailab.vsdt.BpmnProcess#getProcessType <em>Process Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.BpmnProcess#getStatus <em>Status</em>}</li>
 *   <li>{@link de.dailab.vsdt.BpmnProcess#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link de.dailab.vsdt.BpmnProcess#isSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link de.dailab.vsdt.BpmnProcess#isEnableInstanceCompensation <em>Enable Instance Compensation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.VsdtPackage#getBpmnProcess()
 * @model
 * @generated
 */
public interface BpmnProcess extends AbstractProcess, IdObject {
	/**
	 * Returns the value of the '<em><b>Parent Pool</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.Pool#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Pool</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Pool</em>' container reference.
	 * @see #setParentPool(Pool)
	 * @see de.dailab.vsdt.VsdtPackage#getBpmnProcess_ParentPool()
	 * @see de.dailab.vsdt.Pool#getProcess
	 * @model opposite="process" required="true" transient="false"
	 * @generated
	 */
	Pool getParentPool();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BpmnProcess#getParentPool <em>Parent Pool</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Pool</em>' container reference.
	 * @see #getParentPool()
	 * @generated
	 */
	void setParentPool(Pool value);

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
	 * @see de.dailab.vsdt.VsdtPackage#getBpmnProcess_ProcessType()
	 * @model default="PRIVATE" required="true"
	 * @generated
	 */
	ProcessType getProcessType();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BpmnProcess#getProcessType <em>Process Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Type</em>' attribute.
	 * @see de.dailab.vsdt.ProcessType
	 * @see #getProcessType()
	 * @generated
	 */
	void setProcessType(ProcessType value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * The literals are from the enumeration {@link de.dailab.vsdt.StatusType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see de.dailab.vsdt.StatusType
	 * @see #setStatus(StatusType)
	 * @see de.dailab.vsdt.VsdtPackage#getBpmnProcess_Status()
	 * @model required="true"
	 * @generated
	 */
	StatusType getStatus();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BpmnProcess#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see de.dailab.vsdt.StatusType
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(StatusType value);

	/**
	 * Returns the value of the '<em><b>Assignments</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.Assignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assignments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assignments</em>' containment reference list.
	 * @see de.dailab.vsdt.VsdtPackage#getBpmnProcess_Assignments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Assignment> getAssignments();

	/**
	 * Returns the value of the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suppress Join Failure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suppress Join Failure</em>' attribute.
	 * @see #setSuppressJoinFailure(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getBpmnProcess_SuppressJoinFailure()
	 * @model required="true"
	 * @generated
	 */
	boolean isSuppressJoinFailure();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BpmnProcess#isSuppressJoinFailure <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Suppress Join Failure</em>' attribute.
	 * @see #isSuppressJoinFailure()
	 * @generated
	 */
	void setSuppressJoinFailure(boolean value);

	/**
	 * Returns the value of the '<em><b>Enable Instance Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enable Instance Compensation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Instance Compensation</em>' attribute.
	 * @see #setEnableInstanceCompensation(boolean)
	 * @see de.dailab.vsdt.VsdtPackage#getBpmnProcess_EnableInstanceCompensation()
	 * @model required="true"
	 * @generated
	 */
	boolean isEnableInstanceCompensation();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.BpmnProcess#isEnableInstanceCompensation <em>Enable Instance Compensation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Instance Compensation</em>' attribute.
	 * @see #isEnableInstanceCompensation()
	 * @generated
	 */
	void setEnableInstanceCompensation(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" many="false"
	 * @generated
	 */
	EList<Property> getVisibleProperties();

} // BpmnProcess
