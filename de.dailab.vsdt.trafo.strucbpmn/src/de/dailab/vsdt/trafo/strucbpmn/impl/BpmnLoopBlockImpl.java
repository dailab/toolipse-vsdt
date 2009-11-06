/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.trafo.strucbpmn.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.impl.FlowObjectImpl;
import de.dailab.vsdt.trafo.strucbpmn.BpmnBranch;
import de.dailab.vsdt.trafo.strucbpmn.BpmnLoopBlock;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bpmn Loop Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnLoopBlockImpl#getFirstBranch <em>First Branch</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnLoopBlockImpl#getSecondBranch <em>Second Branch</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnLoopBlockImpl#getExitBranch <em>Exit Branch</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnLoopBlockImpl#getFirstGateway <em>First Gateway</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnLoopBlockImpl#getSecondGateway <em>Second Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BpmnLoopBlockImpl extends FlowObjectImpl implements BpmnLoopBlock {
	/**
	 * The cached value of the '{@link #getFirstBranch() <em>First Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstBranch()
	 * @generated
	 * @ordered
	 */
	protected BpmnBranch firstBranch;

	/**
	 * The cached value of the '{@link #getSecondBranch() <em>Second Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondBranch()
	 * @generated
	 * @ordered
	 */
	protected BpmnBranch secondBranch;

	/**
	 * The cached value of the '{@link #getExitBranch() <em>Exit Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExitBranch()
	 * @generated
	 * @ordered
	 */
	protected BpmnBranch exitBranch;

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
	protected BpmnLoopBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrucBpmnPackage.Literals.BPMN_LOOP_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnBranch getFirstBranch() {
		return firstBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstBranch(BpmnBranch newFirstBranch, NotificationChain msgs) {
		BpmnBranch oldFirstBranch = firstBranch;
		firstBranch = newFirstBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_BRANCH, oldFirstBranch, newFirstBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstBranch(BpmnBranch newFirstBranch) {
		if (newFirstBranch != firstBranch) {
			NotificationChain msgs = null;
			if (firstBranch != null)
				msgs = ((InternalEObject)firstBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_BRANCH, null, msgs);
			if (newFirstBranch != null)
				msgs = ((InternalEObject)newFirstBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_BRANCH, null, msgs);
			msgs = basicSetFirstBranch(newFirstBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_BRANCH, newFirstBranch, newFirstBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnBranch getSecondBranch() {
		return secondBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondBranch(BpmnBranch newSecondBranch, NotificationChain msgs) {
		BpmnBranch oldSecondBranch = secondBranch;
		secondBranch = newSecondBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_BRANCH, oldSecondBranch, newSecondBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondBranch(BpmnBranch newSecondBranch) {
		if (newSecondBranch != secondBranch) {
			NotificationChain msgs = null;
			if (secondBranch != null)
				msgs = ((InternalEObject)secondBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_BRANCH, null, msgs);
			if (newSecondBranch != null)
				msgs = ((InternalEObject)newSecondBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_BRANCH, null, msgs);
			msgs = basicSetSecondBranch(newSecondBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_BRANCH, newSecondBranch, newSecondBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnBranch getExitBranch() {
		return exitBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExitBranch(BpmnBranch newExitBranch, NotificationChain msgs) {
		BpmnBranch oldExitBranch = exitBranch;
		exitBranch = newExitBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__EXIT_BRANCH, oldExitBranch, newExitBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExitBranch(BpmnBranch newExitBranch) {
		if (newExitBranch != exitBranch) {
			NotificationChain msgs = null;
			if (exitBranch != null)
				msgs = ((InternalEObject)exitBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__EXIT_BRANCH, null, msgs);
			if (newExitBranch != null)
				msgs = ((InternalEObject)newExitBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__EXIT_BRANCH, null, msgs);
			msgs = basicSetExitBranch(newExitBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__EXIT_BRANCH, newExitBranch, newExitBranch));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_GATEWAY, oldFirstGateway, newFirstGateway);
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
				msgs = ((InternalEObject)firstGateway).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_GATEWAY, null, msgs);
			if (newFirstGateway != null)
				msgs = ((InternalEObject)newFirstGateway).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_GATEWAY, null, msgs);
			msgs = basicSetFirstGateway(newFirstGateway, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_GATEWAY, newFirstGateway, newFirstGateway));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_GATEWAY, oldSecondGateway, newSecondGateway);
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
				msgs = ((InternalEObject)secondGateway).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_GATEWAY, null, msgs);
			if (newSecondGateway != null)
				msgs = ((InternalEObject)newSecondGateway).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_GATEWAY, null, msgs);
			msgs = basicSetSecondGateway(newSecondGateway, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_GATEWAY, newSecondGateway, newSecondGateway));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_BRANCH:
				return basicSetFirstBranch(null, msgs);
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_BRANCH:
				return basicSetSecondBranch(null, msgs);
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__EXIT_BRANCH:
				return basicSetExitBranch(null, msgs);
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_GATEWAY:
				return basicSetFirstGateway(null, msgs);
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_GATEWAY:
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
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_BRANCH:
				return getFirstBranch();
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_BRANCH:
				return getSecondBranch();
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__EXIT_BRANCH:
				return getExitBranch();
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_GATEWAY:
				return getFirstGateway();
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_GATEWAY:
				return getSecondGateway();
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
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_BRANCH:
				setFirstBranch((BpmnBranch)newValue);
				return;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_BRANCH:
				setSecondBranch((BpmnBranch)newValue);
				return;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__EXIT_BRANCH:
				setExitBranch((BpmnBranch)newValue);
				return;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_GATEWAY:
				setFirstGateway((Gateway)newValue);
				return;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_GATEWAY:
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
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_BRANCH:
				setFirstBranch((BpmnBranch)null);
				return;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_BRANCH:
				setSecondBranch((BpmnBranch)null);
				return;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__EXIT_BRANCH:
				setExitBranch((BpmnBranch)null);
				return;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_GATEWAY:
				setFirstGateway((Gateway)null);
				return;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_GATEWAY:
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
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_BRANCH:
				return firstBranch != null;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_BRANCH:
				return secondBranch != null;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__EXIT_BRANCH:
				return exitBranch != null;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__FIRST_GATEWAY:
				return firstGateway != null;
			case StrucBpmnPackage.BPMN_LOOP_BLOCK__SECOND_GATEWAY:
				return secondGateway != null;
		}
		return super.eIsSet(featureID);
	}

} //BpmnLoopBlockImpl
