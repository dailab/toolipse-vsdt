/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.dailab.vsdt.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.BpmnProcess;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtFactory;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getParentDiagram <em>Parent Diagram</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getProcess <em>Process</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getParticipant <em>Participant</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getLanes <em>Lanes</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#isBoundaryVisible <em>Boundary Visible</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PoolImpl extends NodeImpl implements Pool {
	/**
	 * The cached value of the '{@link #getProcess() <em>Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcess()
	 * @generated
	 * @ordered
	 */
	protected BpmnProcess process;

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
	 * The cached value of the '{@link #getLanes() <em>Lanes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLanes()
	 * @generated
	 * @ordered
	 */
	protected EList<Lane> lanes;

	/**
	 * The default value of the '{@link #isBoundaryVisible() <em>Boundary Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoundaryVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOUNDARY_VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isBoundaryVisible() <em>Boundary Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoundaryVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean boundaryVisible = BOUNDARY_VISIBLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PoolImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.POOL;
	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * default: name of the class, e.g. "Pool", "Lane"
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public String getName() {
////		if (name==null) {
////			return this.eClass().getName();
////		}
//		return name;
//	}

	/**
	 * <!-- begin-user-doc -->
	 * Set name of process and participant accordingly. The names will only be 
	 * adapted to the pool's name if they were in that format before, too.  Thus an 
	 * already customized participant name will not be reset when renaming the pool. 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__NAME, oldName, name));
		
		final String PROC= "_Process";
		final String PART= "_Participant";
		if (getProcess() != null && ( getProcess().getName() == null || getProcess().getName().equals(oldName + PROC))) {
			getProcess().setName(newName + PROC);
		}
		if (getParticipant() != null && ( getParticipant().getName() == null || getParticipant().getName().equals(oldName + PART))) {
			getParticipant().setName(newName + PART);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessDiagram getParentDiagram() {
		if (eContainerFeatureID() != VsdtPackage.POOL__PARENT_DIAGRAM) return null;
		return (BusinessProcessDiagram)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentDiagram(BusinessProcessDiagram newParentDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentDiagram, VsdtPackage.POOL__PARENT_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentDiagram(BusinessProcessDiagram newParentDiagram) {
		if (newParentDiagram != eInternalContainer() || (eContainerFeatureID() != VsdtPackage.POOL__PARENT_DIAGRAM && newParentDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newParentDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentDiagram != null)
				msgs = ((InternalEObject)newParentDiagram).eInverseAdd(this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS, BusinessProcessDiagram.class, msgs);
			msgs = basicSetParentDiagram(newParentDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__PARENT_DIAGRAM, newParentDiagram, newParentDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BpmnProcess getProcess() {
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcess(BpmnProcess newProcess, NotificationChain msgs) {
		BpmnProcess oldProcess = process;
		process = newProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__PROCESS, oldProcess, newProcess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcess(BpmnProcess newProcess) {
		if (newProcess != process) {
			NotificationChain msgs = null;
			if (process != null)
				msgs = ((InternalEObject)process).eInverseRemove(this, VsdtPackage.BPMN_PROCESS__PARENT_POOL, BpmnProcess.class, msgs);
			if (newProcess != null)
				msgs = ((InternalEObject)newProcess).eInverseAdd(this, VsdtPackage.BPMN_PROCESS__PARENT_POOL, BpmnProcess.class, msgs);
			msgs = basicSetProcess(newProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__PROCESS, newProcess, newProcess));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VsdtPackage.POOL__PARTICIPANT, oldParticipant, participant));
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
	public NotificationChain basicSetParticipant(Participant newParticipant, NotificationChain msgs) {
		Participant oldParticipant = participant;
		participant = newParticipant;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__PARTICIPANT, oldParticipant, newParticipant);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParticipant(Participant newParticipant) {
		if (newParticipant != participant) {
			NotificationChain msgs = null;
			if (participant != null)
				msgs = ((InternalEObject)participant).eInverseRemove(this, VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS, Participant.class, msgs);
			if (newParticipant != null)
				msgs = ((InternalEObject)newParticipant).eInverseAdd(this, VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS, Participant.class, msgs);
			msgs = basicSetParticipant(newParticipant, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__PARTICIPANT, newParticipant, newParticipant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Lane> getLanes() {
		if (lanes == null) {
			lanes = new EObjectContainmentWithInverseEList<Lane>(Lane.class, this, VsdtPackage.POOL__LANES, VsdtPackage.LANE__PARENT_POOL);
		}
		return lanes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBoundaryVisible() {
		return boundaryVisible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * set lane's boundary visible accordingly
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setBoundaryVisible(boolean newBoundaryVisible) {
		boolean oldBoundaryVisible = boundaryVisible;
		boundaryVisible = newBoundaryVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__BOUNDARY_VISIBLE, oldBoundaryVisible, boundaryVisible));
		
		this.setBoundaryVisibility();
	}

	/**
	 * initialize a new participant for this pool and store it in the parent BPD
	 * @generated NOT
	 */
	public void initializeParticipant() {
		Participant participant= VsdtFactory.eINSTANCE.createParticipant();
		this.getParentDiagram().getParticipants().add(participant);
		participant.setName(this.getName() + "_Participant");
		this.setParticipant(participant);
	}

	/**
	 * <!-- begin-user-doc -->
	 * if only one lane, set lane's boundary invisible, else
	 * set boundaries of lanes accordingly to the pool's boundary
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setBoundaryVisibility() {
		if (getLanes().size()==1) {
			((Lane)getLanes().get(0)).setBoundaryVisible(false);
		} else
		for (Iterator<Lane> iter = getLanes().iterator(); iter.hasNext();) {
			Lane lane = iter.next();
			lane.setBoundaryVisible(boundaryVisible);
		}
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
			case VsdtPackage.POOL__PARENT_DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentDiagram((BusinessProcessDiagram)otherEnd, msgs);
			case VsdtPackage.POOL__PROCESS:
				if (process != null)
					msgs = ((InternalEObject)process).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.POOL__PROCESS, null, msgs);
				return basicSetProcess((BpmnProcess)otherEnd, msgs);
			case VsdtPackage.POOL__PARTICIPANT:
				if (participant != null)
					msgs = ((InternalEObject)participant).eInverseRemove(this, VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS, Participant.class, msgs);
				return basicSetParticipant((Participant)otherEnd, msgs);
			case VsdtPackage.POOL__LANES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLanes()).basicAdd(otherEnd, msgs);
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
			case VsdtPackage.POOL__PARENT_DIAGRAM:
				return basicSetParentDiagram(null, msgs);
			case VsdtPackage.POOL__PROCESS:
				return basicSetProcess(null, msgs);
			case VsdtPackage.POOL__PARTICIPANT:
				return basicSetParticipant(null, msgs);
			case VsdtPackage.POOL__LANES:
				return ((InternalEList<?>)getLanes()).basicRemove(otherEnd, msgs);
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
			case VsdtPackage.POOL__PARENT_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS, BusinessProcessDiagram.class, msgs);
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
			case VsdtPackage.POOL__PARENT_DIAGRAM:
				return getParentDiagram();
			case VsdtPackage.POOL__PROCESS:
				return getProcess();
			case VsdtPackage.POOL__PARTICIPANT:
				if (resolve) return getParticipant();
				return basicGetParticipant();
			case VsdtPackage.POOL__LANES:
				return getLanes();
			case VsdtPackage.POOL__BOUNDARY_VISIBLE:
				return isBoundaryVisible();
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
			case VsdtPackage.POOL__PARENT_DIAGRAM:
				setParentDiagram((BusinessProcessDiagram)newValue);
				return;
			case VsdtPackage.POOL__PROCESS:
				setProcess((BpmnProcess)newValue);
				return;
			case VsdtPackage.POOL__PARTICIPANT:
				setParticipant((Participant)newValue);
				return;
			case VsdtPackage.POOL__LANES:
				getLanes().clear();
				getLanes().addAll((Collection<? extends Lane>)newValue);
				return;
			case VsdtPackage.POOL__BOUNDARY_VISIBLE:
				setBoundaryVisible((Boolean)newValue);
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
			case VsdtPackage.POOL__PARENT_DIAGRAM:
				setParentDiagram((BusinessProcessDiagram)null);
				return;
			case VsdtPackage.POOL__PROCESS:
				setProcess((BpmnProcess)null);
				return;
			case VsdtPackage.POOL__PARTICIPANT:
				setParticipant((Participant)null);
				return;
			case VsdtPackage.POOL__LANES:
				getLanes().clear();
				return;
			case VsdtPackage.POOL__BOUNDARY_VISIBLE:
				setBoundaryVisible(BOUNDARY_VISIBLE_EDEFAULT);
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
			case VsdtPackage.POOL__PARENT_DIAGRAM:
				return getParentDiagram() != null;
			case VsdtPackage.POOL__PROCESS:
				return process != null;
			case VsdtPackage.POOL__PARTICIPANT:
				return participant != null;
			case VsdtPackage.POOL__LANES:
				return lanes != null && !lanes.isEmpty();
			case VsdtPackage.POOL__BOUNDARY_VISIBLE:
				return boundaryVisible != BOUNDARY_VISIBLE_EDEFAULT;
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
		result.append(" (boundaryVisible: ");
		result.append(boundaryVisible);
		result.append(')');
		return result.toString();
	}

} //PoolImpl
