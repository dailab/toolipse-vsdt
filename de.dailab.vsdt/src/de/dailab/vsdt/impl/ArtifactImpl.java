/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.dailab.vsdt.Artifact;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Artifact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.ArtifactImpl#getParentDiagram <em>Parent Diagram</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ArtifactImpl#getPool <em>Pool</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ArtifactImpl extends GraphicalObjectImpl implements Artifact {
	/**
	 * The cached value of the '{@link #getPool() <em>Pool</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPool()
	 * @generated
	 * @ordered
	 */
	protected Pool pool;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArtifactImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.ARTIFACT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessDiagram getParentDiagram() {
		if (eContainerFeatureID != VsdtPackage.ARTIFACT__PARENT_DIAGRAM) return null;
		return (BusinessProcessDiagram)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentDiagram(BusinessProcessDiagram newParentDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentDiagram, VsdtPackage.ARTIFACT__PARENT_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentDiagram(BusinessProcessDiagram newParentDiagram) {
		if (newParentDiagram != eInternalContainer() || (eContainerFeatureID != VsdtPackage.ARTIFACT__PARENT_DIAGRAM && newParentDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newParentDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentDiagram != null)
				msgs = ((InternalEObject)newParentDiagram).eInverseAdd(this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS, BusinessProcessDiagram.class, msgs);
			msgs = basicSetParentDiagram(newParentDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ARTIFACT__PARENT_DIAGRAM, newParentDiagram, newParentDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pool getPool() {
		if (pool != null && pool.eIsProxy()) {
			InternalEObject oldPool = (InternalEObject)pool;
			pool = (Pool)eResolveProxy(oldPool);
			if (pool != oldPool) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.ARTIFACT__POOL, oldPool, pool));
			}
		}
		return pool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pool basicGetPool() {
		return pool;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPool(Pool newPool) {
		Pool oldPool = pool;
		pool = newPool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ARTIFACT__POOL, oldPool, pool));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.ARTIFACT__PARENT_DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentDiagram((BusinessProcessDiagram)otherEnd, msgs);
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
			case VsdtPackage.ARTIFACT__PARENT_DIAGRAM:
				return basicSetParentDiagram(null, msgs);
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
		switch (eContainerFeatureID) {
			case VsdtPackage.ARTIFACT__PARENT_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS, BusinessProcessDiagram.class, msgs);
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
			case VsdtPackage.ARTIFACT__PARENT_DIAGRAM:
				return getParentDiagram();
			case VsdtPackage.ARTIFACT__POOL:
				if (resolve) return getPool();
				return basicGetPool();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VsdtPackage.ARTIFACT__PARENT_DIAGRAM:
				setParentDiagram((BusinessProcessDiagram)newValue);
				return;
			case VsdtPackage.ARTIFACT__POOL:
				setPool((Pool)newValue);
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
			case VsdtPackage.ARTIFACT__PARENT_DIAGRAM:
				setParentDiagram((BusinessProcessDiagram)null);
				return;
			case VsdtPackage.ARTIFACT__POOL:
				setPool((Pool)null);
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
			case VsdtPackage.ARTIFACT__PARENT_DIAGRAM:
				return getParentDiagram() != null;
			case VsdtPackage.ARTIFACT__POOL:
				return pool != null;
		}
		return super.eIsSet(featureID);
	}

} //ArtifactImpl
