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
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.BusinessProcessDiagram;
import de.dailab.vsdt.Participant;
import de.dailab.vsdt.ParticipantType;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Participant</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.ParticipantImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ParticipantImpl#getAssociatedProcesses <em>Associated Processes</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.ParticipantImpl#getAssociatedPools <em>Associated Pools</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ParticipantImpl extends IdObjectImpl implements Participant {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final ParticipantType TYPE_EDEFAULT = ParticipantType.ROLE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected ParticipantType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAssociatedProcesses() <em>Associated Processes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedProcesses()
	 * @generated
	 * @ordered
	 */
	protected EList<BusinessProcessDiagram> associatedProcesses;

	/**
	 * The cached value of the '{@link #getAssociatedPools() <em>Associated Pools</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedPools()
	 * @generated
	 * @ordered
	 */
	protected EList<Pool> associatedPools;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParticipantImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.PARTICIPANT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BusinessProcessDiagram> getAssociatedProcesses() {
		if (associatedProcesses == null) {
			associatedProcesses = new EObjectWithInverseResolvingEList.ManyInverse<BusinessProcessDiagram>(BusinessProcessDiagram.class, this, VsdtPackage.PARTICIPANT__ASSOCIATED_PROCESSES, VsdtPackage.BUSINESS_PROCESS_DIAGRAM__PARTICIPANTS);
		}
		return associatedProcesses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pool> getAssociatedPools() {
		if (associatedPools == null) {
			associatedPools = new EObjectWithInverseResolvingEList<Pool>(Pool.class, this, VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS, VsdtPackage.POOL__PARTICIPANT);
		}
		return associatedPools;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParticipantType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(ParticipantType newType) {
		ParticipantType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.PARTICIPANT__TYPE, oldType, type));
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
			case VsdtPackage.PARTICIPANT__ASSOCIATED_PROCESSES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociatedProcesses()).basicAdd(otherEnd, msgs);
			case VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociatedPools()).basicAdd(otherEnd, msgs);
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
			case VsdtPackage.PARTICIPANT__ASSOCIATED_PROCESSES:
				return ((InternalEList<?>)getAssociatedProcesses()).basicRemove(otherEnd, msgs);
			case VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS:
				return ((InternalEList<?>)getAssociatedPools()).basicRemove(otherEnd, msgs);
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
			case VsdtPackage.PARTICIPANT__TYPE:
				return getType();
			case VsdtPackage.PARTICIPANT__ASSOCIATED_PROCESSES:
				return getAssociatedProcesses();
			case VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS:
				return getAssociatedPools();
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
			case VsdtPackage.PARTICIPANT__TYPE:
				setType((ParticipantType)newValue);
				return;
			case VsdtPackage.PARTICIPANT__ASSOCIATED_PROCESSES:
				getAssociatedProcesses().clear();
				getAssociatedProcesses().addAll((Collection<? extends BusinessProcessDiagram>)newValue);
				return;
			case VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS:
				getAssociatedPools().clear();
				getAssociatedPools().addAll((Collection<? extends Pool>)newValue);
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
			case VsdtPackage.PARTICIPANT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case VsdtPackage.PARTICIPANT__ASSOCIATED_PROCESSES:
				getAssociatedProcesses().clear();
				return;
			case VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS:
				getAssociatedPools().clear();
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
			case VsdtPackage.PARTICIPANT__TYPE:
				return type != TYPE_EDEFAULT;
			case VsdtPackage.PARTICIPANT__ASSOCIATED_PROCESSES:
				return associatedProcesses != null && !associatedProcesses.isEmpty();
			case VsdtPackage.PARTICIPANT__ASSOCIATED_POOLS:
				return associatedPools != null && !associatedPools.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //ParticipantImpl
