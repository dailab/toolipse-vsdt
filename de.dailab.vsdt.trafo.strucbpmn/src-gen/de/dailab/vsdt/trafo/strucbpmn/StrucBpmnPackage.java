/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.dailab.vsdt.trafo.strucbpmn.StrucBpmnFactory
 * @model kind="package"
 * @generated
 */
public interface StrucBpmnPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "strucbpmn";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://de.dailab.vsdt.trafo.strucbpmn";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "strucbpmn";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StrucBpmnPackage eINSTANCE = de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnSequenceImpl <em>Bpmn Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnSequenceImpl
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnSequence()
	 * @generated
	 */
	int BPMN_SEQUENCE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__NAME = VsdtPackage.FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__DOCUMENTATION = VsdtPackage.FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__ID = VsdtPackage.FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__OUTGOING_ASS = VsdtPackage.FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__INCOMING_ASS = VsdtPackage.FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__OUTGOING_MSG = VsdtPackage.FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__INCOMING_MSG = VsdtPackage.FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__PARENT = VsdtPackage.FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__ASSIGNMENTS = VsdtPackage.FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__OUTGOING_SEQ = VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__INCOMING_SEQ = VsdtPackage.FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__ELEMENTS = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Needs To Persist</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE__NEEDS_TO_PERSIST = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bpmn Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_SEQUENCE_FEATURE_COUNT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBlockImpl <em>Bpmn Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBlockImpl
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnBlock()
	 * @generated
	 */
	int BPMN_BLOCK = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__NAME = VsdtPackage.FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__DOCUMENTATION = VsdtPackage.FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__ID = VsdtPackage.FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__OUTGOING_ASS = VsdtPackage.FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__INCOMING_ASS = VsdtPackage.FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__OUTGOING_MSG = VsdtPackage.FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__INCOMING_MSG = VsdtPackage.FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__PARENT = VsdtPackage.FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__ASSIGNMENTS = VsdtPackage.FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__OUTGOING_SEQ = VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__INCOMING_SEQ = VsdtPackage.FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__ELEMENTS = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>First Gateway</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__FIRST_GATEWAY = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Second Gateway</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK__SECOND_GATEWAY = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bpmn Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BLOCK_FEATURE_COUNT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBranchImpl <em>Bpmn Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBranchImpl
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnBranch()
	 * @generated
	 */
	int BPMN_BRANCH = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__NAME = VsdtPackage.FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__DOCUMENTATION = VsdtPackage.FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__ID = VsdtPackage.FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__OUTGOING_ASS = VsdtPackage.FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__INCOMING_ASS = VsdtPackage.FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__OUTGOING_MSG = VsdtPackage.FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__INCOMING_MSG = VsdtPackage.FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__PARENT = VsdtPackage.FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__ASSIGNMENTS = VsdtPackage.FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__OUTGOING_SEQ = VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__INCOMING_SEQ = VsdtPackage.FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__ELEMENT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__CONDITION = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH__DEFAULT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bpmn Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_BRANCH_FEATURE_COUNT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnLoopBlockImpl <em>Bpmn Loop Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnLoopBlockImpl
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnLoopBlock()
	 * @generated
	 */
	int BPMN_LOOP_BLOCK = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__NAME = VsdtPackage.FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__DOCUMENTATION = VsdtPackage.FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__ID = VsdtPackage.FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__OUTGOING_ASS = VsdtPackage.FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__INCOMING_ASS = VsdtPackage.FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__OUTGOING_MSG = VsdtPackage.FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__INCOMING_MSG = VsdtPackage.FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__PARENT = VsdtPackage.FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__ASSIGNMENTS = VsdtPackage.FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__OUTGOING_SEQ = VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__INCOMING_SEQ = VsdtPackage.FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>First Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__FIRST_BRANCH = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Second Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__SECOND_BRANCH = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exit Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__EXIT_BRANCH = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>First Gateway</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__FIRST_GATEWAY = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Second Gateway</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK__SECOND_GATEWAY = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Bpmn Loop Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_LOOP_BLOCK_FEATURE_COUNT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnDerivedProcessImpl <em>Bpmn Derived Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnDerivedProcessImpl
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnDerivedProcess()
	 * @generated
	 */
	int BPMN_DERIVED_PROCESS = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__NAME = VsdtPackage.FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__DOCUMENTATION = VsdtPackage.FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__ID = VsdtPackage.FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__OUTGOING_ASS = VsdtPackage.FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__INCOMING_ASS = VsdtPackage.FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__OUTGOING_MSG = VsdtPackage.FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__INCOMING_MSG = VsdtPackage.FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__PARENT = VsdtPackage.FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__ASSIGNMENTS = VsdtPackage.FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__OUTGOING_SEQ = VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__INCOMING_SEQ = VsdtPackage.FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__ELEMENT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Process Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__PROCESS_NAME = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Wait For Completion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS__WAIT_FOR_COMPLETION = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bpmn Derived Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_DERIVED_PROCESS_FEATURE_COUNT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerBlockImpl <em>Bpmn Event Handler Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerBlockImpl
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnEventHandlerBlock()
	 * @generated
	 */
	int BPMN_EVENT_HANDLER_BLOCK = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__NAME = VsdtPackage.FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__DOCUMENTATION = VsdtPackage.FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__ID = VsdtPackage.FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__OUTGOING_ASS = VsdtPackage.FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__INCOMING_ASS = VsdtPackage.FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__OUTGOING_MSG = VsdtPackage.FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__INCOMING_MSG = VsdtPackage.FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__PARENT = VsdtPackage.FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__ASSIGNMENTS = VsdtPackage.FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__OUTGOING_SEQ = VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__INCOMING_SEQ = VsdtPackage.FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Event Handler Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__EVENT_HANDLER_CASES = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK__ACTIVITY = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bpmn Event Handler Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_BLOCK_FEATURE_COUNT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerCaseImpl <em>Bpmn Event Handler Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerCaseImpl
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnEventHandlerCase()
	 * @generated
	 */
	int BPMN_EVENT_HANDLER_CASE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__NAME = VsdtPackage.FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__DOCUMENTATION = VsdtPackage.FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__ID = VsdtPackage.FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__OUTGOING_ASS = VsdtPackage.FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__INCOMING_ASS = VsdtPackage.FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__OUTGOING_MSG = VsdtPackage.FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__INCOMING_MSG = VsdtPackage.FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__PARENT = VsdtPackage.FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__ASSIGNMENTS = VsdtPackage.FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__OUTGOING_SEQ = VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__INCOMING_SEQ = VsdtPackage.FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Intermediate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__INTERMEDIATE = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Compensation Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element To Skip</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Gateway</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE__GATEWAY = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Bpmn Event Handler Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_EVENT_HANDLER_CASE_FEATURE_COUNT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 4;


	/**
	 * The meta object id for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnElementToSkipImpl <em>Bpmn Element To Skip</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnElementToSkipImpl
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnElementToSkip()
	 * @generated
	 */
	int BPMN_ELEMENT_TO_SKIP = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__NAME = VsdtPackage.FLOW_OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__DOCUMENTATION = VsdtPackage.FLOW_OBJECT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__ID = VsdtPackage.FLOW_OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Outgoing Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__OUTGOING_ASS = VsdtPackage.FLOW_OBJECT__OUTGOING_ASS;

	/**
	 * The feature id for the '<em><b>Incoming Ass</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__INCOMING_ASS = VsdtPackage.FLOW_OBJECT__INCOMING_ASS;

	/**
	 * The feature id for the '<em><b>Outgoing Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__OUTGOING_MSG = VsdtPackage.FLOW_OBJECT__OUTGOING_MSG;

	/**
	 * The feature id for the '<em><b>Incoming Msg</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__INCOMING_MSG = VsdtPackage.FLOW_OBJECT__INCOMING_MSG;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__PARENT = VsdtPackage.FLOW_OBJECT__PARENT;

	/**
	 * The feature id for the '<em><b>Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__ASSIGNMENTS = VsdtPackage.FLOW_OBJECT__ASSIGNMENTS;

	/**
	 * The feature id for the '<em><b>Outgoing Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__OUTGOING_SEQ = VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ;

	/**
	 * The feature id for the '<em><b>Incoming Seq</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__INCOMING_SEQ = VsdtPackage.FLOW_OBJECT__INCOMING_SEQ;

	/**
	 * The feature id for the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__ELEMENT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__VARIABLE_NAME = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Event Handler Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bpmn Element To Skip</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPMN_ELEMENT_TO_SKIP_FEATURE_COUNT = VsdtPackage.FLOW_OBJECT_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.DisjunctiveExpressionImpl <em>Disjunctive Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.DisjunctiveExpressionImpl
	 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getDisjunctiveExpression()
	 * @generated
	 */
	int DISJUNCTIVE_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJUNCTIVE_EXPRESSION__EXPRESSION = VsdtPackage.EXPRESSION__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJUNCTIVE_EXPRESSION__LANGUAGE = VsdtPackage.EXPRESSION__LANGUAGE;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJUNCTIVE_EXPRESSION__EXPRESSIONS = VsdtPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Disjunctive Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISJUNCTIVE_EXPRESSION_FEATURE_COUNT = VsdtPackage.EXPRESSION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnSequence <em>Bpmn Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bpmn Sequence</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnSequence
	 * @generated
	 */
	EClass getBpmnSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnSequence#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnSequence#getElements()
	 * @see #getBpmnSequence()
	 * @generated
	 */
	EReference getBpmnSequence_Elements();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnSequence#isNeedsToPersist <em>Needs To Persist</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Needs To Persist</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnSequence#isNeedsToPersist()
	 * @see #getBpmnSequence()
	 * @generated
	 */
	EAttribute getBpmnSequence_NeedsToPersist();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock <em>Bpmn Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bpmn Block</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBlock
	 * @generated
	 */
	EClass getBpmnBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getElements()
	 * @see #getBpmnBlock()
	 * @generated
	 */
	EReference getBpmnBlock_Elements();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getFirstGateway <em>First Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Gateway</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getFirstGateway()
	 * @see #getBpmnBlock()
	 * @generated
	 */
	EReference getBpmnBlock_FirstGateway();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getSecondGateway <em>Second Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Second Gateway</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBlock#getSecondGateway()
	 * @see #getBpmnBlock()
	 * @generated
	 */
	EReference getBpmnBlock_SecondGateway();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch <em>Bpmn Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bpmn Branch</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBranch
	 * @generated
	 */
	EClass getBpmnBranch();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#getElement()
	 * @see #getBpmnBranch()
	 * @generated
	 */
	EReference getBpmnBranch_Element();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#getCondition()
	 * @see #getBpmnBranch()
	 * @generated
	 */
	EReference getBpmnBranch_Condition();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#isDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnBranch#isDefault()
	 * @see #getBpmnBranch()
	 * @generated
	 */
	EAttribute getBpmnBranch_Default();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock <em>Bpmn Loop Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bpmn Loop Block</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock
	 * @generated
	 */
	EClass getBpmnLoopBlock();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getFirstBranch <em>First Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Branch</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getFirstBranch()
	 * @see #getBpmnLoopBlock()
	 * @generated
	 */
	EReference getBpmnLoopBlock_FirstBranch();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getSecondBranch <em>Second Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Second Branch</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getSecondBranch()
	 * @see #getBpmnLoopBlock()
	 * @generated
	 */
	EReference getBpmnLoopBlock_SecondBranch();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getExitBranch <em>Exit Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exit Branch</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getExitBranch()
	 * @see #getBpmnLoopBlock()
	 * @generated
	 */
	EReference getBpmnLoopBlock_ExitBranch();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getFirstGateway <em>First Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>First Gateway</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getFirstGateway()
	 * @see #getBpmnLoopBlock()
	 * @generated
	 */
	EReference getBpmnLoopBlock_FirstGateway();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getSecondGateway <em>Second Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Second Gateway</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock#getSecondGateway()
	 * @see #getBpmnLoopBlock()
	 * @generated
	 */
	EReference getBpmnLoopBlock_SecondGateway();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess <em>Bpmn Derived Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bpmn Derived Process</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess
	 * @generated
	 */
	EClass getBpmnDerivedProcess();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#getElement()
	 * @see #getBpmnDerivedProcess()
	 * @generated
	 */
	EReference getBpmnDerivedProcess_Element();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#getProcessName <em>Process Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Name</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#getProcessName()
	 * @see #getBpmnDerivedProcess()
	 * @generated
	 */
	EAttribute getBpmnDerivedProcess_ProcessName();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#isWaitForCompletion <em>Wait For Completion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wait For Completion</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnDerivedProcess#isWaitForCompletion()
	 * @see #getBpmnDerivedProcess()
	 * @generated
	 */
	EAttribute getBpmnDerivedProcess_WaitForCompletion();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock <em>Bpmn Event Handler Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bpmn Event Handler Block</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock
	 * @generated
	 */
	EClass getBpmnEventHandlerBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock#getEventHandlerCases <em>Event Handler Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Event Handler Cases</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock#getEventHandlerCases()
	 * @see #getBpmnEventHandlerBlock()
	 * @generated
	 */
	EReference getBpmnEventHandlerBlock_EventHandlerCases();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Activity</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerBlock#getActivity()
	 * @see #getBpmnEventHandlerBlock()
	 * @generated
	 */
	EReference getBpmnEventHandlerBlock_Activity();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase <em>Bpmn Event Handler Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bpmn Event Handler Case</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase
	 * @generated
	 */
	EClass getBpmnEventHandlerCase();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getIntermediate <em>Intermediate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Intermediate</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getIntermediate()
	 * @see #getBpmnEventHandlerCase()
	 * @generated
	 */
	EReference getBpmnEventHandlerCase_Intermediate();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getCompensationElement <em>Compensation Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compensation Element</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getCompensationElement()
	 * @see #getBpmnEventHandlerCase()
	 * @generated
	 */
	EReference getBpmnEventHandlerCase_CompensationElement();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getElementToSkip <em>Element To Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element To Skip</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getElementToSkip()
	 * @see #getBpmnEventHandlerCase()
	 * @generated
	 */
	EReference getBpmnEventHandlerCase_ElementToSkip();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getGateway <em>Gateway</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Gateway</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase#getGateway()
	 * @see #getBpmnEventHandlerCase()
	 * @generated
	 */
	EReference getBpmnEventHandlerCase_Gateway();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip <em>Bpmn Element To Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bpmn Element To Skip</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip
	 * @generated
	 */
	EClass getBpmnElementToSkip();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Element</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getElement()
	 * @see #getBpmnElementToSkip()
	 * @generated
	 */
	EReference getBpmnElementToSkip_Element();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Name</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getVariableName()
	 * @see #getBpmnElementToSkip()
	 * @generated
	 */
	EAttribute getBpmnElementToSkip_VariableName();

	/**
	 * Returns the meta object for the reference '{@link de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getEventHandlerCase <em>Event Handler Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event Handler Case</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip#getEventHandlerCase()
	 * @see #getBpmnElementToSkip()
	 * @generated
	 */
	EReference getBpmnElementToSkip_EventHandlerCase();

	/**
	 * Returns the meta object for class '{@link de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression <em>Disjunctive Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disjunctive Expression</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression
	 * @generated
	 */
	EClass getDisjunctiveExpression();

	/**
	 * Returns the meta object for the attribute list '{@link de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Expressions</em>'.
	 * @see de.dailab.vsdt.trafo.strucbpmn.DisjunctiveExpression#getExpressions()
	 * @see #getDisjunctiveExpression()
	 * @generated
	 */
	EAttribute getDisjunctiveExpression_Expressions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	StrucBpmnFactory getStrucBpmnFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnSequenceImpl <em>Bpmn Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnSequenceImpl
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnSequence()
		 * @generated
		 */
		EClass BPMN_SEQUENCE = eINSTANCE.getBpmnSequence();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_SEQUENCE__ELEMENTS = eINSTANCE.getBpmnSequence_Elements();

		/**
		 * The meta object literal for the '<em><b>Needs To Persist</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_SEQUENCE__NEEDS_TO_PERSIST = eINSTANCE.getBpmnSequence_NeedsToPersist();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBlockImpl <em>Bpmn Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBlockImpl
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnBlock()
		 * @generated
		 */
		EClass BPMN_BLOCK = eINSTANCE.getBpmnBlock();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_BLOCK__ELEMENTS = eINSTANCE.getBpmnBlock_Elements();

		/**
		 * The meta object literal for the '<em><b>First Gateway</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_BLOCK__FIRST_GATEWAY = eINSTANCE.getBpmnBlock_FirstGateway();

		/**
		 * The meta object literal for the '<em><b>Second Gateway</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_BLOCK__SECOND_GATEWAY = eINSTANCE.getBpmnBlock_SecondGateway();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBranchImpl <em>Bpmn Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBranchImpl
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnBranch()
		 * @generated
		 */
		EClass BPMN_BRANCH = eINSTANCE.getBpmnBranch();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_BRANCH__ELEMENT = eINSTANCE.getBpmnBranch_Element();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_BRANCH__CONDITION = eINSTANCE.getBpmnBranch_Condition();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_BRANCH__DEFAULT = eINSTANCE.getBpmnBranch_Default();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnLoopBlockImpl <em>Bpmn Loop Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnLoopBlockImpl
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnLoopBlock()
		 * @generated
		 */
		EClass BPMN_LOOP_BLOCK = eINSTANCE.getBpmnLoopBlock();

		/**
		 * The meta object literal for the '<em><b>First Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_LOOP_BLOCK__FIRST_BRANCH = eINSTANCE.getBpmnLoopBlock_FirstBranch();

		/**
		 * The meta object literal for the '<em><b>Second Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_LOOP_BLOCK__SECOND_BRANCH = eINSTANCE.getBpmnLoopBlock_SecondBranch();

		/**
		 * The meta object literal for the '<em><b>Exit Branch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_LOOP_BLOCK__EXIT_BRANCH = eINSTANCE.getBpmnLoopBlock_ExitBranch();

		/**
		 * The meta object literal for the '<em><b>First Gateway</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_LOOP_BLOCK__FIRST_GATEWAY = eINSTANCE.getBpmnLoopBlock_FirstGateway();

		/**
		 * The meta object literal for the '<em><b>Second Gateway</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_LOOP_BLOCK__SECOND_GATEWAY = eINSTANCE.getBpmnLoopBlock_SecondGateway();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnDerivedProcessImpl <em>Bpmn Derived Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnDerivedProcessImpl
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnDerivedProcess()
		 * @generated
		 */
		EClass BPMN_DERIVED_PROCESS = eINSTANCE.getBpmnDerivedProcess();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_DERIVED_PROCESS__ELEMENT = eINSTANCE.getBpmnDerivedProcess_Element();

		/**
		 * The meta object literal for the '<em><b>Process Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_DERIVED_PROCESS__PROCESS_NAME = eINSTANCE.getBpmnDerivedProcess_ProcessName();

		/**
		 * The meta object literal for the '<em><b>Wait For Completion</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_DERIVED_PROCESS__WAIT_FOR_COMPLETION = eINSTANCE.getBpmnDerivedProcess_WaitForCompletion();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerBlockImpl <em>Bpmn Event Handler Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerBlockImpl
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnEventHandlerBlock()
		 * @generated
		 */
		EClass BPMN_EVENT_HANDLER_BLOCK = eINSTANCE.getBpmnEventHandlerBlock();

		/**
		 * The meta object literal for the '<em><b>Event Handler Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_EVENT_HANDLER_BLOCK__EVENT_HANDLER_CASES = eINSTANCE.getBpmnEventHandlerBlock_EventHandlerCases();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_EVENT_HANDLER_BLOCK__ACTIVITY = eINSTANCE.getBpmnEventHandlerBlock_Activity();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerCaseImpl <em>Bpmn Event Handler Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerCaseImpl
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnEventHandlerCase()
		 * @generated
		 */
		EClass BPMN_EVENT_HANDLER_CASE = eINSTANCE.getBpmnEventHandlerCase();

		/**
		 * The meta object literal for the '<em><b>Intermediate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_EVENT_HANDLER_CASE__INTERMEDIATE = eINSTANCE.getBpmnEventHandlerCase_Intermediate();

		/**
		 * The meta object literal for the '<em><b>Compensation Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT = eINSTANCE.getBpmnEventHandlerCase_CompensationElement();

		/**
		 * The meta object literal for the '<em><b>Element To Skip</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP = eINSTANCE.getBpmnEventHandlerCase_ElementToSkip();

		/**
		 * The meta object literal for the '<em><b>Gateway</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_EVENT_HANDLER_CASE__GATEWAY = eINSTANCE.getBpmnEventHandlerCase_Gateway();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnElementToSkipImpl <em>Bpmn Element To Skip</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.BpmnElementToSkipImpl
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getBpmnElementToSkip()
		 * @generated
		 */
		EClass BPMN_ELEMENT_TO_SKIP = eINSTANCE.getBpmnElementToSkip();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_ELEMENT_TO_SKIP__ELEMENT = eINSTANCE.getBpmnElementToSkip_Element();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BPMN_ELEMENT_TO_SKIP__VARIABLE_NAME = eINSTANCE.getBpmnElementToSkip_VariableName();

		/**
		 * The meta object literal for the '<em><b>Event Handler Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE = eINSTANCE.getBpmnElementToSkip_EventHandlerCase();

		/**
		 * The meta object literal for the '{@link de.dailab.vsdt.trafo.strucbpmn.impl.DisjunctiveExpressionImpl <em>Disjunctive Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.DisjunctiveExpressionImpl
		 * @see de.dailab.vsdt.trafo.strucbpmn.impl.StrucBpmnPackageImpl#getDisjunctiveExpression()
		 * @generated
		 */
		EClass DISJUNCTIVE_EXPRESSION = eINSTANCE.getDisjunctiveExpression();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DISJUNCTIVE_EXPRESSION__EXPRESSIONS = eINSTANCE.getDisjunctiveExpression_Expressions();

	}

} //StrucBpmnPackage
