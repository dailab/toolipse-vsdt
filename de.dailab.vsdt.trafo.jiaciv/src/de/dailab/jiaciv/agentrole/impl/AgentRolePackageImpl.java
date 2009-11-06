/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

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
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AgentRolePackageImpl extends EPackageImpl implements AgentRolePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass agentPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass agentPropertyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass agentRoleRefTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass agentRoleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beanPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beansEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass beanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass factsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass factTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ontologiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ontologyTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass plansEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass planTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rulesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass servicesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceTypeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AgentRolePackageImpl() {
		super(eNS_URI, AgentRoleFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AgentRolePackage init() {
		if (isInited) return (AgentRolePackage)EPackage.Registry.INSTANCE.getEPackage(AgentRolePackage.eNS_URI);

		// Obtain or create and register package
		AgentRolePackageImpl theAgentRolePackage = (AgentRolePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AgentRolePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new AgentRolePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAgentRolePackage.createPackageContents();

		// Initialize created meta-data
		theAgentRolePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAgentRolePackage.freeze();

		return theAgentRolePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAgentProperties() {
		return agentPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentProperties_AgentProperty() {
		return (EReference)agentPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAgentPropertyType() {
		return agentPropertyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentPropertyType_Description() {
		return (EAttribute)agentPropertyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentPropertyType_Key() {
		return (EAttribute)agentPropertyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentPropertyType_Type() {
		return (EAttribute)agentPropertyTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentPropertyType_Value() {
		return (EAttribute)agentPropertyTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAgentRoleRefType() {
		return agentRoleRefTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentRoleRefType_Jar() {
		return (EAttribute)agentRoleRefTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentRoleRefType_Name() {
		return (EAttribute)agentRoleRefTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentRoleRefType_Package() {
		return (EAttribute)agentRoleRefTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAgentRoleType() {
		return agentRoleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_Description() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_Beans() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_Ontologies() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_Facts() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_Plans() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_Services() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_Rules() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_Agentproperties() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_AgentRole() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_AgentRoleRef() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentRoleType_Keywords() {
		return (EAttribute)agentRoleTypeEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAgentRoleType_Depends() {
		return (EReference)agentRoleTypeEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentRoleType_Name() {
		return (EAttribute)agentRoleTypeEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentRoleType_Package() {
		return (EAttribute)agentRoleTypeEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAgentRoleType_Type() {
		return (EAttribute)agentRoleTypeEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeanProperties() {
		return beanPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeanProperties_Dependentproperty() {
		return (EReference)beanPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanProperties_Depends() {
		return (EAttribute)beanPropertiesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanProperties_Description() {
		return (EAttribute)beanPropertiesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanProperties_Key() {
		return (EAttribute)beanPropertiesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanProperties_Type() {
		return (EAttribute)beanPropertiesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanProperties_Value() {
		return (EAttribute)beanPropertiesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeans() {
		return beansEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeans_Bean() {
		return (EReference)beansEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBeanType() {
		return beanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBeanType_Beanproperties() {
		return (EReference)beanTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanType_Description() {
		return (EAttribute)beanTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanType_Name() {
		return (EAttribute)beanTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBeanType_Package() {
		return (EAttribute)beanTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDescriptionType() {
		return descriptionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDescriptionType_Text() {
		return (EAttribute)descriptionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDescriptionType_Link() {
		return (EReference)descriptionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute)documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentRoot_AgentRole() {
		return (EReference)documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFacts() {
		return factsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFacts_Fact() {
		return (EReference)factsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFactType() {
		return factTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFactType_Description() {
		return (EAttribute)factTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFactType_Name() {
		return (EAttribute)factTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFactType_Package() {
		return (EAttribute)factTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkType() {
		return linkTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Linktext() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Name() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Path() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLinkType_Type() {
		return (EAttribute)linkTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOntologies() {
		return ontologiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOntologies_Ontology() {
		return (EReference)ontologiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOntologyType() {
		return ontologyTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOntologyType_Description() {
		return (EAttribute)ontologyTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOntologyType_Name() {
		return (EAttribute)ontologyTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOntologyType_Package() {
		return (EAttribute)ontologyTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOntologyType_Version() {
		return (EAttribute)ontologyTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlans() {
		return plansEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPlans_Plan() {
		return (EReference)plansEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlanType() {
		return planTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlanType_Description() {
		return (EAttribute)planTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlanType_Name() {
		return (EAttribute)planTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlanType_Package() {
		return (EAttribute)planTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRules() {
		return rulesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRules_Rule() {
		return (EReference)rulesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleType() {
		return ruleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_Description() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_Name() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRuleType_Package() {
		return (EAttribute)ruleTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServices() {
		return servicesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServices_Service() {
		return (EReference)servicesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceType() {
		return serviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceType_Description() {
		return (EAttribute)serviceTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceType_Name() {
		return (EAttribute)serviceTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceType_Package() {
		return (EAttribute)serviceTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentRoleFactory getAgentRoleFactory() {
		return (AgentRoleFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		agentPropertiesEClass = createEClass(AGENT_PROPERTIES);
		createEReference(agentPropertiesEClass, AGENT_PROPERTIES__AGENT_PROPERTY);

		agentPropertyTypeEClass = createEClass(AGENT_PROPERTY_TYPE);
		createEAttribute(agentPropertyTypeEClass, AGENT_PROPERTY_TYPE__DESCRIPTION);
		createEAttribute(agentPropertyTypeEClass, AGENT_PROPERTY_TYPE__KEY);
		createEAttribute(agentPropertyTypeEClass, AGENT_PROPERTY_TYPE__TYPE);
		createEAttribute(agentPropertyTypeEClass, AGENT_PROPERTY_TYPE__VALUE);

		agentRoleRefTypeEClass = createEClass(AGENT_ROLE_REF_TYPE);
		createEAttribute(agentRoleRefTypeEClass, AGENT_ROLE_REF_TYPE__JAR);
		createEAttribute(agentRoleRefTypeEClass, AGENT_ROLE_REF_TYPE__NAME);
		createEAttribute(agentRoleRefTypeEClass, AGENT_ROLE_REF_TYPE__PACKAGE);

		agentRoleTypeEClass = createEClass(AGENT_ROLE_TYPE);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__DESCRIPTION);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__BEANS);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__ONTOLOGIES);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__FACTS);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__PLANS);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__SERVICES);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__RULES);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__AGENTPROPERTIES);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__AGENT_ROLE);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__AGENT_ROLE_REF);
		createEAttribute(agentRoleTypeEClass, AGENT_ROLE_TYPE__KEYWORDS);
		createEReference(agentRoleTypeEClass, AGENT_ROLE_TYPE__DEPENDS);
		createEAttribute(agentRoleTypeEClass, AGENT_ROLE_TYPE__NAME);
		createEAttribute(agentRoleTypeEClass, AGENT_ROLE_TYPE__PACKAGE);
		createEAttribute(agentRoleTypeEClass, AGENT_ROLE_TYPE__TYPE);

		beanPropertiesEClass = createEClass(BEAN_PROPERTIES);
		createEReference(beanPropertiesEClass, BEAN_PROPERTIES__DEPENDENTPROPERTY);
		createEAttribute(beanPropertiesEClass, BEAN_PROPERTIES__DEPENDS);
		createEAttribute(beanPropertiesEClass, BEAN_PROPERTIES__DESCRIPTION);
		createEAttribute(beanPropertiesEClass, BEAN_PROPERTIES__KEY);
		createEAttribute(beanPropertiesEClass, BEAN_PROPERTIES__TYPE);
		createEAttribute(beanPropertiesEClass, BEAN_PROPERTIES__VALUE);

		beansEClass = createEClass(BEANS);
		createEReference(beansEClass, BEANS__BEAN);

		beanTypeEClass = createEClass(BEAN_TYPE);
		createEReference(beanTypeEClass, BEAN_TYPE__BEANPROPERTIES);
		createEAttribute(beanTypeEClass, BEAN_TYPE__DESCRIPTION);
		createEAttribute(beanTypeEClass, BEAN_TYPE__NAME);
		createEAttribute(beanTypeEClass, BEAN_TYPE__PACKAGE);

		descriptionTypeEClass = createEClass(DESCRIPTION_TYPE);
		createEAttribute(descriptionTypeEClass, DESCRIPTION_TYPE__TEXT);
		createEReference(descriptionTypeEClass, DESCRIPTION_TYPE__LINK);

		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__AGENT_ROLE);

		factsEClass = createEClass(FACTS);
		createEReference(factsEClass, FACTS__FACT);

		factTypeEClass = createEClass(FACT_TYPE);
		createEAttribute(factTypeEClass, FACT_TYPE__DESCRIPTION);
		createEAttribute(factTypeEClass, FACT_TYPE__NAME);
		createEAttribute(factTypeEClass, FACT_TYPE__PACKAGE);

		linkTypeEClass = createEClass(LINK_TYPE);
		createEAttribute(linkTypeEClass, LINK_TYPE__LINKTEXT);
		createEAttribute(linkTypeEClass, LINK_TYPE__NAME);
		createEAttribute(linkTypeEClass, LINK_TYPE__PATH);
		createEAttribute(linkTypeEClass, LINK_TYPE__TYPE);

		ontologiesEClass = createEClass(ONTOLOGIES);
		createEReference(ontologiesEClass, ONTOLOGIES__ONTOLOGY);

		ontologyTypeEClass = createEClass(ONTOLOGY_TYPE);
		createEAttribute(ontologyTypeEClass, ONTOLOGY_TYPE__DESCRIPTION);
		createEAttribute(ontologyTypeEClass, ONTOLOGY_TYPE__NAME);
		createEAttribute(ontologyTypeEClass, ONTOLOGY_TYPE__PACKAGE);
		createEAttribute(ontologyTypeEClass, ONTOLOGY_TYPE__VERSION);

		plansEClass = createEClass(PLANS);
		createEReference(plansEClass, PLANS__PLAN);

		planTypeEClass = createEClass(PLAN_TYPE);
		createEAttribute(planTypeEClass, PLAN_TYPE__DESCRIPTION);
		createEAttribute(planTypeEClass, PLAN_TYPE__NAME);
		createEAttribute(planTypeEClass, PLAN_TYPE__PACKAGE);

		rulesEClass = createEClass(RULES);
		createEReference(rulesEClass, RULES__RULE);

		ruleTypeEClass = createEClass(RULE_TYPE);
		createEAttribute(ruleTypeEClass, RULE_TYPE__DESCRIPTION);
		createEAttribute(ruleTypeEClass, RULE_TYPE__NAME);
		createEAttribute(ruleTypeEClass, RULE_TYPE__PACKAGE);

		servicesEClass = createEClass(SERVICES);
		createEReference(servicesEClass, SERVICES__SERVICE);

		serviceTypeEClass = createEClass(SERVICE_TYPE);
		createEAttribute(serviceTypeEClass, SERVICE_TYPE__DESCRIPTION);
		createEAttribute(serviceTypeEClass, SERVICE_TYPE__NAME);
		createEAttribute(serviceTypeEClass, SERVICE_TYPE__PACKAGE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(agentPropertiesEClass, AgentProperties.class, "AgentProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAgentProperties_AgentProperty(), this.getAgentPropertyType(), null, "agentProperty", null, 0, -1, AgentProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(agentPropertyTypeEClass, AgentPropertyType.class, "AgentPropertyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAgentPropertyType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, AgentPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentPropertyType_Key(), theXMLTypePackage.getString(), "key", null, 0, 1, AgentPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentPropertyType_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, AgentPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentPropertyType_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, AgentPropertyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(agentRoleRefTypeEClass, AgentRoleRefType.class, "AgentRoleRefType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAgentRoleRefType_Jar(), theXMLTypePackage.getString(), "jar", null, 0, 1, AgentRoleRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentRoleRefType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, AgentRoleRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentRoleRefType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, AgentRoleRefType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(agentRoleTypeEClass, AgentRoleType.class, "AgentRoleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAgentRoleType_Description(), this.getDescriptionType(), null, "description", null, 0, -1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_Beans(), this.getBeans(), null, "beans", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_Ontologies(), this.getOntologies(), null, "ontologies", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_Facts(), this.getFacts(), null, "facts", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_Plans(), this.getPlans(), null, "plans", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_Services(), this.getServices(), null, "services", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_Rules(), this.getRules(), null, "rules", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_Agentproperties(), this.getAgentProperties(), null, "agentproperties", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_AgentRole(), this.getAgentRoleType(), null, "agentRole", null, 0, -1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_AgentRoleRef(), this.getAgentRoleRefType(), null, "agentRoleRef", null, 0, -1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentRoleType_Keywords(), theXMLTypePackage.getString(), "keywords", null, 0, -1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAgentRoleType_Depends(), this.getAgentRoleRefType(), null, "depends", null, 0, -1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentRoleType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentRoleType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAgentRoleType_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, AgentRoleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(beanPropertiesEClass, BeanProperties.class, "BeanProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBeanProperties_Dependentproperty(), this.getBeanProperties(), null, "dependentproperty", null, 0, -1, BeanProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanProperties_Depends(), theXMLTypePackage.getString(), "depends", null, 0, 1, BeanProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanProperties_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, BeanProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanProperties_Key(), theXMLTypePackage.getString(), "key", null, 0, 1, BeanProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanProperties_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, BeanProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanProperties_Value(), theXMLTypePackage.getString(), "value", null, 0, 1, BeanProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(beansEClass, Beans.class, "Beans", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBeans_Bean(), this.getBeanType(), null, "bean", null, 0, -1, Beans.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(beanTypeEClass, BeanType.class, "BeanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBeanType_Beanproperties(), this.getBeanProperties(), null, "beanproperties", null, 0, -1, BeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, BeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, BeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBeanType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, BeanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionTypeEClass, DescriptionType.class, "DescriptionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptionType_Text(), theXMLTypePackage.getString(), "text", null, 1, 1, DescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDescriptionType_Link(), this.getLinkType(), null, "link", null, 0, 1, DescriptionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null, "xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null, "xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_AgentRole(), this.getAgentRoleType(), null, "agentRole", null, 0, -1, null, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(factsEClass, Facts.class, "Facts", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFacts_Fact(), this.getFactType(), null, "fact", null, 0, -1, Facts.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(factTypeEClass, FactType.class, "FactType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFactType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, FactType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFactType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, FactType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFactType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, FactType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(linkTypeEClass, LinkType.class, "LinkType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLinkType_Linktext(), theXMLTypePackage.getString(), "linktext", null, 1, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_Path(), theXMLTypePackage.getString(), "path", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLinkType_Type(), theXMLTypePackage.getString(), "type", null, 0, 1, LinkType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ontologiesEClass, Ontologies.class, "Ontologies", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOntologies_Ontology(), this.getOntologyType(), null, "ontology", null, 0, -1, Ontologies.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ontologyTypeEClass, OntologyType.class, "OntologyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOntologyType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, OntologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOntologyType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, OntologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOntologyType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, OntologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOntologyType_Version(), theXMLTypePackage.getString(), "version", null, 0, 1, OntologyType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(plansEClass, Plans.class, "Plans", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlans_Plan(), this.getPlanType(), null, "plan", null, 0, -1, Plans.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(planTypeEClass, PlanType.class, "PlanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlanType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, PlanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlanType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, PlanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlanType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, PlanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rulesEClass, Rules.class, "Rules", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRules_Rule(), this.getRuleType(), null, "rule", null, 0, -1, Rules.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleTypeEClass, RuleType.class, "RuleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, RuleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(servicesEClass, Services.class, "Services", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServices_Service(), this.getServiceType(), null, "service", null, 0, -1, Services.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceTypeEClass, ServiceType.class, "ServiceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceType_Description(), theXMLTypePackage.getString(), "description", null, 0, 1, ServiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceType_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, ServiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceType_Package(), theXMLTypePackage.getString(), "package", null, 0, 1, ServiceType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "qualified", "false"
		   });		
		addAnnotation
		  (agentPropertiesEClass, 
		   source, 
		   new String[] {
			 "name", "AgentProperties",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAgentProperties_AgentProperty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AgentProperty",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (agentPropertyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "AgentPropertyType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getAgentPropertyType_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentPropertyType_Key(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "key",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentPropertyType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentPropertyType_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (agentRoleRefTypeEClass, 
		   source, 
		   new String[] {
			 "name", "AgentRoleRefType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getAgentRoleRefType_Jar(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "jar",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleRefType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleRefType_Package(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "package",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (agentRoleTypeEClass, 
		   source, 
		   new String[] {
			 "name", "AgentRoleType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAgentRoleType_Description(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Beans(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "beans",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Ontologies(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ontologies",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Facts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "facts",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Plans(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "plans",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Services(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "services",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Rules(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "rules",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Agentproperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "agentproperties",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_AgentRole(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AgentRole",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_AgentRoleRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AgentRoleRef",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Keywords(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "keywords",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Depends(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "depends",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Package(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "package",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getAgentRoleType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (beanPropertiesEClass, 
		   source, 
		   new String[] {
			 "name", "BeanProperties",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBeanProperties_Dependentproperty(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "dependentproperty",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getBeanProperties_Depends(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "depends",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getBeanProperties_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getBeanProperties_Key(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "key",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getBeanProperties_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getBeanProperties_Value(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "value",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (beansEClass, 
		   source, 
		   new String[] {
			 "name", "Beans",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBeans_Bean(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Bean",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (beanTypeEClass, 
		   source, 
		   new String[] {
			 "name", "BeanType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getBeanType_Beanproperties(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "beanproperties",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getBeanType_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getBeanType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getBeanType_Package(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "package",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (descriptionTypeEClass, 
		   source, 
		   new String[] {
			 "name", "DescriptionType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getDescriptionType_Text(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "text",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getDescriptionType_Link(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "link",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (documentRootEClass, 
		   source, 
		   new String[] {
			 "name", "",
			 "kind", "mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_Mixed(), 
		   source, 
		   new String[] {
			 "kind", "elementWildcard",
			 "name", ":mixed"
		   });		
		addAnnotation
		  (getDocumentRoot_XMLNSPrefixMap(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xmlns:prefix"
		   });		
		addAnnotation
		  (getDocumentRoot_XSISchemaLocation(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "xsi:schemaLocation"
		   });		
		addAnnotation
		  (getDocumentRoot_AgentRole(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AgentRole",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (factsEClass, 
		   source, 
		   new String[] {
			 "name", "Facts",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getFacts_Fact(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Fact",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (factTypeEClass, 
		   source, 
		   new String[] {
			 "name", "FactType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getFactType_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFactType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getFactType_Package(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "package",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (linkTypeEClass, 
		   source, 
		   new String[] {
			 "name", "LinkType",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getLinkType_Linktext(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "linktext",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getLinkType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getLinkType_Path(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "path",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getLinkType_Type(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "type",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (ontologiesEClass, 
		   source, 
		   new String[] {
			 "name", "Ontologies",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getOntologies_Ontology(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Ontology",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (ontologyTypeEClass, 
		   source, 
		   new String[] {
			 "name", "OntologyType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getOntologyType_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOntologyType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOntologyType_Package(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "package",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getOntologyType_Version(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "version",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (plansEClass, 
		   source, 
		   new String[] {
			 "name", "Plans",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getPlans_Plan(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Plan",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (planTypeEClass, 
		   source, 
		   new String[] {
			 "name", "PlanType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getPlanType_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPlanType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getPlanType_Package(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "package",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (rulesEClass, 
		   source, 
		   new String[] {
			 "name", "Rules",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getRules_Rule(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Rule",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (ruleTypeEClass, 
		   source, 
		   new String[] {
			 "name", "RuleType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getRuleType_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRuleType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getRuleType_Package(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "package",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (servicesEClass, 
		   source, 
		   new String[] {
			 "name", "Services",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getServices_Service(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Service",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (serviceTypeEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceType",
			 "kind", "empty"
		   });		
		addAnnotation
		  (getServiceType_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "description",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getServiceType_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "name",
			 "namespace", "##targetNamespace"
		   });		
		addAnnotation
		  (getServiceType_Package(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "package",
			 "namespace", "##targetNamespace"
		   });
	}

} //AgentRolePackageImpl
