/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.ws._2003._03.business.process.impl;

import javax.xml.namespace.QName;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.xmlsoap.schemas.ws._2003._03.business.process.ProcessPackage;
import org.xmlsoap.schemas.ws._2003._03.business.process.TThrow;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TThrow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TThrowImpl#getFaultName <em>Fault Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.ws._2003._03.business.process.impl.TThrowImpl#getFaultVariable <em>Fault Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TThrowImpl extends TActivityImpl implements TThrow {
	/**
	 * The default value of the '{@link #getFaultName() <em>Fault Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultName()
	 * @generated
	 * @ordered
	 */
	protected static final QName FAULT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaultName() <em>Fault Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultName()
	 * @generated
	 * @ordered
	 */
	protected QName faultName = FAULT_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFaultVariable() <em>Fault Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultVariable()
	 * @generated
	 * @ordered
	 */
	protected static final String FAULT_VARIABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFaultVariable() <em>Fault Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFaultVariable()
	 * @generated
	 * @ordered
	 */
	protected String faultVariable = FAULT_VARIABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TThrowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ProcessPackage.Literals.TTHROW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QName getFaultName() {
		return faultName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultName(QName newFaultName) {
		QName oldFaultName = faultName;
		faultName = newFaultName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TTHROW__FAULT_NAME, oldFaultName, faultName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFaultVariable() {
		return faultVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFaultVariable(String newFaultVariable) {
		String oldFaultVariable = faultVariable;
		faultVariable = newFaultVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ProcessPackage.TTHROW__FAULT_VARIABLE, oldFaultVariable, faultVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ProcessPackage.TTHROW__FAULT_NAME:
				return getFaultName();
			case ProcessPackage.TTHROW__FAULT_VARIABLE:
				return getFaultVariable();
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
			case ProcessPackage.TTHROW__FAULT_NAME:
				setFaultName((QName)newValue);
				return;
			case ProcessPackage.TTHROW__FAULT_VARIABLE:
				setFaultVariable((String)newValue);
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
			case ProcessPackage.TTHROW__FAULT_NAME:
				setFaultName(FAULT_NAME_EDEFAULT);
				return;
			case ProcessPackage.TTHROW__FAULT_VARIABLE:
				setFaultVariable(FAULT_VARIABLE_EDEFAULT);
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
			case ProcessPackage.TTHROW__FAULT_NAME:
				return FAULT_NAME_EDEFAULT == null ? faultName != null : !FAULT_NAME_EDEFAULT.equals(faultName);
			case ProcessPackage.TTHROW__FAULT_VARIABLE:
				return FAULT_VARIABLE_EDEFAULT == null ? faultVariable != null : !FAULT_VARIABLE_EDEFAULT.equals(faultVariable);
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
		result.append(" (faultName: ");
		result.append(faultName);
		result.append(", faultVariable: ");
		result.append(faultVariable);
		result.append(')');
		return result.toString();
	}

} //TThrowImpl