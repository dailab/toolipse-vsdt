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
 * A representation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getDescription <em>Description</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getBeans <em>Beans</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getOntologies <em>Ontologies</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getFacts <em>Facts</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getPlans <em>Plans</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getServices <em>Services</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getRules <em>Rules</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getAgentproperties <em>Agentproperties</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getAgentRole <em>Agent Role</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getAgentRoleRef <em>Agent Role Ref</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getKeywords <em>Keywords</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getDepends <em>Depends</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getName <em>Name</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getPackage <em>Package</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.AgentRoleType#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType()
 * @model extendedMetaData="name='AgentRoleType' kind='elementOnly'"
 * @generated
 */
public interface AgentRoleType extends EObject {
	/**
	 * Returns the value of the '<em><b>Description</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.DescriptionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Description()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='description' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<DescriptionType> getDescription();

	/**
	 * Returns the value of the '<em><b>Beans</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Beans</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Beans</em>' containment reference.
	 * @see #setBeans(Beans)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Beans()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='beans' namespace='##targetNamespace'"
	 * @generated
	 */
	Beans getBeans();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getBeans <em>Beans</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Beans</em>' containment reference.
	 * @see #getBeans()
	 * @generated
	 */
	void setBeans(Beans value);

	/**
	 * Returns the value of the '<em><b>Ontologies</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ontologies</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ontologies</em>' containment reference.
	 * @see #setOntologies(Ontologies)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Ontologies()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='ontologies' namespace='##targetNamespace'"
	 * @generated
	 */
	Ontologies getOntologies();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getOntologies <em>Ontologies</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ontologies</em>' containment reference.
	 * @see #getOntologies()
	 * @generated
	 */
	void setOntologies(Ontologies value);

	/**
	 * Returns the value of the '<em><b>Facts</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Facts</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Facts</em>' containment reference.
	 * @see #setFacts(Facts)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Facts()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='facts' namespace='##targetNamespace'"
	 * @generated
	 */
	Facts getFacts();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getFacts <em>Facts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Facts</em>' containment reference.
	 * @see #getFacts()
	 * @generated
	 */
	void setFacts(Facts value);

	/**
	 * Returns the value of the '<em><b>Plans</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plans</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plans</em>' containment reference.
	 * @see #setPlans(Plans)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Plans()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='plans' namespace='##targetNamespace'"
	 * @generated
	 */
	Plans getPlans();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getPlans <em>Plans</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plans</em>' containment reference.
	 * @see #getPlans()
	 * @generated
	 */
	void setPlans(Plans value);

	/**
	 * Returns the value of the '<em><b>Services</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' containment reference.
	 * @see #setServices(Services)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Services()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='services' namespace='##targetNamespace'"
	 * @generated
	 */
	Services getServices();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getServices <em>Services</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Services</em>' containment reference.
	 * @see #getServices()
	 * @generated
	 */
	void setServices(Services value);

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference.
	 * @see #setRules(Rules)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Rules()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='rules' namespace='##targetNamespace'"
	 * @generated
	 */
	Rules getRules();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getRules <em>Rules</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rules</em>' containment reference.
	 * @see #getRules()
	 * @generated
	 */
	void setRules(Rules value);

	/**
	 * Returns the value of the '<em><b>Agentproperties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agentproperties</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agentproperties</em>' containment reference.
	 * @see #setAgentproperties(AgentProperties)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Agentproperties()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='agentproperties' namespace='##targetNamespace'"
	 * @generated
	 */
	AgentProperties getAgentproperties();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getAgentproperties <em>Agentproperties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Agentproperties</em>' containment reference.
	 * @see #getAgentproperties()
	 * @generated
	 */
	void setAgentproperties(AgentProperties value);

	/**
	 * Returns the value of the '<em><b>Agent Role</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.AgentRoleType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Role</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Role</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_AgentRole()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AgentRole' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AgentRoleType> getAgentRole();

	/**
	 * Returns the value of the '<em><b>Agent Role Ref</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.AgentRoleRefType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Agent Role Ref</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Agent Role Ref</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_AgentRoleRef()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='AgentRoleRef' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AgentRoleRefType> getAgentRoleRef();

	/**
	 * Returns the value of the '<em><b>Keywords</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Keywords</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Keywords</em>' attribute list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Keywords()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='keywords' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getKeywords();

	/**
	 * Returns the value of the '<em><b>Depends</b></em>' containment reference list.
	 * The list contents are of type {@link de.dailab.jiaciv.agentrole.AgentRoleRefType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Depends</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depends</em>' containment reference list.
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Depends()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='depends' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<AgentRoleRefType> getDepends();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute.
	 * @see #setPackage(String)
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Package()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='package' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

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
	 * @see de.dailab.jiaciv.agentrole.AgentRolePackage#getAgentRoleType_Type()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='type' namespace='##targetNamespace'"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link de.dailab.jiaciv.agentrole.AgentRoleType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

} // AgentRoleType
