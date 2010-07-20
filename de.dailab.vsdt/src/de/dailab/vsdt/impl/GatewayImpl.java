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
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.GatewayType;
import de.dailab.vsdt.VsdtPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gateway</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.GatewayImpl#getGatewayType <em>Gateway Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.GatewayImpl#isInstantiate <em>Instantiate</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.GatewayImpl#getIncomingCondition <em>Incoming Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.GatewayImpl#getOutgoingCondition <em>Outgoing Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GatewayImpl extends FlowObjectImpl implements Gateway {
	/**
	 * The default value of the '{@link #getGatewayType() <em>Gateway Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGatewayType()
	 * @generated
	 * @ordered
	 */
	protected static final GatewayType GATEWAY_TYPE_EDEFAULT = GatewayType.XOR_DATA;

	/**
	 * The cached value of the '{@link #getGatewayType() <em>Gateway Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGatewayType()
	 * @generated
	 * @ordered
	 */
	protected GatewayType gatewayType = GATEWAY_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isInstantiate() <em>Instantiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstantiate()
	 * @generated
	 * @ordered
	 */
	protected static final boolean INSTANTIATE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isInstantiate() <em>Instantiate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isInstantiate()
	 * @generated
	 * @ordered
	 */
	protected boolean instantiate = INSTANTIATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIncomingCondition() <em>Incoming Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression incomingCondition;

	/**
	 * The cached value of the '{@link #getOutgoingCondition() <em>Outgoing Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression outgoingCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GatewayImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.GATEWAY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GatewayType getGatewayType() {
		return gatewayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * initialize gateway attribute set
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGatewayType(GatewayType newGatewayType) {
		GatewayType oldGatewayType = gatewayType;
		gatewayType = newGatewayType == null ? GATEWAY_TYPE_EDEFAULT : newGatewayType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.GATEWAY__GATEWAY_TYPE, oldGatewayType, gatewayType));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isInstantiate() {
		return instantiate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstantiate(boolean newInstantiate) {
		boolean oldInstantiate = instantiate;
		instantiate = newInstantiate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.GATEWAY__INSTANTIATE, oldInstantiate, instantiate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getIncomingCondition() {
		return incomingCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIncomingCondition(Expression newIncomingCondition, NotificationChain msgs) {
		Expression oldIncomingCondition = incomingCondition;
		incomingCondition = newIncomingCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.GATEWAY__INCOMING_CONDITION, oldIncomingCondition, newIncomingCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIncomingCondition(Expression newIncomingCondition) {
		if (newIncomingCondition != incomingCondition) {
			NotificationChain msgs = null;
			if (incomingCondition != null)
				msgs = ((InternalEObject)incomingCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.GATEWAY__INCOMING_CONDITION, null, msgs);
			if (newIncomingCondition != null)
				msgs = ((InternalEObject)newIncomingCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.GATEWAY__INCOMING_CONDITION, null, msgs);
			msgs = basicSetIncomingCondition(newIncomingCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.GATEWAY__INCOMING_CONDITION, newIncomingCondition, newIncomingCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getOutgoingCondition() {
		return outgoingCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutgoingCondition(Expression newOutgoingCondition, NotificationChain msgs) {
		Expression oldOutgoingCondition = outgoingCondition;
		outgoingCondition = newOutgoingCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.GATEWAY__OUTGOING_CONDITION, oldOutgoingCondition, newOutgoingCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutgoingCondition(Expression newOutgoingCondition) {
		if (newOutgoingCondition != outgoingCondition) {
			NotificationChain msgs = null;
			if (outgoingCondition != null)
				msgs = ((InternalEObject)outgoingCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.GATEWAY__OUTGOING_CONDITION, null, msgs);
			if (newOutgoingCondition != null)
				msgs = ((InternalEObject)newOutgoingCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.GATEWAY__OUTGOING_CONDITION, null, msgs);
			msgs = basicSetOutgoingCondition(newOutgoingCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.GATEWAY__OUTGOING_CONDITION, newOutgoingCondition, newOutgoingCondition));
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.GATEWAY__INCOMING_CONDITION:
				return basicSetIncomingCondition(null, msgs);
			case VsdtPackage.GATEWAY__OUTGOING_CONDITION:
				return basicSetOutgoingCondition(null, msgs);
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
			case VsdtPackage.GATEWAY__GATEWAY_TYPE:
				return getGatewayType();
			case VsdtPackage.GATEWAY__INSTANTIATE:
				return isInstantiate();
			case VsdtPackage.GATEWAY__INCOMING_CONDITION:
				return getIncomingCondition();
			case VsdtPackage.GATEWAY__OUTGOING_CONDITION:
				return getOutgoingCondition();
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
			case VsdtPackage.GATEWAY__GATEWAY_TYPE:
				setGatewayType((GatewayType)newValue);
				return;
			case VsdtPackage.GATEWAY__INSTANTIATE:
				setInstantiate((Boolean)newValue);
				return;
			case VsdtPackage.GATEWAY__INCOMING_CONDITION:
				setIncomingCondition((Expression)newValue);
				return;
			case VsdtPackage.GATEWAY__OUTGOING_CONDITION:
				setOutgoingCondition((Expression)newValue);
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
			case VsdtPackage.GATEWAY__GATEWAY_TYPE:
				setGatewayType(GATEWAY_TYPE_EDEFAULT);
				return;
			case VsdtPackage.GATEWAY__INSTANTIATE:
				setInstantiate(INSTANTIATE_EDEFAULT);
				return;
			case VsdtPackage.GATEWAY__INCOMING_CONDITION:
				setIncomingCondition((Expression)null);
				return;
			case VsdtPackage.GATEWAY__OUTGOING_CONDITION:
				setOutgoingCondition((Expression)null);
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
			case VsdtPackage.GATEWAY__GATEWAY_TYPE:
				return gatewayType != GATEWAY_TYPE_EDEFAULT;
			case VsdtPackage.GATEWAY__INSTANTIATE:
				return instantiate != INSTANTIATE_EDEFAULT;
			case VsdtPackage.GATEWAY__INCOMING_CONDITION:
				return incomingCondition != null;
			case VsdtPackage.GATEWAY__OUTGOING_CONDITION:
				return outgoingCondition != null;
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
		result.append(" (gatewayType: ");
		result.append(gatewayType);
		result.append(", instantiate: ");
		result.append(instantiate);
		result.append(')');
		return result.toString();
	}

} //GatewayImpl
