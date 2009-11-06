/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.xmlsoap.schemas.wsdl.WsdlFactory
 * @model kind="package"
 * @generated
 */
public interface WsdlPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "wsdl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://schemas.xmlsoap.org/wsdl/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "wsdl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	WsdlPackage eINSTANCE = org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.DocumentRootImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 0;

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
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__DEFINITIONS = 3;

	/**
	 * The feature id for the '<em><b>Array Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ARRAY_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__REQUIRED = 5;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TDocumentedImpl <em>TDocumented</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TDocumentedImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTDocumented()
	 * @generated
	 */
	int TDOCUMENTED = 7;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDOCUMENTED__DOCUMENTATION = 0;

	/**
	 * The number of structural features of the '<em>TDocumented</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDOCUMENTED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TExtensibleDocumentedImpl <em>TExtensible Documented</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TExtensibleDocumentedImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTExtensibleDocumented()
	 * @generated
	 */
	int TEXTENSIBLE_DOCUMENTED = 10;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_DOCUMENTED__DOCUMENTATION = TDOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_DOCUMENTED__ANY = TDOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TExtensible Documented</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT = TDOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TBindingImpl <em>TBinding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TBindingImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTBinding()
	 * @generated
	 */
	int TBINDING = 1;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING__OPERATION = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING__NAME = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING__TYPE = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TBinding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TBindingOperationImpl <em>TBinding Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TBindingOperationImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTBindingOperation()
	 * @generated
	 */
	int TBINDING_OPERATION = 2;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION__INPUT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION__OUTPUT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fault</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION__FAULT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION__NAME = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>TBinding Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TBindingOperationFaultImpl <em>TBinding Operation Fault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TBindingOperationFaultImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTBindingOperationFault()
	 * @generated
	 */
	int TBINDING_OPERATION_FAULT = 3;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION_FAULT__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION_FAULT__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION_FAULT__NAME = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TBinding Operation Fault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION_FAULT_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TBindingOperationMessageImpl <em>TBinding Operation Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TBindingOperationMessageImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTBindingOperationMessage()
	 * @generated
	 */
	int TBINDING_OPERATION_MESSAGE = 4;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION_MESSAGE__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION_MESSAGE__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION_MESSAGE__NAME = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TBinding Operation Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TBINDING_OPERATION_MESSAGE_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TDefinitionsImpl <em>TDefinitions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TDefinitionsImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTDefinitions()
	 * @generated
	 */
	int TDEFINITIONS = 5;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The feature id for the '<em><b>Any Top Level Optional Element</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__ANY_TOP_LEVEL_OPTIONAL_ELEMENT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__IMPORT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__TYPES = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__MESSAGE = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__PORT_TYPE = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__BINDING = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__SERVICE = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__NAME = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Target Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS__TARGET_NAMESPACE = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>TDefinitions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDEFINITIONS_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TDocumentationImpl <em>TDocumentation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TDocumentationImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTDocumentation()
	 * @generated
	 */
	int TDOCUMENTATION = 6;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDOCUMENTATION__MIXED = 0;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDOCUMENTATION__ANY = 1;

	/**
	 * The number of structural features of the '<em>TDocumentation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TDOCUMENTATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TExtensibilityElementImpl <em>TExtensibility Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TExtensibilityElementImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTExtensibilityElement()
	 * @generated
	 */
	int TEXTENSIBILITY_ELEMENT = 8;

	/**
	 * The feature id for the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBILITY_ELEMENT__REQUIRED = 0;

	/**
	 * The number of structural features of the '<em>TExtensibility Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBILITY_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TExtensibleAttributesDocumentedImpl <em>TExtensible Attributes Documented</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TExtensibleAttributesDocumentedImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTExtensibleAttributesDocumented()
	 * @generated
	 */
	int TEXTENSIBLE_ATTRIBUTES_DOCUMENTED = 9;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__DOCUMENTATION = TDOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__ANY_ATTRIBUTE = TDOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>TExtensible Attributes Documented</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT = TDOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TFaultImpl <em>TFault</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TFaultImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTFault()
	 * @generated
	 */
	int TFAULT = 11;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT__DOCUMENTATION = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT__ANY_ATTRIBUTE = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT__MESSAGE = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT__NAME = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TFault</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TFAULT_FEATURE_COUNT = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TImportImpl <em>TImport</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TImportImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTImport()
	 * @generated
	 */
	int TIMPORT = 12;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__DOCUMENTATION = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__ANY_ATTRIBUTE = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__LOCATION = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT__NAMESPACE = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TImport</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMPORT_FEATURE_COUNT = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TMessageImpl <em>TMessage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TMessageImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTMessage()
	 * @generated
	 */
	int TMESSAGE = 13;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMESSAGE__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMESSAGE__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The feature id for the '<em><b>Part</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMESSAGE__PART = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMESSAGE__NAME = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TMessage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TMESSAGE_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl <em>TOperation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TOperationImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTOperation()
	 * @generated
	 */
	int TOPERATION = 14;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__INPUT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Output</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__OUTPUT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fault</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__FAULT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Output1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__OUTPUT1 = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Input1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__INPUT1 = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Fault1</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__FAULT1 = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__NAME = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parameter Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION__PARAMETER_ORDER = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>TOperation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOPERATION_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TParamImpl <em>TParam</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TParamImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTParam()
	 * @generated
	 */
	int TPARAM = 15;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAM__DOCUMENTATION = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAM__ANY_ATTRIBUTE = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAM__MESSAGE = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAM__NAME = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TParam</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPARAM_FEATURE_COUNT = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TPartImpl <em>TPart</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TPartImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTPart()
	 * @generated
	 */
	int TPART = 16;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPART__DOCUMENTATION = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPART__ANY_ATTRIBUTE = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Element</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPART__ELEMENT = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPART__NAME = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPART__TYPE = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>TPart</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPART_FEATURE_COUNT = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TPortImpl <em>TPort</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TPortImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTPort()
	 * @generated
	 */
	int TPORT = 17;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT__BINDING = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT__NAME = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TPort</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TPortTypeImpl <em>TPort Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TPortTypeImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTPortType()
	 * @generated
	 */
	int TPORT_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT_TYPE__DOCUMENTATION = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any Attribute</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT_TYPE__ANY_ATTRIBUTE = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__ANY_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT_TYPE__OPERATION = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT_TYPE__NAME = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TPort Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TPORT_TYPE_FEATURE_COUNT = TEXTENSIBLE_ATTRIBUTES_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TServiceImpl <em>TService</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TServiceImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTService()
	 * @generated
	 */
	int TSERVICE = 19;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The feature id for the '<em><b>Port</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE__PORT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE__NAME = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>TService</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TSERVICE_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.xmlsoap.schemas.wsdl.impl.TTypesImpl <em>TTypes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.xmlsoap.schemas.wsdl.impl.TTypesImpl
	 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTTypes()
	 * @generated
	 */
	int TTYPES = 20;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTYPES__DOCUMENTATION = TEXTENSIBLE_DOCUMENTED__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Any</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTYPES__ANY = TEXTENSIBLE_DOCUMENTED__ANY;

	/**
	 * The number of structural features of the '<em>TTypes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TTYPES_FEATURE_COUNT = TEXTENSIBLE_DOCUMENTED_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.xmlsoap.schemas.wsdl.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.xmlsoap.schemas.wsdl.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.xmlsoap.schemas.wsdl.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.xmlsoap.schemas.wsdl.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Definitions</em>'.
	 * @see org.xmlsoap.schemas.wsdl.DocumentRoot#getDefinitions()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Definitions();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getArrayType <em>Array Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Array Type</em>'.
	 * @see org.xmlsoap.schemas.wsdl.DocumentRoot#getArrayType()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_ArrayType();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.xmlsoap.schemas.wsdl.DocumentRoot#isRequired()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Required();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TBinding <em>TBinding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TBinding</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBinding
	 * @generated
	 */
	EClass getTBinding();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TBinding#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operation</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBinding#getOperation()
	 * @see #getTBinding()
	 * @generated
	 */
	EReference getTBinding_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TBinding#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBinding#getName()
	 * @see #getTBinding()
	 * @generated
	 */
	EAttribute getTBinding_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TBinding#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBinding#getType()
	 * @see #getTBinding()
	 * @generated
	 */
	EAttribute getTBinding_Type();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TBindingOperation <em>TBinding Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TBinding Operation</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperation
	 * @generated
	 */
	EClass getTBindingOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperation#getInput()
	 * @see #getTBindingOperation()
	 * @generated
	 */
	EReference getTBindingOperation_Input();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperation#getOutput()
	 * @see #getTBindingOperation()
	 * @generated
	 */
	EReference getTBindingOperation_Output();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getFault <em>Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fault</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperation#getFault()
	 * @see #getTBindingOperation()
	 * @generated
	 */
	EReference getTBindingOperation_Fault();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TBindingOperation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperation#getName()
	 * @see #getTBindingOperation()
	 * @generated
	 */
	EAttribute getTBindingOperation_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TBindingOperationFault <em>TBinding Operation Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TBinding Operation Fault</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperationFault
	 * @generated
	 */
	EClass getTBindingOperationFault();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TBindingOperationFault#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperationFault#getName()
	 * @see #getTBindingOperationFault()
	 * @generated
	 */
	EAttribute getTBindingOperationFault_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TBindingOperationMessage <em>TBinding Operation Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TBinding Operation Message</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperationMessage
	 * @generated
	 */
	EClass getTBindingOperationMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TBindingOperationMessage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TBindingOperationMessage#getName()
	 * @see #getTBindingOperationMessage()
	 * @generated
	 */
	EAttribute getTBindingOperationMessage_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TDefinitions <em>TDefinitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDefinitions</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions
	 * @generated
	 */
	EClass getTDefinitions();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getAnyTopLevelOptionalElement <em>Any Top Level Optional Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Top Level Optional Element</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions#getAnyTopLevelOptionalElement()
	 * @see #getTDefinitions()
	 * @generated
	 */
	EAttribute getTDefinitions_AnyTopLevelOptionalElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getImport <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions#getImport()
	 * @see #getTDefinitions()
	 * @generated
	 */
	EReference getTDefinitions_Import();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions#getTypes()
	 * @see #getTDefinitions()
	 * @generated
	 */
	EReference getTDefinitions_Types();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Message</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions#getMessage()
	 * @see #getTDefinitions()
	 * @generated
	 */
	EReference getTDefinitions_Message();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port Type</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions#getPortType()
	 * @see #getTDefinitions()
	 * @generated
	 */
	EReference getTDefinitions_PortType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Binding</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions#getBinding()
	 * @see #getTDefinitions()
	 * @generated
	 */
	EReference getTDefinitions_Binding();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions#getService()
	 * @see #getTDefinitions()
	 * @generated
	 */
	EReference getTDefinitions_Service();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions#getName()
	 * @see #getTDefinitions()
	 * @generated
	 */
	EAttribute getTDefinitions_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getTargetNamespace <em>Target Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Namespace</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDefinitions#getTargetNamespace()
	 * @see #getTDefinitions()
	 * @generated
	 */
	EAttribute getTDefinitions_TargetNamespace();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TDocumentation <em>TDocumentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDocumentation</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDocumentation
	 * @generated
	 */
	EClass getTDocumentation();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.wsdl.TDocumentation#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDocumentation#getMixed()
	 * @see #getTDocumentation()
	 * @generated
	 */
	EAttribute getTDocumentation_Mixed();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.wsdl.TDocumentation#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDocumentation#getAny()
	 * @see #getTDocumentation()
	 * @generated
	 */
	EAttribute getTDocumentation_Any();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TDocumented <em>TDocumented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TDocumented</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDocumented
	 * @generated
	 */
	EClass getTDocumented();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.wsdl.TDocumented#getDocumentation <em>Documentation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Documentation</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TDocumented#getDocumentation()
	 * @see #getTDocumented()
	 * @generated
	 */
	EReference getTDocumented_Documentation();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TExtensibilityElement <em>TExtensibility Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExtensibility Element</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TExtensibilityElement
	 * @generated
	 */
	EClass getTExtensibilityElement();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TExtensibilityElement#isRequired <em>Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Required</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TExtensibilityElement#isRequired()
	 * @see #getTExtensibilityElement()
	 * @generated
	 */
	EAttribute getTExtensibilityElement_Required();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TExtensibleAttributesDocumented <em>TExtensible Attributes Documented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExtensible Attributes Documented</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TExtensibleAttributesDocumented
	 * @generated
	 */
	EClass getTExtensibleAttributesDocumented();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.wsdl.TExtensibleAttributesDocumented#getAnyAttribute <em>Any Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any Attribute</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TExtensibleAttributesDocumented#getAnyAttribute()
	 * @see #getTExtensibleAttributesDocumented()
	 * @generated
	 */
	EAttribute getTExtensibleAttributesDocumented_AnyAttribute();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TExtensibleDocumented <em>TExtensible Documented</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TExtensible Documented</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TExtensibleDocumented
	 * @generated
	 */
	EClass getTExtensibleDocumented();

	/**
	 * Returns the meta object for the attribute list '{@link org.xmlsoap.schemas.wsdl.TExtensibleDocumented#getAny <em>Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Any</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TExtensibleDocumented#getAny()
	 * @see #getTExtensibleDocumented()
	 * @generated
	 */
	EAttribute getTExtensibleDocumented_Any();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TFault <em>TFault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TFault</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TFault
	 * @generated
	 */
	EClass getTFault();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TFault#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TFault#getMessage()
	 * @see #getTFault()
	 * @generated
	 */
	EAttribute getTFault_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TFault#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TFault#getName()
	 * @see #getTFault()
	 * @generated
	 */
	EAttribute getTFault_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TImport <em>TImport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TImport</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TImport
	 * @generated
	 */
	EClass getTImport();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TImport#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TImport#getLocation()
	 * @see #getTImport()
	 * @generated
	 */
	EAttribute getTImport_Location();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TImport#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TImport#getNamespace()
	 * @see #getTImport()
	 * @generated
	 */
	EAttribute getTImport_Namespace();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TMessage <em>TMessage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TMessage</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TMessage
	 * @generated
	 */
	EClass getTMessage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TMessage#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Part</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TMessage#getPart()
	 * @see #getTMessage()
	 * @generated
	 */
	EReference getTMessage_Part();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TMessage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TMessage#getName()
	 * @see #getTMessage()
	 * @generated
	 */
	EAttribute getTMessage_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TOperation <em>TOperation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TOperation</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TOperation
	 * @generated
	 */
	EClass getTOperation();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.wsdl.TOperation#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TOperation#getInput()
	 * @see #getTOperation()
	 * @generated
	 */
	EReference getTOperation_Input();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.wsdl.TOperation#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TOperation#getOutput()
	 * @see #getTOperation()
	 * @generated
	 */
	EReference getTOperation_Output();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TOperation#getFault <em>Fault</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fault</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TOperation#getFault()
	 * @see #getTOperation()
	 * @generated
	 */
	EReference getTOperation_Fault();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.wsdl.TOperation#getOutput1 <em>Output1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Output1</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TOperation#getOutput1()
	 * @see #getTOperation()
	 * @generated
	 */
	EReference getTOperation_Output1();

	/**
	 * Returns the meta object for the containment reference '{@link org.xmlsoap.schemas.wsdl.TOperation#getInput1 <em>Input1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input1</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TOperation#getInput1()
	 * @see #getTOperation()
	 * @generated
	 */
	EReference getTOperation_Input1();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TOperation#getFault1 <em>Fault1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fault1</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TOperation#getFault1()
	 * @see #getTOperation()
	 * @generated
	 */
	EReference getTOperation_Fault1();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TOperation#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TOperation#getName()
	 * @see #getTOperation()
	 * @generated
	 */
	EAttribute getTOperation_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TOperation#getParameterOrder <em>Parameter Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Order</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TOperation#getParameterOrder()
	 * @see #getTOperation()
	 * @generated
	 */
	EAttribute getTOperation_ParameterOrder();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TParam <em>TParam</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TParam</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TParam
	 * @generated
	 */
	EClass getTParam();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TParam#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TParam#getMessage()
	 * @see #getTParam()
	 * @generated
	 */
	EAttribute getTParam_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TParam#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TParam#getName()
	 * @see #getTParam()
	 * @generated
	 */
	EAttribute getTParam_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TPart <em>TPart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPart</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPart
	 * @generated
	 */
	EClass getTPart();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TPart#getElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPart#getElement()
	 * @see #getTPart()
	 * @generated
	 */
	EAttribute getTPart_Element();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TPart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPart#getName()
	 * @see #getTPart()
	 * @generated
	 */
	EAttribute getTPart_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TPart#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPart#getType()
	 * @see #getTPart()
	 * @generated
	 */
	EAttribute getTPart_Type();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TPort <em>TPort</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPort</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPort
	 * @generated
	 */
	EClass getTPort();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TPort#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Binding</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPort#getBinding()
	 * @see #getTPort()
	 * @generated
	 */
	EAttribute getTPort_Binding();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TPort#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPort#getName()
	 * @see #getTPort()
	 * @generated
	 */
	EAttribute getTPort_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TPortType <em>TPort Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TPort Type</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPortType
	 * @generated
	 */
	EClass getTPortType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TPortType#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operation</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPortType#getOperation()
	 * @see #getTPortType()
	 * @generated
	 */
	EReference getTPortType_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TPortType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TPortType#getName()
	 * @see #getTPortType()
	 * @generated
	 */
	EAttribute getTPortType_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TService <em>TService</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TService</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TService
	 * @generated
	 */
	EClass getTService();

	/**
	 * Returns the meta object for the containment reference list '{@link org.xmlsoap.schemas.wsdl.TService#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Port</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TService#getPort()
	 * @see #getTService()
	 * @generated
	 */
	EReference getTService_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.xmlsoap.schemas.wsdl.TService#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TService#getName()
	 * @see #getTService()
	 * @generated
	 */
	EAttribute getTService_Name();

	/**
	 * Returns the meta object for class '{@link org.xmlsoap.schemas.wsdl.TTypes <em>TTypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>TTypes</em>'.
	 * @see org.xmlsoap.schemas.wsdl.TTypes
	 * @generated
	 */
	EClass getTTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	WsdlFactory getWsdlFactory();

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
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.DocumentRootImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__DEFINITIONS = eINSTANCE.getDocumentRoot_Definitions();

		/**
		 * The meta object literal for the '<em><b>Array Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ARRAY_TYPE = eINSTANCE.getDocumentRoot_ArrayType();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__REQUIRED = eINSTANCE.getDocumentRoot_Required();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TBindingImpl <em>TBinding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TBindingImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTBinding()
		 * @generated
		 */
		EClass TBINDING = eINSTANCE.getTBinding();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TBINDING__OPERATION = eINSTANCE.getTBinding_Operation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TBINDING__NAME = eINSTANCE.getTBinding_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TBINDING__TYPE = eINSTANCE.getTBinding_Type();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TBindingOperationImpl <em>TBinding Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TBindingOperationImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTBindingOperation()
		 * @generated
		 */
		EClass TBINDING_OPERATION = eINSTANCE.getTBindingOperation();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TBINDING_OPERATION__INPUT = eINSTANCE.getTBindingOperation_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TBINDING_OPERATION__OUTPUT = eINSTANCE.getTBindingOperation_Output();

		/**
		 * The meta object literal for the '<em><b>Fault</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TBINDING_OPERATION__FAULT = eINSTANCE.getTBindingOperation_Fault();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TBINDING_OPERATION__NAME = eINSTANCE.getTBindingOperation_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TBindingOperationFaultImpl <em>TBinding Operation Fault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TBindingOperationFaultImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTBindingOperationFault()
		 * @generated
		 */
		EClass TBINDING_OPERATION_FAULT = eINSTANCE.getTBindingOperationFault();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TBINDING_OPERATION_FAULT__NAME = eINSTANCE.getTBindingOperationFault_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TBindingOperationMessageImpl <em>TBinding Operation Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TBindingOperationMessageImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTBindingOperationMessage()
		 * @generated
		 */
		EClass TBINDING_OPERATION_MESSAGE = eINSTANCE.getTBindingOperationMessage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TBINDING_OPERATION_MESSAGE__NAME = eINSTANCE.getTBindingOperationMessage_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TDefinitionsImpl <em>TDefinitions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TDefinitionsImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTDefinitions()
		 * @generated
		 */
		EClass TDEFINITIONS = eINSTANCE.getTDefinitions();

		/**
		 * The meta object literal for the '<em><b>Any Top Level Optional Element</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDEFINITIONS__ANY_TOP_LEVEL_OPTIONAL_ELEMENT = eINSTANCE.getTDefinitions_AnyTopLevelOptionalElement();

		/**
		 * The meta object literal for the '<em><b>Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEFINITIONS__IMPORT = eINSTANCE.getTDefinitions_Import();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEFINITIONS__TYPES = eINSTANCE.getTDefinitions_Types();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEFINITIONS__MESSAGE = eINSTANCE.getTDefinitions_Message();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEFINITIONS__PORT_TYPE = eINSTANCE.getTDefinitions_PortType();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEFINITIONS__BINDING = eINSTANCE.getTDefinitions_Binding();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDEFINITIONS__SERVICE = eINSTANCE.getTDefinitions_Service();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDEFINITIONS__NAME = eINSTANCE.getTDefinitions_Name();

		/**
		 * The meta object literal for the '<em><b>Target Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDEFINITIONS__TARGET_NAMESPACE = eINSTANCE.getTDefinitions_TargetNamespace();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TDocumentationImpl <em>TDocumentation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TDocumentationImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTDocumentation()
		 * @generated
		 */
		EClass TDOCUMENTATION = eINSTANCE.getTDocumentation();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDOCUMENTATION__MIXED = eINSTANCE.getTDocumentation_Mixed();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TDOCUMENTATION__ANY = eINSTANCE.getTDocumentation_Any();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TDocumentedImpl <em>TDocumented</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TDocumentedImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTDocumented()
		 * @generated
		 */
		EClass TDOCUMENTED = eINSTANCE.getTDocumented();

		/**
		 * The meta object literal for the '<em><b>Documentation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TDOCUMENTED__DOCUMENTATION = eINSTANCE.getTDocumented_Documentation();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TExtensibilityElementImpl <em>TExtensibility Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TExtensibilityElementImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTExtensibilityElement()
		 * @generated
		 */
		EClass TEXTENSIBILITY_ELEMENT = eINSTANCE.getTExtensibilityElement();

		/**
		 * The meta object literal for the '<em><b>Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBILITY_ELEMENT__REQUIRED = eINSTANCE.getTExtensibilityElement_Required();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TExtensibleAttributesDocumentedImpl <em>TExtensible Attributes Documented</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TExtensibleAttributesDocumentedImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTExtensibleAttributesDocumented()
		 * @generated
		 */
		EClass TEXTENSIBLE_ATTRIBUTES_DOCUMENTED = eINSTANCE.getTExtensibleAttributesDocumented();

		/**
		 * The meta object literal for the '<em><b>Any Attribute</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBLE_ATTRIBUTES_DOCUMENTED__ANY_ATTRIBUTE = eINSTANCE.getTExtensibleAttributesDocumented_AnyAttribute();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TExtensibleDocumentedImpl <em>TExtensible Documented</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TExtensibleDocumentedImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTExtensibleDocumented()
		 * @generated
		 */
		EClass TEXTENSIBLE_DOCUMENTED = eINSTANCE.getTExtensibleDocumented();

		/**
		 * The meta object literal for the '<em><b>Any</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXTENSIBLE_DOCUMENTED__ANY = eINSTANCE.getTExtensibleDocumented_Any();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TFaultImpl <em>TFault</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TFaultImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTFault()
		 * @generated
		 */
		EClass TFAULT = eINSTANCE.getTFault();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFAULT__MESSAGE = eINSTANCE.getTFault_Message();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TFAULT__NAME = eINSTANCE.getTFault_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TImportImpl <em>TImport</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TImportImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTImport()
		 * @generated
		 */
		EClass TIMPORT = eINSTANCE.getTImport();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMPORT__LOCATION = eINSTANCE.getTImport_Location();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMPORT__NAMESPACE = eINSTANCE.getTImport_Namespace();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TMessageImpl <em>TMessage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TMessageImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTMessage()
		 * @generated
		 */
		EClass TMESSAGE = eINSTANCE.getTMessage();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TMESSAGE__PART = eINSTANCE.getTMessage_Part();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TMESSAGE__NAME = eINSTANCE.getTMessage_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl <em>TOperation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TOperationImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTOperation()
		 * @generated
		 */
		EClass TOPERATION = eINSTANCE.getTOperation();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPERATION__INPUT = eINSTANCE.getTOperation_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPERATION__OUTPUT = eINSTANCE.getTOperation_Output();

		/**
		 * The meta object literal for the '<em><b>Fault</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPERATION__FAULT = eINSTANCE.getTOperation_Fault();

		/**
		 * The meta object literal for the '<em><b>Output1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPERATION__OUTPUT1 = eINSTANCE.getTOperation_Output1();

		/**
		 * The meta object literal for the '<em><b>Input1</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPERATION__INPUT1 = eINSTANCE.getTOperation_Input1();

		/**
		 * The meta object literal for the '<em><b>Fault1</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOPERATION__FAULT1 = eINSTANCE.getTOperation_Fault1();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPERATION__NAME = eINSTANCE.getTOperation_Name();

		/**
		 * The meta object literal for the '<em><b>Parameter Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOPERATION__PARAMETER_ORDER = eINSTANCE.getTOperation_ParameterOrder();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TParamImpl <em>TParam</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TParamImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTParam()
		 * @generated
		 */
		EClass TPARAM = eINSTANCE.getTParam();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPARAM__MESSAGE = eINSTANCE.getTParam_Message();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPARAM__NAME = eINSTANCE.getTParam_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TPartImpl <em>TPart</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TPartImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTPart()
		 * @generated
		 */
		EClass TPART = eINSTANCE.getTPart();

		/**
		 * The meta object literal for the '<em><b>Element</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPART__ELEMENT = eINSTANCE.getTPart_Element();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPART__NAME = eINSTANCE.getTPart_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPART__TYPE = eINSTANCE.getTPart_Type();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TPortImpl <em>TPort</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TPortImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTPort()
		 * @generated
		 */
		EClass TPORT = eINSTANCE.getTPort();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPORT__BINDING = eINSTANCE.getTPort_Binding();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPORT__NAME = eINSTANCE.getTPort_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TPortTypeImpl <em>TPort Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TPortTypeImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTPortType()
		 * @generated
		 */
		EClass TPORT_TYPE = eINSTANCE.getTPortType();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TPORT_TYPE__OPERATION = eINSTANCE.getTPortType_Operation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TPORT_TYPE__NAME = eINSTANCE.getTPortType_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TServiceImpl <em>TService</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TServiceImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTService()
		 * @generated
		 */
		EClass TSERVICE = eINSTANCE.getTService();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TSERVICE__PORT = eINSTANCE.getTService_Port();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TSERVICE__NAME = eINSTANCE.getTService_Name();

		/**
		 * The meta object literal for the '{@link org.xmlsoap.schemas.wsdl.impl.TTypesImpl <em>TTypes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.xmlsoap.schemas.wsdl.impl.TTypesImpl
		 * @see org.xmlsoap.schemas.wsdl.impl.WsdlPackageImpl#getTTypes()
		 * @generated
		 */
		EClass TTYPES = eINSTANCE.getTTypes();

	}

} //WsdlPackage
