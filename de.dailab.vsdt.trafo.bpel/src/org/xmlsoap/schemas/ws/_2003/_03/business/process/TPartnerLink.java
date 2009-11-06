/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;

import javax.xml.namespace.QName;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPartner Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getMyRole <em>My Role</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getName <em>Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getPartnerLinkType <em>Partner Link Type</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getPartnerRole <em>Partner Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPartnerLink()
 * @model extendedMetaData="name='tPartnerLink' kind='elementOnly'"
 * @generated
 */
public interface TPartnerLink extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>My Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>My Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>My Role</em>' attribute.
	 * @see #setMyRole(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPartnerLink_MyRole()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='myRole'"
	 * @generated
	 */
	String getMyRole();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getMyRole <em>My Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>My Role</em>' attribute.
	 * @see #getMyRole()
	 * @generated
	 */
	void setMyRole(String value);

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
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPartnerLink_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Partner Link Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Link Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Link Type</em>' attribute.
	 * @see #setPartnerLinkType(QName)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPartnerLink_PartnerLinkType()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.QName" required="true"
	 *        extendedMetaData="kind='attribute' name='partnerLinkType'"
	 * @generated
	 */
	QName getPartnerLinkType();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getPartnerLinkType <em>Partner Link Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Link Type</em>' attribute.
	 * @see #getPartnerLinkType()
	 * @generated
	 */
	void setPartnerLinkType(QName value);

	/**
	 * Returns the value of the '<em><b>Partner Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Role</em>' attribute.
	 * @see #setPartnerRole(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPartnerLink_PartnerRole()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='partnerRole'"
	 * @generated
	 */
	String getPartnerRole();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink#getPartnerRole <em>Partner Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Role</em>' attribute.
	 * @see #getPartnerRole()
	 * @generated
	 */
	void setPartnerRole(String value);

} // TPartnerLink