/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage
 * @generated
 */
public class StrucBpmnAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StrucBpmnPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrucBpmnAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StrucBpmnPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StrucBpmnSwitch<Adapter> modelSwitch =
		new StrucBpmnSwitch<Adapter>() {
			@Override
			public Adapter caseBpmnSequence(BpmnSequence object) {
				return createBpmnSequenceAdapter();
			}
			@Override
			public Adapter caseBpmnBlock(BpmnBlock object) {
				return createBpmnBlockAdapter();
			}
			@Override
			public Adapter caseBpmnBranch(BpmnBranch object) {
				return createBpmnBranchAdapter();
			}
			@Override
			public Adapter caseBpmnLoopBlock(BpmnLoopBlock object) {
				return createBpmnLoopBlockAdapter();
			}
			@Override
			public Adapter caseBpmnDerivedProcess(BpmnDerivedProcess object) {
				return createBpmnDerivedProcessAdapter();
			}
			@Override
			public Adapter caseBpmnEventHandlerBlock(BpmnEventHandlerBlock object) {
				return createBpmnEventHandlerBlockAdapter();
			}
			@Override
			public Adapter caseBpmnEventHandlerCase(BpmnEventHandlerCase object) {
				return createBpmnEventHandlerCaseAdapter();
			}
			@Override
			public Adapter caseBpmnElementToSkip(BpmnElementToSkip object) {
				return createBpmnElementToSkipAdapter();
			}
			@Override
			public Adapter caseDisjunctiveExpression(DisjunctiveExpression object) {
				return createDisjunctiveExpressionAdapter();
			}
			@Override
			public Adapter caseIdObject(IdObject object) {
				return createIdObjectAdapter();
			}
			@Override
			public Adapter caseGraphicalObject(GraphicalObject object) {
				return createGraphicalObjectAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseFlowObject(FlowObject object) {
				return createFlowObjectAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnSequence <em>Bpmn Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnSequence
	 * @generated
	 */
	public Adapter createBpmnSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock <em>Bpmn Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBlock
	 * @generated
	 */
	public Adapter createBpmnBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch <em>Bpmn Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBranch
	 * @generated
	 */
	public Adapter createBpmnBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock <em>Bpmn Loop Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock
	 * @generated
	 */
	public Adapter createBpmnLoopBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess <em>Bpmn Derived Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess
	 * @generated
	 */
	public Adapter createBpmnDerivedProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock <em>Bpmn Event Handler Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock
	 * @generated
	 */
	public Adapter createBpmnEventHandlerBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase <em>Bpmn Event Handler Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase
	 * @generated
	 */
	public Adapter createBpmnEventHandlerCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip <em>Bpmn Element To Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip
	 * @generated
	 */
	public Adapter createBpmnElementToSkipAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression <em>Disjunctive Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression
	 * @generated
	 */
	public Adapter createDisjunctiveExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.IdObject <em>Id Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.IdObject
	 * @generated
	 */
	public Adapter createIdObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.GraphicalObject <em>Graphical Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.GraphicalObject
	 * @generated
	 */
	public Adapter createGraphicalObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.FlowObject <em>Flow Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.FlowObject
	 * @generated
	 */
	public Adapter createFlowObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.vsdt.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.vsdt.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //StrucBpmnAdapterFactory
