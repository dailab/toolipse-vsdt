/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.dailab.vsdt.Implementation;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.ImplementationImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ImplementationImpl#getParticipant <em>Participant</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ImplementationImpl#getInterface <em>Interface</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ImplementationImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ImplementationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ImplementationImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ImplementationImpl#getInputMessage <em>Input Message</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ImplementationImpl#getOutputMessage <em>Output Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ImplementationImpl extends EObjectImpl implements Implementation {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = "WebService";
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getParticipant() <em>Participant</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipant()
	 * @generated
	 * @ordered
	 */
	protected Participant participant;
	/**
	 * The default value of the '{@link #getInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected static final String INTERFACE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getInterface() <em>Interface</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterface()
	 * @generated
	 * @ordered
	 */
	protected String interface_ = INTERFACE_EDEFAULT;
	/**
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected String operation = OPERATION_EDEFAULT;
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInputMessage() <em>Input Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputMessage()
	 * @generated
	 * @ordered
	 */
	protected Message inputMessage;
	/**
	 * The cached value of the '{@link #getOutputMessage() <em>Output Message</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputMessage()
	 * @generated
	 * @ordered
	 */
	protected Message outputMessage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.IMPLEMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.IMPLEMENTATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant getParticipant() {
		if (participant != null && participant.eIsProxy()) {
			InternalEObject oldParticipant = (InternalEObject)participant;
			participant = (Participant)eResolveProxy(oldParticipant);
			if (participant != oldParticipant) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.IMPLEMENTATION__PARTICIPANT, oldParticipant, participant));
			}
		}
		return participant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant basicGetParticipant() {
		return participant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParticipant(Participant newParticipant) {
		Participant oldParticipant = participant;
		participant = newParticipant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.IMPLEMENTATION__PARTICIPANT, oldParticipant, participant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInterface() {
		return interface_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInterface(String newInterface) {
		String oldInterface = interface_;
		interface_ = newInterface;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.IMPLEMENTATION__INTERFACE, oldInterface, interface_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(String newOperation) {
		String oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.IMPLEMENTATION__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.IMPLEMENTATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.IMPLEMENTATION__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getInputMessage() {
		if (inputMessage != null && inputMessage.eIsProxy()) {
			InternalEObject oldInputMessage = (InternalEObject)inputMessage;
			inputMessage = (Message)eResolveProxy(oldInputMessage);
			if (inputMessage != oldInputMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.IMPLEMENTATION__INPUT_MESSAGE, oldInputMessage, inputMessage));
			}
		}
		return inputMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetInputMessage() {
		return inputMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputMessage(Message newInputMessage) {
		Message oldInputMessage = inputMessage;
		inputMessage = newInputMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.IMPLEMENTATION__INPUT_MESSAGE, oldInputMessage, inputMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message getOutputMessage() {
		if (outputMessage != null && outputMessage.eIsProxy()) {
			InternalEObject oldOutputMessage = (InternalEObject)outputMessage;
			outputMessage = (Message)eResolveProxy(oldOutputMessage);
			if (outputMessage != oldOutputMessage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.IMPLEMENTATION__OUTPUT_MESSAGE, oldOutputMessage, outputMessage));
			}
		}
		return outputMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Message basicGetOutputMessage() {
		return outputMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputMessage(Message newOutputMessage) {
		Message oldOutputMessage = outputMessage;
		outputMessage = newOutputMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.IMPLEMENTATION__OUTPUT_MESSAGE, oldOutputMessage, outputMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VsdtPackage.IMPLEMENTATION__TYPE:
				return getType();
			case VsdtPackage.IMPLEMENTATION__PARTICIPANT:
				if (resolve) return getParticipant();
				return basicGetParticipant();
			case VsdtPackage.IMPLEMENTATION__INTERFACE:
				return getInterface();
			case VsdtPackage.IMPLEMENTATION__OPERATION:
				return getOperation();
			case VsdtPackage.IMPLEMENTATION__DESCRIPTION:
				return getDescription();
			case VsdtPackage.IMPLEMENTATION__LOCATION:
				return getLocation();
			case VsdtPackage.IMPLEMENTATION__INPUT_MESSAGE:
				if (resolve) return getInputMessage();
				return basicGetInputMessage();
			case VsdtPackage.IMPLEMENTATION__OUTPUT_MESSAGE:
				if (resolve) return getOutputMessage();
				return basicGetOutputMessage();
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
			case VsdtPackage.IMPLEMENTATION__TYPE:
				setType((String)newValue);
				return;
			case VsdtPackage.IMPLEMENTATION__PARTICIPANT:
				setParticipant((Participant)newValue);
				return;
			case VsdtPackage.IMPLEMENTATION__INTERFACE:
				setInterface((String)newValue);
				return;
			case VsdtPackage.IMPLEMENTATION__OPERATION:
				setOperation((String)newValue);
				return;
			case VsdtPackage.IMPLEMENTATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case VsdtPackage.IMPLEMENTATION__LOCATION:
				setLocation((String)newValue);
				return;
			case VsdtPackage.IMPLEMENTATION__INPUT_MESSAGE:
				setInputMessage((Message)newValue);
				return;
			case VsdtPackage.IMPLEMENTATION__OUTPUT_MESSAGE:
				setOutputMessage((Message)newValue);
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
			case VsdtPackage.IMPLEMENTATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case VsdtPackage.IMPLEMENTATION__PARTICIPANT:
				setParticipant((Participant)null);
				return;
			case VsdtPackage.IMPLEMENTATION__INTERFACE:
				setInterface(INTERFACE_EDEFAULT);
				return;
			case VsdtPackage.IMPLEMENTATION__OPERATION:
				setOperation(OPERATION_EDEFAULT);
				return;
			case VsdtPackage.IMPLEMENTATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case VsdtPackage.IMPLEMENTATION__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case VsdtPackage.IMPLEMENTATION__INPUT_MESSAGE:
				setInputMessage((Message)null);
				return;
			case VsdtPackage.IMPLEMENTATION__OUTPUT_MESSAGE:
				setOutputMessage((Message)null);
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
			case VsdtPackage.IMPLEMENTATION__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case VsdtPackage.IMPLEMENTATION__PARTICIPANT:
				return participant != null;
			case VsdtPackage.IMPLEMENTATION__INTERFACE:
				return INTERFACE_EDEFAULT == null ? interface_ != null : !INTERFACE_EDEFAULT.equals(interface_);
			case VsdtPackage.IMPLEMENTATION__OPERATION:
				return OPERATION_EDEFAULT == null ? operation != null : !OPERATION_EDEFAULT.equals(operation);
			case VsdtPackage.IMPLEMENTATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case VsdtPackage.IMPLEMENTATION__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case VsdtPackage.IMPLEMENTATION__INPUT_MESSAGE:
				return inputMessage != null;
			case VsdtPackage.IMPLEMENTATION__OUTPUT_MESSAGE:
				return outputMessage != null;
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
		result.append(" (type: ");
		result.append(type);
		result.append(", interface: ");
		result.append(interface_);
		result.append(", operation: ");
		result.append(operation);
		result.append(", description: ");
		result.append(description);
		result.append(", location: ");
		result.append(location);
		result.append(')');
		return result.toString();
	}

} //ImplementationImpl
