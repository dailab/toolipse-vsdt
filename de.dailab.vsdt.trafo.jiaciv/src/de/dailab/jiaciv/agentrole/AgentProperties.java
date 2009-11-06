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
 * A representation of the model object '<em><b>Agent Properties</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentProperties#getAgentProperty <em>Agent Property</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentProperties()
 * @model extendedMetaData="name='AgentProperties' kind='elementOnly'"
 * @generated
 */
public interface AgentProperties extends EObject {
	/**
	 * Returns the value of the '<em><b>Agent Property</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.AgentPropertyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Property</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Property</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentProperties_AgentProperty()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AgentProperty' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AgentPropertyType> getAgentProperty();

} // AgentProperties
