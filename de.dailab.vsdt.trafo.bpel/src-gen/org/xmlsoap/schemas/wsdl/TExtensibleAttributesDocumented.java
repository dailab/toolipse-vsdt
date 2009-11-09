/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TExtensible Attributes Documented</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 
 *           This type is extended by component types to allow attributes from other namespaces to be added.
 *           
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TExtensibleAttributesDocumented#getAnyAttribute <em>Any Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTExtensibleAttributesDocumented()
 * @model abstract="true"
 *        extendedMetaData="name='tExtensibleAttributesDocumented' kind='elementOnly'"
 * @generated
 */
public interface TExtensibleAttributesDocumented extends TDocumented {
	/**
	 * Returns the value of the '<em><b>Any Attribute</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Attribute</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Attribute</em>' attribute list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTExtensibleAttributesDocumented_AnyAttribute()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='attributeWildcard' wildcards='##other' name=':1' processing='lax'"
	 * @generated
	 */
	FeatureMap getAnyAttribute();

} // TExtensibleAttributesDocumented