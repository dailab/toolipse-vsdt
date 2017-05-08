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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.Activity;
import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.FlowObjectContainer;
import de.dailab.vsdt.Intermediate;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.SequenceFlow;
import de.dailab.vsdt.VsdtPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flow Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.FlowObjectImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.FlowObjectImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.FlowObjectImpl#getOutgoingSeq <em>Outgoing Seq</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.FlowObjectImpl#getIncomingSeq <em>Incoming Seq</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class FlowObjectImpl extends NodeImpl implements FlowObject {
	/**
	 * The cached value of the '{@link #getAssignments() <em>Assignments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignments()
	 * @generated
	 * @ordered
	 */
	protected EList<Assignment> assignments;

	/**
	 * The cached value of the '{@link #getOutgoingSeq() <em>Outgoing Seq</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingSeq()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceFlow> outgoingSeq;

	/**
	 * The cached value of the '{@link #getIncomingSeq() <em>Incoming Seq</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingSeq()
	 * @generated
	 * @ordered
	 */
	protected EList<SequenceFlow> incomingSeq;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlowObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.FLOW_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlowObjectContainer getParent() {
		if (eContainerFeatureID() != VsdtPackage.FLOW_OBJECT__PARENT) return null;
		return (FlowObjectContainer)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(FlowObjectContainer newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, VsdtPackage.FLOW_OBJECT__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(FlowObjectContainer newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != VsdtPackage.FLOW_OBJECT__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS, FlowObjectContainer.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.FLOW_OBJECT__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assignment> getAssignments() {
		if (assignments == null) {
			assignments = new EObjectContainmentEList<Assignment>(Assignment.class, this, VsdtPackage.FLOW_OBJECT__ASSIGNMENTS);
		}
		return assignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceFlow> getOutgoingSeq() {
		if (outgoingSeq == null) {
			outgoingSeq = new EObjectWithInverseEList<SequenceFlow>(SequenceFlow.class, this, VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ, VsdtPackage.SEQUENCE_FLOW__SOURCE);
		}
		return outgoingSeq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SequenceFlow> getIncomingSeq() {
		if (incomingSeq == null) {
			incomingSeq = new EObjectWithInverseEList<SequenceFlow>(SequenceFlow.class, this, VsdtPackage.FLOW_OBJECT__INCOMING_SEQ, VsdtPackage.SEQUENCE_FLOW__TARGET);
		}
		return incomingSeq;
	}

	/**
	 * <!-- begin-user-doc -->
	 * this method returns whether this node is a starting node, e.g. if the node
	 * has no incoming sequence flows while not being a compensation activity
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isStartingNode() {
		if (this instanceof Activity && ((Activity)this).isCompensation()) { 
			return false;
		}
		return getIncomingSeq().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
 	 * this method returns whether this node is a ending node, i.e. if the node
	 * has no outgoing sequence flows while not being a compensation activity
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isEndingNode() {
		if (this instanceof Activity && ((Activity)this).isCompensation()) { 
			return false;
		}
		return getOutgoingSeq().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * returns the process, if the flow object is directly contained in the 
	 * process or returns the subprocess the flow object is contained in or 
	 * returns the abstract process of the target activity if the flow object
	 * is a boundary event  
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public AbstractProcess getAbstractProcess() {
		if (this instanceof Intermediate && ((Intermediate) this).getAttachedTo()!=null) {
			return ((Intermediate)this).getAttachedTo().getAbstractProcess();
		}
		EObject container= eContainer();
		// contained in Subprocess
		if (container instanceof Activity) {
			return (Activity) container;
		} 
		// contained in Lane
		if (container instanceof Lane) {
			return ((Lane) container).getParent();
		}
		// contained in structuring element
		if (container instanceof FlowObject) {
			return ((FlowObject) container).getAbstractProcess();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.FLOW_OBJECT__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((FlowObjectContainer)otherEnd, msgs);
			case VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingSeq()).basicAdd(otherEnd, msgs);
			case VsdtPackage.FLOW_OBJECT__INCOMING_SEQ:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingSeq()).basicAdd(otherEnd, msgs);
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
			case VsdtPackage.FLOW_OBJECT__PARENT:
				return basicSetParent(null, msgs);
			case VsdtPackage.FLOW_OBJECT__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
			case VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ:
				return ((InternalEList<?>)getOutgoingSeq()).basicRemove(otherEnd, msgs);
			case VsdtPackage.FLOW_OBJECT__INCOMING_SEQ:
				return ((InternalEList<?>)getIncomingSeq()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case VsdtPackage.FLOW_OBJECT__PARENT:
				return eInternalContainer().eInverseRemove(this, VsdtPackage.FLOW_OBJECT_CONTAINER__CONTAINED_FLOW_OBJECTS, FlowObjectContainer.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VsdtPackage.FLOW_OBJECT__PARENT:
				return getParent();
			case VsdtPackage.FLOW_OBJECT__ASSIGNMENTS:
				return getAssignments();
			case VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ:
				return getOutgoingSeq();
			case VsdtPackage.FLOW_OBJECT__INCOMING_SEQ:
				return getIncomingSeq();
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
			case VsdtPackage.FLOW_OBJECT__PARENT:
				setParent((FlowObjectContainer)newValue);
				return;
			case VsdtPackage.FLOW_OBJECT__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends Assignment>)newValue);
				return;
			case VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ:
				getOutgoingSeq().clear();
				getOutgoingSeq().addAll((Collection<? extends SequenceFlow>)newValue);
				return;
			case VsdtPackage.FLOW_OBJECT__INCOMING_SEQ:
				getIncomingSeq().clear();
				getIncomingSeq().addAll((Collection<? extends SequenceFlow>)newValue);
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
			case VsdtPackage.FLOW_OBJECT__PARENT:
				setParent((FlowObjectContainer)null);
				return;
			case VsdtPackage.FLOW_OBJECT__ASSIGNMENTS:
				getAssignments().clear();
				return;
			case VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ:
				getOutgoingSeq().clear();
				return;
			case VsdtPackage.FLOW_OBJECT__INCOMING_SEQ:
				getIncomingSeq().clear();
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
			case VsdtPackage.FLOW_OBJECT__PARENT:
				return getParent() != null;
			case VsdtPackage.FLOW_OBJECT__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
			case VsdtPackage.FLOW_OBJECT__OUTGOING_SEQ:
				return outgoingSeq != null && !outgoingSeq.isEmpty();
			case VsdtPackage.FLOW_OBJECT__INCOMING_SEQ:
				return incomingSeq != null && !incomingSeq.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * recursively return the pool.
	 * if the flow object is top element in the lane, the lane's pool is returned.
	 * if the flow object is contained within another activity, this activity's pool is returned
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Pool getPool() {
		if (this instanceof Intermediate && ((Intermediate) this).getAttachedTo()!=null) {
			return ((Intermediate)this).getAttachedTo().getPool();
		}
		EObject container= eContainer();
		if (container instanceof Lane) {
			return (Pool) ((Lane) container).eContainer();
		}
		if (container instanceof Activity) {
			return ((Activity) container).getPool();
		}
		// for structuring elements
		if (container instanceof FlowObject) {
			return ((FlowObject) container).getPool();
		}
		return null;
	}

} //FlowObjectImpl
