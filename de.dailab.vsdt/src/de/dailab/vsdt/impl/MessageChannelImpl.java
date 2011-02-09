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

import de.dailab.vsdt.Expression;
import de.dailab.vsdt.MessageChannel;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message Channel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.MessageChannelImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.MessageChannelImpl#getPayload <em>Payload</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MessageChannelImpl extends ImplementationImpl implements MessageChannel {
	/**
	 * The cached value of the '{@link #getChannel() <em>Channel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannel()
	 * @generated
	 * @ordered
	 */
	protected Expression channel;

	/**
	 * The cached value of the '{@link #getPayload() <em>Payload</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayload()
	 * @generated
	 * @ordered
	 */
	protected Property payload;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageChannelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.MESSAGE_CHANNEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getChannel() {
		if (channel != null && channel.eIsProxy()) {
			InternalEObject oldChannel = (InternalEObject)channel;
			channel = (Expression)eResolveProxy(oldChannel);
			if (channel != oldChannel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.MESSAGE_CHANNEL__CHANNEL, oldChannel, channel));
			}
		}
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression basicGetChannel() {
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannel(Expression newChannel) {
		Expression oldChannel = channel;
		channel = newChannel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__CHANNEL, oldChannel, channel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getPayload() {
		return payload;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPayload(Property newPayload, NotificationChain msgs) {
		Property oldPayload = payload;
		payload = newPayload;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__PAYLOAD, oldPayload, newPayload);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayload(Property newPayload) {
		if (newPayload != payload) {
			NotificationChain msgs = null;
			if (payload != null)
				msgs = ((InternalEObject)payload).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MESSAGE_CHANNEL__PAYLOAD, null, msgs);
			if (newPayload != null)
				msgs = ((InternalEObject)newPayload).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MESSAGE_CHANNEL__PAYLOAD, null, msgs);
			msgs = basicSetPayload(newPayload, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__PAYLOAD, newPayload, newPayload));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.MESSAGE_CHANNEL__PAYLOAD:
				return basicSetPayload(null, msgs);
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
			case VsdtPackage.MESSAGE_CHANNEL__CHANNEL:
				if (resolve) return getChannel();
				return basicGetChannel();
			case VsdtPackage.MESSAGE_CHANNEL__PAYLOAD:
				return getPayload();
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
			case VsdtPackage.MESSAGE_CHANNEL__CHANNEL:
				setChannel((Expression)newValue);
				return;
			case VsdtPackage.MESSAGE_CHANNEL__PAYLOAD:
				setPayload((Property)newValue);
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
			case VsdtPackage.MESSAGE_CHANNEL__CHANNEL:
				setChannel((Expression)null);
				return;
			case VsdtPackage.MESSAGE_CHANNEL__PAYLOAD:
				setPayload((Property)null);
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
			case VsdtPackage.MESSAGE_CHANNEL__CHANNEL:
				return channel != null;
			case VsdtPackage.MESSAGE_CHANNEL__PAYLOAD:
				return payload != null;
		}
		return super.eIsSet(featureID);
	}

} //MessageChannelImpl
