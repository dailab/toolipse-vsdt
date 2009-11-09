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
 * A representation of the model object '<em><b>TFrom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getEndpointReference <em>Endpoint Reference</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getOpaque <em>Opaque</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getPart <em>Part</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getPartnerLink <em>Partner Link</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getProperty <em>Property</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getQuery <em>Query</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFrom()
 * @model extendedMetaData="name='tFrom' kind='elementOnly'"
 * @generated
 */
public interface TFrom extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Endpoint Reference</b></em>' attribute.
	 * The default value is <code>"myRole"</code>.
	 * The literals are from the enumeration {@link org.xmlsoap.schemas.ws._2003._03.business.process.TRoles}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Endpoint Reference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Endpoint Reference</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TRoles
	 * @see #isSetEndpointReference()
	 * @see #unsetEndpointReference()
	 * @see #setEndpointReference(TRoles)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFrom_EndpointReference()
	 * @model default="myRole" unique="false" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='endpointReference'"
	 * @generated
	 */
	TRoles getEndpointReference();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getEndpointReference <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Endpoint Reference</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TRoles
	 * @see #isSetEndpointReference()
	 * @see #unsetEndpointReference()
	 * @see #getEndpointReference()
	 * @generated
	 */
	void setEndpointReference(TRoles value);

	/**
	 * Unsets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getEndpointReference <em>Endpoint Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetEndpointReference()
	 * @see #getEndpointReference()
	 * @see #setEndpointReference(TRoles)
	 * @generated
	 */
	void unsetEndpointReference();

	/**
	 * Returns whether the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getEndpointReference <em>Endpoint Reference</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Endpoint Reference</em>' attribute is set.
	 * @see #unsetEndpointReference()
	 * @see #getEndpointReference()
	 * @see #setEndpointReference(TRoles)
	 * @generated
	 */
	boolean isSetEndpointReference();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFrom_Expression()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='expression'"
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

	/**
	 * Returns the value of the '<em><b>Opaque</b></em>' attribute.
	 * The default value is <code>"yes"</code>.
	 * The literals are from the enumeration {@link org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opaque</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opaque</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see #isSetOpaque()
	 * @see #unsetOpaque()
	 * @see #setOpaque(TBoolean)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFrom_Opaque()
	 * @model default="yes" unique="false" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='opaque'"
	 * @generated
	 */
	TBoolean getOpaque();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getOpaque <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Opaque</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see #isSetOpaque()
	 * @see #unsetOpaque()
	 * @see #getOpaque()
	 * @generated
	 */
	void setOpaque(TBoolean value);

	/**
	 * Unsets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getOpaque <em>Opaque</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetOpaque()
	 * @see #getOpaque()
	 * @see #setOpaque(TBoolean)
	 * @generated
	 */
	void unsetOpaque();

	/**
	 * Returns whether the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getOpaque <em>Opaque</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Opaque</em>' attribute is set.
	 * @see #unsetOpaque()
	 * @see #getOpaque()
	 * @see #setOpaque(TBoolean)
	 * @generated
	 */
	boolean isSetOpaque();

	/**
	 * Returns the value of the '<em><b>Part</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' attribute.
	 * @see #setPart(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFrom_Part()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='part'"
	 * @generated
	 */
	String getPart();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getPart <em>Part</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' attribute.
	 * @see #getPart()
	 * @generated
	 */
	void setPart(String value);

	/**
	 * Returns the value of the '<em><b>Partner Link</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Link</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Link</em>' attribute.
	 * @see #setPartnerLink(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFrom_PartnerLink()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='partnerLink'"
	 * @generated
	 */
	String getPartnerLink();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getPartnerLink <em>Partner Link</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Partner Link</em>' attribute.
	 * @see #getPartnerLink()
	 * @generated
	 */
	void setPartnerLink(String value);

	/**
	 * Returns the value of the '<em><b>Property</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property</em>' attribute.
	 * @see #setProperty(QName)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFrom_Property()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.QName"
	 *        extendedMetaData="kind='attribute' name='property'"
	 * @generated
	 */
	QName getProperty();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getProperty <em>Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property</em>' attribute.
	 * @see #getProperty()
	 * @generated
	 */
	void setProperty(QName value);

	/**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFrom_Query()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='query'"
	 * @generated
	 */
	String getQuery();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(String value);

	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see #setVariable(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFrom_Variable()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='variable'"
	 * @generated
	 */
	String getVariable();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFrom#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(String value);

} // TFrom