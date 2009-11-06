/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import org.eclipse.emf.common.util.EList;

import de.dailab.vsdt.FlowObject;

/**
 * <!-- begin-user-doc -->
 * The BpmnSequence (BS) is intended to represent a sequence of other FlowObjects. Being a FlowObject itself, the
 * BS can be wrapped in other structured elements. During transformation, the sequence flows connecting the objects 
 * that are combined to one sequence can be omitted and the sequence flows going to the objects should be reconnected
 * to the BS.
 * <br>
 * The field needsToPersist can be used to avoid the 'flattening' of sequences, so that if two sequences are in sequence
 * and one of them 'needs to persist', the sequence itself will be inserted into the new sequence and not its elements. 
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnSequence#getElements <em>Elements</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnSequence#isNeedsToPersist <em>Needs To Persist</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnSequence()
 * @model
 * @generated
 */
public interface BpmnSequence extends FlowObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.vsdt.FlowObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnSequence_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<FlowObject> getElements();

	/**
	 * Returns the value of the '<em><b>Needs To Persist</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Needs To Persist</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Needs To Persist</em>' attribute.
	 * @see #setNeedsToPersist(boolean)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnSequence_NeedsToPersist()
	 * @model
	 * @generated
	 */
	boolean isNeedsToPersist();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnSequence#isNeedsToPersist <em>Needs To Persist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Needs To Persist</em>' attribute.
	 * @see #isNeedsToPersist()
	 * @generated
	 */
	void setNeedsToPersist(boolean value);

} // BpmnSequence
