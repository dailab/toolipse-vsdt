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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.Artifact;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.BusinessProcessSystem;
import de.dailab.vsdt.ConnectingObject;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Business Process Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessDiagramImpl#getPools <em>Pools</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessDiagramImpl#getArtifacts <em>Artifacts</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessDiagramImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessDiagramImpl#getParticipants <em>Participants</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BusinessProcessDiagramImpl#getBusinessProcessSystem <em>Business Process System</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BusinessProcessDiagramImpl extends IdObjectImpl implements BusinessProcessDiagram {
	/**
	 * The cached value of the '{@link #getPools() <em>Pools</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPools()
	 * @generated
	 * @ordered
	 */
	protected EList<Pool> pools;

	/**
	 * The cached value of the '{@link #getArtifacts() <em>Artifacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifacts()
	 * @generated
	 * @ordered
	 */
	protected EList<Artifact> artifacts;

	/**
	 * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnections()
	 * @generated
	 * @ordered
	 */
	protected EList<ConnectingObject> connections;

	/**
	 * The cached value of the '{@link #getParticipants() <em>Participants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParticipants()
	 * @generated
	 * @ordered
	 */
	protected EList<Participant> participants;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BusinessProcessDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.BUSINESS_PROCESS_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pool> getPools() {
		if (pools == null) {
			pools = new EObjectContainmentWithInverseEList<Pool>(Pool.class, this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS, VsdtPackage.POOL__PARENT_DIAGRAM);
		}
		return pools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Artifact> getArtifacts() {
		if (artifacts == null) {
			artifacts = new EObjectContainmentWithInverseEList<Artifact>(Artifact.class, this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS, VsdtPackage.ARTIFACT__PARENT_DIAGRAM);
		}
		return artifacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ConnectingObject> getConnections() {
		if (connections == null) {
			connections = new EObjectContainmentWithInverseEList<ConnectingObject>(ConnectingObject.class, this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS, VsdtPackage.CONNECTING_OBJECT__PARENT_DIAGRAM);
		}
		return connections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Participant> getParticipants() {
		if (participants == null) {
			participants = new EObjectWithInverseResolvingEList.ManyInverse<Participant>(Participant.class, this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS, VsdtPackage.PARTICIPANT__ASSOCIATED_PROCESSES);
		}
		return participants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessSystem getBusinessProcessSystem() {
		if (eContainerFeatureID() != VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM) return null;
		return (BusinessProcessSystem)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBusinessProcessSystem(BusinessProcessSystem newBusinessProcessSystem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBusinessProcessSystem, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBusinessProcessSystem(BusinessProcessSystem newBusinessProcessSystem) {
		if (newBusinessProcessSystem != eInternalContainer() || (eContainerFeatureID() != VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM && newBusinessProcessSystem != null)) {
			if (EcoreUtil.isAncestor(this, newBusinessProcessSystem))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBusinessProcessSystem != null)
				msgs = ((InternalEObject)newBusinessProcessSystem).eInverseAdd(this, VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES, BusinessProcessSystem.class, msgs);
			msgs = basicSetBusinessProcessSystem(newBusinessProcessSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM, newBusinessProcessSystem, newBusinessProcessSystem));
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
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPools()).basicAdd(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArtifacts()).basicAdd(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnections()).basicAdd(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParticipants()).basicAdd(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBusinessProcessSystem((BusinessProcessSystem)otherEnd, msgs);
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
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS:
				return ((InternalEList<?>)getPools()).basicRemove(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS:
				return ((InternalEList<?>)getArtifacts()).basicRemove(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS:
				return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS:
				return ((InternalEList<?>)getParticipants()).basicRemove(otherEnd, msgs);
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM:
				return basicSetBusinessProcessSystem(null, msgs);
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
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM:
				return eInternalContainer().eInverseRemove(this, VsdtPackage.BUSINESS_PROCESS_SYSTEM__BUSINESS_PROCESSES, BusinessProcessSystem.class, msgs);
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
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS:
				return getPools();
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS:
				return getArtifacts();
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS:
				return getConnections();
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS:
				return getParticipants();
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM:
				return getBusinessProcessSystem();
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
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS:
				getPools().clear();
				getPools().addAll((Collection<? extends Pool>)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS:
				getArtifacts().clear();
				getArtifacts().addAll((Collection<? extends Artifact>)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends ConnectingObject>)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS:
				getParticipants().clear();
				getParticipants().addAll((Collection<? extends Participant>)newValue);
				return;
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM:
				setBusinessProcessSystem((BusinessProcessSystem)newValue);
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
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS:
				getPools().clear();
				return;
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS:
				getArtifacts().clear();
				return;
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS:
				getConnections().clear();
				return;
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS:
				getParticipants().clear();
				return;
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM:
				setBusinessProcessSystem((BusinessProcessSystem)null);
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
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS:
				return pools != null && !pools.isEmpty();
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__ARTIFACTS:
				return artifacts != null && !artifacts.isEmpty();
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__CONNECTIONS:
				return connections != null && !connections.isEmpty();
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS:
				return participants != null && !participants.isEmpty();
			case VsdtPackage.BUSINESS_PROCESS_DIAGRAM__BUSINESS_PROCESS_SYSTEM:
				return getBusinessProcessSystem() != null;
		}
		return super.eIsSet(featureID);
	}

} //BusinessProcessDiagramImpl
