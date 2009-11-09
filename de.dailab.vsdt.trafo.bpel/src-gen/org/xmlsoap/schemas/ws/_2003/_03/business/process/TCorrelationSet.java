/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;

import java.util.List;

import javax.xml.namespace.QName;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TCorrelation Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet#getName <em>Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelationSet()
 * @model extendedMetaData="name='tCorrelationSet' kind='elementOnly'"
 * @generated
 */
public interface TCorrelationSet extends TExtensibleElements {
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
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelationSet_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName" required="true"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Properties</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' attribute.
	 * @see #setProperties(List)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelationSet_Properties()
	 * @model unique="false" dataType="org.xmlsoap.schemas.ws._2003._03.business.process.PropertiesType" required="true" many="false"
	 *        extendedMetaData="kind='attribute' name='properties'"
	 * @generated
	 */
	List<QName> getProperties();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet#getProperties <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' attribute.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(List<QName> value);

} // TCorrelationSet