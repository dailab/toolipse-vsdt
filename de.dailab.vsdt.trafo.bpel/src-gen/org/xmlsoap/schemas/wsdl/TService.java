/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TService</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TService#getPort <em>Port</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TService#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTService()
 * @model extendedMetaData="name='tService' kind='elementOnly'"
 * @generated
 */
public interface TService extends TExtensibleDocumented {
	/**
	 * Returns the value of the '<em><b>Port</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TPort}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTService_Port()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='port' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TPort> getPort();

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
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTService_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TService#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // TService