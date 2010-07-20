/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Object Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.FlowObjectContainerImpl#getContainedFlowObjects <em>Contained Flow Objects</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class FlowObjectContainerImpl extends EObjectImpl implements FlowObjectContainer {
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
	protected FlowObjectContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.FLOW_OBJECT_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowObject> getContainedFlowObjects() {
		if (containedFlowObjects == null) {
			containedFlowObjects = new EObjectContainmentWithInverseEList<FlowObject>(FlowObject.class, this, VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS, VsdtPackage.FLOW_OBJECT__PARENT);
		}
		return containedFlowObjects;
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
			case VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContainedFlowObjects()).basicAdd(otherEnd, msgs);
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
			case VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS:
				return ((InternalEList<?>)getContainedFlowObjects()).basicRemove(otherEnd, msgs);
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
			case VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS:
				return getContainedFlowObjects();
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
			case VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS:
				getContainedFlowObjects().clear();
				getContainedFlowObjects().addAll((Collection<? extends FlowObject>)newValue);
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
			case VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS:
				getContainedFlowObjects().clear();
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
			case VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS:
				return containedFlowObjects != null && !containedFlowObjects.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FlowObjectContainerImpl
