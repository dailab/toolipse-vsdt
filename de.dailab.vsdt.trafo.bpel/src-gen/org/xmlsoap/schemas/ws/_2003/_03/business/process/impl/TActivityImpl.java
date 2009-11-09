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
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TActivity;
import org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean;
import org.xmlsoap.schemas.ws._2003._03.business.process.TSource;
import org.xmlsoap.schemas.ws._2003._03.business.process.TTarget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TActivity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityImpl#getJoinCondition <em>Join Condition</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TActivityImpl#getSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TActivityImpl extends TExtensibleElementsImpl implements TActivity {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected EList<TTarget> target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EList<TSource> source;

	/**
	 * The default value of the '{@link #getJoinCondition() <em>Join Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinCondition()
	 * @generated
	 * @ordered
	 */
	protected static final String JOIN_CONDITION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJoinCondition() <em>Join Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinCondition()
	 * @generated
	 * @ordered
	 */
	protected String joinCondition = JOIN_CONDITION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppressJoinFailure()
	 * @generated
	 * @ordered
	 */
	protected static final TBoolean SUPPRESS_JOIN_FAILURE_EDEFAULT = TBoolean.NO;

	/**
	 * The cached value of the '{@link #getSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuppressJoinFailure()
	 * @generated
	 * @ordered
	 */
	protected TBoolean suppressJoinFailure = SUPPRESS_JOIN_FAILURE_EDEFAULT;

	/**
	 * This is true if the Suppress Join Failure attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean suppressJoinFailureESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TActivityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TACTIVITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TTarget> getTarget() {
		if (target == null) {
			target = new EObjectContainmentEList<TTarget>(TTarget.class, this, ProcessPackage.TACTIVITY__TARGET);
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TSource> getSource() {
		if (source == null) {
			source = new EObjectContainmentEList<TSource>(TSource.class, this, ProcessPackage.TACTIVITY__SOURCE);
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJoinCondition() {
		return joinCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJoinCondition(String newJoinCondition) {
		String oldJoinCondition = joinCondition;
		joinCondition = newJoinCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TACTIVITY__JOIN_CONDITION, oldJoinCondition, joinCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TACTIVITY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBoolean getSuppressJoinFailure() {
		return suppressJoinFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressJoinFailure(TBoolean newSuppressJoinFailure) {
		TBoolean oldSuppressJoinFailure = suppressJoinFailure;
		suppressJoinFailure = newSuppressJoinFailure == null ? SUPPRESS_JOIN_FAILURE_EDEFAULT : newSuppressJoinFailure;
		boolean oldSuppressJoinFailureESet = suppressJoinFailureESet;
		suppressJoinFailureESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TACTIVITY__SUPPRESS_JOIN_FAILURE, oldSuppressJoinFailure, suppressJoinFailure, !oldSuppressJoinFailureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetSuppressJoinFailure() {
		TBoolean oldSuppressJoinFailure = suppressJoinFailure;
		boolean oldSuppressJoinFailureESet = suppressJoinFailureESet;
		suppressJoinFailure = SUPPRESS_JOIN_FAILURE_EDEFAULT;
		suppressJoinFailureESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ProcessPackage.TACTIVITY__SUPPRESS_JOIN_FAILURE, oldSuppressJoinFailure, SUPPRESS_JOIN_FAILURE_EDEFAULT, oldSuppressJoinFailureESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetSuppressJoinFailure() {
		return suppressJoinFailureESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TACTIVITY__TARGET:
				return ((InternalEList<?>)getTarget()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TACTIVITY__SOURCE:
				return ((InternalEList<?>)getSource()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.TACTIVITY__TARGET:
				return getTarget();
			case ProcessPackage.TACTIVITY__SOURCE:
				return getSource();
			case ProcessPackage.TACTIVITY__JOIN_CONDITION:
				return getJoinCondition();
			case ProcessPackage.TACTIVITY__NAME:
				return getName();
			case ProcessPackage.TACTIVITY__SUPPRESS_JOIN_FAILURE:
				return getSuppressJoinFailure();
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
			case ProcessPackage.TACTIVITY__TARGET:
				getTarget().clear();
				getTarget().addAll((Collection<? extends TTarget>)newValue);
				return;
			case ProcessPackage.TACTIVITY__SOURCE:
				getSource().clear();
				getSource().addAll((Collection<? extends TSource>)newValue);
				return;
			case ProcessPackage.TACTIVITY__JOIN_CONDITION:
				setJoinCondition((String)newValue);
				return;
			case ProcessPackage.TACTIVITY__NAME:
				setName((String)newValue);
				return;
			case ProcessPackage.TACTIVITY__SUPPRESS_JOIN_FAILURE:
				setSuppressJoinFailure((TBoolean)newValue);
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
			case ProcessPackage.TACTIVITY__TARGET:
				getTarget().clear();
				return;
			case ProcessPackage.TACTIVITY__SOURCE:
				getSource().clear();
				return;
			case ProcessPackage.TACTIVITY__JOIN_CONDITION:
				setJoinCondition(JOIN_CONDITION_EDEFAULT);
				return;
			case ProcessPackage.TACTIVITY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ProcessPackage.TACTIVITY__SUPPRESS_JOIN_FAILURE:
				unsetSuppressJoinFailure();
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
			case ProcessPackage.TACTIVITY__TARGET:
				return target != null && !target.isEmpty();
			case ProcessPackage.TACTIVITY__SOURCE:
				return source != null && !source.isEmpty();
			case ProcessPackage.TACTIVITY__JOIN_CONDITION:
				return JOIN_CONDITION_EDEFAULT == null ? joinCondition != null : !JOIN_CONDITION_EDEFAULT.equals(joinCondition);
			case ProcessPackage.TACTIVITY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ProcessPackage.TACTIVITY__SUPPRESS_JOIN_FAILURE:
				return isSetSuppressJoinFailure();
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
		result.append(" (joinCondition: ");
		result.append(joinCondition);
		result.append(", name: ");
		result.append(name);
		result.append(", suppressJoinFailure: ");
		if (suppressJoinFailureESet) result.append(suppressJoinFailure); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TActivityImpl