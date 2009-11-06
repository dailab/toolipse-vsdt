/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import org.eclipse.emf.common.util.EList;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.FlowObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bpmn Event Handler Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock#getEventHandlerCases <em>Event Handler Cases</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock#getActivity <em>Activity</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnEventHandlerBlock()
 * @model
 * @generated
 */
public interface BpmnEventHandlerBlock extends FlowObject {
	/**
	 * Returns the value of the '<em><b>Event Handler Cases</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event Handler Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event Handler Cases</em>' containment reference list.
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnEventHandlerBlock_EventHandlerCases()
	 * @model containment="true"
	 * @generated
	 */
	EList<BpmnEventHandlerCase> getEventHandlerCases();

	/**
	 * Returns the value of the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' containment reference.
	 * @see #setActivity(Activity)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnEventHandlerBlock_Activity()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock#getActivity <em>Activity</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' containment reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

} // BpmnEventHandlerBlock
