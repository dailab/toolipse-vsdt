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
import org.xmlsoap.schemas.ws._2003._03.business.process.TBoolean;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TPick;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TPick</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPickImpl#getOnMessage <em>On Message</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPickImpl#getOnAlarm <em>On Alarm</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TPickImpl#getCreateInstance <em>Create Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TPickImpl extends TActivityImpl implements TPick {
	/**
	 * The cached value of the '{@link #getOnMessage() <em>On Message</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnMessage()
	 * @generated
	 * @ordered
	 */
	protected EList<TOnMessage> onMessage;

	/**
	 * The cached value of the '{@link #getOnAlarm() <em>On Alarm</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnAlarm()
	 * @generated
	 * @ordered
	 */
	protected EList<TOnAlarm> onAlarm;

	/**
	 * The default value of the '{@link #getCreateInstance() <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateInstance()
	 * @generated
	 * @ordered
	 */
	protected static final TBoolean CREATE_INSTANCE_EDEFAULT = TBoolean.NO;

	/**
	 * The cached value of the '{@link #getCreateInstance() <em>Create Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreateInstance()
	 * @generated
	 * @ordered
	 */
	protected TBoolean createInstance = CREATE_INSTANCE_EDEFAULT;

	/**
	 * This is true if the Create Instance attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean createInstanceESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TPickImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TPICK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TOnMessage> getOnMessage() {
		if (onMessage == null) {
			onMessage = new EObjectContainmentEList<TOnMessage>(TOnMessage.class, this, ProcessPackage.TPICK__ON_MESSAGE);
		}
		return onMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TOnAlarm> getOnAlarm() {
		if (onAlarm == null) {
			onAlarm = new EObjectContainmentEList<TOnAlarm>(TOnAlarm.class, this, ProcessPackage.TPICK__ON_ALARM);
		}
		return onAlarm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TBoolean getCreateInstance() {
		return createInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreateInstance(TBoolean newCreateInstance) {
		TBoolean oldCreateInstance = createInstance;
		createInstance = newCreateInstance == null ? CREATE_INSTANCE_EDEFAULT : newCreateInstance;
		boolean oldCreateInstanceESet = createInstanceESet;
		createInstanceESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TPICK__CREATE_INSTANCE, oldCreateInstance, createInstance, !oldCreateInstanceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetCreateInstance() {
		TBoolean oldCreateInstance = createInstance;
		boolean oldCreateInstanceESet = createInstanceESet;
		createInstance = CREATE_INSTANCE_EDEFAULT;
		createInstanceESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ProcessPackage.TPICK__CREATE_INSTANCE, oldCreateInstance, CREATE_INSTANCE_EDEFAULT, oldCreateInstanceESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetCreateInstance() {
		return createInstanceESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TPICK__ON_MESSAGE:
				return ((InternalEList<?>)getOnMessage()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TPICK__ON_ALARM:
				return ((InternalEList<?>)getOnAlarm()).basicRemove(otherEnd, msgs);
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
			case ProcessPackage.TPICK__ON_MESSAGE:
				return getOnMessage();
			case ProcessPackage.TPICK__ON_ALARM:
				return getOnAlarm();
			case ProcessPackage.TPICK__CREATE_INSTANCE:
				return getCreateInstance();
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
			case ProcessPackage.TPICK__ON_MESSAGE:
				getOnMessage().clear();
				getOnMessage().addAll((Collection<? extends TOnMessage>)newValue);
				return;
			case ProcessPackage.TPICK__ON_ALARM:
				getOnAlarm().clear();
				getOnAlarm().addAll((Collection<? extends TOnAlarm>)newValue);
				return;
			case ProcessPackage.TPICK__CREATE_INSTANCE:
				setCreateInstance((TBoolean)newValue);
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
			case ProcessPackage.TPICK__ON_MESSAGE:
				getOnMessage().clear();
				return;
			case ProcessPackage.TPICK__ON_ALARM:
				getOnAlarm().clear();
				return;
			case ProcessPackage.TPICK__CREATE_INSTANCE:
				unsetCreateInstance();
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
			case ProcessPackage.TPICK__ON_MESSAGE:
				return onMessage != null && !onMessage.isEmpty();
			case ProcessPackage.TPICK__ON_ALARM:
				return onAlarm != null && !onAlarm.isEmpty();
			case ProcessPackage.TPICK__CREATE_INSTANCE:
				return isSetCreateInstance();
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
		result.append(" (createInstance: ");
		if (createInstanceESet) result.append(createInstance); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //TPickImpl