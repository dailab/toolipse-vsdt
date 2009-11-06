/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.dailab.jiaciv.agentrole.AgentProperties;
import de.dailab.jiaciv.agentrole.AgentPropertyType;
import de.dailab.jiaciv.agentrole.AgentRoleFactory;
import de.dailab.jiaciv.agentrole.AgentRolePackage;
import de.dailab.jiaciv.agentrole.AgentRoleRefType;
import de.dailab.jiaciv.agentrole.AgentRoleType;
import de.dailab.jiaciv.agentrole.BeanProperties;
import de.dailab.jiaciv.agentrole.BeanType;
import de.dailab.jiaciv.agentrole.Beans;
import de.dailab.jiaciv.agentrole.DescriptionType;
import de.dailab.jiaciv.agentrole.DocumentRoot;
import de.dailab.jiaciv.agentrole.FactType;
import de.dailab.jiaciv.agentrole.Facts;
import de.dailab.jiaciv.agentrole.LinkType;
import de.dailab.jiaciv.agentrole.Ontologies;
import de.dailab.jiaciv.agentrole.OntologyType;
import de.dailab.jiaciv.agentrole.PlanType;
import de.dailab.jiaciv.agentrole.Plans;
import de.dailab.jiaciv.agentrole.RuleType;
import de.dailab.jiaciv.agentrole.Rules;
import de.dailab.jiaciv.agentrole.ServiceType;
import de.dailab.jiaciv.agentrole.Services;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AgentRoleFactoryImpl extends EFactoryImpl implements AgentRoleFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AgentRoleFactory init() {
		try {
			AgentRoleFactory theAgentRoleFactory = (AgentRoleFactory)EPackage.Registry.INSTANCE.getEFactory("platform:/resource/MappingTool/model/AgentRole.xsd"); 
			if (theAgentRoleFactory != null) {
				return theAgentRoleFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AgentRoleFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentRoleFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AgentRolePackage.AGENT_PROPERTIES: return createAgentProperties();
			case AgentRolePackage.AGENT_PROPERTY_TYPE: return createAgentPropertyType();
			case AgentRolePackage.AGENT_ROLE_REF_TYPE: return createAgentRoleRefType();
			case AgentRolePackage.AGENT_ROLE_TYPE: return createAgentRoleType();
			case AgentRolePackage.BEAN_PROPERTIES: return createBeanProperties();
			case AgentRolePackage.BEANS: return createBeans();
			case AgentRolePackage.BEAN_TYPE: return createBeanType();
			case AgentRolePackage.DESCRIPTION_TYPE: return createDescriptionType();
			case AgentRolePackage.DOCUMENT_ROOT: return createDocumentRoot();
			case AgentRolePackage.FACTS: return createFacts();
			case AgentRolePackage.FACT_TYPE: return createFactType();
			case AgentRolePackage.LINK_TYPE: return createLinkType();
			case AgentRolePackage.ONTOLOGIES: return createOntologies();
			case AgentRolePackage.ONTOLOGY_TYPE: return createOntologyType();
			case AgentRolePackage.PLANS: return createPlans();
			case AgentRolePackage.PLAN_TYPE: return createPlanType();
			case AgentRolePackage.RULES: return createRules();
			case AgentRolePackage.RULE_TYPE: return createRuleType();
			case AgentRolePackage.SERVICES: return createServices();
			case AgentRolePackage.SERVICE_TYPE: return createServiceType();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentProperties createAgentProperties() {
		AgentPropertiesImpl agentProperties = new AgentPropertiesImpl();
		return agentProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentPropertyType createAgentPropertyType() {
		AgentPropertyTypeImpl agentPropertyType = new AgentPropertyTypeImpl();
		return agentPropertyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentRoleRefType createAgentRoleRefType() {
		AgentRoleRefTypeImpl agentRoleRefType = new AgentRoleRefTypeImpl();
		return agentRoleRefType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentRoleType createAgentRoleType() {
		AgentRoleTypeImpl agentRoleType = new AgentRoleTypeImpl();
		return agentRoleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanProperties createBeanProperties() {
		BeanPropertiesImpl beanProperties = new BeanPropertiesImpl();
		return beanProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Beans createBeans() {
		BeansImpl beans = new BeansImpl();
		return beans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeanType createBeanType() {
		BeanTypeImpl beanType = new BeanTypeImpl();
		return beanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionType createDescriptionType() {
		DescriptionTypeImpl descriptionType = new DescriptionTypeImpl();
		return descriptionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Facts createFacts() {
		FactsImpl facts = new FactsImpl();
		return facts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FactType createFactType() {
		FactTypeImpl factType = new FactTypeImpl();
		return factType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LinkType createLinkType() {
		LinkTypeImpl linkType = new LinkTypeImpl();
		return linkType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ontologies createOntologies() {
		OntologiesImpl ontologies = new OntologiesImpl();
		return ontologies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OntologyType createOntologyType() {
		OntologyTypeImpl ontologyType = new OntologyTypeImpl();
		return ontologyType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plans createPlans() {
		PlansImpl plans = new PlansImpl();
		return plans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PlanType createPlanType() {
		PlanTypeImpl planType = new PlanTypeImpl();
		return planType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rules createRules() {
		RulesImpl rules = new RulesImpl();
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleType createRuleType() {
		RuleTypeImpl ruleType = new RuleTypeImpl();
		return ruleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Services createServices() {
		ServicesImpl services = new ServicesImpl();
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceType createServiceType() {
		ServiceTypeImpl serviceType = new ServiceTypeImpl();
		return serviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentRolePackage getAgentRolePackage() {
		return (AgentRolePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AgentRolePackage getPackage() {
		return AgentRolePackage.eINSTANCE;
	}

} //AgentRoleFactoryImpl
