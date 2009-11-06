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

import de.dailab.vsdt.Association;
import de.dailab.vsdt.GraphicalObject;
import de.dailab.vsdt.VsdtPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphical Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.GraphicalObjectImpl#getOutgoingAss <em>Outgoing Ass</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.GraphicalObjectImpl#getIncomingAss <em>Incoming Ass</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class GraphicalObjectImpl extends IdObjectImpl implements GraphicalObject {
	/**
	 * The cached value of the '{@link #getOutgoingAss() <em>Outgoing Ass</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoingAss()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> outgoingAss;

	/**
	 * The cached value of the '{@link #getIncomingAss() <em>Incoming Ass</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingAss()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> incomingAss;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicalObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VsdtPackage.Literals.GRAPHICAL_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getOutgoingAss() {
		if (outgoingAss == null) {
			outgoingAss = new EObjectWithInverseEList<Association>(Association.class, this, VsdtPackage.GRAPHICAL_OBJECT__OUTGOING_ASS, VsdtPackage.ASSOCIATION__SOURCE);
		}
		return outgoingAss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getIncomingAss() {
		if (incomingAss == null) {
			incomingAss = new EObjectWithInverseEList<Association>(Association.class, this, VsdtPackage.GRAPHICAL_OBJECT__INCOMING_ASS, VsdtPackage.ASSOCIATION__TARGET);
		}
		return incomingAss;
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
			case VsdtPackage.GRAPHICAL_OBJECT__OUTGOING_ASS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingAss()).basicAdd(otherEnd, msgs);
			case VsdtPackage.GRAPHICAL_OBJECT__INCOMING_ASS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingAss()).basicAdd(otherEnd, msgs);
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
			case VsdtPackage.GRAPHICAL_OBJECT__OUTGOING_ASS:
				return ((InternalEList<?>)getOutgoingAss()).basicRemove(otherEnd, msgs);
			case VsdtPackage.GRAPHICAL_OBJECT__INCOMING_ASS:
				return ((InternalEList<?>)getIncomingAss()).basicRemove(otherEnd, msgs);
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
			case VsdtPackage.GRAPHICAL_OBJECT__OUTGOING_ASS:
				return getOutgoingAss();
			case VsdtPackage.GRAPHICAL_OBJECT__INCOMING_ASS:
				return getIncomingAss();
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
			case VsdtPackage.GRAPHICAL_OBJECT__OUTGOING_ASS:
				getOutgoingAss().clear();
				getOutgoingAss().addAll((Collection<? extends Association>)newValue);
				return;
			case VsdtPackage.GRAPHICAL_OBJECT__INCOMING_ASS:
				getIncomingAss().clear();
				getIncomingAss().addAll((Collection<? extends Association>)newValue);
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
			case VsdtPackage.GRAPHICAL_OBJECT__OUTGOING_ASS:
				getOutgoingAss().clear();
				return;
			case VsdtPackage.GRAPHICAL_OBJECT__INCOMING_ASS:
				getIncomingAss().clear();
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
			case VsdtPackage.GRAPHICAL_OBJECT__OUTGOING_ASS:
				return outgoingAss != null && !outgoingAss.isEmpty();
			case VsdtPackage.GRAPHICAL_OBJECT__INCOMING_ASS:
				return incomingAss != null && !incomingAss.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GraphicalObjectImpl
