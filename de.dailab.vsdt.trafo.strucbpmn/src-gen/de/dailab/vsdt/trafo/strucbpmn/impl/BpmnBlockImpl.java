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
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.impl.FlowObjectImpl;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBlock;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bpmn Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBlockImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBlockImpl#getFirstGateway <em>First Gateway</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnBlockImpl#getSecondGateway <em>Second Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BpmnBlockImpl extends FlowObjectImpl implements BpmnBlock {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<BpmnBranch> elements;

	/**
	 * The cached value of the '{@link #getFirstGateway() <em>First Gateway</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstGateway()
	 * @generated
	 * @ordered
	 */
	protected Gateway firstGateway;

	/**
	 * The cached value of the '{@link #getSecondGateway() <em>Second Gateway</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondGateway()
	 * @generated
	 * @ordered
	 */
	protected Gateway secondGateway;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BpmnBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrucBpmnPackage.Literals.BPMN_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BpmnBranch> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<BpmnBranch>(BpmnBranch.class, this, StrucBpmnPackage.BPMN_BLOCK__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway getFirstGateway() {
		return firstGateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstGateway(Gateway newFirstGateway, NotificationChain msgs) {
		Gateway oldFirstGateway = firstGateway;
		firstGateway = newFirstGateway;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_BLOCK__FIRST_GATEWAY, oldFirstGateway, newFirstGateway);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstGateway(Gateway newFirstGateway) {
		if (newFirstGateway != firstGateway) {
			NotificationChain msgs = null;
			if (firstGateway != null)
				msgs = ((InternalEObject)firstGateway).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_BLOCK__FIRST_GATEWAY, null, msgs);
			if (newFirstGateway != null)
				msgs = ((InternalEObject)newFirstGateway).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_BLOCK__FIRST_GATEWAY, null, msgs);
			msgs = basicSetFirstGateway(newFirstGateway, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_BLOCK__FIRST_GATEWAY, newFirstGateway, newFirstGateway));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway getSecondGateway() {
		return secondGateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondGateway(Gateway newSecondGateway, NotificationChain msgs) {
		Gateway oldSecondGateway = secondGateway;
		secondGateway = newSecondGateway;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_BLOCK__SECOND_GATEWAY, oldSecondGateway, newSecondGateway);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondGateway(Gateway newSecondGateway) {
		if (newSecondGateway != secondGateway) {
			NotificationChain msgs = null;
			if (secondGateway != null)
				msgs = ((InternalEObject)secondGateway).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_BLOCK__SECOND_GATEWAY, null, msgs);
			if (newSecondGateway != null)
				msgs = ((InternalEObject)newSecondGateway).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_BLOCK__SECOND_GATEWAY, null, msgs);
			msgs = basicSetSecondGateway(newSecondGateway, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_BLOCK__SECOND_GATEWAY, newSecondGateway, newSecondGateway));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public FlowObject getDefaultElement() {
		for (BpmnBranch branch : getElements()) {
			if (branch.isDefault()) {
				return branch.getElement();
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrucBpmnPackage.BPMN_BLOCK__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
			case StrucBpmnPackage.BPMN_BLOCK__FIRST_GATEWAY:
				return basicSetFirstGateway(null, msgs);
			case StrucBpmnPackage.BPMN_BLOCK__SECOND_GATEWAY:
				return basicSetSecondGateway(null, msgs);
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
			case StrucBpmnPackage.BPMN_BLOCK__ELEMENTS:
				return getElements();
			case StrucBpmnPackage.BPMN_BLOCK__FIRST_GATEWAY:
				return getFirstGateway();
			case StrucBpmnPackage.BPMN_BLOCK__SECOND_GATEWAY:
				return getSecondGateway();
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
			case StrucBpmnPackage.BPMN_BLOCK__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends BpmnBranch>)newValue);
				return;
			case StrucBpmnPackage.BPMN_BLOCK__FIRST_GATEWAY:
				setFirstGateway((Gateway)newValue);
				return;
			case StrucBpmnPackage.BPMN_BLOCK__SECOND_GATEWAY:
				setSecondGateway((Gateway)newValue);
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
			case StrucBpmnPackage.BPMN_BLOCK__ELEMENTS:
				getElements().clear();
				return;
			case StrucBpmnPackage.BPMN_BLOCK__FIRST_GATEWAY:
				setFirstGateway((Gateway)null);
				return;
			case StrucBpmnPackage.BPMN_BLOCK__SECOND_GATEWAY:
				setSecondGateway((Gateway)null);
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
			case StrucBpmnPackage.BPMN_BLOCK__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case StrucBpmnPackage.BPMN_BLOCK__FIRST_GATEWAY:
				return firstGateway != null;
			case StrucBpmnPackage.BPMN_BLOCK__SECOND_GATEWAY:
				return secondGateway != null;
		}
		return super.eIsSet(featureID);
	}

} //BpmnBlockImpl
