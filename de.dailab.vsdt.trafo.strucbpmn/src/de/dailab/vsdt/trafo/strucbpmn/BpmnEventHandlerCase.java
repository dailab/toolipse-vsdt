/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bpmn Event Handler Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getIntermediate <em>Intermediate</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getCompensationElement <em>Compensation Element</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getElementToSkip <em>Element To Skip</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getGateway <em>Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnEventHandlerCase()
 * @model
 * @generated
 */
public interface BpmnEventHandlerCase extends FlowObject {
	/**
	 * Returns the value of the '<em><b>Intermediate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intermediate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate</em>' containment reference.
	 * @see #setIntermediate(Intermediate)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnEventHandlerCase_Intermediate()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Intermediate getIntermediate();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getIntermediate <em>Intermediate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate</em>' containment reference.
	 * @see #getIntermediate()
	 * @generated
	 */
	void setIntermediate(Intermediate value);

	/**
	 * Returns the value of the '<em><b>Compensation Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compensation Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compensation Element</em>' containment reference.
	 * @see #setCompensationElement(FlowObject)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnEventHandlerCase_CompensationElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FlowObject getCompensationElement();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getCompensationElement <em>Compensation Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Compensation Element</em>' containment reference.
	 * @see #getCompensationElement()
	 * @generated
	 */
	void setCompensationElement(FlowObject value);

	/**
	 * Returns the value of the '<em><b>Element To Skip</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getEventHandlerCase <em>Event Handler Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element To Skip</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element To Skip</em>' reference.
	 * @see #setElementToSkip(BpmnElementToSkip)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnEventHandlerCase_ElementToSkip()
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getEventHandlerCase
	 * @model opposite="eventHandlerCase"
	 * @generated
	 */
	BpmnElementToSkip getElementToSkip();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getElementToSkip <em>Element To Skip</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element To Skip</em>' reference.
	 * @see #getElementToSkip()
	 * @generated
	 */
	void setElementToSkip(BpmnElementToSkip value);

	/**
	 * Returns the value of the '<em><b>Gateway</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateway</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateway</em>' reference.
	 * @see #setGateway(Gateway)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnEventHandlerCase_Gateway()
	 * @model
	 * @generated
	 */
	Gateway getGateway();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getGateway <em>Gateway</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gateway</em>' reference.
	 * @see #getGateway()
	 * @generated
	 */
	void setGateway(Gateway value);

} // BpmnEventHandlerCase
