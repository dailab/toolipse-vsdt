/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.dailab.jiaciv.agentrole.AgentProperties;
import de.dailab.jiaciv.agentrole.AgentPropertyType;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.dailab.jiaciv.agentrole.AgentRolePackage
 * @generated
 */
public class AgentRoleAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AgentRolePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentRoleAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AgentRolePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AgentRoleSwitch<Adapter> modelSwitch =
		new AgentRoleSwitch<Adapter>() {
			@Override
			public Adapter caseAgentProperties(AgentProperties object) {
				return createAgentPropertiesAdapter();
			}
			@Override
			public Adapter caseAgentPropertyType(AgentPropertyType object) {
				return createAgentPropertyTypeAdapter();
			}
			@Override
			public Adapter caseAgentRoleRefType(AgentRoleRefType object) {
				return createAgentRoleRefTypeAdapter();
			}
			@Override
			public Adapter caseAgentRoleType(AgentRoleType object) {
				return createAgentRoleTypeAdapter();
			}
			@Override
			public Adapter caseBeanProperties(BeanProperties object) {
				return createBeanPropertiesAdapter();
			}
			@Override
			public Adapter caseBeans(Beans object) {
				return createBeansAdapter();
			}
			@Override
			public Adapter caseBeanType(BeanType object) {
				return createBeanTypeAdapter();
			}
			@Override
			public Adapter caseDescriptionType(DescriptionType object) {
				return createDescriptionTypeAdapter();
			}
			@Override
			public Adapter caseDocumentRoot(DocumentRoot object) {
				return createDocumentRootAdapter();
			}
			@Override
			public Adapter caseFacts(Facts object) {
				return createFactsAdapter();
			}
			@Override
			public Adapter caseFactType(FactType object) {
				return createFactTypeAdapter();
			}
			@Override
			public Adapter caseLinkType(LinkType object) {
				return createLinkTypeAdapter();
			}
			@Override
			public Adapter caseOntologies(Ontologies object) {
				return createOntologiesAdapter();
			}
			@Override
			public Adapter caseOntologyType(OntologyType object) {
				return createOntologyTypeAdapter();
			}
			@Override
			public Adapter casePlans(Plans object) {
				return createPlansAdapter();
			}
			@Override
			public Adapter casePlanType(PlanType object) {
				return createPlanTypeAdapter();
			}
			@Override
			public Adapter caseRules(Rules object) {
				return createRulesAdapter();
			}
			@Override
			public Adapter caseRuleType(RuleType object) {
				return createRuleTypeAdapter();
			}
			@Override
			public Adapter caseServices(Services object) {
				return createServicesAdapter();
			}
			@Override
			public Adapter caseServiceType(ServiceType object) {
				return createServiceTypeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.AgentProperties <em>Agent Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.AgentProperties
	 * @generated
	 */
	public Adapter createAgentPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.AgentPropertyType <em>Agent Property Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.AgentPropertyType
	 * @generated
	 */
	public Adapter createAgentPropertyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.AgentRoleRefType <em>Ref Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleRefType
	 * @generated
	 */
	public Adapter createAgentRoleRefTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.AgentRoleType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.AgentRoleType
	 * @generated
	 */
	public Adapter createAgentRoleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.BeanProperties <em>Bean Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.BeanProperties
	 * @generated
	 */
	public Adapter createBeanPropertiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.Beans <em>Beans</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.Beans
	 * @generated
	 */
	public Adapter createBeansAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.BeanType <em>Bean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.BeanType
	 * @generated
	 */
	public Adapter createBeanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.DescriptionType <em>Description Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.DescriptionType
	 * @generated
	 */
	public Adapter createDescriptionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.DocumentRoot
	 * @generated
	 */
	public Adapter createDocumentRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.Facts <em>Facts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.Facts
	 * @generated
	 */
	public Adapter createFactsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.FactType <em>Fact Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.FactType
	 * @generated
	 */
	public Adapter createFactTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.LinkType <em>Link Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.LinkType
	 * @generated
	 */
	public Adapter createLinkTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.Ontologies <em>Ontologies</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.Ontologies
	 * @generated
	 */
	public Adapter createOntologiesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.OntologyType <em>Ontology Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.OntologyType
	 * @generated
	 */
	public Adapter createOntologyTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.Plans <em>Plans</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.Plans
	 * @generated
	 */
	public Adapter createPlansAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.PlanType <em>Plan Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.PlanType
	 * @generated
	 */
	public Adapter createPlanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.Rules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.Rules
	 * @generated
	 */
	public Adapter createRulesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.RuleType <em>Rule Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.RuleType
	 * @generated
	 */
	public Adapter createRuleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.Services <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.Services
	 * @generated
	 */
	public Adapter createServicesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.dailab.jiaciv.agentrole.ServiceType <em>Service Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.dailab.jiaciv.agentrole.ServiceType
	 * @generated
	 */
	public Adapter createServiceTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AgentRoleAdapterFactory
