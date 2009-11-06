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
 * A representation of the model object '<em><b>TPartner Links</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLinks#getPartnerLink <em>Partner Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPartnerLinks()
 * @model extendedMetaData="name='tPartnerLinks' kind='elementOnly'"
 * @generated
 */
public interface TPartnerLinks extends TExtensibleElements {
	/**
	 * Returns the value of the '<em><b>Partner Link</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.ws._2003._03.business.process.TPartnerLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Partner Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Partner Link</em>' containment reference list.
	 * @see org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage#getTPartnerLinks_PartnerLink()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='partnerLink' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<TPartnerLink> getPartnerLink();

} // TPartnerLinks