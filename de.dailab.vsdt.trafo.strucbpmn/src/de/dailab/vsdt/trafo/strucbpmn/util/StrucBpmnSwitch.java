/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.GraphicalObject;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Node;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage
 * @generated
 */
public class StrucBpmnSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StrucBpmnPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrucBpmnSwitch() {
		if (modelPackage == null) {
			modelPackage = StrucBpmnPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StrucBpmnPackage.BPMN_SEQUENCE: {
				BpmnSequence bpmnSequence = (BpmnSequence)theEObject;
				T result = caseBpmnSequence(bpmnSequence);
				if (result == null) result = caseFlowObject(bpmnSequence);
				if (result == null) result = caseNode(bpmnSequence);
				if (result == null) result = caseGraphicalObject(bpmnSequence);
				if (result == null) result = caseIdObject(bpmnSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrucBpmnPackage.BPMN_BLOCK: {
				BpmnBlock bpmnBlock = (BpmnBlock)theEObject;
				T result = caseBpmnBlock(bpmnBlock);
				if (result == null) result = caseFlowObject(bpmnBlock);
				if (result == null) result = caseNode(bpmnBlock);
				if (result == null) result = caseGraphicalObject(bpmnBlock);
				if (result == null) result = caseIdObject(bpmnBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrucBpmnPackage.BPMN_BRANCH: {
				BpmnBranch bpmnBranch = (BpmnBranch)theEObject;
				T result = caseBpmnBranch(bpmnBranch);
				if (result == null) result = caseFlowObject(bpmnBranch);
				if (result == null) result = caseNode(bpmnBranch);
				if (result == null) result = caseGraphicalObject(bpmnBranch);
				if (result == null) result = caseIdObject(bpmnBranch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrucBpmnPackage.BPMN_LOOP_BLOCK: {
				BpmnLoopBlock bpmnLoopBlock = (BpmnLoopBlock)theEObject;
				T result = caseBpmnLoopBlock(bpmnLoopBlock);
				if (result == null) result = caseFlowObject(bpmnLoopBlock);
				if (result == null) result = caseNode(bpmnLoopBlock);
				if (result == null) result = caseGraphicalObject(bpmnLoopBlock);
				if (result == null) result = caseIdObject(bpmnLoopBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrucBpmnPackage.BPMN_DERIVED_PROCESS: {
				BpmnDerivedProcess bpmnDerivedProcess = (BpmnDerivedProcess)theEObject;
				T result = caseBpmnDerivedProcess(bpmnDerivedProcess);
				if (result == null) result = caseFlowObject(bpmnDerivedProcess);
				if (result == null) result = caseNode(bpmnDerivedProcess);
				if (result == null) result = caseGraphicalObject(bpmnDerivedProcess);
				if (result == null) result = caseIdObject(bpmnDerivedProcess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_BLOCK: {
				BpmnEventHandlerBlock bpmnEventHandlerBlock = (BpmnEventHandlerBlock)theEObject;
				T result = caseBpmnEventHandlerBlock(bpmnEventHandlerBlock);
				if (result == null) result = caseFlowObject(bpmnEventHandlerBlock);
				if (result == null) result = caseNode(bpmnEventHandlerBlock);
				if (result == null) result = caseGraphicalObject(bpmnEventHandlerBlock);
				if (result == null) result = caseIdObject(bpmnEventHandlerBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE: {
				BpmnEventHandlerCase bpmnEventHandlerCase = (BpmnEventHandlerCase)theEObject;
				T result = caseBpmnEventHandlerCase(bpmnEventHandlerCase);
				if (result == null) result = caseFlowObject(bpmnEventHandlerCase);
				if (result == null) result = caseNode(bpmnEventHandlerCase);
				if (result == null) result = caseGraphicalObject(bpmnEventHandlerCase);
				if (result == null) result = caseIdObject(bpmnEventHandlerCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP: {
				BpmnElementToSkip bpmnElementToSkip = (BpmnElementToSkip)theEObject;
				T result = caseBpmnElementToSkip(bpmnElementToSkip);
				if (result == null) result = caseFlowObject(bpmnElementToSkip);
				if (result == null) result = caseNode(bpmnElementToSkip);
				if (result == null) result = caseGraphicalObject(bpmnElementToSkip);
				if (result == null) result = caseIdObject(bpmnElementToSkip);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StrucBpmnPackage.DISJUNCTIVE_EXPRESSION: {
				DisjunctiveExpression disjunctiveExpression = (DisjunctiveExpression)theEObject;
				T result = caseDisjunctiveExpression(disjunctiveExpression);
				if (result == null) result = caseExpression(disjunctiveExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bpmn Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bpmn Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBpmnSequence(BpmnSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bpmn Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bpmn Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBpmnBlock(BpmnBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bpmn Branch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bpmn Branch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBpmnBranch(BpmnBranch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bpmn Loop Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bpmn Loop Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBpmnLoopBlock(BpmnLoopBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bpmn Derived Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bpmn Derived Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBpmnDerivedProcess(BpmnDerivedProcess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bpmn Event Handler Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bpmn Event Handler Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBpmnEventHandlerBlock(BpmnEventHandlerBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bpmn Event Handler Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bpmn Event Handler Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBpmnEventHandlerCase(BpmnEventHandlerCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bpmn Element To Skip</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bpmn Element To Skip</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBpmnElementToSkip(BpmnElementToSkip object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Disjunctive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Disjunctive Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDisjunctiveExpression(DisjunctiveExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Id Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Id Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdObject(IdObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graphical Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graphical Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraphicalObject(GraphicalObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Flow Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Flow Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFlowObject(FlowObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //StrucBpmnSwitch
