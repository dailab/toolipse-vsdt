/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.impl.FlowObjectImpl;
import de.dailab.vsdt.trafo.strucbpmn.BpmnSequence;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bpmn Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnSequenceImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnSequenceImpl#isNeedsToPersist <em>Needs To Persist</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BpmnSequenceImpl extends FlowObjectImpl implements BpmnSequence {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<FlowObject> elements;

	/**
	 * The default value of the '{@link #isNeedsToPersist() <em>Needs To Persist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedsToPersist()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NEEDS_TO_PERSIST_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isNeedsToPersist() <em>Needs To Persist</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNeedsToPersist()
	 * @generated
	 * @ordered
	 */
	protected boolean needsToPersist = NEEDS_TO_PERSIST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BpmnSequenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrucBpmnPackage.Literals.BPMN_SEQUENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FlowObject> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<FlowObject>(FlowObject.class, this, StrucBpmnPackage.BPMN_SEQUENCE__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNeedsToPersist() {
		return needsToPersist;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeedsToPersist(boolean newNeedsToPersist) {
		boolean oldNeedsToPersist = needsToPersist;
		needsToPersist = newNeedsToPersist;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_SEQUENCE__NEEDS_TO_PERSIST, oldNeedsToPersist, needsToPersist));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrucBpmnPackage.BPMN_SEQUENCE__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case StrucBpmnPackage.BPMN_SEQUENCE__ELEMENTS:
				return getElements();
			case StrucBpmnPackage.BPMN_SEQUENCE__NEEDS_TO_PERSIST:
				return isNeedsToPersist();
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
			case StrucBpmnPackage.BPMN_SEQUENCE__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends FlowObject>)newValue);
				return;
			case StrucBpmnPackage.BPMN_SEQUENCE__NEEDS_TO_PERSIST:
				setNeedsToPersist((Boolean)newValue);
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
			case StrucBpmnPackage.BPMN_SEQUENCE__ELEMENTS:
				getElements().clear();
				return;
			case StrucBpmnPackage.BPMN_SEQUENCE__NEEDS_TO_PERSIST:
				setNeedsToPersist(NEEDS_TO_PERSIST_EDEFAULT);
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
			case StrucBpmnPackage.BPMN_SEQUENCE__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case StrucBpmnPackage.BPMN_SEQUENCE__NEEDS_TO_PERSIST:
				return needsToPersist != NEEDS_TO_PERSIST_EDEFAULT;
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
		result.append(" (needsToPersist: ");
		result.append(needsToPersist);
		result.append(')');
		return result.toString();
	}

} //BpmnSequenceImpl
