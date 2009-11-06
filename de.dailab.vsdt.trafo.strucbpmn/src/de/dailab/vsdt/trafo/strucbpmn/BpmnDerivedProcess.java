/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import de.dailab.vsdt.FlowObject;

/**
 * <!-- begin-user-doc -->
 * The BpmnDerivedProcess (BDP) can be used to wrap an element that has to be put in a seperate process, e.g. when
 * an element is used in multiple branches of a loop.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#getElement <em>Element</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#getProcessName <em>Process Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#isWaitForCompletion <em>Wait For Completion</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnDerivedProcess()
 * @model
 * @generated
 */
public interface BpmnDerivedProcess extends FlowObject {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' reference.
	 * @see #setElement(FlowObject)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnDerivedProcess_Element()
	 * @model required="true"
	 * @generated
	 */
	FlowObject getElement();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#getElement <em>Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(FlowObject value);

	/**
	 * Returns the value of the '<em><b>Process Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Name</em>' attribute.
	 * @see #setProcessName(String)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnDerivedProcess_ProcessName()
	 * @model required="true"
	 * @generated
	 */
	String getProcessName();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#getProcessName <em>Process Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Name</em>' attribute.
	 * @see #getProcessName()
	 * @generated
	 */
	void setProcessName(String value);

	/**
	 * Returns the value of the '<em><b>Wait For Completion</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wait For Completion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait For Completion</em>' attribute.
	 * @see #setWaitForCompletion(boolean)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnDerivedProcess_WaitForCompletion()
	 * @model default="true"
	 * @generated
	 */
	boolean isWaitForCompletion();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#isWaitForCompletion <em>Wait For Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait For Completion</em>' attribute.
	 * @see #isWaitForCompletion()
	 * @generated
	 */
	void setWaitForCompletion(boolean value);

} // BpmnDerivedProcess
