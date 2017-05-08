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
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.MessageChannelImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.MessageChannelImpl#getPayload <em>Payload</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.MessageChannelImpl#getSender <em>Sender</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.MessageChannelImpl#getReceiver <em>Receiver</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.MessageChannelImpl#isMessageGroup <em>Message Group</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageChannelImpl extends ImplementationImpl implements MessageChannel {
	/**
	 * The cached value of the '{@link #getChannel() <em>Channel</em>}' containment reference.
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
	 * The cached value of the '{@link #getSender() <em>Sender</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSender()
	 * @generated
	 * @ordered
	 */
	protected Property sender;

	/**
	 * The cached value of the '{@link #getReceiver() <em>Receiver</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReceiver()
	 * @generated
	 * @ordered
	 */
	protected Property receiver;

	/**
	 * The default value of the '{@link #isMessageGroup() <em>Message Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMessageGroup()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MESSAGE_GROUP_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isMessageGroup() <em>Message Group</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMessageGroup()
	 * @generated
	 * @ordered
	 */
	protected boolean messageGroup = MESSAGE_GROUP_EDEFAULT;

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
		return channel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChannel(Expression newChannel, NotificationChain msgs) {
		Expression oldChannel = channel;
		channel = newChannel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__CHANNEL, oldChannel, newChannel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChannel(Expression newChannel) {
		if (newChannel != channel) {
			NotificationChain msgs = null;
			if (channel != null)
				msgs = ((InternalEObject)channel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MESSAGE_CHANNEL__CHANNEL, null, msgs);
			if (newChannel != null)
				msgs = ((InternalEObject)newChannel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MESSAGE_CHANNEL__CHANNEL, null, msgs);
			msgs = basicSetChannel(newChannel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__CHANNEL, newChannel, newChannel));
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
	public Property getSender() {
		return sender;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSender(Property newSender, NotificationChain msgs) {
		Property oldSender = sender;
		sender = newSender;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__SENDER, oldSender, newSender);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSender(Property newSender) {
		if (newSender != sender) {
			NotificationChain msgs = null;
			if (sender != null)
				msgs = ((InternalEObject)sender).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MESSAGE_CHANNEL__SENDER, null, msgs);
			if (newSender != null)
				msgs = ((InternalEObject)newSender).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MESSAGE_CHANNEL__SENDER, null, msgs);
			msgs = basicSetSender(newSender, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__SENDER, newSender, newSender));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getReceiver() {
		return receiver;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReceiver(Property newReceiver, NotificationChain msgs) {
		Property oldReceiver = receiver;
		receiver = newReceiver;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__RECEIVER, oldReceiver, newReceiver);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReceiver(Property newReceiver) {
		if (newReceiver != receiver) {
			NotificationChain msgs = null;
			if (receiver != null)
				msgs = ((InternalEObject)receiver).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MESSAGE_CHANNEL__RECEIVER, null, msgs);
			if (newReceiver != null)
				msgs = ((InternalEObject)newReceiver).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MESSAGE_CHANNEL__RECEIVER, null, msgs);
			msgs = basicSetReceiver(newReceiver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__RECEIVER, newReceiver, newReceiver));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMessageGroup() {
		return messageGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessageGroup(boolean newMessageGroup) {
		boolean oldMessageGroup = messageGroup;
		messageGroup = newMessageGroup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MESSAGE_CHANNEL__MESSAGE_GROUP, oldMessageGroup, messageGroup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.MESSAGE_CHANNEL__CHANNEL:
				return basicSetChannel(null, msgs);
			case VsdtPackage.MESSAGE_CHANNEL__PAYLOAD:
				return basicSetPayload(null, msgs);
			case VsdtPackage.MESSAGE_CHANNEL__SENDER:
				return basicSetSender(null, msgs);
			case VsdtPackage.MESSAGE_CHANNEL__RECEIVER:
				return basicSetReceiver(null, msgs);
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
				return getChannel();
			case VsdtPackage.MESSAGE_CHANNEL__PAYLOAD:
				return getPayload();
			case VsdtPackage.MESSAGE_CHANNEL__SENDER:
				return getSender();
			case VsdtPackage.MESSAGE_CHANNEL__RECEIVER:
				return getReceiver();
			case VsdtPackage.MESSAGE_CHANNEL__MESSAGE_GROUP:
				return isMessageGroup();
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
			case VsdtPackage.MESSAGE_CHANNEL__SENDER:
				setSender((Property)newValue);
				return;
			case VsdtPackage.MESSAGE_CHANNEL__RECEIVER:
				setReceiver((Property)newValue);
				return;
			case VsdtPackage.MESSAGE_CHANNEL__MESSAGE_GROUP:
				setMessageGroup((Boolean)newValue);
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
			case VsdtPackage.MESSAGE_CHANNEL__SENDER:
				setSender((Property)null);
				return;
			case VsdtPackage.MESSAGE_CHANNEL__RECEIVER:
				setReceiver((Property)null);
				return;
			case VsdtPackage.MESSAGE_CHANNEL__MESSAGE_GROUP:
				setMessageGroup(MESSAGE_GROUP_EDEFAULT);
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
			case VsdtPackage.MESSAGE_CHANNEL__SENDER:
				return sender != null;
			case VsdtPackage.MESSAGE_CHANNEL__RECEIVER:
				return receiver != null;
			case VsdtPackage.MESSAGE_CHANNEL__MESSAGE_GROUP:
				return messageGroup != MESSAGE_GROUP_EDEFAULT;
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
		result.append(" (messageGroup: ");
		result.append(messageGroup);
		result.append(')');
		return result.toString();
	}

} //MessageChannelImpl
