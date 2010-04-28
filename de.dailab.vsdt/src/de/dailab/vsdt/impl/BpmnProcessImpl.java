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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.Assignment;
import de.dailab.vsdt.BpmnProcess;
import de.dailab.vsdt.FlowObject;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.ProcessType;
import de.dailab.vsdt.Property;
import de.dailab.vsdt.StatusType;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.util.VsdtHelper;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bpmn Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#getParentPool <em>Parent Pool</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#getProcessType <em>Process Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#getAssignments <em>Assignments</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#isSuppressJoinFailure <em>Suppress Join Failure</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.BpmnProcessImpl#isEnableInstanceCompensation <em>Enable Instance Compensation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BpmnProcessImpl extends AbstractProcessImpl implements BpmnProcess {
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
	 * The default value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected static final String DOCUMENTATION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getDocumentation() <em>Documentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDocumentation()
	 * @generated
	 * @ordered
	 */
	protected String documentation = DOCUMENTATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<String> categories;

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
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final StatusType STATUS_EDEFAULT = StatusType.NONE;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected StatusType status = STATUS_EDEFAULT;

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
	 * The default value of the '{@link #isSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressJoinFailure()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SUPPRESS_JOIN_FAILURE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSuppressJoinFailure() <em>Suppress Join Failure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSuppressJoinFailure()
	 * @generated
	 * @ordered
	 */
	protected boolean suppressJoinFailure = SUPPRESS_JOIN_FAILURE_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnableInstanceCompensation() <em>Enable Instance Compensation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableInstanceCompensation()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLE_INSTANCE_COMPENSATION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnableInstanceCompensation() <em>Enable Instance Compensation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnableInstanceCompensation()
	 * @generated
	 * @ordered
	 */
	protected boolean enableInstanceCompensation = ENABLE_INSTANCE_COMPENSATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * initialize ID
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected BpmnProcessImpl() {
		super();
		VsdtHelper.generateNewID(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.BPMN_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BPMN_PROCESS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDocumentation() {
		return documentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDocumentation(String newDocumentation) {
		String oldDocumentation = documentation;
		documentation = newDocumentation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BPMN_PROCESS__DOCUMENTATION, oldDocumentation, documentation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCategories() {
		if (categories == null) {
			categories = new EDataTypeUniqueEList<String>(String.class, this, VsdtPackage.BPMN_PROCESS__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pool getParentPool() {
		if (eContainerFeatureID() != VsdtPackage.BPMN_PROCESS__PARENT_POOL) return null;
		return (Pool)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentPool(Pool newParentPool, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentPool, VsdtPackage.BPMN_PROCESS__PARENT_POOL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentPool(Pool newParentPool) {
		if (newParentPool != eInternalContainer() || (eContainerFeatureID() != VsdtPackage.BPMN_PROCESS__PARENT_POOL && newParentPool != null)) {
			if (EcoreUtil.isAncestor(this, newParentPool))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentPool != null)
				msgs = ((InternalEObject)newParentPool).eInverseAdd(this, VsdtPackage.POOL__PROCESS, Pool.class, msgs);
			msgs = basicSetParentPool(newParentPool, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BPMN_PROCESS__PARENT_POOL, newParentPool, newParentPool));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BPMN_PROCESS__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BPMN_PROCESS__PROCESS_TYPE, oldProcessType, processType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusType getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(StatusType newStatus) {
		StatusType oldStatus = status;
		status = newStatus == null ? STATUS_EDEFAULT : newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BPMN_PROCESS__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Assignment> getAssignments() {
		if (assignments == null) {
			assignments = new EObjectContainmentEList<Assignment>(Assignment.class, this, VsdtPackage.BPMN_PROCESS__ASSIGNMENTS);
		}
		return assignments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSuppressJoinFailure() {
		return suppressJoinFailure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuppressJoinFailure(boolean newSuppressJoinFailure) {
		boolean oldSuppressJoinFailure = suppressJoinFailure;
		suppressJoinFailure = newSuppressJoinFailure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BPMN_PROCESS__SUPPRESS_JOIN_FAILURE, oldSuppressJoinFailure, suppressJoinFailure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEnableInstanceCompensation() {
		return enableInstanceCompensation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnableInstanceCompensation(boolean newEnableInstanceCompensation) {
		boolean oldEnableInstanceCompensation = enableInstanceCompensation;
		enableInstanceCompensation = newEnableInstanceCompensation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.BPMN_PROCESS__ENABLE_INSTANCE_COMPENSATION, oldEnableInstanceCompensation, enableInstanceCompensation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns a list of Properties with this element in it's scope.
	 * For the Process element, these are only the Properties of the Process itself.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Property> getVisibleProperties() {
		return getProperties();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getNameOrId() {
		String name= getName();
		String id= getId();
		if (name != null && name.length() > 0) {
			return name;
		} else {
			return id;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.BPMN_PROCESS__PARENT_POOL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentPool((Pool)otherEnd, msgs);
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
			case VsdtPackage.BPMN_PROCESS__PARENT_POOL:
				return basicSetParentPool(null, msgs);
			case VsdtPackage.BPMN_PROCESS__ASSIGNMENTS:
				return ((InternalEList<?>)getAssignments()).basicRemove(otherEnd, msgs);
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
			case VsdtPackage.BPMN_PROCESS__PARENT_POOL:
				return eInternalContainer().eInverseRemove(this, VsdtPackage.POOL__PROCESS, Pool.class, msgs);
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
			case VsdtPackage.BPMN_PROCESS__NAME:
				return getName();
			case VsdtPackage.BPMN_PROCESS__DOCUMENTATION:
				return getDocumentation();
			case VsdtPackage.BPMN_PROCESS__ID:
				return getId();
			case VsdtPackage.BPMN_PROCESS__CATEGORIES:
				return getCategories();
			case VsdtPackage.BPMN_PROCESS__PARENT_POOL:
				return getParentPool();
			case VsdtPackage.BPMN_PROCESS__PROCESS_TYPE:
				return getProcessType();
			case VsdtPackage.BPMN_PROCESS__STATUS:
				return getStatus();
			case VsdtPackage.BPMN_PROCESS__ASSIGNMENTS:
				return getAssignments();
			case VsdtPackage.BPMN_PROCESS__SUPPRESS_JOIN_FAILURE:
				return isSuppressJoinFailure();
			case VsdtPackage.BPMN_PROCESS__ENABLE_INSTANCE_COMPENSATION:
				return isEnableInstanceCompensation();
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
			case VsdtPackage.BPMN_PROCESS__NAME:
				setName((String)newValue);
				return;
			case VsdtPackage.BPMN_PROCESS__DOCUMENTATION:
				setDocumentation((String)newValue);
				return;
			case VsdtPackage.BPMN_PROCESS__ID:
				setId((String)newValue);
				return;
			case VsdtPackage.BPMN_PROCESS__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends String>)newValue);
				return;
			case VsdtPackage.BPMN_PROCESS__PARENT_POOL:
				setParentPool((Pool)newValue);
				return;
			case VsdtPackage.BPMN_PROCESS__PROCESS_TYPE:
				setProcessType((ProcessType)newValue);
				return;
			case VsdtPackage.BPMN_PROCESS__STATUS:
				setStatus((StatusType)newValue);
				return;
			case VsdtPackage.BPMN_PROCESS__ASSIGNMENTS:
				getAssignments().clear();
				getAssignments().addAll((Collection<? extends Assignment>)newValue);
				return;
			case VsdtPackage.BPMN_PROCESS__SUPPRESS_JOIN_FAILURE:
				setSuppressJoinFailure((Boolean)newValue);
				return;
			case VsdtPackage.BPMN_PROCESS__ENABLE_INSTANCE_COMPENSATION:
				setEnableInstanceCompensation((Boolean)newValue);
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
			case VsdtPackage.BPMN_PROCESS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VsdtPackage.BPMN_PROCESS__DOCUMENTATION:
				setDocumentation(DOCUMENTATION_EDEFAULT);
				return;
			case VsdtPackage.BPMN_PROCESS__ID:
				setId(ID_EDEFAULT);
				return;
			case VsdtPackage.BPMN_PROCESS__CATEGORIES:
				getCategories().clear();
				return;
			case VsdtPackage.BPMN_PROCESS__PARENT_POOL:
				setParentPool((Pool)null);
				return;
			case VsdtPackage.BPMN_PROCESS__PROCESS_TYPE:
				setProcessType(PROCESS_TYPE_EDEFAULT);
				return;
			case VsdtPackage.BPMN_PROCESS__STATUS:
				setStatus(STATUS_EDEFAULT);
				return;
			case VsdtPackage.BPMN_PROCESS__ASSIGNMENTS:
				getAssignments().clear();
				return;
			case VsdtPackage.BPMN_PROCESS__SUPPRESS_JOIN_FAILURE:
				setSuppressJoinFailure(SUPPRESS_JOIN_FAILURE_EDEFAULT);
				return;
			case VsdtPackage.BPMN_PROCESS__ENABLE_INSTANCE_COMPENSATION:
				setEnableInstanceCompensation(ENABLE_INSTANCE_COMPENSATION_EDEFAULT);
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
			case VsdtPackage.BPMN_PROCESS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VsdtPackage.BPMN_PROCESS__DOCUMENTATION:
				return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
			case VsdtPackage.BPMN_PROCESS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case VsdtPackage.BPMN_PROCESS__CATEGORIES:
				return categories != null && !categories.isEmpty();
			case VsdtPackage.BPMN_PROCESS__PARENT_POOL:
				return getParentPool() != null;
			case VsdtPackage.BPMN_PROCESS__PROCESS_TYPE:
				return processType != PROCESS_TYPE_EDEFAULT;
			case VsdtPackage.BPMN_PROCESS__STATUS:
				return status != STATUS_EDEFAULT;
			case VsdtPackage.BPMN_PROCESS__ASSIGNMENTS:
				return assignments != null && !assignments.isEmpty();
			case VsdtPackage.BPMN_PROCESS__SUPPRESS_JOIN_FAILURE:
				return suppressJoinFailure != SUPPRESS_JOIN_FAILURE_EDEFAULT;
			case VsdtPackage.BPMN_PROCESS__ENABLE_INSTANCE_COMPENSATION:
				return enableInstanceCompensation != ENABLE_INSTANCE_COMPENSATION_EDEFAULT;
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
		if (baseClass == IdObject.class) {
			switch (derivedFeatureID) {
				case VsdtPackage.BPMN_PROCESS__NAME: return VsdtPackage.ID_OBJECT__NAME;
				case VsdtPackage.BPMN_PROCESS__DOCUMENTATION: return VsdtPackage.ID_OBJECT__DOCUMENTATION;
				case VsdtPackage.BPMN_PROCESS__ID: return VsdtPackage.ID_OBJECT__ID;
				case VsdtPackage.BPMN_PROCESS__CATEGORIES: return VsdtPackage.ID_OBJECT__CATEGORIES;
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
		if (baseClass == IdObject.class) {
			switch (baseFeatureID) {
				case VsdtPackage.ID_OBJECT__NAME: return VsdtPackage.BPMN_PROCESS__NAME;
				case VsdtPackage.ID_OBJECT__DOCUMENTATION: return VsdtPackage.BPMN_PROCESS__DOCUMENTATION;
				case VsdtPackage.ID_OBJECT__ID: return VsdtPackage.BPMN_PROCESS__ID;
				case VsdtPackage.ID_OBJECT__CATEGORIES: return VsdtPackage.BPMN_PROCESS__CATEGORIES;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", documentation: ");
		result.append(documentation);
		result.append(", id: ");
		result.append(id);
		result.append(", categories: ");
		result.append(categories);
		result.append(", processType: ");
		result.append(processType);
		result.append(", status: ");
		result.append(status);
		result.append(", suppressJoinFailure: ");
		result.append(suppressJoinFailure);
		result.append(", enableInstanceCompensation: ");
		result.append(enableInstanceCompensation);
		result.append(')');
		return result.toString();
	}
	
	/**
	 * for a process, the graphical elements are the contained flow objects
	 * of all the processes pool's lanes 
	 * @generated NOT
	 */
	@Override
	public EList<FlowObject> getGraphicalElements() {
		EList<FlowObject> list= new BasicEList<FlowObject>();
		for (Iterator<Lane> iter = getParentPool().getLanes().iterator(); iter.hasNext();) {
			Lane lane = iter.next();
			list.addAll(lane.getContainedFlowObjects());
		}
		return list;
	}
	
} //BpmnProcessImpl
