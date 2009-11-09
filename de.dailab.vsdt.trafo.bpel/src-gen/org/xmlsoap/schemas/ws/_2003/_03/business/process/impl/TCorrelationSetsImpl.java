/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSet;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationSets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCorrelation Sets</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationSetsImpl#getCorrelationSet <em>Correlation Set</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCorrelationSetsImpl extends TExtensibleElementsImpl implements TCorrelationSets {
	/**
	 * The cached value of the '{@link #getCorrelationSet() <em>Correlation Set</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelationSet()
	 * @generated
	 * @ordered
	 */
	protected EList<TCorrelationSet> correlationSet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCorrelationSetsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TCORRELATION_SETS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCorrelationSet> getCorrelationSet() {
		if (correlationSet == null) {
			correlationSet = new EObjectContainmentEList<TCorrelationSet>(TCorrelationSet.class, this, ProcessPackage.TCORRELATION_SETS__CORRELATION_SET);
		}
		return correlationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TCORRELATION_SETS__CORRELATION_SET:
				return ((InternalEList<?>)getCorrelationSet()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.TCORRELATION_SETS__CORRELATION_SET:
				return getCorrelationSet();
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
			case ProcessPackage.TCORRELATION_SETS__CORRELATION_SET:
				getCorrelationSet().clear();
				getCorrelationSet().addAll((Collection<? extends TCorrelationSet>)newValue);
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
			case ProcessPackage.TCORRELATION_SETS__CORRELATION_SET:
				getCorrelationSet().clear();
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
			case ProcessPackage.TCORRELATION_SETS__CORRELATION_SET:
				return correlationSet != null && !correlationSet.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TCorrelationSetsImpl