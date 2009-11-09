/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.dailab.vsdt.VsdtPackage;
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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StrucBpmnPackageImpl extends EPackageImpl implements StrucBpmnPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpmnSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpmnBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpmnBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpmnLoopBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpmnDerivedProcessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpmnEventHandlerBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpmnEventHandlerCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bpmnElementToSkipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass disjunctiveExpressionEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private StrucBpmnPackageImpl() {
		super(eNS_URI, StrucBpmnFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static StrucBpmnPackage init() {
		if (isInited) return (StrucBpmnPackage)EPackage.Registry.INSTANCE.getEPackage(StrucBpmnPackage.eNS_URI);

		// Obtain or create and register package
		StrucBpmnPackageImpl theStrucBpmnPackage = (StrucBpmnPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof StrucBpmnPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new StrucBpmnPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		VsdtPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theStrucBpmnPackage.createPackageContents();

		// Initialize created meta-data
		theStrucBpmnPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theStrucBpmnPackage.freeze();

		return theStrucBpmnPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBpmnSequence() {
		return bpmnSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnSequence_Elements() {
		return (EReference)bpmnSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBpmnSequence_NeedsToPersist() {
		return (EAttribute)bpmnSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBpmnBlock() {
		return bpmnBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnBlock_Elements() {
		return (EReference)bpmnBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnBlock_FirstGateway() {
		return (EReference)bpmnBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnBlock_SecondGateway() {
		return (EReference)bpmnBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBpmnBranch() {
		return bpmnBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnBranch_Element() {
		return (EReference)bpmnBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnBranch_Condition() {
		return (EReference)bpmnBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBpmnBranch_Default() {
		return (EAttribute)bpmnBranchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBpmnLoopBlock() {
		return bpmnLoopBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnLoopBlock_FirstBranch() {
		return (EReference)bpmnLoopBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnLoopBlock_SecondBranch() {
		return (EReference)bpmnLoopBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnLoopBlock_ExitBranch() {
		return (EReference)bpmnLoopBlockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnLoopBlock_FirstGateway() {
		return (EReference)bpmnLoopBlockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnLoopBlock_SecondGateway() {
		return (EReference)bpmnLoopBlockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBpmnDerivedProcess() {
		return bpmnDerivedProcessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnDerivedProcess_Element() {
		return (EReference)bpmnDerivedProcessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBpmnDerivedProcess_ProcessName() {
		return (EAttribute)bpmnDerivedProcessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBpmnDerivedProcess_WaitForCompletion() {
		return (EAttribute)bpmnDerivedProcessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBpmnEventHandlerBlock() {
		return bpmnEventHandlerBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnEventHandlerBlock_EventHandlerCases() {
		return (EReference)bpmnEventHandlerBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnEventHandlerBlock_Activity() {
		return (EReference)bpmnEventHandlerBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBpmnEventHandlerCase() {
		return bpmnEventHandlerCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnEventHandlerCase_Intermediate() {
		return (EReference)bpmnEventHandlerCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnEventHandlerCase_CompensationElement() {
		return (EReference)bpmnEventHandlerCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnEventHandlerCase_ElementToSkip() {
		return (EReference)bpmnEventHandlerCaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnEventHandlerCase_Gateway() {
		return (EReference)bpmnEventHandlerCaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBpmnElementToSkip() {
		return bpmnElementToSkipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnElementToSkip_Element() {
		return (EReference)bpmnElementToSkipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBpmnElementToSkip_VariableName() {
		return (EAttribute)bpmnElementToSkipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBpmnElementToSkip_EventHandlerCase() {
		return (EReference)bpmnElementToSkipEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDisjunctiveExpression() {
		return disjunctiveExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDisjunctiveExpression_Expressions() {
		return (EAttribute)disjunctiveExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StrucBpmnFactory getStrucBpmnFactory() {
		return (StrucBpmnFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		bpmnSequenceEClass = createEClass(BPMN_SEQUENCE);
		createEReference(bpmnSequenceEClass, BPMN_SEQUENCE__ELEMENTS);
		createEAttribute(bpmnSequenceEClass, BPMN_SEQUENCE__NEEDS_TO_PERSIST);

		bpmnBlockEClass = createEClass(BPMN_BLOCK);
		createEReference(bpmnBlockEClass, BPMN_BLOCK__ELEMENTS);
		createEReference(bpmnBlockEClass, BPMN_BLOCK__FIRST_GATEWAY);
		createEReference(bpmnBlockEClass, BPMN_BLOCK__SECOND_GATEWAY);

		bpmnBranchEClass = createEClass(BPMN_BRANCH);
		createEReference(bpmnBranchEClass, BPMN_BRANCH__ELEMENT);
		createEReference(bpmnBranchEClass, BPMN_BRANCH__CONDITION);
		createEAttribute(bpmnBranchEClass, BPMN_BRANCH__DEFAULT);

		bpmnLoopBlockEClass = createEClass(BPMN_LOOP_BLOCK);
		createEReference(bpmnLoopBlockEClass, BPMN_LOOP_BLOCK__FIRST_BRANCH);
		createEReference(bpmnLoopBlockEClass, BPMN_LOOP_BLOCK__SECOND_BRANCH);
		createEReference(bpmnLoopBlockEClass, BPMN_LOOP_BLOCK__EXIT_BRANCH);
		createEReference(bpmnLoopBlockEClass, BPMN_LOOP_BLOCK__FIRST_GATEWAY);
		createEReference(bpmnLoopBlockEClass, BPMN_LOOP_BLOCK__SECOND_GATEWAY);

		bpmnDerivedProcessEClass = createEClass(BPMN_DERIVED_PROCESS);
		createEReference(bpmnDerivedProcessEClass, BPMN_DERIVED_PROCESS__ELEMENT);
		createEAttribute(bpmnDerivedProcessEClass, BPMN_DERIVED_PROCESS__PROCESS_NAME);
		createEAttribute(bpmnDerivedProcessEClass, BPMN_DERIVED_PROCESS__WAIT_FOR_COMPLETION);

		bpmnEventHandlerBlockEClass = createEClass(BPMN_EVENT_HANDLER_BLOCK);
		createEReference(bpmnEventHandlerBlockEClass, BPMN_EVENT_HANDLER_BLOCK__EVENT_HANDLER_CASES);
		createEReference(bpmnEventHandlerBlockEClass, BPMN_EVENT_HANDLER_BLOCK__ACTIVITY);

		bpmnEventHandlerCaseEClass = createEClass(BPMN_EVENT_HANDLER_CASE);
		createEReference(bpmnEventHandlerCaseEClass, BPMN_EVENT_HANDLER_CASE__INTERMEDIATE);
		createEReference(bpmnEventHandlerCaseEClass, BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT);
		createEReference(bpmnEventHandlerCaseEClass, BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP);
		createEReference(bpmnEventHandlerCaseEClass, BPMN_EVENT_HANDLER_CASE__GATEWAY);

		bpmnElementToSkipEClass = createEClass(BPMN_ELEMENT_TO_SKIP);
		createEReference(bpmnElementToSkipEClass, BPMN_ELEMENT_TO_SKIP__ELEMENT);
		createEAttribute(bpmnElementToSkipEClass, BPMN_ELEMENT_TO_SKIP__VARIABLE_NAME);
		createEReference(bpmnElementToSkipEClass, BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE);

		disjunctiveExpressionEClass = createEClass(DISJUNCTIVE_EXPRESSION);
		createEAttribute(disjunctiveExpressionEClass, DISJUNCTIVE_EXPRESSION__EXPRESSIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		VsdtPackage theVsdtPackage = (VsdtPackage)EPackage.Registry.INSTANCE.getEPackage(VsdtPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bpmnSequenceEClass.getESuperTypes().add(theVsdtPackage.getFlowObject());
		bpmnBlockEClass.getESuperTypes().add(theVsdtPackage.getFlowObject());
		bpmnBranchEClass.getESuperTypes().add(theVsdtPackage.getFlowObject());
		bpmnLoopBlockEClass.getESuperTypes().add(theVsdtPackage.getFlowObject());
		bpmnDerivedProcessEClass.getESuperTypes().add(theVsdtPackage.getFlowObject());
		bpmnEventHandlerBlockEClass.getESuperTypes().add(theVsdtPackage.getFlowObject());
		bpmnEventHandlerCaseEClass.getESuperTypes().add(theVsdtPackage.getFlowObject());
		bpmnElementToSkipEClass.getESuperTypes().add(theVsdtPackage.getFlowObject());
		disjunctiveExpressionEClass.getESuperTypes().add(theVsdtPackage.getExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(bpmnSequenceEClass, BpmnSequence.class, "BpmnSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBpmnSequence_Elements(), theVsdtPackage.getFlowObject(), null, "elements", null, 0, -1, BpmnSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBpmnSequence_NeedsToPersist(), ecorePackage.getEBoolean(), "needsToPersist", null, 0, 1, BpmnSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bpmnBlockEClass, BpmnBlock.class, "BpmnBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBpmnBlock_Elements(), this.getBpmnBranch(), null, "elements", null, 0, -1, BpmnBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnBlock_FirstGateway(), theVsdtPackage.getGateway(), null, "firstGateway", null, 1, 1, BpmnBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnBlock_SecondGateway(), theVsdtPackage.getGateway(), null, "secondGateway", null, 1, 1, BpmnBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(bpmnBlockEClass, theVsdtPackage.getFlowObject(), "getDefaultElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bpmnBranchEClass, BpmnBranch.class, "BpmnBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBpmnBranch_Element(), theVsdtPackage.getFlowObject(), null, "element", null, 1, 1, BpmnBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnBranch_Condition(), theVsdtPackage.getExpression(), null, "condition", null, 0, 1, BpmnBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBpmnBranch_Default(), ecorePackage.getEBoolean(), "default", null, 0, 1, BpmnBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bpmnLoopBlockEClass, BpmnLoopBlock.class, "BpmnLoopBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBpmnLoopBlock_FirstBranch(), this.getBpmnBranch(), null, "firstBranch", null, 1, 1, BpmnLoopBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnLoopBlock_SecondBranch(), this.getBpmnBranch(), null, "secondBranch", null, 1, 1, BpmnLoopBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnLoopBlock_ExitBranch(), this.getBpmnBranch(), null, "exitBranch", null, 1, 1, BpmnLoopBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnLoopBlock_FirstGateway(), theVsdtPackage.getGateway(), null, "firstGateway", null, 1, 1, BpmnLoopBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnLoopBlock_SecondGateway(), theVsdtPackage.getGateway(), null, "secondGateway", null, 1, 1, BpmnLoopBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bpmnDerivedProcessEClass, BpmnDerivedProcess.class, "BpmnDerivedProcess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBpmnDerivedProcess_Element(), theVsdtPackage.getFlowObject(), null, "element", null, 1, 1, BpmnDerivedProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBpmnDerivedProcess_ProcessName(), ecorePackage.getEString(), "processName", null, 1, 1, BpmnDerivedProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBpmnDerivedProcess_WaitForCompletion(), ecorePackage.getEBoolean(), "waitForCompletion", "true", 0, 1, BpmnDerivedProcess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bpmnEventHandlerBlockEClass, BpmnEventHandlerBlock.class, "BpmnEventHandlerBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBpmnEventHandlerBlock_EventHandlerCases(), this.getBpmnEventHandlerCase(), null, "eventHandlerCases", null, 0, -1, BpmnEventHandlerBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnEventHandlerBlock_Activity(), theVsdtPackage.getActivity(), null, "activity", null, 1, 1, BpmnEventHandlerBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bpmnEventHandlerCaseEClass, BpmnEventHandlerCase.class, "BpmnEventHandlerCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBpmnEventHandlerCase_Intermediate(), theVsdtPackage.getIntermediate(), null, "intermediate", null, 1, 1, BpmnEventHandlerCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnEventHandlerCase_CompensationElement(), theVsdtPackage.getFlowObject(), null, "compensationElement", null, 1, 1, BpmnEventHandlerCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnEventHandlerCase_ElementToSkip(), this.getBpmnElementToSkip(), this.getBpmnElementToSkip_EventHandlerCase(), "elementToSkip", null, 0, 1, BpmnEventHandlerCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnEventHandlerCase_Gateway(), theVsdtPackage.getGateway(), null, "gateway", null, 0, 1, BpmnEventHandlerCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bpmnElementToSkipEClass, BpmnElementToSkip.class, "BpmnElementToSkip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBpmnElementToSkip_Element(), theVsdtPackage.getFlowObject(), null, "element", null, 1, 1, BpmnElementToSkip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBpmnElementToSkip_VariableName(), ecorePackage.getEString(), "variableName", null, 0, 1, BpmnElementToSkip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBpmnElementToSkip_EventHandlerCase(), this.getBpmnEventHandlerCase(), this.getBpmnEventHandlerCase_ElementToSkip(), "eventHandlerCase", null, 0, 1, BpmnElementToSkip.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(disjunctiveExpressionEClass, DisjunctiveExpression.class, "DisjunctiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDisjunctiveExpression_Expressions(), ecorePackage.getEString(), "expressions", null, 0, -1, DisjunctiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //StrucBpmnPackageImpl
