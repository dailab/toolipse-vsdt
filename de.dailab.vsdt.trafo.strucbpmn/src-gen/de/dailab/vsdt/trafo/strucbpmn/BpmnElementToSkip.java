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
 * A representation of the model object '<em><b>Bpmn Element To Skip</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getElement <em>Element</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getEventHandlerCase <em>Event Handler Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnElementToSkip()
 * @model
 * @generated
 */
public interface BpmnElementToSkip extends FlowObject {
	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference.
	 * @see #setElement(FlowObject)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnElementToSkip_Element()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FlowObject getElement();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getElement <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' containment reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(FlowObject value);

	/**
	 * Returns the value of the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' attribute.
	 * @see #setVariableName(String)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnElementToSkip_VariableName()
	 * @model
	 * @generated
	 */
	String getVariableName();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getVariableName <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' attribute.
	 * @see #getVariableName()
	 * @generated
	 */
	void setVariableName(String value);

	/**
	 * Returns the value of the '<em><b>Event Handler Case</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getElementToSkip <em>Element To Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Handler Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Handler Case</em>' reference.
	 * @see #setEventHandlerCase(BpmnEventHandlerCase)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnElementToSkip_EventHandlerCase()
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getElementToSkip
	 * @model opposite="elementToSkip"
	 * @generated
	 */
	BpmnEventHandlerCase getEventHandlerCase();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getEventHandlerCase <em>Event Handler Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event Handler Case</em>' reference.
	 * @see #getEventHandlerCase()
	 * @generated
	 */
	void setEventHandlerCase(BpmnEventHandlerCase value);

} // BpmnElementToSkip
