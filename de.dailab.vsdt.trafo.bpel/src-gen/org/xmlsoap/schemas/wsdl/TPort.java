/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import javax.xml.namespace.QName;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPort</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TPort#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TPort#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTPort()
 * @model extendedMetaData="name='tPort' kind='elementOnly'"
 * @generated
 */
public interface TPort extends TExtensibleDocumented {
	/**
	 * Returns the value of the '<em><b>Binding</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' attribute.
	 * @see #setBinding(QName)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTPort_Binding()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
	 *        extendedMetaData="kind='attribute' name='binding'"
	 * @generated
	 */
	QName getBinding();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TPort#getBinding <em>Binding</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Binding</em>' attribute.
	 * @see #getBinding()
	 * @generated
	 */
	void setBinding(QName value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTPort_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TPort#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TPort