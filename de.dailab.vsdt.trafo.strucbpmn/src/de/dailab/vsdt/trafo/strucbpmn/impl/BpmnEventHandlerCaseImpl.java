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

import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Gateway;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.impl.FlowObjectImpl;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bpmn Event Handler Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerCaseImpl#getIntermediate <em>Intermediate</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerCaseImpl#getCompensationElement <em>Compensation Element</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerCaseImpl#getElementToSkip <em>Element To Skip</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnEventHandlerCaseImpl#getGateway <em>Gateway</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BpmnEventHandlerCaseImpl extends FlowObjectImpl implements BpmnEventHandlerCase {
	/**
	 * The cached value of the '{@link #getIntermediate() <em>Intermediate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntermediate()
	 * @generated
	 * @ordered
	 */
	protected Intermediate intermediate;

	/**
	 * The cached value of the '{@link #getCompensationElement() <em>Compensation Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompensationElement()
	 * @generated
	 * @ordered
	 */
	protected FlowObject compensationElement;

	/**
	 * The cached value of the '{@link #getElementToSkip() <em>Element To Skip</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementToSkip()
	 * @generated
	 * @ordered
	 */
	protected BpmnElementToSkip elementToSkip;

	/**
	 * The cached value of the '{@link #getGateway() <em>Gateway</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGateway()
	 * @generated
	 * @ordered
	 */
	protected Gateway gateway;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BpmnEventHandlerCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrucBpmnPackage.Literals.BPMN_EVENT_HANDLER_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intermediate getIntermediate() {
		return intermediate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIntermediate(Intermediate newIntermediate, NotificationChain msgs) {
		Intermediate oldIntermediate = intermediate;
		intermediate = newIntermediate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__INTERMEDIATE, oldIntermediate, newIntermediate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntermediate(Intermediate newIntermediate) {
		if (newIntermediate != intermediate) {
			NotificationChain msgs = null;
			if (intermediate != null)
				msgs = ((InternalEObject)intermediate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__INTERMEDIATE, null, msgs);
			if (newIntermediate != null)
				msgs = ((InternalEObject)newIntermediate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__INTERMEDIATE, null, msgs);
			msgs = basicSetIntermediate(newIntermediate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__INTERMEDIATE, newIntermediate, newIntermediate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowObject getCompensationElement() {
		return compensationElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCompensationElement(FlowObject newCompensationElement, NotificationChain msgs) {
		FlowObject oldCompensationElement = compensationElement;
		compensationElement = newCompensationElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT, oldCompensationElement, newCompensationElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCompensationElement(FlowObject newCompensationElement) {
		if (newCompensationElement != compensationElement) {
			NotificationChain msgs = null;
			if (compensationElement != null)
				msgs = ((InternalEObject)compensationElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT, null, msgs);
			if (newCompensationElement != null)
				msgs = ((InternalEObject)newCompensationElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT, null, msgs);
			msgs = basicSetCompensationElement(newCompensationElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT, newCompensationElement, newCompensationElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnElementToSkip getElementToSkip() {
		if (elementToSkip != null && elementToSkip.eIsProxy()) {
			InternalEObject oldElementToSkip = (InternalEObject)elementToSkip;
			elementToSkip = (BpmnElementToSkip)eResolveProxy(oldElementToSkip);
			if (elementToSkip != oldElementToSkip) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP, oldElementToSkip, elementToSkip));
			}
		}
		return elementToSkip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnElementToSkip basicGetElementToSkip() {
		return elementToSkip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElementToSkip(BpmnElementToSkip newElementToSkip, NotificationChain msgs) {
		BpmnElementToSkip oldElementToSkip = elementToSkip;
		elementToSkip = newElementToSkip;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP, oldElementToSkip, newElementToSkip);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementToSkip(BpmnElementToSkip newElementToSkip) {
		if (newElementToSkip != elementToSkip) {
			NotificationChain msgs = null;
			if (elementToSkip != null)
				msgs = ((InternalEObject)elementToSkip).eInverseRemove(this, StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE, BpmnElementToSkip.class, msgs);
			if (newElementToSkip != null)
				msgs = ((InternalEObject)newElementToSkip).eInverseAdd(this, StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE, BpmnElementToSkip.class, msgs);
			msgs = basicSetElementToSkip(newElementToSkip, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP, newElementToSkip, newElementToSkip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway getGateway() {
		if (gateway != null && gateway.eIsProxy()) {
			InternalEObject oldGateway = (InternalEObject)gateway;
			gateway = (Gateway)eResolveProxy(oldGateway);
			if (gateway != oldGateway) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__GATEWAY, oldGateway, gateway));
			}
		}
		return gateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gateway basicGetGateway() {
		return gateway;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGateway(Gateway newGateway) {
		Gateway oldGateway = gateway;
		gateway = newGateway;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__GATEWAY, oldGateway, gateway));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP:
				if (elementToSkip != null)
					msgs = ((InternalEObject)elementToSkip).eInverseRemove(this, StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE, BpmnElementToSkip.class, msgs);
				return basicSetElementToSkip((BpmnElementToSkip)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__INTERMEDIATE:
				return basicSetIntermediate(null, msgs);
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT:
				return basicSetCompensationElement(null, msgs);
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP:
				return basicSetElementToSkip(null, msgs);
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
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__INTERMEDIATE:
				return getIntermediate();
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT:
				return getCompensationElement();
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP:
				if (resolve) return getElementToSkip();
				return basicGetElementToSkip();
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__GATEWAY:
				if (resolve) return getGateway();
				return basicGetGateway();
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
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__INTERMEDIATE:
				setIntermediate((Intermediate)newValue);
				return;
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT:
				setCompensationElement((FlowObject)newValue);
				return;
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP:
				setElementToSkip((BpmnElementToSkip)newValue);
				return;
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__GATEWAY:
				setGateway((Gateway)newValue);
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
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__INTERMEDIATE:
				setIntermediate((Intermediate)null);
				return;
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT:
				setCompensationElement((FlowObject)null);
				return;
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP:
				setElementToSkip((BpmnElementToSkip)null);
				return;
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__GATEWAY:
				setGateway((Gateway)null);
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
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__INTERMEDIATE:
				return intermediate != null;
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__COMPENSATION_ELEMENT:
				return compensationElement != null;
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP:
				return elementToSkip != null;
			case StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__GATEWAY:
				return gateway != null;
		}
		return super.eIsSet(featureID);
	}

} //BpmnEventHandlerCaseImpl
