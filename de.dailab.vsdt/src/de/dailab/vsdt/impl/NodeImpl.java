/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.Activity;
import de.dailab.vsdt.ActivityType;
import de.dailab.vsdt.End;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Message;
import de.dailab.vsdt.MessageFlow;
import de.dailab.vsdt.Node;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.Start;
import de.dailab.vsdt.TriggerType;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.NodeImpl#getOutgoingMsg <em>Outgoing Msg</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.NodeImpl#getIncomingMsg <em>Incoming Msg</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NodeImpl extends GraphicalObjectImpl implements Node {
	/**
	 * The cached value of the '{@link #getOutgoingMsg() <em>Outgoing Msg</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingMsg()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageFlow> outgoingMsg;

	/**
	 * The cached value of the '{@link #getIncomingMsg() <em>Incoming Msg</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingMsg()
	 * @generated
	 * @ordered
	 */
	protected EList<MessageFlow> incomingMsg;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageFlow> getOutgoingMsg() {
		if (outgoingMsg == null) {
			outgoingMsg = new EObjectWithInverseEList<MessageFlow>(MessageFlow.class, this, VsdtPackage.NODE__OUTGOING_MSG, VsdtPackage.MESSAGE_FLOW__SOURCE);
		}
		return outgoingMsg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MessageFlow> getIncomingMsg() {
		if (incomingMsg == null) {
			incomingMsg = new EObjectWithInverseEList<MessageFlow>(MessageFlow.class, this, VsdtPackage.NODE__INCOMING_MSG, VsdtPackage.MESSAGE_FLOW__TARGET);
		}
		return incomingMsg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Pool getPool() {
		if (this instanceof Pool) {
			return (Pool) this;
		}
		if (this instanceof FlowObject) {
			return ((FlowObject) this).getPool();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void adaptToMessage(Message message, boolean incoming) {
		if (this instanceof Start) {
			Start start = (Start) this;
			if (start.getTrigger() == TriggerType.NONE || start.getTrigger() == TriggerType.MESSAGE) {
				start.setTrigger(TriggerType.MESSAGE);
			} else {
				start.setTrigger(TriggerType.MULTIPLE);
			}
			start.setMessage(message);
		} 
		if (this instanceof Intermediate) {
			Intermediate intermediate = (Intermediate) this;
			if (intermediate.getTrigger() == TriggerType.NONE || intermediate.getTrigger() == TriggerType.MESSAGE) {
				intermediate.setTrigger(TriggerType.MESSAGE);
			} else {
				intermediate.setTrigger(TriggerType.MULTIPLE);
			}
			intermediate.setMessage(message);
		} 
		if (this instanceof End) {
			End end = (End) this;
			if (end.getTrigger() == TriggerType.NONE || end.getTrigger() == TriggerType.MESSAGE) {
				end.setTrigger(TriggerType.MESSAGE);
			} else {
				end.setTrigger(TriggerType.MULTIPLE);
			}
			end.setMessage(message);
		}
		if (this instanceof Activity) {
			Activity activity = (Activity) this;
			if (incoming) {
				if (activity.getActivityType() == ActivityType.NONE || activity.getActivityType() == ActivityType.RECEIVE) {
					activity.setActivityType(ActivityType.RECEIVE);
					activity.setOutMessage(message);
				}
				if (activity.getActivityType() == ActivityType.SEND) {
					activity.setActivityType(ActivityType.SERVICE);
					activity.setOutMessage(message);
				}
			} else {
				if (activity.getActivityType() == ActivityType.NONE || activity.getActivityType() == ActivityType.SEND) {
					activity.setActivityType(ActivityType.SEND);
					activity.setInMessage(message);
				}
				if (activity.getActivityType() == ActivityType.RECEIVE) {
					activity.setActivityType(ActivityType.SERVICE);
					activity.setInMessage(message);
				}	
			}
		}
	
	}

	// TODO remove obsolete code after some time of testing (commented out 080908)
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void adaptToIncomingMessageFlow() {
//		if (this.getIncomingMsg().isEmpty()) {
//			return;
//		}
//		MessageFlow theMessageFlow= this.getIncomingMsg().get(0);
//		Message theMessage= theMessageFlow.getMessage();
//		
//		if (this instanceof Start) {
//			Start start = (Start) this;
//			if (start.getTrigger() == StartEventTriggerType.NONE || start.getTrigger() == StartEventTriggerType.MESSAGE) {
//				start.setTrigger(StartEventTriggerType.MESSAGE);
//			} else {
//				start.setTrigger(StartEventTriggerType.MULTIPLE);
//			}
//			start.setMessage(theMessage);
//		} else
//		if (this instanceof Intermediate) {
//			Intermediate intermediate = (Intermediate) this;
//			if (intermediate.getTrigger() == IntermediateEventTriggerType.NONE || intermediate.getTrigger() == IntermediateEventTriggerType.MESSAGE) {
//				intermediate.setTrigger(IntermediateEventTriggerType.MESSAGE);
//			} else {
//				intermediate.setTrigger(IntermediateEventTriggerType.MULTIPLE);
//			}
//			intermediate.setMessage(theMessage);
//		} else
//		if (this instanceof Activity) {
//			Activity activity = (Activity) this;
//			if (activity.getActivityType() == ActivityType.NONE || activity.getActivityType() == ActivityType.RECEIVE) {
//				activity.setActivityType(ActivityType.RECEIVE);
//				activity.setOutMessage(theMessage);
//			}
//			if (activity.getActivityType() == ActivityType.SEND) {
//				activity.setActivityType(ActivityType.SERVICE);
//				activity.setOutMessage(theMessage);
//			}
//		}
//	}
//
//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public void adaptToOutgoingMessageFlow() {
//		if (this.getOutgoingMsg().isEmpty()) {
//			return;
//		}
//		MessageFlow theMessageFlow= this.getOutgoingMsg().get(0);
//		Message theMessage= theMessageFlow.getMessage();
//		
//		if (this instanceof End) {
//			End end = (End) this;
//			if (end.getTrigger() == EndEventTriggerType.NONE || end.getTrigger() == EndEventTriggerType.MESSAGE) {
//				end.setTrigger(EndEventTriggerType.MESSAGE);
//				end.setMessage(theMessage);
//			}
//		} else
//		if (this instanceof Activity) {
//			Activity activity = (Activity) this;
//			if (activity.getActivityType() == ActivityType.NONE || activity.getActivityType() == ActivityType.SEND) {
//				activity.setActivityType(ActivityType.SEND);
//				activity.setInMessage(theMessage);
//			}
//			if (activity.getActivityType() == ActivityType.RECEIVE) {
//				activity.setActivityType(ActivityType.SERVICE);
//				activity.setInMessage(theMessage);
//			}
//		}
//	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.NODE__OUTGOING_MSG:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingMsg()).basicAdd(otherEnd, msgs);
			case VsdtPackage.NODE__INCOMING_MSG:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingMsg()).basicAdd(otherEnd, msgs);
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
			case VsdtPackage.NODE__OUTGOING_MSG:
				return ((InternalEList<?>)getOutgoingMsg()).basicRemove(otherEnd, msgs);
			case VsdtPackage.NODE__INCOMING_MSG:
				return ((InternalEList<?>)getIncomingMsg()).basicRemove(otherEnd, msgs);
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
			case VsdtPackage.NODE__OUTGOING_MSG:
				return getOutgoingMsg();
			case VsdtPackage.NODE__INCOMING_MSG:
				return getIncomingMsg();
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
			case VsdtPackage.NODE__OUTGOING_MSG:
				getOutgoingMsg().clear();
				getOutgoingMsg().addAll((Collection<? extends MessageFlow>)newValue);
				return;
			case VsdtPackage.NODE__INCOMING_MSG:
				getIncomingMsg().clear();
				getIncomingMsg().addAll((Collection<? extends MessageFlow>)newValue);
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
			case VsdtPackage.NODE__OUTGOING_MSG:
				getOutgoingMsg().clear();
				return;
			case VsdtPackage.NODE__INCOMING_MSG:
				getIncomingMsg().clear();
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
			case VsdtPackage.NODE__OUTGOING_MSG:
				return outgoingMsg != null && !outgoingMsg.isEmpty();
			case VsdtPackage.NODE__INCOMING_MSG:
				return incomingMsg != null && !incomingMsg.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NodeImpl
