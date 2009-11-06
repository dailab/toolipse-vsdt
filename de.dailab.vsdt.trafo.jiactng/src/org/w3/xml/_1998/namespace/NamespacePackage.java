/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.w3.xml._1998.namespace;

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
 * @see org.w3.xml._1998.namespace.NamespaceFactory
 * @model kind="package"
 *        annotation="http://www.w3.org/XML/1998/namespace lang='en'"
 * @generated
 */
public interface NamespacePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "namespace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.w3.org/XML/1998/namespace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "namespace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NamespacePackage eINSTANCE = org.w3.xml._1998.namespace.impl.NamespacePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.w3.xml._1998.namespace.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.w3.xml._1998.namespace.impl.DocumentRootImpl
	 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getDocumentRoot()
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
	 * The feature id for the '<em><b>Base</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__BASE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__ID = 4;

	/**
	 * The feature id for the '<em><b>Lang</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__LANG = 5;

	/**
	 * The feature id for the '<em><b>Space</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__SPACE = 6;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.w3.xml._1998.namespace.LangTypeMember1 <em>Lang Type Member1</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.w3.xml._1998.namespace.LangTypeMember1
	 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getLangTypeMember1()
	 * @generated
	 */
	int LANG_TYPE_MEMBER1 = 1;

	/**
	 * The meta object id for the '{@link org.w3.xml._1998.namespace.SpaceType <em>Space Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.w3.xml._1998.namespace.SpaceType
	 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getSpaceType()
	 * @generated
	 */
	int SPACE_TYPE = 2;

	/**
	 * The meta object id for the '<em>Lang Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Object
	 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getLangType()
	 * @generated
	 */
	int LANG_TYPE = 3;

	/**
	 * The meta object id for the '<em>Lang Type Member1 Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.w3.xml._1998.namespace.LangTypeMember1
	 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getLangTypeMember1Object()
	 * @generated
	 */
	int LANG_TYPE_MEMBER1_OBJECT = 4;

	/**
	 * The meta object id for the '<em>Space Type Object</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.w3.xml._1998.namespace.SpaceType
	 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getSpaceTypeObject()
	 * @generated
	 */
	int SPACE_TYPE_OBJECT = 5;


	/**
	 * Returns the meta object for class '{@link org.w3.xml._1998.namespace.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.w3.xml._1998.namespace.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link org.w3.xml._1998.namespace.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.w3.xml._1998.namespace.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.w3.xml._1998.namespace.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.w3.xml._1998.namespace.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.w3.xml._1998.namespace.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.w3.xml._1998.namespace.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.w3.xml._1998.namespace.DocumentRoot#getBase <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base</em>'.
	 * @see org.w3.xml._1998.namespace.DocumentRoot#getBase()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Base();

	/**
	 * Returns the meta object for the attribute '{@link org.w3.xml._1998.namespace.DocumentRoot#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.w3.xml._1998.namespace.DocumentRoot#getId()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Id();

	/**
	 * Returns the meta object for the attribute '{@link org.w3.xml._1998.namespace.DocumentRoot#getLang <em>Lang</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lang</em>'.
	 * @see org.w3.xml._1998.namespace.DocumentRoot#getLang()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Lang();

	/**
	 * Returns the meta object for the attribute '{@link org.w3.xml._1998.namespace.DocumentRoot#getSpace <em>Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Space</em>'.
	 * @see org.w3.xml._1998.namespace.DocumentRoot#getSpace()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Space();

	/**
	 * Returns the meta object for enum '{@link org.w3.xml._1998.namespace.LangTypeMember1 <em>Lang Type Member1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Lang Type Member1</em>'.
	 * @see org.w3.xml._1998.namespace.LangTypeMember1
	 * @generated
	 */
	EEnum getLangTypeMember1();

	/**
	 * Returns the meta object for enum '{@link org.w3.xml._1998.namespace.SpaceType <em>Space Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Space Type</em>'.
	 * @see org.w3.xml._1998.namespace.SpaceType
	 * @generated
	 */
	EEnum getSpaceType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Object <em>Lang Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lang Type</em>'.
	 * @see java.lang.Object
	 * @model instanceClass="java.lang.Object"
	 *        extendedMetaData="name='lang_._type' memberTypes='http://www.eclipse.org/emf/2003/XMLType#language lang_._type_._member_._1'"
	 * @generated
	 */
	EDataType getLangType();

	/**
	 * Returns the meta object for data type '{@link org.w3.xml._1998.namespace.LangTypeMember1 <em>Lang Type Member1 Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Lang Type Member1 Object</em>'.
	 * @see org.w3.xml._1998.namespace.LangTypeMember1
	 * @model instanceClass="org.w3.xml._1998.namespace.LangTypeMember1"
	 *        extendedMetaData="name='lang_._type_._member_._1:Object' baseType='lang_._type_._member_._1'"
	 * @generated
	 */
	EDataType getLangTypeMember1Object();

	/**
	 * Returns the meta object for data type '{@link org.w3.xml._1998.namespace.SpaceType <em>Space Type Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Space Type Object</em>'.
	 * @see org.w3.xml._1998.namespace.SpaceType
	 * @model instanceClass="org.w3.xml._1998.namespace.SpaceType"
	 *        extendedMetaData="name='space_._type:Object' baseType='space_._type'"
	 * @generated
	 */
	EDataType getSpaceTypeObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NamespaceFactory getNamespaceFactory();

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
		 * The meta object literal for the '{@link org.w3.xml._1998.namespace.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.w3.xml._1998.namespace.impl.DocumentRootImpl
		 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getDocumentRoot()
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
		 * The meta object literal for the '<em><b>Base</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__BASE = eINSTANCE.getDocumentRoot_Base();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__ID = eINSTANCE.getDocumentRoot_Id();

		/**
		 * The meta object literal for the '<em><b>Lang</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__LANG = eINSTANCE.getDocumentRoot_Lang();

		/**
		 * The meta object literal for the '<em><b>Space</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__SPACE = eINSTANCE.getDocumentRoot_Space();

		/**
		 * The meta object literal for the '{@link org.w3.xml._1998.namespace.LangTypeMember1 <em>Lang Type Member1</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.w3.xml._1998.namespace.LangTypeMember1
		 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getLangTypeMember1()
		 * @generated
		 */
		EEnum LANG_TYPE_MEMBER1 = eINSTANCE.getLangTypeMember1();

		/**
		 * The meta object literal for the '{@link org.w3.xml._1998.namespace.SpaceType <em>Space Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.w3.xml._1998.namespace.SpaceType
		 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getSpaceType()
		 * @generated
		 */
		EEnum SPACE_TYPE = eINSTANCE.getSpaceType();

		/**
		 * The meta object literal for the '<em>Lang Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Object
		 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getLangType()
		 * @generated
		 */
		EDataType LANG_TYPE = eINSTANCE.getLangType();

		/**
		 * The meta object literal for the '<em>Lang Type Member1 Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.w3.xml._1998.namespace.LangTypeMember1
		 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getLangTypeMember1Object()
		 * @generated
		 */
		EDataType LANG_TYPE_MEMBER1_OBJECT = eINSTANCE.getLangTypeMember1Object();

		/**
		 * The meta object literal for the '<em>Space Type Object</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.w3.xml._1998.namespace.SpaceType
		 * @see org.w3.xml._1998.namespace.impl.NamespacePackageImpl#getSpaceTypeObject()
		 * @generated
		 */
		EDataType SPACE_TYPE_OBJECT = eINSTANCE.getSpaceTypeObject();

	}

} //NamespacePackage
