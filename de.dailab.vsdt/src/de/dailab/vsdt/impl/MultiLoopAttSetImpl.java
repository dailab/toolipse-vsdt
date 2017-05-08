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
import de.dailab.vsdt.FlowConditionTypes;
import de.dailab.vsdt.MultiLoopAttSet;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Loop Att Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.MultiLoopAttSetImpl#getMI_Condition <em>MI Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.MultiLoopAttSetImpl#getMI_FlowCondition <em>MI Flow Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.MultiLoopAttSetImpl#getComplexMI_FlowCondition <em>Complex MI Flow Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.MultiLoopAttSetImpl#isSequential <em>Sequential</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MultiLoopAttSetImpl extends LoopAttributeSetImpl implements MultiLoopAttSet {
	/**
	 * The cached value of the '{@link #getMI_Condition() <em>MI Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMI_Condition()
	 * @generated
	 * @ordered
	 */
	protected Expression mI_Condition;

	/**
	 * The default value of the '{@link #getMI_FlowCondition() <em>MI Flow Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMI_FlowCondition()
	 * @generated
	 * @ordered
	 */
	protected static final FlowConditionTypes MI_FLOW_CONDITION_EDEFAULT = FlowConditionTypes.NONE;

	/**
	 * The cached value of the '{@link #getMI_FlowCondition() <em>MI Flow Condition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMI_FlowCondition()
	 * @generated
	 * @ordered
	 */
	protected FlowConditionTypes mI_FlowCondition = MI_FLOW_CONDITION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComplexMI_FlowCondition() <em>Complex MI Flow Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComplexMI_FlowCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression complexMI_FlowCondition;

	/**
	 * The default value of the '{@link #isSequential() <em>Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequential()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SEQUENTIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSequential() <em>Sequential</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSequential()
	 * @generated
	 * @ordered
	 */
	protected boolean sequential = SEQUENTIAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiLoopAttSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.MULTI_LOOP_ATT_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * create expression object
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getMI_Condition() {
		return mI_Condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMI_Condition(Expression newMI_Condition, NotificationChain msgs) {
		Expression oldMI_Condition = mI_Condition;
		mI_Condition = newMI_Condition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.MULTI_LOOP_ATT_SET__MI_CONDITION, oldMI_Condition, newMI_Condition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMI_Condition(Expression newMI_Condition) {
		if (newMI_Condition != mI_Condition) {
			NotificationChain msgs = null;
			if (mI_Condition != null)
				msgs = ((InternalEObject)mI_Condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MULTI_LOOP_ATT_SET__MI_CONDITION, null, msgs);
			if (newMI_Condition != null)
				msgs = ((InternalEObject)newMI_Condition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MULTI_LOOP_ATT_SET__MI_CONDITION, null, msgs);
			msgs = basicSetMI_Condition(newMI_Condition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MULTI_LOOP_ATT_SET__MI_CONDITION, newMI_Condition, newMI_Condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowConditionTypes getMI_FlowCondition() {
		return mI_FlowCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMI_FlowCondition(FlowConditionTypes newMI_FlowCondition) {
		FlowConditionTypes oldMI_FlowCondition = mI_FlowCondition;
		mI_FlowCondition = newMI_FlowCondition == null ? MI_FLOW_CONDITION_EDEFAULT : newMI_FlowCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MULTI_LOOP_ATT_SET__MI_FLOW_CONDITION, oldMI_FlowCondition, mI_FlowCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getComplexMI_FlowCondition() {
		return complexMI_FlowCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetComplexMI_FlowCondition(Expression newComplexMI_FlowCondition, NotificationChain msgs) {
		Expression oldComplexMI_FlowCondition = complexMI_FlowCondition;
		complexMI_FlowCondition = newComplexMI_FlowCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION, oldComplexMI_FlowCondition, newComplexMI_FlowCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComplexMI_FlowCondition(Expression newComplexMI_FlowCondition) {
		if (newComplexMI_FlowCondition != complexMI_FlowCondition) {
			NotificationChain msgs = null;
			if (complexMI_FlowCondition != null)
				msgs = ((InternalEObject)complexMI_FlowCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION, null, msgs);
			if (newComplexMI_FlowCondition != null)
				msgs = ((InternalEObject)newComplexMI_FlowCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION, null, msgs);
			msgs = basicSetComplexMI_FlowCondition(newComplexMI_FlowCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION, newComplexMI_FlowCondition, newComplexMI_FlowCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSequential() {
		return sequential;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSequential(boolean newSequential) {
		boolean oldSequential = sequential;
		sequential = newSequential;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.MULTI_LOOP_ATT_SET__SEQUENTIAL, oldSequential, sequential));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.MULTI_LOOP_ATT_SET__MI_CONDITION:
				return basicSetMI_Condition(null, msgs);
			case VsdtPackage.MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION:
				return basicSetComplexMI_FlowCondition(null, msgs);
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
			case VsdtPackage.MULTI_LOOP_ATT_SET__MI_CONDITION:
				return getMI_Condition();
			case VsdtPackage.MULTI_LOOP_ATT_SET__MI_FLOW_CONDITION:
				return getMI_FlowCondition();
			case VsdtPackage.MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION:
				return getComplexMI_FlowCondition();
			case VsdtPackage.MULTI_LOOP_ATT_SET__SEQUENTIAL:
				return isSequential();
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
			case VsdtPackage.MULTI_LOOP_ATT_SET__MI_CONDITION:
				setMI_Condition((Expression)newValue);
				return;
			case VsdtPackage.MULTI_LOOP_ATT_SET__MI_FLOW_CONDITION:
				setMI_FlowCondition((FlowConditionTypes)newValue);
				return;
			case VsdtPackage.MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION:
				setComplexMI_FlowCondition((Expression)newValue);
				return;
			case VsdtPackage.MULTI_LOOP_ATT_SET__SEQUENTIAL:
				setSequential((Boolean)newValue);
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
			case VsdtPackage.MULTI_LOOP_ATT_SET__MI_CONDITION:
				setMI_Condition((Expression)null);
				return;
			case VsdtPackage.MULTI_LOOP_ATT_SET__MI_FLOW_CONDITION:
				setMI_FlowCondition(MI_FLOW_CONDITION_EDEFAULT);
				return;
			case VsdtPackage.MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION:
				setComplexMI_FlowCondition((Expression)null);
				return;
			case VsdtPackage.MULTI_LOOP_ATT_SET__SEQUENTIAL:
				setSequential(SEQUENTIAL_EDEFAULT);
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
			case VsdtPackage.MULTI_LOOP_ATT_SET__MI_CONDITION:
				return mI_Condition != null;
			case VsdtPackage.MULTI_LOOP_ATT_SET__MI_FLOW_CONDITION:
				return mI_FlowCondition != MI_FLOW_CONDITION_EDEFAULT;
			case VsdtPackage.MULTI_LOOP_ATT_SET__COMPLEX_MI_FLOW_CONDITION:
				return complexMI_FlowCondition != null;
			case VsdtPackage.MULTI_LOOP_ATT_SET__SEQUENTIAL:
				return sequential != SEQUENTIAL_EDEFAULT;
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
		result.append(" (MI_FlowCondition: ");
		result.append(mI_FlowCondition);
		result.append(", sequential: ");
		result.append(sequential);
		result.append(')');
		return result.toString();
	}

} //MultiLoopAttSetImpl
