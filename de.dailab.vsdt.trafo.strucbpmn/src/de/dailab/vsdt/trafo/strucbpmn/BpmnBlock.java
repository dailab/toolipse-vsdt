/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import org.eclipse.emf.common.util.EList;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;

/**
 * <!-- begin-user-doc -->
 * The BpmnBlock (BB) represents a block being made up of normally two gateways and an arbitrary number of (complex) flow
 * objects spanning from the first to the second gateway. Depending on the gateway's types different block structures
 * have to be created for the target language, although possibly only the first gateway can be taken into account due
 * to restrictions in the target languages expressiveness.
 * <br>
 * In case the branches of the block have conditions, these conditions can be stored in the <code>conditions</code> map
 * for later use in the element mapping. If the block has a default element, this element should be specified in the 
 * field of the same name, so it can be identified later (although this would be possible using the map only, too).
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getElements <em>Elements</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getFirstGateway <em>First Gateway</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getSecondGateway <em>Second Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnBlock()
 * @model
 * @generated
 */
public interface BpmnBlock extends FlowObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnBlock_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<BpmnBranch> getElements();

	/**
	 * Returns the value of the '<em><b>First Gateway</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Gateway</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Gateway</em>' containment reference.
	 * @see #setFirstGateway(Gateway)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnBlock_FirstGateway()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Gateway getFirstGateway();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getFirstGateway <em>First Gateway</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Gateway</em>' containment reference.
	 * @see #getFirstGateway()
	 * @generated
	 */
	void setFirstGateway(Gateway value);

	/**
	 * Returns the value of the '<em><b>Second Gateway</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Gateway</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Gateway</em>' containment reference.
	 * @see #setSecondGateway(Gateway)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnBlock_SecondGateway()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Gateway getSecondGateway();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getSecondGateway <em>Second Gateway</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Gateway</em>' containment reference.
	 * @see #getSecondGateway()
	 * @generated
	 */
	void setSecondGateway(Gateway value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	FlowObject getDefaultElement();

} // BpmnBlock
