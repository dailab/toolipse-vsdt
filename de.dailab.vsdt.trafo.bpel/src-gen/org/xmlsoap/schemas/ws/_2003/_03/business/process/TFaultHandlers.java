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
 * A representation of the model object '<em><b>TFault Handlers</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers#getCatch <em>Catch</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers#getCatchAll <em>Catch All</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFaultHandlers()
 * @model extendedMetaData="name='tFaultHandlers' kind='elementOnly'"
 * @generated
 */
public interface TFaultHandlers extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Catch</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TCatch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFaultHandlers_Catch()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='catch' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TCatch> getCatch();

	/**
	 * Returns the value of the '<em><b>Catch All</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Catch All</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Catch All</em>' containment reference.
	 * @see #setCatchAll(TActivityOrCompensateContainer)
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTFaultHandlers_CatchAll()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='catchAll' namespace='##targetNamespace'"
	 * @generated
	 */
	TActivityOrCompensateContainer getCatchAll();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.ws._2003._03.business.process.TFaultHandlers#getCatchAll <em>Catch All</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Catch All</em>' containment reference.
	 * @see #getCatchAll()
	 * @generated
	 */
	void setCatchAll(TActivityOrCompensateContainer value);

} // TFaultHandlers