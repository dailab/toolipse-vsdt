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
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.dailab.vsdt.Association;
import de.dailab.vsdt.GraphicalObject;
import de.dailab.vsdt.IdObject;
import de.dailab.vsdt.Lane;
import de.dailab.vsdt.Pool;
import de.dailab.vsdt.VsdtPackage;
import de.dailab.vsdt.util.VsdtHelper;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lane</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#getOutgoingAss <em>Outgoing Ass</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#getIncomingAss <em>Incoming Ass</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#getParentPool <em>Parent Pool</em>}</li>
 *   <li>{@link de.dailab.vsdt.impl.LaneImpl#isBoundaryVisible <em>Boundary Visible</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LaneImpl extends FlowObjectContainerImpl implements Lane {
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
	 * @generated NOT
	 */
	protected LaneImpl() {
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
		return VsdtPackage.Literals.LANE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.LANE__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.LANE__DOCUMENTATION, oldDocumentation, documentation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getCategories() {
		if (categories == null) {
			categories = new EDataTypeUniqueEList<String>(String.class, this, VsdtPackage.LANE__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getOutgoingAss() {
		if (outgoingAss == null) {
			outgoingAss = new EObjectWithInverseEList<Association>(Association.class, this, VsdtPackage.LANE__OUTGOING_ASS, VsdtPackage.ASSOCIATION__SOURCE);
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
			incomingAss = new EObjectWithInverseEList<Association>(Association.class, this, VsdtPackage.LANE__INCOMING_ASS, VsdtPackage.ASSOCIATION__TARGET);
		}
		return incomingAss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * default: name of the class, e.g. "Pool", "Lane"
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
//		if (name==null) {
//			return this.eClass().getName();
//		}
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
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.LANE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pool getParentPool() {
		if (eContainerFeatureID() != VsdtPackage.LANE__PARENT_POOL) return null;
		return (Pool)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentPool(Pool newParentPool, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentPool, VsdtPackage.LANE__PARENT_POOL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentPool(Pool newParentPool) {
		if (newParentPool != eInternalContainer() || (eContainerFeatureID() != VsdtPackage.LANE__PARENT_POOL && newParentPool != null)) {
			if (EcoreUtil.isAncestor(this, newParentPool))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentPool != null)
				msgs = ((InternalEObject)newParentPool).eInverseAdd(this, VsdtPackage.POOL__LANES, Pool.class, msgs);
			msgs = basicSetParentPool(newParentPool, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.LANE__PARENT_POOL, newParentPool, newParentPool));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VsdtPackage.LANE__BOUNDARY_VISIBLE, oldBoundaryVisible, boundaryVisible));
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
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VsdtPackage.LANE__OUTGOING_ASS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoingAss()).basicAdd(otherEnd, msgs);
			case VsdtPackage.LANE__INCOMING_ASS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingAss()).basicAdd(otherEnd, msgs);
			case VsdtPackage.LANE__PARENT_POOL:
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
			case VsdtPackage.LANE__OUTGOING_ASS:
				return ((InternalEList<?>)getOutgoingAss()).basicRemove(otherEnd, msgs);
			case VsdtPackage.LANE__INCOMING_ASS:
				return ((InternalEList<?>)getIncomingAss()).basicRemove(otherEnd, msgs);
			case VsdtPackage.LANE__PARENT_POOL:
				return basicSetParentPool(null, msgs);
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
			case VsdtPackage.LANE__PARENT_POOL:
				return eInternalContainer().eInverseRemove(this, VsdtPackage.POOL__LANES, Pool.class, msgs);
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
			case VsdtPackage.LANE__NAME:
				return getName();
			case VsdtPackage.LANE__DOCUMENTATION:
				return getDocumentation();
			case VsdtPackage.LANE__ID:
				return getId();
			case VsdtPackage.LANE__CATEGORIES:
				return getCategories();
			case VsdtPackage.LANE__OUTGOING_ASS:
				return getOutgoingAss();
			case VsdtPackage.LANE__INCOMING_ASS:
				return getIncomingAss();
			case VsdtPackage.LANE__PARENT_POOL:
				return getParentPool();
			case VsdtPackage.LANE__BOUNDARY_VISIBLE:
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
			case VsdtPackage.LANE__NAME:
				setName((String)newValue);
				return;
			case VsdtPackage.LANE__DOCUMENTATION:
				setDocumentation((String)newValue);
				return;
			case VsdtPackage.LANE__ID:
				setId((String)newValue);
				return;
			case VsdtPackage.LANE__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends String>)newValue);
				return;
			case VsdtPackage.LANE__OUTGOING_ASS:
				getOutgoingAss().clear();
				getOutgoingAss().addAll((Collection<? extends Association>)newValue);
				return;
			case VsdtPackage.LANE__INCOMING_ASS:
				getIncomingAss().clear();
				getIncomingAss().addAll((Collection<? extends Association>)newValue);
				return;
			case VsdtPackage.LANE__PARENT_POOL:
				setParentPool((Pool)newValue);
				return;
			case VsdtPackage.LANE__BOUNDARY_VISIBLE:
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
			case VsdtPackage.LANE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case VsdtPackage.LANE__DOCUMENTATION:
				setDocumentation(DOCUMENTATION_EDEFAULT);
				return;
			case VsdtPackage.LANE__ID:
				setId(ID_EDEFAULT);
				return;
			case VsdtPackage.LANE__CATEGORIES:
				getCategories().clear();
				return;
			case VsdtPackage.LANE__OUTGOING_ASS:
				getOutgoingAss().clear();
				return;
			case VsdtPackage.LANE__INCOMING_ASS:
				getIncomingAss().clear();
				return;
			case VsdtPackage.LANE__PARENT_POOL:
				setParentPool((Pool)null);
				return;
			case VsdtPackage.LANE__BOUNDARY_VISIBLE:
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
			case VsdtPackage.LANE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case VsdtPackage.LANE__DOCUMENTATION:
				return DOCUMENTATION_EDEFAULT == null ? documentation != null : !DOCUMENTATION_EDEFAULT.equals(documentation);
			case VsdtPackage.LANE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case VsdtPackage.LANE__CATEGORIES:
				return categories != null && !categories.isEmpty();
			case VsdtPackage.LANE__OUTGOING_ASS:
				return outgoingAss != null && !outgoingAss.isEmpty();
			case VsdtPackage.LANE__INCOMING_ASS:
				return incomingAss != null && !incomingAss.isEmpty();
			case VsdtPackage.LANE__PARENT_POOL:
				return getParentPool() != null;
			case VsdtPackage.LANE__BOUNDARY_VISIBLE:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IdObject.class) {
			switch (derivedFeatureID) {
				case VsdtPackage.LANE__NAME: return VsdtPackage.ID_OBJECT__NAME;
				case VsdtPackage.LANE__DOCUMENTATION: return VsdtPackage.ID_OBJECT__DOCUMENTATION;
				case VsdtPackage.LANE__ID: return VsdtPackage.ID_OBJECT__ID;
				case VsdtPackage.LANE__CATEGORIES: return VsdtPackage.ID_OBJECT__CATEGORIES;
				default: return -1;
			}
		}
		if (baseClass == GraphicalObject.class) {
			switch (derivedFeatureID) {
				case VsdtPackage.LANE__OUTGOING_ASS: return VsdtPackage.GRAPHICAL_OBJECT__OUTGOING_ASS;
				case VsdtPackage.LANE__INCOMING_ASS: return VsdtPackage.GRAPHICAL_OBJECT__INCOMING_ASS;
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
				case VsdtPackage.ID_OBJECT__NAME: return VsdtPackage.LANE__NAME;
				case VsdtPackage.ID_OBJECT__DOCUMENTATION: return VsdtPackage.LANE__DOCUMENTATION;
				case VsdtPackage.ID_OBJECT__ID: return VsdtPackage.LANE__ID;
				case VsdtPackage.ID_OBJECT__CATEGORIES: return VsdtPackage.LANE__CATEGORIES;
				default: return -1;
			}
		}
		if (baseClass == GraphicalObject.class) {
			switch (baseFeatureID) {
				case VsdtPackage.GRAPHICAL_OBJECT__OUTGOING_ASS: return VsdtPackage.LANE__OUTGOING_ASS;
				case VsdtPackage.GRAPHICAL_OBJECT__INCOMING_ASS: return VsdtPackage.LANE__INCOMING_ASS;
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
		result.append(", boundaryVisible: ");
		result.append(boundaryVisible);
		result.append(')');
		return result.toString();
	}

} //LaneImpl
