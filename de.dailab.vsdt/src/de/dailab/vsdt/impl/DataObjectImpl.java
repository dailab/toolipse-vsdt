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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.DataObject;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.DataObjectImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.DataObjectImpl#isRequiredForStart <em>Required For Start</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.DataObjectImpl#isProducedAtCompletion <em>Produced At Completion</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.DataObjectImpl#getState <em>State</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataObjectImpl extends ArtifactImpl implements DataObject {
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
	 * The default value of the '{@link #isRequiredForStart() <em>Required For Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequiredForStart()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_FOR_START_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isRequiredForStart() <em>Required For Start</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRequiredForStart()
	 * @generated
	 * @ordered
	 */
	protected boolean requiredForStart = REQUIRED_FOR_START_EDEFAULT;

	/**
	 * The default value of the '{@link #isProducedAtCompletion() <em>Produced At Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProducedAtCompletion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PRODUCED_AT_COMPLETION_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isProducedAtCompletion() <em>Produced At Completion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isProducedAtCompletion()
	 * @generated
	 * @ordered
	 */
	protected boolean producedAtCompletion = PRODUCED_AT_COMPLETION_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final String STATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected String state = STATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.DATA_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, VsdtPackage.DATA_OBJECT__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRequiredForStart() {
		return requiredForStart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredForStart(boolean newRequiredForStart) {
		boolean oldRequiredForStart = requiredForStart;
		requiredForStart = newRequiredForStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.DATA_OBJECT__REQUIRED_FOR_START, oldRequiredForStart, requiredForStart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isProducedAtCompletion() {
		return producedAtCompletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProducedAtCompletion(boolean newProducedAtCompletion) {
		boolean oldProducedAtCompletion = producedAtCompletion;
		producedAtCompletion = newProducedAtCompletion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.DATA_OBJECT__PRODUCED_AT_COMPLETION, oldProducedAtCompletion, producedAtCompletion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(String newState) {
		String oldState = state;
		state = newState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.DATA_OBJECT__STATE, oldState, state));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.DATA_OBJECT__PROPERTIES:
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
			case VsdtPackage.DATA_OBJECT__PROPERTIES:
				return getProperties();
			case VsdtPackage.DATA_OBJECT__REQUIRED_FOR_START:
				return isRequiredForStart();
			case VsdtPackage.DATA_OBJECT__PRODUCED_AT_COMPLETION:
				return isProducedAtCompletion();
			case VsdtPackage.DATA_OBJECT__STATE:
				return getState();
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
			case VsdtPackage.DATA_OBJECT__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case VsdtPackage.DATA_OBJECT__REQUIRED_FOR_START:
				setRequiredForStart((Boolean)newValue);
				return;
			case VsdtPackage.DATA_OBJECT__PRODUCED_AT_COMPLETION:
				setProducedAtCompletion((Boolean)newValue);
				return;
			case VsdtPackage.DATA_OBJECT__STATE:
				setState((String)newValue);
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
			case VsdtPackage.DATA_OBJECT__PROPERTIES:
				getProperties().clear();
				return;
			case VsdtPackage.DATA_OBJECT__REQUIRED_FOR_START:
				setRequiredForStart(REQUIRED_FOR_START_EDEFAULT);
				return;
			case VsdtPackage.DATA_OBJECT__PRODUCED_AT_COMPLETION:
				setProducedAtCompletion(PRODUCED_AT_COMPLETION_EDEFAULT);
				return;
			case VsdtPackage.DATA_OBJECT__STATE:
				setState(STATE_EDEFAULT);
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
			case VsdtPackage.DATA_OBJECT__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case VsdtPackage.DATA_OBJECT__REQUIRED_FOR_START:
				return requiredForStart != REQUIRED_FOR_START_EDEFAULT;
			case VsdtPackage.DATA_OBJECT__PRODUCED_AT_COMPLETION:
				return producedAtCompletion != PRODUCED_AT_COMPLETION_EDEFAULT;
			case VsdtPackage.DATA_OBJECT__STATE:
				return STATE_EDEFAULT == null ? state != null : !STATE_EDEFAULT.equals(state);
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
		result.append(" (requiredForStart: ");
		result.append(requiredForStart);
		result.append(", producedAtCompletion: ");
		result.append(producedAtCompletion);
		result.append(", state: ");
		result.append(state);
		result.append(')');
		return result.toString();
	}

} //DataObjectImpl
