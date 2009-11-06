/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.dailab.jiaciv.agentrole.AgentRoleFactory
 * @model kind="package"
 *        extendedMetaData="qualified='false'"
 * @generated
 */
public interface AgentRolePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "agentrole";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "platform:/resource/MappingTool/model/AgentRole.xsd";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "agentrole";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AgentRolePackage eINSTANCE = de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.AgentPropertiesImpl <em>Agent Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.AgentPropertiesImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getAgentProperties()
	 * @generated
	 */
	int AGENT_PROPERTIES = 0;

	/**
	 * The feature id for the '<em><b>Agent Property</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_PROPERTIES__AGENT_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Agent Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_PROPERTIES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.AgentPropertyTypeImpl <em>Agent Property Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.AgentPropertyTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getAgentPropertyType()
	 * @generated
	 */
	int AGENT_PROPERTY_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_PROPERTY_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_PROPERTY_TYPE__KEY = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_PROPERTY_TYPE__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_PROPERTY_TYPE__VALUE = 3;

	/**
	 * The number of structural features of the '<em>Agent Property Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_PROPERTY_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.AgentRoleRefTypeImpl <em>Ref Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRoleRefTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getAgentRoleRefType()
	 * @generated
	 */
	int AGENT_ROLE_REF_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Jar</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_REF_TYPE__JAR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_REF_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_REF_TYPE__PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Ref Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_REF_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getAgentRoleType()
	 * @generated
	 */
	int AGENT_ROLE_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Description</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Beans</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__BEANS = 1;

	/**
	 * The feature id for the '<em><b>Ontologies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__ONTOLOGIES = 2;

	/**
	 * The feature id for the '<em><b>Facts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__FACTS = 3;

	/**
	 * The feature id for the '<em><b>Plans</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__PLANS = 4;

	/**
	 * The feature id for the '<em><b>Services</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__SERVICES = 5;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__RULES = 6;

	/**
	 * The feature id for the '<em><b>Agentproperties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__AGENTPROPERTIES = 7;

	/**
	 * The feature id for the '<em><b>Agent Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__AGENT_ROLE = 8;

	/**
	 * The feature id for the '<em><b>Agent Role Ref</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__AGENT_ROLE_REF = 9;

	/**
	 * The feature id for the '<em><b>Keywords</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__KEYWORDS = 10;

	/**
	 * The feature id for the '<em><b>Depends</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__DEPENDS = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__NAME = 12;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__PACKAGE = 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE__TYPE = 14;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_ROLE_TYPE_FEATURE_COUNT = 15;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl <em>Bean Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getBeanProperties()
	 * @generated
	 */
	int BEAN_PROPERTIES = 4;

	/**
	 * The feature id for the '<em><b>Dependentproperty</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_PROPERTIES__DEPENDENTPROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Depends</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_PROPERTIES__DEPENDS = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_PROPERTIES__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_PROPERTIES__KEY = 3;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_PROPERTIES__TYPE = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_PROPERTIES__VALUE = 5;

	/**
	 * The number of structural features of the '<em>Bean Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_PROPERTIES_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.BeansImpl <em>Beans</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.BeansImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getBeans()
	 * @generated
	 */
	int BEANS = 5;

	/**
	 * The feature id for the '<em><b>Bean</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEANS__BEAN = 0;

	/**
	 * The number of structural features of the '<em>Beans</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEANS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.BeanTypeImpl <em>Bean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.BeanTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getBeanType()
	 * @generated
	 */
	int BEAN_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Beanproperties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__BEANPROPERTIES = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE__PACKAGE = 3;

	/**
	 * The number of structural features of the '<em>Bean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEAN_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.DescriptionTypeImpl <em>Description Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.DescriptionTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getDescriptionType()
	 * @generated
	 */
	int DESCRIPTION_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_TYPE__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Link</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_TYPE__LINK = 1;

	/**
	 * The number of structural features of the '<em>Description Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.DocumentRootImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 8;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Agent Role</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__AGENT_ROLE = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.FactsImpl <em>Facts</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.FactsImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getFacts()
	 * @generated
	 */
	int FACTS = 9;

	/**
	 * The feature id for the '<em><b>Fact</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTS__FACT = 0;

	/**
	 * The number of structural features of the '<em>Facts</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACTS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.FactTypeImpl <em>Fact Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.FactTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getFactType()
	 * @generated
	 */
	int FACT_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACT_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACT_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACT_TYPE__PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Fact Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FACT_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.LinkTypeImpl <em>Link Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.LinkTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getLinkType()
	 * @generated
	 */
	int LINK_TYPE = 11;

	/**
	 * The feature id for the '<em><b>Linktext</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__LINKTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__PATH = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Link Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINK_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.OntologiesImpl <em>Ontologies</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.OntologiesImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getOntologies()
	 * @generated
	 */
	int ONTOLOGIES = 12;

	/**
	 * The feature id for the '<em><b>Ontology</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGIES__ONTOLOGY = 0;

	/**
	 * The number of structural features of the '<em>Ontologies</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGIES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.OntologyTypeImpl <em>Ontology Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.OntologyTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getOntologyType()
	 * @generated
	 */
	int ONTOLOGY_TYPE = 13;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY_TYPE__PACKAGE = 2;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY_TYPE__VERSION = 3;

	/**
	 * The number of structural features of the '<em>Ontology Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONTOLOGY_TYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.PlansImpl <em>Plans</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.PlansImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getPlans()
	 * @generated
	 */
	int PLANS = 14;

	/**
	 * The feature id for the '<em><b>Plan</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANS__PLAN = 0;

	/**
	 * The number of structural features of the '<em>Plans</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.PlanTypeImpl <em>Plan Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.PlanTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getPlanType()
	 * @generated
	 */
	int PLAN_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAN_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAN_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAN_TYPE__PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Plan Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAN_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.RulesImpl <em>Rules</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.RulesImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getRules()
	 * @generated
	 */
	int RULES = 16;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULES__RULE = 0;

	/**
	 * The number of structural features of the '<em>Rules</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.RuleTypeImpl <em>Rule Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.RuleTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getRuleType()
	 * @generated
	 */
	int RULE_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE__PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Rule Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.ServicesImpl <em>Services</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.ServicesImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getServices()
	 * @generated
	 */
	int SERVICES = 18;

	/**
	 * The feature id for the '<em><b>Service</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICES__SERVICE = 0;

	/**
	 * The number of structural features of the '<em>Services</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICES_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.dailab.jiaciv.agentrole.impl.ServiceTypeImpl <em>Service Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.dailab.jiaciv.agentrole.impl.ServiceTypeImpl
	 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getServiceType()
	 * @generated
	 */
	int SERVICE_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TYPE__DESCRIPTION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TYPE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TYPE__PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Service Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_TYPE_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.AgentProperties <em>Agent Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent Properties</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentProperties
	 * @generated
	 */
	EClass getAgentProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.AgentProperties#getAgentProperty <em>Agent Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Agent Property</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentProperties#getAgentProperty()
	 * @see #getAgentProperties()
	 * @generated
	 */
	EReference getAgentProperties_AgentProperty();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.AgentPropertyType <em>Agent Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Agent Property Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentPropertyType
	 * @generated
	 */
	EClass getAgentPropertyType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentPropertyType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentPropertyType#getDescription()
	 * @see #getAgentPropertyType()
	 * @generated
	 */
	EAttribute getAgentPropertyType_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentPropertyType#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentPropertyType#getKey()
	 * @see #getAgentPropertyType()
	 * @generated
	 */
	EAttribute getAgentPropertyType_Key();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentPropertyType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentPropertyType#getType()
	 * @see #getAgentPropertyType()
	 * @generated
	 */
	EAttribute getAgentPropertyType_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentPropertyType#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentPropertyType#getValue()
	 * @see #getAgentPropertyType()
	 * @generated
	 */
	EAttribute getAgentPropertyType_Value();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.AgentRoleRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ref Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleRefType
	 * @generated
	 */
	EClass getAgentRoleRefType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentRoleRefType#getJar <em>Jar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Jar</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleRefType#getJar()
	 * @see #getAgentRoleRefType()
	 * @generated
	 */
	EAttribute getAgentRoleRefType_Jar();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentRoleRefType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleRefType#getName()
	 * @see #getAgentRoleRefType()
	 * @generated
	 */
	EAttribute getAgentRoleRefType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentRoleRefType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleRefType#getPackage()
	 * @see #getAgentRoleRefType()
	 * @generated
	 */
	EAttribute getAgentRoleRefType_Package();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.AgentRoleType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType
	 * @generated
	 */
	EClass getAgentRoleType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Description</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getDescription()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_Description();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getBeans <em>Beans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Beans</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getBeans()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_Beans();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getOntologies <em>Ontologies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Ontologies</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getOntologies()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_Ontologies();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getFacts <em>Facts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Facts</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getFacts()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_Facts();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getPlans <em>Plans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Plans</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getPlans()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_Plans();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Services</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getServices()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_Services();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Rules</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getRules()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_Rules();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getAgentproperties <em>Agentproperties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Agentproperties</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getAgentproperties()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_Agentproperties();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getAgentRole <em>Agent Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Agent Role</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getAgentRole()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_AgentRole();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getAgentRoleRef <em>Agent Role Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Agent Role Ref</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getAgentRoleRef()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_AgentRoleRef();

	/**
	 * Returns the meta object for the attribute list '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getKeywords <em>Keywords</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Keywords</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getKeywords()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EAttribute getAgentRoleType_Keywords();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getDepends <em>Depends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Depends</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getDepends()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EReference getAgentRoleType_Depends();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getName()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EAttribute getAgentRoleType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getPackage()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EAttribute getAgentRoleType_Package();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType#getType()
	 * @see #getAgentRoleType()
	 * @generated
	 */
	EAttribute getAgentRoleType_Type();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.BeanProperties <em>Bean Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bean Properties</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanProperties
	 * @generated
	 */
	EClass getBeanProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.BeanProperties#getDependentproperty <em>Dependentproperty</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependentproperty</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanProperties#getDependentproperty()
	 * @see #getBeanProperties()
	 * @generated
	 */
	EReference getBeanProperties_Dependentproperty();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.BeanProperties#getDepends <em>Depends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depends</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanProperties#getDepends()
	 * @see #getBeanProperties()
	 * @generated
	 */
	EAttribute getBeanProperties_Depends();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.BeanProperties#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanProperties#getDescription()
	 * @see #getBeanProperties()
	 * @generated
	 */
	EAttribute getBeanProperties_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.BeanProperties#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanProperties#getKey()
	 * @see #getBeanProperties()
	 * @generated
	 */
	EAttribute getBeanProperties_Key();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.BeanProperties#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanProperties#getType()
	 * @see #getBeanProperties()
	 * @generated
	 */
	EAttribute getBeanProperties_Type();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.BeanProperties#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanProperties#getValue()
	 * @see #getBeanProperties()
	 * @generated
	 */
	EAttribute getBeanProperties_Value();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.Beans <em>Beans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Beans</em>'.
	 * @see de.dailab.jiaciv.agentrole.Beans
	 * @generated
	 */
	EClass getBeans();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.Beans#getBean <em>Bean</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bean</em>'.
	 * @see de.dailab.jiaciv.agentrole.Beans#getBean()
	 * @see #getBeans()
	 * @generated
	 */
	EReference getBeans_Bean();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.BeanType <em>Bean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bean Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanType
	 * @generated
	 */
	EClass getBeanType();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.BeanType#getBeanproperties <em>Beanproperties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Beanproperties</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanType#getBeanproperties()
	 * @see #getBeanType()
	 * @generated
	 */
	EReference getBeanType_Beanproperties();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.BeanType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanType#getDescription()
	 * @see #getBeanType()
	 * @generated
	 */
	EAttribute getBeanType_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.BeanType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanType#getName()
	 * @see #getBeanType()
	 * @generated
	 */
	EAttribute getBeanType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.BeanType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see de.dailab.jiaciv.agentrole.BeanType#getPackage()
	 * @see #getBeanType()
	 * @generated
	 */
	EAttribute getBeanType_Package();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.DescriptionType <em>Description Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.DescriptionType
	 * @generated
	 */
	EClass getDescriptionType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.DescriptionType#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see de.dailab.jiaciv.agentrole.DescriptionType#getText()
	 * @see #getDescriptionType()
	 * @generated
	 */
	EAttribute getDescriptionType_Text();

	/**
	 * Returns the meta object for the containment reference '{@link de.dailab.jiaciv.agentrole.DescriptionType#getLink <em>Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Link</em>'.
	 * @see de.dailab.jiaciv.agentrole.DescriptionType#getLink()
	 * @see #getDescriptionType()
	 * @generated
	 */
	EReference getDescriptionType_Link();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see de.dailab.jiaciv.agentrole.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the attribute list '{@link de.dailab.jiaciv.agentrole.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see de.dailab.jiaciv.agentrole.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link de.dailab.jiaciv.agentrole.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see de.dailab.jiaciv.agentrole.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link de.dailab.jiaciv.agentrole.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see de.dailab.jiaciv.agentrole.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.DocumentRoot#getAgentRole <em>Agent Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Agent Role</em>'.
	 * @see de.dailab.jiaciv.agentrole.DocumentRoot#getAgentRole()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_AgentRole();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.Facts <em>Facts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Facts</em>'.
	 * @see de.dailab.jiaciv.agentrole.Facts
	 * @generated
	 */
	EClass getFacts();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.Facts#getFact <em>Fact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fact</em>'.
	 * @see de.dailab.jiaciv.agentrole.Facts#getFact()
	 * @see #getFacts()
	 * @generated
	 */
	EReference getFacts_Fact();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.FactType <em>Fact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fact Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.FactType
	 * @generated
	 */
	EClass getFactType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.FactType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.jiaciv.agentrole.FactType#getDescription()
	 * @see #getFactType()
	 * @generated
	 */
	EAttribute getFactType_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.FactType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.jiaciv.agentrole.FactType#getName()
	 * @see #getFactType()
	 * @generated
	 */
	EAttribute getFactType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.FactType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see de.dailab.jiaciv.agentrole.FactType#getPackage()
	 * @see #getFactType()
	 * @generated
	 */
	EAttribute getFactType_Package();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.LinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Link Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.LinkType
	 * @generated
	 */
	EClass getLinkType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.LinkType#getLinktext <em>Linktext</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Linktext</em>'.
	 * @see de.dailab.jiaciv.agentrole.LinkType#getLinktext()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_Linktext();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.LinkType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.jiaciv.agentrole.LinkType#getName()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.LinkType#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see de.dailab.jiaciv.agentrole.LinkType#getPath()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_Path();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.LinkType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.LinkType#getType()
	 * @see #getLinkType()
	 * @generated
	 */
	EAttribute getLinkType_Type();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.Ontologies <em>Ontologies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ontologies</em>'.
	 * @see de.dailab.jiaciv.agentrole.Ontologies
	 * @generated
	 */
	EClass getOntologies();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.Ontologies#getOntology <em>Ontology</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ontology</em>'.
	 * @see de.dailab.jiaciv.agentrole.Ontologies#getOntology()
	 * @see #getOntologies()
	 * @generated
	 */
	EReference getOntologies_Ontology();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.OntologyType <em>Ontology Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ontology Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.OntologyType
	 * @generated
	 */
	EClass getOntologyType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.OntologyType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.jiaciv.agentrole.OntologyType#getDescription()
	 * @see #getOntologyType()
	 * @generated
	 */
	EAttribute getOntologyType_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.OntologyType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.jiaciv.agentrole.OntologyType#getName()
	 * @see #getOntologyType()
	 * @generated
	 */
	EAttribute getOntologyType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.OntologyType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see de.dailab.jiaciv.agentrole.OntologyType#getPackage()
	 * @see #getOntologyType()
	 * @generated
	 */
	EAttribute getOntologyType_Package();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.OntologyType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.dailab.jiaciv.agentrole.OntologyType#getVersion()
	 * @see #getOntologyType()
	 * @generated
	 */
	EAttribute getOntologyType_Version();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.Plans <em>Plans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plans</em>'.
	 * @see de.dailab.jiaciv.agentrole.Plans
	 * @generated
	 */
	EClass getPlans();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.Plans#getPlan <em>Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plan</em>'.
	 * @see de.dailab.jiaciv.agentrole.Plans#getPlan()
	 * @see #getPlans()
	 * @generated
	 */
	EReference getPlans_Plan();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.PlanType <em>Plan Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plan Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.PlanType
	 * @generated
	 */
	EClass getPlanType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.PlanType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.jiaciv.agentrole.PlanType#getDescription()
	 * @see #getPlanType()
	 * @generated
	 */
	EAttribute getPlanType_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.PlanType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.jiaciv.agentrole.PlanType#getName()
	 * @see #getPlanType()
	 * @generated
	 */
	EAttribute getPlanType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.PlanType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see de.dailab.jiaciv.agentrole.PlanType#getPackage()
	 * @see #getPlanType()
	 * @generated
	 */
	EAttribute getPlanType_Package();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.Rules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rules</em>'.
	 * @see de.dailab.jiaciv.agentrole.Rules
	 * @generated
	 */
	EClass getRules();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.Rules#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rule</em>'.
	 * @see de.dailab.jiaciv.agentrole.Rules#getRule()
	 * @see #getRules()
	 * @generated
	 */
	EReference getRules_Rule();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.RuleType <em>Rule Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.RuleType
	 * @generated
	 */
	EClass getRuleType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.RuleType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.jiaciv.agentrole.RuleType#getDescription()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.RuleType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.jiaciv.agentrole.RuleType#getName()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.RuleType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see de.dailab.jiaciv.agentrole.RuleType#getPackage()
	 * @see #getRuleType()
	 * @generated
	 */
	EAttribute getRuleType_Package();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.Services <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Services</em>'.
	 * @see de.dailab.jiaciv.agentrole.Services
	 * @generated
	 */
	EClass getServices();

	/**
	 * Returns the meta object for the containment reference list '{@link de.dailab.jiaciv.agentrole.Services#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service</em>'.
	 * @see de.dailab.jiaciv.agentrole.Services#getService()
	 * @see #getServices()
	 * @generated
	 */
	EReference getServices_Service();

	/**
	 * Returns the meta object for class '{@link de.dailab.jiaciv.agentrole.ServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Type</em>'.
	 * @see de.dailab.jiaciv.agentrole.ServiceType
	 * @generated
	 */
	EClass getServiceType();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.ServiceType#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.dailab.jiaciv.agentrole.ServiceType#getDescription()
	 * @see #getServiceType()
	 * @generated
	 */
	EAttribute getServiceType_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.ServiceType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.dailab.jiaciv.agentrole.ServiceType#getName()
	 * @see #getServiceType()
	 * @generated
	 */
	EAttribute getServiceType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.dailab.jiaciv.agentrole.ServiceType#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see de.dailab.jiaciv.agentrole.ServiceType#getPackage()
	 * @see #getServiceType()
	 * @generated
	 */
	EAttribute getServiceType_Package();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AgentRoleFactory getAgentRoleFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.AgentPropertiesImpl <em>Agent Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.AgentPropertiesImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getAgentProperties()
		 * @generated
		 */
		EClass AGENT_PROPERTIES = eINSTANCE.getAgentProperties();

		/**
		 * The meta object literal for the '<em><b>Agent Property</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_PROPERTIES__AGENT_PROPERTY = eINSTANCE.getAgentProperties_AgentProperty();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.AgentPropertyTypeImpl <em>Agent Property Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.AgentPropertyTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getAgentPropertyType()
		 * @generated
		 */
		EClass AGENT_PROPERTY_TYPE = eINSTANCE.getAgentPropertyType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_PROPERTY_TYPE__DESCRIPTION = eINSTANCE.getAgentPropertyType_Description();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_PROPERTY_TYPE__KEY = eINSTANCE.getAgentPropertyType_Key();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_PROPERTY_TYPE__TYPE = eINSTANCE.getAgentPropertyType_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_PROPERTY_TYPE__VALUE = eINSTANCE.getAgentPropertyType_Value();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.AgentRoleRefTypeImpl <em>Ref Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRoleRefTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getAgentRoleRefType()
		 * @generated
		 */
		EClass AGENT_ROLE_REF_TYPE = eINSTANCE.getAgentRoleRefType();

		/**
		 * The meta object literal for the '<em><b>Jar</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_ROLE_REF_TYPE__JAR = eINSTANCE.getAgentRoleRefType_Jar();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_ROLE_REF_TYPE__NAME = eINSTANCE.getAgentRoleRefType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_ROLE_REF_TYPE__PACKAGE = eINSTANCE.getAgentRoleRefType_Package();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getAgentRoleType()
		 * @generated
		 */
		EClass AGENT_ROLE_TYPE = eINSTANCE.getAgentRoleType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__DESCRIPTION = eINSTANCE.getAgentRoleType_Description();

		/**
		 * The meta object literal for the '<em><b>Beans</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__BEANS = eINSTANCE.getAgentRoleType_Beans();

		/**
		 * The meta object literal for the '<em><b>Ontologies</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__ONTOLOGIES = eINSTANCE.getAgentRoleType_Ontologies();

		/**
		 * The meta object literal for the '<em><b>Facts</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__FACTS = eINSTANCE.getAgentRoleType_Facts();

		/**
		 * The meta object literal for the '<em><b>Plans</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__PLANS = eINSTANCE.getAgentRoleType_Plans();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__SERVICES = eINSTANCE.getAgentRoleType_Services();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__RULES = eINSTANCE.getAgentRoleType_Rules();

		/**
		 * The meta object literal for the '<em><b>Agentproperties</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__AGENTPROPERTIES = eINSTANCE.getAgentRoleType_Agentproperties();

		/**
		 * The meta object literal for the '<em><b>Agent Role</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__AGENT_ROLE = eINSTANCE.getAgentRoleType_AgentRole();

		/**
		 * The meta object literal for the '<em><b>Agent Role Ref</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__AGENT_ROLE_REF = eINSTANCE.getAgentRoleType_AgentRoleRef();

		/**
		 * The meta object literal for the '<em><b>Keywords</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_ROLE_TYPE__KEYWORDS = eINSTANCE.getAgentRoleType_Keywords();

		/**
		 * The meta object literal for the '<em><b>Depends</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT_ROLE_TYPE__DEPENDS = eINSTANCE.getAgentRoleType_Depends();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_ROLE_TYPE__NAME = eINSTANCE.getAgentRoleType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_ROLE_TYPE__PACKAGE = eINSTANCE.getAgentRoleType_Package();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGENT_ROLE_TYPE__TYPE = eINSTANCE.getAgentRoleType_Type();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl <em>Bean Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getBeanProperties()
		 * @generated
		 */
		EClass BEAN_PROPERTIES = eINSTANCE.getBeanProperties();

		/**
		 * The meta object literal for the '<em><b>Dependentproperty</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEAN_PROPERTIES__DEPENDENTPROPERTY = eINSTANCE.getBeanProperties_Dependentproperty();

		/**
		 * The meta object literal for the '<em><b>Depends</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_PROPERTIES__DEPENDS = eINSTANCE.getBeanProperties_Depends();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_PROPERTIES__DESCRIPTION = eINSTANCE.getBeanProperties_Description();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_PROPERTIES__KEY = eINSTANCE.getBeanProperties_Key();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_PROPERTIES__TYPE = eINSTANCE.getBeanProperties_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_PROPERTIES__VALUE = eINSTANCE.getBeanProperties_Value();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.BeansImpl <em>Beans</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.BeansImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getBeans()
		 * @generated
		 */
		EClass BEANS = eINSTANCE.getBeans();

		/**
		 * The meta object literal for the '<em><b>Bean</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEANS__BEAN = eINSTANCE.getBeans_Bean();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.BeanTypeImpl <em>Bean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.BeanTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getBeanType()
		 * @generated
		 */
		EClass BEAN_TYPE = eINSTANCE.getBeanType();

		/**
		 * The meta object literal for the '<em><b>Beanproperties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEAN_TYPE__BEANPROPERTIES = eINSTANCE.getBeanType_Beanproperties();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_TYPE__DESCRIPTION = eINSTANCE.getBeanType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_TYPE__NAME = eINSTANCE.getBeanType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEAN_TYPE__PACKAGE = eINSTANCE.getBeanType_Package();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.DescriptionTypeImpl <em>Description Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.DescriptionTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getDescriptionType()
		 * @generated
		 */
		EClass DESCRIPTION_TYPE = eINSTANCE.getDescriptionType();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION_TYPE__TEXT = eINSTANCE.getDescriptionType_Text();

		/**
		 * The meta object literal for the '<em><b>Link</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DESCRIPTION_TYPE__LINK = eINSTANCE.getDescriptionType_Link();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.DocumentRootImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Agent Role</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__AGENT_ROLE = eINSTANCE.getDocumentRoot_AgentRole();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.FactsImpl <em>Facts</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.FactsImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getFacts()
		 * @generated
		 */
		EClass FACTS = eINSTANCE.getFacts();

		/**
		 * The meta object literal for the '<em><b>Fact</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FACTS__FACT = eINSTANCE.getFacts_Fact();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.FactTypeImpl <em>Fact Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.FactTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getFactType()
		 * @generated
		 */
		EClass FACT_TYPE = eINSTANCE.getFactType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACT_TYPE__DESCRIPTION = eINSTANCE.getFactType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACT_TYPE__NAME = eINSTANCE.getFactType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FACT_TYPE__PACKAGE = eINSTANCE.getFactType_Package();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.LinkTypeImpl <em>Link Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.LinkTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getLinkType()
		 * @generated
		 */
		EClass LINK_TYPE = eINSTANCE.getLinkType();

		/**
		 * The meta object literal for the '<em><b>Linktext</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__LINKTEXT = eINSTANCE.getLinkType_Linktext();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__NAME = eINSTANCE.getLinkType_Name();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__PATH = eINSTANCE.getLinkType_Path();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINK_TYPE__TYPE = eINSTANCE.getLinkType_Type();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.OntologiesImpl <em>Ontologies</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.OntologiesImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getOntologies()
		 * @generated
		 */
		EClass ONTOLOGIES = eINSTANCE.getOntologies();

		/**
		 * The meta object literal for the '<em><b>Ontology</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ONTOLOGIES__ONTOLOGY = eINSTANCE.getOntologies_Ontology();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.OntologyTypeImpl <em>Ontology Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.OntologyTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getOntologyType()
		 * @generated
		 */
		EClass ONTOLOGY_TYPE = eINSTANCE.getOntologyType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ONTOLOGY_TYPE__DESCRIPTION = eINSTANCE.getOntologyType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ONTOLOGY_TYPE__NAME = eINSTANCE.getOntologyType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ONTOLOGY_TYPE__PACKAGE = eINSTANCE.getOntologyType_Package();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ONTOLOGY_TYPE__VERSION = eINSTANCE.getOntologyType_Version();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.PlansImpl <em>Plans</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.PlansImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getPlans()
		 * @generated
		 */
		EClass PLANS = eINSTANCE.getPlans();

		/**
		 * The meta object literal for the '<em><b>Plan</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLANS__PLAN = eINSTANCE.getPlans_Plan();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.PlanTypeImpl <em>Plan Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.PlanTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getPlanType()
		 * @generated
		 */
		EClass PLAN_TYPE = eINSTANCE.getPlanType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAN_TYPE__DESCRIPTION = eINSTANCE.getPlanType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAN_TYPE__NAME = eINSTANCE.getPlanType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLAN_TYPE__PACKAGE = eINSTANCE.getPlanType_Package();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.RulesImpl <em>Rules</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.RulesImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getRules()
		 * @generated
		 */
		EClass RULES = eINSTANCE.getRules();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULES__RULE = eINSTANCE.getRules_Rule();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.RuleTypeImpl <em>Rule Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.RuleTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getRuleType()
		 * @generated
		 */
		EClass RULE_TYPE = eINSTANCE.getRuleType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__DESCRIPTION = eINSTANCE.getRuleType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__NAME = eINSTANCE.getRuleType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE_TYPE__PACKAGE = eINSTANCE.getRuleType_Package();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.ServicesImpl <em>Services</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.ServicesImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getServices()
		 * @generated
		 */
		EClass SERVICES = eINSTANCE.getServices();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICES__SERVICE = eINSTANCE.getServices_Service();

		/**
		 * The meta object literal for the '{@link de.dailab.jiaciv.agentrole.impl.ServiceTypeImpl <em>Service Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.dailab.jiaciv.agentrole.impl.ServiceTypeImpl
		 * @see de.dailab.jiaciv.agentrole.impl.AgentRolePackageImpl#getServiceType()
		 * @generated
		 */
		EClass SERVICE_TYPE = eINSTANCE.getServiceType();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_TYPE__DESCRIPTION = eINSTANCE.getServiceType_Description();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_TYPE__NAME = eINSTANCE.getServiceType_Name();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_TYPE__PACKAGE = eINSTANCE.getServiceType_Package();

	}

} //AgentRolePackage
