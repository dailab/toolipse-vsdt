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
import de.dailab.vsdt.impl.FlowObjectImpl;
import de.dailab.vsdt.trafo.strucbpmn.BpmnElementToSkip;
import de.dailab.vsdt.trafo.strucbpmn.BpmnEventHandlerCase;
import de.dailab.vsdt.trafo.strucbpmn.StrucBpmnPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bpmn Element To Skip</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnElementToSkipImpl#getElement <em>Element</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnElementToSkipImpl#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.trafo.strucbpmn.impl.BpmnElementToSkipImpl#getEventHandlerCase <em>Event Handler Case</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BpmnElementToSkipImpl extends FlowObjectImpl implements BpmnElementToSkip {
	/**
	 * The cached value of the '{@link #getElement() <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement()
	 * @generated
	 * @ordered
	 */
	protected FlowObject element;

	/**
	 * The default value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected static final String VARIABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVariableName() <em>Variable Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableName()
	 * @generated
	 * @ordered
	 */
	protected String variableName = VARIABLE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEventHandlerCase() <em>Event Handler Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventHandlerCase()
	 * @generated
	 * @ordered
	 */
	protected BpmnEventHandlerCase eventHandlerCase;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BpmnElementToSkipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StrucBpmnPackage.Literals.BPMN_ELEMENT_TO_SKIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowObject getElement() {
		return element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElement(FlowObject newElement, NotificationChain msgs) {
		FlowObject oldElement = element;
		element = newElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__ELEMENT, oldElement, newElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElement(FlowObject newElement) {
		if (newElement != element) {
			NotificationChain msgs = null;
			if (element != null)
				msgs = ((InternalEObject)element).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__ELEMENT, null, msgs);
			if (newElement != null)
				msgs = ((InternalEObject)newElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__ELEMENT, null, msgs);
			msgs = basicSetElement(newElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__ELEMENT, newElement, newElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVariableName() {
		return variableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableName(String newVariableName) {
		String oldVariableName = variableName;
		variableName = newVariableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__VARIABLE_NAME, oldVariableName, variableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnEventHandlerCase getEventHandlerCase() {
		if (eventHandlerCase != null && eventHandlerCase.eIsProxy()) {
			InternalEObject oldEventHandlerCase = (InternalEObject)eventHandlerCase;
			eventHandlerCase = (BpmnEventHandlerCase)eResolveProxy(oldEventHandlerCase);
			if (eventHandlerCase != oldEventHandlerCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE, oldEventHandlerCase, eventHandlerCase));
			}
		}
		return eventHandlerCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnEventHandlerCase basicGetEventHandlerCase() {
		return eventHandlerCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventHandlerCase(BpmnEventHandlerCase newEventHandlerCase, NotificationChain msgs) {
		BpmnEventHandlerCase oldEventHandlerCase = eventHandlerCase;
		eventHandlerCase = newEventHandlerCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE, oldEventHandlerCase, newEventHandlerCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEventHandlerCase(BpmnEventHandlerCase newEventHandlerCase) {
		if (newEventHandlerCase != eventHandlerCase) {
			NotificationChain msgs = null;
			if (eventHandlerCase != null)
				msgs = ((InternalEObject)eventHandlerCase).eInverseRemove(this, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP, BpmnEventHandlerCase.class, msgs);
			if (newEventHandlerCase != null)
				msgs = ((InternalEObject)newEventHandlerCase).eInverseAdd(this, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP, BpmnEventHandlerCase.class, msgs);
			msgs = basicSetEventHandlerCase(newEventHandlerCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE, newEventHandlerCase, newEventHandlerCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE:
				if (eventHandlerCase != null)
					msgs = ((InternalEObject)eventHandlerCase).eInverseRemove(this, StrucBpmnPackage.BPMN_EVENT_HANDLER_CASE__ELEMENT_TO_SKIP, BpmnEventHandlerCase.class, msgs);
				return basicSetEventHandlerCase((BpmnEventHandlerCase)otherEnd, msgs);
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
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__ELEMENT:
				return basicSetElement(null, msgs);
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE:
				return basicSetEventHandlerCase(null, msgs);
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
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__ELEMENT:
				return getElement();
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__VARIABLE_NAME:
				return getVariableName();
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE:
				if (resolve) return getEventHandlerCase();
				return basicGetEventHandlerCase();
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
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__ELEMENT:
				setElement((FlowObject)newValue);
				return;
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__VARIABLE_NAME:
				setVariableName((String)newValue);
				return;
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE:
				setEventHandlerCase((BpmnEventHandlerCase)newValue);
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
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__ELEMENT:
				setElement((FlowObject)null);
				return;
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__VARIABLE_NAME:
				setVariableName(VARIABLE_NAME_EDEFAULT);
				return;
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE:
				setEventHandlerCase((BpmnEventHandlerCase)null);
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
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__ELEMENT:
				return element != null;
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__VARIABLE_NAME:
				return VARIABLE_NAME_EDEFAULT == null ? variableName != null : !VARIABLE_NAME_EDEFAULT.equals(variableName);
			case StrucBpmnPackage.BPMN_ELEMENT_TO_SKIP__EVENT_HANDLER_CASE:
				return eventHandlerCase != null;
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
		result.append(" (variableName: ");
		result.append(variableName);
		result.append(')');
		return result.toString();
	}

} //BpmnElementToSkipImpl
