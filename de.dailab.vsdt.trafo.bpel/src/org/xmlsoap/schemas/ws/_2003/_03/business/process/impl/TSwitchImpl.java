/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.xmlsoap.schemas.ws._2003._03.business.process.CaseType;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivityContainer;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSwitch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TSwitch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSwitchImpl#getCase <em>Case</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TSwitchImpl#getOtherwise <em>Otherwise</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TSwitchImpl extends TActivityImpl implements TSwitch {
	/**
	 * The cached value of the '{@link #getCase() <em>Case</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCase()
	 * @generated
	 * @ordered
	 */
	protected EList<CaseType> case_;

	/**
	 * The cached value of the '{@link #getOtherwise() <em>Otherwise</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherwise()
	 * @generated
	 * @ordered
	 */
	protected TActivityContainer otherwise;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TSwitchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TSWITCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CaseType> getCase() {
		if (case_ == null) {
			case_ = new EObjectContainmentEList<CaseType>(CaseType.class, this, ProcessPackage.TSWITCH__CASE);
		}
		return case_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TActivityContainer getOtherwise() {
		return otherwise;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOtherwise(TActivityContainer newOtherwise, NotificationChain msgs) {
		TActivityContainer oldOtherwise = otherwise;
		otherwise = newOtherwise;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ProcessPackage.TSWITCH__OTHERWISE, oldOtherwise, newOtherwise);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOtherwise(TActivityContainer newOtherwise) {
		if (newOtherwise != otherwise) {
			NotificationChain msgs = null;
			if (otherwise != null)
				msgs = ((InternalEObject)otherwise).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSWITCH__OTHERWISE, null, msgs);
			if (newOtherwise != null)
				msgs = ((InternalEObject)newOtherwise).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ProcessPackage.TSWITCH__OTHERWISE, null, msgs);
			msgs = basicSetOtherwise(newOtherwise, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TSWITCH__OTHERWISE, newOtherwise, newOtherwise));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TSWITCH__CASE:
				return ((InternalEList<?>)getCase()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TSWITCH__OTHERWISE:
				return basicSetOtherwise(null, msgs);
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
			case ProcessPackage.TSWITCH__CASE:
				return getCase();
			case ProcessPackage.TSWITCH__OTHERWISE:
				return getOtherwise();
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
			case ProcessPackage.TSWITCH__CASE:
				getCase().clear();
				getCase().addAll((Collection<? extends CaseType>)newValue);
				return;
			case ProcessPackage.TSWITCH__OTHERWISE:
				setOtherwise((TActivityContainer)newValue);
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
			case ProcessPackage.TSWITCH__CASE:
				getCase().clear();
				return;
			case ProcessPackage.TSWITCH__OTHERWISE:
				setOtherwise((TActivityContainer)null);
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
			case ProcessPackage.TSWITCH__CASE:
				return case_ != null && !case_.isEmpty();
			case ProcessPackage.TSWITCH__OTHERWISE:
				return otherwise != null;
		}
		return super.eIsSet(featureID);
	}

} //TSwitchImpl