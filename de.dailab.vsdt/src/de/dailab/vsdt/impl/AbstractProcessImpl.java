/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.AbstractProcessImpl#isAdHoc <em>Ad Hoc</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.AbstractProcessImpl#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.AbstractProcessImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractProcessImpl extends EObjectImpl implements AbstractProcess {
	/**
	 * The default value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdHoc()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AD_HOC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdHoc()
	 * @generated
	 * @ordered
	 */
	protected boolean adHoc = AD_HOC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdHocCompletionCondition() <em>Ad Hoc Completion Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdHocCompletionCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression adHocCompletionCondition;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.ABSTRACT_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAdHoc() {
		return adHoc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdHoc(boolean newAdHoc) {
		boolean oldAdHoc = adHoc;
		adHoc = newAdHoc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ABSTRACT_PROCESS__AD_HOC, oldAdHoc, adHoc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAdHocCompletionCondition() {
		return adHocCompletionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdHocCompletionCondition(Expression newAdHocCompletionCondition, NotificationChain msgs) {
		Expression oldAdHocCompletionCondition = adHocCompletionCondition;
		adHocCompletionCondition = newAdHocCompletionCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION, oldAdHocCompletionCondition, newAdHocCompletionCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdHocCompletionCondition(Expression newAdHocCompletionCondition) {
		if (newAdHocCompletionCondition != adHocCompletionCondition) {
			NotificationChain msgs = null;
			if (adHocCompletionCondition != null)
				msgs = ((InternalEObject)adHocCompletionCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION, null, msgs);
			if (newAdHocCompletionCondition != null)
				msgs = ((InternalEObject)newAdHocCompletionCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION, null, msgs);
			msgs = basicSetAdHocCompletionCondition(newAdHocCompletionCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION, newAdHocCompletionCondition, newAdHocCompletionCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, VsdtPackage.ABSTRACT_PROCESS__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * providing only an abstract implementation here, since the graphical elements
	 * are different for processes and activities
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract EList<FlowObject> getGraphicalElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION:
				return basicSetAdHocCompletionCondition(null, msgs);
			case VsdtPackage.ABSTRACT_PROCESS__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
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
			case VsdtPackage.ABSTRACT_PROCESS__AD_HOC:
				return isAdHoc();
			case VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION:
				return getAdHocCompletionCondition();
			case VsdtPackage.ABSTRACT_PROCESS__PROPERTIES:
				return getProperties();
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
			case VsdtPackage.ABSTRACT_PROCESS__AD_HOC:
				setAdHoc((Boolean)newValue);
				return;
			case VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION:
				setAdHocCompletionCondition((Expression)newValue);
				return;
			case VsdtPackage.ABSTRACT_PROCESS__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
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
			case VsdtPackage.ABSTRACT_PROCESS__AD_HOC:
				setAdHoc(AD_HOC_EDEFAULT);
				return;
			case VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION:
				setAdHocCompletionCondition((Expression)null);
				return;
			case VsdtPackage.ABSTRACT_PROCESS__PROPERTIES:
				getProperties().clear();
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
			case VsdtPackage.ABSTRACT_PROCESS__AD_HOC:
				return adHoc != AD_HOC_EDEFAULT;
			case VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION:
				return adHocCompletionCondition != null;
			case VsdtPackage.ABSTRACT_PROCESS__PROPERTIES:
				return properties != null && !properties.isEmpty();
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
		result.append(" (adHoc: ");
		result.append(adHoc);
		result.append(')');
		return result.toString();
	}

} //AbstractProcessImpl
