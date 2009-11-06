/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bean Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.BeanProperties#getDependentproperty <em>Dependentproperty</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.BeanProperties#getDepends <em>Depends</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.BeanProperties#getDescription <em>Description</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.BeanProperties#getKey <em>Key</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.BeanProperties#getType <em>Type</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.BeanProperties#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getBeanProperties()
 * @model extendedMetaData="name='BeanProperties' kind='elementOnly'"
 * @generated
 */
public interface BeanProperties extends EObject {
	/**
	 * Returns the value of the '<em><b>Dependentproperty</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.BeanProperties}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependentproperty</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependentproperty</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getBeanProperties_Dependentproperty()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='dependentproperty' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<BeanProperties> getDependentproperty();

	/**
	 * Returns the value of the '<em><b>Depends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends</em>' attribute.
	 * @see #setDepends(String)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getBeanProperties_Depends()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='depends' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDepends();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.BeanProperties#getDepends <em>Depends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depends</em>' attribute.
	 * @see #getDepends()
	 * @generated
	 */
	void setDepends(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getBeanProperties_Description()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.BeanProperties#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getBeanProperties_Key()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='key' namespace='##targetNamespace'"
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.BeanProperties#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getBeanProperties_Type()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type' namespace='##targetNamespace'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.BeanProperties#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getBeanProperties_Value()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.BeanProperties#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // BeanProperties
