/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCorrelation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getInitiate <em>Initiate</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getSet <em>Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelation()
 * @model extendedMetaData="name='tCorrelation' kind='elementOnly'"
 * @generated
 */
public interface TCorrelation extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Initiate</b></em>' attribute.
	 * The default value is <code>"no"</code>.
	 * The literals are from the enumeration {@link org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initiate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initiate</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see #isSetInitiate()
	 * @see #unsetInitiate()
	 * @see #setInitiate(TBoolean)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelation_Initiate()
	 * @model default="no" unique="false" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='initiate'"
	 * @generated
	 */
	TBoolean getInitiate();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getInitiate <em>Initiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initiate</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see #isSetInitiate()
	 * @see #unsetInitiate()
	 * @see #getInitiate()
	 * @generated
	 */
	void setInitiate(TBoolean value);

	/**
	 * Unsets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getInitiate <em>Initiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInitiate()
	 * @see #getInitiate()
	 * @see #setInitiate(TBoolean)
	 * @generated
	 */
	void unsetInitiate();

	/**
	 * Returns whether the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getInitiate <em>Initiate</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Initiate</em>' attribute is set.
	 * @see #unsetInitiate()
	 * @see #getInitiate()
	 * @see #setInitiate(TBoolean)
	 * @generated
	 */
	boolean isSetInitiate();

	/**
	 * Returns the value of the '<em><b>Set</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Set</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Set</em>' attribute.
	 * @see #setSet(String)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelation_Set()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='set'"
	 * @generated
	 */
	String getSet();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelation#getSet <em>Set</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Set</em>' attribute.
	 * @see #getSet()
	 * @generated
	 */
	void setSet(String value);

} // TCorrelation