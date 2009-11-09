/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.xmlsoap.schemas.wsdl.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.xmlsoap.schemas.wsdl.TFault;
import org.xmlsoap.schemas.wsdl.TOperation;
import org.xmlsoap.schemas.wsdl.TParam;
import org.xmlsoap.schemas.wsdl.WsdlPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TOperation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl#getInput <em>Input</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl#getFault <em>Fault</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl#getOutput1 <em>Output1</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl#getInput1 <em>Input1</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl#getFault1 <em>Fault1</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.xmlsoap.schemas.wsdl.impl.TOperationImpl#getParameterOrder <em>Parameter Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TOperationImpl extends TExtensibleDocumentedImpl implements TOperation {
	/**
	 * The cached value of the '{@link #getInput() <em>Input</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput()
	 * @generated
	 * @ordered
	 */
	protected TParam input;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected TParam output;

	/**
	 * The cached value of the '{@link #getFault() <em>Fault</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFault()
	 * @generated
	 * @ordered
	 */
	protected EList<TFault> fault;

	/**
	 * The cached value of the '{@link #getOutput1() <em>Output1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput1()
	 * @generated
	 * @ordered
	 */
	protected TParam output1;

	/**
	 * The cached value of the '{@link #getInput1() <em>Input1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInput1()
	 * @generated
	 * @ordered
	 */
	protected TParam input1;

	/**
	 * The cached value of the '{@link #getFault1() <em>Fault1</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFault1()
	 * @generated
	 * @ordered
	 */
	protected EList<TFault> fault1;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getParameterOrder() <em>Parameter Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterOrder()
	 * @generated
	 * @ordered
	 */
	protected static final List<String> PARAMETER_ORDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterOrder() <em>Parameter Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterOrder()
	 * @generated
	 * @ordered
	 */
	protected List<String> parameterOrder = PARAMETER_ORDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WsdlPackage.Literals.TOPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TParam getInput() {
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput(TParam newInput, NotificationChain msgs) {
		TParam oldInput = input;
		input = newInput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__INPUT, oldInput, newInput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput(TParam newInput) {
		if (newInput != input) {
			NotificationChain msgs = null;
			if (input != null)
				msgs = ((InternalEObject)input).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WsdlPackage.TOPERATION__INPUT, null, msgs);
			if (newInput != null)
				msgs = ((InternalEObject)newInput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WsdlPackage.TOPERATION__INPUT, null, msgs);
			msgs = basicSetInput(newInput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__INPUT, newInput, newInput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TParam getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput(TParam newOutput, NotificationChain msgs) {
		TParam oldOutput = output;
		output = newOutput;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__OUTPUT, oldOutput, newOutput);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(TParam newOutput) {
		if (newOutput != output) {
			NotificationChain msgs = null;
			if (output != null)
				msgs = ((InternalEObject)output).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WsdlPackage.TOPERATION__OUTPUT, null, msgs);
			if (newOutput != null)
				msgs = ((InternalEObject)newOutput).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WsdlPackage.TOPERATION__OUTPUT, null, msgs);
			msgs = basicSetOutput(newOutput, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__OUTPUT, newOutput, newOutput));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TFault> getFault() {
		if (fault == null) {
			fault = new EObjectContainmentEList<TFault>(TFault.class, this, WsdlPackage.TOPERATION__FAULT);
		}
		return fault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TParam getOutput1() {
		return output1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOutput1(TParam newOutput1, NotificationChain msgs) {
		TParam oldOutput1 = output1;
		output1 = newOutput1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__OUTPUT1, oldOutput1, newOutput1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput1(TParam newOutput1) {
		if (newOutput1 != output1) {
			NotificationChain msgs = null;
			if (output1 != null)
				msgs = ((InternalEObject)output1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WsdlPackage.TOPERATION__OUTPUT1, null, msgs);
			if (newOutput1 != null)
				msgs = ((InternalEObject)newOutput1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WsdlPackage.TOPERATION__OUTPUT1, null, msgs);
			msgs = basicSetOutput1(newOutput1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__OUTPUT1, newOutput1, newOutput1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TParam getInput1() {
		return input1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInput1(TParam newInput1, NotificationChain msgs) {
		TParam oldInput1 = input1;
		input1 = newInput1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__INPUT1, oldInput1, newInput1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInput1(TParam newInput1) {
		if (newInput1 != input1) {
			NotificationChain msgs = null;
			if (input1 != null)
				msgs = ((InternalEObject)input1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WsdlPackage.TOPERATION__INPUT1, null, msgs);
			if (newInput1 != null)
				msgs = ((InternalEObject)newInput1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WsdlPackage.TOPERATION__INPUT1, null, msgs);
			msgs = basicSetInput1(newInput1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__INPUT1, newInput1, newInput1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TFault> getFault1() {
		if (fault1 == null) {
			fault1 = new EObjectContainmentEList<TFault>(TFault.class, this, WsdlPackage.TOPERATION__FAULT1);
		}
		return fault1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List<String> getParameterOrder() {
		return parameterOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterOrder(List<String> newParameterOrder) {
		List<String> oldParameterOrder = parameterOrder;
		parameterOrder = newParameterOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WsdlPackage.TOPERATION__PARAMETER_ORDER, oldParameterOrder, parameterOrder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WsdlPackage.TOPERATION__INPUT:
				return basicSetInput(null, msgs);
			case WsdlPackage.TOPERATION__OUTPUT:
				return basicSetOutput(null, msgs);
			case WsdlPackage.TOPERATION__FAULT:
				return ((InternalEList<?>)getFault()).basicRemove(otherEnd, msgs);
			case WsdlPackage.TOPERATION__OUTPUT1:
				return basicSetOutput1(null, msgs);
			case WsdlPackage.TOPERATION__INPUT1:
				return basicSetInput1(null, msgs);
			case WsdlPackage.TOPERATION__FAULT1:
				return ((InternalEList<?>)getFault1()).basicRemove(otherEnd, msgs);
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
			case WsdlPackage.TOPERATION__INPUT:
				return getInput();
			case WsdlPackage.TOPERATION__OUTPUT:
				return getOutput();
			case WsdlPackage.TOPERATION__FAULT:
				return getFault();
			case WsdlPackage.TOPERATION__OUTPUT1:
				return getOutput1();
			case WsdlPackage.TOPERATION__INPUT1:
				return getInput1();
			case WsdlPackage.TOPERATION__FAULT1:
				return getFault1();
			case WsdlPackage.TOPERATION__NAME:
				return getName();
			case WsdlPackage.TOPERATION__PARAMETER_ORDER:
				return getParameterOrder();
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
			case WsdlPackage.TOPERATION__INPUT:
				setInput((TParam)newValue);
				return;
			case WsdlPackage.TOPERATION__OUTPUT:
				setOutput((TParam)newValue);
				return;
			case WsdlPackage.TOPERATION__FAULT:
				getFault().clear();
				getFault().addAll((Collection<? extends TFault>)newValue);
				return;
			case WsdlPackage.TOPERATION__OUTPUT1:
				setOutput1((TParam)newValue);
				return;
			case WsdlPackage.TOPERATION__INPUT1:
				setInput1((TParam)newValue);
				return;
			case WsdlPackage.TOPERATION__FAULT1:
				getFault1().clear();
				getFault1().addAll((Collection<? extends TFault>)newValue);
				return;
			case WsdlPackage.TOPERATION__NAME:
				setName((String)newValue);
				return;
			case WsdlPackage.TOPERATION__PARAMETER_ORDER:
				setParameterOrder((List<String>)newValue);
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
			case WsdlPackage.TOPERATION__INPUT:
				setInput((TParam)null);
				return;
			case WsdlPackage.TOPERATION__OUTPUT:
				setOutput((TParam)null);
				return;
			case WsdlPackage.TOPERATION__FAULT:
				getFault().clear();
				return;
			case WsdlPackage.TOPERATION__OUTPUT1:
				setOutput1((TParam)null);
				return;
			case WsdlPackage.TOPERATION__INPUT1:
				setInput1((TParam)null);
				return;
			case WsdlPackage.TOPERATION__FAULT1:
				getFault1().clear();
				return;
			case WsdlPackage.TOPERATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case WsdlPackage.TOPERATION__PARAMETER_ORDER:
				setParameterOrder(PARAMETER_ORDER_EDEFAULT);
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
			case WsdlPackage.TOPERATION__INPUT:
				return input != null;
			case WsdlPackage.TOPERATION__OUTPUT:
				return output != null;
			case WsdlPackage.TOPERATION__FAULT:
				return fault != null && !fault.isEmpty();
			case WsdlPackage.TOPERATION__OUTPUT1:
				return output1 != null;
			case WsdlPackage.TOPERATION__INPUT1:
				return input1 != null;
			case WsdlPackage.TOPERATION__FAULT1:
				return fault1 != null && !fault1.isEmpty();
			case WsdlPackage.TOPERATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case WsdlPackage.TOPERATION__PARAMETER_ORDER:
				return PARAMETER_ORDER_EDEFAULT == null ? parameterOrder != null : !PARAMETER_ORDER_EDEFAULT.equals(parameterOrder);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", parameterOrder: ");
		result.append(parameterOrder);
		result.append(')');
		return result.toString();
	}

} //TOperationImpl