/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.dailab.jiaciv.agentrole.AgentRolePackage
 * @generated
 */
public interface AgentRoleFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AgentRoleFactory eINSTANCE = de.dailab.jiaciv.agentrole.impl.AgentRoleFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Agent Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Agent Properties</em>'.
	 * @generated
	 */
	AgentProperties createAgentProperties();

	/**
	 * Returns a new object of class '<em>Agent Property Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Agent Property Type</em>'.
	 * @generated
	 */
	AgentPropertyType createAgentPropertyType();

	/**
	 * Returns a new object of class '<em>Ref Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ref Type</em>'.
	 * @generated
	 */
	AgentRoleRefType createAgentRoleRefType();

	/**
	 * Returns a new object of class '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type</em>'.
	 * @generated
	 */
	AgentRoleType createAgentRoleType();

	/**
	 * Returns a new object of class '<em>Bean Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bean Properties</em>'.
	 * @generated
	 */
	BeanProperties createBeanProperties();

	/**
	 * Returns a new object of class '<em>Beans</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Beans</em>'.
	 * @generated
	 */
	Beans createBeans();

	/**
	 * Returns a new object of class '<em>Bean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bean Type</em>'.
	 * @generated
	 */
	BeanType createBeanType();

	/**
	 * Returns a new object of class '<em>Description Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Description Type</em>'.
	 * @generated
	 */
	DescriptionType createDescriptionType();

	/**
	 * Returns a new object of class '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Facts</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Facts</em>'.
	 * @generated
	 */
	Facts createFacts();

	/**
	 * Returns a new object of class '<em>Fact Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fact Type</em>'.
	 * @generated
	 */
	FactType createFactType();

	/**
	 * Returns a new object of class '<em>Link Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Link Type</em>'.
	 * @generated
	 */
	LinkType createLinkType();

	/**
	 * Returns a new object of class '<em>Ontologies</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ontologies</em>'.
	 * @generated
	 */
	Ontologies createOntologies();

	/**
	 * Returns a new object of class '<em>Ontology Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ontology Type</em>'.
	 * @generated
	 */
	OntologyType createOntologyType();

	/**
	 * Returns a new object of class '<em>Plans</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plans</em>'.
	 * @generated
	 */
	Plans createPlans();

	/**
	 * Returns a new object of class '<em>Plan Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plan Type</em>'.
	 * @generated
	 */
	PlanType createPlanType();

	/**
	 * Returns a new object of class '<em>Rules</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rules</em>'.
	 * @generated
	 */
	Rules createRules();

	/**
	 * Returns a new object of class '<em>Rule Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Type</em>'.
	 * @generated
	 */
	RuleType createRuleType();

	/**
	 * Returns a new object of class '<em>Services</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Services</em>'.
	 * @generated
	 */
	Services createServices();

	/**
	 * Returns a new object of class '<em>Service Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Type</em>'.
	 * @generated
	 */
	ServiceType createServiceType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AgentRolePackage getAgentRolePackage();

} //AgentRoleFactory
