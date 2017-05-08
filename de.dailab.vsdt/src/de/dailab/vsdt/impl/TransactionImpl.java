/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.dailab.vsdt.Transaction;
import de.dailab.vsdt.TransactionMethodType;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.TransactionImpl#getTransactionId <em>Transaction Id</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.TransactionImpl#getTransactionProtocol <em>Transaction Protocol</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.TransactionImpl#getTransactionMethod <em>Transaction Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransactionImpl extends EObjectImpl implements Transaction {
	/**
	 * The default value of the '{@link #getTransactionId() <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionId()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSACTION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransactionId() <em>Transaction Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionId()
	 * @generated
	 * @ordered
	 */
	protected String transactionId = TRANSACTION_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransactionProtocol() <em>Transaction Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionProtocol()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSACTION_PROTOCOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransactionProtocol() <em>Transaction Protocol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionProtocol()
	 * @generated
	 * @ordered
	 */
	protected String transactionProtocol = TRANSACTION_PROTOCOL_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransactionMethod() <em>Transaction Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionMethod()
	 * @generated
	 * @ordered
	 */
	protected static final TransactionMethodType TRANSACTION_METHOD_EDEFAULT = TransactionMethodType.COMPENSATE;

	/**
	 * The cached value of the '{@link #getTransactionMethod() <em>Transaction Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransactionMethod()
	 * @generated
	 * @ordered
	 */
	protected TransactionMethodType transactionMethod = TRANSACTION_METHOD_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.TRANSACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionId(String newTransactionId) {
		String oldTransactionId = transactionId;
		transactionId = newTransactionId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.TRANSACTION__TRANSACTION_ID, oldTransactionId, transactionId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransactionProtocol() {
		return transactionProtocol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionProtocol(String newTransactionProtocol) {
		String oldTransactionProtocol = transactionProtocol;
		transactionProtocol = newTransactionProtocol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.TRANSACTION__TRANSACTION_PROTOCOL, oldTransactionProtocol, transactionProtocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransactionMethodType getTransactionMethod() {
		return transactionMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransactionMethod(TransactionMethodType newTransactionMethod) {
		TransactionMethodType oldTransactionMethod = transactionMethod;
		transactionMethod = newTransactionMethod == null ? TRANSACTION_METHOD_EDEFAULT : newTransactionMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.TRANSACTION__TRANSACTION_METHOD, oldTransactionMethod, transactionMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VsdtPackage.TRANSACTION__TRANSACTION_ID:
				return getTransactionId();
			case VsdtPackage.TRANSACTION__TRANSACTION_PROTOCOL:
				return getTransactionProtocol();
			case VsdtPackage.TRANSACTION__TRANSACTION_METHOD:
				return getTransactionMethod();
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
			case VsdtPackage.TRANSACTION__TRANSACTION_ID:
				setTransactionId((String)newValue);
				return;
			case VsdtPackage.TRANSACTION__TRANSACTION_PROTOCOL:
				setTransactionProtocol((String)newValue);
				return;
			case VsdtPackage.TRANSACTION__TRANSACTION_METHOD:
				setTransactionMethod((TransactionMethodType)newValue);
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
			case VsdtPackage.TRANSACTION__TRANSACTION_ID:
				setTransactionId(TRANSACTION_ID_EDEFAULT);
				return;
			case VsdtPackage.TRANSACTION__TRANSACTION_PROTOCOL:
				setTransactionProtocol(TRANSACTION_PROTOCOL_EDEFAULT);
				return;
			case VsdtPackage.TRANSACTION__TRANSACTION_METHOD:
				setTransactionMethod(TRANSACTION_METHOD_EDEFAULT);
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
			case VsdtPackage.TRANSACTION__TRANSACTION_ID:
				return TRANSACTION_ID_EDEFAULT == null ? transactionId != null : !TRANSACTION_ID_EDEFAULT.equals(transactionId);
			case VsdtPackage.TRANSACTION__TRANSACTION_PROTOCOL:
				return TRANSACTION_PROTOCOL_EDEFAULT == null ? transactionProtocol != null : !TRANSACTION_PROTOCOL_EDEFAULT.equals(transactionProtocol);
			case VsdtPackage.TRANSACTION__TRANSACTION_METHOD:
				return transactionMethod != TRANSACTION_METHOD_EDEFAULT;
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
		result.append(" (transactionId: ");
		result.append(transactionId);
		result.append(", transactionProtocol: ");
		result.append(transactionProtocol);
		result.append(", transactionMethod: ");
		result.append(transactionMethod);
		result.append(')');
		return result.toString();
	}

} //TransactionImpl
