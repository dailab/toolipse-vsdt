/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#getContainedFlowObjects <em>Contained Flow Objects</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LaneImpl extends GraphicalObjectImpl implements Lane {
	/**
	 * The cached value of the '{@link #getContainedFlowObjects() <em>Contained Flow Objects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedFlowObjects()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowObject> containedFlowObjects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LaneImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.LANE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowObject> getContainedFlowObjects() {
		if (containedFlowObjects == null) {
			containedFlowObjects = new EObjectContainmentWithInverseEList<FlowObject>(FlowObject.class, this, VsdtPackage.LANE__CONTAINED_FLOW_OBJECTS, VsdtPackage.FLOW_OBJECT__PARENT);
		}
		return containedFlowObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pool getParent() {
		if (eContainerFeatureID() != VsdtPackage.LANE__PARENT) return null;
		return (Pool)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Pool newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, VsdtPackage.LANE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Pool newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != VsdtPackage.LANE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, VsdtPackage.POOL__LANES, Pool.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.LANE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.LANE__CONTAINED_FLOW_OBJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainedFlowObjects()).basicAdd(otherEnd, msgs);
			case VsdtPackage.LANE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Pool)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.LANE__CONTAINED_FLOW_OBJECTS:
				return ((InternalEList<?>)getContainedFlowObjects()).basicRemove(otherEnd, msgs);
			case VsdtPackage.LANE__PARENT:
				return basicSetParent(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case VsdtPackage.LANE__PARENT:
				return eInternalContainer().eInverseRemove(this, VsdtPackage.POOL__LANES, Pool.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VsdtPackage.LANE__CONTAINED_FLOW_OBJECTS:
				return getContainedFlowObjects();
			case VsdtPackage.LANE__PARENT:
				return getParent();
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
			case VsdtPackage.LANE__CONTAINED_FLOW_OBJECTS:
				getContainedFlowObjects().clear();
				getContainedFlowObjects().addAll((Collection<? extends FlowObject>)newValue);
				return;
			case VsdtPackage.LANE__PARENT:
				setParent((Pool)newValue);
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
			case VsdtPackage.LANE__CONTAINED_FLOW_OBJECTS:
				getContainedFlowObjects().clear();
				return;
			case VsdtPackage.LANE__PARENT:
				setParent((Pool)null);
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
			case VsdtPackage.LANE__CONTAINED_FLOW_OBJECTS:
				return containedFlowObjects != null && !containedFlowObjects.isEmpty();
			case VsdtPackage.LANE__PARENT:
				return getParent() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == FlowObjectContainer.class) {
			switch (derivedFeatureID) {
				case VsdtPackage.LANE__CONTAINED_FLOW_OBJECTS: return VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == FlowObjectContainer.class) {
			switch (baseFeatureID) {
				case VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS: return VsdtPackage.LANE__CONTAINED_FLOW_OBJECTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //LaneImpl
