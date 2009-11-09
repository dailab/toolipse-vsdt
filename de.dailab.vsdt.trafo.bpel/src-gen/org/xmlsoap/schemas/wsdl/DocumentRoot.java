/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getMixed <em>Mixed</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getDefinitions <em>Definitions</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getArrayType <em>Array Type</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.DocumentRoot#isRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getDocumentRoot()
 * @model extendedMetaData="name='' kind='mixed'"
 * @generated
 */
public interface DocumentRoot extends EObject {
	/**
	 * Returns the value of the '<em><b>Mixed</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mixed</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mixed</em>' attribute list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getDocumentRoot_Mixed()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='elementWildcard' name=':mixed'"
	 * @generated
	 */
	FeatureMap getMixed();

	/**
	 * Returns the value of the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XMLNS Prefix Map</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XMLNS Prefix Map</em>' map.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getDocumentRoot_XMLNSPrefixMap()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xmlns:prefix'"
	 * @generated
	 */
	EMap<String, String> getXMLNSPrefixMap();

	/**
	 * Returns the value of the '<em><b>XSI Schema Location</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSI Schema Location</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSI Schema Location</em>' map.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getDocumentRoot_XSISchemaLocation()
	 * @model mapType="org.eclipse.emf.ecore.EStringToStringMapEntry<org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString>" transient="true"
	 *        extendedMetaData="kind='attribute' name='xsi:schemaLocation'"
	 * @generated
	 */
	EMap<String, String> getXSISchemaLocation();

	/**
	 * Returns the value of the '<em><b>Definitions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definitions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definitions</em>' containment reference.
	 * @see #setDefinitions(TDefinitions)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getDocumentRoot_Definitions()
	 * @model containment="true" upper="-2" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='definitions' namespace='##targetNamespace'"
	 * @generated
	 */
	TDefinitions getDefinitions();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getDefinitions <em>Definitions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definitions</em>' containment reference.
	 * @see #getDefinitions()
	 * @generated
	 */
	void setDefinitions(TDefinitions value);

	/**
	 * Returns the value of the '<em><b>Array Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Type</em>' attribute.
	 * @see #setArrayType(String)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getDocumentRoot_ArrayType()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='arrayType' namespace='##targetNamespace'"
	 * @generated
	 */
	String getArrayType();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#getArrayType <em>Array Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array Type</em>' attribute.
	 * @see #getArrayType()
	 * @generated
	 */
	void setArrayType(String value);

	/**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #isSetRequired()
	 * @see #unsetRequired()
	 * @see #setRequired(boolean)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getDocumentRoot_Required()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='required' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isSetRequired()
	 * @see #unsetRequired()
	 * @see #isRequired()
	 * @generated
	 */
	void setRequired(boolean value);

	/**
	 * Unsets the value of the '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRequired()
	 * @see #isRequired()
	 * @see #setRequired(boolean)
	 * @generated
	 */
	void unsetRequired();

	/**
	 * Returns whether the value of the '{@link org.xmlsoap.schemas.wsdl.DocumentRoot#isRequired <em>Required</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Required</em>' attribute is set.
	 * @see #unsetRequired()
	 * @see #isRequired()
	 * @see #setRequired(boolean)
	 * @generated
	 */
	boolean isSetRequired();

} // DocumentRoot