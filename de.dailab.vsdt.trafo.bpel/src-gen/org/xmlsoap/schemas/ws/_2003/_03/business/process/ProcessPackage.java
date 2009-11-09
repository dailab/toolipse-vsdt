/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessFactory
 * @model kind="package"
 * @generated
 */
public interface ProcessPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "process";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://schemas.xmlsoap.org/ws/2003/03/business-process/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "bpws";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ProcessPackage eINSTANCE = org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TExtensibleElementsImpl <em>TExtensible Elements</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TExtensibleElementsImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTExtensibleElements()
	 * @generated
	 */
	int TEXTENSIBLE_ELEMENTS = 19;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ELEMENTS__ANY = 0;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE = 1;

	/**
	 * The number of structural features of the '<em>TExtensible Elements</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ELEMENTS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityContainerImpl <em>TActivity Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityContainerImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTActivityContainer()
	 * @generated
	 */
	int TACTIVITY_CONTAINER = 4;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__EMPTY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__INVOKE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__RECEIVE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__REPLY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__ASSIGN = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__WAIT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__THROW = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__TERMINATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__FLOW = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__SWITCH = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__WHILE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__SEQUENCE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__PICK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER__SCOPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>TActivity Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_CONTAINER_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 14;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.CaseTypeImpl <em>Case Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.CaseTypeImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getCaseType()
	 * @generated
	 */
	int CASE_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__ANY = TACTIVITY_CONTAINER__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__ANY_ATTRIBUTE = TACTIVITY_CONTAINER__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__EMPTY = TACTIVITY_CONTAINER__EMPTY;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__INVOKE = TACTIVITY_CONTAINER__INVOKE;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__RECEIVE = TACTIVITY_CONTAINER__RECEIVE;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__REPLY = TACTIVITY_CONTAINER__REPLY;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__ASSIGN = TACTIVITY_CONTAINER__ASSIGN;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__WAIT = TACTIVITY_CONTAINER__WAIT;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__THROW = TACTIVITY_CONTAINER__THROW;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__TERMINATE = TACTIVITY_CONTAINER__TERMINATE;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__FLOW = TACTIVITY_CONTAINER__FLOW;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__SWITCH = TACTIVITY_CONTAINER__SWITCH;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__WHILE = TACTIVITY_CONTAINER__WHILE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__SEQUENCE = TACTIVITY_CONTAINER__SEQUENCE;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__PICK = TACTIVITY_CONTAINER__PICK;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__SCOPE = TACTIVITY_CONTAINER__SCOPE;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE__CONDITION = TACTIVITY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Case Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_TYPE_FEATURE_COUNT = TACTIVITY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.DocumentRootImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 1;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__FROM = 3;

	/**
	 * The feature id for the '<em><b>Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__PROCESS = 4;

	/**
	 * The feature id for the '<em><b>To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__TO = 5;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.PartnerLinkTypeImpl <em>Partner Link Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.PartnerLinkTypeImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getPartnerLinkType()
	 * @generated
	 */
	int PARTNER_LINK_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_LINK_TYPE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_LINK_TYPE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_LINK_TYPE__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Partner Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTNER_LINK_TYPE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityImpl <em>TActivity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTActivity()
	 * @generated
	 */
	int TACTIVITY = 3;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY__TARGET = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY__SOURCE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY__JOIN_CONDITION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY__SUPPRESS_JOIN_FAILURE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>TActivity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityOrCompensateContainerImpl <em>TActivity Or Compensate Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityOrCompensateContainerImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTActivityOrCompensateContainer()
	 * @generated
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER = 5;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__EMPTY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__INVOKE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__RECEIVE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__REPLY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__ASSIGN = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__WAIT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__THROW = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__TERMINATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__FLOW = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__SWITCH = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__WHILE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__SEQUENCE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__PICK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__SCOPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Compensate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER__COMPENSATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>TActivity Or Compensate Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TACTIVITY_OR_COMPENSATE_CONTAINER_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 15;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TAssignImpl <em>TAssign</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TAssignImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTAssign()
	 * @generated
	 */
	int TASSIGN = 6;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASSIGN__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASSIGN__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASSIGN__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASSIGN__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASSIGN__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASSIGN__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASSIGN__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Copy</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASSIGN__COPY = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TAssign</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TASSIGN_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCatchImpl <em>TCatch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCatchImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCatch()
	 * @generated
	 */
	int TCATCH = 7;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__ANY = TACTIVITY_OR_COMPENSATE_CONTAINER__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__ANY_ATTRIBUTE = TACTIVITY_OR_COMPENSATE_CONTAINER__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__EMPTY = TACTIVITY_OR_COMPENSATE_CONTAINER__EMPTY;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__INVOKE = TACTIVITY_OR_COMPENSATE_CONTAINER__INVOKE;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__RECEIVE = TACTIVITY_OR_COMPENSATE_CONTAINER__RECEIVE;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__REPLY = TACTIVITY_OR_COMPENSATE_CONTAINER__REPLY;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__ASSIGN = TACTIVITY_OR_COMPENSATE_CONTAINER__ASSIGN;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__WAIT = TACTIVITY_OR_COMPENSATE_CONTAINER__WAIT;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__THROW = TACTIVITY_OR_COMPENSATE_CONTAINER__THROW;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__TERMINATE = TACTIVITY_OR_COMPENSATE_CONTAINER__TERMINATE;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__FLOW = TACTIVITY_OR_COMPENSATE_CONTAINER__FLOW;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__SWITCH = TACTIVITY_OR_COMPENSATE_CONTAINER__SWITCH;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__WHILE = TACTIVITY_OR_COMPENSATE_CONTAINER__WHILE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__SEQUENCE = TACTIVITY_OR_COMPENSATE_CONTAINER__SEQUENCE;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__PICK = TACTIVITY_OR_COMPENSATE_CONTAINER__PICK;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__SCOPE = TACTIVITY_OR_COMPENSATE_CONTAINER__SCOPE;

	/**
	 * The feature id for the '<em><b>Compensate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__COMPENSATE = TACTIVITY_OR_COMPENSATE_CONTAINER__COMPENSATE;

	/**
	 * The feature id for the '<em><b>Fault Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__FAULT_NAME = TACTIVITY_OR_COMPENSATE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fault Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH__FAULT_VARIABLE = TACTIVITY_OR_COMPENSATE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TCatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCATCH_FEATURE_COUNT = TACTIVITY_OR_COMPENSATE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCompensateImpl <em>TCompensate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCompensateImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCompensate()
	 * @generated
	 */
	int TCOMPENSATE = 8;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATE__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATE__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATE__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATE__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATE__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATE__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATE__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATE__SCOPE = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCompensate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATE_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCompensationHandlerImpl <em>TCompensation Handler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCompensationHandlerImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCompensationHandler()
	 * @generated
	 */
	int TCOMPENSATION_HANDLER = 9;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__ANY = TACTIVITY_OR_COMPENSATE_CONTAINER__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__ANY_ATTRIBUTE = TACTIVITY_OR_COMPENSATE_CONTAINER__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__EMPTY = TACTIVITY_OR_COMPENSATE_CONTAINER__EMPTY;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__INVOKE = TACTIVITY_OR_COMPENSATE_CONTAINER__INVOKE;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__RECEIVE = TACTIVITY_OR_COMPENSATE_CONTAINER__RECEIVE;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__REPLY = TACTIVITY_OR_COMPENSATE_CONTAINER__REPLY;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__ASSIGN = TACTIVITY_OR_COMPENSATE_CONTAINER__ASSIGN;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__WAIT = TACTIVITY_OR_COMPENSATE_CONTAINER__WAIT;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__THROW = TACTIVITY_OR_COMPENSATE_CONTAINER__THROW;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__TERMINATE = TACTIVITY_OR_COMPENSATE_CONTAINER__TERMINATE;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__FLOW = TACTIVITY_OR_COMPENSATE_CONTAINER__FLOW;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__SWITCH = TACTIVITY_OR_COMPENSATE_CONTAINER__SWITCH;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__WHILE = TACTIVITY_OR_COMPENSATE_CONTAINER__WHILE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__SEQUENCE = TACTIVITY_OR_COMPENSATE_CONTAINER__SEQUENCE;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__PICK = TACTIVITY_OR_COMPENSATE_CONTAINER__PICK;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__SCOPE = TACTIVITY_OR_COMPENSATE_CONTAINER__SCOPE;

	/**
	 * The feature id for the '<em><b>Compensate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER__COMPENSATE = TACTIVITY_OR_COMPENSATE_CONTAINER__COMPENSATE;

	/**
	 * The number of structural features of the '<em>TCompensation Handler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOMPENSATION_HANDLER_FEATURE_COUNT = TACTIVITY_OR_COMPENSATE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCopyImpl <em>TCopy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCopyImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCopy()
	 * @generated
	 */
	int TCOPY = 10;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOPY__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOPY__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>From</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOPY__FROM = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOPY__TO = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TCopy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCOPY_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationImpl <em>TCorrelation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelation()
	 * @generated
	 */
	int TCORRELATION = 11;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Initiate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION__INITIATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION__SET = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TCorrelation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationsImpl <em>TCorrelations</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationsImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelations()
	 * @generated
	 */
	int TCORRELATIONS = 12;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATIONS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATIONS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Correlation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATIONS__CORRELATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCorrelations</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATIONS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationSetImpl <em>TCorrelation Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationSetImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelationSet()
	 * @generated
	 */
	int TCORRELATION_SET = 13;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_SET__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_SET__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_SET__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_SET__PROPERTIES = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TCorrelation Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_SET_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationSetsImpl <em>TCorrelation Sets</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationSetsImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelationSets()
	 * @generated
	 */
	int TCORRELATION_SETS = 14;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_SETS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_SETS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Correlation Set</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_SETS__CORRELATION_SET = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCorrelation Sets</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_SETS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationsWithPatternImpl <em>TCorrelations With Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationsWithPatternImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelationsWithPattern()
	 * @generated
	 */
	int TCORRELATIONS_WITH_PATTERN = 15;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATIONS_WITH_PATTERN__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATIONS_WITH_PATTERN__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Correlation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATIONS_WITH_PATTERN__CORRELATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCorrelations With Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATIONS_WITH_PATTERN_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationWithPatternImpl <em>TCorrelation With Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationWithPatternImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelationWithPattern()
	 * @generated
	 */
	int TCORRELATION_WITH_PATTERN = 16;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_WITH_PATTERN__ANY = TCORRELATION__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_WITH_PATTERN__ANY_ATTRIBUTE = TCORRELATION__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Initiate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_WITH_PATTERN__INITIATE = TCORRELATION__INITIATE;

	/**
	 * The feature id for the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_WITH_PATTERN__SET = TCORRELATION__SET;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_WITH_PATTERN__PATTERN = TCORRELATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TCorrelation With Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TCORRELATION_WITH_PATTERN_FEATURE_COUNT = TCORRELATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEmptyImpl <em>TEmpty</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEmptyImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTEmpty()
	 * @generated
	 */
	int TEMPTY = 17;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPTY__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPTY__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPTY__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPTY__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPTY__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPTY__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPTY__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The number of structural features of the '<em>TEmpty</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPTY_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEventHandlersImpl <em>TEvent Handlers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEventHandlersImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTEventHandlers()
	 * @generated
	 */
	int TEVENT_HANDLERS = 18;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEVENT_HANDLERS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEVENT_HANDLERS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>On Message</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEVENT_HANDLERS__ON_MESSAGE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>On Alarm</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEVENT_HANDLERS__ON_ALARM = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TEvent Handlers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEVENT_HANDLERS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFaultHandlersImpl <em>TFault Handlers</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFaultHandlersImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTFaultHandlers()
	 * @generated
	 */
	int TFAULT_HANDLERS = 20;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT_HANDLERS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT_HANDLERS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Catch</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT_HANDLERS__CATCH = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Catch All</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT_HANDLERS__CATCH_ALL = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TFault Handlers</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT_HANDLERS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl <em>TFlow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTFlow()
	 * @generated
	 */
	int TFLOW = 21;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Links</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__LINKS = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__ACTIVITY = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__EMPTY = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__INVOKE = TACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__RECEIVE = TACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__REPLY = TACTIVITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__ASSIGN = TACTIVITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__WAIT = TACTIVITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__THROW = TACTIVITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__TERMINATE = TACTIVITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__FLOW = TACTIVITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__SWITCH = TACTIVITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__WHILE = TACTIVITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__SEQUENCE = TACTIVITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__PICK = TACTIVITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW__SCOPE = TACTIVITY_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>TFlow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFLOW_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 16;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl <em>TFrom</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTFrom()
	 * @generated
	 */
	int TFROM = 22;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Endpoint Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__ENDPOINT_REFERENCE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__EXPRESSION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Opaque</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__OPAQUE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__PART = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__PARTNER_LINK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__PROPERTY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__QUERY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM__VARIABLE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>TFrom</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFROM_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TInvokeImpl <em>TInvoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TInvokeImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTInvoke()
	 * @generated
	 */
	int TINVOKE = 23;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Correlations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__CORRELATIONS = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Catch</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__CATCH = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Catch All</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__CATCH_ALL = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Compensation Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__COMPENSATION_HANDLER = TACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Input Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__INPUT_VARIABLE = TACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__OPERATION = TACTIVITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Output Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__OUTPUT_VARIABLE = TACTIVITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__PARTNER_LINK = TACTIVITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE__PORT_TYPE = TACTIVITY_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>TInvoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TINVOKE_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TLinkImpl <em>TLink</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TLinkImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTLink()
	 * @generated
	 */
	int TLINK = 24;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLINK__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLINK__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLINK__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TLink</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLINK_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TLinksImpl <em>TLinks</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TLinksImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTLinks()
	 * @generated
	 */
	int TLINKS = 25;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLINKS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLINKS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLINKS__LINK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TLinks</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLINKS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnAlarmImpl <em>TOn Alarm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnAlarmImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTOnAlarm()
	 * @generated
	 */
	int TON_ALARM = 26;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__ANY = TACTIVITY_CONTAINER__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__ANY_ATTRIBUTE = TACTIVITY_CONTAINER__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__EMPTY = TACTIVITY_CONTAINER__EMPTY;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__INVOKE = TACTIVITY_CONTAINER__INVOKE;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__RECEIVE = TACTIVITY_CONTAINER__RECEIVE;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__REPLY = TACTIVITY_CONTAINER__REPLY;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__ASSIGN = TACTIVITY_CONTAINER__ASSIGN;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__WAIT = TACTIVITY_CONTAINER__WAIT;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__THROW = TACTIVITY_CONTAINER__THROW;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__TERMINATE = TACTIVITY_CONTAINER__TERMINATE;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__FLOW = TACTIVITY_CONTAINER__FLOW;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__SWITCH = TACTIVITY_CONTAINER__SWITCH;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__WHILE = TACTIVITY_CONTAINER__WHILE;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__SEQUENCE = TACTIVITY_CONTAINER__SEQUENCE;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__PICK = TACTIVITY_CONTAINER__PICK;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__SCOPE = TACTIVITY_CONTAINER__SCOPE;

	/**
	 * The feature id for the '<em><b>For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__FOR = TACTIVITY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM__UNTIL = TACTIVITY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TOn Alarm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_ALARM_FEATURE_COUNT = TACTIVITY_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl <em>TOn Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTOnMessage()
	 * @generated
	 */
	int TON_MESSAGE = 27;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Correlations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__CORRELATIONS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__EMPTY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__INVOKE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__RECEIVE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__REPLY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__ASSIGN = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__WAIT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__THROW = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__TERMINATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__FLOW = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__SWITCH = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__WHILE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__SEQUENCE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__PICK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__SCOPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__OPERATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__PARTNER_LINK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__PORT_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE__VARIABLE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 18;

	/**
	 * The number of structural features of the '<em>TOn Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TON_MESSAGE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 19;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.ToTypeImpl <em>To Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ToTypeImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getToType()
	 * @generated
	 */
	int TO_TYPE = 28;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__ANY = TFROM__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__ANY_ATTRIBUTE = TFROM__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Endpoint Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__ENDPOINT_REFERENCE = TFROM__ENDPOINT_REFERENCE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__EXPRESSION = TFROM__EXPRESSION;

	/**
	 * The feature id for the '<em><b>Opaque</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__OPAQUE = TFROM__OPAQUE;

	/**
	 * The feature id for the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__PART = TFROM__PART;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__PARTNER_LINK = TFROM__PARTNER_LINK;

	/**
	 * The feature id for the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__PROPERTY = TFROM__PROPERTY;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__QUERY = TFROM__QUERY;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE__VARIABLE = TFROM__VARIABLE;

	/**
	 * The number of structural features of the '<em>To Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_TYPE_FEATURE_COUNT = TFROM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerImpl <em>TPartner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPartner()
	 * @generated
	 */
	int TPARTNER = 29;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER__PARTNER_LINK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TPartner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinkImpl <em>TPartner Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinkImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPartnerLink()
	 * @generated
	 */
	int TPARTNER_LINK = 30;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINK__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINK__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>My Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINK__MY_ROLE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINK__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Partner Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINK__PARTNER_LINK_TYPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Partner Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINK__PARTNER_ROLE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>TPartner Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINK_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinksImpl <em>TPartner Links</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinksImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPartnerLinks()
	 * @generated
	 */
	int TPARTNER_LINKS = 31;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINKS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINKS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINKS__PARTNER_LINK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TPartner Links</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNER_LINKS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnersImpl <em>TPartners</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnersImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPartners()
	 * @generated
	 */
	int TPARTNERS = 32;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNERS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNERS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Partner</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNERS__PARTNER = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TPartners</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARTNERS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPickImpl <em>TPick</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPickImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPick()
	 * @generated
	 */
	int TPICK = 33;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>On Message</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__ON_MESSAGE = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>On Alarm</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__ON_ALARM = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Create Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK__CREATE_INSTANCE = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TPick</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPICK_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TProcessImpl <em>TProcess</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TProcessImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTProcess()
	 * @generated
	 */
	int TPROCESS = 34;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Partner Links</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__PARTNER_LINKS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Partners</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__PARTNERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__VARIABLES = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Correlation Sets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__CORRELATION_SETS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fault Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__FAULT_HANDLERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Compensation Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__COMPENSATION_HANDLER = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Event Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__EVENT_HANDLERS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__EMPTY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__INVOKE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__RECEIVE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__REPLY = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__ASSIGN = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__WAIT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__THROW = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__TERMINATE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__FLOW = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__SWITCH = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__WHILE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__SEQUENCE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__PICK = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__SCOPE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 20;

	/**
	 * The feature id for the '<em><b>Abstract Process</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__ABSTRACT_PROCESS = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 21;

	/**
	 * The feature id for the '<em><b>Enable Instance Compensation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__ENABLE_INSTANCE_COMPENSATION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 22;

	/**
	 * The feature id for the '<em><b>Expression Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__EXPRESSION_LANGUAGE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 24;

	/**
	 * The feature id for the '<em><b>Query Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__QUERY_LANGUAGE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 25;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__SUPPRESS_JOIN_FAILURE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 26;

	/**
	 * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS__TARGET_NAMESPACE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 27;

	/**
	 * The number of structural features of the '<em>TProcess</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPROCESS_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 28;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TReceiveImpl <em>TReceive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TReceiveImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTReceive()
	 * @generated
	 */
	int TRECEIVE = 35;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Correlations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__CORRELATIONS = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Create Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__CREATE_INSTANCE = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__OPERATION = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__PARTNER_LINK = TACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__PORT_TYPE = TACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE__VARIABLE = TACTIVITY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>TReceive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRECEIVE_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TReplyImpl <em>TReply</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TReplyImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTReply()
	 * @generated
	 */
	int TREPLY = 36;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Correlations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__CORRELATIONS = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fault Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__FAULT_NAME = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__OPERATION = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__PARTNER_LINK = TACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__PORT_TYPE = TACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY__VARIABLE = TACTIVITY_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>TReply</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TREPLY_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl <em>TScope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTScope()
	 * @generated
	 */
	int TSCOPE = 37;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__VARIABLES = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Correlation Sets</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__CORRELATION_SETS = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fault Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__FAULT_HANDLERS = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Compensation Handler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__COMPENSATION_HANDLER = TACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Event Handlers</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__EVENT_HANDLERS = TACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__EMPTY = TACTIVITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__INVOKE = TACTIVITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__RECEIVE = TACTIVITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__REPLY = TACTIVITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__ASSIGN = TACTIVITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__WAIT = TACTIVITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__THROW = TACTIVITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__TERMINATE = TACTIVITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__FLOW = TACTIVITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__SWITCH = TACTIVITY_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__WHILE = TACTIVITY_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__SEQUENCE = TACTIVITY_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__PICK = TACTIVITY_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__SCOPE = TACTIVITY_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Variable Access Serializable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE__VARIABLE_ACCESS_SERIALIZABLE = TACTIVITY_FEATURE_COUNT + 19;

	/**
	 * The number of structural features of the '<em>TScope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSCOPE_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 20;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl <em>TSequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTSequence()
	 * @generated
	 */
	int TSEQUENCE = 38;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__ACTIVITY = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__EMPTY = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__INVOKE = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__RECEIVE = TACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__REPLY = TACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__ASSIGN = TACTIVITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__WAIT = TACTIVITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__THROW = TACTIVITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__TERMINATE = TACTIVITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__FLOW = TACTIVITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__SWITCH = TACTIVITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__WHILE = TACTIVITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__SEQUENCE = TACTIVITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__PICK = TACTIVITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE__SCOPE = TACTIVITY_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>TSequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSEQUENCE_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 15;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSourceImpl <em>TSource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSourceImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTSource()
	 * @generated
	 */
	int TSOURCE = 39;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSOURCE__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSOURCE__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Link Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSOURCE__LINK_NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Transition Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSOURCE__TRANSITION_CONDITION = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TSource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSOURCE_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSwitchImpl <em>TSwitch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSwitchImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTSwitch()
	 * @generated
	 */
	int TSWITCH = 40;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Case</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH__CASE = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Otherwise</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH__OTHERWISE = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TSwitch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSWITCH_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TTargetImpl <em>TTarget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TTargetImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTTarget()
	 * @generated
	 */
	int TTARGET = 41;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTARGET__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTARGET__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Link Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTARGET__LINK_NAME = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TTarget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTARGET_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TTerminateImpl <em>TTerminate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TTerminateImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTTerminate()
	 * @generated
	 */
	int TTERMINATE = 42;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTERMINATE__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTERMINATE__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTERMINATE__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTERMINATE__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTERMINATE__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTERMINATE__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTERMINATE__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The number of structural features of the '<em>TTerminate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTERMINATE_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TThrowImpl <em>TThrow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TThrowImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTThrow()
	 * @generated
	 */
	int TTHROW = 43;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Fault Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW__FAULT_NAME = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fault Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW__FAULT_VARIABLE = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TThrow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTHROW_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TVariableImpl <em>TVariable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TVariableImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTVariable()
	 * @generated
	 */
	int TVARIABLE = 44;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Message Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__MESSAGE_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE__ANY_ATTRIBUTE = 4;

	/**
	 * The number of structural features of the '<em>TVariable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TVariablesImpl <em>TVariables</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TVariablesImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTVariables()
	 * @generated
	 */
	int TVARIABLES = 45;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLES__ANY = TEXTENSIBLE_ELEMENTS__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLES__ANY_ATTRIBUTE = TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLES__VARIABLE = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TVariables</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TVARIABLES_FEATURE_COUNT = TEXTENSIBLE_ELEMENTS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWaitImpl <em>TWait</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWaitImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTWait()
	 * @generated
	 */
	int TWAIT = 46;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT__FOR = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Until</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT__UNTIL = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TWait</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWAIT_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl <em>TWhile</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTWhile()
	 * @generated
	 */
	int TWHILE = 47;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__ANY = TACTIVITY__ANY;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__ANY_ATTRIBUTE = TACTIVITY__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__TARGET = TACTIVITY__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__SOURCE = TACTIVITY__SOURCE;

	/**
	 * The feature id for the '<em><b>Join Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__JOIN_CONDITION = TACTIVITY__JOIN_CONDITION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__NAME = TACTIVITY__NAME;

	/**
	 * The feature id for the '<em><b>Suppress Join Failure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__SUPPRESS_JOIN_FAILURE = TACTIVITY__SUPPRESS_JOIN_FAILURE;

	/**
	 * The feature id for the '<em><b>Empty</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__EMPTY = TACTIVITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Invoke</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__INVOKE = TACTIVITY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Receive</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__RECEIVE = TACTIVITY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Reply</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__REPLY = TACTIVITY_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Assign</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__ASSIGN = TACTIVITY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__WAIT = TACTIVITY_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Throw</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__THROW = TACTIVITY_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Terminate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__TERMINATE = TACTIVITY_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Flow</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__FLOW = TACTIVITY_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__SWITCH = TACTIVITY_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>While</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__WHILE = TACTIVITY_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__SEQUENCE = TACTIVITY_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Pick</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__PICK = TACTIVITY_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__SCOPE = TACTIVITY_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE__CONDITION = TACTIVITY_FEATURE_COUNT + 14;

	/**
	 * The number of structural features of the '<em>TWhile</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TWHILE_FEATURE_COUNT = TACTIVITY_FEATURE_COUNT + 15;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.PatternType <em>Pattern Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PatternType
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getPatternType()
	 * @generated
	 */
	int PATTERN_TYPE = 48;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean <em>TBoolean</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTBoolean()
	 * @generated
	 */
	int TBOOLEAN = 49;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TRoles <em>TRoles</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TRoles
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTRoles()
	 * @generated
	 */
	int TROLES = 50;

	/**
	 * The meta object id for the '<em>Pattern Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PatternType
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getPatternTypeObject()
	 * @generated
	 */
	int PATTERN_TYPE_OBJECT = 51;

	/**
	 * The meta object id for the '<em>Properties Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.List
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getPropertiesType()
	 * @generated
	 */
	int PROPERTIES_TYPE = 52;

	/**
	 * The meta object id for the '<em>TBoolean Expr</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTBooleanExpr()
	 * @generated
	 */
	int TBOOLEAN_EXPR = 53;

	/**
	 * The meta object id for the '<em>TBoolean Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTBooleanObject()
	 * @generated
	 */
	int TBOOLEAN_OBJECT = 54;

	/**
	 * The meta object id for the '<em>TDeadline Expr</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTDeadlineExpr()
	 * @generated
	 */
	int TDEADLINE_EXPR = 55;

	/**
	 * The meta object id for the '<em>TDuration Expr</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTDurationExpr()
	 * @generated
	 */
	int TDURATION_EXPR = 56;

	/**
	 * The meta object id for the '<em>TRoles Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TRoles
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTRolesObject()
	 * @generated
	 */
	int TROLES_OBJECT = 57;


	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.CaseType <em>Case Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.CaseType
	 * @generated
	 */
	EClass getCaseType();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.CaseType#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.CaseType#getCondition()
	 * @see #getCaseType()
	 * @generated
	 */
	EAttribute getCaseType_Condition();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>From</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getFrom()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_From();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Process</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getProcess()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Process();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>To</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.DocumentRoot#getTo()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_To();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.PartnerLinkType <em>Partner Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Partner Link Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PartnerLinkType
	 * @generated
	 */
	EClass getPartnerLinkType();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.PartnerLinkType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PartnerLinkType#getName()
	 * @see #getPartnerLinkType()
	 * @generated
	 */
	EAttribute getPartnerLinkType_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity <em>TActivity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TActivity</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivity
	 * @generated
	 */
	EClass getTActivity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getTarget()
	 * @see #getTActivity()
	 * @generated
	 */
	EReference getTActivity_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Source</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getSource()
	 * @see #getTActivity()
	 * @generated
	 */
	EReference getTActivity_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getJoinCondition <em>Join Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Join Condition</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getJoinCondition()
	 * @see #getTActivity()
	 * @generated
	 */
	EAttribute getTActivity_JoinCondition();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getName()
	 * @see #getTActivity()
	 * @generated
	 */
	EAttribute getTActivity_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getSuppressJoinFailure <em>Suppress Join Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suppress Join Failure</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivity#getSuppressJoinFailure()
	 * @see #getTActivity()
	 * @generated
	 */
	EAttribute getTActivity_SuppressJoinFailure();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer <em>TActivity Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TActivity Container</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer
	 * @generated
	 */
	EClass getTActivityContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getEmpty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Empty</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getEmpty()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Empty();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getInvoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invoke</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getInvoke()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Invoke();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Receive</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getReceive()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Receive();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getReply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reply</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getReply()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Reply();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getAssign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assign</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getAssign()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Assign();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wait</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getWait()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Wait();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getThrow <em>Throw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Throw</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getThrow()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Throw();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getTerminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Terminate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getTerminate()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Terminate();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Flow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getFlow()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Flow();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getSwitch()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Switch();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getWhile <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>While</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getWhile()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_While();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getSequence()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Sequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getPick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pick</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getPick()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Pick();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer#getScope()
	 * @see #getTActivityContainer()
	 * @generated
	 */
	EReference getTActivityContainer_Scope();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer <em>TActivity Or Compensate Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TActivity Or Compensate Container</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer
	 * @generated
	 */
	EClass getTActivityOrCompensateContainer();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getEmpty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Empty</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getEmpty()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Empty();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getInvoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invoke</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getInvoke()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Invoke();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Receive</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getReceive()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Receive();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getReply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reply</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getReply()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Reply();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getAssign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assign</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getAssign()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Assign();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wait</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getWait()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Wait();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getThrow <em>Throw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Throw</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getThrow()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Throw();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getTerminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Terminate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getTerminate()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Terminate();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Flow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getFlow()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Flow();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getSwitch()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Switch();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getWhile <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>While</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getWhile()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_While();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getSequence()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Sequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getPick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pick</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getPick()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Pick();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getScope()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Scope();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getCompensate <em>Compensate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compensate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TActivityOrCompensateContainer#getCompensate()
	 * @see #getTActivityOrCompensateContainer()
	 * @generated
	 */
	EReference getTActivityOrCompensateContainer_Compensate();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TAssign <em>TAssign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TAssign</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TAssign
	 * @generated
	 */
	EClass getTAssign();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TAssign#getCopy <em>Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Copy</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TAssign#getCopy()
	 * @see #getTAssign()
	 * @generated
	 */
	EReference getTAssign_Copy();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCatch <em>TCatch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCatch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCatch
	 * @generated
	 */
	EClass getTCatch();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCatch#getFaultName <em>Fault Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCatch#getFaultName()
	 * @see #getTCatch()
	 * @generated
	 */
	EAttribute getTCatch_FaultName();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCatch#getFaultVariable <em>Fault Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Variable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCatch#getFaultVariable()
	 * @see #getTCatch()
	 * @generated
	 */
	EAttribute getTCatch_FaultVariable();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCompensate <em>TCompensate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCompensate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCompensate
	 * @generated
	 */
	EClass getTCompensate();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCompensate#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCompensate#getScope()
	 * @see #getTCompensate()
	 * @generated
	 */
	EAttribute getTCompensate_Scope();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCompensationHandler <em>TCompensation Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCompensation Handler</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCompensationHandler
	 * @generated
	 */
	EClass getTCompensationHandler();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCopy <em>TCopy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCopy</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCopy
	 * @generated
	 */
	EClass getTCopy();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCopy#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>From</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCopy#getFrom()
	 * @see #getTCopy()
	 * @generated
	 */
	EReference getTCopy_From();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCopy#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>To</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCopy#getTo()
	 * @see #getTCopy()
	 * @generated
	 */
	EReference getTCopy_To();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation <em>TCorrelation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCorrelation</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation
	 * @generated
	 */
	EClass getTCorrelation();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getInitiate <em>Initiate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initiate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getInitiate()
	 * @see #getTCorrelation()
	 * @generated
	 */
	EAttribute getTCorrelation_Initiate();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getSet <em>Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Set</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getSet()
	 * @see #getTCorrelation()
	 * @generated
	 */
	EAttribute getTCorrelation_Set();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelations <em>TCorrelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCorrelations</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelations
	 * @generated
	 */
	EClass getTCorrelations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelations#getCorrelation <em>Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Correlation</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelations#getCorrelation()
	 * @see #getTCorrelations()
	 * @generated
	 */
	EReference getTCorrelations_Correlation();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet <em>TCorrelation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCorrelation Set</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet
	 * @generated
	 */
	EClass getTCorrelationSet();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet#getName()
	 * @see #getTCorrelationSet()
	 * @generated
	 */
	EAttribute getTCorrelationSet_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Properties</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet#getProperties()
	 * @see #getTCorrelationSet()
	 * @generated
	 */
	EAttribute getTCorrelationSet_Properties();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets <em>TCorrelation Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCorrelation Sets</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets
	 * @generated
	 */
	EClass getTCorrelationSets();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets#getCorrelationSet <em>Correlation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Correlation Set</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets#getCorrelationSet()
	 * @see #getTCorrelationSets()
	 * @generated
	 */
	EReference getTCorrelationSets_CorrelationSet();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationsWithPattern <em>TCorrelations With Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCorrelations With Pattern</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationsWithPattern
	 * @generated
	 */
	EClass getTCorrelationsWithPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationsWithPattern#getCorrelation <em>Correlation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Correlation</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationsWithPattern#getCorrelation()
	 * @see #getTCorrelationsWithPattern()
	 * @generated
	 */
	EReference getTCorrelationsWithPattern_Correlation();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern <em>TCorrelation With Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TCorrelation With Pattern</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern
	 * @generated
	 */
	EClass getTCorrelationWithPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pattern</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern#getPattern()
	 * @see #getTCorrelationWithPattern()
	 * @generated
	 */
	EAttribute getTCorrelationWithPattern_Pattern();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty <em>TEmpty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TEmpty</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TEmpty
	 * @generated
	 */
	EClass getTEmpty();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers <em>TEvent Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TEvent Handlers</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers
	 * @generated
	 */
	EClass getTEventHandlers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers#getOnMessage <em>On Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>On Message</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers#getOnMessage()
	 * @see #getTEventHandlers()
	 * @generated
	 */
	EReference getTEventHandlers_OnMessage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers#getOnAlarm <em>On Alarm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>On Alarm</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers#getOnAlarm()
	 * @see #getTEventHandlers()
	 * @generated
	 */
	EReference getTEventHandlers_OnAlarm();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TExtensibleElements <em>TExtensible Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExtensible Elements</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TExtensibleElements
	 * @generated
	 */
	EClass getTExtensibleElements();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TExtensibleElements#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TExtensibleElements#getAny()
	 * @see #getTExtensibleElements()
	 * @generated
	 */
	EAttribute getTExtensibleElements_Any();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TExtensibleElements#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TExtensibleElements#getAnyAttribute()
	 * @see #getTExtensibleElements()
	 * @generated
	 */
	EAttribute getTExtensibleElements_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers <em>TFault Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFault Handlers</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers
	 * @generated
	 */
	EClass getTFaultHandlers();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers#getCatch <em>Catch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Catch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers#getCatch()
	 * @see #getTFaultHandlers()
	 * @generated
	 */
	EReference getTFaultHandlers_Catch();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers#getCatchAll <em>Catch All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Catch All</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers#getCatchAll()
	 * @see #getTFaultHandlers()
	 * @generated
	 */
	EReference getTFaultHandlers_CatchAll();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow <em>TFlow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFlow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow
	 * @generated
	 */
	EClass getTFlow();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getLinks <em>Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Links</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getLinks()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Links();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Activity</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getActivity()
	 * @see #getTFlow()
	 * @generated
	 */
	EAttribute getTFlow_Activity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getEmpty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Empty</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getEmpty()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Empty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getInvoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invoke</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getInvoke()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Invoke();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Receive</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getReceive()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Receive();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getReply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reply</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getReply()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Reply();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getAssign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assign</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getAssign()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Assign();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Wait</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getWait()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Wait();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getThrow <em>Throw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Throw</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getThrow()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Throw();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getTerminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terminate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getTerminate()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Terminate();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Flow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getFlow()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Flow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Switch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getSwitch()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Switch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getWhile <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>While</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getWhile()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_While();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequence</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getSequence()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Sequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getPick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pick</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getPick()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Pick();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFlow#getScope()
	 * @see #getTFlow()
	 * @generated
	 */
	EReference getTFlow_Scope();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom <em>TFrom</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFrom</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom
	 * @generated
	 */
	EClass getTFrom();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getEndpointReference <em>Endpoint Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Endpoint Reference</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getEndpointReference()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_EndpointReference();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getExpression()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_Expression();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getOpaque <em>Opaque</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Opaque</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getOpaque()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_Opaque();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Part</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getPart()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_Part();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Link</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getPartnerLink()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_PartnerLink();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Property</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getProperty()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getQuery()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_Query();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getVariable()
	 * @see #getTFrom()
	 * @generated
	 */
	EAttribute getTFrom_Variable();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke <em>TInvoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TInvoke</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke
	 * @generated
	 */
	EClass getTInvoke();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCorrelations <em>Correlations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Correlations</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCorrelations()
	 * @see #getTInvoke()
	 * @generated
	 */
	EReference getTInvoke_Correlations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCatch <em>Catch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Catch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCatch()
	 * @see #getTInvoke()
	 * @generated
	 */
	EReference getTInvoke_Catch();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCatchAll <em>Catch All</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Catch All</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCatchAll()
	 * @see #getTInvoke()
	 * @generated
	 */
	EReference getTInvoke_CatchAll();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCompensationHandler <em>Compensation Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compensation Handler</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getCompensationHandler()
	 * @see #getTInvoke()
	 * @generated
	 */
	EReference getTInvoke_CompensationHandler();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getInputVariable <em>Input Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input Variable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getInputVariable()
	 * @see #getTInvoke()
	 * @generated
	 */
	EAttribute getTInvoke_InputVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getOperation()
	 * @see #getTInvoke()
	 * @generated
	 */
	EAttribute getTInvoke_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getOutputVariable <em>Output Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output Variable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getOutputVariable()
	 * @see #getTInvoke()
	 * @generated
	 */
	EAttribute getTInvoke_OutputVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Link</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getPartnerLink()
	 * @see #getTInvoke()
	 * @generated
	 */
	EAttribute getTInvoke_PartnerLink();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TInvoke#getPortType()
	 * @see #getTInvoke()
	 * @generated
	 */
	EAttribute getTInvoke_PortType();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TLink <em>TLink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLink</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TLink
	 * @generated
	 */
	EClass getTLink();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TLink#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TLink#getName()
	 * @see #getTLink()
	 * @generated
	 */
	EAttribute getTLink_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TLinks <em>TLinks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TLinks</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TLinks
	 * @generated
	 */
	EClass getTLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TLinks#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Link</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TLinks#getLink()
	 * @see #getTLinks()
	 * @generated
	 */
	EReference getTLinks_Link();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm <em>TOn Alarm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TOn Alarm</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm
	 * @generated
	 */
	EClass getTOnAlarm();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm#getFor <em>For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>For</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm#getFor()
	 * @see #getTOnAlarm()
	 * @generated
	 */
	EAttribute getTOnAlarm_For();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm#getUntil <em>Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Until</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm#getUntil()
	 * @see #getTOnAlarm()
	 * @generated
	 */
	EAttribute getTOnAlarm_Until();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage <em>TOn Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TOn Message</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage
	 * @generated
	 */
	EClass getTOnMessage();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getCorrelations <em>Correlations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Correlations</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getCorrelations()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Correlations();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getEmpty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Empty</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getEmpty()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Empty();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getInvoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invoke</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getInvoke()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Invoke();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Receive</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getReceive()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Receive();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getReply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reply</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getReply()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Reply();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getAssign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assign</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getAssign()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Assign();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wait</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getWait()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Wait();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getThrow <em>Throw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Throw</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getThrow()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Throw();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getTerminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Terminate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getTerminate()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Terminate();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Flow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getFlow()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Flow();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getSwitch()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Switch();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getWhile <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>While</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getWhile()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_While();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getSequence()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Sequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getPick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pick</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getPick()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Pick();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getScope()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EReference getTOnMessage_Scope();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getOperation()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EAttribute getTOnMessage_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Link</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getPartnerLink()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EAttribute getTOnMessage_PartnerLink();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getPortType()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EAttribute getTOnMessage_PortType();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage#getVariable()
	 * @see #getTOnMessage()
	 * @generated
	 */
	EAttribute getTOnMessage_Variable();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.ToType <em>To Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ToType
	 * @generated
	 */
	EClass getToType();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartner <em>TPartner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPartner</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartner
	 * @generated
	 */
	EClass getTPartner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartner#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partner Link</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartner#getPartnerLink()
	 * @see #getTPartner()
	 * @generated
	 */
	EReference getTPartner_PartnerLink();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartner#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartner#getName()
	 * @see #getTPartner()
	 * @generated
	 */
	EAttribute getTPartner_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink <em>TPartner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPartner Link</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink
	 * @generated
	 */
	EClass getTPartnerLink();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getMyRole <em>My Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>My Role</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getMyRole()
	 * @see #getTPartnerLink()
	 * @generated
	 */
	EAttribute getTPartnerLink_MyRole();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getName()
	 * @see #getTPartnerLink()
	 * @generated
	 */
	EAttribute getTPartnerLink_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getPartnerLinkType <em>Partner Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Link Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getPartnerLinkType()
	 * @see #getTPartnerLink()
	 * @generated
	 */
	EAttribute getTPartnerLink_PartnerLinkType();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getPartnerRole <em>Partner Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Role</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getPartnerRole()
	 * @see #getTPartnerLink()
	 * @generated
	 */
	EAttribute getTPartnerLink_PartnerRole();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLinks <em>TPartner Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPartner Links</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLinks
	 * @generated
	 */
	EClass getTPartnerLinks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLinks#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partner Link</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLinks#getPartnerLink()
	 * @see #getTPartnerLinks()
	 * @generated
	 */
	EReference getTPartnerLinks_PartnerLink();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartners <em>TPartners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPartners</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartners
	 * @generated
	 */
	EClass getTPartners();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartners#getPartner <em>Partner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Partner</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPartners#getPartner()
	 * @see #getTPartners()
	 * @generated
	 */
	EReference getTPartners_Partner();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick <em>TPick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPick</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPick
	 * @generated
	 */
	EClass getTPick();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getOnMessage <em>On Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>On Message</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getOnMessage()
	 * @see #getTPick()
	 * @generated
	 */
	EReference getTPick_OnMessage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getOnAlarm <em>On Alarm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>On Alarm</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getOnAlarm()
	 * @see #getTPick()
	 * @generated
	 */
	EReference getTPick_OnAlarm();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getCreateInstance <em>Create Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create Instance</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getCreateInstance()
	 * @see #getTPick()
	 * @generated
	 */
	EAttribute getTPick_CreateInstance();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess <em>TProcess</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TProcess</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess
	 * @generated
	 */
	EClass getTProcess();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getPartnerLinks <em>Partner Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Partner Links</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getPartnerLinks()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_PartnerLinks();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getPartners <em>Partners</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Partners</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getPartners()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Partners();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variables</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getVariables()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Variables();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getCorrelationSets <em>Correlation Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Correlation Sets</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getCorrelationSets()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_CorrelationSets();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getFaultHandlers <em>Fault Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fault Handlers</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getFaultHandlers()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_FaultHandlers();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getCompensationHandler <em>Compensation Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compensation Handler</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getCompensationHandler()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_CompensationHandler();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getEventHandlers <em>Event Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Handlers</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getEventHandlers()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_EventHandlers();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getEmpty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Empty</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getEmpty()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Empty();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getInvoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invoke</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getInvoke()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Invoke();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Receive</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getReceive()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Receive();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getReply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reply</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getReply()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Reply();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getAssign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assign</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getAssign()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Assign();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wait</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getWait()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Wait();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getThrow <em>Throw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Throw</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getThrow()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Throw();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getTerminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Terminate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getTerminate()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Terminate();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Flow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getFlow()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Flow();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getSwitch()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Switch();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getWhile <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>While</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getWhile()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_While();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getSequence()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Sequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getPick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pick</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getPick()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Pick();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getScope()
	 * @see #getTProcess()
	 * @generated
	 */
	EReference getTProcess_Scope();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getAbstractProcess <em>Abstract Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract Process</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getAbstractProcess()
	 * @see #getTProcess()
	 * @generated
	 */
	EAttribute getTProcess_AbstractProcess();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getEnableInstanceCompensation <em>Enable Instance Compensation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enable Instance Compensation</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getEnableInstanceCompensation()
	 * @see #getTProcess()
	 * @generated
	 */
	EAttribute getTProcess_EnableInstanceCompensation();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getExpressionLanguage <em>Expression Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Language</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getExpressionLanguage()
	 * @see #getTProcess()
	 * @generated
	 */
	EAttribute getTProcess_ExpressionLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getName()
	 * @see #getTProcess()
	 * @generated
	 */
	EAttribute getTProcess_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getQueryLanguage <em>Query Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query Language</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getQueryLanguage()
	 * @see #getTProcess()
	 * @generated
	 */
	EAttribute getTProcess_QueryLanguage();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getSuppressJoinFailure <em>Suppress Join Failure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suppress Join Failure</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getSuppressJoinFailure()
	 * @see #getTProcess()
	 * @generated
	 */
	EAttribute getTProcess_SuppressJoinFailure();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getTargetNamespace <em>Target Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Namespace</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TProcess#getTargetNamespace()
	 * @see #getTProcess()
	 * @generated
	 */
	EAttribute getTProcess_TargetNamespace();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReceive <em>TReceive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TReceive</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReceive
	 * @generated
	 */
	EClass getTReceive();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getCorrelations <em>Correlations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Correlations</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getCorrelations()
	 * @see #getTReceive()
	 * @generated
	 */
	EReference getTReceive_Correlations();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getCreateInstance <em>Create Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Create Instance</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getCreateInstance()
	 * @see #getTReceive()
	 * @generated
	 */
	EAttribute getTReceive_CreateInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getOperation()
	 * @see #getTReceive()
	 * @generated
	 */
	EAttribute getTReceive_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Link</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getPartnerLink()
	 * @see #getTReceive()
	 * @generated
	 */
	EAttribute getTReceive_PartnerLink();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getPortType()
	 * @see #getTReceive()
	 * @generated
	 */
	EAttribute getTReceive_PortType();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReceive#getVariable()
	 * @see #getTReceive()
	 * @generated
	 */
	EAttribute getTReceive_Variable();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReply <em>TReply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TReply</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReply
	 * @generated
	 */
	EClass getTReply();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getCorrelations <em>Correlations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Correlations</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getCorrelations()
	 * @see #getTReply()
	 * @generated
	 */
	EReference getTReply_Correlations();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getFaultName <em>Fault Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getFaultName()
	 * @see #getTReply()
	 * @generated
	 */
	EAttribute getTReply_FaultName();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getOperation()
	 * @see #getTReply()
	 * @generated
	 */
	EAttribute getTReply_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getPartnerLink <em>Partner Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partner Link</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getPartnerLink()
	 * @see #getTReply()
	 * @generated
	 */
	EAttribute getTReply_PartnerLink();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getPortType()
	 * @see #getTReply()
	 * @generated
	 */
	EAttribute getTReply_PortType();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TReply#getVariable()
	 * @see #getTReply()
	 * @generated
	 */
	EAttribute getTReply_Variable();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope <em>TScope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TScope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope
	 * @generated
	 */
	EClass getTScope();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variables</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getVariables()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Variables();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getCorrelationSets <em>Correlation Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Correlation Sets</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getCorrelationSets()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_CorrelationSets();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getFaultHandlers <em>Fault Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fault Handlers</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getFaultHandlers()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_FaultHandlers();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getCompensationHandler <em>Compensation Handler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Compensation Handler</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getCompensationHandler()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_CompensationHandler();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getEventHandlers <em>Event Handlers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Event Handlers</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getEventHandlers()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_EventHandlers();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getEmpty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Empty</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getEmpty()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Empty();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getInvoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invoke</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getInvoke()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Invoke();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Receive</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getReceive()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Receive();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getReply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reply</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getReply()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Reply();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getAssign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assign</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getAssign()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Assign();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wait</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getWait()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Wait();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getThrow <em>Throw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Throw</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getThrow()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Throw();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getTerminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Terminate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getTerminate()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Terminate();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Flow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getFlow()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Flow();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getSwitch()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Switch();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getWhile <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>While</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getWhile()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_While();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getSequence()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Sequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getPick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pick</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getPick()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Pick();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getScope()
	 * @see #getTScope()
	 * @generated
	 */
	EReference getTScope_Scope();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getVariableAccessSerializable <em>Variable Access Serializable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Access Serializable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TScope#getVariableAccessSerializable()
	 * @see #getTScope()
	 * @generated
	 */
	EAttribute getTScope_VariableAccessSerializable();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence <em>TSequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TSequence</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence
	 * @generated
	 */
	EClass getTSequence();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Activity</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getActivity()
	 * @see #getTSequence()
	 * @generated
	 */
	EAttribute getTSequence_Activity();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getEmpty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Empty</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getEmpty()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Empty();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getInvoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invoke</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getInvoke()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Invoke();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Receive</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getReceive()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Receive();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getReply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Reply</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getReply()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Reply();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getAssign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assign</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getAssign()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Assign();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Wait</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getWait()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Wait();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getThrow <em>Throw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Throw</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getThrow()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Throw();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getTerminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Terminate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getTerminate()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Terminate();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Flow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getFlow()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Flow();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Switch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getSwitch()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Switch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getWhile <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>While</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getWhile()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_While();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sequence</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getSequence()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Sequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getPick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pick</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getPick()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Pick();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSequence#getScope()
	 * @see #getTSequence()
	 * @generated
	 */
	EReference getTSequence_Scope();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSource <em>TSource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TSource</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSource
	 * @generated
	 */
	EClass getTSource();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSource#getLinkName <em>Link Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSource#getLinkName()
	 * @see #getTSource()
	 * @generated
	 */
	EAttribute getTSource_LinkName();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSource#getTransitionCondition <em>Transition Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transition Condition</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSource#getTransitionCondition()
	 * @see #getTSource()
	 * @generated
	 */
	EAttribute getTSource_TransitionCondition();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch <em>TSwitch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TSwitch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch
	 * @generated
	 */
	EClass getTSwitch();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch#getCase <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Case</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch#getCase()
	 * @see #getTSwitch()
	 * @generated
	 */
	EReference getTSwitch_Case();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch#getOtherwise <em>Otherwise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Otherwise</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch#getOtherwise()
	 * @see #getTSwitch()
	 * @generated
	 */
	EReference getTSwitch_Otherwise();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TTarget <em>TTarget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTarget</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TTarget
	 * @generated
	 */
	EClass getTTarget();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TTarget#getLinkName <em>Link Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Link Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TTarget#getLinkName()
	 * @see #getTTarget()
	 * @generated
	 */
	EAttribute getTTarget_LinkName();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TTerminate <em>TTerminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTerminate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TTerminate
	 * @generated
	 */
	EClass getTTerminate();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TThrow <em>TThrow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TThrow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TThrow
	 * @generated
	 */
	EClass getTThrow();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TThrow#getFaultName <em>Fault Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TThrow#getFaultName()
	 * @see #getTThrow()
	 * @generated
	 */
	EAttribute getTThrow_FaultName();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TThrow#getFaultVariable <em>Fault Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fault Variable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TThrow#getFaultVariable()
	 * @see #getTThrow()
	 * @generated
	 */
	EAttribute getTThrow_FaultVariable();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariable <em>TVariable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TVariable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariable
	 * @generated
	 */
	EClass getTVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getElement()
	 * @see #getTVariable()
	 * @generated
	 */
	EAttribute getTVariable_Element();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getMessageType <em>Message Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getMessageType()
	 * @see #getTVariable()
	 * @generated
	 */
	EAttribute getTVariable_MessageType();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getName()
	 * @see #getTVariable()
	 * @generated
	 */
	EAttribute getTVariable_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getType()
	 * @see #getTVariable()
	 * @generated
	 */
	EAttribute getTVariable_Type();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariable#getAnyAttribute()
	 * @see #getTVariable()
	 * @generated
	 */
	EAttribute getTVariable_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariables <em>TVariables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TVariables</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariables
	 * @generated
	 */
	EClass getTVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariables#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TVariables#getVariable()
	 * @see #getTVariables()
	 * @generated
	 */
	EReference getTVariables_Variable();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWait <em>TWait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TWait</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWait
	 * @generated
	 */
	EClass getTWait();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWait#getFor <em>For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>For</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWait#getFor()
	 * @see #getTWait()
	 * @generated
	 */
	EAttribute getTWait_For();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWait#getUntil <em>Until</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Until</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWait#getUntil()
	 * @see #getTWait()
	 * @generated
	 */
	EAttribute getTWait_Until();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile <em>TWhile</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TWhile</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile
	 * @generated
	 */
	EClass getTWhile();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getEmpty <em>Empty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Empty</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getEmpty()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Empty();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getInvoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Invoke</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getInvoke()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Invoke();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getReceive <em>Receive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Receive</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getReceive()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Receive();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getReply <em>Reply</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Reply</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getReply()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Reply();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getAssign <em>Assign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assign</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getAssign()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Assign();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Wait</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getWait()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Wait();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getThrow <em>Throw</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Throw</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getThrow()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Throw();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getTerminate <em>Terminate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Terminate</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getTerminate()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Terminate();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getFlow <em>Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Flow</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getFlow()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Flow();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getSwitch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getSwitch()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Switch();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getWhile <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>While</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getWhile()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_While();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getSequence <em>Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Sequence</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getSequence()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Sequence();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getPick <em>Pick</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pick</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getPick()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Pick();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scope</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getScope()
	 * @see #getTWhile()
	 * @generated
	 */
	EReference getTWhile_Scope();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Condition</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TWhile#getCondition()
	 * @see #getTWhile()
	 * @generated
	 */
	EAttribute getTWhile_Condition();

	/**
	 * Returns the meta object for enum '{@link org.xmlsoap.schemas.ws._2003._03.business.process.PatternType <em>Pattern Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Pattern Type</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PatternType
	 * @generated
	 */
	EEnum getPatternType();

	/**
	 * Returns the meta object for enum '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean <em>TBoolean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TBoolean</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @generated
	 */
	EEnum getTBoolean();

	/**
	 * Returns the meta object for enum '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TRoles <em>TRoles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>TRoles</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TRoles
	 * @generated
	 */
	EEnum getTRoles();

	/**
	 * Returns the meta object for data type '{@link org.xmlsoap.schemas.ws._2003._03.business.process.PatternType <em>Pattern Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Pattern Type Object</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PatternType
	 * @model instanceClass="org.xmlsoap.schemas.ws._2003._03.business.process.PatternType"
	 *        extendedMetaData="name='pattern_._type:Object' baseType='pattern_._type'"
	 * @generated
	 */
	EDataType getPatternTypeObject();

	/**
	 * Returns the meta object for data type '{@link java.util.List <em>Properties Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Properties Type</em>'.
	 * @see java.util.List
	 * @model instanceClass="java.util.List"
	 *        extendedMetaData="name='properties_._type' itemType='http://www.eclipse.org/emf/2003/XMLType#QName'"
	 * @generated
	 */
	EDataType getPropertiesType();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>TBoolean Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TBoolean Expr</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='tBoolean-expr' baseType='http://www.eclipse.org/emf/2003/XMLType#string'"
	 * @generated
	 */
	EDataType getTBooleanExpr();

	/**
	 * Returns the meta object for data type '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean <em>TBoolean Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TBoolean Object</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @model instanceClass="org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean"
	 *        extendedMetaData="name='tBoolean:Object' baseType='tBoolean'"
	 * @generated
	 */
	EDataType getTBooleanObject();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>TDeadline Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TDeadline Expr</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='tDeadline-expr' baseType='http://www.eclipse.org/emf/2003/XMLType#string'"
	 * @generated
	 */
	EDataType getTDeadlineExpr();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>TDuration Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TDuration Expr</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 *        extendedMetaData="name='tDuration-expr' baseType='http://www.eclipse.org/emf/2003/XMLType#string'"
	 * @generated
	 */
	EDataType getTDurationExpr();

	/**
	 * Returns the meta object for data type '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TRoles <em>TRoles Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>TRoles Object</em>'.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TRoles
	 * @model instanceClass="org.xmlsoap.schemas.ws._2003._03.business.process.TRoles"
	 *        extendedMetaData="name='tRoles:Object' baseType='tRoles'"
	 * @generated
	 */
	EDataType getTRolesObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ProcessFactory getProcessFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.CaseTypeImpl <em>Case Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.CaseTypeImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getCaseType()
		 * @generated
		 */
		EClass CASE_TYPE = eINSTANCE.getCaseType();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CASE_TYPE__CONDITION = eINSTANCE.getCaseType_Condition();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.DocumentRootImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__FROM = eINSTANCE.getDocumentRoot_From();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__PROCESS = eINSTANCE.getDocumentRoot_Process();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__TO = eINSTANCE.getDocumentRoot_To();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.PartnerLinkTypeImpl <em>Partner Link Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.PartnerLinkTypeImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getPartnerLinkType()
		 * @generated
		 */
		EClass PARTNER_LINK_TYPE = eINSTANCE.getPartnerLinkType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARTNER_LINK_TYPE__NAME = eINSTANCE.getPartnerLinkType_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityImpl <em>TActivity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTActivity()
		 * @generated
		 */
		EClass TACTIVITY = eINSTANCE.getTActivity();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY__TARGET = eINSTANCE.getTActivity_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY__SOURCE = eINSTANCE.getTActivity_Source();

		/**
		 * The meta object literal for the '<em><b>Join Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TACTIVITY__JOIN_CONDITION = eINSTANCE.getTActivity_JoinCondition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TACTIVITY__NAME = eINSTANCE.getTActivity_Name();

		/**
		 * The meta object literal for the '<em><b>Suppress Join Failure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TACTIVITY__SUPPRESS_JOIN_FAILURE = eINSTANCE.getTActivity_SuppressJoinFailure();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityContainerImpl <em>TActivity Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityContainerImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTActivityContainer()
		 * @generated
		 */
		EClass TACTIVITY_CONTAINER = eINSTANCE.getTActivityContainer();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__EMPTY = eINSTANCE.getTActivityContainer_Empty();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__INVOKE = eINSTANCE.getTActivityContainer_Invoke();

		/**
		 * The meta object literal for the '<em><b>Receive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__RECEIVE = eINSTANCE.getTActivityContainer_Receive();

		/**
		 * The meta object literal for the '<em><b>Reply</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__REPLY = eINSTANCE.getTActivityContainer_Reply();

		/**
		 * The meta object literal for the '<em><b>Assign</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__ASSIGN = eINSTANCE.getTActivityContainer_Assign();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__WAIT = eINSTANCE.getTActivityContainer_Wait();

		/**
		 * The meta object literal for the '<em><b>Throw</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__THROW = eINSTANCE.getTActivityContainer_Throw();

		/**
		 * The meta object literal for the '<em><b>Terminate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__TERMINATE = eINSTANCE.getTActivityContainer_Terminate();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__FLOW = eINSTANCE.getTActivityContainer_Flow();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__SWITCH = eINSTANCE.getTActivityContainer_Switch();

		/**
		 * The meta object literal for the '<em><b>While</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__WHILE = eINSTANCE.getTActivityContainer_While();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__SEQUENCE = eINSTANCE.getTActivityContainer_Sequence();

		/**
		 * The meta object literal for the '<em><b>Pick</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__PICK = eINSTANCE.getTActivityContainer_Pick();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_CONTAINER__SCOPE = eINSTANCE.getTActivityContainer_Scope();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityOrCompensateContainerImpl <em>TActivity Or Compensate Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityOrCompensateContainerImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTActivityOrCompensateContainer()
		 * @generated
		 */
		EClass TACTIVITY_OR_COMPENSATE_CONTAINER = eINSTANCE.getTActivityOrCompensateContainer();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__EMPTY = eINSTANCE.getTActivityOrCompensateContainer_Empty();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__INVOKE = eINSTANCE.getTActivityOrCompensateContainer_Invoke();

		/**
		 * The meta object literal for the '<em><b>Receive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__RECEIVE = eINSTANCE.getTActivityOrCompensateContainer_Receive();

		/**
		 * The meta object literal for the '<em><b>Reply</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__REPLY = eINSTANCE.getTActivityOrCompensateContainer_Reply();

		/**
		 * The meta object literal for the '<em><b>Assign</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__ASSIGN = eINSTANCE.getTActivityOrCompensateContainer_Assign();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__WAIT = eINSTANCE.getTActivityOrCompensateContainer_Wait();

		/**
		 * The meta object literal for the '<em><b>Throw</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__THROW = eINSTANCE.getTActivityOrCompensateContainer_Throw();

		/**
		 * The meta object literal for the '<em><b>Terminate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__TERMINATE = eINSTANCE.getTActivityOrCompensateContainer_Terminate();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__FLOW = eINSTANCE.getTActivityOrCompensateContainer_Flow();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__SWITCH = eINSTANCE.getTActivityOrCompensateContainer_Switch();

		/**
		 * The meta object literal for the '<em><b>While</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__WHILE = eINSTANCE.getTActivityOrCompensateContainer_While();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__SEQUENCE = eINSTANCE.getTActivityOrCompensateContainer_Sequence();

		/**
		 * The meta object literal for the '<em><b>Pick</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__PICK = eINSTANCE.getTActivityOrCompensateContainer_Pick();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__SCOPE = eINSTANCE.getTActivityOrCompensateContainer_Scope();

		/**
		 * The meta object literal for the '<em><b>Compensate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TACTIVITY_OR_COMPENSATE_CONTAINER__COMPENSATE = eINSTANCE.getTActivityOrCompensateContainer_Compensate();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TAssignImpl <em>TAssign</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TAssignImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTAssign()
		 * @generated
		 */
		EClass TASSIGN = eINSTANCE.getTAssign();

		/**
		 * The meta object literal for the '<em><b>Copy</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TASSIGN__COPY = eINSTANCE.getTAssign_Copy();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCatchImpl <em>TCatch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCatchImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCatch()
		 * @generated
		 */
		EClass TCATCH = eINSTANCE.getTCatch();

		/**
		 * The meta object literal for the '<em><b>Fault Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCATCH__FAULT_NAME = eINSTANCE.getTCatch_FaultName();

		/**
		 * The meta object literal for the '<em><b>Fault Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCATCH__FAULT_VARIABLE = eINSTANCE.getTCatch_FaultVariable();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCompensateImpl <em>TCompensate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCompensateImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCompensate()
		 * @generated
		 */
		EClass TCOMPENSATE = eINSTANCE.getTCompensate();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCOMPENSATE__SCOPE = eINSTANCE.getTCompensate_Scope();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCompensationHandlerImpl <em>TCompensation Handler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCompensationHandlerImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCompensationHandler()
		 * @generated
		 */
		EClass TCOMPENSATION_HANDLER = eINSTANCE.getTCompensationHandler();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCopyImpl <em>TCopy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCopyImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCopy()
		 * @generated
		 */
		EClass TCOPY = eINSTANCE.getTCopy();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCOPY__FROM = eINSTANCE.getTCopy_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCOPY__TO = eINSTANCE.getTCopy_To();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationImpl <em>TCorrelation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelation()
		 * @generated
		 */
		EClass TCORRELATION = eINSTANCE.getTCorrelation();

		/**
		 * The meta object literal for the '<em><b>Initiate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCORRELATION__INITIATE = eINSTANCE.getTCorrelation_Initiate();

		/**
		 * The meta object literal for the '<em><b>Set</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCORRELATION__SET = eINSTANCE.getTCorrelation_Set();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationsImpl <em>TCorrelations</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationsImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelations()
		 * @generated
		 */
		EClass TCORRELATIONS = eINSTANCE.getTCorrelations();

		/**
		 * The meta object literal for the '<em><b>Correlation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCORRELATIONS__CORRELATION = eINSTANCE.getTCorrelations_Correlation();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationSetImpl <em>TCorrelation Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationSetImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelationSet()
		 * @generated
		 */
		EClass TCORRELATION_SET = eINSTANCE.getTCorrelationSet();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCORRELATION_SET__NAME = eINSTANCE.getTCorrelationSet_Name();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCORRELATION_SET__PROPERTIES = eINSTANCE.getTCorrelationSet_Properties();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationSetsImpl <em>TCorrelation Sets</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationSetsImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelationSets()
		 * @generated
		 */
		EClass TCORRELATION_SETS = eINSTANCE.getTCorrelationSets();

		/**
		 * The meta object literal for the '<em><b>Correlation Set</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCORRELATION_SETS__CORRELATION_SET = eINSTANCE.getTCorrelationSets_CorrelationSet();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationsWithPatternImpl <em>TCorrelations With Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationsWithPatternImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelationsWithPattern()
		 * @generated
		 */
		EClass TCORRELATIONS_WITH_PATTERN = eINSTANCE.getTCorrelationsWithPattern();

		/**
		 * The meta object literal for the '<em><b>Correlation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TCORRELATIONS_WITH_PATTERN__CORRELATION = eINSTANCE.getTCorrelationsWithPattern_Correlation();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationWithPatternImpl <em>TCorrelation With Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationWithPatternImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTCorrelationWithPattern()
		 * @generated
		 */
		EClass TCORRELATION_WITH_PATTERN = eINSTANCE.getTCorrelationWithPattern();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TCORRELATION_WITH_PATTERN__PATTERN = eINSTANCE.getTCorrelationWithPattern_Pattern();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEmptyImpl <em>TEmpty</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEmptyImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTEmpty()
		 * @generated
		 */
		EClass TEMPTY = eINSTANCE.getTEmpty();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEventHandlersImpl <em>TEvent Handlers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEventHandlersImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTEventHandlers()
		 * @generated
		 */
		EClass TEVENT_HANDLERS = eINSTANCE.getTEventHandlers();

		/**
		 * The meta object literal for the '<em><b>On Message</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEVENT_HANDLERS__ON_MESSAGE = eINSTANCE.getTEventHandlers_OnMessage();

		/**
		 * The meta object literal for the '<em><b>On Alarm</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEVENT_HANDLERS__ON_ALARM = eINSTANCE.getTEventHandlers_OnAlarm();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TExtensibleElementsImpl <em>TExtensible Elements</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TExtensibleElementsImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTExtensibleElements()
		 * @generated
		 */
		EClass TEXTENSIBLE_ELEMENTS = eINSTANCE.getTExtensibleElements();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBLE_ELEMENTS__ANY = eINSTANCE.getTExtensibleElements_Any();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBLE_ELEMENTS__ANY_ATTRIBUTE = eINSTANCE.getTExtensibleElements_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFaultHandlersImpl <em>TFault Handlers</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFaultHandlersImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTFaultHandlers()
		 * @generated
		 */
		EClass TFAULT_HANDLERS = eINSTANCE.getTFaultHandlers();

		/**
		 * The meta object literal for the '<em><b>Catch</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFAULT_HANDLERS__CATCH = eINSTANCE.getTFaultHandlers_Catch();

		/**
		 * The meta object literal for the '<em><b>Catch All</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFAULT_HANDLERS__CATCH_ALL = eINSTANCE.getTFaultHandlers_CatchAll();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl <em>TFlow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFlowImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTFlow()
		 * @generated
		 */
		EClass TFLOW = eINSTANCE.getTFlow();

		/**
		 * The meta object literal for the '<em><b>Links</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__LINKS = eINSTANCE.getTFlow_Links();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFLOW__ACTIVITY = eINSTANCE.getTFlow_Activity();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__EMPTY = eINSTANCE.getTFlow_Empty();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__INVOKE = eINSTANCE.getTFlow_Invoke();

		/**
		 * The meta object literal for the '<em><b>Receive</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__RECEIVE = eINSTANCE.getTFlow_Receive();

		/**
		 * The meta object literal for the '<em><b>Reply</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__REPLY = eINSTANCE.getTFlow_Reply();

		/**
		 * The meta object literal for the '<em><b>Assign</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__ASSIGN = eINSTANCE.getTFlow_Assign();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__WAIT = eINSTANCE.getTFlow_Wait();

		/**
		 * The meta object literal for the '<em><b>Throw</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__THROW = eINSTANCE.getTFlow_Throw();

		/**
		 * The meta object literal for the '<em><b>Terminate</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__TERMINATE = eINSTANCE.getTFlow_Terminate();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__FLOW = eINSTANCE.getTFlow_Flow();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__SWITCH = eINSTANCE.getTFlow_Switch();

		/**
		 * The meta object literal for the '<em><b>While</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__WHILE = eINSTANCE.getTFlow_While();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__SEQUENCE = eINSTANCE.getTFlow_Sequence();

		/**
		 * The meta object literal for the '<em><b>Pick</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__PICK = eINSTANCE.getTFlow_Pick();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TFLOW__SCOPE = eINSTANCE.getTFlow_Scope();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl <em>TFrom</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TFromImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTFrom()
		 * @generated
		 */
		EClass TFROM = eINSTANCE.getTFrom();

		/**
		 * The meta object literal for the '<em><b>Endpoint Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__ENDPOINT_REFERENCE = eINSTANCE.getTFrom_EndpointReference();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__EXPRESSION = eINSTANCE.getTFrom_Expression();

		/**
		 * The meta object literal for the '<em><b>Opaque</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__OPAQUE = eINSTANCE.getTFrom_Opaque();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__PART = eINSTANCE.getTFrom_Part();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__PARTNER_LINK = eINSTANCE.getTFrom_PartnerLink();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__PROPERTY = eINSTANCE.getTFrom_Property();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__QUERY = eINSTANCE.getTFrom_Query();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFROM__VARIABLE = eINSTANCE.getTFrom_Variable();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TInvokeImpl <em>TInvoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TInvokeImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTInvoke()
		 * @generated
		 */
		EClass TINVOKE = eINSTANCE.getTInvoke();

		/**
		 * The meta object literal for the '<em><b>Correlations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TINVOKE__CORRELATIONS = eINSTANCE.getTInvoke_Correlations();

		/**
		 * The meta object literal for the '<em><b>Catch</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TINVOKE__CATCH = eINSTANCE.getTInvoke_Catch();

		/**
		 * The meta object literal for the '<em><b>Catch All</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TINVOKE__CATCH_ALL = eINSTANCE.getTInvoke_CatchAll();

		/**
		 * The meta object literal for the '<em><b>Compensation Handler</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TINVOKE__COMPENSATION_HANDLER = eINSTANCE.getTInvoke_CompensationHandler();

		/**
		 * The meta object literal for the '<em><b>Input Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TINVOKE__INPUT_VARIABLE = eINSTANCE.getTInvoke_InputVariable();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TINVOKE__OPERATION = eINSTANCE.getTInvoke_Operation();

		/**
		 * The meta object literal for the '<em><b>Output Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TINVOKE__OUTPUT_VARIABLE = eINSTANCE.getTInvoke_OutputVariable();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TINVOKE__PARTNER_LINK = eINSTANCE.getTInvoke_PartnerLink();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TINVOKE__PORT_TYPE = eINSTANCE.getTInvoke_PortType();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TLinkImpl <em>TLink</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TLinkImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTLink()
		 * @generated
		 */
		EClass TLINK = eINSTANCE.getTLink();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLINK__NAME = eINSTANCE.getTLink_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TLinksImpl <em>TLinks</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TLinksImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTLinks()
		 * @generated
		 */
		EClass TLINKS = eINSTANCE.getTLinks();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLINKS__LINK = eINSTANCE.getTLinks_Link();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnAlarmImpl <em>TOn Alarm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnAlarmImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTOnAlarm()
		 * @generated
		 */
		EClass TON_ALARM = eINSTANCE.getTOnAlarm();

		/**
		 * The meta object literal for the '<em><b>For</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TON_ALARM__FOR = eINSTANCE.getTOnAlarm_For();

		/**
		 * The meta object literal for the '<em><b>Until</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TON_ALARM__UNTIL = eINSTANCE.getTOnAlarm_Until();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl <em>TOn Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TOnMessageImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTOnMessage()
		 * @generated
		 */
		EClass TON_MESSAGE = eINSTANCE.getTOnMessage();

		/**
		 * The meta object literal for the '<em><b>Correlations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__CORRELATIONS = eINSTANCE.getTOnMessage_Correlations();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__EMPTY = eINSTANCE.getTOnMessage_Empty();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__INVOKE = eINSTANCE.getTOnMessage_Invoke();

		/**
		 * The meta object literal for the '<em><b>Receive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__RECEIVE = eINSTANCE.getTOnMessage_Receive();

		/**
		 * The meta object literal for the '<em><b>Reply</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__REPLY = eINSTANCE.getTOnMessage_Reply();

		/**
		 * The meta object literal for the '<em><b>Assign</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__ASSIGN = eINSTANCE.getTOnMessage_Assign();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__WAIT = eINSTANCE.getTOnMessage_Wait();

		/**
		 * The meta object literal for the '<em><b>Throw</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__THROW = eINSTANCE.getTOnMessage_Throw();

		/**
		 * The meta object literal for the '<em><b>Terminate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__TERMINATE = eINSTANCE.getTOnMessage_Terminate();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__FLOW = eINSTANCE.getTOnMessage_Flow();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__SWITCH = eINSTANCE.getTOnMessage_Switch();

		/**
		 * The meta object literal for the '<em><b>While</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__WHILE = eINSTANCE.getTOnMessage_While();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__SEQUENCE = eINSTANCE.getTOnMessage_Sequence();

		/**
		 * The meta object literal for the '<em><b>Pick</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__PICK = eINSTANCE.getTOnMessage_Pick();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TON_MESSAGE__SCOPE = eINSTANCE.getTOnMessage_Scope();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TON_MESSAGE__OPERATION = eINSTANCE.getTOnMessage_Operation();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TON_MESSAGE__PARTNER_LINK = eINSTANCE.getTOnMessage_PartnerLink();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TON_MESSAGE__PORT_TYPE = eINSTANCE.getTOnMessage_PortType();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TON_MESSAGE__VARIABLE = eINSTANCE.getTOnMessage_Variable();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.ToTypeImpl <em>To Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ToTypeImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getToType()
		 * @generated
		 */
		EClass TO_TYPE = eINSTANCE.getToType();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerImpl <em>TPartner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPartner()
		 * @generated
		 */
		EClass TPARTNER = eINSTANCE.getTPartner();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPARTNER__PARTNER_LINK = eINSTANCE.getTPartner_PartnerLink();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPARTNER__NAME = eINSTANCE.getTPartner_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinkImpl <em>TPartner Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinkImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPartnerLink()
		 * @generated
		 */
		EClass TPARTNER_LINK = eINSTANCE.getTPartnerLink();

		/**
		 * The meta object literal for the '<em><b>My Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPARTNER_LINK__MY_ROLE = eINSTANCE.getTPartnerLink_MyRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPARTNER_LINK__NAME = eINSTANCE.getTPartnerLink_Name();

		/**
		 * The meta object literal for the '<em><b>Partner Link Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPARTNER_LINK__PARTNER_LINK_TYPE = eINSTANCE.getTPartnerLink_PartnerLinkType();

		/**
		 * The meta object literal for the '<em><b>Partner Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPARTNER_LINK__PARTNER_ROLE = eINSTANCE.getTPartnerLink_PartnerRole();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinksImpl <em>TPartner Links</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnerLinksImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPartnerLinks()
		 * @generated
		 */
		EClass TPARTNER_LINKS = eINSTANCE.getTPartnerLinks();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPARTNER_LINKS__PARTNER_LINK = eINSTANCE.getTPartnerLinks_PartnerLink();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnersImpl <em>TPartners</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPartnersImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPartners()
		 * @generated
		 */
		EClass TPARTNERS = eINSTANCE.getTPartners();

		/**
		 * The meta object literal for the '<em><b>Partner</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPARTNERS__PARTNER = eINSTANCE.getTPartners_Partner();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPickImpl <em>TPick</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPickImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTPick()
		 * @generated
		 */
		EClass TPICK = eINSTANCE.getTPick();

		/**
		 * The meta object literal for the '<em><b>On Message</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPICK__ON_MESSAGE = eINSTANCE.getTPick_OnMessage();

		/**
		 * The meta object literal for the '<em><b>On Alarm</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPICK__ON_ALARM = eINSTANCE.getTPick_OnAlarm();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPICK__CREATE_INSTANCE = eINSTANCE.getTPick_CreateInstance();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TProcessImpl <em>TProcess</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TProcessImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTProcess()
		 * @generated
		 */
		EClass TPROCESS = eINSTANCE.getTProcess();

		/**
		 * The meta object literal for the '<em><b>Partner Links</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__PARTNER_LINKS = eINSTANCE.getTProcess_PartnerLinks();

		/**
		 * The meta object literal for the '<em><b>Partners</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__PARTNERS = eINSTANCE.getTProcess_Partners();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__VARIABLES = eINSTANCE.getTProcess_Variables();

		/**
		 * The meta object literal for the '<em><b>Correlation Sets</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__CORRELATION_SETS = eINSTANCE.getTProcess_CorrelationSets();

		/**
		 * The meta object literal for the '<em><b>Fault Handlers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__FAULT_HANDLERS = eINSTANCE.getTProcess_FaultHandlers();

		/**
		 * The meta object literal for the '<em><b>Compensation Handler</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__COMPENSATION_HANDLER = eINSTANCE.getTProcess_CompensationHandler();

		/**
		 * The meta object literal for the '<em><b>Event Handlers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__EVENT_HANDLERS = eINSTANCE.getTProcess_EventHandlers();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__EMPTY = eINSTANCE.getTProcess_Empty();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__INVOKE = eINSTANCE.getTProcess_Invoke();

		/**
		 * The meta object literal for the '<em><b>Receive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__RECEIVE = eINSTANCE.getTProcess_Receive();

		/**
		 * The meta object literal for the '<em><b>Reply</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__REPLY = eINSTANCE.getTProcess_Reply();

		/**
		 * The meta object literal for the '<em><b>Assign</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__ASSIGN = eINSTANCE.getTProcess_Assign();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__WAIT = eINSTANCE.getTProcess_Wait();

		/**
		 * The meta object literal for the '<em><b>Throw</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__THROW = eINSTANCE.getTProcess_Throw();

		/**
		 * The meta object literal for the '<em><b>Terminate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__TERMINATE = eINSTANCE.getTProcess_Terminate();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__FLOW = eINSTANCE.getTProcess_Flow();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__SWITCH = eINSTANCE.getTProcess_Switch();

		/**
		 * The meta object literal for the '<em><b>While</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__WHILE = eINSTANCE.getTProcess_While();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__SEQUENCE = eINSTANCE.getTProcess_Sequence();

		/**
		 * The meta object literal for the '<em><b>Pick</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__PICK = eINSTANCE.getTProcess_Pick();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPROCESS__SCOPE = eINSTANCE.getTProcess_Scope();

		/**
		 * The meta object literal for the '<em><b>Abstract Process</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROCESS__ABSTRACT_PROCESS = eINSTANCE.getTProcess_AbstractProcess();

		/**
		 * The meta object literal for the '<em><b>Enable Instance Compensation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROCESS__ENABLE_INSTANCE_COMPENSATION = eINSTANCE.getTProcess_EnableInstanceCompensation();

		/**
		 * The meta object literal for the '<em><b>Expression Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROCESS__EXPRESSION_LANGUAGE = eINSTANCE.getTProcess_ExpressionLanguage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROCESS__NAME = eINSTANCE.getTProcess_Name();

		/**
		 * The meta object literal for the '<em><b>Query Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROCESS__QUERY_LANGUAGE = eINSTANCE.getTProcess_QueryLanguage();

		/**
		 * The meta object literal for the '<em><b>Suppress Join Failure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROCESS__SUPPRESS_JOIN_FAILURE = eINSTANCE.getTProcess_SuppressJoinFailure();

		/**
		 * The meta object literal for the '<em><b>Target Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPROCESS__TARGET_NAMESPACE = eINSTANCE.getTProcess_TargetNamespace();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TReceiveImpl <em>TReceive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TReceiveImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTReceive()
		 * @generated
		 */
		EClass TRECEIVE = eINSTANCE.getTReceive();

		/**
		 * The meta object literal for the '<em><b>Correlations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRECEIVE__CORRELATIONS = eINSTANCE.getTReceive_Correlations();

		/**
		 * The meta object literal for the '<em><b>Create Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRECEIVE__CREATE_INSTANCE = eINSTANCE.getTReceive_CreateInstance();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRECEIVE__OPERATION = eINSTANCE.getTReceive_Operation();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRECEIVE__PARTNER_LINK = eINSTANCE.getTReceive_PartnerLink();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRECEIVE__PORT_TYPE = eINSTANCE.getTReceive_PortType();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRECEIVE__VARIABLE = eINSTANCE.getTReceive_Variable();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TReplyImpl <em>TReply</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TReplyImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTReply()
		 * @generated
		 */
		EClass TREPLY = eINSTANCE.getTReply();

		/**
		 * The meta object literal for the '<em><b>Correlations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TREPLY__CORRELATIONS = eINSTANCE.getTReply_Correlations();

		/**
		 * The meta object literal for the '<em><b>Fault Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREPLY__FAULT_NAME = eINSTANCE.getTReply_FaultName();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREPLY__OPERATION = eINSTANCE.getTReply_Operation();

		/**
		 * The meta object literal for the '<em><b>Partner Link</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREPLY__PARTNER_LINK = eINSTANCE.getTReply_PartnerLink();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREPLY__PORT_TYPE = eINSTANCE.getTReply_PortType();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TREPLY__VARIABLE = eINSTANCE.getTReply_Variable();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl <em>TScope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TScopeImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTScope()
		 * @generated
		 */
		EClass TSCOPE = eINSTANCE.getTScope();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__VARIABLES = eINSTANCE.getTScope_Variables();

		/**
		 * The meta object literal for the '<em><b>Correlation Sets</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__CORRELATION_SETS = eINSTANCE.getTScope_CorrelationSets();

		/**
		 * The meta object literal for the '<em><b>Fault Handlers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__FAULT_HANDLERS = eINSTANCE.getTScope_FaultHandlers();

		/**
		 * The meta object literal for the '<em><b>Compensation Handler</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__COMPENSATION_HANDLER = eINSTANCE.getTScope_CompensationHandler();

		/**
		 * The meta object literal for the '<em><b>Event Handlers</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__EVENT_HANDLERS = eINSTANCE.getTScope_EventHandlers();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__EMPTY = eINSTANCE.getTScope_Empty();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__INVOKE = eINSTANCE.getTScope_Invoke();

		/**
		 * The meta object literal for the '<em><b>Receive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__RECEIVE = eINSTANCE.getTScope_Receive();

		/**
		 * The meta object literal for the '<em><b>Reply</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__REPLY = eINSTANCE.getTScope_Reply();

		/**
		 * The meta object literal for the '<em><b>Assign</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__ASSIGN = eINSTANCE.getTScope_Assign();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__WAIT = eINSTANCE.getTScope_Wait();

		/**
		 * The meta object literal for the '<em><b>Throw</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__THROW = eINSTANCE.getTScope_Throw();

		/**
		 * The meta object literal for the '<em><b>Terminate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__TERMINATE = eINSTANCE.getTScope_Terminate();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__FLOW = eINSTANCE.getTScope_Flow();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__SWITCH = eINSTANCE.getTScope_Switch();

		/**
		 * The meta object literal for the '<em><b>While</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__WHILE = eINSTANCE.getTScope_While();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__SEQUENCE = eINSTANCE.getTScope_Sequence();

		/**
		 * The meta object literal for the '<em><b>Pick</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__PICK = eINSTANCE.getTScope_Pick();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSCOPE__SCOPE = eINSTANCE.getTScope_Scope();

		/**
		 * The meta object literal for the '<em><b>Variable Access Serializable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSCOPE__VARIABLE_ACCESS_SERIALIZABLE = eINSTANCE.getTScope_VariableAccessSerializable();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl <em>TSequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSequenceImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTSequence()
		 * @generated
		 */
		EClass TSEQUENCE = eINSTANCE.getTSequence();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSEQUENCE__ACTIVITY = eINSTANCE.getTSequence_Activity();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__EMPTY = eINSTANCE.getTSequence_Empty();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__INVOKE = eINSTANCE.getTSequence_Invoke();

		/**
		 * The meta object literal for the '<em><b>Receive</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__RECEIVE = eINSTANCE.getTSequence_Receive();

		/**
		 * The meta object literal for the '<em><b>Reply</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__REPLY = eINSTANCE.getTSequence_Reply();

		/**
		 * The meta object literal for the '<em><b>Assign</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__ASSIGN = eINSTANCE.getTSequence_Assign();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__WAIT = eINSTANCE.getTSequence_Wait();

		/**
		 * The meta object literal for the '<em><b>Throw</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__THROW = eINSTANCE.getTSequence_Throw();

		/**
		 * The meta object literal for the '<em><b>Terminate</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__TERMINATE = eINSTANCE.getTSequence_Terminate();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__FLOW = eINSTANCE.getTSequence_Flow();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__SWITCH = eINSTANCE.getTSequence_Switch();

		/**
		 * The meta object literal for the '<em><b>While</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__WHILE = eINSTANCE.getTSequence_While();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__SEQUENCE = eINSTANCE.getTSequence_Sequence();

		/**
		 * The meta object literal for the '<em><b>Pick</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__PICK = eINSTANCE.getTSequence_Pick();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSEQUENCE__SCOPE = eINSTANCE.getTSequence_Scope();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSourceImpl <em>TSource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSourceImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTSource()
		 * @generated
		 */
		EClass TSOURCE = eINSTANCE.getTSource();

		/**
		 * The meta object literal for the '<em><b>Link Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSOURCE__LINK_NAME = eINSTANCE.getTSource_LinkName();

		/**
		 * The meta object literal for the '<em><b>Transition Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSOURCE__TRANSITION_CONDITION = eINSTANCE.getTSource_TransitionCondition();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSwitchImpl <em>TSwitch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSwitchImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTSwitch()
		 * @generated
		 */
		EClass TSWITCH = eINSTANCE.getTSwitch();

		/**
		 * The meta object literal for the '<em><b>Case</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSWITCH__CASE = eINSTANCE.getTSwitch_Case();

		/**
		 * The meta object literal for the '<em><b>Otherwise</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSWITCH__OTHERWISE = eINSTANCE.getTSwitch_Otherwise();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TTargetImpl <em>TTarget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TTargetImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTTarget()
		 * @generated
		 */
		EClass TTARGET = eINSTANCE.getTTarget();

		/**
		 * The meta object literal for the '<em><b>Link Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTARGET__LINK_NAME = eINSTANCE.getTTarget_LinkName();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TTerminateImpl <em>TTerminate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TTerminateImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTTerminate()
		 * @generated
		 */
		EClass TTERMINATE = eINSTANCE.getTTerminate();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TThrowImpl <em>TThrow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TThrowImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTThrow()
		 * @generated
		 */
		EClass TTHROW = eINSTANCE.getTThrow();

		/**
		 * The meta object literal for the '<em><b>Fault Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTHROW__FAULT_NAME = eINSTANCE.getTThrow_FaultName();

		/**
		 * The meta object literal for the '<em><b>Fault Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TTHROW__FAULT_VARIABLE = eINSTANCE.getTThrow_FaultVariable();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TVariableImpl <em>TVariable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TVariableImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTVariable()
		 * @generated
		 */
		EClass TVARIABLE = eINSTANCE.getTVariable();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TVARIABLE__ELEMENT = eINSTANCE.getTVariable_Element();

		/**
		 * The meta object literal for the '<em><b>Message Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TVARIABLE__MESSAGE_TYPE = eINSTANCE.getTVariable_MessageType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TVARIABLE__NAME = eINSTANCE.getTVariable_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TVARIABLE__TYPE = eINSTANCE.getTVariable_Type();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TVARIABLE__ANY_ATTRIBUTE = eINSTANCE.getTVariable_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TVariablesImpl <em>TVariables</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TVariablesImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTVariables()
		 * @generated
		 */
		EClass TVARIABLES = eINSTANCE.getTVariables();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TVARIABLES__VARIABLE = eINSTANCE.getTVariables_Variable();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWaitImpl <em>TWait</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWaitImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTWait()
		 * @generated
		 */
		EClass TWAIT = eINSTANCE.getTWait();

		/**
		 * The meta object literal for the '<em><b>For</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWAIT__FOR = eINSTANCE.getTWait_For();

		/**
		 * The meta object literal for the '<em><b>Until</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWAIT__UNTIL = eINSTANCE.getTWait_Until();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl <em>TWhile</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.TWhileImpl
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTWhile()
		 * @generated
		 */
		EClass TWHILE = eINSTANCE.getTWhile();

		/**
		 * The meta object literal for the '<em><b>Empty</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__EMPTY = eINSTANCE.getTWhile_Empty();

		/**
		 * The meta object literal for the '<em><b>Invoke</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__INVOKE = eINSTANCE.getTWhile_Invoke();

		/**
		 * The meta object literal for the '<em><b>Receive</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__RECEIVE = eINSTANCE.getTWhile_Receive();

		/**
		 * The meta object literal for the '<em><b>Reply</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__REPLY = eINSTANCE.getTWhile_Reply();

		/**
		 * The meta object literal for the '<em><b>Assign</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__ASSIGN = eINSTANCE.getTWhile_Assign();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__WAIT = eINSTANCE.getTWhile_Wait();

		/**
		 * The meta object literal for the '<em><b>Throw</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__THROW = eINSTANCE.getTWhile_Throw();

		/**
		 * The meta object literal for the '<em><b>Terminate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__TERMINATE = eINSTANCE.getTWhile_Terminate();

		/**
		 * The meta object literal for the '<em><b>Flow</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__FLOW = eINSTANCE.getTWhile_Flow();

		/**
		 * The meta object literal for the '<em><b>Switch</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__SWITCH = eINSTANCE.getTWhile_Switch();

		/**
		 * The meta object literal for the '<em><b>While</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__WHILE = eINSTANCE.getTWhile_While();

		/**
		 * The meta object literal for the '<em><b>Sequence</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__SEQUENCE = eINSTANCE.getTWhile_Sequence();

		/**
		 * The meta object literal for the '<em><b>Pick</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__PICK = eINSTANCE.getTWhile_Pick();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TWHILE__SCOPE = eINSTANCE.getTWhile_Scope();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TWHILE__CONDITION = eINSTANCE.getTWhile_Condition();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.PatternType <em>Pattern Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PatternType
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getPatternType()
		 * @generated
		 */
		EEnum PATTERN_TYPE = eINSTANCE.getPatternType();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean <em>TBoolean</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTBoolean()
		 * @generated
		 */
		EEnum TBOOLEAN = eINSTANCE.getTBoolean();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TRoles <em>TRoles</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TRoles
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTRoles()
		 * @generated
		 */
		EEnum TROLES = eINSTANCE.getTRoles();

		/**
		 * The meta object literal for the '<em>Pattern Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.PatternType
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getPatternTypeObject()
		 * @generated
		 */
		EDataType PATTERN_TYPE_OBJECT = eINSTANCE.getPatternTypeObject();

		/**
		 * The meta object literal for the '<em>Properties Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.List
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getPropertiesType()
		 * @generated
		 */
		EDataType PROPERTIES_TYPE = eINSTANCE.getPropertiesType();

		/**
		 * The meta object literal for the '<em>TBoolean Expr</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTBooleanExpr()
		 * @generated
		 */
		EDataType TBOOLEAN_EXPR = eINSTANCE.getTBooleanExpr();

		/**
		 * The meta object literal for the '<em>TBoolean Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTBooleanObject()
		 * @generated
		 */
		EDataType TBOOLEAN_OBJECT = eINSTANCE.getTBooleanObject();

		/**
		 * The meta object literal for the '<em>TDeadline Expr</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTDeadlineExpr()
		 * @generated
		 */
		EDataType TDEADLINE_EXPR = eINSTANCE.getTDeadlineExpr();

		/**
		 * The meta object literal for the '<em>TDuration Expr</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTDurationExpr()
		 * @generated
		 */
		EDataType TDURATION_EXPR = eINSTANCE.getTDurationExpr();

		/**
		 * The meta object literal for the '<em>TRoles Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TRoles
		 * @see org.xmlsoap.schemas.ws._2003._03.business.process.impl.ProcessPackageImpl#getTRolesObject()
		 * @generated
		 */
		EDataType TROLES_OBJECT = eINSTANCE.getTRolesObject();

	}

} //ProcessPackage
