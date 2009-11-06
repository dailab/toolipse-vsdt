/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.springframework.schema.beans.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.springframework.schema.beans.AliasType;
import org.springframework.schema.beans.BeanType;
import org.springframework.schema.beans.BeansPackage;
import org.springframework.schema.beans.BeansType;
import org.springframework.schema.beans.DefaultAutowireType;
import org.springframework.schema.beans.DefaultDependencyCheckType;
import org.springframework.schema.beans.DescriptionType;
import org.springframework.schema.beans.ImportType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getImport <em>Import</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getAlias <em>Alias</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getBean <em>Bean</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getAny <em>Any</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getDefaultAutowire <em>Default Autowire</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getDefaultDependencyCheck <em>Default Dependency Check</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getDefaultDestroyMethod <em>Default Destroy Method</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#getDefaultInitMethod <em>Default Init Method</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#isDefaultLazyInit <em>Default Lazy Init</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.BeansTypeImpl#isDefaultMerge <em>Default Merge</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BeansTypeImpl extends EObjectImpl implements BeansType {
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected DescriptionType description;

	/**
	 * The cached value of the '{@link #getGroup() <em>Group</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group;

	/**
	 * The default value of the '{@link #getDefaultAutowire() <em>Default Autowire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultAutowire()
	 * @generated
	 * @ordered
	 */
	protected static final DefaultAutowireType DEFAULT_AUTOWIRE_EDEFAULT = DefaultAutowireType.NO;

	/**
	 * The cached value of the '{@link #getDefaultAutowire() <em>Default Autowire</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultAutowire()
	 * @generated
	 * @ordered
	 */
	protected DefaultAutowireType defaultAutowire = DEFAULT_AUTOWIRE_EDEFAULT;

	/**
	 * This is true if the Default Autowire attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean defaultAutowireESet;

	/**
	 * The default value of the '{@link #getDefaultDependencyCheck() <em>Default Dependency Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDependencyCheck()
	 * @generated
	 * @ordered
	 */
	protected static final DefaultDependencyCheckType DEFAULT_DEPENDENCY_CHECK_EDEFAULT = DefaultDependencyCheckType.NONE;

	/**
	 * The cached value of the '{@link #getDefaultDependencyCheck() <em>Default Dependency Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDependencyCheck()
	 * @generated
	 * @ordered
	 */
	protected DefaultDependencyCheckType defaultDependencyCheck = DEFAULT_DEPENDENCY_CHECK_EDEFAULT;

	/**
	 * This is true if the Default Dependency Check attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean defaultDependencyCheckESet;

	/**
	 * The default value of the '{@link #getDefaultDestroyMethod() <em>Default Destroy Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDestroyMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_DESTROY_METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultDestroyMethod() <em>Default Destroy Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultDestroyMethod()
	 * @generated
	 * @ordered
	 */
	protected String defaultDestroyMethod = DEFAULT_DESTROY_METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getDefaultInitMethod() <em>Default Init Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultInitMethod()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_INIT_METHOD_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultInitMethod() <em>Default Init Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultInitMethod()
	 * @generated
	 * @ordered
	 */
	protected String defaultInitMethod = DEFAULT_INIT_METHOD_EDEFAULT;

	/**
	 * The default value of the '{@link #isDefaultLazyInit() <em>Default Lazy Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultLazyInit()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_LAZY_INIT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefaultLazyInit() <em>Default Lazy Init</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultLazyInit()
	 * @generated
	 * @ordered
	 */
	protected boolean defaultLazyInit = DEFAULT_LAZY_INIT_EDEFAULT;

	/**
	 * This is true if the Default Lazy Init attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean defaultLazyInitESet;

	/**
	 * The default value of the '{@link #isDefaultMerge() <em>Default Merge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultMerge()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_MERGE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefaultMerge() <em>Default Merge</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultMerge()
	 * @generated
	 * @ordered
	 */
	protected boolean defaultMerge = DEFAULT_MERGE_EDEFAULT;

	/**
	 * This is true if the Default Merge attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean defaultMergeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BeansTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BeansPackage.Literals.BEANS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DescriptionType getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDescription(DescriptionType newDescription, NotificationChain msgs) {
		DescriptionType oldDescription = description;
		description = newDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, BeansPackage.BEANS_TYPE__DESCRIPTION, oldDescription, newDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(DescriptionType newDescription) {
		if (newDescription != description) {
			NotificationChain msgs = null;
			if (description != null)
				msgs = ((InternalEObject)description).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - BeansPackage.BEANS_TYPE__DESCRIPTION, null, msgs);
			if (newDescription != null)
				msgs = ((InternalEObject)newDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - BeansPackage.BEANS_TYPE__DESCRIPTION, null, msgs);
			msgs = basicSetDescription(newDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BeansPackage.BEANS_TYPE__DESCRIPTION, newDescription, newDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, BeansPackage.BEANS_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportType> getImport() {
		return getGroup().list(BeansPackage.Literals.BEANS_TYPE__IMPORT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AliasType> getAlias() {
		return getGroup().list(BeansPackage.Literals.BEANS_TYPE__ALIAS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BeanType> getBean() {
		return getGroup().list(BeansPackage.Literals.BEANS_TYPE__BEAN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		return (FeatureMap)getGroup().<FeatureMap.Entry>list(BeansPackage.Literals.BEANS_TYPE__ANY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAutowireType getDefaultAutowire() {
		return defaultAutowire;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultAutowire(DefaultAutowireType newDefaultAutowire) {
		DefaultAutowireType oldDefaultAutowire = defaultAutowire;
		defaultAutowire = newDefaultAutowire == null ? DEFAULT_AUTOWIRE_EDEFAULT : newDefaultAutowire;
		boolean oldDefaultAutowireESet = defaultAutowireESet;
		defaultAutowireESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BeansPackage.BEANS_TYPE__DEFAULT_AUTOWIRE, oldDefaultAutowire, defaultAutowire, !oldDefaultAutowireESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefaultAutowire() {
		DefaultAutowireType oldDefaultAutowire = defaultAutowire;
		boolean oldDefaultAutowireESet = defaultAutowireESet;
		defaultAutowire = DEFAULT_AUTOWIRE_EDEFAULT;
		defaultAutowireESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, BeansPackage.BEANS_TYPE__DEFAULT_AUTOWIRE, oldDefaultAutowire, DEFAULT_AUTOWIRE_EDEFAULT, oldDefaultAutowireESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefaultAutowire() {
		return defaultAutowireESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultDependencyCheckType getDefaultDependencyCheck() {
		return defaultDependencyCheck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultDependencyCheck(DefaultDependencyCheckType newDefaultDependencyCheck) {
		DefaultDependencyCheckType oldDefaultDependencyCheck = defaultDependencyCheck;
		defaultDependencyCheck = newDefaultDependencyCheck == null ? DEFAULT_DEPENDENCY_CHECK_EDEFAULT : newDefaultDependencyCheck;
		boolean oldDefaultDependencyCheckESet = defaultDependencyCheckESet;
		defaultDependencyCheckESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BeansPackage.BEANS_TYPE__DEFAULT_DEPENDENCY_CHECK, oldDefaultDependencyCheck, defaultDependencyCheck, !oldDefaultDependencyCheckESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefaultDependencyCheck() {
		DefaultDependencyCheckType oldDefaultDependencyCheck = defaultDependencyCheck;
		boolean oldDefaultDependencyCheckESet = defaultDependencyCheckESet;
		defaultDependencyCheck = DEFAULT_DEPENDENCY_CHECK_EDEFAULT;
		defaultDependencyCheckESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, BeansPackage.BEANS_TYPE__DEFAULT_DEPENDENCY_CHECK, oldDefaultDependencyCheck, DEFAULT_DEPENDENCY_CHECK_EDEFAULT, oldDefaultDependencyCheckESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefaultDependencyCheck() {
		return defaultDependencyCheckESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultDestroyMethod() {
		return defaultDestroyMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultDestroyMethod(String newDefaultDestroyMethod) {
		String oldDefaultDestroyMethod = defaultDestroyMethod;
		defaultDestroyMethod = newDefaultDestroyMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BeansPackage.BEANS_TYPE__DEFAULT_DESTROY_METHOD, oldDefaultDestroyMethod, defaultDestroyMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultInitMethod() {
		return defaultInitMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultInitMethod(String newDefaultInitMethod) {
		String oldDefaultInitMethod = defaultInitMethod;
		defaultInitMethod = newDefaultInitMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BeansPackage.BEANS_TYPE__DEFAULT_INIT_METHOD, oldDefaultInitMethod, defaultInitMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefaultLazyInit() {
		return defaultLazyInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultLazyInit(boolean newDefaultLazyInit) {
		boolean oldDefaultLazyInit = defaultLazyInit;
		defaultLazyInit = newDefaultLazyInit;
		boolean oldDefaultLazyInitESet = defaultLazyInitESet;
		defaultLazyInitESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BeansPackage.BEANS_TYPE__DEFAULT_LAZY_INIT, oldDefaultLazyInit, defaultLazyInit, !oldDefaultLazyInitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefaultLazyInit() {
		boolean oldDefaultLazyInit = defaultLazyInit;
		boolean oldDefaultLazyInitESet = defaultLazyInitESet;
		defaultLazyInit = DEFAULT_LAZY_INIT_EDEFAULT;
		defaultLazyInitESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, BeansPackage.BEANS_TYPE__DEFAULT_LAZY_INIT, oldDefaultLazyInit, DEFAULT_LAZY_INIT_EDEFAULT, oldDefaultLazyInitESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefaultLazyInit() {
		return defaultLazyInitESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefaultMerge() {
		return defaultMerge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultMerge(boolean newDefaultMerge) {
		boolean oldDefaultMerge = defaultMerge;
		defaultMerge = newDefaultMerge;
		boolean oldDefaultMergeESet = defaultMergeESet;
		defaultMergeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BeansPackage.BEANS_TYPE__DEFAULT_MERGE, oldDefaultMerge, defaultMerge, !oldDefaultMergeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDefaultMerge() {
		boolean oldDefaultMerge = defaultMerge;
		boolean oldDefaultMergeESet = defaultMergeESet;
		defaultMerge = DEFAULT_MERGE_EDEFAULT;
		defaultMergeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, BeansPackage.BEANS_TYPE__DEFAULT_MERGE, oldDefaultMerge, DEFAULT_MERGE_EDEFAULT, oldDefaultMergeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDefaultMerge() {
		return defaultMergeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BeansPackage.BEANS_TYPE__DESCRIPTION:
				return basicSetDescription(null, msgs);
			case BeansPackage.BEANS_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case BeansPackage.BEANS_TYPE__IMPORT:
				return ((InternalEList<?>)getImport()).basicRemove(otherEnd, msgs);
			case BeansPackage.BEANS_TYPE__ALIAS:
				return ((InternalEList<?>)getAlias()).basicRemove(otherEnd, msgs);
			case BeansPackage.BEANS_TYPE__BEAN:
				return ((InternalEList<?>)getBean()).basicRemove(otherEnd, msgs);
			case BeansPackage.BEANS_TYPE__ANY:
				return ((InternalEList<?>)getAny()).basicRemove(otherEnd, msgs);
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
			case BeansPackage.BEANS_TYPE__DESCRIPTION:
				return getDescription();
			case BeansPackage.BEANS_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case BeansPackage.BEANS_TYPE__IMPORT:
				return getImport();
			case BeansPackage.BEANS_TYPE__ALIAS:
				return getAlias();
			case BeansPackage.BEANS_TYPE__BEAN:
				return getBean();
			case BeansPackage.BEANS_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
			case BeansPackage.BEANS_TYPE__DEFAULT_AUTOWIRE:
				return getDefaultAutowire();
			case BeansPackage.BEANS_TYPE__DEFAULT_DEPENDENCY_CHECK:
				return getDefaultDependencyCheck();
			case BeansPackage.BEANS_TYPE__DEFAULT_DESTROY_METHOD:
				return getDefaultDestroyMethod();
			case BeansPackage.BEANS_TYPE__DEFAULT_INIT_METHOD:
				return getDefaultInitMethod();
			case BeansPackage.BEANS_TYPE__DEFAULT_LAZY_INIT:
				return isDefaultLazyInit() ? Boolean.TRUE : Boolean.FALSE;
			case BeansPackage.BEANS_TYPE__DEFAULT_MERGE:
				return isDefaultMerge() ? Boolean.TRUE : Boolean.FALSE;
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
			case BeansPackage.BEANS_TYPE__DESCRIPTION:
				setDescription((DescriptionType)newValue);
				return;
			case BeansPackage.BEANS_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case BeansPackage.BEANS_TYPE__IMPORT:
				getImport().clear();
				getImport().addAll((Collection<? extends ImportType>)newValue);
				return;
			case BeansPackage.BEANS_TYPE__ALIAS:
				getAlias().clear();
				getAlias().addAll((Collection<? extends AliasType>)newValue);
				return;
			case BeansPackage.BEANS_TYPE__BEAN:
				getBean().clear();
				getBean().addAll((Collection<? extends BeanType>)newValue);
				return;
			case BeansPackage.BEANS_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_AUTOWIRE:
				setDefaultAutowire((DefaultAutowireType)newValue);
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_DEPENDENCY_CHECK:
				setDefaultDependencyCheck((DefaultDependencyCheckType)newValue);
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_DESTROY_METHOD:
				setDefaultDestroyMethod((String)newValue);
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_INIT_METHOD:
				setDefaultInitMethod((String)newValue);
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_LAZY_INIT:
				setDefaultLazyInit(((Boolean)newValue).booleanValue());
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_MERGE:
				setDefaultMerge(((Boolean)newValue).booleanValue());
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
			case BeansPackage.BEANS_TYPE__DESCRIPTION:
				setDescription((DescriptionType)null);
				return;
			case BeansPackage.BEANS_TYPE__GROUP:
				getGroup().clear();
				return;
			case BeansPackage.BEANS_TYPE__IMPORT:
				getImport().clear();
				return;
			case BeansPackage.BEANS_TYPE__ALIAS:
				getAlias().clear();
				return;
			case BeansPackage.BEANS_TYPE__BEAN:
				getBean().clear();
				return;
			case BeansPackage.BEANS_TYPE__ANY:
				getAny().clear();
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_AUTOWIRE:
				unsetDefaultAutowire();
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_DEPENDENCY_CHECK:
				unsetDefaultDependencyCheck();
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_DESTROY_METHOD:
				setDefaultDestroyMethod(DEFAULT_DESTROY_METHOD_EDEFAULT);
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_INIT_METHOD:
				setDefaultInitMethod(DEFAULT_INIT_METHOD_EDEFAULT);
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_LAZY_INIT:
				unsetDefaultLazyInit();
				return;
			case BeansPackage.BEANS_TYPE__DEFAULT_MERGE:
				unsetDefaultMerge();
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
			case BeansPackage.BEANS_TYPE__DESCRIPTION:
				return description != null;
			case BeansPackage.BEANS_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case BeansPackage.BEANS_TYPE__IMPORT:
				return !getImport().isEmpty();
			case BeansPackage.BEANS_TYPE__ALIAS:
				return !getAlias().isEmpty();
			case BeansPackage.BEANS_TYPE__BEAN:
				return !getBean().isEmpty();
			case BeansPackage.BEANS_TYPE__ANY:
				return !getAny().isEmpty();
			case BeansPackage.BEANS_TYPE__DEFAULT_AUTOWIRE:
				return isSetDefaultAutowire();
			case BeansPackage.BEANS_TYPE__DEFAULT_DEPENDENCY_CHECK:
				return isSetDefaultDependencyCheck();
			case BeansPackage.BEANS_TYPE__DEFAULT_DESTROY_METHOD:
				return DEFAULT_DESTROY_METHOD_EDEFAULT == null ? defaultDestroyMethod != null : !DEFAULT_DESTROY_METHOD_EDEFAULT.equals(defaultDestroyMethod);
			case BeansPackage.BEANS_TYPE__DEFAULT_INIT_METHOD:
				return DEFAULT_INIT_METHOD_EDEFAULT == null ? defaultInitMethod != null : !DEFAULT_INIT_METHOD_EDEFAULT.equals(defaultInitMethod);
			case BeansPackage.BEANS_TYPE__DEFAULT_LAZY_INIT:
				return isSetDefaultLazyInit();
			case BeansPackage.BEANS_TYPE__DEFAULT_MERGE:
				return isSetDefaultMerge();
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
		result.append(" (group: ");
		result.append(group);
		result.append(", defaultAutowire: ");
		if (defaultAutowireESet) result.append(defaultAutowire); else result.append("<unset>");
		result.append(", defaultDependencyCheck: ");
		if (defaultDependencyCheckESet) result.append(defaultDependencyCheck); else result.append("<unset>");
		result.append(", defaultDestroyMethod: ");
		result.append(defaultDestroyMethod);
		result.append(", defaultInitMethod: ");
		result.append(defaultInitMethod);
		result.append(", defaultLazyInit: ");
		if (defaultLazyInitESet) result.append(defaultLazyInit); else result.append("<unset>");
		result.append(", defaultMerge: ");
		if (defaultMergeESet) result.append(defaultMerge); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //BeansTypeImpl
