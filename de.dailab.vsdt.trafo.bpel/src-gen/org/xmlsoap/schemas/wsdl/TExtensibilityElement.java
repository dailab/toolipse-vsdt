/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TExtensibility Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TExtensibilityElement#isRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTExtensibilityElement()
 * @model abstract="true"
 *        extendedMetaData="name='tExtensibilityElement' kind='empty'"
 * @generated
 */
public interface TExtensibilityElement extends EObject {
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
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTExtensibilityElement_Required()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='attribute' name='required' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isRequired();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TExtensibilityElement#isRequired <em>Required</em>}' attribute.
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
	 * Unsets the value of the '{@link org.xmlsoap.schemas.wsdl.TExtensibilityElement#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetRequired()
	 * @see #isRequired()
	 * @see #setRequired(boolean)
	 * @generated
	 */
	void unsetRequired();

	/**
	 * Returns whether the value of the '{@link org.xmlsoap.schemas.wsdl.TExtensibilityElement#isRequired <em>Required</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Required</em>' attribute is set.
	 * @see #unsetRequired()
	 * @see #isRequired()
	 * @see #setRequired(boolean)
	 * @generated
	 */
	boolean isSetRequired();

} // TExtensibilityElement