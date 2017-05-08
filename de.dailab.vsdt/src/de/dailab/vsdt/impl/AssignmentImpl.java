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
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.dailab.vsdt.AssignTimeType;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.AssignmentImpl#getTo <em>To</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.AssignmentImpl#getFrom <em>From</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.AssignmentImpl#getAssignTime <em>Assign Time</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.AssignmentImpl#getToQuery <em>To Query</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignmentImpl extends EObjectImpl implements Assignment {
	/**
	 * The cached value of the '{@link #getTo() <em>To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTo()
	 * @generated
	 * @ordered
	 */
	protected Property to;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected Expression from;

	/**
	 * The default value of the '{@link #getAssignTime() <em>Assign Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignTime()
	 * @generated
	 * @ordered
	 */
	protected static final AssignTimeType ASSIGN_TIME_EDEFAULT = AssignTimeType.START;

	/**
	 * The cached value of the '{@link #getAssignTime() <em>Assign Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignTime()
	 * @generated
	 * @ordered
	 */
	protected AssignTimeType assignTime = ASSIGN_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getToQuery() <em>To Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String TO_QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getToQuery() <em>To Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToQuery()
	 * @generated
	 * @ordered
	 */
	protected String toQuery = TO_QUERY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getTo() {
		return to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTo(Property newTo) {
		Property oldTo = to;
		to = newTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ASSIGNMENT__TO, oldTo, to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * initialize expression object
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Expression getFrom() {
		if (from == null) {
			from= VsdtFactory.eINSTANCE.createExpression();
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFrom(Expression newFrom, NotificationChain msgs) {
		Expression oldFrom = from;
		from = newFrom;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.ASSIGNMENT__FROM, oldFrom, newFrom);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrom(Expression newFrom) {
		if (newFrom != from) {
			NotificationChain msgs = null;
			if (from != null)
				msgs = ((InternalEObject)from).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.ASSIGNMENT__FROM, null, msgs);
			if (newFrom != null)
				msgs = ((InternalEObject)newFrom).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.ASSIGNMENT__FROM, null, msgs);
			msgs = basicSetFrom(newFrom, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ASSIGNMENT__FROM, newFrom, newFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignTimeType getAssignTime() {
		return assignTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignTime(AssignTimeType newAssignTime) {
		AssignTimeType oldAssignTime = assignTime;
		assignTime = newAssignTime == null ? ASSIGN_TIME_EDEFAULT : newAssignTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ASSIGNMENT__ASSIGN_TIME, oldAssignTime, assignTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getToQuery() {
		return toQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToQuery(String newToQuery) {
		String oldToQuery = toQuery;
		toQuery = newToQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ASSIGNMENT__TO_QUERY, oldToQuery, toQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.ASSIGNMENT__FROM:
				return basicSetFrom(null, msgs);
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
			case VsdtPackage.ASSIGNMENT__TO:
				return getTo();
			case VsdtPackage.ASSIGNMENT__FROM:
				return getFrom();
			case VsdtPackage.ASSIGNMENT__ASSIGN_TIME:
				return getAssignTime();
			case VsdtPackage.ASSIGNMENT__TO_QUERY:
				return getToQuery();
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
			case VsdtPackage.ASSIGNMENT__TO:
				setTo((Property)newValue);
				return;
			case VsdtPackage.ASSIGNMENT__FROM:
				setFrom((Expression)newValue);
				return;
			case VsdtPackage.ASSIGNMENT__ASSIGN_TIME:
				setAssignTime((AssignTimeType)newValue);
				return;
			case VsdtPackage.ASSIGNMENT__TO_QUERY:
				setToQuery((String)newValue);
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
			case VsdtPackage.ASSIGNMENT__TO:
				setTo((Property)null);
				return;
			case VsdtPackage.ASSIGNMENT__FROM:
				setFrom((Expression)null);
				return;
			case VsdtPackage.ASSIGNMENT__ASSIGN_TIME:
				setAssignTime(ASSIGN_TIME_EDEFAULT);
				return;
			case VsdtPackage.ASSIGNMENT__TO_QUERY:
				setToQuery(TO_QUERY_EDEFAULT);
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
			case VsdtPackage.ASSIGNMENT__TO:
				return to != null;
			case VsdtPackage.ASSIGNMENT__FROM:
				return from != null;
			case VsdtPackage.ASSIGNMENT__ASSIGN_TIME:
				return assignTime != ASSIGN_TIME_EDEFAULT;
			case VsdtPackage.ASSIGNMENT__TO_QUERY:
				return TO_QUERY_EDEFAULT == null ? toQuery != null : !TO_QUERY_EDEFAULT.equals(toQuery);
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
		result.append(" (assignTime: ");
		result.append(assignTime);
		result.append(", toQuery: ");
		result.append(toQuery);
		result.append(')');
		return result.toString();
	}

} //AssignmentImpl
