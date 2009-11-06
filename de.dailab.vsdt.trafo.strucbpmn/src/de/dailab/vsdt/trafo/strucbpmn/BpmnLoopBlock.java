/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;

/**
 * <!-- begin-user-doc -->
 * The BpmnLoopBlock (BLB) represents a BPMN Loop Structure made up with gateways and interconnected flow objects instead
 * of a looping activity. The first and second elements of the BLB are the flow objects -- in most cases sequences -- that
 * span between the gateways. Since the first element, spanning from the first gateway to the second, has to be executed at
 * least once, it has to be inserted before the loop in case the target language does not provide a do-while kind
 * of loop. The loop body in made up of the second element followed by the first (in this order!).
 * <br>
 * The loopCondition and exitCondition can be extracted from the looping and the exiting sequence flow. If the looping sequence 
 * flow has a condition, that condition should be used, otherwise the condition of the exiting sequence flow -- the exit condition --
 * should be negated (for a while kind of loop. for a until-kind of loop the loopCondition has to be negated).
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getFirstBranch <em>First Branch</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getSecondBranch <em>Second Branch</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getExitBranch <em>Exit Branch</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getFirstGateway <em>First Gateway</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getSecondGateway <em>Second Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnLoopBlock()
 * @model
 * @generated
 */
public interface BpmnLoopBlock extends FlowObject {
	/**
	 * Returns the value of the '<em><b>First Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>First Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>First Branch</em>' containment reference.
	 * @see #setFirstBranch(BpmnBranch)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnLoopBlock_FirstBranch()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BpmnBranch getFirstBranch();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getFirstBranch <em>First Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>First Branch</em>' containment reference.
	 * @see #getFirstBranch()
	 * @generated
	 */
	void setFirstBranch(BpmnBranch value);

	/**
	 * Returns the value of the '<em><b>Second Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Second Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second Branch</em>' containment reference.
	 * @see #setSecondBranch(BpmnBranch)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnLoopBlock_SecondBranch()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BpmnBranch getSecondBranch();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getSecondBranch <em>Second Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Branch</em>' containment reference.
	 * @see #getSecondBranch()
	 * @generated
	 */
	void setSecondBranch(BpmnBranch value);

	/**
	 * Returns the value of the '<em><b>Exit Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Branch</em>' containment reference.
	 * @see #setExitBranch(BpmnBranch)
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnLoopBlock_ExitBranch()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BpmnBranch getExitBranch();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getExitBranch <em>Exit Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Branch</em>' containment reference.
	 * @see #getExitBranch()
	 * @generated
	 */
	void setExitBranch(BpmnBranch value);

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
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnLoopBlock_FirstGateway()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Gateway getFirstGateway();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getFirstGateway <em>First Gateway</em>}' containment reference.
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
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#getBpmnLoopBlock_SecondGateway()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Gateway getSecondGateway();

	/**
	 * Sets the value of the '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getSecondGateway <em>Second Gateway</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second Gateway</em>' containment reference.
	 * @see #getSecondGateway()
	 * @generated
	 */
	void setSecondGateway(Gateway value);

} // BpmnLoopBlock
