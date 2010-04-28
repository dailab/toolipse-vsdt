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

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connecting Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.ConnectingObjectImpl#getParentDiagram <em>Parent Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConnectingObjectImpl extends GraphicalObjectImpl implements ConnectingObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectingObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.CONNECTING_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessDiagram getParentDiagram() {
		if (eContainerFeatureID() != VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM) return null;
		return (BusinessProcessDiagram)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentDiagram(BusinessProcessDiagram newParentDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentDiagram, VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentDiagram(BusinessProcessDiagram newParentDiagram) {
		if (newParentDiagram != eInternalContainer() || (eContainerFeatureID() != VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM && newParentDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newParentDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentDiagram != null)
				msgs = ((InternalEObject)newParentDiagram).eInverseAdd(this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS, BusinessProcessDiagram.class, msgs);
			msgs = basicSetParentDiagram(newParentDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM, newParentDiagram, newParentDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM:
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
			case VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM:
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
		switch (eContainerFeatureID()) {
			case VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS, BusinessProcessDiagram.class, msgs);
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
			case VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM:
				return getParentDiagram();
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
			case VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM:
				setParentDiagram((BusinessProcessDiagram)newValue);
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
			case VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM:
				setParentDiagram((BusinessProcessDiagram)null);
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
			case VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM:
				return getParentDiagram() != null;
		}
		return super.eIsSet(featureID);
	}

} //ConnectingObjectImpl
