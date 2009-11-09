/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TPick</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getOnMessage <em>On Message</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getOnAlarm <em>On Alarm</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getCreateInstance <em>Create Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPick()
 * @model extendedMetaData="name='tPick' kind='elementOnly'"
 * @generated
 */
public interface TPick extends TActivity {
	/**
	 * Returns the value of the '<em><b>On Message</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Message</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Message</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPick_OnMessage()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='onMessage' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TOnMessage> getOnMessage();

	/**
	 * Returns the value of the '<em><b>On Alarm</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>On Alarm</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Alarm</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPick_OnAlarm()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='onAlarm' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TOnAlarm> getOnAlarm();

	/**
	 * Returns the value of the '<em><b>Create Instance</b></em>' attribute.
	 * The default value is <code>"no"</code>.
	 * The literals are from the enumeration {@link org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Create Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Create Instance</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see #isSetCreateInstance()
	 * @see #unsetCreateInstance()
	 * @see #setCreateInstance(TBoolean)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPick_CreateInstance()
	 * @model default="no" unique="false" unsettable="true"
	 *        extendedMetaData="kind='attribute' name='createInstance'"
	 * @generated
	 */
	TBoolean getCreateInstance();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getCreateInstance <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Create Instance</em>' attribute.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean
	 * @see #isSetCreateInstance()
	 * @see #unsetCreateInstance()
	 * @see #getCreateInstance()
	 * @generated
	 */
	void setCreateInstance(TBoolean value);

	/**
	 * Unsets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getCreateInstance <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetCreateInstance()
	 * @see #getCreateInstance()
	 * @see #setCreateInstance(TBoolean)
	 * @generated
	 */
	void unsetCreateInstance();

	/**
	 * Returns whether the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPick#getCreateInstance <em>Create Instance</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Create Instance</em>' attribute is set.
	 * @see #unsetCreateInstance()
	 * @see #getCreateInstance()
	 * @see #setCreateInstance(TBoolean)
	 * @generated
	 */
	boolean isSetCreateInstance();

} // TPick