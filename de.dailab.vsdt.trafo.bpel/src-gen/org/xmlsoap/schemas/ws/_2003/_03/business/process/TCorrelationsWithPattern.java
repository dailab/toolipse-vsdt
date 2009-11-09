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
 * A representation of the model object '<em><b>TCorrelations With Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationsWithPattern#getCorrelation <em>Correlation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelationsWithPattern()
 * @model extendedMetaData="name='tCorrelationsWithPattern' kind='elementOnly'"
 * @generated
 */
public interface TCorrelationsWithPattern extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Correlation</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelationsWithPattern_Correlation()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='correlation' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TCorrelationWithPattern> getCorrelation();

} // TCorrelationsWithPattern