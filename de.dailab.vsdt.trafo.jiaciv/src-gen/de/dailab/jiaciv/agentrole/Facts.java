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
 * A representation of the model object '<em><b>Facts</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.Facts#getFact <em>Fact</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getFacts()
 * @model extendedMetaData="name='Facts' kind='elementOnly'"
 * @generated
 */
public interface Facts extends EObject {
	/**
	 * Returns the value of the '<em><b>Fact</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.FactType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fact</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fact</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getFacts_Fact()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Fact' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<FactType> getFact();

} // Facts
