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
 * A representation of the model object '<em><b>TCorrelation Sets</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets#getCorrelationSet <em>Correlation Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelationSets()
 * @model extendedMetaData="name='tCorrelationSets' kind='elementOnly'"
 * @generated
 */
public interface TCorrelationSets extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Correlation Set</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Correlation Set</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correlation Set</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTCorrelationSets_CorrelationSet()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='correlationSet' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TCorrelationSet> getCorrelationSet();

} // TCorrelationSets