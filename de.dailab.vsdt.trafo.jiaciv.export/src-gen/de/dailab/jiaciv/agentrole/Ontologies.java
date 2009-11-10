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
 * A representation of the model object '<em><b>Ontologies</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.Ontologies#getOntology <em>Ontology</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getOntologies()
 * @model extendedMetaData="name='Ontologies' kind='elementOnly'"
 * @generated
 */
public interface Ontologies extends EObject {
	/**
	 * Returns the value of the '<em><b>Ontology</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.OntologyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ontology</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ontology</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getOntologies_Ontology()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Ontology' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<OntologyType> getOntology();

} // Ontologies
