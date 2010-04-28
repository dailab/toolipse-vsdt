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
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.LoopAttributeSet;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop Attribute Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.LoopAttributeSetImpl#getParentActivity <em>Parent Activity</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.LoopAttributeSetImpl#getLoopCounter <em>Loop Counter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LoopAttributeSetImpl extends EObjectImpl implements LoopAttributeSet {
	/**
	 * The default value of the '{@link #getLoopCounter() <em>Loop Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopCounter()
	 * @generated
	 * @ordered
	 */
	protected static final int LOOP_COUNTER_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getLoopCounter() <em>Loop Counter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopCounter()
	 * @generated
	 * @ordered
	 */
	protected int loopCounter = LOOP_COUNTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopAttributeSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.LOOP_ATTRIBUTE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getParentActivity() {
		if (eContainerFeatureID() != VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY) return null;
		return (Activity)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentActivity(Activity newParentActivity, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentActivity, VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentActivity(Activity newParentActivity) {
		if (newParentActivity != eInternalContainer() || (eContainerFeatureID() != VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY && newParentActivity != null)) {
			if (EcoreUtil.isAncestor(this, newParentActivity))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentActivity != null)
				msgs = ((InternalEObject)newParentActivity).eInverseAdd(this, VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES, Activity.class, msgs);
			msgs = basicSetParentActivity(newParentActivity, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY, newParentActivity, newParentActivity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLoopCounter() {
		return loopCounter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopCounter(int newLoopCounter) {
		int oldLoopCounter = loopCounter;
		loopCounter = newLoopCounter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.LOOP_ATTRIBUTE_SET__LOOP_COUNTER, oldLoopCounter, loopCounter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentActivity((Activity)otherEnd, msgs);
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
			case VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY:
				return basicSetParentActivity(null, msgs);
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
			case VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY:
				return eInternalContainer().eInverseRemove(this, VsdtPackage.ACTIVITY__LOOP_ATTRIBUTES, Activity.class, msgs);
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
			case VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY:
				return getParentActivity();
			case VsdtPackage.LOOP_ATTRIBUTE_SET__LOOP_COUNTER:
				return getLoopCounter();
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
			case VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY:
				setParentActivity((Activity)newValue);
				return;
			case VsdtPackage.LOOP_ATTRIBUTE_SET__LOOP_COUNTER:
				setLoopCounter((Integer)newValue);
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
			case VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY:
				setParentActivity((Activity)null);
				return;
			case VsdtPackage.LOOP_ATTRIBUTE_SET__LOOP_COUNTER:
				setLoopCounter(LOOP_COUNTER_EDEFAULT);
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
			case VsdtPackage.LOOP_ATTRIBUTE_SET__PARENT_ACTIVITY:
				return getParentActivity() != null;
			case VsdtPackage.LOOP_ATTRIBUTE_SET__LOOP_COUNTER:
				return loopCounter != LOOP_COUNTER_EDEFAULT;
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
		result.append(" (loopCounter: ");
		result.append(loopCounter);
		result.append(')');
		return result.toString();
	}

} //LoopAttributeSetImpl
