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
 * A representation of the model object '<em><b>TVariables</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariables#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTVariables()
 * @model extendedMetaData="name='tVariables' kind='elementOnly'"
 * @generated
 */
public interface TVariables extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTVariables_Variable()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='variable' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TVariable> getVariable();

} // TVariables