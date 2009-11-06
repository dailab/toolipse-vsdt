/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StrucBpmnFactoryImpl extends EFactoryImpl implements StrucBpmnFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static StrucBpmnFactory init() {
		try {
			StrucBpmnFactory theStrucBpmnFactory = (StrucBpmnFactory)EPackage.Registry.INSTANCE.getEFactory("http://de.dailab.vsdt.trafo.strucbpmn"); 
			if (theStrucBpmnFactory != null) {
				return theStrucBpmnFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new StrucBpmnFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrucBpmnFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case StrucBpmnPackage.BPMN_SEQUENCE: return createBpmnSequence();
			case StrucBpmnPackage.BPMN_BLOCK: return createBpmnBlock();
			case StrucBpmnPackage.BPMN_BRANCH: return createBpmnBranch();
			case StrucBpmnPackage.BPMN_LOOP_BLOCK: return createBpmnLoopBlock();
			case StrucBpmnPackage.BPMN_DERIVED_PROCESS: return createBpmnDerivedProcess();
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_BLOCK: return createBpmnEventHandlerBlock();
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE: return createBpmnEventHandlerCase();
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP: return createBpmnElementToSkip();
			case StrucBpmnPackage.DISJUNCTIVE_EXPRESSION: return createDisjunctiveExpression();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnSequence createBpmnSequence() {
		BpmnSequenceImpl bpmnSequence = new BpmnSequenceImpl();
		return bpmnSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnBlock createBpmnBlock() {
		BpmnBlockImpl bpmnBlock = new BpmnBlockImpl();
		return bpmnBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnBranch createBpmnBranch() {
		BpmnBranchImpl bpmnBranch = new BpmnBranchImpl();
		return bpmnBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnLoopBlock createBpmnLoopBlock() {
		BpmnLoopBlockImpl bpmnLoopBlock = new BpmnLoopBlockImpl();
		return bpmnLoopBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnDerivedProcess createBpmnDerivedProcess() {
		BpmnDerivedProcessImpl bpmnDerivedProcess = new BpmnDerivedProcessImpl();
		return bpmnDerivedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnEventHandlerBlock createBpmnEventHandlerBlock() {
		BpmnEventHandlerBlockImpl bpmnEventHandlerBlock = new BpmnEventHandlerBlockImpl();
		return bpmnEventHandlerBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnEventHandlerCase createBpmnEventHandlerCase() {
		BpmnEventHandlerCaseImpl bpmnEventHandlerCase = new BpmnEventHandlerCaseImpl();
		return bpmnEventHandlerCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnElementToSkip createBpmnElementToSkip() {
		BpmnElementToSkipImpl bpmnElementToSkip = new BpmnElementToSkipImpl();
		return bpmnElementToSkip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DisjunctiveExpression createDisjunctiveExpression() {
		DisjunctiveExpressionImpl disjunctiveExpression = new DisjunctiveExpressionImpl();
		return disjunctiveExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrucBpmnPackage getStrucBpmnPackage() {
		return (StrucBpmnPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static StrucBpmnPackage getPackage() {
		return StrucBpmnPackage.eINSTANCE;
	}

} //StrucBpmnFactoryImpl
