/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole.impl;

import de.dailab.jiaciv.agentrole.AgentProperties;
import de.dailab.jiaciv.agentrole.AgentRolePackage;
import de.dailab.jiaciv.agentrole.AgentRoleRefType;
import de.dailab.jiaciv.agentrole.AgentRoleType;
import de.dailab.jiaciv.agentrole.Beans;
import de.dailab.jiaciv.agentrole.DescriptionType;
import de.dailab.jiaciv.agentrole.Facts;
import de.dailab.jiaciv.agentrole.Ontologies;
import de.dailab.jiaciv.agentrole.Plans;
import de.dailab.jiaciv.agentrole.Rules;
import de.dailab.jiaciv.agentrole.Services;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getBeans <em>Beans</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getOntologies <em>Ontologies</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getFacts <em>Facts</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getPlans <em>Plans</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getServices <em>Services</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getAgentproperties <em>Agentproperties</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getAgentRole <em>Agent Role</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getAgentRoleRef <em>Agent Role Ref</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getDepends <em>Depends</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentRoleTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AgentRoleTypeImpl extends EObjectImpl implements AgentRoleType {
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected EList<DescriptionType> description;

	/**
	 * The cached value of the '{@link #getBeans() <em>Beans</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeans()
	 * @generated
	 * @ordered
	 */
	protected Beans beans;

	/**
	 * The cached value of the '{@link #getOntologies() <em>Ontologies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOntologies()
	 * @generated
	 * @ordered
	 */
	protected Ontologies ontologies;

	/**
	 * The cached value of the '{@link #getFacts() <em>Facts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFacts()
	 * @generated
	 * @ordered
	 */
	protected Facts facts;

	/**
	 * The cached value of the '{@link #getPlans() <em>Plans</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlans()
	 * @generated
	 * @ordered
	 */
	protected Plans plans;

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected Services services;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected Rules rules;

	/**
	 * The cached value of the '{@link #getAgentproperties() <em>Agentproperties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentproperties()
	 * @generated
	 * @ordered
	 */
	protected AgentProperties agentproperties;

	/**
	 * The cached value of the '{@link #getAgentRole() <em>Agent Role</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentRole()
	 * @generated
	 * @ordered
	 */
	protected EList<AgentRoleType> agentRole;

	/**
	 * The cached value of the '{@link #getAgentRoleRef() <em>Agent Role Ref</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentRoleRef()
	 * @generated
	 * @ordered
	 */
	protected EList<AgentRoleRefType> agentRoleRef;

	/**
	 * The cached value of the '{@link #getKeywords() <em>Keywords</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeywords()
	 * @generated
	 * @ordered
	 */
	protected EList<String> keywords;

	/**
	 * The cached value of the '{@link #getDepends() <em>Depends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected EList<AgentRoleRefType> depends;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AgentRoleTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AgentRolePackage.Literals.AGENT_ROLE_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DescriptionType> getDescription() {
		if (description == null) {
			description = new EObjectContainmentEList<DescriptionType>(DescriptionType.class, this, AgentRolePackage.AGENT_ROLE_TYPE__DESCRIPTION);
		}
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Beans getBeans() {
		return beans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBeans(Beans newBeans, NotificationChain msgs) {
		Beans oldBeans = beans;
		beans = newBeans;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__BEANS, oldBeans, newBeans);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeans(Beans newBeans) {
		if (newBeans != beans) {
			NotificationChain msgs = null;
			if (beans != null)
				msgs = ((InternalEObject)beans).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__BEANS, null, msgs);
			if (newBeans != null)
				msgs = ((InternalEObject)newBeans).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__BEANS, null, msgs);
			msgs = basicSetBeans(newBeans, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__BEANS, newBeans, newBeans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ontologies getOntologies() {
		return ontologies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOntologies(Ontologies newOntologies, NotificationChain msgs) {
		Ontologies oldOntologies = ontologies;
		ontologies = newOntologies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__ONTOLOGIES, oldOntologies, newOntologies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOntologies(Ontologies newOntologies) {
		if (newOntologies != ontologies) {
			NotificationChain msgs = null;
			if (ontologies != null)
				msgs = ((InternalEObject)ontologies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__ONTOLOGIES, null, msgs);
			if (newOntologies != null)
				msgs = ((InternalEObject)newOntologies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__ONTOLOGIES, null, msgs);
			msgs = basicSetOntologies(newOntologies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__ONTOLOGIES, newOntologies, newOntologies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Facts getFacts() {
		return facts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFacts(Facts newFacts, NotificationChain msgs) {
		Facts oldFacts = facts;
		facts = newFacts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__FACTS, oldFacts, newFacts);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFacts(Facts newFacts) {
		if (newFacts != facts) {
			NotificationChain msgs = null;
			if (facts != null)
				msgs = ((InternalEObject)facts).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__FACTS, null, msgs);
			if (newFacts != null)
				msgs = ((InternalEObject)newFacts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__FACTS, null, msgs);
			msgs = basicSetFacts(newFacts, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__FACTS, newFacts, newFacts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Plans getPlans() {
		return plans;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlans(Plans newPlans, NotificationChain msgs) {
		Plans oldPlans = plans;
		plans = newPlans;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__PLANS, oldPlans, newPlans);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlans(Plans newPlans) {
		if (newPlans != plans) {
			NotificationChain msgs = null;
			if (plans != null)
				msgs = ((InternalEObject)plans).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__PLANS, null, msgs);
			if (newPlans != null)
				msgs = ((InternalEObject)newPlans).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__PLANS, null, msgs);
			msgs = basicSetPlans(newPlans, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__PLANS, newPlans, newPlans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Services getServices() {
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServices(Services newServices, NotificationChain msgs) {
		Services oldServices = services;
		services = newServices;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__SERVICES, oldServices, newServices);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServices(Services newServices) {
		if (newServices != services) {
			NotificationChain msgs = null;
			if (services != null)
				msgs = ((InternalEObject)services).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__SERVICES, null, msgs);
			if (newServices != null)
				msgs = ((InternalEObject)newServices).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__SERVICES, null, msgs);
			msgs = basicSetServices(newServices, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__SERVICES, newServices, newServices));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rules getRules() {
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRules(Rules newRules, NotificationChain msgs) {
		Rules oldRules = rules;
		rules = newRules;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__RULES, oldRules, newRules);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRules(Rules newRules) {
		if (newRules != rules) {
			NotificationChain msgs = null;
			if (rules != null)
				msgs = ((InternalEObject)rules).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__RULES, null, msgs);
			if (newRules != null)
				msgs = ((InternalEObject)newRules).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__RULES, null, msgs);
			msgs = basicSetRules(newRules, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__RULES, newRules, newRules));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AgentProperties getAgentproperties() {
		return agentproperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAgentproperties(AgentProperties newAgentproperties, NotificationChain msgs) {
		AgentProperties oldAgentproperties = agentproperties;
		agentproperties = newAgentproperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__AGENTPROPERTIES, oldAgentproperties, newAgentproperties);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAgentproperties(AgentProperties newAgentproperties) {
		if (newAgentproperties != agentproperties) {
			NotificationChain msgs = null;
			if (agentproperties != null)
				msgs = ((InternalEObject)agentproperties).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__AGENTPROPERTIES, null, msgs);
			if (newAgentproperties != null)
				msgs = ((InternalEObject)newAgentproperties).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AgentRolePackage.AGENT_ROLE_TYPE__AGENTPROPERTIES, null, msgs);
			msgs = basicSetAgentproperties(newAgentproperties, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__AGENTPROPERTIES, newAgentproperties, newAgentproperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AgentRoleType> getAgentRole() {
		if (agentRole == null) {
			agentRole = new EObjectContainmentEList<AgentRoleType>(AgentRoleType.class, this, AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE);
		}
		return agentRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AgentRoleRefType> getAgentRoleRef() {
		if (agentRoleRef == null) {
			agentRoleRef = new EObjectContainmentEList<AgentRoleRefType>(AgentRoleRefType.class, this, AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE_REF);
		}
		return agentRoleRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getKeywords() {
		if (keywords == null) {
			keywords = new EDataTypeEList<String>(String.class, this, AgentRolePackage.AGENT_ROLE_TYPE__KEYWORDS);
		}
		return keywords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AgentRoleRefType> getDepends() {
		if (depends == null) {
			depends = new EObjectContainmentEList<AgentRoleRefType>(AgentRoleRefType.class, this, AgentRolePackage.AGENT_ROLE_TYPE__DEPENDS);
		}
		return depends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__PACKAGE, oldPackage, package_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.AGENT_ROLE_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AgentRolePackage.AGENT_ROLE_TYPE__DESCRIPTION:
				return ((InternalEList<?>)getDescription()).basicRemove(otherEnd, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__BEANS:
				return basicSetBeans(null, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__ONTOLOGIES:
				return basicSetOntologies(null, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__FACTS:
				return basicSetFacts(null, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__PLANS:
				return basicSetPlans(null, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__SERVICES:
				return basicSetServices(null, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__RULES:
				return basicSetRules(null, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENTPROPERTIES:
				return basicSetAgentproperties(null, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE:
				return ((InternalEList<?>)getAgentRole()).basicRemove(otherEnd, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE_REF:
				return ((InternalEList<?>)getAgentRoleRef()).basicRemove(otherEnd, msgs);
			case AgentRolePackage.AGENT_ROLE_TYPE__DEPENDS:
				return ((InternalEList<?>)getDepends()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AgentRolePackage.AGENT_ROLE_TYPE__DESCRIPTION:
				return getDescription();
			case AgentRolePackage.AGENT_ROLE_TYPE__BEANS:
				return getBeans();
			case AgentRolePackage.AGENT_ROLE_TYPE__ONTOLOGIES:
				return getOntologies();
			case AgentRolePackage.AGENT_ROLE_TYPE__FACTS:
				return getFacts();
			case AgentRolePackage.AGENT_ROLE_TYPE__PLANS:
				return getPlans();
			case AgentRolePackage.AGENT_ROLE_TYPE__SERVICES:
				return getServices();
			case AgentRolePackage.AGENT_ROLE_TYPE__RULES:
				return getRules();
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENTPROPERTIES:
				return getAgentproperties();
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE:
				return getAgentRole();
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE_REF:
				return getAgentRoleRef();
			case AgentRolePackage.AGENT_ROLE_TYPE__KEYWORDS:
				return getKeywords();
			case AgentRolePackage.AGENT_ROLE_TYPE__DEPENDS:
				return getDepends();
			case AgentRolePackage.AGENT_ROLE_TYPE__NAME:
				return getName();
			case AgentRolePackage.AGENT_ROLE_TYPE__PACKAGE:
				return getPackage();
			case AgentRolePackage.AGENT_ROLE_TYPE__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AgentRolePackage.AGENT_ROLE_TYPE__DESCRIPTION:
				getDescription().clear();
				getDescription().addAll((Collection<? extends DescriptionType>)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__BEANS:
				setBeans((Beans)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__ONTOLOGIES:
				setOntologies((Ontologies)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__FACTS:
				setFacts((Facts)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__PLANS:
				setPlans((Plans)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__SERVICES:
				setServices((Services)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__RULES:
				setRules((Rules)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENTPROPERTIES:
				setAgentproperties((AgentProperties)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE:
				getAgentRole().clear();
				getAgentRole().addAll((Collection<? extends AgentRoleType>)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE_REF:
				getAgentRoleRef().clear();
				getAgentRoleRef().addAll((Collection<? extends AgentRoleRefType>)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__KEYWORDS:
				getKeywords().clear();
				getKeywords().addAll((Collection<? extends String>)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__DEPENDS:
				getDepends().clear();
				getDepends().addAll((Collection<? extends AgentRoleRefType>)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__NAME:
				setName((String)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__PACKAGE:
				setPackage((String)newValue);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__TYPE:
				setType((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AgentRolePackage.AGENT_ROLE_TYPE__DESCRIPTION:
				getDescription().clear();
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__BEANS:
				setBeans((Beans)null);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__ONTOLOGIES:
				setOntologies((Ontologies)null);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__FACTS:
				setFacts((Facts)null);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__PLANS:
				setPlans((Plans)null);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__SERVICES:
				setServices((Services)null);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__RULES:
				setRules((Rules)null);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENTPROPERTIES:
				setAgentproperties((AgentProperties)null);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE:
				getAgentRole().clear();
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE_REF:
				getAgentRoleRef().clear();
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__KEYWORDS:
				getKeywords().clear();
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__DEPENDS:
				getDepends().clear();
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case AgentRolePackage.AGENT_ROLE_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AgentRolePackage.AGENT_ROLE_TYPE__DESCRIPTION:
				return description != null && !description.isEmpty();
			case AgentRolePackage.AGENT_ROLE_TYPE__BEANS:
				return beans != null;
			case AgentRolePackage.AGENT_ROLE_TYPE__ONTOLOGIES:
				return ontologies != null;
			case AgentRolePackage.AGENT_ROLE_TYPE__FACTS:
				return facts != null;
			case AgentRolePackage.AGENT_ROLE_TYPE__PLANS:
				return plans != null;
			case AgentRolePackage.AGENT_ROLE_TYPE__SERVICES:
				return services != null;
			case AgentRolePackage.AGENT_ROLE_TYPE__RULES:
				return rules != null;
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENTPROPERTIES:
				return agentproperties != null;
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE:
				return agentRole != null && !agentRole.isEmpty();
			case AgentRolePackage.AGENT_ROLE_TYPE__AGENT_ROLE_REF:
				return agentRoleRef != null && !agentRoleRef.isEmpty();
			case AgentRolePackage.AGENT_ROLE_TYPE__KEYWORDS:
				return keywords != null && !keywords.isEmpty();
			case AgentRolePackage.AGENT_ROLE_TYPE__DEPENDS:
				return depends != null && !depends.isEmpty();
			case AgentRolePackage.AGENT_ROLE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AgentRolePackage.AGENT_ROLE_TYPE__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case AgentRolePackage.AGENT_ROLE_TYPE__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (keywords: ");
		result.append(keywords);
		result.append(", name: ");
		result.append(name);
		result.append(", package: ");
		result.append(package_);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //AgentRoleTypeImpl
