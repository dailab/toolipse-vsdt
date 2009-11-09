/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage
 * @generated
 */
public interface StrucBpmnFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StrucBpmnFactory eINSTANCE = de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Bpmn Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bpmn Sequence</em>'.
	 * @generated
	 */
	BpmnSequence createBpmnSequence();

	/**
	 * Returns a new object of class '<em>Bpmn Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bpmn Block</em>'.
	 * @generated
	 */
	BpmnBlock createBpmnBlock();

	/**
	 * Returns a new object of class '<em>Bpmn Branch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bpmn Branch</em>'.
	 * @generated
	 */
	BpmnBranch createBpmnBranch();

	/**
	 * Returns a new object of class '<em>Bpmn Loop Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bpmn Loop Block</em>'.
	 * @generated
	 */
	BpmnLoopBlock createBpmnLoopBlock();

	/**
	 * Returns a new object of class '<em>Bpmn Derived Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bpmn Derived Process</em>'.
	 * @generated
	 */
	BpmnDerivedProcess createBpmnDerivedProcess();

	/**
	 * Returns a new object of class '<em>Bpmn Event Handler Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bpmn Event Handler Block</em>'.
	 * @generated
	 */
	BpmnEventHandlerBlock createBpmnEventHandlerBlock();

	/**
	 * Returns a new object of class '<em>Bpmn Event Handler Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bpmn Event Handler Case</em>'.
	 * @generated
	 */
	BpmnEventHandlerCase createBpmnEventHandlerCase();

	/**
	 * Returns a new object of class '<em>Bpmn Element To Skip</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bpmn Element To Skip</em>'.
	 * @generated
	 */
	BpmnElementToSkip createBpmnElementToSkip();

	/**
	 * Returns a new object of class '<em>Disjunctive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Disjunctive Expression</em>'.
	 * @generated
	 */
	DisjunctiveExpression createDisjunctiveExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StrucBpmnPackage getStrucBpmnPackage();

} //StrucBpmnFactory
