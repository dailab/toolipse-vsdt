/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TDefinitions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TDefinitions#getAnyTopLevelOptionalElement <em>Any Top Level Optional Element</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TDefinitions#getImport <em>Import</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TDefinitions#getTypes <em>Types</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TDefinitions#getMessage <em>Message</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TDefinitions#getPortType <em>Port Type</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TDefinitions#getBinding <em>Binding</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TDefinitions#getService <em>Service</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TDefinitions#getName <em>Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.TDefinitions#getTargetNamespace <em>Target Namespace</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions()
 * @model extendedMetaData="name='tDefinitions' kind='elementOnly'"
 * @generated
 */
public interface TDefinitions extends TExtensibleDocumented {
	/**
	 * Returns the value of the '<em><b>Any Top Level Optional Element</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Top Level Optional Element</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Top Level Optional Element</em>' attribute list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions_AnyTopLevelOptionalElement()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='AnyTopLevelOptionalElement:2'"
	 * @generated
	 */
	FeatureMap getAnyTopLevelOptionalElement();

	/**
	 * Returns the value of the '<em><b>Import</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TImport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions_Import()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='import' namespace='##targetNamespace' group='#AnyTopLevelOptionalElement:2'"
	 * @generated
	 */
	EList<TImport> getImport();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TTypes}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions_Types()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='types' namespace='##targetNamespace' group='#AnyTopLevelOptionalElement:2'"
	 * @generated
	 */
	EList<TTypes> getTypes();

	/**
	 * Returns the value of the '<em><b>Message</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TMessage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions_Message()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='message' namespace='##targetNamespace' group='#AnyTopLevelOptionalElement:2'"
	 * @generated
	 */
	EList<TMessage> getMessage();

	/**
	 * Returns the value of the '<em><b>Port Type</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TPortType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Type</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions_PortType()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='portType' namespace='##targetNamespace' group='#AnyTopLevelOptionalElement:2'"
	 * @generated
	 */
	EList<TPortType> getPortType();

	/**
	 * Returns the value of the '<em><b>Binding</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TBinding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Binding</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Binding</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions_Binding()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='binding' namespace='##targetNamespace' group='#AnyTopLevelOptionalElement:2'"
	 * @generated
	 */
	EList<TBinding> getBinding();

	/**
	 * Returns the value of the '<em><b>Service</b></em>' containment reference list.
	 * The list contents are of type {@link org.xmlsoap.schemas.wsdl.TService}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' containment reference list.
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions_Service()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='service' namespace='##targetNamespace' group='#AnyTopLevelOptionalElement:2'"
	 * @generated
	 */
	EList<TService> getService();

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
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.NCName"
	 *        extendedMetaData="kind='attribute' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Target Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Namespace</em>' attribute.
	 * @see #setTargetNamespace(String)
	 * @see org.xmlsoap.schemas.wsdl.WsdlPackage#getTDefinitions_TargetNamespace()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='targetNamespace'"
	 * @generated
	 */
	String getTargetNamespace();

	/**
	 * Sets the value of the '{@link org.xmlsoap.schemas.wsdl.TDefinitions#getTargetNamespace <em>Target Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Namespace</em>' attribute.
	 * @see #getTargetNamespace()
	 * @generated
	 */
	void setTargetNamespace(String value);

} // TDefinitions