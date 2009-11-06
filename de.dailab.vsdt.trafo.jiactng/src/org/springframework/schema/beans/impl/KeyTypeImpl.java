/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.springframework.schema.beans.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.springframework.schema.beans.BeanType;
import org.springframework.schema.beans.BeansPackage;
import org.springframework.schema.beans.IdrefType;
import org.springframework.schema.beans.KeyType;
import org.springframework.schema.beans.ListOrSetType;
import org.springframework.schema.beans.MapType;
import org.springframework.schema.beans.NullType;
import org.springframework.schema.beans.PropsType;
import org.springframework.schema.beans.RefType;
import org.springframework.schema.beans.ValueType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getGroup <em>Group</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getBean <em>Bean</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getIdref <em>Idref</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getNull <em>Null</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getList <em>List</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getSet <em>Set</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getMap <em>Map</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getProps <em>Props</em>}</li>
 *   <li>{@link org.springframework.schema.beans.impl.KeyTypeImpl#getAny <em>Any</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class KeyTypeImpl extends EObjectImpl implements KeyType {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BeansPackage.Literals.KEY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup() {
		if (group == null) {
			group = new BasicFeatureMap(this, BeansPackage.KEY_TYPE__GROUP);
		}
		return group;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BeanType> getBean() {
		return getGroup().list(BeansPackage.Literals.KEY_TYPE__BEAN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RefType> getRef() {
		return getGroup().list(BeansPackage.Literals.KEY_TYPE__REF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdrefType> getIdref() {
		return getGroup().list(BeansPackage.Literals.KEY_TYPE__IDREF);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ValueType> getValue() {
		return getGroup().list(BeansPackage.Literals.KEY_TYPE__VALUE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NullType> getNull() {
		return getGroup().list(BeansPackage.Literals.KEY_TYPE__NULL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ListOrSetType> getList() {
		return getGroup().list(BeansPackage.Literals.KEY_TYPE__LIST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ListOrSetType> getSet() {
		return getGroup().list(BeansPackage.Literals.KEY_TYPE__SET);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MapType> getMap() {
		return getGroup().list(BeansPackage.Literals.KEY_TYPE__MAP);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropsType> getProps() {
		return getGroup().list(BeansPackage.Literals.KEY_TYPE__PROPS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getAny() {
		return (FeatureMap)getGroup().<FeatureMap.Entry>list(BeansPackage.Literals.KEY_TYPE__ANY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BeansPackage.KEY_TYPE__GROUP:
				return ((InternalEList<?>)getGroup()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__BEAN:
				return ((InternalEList<?>)getBean()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__REF:
				return ((InternalEList<?>)getRef()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__IDREF:
				return ((InternalEList<?>)getIdref()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__VALUE:
				return ((InternalEList<?>)getValue()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__NULL:
				return ((InternalEList<?>)getNull()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__LIST:
				return ((InternalEList<?>)getList()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__SET:
				return ((InternalEList<?>)getSet()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__MAP:
				return ((InternalEList<?>)getMap()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__PROPS:
				return ((InternalEList<?>)getProps()).basicRemove(otherEnd, msgs);
			case BeansPackage.KEY_TYPE__ANY:
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
			case BeansPackage.KEY_TYPE__GROUP:
				if (coreType) return getGroup();
				return ((FeatureMap.Internal)getGroup()).getWrapper();
			case BeansPackage.KEY_TYPE__BEAN:
				return getBean();
			case BeansPackage.KEY_TYPE__REF:
				return getRef();
			case BeansPackage.KEY_TYPE__IDREF:
				return getIdref();
			case BeansPackage.KEY_TYPE__VALUE:
				return getValue();
			case BeansPackage.KEY_TYPE__NULL:
				return getNull();
			case BeansPackage.KEY_TYPE__LIST:
				return getList();
			case BeansPackage.KEY_TYPE__SET:
				return getSet();
			case BeansPackage.KEY_TYPE__MAP:
				return getMap();
			case BeansPackage.KEY_TYPE__PROPS:
				return getProps();
			case BeansPackage.KEY_TYPE__ANY:
				if (coreType) return getAny();
				return ((FeatureMap.Internal)getAny()).getWrapper();
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
			case BeansPackage.KEY_TYPE__GROUP:
				((FeatureMap.Internal)getGroup()).set(newValue);
				return;
			case BeansPackage.KEY_TYPE__BEAN:
				getBean().clear();
				getBean().addAll((Collection<? extends BeanType>)newValue);
				return;
			case BeansPackage.KEY_TYPE__REF:
				getRef().clear();
				getRef().addAll((Collection<? extends RefType>)newValue);
				return;
			case BeansPackage.KEY_TYPE__IDREF:
				getIdref().clear();
				getIdref().addAll((Collection<? extends IdrefType>)newValue);
				return;
			case BeansPackage.KEY_TYPE__VALUE:
				getValue().clear();
				getValue().addAll((Collection<? extends ValueType>)newValue);
				return;
			case BeansPackage.KEY_TYPE__NULL:
				getNull().clear();
				getNull().addAll((Collection<? extends NullType>)newValue);
				return;
			case BeansPackage.KEY_TYPE__LIST:
				getList().clear();
				getList().addAll((Collection<? extends ListOrSetType>)newValue);
				return;
			case BeansPackage.KEY_TYPE__SET:
				getSet().clear();
				getSet().addAll((Collection<? extends ListOrSetType>)newValue);
				return;
			case BeansPackage.KEY_TYPE__MAP:
				getMap().clear();
				getMap().addAll((Collection<? extends MapType>)newValue);
				return;
			case BeansPackage.KEY_TYPE__PROPS:
				getProps().clear();
				getProps().addAll((Collection<? extends PropsType>)newValue);
				return;
			case BeansPackage.KEY_TYPE__ANY:
				((FeatureMap.Internal)getAny()).set(newValue);
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
			case BeansPackage.KEY_TYPE__GROUP:
				getGroup().clear();
				return;
			case BeansPackage.KEY_TYPE__BEAN:
				getBean().clear();
				return;
			case BeansPackage.KEY_TYPE__REF:
				getRef().clear();
				return;
			case BeansPackage.KEY_TYPE__IDREF:
				getIdref().clear();
				return;
			case BeansPackage.KEY_TYPE__VALUE:
				getValue().clear();
				return;
			case BeansPackage.KEY_TYPE__NULL:
				getNull().clear();
				return;
			case BeansPackage.KEY_TYPE__LIST:
				getList().clear();
				return;
			case BeansPackage.KEY_TYPE__SET:
				getSet().clear();
				return;
			case BeansPackage.KEY_TYPE__MAP:
				getMap().clear();
				return;
			case BeansPackage.KEY_TYPE__PROPS:
				getProps().clear();
				return;
			case BeansPackage.KEY_TYPE__ANY:
				getAny().clear();
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
			case BeansPackage.KEY_TYPE__GROUP:
				return group != null && !group.isEmpty();
			case BeansPackage.KEY_TYPE__BEAN:
				return !getBean().isEmpty();
			case BeansPackage.KEY_TYPE__REF:
				return !getRef().isEmpty();
			case BeansPackage.KEY_TYPE__IDREF:
				return !getIdref().isEmpty();
			case BeansPackage.KEY_TYPE__VALUE:
				return !getValue().isEmpty();
			case BeansPackage.KEY_TYPE__NULL:
				return !getNull().isEmpty();
			case BeansPackage.KEY_TYPE__LIST:
				return !getList().isEmpty();
			case BeansPackage.KEY_TYPE__SET:
				return !getSet().isEmpty();
			case BeansPackage.KEY_TYPE__MAP:
				return !getMap().isEmpty();
			case BeansPackage.KEY_TYPE__PROPS:
				return !getProps().isEmpty();
			case BeansPackage.KEY_TYPE__ANY:
				return !getAny().isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //KeyTypeImpl
