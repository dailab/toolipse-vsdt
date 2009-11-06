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
import de.dailab.vsdt.StandardLoopAttSet;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Standard Loop Att Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.StandardLoopAttSetImpl#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.StandardLoopAttSetImpl#getLoopMaximum <em>Loop Maximum</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.StandardLoopAttSetImpl#isTestBefore <em>Test Before</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StandardLoopAttSetImpl extends LoopAttributeSetImpl implements StandardLoopAttSet {
	/**
	 * The cached value of the '{@link #getLoopCondition() <em>Loop Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression loopCondition;

	/**
	 * The default value of the '{@link #getLoopMaximum() <em>Loop Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopMaximum()
	 * @generated
	 * @ordered
	 */
	protected static final int LOOP_MAXIMUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getLoopMaximum() <em>Loop Maximum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopMaximum()
	 * @generated
	 * @ordered
	 */
	protected int loopMaximum = LOOP_MAXIMUM_EDEFAULT;

	/**
	 * The default value of the '{@link #isTestBefore() <em>Test Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTestBefore()
	 * @generated
	 * @ordered
	 */
	protected static final boolean TEST_BEFORE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isTestBefore() <em>Test Before</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isTestBefore()
	 * @generated
	 * @ordered
	 */
	protected boolean testBefore = TEST_BEFORE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StandardLoopAttSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.STANDARD_LOOP_ATT_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * initialize expression object
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getLoopCondition() {
		return loopCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopCondition(Expression newLoopCondition, NotificationChain msgs) {
		Expression oldLoopCondition = loopCondition;
		loopCondition = newLoopCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_CONDITION, oldLoopCondition, newLoopCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopCondition(Expression newLoopCondition) {
		if (newLoopCondition != loopCondition) {
			NotificationChain msgs = null;
			if (loopCondition != null)
				msgs = ((InternalEObject)loopCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_CONDITION, null, msgs);
			if (newLoopCondition != null)
				msgs = ((InternalEObject)newLoopCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_CONDITION, null, msgs);
			msgs = basicSetLoopCondition(newLoopCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_CONDITION, newLoopCondition, newLoopCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLoopMaximum() {
		return loopMaximum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopMaximum(int newLoopMaximum) {
		int oldLoopMaximum = loopMaximum;
		loopMaximum = newLoopMaximum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_MAXIMUM, oldLoopMaximum, loopMaximum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isTestBefore() {
		return testBefore;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTestBefore(boolean newTestBefore) {
		boolean oldTestBefore = testBefore;
		testBefore = newTestBefore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.STANDARD_LOOP_ATT_SET__TEST_BEFORE, oldTestBefore, testBefore));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_CONDITION:
				return basicSetLoopCondition(null, msgs);
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
			case VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_CONDITION:
				return getLoopCondition();
			case VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_MAXIMUM:
				return new Integer(getLoopMaximum());
			case VsdtPackage.STANDARD_LOOP_ATT_SET__TEST_BEFORE:
				return isTestBefore() ? Boolean.TRUE : Boolean.FALSE;
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
			case VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_CONDITION:
				setLoopCondition((Expression)newValue);
				return;
			case VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_MAXIMUM:
				setLoopMaximum(((Integer)newValue).intValue());
				return;
			case VsdtPackage.STANDARD_LOOP_ATT_SET__TEST_BEFORE:
				setTestBefore(((Boolean)newValue).booleanValue());
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
			case VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_CONDITION:
				setLoopCondition((Expression)null);
				return;
			case VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_MAXIMUM:
				setLoopMaximum(LOOP_MAXIMUM_EDEFAULT);
				return;
			case VsdtPackage.STANDARD_LOOP_ATT_SET__TEST_BEFORE:
				setTestBefore(TEST_BEFORE_EDEFAULT);
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
			case VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_CONDITION:
				return loopCondition != null;
			case VsdtPackage.STANDARD_LOOP_ATT_SET__LOOP_MAXIMUM:
				return loopMaximum != LOOP_MAXIMUM_EDEFAULT;
			case VsdtPackage.STANDARD_LOOP_ATT_SET__TEST_BEFORE:
				return testBefore != TEST_BEFORE_EDEFAULT;
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
		result.append(" (loopMaximum: ");
		result.append(loopMaximum);
		result.append(", testBefore: ");
		result.append(testBefore);
		result.append(')');
		return result.toString();
	}

} //StandardLoopAttSetImpl
