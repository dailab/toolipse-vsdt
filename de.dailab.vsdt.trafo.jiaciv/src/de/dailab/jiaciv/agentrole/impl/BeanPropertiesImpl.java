/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.jiaciv.agentrole.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.jiaciv.agentrole.AgentRolePackage;
import de.dailab.jiaciv.agentrole.BeanProperties;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bean Properties</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl#getDependentproperty <em>Dependentproperty</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl#getDepends <em>Depends</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl#getKey <em>Key</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.dailab.jiaciv.agentrole.impl.BeanPropertiesImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BeanPropertiesImpl extends EObjectImpl implements BeanProperties {
	/**
	 * The cached value of the '{@link #getDependentproperty() <em>Dependentproperty</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependentproperty()
	 * @generated
	 * @ordered
	 */
	protected EList<BeanProperties> dependentproperty;

	/**
	 * The default value of the '{@link #getDepends() <em>Depends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected static final String DEPENDS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDepends() <em>Depends</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepends()
	 * @generated
	 * @ordered
	 */
	protected String depends = DEPENDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

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
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BeanPropertiesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AgentRolePackage.Literals.BEAN_PROPERTIES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BeanProperties> getDependentproperty() {
		if (dependentproperty == null) {
			dependentproperty = new EObjectContainmentEList<BeanProperties>(BeanProperties.class, this, AgentRolePackage.BEAN_PROPERTIES__DEPENDENTPROPERTY);
		}
		return dependentproperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDepends() {
		return depends;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDepends(String newDepends) {
		String oldDepends = depends;
		depends = newDepends;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.BEAN_PROPERTIES__DEPENDS, oldDepends, depends));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.BEAN_PROPERTIES__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.BEAN_PROPERTIES__KEY, oldKey, key));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.BEAN_PROPERTIES__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AgentRolePackage.BEAN_PROPERTIES__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AgentRolePackage.BEAN_PROPERTIES__DEPENDENTPROPERTY:
				return ((InternalEList<?>)getDependentproperty()).basicRemove(otherEnd, msgs);
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
			case AgentRolePackage.BEAN_PROPERTIES__DEPENDENTPROPERTY:
				return getDependentproperty();
			case AgentRolePackage.BEAN_PROPERTIES__DEPENDS:
				return getDepends();
			case AgentRolePackage.BEAN_PROPERTIES__DESCRIPTION:
				return getDescription();
			case AgentRolePackage.BEAN_PROPERTIES__KEY:
				return getKey();
			case AgentRolePackage.BEAN_PROPERTIES__TYPE:
				return getType();
			case AgentRolePackage.BEAN_PROPERTIES__VALUE:
				return getValue();
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
			case AgentRolePackage.BEAN_PROPERTIES__DEPENDENTPROPERTY:
				getDependentproperty().clear();
				getDependentproperty().addAll((Collection<? extends BeanProperties>)newValue);
				return;
			case AgentRolePackage.BEAN_PROPERTIES__DEPENDS:
				setDepends((String)newValue);
				return;
			case AgentRolePackage.BEAN_PROPERTIES__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case AgentRolePackage.BEAN_PROPERTIES__KEY:
				setKey((String)newValue);
				return;
			case AgentRolePackage.BEAN_PROPERTIES__TYPE:
				setType((String)newValue);
				return;
			case AgentRolePackage.BEAN_PROPERTIES__VALUE:
				setValue((String)newValue);
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
			case AgentRolePackage.BEAN_PROPERTIES__DEPENDENTPROPERTY:
				getDependentproperty().clear();
				return;
			case AgentRolePackage.BEAN_PROPERTIES__DEPENDS:
				setDepends(DEPENDS_EDEFAULT);
				return;
			case AgentRolePackage.BEAN_PROPERTIES__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case AgentRolePackage.BEAN_PROPERTIES__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case AgentRolePackage.BEAN_PROPERTIES__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case AgentRolePackage.BEAN_PROPERTIES__VALUE:
				setValue(VALUE_EDEFAULT);
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
			case AgentRolePackage.BEAN_PROPERTIES__DEPENDENTPROPERTY:
				return dependentproperty != null && !dependentproperty.isEmpty();
			case AgentRolePackage.BEAN_PROPERTIES__DEPENDS:
				return DEPENDS_EDEFAULT == null ? depends != null : !DEPENDS_EDEFAULT.equals(depends);
			case AgentRolePackage.BEAN_PROPERTIES__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case AgentRolePackage.BEAN_PROPERTIES__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case AgentRolePackage.BEAN_PROPERTIES__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case AgentRolePackage.BEAN_PROPERTIES__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
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
		result.append(" (depends: ");
		result.append(depends);
		result.append(", description: ");
		result.append(description);
		result.append(", key: ");
		result.append(key);
		result.append(", type: ");
		result.append(type);
		result.append(", value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //BeanPropertiesImpl
