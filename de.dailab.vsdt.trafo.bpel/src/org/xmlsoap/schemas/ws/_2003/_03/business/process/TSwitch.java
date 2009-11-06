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
 * A representation of the model object '<em><b>TSwitch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch#getCase <em>Case</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch#getOtherwise <em>Otherwise</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSwitch()
 * @model extendedMetaData="name='tSwitch' kind='elementOnly'"
 * @generated
 */
public interface TSwitch extends TActivity {
	/**
	 * Returns the value of the '<em><b>Case</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.CaseType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSwitch_Case()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='case' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<CaseType> getCase();

	/**
	 * Returns the value of the '<em><b>Otherwise</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Otherwise</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Otherwise</em>' containment reference.
	 * @see #setOtherwise(TActivityContainer)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTSwitch_Otherwise()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='otherwise' namespace='##targetNamespace'"
	 * @generated
	 */
	TActivityContainer getOtherwise();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch#getOtherwise <em>Otherwise</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Otherwise</em>' containment reference.
	 * @see #getOtherwise()
	 * @generated
	 */
	void setOtherwise(TActivityContainer value);

} // TSwitch