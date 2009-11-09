/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bpmn Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#getElement <em>Element</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#getCondition <em>Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#isDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnBranch()
 * @model
 * @generated
 */
public interface BpmnBranch extends FlowObject {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference.
	 * @see #setElement(FlowObject)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnBranch_Element()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FlowObject getElement();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#getElement <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' containment reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(FlowObject value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnBranch_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' attribute.
	 * @see #setDefault(boolean)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnBranch_Default()
	 * @model
	 * @generated
	 */
	boolean isDefault();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#isDefault <em>Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' attribute.
	 * @see #isDefault()
	 * @generated
	 */
	void setDefault(boolean value);

} // BpmnBranch
