/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.jiaciv.agentrole.AgentProperties;
import de.dailab.jiaciv.agentrole.AgentPropertyType;
import de.dailab.jiaciv.agentrole.AgentRolePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Agent Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.AgentPropertiesImpl#getAgentProperty <em>Agent Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AgentPropertiesImpl extends EObjectImpl implements AgentProperties {
	/**
	 * The cached value of the '{@link #getAgentProperty() <em>Agent Property</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAgentProperty()
	 * @generated
	 * @ordered
	 */
	protected EList<AgentPropertyType> agentProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AgentPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AgentRolePackage.Literals.AGENT_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AgentPropertyType> getAgentProperty() {
		if (agentProperty == null) {
			agentProperty = new EObjectContainmentEList<AgentPropertyType>(AgentPropertyType.class, this, AgentRolePackage.AGENT_PROPERTIES__AGENT_PROPERTY);
		}
		return agentProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AgentRolePackage.AGENT_PROPERTIES__AGENT_PROPERTY:
				return ((InternalEList<?>)getAgentProperty()).basicRemove(otherEnd, msgs);
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
			case AgentRolePackage.AGENT_PROPERTIES__AGENT_PROPERTY:
				return getAgentProperty();
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
			case AgentRolePackage.AGENT_PROPERTIES__AGENT_PROPERTY:
				getAgentProperty().clear();
				getAgentProperty().addAll((Collection<? extends AgentPropertyType>)newValue);
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
			case AgentRolePackage.AGENT_PROPERTIES__AGENT_PROPERTY:
				getAgentProperty().clear();
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
			case AgentRolePackage.AGENT_PROPERTIES__AGENT_PROPERTY:
				return agentProperty != null && !agentProperty.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AgentPropertiesImpl
