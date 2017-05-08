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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.AbstractProcess;
import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Expression;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.ProcessType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pool</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#isAdHoc <em>Ad Hoc</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getAdHocCompletionCondition <em>Ad Hoc Completion Condition</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getParticipant <em>Participant</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getLanes <em>Lanes</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#isBoundaryVisible <em>Boundary Visible</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.PoolImpl#getProcessType <em>Process Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PoolImpl extends NodeImpl implements Pool {
	/**
	 * The default value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdHoc()
	 * @generated
	 * @ordered
	 */
	protected static final boolean AD_HOC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAdHoc() <em>Ad Hoc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAdHoc()
	 * @generated
	 * @ordered
	 */
	protected boolean adHoc = AD_HOC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAdHocCompletionCondition() <em>Ad Hoc Completion Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdHocCompletionCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression adHocCompletionCondition;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> properties;

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
	 * The default value of the '{@link #getProcessType() <em>Process Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessType()
	 * @generated
	 * @ordered
	 */
	protected static final ProcessType PROCESS_TYPE_EDEFAULT = ProcessType.PRIVATE;

	/**
	 * The cached value of the '{@link #getProcessType() <em>Process Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessType()
	 * @generated
	 * @ordered
	 */
	protected ProcessType processType = PROCESS_TYPE_EDEFAULT;

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

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAdHoc() {
		return adHoc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdHoc(boolean newAdHoc) {
		boolean oldAdHoc = adHoc;
		adHoc = newAdHoc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__AD_HOC, oldAdHoc, adHoc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getAdHocCompletionCondition() {
		return adHocCompletionCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAdHocCompletionCondition(Expression newAdHocCompletionCondition, NotificationChain msgs) {
		Expression oldAdHocCompletionCondition = adHocCompletionCondition;
		adHocCompletionCondition = newAdHocCompletionCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION, oldAdHocCompletionCondition, newAdHocCompletionCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAdHocCompletionCondition(Expression newAdHocCompletionCondition) {
		if (newAdHocCompletionCondition != adHocCompletionCondition) {
			NotificationChain msgs = null;
			if (adHocCompletionCondition != null)
				msgs = ((InternalEObject)adHocCompletionCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION, null, msgs);
			if (newAdHocCompletionCondition != null)
				msgs = ((InternalEObject)newAdHocCompletionCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION, null, msgs);
			msgs = basicSetAdHocCompletionCondition(newAdHocCompletionCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION, newAdHocCompletionCondition, newAdHocCompletionCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Property> getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList<Property>(Property.class, this, VsdtPackage.POOL__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BusinessProcessDiagram getParent() {
		if (eContainerFeatureID() != VsdtPackage.POOL__PARENT) return null;
		return (BusinessProcessDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(BusinessProcessDiagram newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, VsdtPackage.POOL__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(BusinessProcessDiagram newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != VsdtPackage.POOL__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__POOLS, BusinessProcessDiagram.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__PARENT, newParent, newParent));
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
			lanes = new EObjectContainmentWithInverseEList<Lane>(Lane.class, this, VsdtPackage.POOL__LANES, VsdtPackage.LANE__PARENT);
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
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundaryVisible(boolean newBoundaryVisible) {
		boolean oldBoundaryVisible = boundaryVisible;
		boundaryVisible = newBoundaryVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__BOUNDARY_VISIBLE, oldBoundaryVisible, boundaryVisible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessType getProcessType() {
		return processType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessType(ProcessType newProcessType) {
		ProcessType oldProcessType = processType;
		processType = newProcessType == null ? PROCESS_TYPE_EDEFAULT : newProcessType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.POOL__PROCESS_TYPE, oldProcessType, processType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * return the lanes' graphical elements
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FlowObject> getGraphicalElements() {
		EList<FlowObject> flowObjects= new BasicEList<FlowObject>();
		for (Lane lane : getLanes()) {
			flowObjects.addAll(lane.getContainedFlowObjects());
		}
		return flowObjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * this Pool's Pool is the Pool itself
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Pool getPool() {
		return this;
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
			case VsdtPackage.POOL__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((BusinessProcessDiagram)otherEnd, msgs);
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
			case VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION:
				return basicSetAdHocCompletionCondition(null, msgs);
			case VsdtPackage.POOL__PROPERTIES:
				return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
			case VsdtPackage.POOL__PARENT:
				return basicSetParent(null, msgs);
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
			case VsdtPackage.POOL__PARENT:
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
			case VsdtPackage.POOL__AD_HOC:
				return isAdHoc();
			case VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION:
				return getAdHocCompletionCondition();
			case VsdtPackage.POOL__PROPERTIES:
				return getProperties();
			case VsdtPackage.POOL__PARENT:
				return getParent();
			case VsdtPackage.POOL__PARTICIPANT:
				if (resolve) return getParticipant();
				return basicGetParticipant();
			case VsdtPackage.POOL__LANES:
				return getLanes();
			case VsdtPackage.POOL__BOUNDARY_VISIBLE:
				return isBoundaryVisible();
			case VsdtPackage.POOL__PROCESS_TYPE:
				return getProcessType();
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
			case VsdtPackage.POOL__AD_HOC:
				setAdHoc((Boolean)newValue);
				return;
			case VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION:
				setAdHocCompletionCondition((Expression)newValue);
				return;
			case VsdtPackage.POOL__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection<? extends Property>)newValue);
				return;
			case VsdtPackage.POOL__PARENT:
				setParent((BusinessProcessDiagram)newValue);
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
			case VsdtPackage.POOL__PROCESS_TYPE:
				setProcessType((ProcessType)newValue);
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
			case VsdtPackage.POOL__AD_HOC:
				setAdHoc(AD_HOC_EDEFAULT);
				return;
			case VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION:
				setAdHocCompletionCondition((Expression)null);
				return;
			case VsdtPackage.POOL__PROPERTIES:
				getProperties().clear();
				return;
			case VsdtPackage.POOL__PARENT:
				setParent((BusinessProcessDiagram)null);
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
			case VsdtPackage.POOL__PROCESS_TYPE:
				setProcessType(PROCESS_TYPE_EDEFAULT);
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
			case VsdtPackage.POOL__AD_HOC:
				return adHoc != AD_HOC_EDEFAULT;
			case VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION:
				return adHocCompletionCondition != null;
			case VsdtPackage.POOL__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case VsdtPackage.POOL__PARENT:
				return getParent() != null;
			case VsdtPackage.POOL__PARTICIPANT:
				return participant != null;
			case VsdtPackage.POOL__LANES:
				return lanes != null && !lanes.isEmpty();
			case VsdtPackage.POOL__BOUNDARY_VISIBLE:
				return boundaryVisible != BOUNDARY_VISIBLE_EDEFAULT;
			case VsdtPackage.POOL__PROCESS_TYPE:
				return processType != PROCESS_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AbstractProcess.class) {
			switch (derivedFeatureID) {
				case VsdtPackage.POOL__AD_HOC: return VsdtPackage.ABSTRACT_PROCESS__AD_HOC;
				case VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION: return VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION;
				case VsdtPackage.POOL__PROPERTIES: return VsdtPackage.ABSTRACT_PROCESS__PROPERTIES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AbstractProcess.class) {
			switch (baseFeatureID) {
				case VsdtPackage.ABSTRACT_PROCESS__AD_HOC: return VsdtPackage.POOL__AD_HOC;
				case VsdtPackage.ABSTRACT_PROCESS__AD_HOC_COMPLETION_CONDITION: return VsdtPackage.POOL__AD_HOC_COMPLETION_CONDITION;
				case VsdtPackage.ABSTRACT_PROCESS__PROPERTIES: return VsdtPackage.POOL__PROPERTIES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (adHoc: ");
		result.append(adHoc);
		result.append(", boundaryVisible: ");
		result.append(boundaryVisible);
		result.append(", processType: ");
		result.append(processType);
		result.append(')');
		return result.toString();
	}

} //PoolImpl
