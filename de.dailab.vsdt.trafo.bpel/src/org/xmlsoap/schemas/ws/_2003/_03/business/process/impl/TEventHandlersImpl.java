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
import org.xmlsoap.schemas.ws._2003._03.business.process.TEventHandlers;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnAlarm;
import org.xmlsoap.schemas.ws._2003._03.business.process.TOnMessage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TEvent Handlers</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEventHandlersImpl#getOnMessage <em>On Message</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TEventHandlersImpl#getOnAlarm <em>On Alarm</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TEventHandlersImpl extends TExtensibleElementsImpl implements TEventHandlers {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TEventHandlersImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TEVENT_HANDLERS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TOnMessage> getOnMessage() {
		if (onMessage == null) {
			onMessage = new EObjectContainmentEList<TOnMessage>(TOnMessage.class, this, ProcessPackage.TEVENT_HANDLERS__ON_MESSAGE);
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
			onAlarm = new EObjectContainmentEList<TOnAlarm>(TOnAlarm.class, this, ProcessPackage.TEVENT_HANDLERS__ON_ALARM);
		}
		return onAlarm;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ProcessPackage.TEVENT_HANDLERS__ON_MESSAGE:
				return ((InternalEList<?>)getOnMessage()).basicRemove(otherEnd, msgs);
			case ProcessPackage.TEVENT_HANDLERS__ON_ALARM:
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
			case ProcessPackage.TEVENT_HANDLERS__ON_MESSAGE:
				return getOnMessage();
			case ProcessPackage.TEVENT_HANDLERS__ON_ALARM:
				return getOnAlarm();
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
			case ProcessPackage.TEVENT_HANDLERS__ON_MESSAGE:
				getOnMessage().clear();
				getOnMessage().addAll((Collection<? extends TOnMessage>)newValue);
				return;
			case ProcessPackage.TEVENT_HANDLERS__ON_ALARM:
				getOnAlarm().clear();
				getOnAlarm().addAll((Collection<? extends TOnAlarm>)newValue);
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
			case ProcessPackage.TEVENT_HANDLERS__ON_MESSAGE:
				getOnMessage().clear();
				return;
			case ProcessPackage.TEVENT_HANDLERS__ON_ALARM:
				getOnAlarm().clear();
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
			case ProcessPackage.TEVENT_HANDLERS__ON_MESSAGE:
				return onMessage != null && !onMessage.isEmpty();
			case ProcessPackage.TEVENT_HANDLERS__ON_ALARM:
				return onAlarm != null && !onAlarm.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TEventHandlersImpl