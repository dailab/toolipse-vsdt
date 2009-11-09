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
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationWithPattern;
import org.xmlsoap.schemas.ws._2003._03.business.process.TCorrelationsWithPattern;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TCorrelations With Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TCorrelationsWithPatternImpl#getCorrelation <em>Correlation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TCorrelationsWithPatternImpl extends TExtensibleElementsImpl implements TCorrelationsWithPattern {
	/**
	 * The cached value of the '{@link #getCorrelation() <em>Correlation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorrelation()
	 * @generated
	 * @ordered
	 */
	protected EList<TCorrelationWithPattern> correlation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TCorrelationsWithPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TCORRELATIONS_WITH_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TCorrelationWithPattern> getCorrelation() {
		if (correlation == null) {
			correlation = new EObjectContainmentEList<TCorrelationWithPattern>(TCorrelationWithPattern.class, this, ProcessPackage.TCORRELATIONS_WITH_PATTERN__CORRELATION);
		}
		return correlation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TCORRELATIONS_WITH_PATTERN__CORRELATION:
				return ((InternalEList<?>)getCorrelation()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.TCORRELATIONS_WITH_PATTERN__CORRELATION:
				return getCorrelation();
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
			case ProcessPackage.TCORRELATIONS_WITH_PATTERN__CORRELATION:
				getCorrelation().clear();
				getCorrelation().addAll((Collection<? extends TCorrelationWithPattern>)newValue);
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
			case ProcessPackage.TCORRELATIONS_WITH_PATTERN__CORRELATION:
				getCorrelation().clear();
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
			case ProcessPackage.TCORRELATIONS_WITH_PATTERN__CORRELATION:
				return correlation != null && !correlation.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TCorrelationsWithPatternImpl