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
 * A representation of the model object '<em><b>TEvent Handlers</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers#getOnMessage <em>On Message</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers#getOnAlarm <em>On Alarm</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTEventHandlers()
 * @model extendedMetaData="name='tEventHandlers' kind='elementOnly'"
 * @generated
 */
public interface TEventHandlers extends TExtensibleElements {
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
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTEventHandlers_OnMessage()
	 * @model containment="true"
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
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTEventHandlers_OnAlarm()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='onAlarm' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TOnAlarm> getOnAlarm();

} // TEventHandlers